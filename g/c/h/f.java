package g.c.h;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes8.dex */
public abstract class f implements Framedata {

    /* renamed from: b  reason: collision with root package name */
    public Framedata.Opcode f71636b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f71637c = g.c.k.b.a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f71635a = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f71638d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f71639e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f71640f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f71641g = false;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f71642a;

        static {
            int[] iArr = new int[Framedata.Opcode.values().length];
            f71642a = iArr;
            try {
                iArr[Framedata.Opcode.PING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f71642a[Framedata.Opcode.PONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f71642a[Framedata.Opcode.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f71642a[Framedata.Opcode.BINARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f71642a[Framedata.Opcode.CLOSING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f71642a[Framedata.Opcode.CONTINUOUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public f(Framedata.Opcode opcode) {
        this.f71636b = opcode;
    }

    public static f g(Framedata.Opcode opcode) {
        if (opcode != null) {
            switch (a.f71642a[opcode.ordinal()]) {
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
        return this.f71637c;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean b() {
        return this.f71639e;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean c() {
        return this.f71640f;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode d() {
        return this.f71636b;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean e() {
        return this.f71641g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f71635a == fVar.f71635a && this.f71638d == fVar.f71638d && this.f71639e == fVar.f71639e && this.f71640f == fVar.f71640f && this.f71641g == fVar.f71641g && this.f71636b == fVar.f71636b) {
            ByteBuffer byteBuffer = this.f71637c;
            ByteBuffer byteBuffer2 = fVar.f71637c;
            return byteBuffer != null ? byteBuffer.equals(byteBuffer2) : byteBuffer2 == null;
        }
        return false;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean f() {
        return this.f71635a;
    }

    public abstract void h() throws InvalidDataException;

    public int hashCode() {
        int hashCode = (((this.f71635a ? 1 : 0) * 31) + this.f71636b.hashCode()) * 31;
        ByteBuffer byteBuffer = this.f71637c;
        return ((((((((hashCode + (byteBuffer != null ? byteBuffer.hashCode() : 0)) * 31) + (this.f71638d ? 1 : 0)) * 31) + (this.f71639e ? 1 : 0)) * 31) + (this.f71640f ? 1 : 0)) * 31) + (this.f71641g ? 1 : 0);
    }

    public void i(boolean z) {
        this.f71635a = z;
    }

    public void j(ByteBuffer byteBuffer) {
        this.f71637c = byteBuffer;
    }

    public void k(boolean z) {
        this.f71639e = z;
    }

    public void l(boolean z) {
        this.f71640f = z;
    }

    public void m(boolean z) {
        this.f71641g = z;
    }

    public void n(boolean z) {
        this.f71638d = z;
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
        sb.append(this.f71637c.position());
        sb.append(", len:");
        sb.append(this.f71637c.remaining());
        sb.append("], payload:");
        sb.append(this.f71637c.remaining() > 1000 ? "(too big to display)" : new String(this.f71637c.array()));
        sb.append('}');
        return sb.toString();
    }
}
