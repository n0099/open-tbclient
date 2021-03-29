package d.b.b.d;

import com.baidu.adp.gif.NSGif;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: d.b.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0533a implements a {

        /* renamed from: c  reason: collision with root package name */
        public static a f41575c;

        /* renamed from: a  reason: collision with root package name */
        public int f41576a;

        /* renamed from: b  reason: collision with root package name */
        public final d f41577b = new d();

        public C0533a() {
            this.f41576a = 0;
            if (NSGif.f2135f) {
                this.f41576a = 0;
            } else {
                this.f41576a = 1;
            }
        }

        public static synchronized a b() {
            a aVar;
            synchronized (C0533a.class) {
                if (f41575c == null) {
                    f41575c = new C0533a();
                }
                aVar = f41575c;
            }
            return aVar;
        }

        @Override // d.b.b.d.a
        public d.b.b.j.d.a a(byte[] bArr, int i, int i2) {
            if (this.f41576a == 0) {
                try {
                    return this.f41577b.a(bArr, i, i2);
                } catch (Exception unused) {
                }
            }
            return null;
        }

        @Override // d.b.b.d.a
        public d.b.b.j.d.a get(String str) {
            if (this.f41576a == 0) {
                try {
                    return this.f41577b.get(str);
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }

    d.b.b.j.d.a a(byte[] bArr, int i, int i2);

    d.b.b.j.d.a get(String str);
}
