package org.java_websocket.framing;

import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public interface Framedata {

    /* loaded from: classes7.dex */
    public enum Opcode {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    boolean Mp();

    ByteBuffer dNB();

    boolean dNC();

    boolean dND();

    boolean dNE();

    Opcode dNF();
}
