package d.b.g0.g.h0;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final ReentrantLock f48151c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f48152d;

    /* renamed from: a  reason: collision with root package name */
    public List<c> f48153a = new ArrayList(3);

    /* renamed from: b  reason: collision with root package name */
    public d f48154b;

    public static a a() {
        if (f48152d == null) {
            synchronized (a.class) {
                if (f48152d == null) {
                    f48152d = new a();
                }
            }
        }
        return f48152d;
    }

    public void b() {
        this.f48154b = null;
        this.f48153a.clear();
    }

    public final void c(c cVar) {
        f48151c.lock();
        try {
            if (this.f48154b != null) {
                this.f48154b.a(cVar);
            } else {
                this.f48153a.add(cVar);
            }
        } finally {
            f48151c.unlock();
        }
    }

    public void d(String str, boolean z) {
        d.b.g0.a.c0.c.g("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        c(cVar);
    }

    public final void e() {
        if (this.f48153a.isEmpty() || this.f48154b == null) {
            return;
        }
        f48151c.lock();
        try {
            for (c cVar : this.f48153a) {
                this.f48154b.a(cVar);
            }
            this.f48153a.clear();
        } finally {
            f48151c.unlock();
        }
    }

    public void f(d dVar) {
        this.f48154b = dVar;
        e();
    }
}
