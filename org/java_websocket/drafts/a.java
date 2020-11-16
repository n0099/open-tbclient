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
/* loaded from: classes18.dex */
public class a extends Draft {
    static final /* synthetic */ boolean $assertionsDisabled;
    private b qei;
    private List<b> qej;
    private org.java_websocket.d.a qek;
    private List<org.java_websocket.d.a> qel;
    private Framedata qem;
    private List<ByteBuffer> qen;
    private ByteBuffer qeo;
    private final Random qep;

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
        this.qei = new org.java_websocket.b.a();
        this.qep = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.qej = new ArrayList(list.size());
        this.qel = new ArrayList(list2.size());
        boolean z2 = false;
        this.qen = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.qej.addAll(list);
        if (!z) {
            this.qej.add(this.qej.size(), this.qei);
        }
        this.qel.addAll(list2);
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (c(aVar) != 13) {
            cb("acceptHandshakeAsServer - Wrong websocket version.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String ZQ = aVar.ZQ("Sec-WebSocket-Extensions");
        Iterator<b> it = this.qej.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.ZM(ZQ)) {
                this.qei = next;
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                cb("acceptHandshakeAsServer - Matching extension found: " + this.qei.toString());
                handshakeState2 = handshakeState3;
                break;
            }
        }
        Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
        String ZQ2 = aVar.ZQ("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.qel.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState4;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.ZS(ZQ2)) {
                this.qek = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                cb("acceptHandshakeAsServer - Matching protocol found: " + this.qek.toString());
                break;
            }
        }
        if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
            return Draft.HandshakeState.MATCHED;
        }
        cb("acceptHandshakeAsServer - No matching extension or protocol found.");
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar, h hVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (!b(hVar)) {
            cb("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return Draft.HandshakeState.NOT_MATCHED;
        } else if (!aVar.ZR("Sec-WebSocket-Key") || !hVar.ZR("Sec-WebSocket-Accept")) {
            cb("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return Draft.HandshakeState.NOT_MATCHED;
        } else {
            if (!ZL(aVar.ZQ("Sec-WebSocket-Key")).equals(hVar.ZQ("Sec-WebSocket-Accept"))) {
                cb("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String ZQ = hVar.ZQ("Sec-WebSocket-Extensions");
            Iterator<b> it = this.qej.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.ZN(ZQ)) {
                    this.qei = next;
                    Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                    cb("acceptHandshakeAsClient - Matching extension found: " + this.qei.toString());
                    handshakeState2 = handshakeState3;
                    break;
                }
            }
            Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
            String ZQ2 = hVar.ZQ("Sec-WebSocket-Protocol");
            Iterator<org.java_websocket.d.a> it2 = this.qel.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    handshakeState = handshakeState4;
                    break;
                }
                org.java_websocket.d.a next2 = it2.next();
                if (next2.ZS(ZQ2)) {
                    this.qek = next2;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    cb("acceptHandshakeAsClient - Matching protocol found: " + this.qek.toString());
                    break;
                }
            }
            if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
                return Draft.HandshakeState.MATCHED;
            }
            cb("acceptHandshakeAsClient - No matching extension or protocol found.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
    }

    public b eEM() {
        return this.qei;
    }

    public List<b> eEN() {
        return this.qej;
    }

    public org.java_websocket.d.a eEO() {
        return this.qek;
    }

    public List<org.java_websocket.d.a> eEP() {
        return this.qel;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.qep.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.qej) {
            if (bVar2.eES() != null && bVar2.eES().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.eES());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.qel) {
            if (aVar.eFe().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.eFe());
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
        iVar.put(HTTP.CONN_DIRECTIVE, aVar.ZQ(HTTP.CONN_DIRECTIVE));
        String ZQ = aVar.ZQ("Sec-WebSocket-Key");
        if (ZQ == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", ZL(ZQ));
        if (eEM().eET().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", eEM().eET());
        }
        if (eEO() != null && eEO().eFe().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", eEO().eFe());
        }
        iVar.ZP("Web Socket Protocol Handshake");
        iVar.put("Server", "TooTallNate Java-WebSocket");
        iVar.put("Date", eEQ());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft eEL() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : eEN()) {
            arrayList.add(bVar.eEU());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : eEP()) {
            arrayList2.add(aVar.eFf());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        eEM().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.eEX().remaining() + "): {" + (framedata.eEX().remaining() > 1000 ? "too big to display" : new String(framedata.eEX().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer eEX = framedata.eEX();
        boolean z = this.qdT == WebSocket.Role.CLIENT;
        if (eEX.remaining() <= 125) {
            i = 1;
        } else {
            i = eEX.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + eEX.remaining());
        allocate.put((byte) (((byte) (framedata.alJ() ? -128 : 0)) | a(framedata.eFb())));
        byte[] O = O(eEX.remaining(), i);
        if ($assertionsDisabled || O.length == i) {
            if (i == 1) {
                allocate.put((byte) (O[0] | (z ? Byte.MIN_VALUE : (byte) 0)));
            } else if (i == 2) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | 126));
                allocate.put(O);
            } else if (i == 8) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | Byte.MAX_VALUE));
                allocate.put(O);
            } else {
                throw new RuntimeException("Size representation not supported/specified");
            }
            if (z) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.putInt(this.qep.nextInt());
                allocate.put(allocate2.array());
                while (eEX.hasRemaining()) {
                    allocate.put((byte) (eEX.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(eEX);
                eEX.flip();
            }
            if ($assertionsDisabled || allocate.remaining() == 0) {
                allocate.flip();
                return allocate;
            }
            throw new AssertionError(allocate.remaining());
        }
        throw new AssertionError();
    }

    public Framedata A(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
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
        ByteBuffer allocate = ByteBuffer.allocate(Sp(b));
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
        b5.eE(z3);
        b5.Bq(z);
        b5.Br(z2);
        b5.Bs(z4);
        allocate.flip();
        b5.B(allocate);
        eEM().e(b5);
        eEM().c(b5);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b5.eEX().remaining() + "): {" + (b5.eEX().remaining() > 1000 ? "too big to display" : new String(b5.eEX().array())) + '}');
        }
        b5.eEV();
        return b5;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> y(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.qeo == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.qeo.remaining();
                if (remaining2 > remaining) {
                    this.qeo.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.qeo.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(A((ByteBuffer) this.qeo.duplicate().position(0)));
                this.qeo = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(Sp(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.qeo.limit()) {
                    throw new AssertionError();
                }
                this.qeo.rewind();
                allocate.put(this.qeo);
                this.qeo = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(A(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.qeo = ByteBuffer.allocate(Sp(e2.getPreferredSize()));
                this.qeo.put(byteBuffer);
            }
        }
        return linkedList;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> b(ByteBuffer byteBuffer, boolean z) {
        org.java_websocket.framing.a aVar = new org.java_websocket.framing.a();
        aVar.B(byteBuffer);
        aVar.Bt(z);
        try {
            aVar.eEV();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> bt(String str, boolean z) {
        org.java_websocket.framing.i iVar = new org.java_websocket.framing.i();
        iVar.B(ByteBuffer.wrap(org.java_websocket.e.c.ZT(str)));
        iVar.Bt(z);
        try {
            iVar.eEV();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.qeo = null;
        if (this.qei != null) {
            this.qei.reset();
        }
        this.qei = new org.java_websocket.b.a();
        this.qek = null;
    }

    private String eEQ() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String ZL(String str) {
        try {
            return org.java_websocket.e.a.encodeBytes(MessageDigest.getInstance("SHA1").digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    private byte[] O(long j, int i) {
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
        Framedata.Opcode eFb = framedata.eFb();
        if (eFb == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.q(i, str, true);
            } else if (eEK() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.p(i, str, true);
            } else {
                cVar.r(i, str, false);
            }
        } else if (eFb == Framedata.Opcode.PING) {
            cVar.eEJ().onWebsocketPing(cVar, framedata);
        } else if (eFb == Framedata.Opcode.PONG) {
            cVar.eEI();
            cVar.eEJ().onWebsocketPong(cVar, framedata);
        } else if (!framedata.alJ() || eFb == Framedata.Opcode.CONTINUOUS) {
            if (eFb != Framedata.Opcode.CONTINUOUS) {
                if (this.qem != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.qem = framedata;
                this.qen.add(framedata.eEX());
            } else if (framedata.alJ()) {
                if (this.qem == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.qen.add(framedata.eEX());
                if (this.qem.eFb() == Framedata.Opcode.TEXT) {
                    ((f) this.qem).B(eER());
                    ((f) this.qem).eEV();
                    try {
                        cVar.eEJ().onWebsocketMessage(cVar, org.java_websocket.e.c.C(this.qem.eEX()));
                    } catch (RuntimeException e) {
                        cVar.eEJ().onWebsocketError(cVar, e);
                    }
                } else if (this.qem.eFb() == Framedata.Opcode.BINARY) {
                    ((f) this.qem).B(eER());
                    ((f) this.qem).eEV();
                    try {
                        cVar.eEJ().onWebsocketMessage(cVar, this.qem.eEX());
                    } catch (RuntimeException e2) {
                        cVar.eEJ().onWebsocketError(cVar, e2);
                    }
                }
                this.qem = null;
                this.qen.clear();
            } else if (this.qem == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (eFb == Framedata.Opcode.TEXT && !org.java_websocket.e.c.D(framedata.eEX())) {
                throw new InvalidDataException(1007);
            }
            if (eFb == Framedata.Opcode.CONTINUOUS && this.qem != null) {
                this.qen.add(framedata.eEX());
            }
        } else if (this.qem != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (eFb == Framedata.Opcode.TEXT) {
                try {
                    cVar.eEJ().onWebsocketMessage(cVar, org.java_websocket.e.c.C(framedata.eEX()));
                } catch (RuntimeException e3) {
                    cVar.eEJ().onWebsocketError(cVar, e3);
                }
            } else if (eFb == Framedata.Opcode.BINARY) {
                try {
                    cVar.eEJ().onWebsocketMessage(cVar, framedata.eEX());
                } catch (RuntimeException e4) {
                    cVar.eEJ().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType eEK() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (eEM() != null) {
            draft = draft + " extension: " + eEM().toString();
        }
        if (eEO() != null) {
            return draft + " protocol: " + eEO().toString();
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
        if (this.qei == null ? aVar.qei != null : !this.qei.equals(aVar.qei)) {
            return false;
        }
        return this.qek != null ? this.qek.equals(aVar.qek) : aVar.qek == null;
    }

    public int hashCode() {
        return ((this.qei != null ? this.qei.hashCode() : 0) * 31) + (this.qek != null ? this.qek.hashCode() : 0);
    }

    private ByteBuffer eER() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.qen.iterator();
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
        for (ByteBuffer byteBuffer : this.qen) {
            allocate.put(byteBuffer);
        }
        allocate.flip();
        return allocate;
    }

    private static void cb(Object obj) {
        if (org.java_websocket.c.DEBUG) {
            System.out.println(obj);
        }
    }
}
