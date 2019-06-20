package cn.think.in.java.core;

import cn.think.in.java.common.NodeConfig;
import cn.think.in.java.entity.AppendEntryParam;
import cn.think.in.java.entity.AppendEntryResult;
import cn.think.in.java.entity.RequestVoteParam;
import cn.think.in.java.entity.RequestVoteResult;
import raft.client.ClientKVAck;
import raft.client.ClientKVReq;

/**
 *
 * @author 莫那·鲁道
 */
public interface Node<T> extends LifeCycle{

    /**
     * 设置配置文件.
     *
     * @param config
     */
    void setConfig(NodeConfig config);

    /**
     * 处理请求投票 RPC.
     *
     * @param param
     * @return
     */
    RequestVoteResult handlerRequestVote(RequestVoteParam param);

    /**
     * 处理附加日志请求.
     *
     * @param param
     * @return
     */
    AppendEntryResult handlerAppendEntries(AppendEntryParam param);

    /**
     * 处理客户端请求.
     *
     * @param request
     * @return
     */
    ClientKVAck handlerClientRequest(ClientKVReq request);

    /**
     * 转发给 leader 节点.
     * @param request
     * @return
     */
    ClientKVAck redirect(ClientKVReq request);

}
