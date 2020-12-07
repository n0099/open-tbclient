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
    public static int pNM;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> pNN;
    public final BlockingQueue<ByteBuffer> pNO;
    private final d pNP;
    public SelectionKey pNQ;
    public ByteChannel pNR;
    private List<Draft> pNU;
    private WebSocket.Role pNV;
    private g pOe;
    private Object pOf;
    private volatile boolean pNS = false;
    private WebSocket.READYSTATE pNT = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer pNW = ByteBuffer.allocate(0);
    private org.java_websocket.c.a pNX = null;
    private String pNY = null;
    private Integer pNZ = null;
    private Boolean pOa = null;
    private String pOb = null;
    private long pOc = System.currentTimeMillis();
    private final Object pOd = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        pNM = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.pNV == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.pNN = new LinkedBlockingQueue();
        this.pNO = new LinkedBlockingQueue();
        this.pNP = dVar;
        this.pNV = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.eEK();
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
            if (!$assertionsDisabled && this.pNW.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                u(byteBuffer);
            } else if (this.pNW.hasRemaining()) {
                u(this.pNW);
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
        if (this.pNW.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.pNW.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.pNW.capacity() + byteBuffer.remaining());
                this.pNW.flip();
                allocate.put(this.pNW);
                this.pNW = allocate;
            }
            this.pNW.put(byteBuffer);
            this.pNW.flip();
            byteBuffer2 = this.pNW;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.pNW.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.pNW = ByteBuffer.allocate(preferedSize);
                this.pNW.put(byteBuffer);
            } else {
                this.pNW.position(this.pNW.limit());
                this.pNW.limit(this.pNW.capacity());
            }
        }
        if (this.pNV == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.pNU) {
                    Draft eEK = draft.eEK();
                    try {
                        eEK.a(this.pNV);
                        byteBuffer2.reset();
                        z = eEK.z(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(z instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z2 = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) z;
                        if (eEK.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.pOb = aVar.getResourceDescriptor();
                            try {
                                write(eEK.a(eEK.a(aVar, this.pNP.onWebsocketHandshakeReceivedAsServer(this, eEK, aVar)), this.pNV));
                                this.draft = eEK;
                                a(aVar);
                                z2 = true;
                            } catch (RuntimeException e4) {
                                this.pNP.onWebsocketError(this, e4);
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
        if (this.pNV == WebSocket.Role.CLIENT) {
            this.draft.a(this.pNV);
            f z4 = this.draft.z(byteBuffer2);
            if (!(z4 instanceof h)) {
                s(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) z4;
            if (this.draft.a(this.pNX, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.pNP.onWebsocketHandshakeReceivedAsClient(this, this.pNX, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.pNP.onWebsocketError(this, e6);
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
            this.pNP.onWebsocketError(this, e);
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
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.pNT != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    s(i, str, false);
                } else {
                    if (this.draft.eEJ() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.pNP.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.pNP.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.pNP.onWebsocketError(this, e2);
                                s(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.eEU();
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
            this.pNW = null;
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
            if (this.pNQ != null) {
                this.pNQ.cancel();
            }
            if (this.pNR != null) {
                try {
                    this.pNR.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.pNP.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.pNP.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.pNP.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.pNX = null;
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
        if (!this.pNS) {
            this.pNZ = Integer.valueOf(i);
            this.pNY = str;
            this.pOa = Boolean.valueOf(z);
            this.pNS = true;
            this.pNP.onWriteDemand(this);
            try {
                this.pNP.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.pNP.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.pNX = null;
        }
    }

    public void eEF() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            ar(-1, true);
        } else if (this.pNS) {
            r(this.pNZ.intValue(), this.pNY, this.pOa.booleanValue());
        } else if (this.draft.eEJ() == Draft.CloseHandshakeType.NONE) {
            ar(1000, true);
        } else if (this.draft.eEJ() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.pNV == WebSocket.Role.SERVER) {
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
        s(this.draft.bp(str, this.pNV == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        s(this.draft.b(byteBuffer, this.pNV == WebSocket.Role.CLIENT));
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
        if (this.pOe == null) {
            this.pOe = new g();
        }
        sendFrame(this.pOe);
    }

    public boolean hasBufferedData() {
        return !this.pNN.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.pNX = this.draft.b(bVar);
        this.pOb = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.pOb == null) {
            throw new AssertionError();
        }
        try {
            this.pNP.onWebsocketHandshakeSentAsClient(this, this.pNX);
            write(this.draft.a(this.pNX, this.pNV));
        } catch (RuntimeException e) {
            this.pNP.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void v(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.pNN.add(byteBuffer);
        this.pNP.onWriteDemand(this);
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.pOd) {
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
            this.pNP.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.pNP.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.pNS || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.pNS;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.pNT;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.pNT = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.pNP.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.pNP.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long eEG() {
        return this.pOc;
    }

    public void eEH() {
        this.pOc = System.currentTimeMillis();
    }

    public d eEI() {
        return this.pNP;
    }

    public <T> T getAttachment() {
        return (T) this.pOf;
    }

    public <T> void setAttachment(T t) {
        this.pOf = t;
    }
}
