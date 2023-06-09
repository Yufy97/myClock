package cn.nineSeven.service.impl;

import cn.nineSeven.constant.AppHttpCodeEnum;
import cn.nineSeven.entity.Result;
import cn.nineSeven.utils.WebUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override

    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        accessDeniedException.printStackTrace();
        Result result = Result.errorResult(AppHttpCodeEnum.NO_OPERATOR_AUTH);

        WebUtils.renderString(response, JSON.toJSONString(result));
    }
}
