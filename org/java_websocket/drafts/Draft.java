package org.java_websocket.drafts;

import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.tieba.ara;
import com.baidu.tieba.bra;
import com.baidu.tieba.cra;
import com.baidu.tieba.era;
import com.baidu.tieba.fra;
import com.baidu.tieba.iqa;
import com.baidu.tieba.kra;
import com.baidu.tieba.oqa;
import com.baidu.tieba.qqa;
import com.baidu.tieba.tqa;
import com.baidu.tieba.wqa;
import com.baidu.tieba.xqa;
import com.baidu.tieba.yqa;
import com.baidu.tieba.zqa;
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
/* loaded from: classes9.dex */
public abstract class Draft {
    public WebSocket.Role a = null;
    public Framedata.Opcode b = null;

    /* loaded from: classes9.dex */
    public enum CloseHandshakeType {
        NONE,
        ONEWAY,
        TWOWAY
    }

    /* loaded from: classes9.dex */
    public enum HandshakeState {
        MATCHED,
        NOT_MATCHED
    }

    public abstract HandshakeState a(xqa xqaVar, era eraVar) throws InvalidHandshakeException;

    public abstract HandshakeState b(xqa xqaVar) throws InvalidHandshakeException;

    public abstract Draft f();

    public abstract ByteBuffer g(Framedata framedata);

    public abstract List<Framedata> h(String str, boolean z);

    public abstract List<Framedata> i(ByteBuffer byteBuffer, boolean z);

    public abstract CloseHandshakeType l();

    public abstract yqa m(yqa yqaVar) throws InvalidHandshakeException;

    public abstract zqa n(xqa xqaVar, fra fraVar) throws InvalidHandshakeException;

    public abstract void o(iqa iqaVar, Framedata framedata) throws InvalidDataException;

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
        return kra.d(p.array(), 0, p.limit());
    }

    public boolean c(cra craVar) {
        if (craVar.d("Upgrade").equalsIgnoreCase("websocket") && craVar.d(HTTP.CONN_DIRECTIVE).toLowerCase(Locale.ENGLISH).contains("upgrade")) {
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

    public int r(cra craVar) {
        String d = craVar.d("Sec-WebSocket-Version");
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

    public cra v(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        return w(byteBuffer, this.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v21, types: [com.baidu.tieba.bra, com.baidu.tieba.fra] */
    public static zqa w(ByteBuffer byteBuffer, WebSocket.Role role) throws InvalidHandshakeException, IncompleteHandshakeException {
        ara araVar;
        String q = q(byteBuffer);
        if (q != null) {
            String[] split = q.split(" ", 3);
            if (split.length == 3) {
                if (role == WebSocket.Role.CLIENT) {
                    if (ADConfigError.REQUEST_HAS_SUCCESS_BEFORE.equals(split[1])) {
                        if ("HTTP/1.1".equalsIgnoreCase(split[0])) {
                            ?? braVar = new bra();
                            braVar.h(Short.parseShort(split[1]));
                            braVar.c(split[2]);
                            araVar = braVar;
                        } else {
                            throw new InvalidHandshakeException("Invalid status line received: " + split[0] + " Status line: " + q);
                        }
                    } else {
                        throw new InvalidHandshakeException("Invalid status code received: " + split[1] + " Status line: " + q);
                    }
                } else if ("GET".equalsIgnoreCase(split[0])) {
                    if ("HTTP/1.1".equalsIgnoreCase(split[2])) {
                        ara araVar2 = new ara();
                        araVar2.b(split[1]);
                        araVar = araVar2;
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
                        if (araVar.e(split2[0])) {
                            String str = split2[0];
                            araVar.put(str, araVar.d(split2[0]) + "; " + split2[1].replaceFirst("^ +", ""));
                        } else {
                            araVar.put(split2[0], split2[1].replaceFirst("^ +", ""));
                        }
                        q2 = q(byteBuffer);
                    } else {
                        throw new InvalidHandshakeException("not an http header");
                    }
                }
                if (q2 != null) {
                    return araVar;
                }
                throw new IncompleteHandshakeException();
            }
            throw new InvalidHandshakeException();
        }
        throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
    }

    public List<Framedata> e(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        tqa tqaVar;
        if (opcode != Framedata.Opcode.BINARY && opcode != Framedata.Opcode.TEXT) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        if (this.b != null) {
            tqaVar = new qqa();
        } else {
            this.b = opcode;
            if (opcode == Framedata.Opcode.BINARY) {
                tqaVar = new oqa();
            } else if (opcode == Framedata.Opcode.TEXT) {
                tqaVar = new wqa();
            } else {
                tqaVar = null;
            }
        }
        tqaVar.j(byteBuffer);
        tqaVar.i(z);
        try {
            tqaVar.h();
            if (z) {
                this.b = null;
            } else {
                this.b = opcode;
            }
            return Collections.singletonList(tqaVar);
        } catch (InvalidDataException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<ByteBuffer> j(cra craVar, WebSocket.Role role) {
        return k(craVar, role, true);
    }

    public List<ByteBuffer> k(cra craVar, WebSocket.Role role, boolean z) {
        byte[] bArr;
        int length;
        StringBuilder sb = new StringBuilder(100);
        if (craVar instanceof xqa) {
            sb.append("GET ");
            sb.append(((xqa) craVar).f());
            sb.append(" HTTP/1.1");
        } else if (craVar instanceof era) {
            sb.append("HTTP/1.1 101 ");
            sb.append(((era) craVar).a());
        } else {
            throw new IllegalArgumentException("unknown role");
        }
        sb.append("\r\n");
        Iterator<String> g = craVar.g();
        while (g.hasNext()) {
            String next = g.next();
            String d = craVar.d(next);
            sb.append(next);
            sb.append(": ");
            sb.append(d);
            sb.append("\r\n");
        }
        sb.append("\r\n");
        byte[] a = kra.a(sb.toString());
        if (z) {
            bArr = craVar.getContent();
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
