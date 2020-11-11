package org.java_websocket.framing;

import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public interface Framedata {

    /* loaded from: classes11.dex */
    public enum Opcode {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    boolean amr();

    ByteBuffer eEW();

    boolean eEX();

    boolean eEY();

    boolean eEZ();

    Opcode eFa();
}
