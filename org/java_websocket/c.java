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
/* loaded from: classes9.dex */
public class c implements WebSocket {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static boolean DEBUG;
    public static int oij;
    private Draft draft;
    private g oiB;
    private Object oiC;
    public final BlockingQueue<ByteBuffer> oik;
    public final BlockingQueue<ByteBuffer> oil;
    private final d oim;
    public SelectionKey oin;
    public ByteChannel oio;
    private List<Draft> oir;
    private WebSocket.Role ois;
    private volatile boolean oip = false;
    private WebSocket.READYSTATE oiq = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer oit = ByteBuffer.allocate(0);
    private org.java_websocket.c.a oiu = null;
    private String oiv = null;
    private Integer oiw = null;
    private Boolean oix = null;
    private String oiy = null;
    private long oiz = System.currentTimeMillis();
    private final Object oiA = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        oij = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.ois == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.oik = new LinkedBlockingQueue();
        this.oil = new LinkedBlockingQueue();
        this.oim = dVar;
        this.ois = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.dXa();
        }
    }

    public void r(ByteBuffer byteBuffer) {
        if (!$assertionsDisabled && !byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
        if (DEBUG) {
            System.out.println("process(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining())) + '}');
        }
        if (getReadyState() != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                t(byteBuffer);
            }
        } else if (s(byteBuffer) && !isClosing() && !isClosed()) {
            if (!$assertionsDisabled && this.oit.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                t(byteBuffer);
            } else if (this.oit.hasRemaining()) {
                t(this.oit);
            }
        }
        if (!$assertionsDisabled && !isClosing() && !isFlushAndClose() && byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
    }

    private boolean s(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        f y;
        boolean z;
        if (this.oit.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.oit.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.oit.capacity() + byteBuffer.remaining());
                this.oit.flip();
                allocate.put(this.oit);
                this.oit = allocate;
            }
            this.oit.put(byteBuffer);
            this.oit.flip();
            byteBuffer2 = this.oit;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.oit.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.oit = ByteBuffer.allocate(preferedSize);
                this.oit.put(byteBuffer);
            } else {
                this.oit.position(this.oit.limit());
                this.oit.limit(this.oit.capacity());
            }
        }
        if (this.ois == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.oir) {
                    Draft dXa = draft.dXa();
                    try {
                        dXa.a(this.ois);
                        byteBuffer2.reset();
                        y = dXa.y(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(y instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) y;
                        if (dXa.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.oiy = aVar.getResourceDescriptor();
                            try {
                                write(dXa.a(dXa.a(aVar, this.oim.onWebsocketHandshakeReceivedAsServer(this, dXa, aVar)), this.ois));
                                this.draft = dXa;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.oim.onWebsocketError(this, e4);
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
            f y2 = this.draft.y(byteBuffer2);
            if (!(y2 instanceof org.java_websocket.c.a)) {
                q(1002, "wrong http function", false);
                return false;
            }
            org.java_websocket.c.a aVar2 = (org.java_websocket.c.a) y2;
            if (this.draft.a(aVar2) == Draft.HandshakeState.MATCHED) {
                a(aVar2);
                return true;
            }
            close(1002, "the handshake did finaly not match");
            return false;
        }
        if (this.ois == WebSocket.Role.CLIENT) {
            this.draft.a(this.ois);
            f y3 = this.draft.y(byteBuffer2);
            if (!(y3 instanceof h)) {
                q(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) y3;
            if (this.draft.a(this.oiu, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.oim.onWebsocketHandshakeReceivedAsClient(this, this.oiu, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.oim.onWebsocketError(this, e6);
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

    private void t(ByteBuffer byteBuffer) {
        try {
            for (Framedata framedata : this.draft.x(byteBuffer)) {
                if (DEBUG) {
                    System.out.println("matched frame: " + framedata);
                }
                this.draft.a(this, framedata);
            }
        } catch (InvalidDataException e) {
            this.oim.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        u(LL(404));
        q(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        u(LL(500));
        q(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer LL(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.Rs("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void o(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.oiq != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    q(i, str, false);
                } else {
                    if (this.draft.dWZ() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.oim.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.oim.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.oim.onWebsocketError(this, e2);
                                q(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.dXk();
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
            this.oit = null;
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
            if (this.oin != null) {
                this.oin.cancel();
            }
            if (this.oio != null) {
                try {
                    this.oio.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.oim.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.oim.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.oim.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.oiu = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void aj(int i, boolean z) {
        p(i, "", z);
    }

    public void closeConnection(int i, String str) {
        p(i, str, false);
    }

    public synchronized void q(int i, String str, boolean z) {
        if (!this.oip) {
            this.oiw = Integer.valueOf(i);
            this.oiv = str;
            this.oix = Boolean.valueOf(z);
            this.oip = true;
            this.oim.onWriteDemand(this);
            try {
                this.oim.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.oim.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.oiu = null;
        }
    }

    public void dWV() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            aj(-1, true);
        } else if (this.oip) {
            p(this.oiw.intValue(), this.oiv, this.oix.booleanValue());
        } else if (this.draft.dWZ() == Draft.CloseHandshakeType.NONE) {
            aj(1000, true);
        } else if (this.draft.dWZ() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.ois == WebSocket.Role.SERVER) {
                aj(1006, true);
            } else {
                aj(1000, true);
            }
        } else {
            aj(1006, true);
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
        r(this.draft.bc(str, this.ois == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        r(this.draft.b(byteBuffer, this.ois == WebSocket.Role.CLIENT));
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
        if (this.oiB == null) {
            this.oiB = new g();
        }
        sendFrame(this.oiB);
    }

    public boolean hasBufferedData() {
        return !this.oik.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.oiu = this.draft.b(bVar);
        this.oiy = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.oiy == null) {
            throw new AssertionError();
        }
        try {
            this.oim.onWebsocketHandshakeSentAsClient(this, this.oiu);
            write(this.draft.a(this.oiu, this.ois));
        } catch (RuntimeException e) {
            this.oim.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void u(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.oik.add(byteBuffer);
        this.oim.onWriteDemand(this);
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.oiA) {
            for (ByteBuffer byteBuffer : list) {
                u(byteBuffer);
            }
        }
    }

    private void a(f fVar) {
        if (DEBUG) {
            System.out.println("open using draft: " + this.draft);
        }
        a(WebSocket.READYSTATE.OPEN);
        try {
            this.oim.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.oim.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.oip || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.oip;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.oiq;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.oiq = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.oim.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.oim.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long dWW() {
        return this.oiz;
    }

    public void dWX() {
        this.oiz = System.currentTimeMillis();
    }

    public d dWY() {
        return this.oim;
    }

    public <T> T getAttachment() {
        return (T) this.oiC;
    }

    public <T> void setAttachment(T t) {
        this.oiC = t;
    }
}
