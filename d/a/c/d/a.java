package d.a.c.d;

import com.baidu.adp.gif.NSGif;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: d.a.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0536a implements a {

        /* renamed from: c  reason: collision with root package name */
        public static a f42067c;

        /* renamed from: a  reason: collision with root package name */
        public int f42068a;

        /* renamed from: b  reason: collision with root package name */
        public final d f42069b = new d();

        public C0536a() {
            this.f42068a = 0;
            if (NSGif.f2152f) {
                this.f42068a = 0;
            } else {
                this.f42068a = 1;
            }
        }

        public static synchronized a b() {
            a aVar;
            synchronized (C0536a.class) {
                if (f42067c == null) {
                    f42067c = new C0536a();
                }
                aVar = f42067c;
            }
            return aVar;
        }

        @Override // d.a.c.d.a
        public d.a.c.k.d.a a(byte[] bArr, int i2, int i3) {
            if (this.f42068a == 0) {
                try {
                    return this.f42069b.a(bArr, i2, i3);
                } catch (Exception unused) {
                }
            }
            return null;
        }

        @Override // d.a.c.d.a
        public d.a.c.k.d.a get(String str) {
            if (this.f42068a == 0) {
                try {
                    return this.f42069b.get(str);
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }

    d.a.c.k.d.a a(byte[] bArr, int i2, int i3);

    d.a.c.k.d.a get(String str);
}
