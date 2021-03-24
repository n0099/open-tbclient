package g.c.h;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class f implements Framedata {

    /* renamed from: b  reason: collision with root package name */
    public Framedata.Opcode f67631b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f67632c = g.c.k.b.a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f67630a = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f67633d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67634e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67635f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67636g = false;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f67637a;

        static {
            int[] iArr = new int[Framedata.Opcode.values().length];
            f67637a = iArr;
            try {
                iArr[Framedata.Opcode.PING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f67637a[Framedata.Opcode.PONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f67637a[Framedata.Opcode.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f67637a[Framedata.Opcode.BINARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f67637a[Framedata.Opcode.CLOSING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f67637a[Framedata.Opcode.CONTINUOUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public f(Framedata.Opcode opcode) {
        this.f67631b = opcode;
    }

    public static f g(Framedata.Opcode opcode) {
        if (opcode != null) {
            switch (a.f67637a[opcode.ordinal()]) {
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
        return this.f67634e;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean b() {
        return this.f67635f;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode c() {
        return this.f67631b;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean d() {
        return this.f67636g;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean e() {
        return this.f67630a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f67630a == fVar.f67630a && this.f67633d == fVar.f67633d && this.f67634e == fVar.f67634e && this.f67635f == fVar.f67635f && this.f67636g == fVar.f67636g && this.f67631b == fVar.f67631b) {
            ByteBuffer byteBuffer = this.f67632c;
            ByteBuffer byteBuffer2 = fVar.f67632c;
            return byteBuffer != null ? byteBuffer.equals(byteBuffer2) : byteBuffer2 == null;
        }
        return false;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer f() {
        return this.f67632c;
    }

    public abstract void h() throws InvalidDataException;

    public int hashCode() {
        int hashCode = (((this.f67630a ? 1 : 0) * 31) + this.f67631b.hashCode()) * 31;
        ByteBuffer byteBuffer = this.f67632c;
        return ((((((((hashCode + (byteBuffer != null ? byteBuffer.hashCode() : 0)) * 31) + (this.f67633d ? 1 : 0)) * 31) + (this.f67634e ? 1 : 0)) * 31) + (this.f67635f ? 1 : 0)) * 31) + (this.f67636g ? 1 : 0);
    }

    public void i(boolean z) {
        this.f67630a = z;
    }

    public void j(ByteBuffer byteBuffer) {
        this.f67632c = byteBuffer;
    }

    public void k(boolean z) {
        this.f67634e = z;
    }

    public void l(boolean z) {
        this.f67635f = z;
    }

    public void m(boolean z) {
        this.f67636g = z;
    }

    public void n(boolean z) {
        this.f67633d = z;
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
        sb.append(this.f67632c.position());
        sb.append(", len:");
        sb.append(this.f67632c.remaining());
        sb.append("], payload:");
        sb.append(this.f67632c.remaining() > 1000 ? "(too big to display)" : new String(this.f67632c.array()));
        sb.append('}');
        return sb.toString();
    }
}
