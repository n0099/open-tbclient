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
/* loaded from: classes4.dex */
public class c implements WebSocket {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static boolean DEBUG;
    public static int qqY;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> qqZ;
    public final BlockingQueue<ByteBuffer> qra;
    private final d qrb;
    public SelectionKey qrc;
    public ByteChannel qrd;
    private List<Draft> qrg;
    private WebSocket.Role qrh;
    private g qrq;
    private Object qrr;
    private volatile boolean qre = false;
    private WebSocket.READYSTATE qrf = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer qri = ByteBuffer.allocate(0);
    private org.java_websocket.c.a qrj = null;
    private String qrk = null;
    private Integer qrl = null;
    private Boolean qrm = null;
    private String qrn = null;
    private long qro = System.currentTimeMillis();
    private final Object qrp = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        qqY = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.qrh == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.qqZ = new LinkedBlockingQueue();
        this.qra = new LinkedBlockingQueue();
        this.qrb = dVar;
        this.qrh = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.eNx();
        }
    }

    public void r(ByteBuffer byteBuffer) {
        if (!$assertionsDisabled && !byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
        if (DEBUG) {
            System.out.println("process(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining())) + '}');
        }
        if (getReadyState() != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                t(byteBuffer);
            }
        } else if (s(byteBuffer) && !isClosing() && !isClosed()) {
            if (!$assertionsDisabled && this.qri.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                t(byteBuffer);
            } else if (this.qri.hasRemaining()) {
                t(this.qri);
            }
        }
        if (!$assertionsDisabled && !isClosing() && !isFlushAndClose() && byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
    }

    private boolean s(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        f y;
        boolean z;
        if (this.qri.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.qri.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.qri.capacity() + byteBuffer.remaining());
                this.qri.flip();
                allocate.put(this.qri);
                this.qri = allocate;
            }
            this.qri.put(byteBuffer);
            this.qri.flip();
            byteBuffer2 = this.qri;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.qri.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.qri = ByteBuffer.allocate(preferedSize);
                this.qri.put(byteBuffer);
            } else {
                this.qri.position(this.qri.limit());
                this.qri.limit(this.qri.capacity());
            }
        }
        if (this.qrh == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.qrg) {
                    Draft eNx = draft.eNx();
                    try {
                        eNx.a(this.qrh);
                        byteBuffer2.reset();
                        y = eNx.y(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(y instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) y;
                        if (eNx.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.qrn = aVar.getResourceDescriptor();
                            try {
                                write(eNx.a(eNx.a(aVar, this.qrb.onWebsocketHandshakeReceivedAsServer(this, eNx, aVar)), this.qrh));
                                this.draft = eNx;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.qrb.onWebsocketError(this, e4);
                                b(e4);
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
            f y2 = this.draft.y(byteBuffer2);
            if (!(y2 instanceof org.java_websocket.c.a)) {
                s(1002, "wrong http function", false);
                return false;
            }
            org.java_websocket.c.a aVar2 = (org.java_websocket.c.a) y2;
            if (this.draft.a(aVar2) == Draft.HandshakeState.MATCHED) {
                a(aVar2);
                return true;
            }
            close(1002, "the handshake did finaly not match");
            return false;
        }
        if (this.qrh == WebSocket.Role.CLIENT) {
            this.draft.a(this.qrh);
            f y3 = this.draft.y(byteBuffer2);
            if (!(y3 instanceof h)) {
                s(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) y3;
            if (this.draft.a(this.qrj, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.qrb.onWebsocketHandshakeReceivedAsClient(this, this.qrj, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.qrb.onWebsocketError(this, e6);
                    s(-1, e6.getMessage(), false);
                    return false;
                } catch (InvalidDataException e7) {
                    s(e7.getCloseCode(), e7.getMessage(), false);
                    return false;
                }
            }
            close(1002, "draft " + this.draft + " refuses handshake");
        }
        return false;
    }

    private void t(ByteBuffer byteBuffer) {
        try {
            for (Framedata framedata : this.draft.x(byteBuffer)) {
                if (DEBUG) {
                    System.out.println("matched frame: " + framedata);
                }
                this.draft.a(this, framedata);
            }
        } catch (InvalidDataException e) {
            this.qrb.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        u(TQ(404));
        s(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void b(RuntimeException runtimeException) {
        u(TQ(500));
        s(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer TQ(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.Zt("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void q(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.qrf != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    s(i, str, false);
                } else {
                    if (this.draft.eNw() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.qrb.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.qrb.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.qrb.onWebsocketError(this, e2);
                                s(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.eNH();
                            sendFrame(bVar);
                        }
                    }
                    s(i, str, z);
                }
            } else if (i == -3) {
                if (!$assertionsDisabled && !z) {
                    throw new AssertionError();
                }
                s(-3, str, true);
            } else if (i == 1002) {
                s(i, str, z);
            } else {
                s(-1, str, false);
            }
            a(WebSocket.READYSTATE.CLOSING);
            this.qri = null;
        }
    }

    public void close(int i, String str) {
        q(i, str, false);
    }

    public synchronized void r(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN && i == 1006) {
                a(WebSocket.READYSTATE.CLOSING);
            }
            if (this.qrc != null) {
                this.qrc.cancel();
            }
            if (this.qrd != null) {
                try {
                    this.qrd.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.qrb.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.qrb.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.qrb.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.qrj = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void ap(int i, boolean z) {
        r(i, "", z);
    }

    public void closeConnection(int i, String str) {
        r(i, str, false);
    }

    public synchronized void s(int i, String str, boolean z) {
        if (!this.qre) {
            this.qrl = Integer.valueOf(i);
            this.qrk = str;
            this.qrm = Boolean.valueOf(z);
            this.qre = true;
            this.qrb.onWriteDemand(this);
            try {
                this.qrb.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.qrb.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.qrj = null;
        }
    }

    public void eNs() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            ap(-1, true);
        } else if (this.qre) {
            r(this.qrl.intValue(), this.qrk, this.qrm.booleanValue());
        } else if (this.draft.eNw() == Draft.CloseHandshakeType.NONE) {
            ap(1000, true);
        } else if (this.draft.eNw() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.qrh == WebSocket.Role.SERVER) {
                ap(1006, true);
            } else {
                ap(1000, true);
            }
        } else {
            ap(1006, true);
        }
    }

    public void close(int i) {
        q(i, "", false);
    }

    public void b(InvalidDataException invalidDataException) {
        q(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    public void send(String str) throws WebsocketNotConnectedException {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        s(this.draft.bp(str, this.qrh == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        s(this.draft.b(byteBuffer, this.qrh == WebSocket.Role.CLIENT));
    }

    public void send(byte[] bArr) throws IllegalArgumentException, WebsocketNotConnectedException {
        send(ByteBuffer.wrap(bArr));
    }

    private void s(Collection<Framedata> collection) {
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
        s(this.draft.a(opcode, byteBuffer, z));
    }

    public void sendFrame(Collection<Framedata> collection) {
        s(collection);
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        s(Collections.singletonList(framedata));
    }

    public void sendPing() throws NotYetConnectedException {
        if (this.qrq == null) {
            this.qrq = new g();
        }
        sendFrame(this.qrq);
    }

    public boolean hasBufferedData() {
        return !this.qqZ.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.qrj = this.draft.b(bVar);
        this.qrn = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.qrn == null) {
            throw new AssertionError();
        }
        try {
            this.qrb.onWebsocketHandshakeSentAsClient(this, this.qrj);
            write(this.draft.a(this.qrj, this.qrh));
        } catch (RuntimeException e) {
            this.qrb.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void u(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.qqZ.add(byteBuffer);
        this.qrb.onWriteDemand(this);
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.qrp) {
            for (ByteBuffer byteBuffer : list) {
                u(byteBuffer);
            }
        }
    }

    private void a(f fVar) {
        if (DEBUG) {
            System.out.println("open using draft: " + this.draft);
        }
        a(WebSocket.READYSTATE.OPEN);
        try {
            this.qrb.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.qrb.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.qre || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.qre;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.qrf;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.qrf = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.qrb.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.qrb.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long eNt() {
        return this.qro;
    }

    public void eNu() {
        this.qro = System.currentTimeMillis();
    }

    public d eNv() {
        return this.qrb;
    }

    public <T> T getAttachment() {
        return (T) this.qrr;
    }

    public <T> void setAttachment(T t) {
        this.qrr = t;
    }
}
