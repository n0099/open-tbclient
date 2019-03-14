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
    public static int jTV;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> jTW;
    public final BlockingQueue<ByteBuffer> jTX;
    private final d jTY;
    public SelectionKey jTZ;
    public ByteChannel jUa;
    private List<Draft> jUd;
    private WebSocket.Role jUe;
    private g jUn;
    private Object jUo;
    private volatile boolean jUb = false;
    private WebSocket.READYSTATE jUc = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer jUf = ByteBuffer.allocate(0);
    private org.java_websocket.c.a jUg = null;
    private String jUh = null;
    private Integer jUi = null;
    private Boolean jUj = null;
    private String jUk = null;
    private long jUl = System.currentTimeMillis();
    private final Object jUm = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        jTV = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.jUe == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.jTW = new LinkedBlockingQueue();
        this.jTX = new LinkedBlockingQueue();
        this.jTY = dVar;
        this.jUe = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.cDe();
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
            if (!$assertionsDisabled && this.jUf.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                m(byteBuffer);
            } else if (this.jUf.hasRemaining()) {
                m(this.jUf);
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
        if (this.jUf.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.jUf.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.jUf.capacity() + byteBuffer.remaining());
                this.jUf.flip();
                allocate.put(this.jUf);
                this.jUf = allocate;
            }
            this.jUf.put(byteBuffer);
            this.jUf.flip();
            byteBuffer2 = this.jUf;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.jUf.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.jUf = ByteBuffer.allocate(preferedSize);
                this.jUf.put(byteBuffer);
            } else {
                this.jUf.position(this.jUf.limit());
                this.jUf.limit(this.jUf.capacity());
            }
        }
        if (this.jUe == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.jUd) {
                    Draft cDe = draft.cDe();
                    try {
                        cDe.a(this.jUe);
                        byteBuffer2.reset();
                        r = cDe.r(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(r instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) r;
                        if (cDe.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.jUk = aVar.getResourceDescriptor();
                            try {
                                eE(cDe.a(cDe.a(aVar, this.jTY.onWebsocketHandshakeReceivedAsServer(this, cDe, aVar)), this.jUe));
                                this.draft = cDe;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.jTY.onWebsocketError(this, e4);
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
        if (this.jUe == WebSocket.Role.CLIENT) {
            this.draft.a(this.jUe);
            f r3 = this.draft.r(byteBuffer2);
            if (!(r3 instanceof h)) {
                k(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) r3;
            if (this.draft.a(this.jUg, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.jTY.onWebsocketHandshakeReceivedAsClient(this, this.jUg, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.jTY.onWebsocketError(this, e6);
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
            this.jTY.onWebsocketError(this, e);
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
        return ByteBuffer.wrap(org.java_websocket.e.c.FD("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void i(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.jUc != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    k(i, str, false);
                } else {
                    if (this.draft.cDd() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.jTY.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.jTY.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.jTY.onWebsocketError(this, e2);
                                k(PointerIconCompat.TYPE_CELL, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.cDo();
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
            this.jUf = null;
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
            if (this.jTZ != null) {
                this.jTZ.cancel();
            }
            if (this.jUa != null) {
                try {
                    this.jUa.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.jTY.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.jTY.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.jTY.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.jUg = null;
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
        if (!this.jUb) {
            this.jUi = Integer.valueOf(i);
            this.jUh = str;
            this.jUj = Boolean.valueOf(z);
            this.jUb = true;
            this.jTY.onWriteDemand(this);
            try {
                this.jTY.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.jTY.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.jUg = null;
        }
    }

    public void cCZ() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            S(-1, true);
        } else if (this.jUb) {
            j(this.jUi.intValue(), this.jUh, this.jUj.booleanValue());
        } else if (this.draft.cDd() == Draft.CloseHandshakeType.NONE) {
            S(1000, true);
        } else if (this.draft.cDd() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.jUe == WebSocket.Role.SERVER) {
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
        l(this.draft.az(str, this.jUe == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        l(this.draft.b(byteBuffer, this.jUe == WebSocket.Role.CLIENT));
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
        if (this.jUn == null) {
            this.jUn = new g();
        }
        sendFrame(this.jUn);
    }

    public boolean hasBufferedData() {
        return !this.jTW.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.jUg = this.draft.b(bVar);
        this.jUk = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.jUk == null) {
            throw new AssertionError();
        }
        try {
            this.jTY.onWebsocketHandshakeSentAsClient(this, this.jUg);
            eE(this.draft.a(this.jUg, this.jUe));
        } catch (RuntimeException e) {
            this.jTY.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void n(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.jTW.add(byteBuffer);
        this.jTY.onWriteDemand(this);
    }

    private void eE(List<ByteBuffer> list) {
        synchronized (this.jUm) {
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
            this.jTY.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.jTY.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.jUb || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.jUb;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.jUc;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.jUc = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.jTY.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.jTY.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long cDa() {
        return this.jUl;
    }

    public void cDb() {
        this.jUl = System.currentTimeMillis();
    }

    public d cDc() {
        return this.jTY;
    }

    public <T> T getAttachment() {
        return (T) this.jUo;
    }

    public <T> void setAttachment(T t) {
        this.jUo = t;
    }
}
