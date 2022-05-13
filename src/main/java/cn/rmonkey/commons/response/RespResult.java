package cn.rmonkey.commons.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Zhaozihao (Zack)
 * @Description
 * @date 2022/5/13 14:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespResult <T>{
    private Integer code;
    private String message;
    private T data;
    @Data
    public static class Success<T> {
        public static <T>  RespResult<T> success(String message) {
            return new RespResult<>(ResponseCode.RESPONSE_SUCCESS,message,null);
        }
        public static <T> RespResult<T> success(String message, T data) {
            return new RespResult<>(ResponseCode.RESPONSE_SUCCESS,message,data);
        }
        public static <T> RespResult<T> success(Integer code, String message, T data) {
            return new RespResult<>(code,message,data);
        }
    }
    @Data
    public static class Failure<T> {
        public static <T> RespResult<T> failure(String message) {
            return new RespResult<>(ResponseCode.RESPONSE_FAILURE,message,null);
        }
        public static <T> RespResult<T> failure(String message,T data) {
            return new RespResult<>(ResponseCode.RESPONSE_FAILURE, message, data);
        }
        public static <T> RespResult<T> failure(Integer code,String message , T data) {
            return new RespResult<>(code,message,data);
        }
    }
    static class NoData<T> {
        public static <T> RespResult<T> noData(String message) {
            return new RespResult<>(ResponseCode.RESPONSE_NO_DATA,message,null);
        }
        public static <T> RespResult<T> noData(String message,T data) {
            return new RespResult<>(ResponseCode.RESPONSE_NO_DATA, message, data);
        }
        public static <T> RespResult<T> noData(Integer code,String message , T data) {
            return new RespResult<>(code,message,data);
        }
    }
}
