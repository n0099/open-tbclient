package org.java_websocket.framing;

import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public interface Framedata {

    /* loaded from: classes2.dex */
    public enum Opcode {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    ByteBuffer cPH();

    boolean cPI();

    boolean cPJ();

    boolean cPK();

    boolean cPL();

    Opcode cPM();
}
