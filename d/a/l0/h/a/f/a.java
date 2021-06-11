package d.a.l0.h.a.f;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f50781b;

    /* renamed from: a  reason: collision with root package name */
    public List<c> f50782a = new CopyOnWriteArrayList();

    public static a b() {
        if (f50781b == null) {
            synchronized (a.class) {
                if (f50781b == null) {
                    f50781b = new a();
                }
            }
        }
        return f50781b;
    }

    public void a(c cVar) {
        if (cVar == null || this.f50782a.contains(cVar)) {
            return;
        }
        this.f50782a.add(cVar);
    }

    public void c(int i2, String str) {
        for (c cVar : this.f50782a) {
            if (i2 == 16) {
                cVar.c();
            } else if (i2 == 17) {
                cVar.b(str);
            }
            d(cVar);
        }
    }

    public void d(c cVar) {
        if (this.f50782a.contains(cVar)) {
            this.f50782a.remove(cVar);
        }
    }
}
