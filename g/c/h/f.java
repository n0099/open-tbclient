package g.c.h;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class f implements Framedata {

    /* renamed from: b  reason: collision with root package name */
    public Framedata.Opcode f68789b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f68790c = g.c.k.b.a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f68788a = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f68791d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f68792e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f68793f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68794g = false;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f68795a;

        static {
            int[] iArr = new int[Framedata.Opcode.values().length];
            f68795a = iArr;
            try {
                iArr[Framedata.Opcode.PING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68795a[Framedata.Opcode.PONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f68795a[Framedata.Opcode.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f68795a[Framedata.Opcode.BINARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f68795a[Framedata.Opcode.CLOSING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f68795a[Framedata.Opcode.CONTINUOUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public f(Framedata.Opcode opcode) {
        this.f68789b = opcode;
    }

    public static f g(Framedata.Opcode opcode) {
        if (opcode != null) {
            switch (a.f68795a[opcode.ordinal()]) {
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
        return this.f68792e;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean b() {
        return this.f68793f;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode c() {
        return this.f68789b;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean d() {
        return this.f68794g;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean e() {
        return this.f68788a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f68788a == fVar.f68788a && this.f68791d == fVar.f68791d && this.f68792e == fVar.f68792e && this.f68793f == fVar.f68793f && this.f68794g == fVar.f68794g && this.f68789b == fVar.f68789b) {
            ByteBuffer byteBuffer = this.f68790c;
            ByteBuffer byteBuffer2 = fVar.f68790c;
            return byteBuffer != null ? byteBuffer.equals(byteBuffer2) : byteBuffer2 == null;
        }
        return false;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer f() {
        return this.f68790c;
    }

    public abstract void h() throws InvalidDataException;

    public int hashCode() {
        int hashCode = (((this.f68788a ? 1 : 0) * 31) + this.f68789b.hashCode()) * 31;
        ByteBuffer byteBuffer = this.f68790c;
        return ((((((((hashCode + (byteBuffer != null ? byteBuffer.hashCode() : 0)) * 31) + (this.f68791d ? 1 : 0)) * 31) + (this.f68792e ? 1 : 0)) * 31) + (this.f68793f ? 1 : 0)) * 31) + (this.f68794g ? 1 : 0);
    }

    public void i(boolean z) {
        this.f68788a = z;
    }

    public void j(ByteBuffer byteBuffer) {
        this.f68790c = byteBuffer;
    }

    public void k(boolean z) {
        this.f68792e = z;
    }

    public void l(boolean z) {
        this.f68793f = z;
    }

    public void m(boolean z) {
        this.f68794g = z;
    }

    public void n(boolean z) {
        this.f68791d = z;
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
        sb.append(this.f68790c.position());
        sb.append(", len:");
        sb.append(this.f68790c.remaining());
        sb.append("], payload:");
        sb.append(this.f68790c.remaining() > 1000 ? "(too big to display)" : new String(this.f68790c.array()));
        sb.append('}');
        return sb.toString();
    }
}
