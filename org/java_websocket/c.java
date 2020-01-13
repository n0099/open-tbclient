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
/* loaded from: classes5.dex */
public class c implements WebSocket {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static boolean DEBUG;
    public static int nKY;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> nKZ;
    public final BlockingQueue<ByteBuffer> nLa;
    private final d nLb;
    public SelectionKey nLc;
    public ByteChannel nLd;
    private List<Draft> nLg;
    private WebSocket.Role nLh;
    private g nLq;
    private Object nLr;
    private volatile boolean nLe = false;
    private WebSocket.READYSTATE nLf = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer nLi = ByteBuffer.allocate(0);
    private org.java_websocket.c.a nLj = null;
    private String nLk = null;
    private Integer nLl = null;
    private Boolean nLm = null;
    private String nLn = null;
    private long nLo = System.currentTimeMillis();
    private final Object nLp = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        nKY = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.nLh == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.nKZ = new LinkedBlockingQueue();
        this.nLa = new LinkedBlockingQueue();
        this.nLb = dVar;
        this.nLh = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.dLX();
        }
    }

    public void l(ByteBuffer byteBuffer) {
        if (!$assertionsDisabled && !byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
        if (DEBUG) {
            System.out.println("process(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining())) + '}');
        }
        if (getReadyState() != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                n(byteBuffer);
            }
        } else if (m(byteBuffer) && !isClosing() && !isClosed()) {
            if (!$assertionsDisabled && this.nLi.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                n(byteBuffer);
            } else if (this.nLi.hasRemaining()) {
                n(this.nLi);
            }
        }
        if (!$assertionsDisabled && !isClosing() && !isFlushAndClose() && byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
    }

    private boolean m(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        f s;
        boolean z;
        if (this.nLi.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.nLi.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.nLi.capacity() + byteBuffer.remaining());
                this.nLi.flip();
                allocate.put(this.nLi);
                this.nLi = allocate;
            }
            this.nLi.put(byteBuffer);
            this.nLi.flip();
            byteBuffer2 = this.nLi;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.nLi.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.nLi = ByteBuffer.allocate(preferedSize);
                this.nLi.put(byteBuffer);
            } else {
                this.nLi.position(this.nLi.limit());
                this.nLi.limit(this.nLi.capacity());
            }
        }
        if (this.nLh == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.nLg) {
                    Draft dLX = draft.dLX();
                    try {
                        dLX.a(this.nLh);
                        byteBuffer2.reset();
                        s = dLX.s(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(s instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) s;
                        if (dLX.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.nLn = aVar.getResourceDescriptor();
                            try {
                                fF(dLX.a(dLX.a(aVar, this.nLb.onWebsocketHandshakeReceivedAsServer(this, dLX, aVar)), this.nLh));
                                this.draft = dLX;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.nLb.onWebsocketError(this, e4);
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
            f s2 = this.draft.s(byteBuffer2);
            if (!(s2 instanceof org.java_websocket.c.a)) {
                p(1002, "wrong http function", false);
                return false;
            }
            org.java_websocket.c.a aVar2 = (org.java_websocket.c.a) s2;
            if (this.draft.a(aVar2) == Draft.HandshakeState.MATCHED) {
                a(aVar2);
                return true;
            }
            close(1002, "the handshake did finaly not match");
            return false;
        }
        if (this.nLh == WebSocket.Role.CLIENT) {
            this.draft.a(this.nLh);
            f s3 = this.draft.s(byteBuffer2);
            if (!(s3 instanceof h)) {
                p(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) s3;
            if (this.draft.a(this.nLj, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.nLb.onWebsocketHandshakeReceivedAsClient(this, this.nLj, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.nLb.onWebsocketError(this, e6);
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

    private void n(ByteBuffer byteBuffer) {
        try {
            for (Framedata framedata : this.draft.r(byteBuffer)) {
                if (DEBUG) {
                    System.out.println("matched frame: " + framedata);
                }
                this.draft.a(this, framedata);
            }
        } catch (InvalidDataException e) {
            this.nLb.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        o(NU(404));
        p(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        o(NU(500));
        p(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer NU(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.OH("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void n(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.nLf != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    p(i, str, false);
                } else {
                    if (this.draft.dLW() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.nLb.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.nLb.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.nLb.onWebsocketError(this, e2);
                                p(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.dMh();
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
            this.nLi = null;
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
            if (this.nLc != null) {
                this.nLc.cancel();
            }
            if (this.nLd != null) {
                try {
                    this.nLd.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.nLb.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.nLb.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.nLb.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.nLj = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void ah(int i, boolean z) {
        o(i, "", z);
    }

    public void closeConnection(int i, String str) {
        o(i, str, false);
    }

    public synchronized void p(int i, String str, boolean z) {
        if (!this.nLe) {
            this.nLl = Integer.valueOf(i);
            this.nLk = str;
            this.nLm = Boolean.valueOf(z);
            this.nLe = true;
            this.nLb.onWriteDemand(this);
            try {
                this.nLb.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.nLb.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.nLj = null;
        }
    }

    public void dLS() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            ah(-1, true);
        } else if (this.nLe) {
            o(this.nLl.intValue(), this.nLk, this.nLm.booleanValue());
        } else if (this.draft.dLW() == Draft.CloseHandshakeType.NONE) {
            ah(1000, true);
        } else if (this.draft.dLW() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.nLh == WebSocket.Role.SERVER) {
                ah(1006, true);
            } else {
                ah(1000, true);
            }
        } else {
            ah(1006, true);
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
        p(this.draft.aU(str, this.nLh == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        p(this.draft.b(byteBuffer, this.nLh == WebSocket.Role.CLIENT));
    }

    public void send(byte[] bArr) throws IllegalArgumentException, WebsocketNotConnectedException {
        send(ByteBuffer.wrap(bArr));
    }

    private void p(Collection<Framedata> collection) {
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
        fF(arrayList);
    }

    public void sendFragmentedFrame(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        p(this.draft.a(opcode, byteBuffer, z));
    }

    public void sendFrame(Collection<Framedata> collection) {
        p(collection);
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        p(Collections.singletonList(framedata));
    }

    public void sendPing() throws NotYetConnectedException {
        if (this.nLq == null) {
            this.nLq = new g();
        }
        sendFrame(this.nLq);
    }

    public boolean hasBufferedData() {
        return !this.nKZ.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.nLj = this.draft.b(bVar);
        this.nLn = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.nLn == null) {
            throw new AssertionError();
        }
        try {
            this.nLb.onWebsocketHandshakeSentAsClient(this, this.nLj);
            fF(this.draft.a(this.nLj, this.nLh));
        } catch (RuntimeException e) {
            this.nLb.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void o(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.nKZ.add(byteBuffer);
        this.nLb.onWriteDemand(this);
    }

    private void fF(List<ByteBuffer> list) {
        synchronized (this.nLp) {
            for (ByteBuffer byteBuffer : list) {
                o(byteBuffer);
            }
        }
    }

    private void a(f fVar) {
        if (DEBUG) {
            System.out.println("open using draft: " + this.draft);
        }
        a(WebSocket.READYSTATE.OPEN);
        try {
            this.nLb.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.nLb.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.nLe || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.nLe;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.nLf;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.nLf = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.nLb.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.nLb.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long dLT() {
        return this.nLo;
    }

    public void dLU() {
        this.nLo = System.currentTimeMillis();
    }

    public d dLV() {
        return this.nLb;
    }

    public <T> T getAttachment() {
        return (T) this.nLr;
    }

    public <T> void setAttachment(T t) {
        this.nLr = t;
    }
}
