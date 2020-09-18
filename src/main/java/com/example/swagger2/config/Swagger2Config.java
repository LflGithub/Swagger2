package com.example.swagger2.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 接口文档配置
 *
 * @author LIFULIN
 * @className Swagger2Config
 * @description TODO
 * @date 2020/9/8-17:44
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
@Slf4j
public class Swagger2Config implements WebMvcConfigurer {

    /**
     * 根据配置读取是否开启swagger文档，针对测试与生产环境采用不同的配置
     */
    @Value("${swagger.enable}")
    private boolean isSwaggerEnable;

    @Value("${server.port}")
    private Integer port;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    /**
     * 不可删除，用以解决资源映射导致无法访问页面的问题
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations(
                "classpath:/META-INF/resources/");
        registry.addResourceHandler("doc.html").addResourceLocations(
                "classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");

    }

    //———————————————————————————————————第一组————————————————————————————————————————————
    @Bean
    public Docket portApi() {
        log.info("接口文档原生界面：http://localhost:" + port + contextPath + "/swagger-ui.html");
        log.info("接口文档增强界面（推荐）：http://localhost:" + port + contextPath + "/doc.html");
        return new Docket(DocumentationType.SWAGGER_2)
                //分组名称
                .groupName("文档分组第一组")
                //是否开启
                .enable(isSwaggerEnable)
                .apiInfo(portApiInfo()).select()
                //扫描指定包中的swagger注解
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger2"))
                //扫描所有有注解的api，用这种方式更灵活
                // .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiInfo portApiInfo() {
        return new ApiInfoBuilder()
                //api 文档标题
                .title("api 文档标题")
                //api 文档描述
                .description("api 文档描述")
                //api 服务Url
                .termsOfServiceUrl("api 服务Url：http://baidu.com")
                //api 文档版本
                .version("1.0.0")
                //负责此API的人员的联系信息
                .contact(new Contact("李福霖", "", "lfl@szchnigs.com"))
                //api 的许可信息
                .license("api 的许可信息")
                //api 的许可Url
                .licenseUrl("api 的许可Url http://baidu.com")
                .build();
    }


    //———————————————————————————————————第二组————————————————————————————————————————————

/*
    @Bean
    public Docket portApi2() {
        log.info("接口文档原生界面：http://localhost:"+port + contextPath + "/swagger-ui.html");
        log.info("接口文档增强界面（推荐）：http://localhost:"+port + contextPath + "/doc.html");
        return new Docket(DocumentationType.SWAGGER_2)
                //分组名称
                .groupName("文档分组第二组")
                .enable(isSwaggerEnable)
                .apiInfo(portApiInfo2()).select()
                //扫描指定包中的swagger注解
                // .apis(RequestHandlerSelectors.basePackage("com.example.swagger2"))
                //扫描所有有注解的api，用这种方式更灵活
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiInfo portApiInfo2() {
        return new ApiInfoBuilder()
                //文档标题
                .title("第二组接口文档")
                //简介
                .description("接口文档")
                //服务Url
                .termsOfServiceUrl("http://baidu.com")
                //版本
                .version("1.0.0")
                //作者
                .contact(new Contact("李福霖","","lfl@szchnigs.com"))
                .license("")
                .licenseUrl("")
                .build();
    }
*/

}
