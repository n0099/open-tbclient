package d.a.k0.c;

import android.util.Pair;
import d.a.k0.a;
import d.a.k0.e.d;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f44096f;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f44097a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f44098b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f44099c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f44100d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Integer, a.InterfaceC0609a> f44101e = new HashMap<>();

    public static a c() {
        if (f44096f == null) {
            synchronized (a.class) {
                if (f44096f == null) {
                    f44096f = new a();
                }
            }
        }
        return f44096f;
    }

    public synchronized int a(a.InterfaceC0609a interfaceC0609a) {
        int currentTimeMillis;
        currentTimeMillis = (int) System.currentTimeMillis();
        this.f44101e.put(Integer.valueOf(currentTimeMillis), interfaceC0609a);
        return currentTimeMillis;
    }

    public synchronized Pair<Boolean, a.InterfaceC0609a> b(int i2) {
        if (!this.f44101e.containsKey(Integer.valueOf(i2))) {
            return new Pair<>(Boolean.FALSE, null);
        }
        d.a().b(i2);
        this.f44101e.remove(Integer.valueOf(i2));
        return new Pair<>(Boolean.TRUE, this.f44101e.get(Integer.valueOf(i2)));
    }

    public void d(boolean z) {
        this.f44097a.set(z);
    }

    public boolean e(boolean z, boolean z2) {
        return this.f44097a.compareAndSet(z, z2);
    }

    public void f(boolean z) {
        this.f44098b.set(z);
    }

    public boolean g() {
        return this.f44098b.get();
    }

    public synchronized boolean h(int i2) {
        return this.f44101e.containsKey(Integer.valueOf(i2));
    }

    public boolean i(boolean z, boolean z2) {
        return this.f44098b.compareAndSet(z, z2);
    }

    public void j(boolean z) {
        this.f44099c.set(z);
    }

    public boolean k() {
        return this.f44099c.get();
    }

    public boolean l(boolean z, boolean z2) {
        return this.f44099c.compareAndSet(z, z2);
    }

    public void m(boolean z) {
        this.f44100d.set(z);
    }

    public boolean n(boolean z, boolean z2) {
        return this.f44100d.compareAndSet(z, z2);
    }
}
