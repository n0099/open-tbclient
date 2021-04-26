package d.a.h0.g.i;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static volatile d f46367c;

    /* renamed from: a  reason: collision with root package name */
    public final Lock f46368a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<j> f46369b = new ArrayList<>();

    public static d i() {
        if (f46367c == null) {
            synchronized (d.class) {
                if (f46367c == null) {
                    f46367c = new d();
                }
            }
        }
        return f46367c;
    }

    public final Object[] a() {
        try {
            this.f46368a.lock();
            return this.f46369b.size() > 0 ? this.f46369b.toArray() : null;
        } finally {
            this.f46368a.unlock();
        }
    }

    public void b(a aVar) {
        Object[] a2 = a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((j) obj).f(aVar);
            }
        }
    }

    public void c(a aVar) {
        Object[] a2 = a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((j) obj).d(aVar);
            }
        }
    }

    public void d(a aVar) {
        Object[] a2 = a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((j) obj).c(aVar);
            }
        }
    }

    public void e(a aVar) {
        Object[] a2 = a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((j) obj).g(aVar);
            }
        }
    }

    public void f(a aVar) {
        Object[] a2 = a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((j) obj).b(aVar);
            }
        }
    }

    public void g(a aVar) {
        Object[] a2 = a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((j) obj).a(aVar);
            }
        }
    }

    public void h(a aVar) {
        Object[] a2 = a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((j) obj).e(aVar);
            }
        }
    }
}
