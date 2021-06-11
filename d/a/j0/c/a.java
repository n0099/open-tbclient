package d.a.j0.c;

import android.util.Pair;
import d.a.j0.a;
import d.a.j0.e.d;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f43956f;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f43957a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f43958b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f43959c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f43960d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Integer, a.InterfaceC0605a> f43961e = new HashMap<>();

    public static a c() {
        if (f43956f == null) {
            synchronized (a.class) {
                if (f43956f == null) {
                    f43956f = new a();
                }
            }
        }
        return f43956f;
    }

    public synchronized int a(a.InterfaceC0605a interfaceC0605a) {
        int currentTimeMillis;
        currentTimeMillis = (int) System.currentTimeMillis();
        this.f43961e.put(Integer.valueOf(currentTimeMillis), interfaceC0605a);
        return currentTimeMillis;
    }

    public synchronized Pair<Boolean, a.InterfaceC0605a> b(int i2) {
        if (!this.f43961e.containsKey(Integer.valueOf(i2))) {
            return new Pair<>(Boolean.FALSE, null);
        }
        d.a().b(i2);
        this.f43961e.remove(Integer.valueOf(i2));
        return new Pair<>(Boolean.TRUE, this.f43961e.get(Integer.valueOf(i2)));
    }

    public void d(boolean z) {
        this.f43957a.set(z);
    }

    public boolean e(boolean z, boolean z2) {
        return this.f43957a.compareAndSet(z, z2);
    }

    public void f(boolean z) {
        this.f43958b.set(z);
    }

    public boolean g() {
        return this.f43958b.get();
    }

    public synchronized boolean h(int i2) {
        return this.f43961e.containsKey(Integer.valueOf(i2));
    }

    public boolean i(boolean z, boolean z2) {
        return this.f43958b.compareAndSet(z, z2);
    }

    public void j(boolean z) {
        this.f43959c.set(z);
    }

    public boolean k() {
        return this.f43959c.get();
    }

    public boolean l(boolean z, boolean z2) {
        return this.f43959c.compareAndSet(z, z2);
    }

    public void m(boolean z) {
        this.f43960d.set(z);
    }

    public boolean n(boolean z, boolean z2) {
        return this.f43960d.compareAndSet(z, z2);
    }
}
