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
    private b jUi;
    private List<b> jUj;
    private org.java_websocket.d.a jUk;
    private List<org.java_websocket.d.a> jUl;
    private Framedata jUm;
    private List<ByteBuffer> jUn;
    private ByteBuffer jUo;
    private final Random jUp;

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
        this.jUi = new org.java_websocket.b.a();
        this.jUp = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.jUj = new ArrayList(list.size());
        this.jUl = new ArrayList(list2.size());
        boolean z2 = false;
        this.jUn = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.jUj.addAll(list);
        if (!z) {
            this.jUj.add(this.jUj.size(), this.jUi);
        }
        this.jUl.addAll(list2);
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (c(aVar) != 13) {
            bk("acceptHandshakeAsServer - Wrong websocket version.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String Gi = aVar.Gi("Sec-WebSocket-Extensions");
        Iterator<b> it = this.jUj.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.Ge(Gi)) {
                this.jUi = next;
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                bk("acceptHandshakeAsServer - Matching extension found: " + this.jUi.toString());
                handshakeState2 = handshakeState3;
                break;
            }
        }
        Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
        String Gi2 = aVar.Gi("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.jUl.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState4;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.Gk(Gi2)) {
                this.jUk = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                bk("acceptHandshakeAsServer - Matching protocol found: " + this.jUk.toString());
                break;
            }
        }
        if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
            return Draft.HandshakeState.MATCHED;
        }
        bk("acceptHandshakeAsServer - No matching extension or protocol found.");
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar, h hVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (!b(hVar)) {
            bk("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return Draft.HandshakeState.NOT_MATCHED;
        } else if (!aVar.Gj("Sec-WebSocket-Key") || !hVar.Gj("Sec-WebSocket-Accept")) {
            bk("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return Draft.HandshakeState.NOT_MATCHED;
        } else {
            if (!Gd(aVar.Gi("Sec-WebSocket-Key")).equals(hVar.Gi("Sec-WebSocket-Accept"))) {
                bk("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String Gi = hVar.Gi("Sec-WebSocket-Extensions");
            Iterator<b> it = this.jUj.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.Gf(Gi)) {
                    this.jUi = next;
                    Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                    bk("acceptHandshakeAsClient - Matching extension found: " + this.jUi.toString());
                    handshakeState2 = handshakeState3;
                    break;
                }
            }
            Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
            String Gi2 = hVar.Gi("Sec-WebSocket-Protocol");
            Iterator<org.java_websocket.d.a> it2 = this.jUl.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    handshakeState = handshakeState4;
                    break;
                }
                org.java_websocket.d.a next2 = it2.next();
                if (next2.Gk(Gi2)) {
                    this.jUk = next2;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    bk("acceptHandshakeAsClient - Matching protocol found: " + this.jUk.toString());
                    break;
                }
            }
            if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
                return Draft.HandshakeState.MATCHED;
            }
            bk("acceptHandshakeAsClient - No matching extension or protocol found.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
    }

    public b cCS() {
        return this.jUi;
    }

    public List<b> cCT() {
        return this.jUj;
    }

    public org.java_websocket.d.a cCU() {
        return this.jUk;
    }

    public List<org.java_websocket.d.a> cCV() {
        return this.jUl;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.jUp.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.jUj) {
            if (bVar2.cCY() != null && bVar2.cCY().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.cCY());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.jUl) {
            if (aVar.cDl().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.cDl());
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
        iVar.put(HTTP.CONN_DIRECTIVE, aVar.Gi(HTTP.CONN_DIRECTIVE));
        String Gi = aVar.Gi("Sec-WebSocket-Key");
        if (Gi == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", Gd(Gi));
        if (cCS().cCZ().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", cCS().cCZ());
        }
        if (cCU() != null && cCU().cDl().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", cCU().cDl());
        }
        iVar.Gh("Web Socket Protocol Handshake");
        iVar.put(HTTP.SERVER_HEADER, "TooTallNate Java-WebSocket");
        iVar.put(HTTP.DATE_HEADER, cCW());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft cCR() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : cCT()) {
            arrayList.add(bVar.cDa());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : cCV()) {
            arrayList2.add(aVar.cDm());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        cCS().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.cDd().remaining() + "): {" + (framedata.cDd().remaining() > 1000 ? "too big to display" : new String(framedata.cDd().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer cDd = framedata.cDd();
        boolean z = this.jTT == WebSocket.Role.CLIENT;
        if (cDd.remaining() <= 125) {
            i = 1;
        } else {
            i = cDd.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + cDd.remaining());
        allocate.put((byte) (((byte) (framedata.cDe() ? -128 : 0)) | a(framedata.cDi())));
        byte[] x = x(cDd.remaining(), i);
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
                allocate2.putInt(this.jUp.nextInt());
                allocate.put(allocate2.array());
                while (cDd.hasRemaining()) {
                    allocate.put((byte) (cDd.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(cDd);
                cDd.flip();
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
        ByteBuffer allocate = ByteBuffer.allocate(Dn(b));
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
        cCS().e(b5);
        cCS().c(b5);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b5.cDd().remaining() + "): {" + (b5.cDd().remaining() > 1000 ? "too big to display" : new String(b5.cDd().array())) + '}');
        }
        b5.cDb();
        return b5;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> q(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.jUo == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.jUo.remaining();
                if (remaining2 > remaining) {
                    this.jUo.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.jUo.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(s((ByteBuffer) this.jUo.duplicate().position(0)));
                this.jUo = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(Dn(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.jUo.limit()) {
                    throw new AssertionError();
                }
                this.jUo.rewind();
                allocate.put(this.jUo);
                this.jUo = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(s(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.jUo = ByteBuffer.allocate(Dn(e2.getPreferredSize()));
                this.jUo.put(byteBuffer);
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
            aVar.cDb();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> ay(String str, boolean z) {
        org.java_websocket.framing.i iVar = new org.java_websocket.framing.i();
        iVar.t(ByteBuffer.wrap(org.java_websocket.e.c.Gl(str)));
        iVar.rK(z);
        try {
            iVar.cDb();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.jUo = null;
        if (this.jUi != null) {
            this.jUi.reset();
        }
        this.jUi = new org.java_websocket.b.a();
        this.jUk = null;
    }

    private String cCW() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String Gd(String str) {
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
        Framedata.Opcode cDi = framedata.cDi();
        if (cDi == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.i(i, str, true);
            } else if (cCQ() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.h(i, str, true);
            } else {
                cVar.j(i, str, false);
            }
        } else if (cDi == Framedata.Opcode.PING) {
            cVar.cCP().onWebsocketPing(cVar, framedata);
        } else if (cDi == Framedata.Opcode.PONG) {
            cVar.cCO();
            cVar.cCP().onWebsocketPong(cVar, framedata);
        } else if (!framedata.cDe() || cDi == Framedata.Opcode.CONTINUOUS) {
            if (cDi != Framedata.Opcode.CONTINUOUS) {
                if (this.jUm != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.jUm = framedata;
                this.jUn.add(framedata.cDd());
            } else if (framedata.cDe()) {
                if (this.jUm == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.jUn.add(framedata.cDd());
                if (this.jUm.cDi() == Framedata.Opcode.TEXT) {
                    ((f) this.jUm).t(cCX());
                    ((f) this.jUm).cDb();
                    try {
                        cVar.cCP().onWebsocketMessage(cVar, org.java_websocket.e.c.u(this.jUm.cDd()));
                    } catch (RuntimeException e) {
                        cVar.cCP().onWebsocketError(cVar, e);
                    }
                } else if (this.jUm.cDi() == Framedata.Opcode.BINARY) {
                    ((f) this.jUm).t(cCX());
                    ((f) this.jUm).cDb();
                    try {
                        cVar.cCP().onWebsocketMessage(cVar, this.jUm.cDd());
                    } catch (RuntimeException e2) {
                        cVar.cCP().onWebsocketError(cVar, e2);
                    }
                }
                this.jUm = null;
                this.jUn.clear();
            } else if (this.jUm == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (cDi == Framedata.Opcode.TEXT && !org.java_websocket.e.c.v(framedata.cDd())) {
                throw new InvalidDataException(PointerIconCompat.TYPE_CROSSHAIR);
            }
            if (cDi == Framedata.Opcode.CONTINUOUS && this.jUm != null) {
                this.jUn.add(framedata.cDd());
            }
        } else if (this.jUm != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (cDi == Framedata.Opcode.TEXT) {
                try {
                    cVar.cCP().onWebsocketMessage(cVar, org.java_websocket.e.c.u(framedata.cDd()));
                } catch (RuntimeException e3) {
                    cVar.cCP().onWebsocketError(cVar, e3);
                }
            } else if (cDi == Framedata.Opcode.BINARY) {
                try {
                    cVar.cCP().onWebsocketMessage(cVar, framedata.cDd());
                } catch (RuntimeException e4) {
                    cVar.cCP().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType cCQ() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (cCS() != null) {
            draft = draft + " extension: " + cCS().toString();
        }
        if (cCU() != null) {
            return draft + " protocol: " + cCU().toString();
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
        if (this.jUi == null ? aVar.jUi != null : !this.jUi.equals(aVar.jUi)) {
            return false;
        }
        return this.jUk != null ? this.jUk.equals(aVar.jUk) : aVar.jUk == null;
    }

    public int hashCode() {
        return ((this.jUi != null ? this.jUi.hashCode() : 0) * 31) + (this.jUk != null ? this.jUk.hashCode() : 0);
    }

    private ByteBuffer cCX() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.jUn.iterator();
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
        for (ByteBuffer byteBuffer : this.jUn) {
            allocate.put(byteBuffer);
        }
        allocate.flip();
        return allocate;
    }

    private static void bk(Object obj) {
        if (org.java_websocket.c.DEBUG) {
            System.out.println(obj);
        }
    }
}
