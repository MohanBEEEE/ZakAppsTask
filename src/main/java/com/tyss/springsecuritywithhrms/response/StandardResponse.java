package com.tyss.springsecuritywithhrms.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardResponse implements Serializable {
	
	private static final long serialVersionUID = -3007796487045223584L;
	
	private String responseCode;
	private String responsestatus;
	private String responseDescription;

	public static StandardResponse notFoundError(String desc) {
		return new StandardResponse("404", "FAILED", desc);
	}
	
	public static StandardResponse badRequest(String desc) {
		return new StandardResponse("400","BAD REQUEST", desc);
	}
	
	public static StandardResponse internalServerError(String desc) {
		return new StandardResponse("500", "INTERNAL SERVER ERROR", desc);
	}
	
	public static StandardResponse failedError(String respCode,String desc) {
		return new StandardResponse(respCode, "FAILED", desc);
	}
	
	public static StandardResponse success(String desc) {
		return new StandardResponse("200", "SUCCESS", desc);
	}
}
