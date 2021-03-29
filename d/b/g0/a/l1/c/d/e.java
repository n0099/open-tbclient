package d.b.g0.a.l1.c.d;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.g0.a.k;
import d.b.g0.a.t.c.a.b;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends d.b.g0.a.l1.c.d.a {

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.i2.u0.b<h<f.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.n.b f45219e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.l1.c.c.a f45220f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.v1.d.a f45221g;

        public a(e eVar, d.b.g0.a.e0.n.b bVar, d.b.g0.a.l1.c.c.a aVar, d.b.g0.a.v1.d.a aVar2) {
            this.f45219e = bVar;
            this.f45220f = aVar;
            this.f45221g = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<f.d> hVar) {
            if (hVar != null && hVar.c() && !TextUtils.isEmpty(hVar.f46808a.f46826a)) {
                JSONObject jSONObject = this.f45221g.f46839g;
                if (jSONObject != null) {
                    try {
                        jSONObject.put("code", hVar.f46808a.f46826a);
                        this.f45220f.f45198d = true;
                    } catch (JSONException e2) {
                        if (k.f45051a) {
                            d.b.g0.a.l1.d.a.a(Log.getStackTraceString(e2));
                        }
                    }
                    this.f45220f.f45199e = jSONObject.toString();
                }
                this.f45219e.a(this.f45220f);
                return;
            }
            d.b.g0.a.l1.d.a.a("login failure, can't get login code");
            this.f45219e.a(this.f45220f);
        }
    }

    @Override // d.b.g0.a.l1.c.d.b
    public d.b.g0.a.t.e.b b(JSONObject jSONObject) {
        return null;
    }

    @Override // d.b.g0.a.l1.c.d.b
    public String g() {
        return "snsapi_userinfo";
    }

    @Override // d.b.g0.a.l1.c.d.a
    public void o(SwanAppActivity swanAppActivity, String str, d.b.g0.a.l1.c.b.b bVar, d.b.g0.a.v1.d.a aVar, d.b.g0.a.e0.n.b<d.b.g0.a.l1.c.c.a> bVar2) {
        d.b.g0.a.l1.c.c.a aVar2 = new d.b.g0.a.l1.c.c.a(bVar.f45192f);
        aVar2.f45195a = bVar.f45191e;
        if (aVar != null && aVar.j.a() == 0) {
            d.b.g0.a.l1.d.a.a("obtain user info detail, get login code");
            b.c cVar = new b.c(bVar.f45193g);
            Bundle bundle = new Bundle();
            bundle.putString("__plugin__", bVar.f45187a);
            d.b.g0.a.r1.d.e().s().R().q(swanAppActivity, cVar, bundle, new a(this, bVar2, aVar2, aVar));
            return;
        }
        d.b.g0.a.l1.d.a.a("open data result failure");
        bVar2.a(aVar2);
    }
}
