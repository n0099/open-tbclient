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
    public static int kwG;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> kwH;
    public final BlockingQueue<ByteBuffer> kwI;
    private final d kwJ;
    public SelectionKey kwK;
    public ByteChannel kwL;
    private List<Draft> kwO;
    private WebSocket.Role kwP;
    private g kwY;
    private Object kwZ;
    private volatile boolean kwM = false;
    private WebSocket.READYSTATE kwN = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer kwQ = ByteBuffer.allocate(0);
    private org.java_websocket.c.a kwR = null;
    private String kwS = null;
    private Integer kwT = null;
    private Boolean kwU = null;
    private String kwV = null;
    private long kwW = System.currentTimeMillis();
    private final Object kwX = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        kwG = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.kwP == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.kwH = new LinkedBlockingQueue();
        this.kwI = new LinkedBlockingQueue();
        this.kwJ = dVar;
        this.kwP = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.cPv();
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
            if (!$assertionsDisabled && this.kwQ.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                j(byteBuffer);
            } else if (this.kwQ.hasRemaining()) {
                j(this.kwQ);
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
        if (this.kwQ.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.kwQ.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.kwQ.capacity() + byteBuffer.remaining());
                this.kwQ.flip();
                allocate.put(this.kwQ);
                this.kwQ = allocate;
            }
            this.kwQ.put(byteBuffer);
            this.kwQ.flip();
            byteBuffer2 = this.kwQ;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.kwQ.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.kwQ = ByteBuffer.allocate(preferedSize);
                this.kwQ.put(byteBuffer);
            } else {
                this.kwQ.position(this.kwQ.limit());
                this.kwQ.limit(this.kwQ.capacity());
            }
        }
        if (this.kwP == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.kwO) {
                    Draft cPv = draft.cPv();
                    try {
                        cPv.a(this.kwP);
                        byteBuffer2.reset();
                        o = cPv.o(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(o instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) o;
                        if (cPv.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.kwV = aVar.getResourceDescriptor();
                            try {
                                eL(cPv.a(cPv.a(aVar, this.kwJ.onWebsocketHandshakeReceivedAsServer(this, cPv, aVar)), this.kwP));
                                this.draft = cPv;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.kwJ.onWebsocketError(this, e4);
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
        if (this.kwP == WebSocket.Role.CLIENT) {
            this.draft.a(this.kwP);
            f o3 = this.draft.o(byteBuffer2);
            if (!(o3 instanceof h)) {
                m(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) o3;
            if (this.draft.a(this.kwR, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.kwJ.onWebsocketHandshakeReceivedAsClient(this, this.kwR, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.kwJ.onWebsocketError(this, e6);
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
            this.kwJ.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        k(EU(404));
        m(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        k(EU(500));
        m(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer EU(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.Il("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void k(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.kwN != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    m(i, str, false);
                } else {
                    if (this.draft.cPu() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.kwJ.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.kwJ.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.kwJ.onWebsocketError(this, e2);
                                m(PointerIconCompat.TYPE_CELL, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.cPF();
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
            this.kwQ = null;
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
            if (this.kwK != null) {
                this.kwK.cancel();
            }
            if (this.kwL != null) {
                try {
                    this.kwL.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.kwJ.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.kwJ.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.kwJ.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.kwR = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void aa(int i, boolean z) {
        l(i, "", z);
    }

    public void closeConnection(int i, String str) {
        l(i, str, false);
    }

    public synchronized void m(int i, String str, boolean z) {
        if (!this.kwM) {
            this.kwT = Integer.valueOf(i);
            this.kwS = str;
            this.kwU = Boolean.valueOf(z);
            this.kwM = true;
            this.kwJ.onWriteDemand(this);
            try {
                this.kwJ.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.kwJ.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.kwR = null;
        }
    }

    public void cPq() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            aa(-1, true);
        } else if (this.kwM) {
            l(this.kwT.intValue(), this.kwS, this.kwU.booleanValue());
        } else if (this.draft.cPu() == Draft.CloseHandshakeType.NONE) {
            aa(1000, true);
        } else if (this.draft.cPu() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.kwP == WebSocket.Role.SERVER) {
                aa(PointerIconCompat.TYPE_CELL, true);
            } else {
                aa(1000, true);
            }
        } else {
            aa(PointerIconCompat.TYPE_CELL, true);
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
        l(this.draft.aF(str, this.kwP == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        l(this.draft.b(byteBuffer, this.kwP == WebSocket.Role.CLIENT));
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
        eL(arrayList);
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
        if (this.kwY == null) {
            this.kwY = new g();
        }
        sendFrame(this.kwY);
    }

    public boolean hasBufferedData() {
        return !this.kwH.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.kwR = this.draft.b(bVar);
        this.kwV = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.kwV == null) {
            throw new AssertionError();
        }
        try {
            this.kwJ.onWebsocketHandshakeSentAsClient(this, this.kwR);
            eL(this.draft.a(this.kwR, this.kwP));
        } catch (RuntimeException e) {
            this.kwJ.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void k(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.kwH.add(byteBuffer);
        this.kwJ.onWriteDemand(this);
    }

    private void eL(List<ByteBuffer> list) {
        synchronized (this.kwX) {
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
            this.kwJ.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.kwJ.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.kwM || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.kwM;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.kwN;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.kwN = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.kwJ.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.kwJ.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long cPr() {
        return this.kwW;
    }

    public void cPs() {
        this.kwW = System.currentTimeMillis();
    }

    public d cPt() {
        return this.kwJ;
    }

    public <T> T getAttachment() {
        return (T) this.kwZ;
    }

    public <T> void setAttachment(T t) {
        this.kwZ = t;
    }
}
