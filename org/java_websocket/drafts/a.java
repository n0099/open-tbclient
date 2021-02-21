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
/* loaded from: classes4.dex */
public class a extends Draft {
    static final /* synthetic */ boolean $assertionsDisabled;
    private org.java_websocket.d.a qxA;
    private List<org.java_websocket.d.a> qxB;
    private Framedata qxC;
    private List<ByteBuffer> qxD;
    private ByteBuffer qxE;
    private final Random qxF;
    private b qxy;
    private List<b> qxz;

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
        this.qxy = new org.java_websocket.b.a();
        this.qxF = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.qxz = new ArrayList(list.size());
        this.qxB = new ArrayList(list2.size());
        boolean z2 = false;
        this.qxD = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.qxz.addAll(list);
        if (!z) {
            this.qxz.add(this.qxz.size(), this.qxy);
        }
        this.qxB.addAll(list2);
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (c(aVar) != 13) {
            bU("acceptHandshakeAsServer - Wrong websocket version.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String acE = aVar.acE("Sec-WebSocket-Extensions");
        Iterator<b> it = this.qxz.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.acA(acE)) {
                this.qxy = next;
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                bU("acceptHandshakeAsServer - Matching extension found: " + this.qxy.toString());
                handshakeState2 = handshakeState3;
                break;
            }
        }
        Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
        String acE2 = aVar.acE("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.qxB.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState4;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.acG(acE2)) {
                this.qxA = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                bU("acceptHandshakeAsServer - Matching protocol found: " + this.qxA.toString());
                break;
            }
        }
        if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
            return Draft.HandshakeState.MATCHED;
        }
        bU("acceptHandshakeAsServer - No matching extension or protocol found.");
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar, h hVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (!b(hVar)) {
            bU("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return Draft.HandshakeState.NOT_MATCHED;
        } else if (!aVar.acF("Sec-WebSocket-Key") || !hVar.acF("Sec-WebSocket-Accept")) {
            bU("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return Draft.HandshakeState.NOT_MATCHED;
        } else {
            if (!acz(aVar.acE("Sec-WebSocket-Key")).equals(hVar.acE("Sec-WebSocket-Accept"))) {
                bU("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String acE = hVar.acE("Sec-WebSocket-Extensions");
            Iterator<b> it = this.qxz.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.acB(acE)) {
                    this.qxy = next;
                    Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                    bU("acceptHandshakeAsClient - Matching extension found: " + this.qxy.toString());
                    handshakeState2 = handshakeState3;
                    break;
                }
            }
            Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
            String acE2 = hVar.acE("Sec-WebSocket-Protocol");
            Iterator<org.java_websocket.d.a> it2 = this.qxB.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    handshakeState = handshakeState4;
                    break;
                }
                org.java_websocket.d.a next2 = it2.next();
                if (next2.acG(acE2)) {
                    this.qxA = next2;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    bU("acceptHandshakeAsClient - Matching protocol found: " + this.qxA.toString());
                    break;
                }
            }
            if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
                return Draft.HandshakeState.MATCHED;
            }
            bU("acceptHandshakeAsClient - No matching extension or protocol found.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
    }

    public b eMg() {
        return this.qxy;
    }

    public List<b> eMh() {
        return this.qxz;
    }

    public org.java_websocket.d.a eMi() {
        return this.qxA;
    }

    public List<org.java_websocket.d.a> eMj() {
        return this.qxB;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.qxF.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.qxz) {
            if (bVar2.eMm() != null && bVar2.eMm().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.eMm());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.qxB) {
            if (aVar.eMy().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.eMy());
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
        iVar.put(HTTP.CONN_DIRECTIVE, aVar.acE(HTTP.CONN_DIRECTIVE));
        String acE = aVar.acE("Sec-WebSocket-Key");
        if (acE == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", acz(acE));
        if (eMg().eMn().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", eMg().eMn());
        }
        if (eMi() != null && eMi().eMy().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", eMi().eMy());
        }
        iVar.acD("Web Socket Protocol Handshake");
        iVar.put("Server", "TooTallNate Java-WebSocket");
        iVar.put("Date", eMk());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft eMf() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : eMh()) {
            arrayList.add(bVar.eMo());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : eMj()) {
            arrayList2.add(aVar.eMz());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        eMg().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.eMr().remaining() + "): {" + (framedata.eMr().remaining() > 1000 ? "too big to display" : new String(framedata.eMr().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer eMr = framedata.eMr();
        boolean z = this.qxj == WebSocket.Role.CLIENT;
        if (eMr.remaining() <= 125) {
            i = 1;
        } else {
            i = eMr.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + eMr.remaining());
        allocate.put((byte) (((byte) (framedata.amI() ? -128 : 0)) | a(framedata.eMv())));
        byte[] P = P(eMr.remaining(), i);
        if ($assertionsDisabled || P.length == i) {
            if (i == 1) {
                allocate.put((byte) (P[0] | (z ? Byte.MIN_VALUE : (byte) 0)));
            } else if (i == 2) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | 126));
                allocate.put(P);
            } else if (i == 8) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | Byte.MAX_VALUE));
                allocate.put(P);
            } else {
                throw new RuntimeException("Size representation not supported/specified");
            }
            if (z) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.putInt(this.qxF.nextInt());
                allocate.put(allocate2.array());
                while (eMr.hasRemaining()) {
                    allocate.put((byte) (eMr.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(eMr);
                eMr.flip();
            }
            if ($assertionsDisabled || allocate.remaining() == 0) {
                allocate.flip();
                return allocate;
            }
            throw new AssertionError(allocate.remaining());
        }
        throw new AssertionError();
    }

    public Framedata z(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
        boolean z;
        boolean z2;
        byte b2;
        int remaining = byteBuffer.remaining();
        int i = 2;
        if (remaining < 2) {
            throw new IncompleteException(2);
        }
        byte b3 = byteBuffer.get();
        boolean z3 = (b3 >> 8) != 0;
        boolean z4 = false;
        if ((b3 & 64) == 0) {
            z = false;
        } else {
            z = true;
        }
        if ((b3 & 32) == 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if ((b3 & 16) != 0) {
            z4 = true;
        }
        byte b4 = byteBuffer.get();
        boolean z5 = (b4 & Byte.MIN_VALUE) != 0;
        byte b5 = (byte) (b4 & Byte.MAX_VALUE);
        Framedata.Opcode j = j((byte) (b3 & 15));
        if (b5 >= 0 && b5 <= 125) {
            b2 = b5;
        } else if (j == Framedata.Opcode.PING || j == Framedata.Opcode.PONG || j == Framedata.Opcode.CLOSING) {
            throw new InvalidFrameException("more than 125 octets");
        } else {
            if (b5 == 126) {
                i = 4;
                if (remaining < 4) {
                    throw new IncompleteException(4);
                }
                b2 = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
            } else {
                i = 10;
                if (remaining < 10) {
                    throw new IncompleteException(10);
                }
                byte[] bArr = new byte[8];
                for (int i2 = 0; i2 < 8; i2++) {
                    bArr[i2] = byteBuffer.get();
                }
                long longValue = new BigInteger(bArr).longValue();
                if (longValue > 2147483647L) {
                    throw new LimitExedeedException("Payloadsize is to big...");
                }
                b2 = (int) longValue;
            }
        }
        int i3 = (z5 ? 4 : 0) + i + b2;
        if (remaining < i3) {
            throw new IncompleteException(i3);
        }
        ByteBuffer allocate = ByteBuffer.allocate(SG(b2));
        if (z5) {
            byte[] bArr2 = new byte[4];
            byteBuffer.get(bArr2);
            for (int i4 = 0; i4 < b2; i4++) {
                allocate.put((byte) (byteBuffer.get() ^ bArr2[i4 % 4]));
            }
        } else {
            allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
            byteBuffer.position(byteBuffer.position() + allocate.limit());
        }
        f b6 = f.b(j);
        b6.fa(z3);
        b6.CZ(z);
        b6.Da(z2);
        b6.Db(z4);
        allocate.flip();
        b6.A(allocate);
        eMg().e(b6);
        eMg().c(b6);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b6.eMr().remaining() + "): {" + (b6.eMr().remaining() > 1000 ? "too big to display" : new String(b6.eMr().array())) + '}');
        }
        b6.eMp();
        return b6;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> x(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.qxE == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.qxE.remaining();
                if (remaining2 > remaining) {
                    this.qxE.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.qxE.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(z((ByteBuffer) this.qxE.duplicate().position(0)));
                this.qxE = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(SG(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.qxE.limit()) {
                    throw new AssertionError();
                }
                this.qxE.rewind();
                allocate.put(this.qxE);
                this.qxE = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(z(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.qxE = ByteBuffer.allocate(SG(e2.getPreferredSize()));
                this.qxE.put(byteBuffer);
            }
        }
        return linkedList;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> b(ByteBuffer byteBuffer, boolean z) {
        org.java_websocket.framing.a aVar = new org.java_websocket.framing.a();
        aVar.A(byteBuffer);
        aVar.Dc(z);
        try {
            aVar.eMp();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> bp(String str, boolean z) {
        org.java_websocket.framing.i iVar = new org.java_websocket.framing.i();
        iVar.A(ByteBuffer.wrap(org.java_websocket.e.c.acH(str)));
        iVar.Dc(z);
        try {
            iVar.eMp();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.qxE = null;
        if (this.qxy != null) {
            this.qxy.reset();
        }
        this.qxy = new org.java_websocket.b.a();
        this.qxA = null;
    }

    private String eMk() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String acz(String str) {
        try {
            return org.java_websocket.e.a.encodeBytes(MessageDigest.getInstance("SHA1").digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    private byte[] P(long j, int i) {
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

    private Framedata.Opcode j(byte b2) throws InvalidFrameException {
        switch (b2) {
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
                throw new InvalidFrameException("Unknown opcode " + ((int) b2));
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
        Framedata.Opcode eMv = framedata.eMv();
        if (eMv == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.q(i, str, true);
            } else if (eMe() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.p(i, str, true);
            } else {
                cVar.r(i, str, false);
            }
        } else if (eMv == Framedata.Opcode.PING) {
            cVar.eMd().onWebsocketPing(cVar, framedata);
        } else if (eMv == Framedata.Opcode.PONG) {
            cVar.eMc();
            cVar.eMd().onWebsocketPong(cVar, framedata);
        } else if (!framedata.amI() || eMv == Framedata.Opcode.CONTINUOUS) {
            if (eMv != Framedata.Opcode.CONTINUOUS) {
                if (this.qxC != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.qxC = framedata;
                this.qxD.add(framedata.eMr());
            } else if (framedata.amI()) {
                if (this.qxC == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.qxD.add(framedata.eMr());
                if (this.qxC.eMv() == Framedata.Opcode.TEXT) {
                    ((f) this.qxC).A(eMl());
                    ((f) this.qxC).eMp();
                    try {
                        cVar.eMd().onWebsocketMessage(cVar, org.java_websocket.e.c.B(this.qxC.eMr()));
                    } catch (RuntimeException e) {
                        cVar.eMd().onWebsocketError(cVar, e);
                    }
                } else if (this.qxC.eMv() == Framedata.Opcode.BINARY) {
                    ((f) this.qxC).A(eMl());
                    ((f) this.qxC).eMp();
                    try {
                        cVar.eMd().onWebsocketMessage(cVar, this.qxC.eMr());
                    } catch (RuntimeException e2) {
                        cVar.eMd().onWebsocketError(cVar, e2);
                    }
                }
                this.qxC = null;
                this.qxD.clear();
            } else if (this.qxC == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (eMv == Framedata.Opcode.TEXT && !org.java_websocket.e.c.C(framedata.eMr())) {
                throw new InvalidDataException(1007);
            }
            if (eMv == Framedata.Opcode.CONTINUOUS && this.qxC != null) {
                this.qxD.add(framedata.eMr());
            }
        } else if (this.qxC != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (eMv == Framedata.Opcode.TEXT) {
                try {
                    cVar.eMd().onWebsocketMessage(cVar, org.java_websocket.e.c.B(framedata.eMr()));
                } catch (RuntimeException e3) {
                    cVar.eMd().onWebsocketError(cVar, e3);
                }
            } else if (eMv == Framedata.Opcode.BINARY) {
                try {
                    cVar.eMd().onWebsocketMessage(cVar, framedata.eMr());
                } catch (RuntimeException e4) {
                    cVar.eMd().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType eMe() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (eMg() != null) {
            draft = draft + " extension: " + eMg().toString();
        }
        if (eMi() != null) {
            return draft + " protocol: " + eMi().toString();
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
        if (this.qxy == null ? aVar.qxy != null : !this.qxy.equals(aVar.qxy)) {
            return false;
        }
        return this.qxA != null ? this.qxA.equals(aVar.qxA) : aVar.qxA == null;
    }

    public int hashCode() {
        return ((this.qxy != null ? this.qxy.hashCode() : 0) * 31) + (this.qxA != null ? this.qxA.hashCode() : 0);
    }

    private ByteBuffer eMl() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.qxD.iterator();
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
        for (ByteBuffer byteBuffer : this.qxD) {
            allocate.put(byteBuffer);
        }
        allocate.flip();
        return allocate;
    }

    private static void bU(Object obj) {
        if (org.java_websocket.c.DEBUG) {
            System.out.println(obj);
        }
    }
}
