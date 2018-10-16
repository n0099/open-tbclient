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
    public static int iqM;
    private static final Object ird;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> iqN;
    public final BlockingQueue<ByteBuffer> iqO;
    private final d iqP;
    public SelectionKey iqQ;
    public ByteChannel iqR;
    private List<Draft> iqU;
    private WebSocket.Role iqV;
    private g ire;
    private Object irf;
    private volatile boolean iqS = false;
    private WebSocket.READYSTATE iqT = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer iqW = ByteBuffer.allocate(0);
    private org.java_websocket.c.a iqX = null;
    private String iqY = null;
    private Integer iqZ = null;
    private Boolean ira = null;
    private String irb = null;
    private long irc = System.currentTimeMillis();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        iqM = 16384;
        DEBUG = false;
        ird = new Object();
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.iqV == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.iqN = new LinkedBlockingQueue();
        this.iqO = new LinkedBlockingQueue();
        this.iqP = dVar;
        this.iqV = WebSocket.Role.CLIENT;
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
            if (!$assertionsDisabled && this.iqW.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                m(byteBuffer);
            } else if (this.iqW.hasRemaining()) {
                m(this.iqW);
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
        if (this.iqW.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.iqW.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.iqW.capacity() + byteBuffer.remaining());
                this.iqW.flip();
                allocate.put(this.iqW);
                this.iqW = allocate;
            }
            this.iqW.put(byteBuffer);
            this.iqW.flip();
            byteBuffer2 = this.iqW;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.iqW.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.iqW = ByteBuffer.allocate(preferedSize);
                this.iqW.put(byteBuffer);
            } else {
                this.iqW.position(this.iqW.limit());
                this.iqW.limit(this.iqW.capacity());
            }
        }
        if (this.iqV == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.iqU) {
                    Draft caL = draft.caL();
                    try {
                        caL.a(this.iqV);
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
                            this.irb = aVar.getResourceDescriptor();
                            try {
                                ew(caL.a(caL.a(aVar, this.iqP.onWebsocketHandshakeReceivedAsServer(this, caL, aVar)), this.iqV));
                                this.draft = caL;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.iqP.onWebsocketError(this, e4);
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
        if (this.iqV == WebSocket.Role.CLIENT) {
            this.draft.a(this.iqV);
            f r3 = this.draft.r(byteBuffer2);
            if (!(r3 instanceof h)) {
                j(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) r3;
            if (this.draft.a(this.iqX, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.iqP.onWebsocketHandshakeReceivedAsClient(this, this.iqX, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.iqP.onWebsocketError(this, e6);
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
            this.iqP.onWebsocketError(this, e);
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
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.iqT != WebSocket.READYSTATE.CLOSED) {
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
                                    this.iqP.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.iqP.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.iqP.onWebsocketError(this, e2);
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
            this.iqW = null;
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
            if (this.iqQ != null) {
                this.iqQ.cancel();
            }
            if (this.iqR != null) {
                try {
                    this.iqR.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.iqP.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.iqP.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.iqP.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.iqX = null;
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
        if (!this.iqS) {
            this.iqZ = Integer.valueOf(i);
            this.iqY = str;
            this.ira = Boolean.valueOf(z);
            this.iqS = true;
            this.iqP.onWriteDemand(this);
            try {
                this.iqP.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.iqP.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.iqX = null;
        }
    }

    public void caG() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            M(-1, true);
        } else if (this.iqS) {
            i(this.iqZ.intValue(), this.iqY, this.ira.booleanValue());
        } else if (this.draft.caK() == Draft.CloseHandshakeType.NONE) {
            M(1000, true);
        } else if (this.draft.caK() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.iqV == WebSocket.Role.SERVER) {
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
        i(this.draft.ah(str, this.iqV == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        i(this.draft.b(byteBuffer, this.iqV == WebSocket.Role.CLIENT));
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
        if (this.ire == null) {
            this.ire = new g();
        }
        sendFrame(this.ire);
    }

    public boolean hasBufferedData() {
        return !this.iqN.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        if (!$assertionsDisabled && getReadyState() == WebSocket.READYSTATE.CONNECTING) {
            throw new AssertionError("shall only be called once");
        }
        this.iqX = this.draft.b(bVar);
        this.irb = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.irb == null) {
            throw new AssertionError();
        }
        try {
            this.iqP.onWebsocketHandshakeSentAsClient(this, this.iqX);
            ew(this.draft.a(this.iqX, this.iqV));
        } catch (RuntimeException e) {
            this.iqP.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void n(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.iqN.add(byteBuffer);
        this.iqP.onWriteDemand(this);
    }

    private void ew(List<ByteBuffer> list) {
        synchronized (ird) {
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
            this.iqP.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.iqP.onWebsocketError(this, e);
        }
    }

    public boolean isConnecting() {
        if ($assertionsDisabled || !this.iqS || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
            return getReadyState() == WebSocket.READYSTATE.CONNECTING;
        }
        throw new AssertionError();
    }

    public boolean isOpen() {
        if (!$assertionsDisabled && getReadyState() == WebSocket.READYSTATE.OPEN && this.iqS) {
            throw new AssertionError();
        }
        return getReadyState() == WebSocket.READYSTATE.OPEN;
    }

    public boolean isClosing() {
        return getReadyState() == WebSocket.READYSTATE.CLOSING;
    }

    public boolean isFlushAndClose() {
        return this.iqS;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.iqT;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.iqT = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.iqP.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.iqP.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long caH() {
        return this.irc;
    }

    public void caI() {
        this.irc = System.currentTimeMillis();
    }

    public d caJ() {
        return this.iqP;
    }

    public <T> T getAttachment() {
        return (T) this.irf;
    }

    public <T> void setAttachment(T t) {
        this.irf = t;
    }
}
