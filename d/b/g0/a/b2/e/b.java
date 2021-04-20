package d.b.g0.a.b2.e;

import d.b.g0.a.c0.c;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f43968c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.b.g0.a.i2.u0.b<Exception>> f43969a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d.b.g0.a.i2.u0.b<Exception>> f43970b = new ArrayList<>();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f43971e;

        public a(int i) {
            this.f43971e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.h("PresetSwanCoreUpdater", "onPresetUpdate start.");
            b bVar = b.this;
            int i = this.f43971e;
            bVar.c(i, d.b.g0.a.b2.e.a.o(i));
            c.h("PresetSwanCoreUpdater", "onPresetUpdate end.");
        }
    }

    /* renamed from: d.b.g0.a.b2.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0627b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f43973e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Exception f43974f;

        public RunnableC0627b(b bVar, d.b.g0.a.i2.u0.b bVar2, Exception exc) {
            this.f43973e = bVar2;
            this.f43974f = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43973e.onCallback(this.f43974f);
        }
    }

    static {
        boolean z = k.f45443a;
    }

    public static b b() {
        if (f43968c == null) {
            synchronized (b.class) {
                if (f43968c == null) {
                    f43968c = new b();
                }
            }
        }
        return f43968c;
    }

    public final void c(int i, Exception exc) {
        synchronized (b.class) {
            try {
                if (i == 0) {
                    Iterator<d.b.g0.a.i2.u0.b<Exception>> it = this.f43969a.iterator();
                    while (it.hasNext()) {
                        d(it.next(), exc);
                    }
                    this.f43969a.clear();
                } else if (i == 1) {
                    Iterator<d.b.g0.a.i2.u0.b<Exception>> it2 = this.f43970b.iterator();
                    while (it2.hasNext()) {
                        d(it2.next(), exc);
                    }
                    this.f43970b.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(d.b.g0.a.i2.u0.b<Exception> bVar, Exception exc) {
        if (bVar != null) {
            k0.X(new RunnableC0627b(this, bVar, exc));
        }
    }

    public void e(d.b.g0.a.i2.u0.b<Exception> bVar, int i) {
        ArrayList<d.b.g0.a.i2.u0.b<Exception>> arrayList;
        c.h("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
        synchronized (b.class) {
            boolean n = d.b.g0.a.b2.e.a.n(i);
            c.h("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = " + n);
            if (!n) {
                d(bVar, null);
                return;
            }
            if (i == 1) {
                arrayList = this.f43970b;
            } else {
                arrayList = this.f43969a;
            }
            if (arrayList.isEmpty()) {
                new Thread(new a(i), "updateSwanCoreAsync").start();
            }
            arrayList.add(bVar);
            c.h("PresetSwanCoreUpdater", "updateSwanCoreAsync end.");
        }
    }

    public void f(int i) {
        synchronized (b.class) {
            c(i, d.b.g0.a.b2.e.a.o(i));
        }
    }
}
