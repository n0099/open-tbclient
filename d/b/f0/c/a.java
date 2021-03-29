package d.b.f0.c;

import android.util.Pair;
import d.b.f0.a;
import d.b.f0.e.d;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f42835f;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f42836a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f42837b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f42838c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f42839d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Integer, a.InterfaceC0579a> f42840e = new HashMap<>();

    public static a c() {
        if (f42835f == null) {
            synchronized (a.class) {
                if (f42835f == null) {
                    f42835f = new a();
                }
            }
        }
        return f42835f;
    }

    public synchronized int a(a.InterfaceC0579a interfaceC0579a) {
        int currentTimeMillis;
        currentTimeMillis = (int) System.currentTimeMillis();
        this.f42840e.put(Integer.valueOf(currentTimeMillis), interfaceC0579a);
        return currentTimeMillis;
    }

    public synchronized Pair<Boolean, a.InterfaceC0579a> b(int i) {
        if (!this.f42840e.containsKey(Integer.valueOf(i))) {
            return new Pair<>(Boolean.FALSE, null);
        }
        d.a().b(i);
        this.f42840e.remove(Integer.valueOf(i));
        return new Pair<>(Boolean.TRUE, this.f42840e.get(Integer.valueOf(i)));
    }

    public void d(boolean z) {
        this.f42836a.set(z);
    }

    public boolean e(boolean z, boolean z2) {
        return this.f42836a.compareAndSet(z, z2);
    }

    public void f(boolean z) {
        this.f42837b.set(z);
    }

    public boolean g() {
        return this.f42837b.get();
    }

    public synchronized boolean h(int i) {
        return this.f42840e.containsKey(Integer.valueOf(i));
    }

    public boolean i(boolean z, boolean z2) {
        return this.f42837b.compareAndSet(z, z2);
    }

    public void j(boolean z) {
        this.f42838c.set(z);
    }

    public boolean k() {
        return this.f42838c.get();
    }

    public boolean l(boolean z, boolean z2) {
        return this.f42838c.compareAndSet(z, z2);
    }

    public void m(boolean z) {
        this.f42839d.set(z);
    }

    public boolean n(boolean z, boolean z2) {
        return this.f42839d.compareAndSet(z, z2);
    }
}
