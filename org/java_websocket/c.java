package org.java_websocket;

import android.support.v4.view.PointerIconCompat;
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
    public static int jUd;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> jUe;
    public final BlockingQueue<ByteBuffer> jUf;
    private final d jUg;
    public SelectionKey jUh;
    public ByteChannel jUi;
    private List<Draft> jUl;
    private WebSocket.Role jUm;
    private g jUv;
    private Object jUw;
    private volatile boolean jUj = false;
    private WebSocket.READYSTATE jUk = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer jUn = ByteBuffer.allocate(0);
    private org.java_websocket.c.a jUo = null;
    private String jUp = null;
    private Integer jUq = null;
    private Boolean jUr = null;
    private String jUs = null;
    private long jUt = System.currentTimeMillis();
    private final Object jUu = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        jUd = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.jUm == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.jUe = new LinkedBlockingQueue();
        this.jUf = new LinkedBlockingQueue();
        this.jUg = dVar;
        this.jUm = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.cDb();
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
            if (!$assertionsDisabled && this.jUn.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                m(byteBuffer);
            } else if (this.jUn.hasRemaining()) {
                m(this.jUn);
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
        if (this.jUn.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.jUn.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.jUn.capacity() + byteBuffer.remaining());
                this.jUn.flip();
                allocate.put(this.jUn);
                this.jUn = allocate;
            }
            this.jUn.put(byteBuffer);
            this.jUn.flip();
            byteBuffer2 = this.jUn;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.jUn.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.jUn = ByteBuffer.allocate(preferedSize);
                this.jUn.put(byteBuffer);
            } else {
                this.jUn.position(this.jUn.limit());
                this.jUn.limit(this.jUn.capacity());
            }
        }
        if (this.jUm == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.jUl) {
                    Draft cDb = draft.cDb();
                    try {
                        cDb.a(this.jUm);
                        byteBuffer2.reset();
                        r = cDb.r(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(r instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) r;
                        if (cDb.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.jUs = aVar.getResourceDescriptor();
                            try {
                                eE(cDb.a(cDb.a(aVar, this.jUg.onWebsocketHandshakeReceivedAsServer(this, cDb, aVar)), this.jUm));
                                this.draft = cDb;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.jUg.onWebsocketError(this, e4);
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
                k(1002, "wrong http function", false);
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
        if (this.jUm == WebSocket.Role.CLIENT) {
            this.draft.a(this.jUm);
            f r3 = this.draft.r(byteBuffer2);
            if (!(r3 instanceof h)) {
                k(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) r3;
            if (this.draft.a(this.jUo, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.jUg.onWebsocketHandshakeReceivedAsClient(this, this.jUo, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.jUg.onWebsocketError(this, e6);
                    k(-1, e6.getMessage(), false);
                    return false;
                } catch (InvalidDataException e7) {
                    k(e7.getCloseCode(), e7.getMessage(), false);
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
            this.jUg.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        n(Dn(404));
        k(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        n(Dn(500));
        k(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer Dn(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.FF("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void i(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.jUk != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    k(i, str, false);
                } else {
                    if (this.draft.cDa() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.jUg.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.jUg.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.jUg.onWebsocketError(this, e2);
                                k(PointerIconCompat.TYPE_CELL, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.cDl();
                            sendFrame(bVar);
                        }
                    }
                    k(i, str, z);
                }
            } else if (i == -3) {
                if (!$assertionsDisabled && !z) {
                    throw new AssertionError();
                }
                k(-3, str, true);
            } else if (i == 1002) {
                k(i, str, z);
            } else {
                k(-1, str, false);
            }
            a(WebSocket.READYSTATE.CLOSING);
            this.jUn = null;
        }
    }

    public void close(int i, String str) {
        i(i, str, false);
    }

    public synchronized void j(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN && i == 1006) {
                a(WebSocket.READYSTATE.CLOSING);
            }
            if (this.jUh != null) {
                this.jUh.cancel();
            }
            if (this.jUi != null) {
                try {
                    this.jUi.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.jUg.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.jUg.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.jUg.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.jUo = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void S(int i, boolean z) {
        j(i, "", z);
    }

    public void closeConnection(int i, String str) {
        j(i, str, false);
    }

    public synchronized void k(int i, String str, boolean z) {
        if (!this.jUj) {
            this.jUq = Integer.valueOf(i);
            this.jUp = str;
            this.jUr = Boolean.valueOf(z);
            this.jUj = true;
            this.jUg.onWriteDemand(this);
            try {
                this.jUg.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.jUg.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.jUo = null;
        }
    }

    public void cCW() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            S(-1, true);
        } else if (this.jUj) {
            j(this.jUq.intValue(), this.jUp, this.jUr.booleanValue());
        } else if (this.draft.cDa() == Draft.CloseHandshakeType.NONE) {
            S(1000, true);
        } else if (this.draft.cDa() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.jUm == WebSocket.Role.SERVER) {
                S(PointerIconCompat.TYPE_CELL, true);
            } else {
                S(1000, true);
            }
        } else {
            S(PointerIconCompat.TYPE_CELL, true);
        }
    }

    public void close(int i) {
        i(i, "", false);
    }

    public void b(InvalidDataException invalidDataException) {
        i(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    public void send(String str) throws WebsocketNotConnectedException {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        l(this.draft.az(str, this.jUm == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        l(this.draft.b(byteBuffer, this.jUm == WebSocket.Role.CLIENT));
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
        eE(arrayList);
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
        if (this.jUv == null) {
            this.jUv = new g();
        }
        sendFrame(this.jUv);
    }

    public boolean hasBufferedData() {
        return !this.jUe.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.jUo = this.draft.b(bVar);
        this.jUs = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.jUs == null) {
            throw new AssertionError();
        }
        try {
            this.jUg.onWebsocketHandshakeSentAsClient(this, this.jUo);
            eE(this.draft.a(this.jUo, this.jUm));
        } catch (RuntimeException e) {
            this.jUg.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void n(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.jUe.add(byteBuffer);
        this.jUg.onWriteDemand(this);
    }

    private void eE(List<ByteBuffer> list) {
        synchronized (this.jUu) {
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
            this.jUg.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.jUg.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.jUj || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.jUj;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.jUk;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.jUk = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.jUg.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.jUg.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long cCX() {
        return this.jUt;
    }

    public void cCY() {
        this.jUt = System.currentTimeMillis();
    }

    public d cCZ() {
        return this.jUg;
    }

    public <T> T getAttachment() {
        return (T) this.jUw;
    }

    public <T> void setAttachment(T t) {
        this.jUw = t;
    }
}
