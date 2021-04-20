package d.b.c.d;

import com.baidu.adp.gif.NSGif;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: d.b.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0551a implements a {

        /* renamed from: c  reason: collision with root package name */
        public static a f42072c;

        /* renamed from: a  reason: collision with root package name */
        public int f42073a;

        /* renamed from: b  reason: collision with root package name */
        public final d f42074b = new d();

        public C0551a() {
            this.f42073a = 0;
            if (NSGif.f2170f) {
                this.f42073a = 0;
            } else {
                this.f42073a = 1;
            }
        }

        public static synchronized a b() {
            a aVar;
            synchronized (C0551a.class) {
                if (f42072c == null) {
                    f42072c = new C0551a();
                }
                aVar = f42072c;
            }
            return aVar;
        }

        @Override // d.b.c.d.a
        public d.b.c.j.d.a a(byte[] bArr, int i, int i2) {
            if (this.f42073a == 0) {
                try {
                    return this.f42074b.a(bArr, i, i2);
                } catch (Exception unused) {
                }
            }
            return null;
        }

        @Override // d.b.c.d.a
        public d.b.c.j.d.a get(String str) {
            if (this.f42073a == 0) {
                try {
                    return this.f42074b.get(str);
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }

    d.b.c.j.d.a a(byte[] bArr, int i, int i2);

    d.b.c.j.d.a get(String str);
}
