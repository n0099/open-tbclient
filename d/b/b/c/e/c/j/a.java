package d.b.b.c.e.c.j;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static byte f41522g = 4;

    /* renamed from: h  reason: collision with root package name */
    public static byte f41523h = Byte.MIN_VALUE;
    public static byte i = 64;
    public static byte j = 8;
    public static byte k = 4;

    /* renamed from: d  reason: collision with root package name */
    public int f41527d;

    /* renamed from: e  reason: collision with root package name */
    public int f41528e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f41524a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f41525b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41526c = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f41529f = false;

    public static a a(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, f());
        a aVar = new a();
        byte b2 = wrap.get();
        if ((f41523h & b2) != 0) {
            aVar.f41524a = true;
        }
        if ((i & b2) != 0) {
            aVar.f41525b = true;
        }
        if ((j & b2) != 0) {
            aVar.f41526c = true;
        }
        if ((b2 & k) != 0) {
            aVar.f41529f = true;
        }
        aVar.f41527d = wrap.getInt();
        aVar.f41528e = wrap.getInt();
        return aVar;
    }

    public static int f() {
        return 9;
    }

    public static byte[] i(boolean z, boolean z2, int i2, int i3, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate(f() + (bArr != null ? bArr.length : 0));
        byte b2 = z ? (byte) (f41523h | 0) : (byte) 0;
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
        return this.f41527d;
    }

    public boolean c() {
        return this.f41525b;
    }

    public boolean d() {
        return this.f41524a;
    }

    public boolean e() {
        return this.f41529f;
    }

    public boolean g() {
        return this.f41526c;
    }

    public int h() {
        return this.f41528e;
    }
}
