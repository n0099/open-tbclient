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
    private b nZX;
    private List<b> nZY;
    private org.java_websocket.d.a nZZ;
    private List<org.java_websocket.d.a> oaa;
    private Framedata oab;
    private List<ByteBuffer> oac;
    private ByteBuffer oad;
    private final Random oae;

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
        this.nZX = new org.java_websocket.b.a();
        this.oae = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.nZY = new ArrayList(list.size());
        this.oaa = new ArrayList(list2.size());
        boolean z2 = false;
        this.oac = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.nZY.addAll(list);
        if (!z) {
            this.nZY.add(this.nZY.size(), this.nZX);
        }
        this.oaa.addAll(list2);
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (c(aVar) != 13) {
            bP("acceptHandshakeAsServer - Wrong websocket version.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String SJ = aVar.SJ("Sec-WebSocket-Extensions");
        Iterator<b> it = this.nZY.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.SF(SJ)) {
                this.nZX = next;
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                bP("acceptHandshakeAsServer - Matching extension found: " + this.nZX.toString());
                handshakeState2 = handshakeState3;
                break;
            }
        }
        Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
        String SJ2 = aVar.SJ("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.oaa.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState4;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.SL(SJ2)) {
                this.nZZ = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                bP("acceptHandshakeAsServer - Matching protocol found: " + this.nZZ.toString());
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
        } else if (!aVar.SK("Sec-WebSocket-Key") || !hVar.SK("Sec-WebSocket-Accept")) {
            bP("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return Draft.HandshakeState.NOT_MATCHED;
        } else {
            if (!SE(aVar.SJ("Sec-WebSocket-Key")).equals(hVar.SJ("Sec-WebSocket-Accept"))) {
                bP("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String SJ = hVar.SJ("Sec-WebSocket-Extensions");
            Iterator<b> it = this.nZY.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.SG(SJ)) {
                    this.nZX = next;
                    Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                    bP("acceptHandshakeAsClient - Matching extension found: " + this.nZX.toString());
                    handshakeState2 = handshakeState3;
                    break;
                }
            }
            Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
            String SJ2 = hVar.SJ("Sec-WebSocket-Protocol");
            Iterator<org.java_websocket.d.a> it2 = this.oaa.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    handshakeState = handshakeState4;
                    break;
                }
                org.java_websocket.d.a next2 = it2.next();
                if (next2.SL(SJ2)) {
                    this.nZZ = next2;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    bP("acceptHandshakeAsClient - Matching protocol found: " + this.nZZ.toString());
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

    public b dTF() {
        return this.nZX;
    }

    public List<b> dTG() {
        return this.nZY;
    }

    public org.java_websocket.d.a dTH() {
        return this.nZZ;
    }

    public List<org.java_websocket.d.a> dTI() {
        return this.oaa;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.oae.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.nZY) {
            if (bVar2.dTL() != null && bVar2.dTL().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.dTL());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.oaa) {
            if (aVar.dTX().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.dTX());
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
        iVar.put(HTTP.CONN_DIRECTIVE, aVar.SJ(HTTP.CONN_DIRECTIVE));
        String SJ = aVar.SJ("Sec-WebSocket-Key");
        if (SJ == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", SE(SJ));
        if (dTF().dTM().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", dTF().dTM());
        }
        if (dTH() != null && dTH().dTX().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", dTH().dTX());
        }
        iVar.SI("Web Socket Protocol Handshake");
        iVar.put("Server", "TooTallNate Java-WebSocket");
        iVar.put("Date", dTJ());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft dTE() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : dTG()) {
            arrayList.add(bVar.dTN());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : dTI()) {
            arrayList2.add(aVar.dTY());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        dTF().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.dTQ().remaining() + "): {" + (framedata.dTQ().remaining() > 1000 ? "too big to display" : new String(framedata.dTQ().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer dTQ = framedata.dTQ();
        boolean z = this.nZI == WebSocket.Role.CLIENT;
        if (dTQ.remaining() <= 125) {
            i = 1;
        } else {
            i = dTQ.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + dTQ.remaining());
        allocate.put((byte) (((byte) (framedata.XQ() ? -128 : 0)) | a(framedata.dTU())));
        byte[] C = C(dTQ.remaining(), i);
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
                allocate2.putInt(this.oae.nextInt());
                allocate.put(allocate2.array());
                while (dTQ.hasRemaining()) {
                    allocate.put((byte) (dTQ.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(dTQ);
                dTQ.flip();
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
        dTF().e(b5);
        dTF().c(b5);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b5.dTQ().remaining() + "): {" + (b5.dTQ().remaining() > 1000 ? "too big to display" : new String(b5.dTQ().array())) + '}');
        }
        b5.dTO();
        return b5;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> w(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.oad == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.oad.remaining();
                if (remaining2 > remaining) {
                    this.oad.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.oad.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(y((ByteBuffer) this.oad.duplicate().position(0)));
                this.oad = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(Ls(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.oad.limit()) {
                    throw new AssertionError();
                }
                this.oad.rewind();
                allocate.put(this.oad);
                this.oad = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(y(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.oad = ByteBuffer.allocate(Ls(e2.getPreferredSize()));
                this.oad.put(byteBuffer);
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
            aVar.dTO();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> bf(String str, boolean z) {
        org.java_websocket.framing.i iVar = new org.java_websocket.framing.i();
        iVar.z(ByteBuffer.wrap(org.java_websocket.e.c.SM(str)));
        iVar.xF(z);
        try {
            iVar.dTO();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.oad = null;
        if (this.nZX != null) {
            this.nZX.reset();
        }
        this.nZX = new org.java_websocket.b.a();
        this.nZZ = null;
    }

    private String dTJ() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String SE(String str) {
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
        Framedata.Opcode dTU = framedata.dTU();
        if (dTU == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.p(i, str, true);
            } else if (dTD() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.o(i, str, true);
            } else {
                cVar.q(i, str, false);
            }
        } else if (dTU == Framedata.Opcode.PING) {
            cVar.dTC().onWebsocketPing(cVar, framedata);
        } else if (dTU == Framedata.Opcode.PONG) {
            cVar.dTB();
            cVar.dTC().onWebsocketPong(cVar, framedata);
        } else if (!framedata.XQ() || dTU == Framedata.Opcode.CONTINUOUS) {
            if (dTU != Framedata.Opcode.CONTINUOUS) {
                if (this.oab != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.oab = framedata;
                this.oac.add(framedata.dTQ());
            } else if (framedata.XQ()) {
                if (this.oab == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.oac.add(framedata.dTQ());
                if (this.oab.dTU() == Framedata.Opcode.TEXT) {
                    ((f) this.oab).z(dTK());
                    ((f) this.oab).dTO();
                    try {
                        cVar.dTC().onWebsocketMessage(cVar, org.java_websocket.e.c.A(this.oab.dTQ()));
                    } catch (RuntimeException e) {
                        cVar.dTC().onWebsocketError(cVar, e);
                    }
                } else if (this.oab.dTU() == Framedata.Opcode.BINARY) {
                    ((f) this.oab).z(dTK());
                    ((f) this.oab).dTO();
                    try {
                        cVar.dTC().onWebsocketMessage(cVar, this.oab.dTQ());
                    } catch (RuntimeException e2) {
                        cVar.dTC().onWebsocketError(cVar, e2);
                    }
                }
                this.oab = null;
                this.oac.clear();
            } else if (this.oab == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (dTU == Framedata.Opcode.TEXT && !org.java_websocket.e.c.B(framedata.dTQ())) {
                throw new InvalidDataException(1007);
            }
            if (dTU == Framedata.Opcode.CONTINUOUS && this.oab != null) {
                this.oac.add(framedata.dTQ());
            }
        } else if (this.oab != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (dTU == Framedata.Opcode.TEXT) {
                try {
                    cVar.dTC().onWebsocketMessage(cVar, org.java_websocket.e.c.A(framedata.dTQ()));
                } catch (RuntimeException e3) {
                    cVar.dTC().onWebsocketError(cVar, e3);
                }
            } else if (dTU == Framedata.Opcode.BINARY) {
                try {
                    cVar.dTC().onWebsocketMessage(cVar, framedata.dTQ());
                } catch (RuntimeException e4) {
                    cVar.dTC().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType dTD() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (dTF() != null) {
            draft = draft + " extension: " + dTF().toString();
        }
        if (dTH() != null) {
            return draft + " protocol: " + dTH().toString();
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
        if (this.nZX == null ? aVar.nZX != null : !this.nZX.equals(aVar.nZX)) {
            return false;
        }
        return this.nZZ != null ? this.nZZ.equals(aVar.nZZ) : aVar.nZZ == null;
    }

    public int hashCode() {
        return ((this.nZX != null ? this.nZX.hashCode() : 0) * 31) + (this.nZZ != null ? this.nZZ.hashCode() : 0);
    }

    private ByteBuffer dTK() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.oac.iterator();
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
        for (ByteBuffer byteBuffer : this.oac) {
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
