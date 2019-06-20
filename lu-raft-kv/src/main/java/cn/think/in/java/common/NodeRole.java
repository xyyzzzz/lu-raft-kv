package cn.think.in.java.common;

import lombok.Getter;

/**
 * @author 莫那·鲁道
 * 用来表示该服务节点是出于什么样的角色
 */
public interface NodeRole {

    int FOLLOWER = 0;
    int CANDIDATE = 1;
    int LEADER = 2;

    @Getter
    enum Enum {

        FOLLOWER(0),

        CANDIDATE(1),

        LEADER(2);

        int code;

        Enum(int code) {
            this.code = code;
        }

        public static Enum value(int i) {
            for (Enum value : Enum.values()) {
                if (value.code == i) {
                    return value;
                }
            }
            return null;
        }

    }

}
