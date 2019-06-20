package cn.think.in.java.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *
 * 请求投票 RPC 返回值.
 *
 */
@Getter
@Setter
public class RequestVoteResult implements Serializable {

    /** 当前任期号，以便于候选人去更新自己的任期 */
    long term;

    /** 候选人赢得了此张选票时为真 */
    boolean voteGranted;

    public RequestVoteResult(boolean voteGranted) {
        this.voteGranted = voteGranted;
    }

    private RequestVoteResult(Builder builder) {
        setTerm(builder.term);
        setVoteGranted(builder.voteGranted);
    }

    public static RequestVoteResult fail() {
        return new RequestVoteResult(false);
    }

    public static RequestVoteResult ok() {
        return new RequestVoteResult(true);
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {

        private long term;
        private boolean voteGranted;

        private Builder() {
        }

        public Builder term(long term) {
            this.term = term;
            return this;
        }

        public Builder voteGranted(boolean voteGranted) {
            this.voteGranted = voteGranted;
            return this;
        }

        public RequestVoteResult build() {
            return new RequestVoteResult(this);
        }
    }
}
