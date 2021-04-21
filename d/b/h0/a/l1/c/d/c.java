package d.b.h0.a.l1.c.d;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends d.b.h0.a.l1.c.d.a {

    /* loaded from: classes2.dex */
    public class a implements d.b.h0.a.n.a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.l1.c.c.a f45935a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e0.n.b f45936b;

        public a(c cVar, d.b.h0.a.l1.c.c.a aVar, d.b.h0.a.e0.n.b bVar) {
            this.f45935a = aVar;
            this.f45936b = bVar;
        }

        @Override // d.b.h0.a.n.a.b
        public void a(int i) {
            d.b.h0.a.l1.d.a.a("obtain address failure, errCode = " + i);
            this.f45936b.a(this.f45935a);
        }

        @Override // d.b.h0.a.n.a.b
        public void b(JSONObject jSONObject) {
            d.b.h0.a.l1.d.a.a("obtain address success");
            d.b.h0.a.l1.c.c.a aVar = this.f45935a;
            aVar.f45919d = true;
            if (jSONObject != null) {
                aVar.f45920e = jSONObject.toString();
            }
            this.f45936b.a(this.f45935a);
        }
    }

    @Override // d.b.h0.a.l1.c.d.b
    public d.b.h0.a.t.e.b b(JSONObject jSONObject) {
        return null;
    }

    @Override // d.b.h0.a.l1.c.d.b
    public String g() {
        return "mapp_choose_address";
    }

    @Override // d.b.h0.a.l1.c.d.a
    public void o(SwanAppActivity swanAppActivity, String str, d.b.h0.a.l1.c.b.b bVar, d.b.h0.a.v1.d.a aVar, d.b.h0.a.e0.n.b<d.b.h0.a.l1.c.c.a> bVar2) {
        d.b.h0.a.l1.c.c.a aVar2 = new d.b.h0.a.l1.c.c.a(bVar.f45913f);
        aVar2.f45916a = bVar.f45912e;
        if (aVar != null && aVar.j.a() != LightappBusinessClient.SVC_ID_H5_TRANSERECORD) {
            d.b.h0.a.l1.d.a.a("obtain address detail");
            d.b.h0.a.w0.a.Q().a(swanAppActivity, str, str, new a(this, aVar2, bVar2));
            return;
        }
        d.b.h0.a.l1.d.a.a("user denied");
        bVar2.a(aVar2);
    }
}
