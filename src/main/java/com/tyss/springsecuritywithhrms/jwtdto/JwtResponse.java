package com.tyss.springsecuritywithhrms.jwtdto;

import java.io.Serializable;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse implements Serializable{
	 
	private static final long serialVersionUID = -3158158251760908093L;

	private String jwtToken;
}
