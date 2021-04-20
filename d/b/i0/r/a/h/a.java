package d.b.i0.r.a.h;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.r.a.c;
import d.b.i0.r.a.d;
import d.b.i0.r.a.e;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static a f60923e;

    /* renamed from: b  reason: collision with root package name */
    public String f60925b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60926c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<b> f60927d = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public int f60924a = d.b.h0.r.d0.b.j().k("splash_ad_strategy_key", 0);

    /* renamed from: d.b.i0.r.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1538a implements Runnable {
        public RunnableC1538a(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.i0.r0.a.h().j();
        }
    }

    public static a c() {
        if (f60923e == null) {
            f60923e = new a();
        }
        return f60923e;
    }

    public void a() {
        this.f60927d.clear();
    }

    public int b() {
        return this.f60924a;
    }

    public final synchronized void d() {
        e eVar = new e();
        d.b.i0.r.a.b bVar = new d.b.i0.r.a.b();
        d dVar = new d();
        c cVar = new c();
        this.f60927d.clear();
        this.f60927d.add(eVar);
        this.f60927d.add(bVar);
        if (this.f60924a == 101) {
            this.f60927d.add(cVar);
            this.f60927d.add(dVar);
        } else if (this.f60924a == 102) {
            this.f60927d.add(dVar);
            this.f60927d.add(cVar);
        } else {
            if (this.f60924a != 103 && this.f60924a != 104) {
                if (this.f60924a == 105) {
                    this.f60927d.add(cVar);
                } else if (this.f60924a != 106) {
                    this.f60927d.add(dVar);
                }
            }
            String p = d.b.h0.r.d0.b.j().p("splash_ad_last_show_key", "");
            this.f60925b = p;
            if (k.isEmpty(p)) {
                if (this.f60924a == 103) {
                    this.f60927d.add(cVar);
                    this.f60927d.add(dVar);
                } else {
                    this.f60927d.add(dVar);
                    this.f60927d.add(cVar);
                }
            } else if (StringHelper.equals(this.f60925b, cVar.a())) {
                this.f60927d.add(dVar);
                this.f60927d.add(cVar);
            } else {
                this.f60927d.add(cVar);
                this.f60927d.add(dVar);
            }
        }
    }

    public boolean e() {
        return TbadkCoreApplication.getInst().isNeedBearAd(this.f60924a);
    }

    public synchronized void f(d.b.h0.k.c cVar) {
        this.f60926c = false;
        d();
        Iterator<b> it = this.f60927d.iterator();
        while (it.hasNext()) {
            it.next().c(cVar);
        }
    }

    public void g(d.b.h0.k.a aVar) {
        h(aVar, true);
    }

    public synchronized void h(d.b.h0.k.a aVar, boolean z) {
        if (this.f60926c) {
            return;
        }
        Iterator<b> it = this.f60927d.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null) {
                if (next.b() == AdLoadState.SUCCEED) {
                    this.f60926c = true;
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
            aVar.a("");
            a();
        }
    }

    public final void i(String str) {
        if (k.isEmpty(str)) {
            return;
        }
        this.f60925b = str;
        d.b.h0.r.d0.b.j().x("splash_ad_last_show_key", str);
    }

    public void j(JSONObject jSONObject) {
        int d2 = d.b.c.e.m.b.d(jSONObject.optString("ad_sdk_priority"), 0);
        c.i(d.b.c.e.m.b.d(jSONObject.optString("bear_sid_type"), 0));
        if ((d2 == 103 || d2 == 104) && d2 != this.f60924a) {
            this.f60925b = "";
            d.b.h0.r.d0.b.j().C("splash_ad_last_show_key");
        }
        d.b.h0.r.d0.b.j().v("splash_ad_strategy_key", d2);
        if (!e() && TbadkCoreApplication.getInst().isNeedBearAd(d2)) {
            if (l.B()) {
                d.b.i0.r0.a.h().j();
            } else {
                d.b.c.e.m.e.a().post(new RunnableC1538a(this));
            }
        }
        this.f60924a = d2;
    }
}
