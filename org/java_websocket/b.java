package org.java_websocket;

import org.java_websocket.c.e;
import org.java_websocket.c.h;
import org.java_websocket.c.i;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.g;
/* loaded from: classes18.dex */
public abstract class b implements d {
    @Override // org.java_websocket.d
    public i onWebsocketHandshakeReceivedAsServer(WebSocket webSocket, Draft draft, org.java_websocket.c.a aVar) throws InvalidDataException {
        return new e();
    }

    @Override // org.java_websocket.d
    public void onWebsocketHandshakeReceivedAsClient(WebSocket webSocket, org.java_websocket.c.a aVar, h hVar) throws InvalidDataException {
    }

    @Override // org.java_websocket.d
    public void onWebsocketHandshakeSentAsClient(WebSocket webSocket, org.java_websocket.c.a aVar) throws InvalidDataException {
    }

    @Deprecated
    public void onWebsocketMessageFragment(WebSocket webSocket, Framedata framedata) {
    }

    @Override // org.java_websocket.d
    public void onWebsocketPing(WebSocket webSocket, Framedata framedata) {
        webSocket.sendFrame(new org.java_websocket.framing.h((g) framedata));
    }

    @Override // org.java_websocket.d
    public void onWebsocketPong(WebSocket webSocket, Framedata framedata) {
    }
}
