package d.a.l0.h.l0;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final ReentrantLock f51115c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f51116d;

    /* renamed from: a  reason: collision with root package name */
    public List<c> f51117a = new ArrayList(3);

    /* renamed from: b  reason: collision with root package name */
    public d f51118b;

    public static a a() {
        if (f51116d == null) {
            synchronized (a.class) {
                if (f51116d == null) {
                    f51116d = new a();
                }
            }
        }
        return f51116d;
    }

    public void b() {
        this.f51118b = null;
        this.f51117a.clear();
    }

    public final void c(c cVar) {
        f51115c.lock();
        try {
            if (this.f51118b != null) {
                this.f51118b.a(cVar);
            } else {
                this.f51117a.add(cVar);
            }
        } finally {
            f51115c.unlock();
        }
    }

    public void d(String str, boolean z) {
        d.a.l0.a.e0.d.g("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        c(cVar);
    }

    public final void e() {
        if (this.f51117a.isEmpty() || this.f51118b == null) {
            return;
        }
        f51115c.lock();
        try {
            for (c cVar : this.f51117a) {
                this.f51118b.a(cVar);
            }
            this.f51117a.clear();
        } finally {
            f51115c.unlock();
        }
    }

    public void f(d dVar) {
        this.f51118b = dVar;
        e();
    }
}
