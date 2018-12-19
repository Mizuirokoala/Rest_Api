package pl.coderslab.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab")
public class AppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMapping(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedMethods("GET","POST","PUT","DELETE")
                .allowedOrigins("http://localhost");
    }
    @Override
    public void configureDeafaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }
}
