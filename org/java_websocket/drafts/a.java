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
/* loaded from: classes7.dex */
public class a extends Draft {
    static final /* synthetic */ boolean $assertionsDisabled;
    private b nhV;
    private List<b> nhW;
    private org.java_websocket.d.a nhX;
    private List<org.java_websocket.d.a> nhY;
    private Framedata nhZ;
    private List<ByteBuffer> nia;
    private ByteBuffer nib;
    private final Random nic;

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
        this.nhV = new org.java_websocket.b.a();
        this.nic = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.nhW = new ArrayList(list.size());
        this.nhY = new ArrayList(list2.size());
        boolean z2 = false;
        this.nia = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.nhW.addAll(list);
        if (!z) {
            this.nhW.add(this.nhW.size(), this.nhV);
        }
        this.nhY.addAll(list2);
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (c(aVar) != 13) {
            bH("acceptHandshakeAsServer - Wrong websocket version.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String PM = aVar.PM("Sec-WebSocket-Extensions");
        Iterator<b> it = this.nhW.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.PI(PM)) {
                this.nhV = next;
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                bH("acceptHandshakeAsServer - Matching extension found: " + this.nhV.toString());
                handshakeState2 = handshakeState3;
                break;
            }
        }
        Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
        String PM2 = aVar.PM("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.nhY.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState4;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.PO(PM2)) {
                this.nhX = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                bH("acceptHandshakeAsServer - Matching protocol found: " + this.nhX.toString());
                break;
            }
        }
        if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
            return Draft.HandshakeState.MATCHED;
        }
        bH("acceptHandshakeAsServer - No matching extension or protocol found.");
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar, h hVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (!b(hVar)) {
            bH("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return Draft.HandshakeState.NOT_MATCHED;
        } else if (!aVar.PN("Sec-WebSocket-Key") || !hVar.PN("Sec-WebSocket-Accept")) {
            bH("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return Draft.HandshakeState.NOT_MATCHED;
        } else {
            if (!PH(aVar.PM("Sec-WebSocket-Key")).equals(hVar.PM("Sec-WebSocket-Accept"))) {
                bH("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String PM = hVar.PM("Sec-WebSocket-Extensions");
            Iterator<b> it = this.nhW.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.PJ(PM)) {
                    this.nhV = next;
                    Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                    bH("acceptHandshakeAsClient - Matching extension found: " + this.nhV.toString());
                    handshakeState2 = handshakeState3;
                    break;
                }
            }
            Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
            String PM2 = hVar.PM("Sec-WebSocket-Protocol");
            Iterator<org.java_websocket.d.a> it2 = this.nhY.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    handshakeState = handshakeState4;
                    break;
                }
                org.java_websocket.d.a next2 = it2.next();
                if (next2.PO(PM2)) {
                    this.nhX = next2;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    bH("acceptHandshakeAsClient - Matching protocol found: " + this.nhX.toString());
                    break;
                }
            }
            if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
                return Draft.HandshakeState.MATCHED;
            }
            bH("acceptHandshakeAsClient - No matching extension or protocol found.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
    }

    public b dGQ() {
        return this.nhV;
    }

    public List<b> dGR() {
        return this.nhW;
    }

    public org.java_websocket.d.a dGS() {
        return this.nhX;
    }

    public List<org.java_websocket.d.a> dGT() {
        return this.nhY;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.nic.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.nhW) {
            if (bVar2.dGW() != null && bVar2.dGW().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.dGW());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.nhY) {
            if (aVar.dHi().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.dHi());
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
        iVar.put(HTTP.CONN_DIRECTIVE, aVar.PM(HTTP.CONN_DIRECTIVE));
        String PM = aVar.PM("Sec-WebSocket-Key");
        if (PM == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", PH(PM));
        if (dGQ().dGX().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", dGQ().dGX());
        }
        if (dGS() != null && dGS().dHi().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", dGS().dHi());
        }
        iVar.PL("Web Socket Protocol Handshake");
        iVar.put("Server", "TooTallNate Java-WebSocket");
        iVar.put("Date", dGU());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft dGP() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : dGR()) {
            arrayList.add(bVar.dGY());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : dGT()) {
            arrayList2.add(aVar.dHj());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        dGQ().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.dHb().remaining() + "): {" + (framedata.dHb().remaining() > 1000 ? "too big to display" : new String(framedata.dHb().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer dHb = framedata.dHb();
        boolean z = this.nhG == WebSocket.Role.CLIENT;
        if (dHb.remaining() <= 125) {
            i = 1;
        } else {
            i = dHb.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + dHb.remaining());
        allocate.put((byte) (((byte) (framedata.Uf() ? -128 : 0)) | a(framedata.dHf())));
        byte[] C = C(dHb.remaining(), i);
        if ($assertionsDisabled || C.length == i) {
            if (i == 1) {
                allocate.put((byte) (C[0] | (z ? Byte.MIN_VALUE : (byte) 0)));
            } else if (i == 2) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | 126));
                allocate.put(C);
            } else if (i == 8) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | Byte.MAX_VALUE));
                allocate.put(C);
            } else {
                throw new RuntimeException("Size representation not supported/specified");
            }
            if (z) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.putInt(this.nic.nextInt());
                allocate.put(allocate2.array());
                while (dHb.hasRemaining()) {
                    allocate.put((byte) (dHb.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(dHb);
                dHb.flip();
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
        Framedata.Opcode h = h((byte) (b2 & 15));
        if (b4 >= 0 && b4 <= 125) {
            i = 2;
            b = b4;
        } else if (h == Framedata.Opcode.PING || h == Framedata.Opcode.PONG || h == Framedata.Opcode.CLOSING) {
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
        ByteBuffer allocate = ByteBuffer.allocate(Jy(b));
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
        f b5 = f.b(h);
        b5.dg(z3);
        b5.wH(z);
        b5.wI(z2);
        b5.wJ(z4);
        allocate.flip();
        b5.u(allocate);
        dGQ().e(b5);
        dGQ().c(b5);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b5.dHb().remaining() + "): {" + (b5.dHb().remaining() > 1000 ? "too big to display" : new String(b5.dHb().array())) + '}');
        }
        b5.dGZ();
        return b5;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> r(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.nib == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.nib.remaining();
                if (remaining2 > remaining) {
                    this.nib.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.nib.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(t((ByteBuffer) this.nib.duplicate().position(0)));
                this.nib = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(Jy(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.nib.limit()) {
                    throw new AssertionError();
                }
                this.nib.rewind();
                allocate.put(this.nib);
                this.nib = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(t(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.nib = ByteBuffer.allocate(Jy(e2.getPreferredSize()));
                this.nib.put(byteBuffer);
            }
        }
        return linkedList;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> b(ByteBuffer byteBuffer, boolean z) {
        org.java_websocket.framing.a aVar = new org.java_websocket.framing.a();
        aVar.u(byteBuffer);
        aVar.wK(z);
        try {
            aVar.dGZ();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> aQ(String str, boolean z) {
        org.java_websocket.framing.i iVar = new org.java_websocket.framing.i();
        iVar.u(ByteBuffer.wrap(org.java_websocket.e.c.PP(str)));
        iVar.wK(z);
        try {
            iVar.dGZ();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.nib = null;
        if (this.nhV != null) {
            this.nhV.reset();
        }
        this.nhV = new org.java_websocket.b.a();
        this.nhX = null;
    }

    private String dGU() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String PH(String str) {
        try {
            return org.java_websocket.e.a.encodeBytes(MessageDigest.getInstance("SHA1").digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    private byte[] C(long j, int i) {
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

    private Framedata.Opcode h(byte b) throws InvalidFrameException {
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
        Framedata.Opcode dHf = framedata.dHf();
        if (dHf == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.p(i, str, true);
            } else if (dGO() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.o(i, str, true);
            } else {
                cVar.q(i, str, false);
            }
        } else if (dHf == Framedata.Opcode.PING) {
            cVar.dGN().onWebsocketPing(cVar, framedata);
        } else if (dHf == Framedata.Opcode.PONG) {
            cVar.dGM();
            cVar.dGN().onWebsocketPong(cVar, framedata);
        } else if (!framedata.Uf() || dHf == Framedata.Opcode.CONTINUOUS) {
            if (dHf != Framedata.Opcode.CONTINUOUS) {
                if (this.nhZ != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.nhZ = framedata;
                this.nia.add(framedata.dHb());
            } else if (framedata.Uf()) {
                if (this.nhZ == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.nia.add(framedata.dHb());
                if (this.nhZ.dHf() == Framedata.Opcode.TEXT) {
                    ((f) this.nhZ).u(dGV());
                    ((f) this.nhZ).dGZ();
                    try {
                        cVar.dGN().onWebsocketMessage(cVar, org.java_websocket.e.c.v(this.nhZ.dHb()));
                    } catch (RuntimeException e) {
                        cVar.dGN().onWebsocketError(cVar, e);
                    }
                } else if (this.nhZ.dHf() == Framedata.Opcode.BINARY) {
                    ((f) this.nhZ).u(dGV());
                    ((f) this.nhZ).dGZ();
                    try {
                        cVar.dGN().onWebsocketMessage(cVar, this.nhZ.dHb());
                    } catch (RuntimeException e2) {
                        cVar.dGN().onWebsocketError(cVar, e2);
                    }
                }
                this.nhZ = null;
                this.nia.clear();
            } else if (this.nhZ == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (dHf == Framedata.Opcode.TEXT && !org.java_websocket.e.c.w(framedata.dHb())) {
                throw new InvalidDataException(1007);
            }
            if (dHf == Framedata.Opcode.CONTINUOUS && this.nhZ != null) {
                this.nia.add(framedata.dHb());
            }
        } else if (this.nhZ != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (dHf == Framedata.Opcode.TEXT) {
                try {
                    cVar.dGN().onWebsocketMessage(cVar, org.java_websocket.e.c.v(framedata.dHb()));
                } catch (RuntimeException e3) {
                    cVar.dGN().onWebsocketError(cVar, e3);
                }
            } else if (dHf == Framedata.Opcode.BINARY) {
                try {
                    cVar.dGN().onWebsocketMessage(cVar, framedata.dHb());
                } catch (RuntimeException e4) {
                    cVar.dGN().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType dGO() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (dGQ() != null) {
            draft = draft + " extension: " + dGQ().toString();
        }
        if (dGS() != null) {
            return draft + " protocol: " + dGS().toString();
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
        if (this.nhV == null ? aVar.nhV != null : !this.nhV.equals(aVar.nhV)) {
            return false;
        }
        return this.nhX != null ? this.nhX.equals(aVar.nhX) : aVar.nhX == null;
    }

    public int hashCode() {
        return ((this.nhV != null ? this.nhV.hashCode() : 0) * 31) + (this.nhX != null ? this.nhX.hashCode() : 0);
    }

    private ByteBuffer dGV() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.nia.iterator();
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
        for (ByteBuffer byteBuffer : this.nia) {
            allocate.put(byteBuffer);
        }
        allocate.flip();
        return allocate;
    }

    private static void bH(Object obj) {
        if (org.java_websocket.c.DEBUG) {
            System.out.println(obj);
        }
    }
}
