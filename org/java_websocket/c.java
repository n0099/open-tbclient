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
    public static int klI;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> klJ;
    public final BlockingQueue<ByteBuffer> klK;
    private final d klL;
    public SelectionKey klM;
    public ByteChannel klN;
    private List<Draft> klQ;
    private WebSocket.Role klR;
    private g kma;
    private Object kmb;
    private volatile boolean klO = false;
    private WebSocket.READYSTATE klP = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer klS = ByteBuffer.allocate(0);
    private org.java_websocket.c.a klT = null;
    private String klU = null;
    private Integer klV = null;
    private Boolean klW = null;
    private String klX = null;
    private long klY = System.currentTimeMillis();
    private final Object klZ = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        klI = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.klR == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.klJ = new LinkedBlockingQueue();
        this.klK = new LinkedBlockingQueue();
        this.klL = dVar;
        this.klR = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.cKA();
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
            if (!$assertionsDisabled && this.klS.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                j(byteBuffer);
            } else if (this.klS.hasRemaining()) {
                j(this.klS);
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
        if (this.klS.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.klS.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.klS.capacity() + byteBuffer.remaining());
                this.klS.flip();
                allocate.put(this.klS);
                this.klS = allocate;
            }
            this.klS.put(byteBuffer);
            this.klS.flip();
            byteBuffer2 = this.klS;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.klS.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.klS = ByteBuffer.allocate(preferedSize);
                this.klS.put(byteBuffer);
            } else {
                this.klS.position(this.klS.limit());
                this.klS.limit(this.klS.capacity());
            }
        }
        if (this.klR == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.klQ) {
                    Draft cKA = draft.cKA();
                    try {
                        cKA.a(this.klR);
                        byteBuffer2.reset();
                        o = cKA.o(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(o instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) o;
                        if (cKA.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.klX = aVar.getResourceDescriptor();
                            try {
                                eJ(cKA.a(cKA.a(aVar, this.klL.onWebsocketHandshakeReceivedAsServer(this, cKA, aVar)), this.klR));
                                this.draft = cKA;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.klL.onWebsocketError(this, e4);
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
        if (this.klR == WebSocket.Role.CLIENT) {
            this.draft.a(this.klR);
            f o3 = this.draft.o(byteBuffer2);
            if (!(o3 instanceof h)) {
                k(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) o3;
            if (this.draft.a(this.klT, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.klL.onWebsocketHandshakeReceivedAsClient(this, this.klT, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.klL.onWebsocketError(this, e6);
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
            this.klL.onWebsocketError(this, e);
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
        return ByteBuffer.wrap(org.java_websocket.e.c.GQ("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void i(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.klP != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    k(i, str, false);
                } else {
                    if (this.draft.cKz() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.klL.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.klL.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.klL.onWebsocketError(this, e2);
                                k(PointerIconCompat.TYPE_CELL, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.cKK();
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
            this.klS = null;
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
            if (this.klM != null) {
                this.klM.cancel();
            }
            if (this.klN != null) {
                try {
                    this.klN.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.klL.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.klL.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.klL.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.klT = null;
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
        if (!this.klO) {
            this.klV = Integer.valueOf(i);
            this.klU = str;
            this.klW = Boolean.valueOf(z);
            this.klO = true;
            this.klL.onWriteDemand(this);
            try {
                this.klL.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.klL.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.klT = null;
        }
    }

    public void cKv() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            X(-1, true);
        } else if (this.klO) {
            j(this.klV.intValue(), this.klU, this.klW.booleanValue());
        } else if (this.draft.cKz() == Draft.CloseHandshakeType.NONE) {
            X(1000, true);
        } else if (this.draft.cKz() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.klR == WebSocket.Role.SERVER) {
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
        l(this.draft.aB(str, this.klR == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        l(this.draft.b(byteBuffer, this.klR == WebSocket.Role.CLIENT));
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
        if (this.kma == null) {
            this.kma = new g();
        }
        sendFrame(this.kma);
    }

    public boolean hasBufferedData() {
        return !this.klJ.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.klT = this.draft.b(bVar);
        this.klX = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.klX == null) {
            throw new AssertionError();
        }
        try {
            this.klL.onWebsocketHandshakeSentAsClient(this, this.klT);
            eJ(this.draft.a(this.klT, this.klR));
        } catch (RuntimeException e) {
            this.klL.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void k(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.klJ.add(byteBuffer);
        this.klL.onWriteDemand(this);
    }

    private void eJ(List<ByteBuffer> list) {
        synchronized (this.klZ) {
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
            this.klL.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.klL.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.klO || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.klO;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.klP;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.klP = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.klL.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.klL.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long cKw() {
        return this.klY;
    }

    public void cKx() {
        this.klY = System.currentTimeMillis();
    }

    public d cKy() {
        return this.klL;
    }

    public <T> T getAttachment() {
        return (T) this.kmb;
    }

    public <T> void setAttachment(T t) {
        this.kmb = t;
    }
}
