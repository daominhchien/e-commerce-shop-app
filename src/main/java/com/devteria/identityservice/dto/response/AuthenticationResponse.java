package com.devteria.identityservice.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
// <đã hiểu> => biết bạn là ai thì sẽ trả về token và authenticated = true
public class AuthenticationResponse {
    String token;
    boolean authenticated;
}
