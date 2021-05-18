package d.a.i0.a.t1.c.d;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.i0.a.e2.c.i;
import d.a.i0.a.e2.c.j.f;
import d.a.i0.a.k;
import d.a.i0.a.u.e.a.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends d.a.i0.a.t1.c.d.a {

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.v2.e1.b<i<f.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.j.b f44610e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.t1.c.c.a f44611f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.e2.d.a f44612g;

        public a(e eVar, d.a.i0.a.h0.j.b bVar, d.a.i0.a.t1.c.c.a aVar, d.a.i0.a.e2.d.a aVar2) {
            this.f44610e = bVar;
            this.f44611f = aVar;
            this.f44612g = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<f.d> iVar) {
            if (iVar != null && iVar.c() && !TextUtils.isEmpty(iVar.f41562a.f41580a)) {
                JSONObject jSONObject = this.f44612g.f41597g;
                if (jSONObject != null) {
                    try {
                        jSONObject.put("code", iVar.f41562a.f41580a);
                        this.f44611f.f44588d = true;
                    } catch (JSONException e2) {
                        if (k.f43025a) {
                            d.a.i0.a.t1.d.a.a(Log.getStackTraceString(e2));
                        }
                    }
                    this.f44611f.f44589e = jSONObject.toString();
                }
                this.f44610e.a(this.f44611f);
                return;
            }
            d.a.i0.a.t1.d.a.a("login failure, can't get login code");
            this.f44610e.a(this.f44611f);
        }
    }

    @Override // d.a.i0.a.t1.c.d.b
    public d.a.i0.a.u.h.b b(JSONObject jSONObject) {
        return null;
    }

    @Override // d.a.i0.a.t1.c.d.b
    public String g() {
        return "snsapi_userinfo";
    }

    @Override // d.a.i0.a.t1.c.d.b
    public String h() {
        return "SwanPluginUserInfoFunPage";
    }

    @Override // d.a.i0.a.t1.c.d.a
    public void p(SwanAppActivity swanAppActivity, String str, d.a.i0.a.t1.c.b.b bVar, d.a.i0.a.e2.d.a aVar, d.a.i0.a.h0.j.b<d.a.i0.a.t1.c.c.a> bVar2) {
        d.a.i0.a.t1.c.c.a aVar2 = new d.a.i0.a.t1.c.c.a(bVar.f44581f);
        aVar2.f44585a = bVar.f44580e;
        if (aVar != null && aVar.j.a() == 0) {
            d.a.i0.a.t1.d.a.a("obtain user info detail, get login code");
            c.C0821c c0821c = new c.C0821c(bVar.f44582g);
            Bundle bundle = new Bundle();
            bundle.putString("__plugin__", bVar.f44576a);
            d.a.i0.a.a2.d.g().r().T().r(swanAppActivity, c0821c, bundle, new a(this, bVar2, aVar2, aVar), "SwanPluginUserInfoFunPage");
            return;
        }
        d.a.i0.a.t1.d.a.a("open data result failure");
        bVar2.a(aVar2);
    }
}
