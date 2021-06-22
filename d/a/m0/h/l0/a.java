package d.a.m0.h.l0;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final ReentrantLock f51223c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f51224d;

    /* renamed from: a  reason: collision with root package name */
    public List<c> f51225a = new ArrayList(3);

    /* renamed from: b  reason: collision with root package name */
    public d f51226b;

    public static a a() {
        if (f51224d == null) {
            synchronized (a.class) {
                if (f51224d == null) {
                    f51224d = new a();
                }
            }
        }
        return f51224d;
    }

    public void b() {
        this.f51226b = null;
        this.f51225a.clear();
    }

    public final void c(c cVar) {
        f51223c.lock();
        try {
            if (this.f51226b != null) {
                this.f51226b.a(cVar);
            } else {
                this.f51225a.add(cVar);
            }
        } finally {
            f51223c.unlock();
        }
    }

    public void d(String str, boolean z) {
        d.a.m0.a.e0.d.g("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        c(cVar);
    }

    public final void e() {
        if (this.f51225a.isEmpty() || this.f51226b == null) {
            return;
        }
        f51223c.lock();
        try {
            for (c cVar : this.f51225a) {
                this.f51226b.a(cVar);
            }
            this.f51225a.clear();
        } finally {
            f51223c.unlock();
        }
    }

    public void f(d dVar) {
        this.f51226b = dVar;
        e();
    }
}
