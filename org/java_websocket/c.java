package org.java_websocket;

import java.io.IOException;
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
import org.java_websocket.c.f;
import org.java_websocket.c.h;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.g;
/* loaded from: classes4.dex */
public class c implements WebSocket {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static boolean DEBUG;
    public static int qxa;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> qxb;
    public final BlockingQueue<ByteBuffer> qxc;
    private final d qxd;
    public SelectionKey qxe;
    public ByteChannel qxf;
    private List<Draft> qxi;
    private WebSocket.Role qxj;
    private g qxs;
    private Object qxt;
    private volatile boolean qxg = false;
    private WebSocket.READYSTATE qxh = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer qxk = ByteBuffer.allocate(0);
    private org.java_websocket.c.a qxl = null;
    private String qxm = null;
    private Integer qxn = null;
    private Boolean qxo = null;
    private String qxp = null;
    private long qxq = System.currentTimeMillis();
    private final Object qxr = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        qxa = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.qxj == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.qxb = new LinkedBlockingQueue();
        this.qxc = new LinkedBlockingQueue();
        this.qxd = dVar;
        this.qxj = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.eMf();
        }
    }

    public void r(ByteBuffer byteBuffer) {
        if (!$assertionsDisabled && !byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
        if (DEBUG) {
            System.out.println("process(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining())) + '}');
        }
        if (getReadyState() != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                t(byteBuffer);
            }
        } else if (s(byteBuffer) && !isClosing() && !isClosed()) {
            if (!$assertionsDisabled && this.qxk.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                t(byteBuffer);
            } else if (this.qxk.hasRemaining()) {
                t(this.qxk);
            }
        }
        if (!$assertionsDisabled && !isClosing() && !isFlushAndClose() && byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
    }

    private boolean s(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        f y;
        boolean z;
        if (this.qxk.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.qxk.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.qxk.capacity() + byteBuffer.remaining());
                this.qxk.flip();
                allocate.put(this.qxk);
                this.qxk = allocate;
            }
            this.qxk.put(byteBuffer);
            this.qxk.flip();
            byteBuffer2 = this.qxk;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.qxk.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.qxk = ByteBuffer.allocate(preferedSize);
                this.qxk.put(byteBuffer);
            } else {
                this.qxk.position(this.qxk.limit());
                this.qxk.limit(this.qxk.capacity());
            }
        }
        if (this.qxj == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.qxi) {
                    Draft eMf = draft.eMf();
                    try {
                        eMf.a(this.qxj);
                        byteBuffer2.reset();
                        y = eMf.y(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(y instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) y;
                        if (eMf.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.qxp = aVar.getResourceDescriptor();
                            try {
                                write(eMf.a(eMf.a(aVar, this.qxd.onWebsocketHandshakeReceivedAsServer(this, eMf, aVar)), this.qxj));
                                this.draft = eMf;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.qxd.onWebsocketError(this, e4);
                                b(e4);
                                z = false;
                            } catch (InvalidDataException e5) {
                                a(e5);
                                z = false;
                            }
                        } else {
                            continue;
                        }
                    }
                    return z;
                }
                if (this.draft == null) {
                    a(new InvalidDataException(1002, "no draft matches"));
                }
                return false;
            }
            f y2 = this.draft.y(byteBuffer2);
            if (!(y2 instanceof org.java_websocket.c.a)) {
                r(1002, "wrong http function", false);
                return false;
            }
            org.java_websocket.c.a aVar2 = (org.java_websocket.c.a) y2;
            if (this.draft.a(aVar2) == Draft.HandshakeState.MATCHED) {
                a(aVar2);
                return true;
            }
            close(1002, "the handshake did finaly not match");
            return false;
        }
        if (this.qxj == WebSocket.Role.CLIENT) {
            this.draft.a(this.qxj);
            f y3 = this.draft.y(byteBuffer2);
            if (!(y3 instanceof h)) {
                r(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) y3;
            if (this.draft.a(this.qxl, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.qxd.onWebsocketHandshakeReceivedAsClient(this, this.qxl, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.qxd.onWebsocketError(this, e6);
                    r(-1, e6.getMessage(), false);
                    return false;
                } catch (InvalidDataException e7) {
                    r(e7.getCloseCode(), e7.getMessage(), false);
                    return false;
                }
            }
            close(1002, "draft " + this.draft + " refuses handshake");
        }
        return false;
    }

    private void t(ByteBuffer byteBuffer) {
        try {
            for (Framedata framedata : this.draft.x(byteBuffer)) {
                if (DEBUG) {
                    System.out.println("matched frame: " + framedata);
                }
                this.draft.a(this, framedata);
            }
        } catch (InvalidDataException e) {
            this.qxd.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        u(SF(404));
        r(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void b(RuntimeException runtimeException) {
        u(SF(500));
        r(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer SF(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.Zz("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void p(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.qxh != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    r(i, str, false);
                } else {
                    if (this.draft.eMe() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.qxd.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.qxd.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.qxd.onWebsocketError(this, e2);
                                r(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.eMp();
                            sendFrame(bVar);
                        }
                    }
                    r(i, str, z);
                }
            } else if (i == -3) {
                if (!$assertionsDisabled && !z) {
                    throw new AssertionError();
                }
                r(-3, str, true);
            } else if (i == 1002) {
                r(i, str, z);
            } else {
                r(-1, str, false);
            }
            a(WebSocket.READYSTATE.CLOSING);
            this.qxk = null;
        }
    }

    public void close(int i, String str) {
        p(i, str, false);
    }

    public synchronized void q(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN && i == 1006) {
                a(WebSocket.READYSTATE.CLOSING);
            }
            if (this.qxe != null) {
                this.qxe.cancel();
            }
            if (this.qxf != null) {
                try {
                    this.qxf.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.qxd.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.qxd.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.qxd.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.qxl = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void ap(int i, boolean z) {
        q(i, "", z);
    }

    public void closeConnection(int i, String str) {
        q(i, str, false);
    }

    public synchronized void r(int i, String str, boolean z) {
        if (!this.qxg) {
            this.qxn = Integer.valueOf(i);
            this.qxm = str;
            this.qxo = Boolean.valueOf(z);
            this.qxg = true;
            this.qxd.onWriteDemand(this);
            try {
                this.qxd.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.qxd.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.qxl = null;
        }
    }

    public void eMa() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            ap(-1, true);
        } else if (this.qxg) {
            q(this.qxn.intValue(), this.qxm, this.qxo.booleanValue());
        } else if (this.draft.eMe() == Draft.CloseHandshakeType.NONE) {
            ap(1000, true);
        } else if (this.draft.eMe() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.qxj == WebSocket.Role.SERVER) {
                ap(1006, true);
            } else {
                ap(1000, true);
            }
        } else {
            ap(1006, true);
        }
    }

    public void close(int i) {
        p(i, "", false);
    }

    public void b(InvalidDataException invalidDataException) {
        p(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    public void send(String str) throws WebsocketNotConnectedException {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        s(this.draft.bp(str, this.qxj == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        s(this.draft.b(byteBuffer, this.qxj == WebSocket.Role.CLIENT));
    }

    public void send(byte[] bArr) throws IllegalArgumentException, WebsocketNotConnectedException {
        send(ByteBuffer.wrap(bArr));
    }

    private void s(Collection<Framedata> collection) {
        if (!isOpen()) {
            throw new WebsocketNotConnectedException();
        }
        if (collection == null) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList();
        for (Framedata framedata : collection) {
            if (DEBUG) {
                System.out.println("send frame: " + framedata);
            }
            arrayList.add(this.draft.a(framedata));
        }
        write(arrayList);
    }

    public void sendFragmentedFrame(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        s(this.draft.a(opcode, byteBuffer, z));
    }

    public void sendFrame(Collection<Framedata> collection) {
        s(collection);
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        s(Collections.singletonList(framedata));
    }

    public void sendPing() throws NotYetConnectedException {
        if (this.qxs == null) {
            this.qxs = new g();
        }
        sendFrame(this.qxs);
    }

    public boolean hasBufferedData() {
        return !this.qxb.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.qxl = this.draft.b(bVar);
        this.qxp = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.qxp == null) {
            throw new AssertionError();
        }
        try {
            this.qxd.onWebsocketHandshakeSentAsClient(this, this.qxl);
            write(this.draft.a(this.qxl, this.qxj));
        } catch (RuntimeException e) {
            this.qxd.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void u(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.qxb.add(byteBuffer);
        this.qxd.onWriteDemand(this);
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.qxr) {
            for (ByteBuffer byteBuffer : list) {
                u(byteBuffer);
            }
        }
    }

    private void a(f fVar) {
        if (DEBUG) {
            System.out.println("open using draft: " + this.draft);
        }
        a(WebSocket.READYSTATE.OPEN);
        try {
            this.qxd.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.qxd.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.qxg || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
            return getReadyState() == WebSocket.READYSTATE.CONNECTING;
        }
        throw new AssertionError();
    }

    public boolean isOpen() {
        return getReadyState() == WebSocket.READYSTATE.OPEN;
    }

    public boolean isClosing() {
        return getReadyState() == WebSocket.READYSTATE.CLOSING;
    }

    public boolean isFlushAndClose() {
        return this.qxg;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.qxh;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.qxh = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.qxd.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.qxd.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long eMb() {
        return this.qxq;
    }

    public void eMc() {
        this.qxq = System.currentTimeMillis();
    }

    public d eMd() {
        return this.qxd;
    }

    public <T> T getAttachment() {
        return (T) this.qxt;
    }

    public <T> void setAttachment(T t) {
        this.qxt = t;
    }
}
