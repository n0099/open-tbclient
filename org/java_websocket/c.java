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
/* loaded from: classes4.dex */
public class c implements WebSocket {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static boolean DEBUG;
    public static int nbZ;
    private Draft draft;
    public final BlockingQueue<ByteBuffer> nca;
    public final BlockingQueue<ByteBuffer> ncb;
    private final d ncc;
    public SelectionKey ncd;
    public ByteChannel nce;
    private List<Draft> nch;
    private WebSocket.Role nci;
    private g ncr;
    private Object ncs;
    private volatile boolean ncf = false;
    private WebSocket.READYSTATE ncg = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private ByteBuffer ncj = ByteBuffer.allocate(0);
    private org.java_websocket.c.a nck = null;
    private String ncl = null;
    private Integer ncm = null;
    private Boolean ncn = null;
    private String nco = null;
    private long ncp = System.currentTimeMillis();
    private final Object ncq = new Object();

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        nbZ = 16384;
        DEBUG = false;
    }

    public c(d dVar, Draft draft) {
        this.draft = null;
        if (dVar == null || (draft == null && this.nci == WebSocket.Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.nca = new LinkedBlockingQueue();
        this.ncb = new LinkedBlockingQueue();
        this.ncc = dVar;
        this.nci = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.draft = draft.dFw();
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
            if (!$assertionsDisabled && this.ncj.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                n(byteBuffer);
            } else if (this.ncj.hasRemaining()) {
                n(this.ncj);
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
        if (this.ncj.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.ncj.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.ncj.capacity() + byteBuffer.remaining());
                this.ncj.flip();
                allocate.put(this.ncj);
                this.ncj = allocate;
            }
            this.ncj.put(byteBuffer);
            this.ncj.flip();
            byteBuffer2 = this.ncj;
        }
        byteBuffer2.mark();
        try {
            try {
            } catch (InvalidHandshakeException e) {
                b(e);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.ncj.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!$assertionsDisabled && e2.getPreferedSize() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                this.ncj = ByteBuffer.allocate(preferedSize);
                this.ncj.put(byteBuffer);
            } else {
                this.ncj.position(this.ncj.limit());
                this.ncj.limit(this.ncj.capacity());
            }
        }
        if (this.nci == WebSocket.Role.SERVER) {
            if (this.draft == null) {
                for (Draft draft : this.nch) {
                    Draft dFw = draft.dFw();
                    try {
                        dFw.a(this.nci);
                        byteBuffer2.reset();
                        s = dFw.s(byteBuffer2);
                    } catch (InvalidHandshakeException e3) {
                    }
                    if (!(s instanceof org.java_websocket.c.a)) {
                        a(new InvalidDataException(1002, "wrong http function"));
                        z = false;
                    } else {
                        org.java_websocket.c.a aVar = (org.java_websocket.c.a) s;
                        if (dFw.a(aVar) == Draft.HandshakeState.MATCHED) {
                            this.nco = aVar.getResourceDescriptor();
                            try {
                                fE(dFw.a(dFw.a(aVar, this.ncc.onWebsocketHandshakeReceivedAsServer(this, dFw, aVar)), this.nci));
                                this.draft = dFw;
                                a(aVar);
                                z = true;
                            } catch (RuntimeException e4) {
                                this.ncc.onWebsocketError(this, e4);
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
                p(1002, "wrong http function", false);
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
        if (this.nci == WebSocket.Role.CLIENT) {
            this.draft.a(this.nci);
            f s3 = this.draft.s(byteBuffer2);
            if (!(s3 instanceof h)) {
                p(1002, "wrong http function", false);
                return false;
            }
            h hVar = (h) s3;
            if (this.draft.a(this.nck, hVar) == Draft.HandshakeState.MATCHED) {
                try {
                    this.ncc.onWebsocketHandshakeReceivedAsClient(this, this.nck, hVar);
                    a(hVar);
                    return true;
                } catch (RuntimeException e6) {
                    this.ncc.onWebsocketError(this, e6);
                    p(-1, e6.getMessage(), false);
                    return false;
                } catch (InvalidDataException e7) {
                    p(e7.getCloseCode(), e7.getMessage(), false);
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
            this.ncc.onWebsocketError(this, e);
            b(e);
        }
    }

    private void a(InvalidDataException invalidDataException) {
        o(Na(404));
        p(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        o(Na(500));
        p(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer Na(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(org.java_websocket.e.c.Ox("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void n(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSING && this.ncg != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN) {
                if (i == 1006) {
                    if (!$assertionsDisabled && z) {
                        throw new AssertionError();
                    }
                    a(WebSocket.READYSTATE.CLOSING);
                    p(i, str, false);
                } else {
                    if (this.draft.dFv() != Draft.CloseHandshakeType.NONE) {
                        if (!z) {
                            try {
                                try {
                                    this.ncc.onWebsocketCloseInitiated(this, i, str);
                                } catch (RuntimeException e) {
                                    this.ncc.onWebsocketError(this, e);
                                }
                            } catch (InvalidDataException e2) {
                                this.ncc.onWebsocketError(this, e2);
                                p(1006, "generated frame is invalid", false);
                            }
                        }
                        if (isOpen()) {
                            org.java_websocket.framing.b bVar = new org.java_websocket.framing.b();
                            bVar.setReason(str);
                            bVar.setCode(i);
                            bVar.dFG();
                            sendFrame(bVar);
                        }
                    }
                    p(i, str, z);
                }
            } else if (i == -3) {
                if (!$assertionsDisabled && !z) {
                    throw new AssertionError();
                }
                p(-3, str, true);
            } else if (i == 1002) {
                p(i, str, z);
            } else {
                p(-1, str, false);
            }
            a(WebSocket.READYSTATE.CLOSING);
            this.ncj = null;
        }
    }

    public void close(int i, String str) {
        n(i, str, false);
    }

    public synchronized void o(int i, String str, boolean z) {
        if (getReadyState() != WebSocket.READYSTATE.CLOSED) {
            if (getReadyState() == WebSocket.READYSTATE.OPEN && i == 1006) {
                a(WebSocket.READYSTATE.CLOSING);
            }
            if (this.ncd != null) {
                this.ncd.cancel();
            }
            if (this.nce != null) {
                try {
                    this.nce.close();
                } catch (IOException e) {
                    if (e.getMessage().equals("Broken pipe")) {
                        if (DEBUG) {
                            System.out.println("Caught IOException: Broken pipe during closeConnection()");
                        }
                    } else {
                        this.ncc.onWebsocketError(this, e);
                    }
                }
            }
            try {
                this.ncc.onWebsocketClose(this, i, str, z);
            } catch (RuntimeException e2) {
                this.ncc.onWebsocketError(this, e2);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.nck = null;
            a(WebSocket.READYSTATE.CLOSED);
        }
    }

    protected void ah(int i, boolean z) {
        o(i, "", z);
    }

    public void closeConnection(int i, String str) {
        o(i, str, false);
    }

    public synchronized void p(int i, String str, boolean z) {
        if (!this.ncf) {
            this.ncm = Integer.valueOf(i);
            this.ncl = str;
            this.ncn = Boolean.valueOf(z);
            this.ncf = true;
            this.ncc.onWriteDemand(this);
            try {
                this.ncc.onWebsocketClosing(this, i, str, z);
            } catch (RuntimeException e) {
                this.ncc.onWebsocketError(this, e);
            }
            if (this.draft != null) {
                this.draft.reset();
            }
            this.nck = null;
        }
    }

    public void dFr() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            ah(-1, true);
        } else if (this.ncf) {
            o(this.ncm.intValue(), this.ncl, this.ncn.booleanValue());
        } else if (this.draft.dFv() == Draft.CloseHandshakeType.NONE) {
            ah(1000, true);
        } else if (this.draft.dFv() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.nci == WebSocket.Role.SERVER) {
                ah(1006, true);
            } else {
                ah(1000, true);
            }
        } else {
            ah(1006, true);
        }
    }

    public void close(int i) {
        n(i, "", false);
    }

    public void b(InvalidDataException invalidDataException) {
        n(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    public void send(String str) throws WebsocketNotConnectedException {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        o(this.draft.aP(str, this.nci == WebSocket.Role.CLIENT));
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        o(this.draft.b(byteBuffer, this.nci == WebSocket.Role.CLIENT));
    }

    public void send(byte[] bArr) throws IllegalArgumentException, WebsocketNotConnectedException {
        send(ByteBuffer.wrap(bArr));
    }

    private void o(Collection<Framedata> collection) {
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
        fE(arrayList);
    }

    public void sendFragmentedFrame(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        o(this.draft.a(opcode, byteBuffer, z));
    }

    public void sendFrame(Collection<Framedata> collection) {
        o(collection);
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        o(Collections.singletonList(framedata));
    }

    public void sendPing() throws NotYetConnectedException {
        if (this.ncr == null) {
            this.ncr = new g();
        }
        sendFrame(this.ncr);
    }

    public boolean hasBufferedData() {
        return !this.nca.isEmpty();
    }

    public void a(org.java_websocket.c.b bVar) throws InvalidHandshakeException {
        this.nck = this.draft.b(bVar);
        this.nco = bVar.getResourceDescriptor();
        if (!$assertionsDisabled && this.nco == null) {
            throw new AssertionError();
        }
        try {
            this.ncc.onWebsocketHandshakeSentAsClient(this, this.nck);
            fE(this.draft.a(this.nck, this.nci));
        } catch (RuntimeException e) {
            this.ncc.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of" + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void o(ByteBuffer byteBuffer) {
        if (DEBUG) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + '}');
        }
        this.nca.add(byteBuffer);
        this.ncc.onWriteDemand(this);
    }

    private void fE(List<ByteBuffer> list) {
        synchronized (this.ncq) {
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
            this.ncc.onWebsocketOpen(this, fVar);
        } catch (RuntimeException e) {
            this.ncc.onWebsocketError(this, e);
        }
    }

    @Deprecated
    public boolean isConnecting() {
        if ($assertionsDisabled || !this.ncf || getReadyState() == WebSocket.READYSTATE.CONNECTING) {
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
        return this.ncf;
    }

    public boolean isClosed() {
        return getReadyState() == WebSocket.READYSTATE.CLOSED;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.ncg;
    }

    private void a(WebSocket.READYSTATE readystate) {
        this.ncg = readystate;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.ncc.getRemoteSocketAddress(this);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.ncc.getLocalSocketAddress(this);
    }

    public void close() {
        close(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long dFs() {
        return this.ncp;
    }

    public void dFt() {
        this.ncp = System.currentTimeMillis();
    }

    public d dFu() {
        return this.ncc;
    }

    public <T> T getAttachment() {
        return (T) this.ncs;
    }

    public <T> void setAttachment(T t) {
        this.ncs = t;
    }
}
