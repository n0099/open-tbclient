package d.a.c.c.e.c.j;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static byte f38693g = 4;

    /* renamed from: h  reason: collision with root package name */
    public static byte f38694h = Byte.MIN_VALUE;

    /* renamed from: i  reason: collision with root package name */
    public static byte f38695i = 64;
    public static byte j = 8;
    public static byte k = 4;

    /* renamed from: d  reason: collision with root package name */
    public int f38699d;

    /* renamed from: e  reason: collision with root package name */
    public int f38700e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f38696a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f38697b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38698c = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f38701f = false;

    public static a a(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, f());
        a aVar = new a();
        byte b2 = wrap.get();
        if ((f38694h & b2) != 0) {
            aVar.f38696a = true;
        }
        if ((f38695i & b2) != 0) {
            aVar.f38697b = true;
        }
        if ((j & b2) != 0) {
            aVar.f38698c = true;
        }
        if ((b2 & k) != 0) {
            aVar.f38701f = true;
        }
        aVar.f38699d = wrap.getInt();
        aVar.f38700e = wrap.getInt();
        return aVar;
    }

    public static int f() {
        return 9;
    }

    public static byte[] i(boolean z, boolean z2, int i2, int i3, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate(f() + (bArr != null ? bArr.length : 0));
        byte b2 = z ? (byte) (f38694h | 0) : (byte) 0;
        if (z2) {
            b2 = (byte) (f38695i | b2);
        }
        byte b3 = (byte) (j | b2);
        if (z3) {
            b3 = (byte) (b3 | k);
        }
        allocate.put(b3);
        allocate.putInt(i2);
        allocate.putInt(i3);
        if (bArr != null) {
            allocate.put(bArr);
        }
        allocate.flip();
        return allocate.array();
    }

    public int b() {
        return this.f38699d;
    }

    public boolean c() {
        return this.f38697b;
    }

    public boolean d() {
        return this.f38696a;
    }

    public boolean e() {
        return this.f38701f;
    }

    public boolean g() {
        return this.f38698c;
    }

    public int h() {
        return this.f38700e;
    }
}
