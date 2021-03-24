package d.b.i0.r.a.g;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import d.b.b.e.m.e;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.i0.r.a.c;
import d.b.i0.r.a.d;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static a f59672e;

    /* renamed from: b  reason: collision with root package name */
    public String f59674b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59675c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<b> f59676d = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public int f59673a = d.b.h0.r.d0.b.i().j("splash_ad_strategy_key", 0);

    /* renamed from: d.b.i0.r.a.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1497a implements Runnable {
        public RunnableC1497a(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.i0.q0.a.h().j();
        }
    }

    public static a c() {
        if (f59672e == null) {
            f59672e = new a();
        }
        return f59672e;
    }

    public void a() {
        this.f59676d.clear();
    }

    public int b() {
        return this.f59673a;
    }

    public final synchronized void d() {
        d.b.i0.r.a.b bVar = new d.b.i0.r.a.b();
        d dVar = new d();
        c cVar = new c();
        this.f59676d.clear();
        this.f59676d.add(bVar);
        if (this.f59673a == 101) {
            this.f59676d.add(cVar);
            this.f59676d.add(dVar);
        } else if (this.f59673a == 102) {
            this.f59676d.add(dVar);
            this.f59676d.add(cVar);
        } else {
            if (this.f59673a != 103 && this.f59673a != 104) {
                if (this.f59673a == 105) {
                    this.f59676d.add(cVar);
                } else if (this.f59673a != 106) {
                    this.f59676d.add(dVar);
                }
            }
            String o = d.b.h0.r.d0.b.i().o("splash_ad_last_show_key", "");
            this.f59674b = o;
            if (k.isEmpty(o)) {
                if (this.f59673a == 103) {
                    this.f59676d.add(cVar);
                    this.f59676d.add(dVar);
                } else {
                    this.f59676d.add(dVar);
                    this.f59676d.add(cVar);
                }
            } else if (StringHelper.equals(this.f59674b, cVar.a())) {
                this.f59676d.add(dVar);
                this.f59676d.add(cVar);
            } else {
                this.f59676d.add(cVar);
                this.f59676d.add(dVar);
            }
        }
    }

    public boolean e() {
        return TbadkCoreApplication.getInst().isNeedBearAd(this.f59673a);
    }

    public synchronized void f(d.b.h0.k.c cVar) {
        this.f59675c = false;
        d();
        Iterator<b> it = this.f59676d.iterator();
        while (it.hasNext()) {
            it.next().c(cVar);
        }
    }

    public void g(d.b.h0.k.a aVar) {
        h(aVar, true);
    }

    public synchronized void h(d.b.h0.k.a aVar, boolean z) {
        if (this.f59675c) {
            return;
        }
        Iterator<b> it = this.f59676d.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null) {
                if (next.b() == AdLoadState.SUCCEED) {
                    this.f59675c = true;
                    next.show();
                    d.b.h0.r.z.a.a("homePage", -1L, 0, "logo_splash", 0, "", "splashType", k.isEmpty(next.a()) ? "bes" : next.a());
                    i(next.a());
                    return;
                } else if (next.b() != AdLoadState.FAILED && z) {
                    return;
                }
            }
        }
        if (aVar != null) {
            aVar.b("");
            a();
        }
    }

    public final void i(String str) {
        if (k.isEmpty(str)) {
            return;
        }
        this.f59674b = str;
        d.b.h0.r.d0.b.i().w("splash_ad_last_show_key", str);
    }

    public void j(JSONObject jSONObject) {
        int d2 = d.b.b.e.m.b.d(jSONObject.optString("ad_sdk_priority"), 0);
        c.i(d.b.b.e.m.b.d(jSONObject.optString("bear_sid_type"), 0));
        if ((d2 == 103 || d2 == 104) && d2 != this.f59673a) {
            this.f59674b = "";
            d.b.h0.r.d0.b.i().B("splash_ad_last_show_key");
        }
        d.b.h0.r.d0.b.i().u("splash_ad_strategy_key", d2);
        if (!e() && TbadkCoreApplication.getInst().isNeedBearAd(d2)) {
            if (l.B()) {
                d.b.i0.q0.a.h().j();
            } else {
                e.a().post(new RunnableC1497a(this));
            }
        }
        this.f59673a = d2;
    }
}
