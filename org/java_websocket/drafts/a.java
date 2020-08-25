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
    private b oCF;
    private List<b> oCG;
    private org.java_websocket.d.a oCH;
    private List<org.java_websocket.d.a> oCI;
    private Framedata oCJ;
    private List<ByteBuffer> oCK;
    private ByteBuffer oCL;
    private final Random oCM;

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
        this.oCF = new org.java_websocket.b.a();
        this.oCM = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.oCG = new ArrayList(list.size());
        this.oCI = new ArrayList(list2.size());
        boolean z2 = false;
        this.oCK = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.oCG.addAll(list);
        if (!z) {
            this.oCG.add(this.oCG.size(), this.oCF);
        }
        this.oCI.addAll(list2);
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
        Iterator<b> it = this.oCG.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.Wu(Wy)) {
                this.oCF = next;
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                bT("acceptHandshakeAsServer - Matching extension found: " + this.oCF.toString());
                handshakeState2 = handshakeState3;
                break;
            }
        }
        Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
        String Wy2 = aVar.Wy("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.oCI.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState4;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.WA(Wy2)) {
                this.oCH = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                bT("acceptHandshakeAsServer - Matching protocol found: " + this.oCH.toString());
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
            Iterator<b> it = this.oCG.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.Wv(Wy)) {
                    this.oCF = next;
                    Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                    bT("acceptHandshakeAsClient - Matching extension found: " + this.oCF.toString());
                    handshakeState2 = handshakeState3;
                    break;
                }
            }
            Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
            String Wy2 = hVar.Wy("Sec-WebSocket-Protocol");
            Iterator<org.java_websocket.d.a> it2 = this.oCI.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    handshakeState = handshakeState4;
                    break;
                }
                org.java_websocket.d.a next2 = it2.next();
                if (next2.WA(Wy2)) {
                    this.oCH = next2;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    bT("acceptHandshakeAsClient - Matching protocol found: " + this.oCH.toString());
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

    public b ejg() {
        return this.oCF;
    }

    public List<b> ejh() {
        return this.oCG;
    }

    public org.java_websocket.d.a eji() {
        return this.oCH;
    }

    public List<org.java_websocket.d.a> ejj() {
        return this.oCI;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.oCM.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.oCG) {
            if (bVar2.ejm() != null && bVar2.ejm().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.ejm());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.oCI) {
            if (aVar.ejy().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.ejy());
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
        if (ejg().ejn().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", ejg().ejn());
        }
        if (eji() != null && eji().ejy().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", eji().ejy());
        }
        iVar.Wx("Web Socket Protocol Handshake");
        iVar.put("Server", "TooTallNate Java-WebSocket");
        iVar.put("Date", ejk());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft ejf() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : ejh()) {
            arrayList.add(bVar.ejo());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : ejj()) {
            arrayList2.add(aVar.ejz());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        ejg().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.ejr().remaining() + "): {" + (framedata.ejr().remaining() > 1000 ? "too big to display" : new String(framedata.ejr().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer ejr = framedata.ejr();
        boolean z = this.oCq == WebSocket.Role.CLIENT;
        if (ejr.remaining() <= 125) {
            i = 1;
        } else {
            i = ejr.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + ejr.remaining());
        allocate.put((byte) (((byte) (framedata.aeC() ? -128 : 0)) | a(framedata.ejv())));
        byte[] D = D(ejr.remaining(), i);
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
                allocate2.putInt(this.oCM.nextInt());
                allocate.put(allocate2.array());
                while (ejr.hasRemaining()) {
                    allocate.put((byte) (ejr.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(ejr);
                ejr.flip();
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
        b5.dK(z3);
        b5.yZ(z);
        b5.za(z2);
        b5.zb(z4);
        allocate.flip();
        b5.A(allocate);
        ejg().e(b5);
        ejg().c(b5);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b5.ejr().remaining() + "): {" + (b5.ejr().remaining() > 1000 ? "too big to display" : new String(b5.ejr().array())) + '}');
        }
        b5.ejp();
        return b5;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> x(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.oCL == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.oCL.remaining();
                if (remaining2 > remaining) {
                    this.oCL.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.oCL.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(z((ByteBuffer) this.oCL.duplicate().position(0)));
                this.oCL = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(Op(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.oCL.limit()) {
                    throw new AssertionError();
                }
                this.oCL.rewind();
                allocate.put(this.oCL);
                this.oCL = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(z(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.oCL = ByteBuffer.allocate(Op(e2.getPreferredSize()));
                this.oCL.put(byteBuffer);
            }
        }
        return linkedList;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> b(ByteBuffer byteBuffer, boolean z) {
        org.java_websocket.framing.a aVar = new org.java_websocket.framing.a();
        aVar.A(byteBuffer);
        aVar.zc(z);
        try {
            aVar.ejp();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> bg(String str, boolean z) {
        org.java_websocket.framing.i iVar = new org.java_websocket.framing.i();
        iVar.A(ByteBuffer.wrap(org.java_websocket.e.c.WB(str)));
        iVar.zc(z);
        try {
            iVar.ejp();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.oCL = null;
        if (this.oCF != null) {
            this.oCF.reset();
        }
        this.oCF = new org.java_websocket.b.a();
        this.oCH = null;
    }

    private String ejk() {
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
        Framedata.Opcode ejv = framedata.ejv();
        if (ejv == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.o(i, str, true);
            } else if (eje() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.n(i, str, true);
            } else {
                cVar.p(i, str, false);
            }
        } else if (ejv == Framedata.Opcode.PING) {
            cVar.ejd().onWebsocketPing(cVar, framedata);
        } else if (ejv == Framedata.Opcode.PONG) {
            cVar.ejc();
            cVar.ejd().onWebsocketPong(cVar, framedata);
        } else if (!framedata.aeC() || ejv == Framedata.Opcode.CONTINUOUS) {
            if (ejv != Framedata.Opcode.CONTINUOUS) {
                if (this.oCJ != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.oCJ = framedata;
                this.oCK.add(framedata.ejr());
            } else if (framedata.aeC()) {
                if (this.oCJ == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.oCK.add(framedata.ejr());
                if (this.oCJ.ejv() == Framedata.Opcode.TEXT) {
                    ((f) this.oCJ).A(ejl());
                    ((f) this.oCJ).ejp();
                    try {
                        cVar.ejd().onWebsocketMessage(cVar, org.java_websocket.e.c.B(this.oCJ.ejr()));
                    } catch (RuntimeException e) {
                        cVar.ejd().onWebsocketError(cVar, e);
                    }
                } else if (this.oCJ.ejv() == Framedata.Opcode.BINARY) {
                    ((f) this.oCJ).A(ejl());
                    ((f) this.oCJ).ejp();
                    try {
                        cVar.ejd().onWebsocketMessage(cVar, this.oCJ.ejr());
                    } catch (RuntimeException e2) {
                        cVar.ejd().onWebsocketError(cVar, e2);
                    }
                }
                this.oCJ = null;
                this.oCK.clear();
            } else if (this.oCJ == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (ejv == Framedata.Opcode.TEXT && !org.java_websocket.e.c.C(framedata.ejr())) {
                throw new InvalidDataException(1007);
            }
            if (ejv == Framedata.Opcode.CONTINUOUS && this.oCJ != null) {
                this.oCK.add(framedata.ejr());
            }
        } else if (this.oCJ != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (ejv == Framedata.Opcode.TEXT) {
                try {
                    cVar.ejd().onWebsocketMessage(cVar, org.java_websocket.e.c.B(framedata.ejr()));
                } catch (RuntimeException e3) {
                    cVar.ejd().onWebsocketError(cVar, e3);
                }
            } else if (ejv == Framedata.Opcode.BINARY) {
                try {
                    cVar.ejd().onWebsocketMessage(cVar, framedata.ejr());
                } catch (RuntimeException e4) {
                    cVar.ejd().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType eje() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (ejg() != null) {
            draft = draft + " extension: " + ejg().toString();
        }
        if (eji() != null) {
            return draft + " protocol: " + eji().toString();
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
        if (this.oCF == null ? aVar.oCF != null : !this.oCF.equals(aVar.oCF)) {
            return false;
        }
        return this.oCH != null ? this.oCH.equals(aVar.oCH) : aVar.oCH == null;
    }

    public int hashCode() {
        return ((this.oCF != null ? this.oCF.hashCode() : 0) * 31) + (this.oCH != null ? this.oCH.hashCode() : 0);
    }

    private ByteBuffer ejl() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.oCK.iterator();
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
        for (ByteBuffer byteBuffer : this.oCK) {
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
