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
    private b qya;
    private List<b> qyb;
    private org.java_websocket.d.a qyc;
    private List<org.java_websocket.d.a> qyd;
    private Framedata qye;
    private List<ByteBuffer> qyf;
    private ByteBuffer qyg;
    private final Random qyh;

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
        this.qya = new org.java_websocket.b.a();
        this.qyh = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.qyb = new ArrayList(list.size());
        this.qyd = new ArrayList(list2.size());
        boolean z2 = false;
        this.qyf = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.qyb.addAll(list);
        if (!z) {
            this.qyb.add(this.qyb.size(), this.qya);
        }
        this.qyd.addAll(list2);
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (c(aVar) != 13) {
            bV("acceptHandshakeAsServer - Wrong websocket version.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String acD = aVar.acD("Sec-WebSocket-Extensions");
        Iterator<b> it = this.qyb.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.acz(acD)) {
                this.qya = next;
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                bV("acceptHandshakeAsServer - Matching extension found: " + this.qya.toString());
                handshakeState2 = handshakeState3;
                break;
            }
        }
        Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
        String acD2 = aVar.acD("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.qyd.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState4;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.acF(acD2)) {
                this.qyc = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                bV("acceptHandshakeAsServer - Matching protocol found: " + this.qyc.toString());
                break;
            }
        }
        if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
            return Draft.HandshakeState.MATCHED;
        }
        bV("acceptHandshakeAsServer - No matching extension or protocol found.");
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar, h hVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (!b(hVar)) {
            bV("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return Draft.HandshakeState.NOT_MATCHED;
        } else if (!aVar.acE("Sec-WebSocket-Key") || !hVar.acE("Sec-WebSocket-Accept")) {
            bV("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return Draft.HandshakeState.NOT_MATCHED;
        } else {
            if (!acy(aVar.acD("Sec-WebSocket-Key")).equals(hVar.acD("Sec-WebSocket-Accept"))) {
                bV("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String acD = hVar.acD("Sec-WebSocket-Extensions");
            Iterator<b> it = this.qyb.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.acA(acD)) {
                    this.qya = next;
                    Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                    bV("acceptHandshakeAsClient - Matching extension found: " + this.qya.toString());
                    handshakeState2 = handshakeState3;
                    break;
                }
            }
            Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
            String acD2 = hVar.acD("Sec-WebSocket-Protocol");
            Iterator<org.java_websocket.d.a> it2 = this.qyd.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    handshakeState = handshakeState4;
                    break;
                }
                org.java_websocket.d.a next2 = it2.next();
                if (next2.acF(acD2)) {
                    this.qyc = next2;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    bV("acceptHandshakeAsClient - Matching protocol found: " + this.qyc.toString());
                    break;
                }
            }
            if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
                return Draft.HandshakeState.MATCHED;
            }
            bV("acceptHandshakeAsClient - No matching extension or protocol found.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
    }

    public b eLO() {
        return this.qya;
    }

    public List<b> eLP() {
        return this.qyb;
    }

    public org.java_websocket.d.a eLQ() {
        return this.qyc;
    }

    public List<org.java_websocket.d.a> eLR() {
        return this.qyd;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.qyh.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.qyb) {
            if (bVar2.eLU() != null && bVar2.eLU().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.eLU());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.qyd) {
            if (aVar.eMg().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.eMg());
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
        iVar.put(HTTP.CONN_DIRECTIVE, aVar.acD(HTTP.CONN_DIRECTIVE));
        String acD = aVar.acD("Sec-WebSocket-Key");
        if (acD == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", acy(acD));
        if (eLO().eLV().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", eLO().eLV());
        }
        if (eLQ() != null && eLQ().eMg().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", eLQ().eMg());
        }
        iVar.acC("Web Socket Protocol Handshake");
        iVar.put("Server", "TooTallNate Java-WebSocket");
        iVar.put("Date", eLS());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft eLN() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : eLP()) {
            arrayList.add(bVar.eLW());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : eLR()) {
            arrayList2.add(aVar.eMh());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        eLO().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.eLZ().remaining() + "): {" + (framedata.eLZ().remaining() > 1000 ? "too big to display" : new String(framedata.eLZ().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer eLZ = framedata.eLZ();
        boolean z = this.qxL == WebSocket.Role.CLIENT;
        if (eLZ.remaining() <= 125) {
            i = 1;
        } else {
            i = eLZ.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + eLZ.remaining());
        allocate.put((byte) (((byte) (framedata.amL() ? -128 : 0)) | a(framedata.eMd())));
        byte[] P = P(eLZ.remaining(), i);
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
                allocate2.putInt(this.qyh.nextInt());
                allocate.put(allocate2.array());
                while (eLZ.hasRemaining()) {
                    allocate.put((byte) (eLZ.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(eLZ);
                eLZ.flip();
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
        byte b;
        int remaining = byteBuffer.remaining();
        int i = 2;
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
        Framedata.Opcode j = j((byte) (b2 & 15));
        if (b4 >= 0 && b4 <= 125) {
            b = b4;
        } else if (j == Framedata.Opcode.PING || j == Framedata.Opcode.PONG || j == Framedata.Opcode.CLOSING) {
            throw new InvalidFrameException("more than 125 octets");
        } else {
            if (b4 == 126) {
                i = 4;
                if (remaining < 4) {
                    throw new IncompleteException(4);
                }
                b = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
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
                b = (int) longValue;
            }
        }
        int i3 = (z5 ? 4 : 0) + i + b;
        if (remaining < i3) {
            throw new IncompleteException(i3);
        }
        ByteBuffer allocate = ByteBuffer.allocate(SF(b));
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
        f b5 = f.b(j);
        b5.fa(z3);
        b5.CV(z);
        b5.CW(z2);
        b5.CX(z4);
        allocate.flip();
        b5.A(allocate);
        eLO().e(b5);
        eLO().c(b5);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b5.eLZ().remaining() + "): {" + (b5.eLZ().remaining() > 1000 ? "too big to display" : new String(b5.eLZ().array())) + '}');
        }
        b5.eLX();
        return b5;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> x(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.qyg == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.qyg.remaining();
                if (remaining2 > remaining) {
                    this.qyg.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.qyg.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(z((ByteBuffer) this.qyg.duplicate().position(0)));
                this.qyg = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(SF(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.qyg.limit()) {
                    throw new AssertionError();
                }
                this.qyg.rewind();
                allocate.put(this.qyg);
                this.qyg = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(z(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.qyg = ByteBuffer.allocate(SF(e2.getPreferredSize()));
                this.qyg.put(byteBuffer);
            }
        }
        return linkedList;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> b(ByteBuffer byteBuffer, boolean z) {
        org.java_websocket.framing.a aVar = new org.java_websocket.framing.a();
        aVar.A(byteBuffer);
        aVar.CY(z);
        try {
            aVar.eLX();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> bp(String str, boolean z) {
        org.java_websocket.framing.i iVar = new org.java_websocket.framing.i();
        iVar.A(ByteBuffer.wrap(org.java_websocket.e.c.acG(str)));
        iVar.CY(z);
        try {
            iVar.eLX();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.qyg = null;
        if (this.qya != null) {
            this.qya.reset();
        }
        this.qya = new org.java_websocket.b.a();
        this.qyc = null;
    }

    private String eLS() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String acy(String str) {
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

    private Framedata.Opcode j(byte b) throws InvalidFrameException {
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
        Framedata.Opcode eMd = framedata.eMd();
        if (eMd == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.q(i, str, true);
            } else if (eLM() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.p(i, str, true);
            } else {
                cVar.r(i, str, false);
            }
        } else if (eMd == Framedata.Opcode.PING) {
            cVar.eLL().onWebsocketPing(cVar, framedata);
        } else if (eMd == Framedata.Opcode.PONG) {
            cVar.eLK();
            cVar.eLL().onWebsocketPong(cVar, framedata);
        } else if (!framedata.amL() || eMd == Framedata.Opcode.CONTINUOUS) {
            if (eMd != Framedata.Opcode.CONTINUOUS) {
                if (this.qye != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.qye = framedata;
                this.qyf.add(framedata.eLZ());
            } else if (framedata.amL()) {
                if (this.qye == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.qyf.add(framedata.eLZ());
                if (this.qye.eMd() == Framedata.Opcode.TEXT) {
                    ((f) this.qye).A(eLT());
                    ((f) this.qye).eLX();
                    try {
                        cVar.eLL().onWebsocketMessage(cVar, org.java_websocket.e.c.B(this.qye.eLZ()));
                    } catch (RuntimeException e) {
                        cVar.eLL().onWebsocketError(cVar, e);
                    }
                } else if (this.qye.eMd() == Framedata.Opcode.BINARY) {
                    ((f) this.qye).A(eLT());
                    ((f) this.qye).eLX();
                    try {
                        cVar.eLL().onWebsocketMessage(cVar, this.qye.eLZ());
                    } catch (RuntimeException e2) {
                        cVar.eLL().onWebsocketError(cVar, e2);
                    }
                }
                this.qye = null;
                this.qyf.clear();
            } else if (this.qye == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (eMd == Framedata.Opcode.TEXT && !org.java_websocket.e.c.C(framedata.eLZ())) {
                throw new InvalidDataException(1007);
            }
            if (eMd == Framedata.Opcode.CONTINUOUS && this.qye != null) {
                this.qyf.add(framedata.eLZ());
            }
        } else if (this.qye != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (eMd == Framedata.Opcode.TEXT) {
                try {
                    cVar.eLL().onWebsocketMessage(cVar, org.java_websocket.e.c.B(framedata.eLZ()));
                } catch (RuntimeException e3) {
                    cVar.eLL().onWebsocketError(cVar, e3);
                }
            } else if (eMd == Framedata.Opcode.BINARY) {
                try {
                    cVar.eLL().onWebsocketMessage(cVar, framedata.eLZ());
                } catch (RuntimeException e4) {
                    cVar.eLL().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType eLM() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (eLO() != null) {
            draft = draft + " extension: " + eLO().toString();
        }
        if (eLQ() != null) {
            return draft + " protocol: " + eLQ().toString();
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
        if (this.qya == null ? aVar.qya != null : !this.qya.equals(aVar.qya)) {
            return false;
        }
        return this.qyc != null ? this.qyc.equals(aVar.qyc) : aVar.qyc == null;
    }

    public int hashCode() {
        return ((this.qya != null ? this.qya.hashCode() : 0) * 31) + (this.qyc != null ? this.qyc.hashCode() : 0);
    }

    private ByteBuffer eLT() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.qyf.iterator();
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
        for (ByteBuffer byteBuffer : this.qyf) {
            allocate.put(byteBuffer);
        }
        allocate.flip();
        return allocate;
    }

    private static void bV(Object obj) {
        if (org.java_websocket.c.DEBUG) {
            System.out.println(obj);
        }
    }
}
