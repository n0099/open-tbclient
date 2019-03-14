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
    private final Random jUA;
    private b jUt;
    private List<b> jUu;
    private org.java_websocket.d.a jUv;
    private List<org.java_websocket.d.a> jUw;
    private Framedata jUx;
    private List<ByteBuffer> jUy;
    private ByteBuffer jUz;

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
        this.jUt = new org.java_websocket.b.a();
        this.jUA = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.jUu = new ArrayList(list.size());
        this.jUw = new ArrayList(list2.size());
        boolean z2 = false;
        this.jUy = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.jUu.addAll(list);
        if (!z) {
            this.jUu.add(this.jUu.size(), this.jUt);
        }
        this.jUw.addAll(list2);
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (c(aVar) != 13) {
            bl("acceptHandshakeAsServer - Wrong websocket version.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String Gj = aVar.Gj("Sec-WebSocket-Extensions");
        Iterator<b> it = this.jUu.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.Gf(Gj)) {
                this.jUt = next;
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                bl("acceptHandshakeAsServer - Matching extension found: " + this.jUt.toString());
                handshakeState2 = handshakeState3;
                break;
            }
        }
        Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
        String Gj2 = aVar.Gj("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.jUw.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState4;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.Gl(Gj2)) {
                this.jUv = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                bl("acceptHandshakeAsServer - Matching protocol found: " + this.jUv.toString());
                break;
            }
        }
        if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
            return Draft.HandshakeState.MATCHED;
        }
        bl("acceptHandshakeAsServer - No matching extension or protocol found.");
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar, h hVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (!b(hVar)) {
            bl("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return Draft.HandshakeState.NOT_MATCHED;
        } else if (!aVar.Gk("Sec-WebSocket-Key") || !hVar.Gk("Sec-WebSocket-Accept")) {
            bl("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return Draft.HandshakeState.NOT_MATCHED;
        } else {
            if (!Ge(aVar.Gj("Sec-WebSocket-Key")).equals(hVar.Gj("Sec-WebSocket-Accept"))) {
                bl("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String Gj = hVar.Gj("Sec-WebSocket-Extensions");
            Iterator<b> it = this.jUu.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.Gg(Gj)) {
                    this.jUt = next;
                    Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                    bl("acceptHandshakeAsClient - Matching extension found: " + this.jUt.toString());
                    handshakeState2 = handshakeState3;
                    break;
                }
            }
            Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
            String Gj2 = hVar.Gj("Sec-WebSocket-Protocol");
            Iterator<org.java_websocket.d.a> it2 = this.jUw.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    handshakeState = handshakeState4;
                    break;
                }
                org.java_websocket.d.a next2 = it2.next();
                if (next2.Gl(Gj2)) {
                    this.jUv = next2;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    bl("acceptHandshakeAsClient - Matching protocol found: " + this.jUv.toString());
                    break;
                }
            }
            if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
                return Draft.HandshakeState.MATCHED;
            }
            bl("acceptHandshakeAsClient - No matching extension or protocol found.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
    }

    public b cDf() {
        return this.jUt;
    }

    public List<b> cDg() {
        return this.jUu;
    }

    public org.java_websocket.d.a cDh() {
        return this.jUv;
    }

    public List<org.java_websocket.d.a> cDi() {
        return this.jUw;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.jUA.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.jUu) {
            if (bVar2.cDl() != null && bVar2.cDl().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.cDl());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.jUw) {
            if (aVar.cDy().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.cDy());
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
        iVar.put(HTTP.CONN_DIRECTIVE, aVar.Gj(HTTP.CONN_DIRECTIVE));
        String Gj = aVar.Gj("Sec-WebSocket-Key");
        if (Gj == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", Ge(Gj));
        if (cDf().cDm().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", cDf().cDm());
        }
        if (cDh() != null && cDh().cDy().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", cDh().cDy());
        }
        iVar.Gi("Web Socket Protocol Handshake");
        iVar.put(HTTP.SERVER_HEADER, "TooTallNate Java-WebSocket");
        iVar.put(HTTP.DATE_HEADER, cDj());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft cDe() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : cDg()) {
            arrayList.add(bVar.cDn());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : cDi()) {
            arrayList2.add(aVar.cDz());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        cDf().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.cDq().remaining() + "): {" + (framedata.cDq().remaining() > 1000 ? "too big to display" : new String(framedata.cDq().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer cDq = framedata.cDq();
        boolean z = this.jUe == WebSocket.Role.CLIENT;
        if (cDq.remaining() <= 125) {
            i = 1;
        } else {
            i = cDq.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + cDq.remaining());
        allocate.put((byte) (((byte) (framedata.cDr() ? -128 : 0)) | a(framedata.cDv())));
        byte[] x = x(cDq.remaining(), i);
        if ($assertionsDisabled || x.length == i) {
            if (i == 1) {
                allocate.put((byte) (x[0] | (z ? Byte.MIN_VALUE : (byte) 0)));
            } else if (i == 2) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | 126));
                allocate.put(x);
            } else if (i == 8) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | Byte.MAX_VALUE));
                allocate.put(x);
            } else {
                throw new RuntimeException("Size representation not supported/specified");
            }
            if (z) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.putInt(this.jUA.nextInt());
                allocate.put(allocate2.array());
                while (cDq.hasRemaining()) {
                    allocate.put((byte) (cDq.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(cDq);
                cDq.flip();
            }
            if ($assertionsDisabled || allocate.remaining() == 0) {
                allocate.flip();
                return allocate;
            }
            throw new AssertionError(allocate.remaining());
        }
        throw new AssertionError();
    }

    public Framedata s(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
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
        ByteBuffer allocate = ByteBuffer.allocate(Do(b));
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
        b5.rG(z3);
        b5.rH(z);
        b5.rI(z2);
        b5.rJ(z4);
        allocate.flip();
        b5.t(allocate);
        cDf().e(b5);
        cDf().c(b5);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b5.cDq().remaining() + "): {" + (b5.cDq().remaining() > 1000 ? "too big to display" : new String(b5.cDq().array())) + '}');
        }
        b5.cDo();
        return b5;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> q(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.jUz == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.jUz.remaining();
                if (remaining2 > remaining) {
                    this.jUz.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.jUz.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(s((ByteBuffer) this.jUz.duplicate().position(0)));
                this.jUz = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(Do(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.jUz.limit()) {
                    throw new AssertionError();
                }
                this.jUz.rewind();
                allocate.put(this.jUz);
                this.jUz = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(s(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.jUz = ByteBuffer.allocate(Do(e2.getPreferredSize()));
                this.jUz.put(byteBuffer);
            }
        }
        return linkedList;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> b(ByteBuffer byteBuffer, boolean z) {
        org.java_websocket.framing.a aVar = new org.java_websocket.framing.a();
        aVar.t(byteBuffer);
        aVar.rK(z);
        try {
            aVar.cDo();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> az(String str, boolean z) {
        org.java_websocket.framing.i iVar = new org.java_websocket.framing.i();
        iVar.t(ByteBuffer.wrap(org.java_websocket.e.c.Gm(str)));
        iVar.rK(z);
        try {
            iVar.cDo();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.jUz = null;
        if (this.jUt != null) {
            this.jUt.reset();
        }
        this.jUt = new org.java_websocket.b.a();
        this.jUv = null;
    }

    private String cDj() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String Ge(String str) {
        try {
            return org.java_websocket.e.a.encodeBytes(MessageDigest.getInstance("SHA1").digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    private byte[] x(long j, int i) {
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
        Framedata.Opcode cDv = framedata.cDv();
        if (cDv == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.j(i, str, true);
            } else if (cDd() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.i(i, str, true);
            } else {
                cVar.k(i, str, false);
            }
        } else if (cDv == Framedata.Opcode.PING) {
            cVar.cDc().onWebsocketPing(cVar, framedata);
        } else if (cDv == Framedata.Opcode.PONG) {
            cVar.cDb();
            cVar.cDc().onWebsocketPong(cVar, framedata);
        } else if (!framedata.cDr() || cDv == Framedata.Opcode.CONTINUOUS) {
            if (cDv != Framedata.Opcode.CONTINUOUS) {
                if (this.jUx != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.jUx = framedata;
                this.jUy.add(framedata.cDq());
            } else if (framedata.cDr()) {
                if (this.jUx == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.jUy.add(framedata.cDq());
                if (this.jUx.cDv() == Framedata.Opcode.TEXT) {
                    ((f) this.jUx).t(cDk());
                    ((f) this.jUx).cDo();
                    try {
                        cVar.cDc().onWebsocketMessage(cVar, org.java_websocket.e.c.u(this.jUx.cDq()));
                    } catch (RuntimeException e) {
                        cVar.cDc().onWebsocketError(cVar, e);
                    }
                } else if (this.jUx.cDv() == Framedata.Opcode.BINARY) {
                    ((f) this.jUx).t(cDk());
                    ((f) this.jUx).cDo();
                    try {
                        cVar.cDc().onWebsocketMessage(cVar, this.jUx.cDq());
                    } catch (RuntimeException e2) {
                        cVar.cDc().onWebsocketError(cVar, e2);
                    }
                }
                this.jUx = null;
                this.jUy.clear();
            } else if (this.jUx == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (cDv == Framedata.Opcode.TEXT && !org.java_websocket.e.c.v(framedata.cDq())) {
                throw new InvalidDataException(PointerIconCompat.TYPE_CROSSHAIR);
            }
            if (cDv == Framedata.Opcode.CONTINUOUS && this.jUx != null) {
                this.jUy.add(framedata.cDq());
            }
        } else if (this.jUx != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (cDv == Framedata.Opcode.TEXT) {
                try {
                    cVar.cDc().onWebsocketMessage(cVar, org.java_websocket.e.c.u(framedata.cDq()));
                } catch (RuntimeException e3) {
                    cVar.cDc().onWebsocketError(cVar, e3);
                }
            } else if (cDv == Framedata.Opcode.BINARY) {
                try {
                    cVar.cDc().onWebsocketMessage(cVar, framedata.cDq());
                } catch (RuntimeException e4) {
                    cVar.cDc().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType cDd() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (cDf() != null) {
            draft = draft + " extension: " + cDf().toString();
        }
        if (cDh() != null) {
            return draft + " protocol: " + cDh().toString();
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
        if (this.jUt == null ? aVar.jUt != null : !this.jUt.equals(aVar.jUt)) {
            return false;
        }
        return this.jUv != null ? this.jUv.equals(aVar.jUv) : aVar.jUv == null;
    }

    public int hashCode() {
        return ((this.jUt != null ? this.jUt.hashCode() : 0) * 31) + (this.jUv != null ? this.jUv.hashCode() : 0);
    }

    private ByteBuffer cDk() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.jUy.iterator();
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
        for (ByteBuffer byteBuffer : this.jUy) {
            allocate.put(byteBuffer);
        }
        allocate.flip();
        return allocate;
    }

    private static void bl(Object obj) {
        if (org.java_websocket.c.DEBUG) {
            System.out.println(obj);
        }
    }
}
