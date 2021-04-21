package d.b.h0.e.a.r;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f48411b;

    /* renamed from: a  reason: collision with root package name */
    public List<k> f48412a = new CopyOnWriteArrayList();

    public static a b() {
        if (f48411b == null) {
            synchronized (a.class) {
                if (f48411b == null) {
                    f48411b = new a();
                }
            }
        }
        return f48411b;
    }

    public void a(k kVar) {
        if (kVar == null || this.f48412a.contains(kVar)) {
            return;
        }
        this.f48412a.add(kVar);
    }

    public void c(int i, String str) {
        for (k kVar : this.f48412a) {
            if (i == 16) {
                kVar.c();
            } else if (i == 17) {
                kVar.b(str);
            }
            d(kVar);
        }
    }

    public void d(k kVar) {
        if (this.f48412a.contains(kVar)) {
            this.f48412a.remove(kVar);
        }
    }
}
