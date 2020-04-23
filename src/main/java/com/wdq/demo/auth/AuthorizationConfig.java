/**
 * 
 */
package com.wdq.demo.auth;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b> 
 * 
 * <b>Author:</b> wangdingqiang
 * <b>Date:</b> 2020年4月21日 上午9:47:06
 * <b>Copyright:</b> Copyright &copy;2020-2030 wdq Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author              Detail
 *   ----------------------------------------------------------------------
 *   1.0   2020年4月21日 上午9:47:06   wangdingqiang
 *         new file.
 * </pre>
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private TokenStore tokenStore;
	
	/**
     * 注入authenticationManager
     * 来支持 password grant type
     */
    @Autowired
    private AuthenticationManager authenticationManager;
    
	/**
     * 配置编码器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()   // 基于内存
        		.withClient("app")  //授权客户端
        		.secret(passwordEncoder().encode("111111"))  //授权码
        		.accessTokenValiditySeconds((int) TimeUnit.SECONDS.toSeconds(30))  // 授权过期时间
        		.authorizedGrantTypes("password", "refresh_token", "client_credentials")  // 授权模式
        		.scopes("all")  // 授权范围
        		.resourceIds("rid");  // 授权资源
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer
				.tokenKeyAccess("permitAll()")
				.checkTokenAccess("permitAll()")
				.allowFormAuthenticationForClients();
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore)
        .authenticationManager(authenticationManager);
	}
	
	@Bean
	public TokenStore tokenStore() {
		//这里为了简单达到目的，直接使用内存存储Token和用户信息。
		return new InMemoryTokenStore();
	}
}
