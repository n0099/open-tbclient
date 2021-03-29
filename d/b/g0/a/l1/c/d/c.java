package d.b.g0.a.l1.c.d;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends d.b.g0.a.l1.c.d.a {

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.n.a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.l1.c.c.a f45214a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.n.b f45215b;

        public a(c cVar, d.b.g0.a.l1.c.c.a aVar, d.b.g0.a.e0.n.b bVar) {
            this.f45214a = aVar;
            this.f45215b = bVar;
        }

        @Override // d.b.g0.a.n.a.b
        public void a(int i) {
            d.b.g0.a.l1.d.a.a("obtain address failure, errCode = " + i);
            this.f45215b.a(this.f45214a);
        }

        @Override // d.b.g0.a.n.a.b
        public void b(JSONObject jSONObject) {
            d.b.g0.a.l1.d.a.a("obtain address success");
            d.b.g0.a.l1.c.c.a aVar = this.f45214a;
            aVar.f45198d = true;
            if (jSONObject != null) {
                aVar.f45199e = jSONObject.toString();
            }
            this.f45215b.a(this.f45214a);
        }
    }

    @Override // d.b.g0.a.l1.c.d.b
    public d.b.g0.a.t.e.b b(JSONObject jSONObject) {
        return null;
    }

    @Override // d.b.g0.a.l1.c.d.b
    public String g() {
        return "mapp_choose_address";
    }

    @Override // d.b.g0.a.l1.c.d.a
    public void o(SwanAppActivity swanAppActivity, String str, d.b.g0.a.l1.c.b.b bVar, d.b.g0.a.v1.d.a aVar, d.b.g0.a.e0.n.b<d.b.g0.a.l1.c.c.a> bVar2) {
        d.b.g0.a.l1.c.c.a aVar2 = new d.b.g0.a.l1.c.c.a(bVar.f45192f);
        aVar2.f45195a = bVar.f45191e;
        if (aVar != null && aVar.j.a() != LightappBusinessClient.SVC_ID_H5_TRANSERECORD) {
            d.b.g0.a.l1.d.a.a("obtain address detail");
            d.b.g0.a.w0.a.Q().a(swanAppActivity, str, str, new a(this, aVar2, bVar2));
            return;
        }
        d.b.g0.a.l1.d.a.a("user denied");
        bVar2.a(aVar2);
    }
}
