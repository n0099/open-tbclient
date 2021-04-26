package g.c.h;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class f implements Framedata {

    /* renamed from: b  reason: collision with root package name */
    public Framedata.Opcode f67651b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f67652c = g.c.k.b.a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f67650a = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f67653d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67654e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67655f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67656g = false;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f67657a;

        static {
            int[] iArr = new int[Framedata.Opcode.values().length];
            f67657a = iArr;
            try {
                iArr[Framedata.Opcode.PING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f67657a[Framedata.Opcode.PONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f67657a[Framedata.Opcode.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f67657a[Framedata.Opcode.BINARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f67657a[Framedata.Opcode.CLOSING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f67657a[Framedata.Opcode.CONTINUOUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public f(Framedata.Opcode opcode) {
        this.f67651b = opcode;
    }

    public static f g(Framedata.Opcode opcode) {
        if (opcode != null) {
            switch (a.f67657a[opcode.ordinal()]) {
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
        return this.f67652c;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean b() {
        return this.f67654e;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean c() {
        return this.f67655f;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode d() {
        return this.f67651b;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean e() {
        return this.f67656g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f67650a == fVar.f67650a && this.f67653d == fVar.f67653d && this.f67654e == fVar.f67654e && this.f67655f == fVar.f67655f && this.f67656g == fVar.f67656g && this.f67651b == fVar.f67651b) {
            ByteBuffer byteBuffer = this.f67652c;
            ByteBuffer byteBuffer2 = fVar.f67652c;
            return byteBuffer != null ? byteBuffer.equals(byteBuffer2) : byteBuffer2 == null;
        }
        return false;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean f() {
        return this.f67650a;
    }

    public abstract void h() throws InvalidDataException;

    public int hashCode() {
        int hashCode = (((this.f67650a ? 1 : 0) * 31) + this.f67651b.hashCode()) * 31;
        ByteBuffer byteBuffer = this.f67652c;
        return ((((((((hashCode + (byteBuffer != null ? byteBuffer.hashCode() : 0)) * 31) + (this.f67653d ? 1 : 0)) * 31) + (this.f67654e ? 1 : 0)) * 31) + (this.f67655f ? 1 : 0)) * 31) + (this.f67656g ? 1 : 0);
    }

    public void i(boolean z) {
        this.f67650a = z;
    }

    public void j(ByteBuffer byteBuffer) {
        this.f67652c = byteBuffer;
    }

    public void k(boolean z) {
        this.f67654e = z;
    }

    public void l(boolean z) {
        this.f67655f = z;
    }

    public void m(boolean z) {
        this.f67656g = z;
    }

    public void n(boolean z) {
        this.f67653d = z;
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
        sb.append(this.f67652c.position());
        sb.append(", len:");
        sb.append(this.f67652c.remaining());
        sb.append("], payload:");
        sb.append(this.f67652c.remaining() > 1000 ? "(too big to display)" : new String(this.f67652c.array()));
        sb.append('}');
        return sb.toString();
    }
}
