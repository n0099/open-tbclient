package d.a.c.e.d;

import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.d.l;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f39609a;

    /* renamed from: b  reason: collision with root package name */
    public final e f39610b;

    public d(e eVar, boolean z) {
        this.f39610b = eVar;
        this.f39609a = z;
    }

    @Override // d.a.c.e.d.k
    public e b() {
        return this.f39610b;
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
        bVar.f39632a = str2;
        bVar.f39633b = k.f39616b;
        long j = k.f39620f;
        bVar.f39634c = k.f39618d;
        return bVar;
    }

    @Override // d.a.c.e.d.k
    public T e(String str, String str2) {
        g<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        return k.f39616b;
    }

    @Override // d.a.c.e.d.k
    public void f(String str, String str2, T t, long j) {
        g<T> gVar = new g<>();
        gVar.f39615a = h(str, str2);
        gVar.f39617c = str;
        gVar.f39620f = j;
        gVar.f39616b = t;
        gVar.f39619e = System.currentTimeMillis();
        gVar.f39618d = System.currentTimeMillis();
        j(gVar);
    }

    public String h(String str, String str2) {
        if (this.f39609a) {
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
        } else if (i2.f39620f < System.currentTimeMillis()) {
            m(h2);
            BdLog.isDebugMode();
            return null;
        } else {
            if (this.f39610b.a()) {
                i2.f39619e = System.currentTimeMillis();
                j(i2);
            }
            BdLog.isDebugMode();
            return i2;
        }
    }

    public abstract void l(String str);

    public abstract void m(String str);
}
