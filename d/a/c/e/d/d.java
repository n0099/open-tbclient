package d.a.c.e.d;

import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.d.l;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f38518a;

    /* renamed from: b  reason: collision with root package name */
    public final e f38519b;

    public d(e eVar, boolean z) {
        this.f38519b = eVar;
        this.f38518a = z;
    }

    @Override // d.a.c.e.d.k
    public e b() {
        return this.f38519b;
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
        bVar.f38541a = str2;
        bVar.f38542b = k.f38525b;
        long j = k.f38529f;
        bVar.f38543c = k.f38527d;
        return bVar;
    }

    @Override // d.a.c.e.d.k
    public T e(String str, String str2) {
        g<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        return k.f38525b;
    }

    @Override // d.a.c.e.d.k
    public void f(String str, String str2, T t, long j) {
        g<T> gVar = new g<>();
        gVar.f38524a = h(str, str2);
        gVar.f38526c = str;
        gVar.f38529f = j;
        gVar.f38525b = t;
        gVar.f38528e = System.currentTimeMillis();
        gVar.f38527d = System.currentTimeMillis();
        j(gVar);
    }

    public String h(String str, String str2) {
        if (this.f38518a) {
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
        } else if (i2.f38529f < System.currentTimeMillis()) {
            m(h2);
            BdLog.isDebugMode();
            return null;
        } else {
            if (this.f38519b.a()) {
                i2.f38528e = System.currentTimeMillis();
                j(i2);
            }
            BdLog.isDebugMode();
            return i2;
        }
    }

    public abstract void l(String str);

    public abstract void m(String str);
}
