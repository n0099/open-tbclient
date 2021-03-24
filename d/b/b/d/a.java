package d.b.b.d;

import com.baidu.adp.gif.NSGif;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: d.b.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0532a implements a {

        /* renamed from: c  reason: collision with root package name */
        public static a f41574c;

        /* renamed from: a  reason: collision with root package name */
        public int f41575a;

        /* renamed from: b  reason: collision with root package name */
        public final d f41576b = new d();

        public C0532a() {
            this.f41575a = 0;
            if (NSGif.f2134f) {
                this.f41575a = 0;
            } else {
                this.f41575a = 1;
            }
        }

        public static synchronized a b() {
            a aVar;
            synchronized (C0532a.class) {
                if (f41574c == null) {
                    f41574c = new C0532a();
                }
                aVar = f41574c;
            }
            return aVar;
        }

        @Override // d.b.b.d.a
        public d.b.b.j.d.a a(byte[] bArr, int i, int i2) {
            if (this.f41575a == 0) {
                try {
                    return this.f41576b.a(bArr, i, i2);
                } catch (Exception unused) {
                }
            }
            return null;
        }

        @Override // d.b.b.d.a
        public d.b.b.j.d.a get(String str) {
            if (this.f41575a == 0) {
                try {
                    return this.f41576b.get(str);
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }

    d.b.b.j.d.a a(byte[] bArr, int i, int i2);

    d.b.b.j.d.a get(String str);
}
