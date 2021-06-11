package d.a.c.c.e.c.j;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static byte f42010g = 4;

    /* renamed from: h  reason: collision with root package name */
    public static byte f42011h = Byte.MIN_VALUE;

    /* renamed from: i  reason: collision with root package name */
    public static byte f42012i = 64;
    public static byte j = 8;
    public static byte k = 4;

    /* renamed from: d  reason: collision with root package name */
    public int f42016d;

    /* renamed from: e  reason: collision with root package name */
    public int f42017e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f42013a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42014b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f42015c = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42018f = false;

    public static a a(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, f());
        a aVar = new a();
        byte b2 = wrap.get();
        if ((f42011h & b2) != 0) {
            aVar.f42013a = true;
        }
        if ((f42012i & b2) != 0) {
            aVar.f42014b = true;
        }
        if ((j & b2) != 0) {
            aVar.f42015c = true;
        }
        if ((b2 & k) != 0) {
            aVar.f42018f = true;
        }
        aVar.f42016d = wrap.getInt();
        aVar.f42017e = wrap.getInt();
        return aVar;
    }

    public static int f() {
        return 9;
    }

    public static byte[] i(boolean z, boolean z2, int i2, int i3, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate(f() + (bArr != null ? bArr.length : 0));
        byte b2 = z ? (byte) (f42011h | 0) : (byte) 0;
        if (z2) {
            b2 = (byte) (f42012i | b2);
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
        return this.f42016d;
    }

    public boolean c() {
        return this.f42014b;
    }

    public boolean d() {
        return this.f42013a;
    }

    public boolean e() {
        return this.f42018f;
    }

    public boolean g() {
        return this.f42015c;
    }

    public int h() {
        return this.f42017e;
    }
}
