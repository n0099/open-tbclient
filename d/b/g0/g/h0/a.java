package d.b.g0.g.h0;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final ReentrantLock f48543c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f48544d;

    /* renamed from: a  reason: collision with root package name */
    public List<c> f48545a = new ArrayList(3);

    /* renamed from: b  reason: collision with root package name */
    public d f48546b;

    public static a a() {
        if (f48544d == null) {
            synchronized (a.class) {
                if (f48544d == null) {
                    f48544d = new a();
                }
            }
        }
        return f48544d;
    }

    public void b() {
        this.f48546b = null;
        this.f48545a.clear();
    }

    public final void c(c cVar) {
        f48543c.lock();
        try {
            if (this.f48546b != null) {
                this.f48546b.a(cVar);
            } else {
                this.f48545a.add(cVar);
            }
        } finally {
            f48543c.unlock();
        }
    }

    public void d(String str, boolean z) {
        d.b.g0.a.c0.c.g("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        c(cVar);
    }

    public final void e() {
        if (this.f48545a.isEmpty() || this.f48546b == null) {
            return;
        }
        f48543c.lock();
        try {
            for (c cVar : this.f48545a) {
                this.f48546b.a(cVar);
            }
            this.f48545a.clear();
        } finally {
            f48543c.unlock();
        }
    }

    public void f(d dVar) {
        this.f48546b = dVar;
        e();
    }
}
