package d.b.c.d;

import com.baidu.adp.gif.NSGif;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: d.b.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0570a implements a {

        /* renamed from: c  reason: collision with root package name */
        public static a f42312c;

        /* renamed from: a  reason: collision with root package name */
        public int f42313a;

        /* renamed from: b  reason: collision with root package name */
        public final d f42314b = new d();

        public C0570a() {
            this.f42313a = 0;
            if (NSGif.f2170f) {
                this.f42313a = 0;
            } else {
                this.f42313a = 1;
            }
        }

        public static synchronized a b() {
            a aVar;
            synchronized (C0570a.class) {
                if (f42312c == null) {
                    f42312c = new C0570a();
                }
                aVar = f42312c;
            }
            return aVar;
        }

        @Override // d.b.c.d.a
        public d.b.c.j.d.a a(byte[] bArr, int i, int i2) {
            if (this.f42313a == 0) {
                try {
                    return this.f42314b.a(bArr, i, i2);
                } catch (Exception unused) {
                }
            }
            return null;
        }

        @Override // d.b.c.d.a
        public d.b.c.j.d.a get(String str) {
            if (this.f42313a == 0) {
                try {
                    return this.f42314b.get(str);
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }

    d.b.c.j.d.a a(byte[] bArr, int i, int i2);

    d.b.c.j.d.a get(String str);
}
