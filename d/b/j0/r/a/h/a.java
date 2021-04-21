package d.b.j0.r.a.h;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.j0.r.a.c;
import d.b.j0.r.a.d;
import d.b.j0.r.a.e;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static a f61344e;

    /* renamed from: b  reason: collision with root package name */
    public String f61346b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61347c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<b> f61348d = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public int f61345a = d.b.i0.r.d0.b.j().k("splash_ad_strategy_key", 0);

    /* renamed from: d.b.j0.r.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1561a implements Runnable {
        public RunnableC1561a(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.j0.r0.a.h().j();
        }
    }

    public static a c() {
        if (f61344e == null) {
            f61344e = new a();
        }
        return f61344e;
    }

    public void a() {
        this.f61348d.clear();
    }

    public int b() {
        return this.f61345a;
    }

    public final synchronized void d() {
        e eVar = new e();
        d.b.j0.r.a.b bVar = new d.b.j0.r.a.b();
        d dVar = new d();
        c cVar = new c();
        this.f61348d.clear();
        this.f61348d.add(eVar);
        this.f61348d.add(bVar);
        if (this.f61345a == 101) {
            this.f61348d.add(cVar);
            this.f61348d.add(dVar);
        } else if (this.f61345a == 102) {
            this.f61348d.add(dVar);
            this.f61348d.add(cVar);
        } else {
            if (this.f61345a != 103 && this.f61345a != 104) {
                if (this.f61345a == 105) {
                    this.f61348d.add(cVar);
                } else if (this.f61345a != 106) {
                    this.f61348d.add(dVar);
                }
            }
            String p = d.b.i0.r.d0.b.j().p("splash_ad_last_show_key", "");
            this.f61346b = p;
            if (k.isEmpty(p)) {
                if (this.f61345a == 103) {
                    this.f61348d.add(cVar);
                    this.f61348d.add(dVar);
                } else {
                    this.f61348d.add(dVar);
                    this.f61348d.add(cVar);
                }
            } else if (StringHelper.equals(this.f61346b, cVar.a())) {
                this.f61348d.add(dVar);
                this.f61348d.add(cVar);
            } else {
                this.f61348d.add(cVar);
                this.f61348d.add(dVar);
            }
        }
    }

    public boolean e() {
        return TbadkCoreApplication.getInst().isNeedBearAd(this.f61345a);
    }

    public synchronized void f(d.b.i0.k.c cVar) {
        this.f61347c = false;
        d();
        Iterator<b> it = this.f61348d.iterator();
        while (it.hasNext()) {
            it.next().c(cVar);
        }
    }

    public void g(d.b.i0.k.a aVar) {
        h(aVar, true);
    }

    public synchronized void h(d.b.i0.k.a aVar, boolean z) {
        if (this.f61347c) {
            return;
        }
        Iterator<b> it = this.f61348d.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null) {
                if (next.b() == AdLoadState.SUCCEED) {
                    this.f61347c = true;
                    next.show();
                    d.b.i0.r.z.a.a("homePage", -1L, 0, "logo_splash", 0, "", "splashType", k.isEmpty(next.a()) ? "bes" : next.a());
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
        this.f61346b = str;
        d.b.i0.r.d0.b.j().x("splash_ad_last_show_key", str);
    }

    public void j(JSONObject jSONObject) {
        int d2 = d.b.c.e.m.b.d(jSONObject.optString("ad_sdk_priority"), 0);
        c.i(d.b.c.e.m.b.d(jSONObject.optString("bear_sid_type"), 0));
        if ((d2 == 103 || d2 == 104) && d2 != this.f61345a) {
            this.f61346b = "";
            d.b.i0.r.d0.b.j().C("splash_ad_last_show_key");
        }
        d.b.i0.r.d0.b.j().v("splash_ad_strategy_key", d2);
        if (!e() && TbadkCoreApplication.getInst().isNeedBearAd(d2)) {
            if (l.B()) {
                d.b.j0.r0.a.h().j();
            } else {
                d.b.c.e.m.e.a().post(new RunnableC1561a(this));
            }
        }
        this.f61345a = d2;
    }
}
