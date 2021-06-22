package d.a.c.c.e.c.j;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static byte f42113g = 4;

    /* renamed from: h  reason: collision with root package name */
    public static byte f42114h = Byte.MIN_VALUE;

    /* renamed from: i  reason: collision with root package name */
    public static byte f42115i = 64;
    public static byte j = 8;
    public static byte k = 4;

    /* renamed from: d  reason: collision with root package name */
    public int f42119d;

    /* renamed from: e  reason: collision with root package name */
    public int f42120e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f42116a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42117b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f42118c = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42121f = false;

    public static a a(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, f());
        a aVar = new a();
        byte b2 = wrap.get();
        if ((f42114h & b2) != 0) {
            aVar.f42116a = true;
        }
        if ((f42115i & b2) != 0) {
            aVar.f42117b = true;
        }
        if ((j & b2) != 0) {
            aVar.f42118c = true;
        }
        if ((b2 & k) != 0) {
            aVar.f42121f = true;
        }
        aVar.f42119d = wrap.getInt();
        aVar.f42120e = wrap.getInt();
        return aVar;
    }

    public static int f() {
        return 9;
    }

    public static byte[] i(boolean z, boolean z2, int i2, int i3, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate(f() + (bArr != null ? bArr.length : 0));
        byte b2 = z ? (byte) (f42114h | 0) : (byte) 0;
        if (z2) {
            b2 = (byte) (f42115i | b2);
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
        return this.f42119d;
    }

    public boolean c() {
        return this.f42117b;
    }

    public boolean d() {
        return this.f42116a;
    }

    public boolean e() {
        return this.f42121f;
    }

    public boolean g() {
        return this.f42118c;
    }

    public int h() {
        return this.f42120e;
    }
}
