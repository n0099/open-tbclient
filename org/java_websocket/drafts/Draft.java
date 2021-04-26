package org.java_websocket.drafts;

import com.android.internal.http.multipart.Part;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import g.c.h.i;
import g.c.i.a;
import g.c.i.b;
import g.c.i.d;
import g.c.i.e;
import g.c.i.f;
import g.c.i.h;
import g.c.k.c;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.http.protocol.HTTP;
import org.java_websocket.WebSocket;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExedeedException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class Draft {

    /* renamed from: a  reason: collision with root package name */
    public WebSocket.Role f68316a = null;

    /* renamed from: b  reason: collision with root package name */
    public Framedata.Opcode f68317b = null;

    /* loaded from: classes7.dex */
    public enum CloseHandshakeType {
        NONE,
        ONEWAY,
        TWOWAY
    }

    /* loaded from: classes7.dex */
    public enum HandshakeState {
        MATCHED,
        NOT_MATCHED
    }

    public static ByteBuffer p(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b2 = 48;
        while (byteBuffer.hasRemaining()) {
            byte b3 = byteBuffer.get();
            allocate.put(b3);
            if (b2 == 13 && b3 == 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                return allocate;
            }
            b2 = b3;
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        return null;
    }

    public static String q(ByteBuffer byteBuffer) {
        ByteBuffer p = p(byteBuffer);
        if (p == null) {
            return null;
        }
        return c.d(p.array(), 0, p.limit());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v21, types: [g.c.i.e, g.c.i.i] */
    public static g.c.i.c w(ByteBuffer byteBuffer, WebSocket.Role role) throws InvalidHandshakeException, IncompleteHandshakeException {
        d dVar;
        String q = q(byteBuffer);
        if (q != null) {
            String[] split = q.split(" ", 3);
            if (split.length == 3) {
                if (role == WebSocket.Role.CLIENT) {
                    if ("101".equals(split[1])) {
                        if ("HTTP/1.1".equalsIgnoreCase(split[0])) {
                            ?? eVar = new e();
                            eVar.h(Short.parseShort(split[1]));
                            eVar.c(split[2]);
                            dVar = eVar;
                        } else {
                            throw new InvalidHandshakeException("Invalid status line received: " + split[0] + " Status line: " + q);
                        }
                    } else {
                        throw new InvalidHandshakeException("Invalid status code received: " + split[1] + " Status line: " + q);
                    }
                } else if ("GET".equalsIgnoreCase(split[0])) {
                    if ("HTTP/1.1".equalsIgnoreCase(split[2])) {
                        d dVar2 = new d();
                        dVar2.b(split[1]);
                        dVar = dVar2;
                    } else {
                        throw new InvalidHandshakeException("Invalid status line received: " + split[2] + " Status line: " + q);
                    }
                } else {
                    throw new InvalidHandshakeException("Invalid request method received: " + split[0] + " Status line: " + q);
                }
                String q2 = q(byteBuffer);
                while (q2 != null && q2.length() > 0) {
                    String[] split2 = q2.split(":", 2);
                    if (split2.length == 2) {
                        if (dVar.e(split2[0])) {
                            String str = split2[0];
                            dVar.put(str, dVar.d(split2[0]) + "; " + split2[1].replaceFirst("^ +", ""));
                        } else {
                            dVar.put(split2[0], split2[1].replaceFirst("^ +", ""));
                        }
                        q2 = q(byteBuffer);
                    } else {
                        throw new InvalidHandshakeException("not an http header");
                    }
                }
                if (q2 != null) {
                    return dVar;
                }
                throw new IncompleteHandshakeException();
            }
            throw new InvalidHandshakeException();
        }
        throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
    }

    public abstract HandshakeState a(a aVar, h hVar) throws InvalidHandshakeException;

    public abstract HandshakeState b(a aVar) throws InvalidHandshakeException;

    public boolean c(f fVar) {
        return fVar.d("Upgrade").equalsIgnoreCase("websocket") && fVar.d(HTTP.CONN_DIRECTIVE).toLowerCase(Locale.ENGLISH).contains(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
    }

    public int d(int i2) throws LimitExedeedException, InvalidDataException {
        if (i2 >= 0) {
            return i2;
        }
        throw new InvalidDataException(1002, "Negative count");
    }

    public List<Framedata> e(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        g.c.h.f iVar;
        if (opcode != Framedata.Opcode.BINARY && opcode != Framedata.Opcode.TEXT) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        if (this.f68317b != null) {
            iVar = new g.c.h.c();
        } else {
            this.f68317b = opcode;
            if (opcode == Framedata.Opcode.BINARY) {
                iVar = new g.c.h.a();
            } else {
                iVar = opcode == Framedata.Opcode.TEXT ? new i() : null;
            }
        }
        iVar.j(byteBuffer);
        iVar.i(z);
        try {
            iVar.h();
            if (z) {
                this.f68317b = null;
            } else {
                this.f68317b = opcode;
            }
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public abstract Draft f();

    public abstract ByteBuffer g(Framedata framedata);

    public abstract List<Framedata> h(String str, boolean z);

    public abstract List<Framedata> i(ByteBuffer byteBuffer, boolean z);

    public List<ByteBuffer> j(f fVar, WebSocket.Role role) {
        return k(fVar, role, true);
    }

    public List<ByteBuffer> k(f fVar, WebSocket.Role role, boolean z) {
        StringBuilder sb = new StringBuilder(100);
        if (fVar instanceof a) {
            sb.append("GET ");
            sb.append(((a) fVar).f());
            sb.append(" HTTP/1.1");
        } else if (fVar instanceof h) {
            sb.append("HTTP/1.1 101 ");
            sb.append(((h) fVar).a());
        } else {
            throw new IllegalArgumentException("unknown role");
        }
        sb.append(Part.CRLF);
        Iterator<String> g2 = fVar.g();
        while (g2.hasNext()) {
            String next = g2.next();
            String d2 = fVar.d(next);
            sb.append(next);
            sb.append(": ");
            sb.append(d2);
            sb.append(Part.CRLF);
        }
        sb.append(Part.CRLF);
        byte[] a2 = c.a(sb.toString());
        byte[] content = z ? fVar.getContent() : null;
        ByteBuffer allocate = ByteBuffer.allocate((content == null ? 0 : content.length) + a2.length);
        allocate.put(a2);
        if (content != null) {
            allocate.put(content);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public abstract CloseHandshakeType l();

    public abstract b m(b bVar) throws InvalidHandshakeException;

    public abstract g.c.i.c n(a aVar, g.c.i.i iVar) throws InvalidHandshakeException;

    public abstract void o(g.c.c cVar, Framedata framedata) throws InvalidDataException;

    public int r(f fVar) {
        String d2 = fVar.d("Sec-WebSocket-Version");
        if (d2.length() > 0) {
            try {
                return new Integer(d2.trim()).intValue();
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    public abstract void s();

    public void t(WebSocket.Role role) {
        this.f68316a = role;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public abstract List<Framedata> u(ByteBuffer byteBuffer) throws InvalidDataException;

    public f v(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        return w(byteBuffer, this.f68316a);
    }
}
