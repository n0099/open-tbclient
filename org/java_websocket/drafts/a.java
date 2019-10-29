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
    private b kxM;
    private List<b> kxN;
    private org.java_websocket.d.a kxO;
    private List<org.java_websocket.d.a> kxP;
    private Framedata kxQ;
    private List<ByteBuffer> kxR;
    private ByteBuffer kxS;
    private final Random kxT;

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
        this.kxM = new org.java_websocket.b.a();
        this.kxT = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.kxN = new ArrayList(list.size());
        this.kxP = new ArrayList(list2.size());
        boolean z2 = false;
        this.kxR = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.kxN.addAll(list);
        if (!z) {
            this.kxN.add(this.kxN.size(), this.kxM);
        }
        this.kxP.addAll(list2);
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (c(aVar) != 13) {
            be("acceptHandshakeAsServer - Wrong websocket version.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String Hk = aVar.Hk("Sec-WebSocket-Extensions");
        Iterator<b> it = this.kxN.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.Hg(Hk)) {
                this.kxM = next;
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                be("acceptHandshakeAsServer - Matching extension found: " + this.kxM.toString());
                handshakeState2 = handshakeState3;
                break;
            }
        }
        Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
        String Hk2 = aVar.Hk("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.kxP.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState4;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.Hm(Hk2)) {
                this.kxO = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                be("acceptHandshakeAsServer - Matching protocol found: " + this.kxO.toString());
                break;
            }
        }
        if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
            return Draft.HandshakeState.MATCHED;
        }
        be("acceptHandshakeAsServer - No matching extension or protocol found.");
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar, h hVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (!b(hVar)) {
            be("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return Draft.HandshakeState.NOT_MATCHED;
        } else if (!aVar.Hl("Sec-WebSocket-Key") || !hVar.Hl("Sec-WebSocket-Accept")) {
            be("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return Draft.HandshakeState.NOT_MATCHED;
        } else {
            if (!Hf(aVar.Hk("Sec-WebSocket-Key")).equals(hVar.Hk("Sec-WebSocket-Accept"))) {
                be("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String Hk = hVar.Hk("Sec-WebSocket-Extensions");
            Iterator<b> it = this.kxN.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.Hh(Hk)) {
                    this.kxM = next;
                    Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                    be("acceptHandshakeAsClient - Matching extension found: " + this.kxM.toString());
                    handshakeState2 = handshakeState3;
                    break;
                }
            }
            Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
            String Hk2 = hVar.Hk("Sec-WebSocket-Protocol");
            Iterator<org.java_websocket.d.a> it2 = this.kxP.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    handshakeState = handshakeState4;
                    break;
                }
                org.java_websocket.d.a next2 = it2.next();
                if (next2.Hm(Hk2)) {
                    this.kxO = next2;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    be("acceptHandshakeAsClient - Matching protocol found: " + this.kxO.toString());
                    break;
                }
            }
            if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
                return Draft.HandshakeState.MATCHED;
            }
            be("acceptHandshakeAsClient - No matching extension or protocol found.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
    }

    public b cND() {
        return this.kxM;
    }

    public List<b> cNE() {
        return this.kxN;
    }

    public org.java_websocket.d.a cNF() {
        return this.kxO;
    }

    public List<org.java_websocket.d.a> cNG() {
        return this.kxP;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.kxT.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.kxN) {
            if (bVar2.cNJ() != null && bVar2.cNJ().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.cNJ());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.kxP) {
            if (aVar.cNW().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.cNW());
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
        iVar.put(HTTP.CONN_DIRECTIVE, aVar.Hk(HTTP.CONN_DIRECTIVE));
        String Hk = aVar.Hk("Sec-WebSocket-Key");
        if (Hk == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", Hf(Hk));
        if (cND().cNK().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", cND().cNK());
        }
        if (cNF() != null && cNF().cNW().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", cNF().cNW());
        }
        iVar.Hj("Web Socket Protocol Handshake");
        iVar.put(HTTP.SERVER_HEADER, "TooTallNate Java-WebSocket");
        iVar.put(HTTP.DATE_HEADER, cNH());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft cNC() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : cNE()) {
            arrayList.add(bVar.cNL());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : cNG()) {
            arrayList2.add(aVar.cNX());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        cND().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.cNO().remaining() + "): {" + (framedata.cNO().remaining() > 1000 ? "too big to display" : new String(framedata.cNO().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer cNO = framedata.cNO();
        boolean z = this.kxx == WebSocket.Role.CLIENT;
        if (cNO.remaining() <= 125) {
            i = 1;
        } else {
            i = cNO.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + cNO.remaining());
        allocate.put((byte) (((byte) (framedata.cNP() ? -128 : 0)) | a(framedata.cNT())));
        byte[] w = w(cNO.remaining(), i);
        if ($assertionsDisabled || w.length == i) {
            if (i == 1) {
                allocate.put((byte) (w[0] | (z ? Byte.MIN_VALUE : (byte) 0)));
            } else if (i == 2) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | 126));
                allocate.put(w);
            } else if (i == 8) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | Byte.MAX_VALUE));
                allocate.put(w);
            } else {
                throw new RuntimeException("Size representation not supported/specified");
            }
            if (z) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.putInt(this.kxT.nextInt());
                allocate.put(allocate2.array());
                while (cNO.hasRemaining()) {
                    allocate.put((byte) (cNO.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(cNO);
                cNO.flip();
            }
            if ($assertionsDisabled || allocate.remaining() == 0) {
                allocate.flip();
                return allocate;
            }
            throw new AssertionError(allocate.remaining());
        }
        throw new AssertionError();
    }

    public Framedata p(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
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
        ByteBuffer allocate = ByteBuffer.allocate(Ds(b));
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
        b5.sB(z3);
        b5.sC(z);
        b5.sD(z2);
        b5.sE(z4);
        allocate.flip();
        b5.q(allocate);
        cND().e(b5);
        cND().c(b5);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b5.cNO().remaining() + "): {" + (b5.cNO().remaining() > 1000 ? "too big to display" : new String(b5.cNO().array())) + '}');
        }
        b5.cNM();
        return b5;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> n(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.kxS == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.kxS.remaining();
                if (remaining2 > remaining) {
                    this.kxS.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.kxS.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(p((ByteBuffer) this.kxS.duplicate().position(0)));
                this.kxS = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(Ds(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.kxS.limit()) {
                    throw new AssertionError();
                }
                this.kxS.rewind();
                allocate.put(this.kxS);
                this.kxS = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(p(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.kxS = ByteBuffer.allocate(Ds(e2.getPreferredSize()));
                this.kxS.put(byteBuffer);
            }
        }
        return linkedList;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> b(ByteBuffer byteBuffer, boolean z) {
        org.java_websocket.framing.a aVar = new org.java_websocket.framing.a();
        aVar.q(byteBuffer);
        aVar.sF(z);
        try {
            aVar.cNM();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> aA(String str, boolean z) {
        org.java_websocket.framing.i iVar = new org.java_websocket.framing.i();
        iVar.q(ByteBuffer.wrap(org.java_websocket.e.c.Hn(str)));
        iVar.sF(z);
        try {
            iVar.cNM();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.kxS = null;
        if (this.kxM != null) {
            this.kxM.reset();
        }
        this.kxM = new org.java_websocket.b.a();
        this.kxO = null;
    }

    private String cNH() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String Hf(String str) {
        try {
            return org.java_websocket.e.a.encodeBytes(MessageDigest.getInstance("SHA1").digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    private byte[] w(long j, int i) {
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
        Framedata.Opcode cNT = framedata.cNT();
        if (cNT == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.l(i, str, true);
            } else if (cNB() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.k(i, str, true);
            } else {
                cVar.m(i, str, false);
            }
        } else if (cNT == Framedata.Opcode.PING) {
            cVar.cNA().onWebsocketPing(cVar, framedata);
        } else if (cNT == Framedata.Opcode.PONG) {
            cVar.cNz();
            cVar.cNA().onWebsocketPong(cVar, framedata);
        } else if (!framedata.cNP() || cNT == Framedata.Opcode.CONTINUOUS) {
            if (cNT != Framedata.Opcode.CONTINUOUS) {
                if (this.kxQ != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.kxQ = framedata;
                this.kxR.add(framedata.cNO());
            } else if (framedata.cNP()) {
                if (this.kxQ == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.kxR.add(framedata.cNO());
                if (this.kxQ.cNT() == Framedata.Opcode.TEXT) {
                    ((f) this.kxQ).q(cNI());
                    ((f) this.kxQ).cNM();
                    try {
                        cVar.cNA().onWebsocketMessage(cVar, org.java_websocket.e.c.r(this.kxQ.cNO()));
                    } catch (RuntimeException e) {
                        cVar.cNA().onWebsocketError(cVar, e);
                    }
                } else if (this.kxQ.cNT() == Framedata.Opcode.BINARY) {
                    ((f) this.kxQ).q(cNI());
                    ((f) this.kxQ).cNM();
                    try {
                        cVar.cNA().onWebsocketMessage(cVar, this.kxQ.cNO());
                    } catch (RuntimeException e2) {
                        cVar.cNA().onWebsocketError(cVar, e2);
                    }
                }
                this.kxQ = null;
                this.kxR.clear();
            } else if (this.kxQ == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (cNT == Framedata.Opcode.TEXT && !org.java_websocket.e.c.s(framedata.cNO())) {
                throw new InvalidDataException(1007);
            }
            if (cNT == Framedata.Opcode.CONTINUOUS && this.kxQ != null) {
                this.kxR.add(framedata.cNO());
            }
        } else if (this.kxQ != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (cNT == Framedata.Opcode.TEXT) {
                try {
                    cVar.cNA().onWebsocketMessage(cVar, org.java_websocket.e.c.r(framedata.cNO()));
                } catch (RuntimeException e3) {
                    cVar.cNA().onWebsocketError(cVar, e3);
                }
            } else if (cNT == Framedata.Opcode.BINARY) {
                try {
                    cVar.cNA().onWebsocketMessage(cVar, framedata.cNO());
                } catch (RuntimeException e4) {
                    cVar.cNA().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType cNB() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (cND() != null) {
            draft = draft + " extension: " + cND().toString();
        }
        if (cNF() != null) {
            return draft + " protocol: " + cNF().toString();
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
        if (this.kxM == null ? aVar.kxM != null : !this.kxM.equals(aVar.kxM)) {
            return false;
        }
        return this.kxO != null ? this.kxO.equals(aVar.kxO) : aVar.kxO == null;
    }

    public int hashCode() {
        return ((this.kxM != null ? this.kxM.hashCode() : 0) * 31) + (this.kxO != null ? this.kxO.hashCode() : 0);
    }

    private ByteBuffer cNI() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.kxR.iterator();
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
        for (ByteBuffer byteBuffer : this.kxR) {
            allocate.put(byteBuffer);
        }
        allocate.flip();
        return allocate;
    }

    private static void be(Object obj) {
        if (org.java_websocket.c.DEBUG) {
            System.out.println(obj);
        }
    }
}
