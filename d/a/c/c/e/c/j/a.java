package d.a.c.c.e.c.j;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static byte f39448g = 4;

    /* renamed from: h  reason: collision with root package name */
    public static byte f39449h = Byte.MIN_VALUE;

    /* renamed from: i  reason: collision with root package name */
    public static byte f39450i = 64;
    public static byte j = 8;
    public static byte k = 4;

    /* renamed from: d  reason: collision with root package name */
    public int f39454d;

    /* renamed from: e  reason: collision with root package name */
    public int f39455e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f39451a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39452b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39453c = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f39456f = false;

    public static a a(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, f());
        a aVar = new a();
        byte b2 = wrap.get();
        if ((f39449h & b2) != 0) {
            aVar.f39451a = true;
        }
        if ((f39450i & b2) != 0) {
            aVar.f39452b = true;
        }
        if ((j & b2) != 0) {
            aVar.f39453c = true;
        }
        if ((b2 & k) != 0) {
            aVar.f39456f = true;
        }
        aVar.f39454d = wrap.getInt();
        aVar.f39455e = wrap.getInt();
        return aVar;
    }

    public static int f() {
        return 9;
    }

    public static byte[] i(boolean z, boolean z2, int i2, int i3, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate(f() + (bArr != null ? bArr.length : 0));
        byte b2 = z ? (byte) (f39449h | 0) : (byte) 0;
        if (z2) {
            b2 = (byte) (f39450i | b2);
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
        return this.f39454d;
    }

    public boolean c() {
        return this.f39452b;
    }

    public boolean d() {
        return this.f39451a;
    }

    public boolean e() {
        return this.f39456f;
    }

    public boolean g() {
        return this.f39453c;
    }

    public int h() {
        return this.f39455e;
    }
}
