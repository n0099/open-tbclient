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
    public static int klF;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> klG;
    public final BlockingQueue<ByteBuffer> klH;
    private final d klI;
    public SelectionKey klJ;
    public ByteChannel klK;
    private List<Draft> klN;
    private WebSocket.Role klO;
    private g klX;
    private Object klY;
    private volatile boolean klL = false;
    private WebSocket.READYSTATE klM = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer klP = ByteBuffer.allocate(0);
    private org.java_websocket.c.a klQ = null;
    private String klR = null;
    private Integer klS = null;
    private Boolean klT = null;
    private String klU = null;
    private long klV = System.currentTimeMillis();
    private final Object klW = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        klF = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.klO == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.klG = new LinkedBlockingQueue();
        this.klH = new LinkedBlockingQueue();
        this.klI = dVar;
        this.klO = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.cKB();
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
            if (!$assertionsDisabled && this.klP.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                j(byteBuffer);
            } else if (this.klP.hasRemaining()) {
                j(this.klP);
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
        if (this.klP.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.klP.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.klP.capacity() + byteBuffer.remaining());
                this.klP.flip();
                allocate.put(this.klP);
                this.klP = allocate;
            }
            this.klP.put(byteBuffer);
            this.klP.flip();
            byteBuffer2 = this.klP;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.klP.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.klP = ByteBuffer.allocate(preferedSize);
                this.klP.put(byteBuffer);
            } else {
                this.klP.position(this.klP.limit());
                this.klP.limit(this.klP.capacity());
            }
        }
        if (this.klO == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.klN) {
                    Draft cKB = draft.cKB();
                    try {
                        cKB.a(this.klO);
                        byteBuffer2.reset();
                        o = cKB.o(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(o instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) o;
                        if (cKB.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.klU = aVar.getResourceDescriptor();
                            try {
                                eJ(cKB.a(cKB.a(aVar, this.klI.onWebsocketHandshakeReceivedAsServer(this, cKB, aVar)), this.klO));
                                this.draft = cKB;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.klI.onWebsocketError(this, e4);
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
                k(1002, "wrong http function", false);
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
        if (this.klO == WebSocket.Role.CLIENT) {
            this.draft.a(this.klO);
            f o3 = this.draft.o(byteBuffer2);
            if (!(o3 instanceof h)) {
                k(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) o3;
            if (this.draft.a(this.klQ, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.klI.onWebsocketHandshakeReceivedAsClient(this, this.klQ, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.klI.onWebsocketError(this, e6);
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

    private void j(ByteBuffer byteBuffer) {
        try {
            for (Framedata framedata : this.draft.n(byteBuffer)) {
                if (DEBUG) {
                    System.out.println("matched frame: " + framedata);
                }
                this.draft.a(this, framedata);
            }
        } catch (InvalidDataException e) {
            this.klI.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        k(Ef(404));
        k(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        k(Ef(500));
        k(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer Ef(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.GO("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void i(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.klM != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    k(i, str, false);
                } else {
                    if (this.draft.cKA() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.klI.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.klI.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.klI.onWebsocketError(this, e2);
                                k(PointerIconCompat.TYPE_CELL, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.cKL();
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
            this.klP = null;
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
            if (this.klJ != null) {
                this.klJ.cancel();
            }
            if (this.klK != null) {
                try {
                    this.klK.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.klI.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.klI.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.klI.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.klQ = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void X(int i, boolean z) {
        j(i, "", z);
    }

    public void closeConnection(int i, String str) {
        j(i, str, false);
    }

    public synchronized void k(int i, String str, boolean z) {
        if (!this.klL) {
            this.klS = Integer.valueOf(i);
            this.klR = str;
            this.klT = Boolean.valueOf(z);
            this.klL = true;
            this.klI.onWriteDemand(this);
            try {
                this.klI.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.klI.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.klQ = null;
        }
    }

    public void cKw() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            X(-1, true);
        } else if (this.klL) {
            j(this.klS.intValue(), this.klR, this.klT.booleanValue());
        } else if (this.draft.cKA() == Draft.CloseHandshakeType.NONE) {
            X(1000, true);
        } else if (this.draft.cKA() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.klO == WebSocket.Role.SERVER) {
                X(PointerIconCompat.TYPE_CELL, true);
            } else {
                X(1000, true);
            }
        } else {
            X(PointerIconCompat.TYPE_CELL, true);
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
        l(this.draft.aB(str, this.klO == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        l(this.draft.b(byteBuffer, this.klO == WebSocket.Role.CLIENT));
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
        eJ(arrayList);
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
        if (this.klX == null) {
            this.klX = new g();
        }
        sendFrame(this.klX);
    }

    public boolean hasBufferedData() {
        return !this.klG.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.klQ = this.draft.b(bVar);
        this.klU = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.klU == null) {
            throw new AssertionError();
        }
        try {
            this.klI.onWebsocketHandshakeSentAsClient(this, this.klQ);
            eJ(this.draft.a(this.klQ, this.klO));
        } catch (RuntimeException e) {
            this.klI.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void k(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.klG.add(byteBuffer);
        this.klI.onWriteDemand(this);
    }

    private void eJ(List<ByteBuffer> list) {
        synchronized (this.klW) {
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
            this.klI.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.klI.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.klL || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.klL;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.klM;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.klM = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.klI.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.klI.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long cKx() {
        return this.klV;
    }

    public void cKy() {
        this.klV = System.currentTimeMillis();
    }

    public d cKz() {
        return this.klI;
    }

    public <T> T getAttachment() {
        return (T) this.klY;
    }

    public <T> void setAttachment(T t) {
        this.klY = t;
    }
}
