package d.a.l0.a.t1.c.d;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.l0.a.e2.c.i;
import d.a.l0.a.e2.c.j.f;
import d.a.l0.a.k;
import d.a.l0.a.u.e.a.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends d.a.l0.a.t1.c.d.a {

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<i<f.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.j.b f44786e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.t1.c.c.a f44787f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.e2.d.a f44788g;

        public a(e eVar, d.a.l0.a.h0.j.b bVar, d.a.l0.a.t1.c.c.a aVar, d.a.l0.a.e2.d.a aVar2) {
            this.f44786e = bVar;
            this.f44787f = aVar;
            this.f44788g = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<f.d> iVar) {
            if (iVar != null && iVar.c() && !TextUtils.isEmpty(iVar.f41736a.f41754a)) {
                JSONObject jSONObject = this.f44788g.f41771g;
                if (jSONObject != null) {
                    try {
                        jSONObject.put("code", iVar.f41736a.f41754a);
                        this.f44787f.f44764d = true;
                    } catch (JSONException e2) {
                        if (k.f43199a) {
                            d.a.l0.a.t1.d.a.a(Log.getStackTraceString(e2));
                        }
                    }
                    this.f44787f.f44765e = jSONObject.toString();
                }
                this.f44786e.a(this.f44787f);
                return;
            }
            d.a.l0.a.t1.d.a.a("login failure, can't get login code");
            this.f44786e.a(this.f44787f);
        }
    }

    @Override // d.a.l0.a.t1.c.d.b
    public d.a.l0.a.u.h.b b(JSONObject jSONObject) {
        return null;
    }

    @Override // d.a.l0.a.t1.c.d.b
    public String g() {
        return "snsapi_userinfo";
    }

    @Override // d.a.l0.a.t1.c.d.b
    public String h() {
        return "SwanPluginUserInfoFunPage";
    }

    @Override // d.a.l0.a.t1.c.d.a
    public void p(SwanAppActivity swanAppActivity, String str, d.a.l0.a.t1.c.b.b bVar, d.a.l0.a.e2.d.a aVar, d.a.l0.a.h0.j.b<d.a.l0.a.t1.c.c.a> bVar2) {
        d.a.l0.a.t1.c.c.a aVar2 = new d.a.l0.a.t1.c.c.a(bVar.f44757f);
        aVar2.f44761a = bVar.f44756e;
        if (aVar != null && aVar.j.a() == 0) {
            d.a.l0.a.t1.d.a.a("obtain user info detail, get login code");
            c.C0832c c0832c = new c.C0832c(bVar.f44758g);
            Bundle bundle = new Bundle();
            bundle.putString("__plugin__", bVar.f44752a);
            d.a.l0.a.a2.d.g().r().T().r(swanAppActivity, c0832c, bundle, new a(this, bVar2, aVar2, aVar), "SwanPluginUserInfoFunPage");
            return;
        }
        d.a.l0.a.t1.d.a.a("open data result failure");
        bVar2.a(aVar2);
    }
}
