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
    public static int iDY;
    private static final Object iEp;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> iDZ;
    public final BlockingQueue<ByteBuffer> iEa;
    private final d iEb;
    public SelectionKey iEc;
    public ByteChannel iEd;
    private List<Draft> iEg;
    private WebSocket.Role iEh;
    private g iEq;
    private Object iEr;
    private volatile boolean iEe = false;
    private WebSocket.READYSTATE iEf = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer iEi = ByteBuffer.allocate(0);
    private org.java_websocket.c.a iEj = null;
    private String iEk = null;
    private Integer iEl = null;
    private Boolean iEm = null;
    private String iEn = null;
    private long iEo = System.currentTimeMillis();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        iDY = 16384;
        DEBUG = false;
        iEp = new Object();
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.iEh == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.iDZ = new LinkedBlockingQueue();
        this.iEa = new LinkedBlockingQueue();
        this.iEb = dVar;
        this.iEh = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.cdM();
        }
    }

    public void k(ByteBuffer byteBuffer) {
        if (!$assertionsDisabled && !byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
        if (DEBUG) {
            System.out.println("process(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining())) + '}');
        }
        if (getReadyState() != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                m(byteBuffer);
            }
        } else if (l(byteBuffer) && !isClosing() && !isClosed()) {
            if (!$assertionsDisabled && this.iEi.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                m(byteBuffer);
            } else if (this.iEi.hasRemaining()) {
                m(this.iEi);
            }
        }
        if (!$assertionsDisabled && !isClosing() && !isFlushAndClose() && byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
    }

    private boolean l(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        f r;
        boolean z;
        if (this.iEi.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.iEi.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.iEi.capacity() + byteBuffer.remaining());
                this.iEi.flip();
                allocate.put(this.iEi);
                this.iEi = allocate;
            }
            this.iEi.put(byteBuffer);
            this.iEi.flip();
            byteBuffer2 = this.iEi;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.iEi.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.iEi = ByteBuffer.allocate(preferedSize);
                this.iEi.put(byteBuffer);
            } else {
                this.iEi.position(this.iEi.limit());
                this.iEi.limit(this.iEi.capacity());
            }
        }
        if (this.iEh == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.iEg) {
                    Draft cdM = draft.cdM();
                    try {
                        cdM.a(this.iEh);
                        byteBuffer2.reset();
                        r = cdM.r(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(r instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) r;
                        if (cdM.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.iEn = aVar.getResourceDescriptor();
                            try {
                                eA(cdM.a(cdM.a(aVar, this.iEb.onWebsocketHandshakeReceivedAsServer(this, cdM, aVar)), this.iEh));
                                this.draft = cdM;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.iEb.onWebsocketError(this, e4);
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
            f r2 = this.draft.r(byteBuffer2);
            if (!(r2 instanceof org.java_websocket.c.a)) {
                k(1002, "wrong http function", false);
                return false;
            }
            org.java_websocket.c.a aVar2 = (org.java_websocket.c.a) r2;
            if (this.draft.a(aVar2) == Draft.HandshakeState.MATCHED) {
                a(aVar2);
                return true;
            }
            close(1002, "the handshake did finaly not match");
            return false;
        }
        if (this.iEh == WebSocket.Role.CLIENT) {
            this.draft.a(this.iEh);
            f r3 = this.draft.r(byteBuffer2);
            if (!(r3 instanceof h)) {
                k(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) r3;
            if (this.draft.a(this.iEj, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.iEb.onWebsocketHandshakeReceivedAsClient(this, this.iEj, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.iEb.onWebsocketError(this, e6);
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

    private void m(ByteBuffer byteBuffer) {
        try {
            for (Framedata framedata : this.draft.q(byteBuffer)) {
                if (DEBUG) {
                    System.out.println("matched frame: " + framedata);
                }
                this.draft.a(this, framedata);
            }
        } catch (InvalidDataException e) {
            this.iEb.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        n(zA(404));
        k(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        n(zA(500));
        k(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer zA(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.zA("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void i(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.iEf != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    k(i, str, false);
                } else {
                    if (this.draft.cdL() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.iEb.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.iEb.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.iEb.onWebsocketError(this, e2);
                                k(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.cdW();
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
            this.iEi = null;
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
            if (this.iEc != null) {
                this.iEc.cancel();
            }
            if (this.iEd != null) {
                try {
                    this.iEd.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.iEb.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.iEb.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.iEb.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.iEj = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void M(int i, boolean z) {
        j(i, "", z);
    }

    public void closeConnection(int i, String str) {
        j(i, str, false);
    }

    public synchronized void k(int i, String str, boolean z) {
        if (!this.iEe) {
            this.iEl = Integer.valueOf(i);
            this.iEk = str;
            this.iEm = Boolean.valueOf(z);
            this.iEe = true;
            this.iEb.onWriteDemand(this);
            try {
                this.iEb.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.iEb.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.iEj = null;
        }
    }

    public void cdH() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            M(-1, true);
        } else if (this.iEe) {
            j(this.iEl.intValue(), this.iEk, this.iEm.booleanValue());
        } else if (this.draft.cdL() == Draft.CloseHandshakeType.NONE) {
            M(1000, true);
        } else if (this.draft.cdL() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.iEh == WebSocket.Role.SERVER) {
                M(1006, true);
            } else {
                M(1000, true);
            }
        } else {
            M(1006, true);
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
        l(this.draft.ai(str, this.iEh == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        l(this.draft.b(byteBuffer, this.iEh == WebSocket.Role.CLIENT));
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
        eA(arrayList);
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
        if (this.iEq == null) {
            this.iEq = new g();
        }
        sendFrame(this.iEq);
    }

    public boolean hasBufferedData() {
        return !this.iDZ.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        if (!$assertionsDisabled && getReadyState() == WebSocket.READYSTATE.CONNECTING) {
            throw new AssertionError("shall only be called once");
        }
        this.iEj = this.draft.b(bVar);
        this.iEn = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.iEn == null) {
            throw new AssertionError();
        }
        try {
            this.iEb.onWebsocketHandshakeSentAsClient(this, this.iEj);
            eA(this.draft.a(this.iEj, this.iEh));
        } catch (RuntimeException e) {
            this.iEb.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void n(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.iDZ.add(byteBuffer);
        this.iEb.onWriteDemand(this);
    }

    private void eA(List<ByteBuffer> list) {
        synchronized (iEp) {
            for (ByteBuffer byteBuffer : list) {
                n(byteBuffer);
            }
        }
    }

    private void a(f fVar) {
        if (DEBUG) {
            System.out.println("open using draft: " + this.draft);
        }
        a(WebSocket.READYSTATE.OPEN);
        try {
            this.iEb.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.iEb.onWebsocketError(this, e);
        }
    }

    public boolean isConnecting() {
        if ($assertionsDisabled || !this.iEe || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
            return getReadyState() == WebSocket.READYSTATE.CONNECTING;
        }
        throw new AssertionError();
    }

    public boolean isOpen() {
        if (!$assertionsDisabled && getReadyState() == WebSocket.READYSTATE.OPEN && this.iEe) {
            throw new AssertionError();
        }
        return getReadyState() == WebSocket.READYSTATE.OPEN;
    }

    public boolean isClosing() {
        return getReadyState() == WebSocket.READYSTATE.CLOSING;
    }

    public boolean isFlushAndClose() {
        return this.iEe;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.iEf;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.iEf = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.iEb.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.iEb.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long cdI() {
        return this.iEo;
    }

    public void cdJ() {
        this.iEo = System.currentTimeMillis();
    }

    public d cdK() {
        return this.iEb;
    }

    public <T> T getAttachment() {
        return (T) this.iEr;
    }

    public <T> void setAttachment(T t) {
        this.iEr = t;
    }
}
