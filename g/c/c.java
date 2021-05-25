package g.c;

import g.c.h.g;
import g.c.i.f;
import g.c.i.h;
import g.c.i.i;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public class c implements WebSocket {
    public static int x = 16384;
    public static boolean y = false;

    /* renamed from: e  reason: collision with root package name */
    public final BlockingQueue<ByteBuffer> f68364e;

    /* renamed from: f  reason: collision with root package name */
    public final d f68365f;

    /* renamed from: g  reason: collision with root package name */
    public SelectionKey f68366g;

    /* renamed from: h  reason: collision with root package name */
    public ByteChannel f68367h;
    public List<Draft> k;
    public Draft l;
    public WebSocket.Role m;
    public g v;
    public Object w;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f68368i = false;
    public WebSocket.READYSTATE j = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    public ByteBuffer n = ByteBuffer.allocate(0);
    public g.c.i.a o = null;
    public String p = null;
    public Integer q = null;
    public Boolean r = null;
    public String s = null;
    public long t = System.currentTimeMillis();
    public final Object u = new Object();

    public c(d dVar, Draft draft) {
        this.l = null;
        if (dVar != null && (draft != null || this.m != WebSocket.Role.SERVER)) {
            this.f68364e = new LinkedBlockingQueue();
            new LinkedBlockingQueue();
            this.f68365f = dVar;
            this.m = WebSocket.Role.CLIENT;
            if (draft != null) {
                this.l = draft.f();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("parameters must not be null");
    }

    public boolean A() {
        return this.f68368i;
    }

    public boolean B() {
        return t() == WebSocket.READYSTATE.OPEN;
    }

    public final void C(f fVar) {
        if (y) {
            PrintStream printStream = System.out;
            printStream.println("open using draft: " + this.l);
        }
        L(WebSocket.READYSTATE.OPEN);
        try {
            this.f68365f.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e2) {
            this.f68365f.onWebsocketError(this, e2);
        }
    }

    public void D(String str) throws WebsocketNotConnectedException {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        F(this.l.h(str, this.m == WebSocket.Role.CLIENT));
    }

    public void E(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        F(this.l.i(byteBuffer, this.m == WebSocket.Role.CLIENT));
    }

    public final void F(Collection<Framedata> collection) {
        if (!B()) {
            throw new WebsocketNotConnectedException();
        }
        if (collection != null) {
            ArrayList arrayList = new ArrayList();
            for (Framedata framedata : collection) {
                if (y) {
                    PrintStream printStream = System.out;
                    printStream.println("send frame: " + framedata);
                }
                arrayList.add(this.l.g(framedata));
            }
            P(arrayList);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void G(byte[] bArr) throws IllegalArgumentException, WebsocketNotConnectedException {
        E(ByteBuffer.wrap(bArr));
    }

    public void H(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        F(this.l.e(opcode, byteBuffer, z));
    }

    public void I(Collection<Framedata> collection) {
        F(collection);
    }

    public void J() throws NotYetConnectedException {
        if (this.v == null) {
            this.v = new g();
        }
        sendFrame(this.v);
    }

    public <T> void K(T t) {
        this.w = t;
    }

    public final void L(WebSocket.READYSTATE readystate) {
        this.j = readystate;
    }

    public void M(g.c.i.b bVar) throws InvalidHandshakeException {
        this.l.m(bVar);
        this.o = bVar;
        this.s = bVar.f();
        try {
            this.f68365f.onWebsocketHandshakeSentAsClient(this, this.o);
            P(this.l.j(this.o, this.m));
        } catch (RuntimeException e2) {
            this.f68365f.onWebsocketError(this, e2);
            throw new InvalidHandshakeException("rejected because of" + e2);
        } catch (InvalidDataException unused) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    public void N() {
        this.t = System.currentTimeMillis();
    }

    public final void O(ByteBuffer byteBuffer) {
        if (y) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("write(");
            sb.append(byteBuffer.remaining());
            sb.append("): {");
            sb.append(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array()));
            sb.append('}');
            printStream.println(sb.toString());
        }
        this.f68364e.add(byteBuffer);
        this.f68365f.onWriteDemand(this);
    }

    public final void P(List<ByteBuffer> list) {
        synchronized (this.u) {
            for (ByteBuffer byteBuffer : list) {
                O(byteBuffer);
            }
        }
    }

    public void a() {
        b(1000);
    }

    public void b(int i2) {
        d(i2, "", false);
    }

    public void c(int i2, String str) {
        d(i2, str, false);
    }

    public synchronized void d(int i2, String str, boolean z) {
        if (t() == WebSocket.READYSTATE.CLOSING || this.j == WebSocket.READYSTATE.CLOSED) {
            return;
        }
        if (t() == WebSocket.READYSTATE.OPEN) {
            if (i2 == 1006) {
                L(WebSocket.READYSTATE.CLOSING);
                o(i2, str, false);
                return;
            }
            if (this.l.l() != Draft.CloseHandshakeType.NONE) {
                try {
                    if (!z) {
                        try {
                            this.f68365f.onWebsocketCloseInitiated(this, i2, str);
                        } catch (RuntimeException e2) {
                            this.f68365f.onWebsocketError(this, e2);
                        }
                    }
                    if (B()) {
                        g.c.h.b bVar = new g.c.h.b();
                        bVar.r(str);
                        bVar.q(i2);
                        bVar.h();
                        sendFrame(bVar);
                    }
                } catch (InvalidDataException e3) {
                    this.f68365f.onWebsocketError(this, e3);
                    o(1006, "generated frame is invalid", false);
                }
            }
            o(i2, str, z);
        } else if (i2 == -3) {
            o(-3, str, true);
        } else if (i2 == 1002) {
            o(i2, str, z);
        } else {
            o(-1, str, false);
        }
        L(WebSocket.READYSTATE.CLOSING);
        this.n = null;
    }

    public void e(InvalidDataException invalidDataException) {
        d(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    public void f(int i2, String str) {
        g(i2, str, false);
    }

    public synchronized void g(int i2, String str, boolean z) {
        if (t() == WebSocket.READYSTATE.CLOSED) {
            return;
        }
        if (t() == WebSocket.READYSTATE.OPEN && i2 == 1006) {
            L(WebSocket.READYSTATE.CLOSING);
        }
        if (this.f68366g != null) {
            this.f68366g.cancel();
        }
        if (this.f68367h != null) {
            try {
                this.f68367h.close();
            } catch (IOException e2) {
                if (e2.getMessage().equals("Broken pipe")) {
                    if (y) {
                        System.out.println("Caught IOException: Broken pipe during closeConnection()");
                    }
                } else {
                    this.f68365f.onWebsocketError(this, e2);
                }
            }
        }
        try {
            this.f68365f.onWebsocketClose(this, i2, str, z);
        } catch (RuntimeException e3) {
            this.f68365f.onWebsocketError(this, e3);
        }
        if (this.l != null) {
            this.l.s();
        }
        this.o = null;
        L(WebSocket.READYSTATE.CLOSED);
    }

    public void h(int i2, boolean z) {
        g(i2, "", z);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public final void i(RuntimeException runtimeException) {
        O(p(500));
        o(-1, runtimeException.getMessage(), false);
    }

    public final void j(InvalidDataException invalidDataException) {
        O(p(404));
        o(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    public void k(ByteBuffer byteBuffer) {
        if (y) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("process(");
            sb.append(byteBuffer.remaining());
            sb.append("): {");
            sb.append(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining()));
            sb.append('}');
            printStream.println(sb.toString());
        }
        if (t() != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            if (t() == WebSocket.READYSTATE.OPEN) {
                l(byteBuffer);
            }
        } else if (!m(byteBuffer) || y() || x()) {
        } else {
            if (byteBuffer.hasRemaining()) {
                l(byteBuffer);
            } else if (this.n.hasRemaining()) {
                l(this.n);
            }
        }
    }

    public final void l(ByteBuffer byteBuffer) {
        try {
            for (Framedata framedata : this.l.u(byteBuffer)) {
                if (y) {
                    PrintStream printStream = System.out;
                    printStream.println("matched frame: " + framedata);
                }
                this.l.o(this, framedata);
            }
        } catch (InvalidDataException e2) {
            this.f68365f.onWebsocketError(this, e2);
            e(e2);
        }
    }

    public final boolean m(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        f v;
        if (this.n.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.n.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.n.capacity() + byteBuffer.remaining());
                this.n.flip();
                allocate.put(this.n);
                this.n = allocate;
            }
            this.n.put(byteBuffer);
            this.n.flip();
            byteBuffer2 = this.n;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e2) {
                e(e2);
            }
        } catch (IncompleteHandshakeException e3) {
            if (this.n.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e3.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                }
                ByteBuffer allocate2 = ByteBuffer.allocate(preferedSize);
                this.n = allocate2;
                allocate2.put(byteBuffer);
            } else {
                ByteBuffer byteBuffer3 = this.n;
                byteBuffer3.position(byteBuffer3.limit());
                ByteBuffer byteBuffer4 = this.n;
                byteBuffer4.limit(byteBuffer4.capacity());
            }
        }
        if (this.m == WebSocket.Role.SERVER) {
            if (this.l == null) {
                for (Draft draft : this.k) {
                    Draft f2 = draft.f();
                    try {
                        f2.t(this.m);
                        byteBuffer2.reset();
                        v = f2.v(byteBuffer2);
                    } catch (InvalidHandshakeException unused) {
                    }
                    if (!(v instanceof g.c.i.a)) {
                        j(new InvalidDataException(1002, "wrong http function"));
                        return false;
                    }
                    g.c.i.a aVar = (g.c.i.a) v;
                    if (f2.b(aVar) == Draft.HandshakeState.MATCHED) {
                        this.s = aVar.f();
                        try {
                            i onWebsocketHandshakeReceivedAsServer = this.f68365f.onWebsocketHandshakeReceivedAsServer(this, f2, aVar);
                            f2.n(aVar, onWebsocketHandshakeReceivedAsServer);
                            P(f2.j(onWebsocketHandshakeReceivedAsServer, this.m));
                            this.l = f2;
                            C(aVar);
                            return true;
                        } catch (RuntimeException e4) {
                            this.f68365f.onWebsocketError(this, e4);
                            i(e4);
                            return false;
                        } catch (InvalidDataException e5) {
                            j(e5);
                            return false;
                        }
                    }
                }
                if (this.l == null) {
                    j(new InvalidDataException(1002, "no draft matches"));
                }
                return false;
            }
            f v2 = this.l.v(byteBuffer2);
            if (!(v2 instanceof g.c.i.a)) {
                o(1002, "wrong http function", false);
                return false;
            }
            g.c.i.a aVar2 = (g.c.i.a) v2;
            if (this.l.b(aVar2) == Draft.HandshakeState.MATCHED) {
                C(aVar2);
                return true;
            }
            c(1002, "the handshake did finaly not match");
            return false;
        }
        if (this.m == WebSocket.Role.CLIENT) {
            this.l.t(this.m);
            f v3 = this.l.v(byteBuffer2);
            if (!(v3 instanceof h)) {
                o(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) v3;
            if (this.l.a(this.o, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.f68365f.onWebsocketHandshakeReceivedAsClient(this, this.o, hVar);
                    C(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.f68365f.onWebsocketError(this, e6);
                    o(-1, e6.getMessage(), false);
                    return false;
                } catch (InvalidDataException e7) {
                    o(e7.getCloseCode(), e7.getMessage(), false);
                    return false;
                }
            }
            c(1002, "draft " + this.l + " refuses handshake");
        }
        return false;
    }

    public void n() {
        if (t() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            h(-1, true);
        } else if (this.f68368i) {
            g(this.q.intValue(), this.p, this.r.booleanValue());
        } else if (this.l.l() == Draft.CloseHandshakeType.NONE) {
            h(1000, true);
        } else if (this.l.l() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.m == WebSocket.Role.SERVER) {
                h(1006, true);
            } else {
                h(1000, true);
            }
        } else {
            h(1006, true);
        }
    }

    public synchronized void o(int i2, String str, boolean z) {
        if (this.f68368i) {
            return;
        }
        this.q = Integer.valueOf(i2);
        this.p = str;
        this.r = Boolean.valueOf(z);
        this.f68368i = true;
        this.f68365f.onWriteDemand(this);
        try {
            this.f68365f.onWebsocketClosing(this, i2, str, z);
        } catch (RuntimeException e2) {
            this.f68365f.onWebsocketError(this, e2);
        }
        if (this.l != null) {
            this.l.s();
        }
        this.o = null;
    }

    public final ByteBuffer p(int i2) {
        String str = i2 != 404 ? "500 Internal Server Error" : "404 WebSocket Upgrade Failure";
        return ByteBuffer.wrap(g.c.k.c.a("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public <T> T q() {
        return (T) this.w;
    }

    public long r() {
        return this.t;
    }

    public InetSocketAddress s() {
        return this.f68365f.getLocalSocketAddress(this);
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        F(Collections.singletonList(framedata));
    }

    public WebSocket.READYSTATE t() {
        return this.j;
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress u() {
        return this.f68365f.getRemoteSocketAddress(this);
    }

    public d v() {
        return this.f68365f;
    }

    public boolean w() {
        return !this.f68364e.isEmpty();
    }

    public boolean x() {
        return t() == WebSocket.READYSTATE.CLOSED;
    }

    public boolean y() {
        return t() == WebSocket.READYSTATE.CLOSING;
    }

    @Deprecated
    public boolean z() {
        return t() == WebSocket.READYSTATE.CONNECTING;
    }
}
