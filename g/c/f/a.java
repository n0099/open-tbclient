package g.c.f;

import com.baidu.android.common.others.lang.StringUtil;
import g.c.c;
import g.c.g.b;
import g.c.h.f;
import g.c.h.i;
import g.c.i.h;
import java.io.PrintStream;
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
import kotlin.jvm.internal.ByteCompanionObject;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.http.protocol.HTTP;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.IncompleteException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExedeedException;
import org.java_websocket.exceptions.NotSendableException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes8.dex */
public class a extends Draft {

    /* renamed from: c  reason: collision with root package name */
    public b f71730c;

    /* renamed from: d  reason: collision with root package name */
    public List<b> f71731d;

    /* renamed from: e  reason: collision with root package name */
    public g.c.j.a f71732e;

    /* renamed from: f  reason: collision with root package name */
    public List<g.c.j.a> f71733f;

    /* renamed from: g  reason: collision with root package name */
    public Framedata f71734g;

    /* renamed from: h  reason: collision with root package name */
    public List<ByteBuffer> f71735h;

    /* renamed from: i  reason: collision with root package name */
    public ByteBuffer f71736i;
    public final Random j;

    public a() {
        this(Collections.emptyList());
    }

    public static void G(Object obj) {
        if (c.y) {
            System.out.println(obj);
        }
    }

    public b A() {
        return this.f71730c;
    }

    public List<b> B() {
        return this.f71731d;
    }

    public List<g.c.j.a> C() {
        return this.f71733f;
    }

    public final ByteBuffer D() throws LimitExedeedException {
        long j = 0;
        for (ByteBuffer byteBuffer : this.f71735h) {
            j += byteBuffer.limit();
        }
        if (j <= 2147483647L) {
            ByteBuffer allocate = ByteBuffer.allocate((int) j);
            for (ByteBuffer byteBuffer2 : this.f71735h) {
                allocate.put(byteBuffer2);
            }
            allocate.flip();
            return allocate;
        }
        throw new LimitExedeedException("Payloadsize is to big...");
    }

    public g.c.j.a E() {
        return this.f71732e;
    }

