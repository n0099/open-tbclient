package d.b.f0.c;

import android.util.Pair;
import d.b.f0.a;
import d.b.f0.e.d;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f42834f;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f42835a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f42836b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f42837c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f42838d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Integer, a.InterfaceC0578a> f42839e = new HashMap<>();

    public static a c() {
        if (f42834f == null) {
            synchronized (a.class) {
                if (f42834f == null) {
                    f42834f = new a();
                }
            }
        }
        return f42834f;
    }

    public synchronized int a(a.InterfaceC0578a interfaceC0578a) {
        int currentTimeMillis;
        currentTimeMillis = (int) System.currentTimeMillis();
        this.f42839e.put(Integer.valueOf(currentTimeMillis), interfaceC0578a);
        return currentTimeMillis;
    }

    public synchronized Pair<Boolean, a.InterfaceC0578a> b(int i) {
        if (!this.f42839e.containsKey(Integer.valueOf(i))) {
            return new Pair<>(Boolean.FALSE, null);
        }
        d.a().b(i);
        this.f42839e.remove(Integer.valueOf(i));
        return new Pair<>(Boolean.TRUE, this.f42839e.get(Integer.valueOf(i)));
    }

    public void d(boolean z) {
        this.f42835a.set(z);
    }

    public boolean e(boolean z, boolean z2) {
        return this.f42835a.compareAndSet(z, z2);
    }

    public void f(boolean z) {
        this.f42836b.set(z);
    }

    public boolean g() {
        return this.f42836b.get();
    }

    public synchronized boolean h(int i) {
        return this.f42839e.containsKey(Integer.valueOf(i));
    }

    public boolean i(boolean z, boolean z2) {
        return this.f42836b.compareAndSet(z, z2);
    }

    public void j(boolean z) {
        this.f42837c.set(z);
    }

    public boolean k() {
        return this.f42837c.get();
    }

    public boolean l(boolean z, boolean z2) {
        return this.f42837c.compareAndSet(z, z2);
    }

    public void m(boolean z) {
        this.f42838d.set(z);
    }

    public boolean n(boolean z, boolean z2) {
        return this.f42838d.compareAndSet(z, z2);
    }
}
