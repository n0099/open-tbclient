package g.c.h;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class f implements Framedata {

    /* renamed from: b  reason: collision with root package name */
    public Framedata.Opcode f68642b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f68643c = g.c.k.b.a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f68641a = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f68644d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f68645e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f68646f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68647g = false;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f68648a;

        static {
            int[] iArr = new int[Framedata.Opcode.values().length];
            f68648a = iArr;
            try {
                iArr[Framedata.Opcode.PING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68648a[Framedata.Opcode.PONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f68648a[Framedata.Opcode.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f68648a[Framedata.Opcode.BINARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f68648a[Framedata.Opcode.CLOSING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f68648a[Framedata.Opcode.CONTINUOUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public f(Framedata.Opcode opcode) {
        this.f68642b = opcode;
    }

    public static f g(Framedata.Opcode opcode) {
        if (opcode != null) {
            switch (a.f68648a[opcode.ordinal()]) {
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
        return this.f68645e;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean b() {
        return this.f68646f;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode c() {
        return this.f68642b;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean d() {
        return this.f68647g;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean e() {
        return this.f68641a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f68641a == fVar.f68641a && this.f68644d == fVar.f68644d && this.f68645e == fVar.f68645e && this.f68646f == fVar.f68646f && this.f68647g == fVar.f68647g && this.f68642b == fVar.f68642b) {
            ByteBuffer byteBuffer = this.f68643c;
            ByteBuffer byteBuffer2 = fVar.f68643c;
            return byteBuffer != null ? byteBuffer.equals(byteBuffer2) : byteBuffer2 == null;
        }
        return false;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer f() {
        return this.f68643c;
    }

    public abstract void h() throws InvalidDataException;

    public int hashCode() {
        int hashCode = (((this.f68641a ? 1 : 0) * 31) + this.f68642b.hashCode()) * 31;
        ByteBuffer byteBuffer = this.f68643c;
        return ((((((((hashCode + (byteBuffer != null ? byteBuffer.hashCode() : 0)) * 31) + (this.f68644d ? 1 : 0)) * 31) + (this.f68645e ? 1 : 0)) * 31) + (this.f68646f ? 1 : 0)) * 31) + (this.f68647g ? 1 : 0);
    }

    public void i(boolean z) {
        this.f68641a = z;
    }

    public void j(ByteBuffer byteBuffer) {
        this.f68643c = byteBuffer;
    }

    public void k(boolean z) {
        this.f68645e = z;
    }

    public void l(boolean z) {
        this.f68646f = z;
    }

    public void m(boolean z) {
        this.f68647g = z;
    }

    public void n(boolean z) {
        this.f68644d = z;
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
        sb.append(this.f68643c.position());
        sb.append(", len:");
        sb.append(this.f68643c.remaining());
        sb.append("], payload:");
        sb.append(this.f68643c.remaining() > 1000 ? "(too big to display)" : new String(this.f68643c.array()));
        sb.append('}');
        return sb.toString();
    }
}
