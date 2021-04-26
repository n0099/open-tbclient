package d.a.h0.a.b2.e;

import d.a.h0.a.c0.c;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f41581c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.h0.a.i2.u0.b<Exception>> f41582a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d.a.h0.a.i2.u0.b<Exception>> f41583b = new ArrayList<>();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f41584e;

        public a(int i2) {
            this.f41584e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.h("PresetSwanCoreUpdater", "onPresetUpdate start.");
            b bVar = b.this;
            int i2 = this.f41584e;
            bVar.c(i2, d.a.h0.a.b2.e.a.o(i2));
            c.h("PresetSwanCoreUpdater", "onPresetUpdate end.");
        }
    }

    /* renamed from: d.a.h0.a.b2.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0586b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.u0.b f41586e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Exception f41587f;

        public RunnableC0586b(b bVar, d.a.h0.a.i2.u0.b bVar2, Exception exc) {
            this.f41586e = bVar2;
            this.f41587f = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f41586e.onCallback(this.f41587f);
        }
    }

    static {
        boolean z = k.f43101a;
    }

    public static b b() {
        if (f41581c == null) {
            synchronized (b.class) {
                if (f41581c == null) {
                    f41581c = new b();
                }
            }
        }
        return f41581c;
    }

    public final void c(int i2, Exception exc) {
        synchronized (b.class) {
            try {
                if (i2 == 0) {
                    Iterator<d.a.h0.a.i2.u0.b<Exception>> it = this.f41582a.iterator();
                    while (it.hasNext()) {
                        d(it.next(), exc);
                    }
                    this.f41582a.clear();
                } else if (i2 == 1) {
                    Iterator<d.a.h0.a.i2.u0.b<Exception>> it2 = this.f41583b.iterator();
                    while (it2.hasNext()) {
                        d(it2.next(), exc);
                    }
                    this.f41583b.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(d.a.h0.a.i2.u0.b<Exception> bVar, Exception exc) {
        if (bVar != null) {
            k0.X(new RunnableC0586b(this, bVar, exc));
        }
    }

    public void e(d.a.h0.a.i2.u0.b<Exception> bVar, int i2) {
        ArrayList<d.a.h0.a.i2.u0.b<Exception>> arrayList;
        c.h("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
        synchronized (b.class) {
            boolean n = d.a.h0.a.b2.e.a.n(i2);
            c.h("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = " + n);
            if (!n) {
                d(bVar, null);
                return;
            }
            if (i2 == 1) {
                arrayList = this.f41583b;
            } else {
                arrayList = this.f41582a;
            }
            if (arrayList.isEmpty()) {
                new Thread(new a(i2), "updateSwanCoreAsync").start();
            }
            arrayList.add(bVar);
            c.h("PresetSwanCoreUpdater", "updateSwanCoreAsync end.");
        }
    }

    public void f(int i2) {
        synchronized (b.class) {
            c(i2, d.a.h0.a.b2.e.a.o(i2));
        }
    }
}
