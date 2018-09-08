package com.example01.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
    使用swagger2的例子
 */

//访问http://localhost:8080/swagger-ui.html  就能看到前文所展示的RESTful API的页面
//通过@Configuration注解，让Spring来加载该类配置。
//再通过@EnableSwagger2注解来启用Swagger2。
@Configuration
@EnableSwagger2
public class Application {

    @Bean
    public Docket createRestApi() {//通过createRestApi函数创建Docket的Bean
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()//select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现
                .apis(RequestHandlerSelectors.basePackage("com.example01.springboot.web"))
                .paths(PathSelectors.any())
                .build();
    }
    //本例采用指定扫描的包路径来定义，Swagger会扫描该包下所有Controller定义的API，
    // 并产生文档内容（除了被@ApiIgnore指定的请求）。


    private ApiInfo apiInfo() {//apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
                .termsOfServiceUrl("http://blog.didispace.com/")
                .contact("程序猿DD")
                .version("1.0")
                .build();
    }

}
