package d.b.h0.a.b2.e;

import d.b.h0.a.c0.c;
import d.b.h0.a.i2.k0;
import d.b.h0.a.k;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f44297c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.b.h0.a.i2.u0.b<Exception>> f44298a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d.b.h0.a.i2.u0.b<Exception>> f44299b = new ArrayList<>();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f44300e;

        public a(int i) {
            this.f44300e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.h("PresetSwanCoreUpdater", "onPresetUpdate start.");
            b bVar = b.this;
            int i = this.f44300e;
            bVar.c(i, d.b.h0.a.b2.e.a.o(i));
            c.h("PresetSwanCoreUpdater", "onPresetUpdate end.");
        }
    }

    /* renamed from: d.b.h0.a.b2.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0647b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.i2.u0.b f44302e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Exception f44303f;

        public RunnableC0647b(b bVar, d.b.h0.a.i2.u0.b bVar2, Exception exc) {
            this.f44302e = bVar2;
            this.f44303f = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f44302e.onCallback(this.f44303f);
        }
    }

    static {
        boolean z = k.f45772a;
    }

    public static b b() {
        if (f44297c == null) {
            synchronized (b.class) {
                if (f44297c == null) {
                    f44297c = new b();
                }
            }
        }
        return f44297c;
    }

    public final void c(int i, Exception exc) {
        synchronized (b.class) {
            try {
                if (i == 0) {
                    Iterator<d.b.h0.a.i2.u0.b<Exception>> it = this.f44298a.iterator();
                    while (it.hasNext()) {
                        d(it.next(), exc);
                    }
                    this.f44298a.clear();
                } else if (i == 1) {
                    Iterator<d.b.h0.a.i2.u0.b<Exception>> it2 = this.f44299b.iterator();
                    while (it2.hasNext()) {
                        d(it2.next(), exc);
                    }
                    this.f44299b.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(d.b.h0.a.i2.u0.b<Exception> bVar, Exception exc) {
        if (bVar != null) {
            k0.X(new RunnableC0647b(this, bVar, exc));
        }
    }

    public void e(d.b.h0.a.i2.u0.b<Exception> bVar, int i) {
        ArrayList<d.b.h0.a.i2.u0.b<Exception>> arrayList;
        c.h("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
        synchronized (b.class) {
            boolean n = d.b.h0.a.b2.e.a.n(i);
            c.h("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = " + n);
            if (!n) {
                d(bVar, null);
                return;
            }
            if (i == 1) {
                arrayList = this.f44299b;
            } else {
                arrayList = this.f44298a;
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
            c(i, d.b.h0.a.b2.e.a.o(i));
        }
    }
}
