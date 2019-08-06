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
    public static int kun;
    private Draft draft;
    private g kuF;
    private Object kuG;
    public final BlockingQueue<ByteBuffer> kuo;
    public final BlockingQueue<ByteBuffer> kup;
    private final d kuq;
    public SelectionKey kur;
    public ByteChannel kus;
    private List<Draft> kuv;
    private WebSocket.Role kuw;
    private volatile boolean kut = false;
    private WebSocket.READYSTATE kuu = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer kux = ByteBuffer.allocate(0);
    private org.java_websocket.c.a kuy = null;
    private String kuz = null;
    private Integer kuA = null;
    private Boolean kuB = null;
    private String kuC = null;
    private long kuD = System.currentTimeMillis();
    private final Object kuE = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        kun = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.kuw == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.kuo = new LinkedBlockingQueue();
        this.kup = new LinkedBlockingQueue();
        this.kuq = dVar;
        this.kuw = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.cOJ();
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
            if (!$assertionsDisabled && this.kux.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                j(byteBuffer);
            } else if (this.kux.hasRemaining()) {
                j(this.kux);
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
        if (this.kux.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.kux.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.kux.capacity() + byteBuffer.remaining());
                this.kux.flip();
                allocate.put(this.kux);
                this.kux = allocate;
            }
            this.kux.put(byteBuffer);
            this.kux.flip();
            byteBuffer2 = this.kux;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.kux.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.kux = ByteBuffer.allocate(preferedSize);
                this.kux.put(byteBuffer);
            } else {
                this.kux.position(this.kux.limit());
                this.kux.limit(this.kux.capacity());
            }
        }
        if (this.kuw == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.kuv) {
                    Draft cOJ = draft.cOJ();
                    try {
                        cOJ.a(this.kuw);
                        byteBuffer2.reset();
                        o = cOJ.o(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(o instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) o;
                        if (cOJ.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.kuC = aVar.getResourceDescriptor();
                            try {
                                eL(cOJ.a(cOJ.a(aVar, this.kuq.onWebsocketHandshakeReceivedAsServer(this, cOJ, aVar)), this.kuw));
                                this.draft = cOJ;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.kuq.onWebsocketError(this, e4);
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
        if (this.kuw == WebSocket.Role.CLIENT) {
            this.draft.a(this.kuw);
            f o3 = this.draft.o(byteBuffer2);
            if (!(o3 instanceof h)) {
                m(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) o3;
            if (this.draft.a(this.kuy, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.kuq.onWebsocketHandshakeReceivedAsClient(this, this.kuy, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.kuq.onWebsocketError(this, e6);
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
            this.kuq.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        k(EQ(404));
        m(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        k(EQ(500));
        m(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer EQ(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.HL("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void k(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.kuu != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    m(i, str, false);
                } else {
                    if (this.draft.cOI() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.kuq.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.kuq.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.kuq.onWebsocketError(this, e2);
                                m(PointerIconCompat.TYPE_CELL, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.cOT();
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
            this.kux = null;
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
            if (this.kur != null) {
                this.kur.cancel();
            }
            if (this.kus != null) {
                try {
                    this.kus.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.kuq.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.kuq.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.kuq.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.kuy = null;
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
        if (!this.kut) {
            this.kuA = Integer.valueOf(i);
            this.kuz = str;
            this.kuB = Boolean.valueOf(z);
            this.kut = true;
            this.kuq.onWriteDemand(this);
            try {
                this.kuq.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.kuq.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.kuy = null;
        }
    }

    public void cOE() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            Z(-1, true);
        } else if (this.kut) {
            l(this.kuA.intValue(), this.kuz, this.kuB.booleanValue());
        } else if (this.draft.cOI() == Draft.CloseHandshakeType.NONE) {
            Z(1000, true);
        } else if (this.draft.cOI() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.kuw == WebSocket.Role.SERVER) {
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
        l(this.draft.aF(str, this.kuw == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        l(this.draft.b(byteBuffer, this.kuw == WebSocket.Role.CLIENT));
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
        if (this.kuF == null) {
            this.kuF = new g();
        }
        sendFrame(this.kuF);
    }

    public boolean hasBufferedData() {
        return !this.kuo.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.kuy = this.draft.b(bVar);
        this.kuC = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.kuC == null) {
            throw new AssertionError();
        }
        try {
            this.kuq.onWebsocketHandshakeSentAsClient(this, this.kuy);
            eL(this.draft.a(this.kuy, this.kuw));
        } catch (RuntimeException e) {
            this.kuq.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void k(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.kuo.add(byteBuffer);
        this.kuq.onWriteDemand(this);
    }

    private void eL(List<ByteBuffer> list) {
        synchronized (this.kuE) {
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
            this.kuq.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.kuq.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.kut || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.kut;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.kuu;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.kuu = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.kuq.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.kuq.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long cOF() {
        return this.kuD;
    }

    public void cOG() {
        this.kuD = System.currentTimeMillis();
    }

    public d cOH() {
        return this.kuq;
    }

    public <T> T getAttachment() {
        return (T) this.kuG;
    }

    public <T> void setAttachment(T t) {
        this.kuG = t;
    }
}
