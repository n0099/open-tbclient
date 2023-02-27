package org.java_websocket;

import org.java_websocket.framing.Framedata;
/* loaded from: classes9.dex */
public interface WebSocket {

    /* loaded from: classes9.dex */
    public enum READYSTATE {
        NOT_YET_CONNECTED,
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED
    }

    /* loaded from: classes9.dex */
    public enum Role {
        CLIENT,
        SERVER
    }

    void sendFrame(Framedata framedata);
}
