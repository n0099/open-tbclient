package org.java_websocket.framing;

import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public interface Framedata {

    /* loaded from: classes4.dex */
    public enum Opcode {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    boolean aqf();

    ByteBuffer eNJ();

    boolean eNK();

    boolean eNL();

    boolean eNM();

    Opcode eNN();
}
