package org.java_websocket.drafts;

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
    public static int pOh = 1000;
    public static int pOi = 64;
    protected WebSocket.Role pNV = null;
    protected Framedata.Opcode pOj = null;

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

    public abstract List<Framedata> b(ByteBuffer byteBuffer, boolean z);

    public abstract b b(b bVar) throws InvalidHandshakeException;

    public abstract List<Framedata> bp(String str, boolean z);

    public abstract CloseHandshakeType eEJ();

    public abstract Draft eEK();

    public abstract void reset();

    public abstract List<Framedata> y(ByteBuffer byteBuffer) throws InvalidDataException;

    public static ByteBuffer w(ByteBuffer byteBuffer) {
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

    public static String x(ByteBuffer byteBuffer) {
        ByteBuffer w = w(byteBuffer);
        if (w == null) {
            return null;
        }
        return org.java_websocket.e.c.z(w.array(), 0, w.limit());
    }

    public static c a(ByteBuffer byteBuffer, WebSocket.Role role) throws InvalidHandshakeException, IncompleteHandshakeException {
        i iVar;
        String x = x(byteBuffer);
        if (x == null) {
            throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
        }
        String[] split = x.split(" ", 3);
        if (split.length != 3) {
            throw new InvalidHandshakeException();
        }
        if (role == WebSocket.Role.CLIENT) {
            if (!TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY.equals(split[1])) {
                throw new InvalidHandshakeException("Invalid status code received: " + split[1] + " Status line: " + x);
            }
            if (!"HTTP/1.1".equalsIgnoreCase(split[0])) {
                throw new InvalidHandshakeException("Invalid status line received: " + split[0] + " Status line: " + x);
            }
            i eVar = new e();
            i iVar2 = eVar;
            iVar2.m(Short.parseShort(split[1]));
            iVar2.aaC(split[2]);
            iVar = eVar;
        } else if (!"GET".equalsIgnoreCase(split[0])) {
            throw new InvalidHandshakeException("Invalid request method received: " + split[0] + " Status line: " + x);
        } else {
            if (!"HTTP/1.1".equalsIgnoreCase(split[2])) {
                throw new InvalidHandshakeException("Invalid status line received: " + split[2] + " Status line: " + x);
            }
            d dVar = new d();
            dVar.aaB(split[1]);
            iVar = dVar;
        }
        String x2 = x(byteBuffer);
        while (x2 != null && x2.length() > 0) {
            String[] split2 = x2.split(":", 2);
            if (split2.length != 2) {
                throw new InvalidHandshakeException("not an http header");
            }
            if (iVar.aaE(split2[0])) {
                iVar.put(split2[0], iVar.aaD(split2[0]) + "; " + split2[1].replaceFirst("^ +", ""));
            } else {
                iVar.put(split2[0], split2[1].replaceFirst("^ +", ""));
            }
            x2 = x(byteBuffer);
        }
        if (x2 == null) {
            throw new IncompleteHandshakeException();
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(f fVar) {
        return fVar.aaD("Upgrade").equalsIgnoreCase("websocket") && fVar.aaD(HTTP.CONN_DIRECTIVE).toLowerCase(Locale.ENGLISH).contains(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
    }

    public List<Framedata> a(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        org.java_websocket.framing.f iVar;
        if (opcode != Framedata.Opcode.BINARY && opcode != Framedata.Opcode.TEXT) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        if (this.pOj != null) {
            iVar = new org.java_websocket.framing.c();
        } else {
            this.pOj = opcode;
            if (opcode == Framedata.Opcode.BINARY) {
                iVar = new org.java_websocket.framing.a();
            } else {
                iVar = opcode == Framedata.Opcode.TEXT ? new org.java_websocket.framing.i() : null;
            }
        }
        iVar.B(byteBuffer);
        iVar.eT(z);
        try {
            iVar.eEU();
            if (z) {
                this.pOj = null;
            } else {
                this.pOj = opcode;
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
            sb.append("HTTP/1.1 101 ").append(((h) fVar).eFb());
        } else {
            throw new IllegalArgumentException("unknown role");
        }
        sb.append("\r\n");
        Iterator<String> eFc = fVar.eFc();
        while (eFc.hasNext()) {
            String next = eFc.next();
            String aaD = fVar.aaD(next);
            sb.append(next);
            sb.append(": ");
            sb.append(aaD);
            sb.append("\r\n");
        }
        sb.append("\r\n");
        byte[] Zj = org.java_websocket.e.c.Zj(sb.toString());
        byte[] content = z ? fVar.getContent() : null;
        ByteBuffer allocate = ByteBuffer.allocate((content == null ? 0 : content.length) + Zj.length);
        allocate.put(Zj);
        if (content != null) {
            allocate.put(content);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public f z(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        return a(byteBuffer, this.pNV);
    }

    public int Si(int i) throws LimitExedeedException, InvalidDataException {
        if (i < 0) {
            throw new InvalidDataException(1002, "Negative count");
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(f fVar) {
        String aaD = fVar.aaD("Sec-WebSocket-Version");
        if (aaD.length() > 0) {
            try {
                return new Integer(aaD.trim()).intValue();
            } catch (NumberFormatException e) {
                return -1;
            }
        }
        return -1;
    }

    public void a(WebSocket.Role role) {
        this.pNV = role;
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
