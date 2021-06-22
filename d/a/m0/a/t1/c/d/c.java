package d.a.m0.a.t1.c.d;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.m0.a.t1.c.d.a {

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.n.a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.t1.c.c.a f48563a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.j.b f48564b;

        public a(c cVar, d.a.m0.a.t1.c.c.a aVar, d.a.m0.a.h0.j.b bVar) {
            this.f48563a = aVar;
            this.f48564b = bVar;
        }

        @Override // d.a.m0.a.n.a.b
        public void a(int i2) {
            d.a.m0.a.t1.d.a.a("obtain address failure, errCode = " + i2);
            this.f48564b.a(this.f48563a);
        }

        @Override // d.a.m0.a.n.a.b
        public void b(JSONObject jSONObject) {
            d.a.m0.a.t1.d.a.a("obtain address success");
            d.a.m0.a.t1.c.c.a aVar = this.f48563a;
            aVar.f48546d = true;
            if (jSONObject != null) {
                aVar.f48547e = jSONObject.toString();
            }
            this.f48564b.a(this.f48563a);
        }
    }

    @Override // d.a.m0.a.t1.c.d.b
    public d.a.m0.a.u.h.b b(JSONObject jSONObject) {
        return null;
    }

    @Override // d.a.m0.a.t1.c.d.b
    public String g() {
        return "mapp_choose_address";
    }

    @Override // d.a.m0.a.t1.c.d.b
    public String h() {
        return "SwanPluginAddressFunPage";
    }

    @Override // d.a.m0.a.t1.c.d.a
    public void p(SwanAppActivity swanAppActivity, String str, d.a.m0.a.t1.c.b.b bVar, d.a.m0.a.e2.d.a aVar, d.a.m0.a.h0.j.b<d.a.m0.a.t1.c.c.a> bVar2) {
        d.a.m0.a.t1.c.c.a aVar2 = new d.a.m0.a.t1.c.c.a(bVar.f48539f);
        aVar2.f48543a = bVar.f48538e;
        if (aVar != null && aVar.j.a() != LightappBusinessClient.SVC_ID_H5_TRANSERECORD) {
            d.a.m0.a.t1.d.a.a("obtain address detail");
            d.a.m0.a.c1.a.c0().a(swanAppActivity, str, str, new a(this, aVar2, bVar2));
            return;
        }
        d.a.m0.a.t1.d.a.a("user denied");
        bVar2.a(aVar2);
    }
}
