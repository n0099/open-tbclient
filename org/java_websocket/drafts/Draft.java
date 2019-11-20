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
/* loaded from: classes2.dex */
public abstract class Draft {
    public static int kwS = 1000;
    public static int kwT = 64;
    protected WebSocket.Role kwG = null;
    protected Framedata.Opcode kwU = null;

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

    public abstract List<Framedata> aA(String str, boolean z);

    public abstract List<Framedata> b(ByteBuffer byteBuffer, boolean z);

    public abstract b b(b bVar) throws InvalidHandshakeException;

    public abstract Draft cNA();

    public abstract CloseHandshakeType cNz();

    public abstract List<Framedata> n(ByteBuffer byteBuffer) throws InvalidDataException;

    public abstract void reset();

    public static ByteBuffer l(ByteBuffer byteBuffer) {
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

    public static String m(ByteBuffer byteBuffer) {
        ByteBuffer l = l(byteBuffer);
        if (l == null) {
            return null;
        }
        return org.java_websocket.e.c.l(l.array(), 0, l.limit());
    }

    public static c a(ByteBuffer byteBuffer, WebSocket.Role role) throws InvalidHandshakeException, IncompleteHandshakeException {
        i iVar;
        String m = m(byteBuffer);
        if (m == null) {
            throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
        }
        String[] split = m.split(HanziToPinyin.Token.SEPARATOR, 3);
        if (split.length != 3) {
            throw new InvalidHandshakeException();
        }
        if (role == WebSocket.Role.CLIENT) {
            if (!TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY.equals(split[1])) {
                throw new InvalidHandshakeException("Invalid status code received: " + split[1] + " Status line: " + m);
            }
            if (!"HTTP/1.1".equalsIgnoreCase(split[0])) {
                throw new InvalidHandshakeException("Invalid status line received: " + split[0] + " Status line: " + m);
            }
            i eVar = new e();
            i iVar2 = eVar;
            iVar2.h(Short.parseShort(split[1]));
            iVar2.Hj(split[2]);
            iVar = eVar;
        } else if (!"GET".equalsIgnoreCase(split[0])) {
            throw new InvalidHandshakeException("Invalid request method received: " + split[0] + " Status line: " + m);
        } else {
            if (!"HTTP/1.1".equalsIgnoreCase(split[2])) {
                throw new InvalidHandshakeException("Invalid status line received: " + split[2] + " Status line: " + m);
            }
            d dVar = new d();
            dVar.Hi(split[1]);
            iVar = dVar;
        }
        String m2 = m(byteBuffer);
        while (m2 != null && m2.length() > 0) {
            String[] split2 = m2.split(":", 2);
            if (split2.length != 2) {
                throw new InvalidHandshakeException("not an http header");
            }
            if (iVar.Hl(split2[0])) {
                iVar.put(split2[0], iVar.Hk(split2[0]) + "; " + split2[1].replaceFirst("^ +", ""));
            } else {
                iVar.put(split2[0], split2[1].replaceFirst("^ +", ""));
            }
            m2 = m(byteBuffer);
        }
        if (m2 == null) {
            throw new IncompleteHandshakeException();
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(f fVar) {
        return fVar.Hk("Upgrade").equalsIgnoreCase("websocket") && fVar.Hk(HTTP.CONN_DIRECTIVE).toLowerCase(Locale.ENGLISH).contains(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
    }

    public List<Framedata> a(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        org.java_websocket.framing.f iVar;
        if (opcode != Framedata.Opcode.BINARY && opcode != Framedata.Opcode.TEXT) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        if (this.kwU != null) {
            iVar = new org.java_websocket.framing.c();
        } else {
            this.kwU = opcode;
            if (opcode == Framedata.Opcode.BINARY) {
                iVar = new org.java_websocket.framing.a();
            } else {
                iVar = opcode == Framedata.Opcode.TEXT ? new org.java_websocket.framing.i() : null;
            }
        }
        iVar.q(byteBuffer);
        iVar.sB(z);
        try {
            iVar.cNK();
            if (z) {
                this.kwU = null;
            } else {
                this.kwU = opcode;
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
            sb.append("HTTP/1.1 101 ").append(((h) fVar).cNS());
        } else {
            throw new IllegalArgumentException("unknown role");
        }
        sb.append("\r\n");
        Iterator<String> cNT = fVar.cNT();
        while (cNT.hasNext()) {
            String next = cNT.next();
            String Hk = fVar.Hk(next);
            sb.append(next);
            sb.append(": ");
            sb.append(Hk);
            sb.append("\r\n");
        }
        sb.append("\r\n");
        byte[] GC = org.java_websocket.e.c.GC(sb.toString());
        byte[] content = z ? fVar.getContent() : null;
        ByteBuffer allocate = ByteBuffer.allocate((content == null ? 0 : content.length) + GC.length);
        allocate.put(GC);
        if (content != null) {
            allocate.put(content);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public f o(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        return a(byteBuffer, this.kwG);
    }

    public int Dr(int i) throws LimitExedeedException, InvalidDataException {
        if (i < 0) {
            throw new InvalidDataException(1002, "Negative count");
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(f fVar) {
        String Hk = fVar.Hk("Sec-WebSocket-Version");
        if (Hk.length() > 0) {
            try {
                return new Integer(Hk.trim()).intValue();
            } catch (NumberFormatException e) {
                return -1;
            }
        }
        return -1;
    }

    public void a(WebSocket.Role role) {
        this.kwG = role;
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
