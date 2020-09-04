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
    private b oCX;
    private List<b> oCY;
    private org.java_websocket.d.a oCZ;
    private List<org.java_websocket.d.a> oDa;
    private Framedata oDb;
    private List<ByteBuffer> oDc;
    private ByteBuffer oDd;
    private final Random oDe;

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
        this.oCX = new org.java_websocket.b.a();
        this.oDe = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.oCY = new ArrayList(list.size());
        this.oDa = new ArrayList(list2.size());
        boolean z2 = false;
        this.oDc = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.oCY.addAll(list);
        if (!z) {
            this.oCY.add(this.oCY.size(), this.oCX);
        }
        this.oDa.addAll(list2);
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (c(aVar) != 13) {
            bT("acceptHandshakeAsServer - Wrong websocket version.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String Wy = aVar.Wy("Sec-WebSocket-Extensions");
        Iterator<b> it = this.oCY.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.Wu(Wy)) {
                this.oCX = next;
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                bT("acceptHandshakeAsServer - Matching extension found: " + this.oCX.toString());
                handshakeState2 = handshakeState3;
                break;
            }
        }
        Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
        String Wy2 = aVar.Wy("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.oDa.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState4;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.WA(Wy2)) {
                this.oCZ = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                bT("acceptHandshakeAsServer - Matching protocol found: " + this.oCZ.toString());
                break;
            }
        }
        if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
            return Draft.HandshakeState.MATCHED;
        }
        bT("acceptHandshakeAsServer - No matching extension or protocol found.");
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar, h hVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (!b(hVar)) {
            bT("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return Draft.HandshakeState.NOT_MATCHED;
        } else if (!aVar.Wz("Sec-WebSocket-Key") || !hVar.Wz("Sec-WebSocket-Accept")) {
            bT("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return Draft.HandshakeState.NOT_MATCHED;
        } else {
            if (!Wt(aVar.Wy("Sec-WebSocket-Key")).equals(hVar.Wy("Sec-WebSocket-Accept"))) {
                bT("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String Wy = hVar.Wy("Sec-WebSocket-Extensions");
            Iterator<b> it = this.oCY.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.Wv(Wy)) {
                    this.oCX = next;
                    Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                    bT("acceptHandshakeAsClient - Matching extension found: " + this.oCX.toString());
                    handshakeState2 = handshakeState3;
                    break;
                }
            }
            Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
            String Wy2 = hVar.Wy("Sec-WebSocket-Protocol");
            Iterator<org.java_websocket.d.a> it2 = this.oDa.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    handshakeState = handshakeState4;
                    break;
                }
                org.java_websocket.d.a next2 = it2.next();
                if (next2.WA(Wy2)) {
                    this.oCZ = next2;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    bT("acceptHandshakeAsClient - Matching protocol found: " + this.oCZ.toString());
                    break;
                }
            }
            if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
                return Draft.HandshakeState.MATCHED;
            }
            bT("acceptHandshakeAsClient - No matching extension or protocol found.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
    }

    public b ejp() {
        return this.oCX;
    }

    public List<b> ejq() {
        return this.oCY;
    }

    public org.java_websocket.d.a ejr() {
        return this.oCZ;
    }

    public List<org.java_websocket.d.a> ejs() {
        return this.oDa;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.oDe.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.oCY) {
            if (bVar2.ejv() != null && bVar2.ejv().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.ejv());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.oDa) {
            if (aVar.ejH().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.ejH());
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
        iVar.put(HTTP.CONN_DIRECTIVE, aVar.Wy(HTTP.CONN_DIRECTIVE));
        String Wy = aVar.Wy("Sec-WebSocket-Key");
        if (Wy == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", Wt(Wy));
        if (ejp().ejw().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", ejp().ejw());
        }
        if (ejr() != null && ejr().ejH().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", ejr().ejH());
        }
        iVar.Wx("Web Socket Protocol Handshake");
        iVar.put("Server", "TooTallNate Java-WebSocket");
        iVar.put("Date", ejt());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft ejo() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : ejq()) {
            arrayList.add(bVar.ejx());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : ejs()) {
            arrayList2.add(aVar.ejI());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        ejp().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.ejA().remaining() + "): {" + (framedata.ejA().remaining() > 1000 ? "too big to display" : new String(framedata.ejA().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer ejA = framedata.ejA();
        boolean z = this.oCI == WebSocket.Role.CLIENT;
        if (ejA.remaining() <= 125) {
            i = 1;
        } else {
            i = ejA.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + ejA.remaining());
        allocate.put((byte) (((byte) (framedata.aeC() ? -128 : 0)) | a(framedata.ejE())));
        byte[] D = D(ejA.remaining(), i);
        if ($assertionsDisabled || D.length == i) {
            if (i == 1) {
                allocate.put((byte) (D[0] | (z ? Byte.MIN_VALUE : (byte) 0)));
            } else if (i == 2) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | 126));
                allocate.put(D);
            } else if (i == 8) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | Byte.MAX_VALUE));
                allocate.put(D);
            } else {
                throw new RuntimeException("Size representation not supported/specified");
            }
            if (z) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.putInt(this.oDe.nextInt());
                allocate.put(allocate2.array());
                while (ejA.hasRemaining()) {
                    allocate.put((byte) (ejA.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(ejA);
                ejA.flip();
            }
            if ($assertionsDisabled || allocate.remaining() == 0) {
                allocate.flip();
                return allocate;
            }
            throw new AssertionError(allocate.remaining());
        }
        throw new AssertionError();
    }

    public Framedata z(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
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
        ByteBuffer allocate = ByteBuffer.allocate(Op(b));
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
        b5.dL(z3);
        b5.zb(z);
        b5.zc(z2);
        b5.zd(z4);
        allocate.flip();
        b5.A(allocate);
        ejp().e(b5);
        ejp().c(b5);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b5.ejA().remaining() + "): {" + (b5.ejA().remaining() > 1000 ? "too big to display" : new String(b5.ejA().array())) + '}');
        }
        b5.ejy();
        return b5;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> x(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.oDd == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.oDd.remaining();
                if (remaining2 > remaining) {
                    this.oDd.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.oDd.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(z((ByteBuffer) this.oDd.duplicate().position(0)));
                this.oDd = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(Op(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.oDd.limit()) {
                    throw new AssertionError();
                }
                this.oDd.rewind();
                allocate.put(this.oDd);
                this.oDd = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(z(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.oDd = ByteBuffer.allocate(Op(e2.getPreferredSize()));
                this.oDd.put(byteBuffer);
            }
        }
        return linkedList;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> b(ByteBuffer byteBuffer, boolean z) {
        org.java_websocket.framing.a aVar = new org.java_websocket.framing.a();
        aVar.A(byteBuffer);
        aVar.ze(z);
        try {
            aVar.ejy();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> bg(String str, boolean z) {
        org.java_websocket.framing.i iVar = new org.java_websocket.framing.i();
        iVar.A(ByteBuffer.wrap(org.java_websocket.e.c.WB(str)));
        iVar.ze(z);
        try {
            iVar.ejy();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.oDd = null;
        if (this.oCX != null) {
            this.oCX.reset();
        }
        this.oCX = new org.java_websocket.b.a();
        this.oCZ = null;
    }

    private String ejt() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String Wt(String str) {
        try {
            return org.java_websocket.e.a.encodeBytes(MessageDigest.getInstance("SHA1").digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    private byte[] D(long j, int i) {
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
        Framedata.Opcode ejE = framedata.ejE();
        if (ejE == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.o(i, str, true);
            } else if (ejn() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.n(i, str, true);
            } else {
                cVar.p(i, str, false);
            }
        } else if (ejE == Framedata.Opcode.PING) {
            cVar.ejm().onWebsocketPing(cVar, framedata);
        } else if (ejE == Framedata.Opcode.PONG) {
            cVar.ejl();
            cVar.ejm().onWebsocketPong(cVar, framedata);
        } else if (!framedata.aeC() || ejE == Framedata.Opcode.CONTINUOUS) {
            if (ejE != Framedata.Opcode.CONTINUOUS) {
                if (this.oDb != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.oDb = framedata;
                this.oDc.add(framedata.ejA());
            } else if (framedata.aeC()) {
                if (this.oDb == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.oDc.add(framedata.ejA());
                if (this.oDb.ejE() == Framedata.Opcode.TEXT) {
                    ((f) this.oDb).A(eju());
                    ((f) this.oDb).ejy();
                    try {
                        cVar.ejm().onWebsocketMessage(cVar, org.java_websocket.e.c.B(this.oDb.ejA()));
                    } catch (RuntimeException e) {
                        cVar.ejm().onWebsocketError(cVar, e);
                    }
                } else if (this.oDb.ejE() == Framedata.Opcode.BINARY) {
                    ((f) this.oDb).A(eju());
                    ((f) this.oDb).ejy();
                    try {
                        cVar.ejm().onWebsocketMessage(cVar, this.oDb.ejA());
                    } catch (RuntimeException e2) {
                        cVar.ejm().onWebsocketError(cVar, e2);
                    }
                }
                this.oDb = null;
                this.oDc.clear();
            } else if (this.oDb == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (ejE == Framedata.Opcode.TEXT && !org.java_websocket.e.c.C(framedata.ejA())) {
                throw new InvalidDataException(1007);
            }
            if (ejE == Framedata.Opcode.CONTINUOUS && this.oDb != null) {
                this.oDc.add(framedata.ejA());
            }
        } else if (this.oDb != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (ejE == Framedata.Opcode.TEXT) {
                try {
                    cVar.ejm().onWebsocketMessage(cVar, org.java_websocket.e.c.B(framedata.ejA()));
                } catch (RuntimeException e3) {
                    cVar.ejm().onWebsocketError(cVar, e3);
                }
            } else if (ejE == Framedata.Opcode.BINARY) {
                try {
                    cVar.ejm().onWebsocketMessage(cVar, framedata.ejA());
                } catch (RuntimeException e4) {
                    cVar.ejm().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType ejn() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (ejp() != null) {
            draft = draft + " extension: " + ejp().toString();
        }
        if (ejr() != null) {
            return draft + " protocol: " + ejr().toString();
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
        if (this.oCX == null ? aVar.oCX != null : !this.oCX.equals(aVar.oCX)) {
            return false;
        }
        return this.oCZ != null ? this.oCZ.equals(aVar.oCZ) : aVar.oCZ == null;
    }

    public int hashCode() {
        return ((this.oCX != null ? this.oCX.hashCode() : 0) * 31) + (this.oCZ != null ? this.oCZ.hashCode() : 0);
    }

    private ByteBuffer eju() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.oDc.iterator();
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
        for (ByteBuffer byteBuffer : this.oDc) {
            allocate.put(byteBuffer);
        }
        allocate.flip();
        return allocate;
    }

    private static void bT(Object obj) {
        if (org.java_websocket.c.DEBUG) {
            System.out.println(obj);
        }
    }
}
