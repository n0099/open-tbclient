package org.java_websocket.framing;

import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public interface Framedata {

    /* loaded from: classes10.dex */
    public enum Opcode {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    ByteBuffer a();

    boolean b();

    boolean c();

    Opcode d();

    boolean e();

    boolean f();
}
