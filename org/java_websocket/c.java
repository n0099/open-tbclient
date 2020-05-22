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
    public static int nCB;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> nCC;
    public final BlockingQueue<ByteBuffer> nCD;
    private final d nCE;
    public SelectionKey nCF;
    public ByteChannel nCG;
    private List<Draft> nCJ;
    private WebSocket.Role nCK;
    private g nCT;
    private Object nCU;
    private volatile boolean nCH = false;
    private WebSocket.READYSTATE nCI = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer nCL = ByteBuffer.allocate(0);
    private org.java_websocket.c.a nCM = null;
    private String nCN = null;
    private Integer nCO = null;
    private Boolean nCP = null;
    private String nCQ = null;
    private long nCR = System.currentTimeMillis();
    private final Object nCS = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        nCB = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.nCK == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.nCC = new LinkedBlockingQueue();
        this.nCD = new LinkedBlockingQueue();
        this.nCE = dVar;
        this.nCK = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.dOG();
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
            if (!$assertionsDisabled && this.nCL.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                s(byteBuffer);
            } else if (this.nCL.hasRemaining()) {
                s(this.nCL);
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
        if (this.nCL.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.nCL.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.nCL.capacity() + byteBuffer.remaining());
                this.nCL.flip();
                allocate.put(this.nCL);
                this.nCL = allocate;
            }
            this.nCL.put(byteBuffer);
            this.nCL.flip();
            byteBuffer2 = this.nCL;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.nCL.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.nCL = ByteBuffer.allocate(preferedSize);
                this.nCL.put(byteBuffer);
            } else {
                this.nCL.position(this.nCL.limit());
                this.nCL.limit(this.nCL.capacity());
            }
        }
        if (this.nCK == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.nCJ) {
                    Draft dOG = draft.dOG();
                    try {
                        dOG.a(this.nCK);
                        byteBuffer2.reset();
                        x = dOG.x(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(x instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) x;
                        if (dOG.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.nCQ = aVar.getResourceDescriptor();
                            try {
                                write(dOG.a(dOG.a(aVar, this.nCE.onWebsocketHandshakeReceivedAsServer(this, dOG, aVar)), this.nCK));
                                this.draft = dOG;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.nCE.onWebsocketError(this, e4);
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
        if (this.nCK == WebSocket.Role.CLIENT) {
            this.draft.a(this.nCK);
            f x3 = this.draft.x(byteBuffer2);
            if (!(x3 instanceof h)) {
                q(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) x3;
            if (this.draft.a(this.nCM, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.nCE.onWebsocketHandshakeReceivedAsClient(this, this.nCM, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.nCE.onWebsocketError(this, e6);
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
            this.nCE.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        t(Ki(404));
        q(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        t(Ki(500));
        q(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer Ki(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.PT("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void o(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.nCI != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    q(i, str, false);
                } else {
                    if (this.draft.dOF() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.nCE.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.nCE.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.nCE.onWebsocketError(this, e2);
                                q(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.dOQ();
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
            this.nCL = null;
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
            if (this.nCF != null) {
                this.nCF.cancel();
            }
            if (this.nCG != null) {
                try {
                    this.nCG.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.nCE.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.nCE.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.nCE.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.nCM = null;
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
        if (!this.nCH) {
            this.nCO = Integer.valueOf(i);
            this.nCN = str;
            this.nCP = Boolean.valueOf(z);
            this.nCH = true;
            this.nCE.onWriteDemand(this);
            try {
                this.nCE.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.nCE.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.nCM = null;
        }
    }

    public void dOB() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            ai(-1, true);
        } else if (this.nCH) {
            p(this.nCO.intValue(), this.nCN, this.nCP.booleanValue());
        } else if (this.draft.dOF() == Draft.CloseHandshakeType.NONE) {
            ai(1000, true);
        } else if (this.draft.dOF() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.nCK == WebSocket.Role.SERVER) {
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
        r(this.draft.bd(str, this.nCK == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        r(this.draft.b(byteBuffer, this.nCK == WebSocket.Role.CLIENT));
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
        if (this.nCT == null) {
            this.nCT = new g();
        }
        sendFrame(this.nCT);
    }

    public boolean hasBufferedData() {
        return !this.nCC.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.nCM = this.draft.b(bVar);
        this.nCQ = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.nCQ == null) {
            throw new AssertionError();
        }
        try {
            this.nCE.onWebsocketHandshakeSentAsClient(this, this.nCM);
            write(this.draft.a(this.nCM, this.nCK));
        } catch (RuntimeException e) {
            this.nCE.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void t(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.nCC.add(byteBuffer);
        this.nCE.onWriteDemand(this);
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.nCS) {
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
            this.nCE.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.nCE.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.nCH || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.nCH;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.nCI;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.nCI = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.nCE.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.nCE.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long dOC() {
        return this.nCR;
    }

    public void dOD() {
        this.nCR = System.currentTimeMillis();
    }

    public d dOE() {
        return this.nCE;
    }

    public <T> T getAttachment() {
        return (T) this.nCU;
    }

    public <T> void setAttachment(T t) {
        this.nCU = t;
    }
}
