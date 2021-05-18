package d.a.c.d;

import com.baidu.adp.gif.NSGif;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: d.a.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0496a implements a {

        /* renamed from: c  reason: collision with root package name */
        public static a f38750c;

        /* renamed from: a  reason: collision with root package name */
        public int f38751a;

        /* renamed from: b  reason: collision with root package name */
        public final d f38752b = new d();

        public C0496a() {
            this.f38751a = 0;
            if (NSGif.f2134f) {
                this.f38751a = 0;
            } else {
                this.f38751a = 1;
            }
        }

        public static synchronized a b() {
            a aVar;
            synchronized (C0496a.class) {
                if (f38750c == null) {
                    f38750c = new C0496a();
                }
                aVar = f38750c;
            }
            return aVar;
        }

        @Override // d.a.c.d.a
        public d.a.c.j.d.a a(byte[] bArr, int i2, int i3) {
            if (this.f38751a == 0) {
                try {
                    return this.f38752b.a(bArr, i2, i3);
                } catch (Exception unused) {
                }
            }
            return null;
        }

        @Override // d.a.c.d.a
        public d.a.c.j.d.a get(String str) {
            if (this.f38751a == 0) {
                try {
                    return this.f38752b.get(str);
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }

    d.a.c.j.d.a a(byte[] bArr, int i2, int i3);

    d.a.c.j.d.a get(String str);
}
