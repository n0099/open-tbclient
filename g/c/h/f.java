package g.c.h;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class f implements Framedata {

    /* renamed from: b  reason: collision with root package name */
    public Framedata.Opcode f68337b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f68338c = g.c.k.b.a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f68336a = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f68339d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f68340e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f68341f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68342g = false;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f68343a;

        static {
            int[] iArr = new int[Framedata.Opcode.values().length];
            f68343a = iArr;
            try {
                iArr[Framedata.Opcode.PING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68343a[Framedata.Opcode.PONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f68343a[Framedata.Opcode.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f68343a[Framedata.Opcode.BINARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f68343a[Framedata.Opcode.CLOSING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f68343a[Framedata.Opcode.CONTINUOUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public f(Framedata.Opcode opcode) {
        this.f68337b = opcode;
    }

    public static f g(Framedata.Opcode opcode) {
        if (opcode != null) {
            switch (a.f68343a[opcode.ordinal()]) {
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
        return this.f68338c;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean b() {
        return this.f68340e;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean c() {
        return this.f68341f;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode d() {
        return this.f68337b;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean e() {
        return this.f68342g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f68336a == fVar.f68336a && this.f68339d == fVar.f68339d && this.f68340e == fVar.f68340e && this.f68341f == fVar.f68341f && this.f68342g == fVar.f68342g && this.f68337b == fVar.f68337b) {
            ByteBuffer byteBuffer = this.f68338c;
            ByteBuffer byteBuffer2 = fVar.f68338c;
            return byteBuffer != null ? byteBuffer.equals(byteBuffer2) : byteBuffer2 == null;
        }
        return false;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean f() {
        return this.f68336a;
    }

    public abstract void h() throws InvalidDataException;

    public int hashCode() {
        int hashCode = (((this.f68336a ? 1 : 0) * 31) + this.f68337b.hashCode()) * 31;
        ByteBuffer byteBuffer = this.f68338c;
        return ((((((((hashCode + (byteBuffer != null ? byteBuffer.hashCode() : 0)) * 31) + (this.f68339d ? 1 : 0)) * 31) + (this.f68340e ? 1 : 0)) * 31) + (this.f68341f ? 1 : 0)) * 31) + (this.f68342g ? 1 : 0);
    }

    public void i(boolean z) {
        this.f68336a = z;
    }

    public void j(ByteBuffer byteBuffer) {
        this.f68338c = byteBuffer;
    }

    public void k(boolean z) {
        this.f68340e = z;
    }

    public void l(boolean z) {
        this.f68341f = z;
    }

    public void m(boolean z) {
        this.f68342g = z;
    }

    public void n(boolean z) {
        this.f68339d = z;
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
        sb.append(this.f68338c.position());
        sb.append(", len:");
        sb.append(this.f68338c.remaining());
        sb.append("], payload:");
        sb.append(this.f68338c.remaining() > 1000 ? "(too big to display)" : new String(this.f68338c.array()));
        sb.append('}');
        return sb.toString();
    }
}
