package d.a.l0.a.m2.e;

import d.a.l0.a.e0.d;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f43508c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.l0.a.v2.e1.b<Exception>> f43509a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d.a.l0.a.v2.e1.b<Exception>> f43510b = new ArrayList<>();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f43511e;

        public a(b bVar, int i2) {
            this.f43511e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.h("PresetSwanCoreUpdater", "onPresetCheck start.");
            d.a.l0.a.m2.e.a.s(this.f43511e);
            d.h("PresetSwanCoreUpdater", "onPresetCheck end.");
        }
    }

    /* renamed from: d.a.l0.a.m2.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0747b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f43512e;

        public RunnableC0747b(int i2) {
            this.f43512e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.h("PresetSwanCoreUpdater", "onPresetUpdate start.");
            b bVar = b.this;
            int i2 = this.f43512e;
            bVar.c(i2, d.a.l0.a.m2.e.a.t(i2));
            d.h("PresetSwanCoreUpdater", "onPresetUpdate end.");
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f43514e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Exception f43515f;

        public c(b bVar, d.a.l0.a.v2.e1.b bVar2, Exception exc) {
            this.f43514e = bVar2;
            this.f43515f = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43514e.onCallback(this.f43515f);
        }
    }

    static {
        boolean z = k.f43199a;
    }

    public static b b() {
        if (f43508c == null) {
            synchronized (b.class) {
                if (f43508c == null) {
                    f43508c = new b();
                }
            }
        }
        return f43508c;
    }

    public final void c(int i2, Exception exc) {
        synchronized (b.class) {
            try {
                if (i2 == 0) {
                    Iterator<d.a.l0.a.v2.e1.b<Exception>> it = this.f43509a.iterator();
                    while (it.hasNext()) {
                        d(it.next(), exc);
                    }
                    this.f43509a.clear();
                } else if (i2 == 1) {
                    Iterator<d.a.l0.a.v2.e1.b<Exception>> it2 = this.f43510b.iterator();
                    while (it2.hasNext()) {
                        d(it2.next(), exc);
                    }
                    this.f43510b.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(d.a.l0.a.v2.e1.b<Exception> bVar, Exception exc) {
        if (bVar != null) {
            q0.b0(new c(this, bVar, exc));
        }
    }

    public void e(d.a.l0.a.v2.e1.b<Exception> bVar, int i2) {
        ArrayList<d.a.l0.a.v2.e1.b<Exception>> arrayList;
        d.h("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
        synchronized (b.class) {
            boolean q = d.a.l0.a.m2.e.a.q(i2);
            d.h("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = " + q);
            if (!q && i2 == 0 && !d.a.l0.a.m2.e.a.r(i2)) {
                d.a.l0.a.m2.e.a.w(true, i2);
                new Thread(new a(this, i2), "onPresetCheck").start();
            }
            if (!q) {
                d(bVar, null);
                return;
            }
            if (i2 == 1) {
                arrayList = this.f43510b;
            } else {
                arrayList = this.f43509a;
            }
            if (arrayList.isEmpty()) {
                new Thread(new RunnableC0747b(i2), "updateSwanCoreAsync").start();
            }
            arrayList.add(bVar);
            d.h("PresetSwanCoreUpdater", "updateSwanCoreAsync end.");
        }
    }

    public void f(int i2) {
        synchronized (b.class) {
            c(i2, d.a.l0.a.m2.e.a.t(i2));
        }
    }
}
