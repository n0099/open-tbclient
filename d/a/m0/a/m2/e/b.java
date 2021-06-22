package d.a.m0.a.m2.e;

import d.a.m0.a.e0.d;
import d.a.m0.a.k;
import d.a.m0.a.v2.q0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f47292c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.m0.a.v2.e1.b<Exception>> f47293a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d.a.m0.a.v2.e1.b<Exception>> f47294b = new ArrayList<>();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f47295e;

        public a(b bVar, int i2) {
            this.f47295e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.h("PresetSwanCoreUpdater", "onPresetCheck start.");
            d.a.m0.a.m2.e.a.s(this.f47295e);
            d.h("PresetSwanCoreUpdater", "onPresetCheck end.");
        }
    }

    /* renamed from: d.a.m0.a.m2.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0806b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f47296e;

        public RunnableC0806b(int i2) {
            this.f47296e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.h("PresetSwanCoreUpdater", "onPresetUpdate start.");
            b bVar = b.this;
            int i2 = this.f47296e;
            bVar.c(i2, d.a.m0.a.m2.e.a.t(i2));
            d.h("PresetSwanCoreUpdater", "onPresetUpdate end.");
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.v2.e1.b f47298e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Exception f47299f;

        public c(b bVar, d.a.m0.a.v2.e1.b bVar2, Exception exc) {
            this.f47298e = bVar2;
            this.f47299f = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47298e.onCallback(this.f47299f);
        }
    }

    static {
        boolean z = k.f46983a;
    }

    public static b b() {
        if (f47292c == null) {
            synchronized (b.class) {
                if (f47292c == null) {
                    f47292c = new b();
                }
            }
        }
        return f47292c;
    }

    public final void c(int i2, Exception exc) {
        synchronized (b.class) {
            try {
                if (i2 == 0) {
                    Iterator<d.a.m0.a.v2.e1.b<Exception>> it = this.f47293a.iterator();
                    while (it.hasNext()) {
                        d(it.next(), exc);
                    }
                    this.f47293a.clear();
                } else if (i2 == 1) {
                    Iterator<d.a.m0.a.v2.e1.b<Exception>> it2 = this.f47294b.iterator();
                    while (it2.hasNext()) {
                        d(it2.next(), exc);
                    }
                    this.f47294b.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(d.a.m0.a.v2.e1.b<Exception> bVar, Exception exc) {
        if (bVar != null) {
            q0.b0(new c(this, bVar, exc));
        }
    }

    public void e(d.a.m0.a.v2.e1.b<Exception> bVar, int i2) {
        ArrayList<d.a.m0.a.v2.e1.b<Exception>> arrayList;
        d.h("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
        synchronized (b.class) {
            boolean q = d.a.m0.a.m2.e.a.q(i2);
            d.h("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = " + q);
            if (!q && i2 == 0 && !d.a.m0.a.m2.e.a.r(i2)) {
                d.a.m0.a.m2.e.a.w(true, i2);
                new Thread(new a(this, i2), "onPresetCheck").start();
            }
            if (!q) {
                d(bVar, null);
                return;
            }
            if (i2 == 1) {
                arrayList = this.f47294b;
            } else {
                arrayList = this.f47293a;
            }
            if (arrayList.isEmpty()) {
                new Thread(new RunnableC0806b(i2), "updateSwanCoreAsync").start();
            }
            arrayList.add(bVar);
            d.h("PresetSwanCoreUpdater", "updateSwanCoreAsync end.");
        }
    }

    public void f(int i2) {
        synchronized (b.class) {
            c(i2, d.a.m0.a.m2.e.a.t(i2));
        }
    }
}
