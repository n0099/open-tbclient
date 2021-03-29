package d.b.g0.e.a.r;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f47690b;

    /* renamed from: a  reason: collision with root package name */
    public List<k> f47691a = new CopyOnWriteArrayList();

    public static a b() {
        if (f47690b == null) {
            synchronized (a.class) {
                if (f47690b == null) {
                    f47690b = new a();
                }
            }
        }
        return f47690b;
    }

    public void a(k kVar) {
        if (kVar == null || this.f47691a.contains(kVar)) {
            return;
        }
        this.f47691a.add(kVar);
    }

    public void c(int i, String str) {
        for (k kVar : this.f47691a) {
            if (i == 16) {
                kVar.c();
            } else if (i == 17) {
                kVar.b(str);
            }
            d(kVar);
        }
    }

    public void d(k kVar) {
        if (this.f47691a.contains(kVar)) {
            this.f47691a.remove(kVar);
        }
    }
}
