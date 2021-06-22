package d.a.o0.t.a.h;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.o0.t.a.c;
import d.a.o0.t.a.d;
import d.a.o0.t.a.e;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static a f64628e;

    /* renamed from: b  reason: collision with root package name */
    public String f64630b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f64631c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<b> f64632d = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public int f64629a = d.a.n0.r.d0.b.j().k("splash_ad_strategy_key", 0);

    /* renamed from: d.a.o0.t.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1667a implements Runnable {
        public RunnableC1667a(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.o0.s0.a.h().j();
        }
    }

    public static a c() {
        if (f64628e == null) {
            f64628e = new a();
        }
        return f64628e;
    }

    public void a() {
        Iterator<b> it = this.f64632d.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null) {
                next.destroy();
            }
        }
        this.f64632d.clear();
    }

    public int b() {
        return this.f64629a;
    }

    public final synchronized void d() {
        e eVar = new e();
        d.a.o0.t.a.b bVar = new d.a.o0.t.a.b();
        d dVar = new d();
        c cVar = new c();
        this.f64632d.clear();
        this.f64632d.add(eVar);
        this.f64632d.add(bVar);
        if (this.f64629a == 101) {
            this.f64632d.add(cVar);
            this.f64632d.add(dVar);
        } else if (this.f64629a == 102) {
            this.f64632d.add(dVar);
            this.f64632d.add(cVar);
        } else {
            if (this.f64629a != 103 && this.f64629a != 104) {
                if (this.f64629a == 105) {
                    this.f64632d.add(cVar);
                } else if (this.f64629a != 106) {
                    this.f64632d.add(dVar);
                }
            }
            String p = d.a.n0.r.d0.b.j().p("splash_ad_last_show_key", "");
            this.f64630b = p;
            if (k.isEmpty(p)) {
                if (this.f64629a == 103) {
                    this.f64632d.add(cVar);
                    this.f64632d.add(dVar);
                } else {
                    this.f64632d.add(dVar);
                    this.f64632d.add(cVar);
                }
            } else if (StringHelper.equals(this.f64630b, cVar.c())) {
                this.f64632d.add(dVar);
                this.f64632d.add(cVar);
            } else {
                this.f64632d.add(cVar);
                this.f64632d.add(dVar);
            }
        }
    }

    public boolean e() {
        return TbadkCoreApplication.getInst().isNeedBearAd(this.f64629a);
    }

    public synchronized void f(d.a.n0.k.d dVar) {
        this.f64631c = false;
        d();
        Iterator<b> it = this.f64632d.iterator();
        while (it.hasNext()) {
            it.next().b(dVar);
        }
    }

    public void g(d.a.n0.k.a aVar) {
        h(aVar, true);
    }

    public synchronized void h(d.a.n0.k.a aVar, boolean z) {
        if (this.f64631c) {
            return;
        }
        Iterator<b> it = this.f64632d.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null) {
                if (next.a() == AdLoadState.SUCCEED) {
                    this.f64631c = true;
                    next.show();
                    d.a.n0.r.z.a.a("homePage", -1L, 0, "logo_splash", 0, "", "splashType", k.isEmpty(next.c()) ? "bes" : next.c());
                    i(next.c());
                    return;
                } else if (next.a() != AdLoadState.FAILED && z) {
                    return;
                }
            }
        }
        if (!z) {
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 0).param("obj_type", "a064").param("obj_locate", 4).param(TiebaStatic.Params.RESOURCE_ID, 0).eventStat();
        }
        if (aVar != null) {
            aVar.a("");
        }
    }

    public final void i(String str) {
        if (k.isEmpty(str)) {
            return;
        }
        this.f64630b = str;
        d.a.n0.r.d0.b.j().x("splash_ad_last_show_key", str);
    }

    public void j(JSONObject jSONObject) {
        int d2 = d.a.c.e.m.b.d(jSONObject.optString("ad_sdk_priority"), 0);
        c.i(d.a.c.e.m.b.d(jSONObject.optString("bear_sid_type"), 0));
        if ((d2 == 103 || d2 == 104) && d2 != this.f64629a) {
            this.f64630b = "";
            d.a.n0.r.d0.b.j().C("splash_ad_last_show_key");
        }
        d.a.n0.r.d0.b.j().v("splash_ad_strategy_key", d2);
        if (!e() && TbadkCoreApplication.getInst().isNeedBearAd(d2)) {
            if (l.C()) {
                d.a.o0.s0.a.h().j();
            } else {
                d.a.c.e.m.e.a().post(new RunnableC1667a(this));
            }
        }
        this.f64629a = d2;
    }
}
