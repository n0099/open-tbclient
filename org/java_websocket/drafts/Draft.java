package org.java_websocket.drafts;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.util.TbEnum;
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
/* loaded from: classes5.dex */
public abstract class Draft {
    public static int nLy = 1000;
    public static int nLz = 64;
    protected WebSocket.Role nLm = null;
    protected Framedata.Opcode nLA = null;

    /* loaded from: classes5.dex */
    public enum CloseHandshakeType {
        NONE,
        ONEWAY,
        TWOWAY
    }

    /* loaded from: classes5.dex */
    public enum HandshakeState {
        MATCHED,
        NOT_MATCHED
    }

    public abstract ByteBuffer a(Framedata framedata);

    public abstract c a(org.java_websocket.c.a aVar, i iVar) throws InvalidHandshakeException;

    public abstract HandshakeState a(org.java_websocket.c.a aVar) throws InvalidHandshakeException;

    public abstract HandshakeState a(org.java_websocket.c.a aVar, h hVar) throws InvalidHandshakeException;

    public abstract void a(org.java_websocket.c cVar, Framedata framedata) throws InvalidDataException;

    public abstract List<Framedata> aU(String str, boolean z);

    public abstract List<Framedata> b(ByteBuffer byteBuffer, boolean z);

    public abstract b b(b bVar) throws InvalidHandshakeException;

    public abstract CloseHandshakeType dLY();

    public abstract Draft dLZ();

    public abstract List<Framedata> r(ByteBuffer byteBuffer) throws InvalidDataException;

    public abstract void reset();

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
        return org.java_websocket.e.c.H(p.array(), 0, p.limit());
    }

    public static c a(ByteBuffer byteBuffer, WebSocket.Role role) throws InvalidHandshakeException, IncompleteHandshakeException {
        i iVar;
        String q = q(byteBuffer);
        if (q == null) {
            throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
        }
        String[] split = q.split(HanziToPinyin.Token.SEPARATOR, 3);
        if (split.length != 3) {
            throw new InvalidHandshakeException();
        }
        if (role == WebSocket.Role.CLIENT) {
            if (!TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY.equals(split[1])) {
                throw new InvalidHandshakeException("Invalid status code received: " + split[1] + " Status line: " + q);
            }
            if (!"HTTP/1.1".equalsIgnoreCase(split[0])) {
                throw new InvalidHandshakeException("Invalid status line received: " + split[0] + " Status line: " + q);
            }
            i eVar = new e();
            i iVar2 = eVar;
            iVar2.j(Short.parseShort(split[1]));
            iVar2.Sk(split[2]);
            iVar = eVar;
        } else if (!"GET".equalsIgnoreCase(split[0])) {
            throw new InvalidHandshakeException("Invalid request method received: " + split[0] + " Status line: " + q);
        } else {
            if (!"HTTP/1.1".equalsIgnoreCase(split[2])) {
                throw new InvalidHandshakeException("Invalid status line received: " + split[2] + " Status line: " + q);
            }
            d dVar = new d();
            dVar.Sj(split[1]);
            iVar = dVar;
        }
        String q2 = q(byteBuffer);
        while (q2 != null && q2.length() > 0) {
            String[] split2 = q2.split(":", 2);
            if (split2.length != 2) {
                throw new InvalidHandshakeException("not an http header");
            }
            if (iVar.Sm(split2[0])) {
                iVar.put(split2[0], iVar.Sl(split2[0]) + "; " + split2[1].replaceFirst("^ +", ""));
            } else {
                iVar.put(split2[0], split2[1].replaceFirst("^ +", ""));
            }
            q2 = q(byteBuffer);
        }
        if (q2 == null) {
            throw new IncompleteHandshakeException();
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(f fVar) {
        return fVar.Sl("Upgrade").equalsIgnoreCase("websocket") && fVar.Sl(HTTP.CONN_DIRECTIVE).toLowerCase(Locale.ENGLISH).contains(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
    }

    public List<Framedata> a(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        org.java_websocket.framing.f iVar;
        if (opcode != Framedata.Opcode.BINARY && opcode != Framedata.Opcode.TEXT) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        if (this.nLA != null) {
            iVar = new org.java_websocket.framing.c();
        } else {
            this.nLA = opcode;
            if (opcode == Framedata.Opcode.BINARY) {
                iVar = new org.java_websocket.framing.a();
            } else {
                iVar = opcode == Framedata.Opcode.TEXT ? new org.java_websocket.framing.i() : null;
            }
        }
        iVar.u(byteBuffer);
        iVar.cc(z);
        try {
            iVar.dMj();
            if (z) {
                this.nLA = null;
            } else {
                this.nLA = opcode;
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
            sb.append("HTTP/1.1 101 ").append(((h) fVar).dMq());
        } else {
            throw new IllegalArgumentException("unknown role");
        }
        sb.append("\r\n");
        Iterator<String> dMr = fVar.dMr();
        while (dMr.hasNext()) {
            String next = dMr.next();
            String Sl = fVar.Sl(next);
            sb.append(next);
            sb.append(": ");
            sb.append(Sl);
            sb.append("\r\n");
        }
        sb.append("\r\n");
        byte[] OH = org.java_websocket.e.c.OH(sb.toString());
        byte[] content = z ? fVar.getContent() : null;
        ByteBuffer allocate = ByteBuffer.allocate((content == null ? 0 : content.length) + OH.length);
        allocate.put(OH);
        if (content != null) {
            allocate.put(content);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public f s(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        return a(byteBuffer, this.nLm);
    }

    public int NV(int i) throws LimitExedeedException, InvalidDataException {
        if (i < 0) {
            throw new InvalidDataException(1002, "Negative count");
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(f fVar) {
        String Sl = fVar.Sl("Sec-WebSocket-Version");
        if (Sl.length() > 0) {
            try {
                return new Integer(Sl.trim()).intValue();
            } catch (NumberFormatException e) {
                return -1;
            }
        }
        return -1;
    }

    public void a(WebSocket.Role role) {
        this.nLm = role;
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
