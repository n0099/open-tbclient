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
/* loaded from: classes17.dex */
public class a extends Draft {
    static final /* synthetic */ boolean $assertionsDisabled;
    private b oMC;
    private List<b> oMD;
    private org.java_websocket.d.a oME;
    private List<org.java_websocket.d.a> oMF;
    private Framedata oMG;
    private List<ByteBuffer> oMH;
    private ByteBuffer oMI;
    private final Random oMJ;

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
        this.oMC = new org.java_websocket.b.a();
        this.oMJ = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.oMD = new ArrayList(list.size());
        this.oMF = new ArrayList(list2.size());
        boolean z2 = false;
        this.oMH = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.oMD.addAll(list);
        if (!z) {
            this.oMD.add(this.oMD.size(), this.oMC);
        }
        this.oMF.addAll(list2);
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (c(aVar) != 13) {
            bT("acceptHandshakeAsServer - Wrong websocket version.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String Xa = aVar.Xa("Sec-WebSocket-Extensions");
        Iterator<b> it = this.oMD.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.WW(Xa)) {
                this.oMC = next;
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                bT("acceptHandshakeAsServer - Matching extension found: " + this.oMC.toString());
                handshakeState2 = handshakeState3;
                break;
            }
        }
        Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
        String Xa2 = aVar.Xa("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.oMF.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState4;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.Xc(Xa2)) {
                this.oME = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                bT("acceptHandshakeAsServer - Matching protocol found: " + this.oME.toString());
                break;
            }
        }
        if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
            return Draft.HandshakeState.MATCHED;
        }
        bT("acceptHandshakeAsServer - No matching extension or protocol found.");
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar, h hVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (!b(hVar)) {
            bT("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return Draft.HandshakeState.NOT_MATCHED;
        } else if (!aVar.Xb("Sec-WebSocket-Key") || !hVar.Xb("Sec-WebSocket-Accept")) {
            bT("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return Draft.HandshakeState.NOT_MATCHED;
        } else {
            if (!WV(aVar.Xa("Sec-WebSocket-Key")).equals(hVar.Xa("Sec-WebSocket-Accept"))) {
                bT("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String Xa = hVar.Xa("Sec-WebSocket-Extensions");
            Iterator<b> it = this.oMD.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.WX(Xa)) {
                    this.oMC = next;
                    Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                    bT("acceptHandshakeAsClient - Matching extension found: " + this.oMC.toString());
                    handshakeState2 = handshakeState3;
                    break;
                }
            }
            Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
            String Xa2 = hVar.Xa("Sec-WebSocket-Protocol");
            Iterator<org.java_websocket.d.a> it2 = this.oMF.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    handshakeState = handshakeState4;
                    break;
                }
                org.java_websocket.d.a next2 = it2.next();
                if (next2.Xc(Xa2)) {
                    this.oME = next2;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    bT("acceptHandshakeAsClient - Matching protocol found: " + this.oME.toString());
                    break;
                }
            }
            if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
                return Draft.HandshakeState.MATCHED;
            }
            bT("acceptHandshakeAsClient - No matching extension or protocol found.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
    }

    public b enm() {
        return this.oMC;
    }

    public List<b> enn() {
        return this.oMD;
    }

    public org.java_websocket.d.a eno() {
        return this.oME;
    }

    public List<org.java_websocket.d.a> enp() {
        return this.oMF;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.oMJ.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.oMD) {
            if (bVar2.ens() != null && bVar2.ens().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.ens());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.oMF) {
            if (aVar.enE().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.enE());
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
        iVar.put(HTTP.CONN_DIRECTIVE, aVar.Xa(HTTP.CONN_DIRECTIVE));
        String Xa = aVar.Xa("Sec-WebSocket-Key");
        if (Xa == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", WV(Xa));
        if (enm().ent().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", enm().ent());
        }
        if (eno() != null && eno().enE().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", eno().enE());
        }
        iVar.WZ("Web Socket Protocol Handshake");
        iVar.put("Server", "TooTallNate Java-WebSocket");
        iVar.put("Date", enq());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft enl() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : enn()) {
            arrayList.add(bVar.enu());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : enp()) {
            arrayList2.add(aVar.enF());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        enm().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.enx().remaining() + "): {" + (framedata.enx().remaining() > 1000 ? "too big to display" : new String(framedata.enx().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer enx = framedata.enx();
        boolean z = this.oMn == WebSocket.Role.CLIENT;
        if (enx.remaining() <= 125) {
            i = 1;
        } else {
            i = enx.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + enx.remaining());
        allocate.put((byte) (((byte) (framedata.afm() ? -128 : 0)) | a(framedata.enB())));
        byte[] G = G(enx.remaining(), i);
        if ($assertionsDisabled || G.length == i) {
            if (i == 1) {
                allocate.put((byte) (G[0] | (z ? Byte.MIN_VALUE : (byte) 0)));
            } else if (i == 2) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | 126));
                allocate.put(G);
            } else if (i == 8) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | Byte.MAX_VALUE));
                allocate.put(G);
            } else {
                throw new RuntimeException("Size representation not supported/specified");
            }
            if (z) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.putInt(this.oMJ.nextInt());
                allocate.put(allocate2.array());
                while (enx.hasRemaining()) {
                    allocate.put((byte) (enx.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(enx);
                enx.flip();
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
        Framedata.Opcode i2 = i((byte) (b2 & 15));
        if (b4 >= 0 && b4 <= 125) {
            i = 2;
            b = b4;
        } else if (i2 == Framedata.Opcode.PING || i2 == Framedata.Opcode.PONG || i2 == Framedata.Opcode.CLOSING) {
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
                for (int i3 = 0; i3 < 8; i3++) {
                    bArr[i3] = byteBuffer.get();
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
        int i4 = (z5 ? 4 : 0) + i + b;
        if (remaining < i4) {
            throw new IncompleteException(i4);
        }
        ByteBuffer allocate = ByteBuffer.allocate(OU(b));
        if (z5) {
            byte[] bArr2 = new byte[4];
            byteBuffer.get(bArr2);
            for (int i5 = 0; i5 < b; i5++) {
                allocate.put((byte) (byteBuffer.get() ^ bArr2[i5 % 4]));
            }
        } else {
            allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
            byteBuffer.position(byteBuffer.position() + allocate.limit());
        }
        f b5 = f.b(i2);
        b5.dJ(z3);
        b5.zj(z);
        b5.zk(z2);
        b5.zl(z4);
        allocate.flip();
        b5.A(allocate);
        enm().e(b5);
        enm().c(b5);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b5.enx().remaining() + "): {" + (b5.enx().remaining() > 1000 ? "too big to display" : new String(b5.enx().array())) + '}');
        }
        b5.env();
        return b5;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> x(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.oMI == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.oMI.remaining();
                if (remaining2 > remaining) {
                    this.oMI.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.oMI.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(z((ByteBuffer) this.oMI.duplicate().position(0)));
                this.oMI = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(OU(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.oMI.limit()) {
                    throw new AssertionError();
                }
                this.oMI.rewind();
                allocate.put(this.oMI);
                this.oMI = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(z(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.oMI = ByteBuffer.allocate(OU(e2.getPreferredSize()));
                this.oMI.put(byteBuffer);
            }
        }
        return linkedList;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> b(ByteBuffer byteBuffer, boolean z) {
        org.java_websocket.framing.a aVar = new org.java_websocket.framing.a();
        aVar.A(byteBuffer);
        aVar.zm(z);
        try {
            aVar.env();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> bh(String str, boolean z) {
        org.java_websocket.framing.i iVar = new org.java_websocket.framing.i();
        iVar.A(ByteBuffer.wrap(org.java_websocket.e.c.Xd(str)));
        iVar.zm(z);
        try {
            iVar.env();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.oMI = null;
        if (this.oMC != null) {
            this.oMC.reset();
        }
        this.oMC = new org.java_websocket.b.a();
        this.oME = null;
    }

    private String enq() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String WV(String str) {
        try {
            return org.java_websocket.e.a.encodeBytes(MessageDigest.getInstance("SHA1").digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    private byte[] G(long j, int i) {
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

    private Framedata.Opcode i(byte b) throws InvalidFrameException {
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
        Framedata.Opcode enB = framedata.enB();
        if (enB == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.o(i, str, true);
            } else if (enk() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.n(i, str, true);
            } else {
                cVar.p(i, str, false);
            }
        } else if (enB == Framedata.Opcode.PING) {
            cVar.enj().onWebsocketPing(cVar, framedata);
        } else if (enB == Framedata.Opcode.PONG) {
            cVar.eni();
            cVar.enj().onWebsocketPong(cVar, framedata);
        } else if (!framedata.afm() || enB == Framedata.Opcode.CONTINUOUS) {
            if (enB != Framedata.Opcode.CONTINUOUS) {
                if (this.oMG != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.oMG = framedata;
                this.oMH.add(framedata.enx());
            } else if (framedata.afm()) {
                if (this.oMG == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.oMH.add(framedata.enx());
                if (this.oMG.enB() == Framedata.Opcode.TEXT) {
                    ((f) this.oMG).A(enr());
                    ((f) this.oMG).env();
                    try {
                        cVar.enj().onWebsocketMessage(cVar, org.java_websocket.e.c.B(this.oMG.enx()));
                    } catch (RuntimeException e) {
                        cVar.enj().onWebsocketError(cVar, e);
                    }
                } else if (this.oMG.enB() == Framedata.Opcode.BINARY) {
                    ((f) this.oMG).A(enr());
                    ((f) this.oMG).env();
                    try {
                        cVar.enj().onWebsocketMessage(cVar, this.oMG.enx());
                    } catch (RuntimeException e2) {
                        cVar.enj().onWebsocketError(cVar, e2);
                    }
                }
                this.oMG = null;
                this.oMH.clear();
            } else if (this.oMG == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (enB == Framedata.Opcode.TEXT && !org.java_websocket.e.c.C(framedata.enx())) {
                throw new InvalidDataException(1007);
            }
            if (enB == Framedata.Opcode.CONTINUOUS && this.oMG != null) {
                this.oMH.add(framedata.enx());
            }
        } else if (this.oMG != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (enB == Framedata.Opcode.TEXT) {
                try {
                    cVar.enj().onWebsocketMessage(cVar, org.java_websocket.e.c.B(framedata.enx()));
                } catch (RuntimeException e3) {
                    cVar.enj().onWebsocketError(cVar, e3);
                }
            } else if (enB == Framedata.Opcode.BINARY) {
                try {
                    cVar.enj().onWebsocketMessage(cVar, framedata.enx());
                } catch (RuntimeException e4) {
                    cVar.enj().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType enk() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (enm() != null) {
            draft = draft + " extension: " + enm().toString();
        }
        if (eno() != null) {
            return draft + " protocol: " + eno().toString();
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
        if (this.oMC == null ? aVar.oMC != null : !this.oMC.equals(aVar.oMC)) {
            return false;
        }
        return this.oME != null ? this.oME.equals(aVar.oME) : aVar.oME == null;
    }

    public int hashCode() {
        return ((this.oMC != null ? this.oMC.hashCode() : 0) * 31) + (this.oME != null ? this.oME.hashCode() : 0);
    }

    private ByteBuffer enr() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.oMH.iterator();
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
        for (ByteBuffer byteBuffer : this.oMH) {
            allocate.put(byteBuffer);
        }
        allocate.flip();
        return allocate;
    }

    private static void bT(Object obj) {
        if (org.java_websocket.c.DEBUG) {
            System.out.println(obj);
        }
    }
}
