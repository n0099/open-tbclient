package org.java_websocket.drafts;

import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.http.protocol.HTTP;
import org.java_websocket.WebSocket;
import org.java_websocket.c.b;
import org.java_websocket.c.c;
import org.java_websocket.c.d;
import org.java_websocket.c.e;
import org.java_websocket.c.f;
import org.java_websocket.c.h;
import org.java_websocket.c.i;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExedeedException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class Draft {
    public static int irh = 1000;
    public static int iri = 64;
    protected WebSocket.Role iqV = null;
    protected Framedata.Opcode irj = null;

    /* loaded from: classes2.dex */
    public enum CloseHandshakeType {
        NONE,
        ONEWAY,
        TWOWAY
    }

    /* loaded from: classes2.dex */
    public enum HandshakeState {
        MATCHED,
        NOT_MATCHED
    }

    public abstract ByteBuffer a(Framedata framedata);

    public abstract c a(org.java_websocket.c.a aVar, i iVar) throws InvalidHandshakeException;

    public abstract HandshakeState a(org.java_websocket.c.a aVar) throws InvalidHandshakeException;

    public abstract HandshakeState a(org.java_websocket.c.a aVar, h hVar) throws InvalidHandshakeException;

    public abstract void a(org.java_websocket.c cVar, Framedata framedata) throws InvalidDataException;

    public abstract List<Framedata> ah(String str, boolean z);

    public abstract List<Framedata> b(ByteBuffer byteBuffer, boolean z);

    public abstract b b(b bVar) throws InvalidHandshakeException;

    public abstract CloseHandshakeType caK();

    public abstract Draft caL();

    public abstract List<Framedata> q(ByteBuffer byteBuffer) throws InvalidDataException;

    public abstract void reset();

    public static ByteBuffer o(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b = 48;
        while (byteBuffer.hasRemaining()) {
            byte b2 = byteBuffer.get();
            allocate.put(b2);
            if (b == 13 && b2 == 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                return allocate;
            }
            b = b2;
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        return null;
    }

    public static String p(ByteBuffer byteBuffer) {
        ByteBuffer o = o(byteBuffer);
        if (o == null) {
            return null;
        }
        return org.java_websocket.e.c.n(o.array(), 0, o.limit());
    }

    public static c a(ByteBuffer byteBuffer, WebSocket.Role role) throws InvalidHandshakeException, IncompleteHandshakeException {
        i iVar;
        String p = p(byteBuffer);
        if (p == null) {
            throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
        }
        String[] split = p.split(" ", 3);
        if (split.length != 3) {
            throw new InvalidHandshakeException();
        }
        if (role == WebSocket.Role.CLIENT) {
            if (!"101".equals(split[1])) {
                throw new InvalidHandshakeException("Invalid status code received: " + split[1] + " Status line: " + p);
            }
            if (!"HTTP/1.1".equalsIgnoreCase(split[0])) {
                throw new InvalidHandshakeException("Invalid status line received: " + split[0] + " Status line: " + p);
            }
            i eVar = new e();
            i iVar2 = eVar;
            iVar2.j(Short.parseShort(split[1]));
            iVar2.zd(split[2]);
            iVar = eVar;
        } else if (!"GET".equalsIgnoreCase(split[0])) {
            throw new InvalidHandshakeException("Invalid request method received: " + split[0] + " Status line: " + p);
        } else {
            if (!"HTTP/1.1".equalsIgnoreCase(split[2])) {
                throw new InvalidHandshakeException("Invalid status line received: " + split[2] + " Status line: " + p);
            }
            d dVar = new d();
            dVar.zc(split[1]);
            iVar = dVar;
        }
        String p2 = p(byteBuffer);
        while (p2 != null && p2.length() > 0) {
            String[] split2 = p2.split(":", 2);
            if (split2.length != 2) {
                throw new InvalidHandshakeException("not an http header");
            }
            if (iVar.zf(split2[0])) {
                iVar.put(split2[0], iVar.ze(split2[0]) + "; " + split2[1].replaceFirst("^ +", ""));
            } else {
                iVar.put(split2[0], split2[1].replaceFirst("^ +", ""));
            }
            p2 = p(byteBuffer);
        }
        if (p2 == null) {
            throw new IncompleteHandshakeException();
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(f fVar) {
        return fVar.ze("Upgrade").equalsIgnoreCase("websocket") && fVar.ze(HTTP.CONN_DIRECTIVE).toLowerCase(Locale.ENGLISH).contains(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
    }

    public List<Framedata> a(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        org.java_websocket.framing.f iVar;
        if (opcode != Framedata.Opcode.BINARY && opcode != Framedata.Opcode.TEXT) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        if (this.irj != null) {
            iVar = new org.java_websocket.framing.c();
        } else {
            this.irj = opcode;
            if (opcode == Framedata.Opcode.BINARY) {
                iVar = new org.java_websocket.framing.a();
            } else {
                iVar = opcode == Framedata.Opcode.TEXT ? new org.java_websocket.framing.i() : null;
            }
        }
        iVar.t(byteBuffer);
        iVar.oT(z);
        try {
            iVar.caV();
            if (z) {
                this.irj = null;
            } else {
                this.irj = opcode;
            }
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<ByteBuffer> a(f fVar, WebSocket.Role role) {
        return a(fVar, role, true);
    }

    public List<ByteBuffer> a(f fVar, WebSocket.Role role, boolean z) {
        StringBuilder sb = new StringBuilder(100);
        if (fVar instanceof org.java_websocket.c.a) {
            sb.append("GET ");
            sb.append(((org.java_websocket.c.a) fVar).getResourceDescriptor());
            sb.append(" HTTP/1.1");
        } else if (fVar instanceof h) {
            sb.append("HTTP/1.1 101 ").append(((h) fVar).cbd());
        } else {
            throw new IllegalArgumentException("unknown role");
        }
        sb.append(SystemInfoUtil.LINE_END);
        Iterator<String> cbe = fVar.cbe();
        while (cbe.hasNext()) {
            String next = cbe.next();
            String ze = fVar.ze(next);
            sb.append(next);
            sb.append(": ");
            sb.append(ze);
            sb.append(SystemInfoUtil.LINE_END);
        }
        sb.append(SystemInfoUtil.LINE_END);
        byte[] yz = org.java_websocket.e.c.yz(sb.toString());
        byte[] content = z ? fVar.getContent() : null;
        ByteBuffer allocate = ByteBuffer.allocate((content == null ? 0 : content.length) + yz.length);
        allocate.put(yz);
        if (content != null) {
            allocate.put(content);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public f r(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        return a(byteBuffer, this.iqV);
    }

    public int yw(int i) throws LimitExedeedException, InvalidDataException {
        if (i < 0) {
            throw new InvalidDataException(1002, "Negative count");
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(f fVar) {
        String ze = fVar.ze("Sec-WebSocket-Version");
        if (ze.length() > 0) {
            try {
                return new Integer(ze.trim()).intValue();
            } catch (NumberFormatException e) {
                return -1;
            }
        }
        return -1;
    }

    public void a(WebSocket.Role role) {
        this.iqV = role;
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
