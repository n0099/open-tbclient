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

    boolean amk();

    ByteBuffer eJT();

    boolean eJU();

    boolean eJV();

    boolean eJW();

    Opcode eJX();
}
