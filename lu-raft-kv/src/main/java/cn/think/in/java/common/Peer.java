package cn.think.in.java.common;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * 当前节点的 同伴.
 *
 * @author 莫那·鲁道
 */
@Getter
@Setter
public class Peer {

    /** ip:selfPort */
    private final String address;


    public Peer(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Peer peer = (Peer) o;
        return Objects.equals(address, peer.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(address);
    }

    @Override
    public String toString() {
        return "Peer{" +
            "address='" + address + '\'' +
            '}';
    }
}
