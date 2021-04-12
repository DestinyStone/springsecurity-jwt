package com.test.auth.jwt.entity.security;

import cn.hutool.core.bean.BeanUtil;
import com.test.auth.jwt.bean.UmsMember;
import com.test.auth.jwt.entity.dto.UmsMemberDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: zhouxiaofeng
 * @create: 2021-04-12 14:46
 * @description:
 **/
public class BasicUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UmsMember umsMember = UmsMember.get();
        UmsMemberDTO umsMemberDTO = new UmsMemberDTO();
        BeanUtil.copyProperties(umsMember, umsMemberDTO);
        List<GrantedAuthority> permission = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_role");
        Set<GrantedAuthority> collect = permission.stream().collect(Collectors.toSet());
        return new BasicUserDetails(umsMemberDTO, umsMember.getPassword(), collect);
    }
}
    