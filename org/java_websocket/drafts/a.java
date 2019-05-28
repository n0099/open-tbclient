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
    private b kmd;
    private List<b> kme;
    private org.java_websocket.d.a kmf;
    private List<org.java_websocket.d.a> kmg;
    private Framedata kmh;
    private List<ByteBuffer> kmi;
    private ByteBuffer kmj;
    private final Random kmk;

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
        this.kmd = new org.java_websocket.b.a();
        this.kmk = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.kme = new ArrayList(list.size());
        this.kmg = new ArrayList(list2.size());
        boolean z2 = false;
        this.kmi = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.kme.addAll(list);
        if (!z) {
            this.kme.add(this.kme.size(), this.kmd);
        }
        this.kmg.addAll(list2);
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
        Iterator<b> it = this.kme.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.Hm(Hq)) {
                this.kmd = next;
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                bj("acceptHandshakeAsServer - Matching extension found: " + this.kmd.toString());
                handshakeState2 = handshakeState3;
                break;
            }
        }
        Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
        String Hq2 = aVar.Hq("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.kmg.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState4;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.Hs(Hq2)) {
                this.kmf = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                bj("acceptHandshakeAsServer - Matching protocol found: " + this.kmf.toString());
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
            Iterator<b> it = this.kme.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.Hn(Hq)) {
                    this.kmd = next;
                    Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                    bj("acceptHandshakeAsClient - Matching extension found: " + this.kmd.toString());
                    handshakeState2 = handshakeState3;
                    break;
                }
            }
            Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
            String Hq2 = hVar.Hq("Sec-WebSocket-Protocol");
            Iterator<org.java_websocket.d.a> it2 = this.kmg.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    handshakeState = handshakeState4;
                    break;
                }
                org.java_websocket.d.a next2 = it2.next();
                if (next2.Hs(Hq2)) {
                    this.kmf = next2;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    bj("acceptHandshakeAsClient - Matching protocol found: " + this.kmf.toString());
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

    public b cKC() {
        return this.kmd;
    }

    public List<b> cKD() {
        return this.kme;
    }

    public org.java_websocket.d.a cKE() {
        return this.kmf;
    }

    public List<org.java_websocket.d.a> cKF() {
        return this.kmg;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.kmk.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.kme) {
            if (bVar2.cKI() != null && bVar2.cKI().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.cKI());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.kmg) {
            if (aVar.cKV().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.cKV());
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
        if (cKC().cKJ().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", cKC().cKJ());
        }
        if (cKE() != null && cKE().cKV().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", cKE().cKV());
        }
        iVar.Hp("Web Socket Protocol Handshake");
        iVar.put(HTTP.SERVER_HEADER, "TooTallNate Java-WebSocket");
        iVar.put(HTTP.DATE_HEADER, cKG());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft cKB() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : cKD()) {
            arrayList.add(bVar.cKK());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : cKF()) {
            arrayList2.add(aVar.cKW());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        cKC().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.cKN().remaining() + "): {" + (framedata.cKN().remaining() > 1000 ? "too big to display" : new String(framedata.cKN().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer cKN = framedata.cKN();
        boolean z = this.klO == WebSocket.Role.CLIENT;
        if (cKN.remaining() <= 125) {
            i = 1;
        } else {
            i = cKN.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + cKN.remaining());
        allocate.put((byte) (((byte) (framedata.cKO() ? -128 : 0)) | a(framedata.cKS())));
        byte[] v = v(cKN.remaining(), i);
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
                allocate2.putInt(this.kmk.nextInt());
                allocate.put(allocate2.array());
                while (cKN.hasRemaining()) {
                    allocate.put((byte) (cKN.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(cKN);
                cKN.flip();
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
        cKC().e(b5);
        cKC().c(b5);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b5.cKN().remaining() + "): {" + (b5.cKN().remaining() > 1000 ? "too big to display" : new String(b5.cKN().array())) + '}');
        }
        b5.cKL();
        return b5;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> n(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.kmj == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.kmj.remaining();
                if (remaining2 > remaining) {
                    this.kmj.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.kmj.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(p((ByteBuffer) this.kmj.duplicate().position(0)));
                this.kmj = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(Eg(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.kmj.limit()) {
                    throw new AssertionError();
                }
                this.kmj.rewind();
                allocate.put(this.kmj);
                this.kmj = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(p(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.kmj = ByteBuffer.allocate(Eg(e2.getPreferredSize()));
                this.kmj.put(byteBuffer);
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
            aVar.cKL();
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
            iVar.cKL();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.kmj = null;
        if (this.kmd != null) {
            this.kmd.reset();
        }
        this.kmd = new org.java_websocket.b.a();
        this.kmf = null;
    }

    private String cKG() {
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
        Framedata.Opcode cKS = framedata.cKS();
        if (cKS == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.j(i, str, true);
            } else if (cKA() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.i(i, str, true);
            } else {
                cVar.k(i, str, false);
            }
        } else if (cKS == Framedata.Opcode.PING) {
            cVar.cKz().onWebsocketPing(cVar, framedata);
        } else if (cKS == Framedata.Opcode.PONG) {
            cVar.cKy();
            cVar.cKz().onWebsocketPong(cVar, framedata);
        } else if (!framedata.cKO() || cKS == Framedata.Opcode.CONTINUOUS) {
            if (cKS != Framedata.Opcode.CONTINUOUS) {
                if (this.kmh != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.kmh = framedata;
                this.kmi.add(framedata.cKN());
            } else if (framedata.cKO()) {
                if (this.kmh == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.kmi.add(framedata.cKN());
                if (this.kmh.cKS() == Framedata.Opcode.TEXT) {
                    ((f) this.kmh).q(cKH());
                    ((f) this.kmh).cKL();
                    try {
                        cVar.cKz().onWebsocketMessage(cVar, org.java_websocket.e.c.r(this.kmh.cKN()));
                    } catch (RuntimeException e) {
                        cVar.cKz().onWebsocketError(cVar, e);
                    }
                } else if (this.kmh.cKS() == Framedata.Opcode.BINARY) {
                    ((f) this.kmh).q(cKH());
                    ((f) this.kmh).cKL();
                    try {
                        cVar.cKz().onWebsocketMessage(cVar, this.kmh.cKN());
                    } catch (RuntimeException e2) {
                        cVar.cKz().onWebsocketError(cVar, e2);
                    }
                }
                this.kmh = null;
                this.kmi.clear();
            } else if (this.kmh == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (cKS == Framedata.Opcode.TEXT && !org.java_websocket.e.c.s(framedata.cKN())) {
                throw new InvalidDataException(PointerIconCompat.TYPE_CROSSHAIR);
            }
            if (cKS == Framedata.Opcode.CONTINUOUS && this.kmh != null) {
                this.kmi.add(framedata.cKN());
            }
        } else if (this.kmh != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (cKS == Framedata.Opcode.TEXT) {
                try {
                    cVar.cKz().onWebsocketMessage(cVar, org.java_websocket.e.c.r(framedata.cKN()));
                } catch (RuntimeException e3) {
                    cVar.cKz().onWebsocketError(cVar, e3);
                }
            } else if (cKS == Framedata.Opcode.BINARY) {
                try {
                    cVar.cKz().onWebsocketMessage(cVar, framedata.cKN());
                } catch (RuntimeException e4) {
                    cVar.cKz().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType cKA() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (cKC() != null) {
            draft = draft + " extension: " + cKC().toString();
        }
        if (cKE() != null) {
            return draft + " protocol: " + cKE().toString();
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
        if (this.kmd == null ? aVar.kmd != null : !this.kmd.equals(aVar.kmd)) {
            return false;
        }
        return this.kmf != null ? this.kmf.equals(aVar.kmf) : aVar.kmf == null;
    }

    public int hashCode() {
        return ((this.kmd != null ? this.kmd.hashCode() : 0) * 31) + (this.kmf != null ? this.kmf.hashCode() : 0);
    }

    private ByteBuffer cKH() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.kmi.iterator();
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
        for (ByteBuffer byteBuffer : this.kmi) {
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
