package d.a.i0.a.t1.c.d;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.i0.a.t1.c.d.a {

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.n.a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.t1.c.c.a f44605a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.j.b f44606b;

        public a(c cVar, d.a.i0.a.t1.c.c.a aVar, d.a.i0.a.h0.j.b bVar) {
            this.f44605a = aVar;
            this.f44606b = bVar;
        }

        @Override // d.a.i0.a.n.a.b
        public void a(int i2) {
            d.a.i0.a.t1.d.a.a("obtain address failure, errCode = " + i2);
            this.f44606b.a(this.f44605a);
        }

        @Override // d.a.i0.a.n.a.b
        public void b(JSONObject jSONObject) {
            d.a.i0.a.t1.d.a.a("obtain address success");
            d.a.i0.a.t1.c.c.a aVar = this.f44605a;
            aVar.f44588d = true;
            if (jSONObject != null) {
                aVar.f44589e = jSONObject.toString();
            }
            this.f44606b.a(this.f44605a);
        }
    }

    @Override // d.a.i0.a.t1.c.d.b
    public d.a.i0.a.u.h.b b(JSONObject jSONObject) {
        return null;
    }

    @Override // d.a.i0.a.t1.c.d.b
    public String g() {
        return "mapp_choose_address";
    }

    @Override // d.a.i0.a.t1.c.d.b
    public String h() {
        return "SwanPluginAddressFunPage";
    }

    @Override // d.a.i0.a.t1.c.d.a
    public void p(SwanAppActivity swanAppActivity, String str, d.a.i0.a.t1.c.b.b bVar, d.a.i0.a.e2.d.a aVar, d.a.i0.a.h0.j.b<d.a.i0.a.t1.c.c.a> bVar2) {
        d.a.i0.a.t1.c.c.a aVar2 = new d.a.i0.a.t1.c.c.a(bVar.f44581f);
        aVar2.f44585a = bVar.f44580e;
        if (aVar != null && aVar.j.a() != LightappBusinessClient.SVC_ID_H5_TRANSERECORD) {
            d.a.i0.a.t1.d.a.a("obtain address detail");
            d.a.i0.a.c1.a.c0().a(swanAppActivity, str, str, new a(this, aVar2, bVar2));
            return;
        }
        d.a.i0.a.t1.d.a.a("user denied");
        bVar2.a(aVar2);
    }
}
