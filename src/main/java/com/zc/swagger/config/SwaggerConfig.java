package com.zc.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
//  开启Swagger2
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("docket1");
    }

    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("docket2");
    }

    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("docket3");
    }

    @Bean
    public Docket docket4() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("docket4");
    }

    //  配置了Swagger的Docket的bean实例
    //  enable是否启动swagger，如果为false，则swagger不能在浏览器中访问。默认为true
    @Bean
    public Docket docket(Environment environment) {

        //  设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev","test");

        //  获取项目的环境
        //  通过environment.acceptsProfiles判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("赵灿")
                .enable(flag)
                .select()
                //RequestHandlerSelectors：配置要扫描接口的方式
                //basePackage：指定要扫描的包
                //any()：扫描全部
                //none()：不扫描
                //withClassAnnotation()：扫描类上的注解，参数是一个注解的反射对象
                //withMethodAnnotation()：扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.zc.swagger.controller"))
                //.paths()：过滤路径
                .build();
    }

    //  配置Swagger信息 ==> apiInfo
    private ApiInfo apiInfo() {
        Contact contact = new Contact("赵灿", "http://fym233.cn/zcblog", "zc1872751113@gmail.com");
        return new ApiInfo(
                "赵灿的SwaggerAPI文档",
                "没有描述",
                "z1.0",
                "http://fym233.cn/zcblog",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }

}
