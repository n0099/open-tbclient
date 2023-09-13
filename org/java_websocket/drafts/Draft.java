package org.java_websocket.drafts;

import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.tieba.aac;
import com.baidu.tieba.bac;
import com.baidu.tieba.cac;
import com.baidu.tieba.dac;
import com.baidu.tieba.eac;
import com.baidu.tieba.fac;
import com.baidu.tieba.gac;
import com.baidu.tieba.iac;
import com.baidu.tieba.jac;
import com.baidu.tieba.m9c;
import com.baidu.tieba.oac;
import com.baidu.tieba.s9c;
import com.baidu.tieba.u9c;
import com.baidu.tieba.x9c;
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

    public abstract HandshakeState a(bac bacVar, iac iacVar) throws InvalidHandshakeException;

    public abstract HandshakeState b(bac bacVar) throws InvalidHandshakeException;

    public abstract Draft f();

    public abstract ByteBuffer g(Framedata framedata);

    public abstract List<Framedata> h(String str, boolean z);

    public abstract List<Framedata> i(ByteBuffer byteBuffer, boolean z);

    public abstract CloseHandshakeType l();

    public abstract cac m(cac cacVar) throws InvalidHandshakeException;

    public abstract dac n(bac bacVar, jac jacVar) throws InvalidHandshakeException;

    public abstract void o(m9c m9cVar, Framedata framedata) throws InvalidDataException;

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
        return oac.d(p.array(), 0, p.limit());
    }

    public boolean c(gac gacVar) {
        if (gacVar.d("Upgrade").equalsIgnoreCase("websocket") && gacVar.d(HTTP.CONN_DIRECTIVE).toLowerCase(Locale.ENGLISH).contains("upgrade")) {
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

    public int r(gac gacVar) {
        String d = gacVar.d("Sec-WebSocket-Version");
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

    public gac v(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        return w(byteBuffer, this.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v21, types: [com.baidu.tieba.jac, com.baidu.tieba.fac] */
    public static dac w(ByteBuffer byteBuffer, WebSocket.Role role) throws InvalidHandshakeException, IncompleteHandshakeException {
        eac eacVar;
        String q = q(byteBuffer);
        if (q != null) {
            String[] split = q.split(" ", 3);
            if (split.length == 3) {
                if (role == WebSocket.Role.CLIENT) {
                    if (ADConfigError.REQUEST_HAS_SUCCESS_BEFORE.equals(split[1])) {
                        if ("HTTP/1.1".equalsIgnoreCase(split[0])) {
                            ?? facVar = new fac();
                            facVar.h(Short.parseShort(split[1]));
                            facVar.c(split[2]);
                            eacVar = facVar;
                        } else {
                            throw new InvalidHandshakeException("Invalid status line received: " + split[0] + " Status line: " + q);
                        }
                    } else {
                        throw new InvalidHandshakeException("Invalid status code received: " + split[1] + " Status line: " + q);
                    }
                } else if ("GET".equalsIgnoreCase(split[0])) {
                    if ("HTTP/1.1".equalsIgnoreCase(split[2])) {
                        eac eacVar2 = new eac();
                        eacVar2.b(split[1]);
                        eacVar = eacVar2;
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
                        if (eacVar.e(split2[0])) {
                            String str = split2[0];
                            eacVar.put(str, eacVar.d(split2[0]) + "; " + split2[1].replaceFirst("^ +", ""));
                        } else {
                            eacVar.put(split2[0], split2[1].replaceFirst("^ +", ""));
                        }
                        q2 = q(byteBuffer);
                    } else {
                        throw new InvalidHandshakeException("not an http header");
                    }
                }
                if (q2 != null) {
                    return eacVar;
                }
                throw new IncompleteHandshakeException();
            }
            throw new InvalidHandshakeException();
        }
        throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
    }

    public List<Framedata> e(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        x9c x9cVar;
        if (opcode != Framedata.Opcode.BINARY && opcode != Framedata.Opcode.TEXT) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        if (this.b != null) {
            x9cVar = new u9c();
        } else {
            this.b = opcode;
            if (opcode == Framedata.Opcode.BINARY) {
                x9cVar = new s9c();
            } else if (opcode == Framedata.Opcode.TEXT) {
                x9cVar = new aac();
            } else {
                x9cVar = null;
            }
        }
        x9cVar.j(byteBuffer);
        x9cVar.i(z);
        try {
            x9cVar.h();
            if (z) {
                this.b = null;
            } else {
                this.b = opcode;
            }
            return Collections.singletonList(x9cVar);
        } catch (InvalidDataException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<ByteBuffer> j(gac gacVar, WebSocket.Role role) {
        return k(gacVar, role, true);
    }

    public List<ByteBuffer> k(gac gacVar, WebSocket.Role role, boolean z) {
        byte[] bArr;
        int length;
        StringBuilder sb = new StringBuilder(100);
        if (gacVar instanceof bac) {
            sb.append("GET ");
            sb.append(((bac) gacVar).f());
            sb.append(" HTTP/1.1");
        } else if (gacVar instanceof iac) {
            sb.append("HTTP/1.1 101 ");
            sb.append(((iac) gacVar).a());
        } else {
            throw new IllegalArgumentException("unknown role");
        }
        sb.append("\r\n");
        Iterator<String> g = gacVar.g();
        while (g.hasNext()) {
            String next = g.next();
            String d = gacVar.d(next);
            sb.append(next);
            sb.append(": ");
            sb.append(d);
            sb.append("\r\n");
        }
        sb.append("\r\n");
        byte[] a = oac.a(sb.toString());
        if (z) {
            bArr = gacVar.getContent();
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
