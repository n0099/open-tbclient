package d.a.j0.c;

import android.util.Pair;
import d.a.j0.a;
import d.a.j0.e.d;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f40275f;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f40276a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f40277b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f40278c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f40279d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Integer, a.InterfaceC0549a> f40280e = new HashMap<>();

    public static a c() {
        if (f40275f == null) {
            synchronized (a.class) {
                if (f40275f == null) {
                    f40275f = new a();
                }
            }
        }
        return f40275f;
    }

    public synchronized int a(a.InterfaceC0549a interfaceC0549a) {
        int currentTimeMillis;
        currentTimeMillis = (int) System.currentTimeMillis();
        this.f40280e.put(Integer.valueOf(currentTimeMillis), interfaceC0549a);
        return currentTimeMillis;
    }

    public synchronized Pair<Boolean, a.InterfaceC0549a> b(int i2) {
        if (!this.f40280e.containsKey(Integer.valueOf(i2))) {
            return new Pair<>(Boolean.FALSE, null);
        }
        d.a().b(i2);
        this.f40280e.remove(Integer.valueOf(i2));
        return new Pair<>(Boolean.TRUE, this.f40280e.get(Integer.valueOf(i2)));
    }

    public void d(boolean z) {
        this.f40276a.set(z);
    }

    public boolean e(boolean z, boolean z2) {
        return this.f40276a.compareAndSet(z, z2);
    }

    public void f(boolean z) {
        this.f40277b.set(z);
    }

    public boolean g() {
        return this.f40277b.get();
    }

    public synchronized boolean h(int i2) {
        return this.f40280e.containsKey(Integer.valueOf(i2));
    }

    public boolean i(boolean z, boolean z2) {
        return this.f40277b.compareAndSet(z, z2);
    }

    public void j(boolean z) {
        this.f40278c.set(z);
    }

    public boolean k() {
        return this.f40278c.get();
    }

    public boolean l(boolean z, boolean z2) {
        return this.f40278c.compareAndSet(z, z2);
    }

    public void m(boolean z) {
        this.f40279d.set(z);
    }

    public boolean n(boolean z, boolean z2) {
        return this.f40279d.compareAndSet(z, z2);
    }
}
