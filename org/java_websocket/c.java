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
    public static int iDZ;
    private static final Object iEq;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> iEa;
    public final BlockingQueue<ByteBuffer> iEb;
    private final d iEc;
    public SelectionKey iEd;
    public ByteChannel iEe;
    private List<Draft> iEh;
    private WebSocket.Role iEi;
    private g iEr;
    private Object iEs;
    private volatile boolean iEf = false;
    private WebSocket.READYSTATE iEg = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer iEj = ByteBuffer.allocate(0);
    private org.java_websocket.c.a iEk = null;
    private String iEl = null;
    private Integer iEm = null;
    private Boolean iEn = null;
    private String iEo = null;
    private long iEp = System.currentTimeMillis();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        iDZ = 16384;
        DEBUG = false;
        iEq = new Object();
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.iEi == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.iEa = new LinkedBlockingQueue();
        this.iEb = new LinkedBlockingQueue();
        this.iEc = dVar;
        this.iEi = WebSocket.Role.CLIENT;
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
            if (!$assertionsDisabled && this.iEj.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                m(byteBuffer);
            } else if (this.iEj.hasRemaining()) {
                m(this.iEj);
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
        if (this.iEj.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.iEj.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.iEj.capacity() + byteBuffer.remaining());
                this.iEj.flip();
                allocate.put(this.iEj);
                this.iEj = allocate;
            }
            this.iEj.put(byteBuffer);
            this.iEj.flip();
            byteBuffer2 = this.iEj;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.iEj.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.iEj = ByteBuffer.allocate(preferedSize);
                this.iEj.put(byteBuffer);
            } else {
                this.iEj.position(this.iEj.limit());
                this.iEj.limit(this.iEj.capacity());
            }
        }
        if (this.iEi == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.iEh) {
                    Draft cdM = draft.cdM();
                    try {
                        cdM.a(this.iEi);
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
                            this.iEo = aVar.getResourceDescriptor();
                            try {
                                eA(cdM.a(cdM.a(aVar, this.iEc.onWebsocketHandshakeReceivedAsServer(this, cdM, aVar)), this.iEi));
                                this.draft = cdM;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.iEc.onWebsocketError(this, e4);
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
        if (this.iEi == WebSocket.Role.CLIENT) {
            this.draft.a(this.iEi);
            f r3 = this.draft.r(byteBuffer2);
            if (!(r3 instanceof h)) {
                k(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) r3;
            if (this.draft.a(this.iEk, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.iEc.onWebsocketHandshakeReceivedAsClient(this, this.iEk, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.iEc.onWebsocketError(this, e6);
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
            this.iEc.onWebsocketError(this, e);
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
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.iEg != WebSocket.READYSTATE.CLOSED) {
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
                                    this.iEc.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.iEc.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.iEc.onWebsocketError(this, e2);
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
            this.iEj = null;
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
            if (this.iEd != null) {
                this.iEd.cancel();
            }
            if (this.iEe != null) {
                try {
                    this.iEe.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.iEc.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.iEc.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.iEc.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.iEk = null;
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
        if (!this.iEf) {
            this.iEm = Integer.valueOf(i);
            this.iEl = str;
            this.iEn = Boolean.valueOf(z);
            this.iEf = true;
            this.iEc.onWriteDemand(this);
            try {
                this.iEc.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.iEc.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.iEk = null;
        }
    }

    public void cdH() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            M(-1, true);
        } else if (this.iEf) {
            j(this.iEm.intValue(), this.iEl, this.iEn.booleanValue());
        } else if (this.draft.cdL() == Draft.CloseHandshakeType.NONE) {
            M(1000, true);
        } else if (this.draft.cdL() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.iEi == WebSocket.Role.SERVER) {
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
        l(this.draft.ai(str, this.iEi == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        l(this.draft.b(byteBuffer, this.iEi == WebSocket.Role.CLIENT));
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
        if (this.iEr == null) {
            this.iEr = new g();
        }
        sendFrame(this.iEr);
    }

    public boolean hasBufferedData() {
        return !this.iEa.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        if (!$assertionsDisabled && getReadyState() == WebSocket.READYSTATE.CONNECTING) {
            throw new AssertionError("shall only be called once");
        }
        this.iEk = this.draft.b(bVar);
        this.iEo = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.iEo == null) {
            throw new AssertionError();
        }
        try {
            this.iEc.onWebsocketHandshakeSentAsClient(this, this.iEk);
            eA(this.draft.a(this.iEk, this.iEi));
        } catch (RuntimeException e) {
            this.iEc.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void n(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.iEa.add(byteBuffer);
        this.iEc.onWriteDemand(this);
    }

    private void eA(List<ByteBuffer> list) {
        synchronized (iEq) {
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
            this.iEc.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.iEc.onWebsocketError(this, e);
        }
    }

    public boolean isConnecting() {
        if ($assertionsDisabled || !this.iEf || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
            return getReadyState() == WebSocket.READYSTATE.CONNECTING;
        }
        throw new AssertionError();
    }

    public boolean isOpen() {
        if (!$assertionsDisabled && getReadyState() == WebSocket.READYSTATE.OPEN && this.iEf) {
            throw new AssertionError();
        }
        return getReadyState() == WebSocket.READYSTATE.OPEN;
    }

    public boolean isClosing() {
        return getReadyState() == WebSocket.READYSTATE.CLOSING;
    }

    public boolean isFlushAndClose() {
        return this.iEf;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.iEg;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.iEg = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.iEc.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.iEc.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long cdI() {
        return this.iEp;
    }

    public void cdJ() {
        this.iEp = System.currentTimeMillis();
    }

    public d cdK() {
        return this.iEc;
    }

    public <T> T getAttachment() {
        return (T) this.iEs;
    }

    public <T> void setAttachment(T t) {
        this.iEs = t;
    }
}
