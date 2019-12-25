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
    private List<org.java_websocket.d.a> ncA;
    private Framedata ncB;
    private List<ByteBuffer> ncC;
    private ByteBuffer ncD;
    private final Random ncE;
    private b ncx;
    private List<b> ncy;
    private org.java_websocket.d.a ncz;

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
        this.ncx = new org.java_websocket.b.a();
        this.ncE = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.ncy = new ArrayList(list.size());
        this.ncA = new ArrayList(list2.size());
        boolean z2 = false;
        this.ncC = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.ncy.addAll(list);
        if (!z) {
            this.ncy.add(this.ncy.size(), this.ncx);
        }
        this.ncA.addAll(list2);
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (c(aVar) != 13) {
            bP("acceptHandshakeAsServer - Wrong websocket version.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String Rq = aVar.Rq("Sec-WebSocket-Extensions");
        Iterator<b> it = this.ncy.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.Rm(Rq)) {
                this.ncx = next;
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                bP("acceptHandshakeAsServer - Matching extension found: " + this.ncx.toString());
                handshakeState2 = handshakeState3;
                break;
            }
        }
        Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
        String Rq2 = aVar.Rq("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.ncA.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState4;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.Rs(Rq2)) {
                this.ncz = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                bP("acceptHandshakeAsServer - Matching protocol found: " + this.ncz.toString());
                break;
            }
        }
        if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
            return Draft.HandshakeState.MATCHED;
        }
        bP("acceptHandshakeAsServer - No matching extension or protocol found.");
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar, h hVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (!b(hVar)) {
            bP("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return Draft.HandshakeState.NOT_MATCHED;
        } else if (!aVar.Rr("Sec-WebSocket-Key") || !hVar.Rr("Sec-WebSocket-Accept")) {
            bP("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return Draft.HandshakeState.NOT_MATCHED;
        } else {
            if (!Rl(aVar.Rq("Sec-WebSocket-Key")).equals(hVar.Rq("Sec-WebSocket-Accept"))) {
                bP("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String Rq = hVar.Rq("Sec-WebSocket-Extensions");
            Iterator<b> it = this.ncy.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.Rn(Rq)) {
                    this.ncx = next;
                    Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                    bP("acceptHandshakeAsClient - Matching extension found: " + this.ncx.toString());
                    handshakeState2 = handshakeState3;
                    break;
                }
            }
            Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
            String Rq2 = hVar.Rq("Sec-WebSocket-Protocol");
            Iterator<org.java_websocket.d.a> it2 = this.ncA.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    handshakeState = handshakeState4;
                    break;
                }
                org.java_websocket.d.a next2 = it2.next();
                if (next2.Rs(Rq2)) {
                    this.ncz = next2;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    bP("acceptHandshakeAsClient - Matching protocol found: " + this.ncz.toString());
                    break;
                }
            }
            if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
                return Draft.HandshakeState.MATCHED;
            }
            bP("acceptHandshakeAsClient - No matching extension or protocol found.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
    }

    public b dFx() {
        return this.ncx;
    }

    public List<b> dFy() {
        return this.ncy;
    }

    public org.java_websocket.d.a dFz() {
        return this.ncz;
    }

    public List<org.java_websocket.d.a> dFA() {
        return this.ncA;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.ncE.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.ncy) {
            if (bVar2.dFD() != null && bVar2.dFD().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.dFD());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.ncA) {
            if (aVar.dFP().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.dFP());
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
        iVar.put(HTTP.CONN_DIRECTIVE, aVar.Rq(HTTP.CONN_DIRECTIVE));
        String Rq = aVar.Rq("Sec-WebSocket-Key");
        if (Rq == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", Rl(Rq));
        if (dFx().dFE().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", dFx().dFE());
        }
        if (dFz() != null && dFz().dFP().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", dFz().dFP());
        }
        iVar.Rp("Web Socket Protocol Handshake");
        iVar.put("Server", "TooTallNate Java-WebSocket");
        iVar.put("Date", dFB());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft dFw() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : dFy()) {
            arrayList.add(bVar.dFF());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : dFA()) {
            arrayList2.add(aVar.dFQ());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        dFx().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.dFI().remaining() + "): {" + (framedata.dFI().remaining() > 1000 ? "too big to display" : new String(framedata.dFI().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer dFI = framedata.dFI();
        boolean z = this.nci == WebSocket.Role.CLIENT;
        if (dFI.remaining() <= 125) {
            i = 1;
        } else {
            i = dFI.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + dFI.remaining());
        allocate.put((byte) (((byte) (framedata.JC() ? -128 : 0)) | a(framedata.dFM())));
        byte[] F = F(dFI.remaining(), i);
        if ($assertionsDisabled || F.length == i) {
            if (i == 1) {
                allocate.put((byte) (F[0] | (z ? Byte.MIN_VALUE : (byte) 0)));
            } else if (i == 2) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | 126));
                allocate.put(F);
            } else if (i == 8) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | Byte.MAX_VALUE));
                allocate.put(F);
            } else {
                throw new RuntimeException("Size representation not supported/specified");
            }
            if (z) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.putInt(this.ncE.nextInt());
                allocate.put(allocate2.array());
                while (dFI.hasRemaining()) {
                    allocate.put((byte) (dFI.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(dFI);
                dFI.flip();
            }
            if ($assertionsDisabled || allocate.remaining() == 0) {
                allocate.flip();
                return allocate;
            }
            throw new AssertionError(allocate.remaining());
        }
        throw new AssertionError();
    }

    public Framedata t(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
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
        Framedata.Opcode p = p((byte) (b2 & 15));
        if (b4 >= 0 && b4 <= 125) {
            i = 2;
            b = b4;
        } else if (p == Framedata.Opcode.PING || p == Framedata.Opcode.PONG || p == Framedata.Opcode.CLOSING) {
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
        ByteBuffer allocate = ByteBuffer.allocate(Nb(b));
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
        f b5 = f.b(p);
        b5.bX(z3);
        b5.wf(z);
        b5.wg(z2);
        b5.wh(z4);
        allocate.flip();
        b5.u(allocate);
        dFx().e(b5);
        dFx().c(b5);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b5.dFI().remaining() + "): {" + (b5.dFI().remaining() > 1000 ? "too big to display" : new String(b5.dFI().array())) + '}');
        }
        b5.dFG();
        return b5;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> r(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.ncD == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.ncD.remaining();
                if (remaining2 > remaining) {
                    this.ncD.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.ncD.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(t((ByteBuffer) this.ncD.duplicate().position(0)));
                this.ncD = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(Nb(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.ncD.limit()) {
                    throw new AssertionError();
                }
                this.ncD.rewind();
                allocate.put(this.ncD);
                this.ncD = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(t(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.ncD = ByteBuffer.allocate(Nb(e2.getPreferredSize()));
                this.ncD.put(byteBuffer);
            }
        }
        return linkedList;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> b(ByteBuffer byteBuffer, boolean z) {
        org.java_websocket.framing.a aVar = new org.java_websocket.framing.a();
        aVar.u(byteBuffer);
        aVar.wi(z);
        try {
            aVar.dFG();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> aP(String str, boolean z) {
        org.java_websocket.framing.i iVar = new org.java_websocket.framing.i();
        iVar.u(ByteBuffer.wrap(org.java_websocket.e.c.Rt(str)));
        iVar.wi(z);
        try {
            iVar.dFG();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.ncD = null;
        if (this.ncx != null) {
            this.ncx.reset();
        }
        this.ncx = new org.java_websocket.b.a();
        this.ncz = null;
    }

    private String dFB() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String Rl(String str) {
        try {
            return org.java_websocket.e.a.encodeBytes(MessageDigest.getInstance("SHA1").digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    private byte[] F(long j, int i) {
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

    private Framedata.Opcode p(byte b) throws InvalidFrameException {
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
        Framedata.Opcode dFM = framedata.dFM();
        if (dFM == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.o(i, str, true);
            } else if (dFv() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.n(i, str, true);
            } else {
                cVar.p(i, str, false);
            }
        } else if (dFM == Framedata.Opcode.PING) {
            cVar.dFu().onWebsocketPing(cVar, framedata);
        } else if (dFM == Framedata.Opcode.PONG) {
            cVar.dFt();
            cVar.dFu().onWebsocketPong(cVar, framedata);
        } else if (!framedata.JC() || dFM == Framedata.Opcode.CONTINUOUS) {
            if (dFM != Framedata.Opcode.CONTINUOUS) {
                if (this.ncB != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.ncB = framedata;
                this.ncC.add(framedata.dFI());
            } else if (framedata.JC()) {
                if (this.ncB == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.ncC.add(framedata.dFI());
                if (this.ncB.dFM() == Framedata.Opcode.TEXT) {
                    ((f) this.ncB).u(dFC());
                    ((f) this.ncB).dFG();
                    try {
                        cVar.dFu().onWebsocketMessage(cVar, org.java_websocket.e.c.v(this.ncB.dFI()));
                    } catch (RuntimeException e) {
                        cVar.dFu().onWebsocketError(cVar, e);
                    }
                } else if (this.ncB.dFM() == Framedata.Opcode.BINARY) {
                    ((f) this.ncB).u(dFC());
                    ((f) this.ncB).dFG();
                    try {
                        cVar.dFu().onWebsocketMessage(cVar, this.ncB.dFI());
                    } catch (RuntimeException e2) {
                        cVar.dFu().onWebsocketError(cVar, e2);
                    }
                }
                this.ncB = null;
                this.ncC.clear();
            } else if (this.ncB == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (dFM == Framedata.Opcode.TEXT && !org.java_websocket.e.c.w(framedata.dFI())) {
                throw new InvalidDataException(1007);
            }
            if (dFM == Framedata.Opcode.CONTINUOUS && this.ncB != null) {
                this.ncC.add(framedata.dFI());
            }
        } else if (this.ncB != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (dFM == Framedata.Opcode.TEXT) {
                try {
                    cVar.dFu().onWebsocketMessage(cVar, org.java_websocket.e.c.v(framedata.dFI()));
                } catch (RuntimeException e3) {
                    cVar.dFu().onWebsocketError(cVar, e3);
                }
            } else if (dFM == Framedata.Opcode.BINARY) {
                try {
                    cVar.dFu().onWebsocketMessage(cVar, framedata.dFI());
                } catch (RuntimeException e4) {
                    cVar.dFu().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType dFv() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (dFx() != null) {
            draft = draft + " extension: " + dFx().toString();
        }
        if (dFz() != null) {
            return draft + " protocol: " + dFz().toString();
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
        if (this.ncx == null ? aVar.ncx != null : !this.ncx.equals(aVar.ncx)) {
            return false;
        }
        return this.ncz != null ? this.ncz.equals(aVar.ncz) : aVar.ncz == null;
    }

    public int hashCode() {
        return ((this.ncx != null ? this.ncx.hashCode() : 0) * 31) + (this.ncz != null ? this.ncz.hashCode() : 0);
    }

    private ByteBuffer dFC() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.ncC.iterator();
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
        for (ByteBuffer byteBuffer : this.ncC) {
            allocate.put(byteBuffer);
        }
        allocate.flip();
        return allocate;
    }

    private static void bP(Object obj) {
        if (org.java_websocket.c.DEBUG) {
            System.out.println(obj);
        }
    }
}
