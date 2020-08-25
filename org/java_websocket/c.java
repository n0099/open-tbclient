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
/* loaded from: classes7.dex */
public class c implements WebSocket {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static boolean DEBUG;
    public static int oCh;
    private Draft draft;
    private Object oCA;
    public final BlockingQueue<ByteBuffer> oCi;
    public final BlockingQueue<ByteBuffer> oCj;
    private final d oCk;
    public SelectionKey oCl;
    public ByteChannel oCm;
    private List<Draft> oCp;
    private WebSocket.Role oCq;
    private g oCz;
    private volatile boolean oCn = false;
    private WebSocket.READYSTATE oCo = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer oCr = ByteBuffer.allocate(0);
    private org.java_websocket.c.a oCs = null;
    private String oCt = null;
    private Integer oCu = null;
    private Boolean oCv = null;
    private String oCw = null;
    private long oCx = System.currentTimeMillis();
    private final Object oCy = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        oCh = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.oCq == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.oCi = new LinkedBlockingQueue();
        this.oCj = new LinkedBlockingQueue();
        this.oCk = dVar;
        this.oCq = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.ejf();
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
            if (!$assertionsDisabled && this.oCr.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                t(byteBuffer);
            } else if (this.oCr.hasRemaining()) {
                t(this.oCr);
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
        if (this.oCr.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.oCr.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.oCr.capacity() + byteBuffer.remaining());
                this.oCr.flip();
                allocate.put(this.oCr);
                this.oCr = allocate;
            }
            this.oCr.put(byteBuffer);
            this.oCr.flip();
            byteBuffer2 = this.oCr;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.oCr.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.oCr = ByteBuffer.allocate(preferedSize);
                this.oCr.put(byteBuffer);
            } else {
                this.oCr.position(this.oCr.limit());
                this.oCr.limit(this.oCr.capacity());
            }
        }
        if (this.oCq == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.oCp) {
                    Draft ejf = draft.ejf();
                    try {
                        ejf.a(this.oCq);
                        byteBuffer2.reset();
                        y = ejf.y(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(y instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) y;
                        if (ejf.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.oCw = aVar.getResourceDescriptor();
                            try {
                                write(ejf.a(ejf.a(aVar, this.oCk.onWebsocketHandshakeReceivedAsServer(this, ejf, aVar)), this.oCq));
                                this.draft = ejf;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.oCk.onWebsocketError(this, e4);
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
            f y2 = this.draft.y(byteBuffer2);
            if (!(y2 instanceof org.java_websocket.c.a)) {
                p(1002, "wrong http function", false);
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
        if (this.oCq == WebSocket.Role.CLIENT) {
            this.draft.a(this.oCq);
            f y3 = this.draft.y(byteBuffer2);
            if (!(y3 instanceof h)) {
                p(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) y3;
            if (this.draft.a(this.oCs, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.oCk.onWebsocketHandshakeReceivedAsClient(this, this.oCs, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.oCk.onWebsocketError(this, e6);
                    p(-1, e6.getMessage(), false);
                    return false;
                } catch (InvalidDataException e7) {
                    p(e7.getCloseCode(), e7.getMessage(), false);
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
            this.oCk.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        u(Oo(404));
        p(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        u(Oo(500));
        p(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer Oo(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.Uw("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void n(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.oCo != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    p(i, str, false);
                } else {
                    if (this.draft.eje() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.oCk.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.oCk.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.oCk.onWebsocketError(this, e2);
                                p(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.ejp();
                            sendFrame(bVar);
                        }
                    }
                    p(i, str, z);
                }
            } else if (i == -3) {
                if (!$assertionsDisabled && !z) {
                    throw new AssertionError();
                }
                p(-3, str, true);
            } else if (i == 1002) {
                p(i, str, z);
            } else {
                p(-1, str, false);
            }
            a(WebSocket.READYSTATE.CLOSING);
            this.oCr = null;
        }
    }

    public void close(int i, String str) {
        n(i, str, false);
    }

    public synchronized void o(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN && i == 1006) {
                a(WebSocket.READYSTATE.CLOSING);
            }
            if (this.oCl != null) {
                this.oCl.cancel();
            }
            if (this.oCm != null) {
                try {
                    this.oCm.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.oCk.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.oCk.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.oCk.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.oCs = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void al(int i, boolean z) {
        o(i, "", z);
    }

    public void closeConnection(int i, String str) {
        o(i, str, false);
    }

    public synchronized void p(int i, String str, boolean z) {
        if (!this.oCn) {
            this.oCu = Integer.valueOf(i);
            this.oCt = str;
            this.oCv = Boolean.valueOf(z);
            this.oCn = true;
            this.oCk.onWriteDemand(this);
            try {
                this.oCk.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.oCk.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.oCs = null;
        }
    }

    public void eja() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            al(-1, true);
        } else if (this.oCn) {
            o(this.oCu.intValue(), this.oCt, this.oCv.booleanValue());
        } else if (this.draft.eje() == Draft.CloseHandshakeType.NONE) {
            al(1000, true);
        } else if (this.draft.eje() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.oCq == WebSocket.Role.SERVER) {
                al(1006, true);
            } else {
                al(1000, true);
            }
        } else {
            al(1006, true);
        }
    }

    public void close(int i) {
        n(i, "", false);
    }

    public void b(InvalidDataException invalidDataException) {
        n(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    public void send(String str) throws WebsocketNotConnectedException {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        t(this.draft.bg(str, this.oCq == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        t(this.draft.b(byteBuffer, this.oCq == WebSocket.Role.CLIENT));
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
        if (this.oCz == null) {
            this.oCz = new g();
        }
        sendFrame(this.oCz);
    }

    public boolean hasBufferedData() {
        return !this.oCi.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.oCs = this.draft.b(bVar);
        this.oCw = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.oCw == null) {
            throw new AssertionError();
        }
        try {
            this.oCk.onWebsocketHandshakeSentAsClient(this, this.oCs);
            write(this.draft.a(this.oCs, this.oCq));
        } catch (RuntimeException e) {
            this.oCk.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void u(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.oCi.add(byteBuffer);
        this.oCk.onWriteDemand(this);
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.oCy) {
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
            this.oCk.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.oCk.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.oCn || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.oCn;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.oCo;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.oCo = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.oCk.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.oCk.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long ejb() {
        return this.oCx;
    }

    public void ejc() {
        this.oCx = System.currentTimeMillis();
    }

    public d ejd() {
        return this.oCk;
    }

    public <T> T getAttachment() {
        return (T) this.oCA;
    }

    public <T> void setAttachment(T t) {
        this.oCA = t;
    }
}
