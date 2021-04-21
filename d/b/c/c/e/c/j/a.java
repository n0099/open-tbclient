package d.b.c.c.e.c.j;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static byte f42260g = 4;

    /* renamed from: h  reason: collision with root package name */
    public static byte f42261h = Byte.MIN_VALUE;
    public static byte i = 64;
    public static byte j = 8;
    public static byte k = 4;

    /* renamed from: d  reason: collision with root package name */
    public int f42265d;

    /* renamed from: e  reason: collision with root package name */
    public int f42266e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f42262a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42263b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f42264c = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42267f = false;

    public static a a(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, f());
        a aVar = new a();
        byte b2 = wrap.get();
        if ((f42261h & b2) != 0) {
            aVar.f42262a = true;
        }
        if ((i & b2) != 0) {
            aVar.f42263b = true;
        }
        if ((j & b2) != 0) {
            aVar.f42264c = true;
        }
        if ((b2 & k) != 0) {
            aVar.f42267f = true;
        }
        aVar.f42265d = wrap.getInt();
        aVar.f42266e = wrap.getInt();
        return aVar;
    }

    public static int f() {
        return 9;
    }

    public static byte[] i(boolean z, boolean z2, int i2, int i3, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate(f() + (bArr != null ? bArr.length : 0));
        byte b2 = z ? (byte) (f42261h | 0) : (byte) 0;
        if (z2) {
            b2 = (byte) (i | b2);
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
        return this.f42265d;
    }

    public boolean c() {
        return this.f42263b;
    }

    public boolean d() {
        return this.f42262a;
    }

    public boolean e() {
        return this.f42267f;
    }

    public boolean g() {
        return this.f42264c;
    }

    public int h() {
        return this.f42266e;
    }
}
