package cn.think.in.java.entity;

import cn.think.in.java.core.Consensus;
import lombok.Getter;
import lombok.Setter;

/**
 * 请求投票 RPC 参数.
 *
 * @author 莫那·鲁道
 * @see Consensus#requestVote(RequestVoteParam)
 */
@Getter
@Setter
public class RequestVoteParam extends BaseParam {

    /** 请求选票的候选人的 Id(ip:selfPort) */
    String candidateId;

    /** 候选人的最后日志条目的索引值 */
    long lastLogIndex;

    /** 候选人最后日志条目的任期号  */
    long lastLogTerm;

    private RequestVoteParam(Builder builder) {
        setTerm(builder.term);
        setServerId(builder.serverId);
        setCandidateId(builder.candidateId);
        setLastLogIndex(builder.lastLogIndex);
        setLastLogTerm(builder.lastLogTerm);
    }

    @Override
    public String toString() {
        return "RequestVoteParam{" +
            "candidateId='" + candidateId + '\'' +
            ", lastLogIndex=" + lastLogIndex +
            ", lastLogTerm=" + lastLogTerm +
            ", term=" + term +
            ", serverId='" + serverId + '\'' +
            '}';
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {

        private long term;
        private String serverId;
        private String candidateId;
        private long lastLogIndex;
        private long lastLogTerm;

        private Builder() {
        }

        public Builder term(long val) {
            term = val;
            return this;
        }

        public Builder serverId(String val) {
            serverId = val;
            return this;
        }

        public Builder candidateId(String val) {
            candidateId = val;
            return this;
        }

        public Builder lastLogIndex(long val) {
            lastLogIndex = val;
            return this;
        }

        public Builder lastLogTerm(long val) {
            lastLogTerm = val;
            return this;
        }

        public RequestVoteParam build() {
            return new RequestVoteParam(this);
        }
    }
}
