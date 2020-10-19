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
    public static int pbu;
    private Draft draft;
    private List<Draft> pbC;
    private WebSocket.Role pbD;
    private g pbM;
    private Object pbN;
    public final BlockingQueue<ByteBuffer> pbv;
    public final BlockingQueue<ByteBuffer> pbw;
    private final d pbx;
    public SelectionKey pby;
    public ByteChannel pbz;
    private volatile boolean pbA = false;
    private WebSocket.READYSTATE pbB = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer pbE = ByteBuffer.allocate(0);
    private org.java_websocket.c.a pbF = null;
    private String pbG = null;
    private Integer pbH = null;
    private Boolean pbI = null;
    private String pbJ = null;
    private long pbK = System.currentTimeMillis();
    private final Object pbL = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        pbu = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.pbD == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.pbv = new LinkedBlockingQueue();
        this.pbw = new LinkedBlockingQueue();
        this.pbx = dVar;
        this.pbD = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.eqX();
        }
    }

    public void t(ByteBuffer byteBuffer) {
        if (!$assertionsDisabled && !byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
        if (DEBUG) {
            System.out.println("process(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining())) + '}');
        }
        if (getReadyState() != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                v(byteBuffer);
            }
        } else if (u(byteBuffer) && !isClosing() && !isClosed()) {
            if (!$assertionsDisabled && this.pbE.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                v(byteBuffer);
            } else if (this.pbE.hasRemaining()) {
                v(this.pbE);
            }
        }
        if (!$assertionsDisabled && !isClosing() && !isFlushAndClose() && byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
    }

    private boolean u(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        f A;
        boolean z;
        if (this.pbE.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.pbE.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.pbE.capacity() + byteBuffer.remaining());
                this.pbE.flip();
                allocate.put(this.pbE);
                this.pbE = allocate;
            }
            this.pbE.put(byteBuffer);
            this.pbE.flip();
            byteBuffer2 = this.pbE;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.pbE.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.pbE = ByteBuffer.allocate(preferedSize);
                this.pbE.put(byteBuffer);
            } else {
                this.pbE.position(this.pbE.limit());
                this.pbE.limit(this.pbE.capacity());
            }
        }
        if (this.pbD == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.pbC) {
                    Draft eqX = draft.eqX();
                    try {
                        eqX.a(this.pbD);
                        byteBuffer2.reset();
                        A = eqX.A(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(A instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) A;
                        if (eqX.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.pbJ = aVar.getResourceDescriptor();
                            try {
                                write(eqX.a(eqX.a(aVar, this.pbx.onWebsocketHandshakeReceivedAsServer(this, eqX, aVar)), this.pbD));
                                this.draft = eqX;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.pbx.onWebsocketError(this, e4);
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
            f A2 = this.draft.A(byteBuffer2);
            if (!(A2 instanceof org.java_websocket.c.a)) {
                r(1002, "wrong http function", false);
                return false;
            }
            org.java_websocket.c.a aVar2 = (org.java_websocket.c.a) A2;
            if (this.draft.a(aVar2) == Draft.HandshakeState.MATCHED) {
                a(aVar2);
                return true;
            }
            close(1002, "the handshake did finaly not match");
            return false;
        }
        if (this.pbD == WebSocket.Role.CLIENT) {
            this.draft.a(this.pbD);
            f A3 = this.draft.A(byteBuffer2);
            if (!(A3 instanceof h)) {
                r(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) A3;
            if (this.draft.a(this.pbF, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.pbx.onWebsocketHandshakeReceivedAsClient(this, this.pbF, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.pbx.onWebsocketError(this, e6);
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

    private void v(ByteBuffer byteBuffer) {
        try {
            for (Framedata framedata : this.draft.z(byteBuffer)) {
                if (DEBUG) {
                    System.out.println("matched frame: " + framedata);
                }
                this.draft.a(this, framedata);
            }
        } catch (InvalidDataException e) {
            this.pbx.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        w(Pz(404));
        r(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        w(Pz(500));
        r(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer Pz(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.VM("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void p(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.pbB != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    r(i, str, false);
                } else {
                    if (this.draft.eqW() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.pbx.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.pbx.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.pbx.onWebsocketError(this, e2);
                                r(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.erh();
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
            this.pbE = null;
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
            if (this.pby != null) {
                this.pby.cancel();
            }
            if (this.pbz != null) {
                try {
                    this.pbz.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.pbx.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.pbx.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.pbx.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.pbF = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void ao(int i, boolean z) {
        q(i, "", z);
    }

    public void closeConnection(int i, String str) {
        q(i, str, false);
    }

    public synchronized void r(int i, String str, boolean z) {
        if (!this.pbA) {
            this.pbH = Integer.valueOf(i);
            this.pbG = str;
            this.pbI = Boolean.valueOf(z);
            this.pbA = true;
            this.pbx.onWriteDemand(this);
            try {
                this.pbx.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.pbx.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.pbF = null;
        }
    }

    public void eqS() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            ao(-1, true);
        } else if (this.pbA) {
            q(this.pbH.intValue(), this.pbG, this.pbI.booleanValue());
        } else if (this.draft.eqW() == Draft.CloseHandshakeType.NONE) {
            ao(1000, true);
        } else if (this.draft.eqW() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.pbD == WebSocket.Role.SERVER) {
                ao(1006, true);
            } else {
                ao(1000, true);
            }
        } else {
            ao(1006, true);
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
        t(this.draft.bl(str, this.pbD == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        t(this.draft.b(byteBuffer, this.pbD == WebSocket.Role.CLIENT));
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
        if (this.pbM == null) {
            this.pbM = new g();
        }
        sendFrame(this.pbM);
    }

    public boolean hasBufferedData() {
        return !this.pbv.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.pbF = this.draft.b(bVar);
        this.pbJ = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.pbJ == null) {
            throw new AssertionError();
        }
        try {
            this.pbx.onWebsocketHandshakeSentAsClient(this, this.pbF);
            write(this.draft.a(this.pbF, this.pbD));
        } catch (RuntimeException e) {
            this.pbx.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void w(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.pbv.add(byteBuffer);
        this.pbx.onWriteDemand(this);
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.pbL) {
            for (ByteBuffer byteBuffer : list) {
                w(byteBuffer);
            }
        }
    }

    private void a(f fVar) {
        if (DEBUG) {
            System.out.println("open using draft: " + this.draft);
        }
        a(WebSocket.READYSTATE.OPEN);
        try {
            this.pbx.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.pbx.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.pbA || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.pbA;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.pbB;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.pbB = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.pbx.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.pbx.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long eqT() {
        return this.pbK;
    }

    public void eqU() {
        this.pbK = System.currentTimeMillis();
    }

    public d eqV() {
        return this.pbx;
    }

    public <T> T getAttachment() {
        return (T) this.pbN;
    }

    public <T> void setAttachment(T t) {
        this.pbN = t;
    }
}
