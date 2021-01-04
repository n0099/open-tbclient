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
/* loaded from: classes4.dex */
public class a extends Draft {
    static final /* synthetic */ boolean $assertionsDisabled;
    private b qpO;
    private List<b> qpP;
    private org.java_websocket.d.a qpQ;
    private List<org.java_websocket.d.a> qpR;
    private Framedata qpS;
    private List<ByteBuffer> qpT;
    private ByteBuffer qpU;
    private final Random qpV;

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
        this.qpO = new org.java_websocket.b.a();
        this.qpV = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.qpP = new ArrayList(list.size());
        this.qpR = new ArrayList(list2.size());
        boolean z2 = false;
        this.qpT = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.qpP.addAll(list);
        if (!z) {
            this.qpP.add(this.qpP.size(), this.qpO);
        }
        this.qpR.addAll(list2);
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (c(aVar) != 13) {
            bT("acceptHandshakeAsServer - Wrong websocket version.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String acx = aVar.acx("Sec-WebSocket-Extensions");
        Iterator<b> it = this.qpP.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.act(acx)) {
                this.qpO = next;
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                bT("acceptHandshakeAsServer - Matching extension found: " + this.qpO.toString());
                handshakeState2 = handshakeState3;
                break;
            }
        }
        Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
        String acx2 = aVar.acx("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.qpR.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState4;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.acz(acx2)) {
                this.qpQ = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                bT("acceptHandshakeAsServer - Matching protocol found: " + this.qpQ.toString());
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
        } else if (!aVar.acy("Sec-WebSocket-Key") || !hVar.acy("Sec-WebSocket-Accept")) {
            bT("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return Draft.HandshakeState.NOT_MATCHED;
        } else {
            if (!acs(aVar.acx("Sec-WebSocket-Key")).equals(hVar.acx("Sec-WebSocket-Accept"))) {
                bT("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String acx = hVar.acx("Sec-WebSocket-Extensions");
            Iterator<b> it = this.qpP.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.acu(acx)) {
                    this.qpO = next;
                    Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                    bT("acceptHandshakeAsClient - Matching extension found: " + this.qpO.toString());
                    handshakeState2 = handshakeState3;
                    break;
                }
            }
            Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
            String acx2 = hVar.acx("Sec-WebSocket-Protocol");
            Iterator<org.java_websocket.d.a> it2 = this.qpR.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    handshakeState = handshakeState4;
                    break;
                }
                org.java_websocket.d.a next2 = it2.next();
                if (next2.acz(acx2)) {
                    this.qpQ = next2;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    bT("acceptHandshakeAsClient - Matching protocol found: " + this.qpQ.toString());
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

    public b eMU() {
        return this.qpO;
    }

    public List<b> eMV() {
        return this.qpP;
    }

    public org.java_websocket.d.a eMW() {
        return this.qpQ;
    }

    public List<org.java_websocket.d.a> eMX() {
        return this.qpR;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.qpV.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.qpP) {
            if (bVar2.eNa() != null && bVar2.eNa().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.eNa());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.qpR) {
            if (aVar.eNm().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.eNm());
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
        iVar.put(HTTP.CONN_DIRECTIVE, aVar.acx(HTTP.CONN_DIRECTIVE));
        String acx = aVar.acx("Sec-WebSocket-Key");
        if (acx == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", acs(acx));
        if (eMU().eNb().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", eMU().eNb());
        }
        if (eMW() != null && eMW().eNm().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", eMW().eNm());
        }
        iVar.acw("Web Socket Protocol Handshake");
        iVar.put("Server", "TooTallNate Java-WebSocket");
        iVar.put("Date", eMY());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft eMT() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : eMV()) {
            arrayList.add(bVar.eNc());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : eMX()) {
            arrayList2.add(aVar.eNn());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        eMU().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.eNf().remaining() + "): {" + (framedata.eNf().remaining() > 1000 ? "too big to display" : new String(framedata.eNf().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer eNf = framedata.eNf();
        boolean z = this.qpz == WebSocket.Role.CLIENT;
        if (eNf.remaining() <= 125) {
            i = 1;
        } else {
            i = eNf.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + eNf.remaining());
        allocate.put((byte) (((byte) (framedata.aqe() ? -128 : 0)) | a(framedata.eNj())));
        byte[] O = O(eNf.remaining(), i);
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
                allocate2.putInt(this.qpV.nextInt());
                allocate.put(allocate2.array());
                while (eNf.hasRemaining()) {
                    allocate.put((byte) (eNf.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(eNf);
                eNf.flip();
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
        byte b2;
        int remaining = byteBuffer.remaining();
        int i = 2;
        if (remaining < 2) {
            throw new IncompleteException(2);
        }
        byte b3 = byteBuffer.get();
        boolean z3 = (b3 >> 8) != 0;
        boolean z4 = false;
        if ((b3 & 64) == 0) {
            z = false;
        } else {
            z = true;
        }
        if ((b3 & 32) == 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if ((b3 & 16) != 0) {
            z4 = true;
        }
        byte b4 = byteBuffer.get();
        boolean z5 = (b4 & Byte.MIN_VALUE) != 0;
        byte b5 = (byte) (b4 & Byte.MAX_VALUE);
        Framedata.Opcode j = j((byte) (b3 & 15));
        if (b5 >= 0 && b5 <= 125) {
            b2 = b5;
        } else if (j == Framedata.Opcode.PING || j == Framedata.Opcode.PONG || j == Framedata.Opcode.CLOSING) {
            throw new InvalidFrameException("more than 125 octets");
        } else {
            if (b5 == 126) {
                i = 4;
                if (remaining < 4) {
                    throw new IncompleteException(4);
                }
                b2 = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
            } else {
                i = 10;
                if (remaining < 10) {
                    throw new IncompleteException(10);
                }
                byte[] bArr = new byte[8];
                for (int i2 = 0; i2 < 8; i2++) {
                    bArr[i2] = byteBuffer.get();
                }
                long longValue = new BigInteger(bArr).longValue();
                if (longValue > 2147483647L) {
                    throw new LimitExedeedException("Payloadsize is to big...");
                }
                b2 = (int) longValue;
            }
        }
        int i3 = (z5 ? 4 : 0) + i + b2;
        if (remaining < i3) {
            throw new IncompleteException(i3);
        }
        ByteBuffer allocate = ByteBuffer.allocate(TB(b2));
        if (z5) {
            byte[] bArr2 = new byte[4];
            byteBuffer.get(bArr2);
            for (int i4 = 0; i4 < b2; i4++) {
                allocate.put((byte) (byteBuffer.get() ^ bArr2[i4 % 4]));
            }
        } else {
            allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
            byteBuffer.position(byteBuffer.position() + allocate.limit());
        }
        f b6 = f.b(j);
        b6.fc(z3);
        b6.CJ(z);
        b6.CK(z2);
        b6.CL(z4);
        allocate.flip();
        b6.A(allocate);
        eMU().e(b6);
        eMU().c(b6);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b6.eNf().remaining() + "): {" + (b6.eNf().remaining() > 1000 ? "too big to display" : new String(b6.eNf().array())) + '}');
        }
        b6.eNd();
        return b6;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> x(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.qpU == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.qpU.remaining();
                if (remaining2 > remaining) {
                    this.qpU.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.qpU.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(z((ByteBuffer) this.qpU.duplicate().position(0)));
                this.qpU = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(TB(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.qpU.limit()) {
                    throw new AssertionError();
                }
                this.qpU.rewind();
                allocate.put(this.qpU);
                this.qpU = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(z(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.qpU = ByteBuffer.allocate(TB(e2.getPreferredSize()));
                this.qpU.put(byteBuffer);
            }
        }
        return linkedList;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> b(ByteBuffer byteBuffer, boolean z) {
        org.java_websocket.framing.a aVar = new org.java_websocket.framing.a();
        aVar.A(byteBuffer);
        aVar.CM(z);
        try {
            aVar.eNd();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> bp(String str, boolean z) {
        org.java_websocket.framing.i iVar = new org.java_websocket.framing.i();
        iVar.A(ByteBuffer.wrap(org.java_websocket.e.c.acA(str)));
        iVar.CM(z);
        try {
            iVar.eNd();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.qpU = null;
        if (this.qpO != null) {
            this.qpO.reset();
        }
        this.qpO = new org.java_websocket.b.a();
        this.qpQ = null;
    }

    private String eMY() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String acs(String str) {
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

    private Framedata.Opcode j(byte b2) throws InvalidFrameException {
        switch (b2) {
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
                throw new InvalidFrameException("Unknown opcode " + ((int) b2));
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
        Framedata.Opcode eNj = framedata.eNj();
        if (eNj == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.r(i, str, true);
            } else if (eMS() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.q(i, str, true);
            } else {
                cVar.s(i, str, false);
            }
        } else if (eNj == Framedata.Opcode.PING) {
            cVar.eMR().onWebsocketPing(cVar, framedata);
        } else if (eNj == Framedata.Opcode.PONG) {
            cVar.eMQ();
            cVar.eMR().onWebsocketPong(cVar, framedata);
        } else if (!framedata.aqe() || eNj == Framedata.Opcode.CONTINUOUS) {
            if (eNj != Framedata.Opcode.CONTINUOUS) {
                if (this.qpS != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.qpS = framedata;
                this.qpT.add(framedata.eNf());
            } else if (framedata.aqe()) {
                if (this.qpS == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.qpT.add(framedata.eNf());
                if (this.qpS.eNj() == Framedata.Opcode.TEXT) {
                    ((f) this.qpS).A(eMZ());
                    ((f) this.qpS).eNd();
                    try {
                        cVar.eMR().onWebsocketMessage(cVar, org.java_websocket.e.c.B(this.qpS.eNf()));
                    } catch (RuntimeException e) {
                        cVar.eMR().onWebsocketError(cVar, e);
                    }
                } else if (this.qpS.eNj() == Framedata.Opcode.BINARY) {
                    ((f) this.qpS).A(eMZ());
                    ((f) this.qpS).eNd();
                    try {
                        cVar.eMR().onWebsocketMessage(cVar, this.qpS.eNf());
                    } catch (RuntimeException e2) {
                        cVar.eMR().onWebsocketError(cVar, e2);
                    }
                }
                this.qpS = null;
                this.qpT.clear();
            } else if (this.qpS == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (eNj == Framedata.Opcode.TEXT && !org.java_websocket.e.c.C(framedata.eNf())) {
                throw new InvalidDataException(1007);
            }
            if (eNj == Framedata.Opcode.CONTINUOUS && this.qpS != null) {
                this.qpT.add(framedata.eNf());
            }
        } else if (this.qpS != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (eNj == Framedata.Opcode.TEXT) {
                try {
                    cVar.eMR().onWebsocketMessage(cVar, org.java_websocket.e.c.B(framedata.eNf()));
                } catch (RuntimeException e3) {
                    cVar.eMR().onWebsocketError(cVar, e3);
                }
            } else if (eNj == Framedata.Opcode.BINARY) {
                try {
                    cVar.eMR().onWebsocketMessage(cVar, framedata.eNf());
                } catch (RuntimeException e4) {
                    cVar.eMR().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType eMS() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (eMU() != null) {
            draft = draft + " extension: " + eMU().toString();
        }
        if (eMW() != null) {
            return draft + " protocol: " + eMW().toString();
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
        if (this.qpO == null ? aVar.qpO != null : !this.qpO.equals(aVar.qpO)) {
            return false;
        }
        return this.qpQ != null ? this.qpQ.equals(aVar.qpQ) : aVar.qpQ == null;
    }

    public int hashCode() {
        return ((this.qpO != null ? this.qpO.hashCode() : 0) * 31) + (this.qpQ != null ? this.qpQ.hashCode() : 0);
    }

    private ByteBuffer eMZ() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.qpT.iterator();
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
        for (ByteBuffer byteBuffer : this.qpT) {
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
