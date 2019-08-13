package com.gate.filter.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author brusion
 * @date 2019/8/2
 * @description: token生成与校验方法
 */
public class JwtUtil {


    public static final String SECRET = "qazwsx123444$#%#()*&& asdaswwi1235 ?;!@#kmmmpom in***xx**&";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_AUTH = "Authorization";

    /**
     * 生成token
     */
    public static String generateToken(String phone, String userId, String companyId, String companyName) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("phone", phone);
        map.put("userId", userId);
        map.put("companyId", companyId);
        map.put("companyName", companyName);
        String jwt = Jwts.builder()
                .setSubject("user info").setClaims(map)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        String finalJwt = TOKEN_PREFIX + " " + jwt;
        return finalJwt;
    }

    /**
     * token 数据查询
     */
    public static Map<String, String> validateToken(String token) {
        if (token != null) {
            HashMap<String, String> map = new HashMap<String, String>();
            Map<String, Object> body = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            String phone = (String) (body.get("phone"));
            String userId = (String) (body.get("userId"));
            String companyId = (String) (body.get("companyId"));
            String companyName = (String) (body.get("companyName"));
            map.put("phone", phone);
            map.put("userId", userId);
            map.put("companyId", companyId);
            map.put("companyName", companyName);
            return map;
        } else {
            return null;
        }
    }

}
