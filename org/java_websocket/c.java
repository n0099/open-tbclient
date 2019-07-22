package org.java_websocket;

import android.support.v4.view.PointerIconCompat;
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
/* loaded from: classes2.dex */
public class c implements WebSocket {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static boolean DEBUG;
    public static int kth;
    private Draft draft;
    private Object ktA;
    public final BlockingQueue<ByteBuffer> kti;
    public final BlockingQueue<ByteBuffer> ktj;
    private final d ktk;
    public SelectionKey ktl;
    public ByteChannel ktm;
    private List<Draft> ktp;
    private WebSocket.Role ktq;
    private g ktz;
    private volatile boolean ktn = false;
    private WebSocket.READYSTATE kto = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer ktr = ByteBuffer.allocate(0);
    private org.java_websocket.c.a kts = null;
    private String ktt = null;
    private Integer ktu = null;
    private Boolean ktv = null;
    private String ktw = null;
    private long ktx = System.currentTimeMillis();
    private final Object kty = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        kth = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.ktq == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.kti = new LinkedBlockingQueue();
        this.ktj = new LinkedBlockingQueue();
        this.ktk = dVar;
        this.ktq = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.cOo();
        }
    }

    public void h(ByteBuffer byteBuffer) {
        if (!$assertionsDisabled && !byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
        if (DEBUG) {
            System.out.println("process(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining())) + '}');
        }
        if (getReadyState() != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                j(byteBuffer);
            }
        } else if (i(byteBuffer) && !isClosing() && !isClosed()) {
            if (!$assertionsDisabled && this.ktr.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                j(byteBuffer);
            } else if (this.ktr.hasRemaining()) {
                j(this.ktr);
            }
        }
        if (!$assertionsDisabled && !isClosing() && !isFlushAndClose() && byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
    }

    private boolean i(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        f o;
        boolean z;
        if (this.ktr.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.ktr.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.ktr.capacity() + byteBuffer.remaining());
                this.ktr.flip();
                allocate.put(this.ktr);
                this.ktr = allocate;
            }
            this.ktr.put(byteBuffer);
            this.ktr.flip();
            byteBuffer2 = this.ktr;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.ktr.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.ktr = ByteBuffer.allocate(preferedSize);
                this.ktr.put(byteBuffer);
            } else {
                this.ktr.position(this.ktr.limit());
                this.ktr.limit(this.ktr.capacity());
            }
        }
        if (this.ktq == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.ktp) {
                    Draft cOo = draft.cOo();
                    try {
                        cOo.a(this.ktq);
                        byteBuffer2.reset();
                        o = cOo.o(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(o instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) o;
                        if (cOo.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.ktw = aVar.getResourceDescriptor();
                            try {
                                eM(cOo.a(cOo.a(aVar, this.ktk.onWebsocketHandshakeReceivedAsServer(this, cOo, aVar)), this.ktq));
                                this.draft = cOo;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.ktk.onWebsocketError(this, e4);
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
            f o2 = this.draft.o(byteBuffer2);
            if (!(o2 instanceof org.java_websocket.c.a)) {
                m(1002, "wrong http function", false);
                return false;
            }
            org.java_websocket.c.a aVar2 = (org.java_websocket.c.a) o2;
            if (this.draft.a(aVar2) == Draft.HandshakeState.MATCHED) {
                a(aVar2);
                return true;
            }
            close(1002, "the handshake did finaly not match");
            return false;
        }
        if (this.ktq == WebSocket.Role.CLIENT) {
            this.draft.a(this.ktq);
            f o3 = this.draft.o(byteBuffer2);
            if (!(o3 instanceof h)) {
                m(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) o3;
            if (this.draft.a(this.kts, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.ktk.onWebsocketHandshakeReceivedAsClient(this, this.kts, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.ktk.onWebsocketError(this, e6);
                    m(-1, e6.getMessage(), false);
                    return false;
                } catch (InvalidDataException e7) {
                    m(e7.getCloseCode(), e7.getMessage(), false);
                    return false;
                }
            }
            close(1002, "draft " + this.draft + " refuses handshake");
        }
        return false;
    }

    private void j(ByteBuffer byteBuffer) {
        try {
            for (Framedata framedata : this.draft.n(byteBuffer)) {
                if (DEBUG) {
                    System.out.println("matched frame: " + framedata);
                }
                this.draft.a(this, framedata);
            }
        } catch (InvalidDataException e) {
            this.ktk.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        k(EO(404));
        m(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        k(EO(500));
        m(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer EO(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.HK("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void k(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.kto != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    m(i, str, false);
                } else {
                    if (this.draft.cOn() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.ktk.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.ktk.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.ktk.onWebsocketError(this, e2);
                                m(PointerIconCompat.TYPE_CELL, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.cOy();
                            sendFrame(bVar);
                        }
                    }
                    m(i, str, z);
                }
            } else if (i == -3) {
                if (!$assertionsDisabled && !z) {
                    throw new AssertionError();
                }
                m(-3, str, true);
            } else if (i == 1002) {
                m(i, str, z);
            } else {
                m(-1, str, false);
            }
            a(WebSocket.READYSTATE.CLOSING);
            this.ktr = null;
        }
    }

    public void close(int i, String str) {
        k(i, str, false);
    }

    public synchronized void l(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN && i == 1006) {
                a(WebSocket.READYSTATE.CLOSING);
            }
            if (this.ktl != null) {
                this.ktl.cancel();
            }
            if (this.ktm != null) {
                try {
                    this.ktm.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.ktk.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.ktk.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.ktk.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.kts = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void Z(int i, boolean z) {
        l(i, "", z);
    }

    public void closeConnection(int i, String str) {
        l(i, str, false);
    }

    public synchronized void m(int i, String str, boolean z) {
        if (!this.ktn) {
            this.ktu = Integer.valueOf(i);
            this.ktt = str;
            this.ktv = Boolean.valueOf(z);
            this.ktn = true;
            this.ktk.onWriteDemand(this);
            try {
                this.ktk.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.ktk.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.kts = null;
        }
    }

    public void cOj() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            Z(-1, true);
        } else if (this.ktn) {
            l(this.ktu.intValue(), this.ktt, this.ktv.booleanValue());
        } else if (this.draft.cOn() == Draft.CloseHandshakeType.NONE) {
            Z(1000, true);
        } else if (this.draft.cOn() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.ktq == WebSocket.Role.SERVER) {
                Z(PointerIconCompat.TYPE_CELL, true);
            } else {
                Z(1000, true);
            }
        } else {
            Z(PointerIconCompat.TYPE_CELL, true);
        }
    }

    public void close(int i) {
        k(i, "", false);
    }

    public void b(InvalidDataException invalidDataException) {
        k(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    public void send(String str) throws WebsocketNotConnectedException {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        l(this.draft.aF(str, this.ktq == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        l(this.draft.b(byteBuffer, this.ktq == WebSocket.Role.CLIENT));
    }

    public void send(byte[] bArr) throws IllegalArgumentException, WebsocketNotConnectedException {
        send(ByteBuffer.wrap(bArr));
    }

    private void l(Collection<Framedata> collection) {
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
        eM(arrayList);
    }

    public void sendFragmentedFrame(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        l(this.draft.a(opcode, byteBuffer, z));
    }

    public void sendFrame(Collection<Framedata> collection) {
        l(collection);
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        l(Collections.singletonList(framedata));
    }

    public void sendPing() throws NotYetConnectedException {
        if (this.ktz == null) {
            this.ktz = new g();
        }
        sendFrame(this.ktz);
    }

    public boolean hasBufferedData() {
        return !this.kti.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.kts = this.draft.b(bVar);
        this.ktw = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.ktw == null) {
            throw new AssertionError();
        }
        try {
            this.ktk.onWebsocketHandshakeSentAsClient(this, this.kts);
            eM(this.draft.a(this.kts, this.ktq));
        } catch (RuntimeException e) {
            this.ktk.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void k(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.kti.add(byteBuffer);
        this.ktk.onWriteDemand(this);
    }

    private void eM(List<ByteBuffer> list) {
        synchronized (this.kty) {
            for (ByteBuffer byteBuffer : list) {
                k(byteBuffer);
            }
        }
    }

    private void a(f fVar) {
        if (DEBUG) {
            System.out.println("open using draft: " + this.draft);
        }
        a(WebSocket.READYSTATE.OPEN);
        try {
            this.ktk.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.ktk.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.ktn || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.ktn;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.kto;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.kto = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.ktk.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.ktk.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long cOk() {
        return this.ktx;
    }

    public void cOl() {
        this.ktx = System.currentTimeMillis();
    }

    public d cOm() {
        return this.ktk;
    }

    public <T> T getAttachment() {
        return (T) this.ktA;
    }

    public <T> void setAttachment(T t) {
        this.ktA = t;
    }
}
