package com.campmap.filter;

import com.campmap.service.JwtTokenUtils;
import jakarta.servlet.Filter;
import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class TokenFilter implements Filter {

  @Autowired
  private JwtTokenUtils jwtTokenUtils;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    Filter.super.init(filterConfig);
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse res = (HttpServletResponse) servletResponse;

    // consider to validate token here.

    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {
    Filter.super.destroy();
  }
}
