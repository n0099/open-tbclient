package g.c.h;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class f implements Framedata {

    /* renamed from: b  reason: collision with root package name */
    public Framedata.Opcode f67636b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f67637c = g.c.k.b.a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f67635a = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f67638d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67639e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67640f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67641g = false;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f67642a;

        static {
            int[] iArr = new int[Framedata.Opcode.values().length];
            f67642a = iArr;
            try {
                iArr[Framedata.Opcode.PING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f67642a[Framedata.Opcode.PONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f67642a[Framedata.Opcode.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f67642a[Framedata.Opcode.BINARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f67642a[Framedata.Opcode.CLOSING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f67642a[Framedata.Opcode.CONTINUOUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public f(Framedata.Opcode opcode) {
        this.f67636b = opcode;
    }

    public static f g(Framedata.Opcode opcode) {
        if (opcode != null) {
            switch (a.f67642a[opcode.ordinal()]) {
                case 1:
                    return new g();
                case 2:
                    return new h();
                case 3:
                    return new i();
                case 4:
                    return new g.c.h.a();
                case 5:
                    return new b();
                case 6:
                    return new c();
                default:
                    throw new IllegalArgumentException("Supplied opcode is invalid");
            }
        }
        throw new IllegalArgumentException("Supplied opcode cannot be null");
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean a() {
        return this.f67639e;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean b() {
        return this.f67640f;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode c() {
        return this.f67636b;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean d() {
        return this.f67641g;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean e() {
        return this.f67635a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f67635a == fVar.f67635a && this.f67638d == fVar.f67638d && this.f67639e == fVar.f67639e && this.f67640f == fVar.f67640f && this.f67641g == fVar.f67641g && this.f67636b == fVar.f67636b) {
            ByteBuffer byteBuffer = this.f67637c;
            ByteBuffer byteBuffer2 = fVar.f67637c;
            return byteBuffer != null ? byteBuffer.equals(byteBuffer2) : byteBuffer2 == null;
        }
        return false;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer f() {
        return this.f67637c;
    }

    public abstract void h() throws InvalidDataException;

    public int hashCode() {
        int hashCode = (((this.f67635a ? 1 : 0) * 31) + this.f67636b.hashCode()) * 31;
        ByteBuffer byteBuffer = this.f67637c;
        return ((((((((hashCode + (byteBuffer != null ? byteBuffer.hashCode() : 0)) * 31) + (this.f67638d ? 1 : 0)) * 31) + (this.f67639e ? 1 : 0)) * 31) + (this.f67640f ? 1 : 0)) * 31) + (this.f67641g ? 1 : 0);
    }

    public void i(boolean z) {
        this.f67635a = z;
    }

    public void j(ByteBuffer byteBuffer) {
        this.f67637c = byteBuffer;
    }

    public void k(boolean z) {
        this.f67639e = z;
    }

    public void l(boolean z) {
        this.f67640f = z;
    }

    public void m(boolean z) {
        this.f67641g = z;
    }

    public void n(boolean z) {
        this.f67638d = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Framedata{ optcode:");
        sb.append(c());
        sb.append(", fin:");
        sb.append(e());
        sb.append(", rsv1:");
        sb.append(a());
        sb.append(", rsv2:");
        sb.append(b());
        sb.append(", rsv3:");
        sb.append(d());
        sb.append(", payloadlength:[pos:");
        sb.append(this.f67637c.position());
        sb.append(", len:");
        sb.append(this.f67637c.remaining());
        sb.append("], payload:");
        sb.append(this.f67637c.remaining() > 1000 ? "(too big to display)" : new String(this.f67637c.array()));
        sb.append('}');
        return sb.toString();
    }
}
