package d.b.h0.g.h0;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final ReentrantLock f48872c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f48873d;

    /* renamed from: a  reason: collision with root package name */
    public List<c> f48874a = new ArrayList(3);

    /* renamed from: b  reason: collision with root package name */
    public d f48875b;

    public static a a() {
        if (f48873d == null) {
            synchronized (a.class) {
                if (f48873d == null) {
                    f48873d = new a();
                }
            }
        }
        return f48873d;
    }

    public void b() {
        this.f48875b = null;
        this.f48874a.clear();
    }

    public final void c(c cVar) {
        f48872c.lock();
        try {
            if (this.f48875b != null) {
                this.f48875b.a(cVar);
            } else {
                this.f48874a.add(cVar);
            }
        } finally {
            f48872c.unlock();
        }
    }

    public void d(String str, boolean z) {
        d.b.h0.a.c0.c.g("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        c(cVar);
    }

    public final void e() {
        if (this.f48874a.isEmpty() || this.f48875b == null) {
            return;
        }
        f48872c.lock();
        try {
            for (c cVar : this.f48874a) {
                this.f48875b.a(cVar);
            }
            this.f48874a.clear();
        } finally {
            f48872c.unlock();
        }
    }

    public void f(d dVar) {
        this.f48875b = dVar;
        e();
    }
}
