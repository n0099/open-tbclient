package org.java_websocket.framing;

import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public interface Framedata {

    /* loaded from: classes5.dex */
    public enum Opcode {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    boolean aoR();

    ByteBuffer eEX();

    boolean eEY();

    boolean eEZ();

    boolean eFa();

    Opcode eFb();
}
