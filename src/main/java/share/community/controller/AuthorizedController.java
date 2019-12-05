package share.community.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import share.community.dto.AccessTokenDTO;
import share.community.dto.GitHubUser;
import share.community.provider.GitHubProvider;

@Controller
public class AuthorizedController {

    @Autowired
    private GitHubProvider gitHubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.url}")
    private String redirectUrl;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUrl);
        accessTokenDTO.setState(state);
        String accessToken = gitHubProvider.getAccessoken(accessTokenDTO);
        GitHubUser user = gitHubProvider.getUser(accessToken);
        if(user != null){
            //登录成功:写cookie和session
            request.getSession().setAttribute("user", user);
            return "redirect:/";
        }
        else{
            //登录失败：重新登陆
            return "redirect:/";
        }
    }
}