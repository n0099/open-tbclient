package d.a.l0.h.l0;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final ReentrantLock f47441c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f47442d;

    /* renamed from: a  reason: collision with root package name */
    public List<c> f47443a = new ArrayList(3);

    /* renamed from: b  reason: collision with root package name */
    public d f47444b;

    public static a a() {
        if (f47442d == null) {
            synchronized (a.class) {
                if (f47442d == null) {
                    f47442d = new a();
                }
            }
        }
        return f47442d;
    }

    public void b() {
        this.f47444b = null;
        this.f47443a.clear();
    }

    public final void c(c cVar) {
        f47441c.lock();
        try {
            if (this.f47444b != null) {
                this.f47444b.a(cVar);
            } else {
                this.f47443a.add(cVar);
            }
        } finally {
            f47441c.unlock();
        }
    }

    public void d(String str, boolean z) {
        d.a.l0.a.e0.d.g("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        c(cVar);
    }

    public final void e() {
        if (this.f47443a.isEmpty() || this.f47444b == null) {
            return;
        }
        f47441c.lock();
        try {
            for (c cVar : this.f47443a) {
                this.f47444b.a(cVar);
            }
            this.f47443a.clear();
        } finally {
            f47441c.unlock();
        }
    }

    public void f(d dVar) {
        this.f47444b = dVar;
        e();
    }
}
