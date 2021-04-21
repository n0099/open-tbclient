package d.b.g0.c;

import android.util.Pair;
import d.b.g0.a;
import d.b.g0.e.d;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f43524f;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f43525a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f43526b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f43527c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f43528d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Integer, a.InterfaceC0610a> f43529e = new HashMap<>();

    public static a c() {
        if (f43524f == null) {
            synchronized (a.class) {
                if (f43524f == null) {
                    f43524f = new a();
                }
            }
        }
        return f43524f;
    }

    public synchronized int a(a.InterfaceC0610a interfaceC0610a) {
        int currentTimeMillis;
        currentTimeMillis = (int) System.currentTimeMillis();
        this.f43529e.put(Integer.valueOf(currentTimeMillis), interfaceC0610a);
        return currentTimeMillis;
    }

    public synchronized Pair<Boolean, a.InterfaceC0610a> b(int i) {
        if (!this.f43529e.containsKey(Integer.valueOf(i))) {
            return new Pair<>(Boolean.FALSE, null);
        }
        d.a().b(i);
        this.f43529e.remove(Integer.valueOf(i));
        return new Pair<>(Boolean.TRUE, this.f43529e.get(Integer.valueOf(i)));
    }

    public void d(boolean z) {
        this.f43525a.set(z);
    }

    public boolean e(boolean z, boolean z2) {
        return this.f43525a.compareAndSet(z, z2);
    }

    public void f(boolean z) {
        this.f43526b.set(z);
    }

    public boolean g() {
        return this.f43526b.get();
    }

    public synchronized boolean h(int i) {
        return this.f43529e.containsKey(Integer.valueOf(i));
    }

    public boolean i(boolean z, boolean z2) {
        return this.f43526b.compareAndSet(z, z2);
    }

    public void j(boolean z) {
        this.f43527c.set(z);
    }

    public boolean k() {
        return this.f43527c.get();
    }

    public boolean l(boolean z, boolean z2) {
        return this.f43527c.compareAndSet(z, z2);
    }

    public void m(boolean z) {
        this.f43528d.set(z);
    }

    public boolean n(boolean z, boolean z2) {
        return this.f43528d.compareAndSet(z, z2);
    }
}
