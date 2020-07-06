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
    public static int nZz;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> nZA;
    public final BlockingQueue<ByteBuffer> nZB;
    private final d nZC;
    public SelectionKey nZD;
    public ByteChannel nZE;
    private List<Draft> nZH;
    private WebSocket.Role nZI;
    private g nZR;
    private Object nZS;
    private volatile boolean nZF = false;
    private WebSocket.READYSTATE nZG = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer nZJ = ByteBuffer.allocate(0);
    private org.java_websocket.c.a nZK = null;
    private String nZL = null;
    private Integer nZM = null;
    private Boolean nZN = null;
    private String nZO = null;
    private long nZP = System.currentTimeMillis();
    private final Object nZQ = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        nZz = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.nZI == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.nZA = new LinkedBlockingQueue();
        this.nZB = new LinkedBlockingQueue();
        this.nZC = dVar;
        this.nZI = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.dTE();
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
            if (!$assertionsDisabled && this.nZJ.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                s(byteBuffer);
            } else if (this.nZJ.hasRemaining()) {
                s(this.nZJ);
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
        if (this.nZJ.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.nZJ.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.nZJ.capacity() + byteBuffer.remaining());
                this.nZJ.flip();
                allocate.put(this.nZJ);
                this.nZJ = allocate;
            }
            this.nZJ.put(byteBuffer);
            this.nZJ.flip();
            byteBuffer2 = this.nZJ;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.nZJ.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.nZJ = ByteBuffer.allocate(preferedSize);
                this.nZJ.put(byteBuffer);
            } else {
                this.nZJ.position(this.nZJ.limit());
                this.nZJ.limit(this.nZJ.capacity());
            }
        }
        if (this.nZI == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.nZH) {
                    Draft dTE = draft.dTE();
                    try {
                        dTE.a(this.nZI);
                        byteBuffer2.reset();
                        x = dTE.x(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(x instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) x;
                        if (dTE.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.nZO = aVar.getResourceDescriptor();
                            try {
                                write(dTE.a(dTE.a(aVar, this.nZC.onWebsocketHandshakeReceivedAsServer(this, dTE, aVar)), this.nZI));
                                this.draft = dTE;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.nZC.onWebsocketError(this, e4);
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
        if (this.nZI == WebSocket.Role.CLIENT) {
            this.draft.a(this.nZI);
            f x3 = this.draft.x(byteBuffer2);
            if (!(x3 instanceof h)) {
                q(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) x3;
            if (this.draft.a(this.nZK, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.nZC.onWebsocketHandshakeReceivedAsClient(this, this.nZK, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.nZC.onWebsocketError(this, e6);
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
            this.nZC.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        t(Lr(404));
        q(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        t(Lr(500));
        q(-1, runtimeException.getMessage(), false);
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
        return ByteBuffer.wrap(org.java_websocket.e.c.QH("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void o(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.nZG != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    q(i, str, false);
                } else {
                    if (this.draft.dTD() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.nZC.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.nZC.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.nZC.onWebsocketError(this, e2);
                                q(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.dTO();
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
            this.nZJ = null;
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
            if (this.nZD != null) {
                this.nZD.cancel();
            }
            if (this.nZE != null) {
                try {
                    this.nZE.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.nZC.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.nZC.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.nZC.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.nZK = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void ak(int i, boolean z) {
        p(i, "", z);
    }

    public void closeConnection(int i, String str) {
        p(i, str, false);
    }

    public synchronized void q(int i, String str, boolean z) {
        if (!this.nZF) {
            this.nZM = Integer.valueOf(i);
            this.nZL = str;
            this.nZN = Boolean.valueOf(z);
            this.nZF = true;
            this.nZC.onWriteDemand(this);
            try {
                this.nZC.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.nZC.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.nZK = null;
        }
    }

    public void dTz() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            ak(-1, true);
        } else if (this.nZF) {
            p(this.nZM.intValue(), this.nZL, this.nZN.booleanValue());
        } else if (this.draft.dTD() == Draft.CloseHandshakeType.NONE) {
            ak(1000, true);
        } else if (this.draft.dTD() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.nZI == WebSocket.Role.SERVER) {
                ak(1006, true);
            } else {
                ak(1000, true);
            }
        } else {
            ak(1006, true);
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
        r(this.draft.bf(str, this.nZI == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        r(this.draft.b(byteBuffer, this.nZI == WebSocket.Role.CLIENT));
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
        if (this.nZR == null) {
            this.nZR = new g();
        }
        sendFrame(this.nZR);
    }

    public boolean hasBufferedData() {
        return !this.nZA.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.nZK = this.draft.b(bVar);
        this.nZO = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.nZO == null) {
            throw new AssertionError();
        }
        try {
            this.nZC.onWebsocketHandshakeSentAsClient(this, this.nZK);
            write(this.draft.a(this.nZK, this.nZI));
        } catch (RuntimeException e) {
            this.nZC.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void t(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.nZA.add(byteBuffer);
        this.nZC.onWriteDemand(this);
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.nZQ) {
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
            this.nZC.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.nZC.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.nZF || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.nZF;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.nZG;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.nZG = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.nZC.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.nZC.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long dTA() {
        return this.nZP;
    }

    public void dTB() {
        this.nZP = System.currentTimeMillis();
    }

    public d dTC() {
        return this.nZC;
    }

    public <T> T getAttachment() {
        return (T) this.nZS;
    }

    public <T> void setAttachment(T t) {
        this.nZS = t;
    }
}
