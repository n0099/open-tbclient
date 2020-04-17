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
    public static int nhx;
    private Draft draft;
    private final d nhA;
    public SelectionKey nhB;
    public ByteChannel nhC;
    private List<Draft> nhF;
    private WebSocket.Role nhG;
    private g nhP;
    private Object nhQ;
    public final BlockingQueue<ByteBuffer> nhy;
    public final BlockingQueue<ByteBuffer> nhz;
    private volatile boolean nhD = false;
    private WebSocket.READYSTATE nhE = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer nhH = ByteBuffer.allocate(0);
    private org.java_websocket.c.a nhI = null;
    private String nhJ = null;
    private Integer nhK = null;
    private Boolean nhL = null;
    private String nhM = null;
    private long nhN = System.currentTimeMillis();
    private final Object nhO = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        nhx = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.nhG == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.nhy = new LinkedBlockingQueue();
        this.nhz = new LinkedBlockingQueue();
        this.nhA = dVar;
        this.nhG = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.dGP();
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
            if (!$assertionsDisabled && this.nhH.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                n(byteBuffer);
            } else if (this.nhH.hasRemaining()) {
                n(this.nhH);
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
        if (this.nhH.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.nhH.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.nhH.capacity() + byteBuffer.remaining());
                this.nhH.flip();
                allocate.put(this.nhH);
                this.nhH = allocate;
            }
            this.nhH.put(byteBuffer);
            this.nhH.flip();
            byteBuffer2 = this.nhH;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.nhH.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.nhH = ByteBuffer.allocate(preferedSize);
                this.nhH.put(byteBuffer);
            } else {
                this.nhH.position(this.nhH.limit());
                this.nhH.limit(this.nhH.capacity());
            }
        }
        if (this.nhG == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.nhF) {
                    Draft dGP = draft.dGP();
                    try {
                        dGP.a(this.nhG);
                        byteBuffer2.reset();
                        s = dGP.s(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(s instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) s;
                        if (dGP.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.nhM = aVar.getResourceDescriptor();
                            try {
                                write(dGP.a(dGP.a(aVar, this.nhA.onWebsocketHandshakeReceivedAsServer(this, dGP, aVar)), this.nhG));
                                this.draft = dGP;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.nhA.onWebsocketError(this, e4);
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
                q(1002, "wrong http function", false);
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
        if (this.nhG == WebSocket.Role.CLIENT) {
            this.draft.a(this.nhG);
            f s3 = this.draft.s(byteBuffer2);
            if (!(s3 instanceof h)) {
                q(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) s3;
            if (this.draft.a(this.nhI, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.nhA.onWebsocketHandshakeReceivedAsClient(this, this.nhI, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.nhA.onWebsocketError(this, e6);
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

    private void n(ByteBuffer byteBuffer) {
        try {
            for (Framedata framedata : this.draft.r(byteBuffer)) {
                if (DEBUG) {
                    System.out.println("matched frame: " + framedata);
                }
                this.draft.a(this, framedata);
            }
        } catch (InvalidDataException e) {
            this.nhA.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        o(Jx(404));
        q(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        o(Jx(500));
        q(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer Jx(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.Oc("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void o(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.nhE != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    q(i, str, false);
                } else {
                    if (this.draft.dGO() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.nhA.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.nhA.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.nhA.onWebsocketError(this, e2);
                                q(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.dGZ();
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
            this.nhH = null;
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
            if (this.nhB != null) {
                this.nhB.cancel();
            }
            if (this.nhC != null) {
                try {
                    this.nhC.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.nhA.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.nhA.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.nhA.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.nhI = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void ae(int i, boolean z) {
        p(i, "", z);
    }

    public void closeConnection(int i, String str) {
        p(i, str, false);
    }

    public synchronized void q(int i, String str, boolean z) {
        if (!this.nhD) {
            this.nhK = Integer.valueOf(i);
            this.nhJ = str;
            this.nhL = Boolean.valueOf(z);
            this.nhD = true;
            this.nhA.onWriteDemand(this);
            try {
                this.nhA.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.nhA.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.nhI = null;
        }
    }

    public void dGK() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            ae(-1, true);
        } else if (this.nhD) {
            p(this.nhK.intValue(), this.nhJ, this.nhL.booleanValue());
        } else if (this.draft.dGO() == Draft.CloseHandshakeType.NONE) {
            ae(1000, true);
        } else if (this.draft.dGO() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.nhG == WebSocket.Role.SERVER) {
                ae(1006, true);
            } else {
                ae(1000, true);
            }
        } else {
            ae(1006, true);
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
        p(this.draft.aQ(str, this.nhG == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        p(this.draft.b(byteBuffer, this.nhG == WebSocket.Role.CLIENT));
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
        if (this.nhP == null) {
            this.nhP = new g();
        }
        sendFrame(this.nhP);
    }

    public boolean hasBufferedData() {
        return !this.nhy.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.nhI = this.draft.b(bVar);
        this.nhM = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.nhM == null) {
            throw new AssertionError();
        }
        try {
            this.nhA.onWebsocketHandshakeSentAsClient(this, this.nhI);
            write(this.draft.a(this.nhI, this.nhG));
        } catch (RuntimeException e) {
            this.nhA.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void o(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.nhy.add(byteBuffer);
        this.nhA.onWriteDemand(this);
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.nhO) {
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
            this.nhA.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.nhA.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.nhD || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.nhD;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.nhE;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.nhE = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.nhA.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.nhA.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long dGL() {
        return this.nhN;
    }

    public void dGM() {
        this.nhN = System.currentTimeMillis();
    }

    public d dGN() {
        return this.nhA;
    }

    public <T> T getAttachment() {
        return (T) this.nhQ;
    }

    public <T> void setAttachment(T t) {
        this.nhQ = t;
    }
}
