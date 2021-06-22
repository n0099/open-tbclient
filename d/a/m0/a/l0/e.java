package d.a.m0.a.l0;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: c  reason: collision with root package name */
    public static volatile e f47089c;

    /* renamed from: a  reason: collision with root package name */
    public final Lock f47090a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<i> f47091b = new ArrayList<>();

    public static e i() {
        if (f47089c == null) {
            synchronized (e.class) {
                if (f47089c == null) {
                    f47089c = new e();
                }
            }
        }
        return f47089c;
    }

    public final Object[] a() {
        try {
            this.f47090a.lock();
            return this.f47091b.size() > 0 ? this.f47091b.toArray() : null;
        } finally {
            this.f47090a.unlock();
        }
    }

    public void b(a aVar) {
        Object[] a2 = a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((i) obj).d(aVar);
            }
        }
    }

    public void c(a aVar) {
        Object[] a2 = a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((i) obj).b(aVar);
            }
        }
    }

    public void d(a aVar) {
        Object[] a2 = a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((i) obj).f(aVar);
            }
        }
    }

    public void e(a aVar) {
        Object[] a2 = a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((i) obj).c(aVar);
            }
        }
    }

    public void f(a aVar) {
        Object[] a2 = a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((i) obj).g(aVar);
            }
        }
    }

    public void g(a aVar) {
        Object[] a2 = a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((i) obj).a(aVar);
            }
        }
    }

    public void h(a aVar) {
        Object[] a2 = a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((i) obj).e(aVar);
            }
        }
    }
}
