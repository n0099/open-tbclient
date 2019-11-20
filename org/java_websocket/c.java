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
/* loaded from: classes2.dex */
public class c implements WebSocket {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static boolean DEBUG;
    public static int kwx;
    private Draft draft;
    private final d kwA;
    public SelectionKey kwB;
    public ByteChannel kwC;
    private List<Draft> kwF;
    private WebSocket.Role kwG;
    private g kwP;
    private Object kwQ;
    public final BlockingQueue<ByteBuffer> kwy;
    public final BlockingQueue<ByteBuffer> kwz;
    private volatile boolean kwD = false;
    private WebSocket.READYSTATE kwE = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer kwH = ByteBuffer.allocate(0);
    private org.java_websocket.c.a kwI = null;
    private String kwJ = null;
    private Integer kwK = null;
    private Boolean kwL = null;
    private String kwM = null;
    private long kwN = System.currentTimeMillis();
    private final Object kwO = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        kwx = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.kwG == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.kwy = new LinkedBlockingQueue();
        this.kwz = new LinkedBlockingQueue();
        this.kwA = dVar;
        this.kwG = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.cNA();
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
            if (!$assertionsDisabled && this.kwH.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                j(byteBuffer);
            } else if (this.kwH.hasRemaining()) {
                j(this.kwH);
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
        if (this.kwH.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.kwH.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.kwH.capacity() + byteBuffer.remaining());
                this.kwH.flip();
                allocate.put(this.kwH);
                this.kwH = allocate;
            }
            this.kwH.put(byteBuffer);
            this.kwH.flip();
            byteBuffer2 = this.kwH;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.kwH.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.kwH = ByteBuffer.allocate(preferedSize);
                this.kwH.put(byteBuffer);
            } else {
                this.kwH.position(this.kwH.limit());
                this.kwH.limit(this.kwH.capacity());
            }
        }
        if (this.kwG == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.kwF) {
                    Draft cNA = draft.cNA();
                    try {
                        cNA.a(this.kwG);
                        byteBuffer2.reset();
                        o = cNA.o(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(o instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) o;
                        if (cNA.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.kwM = aVar.getResourceDescriptor();
                            try {
                                eZ(cNA.a(cNA.a(aVar, this.kwA.onWebsocketHandshakeReceivedAsServer(this, cNA, aVar)), this.kwG));
                                this.draft = cNA;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.kwA.onWebsocketError(this, e4);
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
        if (this.kwG == WebSocket.Role.CLIENT) {
            this.draft.a(this.kwG);
            f o3 = this.draft.o(byteBuffer2);
            if (!(o3 instanceof h)) {
                m(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) o3;
            if (this.draft.a(this.kwI, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.kwA.onWebsocketHandshakeReceivedAsClient(this, this.kwI, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.kwA.onWebsocketError(this, e6);
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
            this.kwA.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        k(Dq(404));
        m(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        k(Dq(500));
        m(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer Dq(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.GC("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void k(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.kwE != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    m(i, str, false);
                } else {
                    if (this.draft.cNz() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.kwA.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.kwA.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.kwA.onWebsocketError(this, e2);
                                m(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.cNK();
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
            this.kwH = null;
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
            if (this.kwB != null) {
                this.kwB.cancel();
            }
            if (this.kwC != null) {
                try {
                    this.kwC.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.kwA.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.kwA.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.kwA.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.kwI = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void X(int i, boolean z) {
        l(i, "", z);
    }

    public void closeConnection(int i, String str) {
        l(i, str, false);
    }

    public synchronized void m(int i, String str, boolean z) {
        if (!this.kwD) {
            this.kwK = Integer.valueOf(i);
            this.kwJ = str;
            this.kwL = Boolean.valueOf(z);
            this.kwD = true;
            this.kwA.onWriteDemand(this);
            try {
                this.kwA.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.kwA.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.kwI = null;
        }
    }

    public void cNv() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            X(-1, true);
        } else if (this.kwD) {
            l(this.kwK.intValue(), this.kwJ, this.kwL.booleanValue());
        } else if (this.draft.cNz() == Draft.CloseHandshakeType.NONE) {
            X(1000, true);
        } else if (this.draft.cNz() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.kwG == WebSocket.Role.SERVER) {
                X(1006, true);
            } else {
                X(1000, true);
            }
        } else {
            X(1006, true);
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
        j(this.draft.aA(str, this.kwG == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        j(this.draft.b(byteBuffer, this.kwG == WebSocket.Role.CLIENT));
    }

    public void send(byte[] bArr) throws IllegalArgumentException, WebsocketNotConnectedException {
        send(ByteBuffer.wrap(bArr));
    }

    private void j(Collection<Framedata> collection) {
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
        eZ(arrayList);
    }

    public void sendFragmentedFrame(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        j(this.draft.a(opcode, byteBuffer, z));
    }

    public void sendFrame(Collection<Framedata> collection) {
        j(collection);
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        j(Collections.singletonList(framedata));
    }

    public void sendPing() throws NotYetConnectedException {
        if (this.kwP == null) {
            this.kwP = new g();
        }
        sendFrame(this.kwP);
    }

    public boolean hasBufferedData() {
        return !this.kwy.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.kwI = this.draft.b(bVar);
        this.kwM = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.kwM == null) {
            throw new AssertionError();
        }
        try {
            this.kwA.onWebsocketHandshakeSentAsClient(this, this.kwI);
            eZ(this.draft.a(this.kwI, this.kwG));
        } catch (RuntimeException e) {
            this.kwA.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void k(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.kwy.add(byteBuffer);
        this.kwA.onWriteDemand(this);
    }

    private void eZ(List<ByteBuffer> list) {
        synchronized (this.kwO) {
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
            this.kwA.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.kwA.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.kwD || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.kwD;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.kwE;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.kwE = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.kwA.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.kwA.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long cNw() {
        return this.kwN;
    }

    public void cNx() {
        this.kwN = System.currentTimeMillis();
    }

    public d cNy() {
        return this.kwA;
    }

    public <T> T getAttachment() {
        return (T) this.kwQ;
    }

    public <T> void setAttachment(T t) {
        this.kwQ = t;
    }
}
