package g.c.f;

import com.baidu.android.common.others.lang.StringUtil;
import com.tencent.connect.common.Constants;
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
/* loaded from: classes7.dex */
public class a extends Draft {

    /* renamed from: c  reason: collision with root package name */
    public b f67628c;

    /* renamed from: d  reason: collision with root package name */
    public List<b> f67629d;

    /* renamed from: e  reason: collision with root package name */
    public g.c.j.a f67630e;

    /* renamed from: f  reason: collision with root package name */
    public List<g.c.j.a> f67631f;

    /* renamed from: g  reason: collision with root package name */
    public Framedata f67632g;

    /* renamed from: h  reason: collision with root package name */
    public List<ByteBuffer> f67633h;
    public ByteBuffer i;
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
        return this.f67628c;
    }

    public List<b> B() {
        return this.f67629d;
    }

    public List<g.c.j.a> C() {
        return this.f67631f;
    }

    public final ByteBuffer D() throws LimitExedeedException {
        long j = 0;
        for (ByteBuffer byteBuffer : this.f67633h) {
            j += byteBuffer.limit();
        }
        if (j <= 2147483647L) {
            ByteBuffer allocate = ByteBuffer.allocate((int) j);
            for (ByteBuffer byteBuffer2 : this.f67633h) {
                allocate.put(byteBuffer2);
            }
            allocate.flip();
            return allocate;
        }
        throw new LimitExedeedException("Payloadsize is to big...");
    }

    public g.c.j.a E() {
        return this.f67630e;
    }

    public final String F() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    public final byte[] H(long j, int i) {
        byte[] bArr = new byte[i];
        int i2 = (i * 8) - 8;
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) (j >>> (i2 - (i3 * 8)));
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
        int i;
        int remaining = byteBuffer.remaining();
        int i2 = 2;
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
                i = b4;
            } else if (I == Framedata.Opcode.PING || I == Framedata.Opcode.PONG || I == Framedata.Opcode.CLOSING) {
                throw new InvalidFrameException("more than 125 octets");
            } else {
                if (b4 != 126) {
                    i2 = 10;
                    if (remaining >= 10) {
                        byte[] bArr = new byte[8];
                        for (int i3 = 0; i3 < 8; i3++) {
                            bArr[i3] = byteBuffer.get();
                        }
                        z = z3;
                        long longValue = new BigInteger(bArr).longValue();
                        if (longValue > 2147483647L) {
                            throw new LimitExedeedException("Payloadsize is to big...");
                        }
                        i = (int) longValue;
                    } else {
                        throw new IncompleteException(10);
                    }
                } else if (remaining >= 4) {
                    z = z3;
                    i = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
                    i2 = 4;
                } else {
                    throw new IncompleteException(4);
                }
            }
            int i4 = i2 + (z6 ? 4 : 0) + i;
            if (remaining >= i4) {
                d(i);
                ByteBuffer allocate = ByteBuffer.allocate(i);
                if (z6) {
                    byte[] bArr2 = new byte[4];
                    byteBuffer.get(bArr2);
                    for (int i5 = 0; i5 < i; i5++) {
                        allocate.put((byte) (byteBuffer.get() ^ bArr2[i5 % 4]));
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
                A().g(g2);
                A().c(g2);
                if (c.y) {
                    PrintStream printStream = System.out;
                    StringBuilder sb = new StringBuilder();
                    sb.append("afterDecoding(");
                    sb.append(g2.f().remaining());
                    sb.append("): {");
                    sb.append(g2.f().remaining() > 1000 ? "too big to display" : new String(g2.f().array()));
                    sb.append('}');
                    printStream.println(sb.toString());
                }
                g2.h();
                return g2;
            }
            throw new IncompleteException(i4);
        }
        throw new IncompleteException(2);
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(g.c.i.a aVar, h hVar) throws InvalidHandshakeException {
        if (!c(hVar)) {
            G("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return Draft.HandshakeState.NOT_MATCHED;
        } else if (aVar.c("Sec-WebSocket-Key") && hVar.c("Sec-WebSocket-Accept")) {
            if (!z(aVar.i("Sec-WebSocket-Key")).equals(hVar.i("Sec-WebSocket-Accept"))) {
                G("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState = Draft.HandshakeState.NOT_MATCHED;
            String i = hVar.i("Sec-WebSocket-Extensions");
            Iterator<b> it = this.f67629d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next.e(i)) {
                    this.f67628c = next;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    G("acceptHandshakeAsClient - Matching extension found: " + this.f67628c.toString());
                    break;
                }
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String i2 = hVar.i("Sec-WebSocket-Protocol");
            Iterator<g.c.j.a> it2 = this.f67631f.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                g.c.j.a next2 = it2.next();
                if (next2.b(i2)) {
                    this.f67630e = next2;
                    handshakeState2 = Draft.HandshakeState.MATCHED;
                    G("acceptHandshakeAsClient - Matching protocol found: " + this.f67630e.toString());
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
        String i = aVar.i("Sec-WebSocket-Extensions");
        Iterator<b> it = this.f67629d.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.b(i)) {
                this.f67628c = next;
                handshakeState = Draft.HandshakeState.MATCHED;
                G("acceptHandshakeAsServer - Matching extension found: " + this.f67628c.toString());
                break;
            }
        }
        Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
        String i2 = aVar.i("Sec-WebSocket-Protocol");
        Iterator<g.c.j.a> it2 = this.f67631f.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            g.c.j.a next2 = it2.next();
            if (next2.b(i2)) {
                this.f67630e = next2;
                handshakeState2 = Draft.HandshakeState.MATCHED;
                G("acceptHandshakeAsServer - Matching protocol found: " + this.f67630e.toString());
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
        b bVar = this.f67628c;
        if (bVar == null ? aVar.f67628c == null : bVar.equals(aVar.f67628c)) {
            g.c.j.a aVar2 = this.f67630e;
            g.c.j.a aVar3 = aVar.f67630e;
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
        A().f(framedata);
        if (c.y) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("afterEnconding(");
            sb.append(framedata.f().remaining());
            sb.append("): {");
            sb.append(framedata.f().remaining() > 1000 ? "too big to display" : new String(framedata.f().array()));
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
        b bVar = this.f67628c;
        int hashCode = (bVar != null ? bVar.hashCode() : 0) * 31;
        g.c.j.a aVar = this.f67630e;
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
        bVar.a("Upgrade", "websocket");
        bVar.a(HTTP.CONN_DIRECTIVE, "Upgrade");
        byte[] bArr = new byte[16];
        this.j.nextBytes(bArr);
        bVar.a("Sec-WebSocket-Key", g.c.k.a.g(bArr));
        bVar.a("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        StringBuilder sb = new StringBuilder();
        for (b bVar2 : this.f67629d) {
            if (bVar2.d() != null && bVar2.d().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append(bVar2.d());
            }
        }
        if (sb.length() != 0) {
            bVar.a("Sec-WebSocket-Extensions", sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (g.c.j.a aVar : this.f67631f) {
            if (aVar.c().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb2.append(aVar.c());
            }
        }
        if (sb2.length() != 0) {
            bVar.a("Sec-WebSocket-Protocol", sb2.toString());
        }
        return bVar;
    }

    @Override // org.java_websocket.drafts.Draft
    public g.c.i.c n(g.c.i.a aVar, g.c.i.i iVar) throws InvalidHandshakeException {
        iVar.a("Upgrade", "websocket");
        iVar.a(HTTP.CONN_DIRECTIVE, aVar.i(HTTP.CONN_DIRECTIVE));
        String i = aVar.i("Sec-WebSocket-Key");
        if (i != null) {
            iVar.a("Sec-WebSocket-Accept", z(i));
            if (A().h().length() != 0) {
                iVar.a("Sec-WebSocket-Extensions", A().h());
            }
            if (E() != null && E().c().length() != 0) {
                iVar.a("Sec-WebSocket-Protocol", E().c());
            }
            iVar.h("Web Socket Protocol Handshake");
            iVar.a("Server", "TooTallNate Java-WebSocket");
            iVar.a("Date", F());
            return iVar;
        }
        throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
    }

    @Override // org.java_websocket.drafts.Draft
    public void o(c cVar, Framedata framedata) throws InvalidDataException {
        String str;
        Framedata.Opcode c2 = framedata.c();
        if (c2 == Framedata.Opcode.CLOSING) {
            int i = 1005;
            if (framedata instanceof g.c.h.b) {
                g.c.h.b bVar = (g.c.h.b) framedata;
                i = bVar.o();
                str = bVar.p();
            } else {
                str = "";
            }
            if (cVar.t() == WebSocket.READYSTATE.CLOSING) {
                cVar.g(i, str, true);
            } else if (l() == Draft.CloseHandshakeType.TWOWAY) {
                cVar.d(i, str, true);
            } else {
                cVar.o(i, str, false);
            }
        } else if (c2 == Framedata.Opcode.PING) {
            cVar.v().onWebsocketPing(cVar, framedata);
        } else if (c2 == Framedata.Opcode.PONG) {
            cVar.N();
            cVar.v().onWebsocketPong(cVar, framedata);
        } else if (framedata.e() && c2 != Framedata.Opcode.CONTINUOUS) {
            if (this.f67632g == null) {
                if (c2 == Framedata.Opcode.TEXT) {
                    try {
                        cVar.v().onWebsocketMessage(cVar, g.c.k.c.e(framedata.f()));
                        return;
                    } catch (RuntimeException e2) {
                        cVar.v().onWebsocketError(cVar, e2);
                        return;
                    }
                } else if (c2 == Framedata.Opcode.BINARY) {
                    try {
                        cVar.v().onWebsocketMessage(cVar, framedata.f());
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
            if (c2 != Framedata.Opcode.CONTINUOUS) {
                if (this.f67632g == null) {
                    this.f67632g = framedata;
                    this.f67633h.add(framedata.f());
                } else {
                    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                }
            } else if (framedata.e()) {
                if (this.f67632g != null) {
                    this.f67633h.add(framedata.f());
                    if (this.f67632g.c() == Framedata.Opcode.TEXT) {
                        ((f) this.f67632g).j(D());
                        ((f) this.f67632g).h();
                        try {
                            cVar.v().onWebsocketMessage(cVar, g.c.k.c.e(this.f67632g.f()));
                        } catch (RuntimeException e4) {
                            cVar.v().onWebsocketError(cVar, e4);
                        }
                    } else if (this.f67632g.c() == Framedata.Opcode.BINARY) {
                        ((f) this.f67632g).j(D());
                        ((f) this.f67632g).h();
                        try {
                            cVar.v().onWebsocketMessage(cVar, this.f67632g.f());
                        } catch (RuntimeException e5) {
                            cVar.v().onWebsocketError(cVar, e5);
                        }
                    }
                    this.f67632g = null;
                    this.f67633h.clear();
                } else {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
            } else if (this.f67632g == null) {
                throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
            if (c2 == Framedata.Opcode.TEXT && !g.c.k.c.b(framedata.f())) {
                throw new InvalidDataException(1007);
            }
            if (c2 != Framedata.Opcode.CONTINUOUS || this.f67632g == null) {
                return;
            }
            this.f67633h.add(framedata.f());
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void s() {
        this.i = null;
        b bVar = this.f67628c;
        if (bVar != null) {
            bVar.reset();
        }
        this.f67628c = new g.c.g.a();
        this.f67630e = null;
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
            if (this.i == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.i.remaining();
                if (remaining2 > remaining) {
                    this.i.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(byteBuffer.position() + remaining);
                    return Collections.emptyList();
                }
                this.i.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(J((ByteBuffer) this.i.duplicate().position(0)));
                this.i = null;
            } catch (IncompleteException e2) {
                int preferredSize = e2.getPreferredSize();
                d(preferredSize);
                ByteBuffer allocate = ByteBuffer.allocate(preferredSize);
                this.i.rewind();
                allocate.put(this.i);
                this.i = allocate;
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
                this.i = allocate2;
                allocate2.put(byteBuffer);
            }
        }
        return linkedList;
    }

    public final ByteBuffer x(Framedata framedata) {
        ByteBuffer f2 = framedata.f();
        int i = 0;
        boolean z = this.f68126a == WebSocket.Role.CLIENT;
        int i2 = f2.remaining() <= 125 ? 1 : f2.remaining() <= 65535 ? 2 : 8;
        ByteBuffer allocate = ByteBuffer.allocate((i2 > 1 ? i2 + 1 : i2) + 1 + (z ? 4 : 0) + f2.remaining());
        byte y = y(framedata.c());
        boolean e2 = framedata.e();
        byte b2 = ByteCompanionObject.MIN_VALUE;
        allocate.put((byte) (((byte) (e2 ? com.alipay.sdk.encrypt.a.f1896g : 0)) | y));
        byte[] H = H(f2.remaining(), i2);
        if (i2 == 1) {
            byte b3 = H[0];
            if (!z) {
                b2 = 0;
            }
            allocate.put((byte) (b3 | b2));
        } else if (i2 == 2) {
            if (!z) {
                b2 = 0;
            }
            allocate.put((byte) (b2 | 126));
            allocate.put(H);
        } else if (i2 == 8) {
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
            while (f2.hasRemaining()) {
                allocate.put((byte) (f2.get() ^ allocate2.get(i % 4)));
                i++;
            }
        } else {
            allocate.put(f2);
            f2.flip();
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
        this.f67628c = new g.c.g.a();
        this.j = new Random();
        if (list != null && list2 != null) {
            this.f67629d = new ArrayList(list.size());
            this.f67631f = new ArrayList(list2.size());
            boolean z = false;
            this.f67633h = new ArrayList();
            for (b bVar : list) {
                if (bVar.getClass().equals(g.c.g.a.class)) {
                    z = true;
                }
            }
            this.f67629d.addAll(list);
            if (!z) {
                List<b> list3 = this.f67629d;
                list3.add(list3.size(), this.f67628c);
            }
            this.f67631f.addAll(list2);
            return;
        }
        throw new IllegalArgumentException();
    }
}
