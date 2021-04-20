package d.b.g0.e.a.r;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f48082b;

    /* renamed from: a  reason: collision with root package name */
    public List<k> f48083a = new CopyOnWriteArrayList();

    public static a b() {
        if (f48082b == null) {
            synchronized (a.class) {
                if (f48082b == null) {
                    f48082b = new a();
                }
            }
        }
        return f48082b;
    }

    public void a(k kVar) {
        if (kVar == null || this.f48083a.contains(kVar)) {
            return;
        }
        this.f48083a.add(kVar);
    }

    public void c(int i, String str) {
        for (k kVar : this.f48083a) {
            if (i == 16) {
                kVar.c();
            } else if (i == 17) {
                kVar.b(str);
            }
            d(kVar);
        }
    }

    public void d(k kVar) {
        if (this.f48083a.contains(kVar)) {
            this.f48083a.remove(kVar);
        }
    }
}
