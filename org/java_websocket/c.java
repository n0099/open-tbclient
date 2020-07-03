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
    public static int nZw;
    private Draft draft;
    public SelectionKey nZA;
    public ByteChannel nZB;
    private List<Draft> nZE;
    private WebSocket.Role nZF;
    private g nZO;
    private Object nZP;
    public final BlockingQueue<ByteBuffer> nZx;
    public final BlockingQueue<ByteBuffer> nZy;
    private final d nZz;
    private volatile boolean nZC = false;
    private WebSocket.READYSTATE nZD = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer nZG = ByteBuffer.allocate(0);
    private org.java_websocket.c.a nZH = null;
    private String nZI = null;
    private Integer nZJ = null;
    private Boolean nZK = null;
    private String nZL = null;
    private long nZM = System.currentTimeMillis();
    private final Object nZN = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        nZw = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.nZF == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.nZx = new LinkedBlockingQueue();
        this.nZy = new LinkedBlockingQueue();
        this.nZz = dVar;
        this.nZF = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.dTA();
        }
    }

    public void q(ByteBuffer byteBuffer) {
        if (!$assertionsDisabled && !byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
        if (DEBUG) {
            System.out.println("process(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining())) + '}');
        }
        if (getReadyState() != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                s(byteBuffer);
            }
        } else if (r(byteBuffer) && !isClosing() && !isClosed()) {
            if (!$assertionsDisabled && this.nZG.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                s(byteBuffer);
            } else if (this.nZG.hasRemaining()) {
                s(this.nZG);
            }
        }
        if (!$assertionsDisabled && !isClosing() && !isFlushAndClose() && byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
    }

    private boolean r(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        f x;
        boolean z;
        if (this.nZG.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.nZG.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.nZG.capacity() + byteBuffer.remaining());
                this.nZG.flip();
                allocate.put(this.nZG);
                this.nZG = allocate;
            }
            this.nZG.put(byteBuffer);
            this.nZG.flip();
            byteBuffer2 = this.nZG;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.nZG.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.nZG = ByteBuffer.allocate(preferedSize);
                this.nZG.put(byteBuffer);
            } else {
                this.nZG.position(this.nZG.limit());
                this.nZG.limit(this.nZG.capacity());
            }
        }
        if (this.nZF == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.nZE) {
                    Draft dTA = draft.dTA();
                    try {
                        dTA.a(this.nZF);
                        byteBuffer2.reset();
                        x = dTA.x(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(x instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) x;
                        if (dTA.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.nZL = aVar.getResourceDescriptor();
                            try {
                                write(dTA.a(dTA.a(aVar, this.nZz.onWebsocketHandshakeReceivedAsServer(this, dTA, aVar)), this.nZF));
                                this.draft = dTA;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.nZz.onWebsocketError(this, e4);
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
            f x2 = this.draft.x(byteBuffer2);
            if (!(x2 instanceof org.java_websocket.c.a)) {
                p(1002, "wrong http function", false);
                return false;
            }
            org.java_websocket.c.a aVar2 = (org.java_websocket.c.a) x2;
            if (this.draft.a(aVar2) == Draft.HandshakeState.MATCHED) {
                a(aVar2);
                return true;
            }
            close(1002, "the handshake did finaly not match");
            return false;
        }
        if (this.nZF == WebSocket.Role.CLIENT) {
            this.draft.a(this.nZF);
            f x3 = this.draft.x(byteBuffer2);
            if (!(x3 instanceof h)) {
                p(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) x3;
            if (this.draft.a(this.nZH, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.nZz.onWebsocketHandshakeReceivedAsClient(this, this.nZH, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.nZz.onWebsocketError(this, e6);
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

    private void s(ByteBuffer byteBuffer) {
        try {
            for (Framedata framedata : this.draft.w(byteBuffer)) {
                if (DEBUG) {
                    System.out.println("matched frame: " + framedata);
                }
                this.draft.a(this, framedata);
            }
        } catch (InvalidDataException e) {
            this.nZz.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        t(Lr(404));
        p(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        t(Lr(500));
        p(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer Lr(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.QG("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void n(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.nZD != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    p(i, str, false);
                } else {
                    if (this.draft.dTz() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.nZz.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.nZz.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.nZz.onWebsocketError(this, e2);
                                p(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.dTK();
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
            this.nZG = null;
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
            if (this.nZA != null) {
                this.nZA.cancel();
            }
            if (this.nZB != null) {
                try {
                    this.nZB.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.nZz.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.nZz.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.nZz.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.nZH = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void ak(int i, boolean z) {
        o(i, "", z);
    }

    public void closeConnection(int i, String str) {
        o(i, str, false);
    }

    public synchronized void p(int i, String str, boolean z) {
        if (!this.nZC) {
            this.nZJ = Integer.valueOf(i);
            this.nZI = str;
            this.nZK = Boolean.valueOf(z);
            this.nZC = true;
            this.nZz.onWriteDemand(this);
            try {
                this.nZz.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.nZz.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.nZH = null;
        }
    }

    public void dTv() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            ak(-1, true);
        } else if (this.nZC) {
            o(this.nZJ.intValue(), this.nZI, this.nZK.booleanValue());
        } else if (this.draft.dTz() == Draft.CloseHandshakeType.NONE) {
            ak(1000, true);
        } else if (this.draft.dTz() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.nZF == WebSocket.Role.SERVER) {
                ak(1006, true);
            } else {
                ak(1000, true);
            }
        } else {
            ak(1006, true);
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
        r(this.draft.bf(str, this.nZF == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        r(this.draft.b(byteBuffer, this.nZF == WebSocket.Role.CLIENT));
    }

    public void send(byte[] bArr) throws IllegalArgumentException, WebsocketNotConnectedException {
        send(ByteBuffer.wrap(bArr));
    }

    private void r(Collection<Framedata> collection) {
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
        r(this.draft.a(opcode, byteBuffer, z));
    }

    public void sendFrame(Collection<Framedata> collection) {
        r(collection);
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        r(Collections.singletonList(framedata));
    }

    public void sendPing() throws NotYetConnectedException {
        if (this.nZO == null) {
            this.nZO = new g();
        }
        sendFrame(this.nZO);
    }

    public boolean hasBufferedData() {
        return !this.nZx.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.nZH = this.draft.b(bVar);
        this.nZL = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.nZL == null) {
            throw new AssertionError();
        }
        try {
            this.nZz.onWebsocketHandshakeSentAsClient(this, this.nZH);
            write(this.draft.a(this.nZH, this.nZF));
        } catch (RuntimeException e) {
            this.nZz.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void t(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.nZx.add(byteBuffer);
        this.nZz.onWriteDemand(this);
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.nZN) {
            for (ByteBuffer byteBuffer : list) {
                t(byteBuffer);
            }
        }
    }

    private void a(f fVar) {
        if (DEBUG) {
            System.out.println("open using draft: " + this.draft);
        }
        a(WebSocket.READYSTATE.OPEN);
        try {
            this.nZz.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.nZz.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.nZC || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.nZC;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.nZD;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.nZD = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.nZz.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.nZz.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long dTw() {
        return this.nZM;
    }

    public void dTx() {
        this.nZM = System.currentTimeMillis();
    }

    public d dTy() {
        return this.nZz;
    }

    public <T> T getAttachment() {
        return (T) this.nZP;
    }

    public <T> void setAttachment(T t) {
        this.nZP = t;
    }
}
