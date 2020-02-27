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
    public static int nLS;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> nLT;
    public final BlockingQueue<ByteBuffer> nLU;
    private final d nLV;
    public SelectionKey nLW;
    public ByteChannel nLX;
    private List<Draft> nMa;
    private WebSocket.Role nMb;
    private g nMk;
    private Object nMl;
    private volatile boolean nLY = false;
    private WebSocket.READYSTATE nLZ = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer nMc = ByteBuffer.allocate(0);
    private org.java_websocket.c.a nMd = null;
    private String nMe = null;
    private Integer nMf = null;
    private Boolean nMg = null;
    private String nMh = null;
    private long nMi = System.currentTimeMillis();
    private final Object nMj = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        nLS = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.nMb == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.nLT = new LinkedBlockingQueue();
        this.nLU = new LinkedBlockingQueue();
        this.nLV = dVar;
        this.nMb = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.dNm();
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
            if (!$assertionsDisabled && this.nMc.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                n(byteBuffer);
            } else if (this.nMc.hasRemaining()) {
                n(this.nMc);
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
        if (this.nMc.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.nMc.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.nMc.capacity() + byteBuffer.remaining());
                this.nMc.flip();
                allocate.put(this.nMc);
                this.nMc = allocate;
            }
            this.nMc.put(byteBuffer);
            this.nMc.flip();
            byteBuffer2 = this.nMc;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.nMc.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.nMc = ByteBuffer.allocate(preferedSize);
                this.nMc.put(byteBuffer);
            } else {
                this.nMc.position(this.nMc.limit());
                this.nMc.limit(this.nMc.capacity());
            }
        }
        if (this.nMb == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.nMa) {
                    Draft dNm = draft.dNm();
                    try {
                        dNm.a(this.nMb);
                        byteBuffer2.reset();
                        s = dNm.s(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(s instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) s;
                        if (dNm.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.nMh = aVar.getResourceDescriptor();
                            try {
                                write(dNm.a(dNm.a(aVar, this.nLV.onWebsocketHandshakeReceivedAsServer(this, dNm, aVar)), this.nMb));
                                this.draft = dNm;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.nLV.onWebsocketError(this, e4);
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
        if (this.nMb == WebSocket.Role.CLIENT) {
            this.draft.a(this.nMb);
            f s3 = this.draft.s(byteBuffer2);
            if (!(s3 instanceof h)) {
                p(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) s3;
            if (this.draft.a(this.nMd, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.nLV.onWebsocketHandshakeReceivedAsClient(this, this.nMd, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.nLV.onWebsocketError(this, e6);
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
            this.nLV.onWebsocketError(this, e);
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
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.nLZ != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    p(i, str, false);
                } else {
                    if (this.draft.dNl() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.nLV.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.nLV.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.nLV.onWebsocketError(this, e2);
                                p(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.dNw();
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
            this.nMc = null;
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
            if (this.nLW != null) {
                this.nLW.cancel();
            }
            if (this.nLX != null) {
                try {
                    this.nLX.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.nLV.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.nLV.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.nLV.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.nMd = null;
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
        if (!this.nLY) {
            this.nMf = Integer.valueOf(i);
            this.nMe = str;
            this.nMg = Boolean.valueOf(z);
            this.nLY = true;
            this.nLV.onWriteDemand(this);
            try {
                this.nLV.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.nLV.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.nMd = null;
        }
    }

    public void dNh() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            ag(-1, true);
        } else if (this.nLY) {
            o(this.nMf.intValue(), this.nMe, this.nMg.booleanValue());
        } else if (this.draft.dNl() == Draft.CloseHandshakeType.NONE) {
            ag(1000, true);
        } else if (this.draft.dNl() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.nMb == WebSocket.Role.SERVER) {
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
        p(this.draft.aU(str, this.nMb == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        p(this.draft.b(byteBuffer, this.nMb == WebSocket.Role.CLIENT));
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
        if (this.nMk == null) {
            this.nMk = new g();
        }
        sendFrame(this.nMk);
    }

    public boolean hasBufferedData() {
        return !this.nLT.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.nMd = this.draft.b(bVar);
        this.nMh = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.nMh == null) {
            throw new AssertionError();
        }
        try {
            this.nLV.onWebsocketHandshakeSentAsClient(this, this.nMd);
            write(this.draft.a(this.nMd, this.nMb));
        } catch (RuntimeException e) {
            this.nLV.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void o(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.nLT.add(byteBuffer);
        this.nLV.onWriteDemand(this);
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.nMj) {
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
            this.nLV.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.nLV.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.nLY || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.nLY;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.nLZ;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.nLZ = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.nLV.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.nLV.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long dNi() {
        return this.nMi;
    }

    public void dNj() {
        this.nMi = System.currentTimeMillis();
    }

    public d dNk() {
        return this.nLV;
    }

    public <T> T getAttachment() {
        return (T) this.nMl;
    }

    public <T> void setAttachment(T t) {
        this.nMl = t;
    }
}
