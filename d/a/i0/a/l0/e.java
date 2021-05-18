package d.a.i0.a.l0;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: c  reason: collision with root package name */
    public static volatile e f43131c;

    /* renamed from: a  reason: collision with root package name */
    public final Lock f43132a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<i> f43133b = new ArrayList<>();

    public static e i() {
        if (f43131c == null) {
            synchronized (e.class) {
                if (f43131c == null) {
                    f43131c = new e();
                }
            }
        }
        return f43131c;
    }

    public final Object[] a() {
        try {
            this.f43132a.lock();
            return this.f43133b.size() > 0 ? this.f43133b.toArray() : null;
        } finally {
            this.f43132a.unlock();
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
