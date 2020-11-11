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
    public static int qch;
    private Draft draft;
    private Object qcA;
    public final BlockingQueue<ByteBuffer> qci;
    public final BlockingQueue<ByteBuffer> qcj;
    private final d qck;
    public SelectionKey qcl;
    public ByteChannel qcm;
    private List<Draft> qcp;
    private WebSocket.Role qcq;
    private g qcz;
    private volatile boolean qcn = false;
    private WebSocket.READYSTATE qco = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer qcr = ByteBuffer.allocate(0);
    private org.java_websocket.c.a qcs = null;
    private String qct = null;
    private Integer qcu = null;
    private Boolean qcv = null;
    private String qcw = null;
    private long qcx = System.currentTimeMillis();
    private final Object qcy = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        qch = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.qcq == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.qci = new LinkedBlockingQueue();
        this.qcj = new LinkedBlockingQueue();
        this.qck = dVar;
        this.qcq = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.eEK();
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
            if (!$assertionsDisabled && this.qcr.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                u(byteBuffer);
            } else if (this.qcr.hasRemaining()) {
                u(this.qcr);
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
        if (this.qcr.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.qcr.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.qcr.capacity() + byteBuffer.remaining());
                this.qcr.flip();
                allocate.put(this.qcr);
                this.qcr = allocate;
            }
            this.qcr.put(byteBuffer);
            this.qcr.flip();
            byteBuffer2 = this.qcr;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.qcr.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.qcr = ByteBuffer.allocate(preferedSize);
                this.qcr.put(byteBuffer);
            } else {
                this.qcr.position(this.qcr.limit());
                this.qcr.limit(this.qcr.capacity());
            }
        }
        if (this.qcq == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.qcp) {
                    Draft eEK = draft.eEK();
                    try {
                        eEK.a(this.qcq);
                        byteBuffer2.reset();
                        z = eEK.z(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(z instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z2 = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) z;
                        if (eEK.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.qcw = aVar.getResourceDescriptor();
                            try {
                                write(eEK.a(eEK.a(aVar, this.qck.onWebsocketHandshakeReceivedAsServer(this, eEK, aVar)), this.qcq));
                                this.draft = eEK;
                                a(aVar);
                                z2 = true;
                            } catch (RuntimeException e4) {
                                this.qck.onWebsocketError(this, e4);
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
        if (this.qcq == WebSocket.Role.CLIENT) {
            this.draft.a(this.qcq);
            f z4 = this.draft.z(byteBuffer2);
            if (!(z4 instanceof h)) {
                r(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) z4;
            if (this.draft.a(this.qcs, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.qck.onWebsocketHandshakeReceivedAsClient(this, this.qcs, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.qck.onWebsocketError(this, e6);
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
            this.qck.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        v(RL(404));
        r(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        v(RL(500));
        r(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer RL(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.Yd("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void p(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.qco != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    r(i, str, false);
                } else {
                    if (this.draft.eEJ() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.qck.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.qck.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.qck.onWebsocketError(this, e2);
                                r(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.eEU();
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
            this.qcr = null;
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
            if (this.qcl != null) {
                this.qcl.cancel();
            }
            if (this.qcm != null) {
                try {
                    this.qcm.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.qck.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.qck.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.qck.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.qcs = null;
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
        if (!this.qcn) {
            this.qcu = Integer.valueOf(i);
            this.qct = str;
            this.qcv = Boolean.valueOf(z);
            this.qcn = true;
            this.qck.onWriteDemand(this);
            try {
                this.qck.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.qck.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.qcs = null;
        }
    }

    public void eEF() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            ar(-1, true);
        } else if (this.qcn) {
            q(this.qcu.intValue(), this.qct, this.qcv.booleanValue());
        } else if (this.draft.eEJ() == Draft.CloseHandshakeType.NONE) {
            ar(1000, true);
        } else if (this.draft.eEJ() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.qcq == WebSocket.Role.SERVER) {
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
        t(this.draft.bt(str, this.qcq == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        t(this.draft.b(byteBuffer, this.qcq == WebSocket.Role.CLIENT));
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
        if (this.qcz == null) {
            this.qcz = new g();
        }
        sendFrame(this.qcz);
    }

    public boolean hasBufferedData() {
        return !this.qci.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.qcs = this.draft.b(bVar);
        this.qcw = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.qcw == null) {
            throw new AssertionError();
        }
        try {
            this.qck.onWebsocketHandshakeSentAsClient(this, this.qcs);
            write(this.draft.a(this.qcs, this.qcq));
        } catch (RuntimeException e) {
            this.qck.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void v(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.qci.add(byteBuffer);
        this.qck.onWriteDemand(this);
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.qcy) {
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
            this.qck.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.qck.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.qcn || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.qcn;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.qco;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.qco = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.qck.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.qck.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long eEG() {
        return this.qcx;
    }

    public void eEH() {
        this.qcx = System.currentTimeMillis();
    }

    public d eEI() {
        return this.qck;
    }

    public <T> T getAttachment() {
        return (T) this.qcA;
    }

    public <T> void setAttachment(T t) {
        this.qcA = t;
    }
}
