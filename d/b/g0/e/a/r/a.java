package d.b.g0.e.a.r;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f47689b;

    /* renamed from: a  reason: collision with root package name */
    public List<k> f47690a = new CopyOnWriteArrayList();

    public static a b() {
        if (f47689b == null) {
            synchronized (a.class) {
                if (f47689b == null) {
                    f47689b = new a();
                }
            }
        }
        return f47689b;
    }

    public void a(k kVar) {
        if (kVar == null || this.f47690a.contains(kVar)) {
            return;
        }
        this.f47690a.add(kVar);
    }

    public void c(int i, String str) {
        for (k kVar : this.f47690a) {
            if (i == 16) {
                kVar.c();
            } else if (i == 17) {
                kVar.b(str);
            }
            d(kVar);
        }
    }

    public void d(k kVar) {
        if (this.f47690a.contains(kVar)) {
            this.f47690a.remove(kVar);
        }
    }
}
