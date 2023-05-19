/*
 * Copyright 2023 Park Jun-Hong_(parkjunhong77@gmail.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 *
 * This file is generated under this project, "open-commons-spring-swagger2".
 *
 * Date  : 2023. 5. 19. 오후 5:06:17
 *
 * Author: Park Jun-Hong (parkjunhong77@gmail.com)
 * 
 */

package open.commons.spring.swagger2.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import open.commons.spring.swagger2.SpringfoxSwagger;

/**
 * 
 * @since 2023. 5. 19.
 * @version 0.1.0
 * @author Park Jun-Hong (parkjunhong77@gmail.com)
 */
public class SpringfoxSwaggerWebSecurityCofigurer extends WebSecurityConfigurerAdapter {

    /**
     * <br>
     * 
     * <pre>
     * [개정이력]
     *      날짜    	| 작성자	|	내용
     * ------------------------------------------
     * 2023. 5. 19.		박준홍			최초 작성
     * </pre>
     *
     *
     * @since 2023. 5. 19.
     * @version 0.1.0
     * @author Park Jun-Hong (parkjunhong77@gmail.com)
     */
    public SpringfoxSwaggerWebSecurityCofigurer() {
    }

    /**
     * <br>
     * 
     * <pre>
     * [개정이력]
     *      날짜    	| 작성자	|	내용
     * ------------------------------------------
     * 2023. 5. 19.		박준홍			최초 작성
     * </pre>
     *
     * @param disableDefaults
     *
     * @since 2023. 5. 19.
     * @version 0.1.0
     * @author Park Jun-Hong (parkjunhong77@gmail.com)
     */
    public SpringfoxSwaggerWebSecurityCofigurer(boolean disableDefaults) {
        super(disableDefaults);
    }

    /**
     *
     * @since 2023. 5. 19.
     * @version 0.1.0
     * @author Park Jun-Hong (parkjunhong77@gmail.com)
     *
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(SpringfoxSwagger.getUrlList()).permitAll();
    }

    /**
     *
     * @since 2023. 5. 19.
     * @version 0.1.0
     * @author Park Jun-Hong (parkjunhong77@gmail.com)
     *
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.WebSecurity)
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(SpringfoxSwagger.getUrlList());
    }

}
