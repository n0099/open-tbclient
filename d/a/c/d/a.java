package d.a.c.d;

import com.baidu.adp.gif.NSGif;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: d.a.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0509a implements a {

        /* renamed from: c  reason: collision with root package name */
        public static a f39505c;

        /* renamed from: a  reason: collision with root package name */
        public int f39506a;

        /* renamed from: b  reason: collision with root package name */
        public final d f39507b = new d();

        public C0509a() {
            this.f39506a = 0;
            if (NSGif.f2134f) {
                this.f39506a = 0;
            } else {
                this.f39506a = 1;
            }
        }

        public static synchronized a b() {
            a aVar;
            synchronized (C0509a.class) {
                if (f39505c == null) {
                    f39505c = new C0509a();
                }
                aVar = f39505c;
            }
            return aVar;
        }

        @Override // d.a.c.d.a
        public d.a.c.j.d.a a(byte[] bArr, int i2, int i3) {
            if (this.f39506a == 0) {
                try {
                    return this.f39507b.a(bArr, i2, i3);
                } catch (Exception unused) {
                }
            }
            return null;
        }

        @Override // d.a.c.d.a
        public d.a.c.j.d.a get(String str) {
            if (this.f39506a == 0) {
                try {
                    return this.f39507b.get(str);
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }

    d.a.c.j.d.a a(byte[] bArr, int i2, int i3);

    d.a.c.j.d.a get(String str);
}
