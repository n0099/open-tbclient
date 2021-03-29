package d.b.b.e.d;

import com.baidu.adp.lib.util.BdLog;
import d.b.b.e.d.l;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f41678a;

    /* renamed from: b  reason: collision with root package name */
    public final e f41679b;

    public d(e eVar, boolean z) {
        this.f41679b = eVar;
        this.f41678a = z;
    }

    @Override // d.b.b.e.d.k
    public e b() {
        return this.f41679b;
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
        bVar.f41701a = str2;
        bVar.f41702b = k.f41685b;
        long j = k.f41689f;
        bVar.f41703c = k.f41687d;
        return bVar;
    }

    @Override // d.b.b.e.d.k
    public T e(String str, String str2) {
        g<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        return k.f41685b;
    }

    @Override // d.b.b.e.d.k
    public void f(String str, String str2, T t, long j) {
        g<T> gVar = new g<>();
        gVar.f41684a = h(str, str2);
        gVar.f41686c = str;
        gVar.f41689f = j;
        gVar.f41685b = t;
        gVar.f41688e = System.currentTimeMillis();
        gVar.f41687d = System.currentTimeMillis();
        j(gVar);
    }

    public String h(String str, String str2) {
        if (this.f41678a) {
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
        } else if (i.f41689f < System.currentTimeMillis()) {
            m(h2);
            BdLog.isDebugMode();
            return null;
        } else {
            if (this.f41679b.b()) {
                i.f41688e = System.currentTimeMillis();
                j(i);
            }
            BdLog.isDebugMode();
            return i;
        }
    }

    public abstract void l(String str);

    public abstract void m(String str);
}
