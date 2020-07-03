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
    private b nZU;
    private List<b> nZV;
    private org.java_websocket.d.a nZW;
    private List<org.java_websocket.d.a> nZX;
    private Framedata nZY;
    private List<ByteBuffer> nZZ;
    private ByteBuffer oaa;
    private final Random oab;

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
        this.nZU = new org.java_websocket.b.a();
        this.oab = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.nZV = new ArrayList(list.size());
        this.nZX = new ArrayList(list2.size());
        boolean z2 = false;
        this.nZZ = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.nZV.addAll(list);
        if (!z) {
            this.nZV.add(this.nZV.size(), this.nZU);
        }
        this.nZX.addAll(list2);
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (c(aVar) != 13) {
            bP("acceptHandshakeAsServer - Wrong websocket version.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String SI = aVar.SI("Sec-WebSocket-Extensions");
        Iterator<b> it = this.nZV.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.SE(SI)) {
                this.nZU = next;
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                bP("acceptHandshakeAsServer - Matching extension found: " + this.nZU.toString());
                handshakeState2 = handshakeState3;
                break;
            }
        }
        Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
        String SI2 = aVar.SI("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.nZX.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState4;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.SK(SI2)) {
                this.nZW = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                bP("acceptHandshakeAsServer - Matching protocol found: " + this.nZW.toString());
                break;
            }
        }
        if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
            return Draft.HandshakeState.MATCHED;
        }
        bP("acceptHandshakeAsServer - No matching extension or protocol found.");
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar, h hVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (!b(hVar)) {
            bP("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return Draft.HandshakeState.NOT_MATCHED;
        } else if (!aVar.SJ("Sec-WebSocket-Key") || !hVar.SJ("Sec-WebSocket-Accept")) {
            bP("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return Draft.HandshakeState.NOT_MATCHED;
        } else {
            if (!SD(aVar.SI("Sec-WebSocket-Key")).equals(hVar.SI("Sec-WebSocket-Accept"))) {
                bP("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String SI = hVar.SI("Sec-WebSocket-Extensions");
            Iterator<b> it = this.nZV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.SF(SI)) {
                    this.nZU = next;
                    Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                    bP("acceptHandshakeAsClient - Matching extension found: " + this.nZU.toString());
                    handshakeState2 = handshakeState3;
                    break;
                }
            }
            Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
            String SI2 = hVar.SI("Sec-WebSocket-Protocol");
            Iterator<org.java_websocket.d.a> it2 = this.nZX.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    handshakeState = handshakeState4;
                    break;
                }
                org.java_websocket.d.a next2 = it2.next();
                if (next2.SK(SI2)) {
                    this.nZW = next2;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    bP("acceptHandshakeAsClient - Matching protocol found: " + this.nZW.toString());
                    break;
                }
            }
            if (handshakeState == Draft.HandshakeState.MATCHED && handshakeState2 == Draft.HandshakeState.MATCHED) {
                return Draft.HandshakeState.MATCHED;
            }
            bP("acceptHandshakeAsClient - No matching extension or protocol found.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
    }

    public b dTB() {
        return this.nZU;
    }

    public List<b> dTC() {
        return this.nZV;
    }

    public org.java_websocket.d.a dTD() {
        return this.nZW;
    }

    public List<org.java_websocket.d.a> dTE() {
        return this.nZX;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.oab.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.nZV) {
            if (bVar2.dTH() != null && bVar2.dTH().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.dTH());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.nZX) {
            if (aVar.dTT().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.dTT());
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
        iVar.put(HTTP.CONN_DIRECTIVE, aVar.SI(HTTP.CONN_DIRECTIVE));
        String SI = aVar.SI("Sec-WebSocket-Key");
        if (SI == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", SD(SI));
        if (dTB().dTI().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", dTB().dTI());
        }
        if (dTD() != null && dTD().dTT().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", dTD().dTT());
        }
        iVar.SH("Web Socket Protocol Handshake");
        iVar.put("Server", "TooTallNate Java-WebSocket");
        iVar.put("Date", dTF());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft dTA() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : dTC()) {
            arrayList.add(bVar.dTJ());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : dTE()) {
            arrayList2.add(aVar.dTU());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        dTB().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.dTM().remaining() + "): {" + (framedata.dTM().remaining() > 1000 ? "too big to display" : new String(framedata.dTM().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer dTM = framedata.dTM();
        boolean z = this.nZF == WebSocket.Role.CLIENT;
        if (dTM.remaining() <= 125) {
            i = 1;
        } else {
            i = dTM.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + dTM.remaining());
        allocate.put((byte) (((byte) (framedata.XQ() ? -128 : 0)) | a(framedata.dTQ())));
        byte[] C = C(dTM.remaining(), i);
        if ($assertionsDisabled || C.length == i) {
            if (i == 1) {
                allocate.put((byte) (C[0] | (z ? Byte.MIN_VALUE : (byte) 0)));
            } else if (i == 2) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | 126));
                allocate.put(C);
            } else if (i == 8) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | Byte.MAX_VALUE));
                allocate.put(C);
            } else {
                throw new RuntimeException("Size representation not supported/specified");
            }
            if (z) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.putInt(this.oab.nextInt());
                allocate.put(allocate2.array());
                while (dTM.hasRemaining()) {
                    allocate.put((byte) (dTM.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(dTM);
                dTM.flip();
            }
            if ($assertionsDisabled || allocate.remaining() == 0) {
                allocate.flip();
                return allocate;
            }
            throw new AssertionError(allocate.remaining());
        }
        throw new AssertionError();
    }

    public Framedata y(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
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
        ByteBuffer allocate = ByteBuffer.allocate(Ls(b));
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
        b5.dy(z3);
        b5.xC(z);
        b5.xD(z2);
        b5.xE(z4);
        allocate.flip();
        b5.z(allocate);
        dTB().e(b5);
        dTB().c(b5);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b5.dTM().remaining() + "): {" + (b5.dTM().remaining() > 1000 ? "too big to display" : new String(b5.dTM().array())) + '}');
        }
        b5.dTK();
        return b5;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> w(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.oaa == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.oaa.remaining();
                if (remaining2 > remaining) {
                    this.oaa.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.oaa.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(y((ByteBuffer) this.oaa.duplicate().position(0)));
                this.oaa = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(Ls(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.oaa.limit()) {
                    throw new AssertionError();
                }
                this.oaa.rewind();
                allocate.put(this.oaa);
                this.oaa = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(y(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.oaa = ByteBuffer.allocate(Ls(e2.getPreferredSize()));
                this.oaa.put(byteBuffer);
            }
        }
        return linkedList;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> b(ByteBuffer byteBuffer, boolean z) {
        org.java_websocket.framing.a aVar = new org.java_websocket.framing.a();
        aVar.z(byteBuffer);
        aVar.xF(z);
        try {
            aVar.dTK();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> bf(String str, boolean z) {
        org.java_websocket.framing.i iVar = new org.java_websocket.framing.i();
        iVar.z(ByteBuffer.wrap(org.java_websocket.e.c.SL(str)));
        iVar.xF(z);
        try {
            iVar.dTK();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.oaa = null;
        if (this.nZU != null) {
            this.nZU.reset();
        }
        this.nZU = new org.java_websocket.b.a();
        this.nZW = null;
    }

    private String dTF() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String SD(String str) {
        try {
            return org.java_websocket.e.a.encodeBytes(MessageDigest.getInstance("SHA1").digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    private byte[] C(long j, int i) {
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
        Framedata.Opcode dTQ = framedata.dTQ();
        if (dTQ == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.o(i, str, true);
            } else if (dTz() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.n(i, str, true);
            } else {
                cVar.p(i, str, false);
            }
        } else if (dTQ == Framedata.Opcode.PING) {
            cVar.dTy().onWebsocketPing(cVar, framedata);
        } else if (dTQ == Framedata.Opcode.PONG) {
            cVar.dTx();
            cVar.dTy().onWebsocketPong(cVar, framedata);
        } else if (!framedata.XQ() || dTQ == Framedata.Opcode.CONTINUOUS) {
            if (dTQ != Framedata.Opcode.CONTINUOUS) {
                if (this.nZY != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.nZY = framedata;
                this.nZZ.add(framedata.dTM());
            } else if (framedata.XQ()) {
                if (this.nZY == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.nZZ.add(framedata.dTM());
                if (this.nZY.dTQ() == Framedata.Opcode.TEXT) {
                    ((f) this.nZY).z(dTG());
                    ((f) this.nZY).dTK();
                    try {
                        cVar.dTy().onWebsocketMessage(cVar, org.java_websocket.e.c.A(this.nZY.dTM()));
                    } catch (RuntimeException e) {
                        cVar.dTy().onWebsocketError(cVar, e);
                    }
                } else if (this.nZY.dTQ() == Framedata.Opcode.BINARY) {
                    ((f) this.nZY).z(dTG());
                    ((f) this.nZY).dTK();
                    try {
                        cVar.dTy().onWebsocketMessage(cVar, this.nZY.dTM());
                    } catch (RuntimeException e2) {
                        cVar.dTy().onWebsocketError(cVar, e2);
                    }
                }
                this.nZY = null;
                this.nZZ.clear();
            } else if (this.nZY == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (dTQ == Framedata.Opcode.TEXT && !org.java_websocket.e.c.B(framedata.dTM())) {
                throw new InvalidDataException(1007);
            }
            if (dTQ == Framedata.Opcode.CONTINUOUS && this.nZY != null) {
                this.nZZ.add(framedata.dTM());
            }
        } else if (this.nZY != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (dTQ == Framedata.Opcode.TEXT) {
                try {
                    cVar.dTy().onWebsocketMessage(cVar, org.java_websocket.e.c.A(framedata.dTM()));
                } catch (RuntimeException e3) {
                    cVar.dTy().onWebsocketError(cVar, e3);
                }
            } else if (dTQ == Framedata.Opcode.BINARY) {
                try {
                    cVar.dTy().onWebsocketMessage(cVar, framedata.dTM());
                } catch (RuntimeException e4) {
                    cVar.dTy().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType dTz() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (dTB() != null) {
            draft = draft + " extension: " + dTB().toString();
        }
        if (dTD() != null) {
            return draft + " protocol: " + dTD().toString();
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
        if (this.nZU == null ? aVar.nZU != null : !this.nZU.equals(aVar.nZU)) {
            return false;
        }
        return this.nZW != null ? this.nZW.equals(aVar.nZW) : aVar.nZW == null;
    }

    public int hashCode() {
        return ((this.nZU != null ? this.nZU.hashCode() : 0) * 31) + (this.nZW != null ? this.nZW.hashCode() : 0);
    }

    private ByteBuffer dTG() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.nZZ.iterator();
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
        for (ByteBuffer byteBuffer : this.nZZ) {
            allocate.put(byteBuffer);
        }
        allocate.flip();
        return allocate;
    }

    private static void bP(Object obj) {
        if (org.java_websocket.c.DEBUG) {
            System.out.println(obj);
        }
    }
}
