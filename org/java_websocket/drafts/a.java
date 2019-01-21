package org.java_websocket.drafts;

import com.tencent.connect.common.Constants;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import org.apache.http.protocol.HTTP;
import org.java_websocket.WebSocket;
import org.java_websocket.b.b;
import org.java_websocket.c.c;
import org.java_websocket.c.h;
import org.java_websocket.c.i;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.IncompleteException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExedeedException;
import org.java_websocket.exceptions.NotSendableException;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.f;
/* loaded from: classes2.dex */
public class a extends Draft {
    static final /* synthetic */ boolean $assertionsDisabled;
    private List<org.java_websocket.d.a> iEA;
    private Framedata iEB;
    private List<ByteBuffer> iEC;
    private ByteBuffer iED;
    private final Random iEE;
    private b iEx;
    private List<b> iEy;
    private org.java_websocket.d.a iEz;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a() {
        this(Collections.emptyList());
    }

    public a(List<b> list) {
        this(list, Collections.singletonList(new org.java_websocket.d.b("")));
    }

    public a(List<b> list, List<org.java_websocket.d.a> list2) {
        boolean z;
        this.iEx = new org.java_websocket.b.a();
        this.iEE = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.iEy = new ArrayList(list.size());
        this.iEA = new ArrayList(list2.size());
        boolean z2 = false;
        this.iEC = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.iEy.addAll(list);
        if (!z) {
            this.iEy.add(this.iEy.size(), this.iEx);
        }
        this.iEA.addAll(list2);
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (c(aVar) != 13) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String Af = aVar.Af("Sec-WebSocket-Extensions");
        Iterator<b> it = this.iEy.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.Ab(Af)) {
                this.iEx = next;
                handshakeState2 = Draft.HandshakeState.MATCHED;
                break;
            }
        }
        Draft.HandshakeState handshakeState3 = Draft.HandshakeState.NOT_MATCHED;
        String Af2 = aVar.Af("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.iEA.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState3;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.Ah(Af2)) {
                this.iEz = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                break;
            }
        }
        if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
            return Draft.HandshakeState.MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar, h hVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (!b(hVar)) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        if (!aVar.Ag("Sec-WebSocket-Key") || !hVar.Ag("Sec-WebSocket-Accept")) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        if (!Aa(aVar.Af("Sec-WebSocket-Key")).equals(hVar.Af("Sec-WebSocket-Accept"))) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String Af = hVar.Af("Sec-WebSocket-Extensions");
        Iterator<b> it = this.iEy.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.Ac(Af)) {
                this.iEx = next;
                handshakeState2 = Draft.HandshakeState.MATCHED;
                break;
            }
        }
        Draft.HandshakeState handshakeState3 = Draft.HandshakeState.NOT_MATCHED;
        String Af2 = hVar.Af("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.iEA.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState3;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.Ah(Af2)) {
                this.iEz = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                break;
            }
        }
        if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
            return Draft.HandshakeState.MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    public b cdN() {
        return this.iEx;
    }

    public List<b> cdO() {
        return this.iEy;
    }

    public org.java_websocket.d.a cdP() {
        return this.iEz;
    }

    public List<org.java_websocket.d.a> cdQ() {
        return this.iEA;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.iEE.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.iEy) {
            if (bVar2.cdT() != null && bVar2.cdT().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.cdT());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.iEA) {
            if (aVar.ceg().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.ceg());
            }
        }
        if (sb2.length() != 0) {
            bVar.put("Sec-WebSocket-Protocol", sb2.toString());
        }
        return bVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public c a(org.java_websocket.c.a aVar, i iVar) throws InvalidHandshakeException {
        iVar.put("Upgrade", "websocket");
        iVar.put(HTTP.CONN_DIRECTIVE, aVar.Af(HTTP.CONN_DIRECTIVE));
        String Af = aVar.Af("Sec-WebSocket-Key");
        if (Af == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", Aa(Af));
        if (cdN().cdU().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", cdN().cdU());
        }
        if (cdP() != null && cdP().ceg().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", cdP().ceg());
        }
        iVar.Ae("Web Socket Protocol Handshake");
        iVar.put(HTTP.SERVER_HEADER, "TooTallNate Java-WebSocket");
        iVar.put(HTTP.DATE_HEADER, cdR());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft cdM() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : cdO()) {
            arrayList.add(bVar.cdV());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : cdQ()) {
            arrayList2.add(aVar.ceh());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        cdN().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.cdY().remaining() + "): {" + (framedata.cdY().remaining() > 1000 ? "too big to display" : new String(framedata.cdY().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer cdY = framedata.cdY();
        boolean z = this.iEi == WebSocket.Role.CLIENT;
        if (cdY.remaining() <= 125) {
            i = 1;
        } else {
            i = cdY.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + cdY.remaining());
        allocate.put((byte) (((byte) (framedata.cdZ() ? -128 : 0)) | a(framedata.ced())));
        byte[] s = s(cdY.remaining(), i);
        if ($assertionsDisabled || s.length == i) {
            if (i == 1) {
                allocate.put((byte) (s[0] | (z ? Byte.MIN_VALUE : (byte) 0)));
            } else if (i == 2) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | 126));
                allocate.put(s);
            } else if (i == 8) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | Byte.MAX_VALUE));
                allocate.put(s);
            } else {
                throw new RuntimeException("Size representation not supported/specified");
            }
            if (z) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.putInt(this.iEE.nextInt());
                allocate.put(allocate2.array());
                while (cdY.hasRemaining()) {
                    allocate.put((byte) (cdY.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(cdY);
                cdY.flip();
            }
            if ($assertionsDisabled || allocate.remaining() == 0) {
                allocate.flip();
                return allocate;
            }
            throw new AssertionError(allocate.remaining());
        }
        throw new AssertionError();
    }

    public Framedata s(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
        boolean z;
        boolean z2;
        int i;
        byte b;
        int remaining = byteBuffer.remaining();
        if (remaining < 2) {
            throw new IncompleteException(2);
        }
        byte b2 = byteBuffer.get();
        boolean z3 = (b2 >> 8) != 0;
        boolean z4 = false;
        if ((b2 & 64) == 0) {
            z = false;
        } else {
            z = true;
        }
        if ((b2 & 32) == 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if ((b2 & 16) != 0) {
            z4 = true;
        }
        byte b3 = byteBuffer.get();
        boolean z5 = (b3 & Byte.MIN_VALUE) != 0;
        byte b4 = (byte) (b3 & Byte.MAX_VALUE);
        Framedata.Opcode d = d((byte) (b2 & 15));
        if (b4 >= 0 && b4 <= 125) {
            i = 2;
            b = b4;
        } else if (d == Framedata.Opcode.PING || d == Framedata.Opcode.PONG || d == Framedata.Opcode.CLOSING) {
            throw new InvalidFrameException("more than 125 octets");
        } else {
            if (b4 == 126) {
                if (remaining >= 4) {
                    i = 4;
                    b = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
                } else {
                    throw new IncompleteException(4);
                }
            } else if (remaining < 10) {
                throw new IncompleteException(10);
            } else {
                byte[] bArr = new byte[8];
                for (int i2 = 0; i2 < 8; i2++) {
                    bArr[i2] = byteBuffer.get();
                }
                long longValue = new BigInteger(bArr).longValue();
                if (longValue <= 2147483647L) {
                    i = 10;
                    b = (int) longValue;
                } else {
                    throw new LimitExedeedException("Payloadsize is to big...");
                }
            }
        }
        int i3 = (z5 ? 4 : 0) + i + b;
        if (remaining < i3) {
            throw new IncompleteException(i3);
        }
        ByteBuffer allocate = ByteBuffer.allocate(zB(b));
        if (z5) {
            byte[] bArr2 = new byte[4];
            byteBuffer.get(bArr2);
            for (int i4 = 0; i4 < b; i4++) {
                allocate.put((byte) (byteBuffer.get() ^ bArr2[i4 % 4]));
            }
        } else {
            allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
            byteBuffer.position(byteBuffer.position() + allocate.limit());
        }
        f b5 = f.b(d);
        b5.pm(z3);
        b5.pn(z);
        b5.po(z2);
        b5.pp(z4);
        allocate.flip();
        b5.t(allocate);
        cdN().e(b5);
        cdN().c(b5);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b5.cdY().remaining() + "): {" + (b5.cdY().remaining() > 1000 ? "too big to display" : new String(b5.cdY().array())) + '}');
        }
        b5.cdW();
        return b5;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> q(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.iED == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.iED.remaining();
                if (remaining2 > remaining) {
                    this.iED.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.iED.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(s((ByteBuffer) this.iED.duplicate().position(0)));
                this.iED = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(zB(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.iED.limit()) {
                    throw new AssertionError();
                }
                this.iED.rewind();
                allocate.put(this.iED);
                this.iED = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(s(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.iED = ByteBuffer.allocate(zB(e2.getPreferredSize()));
                this.iED.put(byteBuffer);
            }
        }
        return linkedList;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> b(ByteBuffer byteBuffer, boolean z) {
        org.java_websocket.framing.a aVar = new org.java_websocket.framing.a();
        aVar.t(byteBuffer);
        aVar.pq(z);
        try {
            aVar.cdW();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> ai(String str, boolean z) {
        org.java_websocket.framing.i iVar = new org.java_websocket.framing.i();
        iVar.t(ByteBuffer.wrap(org.java_websocket.e.c.Ai(str)));
        iVar.pq(z);
        try {
            iVar.cdW();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.iED = null;
        if (this.iEx != null) {
            this.iEx.reset();
        }
        this.iEx = new org.java_websocket.b.a();
        this.iEz = null;
    }

    private String cdR() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String Aa(String str) {
        try {
            return org.java_websocket.e.a.encodeBytes(MessageDigest.getInstance("SHA1").digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    private byte[] s(long j, int i) {
        byte[] bArr = new byte[i];
        int i2 = (i * 8) - 8;
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) (j >>> (i2 - (i3 * 8)));
        }
        return bArr;
    }

    private byte a(Framedata.Opcode opcode) {
        if (opcode == Framedata.Opcode.CONTINUOUS) {
            return (byte) 0;
        }
        if (opcode == Framedata.Opcode.TEXT) {
            return (byte) 1;
        }
        if (opcode == Framedata.Opcode.BINARY) {
            return (byte) 2;
        }
        if (opcode == Framedata.Opcode.CLOSING) {
            return (byte) 8;
        }
        if (opcode == Framedata.Opcode.PING) {
            return (byte) 9;
        }
        if (opcode == Framedata.Opcode.PONG) {
            return (byte) 10;
        }
        throw new IllegalArgumentException("Don't know how to handle " + opcode.toString());
    }

    private Framedata.Opcode d(byte b) throws InvalidFrameException {
        switch (b) {
            case 0:
                return Framedata.Opcode.CONTINUOUS;
            case 1:
                return Framedata.Opcode.TEXT;
            case 2:
                return Framedata.Opcode.BINARY;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            default:
                throw new InvalidFrameException("Unknown opcode " + ((int) b));
            case 8:
                return Framedata.Opcode.CLOSING;
            case 9:
                return Framedata.Opcode.PING;
            case 10:
                return Framedata.Opcode.PONG;
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void a(org.java_websocket.c cVar, Framedata framedata) throws InvalidDataException {
        Framedata.Opcode ced = framedata.ced();
        if (ced == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.j(i, str, true);
            } else if (cdL() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.i(i, str, true);
            } else {
                cVar.k(i, str, false);
            }
        } else if (ced == Framedata.Opcode.PING) {
            cVar.cdK().onWebsocketPing(cVar, framedata);
        } else if (ced == Framedata.Opcode.PONG) {
            cVar.cdJ();
            cVar.cdK().onWebsocketPong(cVar, framedata);
        } else if (!framedata.cdZ() || ced == Framedata.Opcode.CONTINUOUS) {
            if (ced != Framedata.Opcode.CONTINUOUS) {
                if (this.iEB != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.iEB = framedata;
                this.iEC.add(framedata.cdY());
            } else if (framedata.cdZ()) {
                if (this.iEB == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.iEC.add(framedata.cdY());
                if (this.iEB.ced() == Framedata.Opcode.TEXT) {
                    ((f) this.iEB).t(cdS());
                    ((f) this.iEB).cdW();
                    try {
                        cVar.cdK().onWebsocketMessage(cVar, org.java_websocket.e.c.u(this.iEB.cdY()));
                    } catch (RuntimeException e) {
                        cVar.cdK().onWebsocketError(cVar, e);
                    }
                } else if (this.iEB.ced() == Framedata.Opcode.BINARY) {
                    ((f) this.iEB).t(cdS());
                    ((f) this.iEB).cdW();
                    try {
                        cVar.cdK().onWebsocketMessage(cVar, this.iEB.cdY());
                    } catch (RuntimeException e2) {
                        cVar.cdK().onWebsocketError(cVar, e2);
                    }
                }
                this.iEB = null;
                this.iEC.clear();
            } else if (this.iEB == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (ced == Framedata.Opcode.TEXT && !org.java_websocket.e.c.v(framedata.cdY())) {
                throw new InvalidDataException(1007);
            }
            if (ced == Framedata.Opcode.CONTINUOUS && this.iEB != null) {
                this.iEC.add(framedata.cdY());
            }
        } else if (this.iEB != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (ced == Framedata.Opcode.TEXT) {
                try {
                    cVar.cdK().onWebsocketMessage(cVar, org.java_websocket.e.c.u(framedata.cdY()));
                } catch (RuntimeException e3) {
                    cVar.cdK().onWebsocketError(cVar, e3);
                }
            } else if (ced == Framedata.Opcode.BINARY) {
                try {
                    cVar.cdK().onWebsocketMessage(cVar, framedata.cdY());
                } catch (RuntimeException e4) {
                    cVar.cdK().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType cdL() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (cdN() != null) {
            draft = draft + " extension: " + cdN().toString();
        }
        if (cdP() != null) {
            return draft + " protocol: " + cdP().toString();
        }
        return draft;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.iEx == null ? aVar.iEx != null : !this.iEx.equals(aVar.iEx)) {
            return false;
        }
        return this.iEz != null ? this.iEz.equals(aVar.iEz) : aVar.iEz == null;
    }

    public int hashCode() {
        return ((this.iEx != null ? this.iEx.hashCode() : 0) * 31) + (this.iEz != null ? this.iEz.hashCode() : 0);
    }

    private ByteBuffer cdS() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.iEC.iterator();
        while (true) {
            j = j2;
            if (!it.hasNext()) {
                break;
            }
            j2 = it.next().limit() + j;
        }
        if (j > 2147483647L) {
            throw new LimitExedeedException("Payloadsize is to big...");
        }
        ByteBuffer allocate = ByteBuffer.allocate((int) j);
        for (ByteBuffer byteBuffer : this.iEC) {
            allocate.put(byteBuffer);
        }
        allocate.flip();
        return allocate;
    }
}
