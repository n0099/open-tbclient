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
    public static int nNS;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> nNT;
    public final BlockingQueue<ByteBuffer> nNU;
    private final d nNV;
    public SelectionKey nNW;
    public ByteChannel nNX;
    private List<Draft> nOa;
    private WebSocket.Role nOb;
    private g nOk;
    private Object nOl;
    private volatile boolean nNY = false;
    private WebSocket.READYSTATE nNZ = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer nOc = ByteBuffer.allocate(0);
    private org.java_websocket.c.a nOd = null;
    private String nOe = null;
    private Integer nOf = null;
    private Boolean nOg = null;
    private String nOh = null;
    private long nOi = System.currentTimeMillis();
    private final Object nOj = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        nNS = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.nOb == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.nNT = new LinkedBlockingQueue();
        this.nNU = new LinkedBlockingQueue();
        this.nNV = dVar;
        this.nOb = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.dNP();
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
            if (!$assertionsDisabled && this.nOc.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                n(byteBuffer);
            } else if (this.nOc.hasRemaining()) {
                n(this.nOc);
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
        if (this.nOc.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.nOc.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.nOc.capacity() + byteBuffer.remaining());
                this.nOc.flip();
                allocate.put(this.nOc);
                this.nOc = allocate;
            }
            this.nOc.put(byteBuffer);
            this.nOc.flip();
            byteBuffer2 = this.nOc;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.nOc.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.nOc = ByteBuffer.allocate(preferedSize);
                this.nOc.put(byteBuffer);
            } else {
                this.nOc.position(this.nOc.limit());
                this.nOc.limit(this.nOc.capacity());
            }
        }
        if (this.nOb == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.nOa) {
                    Draft dNP = draft.dNP();
                    try {
                        dNP.a(this.nOb);
                        byteBuffer2.reset();
                        s = dNP.s(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(s instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) s;
                        if (dNP.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.nOh = aVar.getResourceDescriptor();
                            try {
                                write(dNP.a(dNP.a(aVar, this.nNV.onWebsocketHandshakeReceivedAsServer(this, dNP, aVar)), this.nOb));
                                this.draft = dNP;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.nNV.onWebsocketError(this, e4);
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
        if (this.nOb == WebSocket.Role.CLIENT) {
            this.draft.a(this.nOb);
            f s3 = this.draft.s(byteBuffer2);
            if (!(s3 instanceof h)) {
                p(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) s3;
            if (this.draft.a(this.nOd, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.nNV.onWebsocketHandshakeReceivedAsClient(this, this.nOd, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.nNV.onWebsocketError(this, e6);
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
            this.nNV.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        o(Od(404));
        p(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        o(Od(500));
        p(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer Od(int i) {
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
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.nNZ != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    p(i, str, false);
                } else {
                    if (this.draft.dNO() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.nNV.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.nNV.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.nNV.onWebsocketError(this, e2);
                                p(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.dNZ();
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
            this.nOc = null;
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
            if (this.nNW != null) {
                this.nNW.cancel();
            }
            if (this.nNX != null) {
                try {
                    this.nNX.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.nNV.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.nNV.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.nNV.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.nOd = null;
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
        if (!this.nNY) {
            this.nOf = Integer.valueOf(i);
            this.nOe = str;
            this.nOg = Boolean.valueOf(z);
            this.nNY = true;
            this.nNV.onWriteDemand(this);
            try {
                this.nNV.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.nNV.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.nOd = null;
        }
    }

    public void dNK() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            ag(-1, true);
        } else if (this.nNY) {
            o(this.nOf.intValue(), this.nOe, this.nOg.booleanValue());
        } else if (this.draft.dNO() == Draft.CloseHandshakeType.NONE) {
            ag(1000, true);
        } else if (this.draft.dNO() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.nOb == WebSocket.Role.SERVER) {
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
        p(this.draft.aU(str, this.nOb == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        p(this.draft.b(byteBuffer, this.nOb == WebSocket.Role.CLIENT));
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
        if (this.nOk == null) {
            this.nOk = new g();
        }
        sendFrame(this.nOk);
    }

    public boolean hasBufferedData() {
        return !this.nNT.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.nOd = this.draft.b(bVar);
        this.nOh = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.nOh == null) {
            throw new AssertionError();
        }
        try {
            this.nNV.onWebsocketHandshakeSentAsClient(this, this.nOd);
            write(this.draft.a(this.nOd, this.nOb));
        } catch (RuntimeException e) {
            this.nNV.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void o(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.nNT.add(byteBuffer);
        this.nNV.onWriteDemand(this);
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.nOj) {
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
            this.nNV.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.nNV.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.nNY || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.nNY;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.nNZ;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.nNZ = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.nNV.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.nNV.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long dNL() {
        return this.nOi;
    }

    public void dNM() {
        this.nOi = System.currentTimeMillis();
    }

    public d dNN() {
        return this.nNV;
    }

    public <T> T getAttachment() {
        return (T) this.nOl;
    }

    public <T> void setAttachment(T t) {
        this.nOl = t;
    }
}
