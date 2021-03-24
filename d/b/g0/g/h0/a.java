package d.b.g0.g.h0;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final ReentrantLock f48150c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f48151d;

    /* renamed from: a  reason: collision with root package name */
    public List<c> f48152a = new ArrayList(3);

    /* renamed from: b  reason: collision with root package name */
    public d f48153b;

    public static a a() {
        if (f48151d == null) {
            synchronized (a.class) {
                if (f48151d == null) {
                    f48151d = new a();
                }
            }
        }
        return f48151d;
    }

    public void b() {
        this.f48153b = null;
        this.f48152a.clear();
    }

    public final void c(c cVar) {
        f48150c.lock();
        try {
            if (this.f48153b != null) {
                this.f48153b.a(cVar);
            } else {
                this.f48152a.add(cVar);
            }
        } finally {
            f48150c.unlock();
        }
    }

    public void d(String str, boolean z) {
        d.b.g0.a.c0.c.g("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        c(cVar);
    }

    public final void e() {
        if (this.f48152a.isEmpty() || this.f48153b == null) {
            return;
        }
        f48150c.lock();
        try {
            for (c cVar : this.f48152a) {
                this.f48153b.a(cVar);
            }
            this.f48152a.clear();
        } finally {
            f48150c.unlock();
        }
    }

    public void f(d dVar) {
        this.f48153b = dVar;
        e();
    }
}
