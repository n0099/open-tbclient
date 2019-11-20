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
    private b kwV;
    private List<b> kwW;
    private org.java_websocket.d.a kwX;
    private List<org.java_websocket.d.a> kwY;
    private Framedata kwZ;
    private List<ByteBuffer> kxa;
    private ByteBuffer kxb;
    private final Random kxc;

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
        this.kwV = new org.java_websocket.b.a();
        this.kxc = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.kwW = new ArrayList(list.size());
        this.kwY = new ArrayList(list2.size());
        boolean z2 = false;
        this.kxa = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.kwW.addAll(list);
        if (!z) {
            this.kwW.add(this.kwW.size(), this.kwV);
        }
        this.kwY.addAll(list2);
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
        Iterator<b> it = this.kwW.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.Hg(Hk)) {
                this.kwV = next;
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                be("acceptHandshakeAsServer - Matching extension found: " + this.kwV.toString());
                handshakeState2 = handshakeState3;
                break;
            }
        }
        Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
        String Hk2 = aVar.Hk("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.kwY.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState4;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.Hm(Hk2)) {
                this.kwX = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                be("acceptHandshakeAsServer - Matching protocol found: " + this.kwX.toString());
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
            Iterator<b> it = this.kwW.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.Hh(Hk)) {
                    this.kwV = next;
                    Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                    be("acceptHandshakeAsClient - Matching extension found: " + this.kwV.toString());
                    handshakeState2 = handshakeState3;
                    break;
                }
            }
            Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
            String Hk2 = hVar.Hk("Sec-WebSocket-Protocol");
            Iterator<org.java_websocket.d.a> it2 = this.kwY.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    handshakeState = handshakeState4;
                    break;
                }
                org.java_websocket.d.a next2 = it2.next();
                if (next2.Hm(Hk2)) {
                    this.kwX = next2;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    be("acceptHandshakeAsClient - Matching protocol found: " + this.kwX.toString());
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

    public b cNB() {
        return this.kwV;
    }

    public List<b> cNC() {
        return this.kwW;
    }

    public org.java_websocket.d.a cND() {
        return this.kwX;
    }

    public List<org.java_websocket.d.a> cNE() {
        return this.kwY;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.kxc.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.kwW) {
            if (bVar2.cNH() != null && bVar2.cNH().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.cNH());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.kwY) {
            if (aVar.cNU().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.cNU());
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
        if (cNB().cNI().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", cNB().cNI());
        }
        if (cND() != null && cND().cNU().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", cND().cNU());
        }
        iVar.Hj("Web Socket Protocol Handshake");
        iVar.put(HTTP.SERVER_HEADER, "TooTallNate Java-WebSocket");
        iVar.put(HTTP.DATE_HEADER, cNF());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft cNA() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : cNC()) {
            arrayList.add(bVar.cNJ());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : cNE()) {
            arrayList2.add(aVar.cNV());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        cNB().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.cNM().remaining() + "): {" + (framedata.cNM().remaining() > 1000 ? "too big to display" : new String(framedata.cNM().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer cNM = framedata.cNM();
        boolean z = this.kwG == WebSocket.Role.CLIENT;
        if (cNM.remaining() <= 125) {
            i = 1;
        } else {
            i = cNM.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + cNM.remaining());
        allocate.put((byte) (((byte) (framedata.cNN() ? -128 : 0)) | a(framedata.cNR())));
        byte[] w = w(cNM.remaining(), i);
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
                allocate2.putInt(this.kxc.nextInt());
                allocate.put(allocate2.array());
                while (cNM.hasRemaining()) {
                    allocate.put((byte) (cNM.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(cNM);
                cNM.flip();
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
        ByteBuffer allocate = ByteBuffer.allocate(Dr(b));
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
        cNB().e(b5);
        cNB().c(b5);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b5.cNM().remaining() + "): {" + (b5.cNM().remaining() > 1000 ? "too big to display" : new String(b5.cNM().array())) + '}');
        }
        b5.cNK();
        return b5;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> n(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.kxb == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.kxb.remaining();
                if (remaining2 > remaining) {
                    this.kxb.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.kxb.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(p((ByteBuffer) this.kxb.duplicate().position(0)));
                this.kxb = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(Dr(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.kxb.limit()) {
                    throw new AssertionError();
                }
                this.kxb.rewind();
                allocate.put(this.kxb);
                this.kxb = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(p(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.kxb = ByteBuffer.allocate(Dr(e2.getPreferredSize()));
                this.kxb.put(byteBuffer);
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
            aVar.cNK();
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
            iVar.cNK();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.kxb = null;
        if (this.kwV != null) {
            this.kwV.reset();
        }
        this.kwV = new org.java_websocket.b.a();
        this.kwX = null;
    }

    private String cNF() {
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
        Framedata.Opcode cNR = framedata.cNR();
        if (cNR == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.l(i, str, true);
            } else if (cNz() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.k(i, str, true);
            } else {
                cVar.m(i, str, false);
            }
        } else if (cNR == Framedata.Opcode.PING) {
            cVar.cNy().onWebsocketPing(cVar, framedata);
        } else if (cNR == Framedata.Opcode.PONG) {
            cVar.cNx();
            cVar.cNy().onWebsocketPong(cVar, framedata);
        } else if (!framedata.cNN() || cNR == Framedata.Opcode.CONTINUOUS) {
            if (cNR != Framedata.Opcode.CONTINUOUS) {
                if (this.kwZ != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.kwZ = framedata;
                this.kxa.add(framedata.cNM());
            } else if (framedata.cNN()) {
                if (this.kwZ == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.kxa.add(framedata.cNM());
                if (this.kwZ.cNR() == Framedata.Opcode.TEXT) {
                    ((f) this.kwZ).q(cNG());
                    ((f) this.kwZ).cNK();
                    try {
                        cVar.cNy().onWebsocketMessage(cVar, org.java_websocket.e.c.r(this.kwZ.cNM()));
                    } catch (RuntimeException e) {
                        cVar.cNy().onWebsocketError(cVar, e);
                    }
                } else if (this.kwZ.cNR() == Framedata.Opcode.BINARY) {
                    ((f) this.kwZ).q(cNG());
                    ((f) this.kwZ).cNK();
                    try {
                        cVar.cNy().onWebsocketMessage(cVar, this.kwZ.cNM());
                    } catch (RuntimeException e2) {
                        cVar.cNy().onWebsocketError(cVar, e2);
                    }
                }
                this.kwZ = null;
                this.kxa.clear();
            } else if (this.kwZ == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (cNR == Framedata.Opcode.TEXT && !org.java_websocket.e.c.s(framedata.cNM())) {
                throw new InvalidDataException(1007);
            }
            if (cNR == Framedata.Opcode.CONTINUOUS && this.kwZ != null) {
                this.kxa.add(framedata.cNM());
            }
        } else if (this.kwZ != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (cNR == Framedata.Opcode.TEXT) {
                try {
                    cVar.cNy().onWebsocketMessage(cVar, org.java_websocket.e.c.r(framedata.cNM()));
                } catch (RuntimeException e3) {
                    cVar.cNy().onWebsocketError(cVar, e3);
                }
            } else if (cNR == Framedata.Opcode.BINARY) {
                try {
                    cVar.cNy().onWebsocketMessage(cVar, framedata.cNM());
                } catch (RuntimeException e4) {
                    cVar.cNy().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType cNz() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (cNB() != null) {
            draft = draft + " extension: " + cNB().toString();
        }
        if (cND() != null) {
            return draft + " protocol: " + cND().toString();
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
        if (this.kwV == null ? aVar.kwV != null : !this.kwV.equals(aVar.kwV)) {
            return false;
        }
        return this.kwX != null ? this.kwX.equals(aVar.kwX) : aVar.kwX == null;
    }

    public int hashCode() {
        return ((this.kwV != null ? this.kwV.hashCode() : 0) * 31) + (this.kwX != null ? this.kwX.hashCode() : 0);
    }

    private ByteBuffer cNG() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.kxa.iterator();
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
        for (ByteBuffer byteBuffer : this.kxa) {
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
