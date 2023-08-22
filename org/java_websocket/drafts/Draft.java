package org.java_websocket.drafts;

import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.tieba.a7c;
import com.baidu.tieba.b7c;
import com.baidu.tieba.d7c;
import com.baidu.tieba.e7c;
import com.baidu.tieba.h6c;
import com.baidu.tieba.j7c;
import com.baidu.tieba.n6c;
import com.baidu.tieba.p6c;
import com.baidu.tieba.s6c;
import com.baidu.tieba.v6c;
import com.baidu.tieba.w6c;
import com.baidu.tieba.x6c;
import com.baidu.tieba.y6c;
import com.baidu.tieba.z6c;
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
/* loaded from: classes2.dex */
public abstract class Draft {
    public WebSocket.Role a = null;
    public Framedata.Opcode b = null;

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

    public abstract HandshakeState a(w6c w6cVar, d7c d7cVar) throws InvalidHandshakeException;

    public abstract HandshakeState b(w6c w6cVar) throws InvalidHandshakeException;

    public abstract Draft f();

    public abstract ByteBuffer g(Framedata framedata);

    public abstract List<Framedata> h(String str, boolean z);

    public abstract List<Framedata> i(ByteBuffer byteBuffer, boolean z);

    public abstract CloseHandshakeType l();

    public abstract x6c m(x6c x6cVar) throws InvalidHandshakeException;

    public abstract y6c n(w6c w6cVar, e7c e7cVar) throws InvalidHandshakeException;

    public abstract void o(h6c h6cVar, Framedata framedata) throws InvalidDataException;

    public abstract void s();

    public abstract List<Framedata> u(ByteBuffer byteBuffer) throws InvalidDataException;

    public String toString() {
        return getClass().getSimpleName();
    }

    public static ByteBuffer p(ByteBuffer byteBuffer) {
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

    public static String q(ByteBuffer byteBuffer) {
        ByteBuffer p = p(byteBuffer);
        if (p == null) {
            return null;
        }
        return j7c.d(p.array(), 0, p.limit());
    }

    public boolean c(b7c b7cVar) {
        if (b7cVar.d("Upgrade").equalsIgnoreCase("websocket") && b7cVar.d(HTTP.CONN_DIRECTIVE).toLowerCase(Locale.ENGLISH).contains("upgrade")) {
            return true;
        }
        return false;
    }

    public int d(int i) throws LimitExedeedException, InvalidDataException {
        if (i >= 0) {
            return i;
        }
        throw new InvalidDataException(1002, "Negative count");
    }

    public int r(b7c b7cVar) {
        String d = b7cVar.d("Sec-WebSocket-Version");
        if (d.length() > 0) {
            try {
                return new Integer(d.trim()).intValue();
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    public void t(WebSocket.Role role) {
        this.a = role;
    }

    public b7c v(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        return w(byteBuffer, this.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v21, types: [com.baidu.tieba.a7c, com.baidu.tieba.e7c] */
    public static y6c w(ByteBuffer byteBuffer, WebSocket.Role role) throws InvalidHandshakeException, IncompleteHandshakeException {
        z6c z6cVar;
        String q = q(byteBuffer);
        if (q != null) {
            String[] split = q.split(" ", 3);
            if (split.length == 3) {
                if (role == WebSocket.Role.CLIENT) {
                    if (ADConfigError.REQUEST_HAS_SUCCESS_BEFORE.equals(split[1])) {
                        if ("HTTP/1.1".equalsIgnoreCase(split[0])) {
                            ?? a7cVar = new a7c();
                            a7cVar.h(Short.parseShort(split[1]));
                            a7cVar.c(split[2]);
                            z6cVar = a7cVar;
                        } else {
                            throw new InvalidHandshakeException("Invalid status line received: " + split[0] + " Status line: " + q);
                        }
                    } else {
                        throw new InvalidHandshakeException("Invalid status code received: " + split[1] + " Status line: " + q);
                    }
                } else if ("GET".equalsIgnoreCase(split[0])) {
                    if ("HTTP/1.1".equalsIgnoreCase(split[2])) {
                        z6c z6cVar2 = new z6c();
                        z6cVar2.b(split[1]);
                        z6cVar = z6cVar2;
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
                        if (z6cVar.e(split2[0])) {
                            String str = split2[0];
                            z6cVar.put(str, z6cVar.d(split2[0]) + "; " + split2[1].replaceFirst("^ +", ""));
                        } else {
                            z6cVar.put(split2[0], split2[1].replaceFirst("^ +", ""));
                        }
                        q2 = q(byteBuffer);
                    } else {
                        throw new InvalidHandshakeException("not an http header");
                    }
                }
                if (q2 != null) {
                    return z6cVar;
                }
                throw new IncompleteHandshakeException();
            }
            throw new InvalidHandshakeException();
        }
        throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
    }

    public List<Framedata> e(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        s6c s6cVar;
        if (opcode != Framedata.Opcode.BINARY && opcode != Framedata.Opcode.TEXT) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        if (this.b != null) {
            s6cVar = new p6c();
        } else {
            this.b = opcode;
            if (opcode == Framedata.Opcode.BINARY) {
                s6cVar = new n6c();
            } else if (opcode == Framedata.Opcode.TEXT) {
                s6cVar = new v6c();
            } else {
                s6cVar = null;
            }
        }
        s6cVar.j(byteBuffer);
        s6cVar.i(z);
        try {
            s6cVar.h();
            if (z) {
                this.b = null;
            } else {
                this.b = opcode;
            }
            return Collections.singletonList(s6cVar);
        } catch (InvalidDataException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<ByteBuffer> j(b7c b7cVar, WebSocket.Role role) {
        return k(b7cVar, role, true);
    }

    public List<ByteBuffer> k(b7c b7cVar, WebSocket.Role role, boolean z) {
        byte[] bArr;
        int length;
        StringBuilder sb = new StringBuilder(100);
        if (b7cVar instanceof w6c) {
            sb.append("GET ");
            sb.append(((w6c) b7cVar).f());
            sb.append(" HTTP/1.1");
        } else if (b7cVar instanceof d7c) {
            sb.append("HTTP/1.1 101 ");
            sb.append(((d7c) b7cVar).a());
        } else {
            throw new IllegalArgumentException("unknown role");
        }
        sb.append("\r\n");
        Iterator<String> g = b7cVar.g();
        while (g.hasNext()) {
            String next = g.next();
            String d = b7cVar.d(next);
            sb.append(next);
            sb.append(": ");
            sb.append(d);
            sb.append("\r\n");
        }
        sb.append("\r\n");
        byte[] a = j7c.a(sb.toString());
        if (z) {
            bArr = b7cVar.getContent();
        } else {
            bArr = null;
        }
        if (bArr == null) {
            length = 0;
        } else {
            length = bArr.length;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length + a.length);
        allocate.put(a);
        if (bArr != null) {
            allocate.put(bArr);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }
}
