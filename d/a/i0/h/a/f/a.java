package d.a.i0.h.a.f;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f46931b;

    /* renamed from: a  reason: collision with root package name */
    public List<c> f46932a = new CopyOnWriteArrayList();

    public static a b() {
        if (f46931b == null) {
            synchronized (a.class) {
                if (f46931b == null) {
                    f46931b = new a();
                }
            }
        }
        return f46931b;
    }

    public void a(c cVar) {
        if (cVar == null || this.f46932a.contains(cVar)) {
            return;
        }
        this.f46932a.add(cVar);
    }

    public void c(int i2, String str) {
        for (c cVar : this.f46932a) {
            if (i2 == 16) {
                cVar.c();
            } else if (i2 == 17) {
                cVar.b(str);
            }
            d(cVar);
        }
    }

    public void d(c cVar) {
        if (this.f46932a.contains(cVar)) {
            this.f46932a.remove(cVar);
        }
    }
}
