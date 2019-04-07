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
    public static int jTn;
    private Draft draft;
    private g jTF;
    private Object jTG;
    public final BlockingQueue<ByteBuffer> jTo;
    public final BlockingQueue<ByteBuffer> jTp;
    private final d jTq;
    public SelectionKey jTr;
    public ByteChannel jTs;
    private List<Draft> jTv;
    private WebSocket.Role jTw;
    private volatile boolean jTt = false;
    private WebSocket.READYSTATE jTu = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer jTx = ByteBuffer.allocate(0);
    private org.java_websocket.c.a jTy = null;
    private String jTz = null;
    private Integer jTA = null;
    private Boolean jTB = null;
    private String jTC = null;
    private long jTD = System.currentTimeMillis();
    private final Object jTE = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        jTn = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.jTw == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.jTo = new LinkedBlockingQueue();
        this.jTp = new LinkedBlockingQueue();
        this.jTq = dVar;
        this.jTw = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.cCT();
        }
    }

    public void k(ByteBuffer byteBuffer) {
        if (!$assertionsDisabled && !byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
        if (DEBUG) {
            System.out.println("process(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining())) + '}');
        }
        if (getReadyState() != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                m(byteBuffer);
            }
        } else if (l(byteBuffer) && !isClosing() && !isClosed()) {
            if (!$assertionsDisabled && this.jTx.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                m(byteBuffer);
            } else if (this.jTx.hasRemaining()) {
                m(this.jTx);
            }
        }
        if (!$assertionsDisabled && !isClosing() && !isFlushAndClose() && byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
    }

    private boolean l(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        f r;
        boolean z;
        if (this.jTx.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.jTx.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.jTx.capacity() + byteBuffer.remaining());
                this.jTx.flip();
                allocate.put(this.jTx);
                this.jTx = allocate;
            }
            this.jTx.put(byteBuffer);
            this.jTx.flip();
            byteBuffer2 = this.jTx;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.jTx.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.jTx = ByteBuffer.allocate(preferedSize);
                this.jTx.put(byteBuffer);
            } else {
                this.jTx.position(this.jTx.limit());
                this.jTx.limit(this.jTx.capacity());
            }
        }
        if (this.jTw == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.jTv) {
                    Draft cCT = draft.cCT();
                    try {
                        cCT.a(this.jTw);
                        byteBuffer2.reset();
                        r = cCT.r(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(r instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) r;
                        if (cCT.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.jTC = aVar.getResourceDescriptor();
                            try {
                                eB(cCT.a(cCT.a(aVar, this.jTq.onWebsocketHandshakeReceivedAsServer(this, cCT, aVar)), this.jTw));
                                this.draft = cCT;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.jTq.onWebsocketError(this, e4);
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
            f r2 = this.draft.r(byteBuffer2);
            if (!(r2 instanceof org.java_websocket.c.a)) {
                k(1002, "wrong http function", false);
                return false;
            }
            org.java_websocket.c.a aVar2 = (org.java_websocket.c.a) r2;
            if (this.draft.a(aVar2) == Draft.HandshakeState.MATCHED) {
                a(aVar2);
                return true;
            }
            close(1002, "the handshake did finaly not match");
            return false;
        }
        if (this.jTw == WebSocket.Role.CLIENT) {
            this.draft.a(this.jTw);
            f r3 = this.draft.r(byteBuffer2);
            if (!(r3 instanceof h)) {
                k(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) r3;
            if (this.draft.a(this.jTy, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.jTq.onWebsocketHandshakeReceivedAsClient(this, this.jTy, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.jTq.onWebsocketError(this, e6);
                    k(-1, e6.getMessage(), false);
                    return false;
                } catch (InvalidDataException e7) {
                    k(e7.getCloseCode(), e7.getMessage(), false);
                    return false;
                }
            }
            close(1002, "draft " + this.draft + " refuses handshake");
        }
        return false;
    }

    private void m(ByteBuffer byteBuffer) {
        try {
            for (Framedata framedata : this.draft.q(byteBuffer)) {
                if (DEBUG) {
                    System.out.println("matched frame: " + framedata);
                }
                this.draft.a(this, framedata);
            }
        } catch (InvalidDataException e) {
            this.jTq.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        n(Dd(404));
        k(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        n(Dd(500));
        k(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer Dd(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.Ft("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void i(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.jTu != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    k(i, str, false);
                } else {
                    if (this.draft.cCS() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.jTq.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.jTq.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.jTq.onWebsocketError(this, e2);
                                k(PointerIconCompat.TYPE_CELL, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.cDd();
                            sendFrame(bVar);
                        }
                    }
                    k(i, str, z);
                }
            } else if (i == -3) {
                if (!$assertionsDisabled && !z) {
                    throw new AssertionError();
                }
                k(-3, str, true);
            } else if (i == 1002) {
                k(i, str, z);
            } else {
                k(-1, str, false);
            }
            a(WebSocket.READYSTATE.CLOSING);
            this.jTx = null;
        }
    }

    public void close(int i, String str) {
        i(i, str, false);
    }

    public synchronized void j(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN && i == 1006) {
                a(WebSocket.READYSTATE.CLOSING);
            }
            if (this.jTr != null) {
                this.jTr.cancel();
            }
            if (this.jTs != null) {
                try {
                    this.jTs.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.jTq.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.jTq.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.jTq.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.jTy = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void S(int i, boolean z) {
        j(i, "", z);
    }

    public void closeConnection(int i, String str) {
        j(i, str, false);
    }

    public synchronized void k(int i, String str, boolean z) {
        if (!this.jTt) {
            this.jTA = Integer.valueOf(i);
            this.jTz = str;
            this.jTB = Boolean.valueOf(z);
            this.jTt = true;
            this.jTq.onWriteDemand(this);
            try {
                this.jTq.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.jTq.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.jTy = null;
        }
    }

    public void cCO() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            S(-1, true);
        } else if (this.jTt) {
            j(this.jTA.intValue(), this.jTz, this.jTB.booleanValue());
        } else if (this.draft.cCS() == Draft.CloseHandshakeType.NONE) {
            S(1000, true);
        } else if (this.draft.cCS() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.jTw == WebSocket.Role.SERVER) {
                S(PointerIconCompat.TYPE_CELL, true);
            } else {
                S(1000, true);
            }
        } else {
            S(PointerIconCompat.TYPE_CELL, true);
        }
    }

    public void close(int i) {
        i(i, "", false);
    }

    public void b(InvalidDataException invalidDataException) {
        i(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    public void send(String str) throws WebsocketNotConnectedException {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        l(this.draft.az(str, this.jTw == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        l(this.draft.b(byteBuffer, this.jTw == WebSocket.Role.CLIENT));
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
        eB(arrayList);
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
        if (this.jTF == null) {
            this.jTF = new g();
        }
        sendFrame(this.jTF);
    }

    public boolean hasBufferedData() {
        return !this.jTo.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.jTy = this.draft.b(bVar);
        this.jTC = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.jTC == null) {
            throw new AssertionError();
        }
        try {
            this.jTq.onWebsocketHandshakeSentAsClient(this, this.jTy);
            eB(this.draft.a(this.jTy, this.jTw));
        } catch (RuntimeException e) {
            this.jTq.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void n(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.jTo.add(byteBuffer);
        this.jTq.onWriteDemand(this);
    }

    private void eB(List<ByteBuffer> list) {
        synchronized (this.jTE) {
            for (ByteBuffer byteBuffer : list) {
                n(byteBuffer);
            }
        }
    }

    private void a(f fVar) {
        if (DEBUG) {
            System.out.println("open using draft: " + this.draft);
        }
        a(WebSocket.READYSTATE.OPEN);
        try {
            this.jTq.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.jTq.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.jTt || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.jTt;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.jTu;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.jTu = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.jTq.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.jTq.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long cCP() {
        return this.jTD;
    }

    public void cCQ() {
        this.jTD = System.currentTimeMillis();
    }

    public d cCR() {
        return this.jTq;
    }

    public <T> T getAttachment() {
        return (T) this.jTG;
    }

    public <T> void setAttachment(T t) {
        this.jTG = t;
    }
}
