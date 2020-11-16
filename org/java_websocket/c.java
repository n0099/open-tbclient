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
/* loaded from: classes18.dex */
public class c implements WebSocket {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static boolean DEBUG;
    public static int qdK;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> qdL;
    public final BlockingQueue<ByteBuffer> qdM;
    private final d qdN;
    public SelectionKey qdO;
    public ByteChannel qdP;
    private List<Draft> qdS;
    private WebSocket.Role qdT;
    private g qec;
    private Object qed;
    private volatile boolean qdQ = false;
    private WebSocket.READYSTATE qdR = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer qdU = ByteBuffer.allocate(0);
    private org.java_websocket.c.a qdV = null;
    private String qdW = null;
    private Integer qdX = null;
    private Boolean qdY = null;
    private String qdZ = null;
    private long qea = System.currentTimeMillis();
    private final Object qeb = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        qdK = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.qdT == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.qdL = new LinkedBlockingQueue();
        this.qdM = new LinkedBlockingQueue();
        this.qdN = dVar;
        this.qdT = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.eEL();
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
            if (!$assertionsDisabled && this.qdU.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                u(byteBuffer);
            } else if (this.qdU.hasRemaining()) {
                u(this.qdU);
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
        if (this.qdU.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.qdU.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.qdU.capacity() + byteBuffer.remaining());
                this.qdU.flip();
                allocate.put(this.qdU);
                this.qdU = allocate;
            }
            this.qdU.put(byteBuffer);
            this.qdU.flip();
            byteBuffer2 = this.qdU;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.qdU.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.qdU = ByteBuffer.allocate(preferedSize);
                this.qdU.put(byteBuffer);
            } else {
                this.qdU.position(this.qdU.limit());
                this.qdU.limit(this.qdU.capacity());
            }
        }
        if (this.qdT == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.qdS) {
                    Draft eEL = draft.eEL();
                    try {
                        eEL.a(this.qdT);
                        byteBuffer2.reset();
                        z = eEL.z(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(z instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z2 = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) z;
                        if (eEL.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.qdZ = aVar.getResourceDescriptor();
                            try {
                                write(eEL.a(eEL.a(aVar, this.qdN.onWebsocketHandshakeReceivedAsServer(this, eEL, aVar)), this.qdT));
                                this.draft = eEL;
                                a(aVar);
                                z2 = true;
                            } catch (RuntimeException e4) {
                                this.qdN.onWebsocketError(this, e4);
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
        if (this.qdT == WebSocket.Role.CLIENT) {
            this.draft.a(this.qdT);
            f z4 = this.draft.z(byteBuffer2);
            if (!(z4 instanceof h)) {
                r(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) z4;
            if (this.draft.a(this.qdV, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.qdN.onWebsocketHandshakeReceivedAsClient(this, this.qdV, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.qdN.onWebsocketError(this, e6);
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
            this.qdN.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        v(So(404));
        r(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        v(So(500));
        r(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer So(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.XO("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void p(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.qdR != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    r(i, str, false);
                } else {
                    if (this.draft.eEK() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.qdN.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.qdN.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.qdN.onWebsocketError(this, e2);
                                r(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.eEV();
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
            this.qdU = null;
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
            if (this.qdO != null) {
                this.qdO.cancel();
            }
            if (this.qdP != null) {
                try {
                    this.qdP.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.qdN.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.qdN.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.qdN.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.qdV = null;
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
        if (!this.qdQ) {
            this.qdX = Integer.valueOf(i);
            this.qdW = str;
            this.qdY = Boolean.valueOf(z);
            this.qdQ = true;
            this.qdN.onWriteDemand(this);
            try {
                this.qdN.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.qdN.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.qdV = null;
        }
    }

    public void eEG() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            ar(-1, true);
        } else if (this.qdQ) {
            q(this.qdX.intValue(), this.qdW, this.qdY.booleanValue());
        } else if (this.draft.eEK() == Draft.CloseHandshakeType.NONE) {
            ar(1000, true);
        } else if (this.draft.eEK() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.qdT == WebSocket.Role.SERVER) {
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
        t(this.draft.bt(str, this.qdT == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        t(this.draft.b(byteBuffer, this.qdT == WebSocket.Role.CLIENT));
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
        if (this.qec == null) {
            this.qec = new g();
        }
        sendFrame(this.qec);
    }

    public boolean hasBufferedData() {
        return !this.qdL.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.qdV = this.draft.b(bVar);
        this.qdZ = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.qdZ == null) {
            throw new AssertionError();
        }
        try {
            this.qdN.onWebsocketHandshakeSentAsClient(this, this.qdV);
            write(this.draft.a(this.qdV, this.qdT));
        } catch (RuntimeException e) {
            this.qdN.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void v(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.qdL.add(byteBuffer);
        this.qdN.onWriteDemand(this);
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.qeb) {
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
            this.qdN.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.qdN.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.qdQ || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.qdQ;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.qdR;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.qdR = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.qdN.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.qdN.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long eEH() {
        return this.qea;
    }

    public void eEI() {
        this.qea = System.currentTimeMillis();
    }

    public d eEJ() {
        return this.qdN;
    }

    public <T> T getAttachment() {
        return (T) this.qed;
    }

    public <T> void setAttachment(T t) {
        this.qed = t;
    }
}
