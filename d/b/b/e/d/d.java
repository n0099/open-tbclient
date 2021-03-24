package d.b.b.e.d;

import com.baidu.adp.lib.util.BdLog;
import d.b.b.e.d.l;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f41677a;

    /* renamed from: b  reason: collision with root package name */
    public final e f41678b;

    public d(e eVar, boolean z) {
        this.f41678b = eVar;
        this.f41677a = z;
    }

    @Override // d.b.b.e.d.k
    public e b() {
        return this.f41678b;
    }

    @Override // d.b.b.e.d.k
    public void c(String str, String str2) {
        l(h(str, str2));
    }

    @Override // d.b.b.e.d.k
    public l.b<T> d(String str, String str2) {
        g<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        l.b<T> bVar = new l.b<>();
        bVar.f41700a = str2;
        bVar.f41701b = k.f41684b;
        long j = k.f41688f;
        bVar.f41702c = k.f41686d;
        return bVar;
    }

    @Override // d.b.b.e.d.k
    public T e(String str, String str2) {
        g<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        return k.f41684b;
    }

    @Override // d.b.b.e.d.k
    public void f(String str, String str2, T t, long j) {
        g<T> gVar = new g<>();
        gVar.f41683a = h(str, str2);
        gVar.f41685c = str;
        gVar.f41688f = j;
        gVar.f41684b = t;
        gVar.f41687e = System.currentTimeMillis();
        gVar.f41686d = System.currentTimeMillis();
        j(gVar);
    }

    public String h(String str, String str2) {
        if (this.f41677a) {
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
        } else if (i.f41688f < System.currentTimeMillis()) {
            m(h2);
            BdLog.isDebugMode();
            return null;
        } else {
            if (this.f41678b.b()) {
                i.f41687e = System.currentTimeMillis();
                j(i);
            }
            BdLog.isDebugMode();
            return i;
        }
    }

    public abstract void l(String str);

    public abstract void m(String str);
}
