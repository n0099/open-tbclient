package d.a.g0.c;

import android.util.Pair;
import d.a.g0.a;
import d.a.g0.e.d;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f40014f;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f40015a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f40016b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f40017c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f40018d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Integer, a.InterfaceC0536a> f40019e = new HashMap<>();

    public static a c() {
        if (f40014f == null) {
            synchronized (a.class) {
                if (f40014f == null) {
                    f40014f = new a();
                }
            }
        }
        return f40014f;
    }

    public synchronized int a(a.InterfaceC0536a interfaceC0536a) {
        int currentTimeMillis;
        currentTimeMillis = (int) System.currentTimeMillis();
        this.f40019e.put(Integer.valueOf(currentTimeMillis), interfaceC0536a);
        return currentTimeMillis;
    }

    public synchronized Pair<Boolean, a.InterfaceC0536a> b(int i2) {
        if (!this.f40019e.containsKey(Integer.valueOf(i2))) {
            return new Pair<>(Boolean.FALSE, null);
        }
        d.a().b(i2);
        this.f40019e.remove(Integer.valueOf(i2));
        return new Pair<>(Boolean.TRUE, this.f40019e.get(Integer.valueOf(i2)));
    }

    public void d(boolean z) {
        this.f40015a.set(z);
    }

    public boolean e(boolean z, boolean z2) {
        return this.f40015a.compareAndSet(z, z2);
    }

    public void f(boolean z) {
        this.f40016b.set(z);
    }

    public boolean g() {
        return this.f40016b.get();
    }

    public synchronized boolean h(int i2) {
        return this.f40019e.containsKey(Integer.valueOf(i2));
    }

    public boolean i(boolean z, boolean z2) {
        return this.f40016b.compareAndSet(z, z2);
    }

    public void j(boolean z) {
        this.f40017c.set(z);
    }

    public boolean k() {
        return this.f40017c.get();
    }

    public boolean l(boolean z, boolean z2) {
        return this.f40017c.compareAndSet(z, z2);
    }

    public void m(boolean z) {
        this.f40018d.set(z);
    }

    public boolean n(boolean z, boolean z2) {
        return this.f40018d.compareAndSet(z, z2);
    }
}
