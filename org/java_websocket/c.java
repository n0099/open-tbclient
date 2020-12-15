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
    public static int pNO;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> pNP;
    public final BlockingQueue<ByteBuffer> pNQ;
    private final d pNR;
    public SelectionKey pNS;
    public ByteChannel pNT;
    private List<Draft> pNW;
    private WebSocket.Role pNX;
    private g pOg;
    private Object pOh;
    private volatile boolean pNU = false;
    private WebSocket.READYSTATE pNV = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer pNY = ByteBuffer.allocate(0);
    private org.java_websocket.c.a pNZ = null;
    private String pOa = null;
    private Integer pOb = null;
    private Boolean pOc = null;
    private String pOd = null;
    private long pOe = System.currentTimeMillis();
    private final Object pOf = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        pNO = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.pNX == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.pNP = new LinkedBlockingQueue();
        this.pNQ = new LinkedBlockingQueue();
        this.pNR = dVar;
        this.pNX = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.eEL();
        }
    }

    public void s(ByteBuffer byteBuffer) {
        if (!$assertionsDisabled && !byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
        if (DEBUG) {
            System.out.println("process(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining())) + '}');
        }
        if (getReadyState() != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                u(byteBuffer);
            }
        } else if (t(byteBuffer) && !isClosing() && !isClosed()) {
            if (!$assertionsDisabled && this.pNY.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                u(byteBuffer);
            } else if (this.pNY.hasRemaining()) {
                u(this.pNY);
            }
        }
        if (!$assertionsDisabled && !isClosing() && !isFlushAndClose() && byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
    }

    private boolean t(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        f z;
        boolean z2;
        if (this.pNY.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.pNY.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.pNY.capacity() + byteBuffer.remaining());
                this.pNY.flip();
                allocate.put(this.pNY);
                this.pNY = allocate;
            }
            this.pNY.put(byteBuffer);
            this.pNY.flip();
            byteBuffer2 = this.pNY;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.pNY.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.pNY = ByteBuffer.allocate(preferedSize);
                this.pNY.put(byteBuffer);
            } else {
                this.pNY.position(this.pNY.limit());
                this.pNY.limit(this.pNY.capacity());
            }
        }
        if (this.pNX == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.pNW) {
                    Draft eEL = draft.eEL();
                    try {
                        eEL.a(this.pNX);
                        byteBuffer2.reset();
                        z = eEL.z(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(z instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z2 = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) z;
                        if (eEL.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.pOd = aVar.getResourceDescriptor();
                            try {
                                write(eEL.a(eEL.a(aVar, this.pNR.onWebsocketHandshakeReceivedAsServer(this, eEL, aVar)), this.pNX));
                                this.draft = eEL;
                                a(aVar);
                                z2 = true;
                            } catch (RuntimeException e4) {
                                this.pNR.onWebsocketError(this, e4);
                                a(e4);
                                z2 = false;
                            } catch (InvalidDataException e5) {
                                a(e5);
                                z2 = false;
                            }
                        } else {
                            continue;
                        }
                    }
                    return z2;
                }
                if (this.draft == null) {
                    a(new InvalidDataException(1002, "no draft matches"));
                }
                return false;
            }
            f z3 = this.draft.z(byteBuffer2);
            if (!(z3 instanceof org.java_websocket.c.a)) {
                s(1002, "wrong http function", false);
                return false;
            }
            org.java_websocket.c.a aVar2 = (org.java_websocket.c.a) z3;
            if (this.draft.a(aVar2) == Draft.HandshakeState.MATCHED) {
                a(aVar2);
                return true;
            }
            close(1002, "the handshake did finaly not match");
            return false;
        }
        if (this.pNX == WebSocket.Role.CLIENT) {
            this.draft.a(this.pNX);
            f z4 = this.draft.z(byteBuffer2);
            if (!(z4 instanceof h)) {
                s(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) z4;
            if (this.draft.a(this.pNZ, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.pNR.onWebsocketHandshakeReceivedAsClient(this, this.pNZ, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.pNR.onWebsocketError(this, e6);
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

    private void u(ByteBuffer byteBuffer) {
        try {
            for (Framedata framedata : this.draft.y(byteBuffer)) {
                if (DEBUG) {
                    System.out.println("matched frame: " + framedata);
                }
                this.draft.a(this, framedata);
            }
        } catch (InvalidDataException e) {
            this.pNR.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        v(Sh(404));
        s(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        v(Sh(500));
        s(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer Sh(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.Zj("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void q(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.pNV != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    s(i, str, false);
                } else {
                    if (this.draft.eEK() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.pNR.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.pNR.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.pNR.onWebsocketError(this, e2);
                                s(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.eEV();
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
            this.pNY = null;
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
            if (this.pNS != null) {
                this.pNS.cancel();
            }
            if (this.pNT != null) {
                try {
                    this.pNT.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.pNR.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.pNR.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.pNR.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.pNZ = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void ar(int i, boolean z) {
        r(i, "", z);
    }

    public void closeConnection(int i, String str) {
        r(i, str, false);
    }

    public synchronized void s(int i, String str, boolean z) {
        if (!this.pNU) {
            this.pOb = Integer.valueOf(i);
            this.pOa = str;
            this.pOc = Boolean.valueOf(z);
            this.pNU = true;
            this.pNR.onWriteDemand(this);
            try {
                this.pNR.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.pNR.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.pNZ = null;
        }
    }

    public void eEG() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            ar(-1, true);
        } else if (this.pNU) {
            r(this.pOb.intValue(), this.pOa, this.pOc.booleanValue());
        } else if (this.draft.eEK() == Draft.CloseHandshakeType.NONE) {
            ar(1000, true);
        } else if (this.draft.eEK() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.pNX == WebSocket.Role.SERVER) {
                ar(1006, true);
            } else {
                ar(1000, true);
            }
        } else {
            ar(1006, true);
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
        s(this.draft.bp(str, this.pNX == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        s(this.draft.b(byteBuffer, this.pNX == WebSocket.Role.CLIENT));
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
        if (this.pOg == null) {
            this.pOg = new g();
        }
        sendFrame(this.pOg);
    }

    public boolean hasBufferedData() {
        return !this.pNP.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.pNZ = this.draft.b(bVar);
        this.pOd = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.pOd == null) {
            throw new AssertionError();
        }
        try {
            this.pNR.onWebsocketHandshakeSentAsClient(this, this.pNZ);
            write(this.draft.a(this.pNZ, this.pNX));
        } catch (RuntimeException e) {
            this.pNR.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void v(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.pNP.add(byteBuffer);
        this.pNR.onWriteDemand(this);
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.pOf) {
            for (ByteBuffer byteBuffer : list) {
                v(byteBuffer);
            }
        }
    }

    private void a(f fVar) {
        if (DEBUG) {
            System.out.println("open using draft: " + this.draft);
        }
        a(WebSocket.READYSTATE.OPEN);
        try {
            this.pNR.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.pNR.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.pNU || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.pNU;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.pNV;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.pNV = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.pNR.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.pNR.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long eEH() {
        return this.pOe;
    }

    public void eEI() {
        this.pOe = System.currentTimeMillis();
    }

    public d eEJ() {
        return this.pNR;
    }

    public <T> T getAttachment() {
        return (T) this.pOh;
    }

    public <T> void setAttachment(T t) {
        this.pOh = t;
    }
}
