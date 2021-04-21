package d.b.c.e.d;

import com.baidu.adp.lib.util.BdLog;
import d.b.c.e.d.l;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f42415a;

    /* renamed from: b  reason: collision with root package name */
    public final e f42416b;

    public d(e eVar, boolean z) {
        this.f42416b = eVar;
        this.f42415a = z;
    }

    @Override // d.b.c.e.d.k
    public e b() {
        return this.f42416b;
    }

    @Override // d.b.c.e.d.k
    public void c(String str, String str2) {
        l(h(str, str2));
    }

    @Override // d.b.c.e.d.k
    public l.b<T> d(String str, String str2) {
        g<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        l.b<T> bVar = new l.b<>();
        bVar.f42438a = str2;
        bVar.f42439b = k.f42422b;
        long j = k.f42426f;
        bVar.f42440c = k.f42424d;
        return bVar;
    }

    @Override // d.b.c.e.d.k
    public T e(String str, String str2) {
        g<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        return k.f42422b;
    }

    @Override // d.b.c.e.d.k
    public void f(String str, String str2, T t, long j) {
        g<T> gVar = new g<>();
        gVar.f42421a = h(str, str2);
        gVar.f42423c = str;
        gVar.f42426f = j;
        gVar.f42422b = t;
        gVar.f42425e = System.currentTimeMillis();
        gVar.f42424d = System.currentTimeMillis();
        j(gVar);
    }

    public String h(String str, String str2) {
        if (this.f42415a) {
            return str + "@" + str2;
        }
        return str2;
    }

    public abstract g<T> i(String str);

    public abstract void j(g<T> gVar);

    public g<T> k(String str, String str2) {
        String h2 = h(str, str2);
        g<T> i = i(h2);
        if (i == null) {
            BdLog.isDebugMode();
            return null;
        } else if (i.f42426f < System.currentTimeMillis()) {
            m(h2);
            BdLog.isDebugMode();
            return null;
        } else {
            if (this.f42416b.b()) {
                i.f42425e = System.currentTimeMillis();
                j(i);
            }
            BdLog.isDebugMode();
            return i;
        }
    }

    public abstract void l(String str);

    public abstract void m(String str);
}
