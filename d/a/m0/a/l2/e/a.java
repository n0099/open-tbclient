package d.a.m0.a.l2.e;

import android.util.Log;
import d.a.m0.a.e0.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class a extends b {

    /* renamed from: g  reason: collision with root package name */
    public boolean f47191g;

    /* renamed from: d.a.m0.a.l2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0794a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ArrayList f47192e;

        public RunnableC0794a(ArrayList arrayList) {
            this.f47192e = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.m(this.f47192e);
            a.this.j();
        }
    }

    public a(d.a.m0.a.l2.b bVar) {
        super(bVar);
    }

    @Override // d.a.m0.a.l2.e.b
    public void f() {
        if (this.f47196b.a()) {
            long currentTimeMillis = b.f47194f ? System.currentTimeMillis() : 0L;
            this.f47195a.g(new RunnableC0794a(this.f47196b.n()));
            if (b.f47194f) {
                Log.d("SwanCookieSyncPolicy", "saveCacheToDatabase costTime:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public final void j() {
        if (this.f47191g) {
            return;
        }
        long currentTimeMillis = b.f47194f ? System.currentTimeMillis() : 0L;
        this.f47195a.b();
        this.f47191g = true;
        if (b.f47194f) {
            Log.d("SwanCookieSyncPolicy", "clearExpiredCookies costTime:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public ArrayList<d.a.m0.a.l2.a> k(String str) {
        long currentTimeMillis = b.f47194f ? System.currentTimeMillis() : 0L;
        ArrayList<d.a.m0.a.l2.a> arrayList = new ArrayList<>();
        try {
            arrayList = this.f47195a.e(str);
        } catch (Exception e2) {
            d.h("SwanCookieSyncPolicy", Log.getStackTraceString(e2));
        }
        if (b.f47194f) {
            Log.d("SwanCookieSyncPolicy", "getCookiesForDomain costTime:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return arrayList;
    }

    public void l() {
        long currentTimeMillis = b.f47194f ? System.currentTimeMillis() : 0L;
        this.f47195a.h();
        if (b.f47194f) {
            Log.d("SwanCookieSyncPolicy", "preInitDatabase costTime:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final void m(ArrayList<d.a.m0.a.l2.a> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (b.f47194f) {
            Log.d("SwanCookieSyncPolicy", "syncFromRamToFlash start");
        }
        Iterator<d.a.m0.a.l2.a> it = arrayList.iterator();
        while (it.hasNext()) {
            d.a.m0.a.l2.a next = it.next();
            if (next != null) {
                if (b.f47194f) {
                    Log.d("SwanCookieSyncPolicy", "syncFromRamToFlash result cookie:" + next.toString());
                }
                int i2 = next.f47171i;
                if (i2 == 0) {
                    this.f47195a.a(next);
                    this.f47196b.y(next);
                } else if (i2 == 2) {
                    this.f47195a.d(next.f47163a, next.f47164b, next.f47165c);
                    this.f47196b.g(next);
                } else if (i2 == 3) {
                    this.f47195a.d(next.f47163a, next.f47164b, next.f47165c);
                    this.f47195a.a(next);
                    this.f47196b.y(next);
                }
            }
        }
    }
}
