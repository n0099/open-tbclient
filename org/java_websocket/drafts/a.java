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
/* loaded from: classes9.dex */
public class a extends Draft {
    static final /* synthetic */ boolean $assertionsDisabled;
    private b oiJ;
    private List<b> oiK;
    private org.java_websocket.d.a oiL;
    private List<org.java_websocket.d.a> oiM;
    private Framedata oiN;
    private List<ByteBuffer> oiO;
    private ByteBuffer oiP;
    private final Random oiQ;

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
        this.oiJ = new org.java_websocket.b.a();
        this.oiQ = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.oiK = new ArrayList(list.size());
        this.oiM = new ArrayList(list2.size());
        boolean z2 = false;
        this.oiO = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.oiK.addAll(list);
        if (!z) {
            this.oiK.add(this.oiK.size(), this.oiJ);
        }
        this.oiM.addAll(list2);
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (c(aVar) != 13) {
            bP("acceptHandshakeAsServer - Wrong websocket version.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String Tu = aVar.Tu("Sec-WebSocket-Extensions");
        Iterator<b> it = this.oiK.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.Tq(Tu)) {
                this.oiJ = next;
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                bP("acceptHandshakeAsServer - Matching extension found: " + this.oiJ.toString());
                handshakeState2 = handshakeState3;
                break;
            }
        }
        Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
        String Tu2 = aVar.Tu("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.oiM.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState4;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.Tw(Tu2)) {
                this.oiL = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                bP("acceptHandshakeAsServer - Matching protocol found: " + this.oiL.toString());
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
        } else if (!aVar.Tv("Sec-WebSocket-Key") || !hVar.Tv("Sec-WebSocket-Accept")) {
            bP("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return Draft.HandshakeState.NOT_MATCHED;
        } else {
            if (!Tp(aVar.Tu("Sec-WebSocket-Key")).equals(hVar.Tu("Sec-WebSocket-Accept"))) {
                bP("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String Tu = hVar.Tu("Sec-WebSocket-Extensions");
            Iterator<b> it = this.oiK.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.Tr(Tu)) {
                    this.oiJ = next;
                    Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                    bP("acceptHandshakeAsClient - Matching extension found: " + this.oiJ.toString());
                    handshakeState2 = handshakeState3;
                    break;
                }
            }
            Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
            String Tu2 = hVar.Tu("Sec-WebSocket-Protocol");
            Iterator<org.java_websocket.d.a> it2 = this.oiM.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    handshakeState = handshakeState4;
                    break;
                }
                org.java_websocket.d.a next2 = it2.next();
                if (next2.Tw(Tu2)) {
                    this.oiL = next2;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    bP("acceptHandshakeAsClient - Matching protocol found: " + this.oiL.toString());
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

    public b dXc() {
        return this.oiJ;
    }

    public List<b> dXd() {
        return this.oiK;
    }

    public org.java_websocket.d.a dXe() {
        return this.oiL;
    }

    public List<org.java_websocket.d.a> dXf() {
        return this.oiM;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.oiQ.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.oiK) {
            if (bVar2.dXi() != null && bVar2.dXi().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.dXi());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.oiM) {
            if (aVar.dXu().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.dXu());
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
        iVar.put(HTTP.CONN_DIRECTIVE, aVar.Tu(HTTP.CONN_DIRECTIVE));
        String Tu = aVar.Tu("Sec-WebSocket-Key");
        if (Tu == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", Tp(Tu));
        if (dXc().dXj().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", dXc().dXj());
        }
        if (dXe() != null && dXe().dXu().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", dXe().dXu());
        }
        iVar.Tt("Web Socket Protocol Handshake");
        iVar.put("Server", "TooTallNate Java-WebSocket");
        iVar.put("Date", dXg());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft dXb() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : dXd()) {
            arrayList.add(bVar.dXk());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : dXf()) {
            arrayList2.add(aVar.dXv());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        dXc().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.dXn().remaining() + "): {" + (framedata.dXn().remaining() > 1000 ? "too big to display" : new String(framedata.dXn().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer dXn = framedata.dXn();
        boolean z = this.oiu == WebSocket.Role.CLIENT;
        if (dXn.remaining() <= 125) {
            i = 1;
        } else {
            i = dXn.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + dXn.remaining());
        allocate.put((byte) (((byte) (framedata.Yw() ? -128 : 0)) | a(framedata.dXr())));
        byte[] D = D(dXn.remaining(), i);
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
                allocate2.putInt(this.oiQ.nextInt());
                allocate.put(allocate2.array());
                while (dXn.hasRemaining()) {
                    allocate.put((byte) (dXn.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(dXn);
                dXn.flip();
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
        ByteBuffer allocate = ByteBuffer.allocate(LM(b));
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
        b5.dB(z3);
        b5.yh(z);
        b5.yi(z2);
        b5.yj(z4);
        allocate.flip();
        b5.A(allocate);
        dXc().e(b5);
        dXc().c(b5);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b5.dXn().remaining() + "): {" + (b5.dXn().remaining() > 1000 ? "too big to display" : new String(b5.dXn().array())) + '}');
        }
        b5.dXl();
        return b5;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> x(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.oiP == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.oiP.remaining();
                if (remaining2 > remaining) {
                    this.oiP.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.oiP.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(z((ByteBuffer) this.oiP.duplicate().position(0)));
                this.oiP = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(LM(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.oiP.limit()) {
                    throw new AssertionError();
                }
                this.oiP.rewind();
                allocate.put(this.oiP);
                this.oiP = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(z(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.oiP = ByteBuffer.allocate(LM(e2.getPreferredSize()));
                this.oiP.put(byteBuffer);
            }
        }
        return linkedList;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> b(ByteBuffer byteBuffer, boolean z) {
        org.java_websocket.framing.a aVar = new org.java_websocket.framing.a();
        aVar.A(byteBuffer);
        aVar.yk(z);
        try {
            aVar.dXl();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> bc(String str, boolean z) {
        org.java_websocket.framing.i iVar = new org.java_websocket.framing.i();
        iVar.A(ByteBuffer.wrap(org.java_websocket.e.c.Tx(str)));
        iVar.yk(z);
        try {
            iVar.dXl();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.oiP = null;
        if (this.oiJ != null) {
            this.oiJ.reset();
        }
        this.oiJ = new org.java_websocket.b.a();
        this.oiL = null;
    }

    private String dXg() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String Tp(String str) {
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
        Framedata.Opcode dXr = framedata.dXr();
        if (dXr == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.p(i, str, true);
            } else if (dXa() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.o(i, str, true);
            } else {
                cVar.q(i, str, false);
            }
        } else if (dXr == Framedata.Opcode.PING) {
            cVar.dWZ().onWebsocketPing(cVar, framedata);
        } else if (dXr == Framedata.Opcode.PONG) {
            cVar.dWY();
            cVar.dWZ().onWebsocketPong(cVar, framedata);
        } else if (!framedata.Yw() || dXr == Framedata.Opcode.CONTINUOUS) {
            if (dXr != Framedata.Opcode.CONTINUOUS) {
                if (this.oiN != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.oiN = framedata;
                this.oiO.add(framedata.dXn());
            } else if (framedata.Yw()) {
                if (this.oiN == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.oiO.add(framedata.dXn());
                if (this.oiN.dXr() == Framedata.Opcode.TEXT) {
                    ((f) this.oiN).A(dXh());
                    ((f) this.oiN).dXl();
                    try {
                        cVar.dWZ().onWebsocketMessage(cVar, org.java_websocket.e.c.B(this.oiN.dXn()));
                    } catch (RuntimeException e) {
                        cVar.dWZ().onWebsocketError(cVar, e);
                    }
                } else if (this.oiN.dXr() == Framedata.Opcode.BINARY) {
                    ((f) this.oiN).A(dXh());
                    ((f) this.oiN).dXl();
                    try {
                        cVar.dWZ().onWebsocketMessage(cVar, this.oiN.dXn());
                    } catch (RuntimeException e2) {
                        cVar.dWZ().onWebsocketError(cVar, e2);
                    }
                }
                this.oiN = null;
                this.oiO.clear();
            } else if (this.oiN == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (dXr == Framedata.Opcode.TEXT && !org.java_websocket.e.c.C(framedata.dXn())) {
                throw new InvalidDataException(1007);
            }
            if (dXr == Framedata.Opcode.CONTINUOUS && this.oiN != null) {
                this.oiO.add(framedata.dXn());
            }
        } else if (this.oiN != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (dXr == Framedata.Opcode.TEXT) {
                try {
                    cVar.dWZ().onWebsocketMessage(cVar, org.java_websocket.e.c.B(framedata.dXn()));
                } catch (RuntimeException e3) {
                    cVar.dWZ().onWebsocketError(cVar, e3);
                }
            } else if (dXr == Framedata.Opcode.BINARY) {
                try {
                    cVar.dWZ().onWebsocketMessage(cVar, framedata.dXn());
                } catch (RuntimeException e4) {
                    cVar.dWZ().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType dXa() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (dXc() != null) {
            draft = draft + " extension: " + dXc().toString();
        }
        if (dXe() != null) {
            return draft + " protocol: " + dXe().toString();
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
        if (this.oiJ == null ? aVar.oiJ != null : !this.oiJ.equals(aVar.oiJ)) {
            return false;
        }
        return this.oiL != null ? this.oiL.equals(aVar.oiL) : aVar.oiL == null;
    }

    public int hashCode() {
        return ((this.oiJ != null ? this.oiJ.hashCode() : 0) * 31) + (this.oiL != null ? this.oiL.hashCode() : 0);
    }

    private ByteBuffer dXh() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.oiO.iterator();
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
        for (ByteBuffer byteBuffer : this.oiO) {
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
