package org.java_websocket.framing;

import java.nio.ByteBuffer;
/* loaded from: classes17.dex */
public interface Framedata {

    /* loaded from: classes17.dex */
    public enum Opcode {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    boolean afm();

    boolean enA();

    Opcode enB();

    ByteBuffer enx();

    boolean eny();

    boolean enz();
}
