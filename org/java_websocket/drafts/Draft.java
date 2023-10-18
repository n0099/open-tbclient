package org.java_websocket.drafts;

import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.tieba.b5c;
import com.baidu.tieba.d6c;
import com.baidu.tieba.h5c;
import com.baidu.tieba.j5c;
import com.baidu.tieba.m5c;
import com.baidu.tieba.p5c;
import com.baidu.tieba.q5c;
import com.baidu.tieba.r5c;
import com.baidu.tieba.s5c;
import com.baidu.tieba.t5c;
import com.baidu.tieba.u5c;
import com.baidu.tieba.v5c;
import com.baidu.tieba.x5c;
import com.baidu.tieba.y5c;
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

    public abstract HandshakeState a(q5c q5cVar, x5c x5cVar) throws InvalidHandshakeException;

    public abstract HandshakeState b(q5c q5cVar) throws InvalidHandshakeException;

    public abstract Draft f();

    public abstract ByteBuffer g(Framedata framedata);

    public abstract List<Framedata> h(String str, boolean z);

    public abstract List<Framedata> i(ByteBuffer byteBuffer, boolean z);

    public abstract CloseHandshakeType l();

    public abstract r5c m(r5c r5cVar) throws InvalidHandshakeException;

    public abstract s5c n(q5c q5cVar, y5c y5cVar) throws InvalidHandshakeException;

    public abstract void o(b5c b5cVar, Framedata framedata) throws InvalidDataException;

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
        return d6c.d(p.array(), 0, p.limit());
    }

    public boolean c(v5c v5cVar) {
        if (v5cVar.d("Upgrade").equalsIgnoreCase("websocket") && v5cVar.d(HTTP.CONN_DIRECTIVE).toLowerCase(Locale.ENGLISH).contains("upgrade")) {
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

    public int r(v5c v5cVar) {
        String d = v5cVar.d("Sec-WebSocket-Version");
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

    public v5c v(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        return w(byteBuffer, this.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v21, types: [com.baidu.tieba.y5c, com.baidu.tieba.u5c] */
    public static s5c w(ByteBuffer byteBuffer, WebSocket.Role role) throws InvalidHandshakeException, IncompleteHandshakeException {
        t5c t5cVar;
        String q = q(byteBuffer);
        if (q != null) {
            String[] split = q.split(" ", 3);
            if (split.length == 3) {
                if (role == WebSocket.Role.CLIENT) {
                    if (ADConfigError.REQUEST_HAS_SUCCESS_BEFORE.equals(split[1])) {
                        if ("HTTP/1.1".equalsIgnoreCase(split[0])) {
                            ?? u5cVar = new u5c();
                            u5cVar.h(Short.parseShort(split[1]));
                            u5cVar.c(split[2]);
                            t5cVar = u5cVar;
                        } else {
                            throw new InvalidHandshakeException("Invalid status line received: " + split[0] + " Status line: " + q);
                        }
                    } else {
                        throw new InvalidHandshakeException("Invalid status code received: " + split[1] + " Status line: " + q);
                    }
                } else if ("GET".equalsIgnoreCase(split[0])) {
                    if ("HTTP/1.1".equalsIgnoreCase(split[2])) {
                        t5c t5cVar2 = new t5c();
                        t5cVar2.b(split[1]);
                        t5cVar = t5cVar2;
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
                        if (t5cVar.e(split2[0])) {
                            String str = split2[0];
                            t5cVar.put(str, t5cVar.d(split2[0]) + "; " + split2[1].replaceFirst("^ +", ""));
                        } else {
                            t5cVar.put(split2[0], split2[1].replaceFirst("^ +", ""));
                        }
                        q2 = q(byteBuffer);
                    } else {
                        throw new InvalidHandshakeException("not an http header");
                    }
                }
                if (q2 != null) {
                    return t5cVar;
                }
                throw new IncompleteHandshakeException();
            }
            throw new InvalidHandshakeException();
        }
        throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
    }

    public List<Framedata> e(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        m5c m5cVar;
        if (opcode != Framedata.Opcode.BINARY && opcode != Framedata.Opcode.TEXT) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        if (this.b != null) {
            m5cVar = new j5c();
        } else {
            this.b = opcode;
            if (opcode == Framedata.Opcode.BINARY) {
                m5cVar = new h5c();
            } else if (opcode == Framedata.Opcode.TEXT) {
                m5cVar = new p5c();
            } else {
                m5cVar = null;
            }
        }
        m5cVar.j(byteBuffer);
        m5cVar.i(z);
        try {
            m5cVar.h();
            if (z) {
                this.b = null;
            } else {
                this.b = opcode;
            }
            return Collections.singletonList(m5cVar);
        } catch (InvalidDataException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<ByteBuffer> j(v5c v5cVar, WebSocket.Role role) {
        return k(v5cVar, role, true);
    }

    public List<ByteBuffer> k(v5c v5cVar, WebSocket.Role role, boolean z) {
        byte[] bArr;
        int length;
        StringBuilder sb = new StringBuilder(100);
        if (v5cVar instanceof q5c) {
            sb.append("GET ");
            sb.append(((q5c) v5cVar).f());
            sb.append(" HTTP/1.1");
        } else if (v5cVar instanceof x5c) {
            sb.append("HTTP/1.1 101 ");
            sb.append(((x5c) v5cVar).a());
        } else {
            throw new IllegalArgumentException("unknown role");
        }
        sb.append("\r\n");
        Iterator<String> g = v5cVar.g();
        while (g.hasNext()) {
            String next = g.next();
            String d = v5cVar.d(next);
            sb.append(next);
            sb.append(": ");
            sb.append(d);
            sb.append("\r\n");
        }
        sb.append("\r\n");
        byte[] a = d6c.a(sb.toString());
        if (z) {
            bArr = v5cVar.getContent();
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
