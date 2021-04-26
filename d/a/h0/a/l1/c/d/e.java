package d.a.h0.a.l1.c.d;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.h0.a.k;
import d.a.h0.a.t.c.a.b;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends d.a.h0.a.l1.c.d.a {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<h<f.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.n.b f43277e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.l1.c.c.a f43278f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.v1.d.a f43279g;

        public a(e eVar, d.a.h0.a.e0.n.b bVar, d.a.h0.a.l1.c.c.a aVar, d.a.h0.a.v1.d.a aVar2) {
            this.f43277e = bVar;
            this.f43278f = aVar;
            this.f43279g = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<f.d> hVar) {
            if (hVar != null && hVar.c() && !TextUtils.isEmpty(hVar.f44952a.f44970a)) {
                JSONObject jSONObject = this.f43279g.f44984g;
                if (jSONObject != null) {
                    try {
                        jSONObject.put("code", hVar.f44952a.f44970a);
                        this.f43278f.f43255d = true;
                    } catch (JSONException e2) {
                        if (k.f43101a) {
                            d.a.h0.a.l1.d.a.a(Log.getStackTraceString(e2));
                        }
                    }
                    this.f43278f.f43256e = jSONObject.toString();
                }
                this.f43277e.a(this.f43278f);
                return;
            }
            d.a.h0.a.l1.d.a.a("login failure, can't get login code");
            this.f43277e.a(this.f43278f);
        }
    }

    @Override // d.a.h0.a.l1.c.d.b
    public d.a.h0.a.t.e.b b(JSONObject jSONObject) {
        return null;
    }

    @Override // d.a.h0.a.l1.c.d.b
    public String g() {
        return "snsapi_userinfo";
    }

    @Override // d.a.h0.a.l1.c.d.a
    public void o(SwanAppActivity swanAppActivity, String str, d.a.h0.a.l1.c.b.b bVar, d.a.h0.a.v1.d.a aVar, d.a.h0.a.e0.n.b<d.a.h0.a.l1.c.c.a> bVar2) {
        d.a.h0.a.l1.c.c.a aVar2 = new d.a.h0.a.l1.c.c.a(bVar.f43248f);
        aVar2.f43252a = bVar.f43247e;
        if (aVar != null && aVar.j.a() == 0) {
            d.a.h0.a.l1.d.a.a("obtain user info detail, get login code");
            b.c cVar = new b.c(bVar.f43249g);
            Bundle bundle = new Bundle();
            bundle.putString("__plugin__", bVar.f43243a);
            d.a.h0.a.r1.d.e().p().R().q(swanAppActivity, cVar, bundle, new a(this, bVar2, aVar2, aVar));
            return;
        }
        d.a.h0.a.l1.d.a.a("open data result failure");
        bVar2.a(aVar2);
    }
}
