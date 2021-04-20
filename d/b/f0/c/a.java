package d.b.f0.c;

import android.util.Pair;
import d.b.f0.a;
import d.b.f0.e.d;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f43227f;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f43228a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f43229b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f43230c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f43231d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Integer, a.InterfaceC0591a> f43232e = new HashMap<>();

    public static a c() {
        if (f43227f == null) {
            synchronized (a.class) {
                if (f43227f == null) {
                    f43227f = new a();
                }
            }
        }
        return f43227f;
    }

    public synchronized int a(a.InterfaceC0591a interfaceC0591a) {
        int currentTimeMillis;
        currentTimeMillis = (int) System.currentTimeMillis();
        this.f43232e.put(Integer.valueOf(currentTimeMillis), interfaceC0591a);
        return currentTimeMillis;
    }

    public synchronized Pair<Boolean, a.InterfaceC0591a> b(int i) {
        if (!this.f43232e.containsKey(Integer.valueOf(i))) {
            return new Pair<>(Boolean.FALSE, null);
        }
        d.a().b(i);
        this.f43232e.remove(Integer.valueOf(i));
        return new Pair<>(Boolean.TRUE, this.f43232e.get(Integer.valueOf(i)));
    }

    public void d(boolean z) {
        this.f43228a.set(z);
    }

    public boolean e(boolean z, boolean z2) {
        return this.f43228a.compareAndSet(z, z2);
    }

    public void f(boolean z) {
        this.f43229b.set(z);
    }

    public boolean g() {
        return this.f43229b.get();
    }

    public synchronized boolean h(int i) {
        return this.f43232e.containsKey(Integer.valueOf(i));
    }

    public boolean i(boolean z, boolean z2) {
        return this.f43229b.compareAndSet(z, z2);
    }

    public void j(boolean z) {
        this.f43230c.set(z);
    }

    public boolean k() {
        return this.f43230c.get();
    }

    public boolean l(boolean z, boolean z2) {
        return this.f43230c.compareAndSet(z, z2);
    }

    public void m(boolean z) {
        this.f43231d.set(z);
    }

    public boolean n(boolean z, boolean z2) {
        return this.f43231d.compareAndSet(z, z2);
    }
}
