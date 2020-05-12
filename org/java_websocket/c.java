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
    public static int nhA;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> nhB;
    public final BlockingQueue<ByteBuffer> nhC;
    private final d nhD;
    public SelectionKey nhE;
    public ByteChannel nhF;
    private List<Draft> nhI;
    private WebSocket.Role nhJ;
    private g nhS;
    private Object nhT;
    private volatile boolean nhG = false;
    private WebSocket.READYSTATE nhH = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer nhK = ByteBuffer.allocate(0);
    private org.java_websocket.c.a nhL = null;
    private String nhM = null;
    private Integer nhN = null;
    private Boolean nhO = null;
    private String nhP = null;
    private long nhQ = System.currentTimeMillis();
    private final Object nhR = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        nhA = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.nhJ == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.nhB = new LinkedBlockingQueue();
        this.nhC = new LinkedBlockingQueue();
        this.nhD = dVar;
        this.nhJ = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.dGM();
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
            if (!$assertionsDisabled && this.nhK.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                n(byteBuffer);
            } else if (this.nhK.hasRemaining()) {
                n(this.nhK);
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
        if (this.nhK.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.nhK.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.nhK.capacity() + byteBuffer.remaining());
                this.nhK.flip();
                allocate.put(this.nhK);
                this.nhK = allocate;
            }
            this.nhK.put(byteBuffer);
            this.nhK.flip();
            byteBuffer2 = this.nhK;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.nhK.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.nhK = ByteBuffer.allocate(preferedSize);
                this.nhK.put(byteBuffer);
            } else {
                this.nhK.position(this.nhK.limit());
                this.nhK.limit(this.nhK.capacity());
            }
        }
        if (this.nhJ == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.nhI) {
                    Draft dGM = draft.dGM();
                    try {
                        dGM.a(this.nhJ);
                        byteBuffer2.reset();
                        s = dGM.s(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(s instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) s;
                        if (dGM.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.nhP = aVar.getResourceDescriptor();
                            try {
                                write(dGM.a(dGM.a(aVar, this.nhD.onWebsocketHandshakeReceivedAsServer(this, dGM, aVar)), this.nhJ));
                                this.draft = dGM;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.nhD.onWebsocketError(this, e4);
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
        if (this.nhJ == WebSocket.Role.CLIENT) {
            this.draft.a(this.nhJ);
            f s3 = this.draft.s(byteBuffer2);
            if (!(s3 instanceof h)) {
                q(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) s3;
            if (this.draft.a(this.nhL, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.nhD.onWebsocketHandshakeReceivedAsClient(this, this.nhL, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.nhD.onWebsocketError(this, e6);
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
            this.nhD.onWebsocketError(this, e);
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
        return ByteBuffer.wrap(org.java_websocket.e.c.Of("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void o(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.nhH != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    q(i, str, false);
                } else {
                    if (this.draft.dGL() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.nhD.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.nhD.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.nhD.onWebsocketError(this, e2);
                                q(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.dGW();
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
            this.nhK = null;
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
            if (this.nhE != null) {
                this.nhE.cancel();
            }
            if (this.nhF != null) {
                try {
                    this.nhF.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.nhD.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.nhD.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.nhD.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.nhL = null;
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
        if (!this.nhG) {
            this.nhN = Integer.valueOf(i);
            this.nhM = str;
            this.nhO = Boolean.valueOf(z);
            this.nhG = true;
            this.nhD.onWriteDemand(this);
            try {
                this.nhD.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.nhD.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.nhL = null;
        }
    }

    public void dGH() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            ae(-1, true);
        } else if (this.nhG) {
            p(this.nhN.intValue(), this.nhM, this.nhO.booleanValue());
        } else if (this.draft.dGL() == Draft.CloseHandshakeType.NONE) {
            ae(1000, true);
        } else if (this.draft.dGL() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.nhJ == WebSocket.Role.SERVER) {
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
        p(this.draft.aQ(str, this.nhJ == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        p(this.draft.b(byteBuffer, this.nhJ == WebSocket.Role.CLIENT));
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
        if (this.nhS == null) {
            this.nhS = new g();
        }
        sendFrame(this.nhS);
    }

    public boolean hasBufferedData() {
        return !this.nhB.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.nhL = this.draft.b(bVar);
        this.nhP = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.nhP == null) {
            throw new AssertionError();
        }
        try {
            this.nhD.onWebsocketHandshakeSentAsClient(this, this.nhL);
            write(this.draft.a(this.nhL, this.nhJ));
        } catch (RuntimeException e) {
            this.nhD.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void o(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.nhB.add(byteBuffer);
        this.nhD.onWriteDemand(this);
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.nhR) {
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
            this.nhD.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.nhD.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.nhG || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.nhG;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.nhH;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.nhH = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.nhD.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.nhD.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long dGI() {
        return this.nhQ;
    }

    public void dGJ() {
        this.nhQ = System.currentTimeMillis();
    }

    public d dGK() {
        return this.nhD;
    }

    public <T> T getAttachment() {
        return (T) this.nhT;
    }

    public <T> void setAttachment(T t) {
        this.nhT = t;
    }
}
