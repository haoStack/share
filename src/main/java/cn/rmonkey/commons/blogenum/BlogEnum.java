package cn.rmonkey.commons.blogenum;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @Author Zhaozihao (Zack)
 * @Description
 * @date 2022/5/12 15:39
 */
public class BlogEnum {
    public static enum SexEnum {
        MALE("men", 1),
        FEMALE("women", 0),
        UNKNOWN("unknown", 2);
        @JsonValue
        private String value;
        @EnumValue
        private int code;

        SexEnum(String value, int code) {
            this.value = value;
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }

    public static enum StatusEnum {
        ALIVE("ALIVE", 1),
        DESTROY("DESTROY", 0);
        @JsonValue
        private String value;
        @EnumValue
        private int code;

        StatusEnum(String value, int code) {
            this.value = value;
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
}
