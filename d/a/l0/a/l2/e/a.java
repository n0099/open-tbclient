package d.a.l0.a.l2.e;

import android.util.Log;
import d.a.l0.a.e0.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class a extends b {

    /* renamed from: g  reason: collision with root package name */
    public boolean f43407g;

    /* renamed from: d.a.l0.a.l2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0735a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ArrayList f43408e;

        public RunnableC0735a(ArrayList arrayList) {
            this.f43408e = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.m(this.f43408e);
            a.this.j();
        }
    }

    public a(d.a.l0.a.l2.b bVar) {
        super(bVar);
    }

    @Override // d.a.l0.a.l2.e.b
    public void f() {
        if (this.f43412b.a()) {
            long currentTimeMillis = b.f43410f ? System.currentTimeMillis() : 0L;
            this.f43411a.g(new RunnableC0735a(this.f43412b.n()));
            if (b.f43410f) {
                Log.d("SwanCookieSyncPolicy", "saveCacheToDatabase costTime:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public final void j() {
        if (this.f43407g) {
            return;
        }
        long currentTimeMillis = b.f43410f ? System.currentTimeMillis() : 0L;
        this.f43411a.b();
        this.f43407g = true;
        if (b.f43410f) {
            Log.d("SwanCookieSyncPolicy", "clearExpiredCookies costTime:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public ArrayList<d.a.l0.a.l2.a> k(String str) {
        long currentTimeMillis = b.f43410f ? System.currentTimeMillis() : 0L;
        ArrayList<d.a.l0.a.l2.a> arrayList = new ArrayList<>();
        try {
            arrayList = this.f43411a.e(str);
        } catch (Exception e2) {
            d.h("SwanCookieSyncPolicy", Log.getStackTraceString(e2));
        }
        if (b.f43410f) {
            Log.d("SwanCookieSyncPolicy", "getCookiesForDomain costTime:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return arrayList;
    }

    public void l() {
        long currentTimeMillis = b.f43410f ? System.currentTimeMillis() : 0L;
        this.f43411a.h();
        if (b.f43410f) {
            Log.d("SwanCookieSyncPolicy", "preInitDatabase costTime:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final void m(ArrayList<d.a.l0.a.l2.a> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (b.f43410f) {
            Log.d("SwanCookieSyncPolicy", "syncFromRamToFlash start");
        }
        Iterator<d.a.l0.a.l2.a> it = arrayList.iterator();
        while (it.hasNext()) {
            d.a.l0.a.l2.a next = it.next();
            if (next != null) {
                if (b.f43410f) {
                    Log.d("SwanCookieSyncPolicy", "syncFromRamToFlash result cookie:" + next.toString());
                }
                int i2 = next.f43387i;
                if (i2 == 0) {
                    this.f43411a.a(next);
                    this.f43412b.y(next);
                } else if (i2 == 2) {
                    this.f43411a.d(next.f43379a, next.f43380b, next.f43381c);
                    this.f43412b.g(next);
                } else if (i2 == 3) {
                    this.f43411a.d(next.f43379a, next.f43380b, next.f43381c);
                    this.f43411a.a(next);
                    this.f43412b.y(next);
                }
            }
        }
    }
}
