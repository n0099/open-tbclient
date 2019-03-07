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
    public static int jTK;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> jTL;
    public final BlockingQueue<ByteBuffer> jTM;
    private final d jTN;
    public SelectionKey jTO;
    public ByteChannel jTP;
    private List<Draft> jTS;
    private WebSocket.Role jTT;
    private g jUc;
    private Object jUd;
    private volatile boolean jTQ = false;
    private WebSocket.READYSTATE jTR = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer jTU = ByteBuffer.allocate(0);
    private org.java_websocket.c.a jTV = null;
    private String jTW = null;
    private Integer jTX = null;
    private Boolean jTY = null;
    private String jTZ = null;
    private long jUa = System.currentTimeMillis();
    private final Object jUb = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        jTK = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.jTT == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.jTL = new LinkedBlockingQueue();
        this.jTM = new LinkedBlockingQueue();
        this.jTN = dVar;
        this.jTT = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.cCR();
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
            if (!$assertionsDisabled && this.jTU.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                m(byteBuffer);
            } else if (this.jTU.hasRemaining()) {
                m(this.jTU);
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
        if (this.jTU.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.jTU.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.jTU.capacity() + byteBuffer.remaining());
                this.jTU.flip();
                allocate.put(this.jTU);
                this.jTU = allocate;
            }
            this.jTU.put(byteBuffer);
            this.jTU.flip();
            byteBuffer2 = this.jTU;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.jTU.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.jTU = ByteBuffer.allocate(preferedSize);
                this.jTU.put(byteBuffer);
            } else {
                this.jTU.position(this.jTU.limit());
                this.jTU.limit(this.jTU.capacity());
            }
        }
        if (this.jTT == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.jTS) {
                    Draft cCR = draft.cCR();
                    try {
                        cCR.a(this.jTT);
                        byteBuffer2.reset();
                        r = cCR.r(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(r instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) r;
                        if (cCR.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.jTZ = aVar.getResourceDescriptor();
                            try {
                                eE(cCR.a(cCR.a(aVar, this.jTN.onWebsocketHandshakeReceivedAsServer(this, cCR, aVar)), this.jTT));
                                this.draft = cCR;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.jTN.onWebsocketError(this, e4);
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
                j(1002, "wrong http function", false);
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
        if (this.jTT == WebSocket.Role.CLIENT) {
            this.draft.a(this.jTT);
            f r3 = this.draft.r(byteBuffer2);
            if (!(r3 instanceof h)) {
                j(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) r3;
            if (this.draft.a(this.jTV, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.jTN.onWebsocketHandshakeReceivedAsClient(this, this.jTV, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.jTN.onWebsocketError(this, e6);
                    j(-1, e6.getMessage(), false);
                    return false;
                } catch (InvalidDataException e7) {
                    j(e7.getCloseCode(), e7.getMessage(), false);
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
            this.jTN.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        n(Dm(404));
        j(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        n(Dm(500));
        j(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer Dm(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.FC("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void h(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.jTR != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    j(i, str, false);
                } else {
                    if (this.draft.cCQ() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.jTN.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.jTN.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.jTN.onWebsocketError(this, e2);
                                j(PointerIconCompat.TYPE_CELL, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.cDb();
                            sendFrame(bVar);
                        }
                    }
                    j(i, str, z);
                }
            } else if (i == -3) {
                if (!$assertionsDisabled && !z) {
                    throw new AssertionError();
                }
                j(-3, str, true);
            } else if (i == 1002) {
                j(i, str, z);
            } else {
                j(-1, str, false);
            }
            a(WebSocket.READYSTATE.CLOSING);
            this.jTU = null;
        }
    }

    public void close(int i, String str) {
        h(i, str, false);
    }

    public synchronized void i(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN && i == 1006) {
                a(WebSocket.READYSTATE.CLOSING);
            }
            if (this.jTO != null) {
                this.jTO.cancel();
            }
            if (this.jTP != null) {
                try {
                    this.jTP.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.jTN.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.jTN.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.jTN.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.jTV = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void S(int i, boolean z) {
        i(i, "", z);
    }

    public void closeConnection(int i, String str) {
        i(i, str, false);
    }

    public synchronized void j(int i, String str, boolean z) {
        if (!this.jTQ) {
            this.jTX = Integer.valueOf(i);
            this.jTW = str;
            this.jTY = Boolean.valueOf(z);
            this.jTQ = true;
            this.jTN.onWriteDemand(this);
            try {
                this.jTN.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.jTN.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.jTV = null;
        }
    }

    public void cCM() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            S(-1, true);
        } else if (this.jTQ) {
            i(this.jTX.intValue(), this.jTW, this.jTY.booleanValue());
        } else if (this.draft.cCQ() == Draft.CloseHandshakeType.NONE) {
            S(1000, true);
        } else if (this.draft.cCQ() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.jTT == WebSocket.Role.SERVER) {
                S(PointerIconCompat.TYPE_CELL, true);
            } else {
                S(1000, true);
            }
        } else {
            S(PointerIconCompat.TYPE_CELL, true);
        }
    }

    public void close(int i) {
        h(i, "", false);
    }

    public void b(InvalidDataException invalidDataException) {
        h(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    public void send(String str) throws WebsocketNotConnectedException {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        l(this.draft.ay(str, this.jTT == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        l(this.draft.b(byteBuffer, this.jTT == WebSocket.Role.CLIENT));
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
        eE(arrayList);
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
        if (this.jUc == null) {
            this.jUc = new g();
        }
        sendFrame(this.jUc);
    }

    public boolean hasBufferedData() {
        return !this.jTL.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.jTV = this.draft.b(bVar);
        this.jTZ = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.jTZ == null) {
            throw new AssertionError();
        }
        try {
            this.jTN.onWebsocketHandshakeSentAsClient(this, this.jTV);
            eE(this.draft.a(this.jTV, this.jTT));
        } catch (RuntimeException e) {
            this.jTN.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void n(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.jTL.add(byteBuffer);
        this.jTN.onWriteDemand(this);
    }

    private void eE(List<ByteBuffer> list) {
        synchronized (this.jUb) {
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
            this.jTN.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.jTN.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.jTQ || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.jTQ;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.jTR;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.jTR = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.jTN.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.jTN.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long cCN() {
        return this.jUa;
    }

    public void cCO() {
        this.jUa = System.currentTimeMillis();
    }

    public d cCP() {
        return this.jTN;
    }

    public <T> T getAttachment() {
        return (T) this.jUd;
    }

    public <T> void setAttachment(T t) {
        this.jUd = t;
    }
}
