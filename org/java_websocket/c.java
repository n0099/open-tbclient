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
    public static int nLU;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> nLV;
    public final BlockingQueue<ByteBuffer> nLW;
    private final d nLX;
    public SelectionKey nLY;
    public ByteChannel nLZ;
    private List<Draft> nMc;
    private WebSocket.Role nMd;
    private g nMm;
    private Object nMn;
    private volatile boolean nMa = false;
    private WebSocket.READYSTATE nMb = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer nMe = ByteBuffer.allocate(0);
    private org.java_websocket.c.a nMf = null;
    private String nMg = null;
    private Integer nMh = null;
    private Boolean nMi = null;
    private String nMj = null;
    private long nMk = System.currentTimeMillis();
    private final Object nMl = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        nLU = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.nMd == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.nLV = new LinkedBlockingQueue();
        this.nLW = new LinkedBlockingQueue();
        this.nLX = dVar;
        this.nMd = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.dNo();
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
            if (!$assertionsDisabled && this.nMe.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                n(byteBuffer);
            } else if (this.nMe.hasRemaining()) {
                n(this.nMe);
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
        if (this.nMe.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.nMe.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.nMe.capacity() + byteBuffer.remaining());
                this.nMe.flip();
                allocate.put(this.nMe);
                this.nMe = allocate;
            }
            this.nMe.put(byteBuffer);
            this.nMe.flip();
            byteBuffer2 = this.nMe;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.nMe.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.nMe = ByteBuffer.allocate(preferedSize);
                this.nMe.put(byteBuffer);
            } else {
                this.nMe.position(this.nMe.limit());
                this.nMe.limit(this.nMe.capacity());
            }
        }
        if (this.nMd == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.nMc) {
                    Draft dNo = draft.dNo();
                    try {
                        dNo.a(this.nMd);
                        byteBuffer2.reset();
                        s = dNo.s(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(s instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) s;
                        if (dNo.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.nMj = aVar.getResourceDescriptor();
                            try {
                                write(dNo.a(dNo.a(aVar, this.nLX.onWebsocketHandshakeReceivedAsServer(this, dNo, aVar)), this.nMd));
                                this.draft = dNo;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.nLX.onWebsocketError(this, e4);
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
        if (this.nMd == WebSocket.Role.CLIENT) {
            this.draft.a(this.nMd);
            f s3 = this.draft.s(byteBuffer2);
            if (!(s3 instanceof h)) {
                p(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) s3;
            if (this.draft.a(this.nMf, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.nLX.onWebsocketHandshakeReceivedAsClient(this, this.nMf, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.nLX.onWebsocketError(this, e6);
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
            this.nLX.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        o(NX(404));
        p(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        o(NX(500));
        p(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer NX(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.OU("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void n(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.nMb != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    p(i, str, false);
                } else {
                    if (this.draft.dNn() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.nLX.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.nLX.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.nLX.onWebsocketError(this, e2);
                                p(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.dNy();
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
            this.nMe = null;
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
            if (this.nLY != null) {
                this.nLY.cancel();
            }
            if (this.nLZ != null) {
                try {
                    this.nLZ.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.nLX.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.nLX.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.nLX.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.nMf = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void ag(int i, boolean z) {
        o(i, "", z);
    }

    public void closeConnection(int i, String str) {
        o(i, str, false);
    }

    public synchronized void p(int i, String str, boolean z) {
        if (!this.nMa) {
            this.nMh = Integer.valueOf(i);
            this.nMg = str;
            this.nMi = Boolean.valueOf(z);
            this.nMa = true;
            this.nLX.onWriteDemand(this);
            try {
                this.nLX.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.nLX.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.nMf = null;
        }
    }

    public void dNj() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            ag(-1, true);
        } else if (this.nMa) {
            o(this.nMh.intValue(), this.nMg, this.nMi.booleanValue());
        } else if (this.draft.dNn() == Draft.CloseHandshakeType.NONE) {
            ag(1000, true);
        } else if (this.draft.dNn() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.nMd == WebSocket.Role.SERVER) {
                ag(1006, true);
            } else {
                ag(1000, true);
            }
        } else {
            ag(1006, true);
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
        p(this.draft.aU(str, this.nMd == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        p(this.draft.b(byteBuffer, this.nMd == WebSocket.Role.CLIENT));
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
        write(arrayList);
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
        if (this.nMm == null) {
            this.nMm = new g();
        }
        sendFrame(this.nMm);
    }

    public boolean hasBufferedData() {
        return !this.nLV.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.nMf = this.draft.b(bVar);
        this.nMj = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.nMj == null) {
            throw new AssertionError();
        }
        try {
            this.nLX.onWebsocketHandshakeSentAsClient(this, this.nMf);
            write(this.draft.a(this.nMf, this.nMd));
        } catch (RuntimeException e) {
            this.nLX.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void o(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.nLV.add(byteBuffer);
        this.nLX.onWriteDemand(this);
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.nMl) {
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
            this.nLX.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.nLX.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.nMa || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.nMa;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.nMb;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.nMb = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.nLX.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.nLX.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long dNk() {
        return this.nMk;
    }

    public void dNl() {
        this.nMk = System.currentTimeMillis();
    }

    public d dNm() {
        return this.nLX;
    }

    public <T> T getAttachment() {
        return (T) this.nMn;
    }

    public <T> void setAttachment(T t) {
        this.nMn = t;
    }
}
