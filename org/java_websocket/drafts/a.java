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
    private b nhY;
    private List<b> nhZ;
    private org.java_websocket.d.a nia;
    private List<org.java_websocket.d.a> nib;
    private Framedata nic;
    private List<ByteBuffer> nie;
    private ByteBuffer nif;
    private final Random nig;

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
        this.nhY = new org.java_websocket.b.a();
        this.nig = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.nhZ = new ArrayList(list.size());
        this.nib = new ArrayList(list2.size());
        boolean z2 = false;
        this.nie = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.nhZ.addAll(list);
        if (!z) {
            this.nhZ.add(this.nhZ.size(), this.nhY);
        }
        this.nib.addAll(list2);
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (c(aVar) != 13) {
            bI("acceptHandshakeAsServer - Wrong websocket version.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String PP = aVar.PP("Sec-WebSocket-Extensions");
        Iterator<b> it = this.nhZ.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.PL(PP)) {
                this.nhY = next;
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                bI("acceptHandshakeAsServer - Matching extension found: " + this.nhY.toString());
                handshakeState2 = handshakeState3;
                break;
            }
        }
        Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
        String PP2 = aVar.PP("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.nib.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState4;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.PR(PP2)) {
                this.nia = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                bI("acceptHandshakeAsServer - Matching protocol found: " + this.nia.toString());
                break;
            }
        }
        if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
            return Draft.HandshakeState.MATCHED;
        }
        bI("acceptHandshakeAsServer - No matching extension or protocol found.");
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar, h hVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (!b(hVar)) {
            bI("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return Draft.HandshakeState.NOT_MATCHED;
        } else if (!aVar.PQ("Sec-WebSocket-Key") || !hVar.PQ("Sec-WebSocket-Accept")) {
            bI("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return Draft.HandshakeState.NOT_MATCHED;
        } else {
            if (!PK(aVar.PP("Sec-WebSocket-Key")).equals(hVar.PP("Sec-WebSocket-Accept"))) {
                bI("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String PP = hVar.PP("Sec-WebSocket-Extensions");
            Iterator<b> it = this.nhZ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.PM(PP)) {
                    this.nhY = next;
                    Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                    bI("acceptHandshakeAsClient - Matching extension found: " + this.nhY.toString());
                    handshakeState2 = handshakeState3;
                    break;
                }
            }
            Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
            String PP2 = hVar.PP("Sec-WebSocket-Protocol");
            Iterator<org.java_websocket.d.a> it2 = this.nib.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    handshakeState = handshakeState4;
                    break;
                }
                org.java_websocket.d.a next2 = it2.next();
                if (next2.PR(PP2)) {
                    this.nia = next2;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    bI("acceptHandshakeAsClient - Matching protocol found: " + this.nia.toString());
                    break;
                }
            }
            if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
                return Draft.HandshakeState.MATCHED;
            }
            bI("acceptHandshakeAsClient - No matching extension or protocol found.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
    }

    public b dGM() {
        return this.nhY;
    }

    public List<b> dGN() {
        return this.nhZ;
    }

    public org.java_websocket.d.a dGO() {
        return this.nia;
    }

    public List<org.java_websocket.d.a> dGP() {
        return this.nib;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.nig.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.nhZ) {
            if (bVar2.dGS() != null && bVar2.dGS().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.dGS());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.nib) {
            if (aVar.dHe().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.dHe());
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
        iVar.put(HTTP.CONN_DIRECTIVE, aVar.PP(HTTP.CONN_DIRECTIVE));
        String PP = aVar.PP("Sec-WebSocket-Key");
        if (PP == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", PK(PP));
        if (dGM().dGT().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", dGM().dGT());
        }
        if (dGO() != null && dGO().dHe().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", dGO().dHe());
        }
        iVar.PO("Web Socket Protocol Handshake");
        iVar.put("Server", "TooTallNate Java-WebSocket");
        iVar.put("Date", dGQ());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft dGL() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : dGN()) {
            arrayList.add(bVar.dGU());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : dGP()) {
            arrayList2.add(aVar.dHf());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        dGM().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.dGX().remaining() + "): {" + (framedata.dGX().remaining() > 1000 ? "too big to display" : new String(framedata.dGX().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer dGX = framedata.dGX();
        boolean z = this.nhJ == WebSocket.Role.CLIENT;
        if (dGX.remaining() <= 125) {
            i = 1;
        } else {
            i = dGX.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + dGX.remaining());
        allocate.put((byte) (((byte) (framedata.Ue() ? -128 : 0)) | a(framedata.dHb())));
        byte[] C = C(dGX.remaining(), i);
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
                allocate2.putInt(this.nig.nextInt());
                allocate.put(allocate2.array());
                while (dGX.hasRemaining()) {
                    allocate.put((byte) (dGX.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(dGX);
                dGX.flip();
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
        dGM().e(b5);
        dGM().c(b5);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b5.dGX().remaining() + "): {" + (b5.dGX().remaining() > 1000 ? "too big to display" : new String(b5.dGX().array())) + '}');
        }
        b5.dGV();
        return b5;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> r(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.nif == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.nif.remaining();
                if (remaining2 > remaining) {
                    this.nif.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.nif.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(t((ByteBuffer) this.nif.duplicate().position(0)));
                this.nif = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(Jy(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.nif.limit()) {
                    throw new AssertionError();
                }
                this.nif.rewind();
                allocate.put(this.nif);
                this.nif = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(t(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.nif = ByteBuffer.allocate(Jy(e2.getPreferredSize()));
                this.nif.put(byteBuffer);
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
            aVar.dGV();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> aQ(String str, boolean z) {
        org.java_websocket.framing.i iVar = new org.java_websocket.framing.i();
        iVar.u(ByteBuffer.wrap(org.java_websocket.e.c.PS(str)));
        iVar.wK(z);
        try {
            iVar.dGV();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.nif = null;
        if (this.nhY != null) {
            this.nhY.reset();
        }
        this.nhY = new org.java_websocket.b.a();
        this.nia = null;
    }

    private String dGQ() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String PK(String str) {
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
        Framedata.Opcode dHb = framedata.dHb();
        if (dHb == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.p(i, str, true);
            } else if (dGK() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.o(i, str, true);
            } else {
                cVar.q(i, str, false);
            }
        } else if (dHb == Framedata.Opcode.PING) {
            cVar.dGJ().onWebsocketPing(cVar, framedata);
        } else if (dHb == Framedata.Opcode.PONG) {
            cVar.dGI();
            cVar.dGJ().onWebsocketPong(cVar, framedata);
        } else if (!framedata.Ue() || dHb == Framedata.Opcode.CONTINUOUS) {
            if (dHb != Framedata.Opcode.CONTINUOUS) {
                if (this.nic != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.nic = framedata;
                this.nie.add(framedata.dGX());
            } else if (framedata.Ue()) {
                if (this.nic == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.nie.add(framedata.dGX());
                if (this.nic.dHb() == Framedata.Opcode.TEXT) {
                    ((f) this.nic).u(dGR());
                    ((f) this.nic).dGV();
                    try {
                        cVar.dGJ().onWebsocketMessage(cVar, org.java_websocket.e.c.v(this.nic.dGX()));
                    } catch (RuntimeException e) {
                        cVar.dGJ().onWebsocketError(cVar, e);
                    }
                } else if (this.nic.dHb() == Framedata.Opcode.BINARY) {
                    ((f) this.nic).u(dGR());
                    ((f) this.nic).dGV();
                    try {
                        cVar.dGJ().onWebsocketMessage(cVar, this.nic.dGX());
                    } catch (RuntimeException e2) {
                        cVar.dGJ().onWebsocketError(cVar, e2);
                    }
                }
                this.nic = null;
                this.nie.clear();
            } else if (this.nic == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (dHb == Framedata.Opcode.TEXT && !org.java_websocket.e.c.w(framedata.dGX())) {
                throw new InvalidDataException(1007);
            }
            if (dHb == Framedata.Opcode.CONTINUOUS && this.nic != null) {
                this.nie.add(framedata.dGX());
            }
        } else if (this.nic != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (dHb == Framedata.Opcode.TEXT) {
                try {
                    cVar.dGJ().onWebsocketMessage(cVar, org.java_websocket.e.c.v(framedata.dGX()));
                } catch (RuntimeException e3) {
                    cVar.dGJ().onWebsocketError(cVar, e3);
                }
            } else if (dHb == Framedata.Opcode.BINARY) {
                try {
                    cVar.dGJ().onWebsocketMessage(cVar, framedata.dGX());
                } catch (RuntimeException e4) {
                    cVar.dGJ().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType dGK() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (dGM() != null) {
            draft = draft + " extension: " + dGM().toString();
        }
        if (dGO() != null) {
            return draft + " protocol: " + dGO().toString();
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
        if (this.nhY == null ? aVar.nhY != null : !this.nhY.equals(aVar.nhY)) {
            return false;
        }
        return this.nia != null ? this.nia.equals(aVar.nia) : aVar.nia == null;
    }

    public int hashCode() {
        return ((this.nhY != null ? this.nhY.hashCode() : 0) * 31) + (this.nia != null ? this.nia.hashCode() : 0);
    }

    private ByteBuffer dGR() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.nie.iterator();
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
        for (ByteBuffer byteBuffer : this.nie) {
            allocate.put(byteBuffer);
        }
        allocate.flip();
        return allocate;
    }

    private static void bI(Object obj) {
        if (org.java_websocket.c.DEBUG) {
            System.out.println(obj);
        }
    }
}
