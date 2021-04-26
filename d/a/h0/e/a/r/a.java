package d.a.h0.e.a.r;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f45868b;

    /* renamed from: a  reason: collision with root package name */
    public List<k> f45869a = new CopyOnWriteArrayList();

    public static a b() {
        if (f45868b == null) {
            synchronized (a.class) {
                if (f45868b == null) {
                    f45868b = new a();
                }
            }
        }
        return f45868b;
    }

    public void a(k kVar) {
        if (kVar == null || this.f45869a.contains(kVar)) {
            return;
        }
        this.f45869a.add(kVar);
    }

    public void c(int i2, String str) {
        for (k kVar : this.f45869a) {
            if (i2 == 16) {
                kVar.c();
            } else if (i2 == 17) {
                kVar.b(str);
            }
            d(kVar);
        }
    }

    public void d(k kVar) {
        if (this.f45869a.contains(kVar)) {
            this.f45869a.remove(kVar);
        }
    }
}
