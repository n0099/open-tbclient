package g.c.h;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes8.dex */
public abstract class f implements Framedata {

    /* renamed from: b  reason: collision with root package name */
    public Framedata.Opcode f71740b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f71741c = g.c.k.b.a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f71739a = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f71742d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f71743e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f71744f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f71745g = false;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f71746a;

        static {
            int[] iArr = new int[Framedata.Opcode.values().length];
            f71746a = iArr;
            try {
                iArr[Framedata.Opcode.PING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f71746a[Framedata.Opcode.PONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f71746a[Framedata.Opcode.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f71746a[Framedata.Opcode.BINARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f71746a[Framedata.Opcode.CLOSING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f71746a[Framedata.Opcode.CONTINUOUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public f(Framedata.Opcode opcode) {
        this.f71740b = opcode;
    }

    public static f g(Framedata.Opcode opcode) {
        if (opcode != null) {
            switch (a.f71746a[opcode.ordinal()]) {
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
    public ByteBuffer a() {
        return this.f71741c;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean b() {
        return this.f71743e;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean c() {
        return this.f71744f;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode d() {
        return this.f71740b;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean e() {
        return this.f71745g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f71739a == fVar.f71739a && this.f71742d == fVar.f71742d && this.f71743e == fVar.f71743e && this.f71744f == fVar.f71744f && this.f71745g == fVar.f71745g && this.f71740b == fVar.f71740b) {
            ByteBuffer byteBuffer = this.f71741c;
            ByteBuffer byteBuffer2 = fVar.f71741c;
            return byteBuffer != null ? byteBuffer.equals(byteBuffer2) : byteBuffer2 == null;
        }
        return false;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean f() {
        return this.f71739a;
    }

    public abstract void h() throws InvalidDataException;

    public int hashCode() {
        int hashCode = (((this.f71739a ? 1 : 0) * 31) + this.f71740b.hashCode()) * 31;
        ByteBuffer byteBuffer = this.f71741c;
        return ((((((((hashCode + (byteBuffer != null ? byteBuffer.hashCode() : 0)) * 31) + (this.f71742d ? 1 : 0)) * 31) + (this.f71743e ? 1 : 0)) * 31) + (this.f71744f ? 1 : 0)) * 31) + (this.f71745g ? 1 : 0);
    }

    public void i(boolean z) {
        this.f71739a = z;
    }

    public void j(ByteBuffer byteBuffer) {
        this.f71741c = byteBuffer;
    }

    public void k(boolean z) {
        this.f71743e = z;
    }

    public void l(boolean z) {
        this.f71744f = z;
    }

    public void m(boolean z) {
        this.f71745g = z;
    }

    public void n(boolean z) {
        this.f71742d = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Framedata{ optcode:");
        sb.append(d());
        sb.append(", fin:");
        sb.append(f());
        sb.append(", rsv1:");
        sb.append(b());
        sb.append(", rsv2:");
        sb.append(c());
        sb.append(", rsv3:");
        sb.append(e());
        sb.append(", payloadlength:[pos:");
        sb.append(this.f71741c.position());
        sb.append(", len:");
        sb.append(this.f71741c.remaining());
        sb.append("], payload:");
        sb.append(this.f71741c.remaining() > 1000 ? "(too big to display)" : new String(this.f71741c.array()));
        sb.append('}');
        return sb.toString();
    }
}
