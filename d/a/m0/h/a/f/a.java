package d.a.m0.h.a.f;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f50889b;

    /* renamed from: a  reason: collision with root package name */
    public List<c> f50890a = new CopyOnWriteArrayList();

    public static a b() {
        if (f50889b == null) {
            synchronized (a.class) {
                if (f50889b == null) {
                    f50889b = new a();
                }
            }
        }
        return f50889b;
    }

    public void a(c cVar) {
        if (cVar == null || this.f50890a.contains(cVar)) {
            return;
        }
        this.f50890a.add(cVar);
    }

    public void c(int i2, String str) {
        for (c cVar : this.f50890a) {
            if (i2 == 16) {
                cVar.c();
            } else if (i2 == 17) {
                cVar.b(str);
            }
            d(cVar);
        }
    }

    public void d(c cVar) {
        if (this.f50890a.contains(cVar)) {
            this.f50890a.remove(cVar);
        }
    }
}
