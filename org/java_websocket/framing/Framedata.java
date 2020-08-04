package org.java_websocket.framing;

import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public interface Framedata {

    /* loaded from: classes9.dex */
    public enum Opcode {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    boolean Yw();

    ByteBuffer dXn();

    boolean dXo();

    boolean dXp();

    boolean dXq();

    Opcode dXr();
}
