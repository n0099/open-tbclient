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
    private b jUB;
    private List<b> jUC;
    private org.java_websocket.d.a jUD;
    private List<org.java_websocket.d.a> jUE;
    private Framedata jUF;
    private List<ByteBuffer> jUG;
    private ByteBuffer jUH;
    private final Random jUI;

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
        this.jUB = new org.java_websocket.b.a();
        this.jUI = new Random();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        this.jUC = new ArrayList(list.size());
        this.jUE = new ArrayList(list2.size());
        boolean z2 = false;
        this.jUG = new ArrayList();
        Iterator<b> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().getClass().equals(org.java_websocket.b.a.class) ? true : z;
        }
        this.jUC.addAll(list);
        if (!z) {
            this.jUC.add(this.jUC.size(), this.jUB);
        }
        this.jUE.addAll(list2);
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(org.java_websocket.c.a aVar) throws InvalidHandshakeException {
        Draft.HandshakeState handshakeState;
        if (c(aVar) != 13) {
            bl("acceptHandshakeAsServer - Wrong websocket version.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String Gl = aVar.Gl("Sec-WebSocket-Extensions");
        Iterator<b> it = this.jUC.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.Gh(Gl)) {
                this.jUB = next;
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                bl("acceptHandshakeAsServer - Matching extension found: " + this.jUB.toString());
                handshakeState2 = handshakeState3;
                break;
            }
        }
        Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
        String Gl2 = aVar.Gl("Sec-WebSocket-Protocol");
        Iterator<org.java_websocket.d.a> it2 = this.jUE.iterator();
        while (true) {
            if (!it2.hasNext()) {
                handshakeState = handshakeState4;
                break;
            }
            org.java_websocket.d.a next2 = it2.next();
            if (next2.Gn(Gl2)) {
                this.jUD = next2;
                handshakeState = Draft.HandshakeState.MATCHED;
                bl("acceptHandshakeAsServer - Matching protocol found: " + this.jUD.toString());
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
        } else if (!aVar.Gm("Sec-WebSocket-Key") || !hVar.Gm("Sec-WebSocket-Accept")) {
            bl("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return Draft.HandshakeState.NOT_MATCHED;
        } else {
            if (!Gg(aVar.Gl("Sec-WebSocket-Key")).equals(hVar.Gl("Sec-WebSocket-Accept"))) {
                bl("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String Gl = hVar.Gl("Sec-WebSocket-Extensions");
            Iterator<b> it = this.jUC.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.Gi(Gl)) {
                    this.jUB = next;
                    Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                    bl("acceptHandshakeAsClient - Matching extension found: " + this.jUB.toString());
                    handshakeState2 = handshakeState3;
                    break;
                }
            }
            Draft.HandshakeState handshakeState4 = Draft.HandshakeState.NOT_MATCHED;
            String Gl2 = hVar.Gl("Sec-WebSocket-Protocol");
            Iterator<org.java_websocket.d.a> it2 = this.jUE.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    handshakeState = handshakeState4;
                    break;
                }
                org.java_websocket.d.a next2 = it2.next();
                if (next2.Gn(Gl2)) {
                    this.jUD = next2;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    bl("acceptHandshakeAsClient - Matching protocol found: " + this.jUD.toString());
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

    public b cDc() {
        return this.jUB;
    }

    public List<b> cDd() {
        return this.jUC;
    }

    public org.java_websocket.d.a cDe() {
        return this.jUD;
    }

    public List<org.java_websocket.d.a> cDf() {
        return this.jUE;
    }

    @Override // org.java_websocket.drafts.Draft
    public org.java_websocket.c.b b(org.java_websocket.c.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.jUI.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", org.java_websocket.e.a.encodeBytes(bArr));
        bVar.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.jUC) {
            if (bVar2.cDi() != null && bVar2.cDi().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(bVar2.cDi());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (org.java_websocket.d.a aVar : this.jUE) {
            if (aVar.cDv().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.cDv());
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
        iVar.put(HTTP.CONN_DIRECTIVE, aVar.Gl(HTTP.CONN_DIRECTIVE));
        String Gl = aVar.Gl("Sec-WebSocket-Key");
        if (Gl == null) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", Gg(Gl));
        if (cDc().cDj().length() != 0) {
            iVar.put("Sec-WebSocket-Extensions", cDc().cDj());
        }
        if (cDe() != null && cDe().cDv().length() != 0) {
            iVar.put("Sec-WebSocket-Protocol", cDe().cDv());
        }
        iVar.Gk("Web Socket Protocol Handshake");
        iVar.put(HTTP.SERVER_HEADER, "TooTallNate Java-WebSocket");
        iVar.put(HTTP.DATE_HEADER, cDg());
        return iVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft cDb() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : cDd()) {
            arrayList.add(bVar.cDk());
        }
        ArrayList arrayList2 = new ArrayList();
        for (org.java_websocket.d.a aVar : cDf()) {
            arrayList2.add(aVar.cDw());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        cDc().d(framedata);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterEnconding(" + framedata.cDn().remaining() + "): {" + (framedata.cDn().remaining() > 1000 ? "too big to display" : new String(framedata.cDn().array())) + '}');
        }
        return b(framedata);
    }

    private ByteBuffer b(Framedata framedata) {
        int i;
        int i2 = 0;
        ByteBuffer cDn = framedata.cDn();
        boolean z = this.jUm == WebSocket.Role.CLIENT;
        if (cDn.remaining() <= 125) {
            i = 1;
        } else {
            i = cDn.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + cDn.remaining());
        allocate.put((byte) (((byte) (framedata.cDo() ? -128 : 0)) | a(framedata.cDs())));
        byte[] x = x(cDn.remaining(), i);
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
                allocate2.putInt(this.jUI.nextInt());
                allocate.put(allocate2.array());
                while (cDn.hasRemaining()) {
                    allocate.put((byte) (cDn.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(cDn);
                cDn.flip();
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
        cDc().e(b5);
        cDc().c(b5);
        if (org.java_websocket.c.DEBUG) {
            System.out.println("afterDecoding(" + b5.cDn().remaining() + "): {" + (b5.cDn().remaining() > 1000 ? "too big to display" : new String(b5.cDn().array())) + '}');
        }
        b5.cDl();
        return b5;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> q(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.jUH == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.jUH.remaining();
                if (remaining2 > remaining) {
                    this.jUH.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.jUH.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(s((ByteBuffer) this.jUH.duplicate().position(0)));
                this.jUH = null;
            } catch (IncompleteException e) {
                ByteBuffer allocate = ByteBuffer.allocate(Do(e.getPreferredSize()));
                if (!$assertionsDisabled && allocate.limit() <= this.jUH.limit()) {
                    throw new AssertionError();
                }
                this.jUH.rewind();
                allocate.put(this.jUH);
                this.jUH = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(s(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                this.jUH = ByteBuffer.allocate(Do(e2.getPreferredSize()));
                this.jUH.put(byteBuffer);
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
            aVar.cDl();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> az(String str, boolean z) {
        org.java_websocket.framing.i iVar = new org.java_websocket.framing.i();
        iVar.t(ByteBuffer.wrap(org.java_websocket.e.c.Go(str)));
        iVar.rK(z);
        try {
            iVar.cDl();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.jUH = null;
        if (this.jUB != null) {
            this.jUB.reset();
        }
        this.jUB = new org.java_websocket.b.a();
        this.jUD = null;
    }

    private String cDg() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String Gg(String str) {
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
        Framedata.Opcode cDs = framedata.cDs();
        if (cDs == Framedata.Opcode.CLOSING) {
            int i = 1005;
            String str = "";
            if (framedata instanceof org.java_websocket.framing.b) {
                org.java_websocket.framing.b bVar = (org.java_websocket.framing.b) framedata;
                i = bVar.getCloseCode();
                str = bVar.getMessage();
            }
            if (cVar.getReadyState() == WebSocket.READYSTATE.CLOSING) {
                cVar.j(i, str, true);
            } else if (cDa() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.i(i, str, true);
            } else {
                cVar.k(i, str, false);
            }
        } else if (cDs == Framedata.Opcode.PING) {
            cVar.cCZ().onWebsocketPing(cVar, framedata);
        } else if (cDs == Framedata.Opcode.PONG) {
            cVar.cCY();
            cVar.cCZ().onWebsocketPong(cVar, framedata);
        } else if (!framedata.cDo() || cDs == Framedata.Opcode.CONTINUOUS) {
            if (cDs != Framedata.Opcode.CONTINUOUS) {
                if (this.jUF != null) {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
                this.jUF = framedata;
                this.jUG.add(framedata.cDn());
            } else if (framedata.cDo()) {
                if (this.jUF == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                this.jUG.add(framedata.cDn());
                if (this.jUF.cDs() == Framedata.Opcode.TEXT) {
                    ((f) this.jUF).t(cDh());
                    ((f) this.jUF).cDl();
                    try {
                        cVar.cCZ().onWebsocketMessage(cVar, org.java_websocket.e.c.u(this.jUF.cDn()));
                    } catch (RuntimeException e) {
                        cVar.cCZ().onWebsocketError(cVar, e);
                    }
                } else if (this.jUF.cDs() == Framedata.Opcode.BINARY) {
                    ((f) this.jUF).t(cDh());
                    ((f) this.jUF).cDl();
                    try {
                        cVar.cCZ().onWebsocketMessage(cVar, this.jUF.cDn());
                    } catch (RuntimeException e2) {
                        cVar.cCZ().onWebsocketError(cVar, e2);
                    }
                }
                this.jUF = null;
                this.jUG.clear();
            } else if (this.jUF == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (cDs == Framedata.Opcode.TEXT && !org.java_websocket.e.c.v(framedata.cDn())) {
                throw new InvalidDataException(PointerIconCompat.TYPE_CROSSHAIR);
            }
            if (cDs == Framedata.Opcode.CONTINUOUS && this.jUF != null) {
                this.jUG.add(framedata.cDn());
            }
        } else if (this.jUF != null) {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (cDs == Framedata.Opcode.TEXT) {
                try {
                    cVar.cCZ().onWebsocketMessage(cVar, org.java_websocket.e.c.u(framedata.cDn()));
                } catch (RuntimeException e3) {
                    cVar.cCZ().onWebsocketError(cVar, e3);
                }
            } else if (cDs == Framedata.Opcode.BINARY) {
                try {
                    cVar.cCZ().onWebsocketMessage(cVar, framedata.cDn());
                } catch (RuntimeException e4) {
                    cVar.cCZ().onWebsocketError(cVar, e4);
                }
            } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType cDa() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (cDc() != null) {
            draft = draft + " extension: " + cDc().toString();
        }
        if (cDe() != null) {
            return draft + " protocol: " + cDe().toString();
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
        if (this.jUB == null ? aVar.jUB != null : !this.jUB.equals(aVar.jUB)) {
            return false;
        }
        return this.jUD != null ? this.jUD.equals(aVar.jUD) : aVar.jUD == null;
    }

    public int hashCode() {
        return ((this.jUB != null ? this.jUB.hashCode() : 0) * 31) + (this.jUD != null ? this.jUD.hashCode() : 0);
    }

    private ByteBuffer cDh() throws LimitExedeedException {
        long j;
        long j2 = 0;
        Iterator<ByteBuffer> it = this.jUG.iterator();
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
        for (ByteBuffer byteBuffer : this.jUG) {
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
