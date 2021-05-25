package d.a.n0.t.a.h;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.n0.t.a.c;
import d.a.n0.t.a.d;
import d.a.n0.t.a.e;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static a f60812e;

    /* renamed from: b  reason: collision with root package name */
    public String f60814b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60815c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<b> f60816d = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public int f60813a = d.a.m0.r.d0.b.j().k("splash_ad_strategy_key", 0);

    /* renamed from: d.a.n0.t.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1607a implements Runnable {
        public RunnableC1607a(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.n0.s0.a.h().j();
        }
    }

    public static a c() {
        if (f60812e == null) {
            f60812e = new a();
        }
        return f60812e;
    }

    public void a() {
        Iterator<b> it = this.f60816d.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null) {
                next.destroy();
            }
        }
        this.f60816d.clear();
    }

    public int b() {
        return this.f60813a;
    }

    public final synchronized void d() {
        e eVar = new e();
        d.a.n0.t.a.b bVar = new d.a.n0.t.a.b();
        d dVar = new d();
        c cVar = new c();
        this.f60816d.clear();
        this.f60816d.add(eVar);
        this.f60816d.add(bVar);
        if (this.f60813a == 101) {
            this.f60816d.add(cVar);
            this.f60816d.add(dVar);
        } else if (this.f60813a == 102) {
            this.f60816d.add(dVar);
            this.f60816d.add(cVar);
        } else {
            if (this.f60813a != 103 && this.f60813a != 104) {
                if (this.f60813a == 105) {
                    this.f60816d.add(cVar);
                } else if (this.f60813a != 106) {
                    this.f60816d.add(dVar);
                }
            }
            String p = d.a.m0.r.d0.b.j().p("splash_ad_last_show_key", "");
            this.f60814b = p;
            if (k.isEmpty(p)) {
                if (this.f60813a == 103) {
                    this.f60816d.add(cVar);
                    this.f60816d.add(dVar);
                } else {
                    this.f60816d.add(dVar);
                    this.f60816d.add(cVar);
                }
            } else if (StringHelper.equals(this.f60814b, cVar.c())) {
                this.f60816d.add(dVar);
                this.f60816d.add(cVar);
            } else {
                this.f60816d.add(cVar);
                this.f60816d.add(dVar);
            }
        }
    }

    public boolean e() {
        return TbadkCoreApplication.getInst().isNeedBearAd(this.f60813a);
    }

    public synchronized void f(d.a.m0.k.d dVar) {
        this.f60815c = false;
        d();
        Iterator<b> it = this.f60816d.iterator();
        while (it.hasNext()) {
            it.next().b(dVar);
        }
    }

    public void g(d.a.m0.k.a aVar) {
        h(aVar, true);
    }

    public synchronized void h(d.a.m0.k.a aVar, boolean z) {
        if (this.f60815c) {
            return;
        }
        Iterator<b> it = this.f60816d.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null) {
                if (next.a() == AdLoadState.SUCCEED) {
                    this.f60815c = true;
                    next.show();
                    d.a.m0.r.z.a.a("homePage", -1L, 0, "logo_splash", 0, "", "splashType", k.isEmpty(next.c()) ? "bes" : next.c());
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
        this.f60814b = str;
        d.a.m0.r.d0.b.j().x("splash_ad_last_show_key", str);
    }

    public void j(JSONObject jSONObject) {
        int d2 = d.a.c.e.m.b.d(jSONObject.optString("ad_sdk_priority"), 0);
        c.i(d.a.c.e.m.b.d(jSONObject.optString("bear_sid_type"), 0));
        if ((d2 == 103 || d2 == 104) && d2 != this.f60813a) {
            this.f60814b = "";
            d.a.m0.r.d0.b.j().C("splash_ad_last_show_key");
        }
        d.a.m0.r.d0.b.j().v("splash_ad_strategy_key", d2);
        if (!e() && TbadkCoreApplication.getInst().isNeedBearAd(d2)) {
            if (l.C()) {
                d.a.n0.s0.a.h().j();
            } else {
                d.a.c.e.m.e.a().post(new RunnableC1607a(this));
            }
        }
        this.f60813a = d2;
    }
}
