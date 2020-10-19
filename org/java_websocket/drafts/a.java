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
/* loaded from: classes11.dex */
public class a extends Draft {
    static final /* synthetic */ boolean $assertionsDisabled;
    private b pbS;
    private List<b> pbT;
    private org.java_websocket.d.a pbU;
    private List<org.java_websocket.d.a> pbV;
    private Framedata pbW;
    private List<ByteBuffer> pbX;
    private ByteBuffer pbY;
    private final Random pbZ;

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
        this.pbS = new org.java_websocket.b.a();
        this.pbZ = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.pbT = new ArrayList(list.size());
        this.pbV = new ArrayList(list2.size());
        boolean z2 = false;
        this.pbX = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.pbT.addAll(list);
        if (!z) {
            this.pbT.add(this.pbT.size(), this.pbS);
        }
        this.pbV.addAll(list2);
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (c(aVar) != 13) {
            bW("acceptHandshakeAsServer - Wrong websocket version.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String XO = aVar.XO("Sec-WebSocket-Extensions");
        Iterator<b> it = this.pbT.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.XK(XO)) {
                this.pbS = next;
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                bW("acceptHandshakeAsServer - Matching extension found: " + this.pbS.toString());
                handshakeState2 = handshakeState3;
                break;
            }
        }
        Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
        String XO2 = aVar.XO("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.pbV.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState4;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.XQ(XO2)) {
                this.pbU = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                bW("acceptHandshakeAsServer - Matching protocol found: " + this.pbU.toString());
                break;
            }
        }
        if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
            return Draft.HandshakeState.MATCHED;
        }
        bW("acceptHandshakeAsServer - No matching extension or protocol found.");
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar, h hVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (!b(hVar)) {
            bW("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return Draft.HandshakeState.NOT_MATCHED;
        } else if (!aVar.XP("Sec-WebSocket-Key") || !hVar.XP("Sec-WebSocket-Accept")) {
            bW("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return Draft.HandshakeState.NOT_MATCHED;
        } else {
            if (!XJ(aVar.XO("Sec-WebSocket-Key")).equals(hVar.XO("Sec-WebSocket-Accept"))) {
                bW("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String XO = hVar.XO("Sec-WebSocket-Extensions");
            Iterator<b> it = this.pbT.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.XL(XO)) {
                    this.pbS = next;
                    Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                    bW("acceptHandshakeAsClient - Matching extension found: " + this.pbS.toString());
                    handshakeState2 = handshakeState3;
                    break;
                }
            }
            Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
            String XO2 = hVar.XO("Sec-WebSocket-Protocol");
            Iterator<org.java_websocket.d.a> it2 = this.pbV.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    handshakeState = handshakeState4;
                    break;
                }
                org.java_websocket.d.a next2 = it2.next();
                if (next2.XQ(XO2)) {
                    this.pbU = next2;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    bW("acceptHandshakeAsClient - Matching protocol found: " + this.pbU.toString());
                    break;
                }
            }
            if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
                return Draft.HandshakeState.MATCHED;
            }
            bW("acceptHandshakeAsClient - No matching extension or protocol found.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
    }

    public b eqY() {
        return this.pbS;
    }

    public List<b> eqZ() {
        return this.pbT;
    }

    public org.java_websocket.d.a era() {
        return this.pbU;
    }

    public List<org.java_websocket.d.a> erb() {
        return this.pbV;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.pbZ.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.pbT) {
            if (bVar2.ere() != null && bVar2.ere().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.ere());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.pbV) {
            if (aVar.erq().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.erq());
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
        iVar.put(HTTP.CONN_DIRECTIVE, aVar.XO(HTTP.CONN_DIRECTIVE));
        String XO = aVar.XO("Sec-WebSocket-Key");
        if (XO == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", XJ(XO));
        if (eqY().erf().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", eqY().erf());
        }
        if (era() != null && era().erq().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", era().erq());
        }
        iVar.XN("Web Socket Protocol Handshake");
        iVar.put("Server", "TooTallNate Java-WebSocket");
        iVar.put("Date", erc());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft eqX() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : eqZ()) {
            arrayList.add(bVar.erg());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : erb()) {
            arrayList2.add(aVar.err());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        eqY().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.erj().remaining() + "): {" + (framedata.erj().remaining() > 1000 ? "too big to display" : new String(framedata.erj().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer erj = framedata.erj();
        boolean z = this.pbD == WebSocket.Role.CLIENT;
        if (erj.remaining() <= 125) {
            i = 1;
        } else {
            i = erj.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + erj.remaining());
        allocate.put((byte) (((byte) (framedata.ahX() ? -128 : 0)) | a(framedata.ern())));
        byte[] K = K(erj.remaining(), i);
        if ($assertionsDisabled || K.length == i) {
            if (i == 1) {
                allocate.put((byte) (K[0] | (z ? Byte.MIN_VALUE : (byte) 0)));
            } else if (i == 2) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | 126));
                allocate.put(K);
            } else if (i == 8) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | Byte.MAX_VALUE));
                allocate.put(K);
            } else {
                throw new RuntimeException("Size representation not supported/specified");
            }
            if (z) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.putInt(this.pbZ.nextInt());
                allocate.put(allocate2.array());
                while (erj.hasRemaining()) {
                    allocate.put((byte) (erj.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(erj);
                erj.flip();
            }
            if ($assertionsDisabled || allocate.remaining() == 0) {
                allocate.flip();
                return allocate;
            }
            throw new AssertionError(allocate.remaining());
        }
        throw new AssertionError();
    }

    public Framedata B(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
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
        ByteBuffer allocate = ByteBuffer.allocate(PA(b));
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
        b5.ef(z3);
        b5.zQ(z);
        b5.zR(z2);
        b5.zS(z4);
        allocate.flip();
        b5.C(allocate);
        eqY().e(b5);
        eqY().c(b5);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b5.erj().remaining() + "): {" + (b5.erj().remaining() > 1000 ? "too big to display" : new String(b5.erj().array())) + '}');
        }
        b5.erh();
        return b5;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> z(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.pbY == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.pbY.remaining();
                if (remaining2 > remaining) {
                    this.pbY.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.pbY.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(B((ByteBuffer) this.pbY.duplicate().position(0)));
                this.pbY = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(PA(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.pbY.limit()) {
                    throw new AssertionError();
                }
                this.pbY.rewind();
                allocate.put(this.pbY);
                this.pbY = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(B(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.pbY = ByteBuffer.allocate(PA(e2.getPreferredSize()));
                this.pbY.put(byteBuffer);
            }
        }
        return linkedList;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> b(ByteBuffer byteBuffer, boolean z) {
        org.java_websocket.framing.a aVar = new org.java_websocket.framing.a();
        aVar.C(byteBuffer);
        aVar.zT(z);
        try {
            aVar.erh();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> bl(String str, boolean z) {
        org.java_websocket.framing.i iVar = new org.java_websocket.framing.i();
        iVar.C(ByteBuffer.wrap(org.java_websocket.e.c.XR(str)));
        iVar.zT(z);
        try {
            iVar.erh();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.pbY = null;
        if (this.pbS != null) {
            this.pbS.reset();
        }
        this.pbS = new org.java_websocket.b.a();
        this.pbU = null;
    }

    private String erc() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String XJ(String str) {
        try {
            return org.java_websocket.e.a.encodeBytes(MessageDigest.getInstance("SHA1").digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    private byte[] K(long j, int i) {
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
        Framedata.Opcode ern = framedata.ern();
        if (ern == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.q(i, str, true);
            } else if (eqW() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.p(i, str, true);
            } else {
                cVar.r(i, str, false);
            }
        } else if (ern == Framedata.Opcode.PING) {
            cVar.eqV().onWebsocketPing(cVar, framedata);
        } else if (ern == Framedata.Opcode.PONG) {
            cVar.eqU();
            cVar.eqV().onWebsocketPong(cVar, framedata);
        } else if (!framedata.ahX() || ern == Framedata.Opcode.CONTINUOUS) {
            if (ern != Framedata.Opcode.CONTINUOUS) {
                if (this.pbW != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.pbW = framedata;
                this.pbX.add(framedata.erj());
            } else if (framedata.ahX()) {
                if (this.pbW == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.pbX.add(framedata.erj());
                if (this.pbW.ern() == Framedata.Opcode.TEXT) {
                    ((f) this.pbW).C(erd());
                    ((f) this.pbW).erh();
                    try {
                        cVar.eqV().onWebsocketMessage(cVar, org.java_websocket.e.c.D(this.pbW.erj()));
                    } catch (RuntimeException e) {
                        cVar.eqV().onWebsocketError(cVar, e);
                    }
                } else if (this.pbW.ern() == Framedata.Opcode.BINARY) {
                    ((f) this.pbW).C(erd());
                    ((f) this.pbW).erh();
                    try {
                        cVar.eqV().onWebsocketMessage(cVar, this.pbW.erj());
                    } catch (RuntimeException e2) {
                        cVar.eqV().onWebsocketError(cVar, e2);
                    }
                }
                this.pbW = null;
                this.pbX.clear();
            } else if (this.pbW == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (ern == Framedata.Opcode.TEXT && !org.java_websocket.e.c.E(framedata.erj())) {
                throw new InvalidDataException(1007);
            }
            if (ern == Framedata.Opcode.CONTINUOUS && this.pbW != null) {
                this.pbX.add(framedata.erj());
            }
        } else if (this.pbW != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (ern == Framedata.Opcode.TEXT) {
                try {
                    cVar.eqV().onWebsocketMessage(cVar, org.java_websocket.e.c.D(framedata.erj()));
                } catch (RuntimeException e3) {
                    cVar.eqV().onWebsocketError(cVar, e3);
                }
            } else if (ern == Framedata.Opcode.BINARY) {
                try {
                    cVar.eqV().onWebsocketMessage(cVar, framedata.erj());
                } catch (RuntimeException e4) {
                    cVar.eqV().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType eqW() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (eqY() != null) {
            draft = draft + " extension: " + eqY().toString();
        }
        if (era() != null) {
            return draft + " protocol: " + era().toString();
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
        if (this.pbS == null ? aVar.pbS != null : !this.pbS.equals(aVar.pbS)) {
            return false;
        }
        return this.pbU != null ? this.pbU.equals(aVar.pbU) : aVar.pbU == null;
    }

    public int hashCode() {
        return ((this.pbS != null ? this.pbS.hashCode() : 0) * 31) + (this.pbU != null ? this.pbU.hashCode() : 0);
    }

    private ByteBuffer erd() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.pbX.iterator();
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
        for (ByteBuffer byteBuffer : this.pbX) {
            allocate.put(byteBuffer);
        }
        allocate.flip();
        return allocate;
    }

    private static void bW(Object obj) {
        if (org.java_websocket.c.DEBUG) {
            System.out.println(obj);
        }
    }
}
