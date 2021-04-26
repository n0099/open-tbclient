package d.a.h0.g.h0;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final ReentrantLock f46345c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f46346d;

    /* renamed from: a  reason: collision with root package name */
    public List<c> f46347a = new ArrayList(3);

    /* renamed from: b  reason: collision with root package name */
    public d f46348b;

    public static a a() {
        if (f46346d == null) {
            synchronized (a.class) {
                if (f46346d == null) {
                    f46346d = new a();
                }
            }
        }
        return f46346d;
    }

    public void b() {
        this.f46348b = null;
        this.f46347a.clear();
    }

    public final void c(c cVar) {
        f46345c.lock();
        try {
            if (this.f46348b != null) {
                this.f46348b.a(cVar);
            } else {
                this.f46347a.add(cVar);
            }
        } finally {
            f46345c.unlock();
        }
    }

    public void d(String str, boolean z) {
        d.a.h0.a.c0.c.g("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        c(cVar);
    }

    public final void e() {
        if (this.f46347a.isEmpty() || this.f46348b == null) {
            return;
        }
        f46345c.lock();
        try {
            for (c cVar : this.f46347a) {
                this.f46348b.a(cVar);
            }
            this.f46347a.clear();
        } finally {
            f46345c.unlock();
        }
    }

    public void f(d dVar) {
        this.f46348b = dVar;
        e();
    }
}
