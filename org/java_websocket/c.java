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
/* loaded from: classes2.dex */
public class c implements WebSocket {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static boolean DEBUG;
    private static final Object isO;
    public static int isx;
    private Draft draft;
    private final d isA;
    public SelectionKey isB;
    public ByteChannel isC;
    private List<Draft> isF;
    private WebSocket.Role isG;
    private g isP;
    private Object isQ;
    public final BlockingQueue<ByteBuffer> isy;
    public final BlockingQueue<ByteBuffer> isz;
    private volatile boolean isD = false;
    private WebSocket.READYSTATE isE = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer isH = ByteBuffer.allocate(0);
    private org.java_websocket.c.a isI = null;
    private String isJ = null;
    private Integer isK = null;
    private Boolean isL = null;
    private String isM = null;
    private long isN = System.currentTimeMillis();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        isx = 16384;
        DEBUG = false;
        isO = new Object();
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.isG == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.isy = new LinkedBlockingQueue();
        this.isz = new LinkedBlockingQueue();
        this.isA = dVar;
        this.isG = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.cai();
        }
    }

    public void k(ByteBuffer byteBuffer) {
        if (!$assertionsDisabled && !byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
        if (DEBUG) {
            System.out.println("process(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining())) + '}');
        }
        if (getReadyState() != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                m(byteBuffer);
            }
        } else if (l(byteBuffer) && !isClosing() && !isClosed()) {
            if (!$assertionsDisabled && this.isH.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                m(byteBuffer);
            } else if (this.isH.hasRemaining()) {
                m(this.isH);
            }
        }
        if (!$assertionsDisabled && !isClosing() && !isFlushAndClose() && byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
    }

    private boolean l(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        f r;
        boolean z;
        if (this.isH.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.isH.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.isH.capacity() + byteBuffer.remaining());
                this.isH.flip();
                allocate.put(this.isH);
                this.isH = allocate;
            }
            this.isH.put(byteBuffer);
            this.isH.flip();
            byteBuffer2 = this.isH;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.isH.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.isH = ByteBuffer.allocate(preferedSize);
                this.isH.put(byteBuffer);
            } else {
                this.isH.position(this.isH.limit());
                this.isH.limit(this.isH.capacity());
            }
        }
        if (this.isG == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.isF) {
                    Draft cai = draft.cai();
                    try {
                        cai.a(this.isG);
                        byteBuffer2.reset();
                        r = cai.r(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(r instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) r;
                        if (cai.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.isM = aVar.getResourceDescriptor();
                            try {
                                eu(cai.a(cai.a(aVar, this.isA.onWebsocketHandshakeReceivedAsServer(this, cai, aVar)), this.isG));
                                this.draft = cai;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.isA.onWebsocketError(this, e4);
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
            f r2 = this.draft.r(byteBuffer2);
            if (!(r2 instanceof org.java_websocket.c.a)) {
                j(1002, "wrong http function", false);
                return false;
            }
            org.java_websocket.c.a aVar2 = (org.java_websocket.c.a) r2;
            if (this.draft.a(aVar2) == Draft.HandshakeState.MATCHED) {
                a(aVar2);
                return true;
            }
            close(1002, "the handshake did finaly not match");
            return false;
        }
        if (this.isG == WebSocket.Role.CLIENT) {
            this.draft.a(this.isG);
            f r3 = this.draft.r(byteBuffer2);
            if (!(r3 instanceof h)) {
                j(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) r3;
            if (this.draft.a(this.isI, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.isA.onWebsocketHandshakeReceivedAsClient(this, this.isI, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.isA.onWebsocketError(this, e6);
                    j(-1, e6.getMessage(), false);
                    return false;
                } catch (InvalidDataException e7) {
                    j(e7.getCloseCode(), e7.getMessage(), false);
                    return false;
                }
            }
            close(1002, "draft " + this.draft + " refuses handshake");
        }
        return false;
    }

    private void m(ByteBuffer byteBuffer) {
        try {
            for (Framedata framedata : this.draft.q(byteBuffer)) {
                if (DEBUG) {
                    System.out.println("matched frame: " + framedata);
                }
                this.draft.a(this, framedata);
            }
        } catch (InvalidDataException e) {
            this.isA.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        n(yO(404));
        j(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        n(yO(500));
        j(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer yO(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.yE("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void h(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.isE != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    j(i, str, false);
                } else {
                    if (this.draft.cah() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.isA.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.isA.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.isA.onWebsocketError(this, e2);
                                j(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.cas();
                            sendFrame(bVar);
                        }
                    }
                    j(i, str, z);
                }
            } else if (i == -3) {
                if (!$assertionsDisabled && !z) {
                    throw new AssertionError();
                }
                j(-3, str, true);
            } else if (i == 1002) {
                j(i, str, z);
            } else {
                j(-1, str, false);
            }
            a(WebSocket.READYSTATE.CLOSING);
            this.isH = null;
        }
    }

    public void close(int i, String str) {
        h(i, str, false);
    }

    public synchronized void i(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN && i == 1006) {
                a(WebSocket.READYSTATE.CLOSING);
            }
            if (this.isB != null) {
                this.isB.cancel();
            }
            if (this.isC != null) {
                try {
                    this.isC.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.isA.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.isA.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.isA.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.isI = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void M(int i, boolean z) {
        i(i, "", z);
    }

    public void closeConnection(int i, String str) {
        i(i, str, false);
    }

    public synchronized void j(int i, String str, boolean z) {
        if (!this.isD) {
            this.isK = Integer.valueOf(i);
            this.isJ = str;
            this.isL = Boolean.valueOf(z);
            this.isD = true;
            this.isA.onWriteDemand(this);
            try {
                this.isA.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.isA.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.isI = null;
        }
    }

    public void cad() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            M(-1, true);
        } else if (this.isD) {
            i(this.isK.intValue(), this.isJ, this.isL.booleanValue());
        } else if (this.draft.cah() == Draft.CloseHandshakeType.NONE) {
            M(1000, true);
        } else if (this.draft.cah() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.isG == WebSocket.Role.SERVER) {
                M(1006, true);
            } else {
                M(1000, true);
            }
        } else {
            M(1006, true);
        }
    }

    public void close(int i) {
        h(i, "", false);
    }

    public void b(InvalidDataException invalidDataException) {
        h(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    public void send(String str) throws WebsocketNotConnectedException {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        l(this.draft.ah(str, this.isG == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        l(this.draft.b(byteBuffer, this.isG == WebSocket.Role.CLIENT));
    }

    public void send(byte[] bArr) throws IllegalArgumentException, WebsocketNotConnectedException {
        send(ByteBuffer.wrap(bArr));
    }

    private void l(Collection<Framedata> collection) {
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
        eu(arrayList);
    }

    public void sendFragmentedFrame(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        l(this.draft.a(opcode, byteBuffer, z));
    }

    public void sendFrame(Collection<Framedata> collection) {
        l(collection);
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        l(Collections.singletonList(framedata));
    }

    public void sendPing() throws NotYetConnectedException {
        if (this.isP == null) {
            this.isP = new g();
        }
        sendFrame(this.isP);
    }

    public boolean hasBufferedData() {
        return !this.isy.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        if (!$assertionsDisabled && getReadyState() == WebSocket.READYSTATE.CONNECTING) {
            throw new AssertionError("shall only be called once");
        }
        this.isI = this.draft.b(bVar);
        this.isM = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.isM == null) {
            throw new AssertionError();
        }
        try {
            this.isA.onWebsocketHandshakeSentAsClient(this, this.isI);
            eu(this.draft.a(this.isI, this.isG));
        } catch (RuntimeException e) {
            this.isA.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void n(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.isy.add(byteBuffer);
        this.isA.onWriteDemand(this);
    }

    private void eu(List<ByteBuffer> list) {
        synchronized (isO) {
            for (ByteBuffer byteBuffer : list) {
                n(byteBuffer);
            }
        }
    }

    private void a(f fVar) {
        if (DEBUG) {
            System.out.println("open using draft: " + this.draft);
        }
        a(WebSocket.READYSTATE.OPEN);
        try {
            this.isA.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.isA.onWebsocketError(this, e);
        }
    }

    public boolean isConnecting() {
        if ($assertionsDisabled || !this.isD || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
            return getReadyState() == WebSocket.READYSTATE.CONNECTING;
        }
        throw new AssertionError();
    }

    public boolean isOpen() {
        if (!$assertionsDisabled && getReadyState() == WebSocket.READYSTATE.OPEN && this.isD) {
            throw new AssertionError();
        }
        return getReadyState() == WebSocket.READYSTATE.OPEN;
    }

    public boolean isClosing() {
        return getReadyState() == WebSocket.READYSTATE.CLOSING;
    }

    public boolean isFlushAndClose() {
        return this.isD;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.isE;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.isE = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.isA.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.isA.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long cae() {
        return this.isN;
    }

    public void caf() {
        this.isN = System.currentTimeMillis();
    }

    public d cag() {
        return this.isA;
    }

    public <T> T getAttachment() {
        return (T) this.isQ;
    }

    public <T> void setAttachment(T t) {
        this.isQ = t;
    }
}
