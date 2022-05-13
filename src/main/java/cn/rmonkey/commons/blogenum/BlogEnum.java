package cn.rmonkey.commons.blogenum;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.ToString;

/**
 * @Author Zhaozihao (Zack)
 * @Description
 * @date 2022/5/12 15:39
 */
public class BlogEnum {
    @Getter
    @ToString
    public enum SexEnum {
        FEMALE("women", 0),
        MALE("men", 1),
        UNKNOWN("unknown", 2);
        @JsonValue
        private String value;
        @EnumValue
        private int code;

        SexEnum(String value, int code) {
            this.value = value;
            this.code = code;
        }

    }
    @Getter
    @ToString
    public  enum StatusEnum {
        DESTROY("DESTROY", 0),
        ALIVE("ALIVE", 1);
        @JsonValue
        private String value;
        @EnumValue
        private int code;

        StatusEnum(String value, int code) {
            this.value = value;
            this.code = code;
        }

    }
}
