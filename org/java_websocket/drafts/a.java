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
    private b nMq;
    private List<b> nMr;
    private org.java_websocket.d.a nMs;
    private List<org.java_websocket.d.a> nMt;
    private Framedata nMu;
    private List<ByteBuffer> nMv;
    private ByteBuffer nMw;
    private final Random nMx;

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
        this.nMq = new org.java_websocket.b.a();
        this.nMx = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.nMr = new ArrayList(list.size());
        this.nMt = new ArrayList(list2.size());
        boolean z2 = false;
        this.nMv = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.nMr.addAll(list);
        if (!z) {
            this.nMr.add(this.nMr.size(), this.nMq);
        }
        this.nMt.addAll(list2);
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (c(aVar) != 13) {
            bY("acceptHandshakeAsServer - Wrong websocket version.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String Sw = aVar.Sw("Sec-WebSocket-Extensions");
        Iterator<b> it = this.nMr.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.Ss(Sw)) {
                this.nMq = next;
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                bY("acceptHandshakeAsServer - Matching extension found: " + this.nMq.toString());
                handshakeState2 = handshakeState3;
                break;
            }
        }
        Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
        String Sw2 = aVar.Sw("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.nMt.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState4;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.Sy(Sw2)) {
                this.nMs = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                bY("acceptHandshakeAsServer - Matching protocol found: " + this.nMs.toString());
                break;
            }
        }
        if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
            return Draft.HandshakeState.MATCHED;
        }
        bY("acceptHandshakeAsServer - No matching extension or protocol found.");
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar, h hVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (!b(hVar)) {
            bY("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return Draft.HandshakeState.NOT_MATCHED;
        } else if (!aVar.Sx("Sec-WebSocket-Key") || !hVar.Sx("Sec-WebSocket-Accept")) {
            bY("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return Draft.HandshakeState.NOT_MATCHED;
        } else {
            if (!Sr(aVar.Sw("Sec-WebSocket-Key")).equals(hVar.Sw("Sec-WebSocket-Accept"))) {
                bY("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String Sw = hVar.Sw("Sec-WebSocket-Extensions");
            Iterator<b> it = this.nMr.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.St(Sw)) {
                    this.nMq = next;
                    Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                    bY("acceptHandshakeAsClient - Matching extension found: " + this.nMq.toString());
                    handshakeState2 = handshakeState3;
                    break;
                }
            }
            Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
            String Sw2 = hVar.Sw("Sec-WebSocket-Protocol");
            Iterator<org.java_websocket.d.a> it2 = this.nMt.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    handshakeState = handshakeState4;
                    break;
                }
                org.java_websocket.d.a next2 = it2.next();
                if (next2.Sy(Sw2)) {
                    this.nMs = next2;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    bY("acceptHandshakeAsClient - Matching protocol found: " + this.nMs.toString());
                    break;
                }
            }
            if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
                return Draft.HandshakeState.MATCHED;
            }
            bY("acceptHandshakeAsClient - No matching extension or protocol found.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
    }

    public b dNn() {
        return this.nMq;
    }

    public List<b> dNo() {
        return this.nMr;
    }

    public org.java_websocket.d.a dNp() {
        return this.nMs;
    }

    public List<org.java_websocket.d.a> dNq() {
        return this.nMt;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.nMx.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.nMr) {
            if (bVar2.dNt() != null && bVar2.dNt().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.dNt());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.nMt) {
            if (aVar.dNF().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.dNF());
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
        iVar.put(HTTP.CONN_DIRECTIVE, aVar.Sw(HTTP.CONN_DIRECTIVE));
        String Sw = aVar.Sw("Sec-WebSocket-Key");
        if (Sw == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", Sr(Sw));
        if (dNn().dNu().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", dNn().dNu());
        }
        if (dNp() != null && dNp().dNF().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", dNp().dNF());
        }
        iVar.Sv("Web Socket Protocol Handshake");
        iVar.put("Server", "TooTallNate Java-WebSocket");
        iVar.put("Date", dNr());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft dNm() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : dNo()) {
            arrayList.add(bVar.dNv());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : dNq()) {
            arrayList2.add(aVar.dNG());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        dNn().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.dNy().remaining() + "): {" + (framedata.dNy().remaining() > 1000 ? "too big to display" : new String(framedata.dNy().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer dNy = framedata.dNy();
        boolean z = this.nMb == WebSocket.Role.CLIENT;
        if (dNy.remaining() <= 125) {
            i = 1;
        } else {
            i = dNy.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + dNy.remaining());
        allocate.put((byte) (((byte) (framedata.Mn() ? -128 : 0)) | a(framedata.dNC())));
        byte[] F = F(dNy.remaining(), i);
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
                allocate2.putInt(this.nMx.nextInt());
                allocate.put(allocate2.array());
                while (dNy.hasRemaining()) {
                    allocate.put((byte) (dNy.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(dNy);
                dNy.flip();
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
        ByteBuffer allocate = ByteBuffer.allocate(NY(b));
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
        b5.cj(z3);
        b5.wU(z);
        b5.wV(z2);
        b5.wW(z4);
        allocate.flip();
        b5.u(allocate);
        dNn().e(b5);
        dNn().c(b5);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b5.dNy().remaining() + "): {" + (b5.dNy().remaining() > 1000 ? "too big to display" : new String(b5.dNy().array())) + '}');
        }
        b5.dNw();
        return b5;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> r(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.nMw == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.nMw.remaining();
                if (remaining2 > remaining) {
                    this.nMw.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.nMw.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(t((ByteBuffer) this.nMw.duplicate().position(0)));
                this.nMw = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(NY(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.nMw.limit()) {
                    throw new AssertionError();
                }
                this.nMw.rewind();
                allocate.put(this.nMw);
                this.nMw = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(t(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.nMw = ByteBuffer.allocate(NY(e2.getPreferredSize()));
                this.nMw.put(byteBuffer);
            }
        }
        return linkedList;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> b(ByteBuffer byteBuffer, boolean z) {
        org.java_websocket.framing.a aVar = new org.java_websocket.framing.a();
        aVar.u(byteBuffer);
        aVar.wX(z);
        try {
            aVar.dNw();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> aU(String str, boolean z) {
        org.java_websocket.framing.i iVar = new org.java_websocket.framing.i();
        iVar.u(ByteBuffer.wrap(org.java_websocket.e.c.Sz(str)));
        iVar.wX(z);
        try {
            iVar.dNw();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.nMw = null;
        if (this.nMq != null) {
            this.nMq.reset();
        }
        this.nMq = new org.java_websocket.b.a();
        this.nMs = null;
    }

    private String dNr() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String Sr(String str) {
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
        Framedata.Opcode dNC = framedata.dNC();
        if (dNC == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.o(i, str, true);
            } else if (dNl() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.n(i, str, true);
            } else {
                cVar.p(i, str, false);
            }
        } else if (dNC == Framedata.Opcode.PING) {
            cVar.dNk().onWebsocketPing(cVar, framedata);
        } else if (dNC == Framedata.Opcode.PONG) {
            cVar.dNj();
            cVar.dNk().onWebsocketPong(cVar, framedata);
        } else if (!framedata.Mn() || dNC == Framedata.Opcode.CONTINUOUS) {
            if (dNC != Framedata.Opcode.CONTINUOUS) {
                if (this.nMu != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.nMu = framedata;
                this.nMv.add(framedata.dNy());
            } else if (framedata.Mn()) {
                if (this.nMu == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.nMv.add(framedata.dNy());
                if (this.nMu.dNC() == Framedata.Opcode.TEXT) {
                    ((f) this.nMu).u(dNs());
                    ((f) this.nMu).dNw();
                    try {
                        cVar.dNk().onWebsocketMessage(cVar, org.java_websocket.e.c.v(this.nMu.dNy()));
                    } catch (RuntimeException e) {
                        cVar.dNk().onWebsocketError(cVar, e);
                    }
                } else if (this.nMu.dNC() == Framedata.Opcode.BINARY) {
                    ((f) this.nMu).u(dNs());
                    ((f) this.nMu).dNw();
                    try {
                        cVar.dNk().onWebsocketMessage(cVar, this.nMu.dNy());
                    } catch (RuntimeException e2) {
                        cVar.dNk().onWebsocketError(cVar, e2);
                    }
                }
                this.nMu = null;
                this.nMv.clear();
            } else if (this.nMu == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (dNC == Framedata.Opcode.TEXT && !org.java_websocket.e.c.w(framedata.dNy())) {
                throw new InvalidDataException(1007);
            }
            if (dNC == Framedata.Opcode.CONTINUOUS && this.nMu != null) {
                this.nMv.add(framedata.dNy());
            }
        } else if (this.nMu != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (dNC == Framedata.Opcode.TEXT) {
                try {
                    cVar.dNk().onWebsocketMessage(cVar, org.java_websocket.e.c.v(framedata.dNy()));
                } catch (RuntimeException e3) {
                    cVar.dNk().onWebsocketError(cVar, e3);
                }
            } else if (dNC == Framedata.Opcode.BINARY) {
                try {
                    cVar.dNk().onWebsocketMessage(cVar, framedata.dNy());
                } catch (RuntimeException e4) {
                    cVar.dNk().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType dNl() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (dNn() != null) {
            draft = draft + " extension: " + dNn().toString();
        }
        if (dNp() != null) {
            return draft + " protocol: " + dNp().toString();
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
        if (this.nMq == null ? aVar.nMq != null : !this.nMq.equals(aVar.nMq)) {
            return false;
        }
        return this.nMs != null ? this.nMs.equals(aVar.nMs) : aVar.nMs == null;
    }

    public int hashCode() {
        return ((this.nMq != null ? this.nMq.hashCode() : 0) * 31) + (this.nMs != null ? this.nMs.hashCode() : 0);
    }

    private ByteBuffer dNs() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.nMv.iterator();
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
        for (ByteBuffer byteBuffer : this.nMv) {
            allocate.put(byteBuffer);
        }
        allocate.flip();
        return allocate;
    }

    private static void bY(Object obj) {
        if (org.java_websocket.c.DEBUG) {
            System.out.println(obj);
        }
    }
}
