package d.a.k0.r.a.h;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.k0.r.a.c;
import d.a.k0.r.a.d;
import d.a.k0.r.a.e;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static a f60231e;

    /* renamed from: b  reason: collision with root package name */
    public String f60233b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60234c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<b> f60235d = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public int f60232a = d.a.j0.r.d0.b.j().k("splash_ad_strategy_key", 0);

    /* renamed from: d.a.k0.r.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1574a implements Runnable {
        public RunnableC1574a(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.k0.r0.a.h().j();
        }
    }

    public static a c() {
        if (f60231e == null) {
            f60231e = new a();
        }
        return f60231e;
    }

    public void a() {
        Iterator<b> it = this.f60235d.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null) {
                next.destroy();
            }
        }
        this.f60235d.clear();
    }

    public int b() {
        return this.f60232a;
    }

    public final synchronized void d() {
        e eVar = new e();
        d.a.k0.r.a.b bVar = new d.a.k0.r.a.b();
        d dVar = new d();
        c cVar = new c();
        this.f60235d.clear();
        this.f60235d.add(eVar);
        this.f60235d.add(bVar);
        if (this.f60232a == 101) {
            this.f60235d.add(cVar);
            this.f60235d.add(dVar);
        } else if (this.f60232a == 102) {
            this.f60235d.add(dVar);
            this.f60235d.add(cVar);
        } else {
            if (this.f60232a != 103 && this.f60232a != 104) {
                if (this.f60232a == 105) {
                    this.f60235d.add(cVar);
                } else if (this.f60232a != 106) {
                    this.f60235d.add(dVar);
                }
            }
            String p = d.a.j0.r.d0.b.j().p("splash_ad_last_show_key", "");
            this.f60233b = p;
            if (k.isEmpty(p)) {
                if (this.f60232a == 103) {
                    this.f60235d.add(cVar);
                    this.f60235d.add(dVar);
                } else {
                    this.f60235d.add(dVar);
                    this.f60235d.add(cVar);
                }
            } else if (StringHelper.equals(this.f60233b, cVar.c())) {
                this.f60235d.add(dVar);
                this.f60235d.add(cVar);
            } else {
                this.f60235d.add(cVar);
                this.f60235d.add(dVar);
            }
        }
    }

    public boolean e() {
        return TbadkCoreApplication.getInst().isNeedBearAd(this.f60232a);
    }

    public synchronized void f(d.a.j0.k.c cVar) {
        this.f60234c = false;
        d();
        Iterator<b> it = this.f60235d.iterator();
        while (it.hasNext()) {
            it.next().b(cVar);
        }
    }

    public void g(d.a.j0.k.a aVar) {
        h(aVar, true);
    }

    public synchronized void h(d.a.j0.k.a aVar, boolean z) {
        if (this.f60234c) {
            return;
        }
        Iterator<b> it = this.f60235d.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null) {
                if (next.a() == AdLoadState.SUCCEED) {
                    this.f60234c = true;
                    next.show();
                    d.a.j0.r.z.a.a("homePage", -1L, 0, "logo_splash", 0, "", "splashType", k.isEmpty(next.c()) ? "bes" : next.c());
                    i(next.c());
                    return;
                } else if (next.a() != AdLoadState.FAILED && z) {
                    return;
                }
            }
        }
        if (aVar != null) {
            aVar.a("");
        }
    }

    public final void i(String str) {
        if (k.isEmpty(str)) {
            return;
        }
        this.f60233b = str;
        d.a.j0.r.d0.b.j().x("splash_ad_last_show_key", str);
    }

    public void j(JSONObject jSONObject) {
        int d2 = d.a.c.e.m.b.d(jSONObject.optString("ad_sdk_priority"), 0);
        c.i(d.a.c.e.m.b.d(jSONObject.optString("bear_sid_type"), 0));
        if ((d2 == 103 || d2 == 104) && d2 != this.f60232a) {
            this.f60233b = "";
            d.a.j0.r.d0.b.j().C("splash_ad_last_show_key");
        }
        d.a.j0.r.d0.b.j().v("splash_ad_strategy_key", d2);
        if (!e() && TbadkCoreApplication.getInst().isNeedBearAd(d2)) {
            if (l.C()) {
                d.a.k0.r0.a.h().j();
            } else {
                d.a.c.e.m.e.a().post(new RunnableC1574a(this));
            }
        }
        this.f60232a = d2;
    }
}
