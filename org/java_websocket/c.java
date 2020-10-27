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
/* loaded from: classes11.dex */
public class c implements WebSocket {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static boolean DEBUG;
    public static int pSN;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> pSO;
    public final BlockingQueue<ByteBuffer> pSP;
    private final d pSQ;
    public SelectionKey pSR;
    public ByteChannel pSS;
    private List<Draft> pSV;
    private WebSocket.Role pSW;
    private g pTf;
    private Object pTg;
    private volatile boolean pST = false;
    private WebSocket.READYSTATE pSU = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer pSX = ByteBuffer.allocate(0);
    private org.java_websocket.c.a pSY = null;
    private String pSZ = null;
    private Integer pTa = null;
    private Boolean pTb = null;
    private String pTc = null;
    private long pTd = System.currentTimeMillis();
    private final Object pTe = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        pSN = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.pSW == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.pSO = new LinkedBlockingQueue();
        this.pSP = new LinkedBlockingQueue();
        this.pSQ = dVar;
        this.pSW = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.eAV();
        }
    }

    public void s(ByteBuffer byteBuffer) {
        if (!$assertionsDisabled && !byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
        if (DEBUG) {
            System.out.println("process(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining())) + '}');
        }
        if (getReadyState() != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                u(byteBuffer);
            }
        } else if (t(byteBuffer) && !isClosing() && !isClosed()) {
            if (!$assertionsDisabled && this.pSX.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                u(byteBuffer);
            } else if (this.pSX.hasRemaining()) {
                u(this.pSX);
            }
        }
        if (!$assertionsDisabled && !isClosing() && !isFlushAndClose() && byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
    }

    private boolean t(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        f z;
        boolean z2;
        if (this.pSX.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.pSX.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.pSX.capacity() + byteBuffer.remaining());
                this.pSX.flip();
                allocate.put(this.pSX);
                this.pSX = allocate;
            }
            this.pSX.put(byteBuffer);
            this.pSX.flip();
            byteBuffer2 = this.pSX;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.pSX.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.pSX = ByteBuffer.allocate(preferedSize);
                this.pSX.put(byteBuffer);
            } else {
                this.pSX.position(this.pSX.limit());
                this.pSX.limit(this.pSX.capacity());
            }
        }
        if (this.pSW == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.pSV) {
                    Draft eAV = draft.eAV();
                    try {
                        eAV.a(this.pSW);
                        byteBuffer2.reset();
                        z = eAV.z(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(z instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z2 = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) z;
                        if (eAV.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.pTc = aVar.getResourceDescriptor();
                            try {
                                write(eAV.a(eAV.a(aVar, this.pSQ.onWebsocketHandshakeReceivedAsServer(this, eAV, aVar)), this.pSW));
                                this.draft = eAV;
                                a(aVar);
                                z2 = true;
                            } catch (RuntimeException e4) {
                                this.pSQ.onWebsocketError(this, e4);
                                a(e4);
                                z2 = false;
                            } catch (InvalidDataException e5) {
                                a(e5);
                                z2 = false;
                            }
                        } else {
                            continue;
                        }
                    }
                    return z2;
                }
                if (this.draft == null) {
                    a(new InvalidDataException(1002, "no draft matches"));
                }
                return false;
            }
            f z3 = this.draft.z(byteBuffer2);
            if (!(z3 instanceof org.java_websocket.c.a)) {
                r(1002, "wrong http function", false);
                return false;
            }
            org.java_websocket.c.a aVar2 = (org.java_websocket.c.a) z3;
            if (this.draft.a(aVar2) == Draft.HandshakeState.MATCHED) {
                a(aVar2);
                return true;
            }
            close(1002, "the handshake did finaly not match");
            return false;
        }
        if (this.pSW == WebSocket.Role.CLIENT) {
            this.draft.a(this.pSW);
            f z4 = this.draft.z(byteBuffer2);
            if (!(z4 instanceof h)) {
                r(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) z4;
            if (this.draft.a(this.pSY, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.pSQ.onWebsocketHandshakeReceivedAsClient(this, this.pSY, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.pSQ.onWebsocketError(this, e6);
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

    private void u(ByteBuffer byteBuffer) {
        try {
            for (Framedata framedata : this.draft.y(byteBuffer)) {
                if (DEBUG) {
                    System.out.println("matched frame: " + framedata);
                }
                this.draft.a(this, framedata);
            }
        } catch (InvalidDataException e) {
            this.pSQ.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        v(Rq(404));
        r(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        v(Rq(500));
        r(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer Rq(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.Xz("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void p(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.pSU != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    r(i, str, false);
                } else {
                    if (this.draft.eAU() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.pSQ.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.pSQ.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.pSQ.onWebsocketError(this, e2);
                                r(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.eBf();
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
            this.pSX = null;
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
            if (this.pSR != null) {
                this.pSR.cancel();
            }
            if (this.pSS != null) {
                try {
                    this.pSS.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.pSQ.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.pSQ.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.pSQ.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.pSY = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void ar(int i, boolean z) {
        q(i, "", z);
    }

    public void closeConnection(int i, String str) {
        q(i, str, false);
    }

    public synchronized void r(int i, String str, boolean z) {
        if (!this.pST) {
            this.pTa = Integer.valueOf(i);
            this.pSZ = str;
            this.pTb = Boolean.valueOf(z);
            this.pST = true;
            this.pSQ.onWriteDemand(this);
            try {
                this.pSQ.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.pSQ.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.pSY = null;
        }
    }

    public void eAQ() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            ar(-1, true);
        } else if (this.pST) {
            q(this.pTa.intValue(), this.pSZ, this.pTb.booleanValue());
        } else if (this.draft.eAU() == Draft.CloseHandshakeType.NONE) {
            ar(1000, true);
        } else if (this.draft.eAU() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.pSW == WebSocket.Role.SERVER) {
                ar(1006, true);
            } else {
                ar(1000, true);
            }
        } else {
            ar(1006, true);
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
        t(this.draft.br(str, this.pSW == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        t(this.draft.b(byteBuffer, this.pSW == WebSocket.Role.CLIENT));
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
        if (this.pTf == null) {
            this.pTf = new g();
        }
        sendFrame(this.pTf);
    }

    public boolean hasBufferedData() {
        return !this.pSO.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.pSY = this.draft.b(bVar);
        this.pTc = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.pTc == null) {
            throw new AssertionError();
        }
        try {
            this.pSQ.onWebsocketHandshakeSentAsClient(this, this.pSY);
            write(this.draft.a(this.pSY, this.pSW));
        } catch (RuntimeException e) {
            this.pSQ.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void v(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.pSO.add(byteBuffer);
        this.pSQ.onWriteDemand(this);
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.pTe) {
            for (ByteBuffer byteBuffer : list) {
                v(byteBuffer);
            }
        }
    }

    private void a(f fVar) {
        if (DEBUG) {
            System.out.println("open using draft: " + this.draft);
        }
        a(WebSocket.READYSTATE.OPEN);
        try {
            this.pSQ.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.pSQ.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.pST || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.pST;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.pSU;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.pSU = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.pSQ.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.pSQ.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long eAR() {
        return this.pTd;
    }

    public void eAS() {
        this.pTd = System.currentTimeMillis();
    }

    public d eAT() {
        return this.pSQ;
    }

    public <T> T getAttachment() {
        return (T) this.pTg;
    }

    public <T> void setAttachment(T t) {
        this.pTg = t;
    }
}
