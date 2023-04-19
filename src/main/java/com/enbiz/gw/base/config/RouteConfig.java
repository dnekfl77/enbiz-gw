/**
 * 
 */
package com.enbiz.gw.base.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author choiyh44
 * @version 1.0
 * @since 2021. 11. 2.
 *
 */
@Configuration
public class RouteConfig {
//    @Autowired
//    private GlobalFilter globalFilter;
    
    @Value("${app.apiUrl.sample}")
    private String apiUrlMember;
    
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route(p -> p
                .path("/api/sample/**")
                //.filters(f -> f.filter(globalFilter.apply(new X2GlobalFilter.Config("MsgGlobal", true, true))))
                .uri(apiUrlMember))
            .build();
    }
}
