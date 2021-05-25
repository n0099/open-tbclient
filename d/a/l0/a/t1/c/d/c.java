package d.a.l0.a.t1.c.d;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.l0.a.t1.c.d.a {

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.n.a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.t1.c.c.a f44781a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.j.b f44782b;

        public a(c cVar, d.a.l0.a.t1.c.c.a aVar, d.a.l0.a.h0.j.b bVar) {
            this.f44781a = aVar;
            this.f44782b = bVar;
        }

        @Override // d.a.l0.a.n.a.b
        public void a(int i2) {
            d.a.l0.a.t1.d.a.a("obtain address failure, errCode = " + i2);
            this.f44782b.a(this.f44781a);
        }

        @Override // d.a.l0.a.n.a.b
        public void b(JSONObject jSONObject) {
            d.a.l0.a.t1.d.a.a("obtain address success");
            d.a.l0.a.t1.c.c.a aVar = this.f44781a;
            aVar.f44764d = true;
            if (jSONObject != null) {
                aVar.f44765e = jSONObject.toString();
            }
            this.f44782b.a(this.f44781a);
        }
    }

    @Override // d.a.l0.a.t1.c.d.b
    public d.a.l0.a.u.h.b b(JSONObject jSONObject) {
        return null;
    }

    @Override // d.a.l0.a.t1.c.d.b
    public String g() {
        return "mapp_choose_address";
    }

    @Override // d.a.l0.a.t1.c.d.b
    public String h() {
        return "SwanPluginAddressFunPage";
    }

    @Override // d.a.l0.a.t1.c.d.a
    public void p(SwanAppActivity swanAppActivity, String str, d.a.l0.a.t1.c.b.b bVar, d.a.l0.a.e2.d.a aVar, d.a.l0.a.h0.j.b<d.a.l0.a.t1.c.c.a> bVar2) {
        d.a.l0.a.t1.c.c.a aVar2 = new d.a.l0.a.t1.c.c.a(bVar.f44757f);
        aVar2.f44761a = bVar.f44756e;
        if (aVar != null && aVar.j.a() != LightappBusinessClient.SVC_ID_H5_TRANSERECORD) {
            d.a.l0.a.t1.d.a.a("obtain address detail");
            d.a.l0.a.c1.a.c0().a(swanAppActivity, str, str, new a(this, aVar2, bVar2));
            return;
        }
        d.a.l0.a.t1.d.a.a("user denied");
        bVar2.a(aVar2);
    }
}
