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
    public static int iqN;
    private static final Object ire;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> iqO;
    public final BlockingQueue<ByteBuffer> iqP;
    private final d iqQ;
    public SelectionKey iqR;
    public ByteChannel iqS;
    private List<Draft> iqV;
    private WebSocket.Role iqW;
    private g irf;
    private Object irg;
    private volatile boolean iqT = false;
    private WebSocket.READYSTATE iqU = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer iqX = ByteBuffer.allocate(0);
    private org.java_websocket.c.a iqY = null;
    private String iqZ = null;
    private Integer ira = null;
    private Boolean irb = null;
    private String irc = null;
    private long ird = System.currentTimeMillis();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        iqN = 16384;
        DEBUG = false;
        ire = new Object();
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.iqW == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.iqO = new LinkedBlockingQueue();
        this.iqP = new LinkedBlockingQueue();
        this.iqQ = dVar;
        this.iqW = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.caL();
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
            if (!$assertionsDisabled && this.iqX.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                m(byteBuffer);
            } else if (this.iqX.hasRemaining()) {
                m(this.iqX);
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
        if (this.iqX.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.iqX.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.iqX.capacity() + byteBuffer.remaining());
                this.iqX.flip();
                allocate.put(this.iqX);
                this.iqX = allocate;
            }
            this.iqX.put(byteBuffer);
            this.iqX.flip();
            byteBuffer2 = this.iqX;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.iqX.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.iqX = ByteBuffer.allocate(preferedSize);
                this.iqX.put(byteBuffer);
            } else {
                this.iqX.position(this.iqX.limit());
                this.iqX.limit(this.iqX.capacity());
            }
        }
        if (this.iqW == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.iqV) {
                    Draft caL = draft.caL();
                    try {
                        caL.a(this.iqW);
                        byteBuffer2.reset();
                        r = caL.r(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(r instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) r;
                        if (caL.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.irc = aVar.getResourceDescriptor();
                            try {
                                ew(caL.a(caL.a(aVar, this.iqQ.onWebsocketHandshakeReceivedAsServer(this, caL, aVar)), this.iqW));
                                this.draft = caL;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.iqQ.onWebsocketError(this, e4);
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
        if (this.iqW == WebSocket.Role.CLIENT) {
            this.draft.a(this.iqW);
            f r3 = this.draft.r(byteBuffer2);
            if (!(r3 instanceof h)) {
                j(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) r3;
            if (this.draft.a(this.iqY, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.iqQ.onWebsocketHandshakeReceivedAsClient(this, this.iqY, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.iqQ.onWebsocketError(this, e6);
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
            this.iqQ.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        n(yv(404));
        j(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        n(yv(500));
        j(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer yv(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.yz("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void h(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.iqU != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    j(i, str, false);
                } else {
                    if (this.draft.caK() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.iqQ.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.iqQ.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.iqQ.onWebsocketError(this, e2);
                                j(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.caV();
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
            this.iqX = null;
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
            if (this.iqR != null) {
                this.iqR.cancel();
            }
            if (this.iqS != null) {
                try {
                    this.iqS.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.iqQ.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.iqQ.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.iqQ.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.iqY = null;
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
        if (!this.iqT) {
            this.ira = Integer.valueOf(i);
            this.iqZ = str;
            this.irb = Boolean.valueOf(z);
            this.iqT = true;
            this.iqQ.onWriteDemand(this);
            try {
                this.iqQ.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.iqQ.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.iqY = null;
        }
    }

    public void caG() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            M(-1, true);
        } else if (this.iqT) {
            i(this.ira.intValue(), this.iqZ, this.irb.booleanValue());
        } else if (this.draft.caK() == Draft.CloseHandshakeType.NONE) {
            M(1000, true);
        } else if (this.draft.caK() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.iqW == WebSocket.Role.SERVER) {
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
        i(this.draft.ah(str, this.iqW == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        i(this.draft.b(byteBuffer, this.iqW == WebSocket.Role.CLIENT));
    }

    public void send(byte[] bArr) throws IllegalArgumentException, WebsocketNotConnectedException {
        send(ByteBuffer.wrap(bArr));
    }

    private void i(Collection<Framedata> collection) {
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
        ew(arrayList);
    }

    public void sendFragmentedFrame(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        i(this.draft.a(opcode, byteBuffer, z));
    }

    public void sendFrame(Collection<Framedata> collection) {
        i(collection);
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        i(Collections.singletonList(framedata));
    }

    public void sendPing() throws NotYetConnectedException {
        if (this.irf == null) {
            this.irf = new g();
        }
        sendFrame(this.irf);
    }

    public boolean hasBufferedData() {
        return !this.iqO.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        if (!$assertionsDisabled && getReadyState() == WebSocket.READYSTATE.CONNECTING) {
            throw new AssertionError("shall only be called once");
        }
        this.iqY = this.draft.b(bVar);
        this.irc = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.irc == null) {
            throw new AssertionError();
        }
        try {
            this.iqQ.onWebsocketHandshakeSentAsClient(this, this.iqY);
            ew(this.draft.a(this.iqY, this.iqW));
        } catch (RuntimeException e) {
            this.iqQ.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void n(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.iqO.add(byteBuffer);
        this.iqQ.onWriteDemand(this);
    }

    private void ew(List<ByteBuffer> list) {
        synchronized (ire) {
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
            this.iqQ.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.iqQ.onWebsocketError(this, e);
        }
    }

    public boolean isConnecting() {
        if ($assertionsDisabled || !this.iqT || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
            return getReadyState() == WebSocket.READYSTATE.CONNECTING;
        }
        throw new AssertionError();
    }

    public boolean isOpen() {
        if (!$assertionsDisabled && getReadyState() == WebSocket.READYSTATE.OPEN && this.iqT) {
            throw new AssertionError();
        }
        return getReadyState() == WebSocket.READYSTATE.OPEN;
    }

    public boolean isClosing() {
        return getReadyState() == WebSocket.READYSTATE.CLOSING;
    }

    public boolean isFlushAndClose() {
        return this.iqT;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.iqU;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.iqU = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.iqQ.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.iqQ.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long caH() {
        return this.ird;
    }

    public void caI() {
        this.ird = System.currentTimeMillis();
    }

    public d caJ() {
        return this.iqQ;
    }

    public <T> T getAttachment() {
        return (T) this.irg;
    }

    public <T> void setAttachment(T t) {
        this.irg = t;
    }
}
