package d.a.c.e.d;

import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.d.l;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f42171a;

    /* renamed from: b  reason: collision with root package name */
    public final e f42172b;

    public d(e eVar, boolean z) {
        this.f42172b = eVar;
        this.f42171a = z;
    }

    @Override // d.a.c.e.d.k
    public e b() {
        return this.f42172b;
    }

    @Override // d.a.c.e.d.k
    public void c(String str, String str2) {
        l(h(str, str2));
    }

    @Override // d.a.c.e.d.k
    public l.b<T> d(String str, String str2) {
        g<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        l.b<T> bVar = new l.b<>();
        bVar.f42194a = str2;
        bVar.f42195b = k.f42178b;
        long j = k.f42182f;
        bVar.f42196c = k.f42180d;
        return bVar;
    }

    @Override // d.a.c.e.d.k
    public T e(String str, String str2) {
        g<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        return k.f42178b;
    }

    @Override // d.a.c.e.d.k
    public void f(String str, String str2, T t, long j) {
        g<T> gVar = new g<>();
        gVar.f42177a = h(str, str2);
        gVar.f42179c = str;
        gVar.f42182f = j;
        gVar.f42178b = t;
        gVar.f42181e = System.currentTimeMillis();
        gVar.f42180d = System.currentTimeMillis();
        j(gVar);
    }

    public String h(String str, String str2) {
        if (this.f42171a) {
            return str + "@" + str2;
        }
        return str2;
    }

    public abstract g<T> i(String str);

    public abstract void j(g<T> gVar);

    public g<T> k(String str, String str2) {
        String h2 = h(str, str2);
        g<T> i2 = i(h2);
        if (i2 == null) {
            BdLog.isDebugMode();
            return null;
        } else if (i2.f42182f < System.currentTimeMillis()) {
            m(h2);
            BdLog.isDebugMode();
            return null;
        } else {
            if (this.f42172b.a()) {
                i2.f42181e = System.currentTimeMillis();
                j(i2);
            }
            BdLog.isDebugMode();
            return i2;
        }
    }

    public abstract void l(String str);

    public abstract void m(String str);
}
