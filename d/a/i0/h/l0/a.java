package d.a.i0.h.l0;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final ReentrantLock f47265c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f47266d;

    /* renamed from: a  reason: collision with root package name */
    public List<c> f47267a = new ArrayList(3);

    /* renamed from: b  reason: collision with root package name */
    public d f47268b;

    public static a a() {
        if (f47266d == null) {
            synchronized (a.class) {
                if (f47266d == null) {
                    f47266d = new a();
                }
            }
        }
        return f47266d;
    }

    public void b() {
        this.f47268b = null;
        this.f47267a.clear();
    }

    public final void c(c cVar) {
        f47265c.lock();
        try {
            if (this.f47268b != null) {
                this.f47268b.a(cVar);
            } else {
                this.f47267a.add(cVar);
            }
        } finally {
            f47265c.unlock();
        }
    }

    public void d(String str, boolean z) {
        d.a.i0.a.e0.d.g("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        c(cVar);
    }

    public final void e() {
        if (this.f47267a.isEmpty() || this.f47268b == null) {
            return;
        }
        f47265c.lock();
        try {
            for (c cVar : this.f47267a) {
                this.f47268b.a(cVar);
            }
            this.f47267a.clear();
        } finally {
            f47265c.unlock();
        }
    }

    public void f(d dVar) {
        this.f47268b = dVar;
        e();
    }
}
