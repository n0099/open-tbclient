package d.a.l0.h.a.f;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f47107b;

    /* renamed from: a  reason: collision with root package name */
    public List<c> f47108a = new CopyOnWriteArrayList();

    public static a b() {
        if (f47107b == null) {
            synchronized (a.class) {
                if (f47107b == null) {
                    f47107b = new a();
                }
            }
        }
        return f47107b;
    }

    public void a(c cVar) {
        if (cVar == null || this.f47108a.contains(cVar)) {
            return;
        }
        this.f47108a.add(cVar);
    }

    public void c(int i2, String str) {
        for (c cVar : this.f47108a) {
            if (i2 == 16) {
                cVar.c();
            } else if (i2 == 17) {
                cVar.b(str);
            }
            d(cVar);
        }
    }

    public void d(c cVar) {
        if (this.f47108a.contains(cVar)) {
            this.f47108a.remove(cVar);
        }
    }
}
