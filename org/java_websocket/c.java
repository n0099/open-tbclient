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
/* loaded from: classes17.dex */
public class c implements WebSocket {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static boolean DEBUG;
    public static int oMe;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> oMf;
    public final BlockingQueue<ByteBuffer> oMg;
    private final d oMh;
    public SelectionKey oMi;
    public ByteChannel oMj;
    private List<Draft> oMm;
    private WebSocket.Role oMn;
    private g oMw;
    private Object oMx;
    private volatile boolean oMk = false;
    private WebSocket.READYSTATE oMl = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer oMo = ByteBuffer.allocate(0);
    private org.java_websocket.c.a oMp = null;
    private String oMq = null;
    private Integer oMr = null;
    private Boolean oMs = null;
    private String oMt = null;
    private long oMu = System.currentTimeMillis();
    private final Object oMv = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        oMe = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.oMn == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.oMf = new LinkedBlockingQueue();
        this.oMg = new LinkedBlockingQueue();
        this.oMh = dVar;
        this.oMn = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.enl();
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
            if (!$assertionsDisabled && this.oMo.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                t(byteBuffer);
            } else if (this.oMo.hasRemaining()) {
                t(this.oMo);
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
        if (this.oMo.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.oMo.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.oMo.capacity() + byteBuffer.remaining());
                this.oMo.flip();
                allocate.put(this.oMo);
                this.oMo = allocate;
            }
            this.oMo.put(byteBuffer);
            this.oMo.flip();
            byteBuffer2 = this.oMo;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.oMo.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.oMo = ByteBuffer.allocate(preferedSize);
                this.oMo.put(byteBuffer);
            } else {
                this.oMo.position(this.oMo.limit());
                this.oMo.limit(this.oMo.capacity());
            }
        }
        if (this.oMn == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.oMm) {
                    Draft enl = draft.enl();
                    try {
                        enl.a(this.oMn);
                        byteBuffer2.reset();
                        y = enl.y(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(y instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) y;
                        if (enl.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.oMt = aVar.getResourceDescriptor();
                            try {
                                write(enl.a(enl.a(aVar, this.oMh.onWebsocketHandshakeReceivedAsServer(this, enl, aVar)), this.oMn));
                                this.draft = enl;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.oMh.onWebsocketError(this, e4);
                                a(e4);
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
                p(1002, "wrong http function", false);
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
        if (this.oMn == WebSocket.Role.CLIENT) {
            this.draft.a(this.oMn);
            f y3 = this.draft.y(byteBuffer2);
            if (!(y3 instanceof h)) {
                p(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) y3;
            if (this.draft.a(this.oMp, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.oMh.onWebsocketHandshakeReceivedAsClient(this, this.oMp, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.oMh.onWebsocketError(this, e6);
                    p(-1, e6.getMessage(), false);
                    return false;
                } catch (InvalidDataException e7) {
                    p(e7.getCloseCode(), e7.getMessage(), false);
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
            this.oMh.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        u(OT(404));
        p(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        u(OT(500));
        p(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer OT(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.UY("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void n(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.oMl != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    p(i, str, false);
                } else {
                    if (this.draft.enk() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.oMh.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.oMh.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.oMh.onWebsocketError(this, e2);
                                p(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.env();
                            sendFrame(bVar);
                        }
                    }
                    p(i, str, z);
                }
            } else if (i == -3) {
                if (!$assertionsDisabled && !z) {
                    throw new AssertionError();
                }
                p(-3, str, true);
            } else if (i == 1002) {
                p(i, str, z);
            } else {
                p(-1, str, false);
            }
            a(WebSocket.READYSTATE.CLOSING);
            this.oMo = null;
        }
    }

    public void close(int i, String str) {
        n(i, str, false);
    }

    public synchronized void o(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN && i == 1006) {
                a(WebSocket.READYSTATE.CLOSING);
            }
            if (this.oMi != null) {
                this.oMi.cancel();
            }
            if (this.oMj != null) {
                try {
                    this.oMj.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.oMh.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.oMh.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.oMh.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.oMp = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void am(int i, boolean z) {
        o(i, "", z);
    }

    public void closeConnection(int i, String str) {
        o(i, str, false);
    }

    public synchronized void p(int i, String str, boolean z) {
        if (!this.oMk) {
            this.oMr = Integer.valueOf(i);
            this.oMq = str;
            this.oMs = Boolean.valueOf(z);
            this.oMk = true;
            this.oMh.onWriteDemand(this);
            try {
                this.oMh.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.oMh.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.oMp = null;
        }
    }

    public void eng() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            am(-1, true);
        } else if (this.oMk) {
            o(this.oMr.intValue(), this.oMq, this.oMs.booleanValue());
        } else if (this.draft.enk() == Draft.CloseHandshakeType.NONE) {
            am(1000, true);
        } else if (this.draft.enk() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.oMn == WebSocket.Role.SERVER) {
                am(1006, true);
            } else {
                am(1000, true);
            }
        } else {
            am(1006, true);
        }
    }

    public void close(int i) {
        n(i, "", false);
    }

    public void b(InvalidDataException invalidDataException) {
        n(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    public void send(String str) throws WebsocketNotConnectedException {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        t(this.draft.bh(str, this.oMn == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        t(this.draft.b(byteBuffer, this.oMn == WebSocket.Role.CLIENT));
    }

    public void send(byte[] bArr) throws IllegalArgumentException, WebsocketNotConnectedException {
        send(ByteBuffer.wrap(bArr));
    }

    private void t(Collection<Framedata> collection) {
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
        t(this.draft.a(opcode, byteBuffer, z));
    }

    public void sendFrame(Collection<Framedata> collection) {
        t(collection);
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        t(Collections.singletonList(framedata));
    }

    public void sendPing() throws NotYetConnectedException {
        if (this.oMw == null) {
            this.oMw = new g();
        }
        sendFrame(this.oMw);
    }

    public boolean hasBufferedData() {
        return !this.oMf.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.oMp = this.draft.b(bVar);
        this.oMt = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.oMt == null) {
            throw new AssertionError();
        }
        try {
            this.oMh.onWebsocketHandshakeSentAsClient(this, this.oMp);
            write(this.draft.a(this.oMp, this.oMn));
        } catch (RuntimeException e) {
            this.oMh.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void u(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.oMf.add(byteBuffer);
        this.oMh.onWriteDemand(this);
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.oMv) {
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
            this.oMh.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.oMh.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.oMk || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.oMk;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.oMl;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.oMl = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.oMh.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.oMh.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long enh() {
        return this.oMu;
    }

    public void eni() {
        this.oMu = System.currentTimeMillis();
    }

    public d enj() {
        return this.oMh;
    }

    public <T> T getAttachment() {
        return (T) this.oMx;
    }

    public <T> void setAttachment(T t) {
        this.oMx = t;
    }
}
