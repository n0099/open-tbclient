package org.java_websocket.drafts;

import android.support.v4.view.PointerIconCompat;
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
    private b kmc;
    private List<b> kmd;
    private org.java_websocket.d.a kme;
    private List<org.java_websocket.d.a> kmf;
    private Framedata kmg;
    private List<ByteBuffer> kmh;
    private ByteBuffer kmi;
    private final Random kmj;

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
        this.kmc = new org.java_websocket.b.a();
        this.kmj = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.kmd = new ArrayList(list.size());
        this.kmf = new ArrayList(list2.size());
        boolean z2 = false;
        this.kmh = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.kmd.addAll(list);
        if (!z) {
            this.kmd.add(this.kmd.size(), this.kmc);
        }
        this.kmf.addAll(list2);
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (c(aVar) != 13) {
            bj("acceptHandshakeAsServer - Wrong websocket version.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String Hq = aVar.Hq("Sec-WebSocket-Extensions");
        Iterator<b> it = this.kmd.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.Hm(Hq)) {
                this.kmc = next;
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                bj("acceptHandshakeAsServer - Matching extension found: " + this.kmc.toString());
                handshakeState2 = handshakeState3;
                break;
            }
        }
        Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
        String Hq2 = aVar.Hq("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.kmf.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState4;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.Hs(Hq2)) {
                this.kme = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                bj("acceptHandshakeAsServer - Matching protocol found: " + this.kme.toString());
                break;
            }
        }
        if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
            return Draft.HandshakeState.MATCHED;
        }
        bj("acceptHandshakeAsServer - No matching extension or protocol found.");
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar, h hVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (!b(hVar)) {
            bj("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return Draft.HandshakeState.NOT_MATCHED;
        } else if (!aVar.Hr("Sec-WebSocket-Key") || !hVar.Hr("Sec-WebSocket-Accept")) {
            bj("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return Draft.HandshakeState.NOT_MATCHED;
        } else {
            if (!Hl(aVar.Hq("Sec-WebSocket-Key")).equals(hVar.Hq("Sec-WebSocket-Accept"))) {
                bj("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String Hq = hVar.Hq("Sec-WebSocket-Extensions");
            Iterator<b> it = this.kmd.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.Hn(Hq)) {
                    this.kmc = next;
                    Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                    bj("acceptHandshakeAsClient - Matching extension found: " + this.kmc.toString());
                    handshakeState2 = handshakeState3;
                    break;
                }
            }
            Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
            String Hq2 = hVar.Hq("Sec-WebSocket-Protocol");
            Iterator<org.java_websocket.d.a> it2 = this.kmf.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    handshakeState = handshakeState4;
                    break;
                }
                org.java_websocket.d.a next2 = it2.next();
                if (next2.Hs(Hq2)) {
                    this.kme = next2;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    bj("acceptHandshakeAsClient - Matching protocol found: " + this.kme.toString());
                    break;
                }
            }
            if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
                return Draft.HandshakeState.MATCHED;
            }
            bj("acceptHandshakeAsClient - No matching extension or protocol found.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
    }

    public b cKA() {
        return this.kmc;
    }

    public List<b> cKB() {
        return this.kmd;
    }

    public org.java_websocket.d.a cKC() {
        return this.kme;
    }

    public List<org.java_websocket.d.a> cKD() {
        return this.kmf;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.kmj.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.kmd) {
            if (bVar2.cKG() != null && bVar2.cKG().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.cKG());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.kmf) {
            if (aVar.cKT().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.cKT());
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
        iVar.put(HTTP.CONN_DIRECTIVE, aVar.Hq(HTTP.CONN_DIRECTIVE));
        String Hq = aVar.Hq("Sec-WebSocket-Key");
        if (Hq == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", Hl(Hq));
        if (cKA().cKH().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", cKA().cKH());
        }
        if (cKC() != null && cKC().cKT().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", cKC().cKT());
        }
        iVar.Hp("Web Socket Protocol Handshake");
        iVar.put(HTTP.SERVER_HEADER, "TooTallNate Java-WebSocket");
        iVar.put(HTTP.DATE_HEADER, cKE());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft cKz() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : cKB()) {
            arrayList.add(bVar.cKI());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : cKD()) {
            arrayList2.add(aVar.cKU());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        cKA().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.cKL().remaining() + "): {" + (framedata.cKL().remaining() > 1000 ? "too big to display" : new String(framedata.cKL().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer cKL = framedata.cKL();
        boolean z = this.klN == WebSocket.Role.CLIENT;
        if (cKL.remaining() <= 125) {
            i = 1;
        } else {
            i = cKL.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + cKL.remaining());
        allocate.put((byte) (((byte) (framedata.cKM() ? -128 : 0)) | a(framedata.cKQ())));
        byte[] v = v(cKL.remaining(), i);
        if ($assertionsDisabled || v.length == i) {
            if (i == 1) {
                allocate.put((byte) (v[0] | (z ? Byte.MIN_VALUE : (byte) 0)));
            } else if (i == 2) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | 126));
                allocate.put(v);
            } else if (i == 8) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | Byte.MAX_VALUE));
                allocate.put(v);
            } else {
                throw new RuntimeException("Size representation not supported/specified");
            }
            if (z) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.putInt(this.kmj.nextInt());
                allocate.put(allocate2.array());
                while (cKL.hasRemaining()) {
                    allocate.put((byte) (cKL.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(cKL);
                cKL.flip();
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
        ByteBuffer allocate = ByteBuffer.allocate(Eg(b));
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
        b5.su(z3);
        b5.sv(z);
        b5.sw(z2);
        b5.sx(z4);
        allocate.flip();
        b5.q(allocate);
        cKA().e(b5);
        cKA().c(b5);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b5.cKL().remaining() + "): {" + (b5.cKL().remaining() > 1000 ? "too big to display" : new String(b5.cKL().array())) + '}');
        }
        b5.cKJ();
        return b5;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> n(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.kmi == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.kmi.remaining();
                if (remaining2 > remaining) {
                    this.kmi.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.kmi.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(p((ByteBuffer) this.kmi.duplicate().position(0)));
                this.kmi = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(Eg(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.kmi.limit()) {
                    throw new AssertionError();
                }
                this.kmi.rewind();
                allocate.put(this.kmi);
                this.kmi = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(p(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.kmi = ByteBuffer.allocate(Eg(e2.getPreferredSize()));
                this.kmi.put(byteBuffer);
            }
        }
        return linkedList;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> b(ByteBuffer byteBuffer, boolean z) {
        org.java_websocket.framing.a aVar = new org.java_websocket.framing.a();
        aVar.q(byteBuffer);
        aVar.sy(z);
        try {
            aVar.cKJ();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> aB(String str, boolean z) {
        org.java_websocket.framing.i iVar = new org.java_websocket.framing.i();
        iVar.q(ByteBuffer.wrap(org.java_websocket.e.c.Ht(str)));
        iVar.sy(z);
        try {
            iVar.cKJ();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.kmi = null;
        if (this.kmc != null) {
            this.kmc.reset();
        }
        this.kmc = new org.java_websocket.b.a();
        this.kme = null;
    }

    private String cKE() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String Hl(String str) {
        try {
            return org.java_websocket.e.a.encodeBytes(MessageDigest.getInstance("SHA1").digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    private byte[] v(long j, int i) {
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
        Framedata.Opcode cKQ = framedata.cKQ();
        if (cKQ == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.j(i, str, true);
            } else if (cKy() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.i(i, str, true);
            } else {
                cVar.k(i, str, false);
            }
        } else if (cKQ == Framedata.Opcode.PING) {
            cVar.cKx().onWebsocketPing(cVar, framedata);
        } else if (cKQ == Framedata.Opcode.PONG) {
            cVar.cKw();
            cVar.cKx().onWebsocketPong(cVar, framedata);
        } else if (!framedata.cKM() || cKQ == Framedata.Opcode.CONTINUOUS) {
            if (cKQ != Framedata.Opcode.CONTINUOUS) {
                if (this.kmg != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.kmg = framedata;
                this.kmh.add(framedata.cKL());
            } else if (framedata.cKM()) {
                if (this.kmg == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.kmh.add(framedata.cKL());
                if (this.kmg.cKQ() == Framedata.Opcode.TEXT) {
                    ((f) this.kmg).q(cKF());
                    ((f) this.kmg).cKJ();
                    try {
                        cVar.cKx().onWebsocketMessage(cVar, org.java_websocket.e.c.r(this.kmg.cKL()));
                    } catch (RuntimeException e) {
                        cVar.cKx().onWebsocketError(cVar, e);
                    }
                } else if (this.kmg.cKQ() == Framedata.Opcode.BINARY) {
                    ((f) this.kmg).q(cKF());
                    ((f) this.kmg).cKJ();
                    try {
                        cVar.cKx().onWebsocketMessage(cVar, this.kmg.cKL());
                    } catch (RuntimeException e2) {
                        cVar.cKx().onWebsocketError(cVar, e2);
                    }
                }
                this.kmg = null;
                this.kmh.clear();
            } else if (this.kmg == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (cKQ == Framedata.Opcode.TEXT && !org.java_websocket.e.c.s(framedata.cKL())) {
                throw new InvalidDataException(PointerIconCompat.TYPE_CROSSHAIR);
            }
            if (cKQ == Framedata.Opcode.CONTINUOUS && this.kmg != null) {
                this.kmh.add(framedata.cKL());
            }
        } else if (this.kmg != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (cKQ == Framedata.Opcode.TEXT) {
                try {
                    cVar.cKx().onWebsocketMessage(cVar, org.java_websocket.e.c.r(framedata.cKL()));
                } catch (RuntimeException e3) {
                    cVar.cKx().onWebsocketError(cVar, e3);
                }
            } else if (cKQ == Framedata.Opcode.BINARY) {
                try {
                    cVar.cKx().onWebsocketMessage(cVar, framedata.cKL());
                } catch (RuntimeException e4) {
                    cVar.cKx().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType cKy() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (cKA() != null) {
            draft = draft + " extension: " + cKA().toString();
        }
        if (cKC() != null) {
            return draft + " protocol: " + cKC().toString();
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
        if (this.kmc == null ? aVar.kmc != null : !this.kmc.equals(aVar.kmc)) {
            return false;
        }
        return this.kme != null ? this.kme.equals(aVar.kme) : aVar.kme == null;
    }

    public int hashCode() {
        return ((this.kmc != null ? this.kmc.hashCode() : 0) * 31) + (this.kme != null ? this.kme.hashCode() : 0);
    }

    private ByteBuffer cKF() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.kmh.iterator();
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
        for (ByteBuffer byteBuffer : this.kmh) {
            allocate.put(byteBuffer);
        }
        allocate.flip();
        return allocate;
    }

    private static void bj(Object obj) {
        if (org.java_websocket.c.DEBUG) {
            System.out.println(obj);
        }
    }
}
