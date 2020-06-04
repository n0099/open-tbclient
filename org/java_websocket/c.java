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
    public static int nDL;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> nDM;
    public final BlockingQueue<ByteBuffer> nDN;
    private final d nDO;
    public SelectionKey nDP;
    public ByteChannel nDQ;
    private List<Draft> nDT;
    private WebSocket.Role nDU;
    private g nEd;
    private Object nEe;
    private volatile boolean nDR = false;
    private WebSocket.READYSTATE nDS = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer nDV = ByteBuffer.allocate(0);
    private org.java_websocket.c.a nDW = null;
    private String nDX = null;
    private Integer nDY = null;
    private Boolean nDZ = null;
    private String nEa = null;
    private long nEb = System.currentTimeMillis();
    private final Object nEc = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        nDL = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.nDU == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.nDM = new LinkedBlockingQueue();
        this.nDN = new LinkedBlockingQueue();
        this.nDO = dVar;
        this.nDU = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.dOU();
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
            if (!$assertionsDisabled && this.nDV.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                s(byteBuffer);
            } else if (this.nDV.hasRemaining()) {
                s(this.nDV);
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
        if (this.nDV.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.nDV.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.nDV.capacity() + byteBuffer.remaining());
                this.nDV.flip();
                allocate.put(this.nDV);
                this.nDV = allocate;
            }
            this.nDV.put(byteBuffer);
            this.nDV.flip();
            byteBuffer2 = this.nDV;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.nDV.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.nDV = ByteBuffer.allocate(preferedSize);
                this.nDV.put(byteBuffer);
            } else {
                this.nDV.position(this.nDV.limit());
                this.nDV.limit(this.nDV.capacity());
            }
        }
        if (this.nDU == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.nDT) {
                    Draft dOU = draft.dOU();
                    try {
                        dOU.a(this.nDU);
                        byteBuffer2.reset();
                        x = dOU.x(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(x instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) x;
                        if (dOU.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.nEa = aVar.getResourceDescriptor();
                            try {
                                write(dOU.a(dOU.a(aVar, this.nDO.onWebsocketHandshakeReceivedAsServer(this, dOU, aVar)), this.nDU));
                                this.draft = dOU;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.nDO.onWebsocketError(this, e4);
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
                q(1002, "wrong http function", false);
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
        if (this.nDU == WebSocket.Role.CLIENT) {
            this.draft.a(this.nDU);
            f x3 = this.draft.x(byteBuffer2);
            if (!(x3 instanceof h)) {
                q(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) x3;
            if (this.draft.a(this.nDW, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.nDO.onWebsocketHandshakeReceivedAsClient(this, this.nDW, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.nDO.onWebsocketError(this, e6);
                    q(-1, e6.getMessage(), false);
                    return false;
                } catch (InvalidDataException e7) {
                    q(e7.getCloseCode(), e7.getMessage(), false);
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
            this.nDO.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        t(Kk(404));
        q(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        t(Kk(500));
        q(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer Kk(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.PU("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void o(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.nDS != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    q(i, str, false);
                } else {
                    if (this.draft.dOT() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.nDO.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.nDO.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.nDO.onWebsocketError(this, e2);
                                q(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.dPe();
                            sendFrame(bVar);
                        }
                    }
                    q(i, str, z);
                }
            } else if (i == -3) {
                if (!$assertionsDisabled && !z) {
                    throw new AssertionError();
                }
                q(-3, str, true);
            } else if (i == 1002) {
                q(i, str, z);
            } else {
                q(-1, str, false);
            }
            a(WebSocket.READYSTATE.CLOSING);
            this.nDV = null;
        }
    }

    public void close(int i, String str) {
        o(i, str, false);
    }

    public synchronized void p(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN && i == 1006) {
                a(WebSocket.READYSTATE.CLOSING);
            }
            if (this.nDP != null) {
                this.nDP.cancel();
            }
            if (this.nDQ != null) {
                try {
                    this.nDQ.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.nDO.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.nDO.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.nDO.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.nDW = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void ai(int i, boolean z) {
        p(i, "", z);
    }

    public void closeConnection(int i, String str) {
        p(i, str, false);
    }

    public synchronized void q(int i, String str, boolean z) {
        if (!this.nDR) {
            this.nDY = Integer.valueOf(i);
            this.nDX = str;
            this.nDZ = Boolean.valueOf(z);
            this.nDR = true;
            this.nDO.onWriteDemand(this);
            try {
                this.nDO.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.nDO.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.nDW = null;
        }
    }

    public void dOP() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            ai(-1, true);
        } else if (this.nDR) {
            p(this.nDY.intValue(), this.nDX, this.nDZ.booleanValue());
        } else if (this.draft.dOT() == Draft.CloseHandshakeType.NONE) {
            ai(1000, true);
        } else if (this.draft.dOT() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.nDU == WebSocket.Role.SERVER) {
                ai(1006, true);
            } else {
                ai(1000, true);
            }
        } else {
            ai(1006, true);
        }
    }

    public void close(int i) {
        o(i, "", false);
    }

    public void b(InvalidDataException invalidDataException) {
        o(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    public void send(String str) throws WebsocketNotConnectedException {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        r(this.draft.bd(str, this.nDU == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        r(this.draft.b(byteBuffer, this.nDU == WebSocket.Role.CLIENT));
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
        if (this.nEd == null) {
            this.nEd = new g();
        }
        sendFrame(this.nEd);
    }

    public boolean hasBufferedData() {
        return !this.nDM.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.nDW = this.draft.b(bVar);
        this.nEa = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.nEa == null) {
            throw new AssertionError();
        }
        try {
            this.nDO.onWebsocketHandshakeSentAsClient(this, this.nDW);
            write(this.draft.a(this.nDW, this.nDU));
        } catch (RuntimeException e) {
            this.nDO.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void t(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.nDM.add(byteBuffer);
        this.nDO.onWriteDemand(this);
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.nEc) {
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
            this.nDO.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.nDO.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.nDR || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.nDR;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.nDS;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.nDS = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.nDO.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.nDO.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long dOQ() {
        return this.nEb;
    }

    public void dOR() {
        this.nEb = System.currentTimeMillis();
    }

    public d dOS() {
        return this.nDO;
    }

    public <T> T getAttachment() {
        return (T) this.nEe;
    }

    public <T> void setAttachment(T t) {
        this.nEe = t;
    }
}
