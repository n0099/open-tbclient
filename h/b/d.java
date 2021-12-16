package h.b;

import h.b.i.f;
import h.b.i.h;
import h.b.i.i;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes4.dex */
public interface d {
    InetSocketAddress getLocalSocketAddress(WebSocket webSocket);

    InetSocketAddress getRemoteSocketAddress(WebSocket webSocket);

    void onWebsocketClose(WebSocket webSocket, int i2, String str, boolean z);

    void onWebsocketCloseInitiated(WebSocket webSocket, int i2, String str);

    void onWebsocketClosing(WebSocket webSocket, int i2, String str, boolean z);

    void onWebsocketError(WebSocket webSocket, Exception exc);

    void onWebsocketHandshakeReceivedAsClient(WebSocket webSocket, h.b.i.a aVar, h hVar) throws InvalidDataException;

    i onWebsocketHandshakeReceivedAsServer(WebSocket webSocket, Draft draft, h.b.i.a aVar) throws InvalidDataException;

    void onWebsocketHandshakeSentAsClient(WebSocket webSocket, h.b.i.a aVar) throws InvalidDataException;

    void onWebsocketMessage(WebSocket webSocket, String str);

    void onWebsocketMessage(WebSocket webSocket, ByteBuffer byteBuffer);

    void onWebsocketOpen(WebSocket webSocket, f fVar);

    void onWebsocketPing(WebSocket webSocket, Framedata framedata);

    void onWebsocketPong(WebSocket webSocket, Framedata framedata);

    void onWriteDemand(WebSocket webSocket);
}
