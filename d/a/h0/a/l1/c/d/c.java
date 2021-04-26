package d.a.h0.a.l1.c.d;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.h0.a.l1.c.d.a {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.n.a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.l1.c.c.a f43272a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.n.b f43273b;

        public a(c cVar, d.a.h0.a.l1.c.c.a aVar, d.a.h0.a.e0.n.b bVar) {
            this.f43272a = aVar;
            this.f43273b = bVar;
        }

        @Override // d.a.h0.a.n.a.b
        public void a(int i2) {
            d.a.h0.a.l1.d.a.a("obtain address failure, errCode = " + i2);
            this.f43273b.a(this.f43272a);
        }

        @Override // d.a.h0.a.n.a.b
        public void b(JSONObject jSONObject) {
            d.a.h0.a.l1.d.a.a("obtain address success");
            d.a.h0.a.l1.c.c.a aVar = this.f43272a;
            aVar.f43255d = true;
            if (jSONObject != null) {
                aVar.f43256e = jSONObject.toString();
            }
            this.f43273b.a(this.f43272a);
        }
    }

    @Override // d.a.h0.a.l1.c.d.b
    public d.a.h0.a.t.e.b b(JSONObject jSONObject) {
        return null;
    }

    @Override // d.a.h0.a.l1.c.d.b
    public String g() {
        return "mapp_choose_address";
    }

    @Override // d.a.h0.a.l1.c.d.a
    public void o(SwanAppActivity swanAppActivity, String str, d.a.h0.a.l1.c.b.b bVar, d.a.h0.a.v1.d.a aVar, d.a.h0.a.e0.n.b<d.a.h0.a.l1.c.c.a> bVar2) {
        d.a.h0.a.l1.c.c.a aVar2 = new d.a.h0.a.l1.c.c.a(bVar.f43248f);
        aVar2.f43252a = bVar.f43247e;
        if (aVar != null && aVar.j.a() != LightappBusinessClient.SVC_ID_H5_TRANSERECORD) {
            d.a.h0.a.l1.d.a.a("obtain address detail");
            d.a.h0.a.w0.a.Q().a(swanAppActivity, str, str, new a(this, aVar2, bVar2));
            return;
        }
        d.a.h0.a.l1.d.a.a("user denied");
        bVar2.a(aVar2);
    }
}
