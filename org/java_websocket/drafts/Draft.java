package org.java_websocket.drafts;

import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.tieba.dnc;
import com.baidu.tieba.fnc;
import com.baidu.tieba.inc;
import com.baidu.tieba.lnc;
import com.baidu.tieba.mnc;
import com.baidu.tieba.nnc;
import com.baidu.tieba.onc;
import com.baidu.tieba.pnc;
import com.baidu.tieba.qnc;
import com.baidu.tieba.rnc;
import com.baidu.tieba.tnc;
import com.baidu.tieba.unc;
import com.baidu.tieba.xmc;
import com.baidu.tieba.znc;
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

    public abstract HandshakeState a(mnc mncVar, tnc tncVar) throws InvalidHandshakeException;

    public abstract HandshakeState b(mnc mncVar) throws InvalidHandshakeException;

    public abstract Draft f();

    public abstract ByteBuffer g(Framedata framedata);

    public abstract List<Framedata> h(String str, boolean z);

    public abstract List<Framedata> i(ByteBuffer byteBuffer, boolean z);

    public abstract CloseHandshakeType l();

    public abstract nnc m(nnc nncVar) throws InvalidHandshakeException;

    public abstract onc n(mnc mncVar, unc uncVar) throws InvalidHandshakeException;

    public abstract void o(xmc xmcVar, Framedata framedata) throws InvalidDataException;

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
        return znc.d(p.array(), 0, p.limit());
    }

    public boolean c(rnc rncVar) {
        if (rncVar.d("Upgrade").equalsIgnoreCase("websocket") && rncVar.d(HTTP.CONN_DIRECTIVE).toLowerCase(Locale.ENGLISH).contains("upgrade")) {
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

    public int r(rnc rncVar) {
        String d = rncVar.d("Sec-WebSocket-Version");
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

    public rnc v(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        return w(byteBuffer, this.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v21, types: [com.baidu.tieba.unc, com.baidu.tieba.qnc] */
    public static onc w(ByteBuffer byteBuffer, WebSocket.Role role) throws InvalidHandshakeException, IncompleteHandshakeException {
        pnc pncVar;
        String q = q(byteBuffer);
        if (q != null) {
            String[] split = q.split(" ", 3);
            if (split.length == 3) {
                if (role == WebSocket.Role.CLIENT) {
                    if (ADConfigError.REQUEST_HAS_SUCCESS_BEFORE.equals(split[1])) {
                        if ("HTTP/1.1".equalsIgnoreCase(split[0])) {
                            ?? qncVar = new qnc();
                            qncVar.h(Short.parseShort(split[1]));
                            qncVar.c(split[2]);
                            pncVar = qncVar;
                        } else {
                            throw new InvalidHandshakeException("Invalid status line received: " + split[0] + " Status line: " + q);
                        }
                    } else {
                        throw new InvalidHandshakeException("Invalid status code received: " + split[1] + " Status line: " + q);
                    }
                } else if ("GET".equalsIgnoreCase(split[0])) {
                    if ("HTTP/1.1".equalsIgnoreCase(split[2])) {
                        pnc pncVar2 = new pnc();
                        pncVar2.b(split[1]);
                        pncVar = pncVar2;
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
                        if (pncVar.e(split2[0])) {
                            String str = split2[0];
                            pncVar.put(str, pncVar.d(split2[0]) + "; " + split2[1].replaceFirst("^ +", ""));
                        } else {
                            pncVar.put(split2[0], split2[1].replaceFirst("^ +", ""));
                        }
                        q2 = q(byteBuffer);
                    } else {
                        throw new InvalidHandshakeException("not an http header");
                    }
                }
                if (q2 != null) {
                    return pncVar;
                }
                throw new IncompleteHandshakeException();
            }
            throw new InvalidHandshakeException();
        }
        throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
    }

    public List<Framedata> e(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        inc incVar;
        if (opcode != Framedata.Opcode.BINARY && opcode != Framedata.Opcode.TEXT) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        if (this.b != null) {
            incVar = new fnc();
        } else {
            this.b = opcode;
            if (opcode == Framedata.Opcode.BINARY) {
                incVar = new dnc();
            } else if (opcode == Framedata.Opcode.TEXT) {
                incVar = new lnc();
            } else {
                incVar = null;
            }
        }
        incVar.j(byteBuffer);
        incVar.i(z);
        try {
            incVar.h();
            if (z) {
                this.b = null;
            } else {
                this.b = opcode;
            }
            return Collections.singletonList(incVar);
        } catch (InvalidDataException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<ByteBuffer> j(rnc rncVar, WebSocket.Role role) {
        return k(rncVar, role, true);
    }

    public List<ByteBuffer> k(rnc rncVar, WebSocket.Role role, boolean z) {
        byte[] bArr;
        int length;
        StringBuilder sb = new StringBuilder(100);
        if (rncVar instanceof mnc) {
            sb.append("GET ");
            sb.append(((mnc) rncVar).f());
            sb.append(" HTTP/1.1");
        } else if (rncVar instanceof tnc) {
            sb.append("HTTP/1.1 101 ");
            sb.append(((tnc) rncVar).a());
        } else {
            throw new IllegalArgumentException("unknown role");
        }
        sb.append("\r\n");
        Iterator<String> g = rncVar.g();
        while (g.hasNext()) {
            String next = g.next();
            String d = rncVar.d(next);
            sb.append(next);
            sb.append(": ");
            sb.append(d);
            sb.append("\r\n");
        }
        sb.append("\r\n");
        byte[] a = znc.a(sb.toString());
        if (z) {
            bArr = rncVar.getContent();
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