    public final String F() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    public final byte[] H(long j, int i2) {
        byte[] bArr = new byte[i2];
        int i3 = (i2 * 8) - 8;
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) (j >>> (i3 - (i4 * 8)));
        }
        return bArr;
    }

    public final Framedata.Opcode I(byte b2) throws InvalidFrameException {
        if (b2 != 0) {
            if (b2 != 1) {
                if (b2 != 2) {
                    switch (b2) {
                        case 8:
                            return Framedata.Opcode.CLOSING;
                        case 9:
                            return Framedata.Opcode.PING;
                        case 10:
                            return Framedata.Opcode.PONG;
                        default:
                            throw new InvalidFrameException("Unknown opcode " + ((int) b2));
                    }
                }
                return Framedata.Opcode.BINARY;
            }
            return Framedata.Opcode.TEXT;
        }
        return Framedata.Opcode.CONTINUOUS;
    }

    public Framedata J(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
        boolean z;
        int i2;
        int remaining = byteBuffer.remaining();
        int i3 = 2;
        if (remaining >= 2) {
            byte b2 = byteBuffer.get();
            boolean z2 = (b2 >> 8) != 0;
            boolean z3 = (b2 & 64) != 0;
            boolean z4 = (b2 & 32) != 0;
            boolean z5 = (b2 & 16) != 0;
            byte b3 = byteBuffer.get();
            boolean z6 = (b3 & ByteCompanionObject.MIN_VALUE) != 0;
            byte b4 = (byte) (b3 & ByteCompanionObject.MAX_VALUE);
            Framedata.Opcode I = I((byte) (b2 & 15));
            if (b4 >= 0 && b4 <= 125) {
                z = z3;
                i2 = b4;
            } else if (I == Framedata.Opcode.PING || I == Framedata.Opcode.PONG || I == Framedata.Opcode.CLOSING) {
                throw new InvalidFrameException("more than 125 octets");
            } else {
                if (b4 != 126) {
                    i3 = 10;
                    if (remaining >= 10) {
                        byte[] bArr = new byte[8];
                        for (int i4 = 0; i4 < 8; i4++) {
                            bArr[i4] = byteBuffer.get();
                        }
                        z = z3;
                        long longValue = new BigInteger(bArr).longValue();
                        if (longValue > 2147483647L) {
                            throw new LimitExedeedException("Payloadsize is to big...");
                        }
                        i2 = (int) longValue;
                    } else {
                        throw new IncompleteException(10);
                    }
                } else if (remaining >= 4) {
                    z = z3;
                    i2 = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
                    i3 = 4;
                } else {
                    throw new IncompleteException(4);
                }
            }
            int i5 = i3 + (z6 ? 4 : 0) + i2;
            if (remaining >= i5) {
                d(i2);
                ByteBuffer allocate = ByteBuffer.allocate(i2);
                if (z6) {
                    byte[] bArr2 = new byte[4];
                    byteBuffer.get(bArr2);
                    for (int i6 = 0; i6 < i2; i6++) {
                        allocate.put((byte) (byteBuffer.get() ^ bArr2[i6 % 4]));
                    }
                } else {
                    allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                    byteBuffer.position(byteBuffer.position() + allocate.limit());
                }
                f g2 = f.g(I);
                g2.i(z2);
                g2.k(z);
                g2.l(z4);
                g2.m(z5);
                allocate.flip();
                g2.j(allocate);
                A().h(g2);
                A().f(g2);
                if (c.y) {
                    PrintStream printStream = System.out;
                    StringBuilder sb = new StringBuilder();
                    sb.append("afterDecoding(");
                    sb.append(g2.a().remaining());
                    sb.append("): {");
                    sb.append(g2.a().remaining() > 1000 ? "too big to display" : new String(g2.a().array()));
                    sb.append('}');
                    printStream.println(sb.toString());
                }
                g2.h();
                return g2;
            }
            throw new IncompleteException(i5);
        }
        throw new IncompleteException(2);
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(g.c.i.a aVar, h hVar) throws InvalidHandshakeException {
        if (!c(hVar)) {
            G("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return Draft.HandshakeState.NOT_MATCHED;
        } else if (aVar.e("Sec-WebSocket-Key") && hVar.e("Sec-WebSocket-Accept")) {
            if (!z(aVar.d("Sec-WebSocket-Key")).equals(hVar.d("Sec-WebSocket-Accept"))) {
                G("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState = Draft.HandshakeState.NOT_MATCHED;
            String d2 = hVar.d("Sec-WebSocket-Extensions");
            Iterator<b> it = this.f71731d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.b(d2)) {
                    this.f71730c = next;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    G("acceptHandshakeAsClient - Matching extension found: " + this.f71730c.toString());
                    break;
                }
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String d3 = hVar.d("Sec-WebSocket-Protocol");
            Iterator<g.c.j.a> it2 = this.f71733f.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                g.c.j.a next2 = it2.next();
                if (next2.b(d3)) {
                    this.f71732e = next2;
                    handshakeState2 = Draft.HandshakeState.MATCHED;
                    G("acceptHandshakeAsClient - Matching protocol found: " + this.f71732e.toString());
                    break;
                }
            }
            Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
            if (handshakeState2 == handshakeState3 && handshakeState == handshakeState3) {
                return handshakeState3;
            }
            G("acceptHandshakeAsClient - No matching extension or protocol found.");
            return Draft.HandshakeState.NOT_MATCHED;
        } else {
            G("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return Draft.HandshakeState.NOT_MATCHED;
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState b(g.c.i.a aVar) throws InvalidHandshakeException {
        if (r(aVar) != 13) {
            G("acceptHandshakeAsServer - Wrong websocket version.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
        Draft.HandshakeState handshakeState = Draft.HandshakeState.NOT_MATCHED;
        String d2 = aVar.d("Sec-WebSocket-Extensions");
        Iterator<b> it = this.f71731d.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.e(d2)) {
                this.f71730c = next;
                handshakeState = Draft.HandshakeState.MATCHED;
                G("acceptHandshakeAsServer - Matching extension found: " + this.f71730c.toString());
                break;
            }
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String d3 = aVar.d("Sec-WebSocket-Protocol");
        Iterator<g.c.j.a> it2 = this.f71733f.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            g.c.j.a next2 = it2.next();
            if (next2.b(d3)) {
                this.f71732e = next2;
                handshakeState2 = Draft.HandshakeState.MATCHED;
                G("acceptHandshakeAsServer - Matching protocol found: " + this.f71732e.toString());
                break;
            }
        }
        Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
        if (handshakeState2 == handshakeState3 && handshakeState == handshakeState3) {
            return handshakeState3;
        }
        G("acceptHandshakeAsServer - No matching extension or protocol found.");
        return Draft.HandshakeState.NOT_MATCHED;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        b bVar = this.f71730c;
        if (bVar == null ? aVar.f71730c == null : bVar.equals(aVar.f71730c)) {
            g.c.j.a aVar2 = this.f71732e;
            g.c.j.a aVar3 = aVar.f71732e;
            return aVar2 != null ? aVar2.equals(aVar3) : aVar3 == null;
        }
        return false;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft f() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : B()) {
            arrayList.add(bVar.a());
        }
        ArrayList arrayList2 = new ArrayList();
        for (g.c.j.a aVar : C()) {
            arrayList2.add(aVar.a());
        }
        return new a(arrayList, arrayList2);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer g(Framedata framedata) {
        A().c(framedata);
        if (c.y) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("afterEnconding(");
            sb.append(framedata.a().remaining());
            sb.append("): {");
            sb.append(framedata.a().remaining() > 1000 ? "too big to display" : new String(framedata.a().array()));
            sb.append('}');
            printStream.println(sb.toString());
        }
        return x(framedata);
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> h(String str, boolean z) {
        i iVar = new i();
        iVar.j(ByteBuffer.wrap(g.c.k.c.f(str)));
        iVar.n(z);
        try {
            iVar.h();
            return Collections.singletonList(iVar);
        } catch (InvalidDataException e2) {
            throw new NotSendableException(e2);
        }
    }

    public int hashCode() {
        b bVar = this.f71730c;
        int hashCode = (bVar != null ? bVar.hashCode() : 0) * 31;
        g.c.j.a aVar = this.f71732e;
        return hashCode + (aVar != null ? aVar.hashCode() : 0);
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> i(ByteBuffer byteBuffer, boolean z) {
        g.c.h.a aVar = new g.c.h.a();
        aVar.j(byteBuffer);
        aVar.n(z);
        try {
            aVar.h();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e2) {
            throw new NotSendableException(e2);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType l() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // org.java_websocket.drafts.Draft
    public g.c.i.b m(g.c.i.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.j.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", g.c.k.a.g(bArr));
        bVar.put("Sec-WebSocket-Version", "13");
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.f71731d) {
            if (bVar2.g() != null && bVar2.g().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append(bVar2.g());
            }
        }
        if (sb.length() != 0) {
            bVar.put("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (g.c.j.a aVar : this.f71733f) {
            if (aVar.c().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb2.append(aVar.c());
            }
        }
        if (sb2.length() != 0) {
            bVar.put("Sec-WebSocket-Protocol", sb2.toString());
        }
        return bVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public g.c.i.c n(g.c.i.a aVar, g.c.i.i iVar) throws InvalidHandshakeException {
        iVar.put("Upgrade", "websocket");
        iVar.put(HTTP.CONN_DIRECTIVE, aVar.d(HTTP.CONN_DIRECTIVE));
        String d2 = aVar.d("Sec-WebSocket-Key");
        if (d2 != null) {
            iVar.put("Sec-WebSocket-Accept", z(d2));
            if (A().d().length() != 0) {
                iVar.put("Sec-WebSocket-Extensions", A().d());
            }
            if (E() != null && E().c().length() != 0) {
                iVar.put("Sec-WebSocket-Protocol", E().c());
            }
            iVar.c("Web Socket Protocol Handshake");
            iVar.put("Server", "TooTallNate Java-WebSocket");
            iVar.put("Date", F());
            return iVar;
        }
        throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
    }

    @Override // org.java_websocket.drafts.Draft
    public void o(c cVar, Framedata framedata) throws InvalidDataException {
        String str;
        Framedata.Opcode d2 = framedata.d();
        if (d2 == Framedata.Opcode.CLOSING) {
            int i2 = 1005;
            if (framedata instanceof g.c.h.b) {
                g.c.h.b bVar = (g.c.h.b) framedata;
                i2 = bVar.o();
                str = bVar.p();
            } else {
                str = "";
            }
            if (cVar.t() == WebSocket.READYSTATE.CLOSING) {
                cVar.g(i2, str, true);
            } else if (l() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.d(i2, str, true);
            } else {
                cVar.o(i2, str, false);
            }
        } else if (d2 == Framedata.Opcode.PING) {
            cVar.v().onWebsocketPing(cVar, framedata);
        } else if (d2 == Framedata.Opcode.PONG) {
            cVar.N();
            cVar.v().onWebsocketPong(cVar, framedata);
        } else if (framedata.f() && d2 != Framedata.Opcode.CONTINUOUS) {
            if (this.f71734g == null) {
                if (d2 == Framedata.Opcode.TEXT) {
                    try {
                        cVar.v().onWebsocketMessage(cVar, g.c.k.c.e(framedata.a()));
                        return;
                    } catch (RuntimeException e2) {
                        cVar.v().onWebsocketError(cVar, e2);
                        return;
                    }
                } else if (d2 == Framedata.Opcode.BINARY) {
                    try {
                        cVar.v().onWebsocketMessage(cVar, framedata.a());
                        return;
                    } catch (RuntimeException e3) {
                        cVar.v().onWebsocketError(cVar, e3);
                        return;
                    }
                } else {
                    throw new InvalidDataException(1002, "non control or continious frame expected");
                }
            }
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else {
            if (d2 != Framedata.Opcode.CONTINUOUS) {
                if (this.f71734g == null) {
                    this.f71734g = framedata;
                    this.f71735h.add(framedata.a());
                } else {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
            } else if (framedata.f()) {
                if (this.f71734g != null) {
                    this.f71735h.add(framedata.a());
                    if (this.f71734g.d() == Framedata.Opcode.TEXT) {
                        ((f) this.f71734g).j(D());
                        ((f) this.f71734g).h();
                        try {
                            cVar.v().onWebsocketMessage(cVar, g.c.k.c.e(this.f71734g.a()));
                        } catch (RuntimeException e4) {
                            cVar.v().onWebsocketError(cVar, e4);
                        }
                    } else if (this.f71734g.d() == Framedata.Opcode.BINARY) {
                        ((f) this.f71734g).j(D());
                        ((f) this.f71734g).h();
                        try {
                            cVar.v().onWebsocketMessage(cVar, this.f71734g.a());
                        } catch (RuntimeException e5) {
                            cVar.v().onWebsocketError(cVar, e5);
                        }
                    }
                    this.f71734g = null;
                    this.f71735h.clear();
                } else {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
            } else if (this.f71734g == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (d2 == Framedata.Opcode.TEXT && !g.c.k.c.b(framedata.a())) {
                throw new InvalidDataException(1007);
            }
            if (d2 != Framedata.Opcode.CONTINUOUS || this.f71734g == null) {
                return;
            }
            this.f71735h.add(framedata.a());
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void s() {
        this.f71736i = null;
        b bVar = this.f71730c;
        if (bVar != null) {
            bVar.reset();
        }
        this.f71730c = new g.c.g.a();
        this.f71732e = null;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (A() != null) {
            draft = draft + " extension: " + A().toString();
        }
        if (E() != null) {
            return draft + " protocol: " + E().toString();
        }
        return draft;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> u(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.f71736i == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.f71736i.remaining();
                if (remaining2 > remaining) {
                    this.f71736i.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(byteBuffer.position() + remaining);
                    return Collections.emptyList();
                }
                this.f71736i.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(J((ByteBuffer) this.f71736i.duplicate().position(0)));
                this.f71736i = null;
            } catch (IncompleteException e2) {
                int preferredSize = e2.getPreferredSize();
                d(preferredSize);
                ByteBuffer allocate = ByteBuffer.allocate(preferredSize);
                this.f71736i.rewind();
                allocate.put(this.f71736i);
                this.f71736i = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(J(byteBuffer));
            } catch (IncompleteException e3) {
                byteBuffer.reset();
                int preferredSize2 = e3.getPreferredSize();
                d(preferredSize2);
                ByteBuffer allocate2 = ByteBuffer.allocate(preferredSize2);
                this.f71736i = allocate2;
                allocate2.put(byteBuffer);
            }
        }
        return linkedList;
    }

    public final ByteBuffer x(Framedata framedata) {
        ByteBuffer a2 = framedata.a();
        int i2 = 0;
        boolean z = this.f72452a == WebSocket.Role.CLIENT;
        int i3 = a2.remaining() <= 125 ? 1 : a2.remaining() <= 65535 ? 2 : 8;
        ByteBuffer allocate = ByteBuffer.allocate((i3 > 1 ? i3 + 1 : i3) + 1 + (z ? 4 : 0) + a2.remaining());
        byte y = y(framedata.d());
        boolean f2 = framedata.f();
        byte b2 = ByteCompanionObject.MIN_VALUE;
        allocate.put((byte) (((byte) (f2 ? com.alipay.sdk.encrypt.a.f1885g : 0)) | y));
        byte[] H = H(a2.remaining(), i3);
        if (i3 == 1) {
            byte b3 = H[0];
            if (!z) {
                b2 = 0;
            }
            allocate.put((byte) (b3 | b2));
        } else if (i3 == 2) {
            if (!z) {
                b2 = 0;
            }
            allocate.put((byte) (b2 | 126));
            allocate.put(H);
        } else if (i3 == 8) {
            if (!z) {
                b2 = 0;
            }
            allocate.put((byte) (b2 | ByteCompanionObject.MAX_VALUE));
            allocate.put(H);
        } else {
            throw new RuntimeException("Size representation not supported/specified");
        }
        if (z) {
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.putInt(this.j.nextInt());
            allocate.put(allocate2.array());
            while (a2.hasRemaining()) {
                allocate.put((byte) (a2.get() ^ allocate2.get(i2 % 4)));
                i2++;
            }
        } else {
            allocate.put(a2);
            a2.flip();
        }
        allocate.flip();
        return allocate;
    }

    public final byte y(Framedata.Opcode opcode) {
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

    public final String z(String str) {
        try {
            return g.c.k.a.g(MessageDigest.getInstance("SHA1").digest((str.trim() + WebSocketProtocol.ACCEPT_MAGIC).getBytes()));
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public a(List<b> list) {
        this(list, Collections.singletonList(new g.c.j.b("")));
    }

    public a(List<b> list, List<g.c.j.a> list2) {
        this.f71730c = new g.c.g.a();
        this.j = new Random();
        if (list != null && list2 != null) {
            this.f71731d = new ArrayList(list.size());
            this.f71733f = new ArrayList(list2.size());
            boolean z = false;
            this.f71735h = new ArrayList();
            for (b bVar : list) {
                if (bVar.getClass().equals(g.c.g.a.class)) {
                    z = true;
                }
            }
            this.f71731d.addAll(list);
            if (!z) {
                List<b> list3 = this.f71731d;
                list3.add(list3.size(), this.f71730c);
            }
            this.f71733f.addAll(list2);
            return;
        }
        throw new IllegalArgumentException();
    }
}
