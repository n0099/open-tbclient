package g.c;

import g.c.h.g;
import g.c.i.e;
import g.c.i.h;
import g.c.i.i;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes8.dex */
public abstract class b implements d {
    @Override // g.c.d
    public void onWebsocketHandshakeReceivedAsClient(WebSocket webSocket, g.c.i.a aVar, h hVar) throws InvalidDataException {
    }

    @Override // g.c.d
    public i onWebsocketHandshakeReceivedAsServer(WebSocket webSocket, Draft draft, g.c.i.a aVar) throws InvalidDataException {
        return new e();
    }

    @Override // g.c.d
    public void onWebsocketHandshakeSentAsClient(WebSocket webSocket, g.c.i.a aVar) throws InvalidDataException {
    }

    @Deprecated
    public abstract void onWebsocketMessageFragment(WebSocket webSocket, Framedata framedata);

    @Override // g.c.d
    public void onWebsocketPing(WebSocket webSocket, Framedata framedata) {
        webSocket.sendFrame(new g.c.h.h((g) framedata));
    }

    @Override // g.c.d
    public void onWebsocketPong(WebSocket webSocket, Framedata framedata) {
    }
}
