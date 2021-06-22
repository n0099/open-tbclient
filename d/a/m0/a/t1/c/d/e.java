package d.a.m0.a.t1.c.d;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.m0.a.e2.c.i;
import d.a.m0.a.e2.c.j.f;
import d.a.m0.a.k;
import d.a.m0.a.u.e.a.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends d.a.m0.a.t1.c.d.a {

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.v2.e1.b<i<f.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.j.b f48568e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.t1.c.c.a f48569f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.e2.d.a f48570g;

        public a(e eVar, d.a.m0.a.h0.j.b bVar, d.a.m0.a.t1.c.c.a aVar, d.a.m0.a.e2.d.a aVar2) {
            this.f48568e = bVar;
            this.f48569f = aVar;
            this.f48570g = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<f.d> iVar) {
            if (iVar != null && iVar.c() && !TextUtils.isEmpty(iVar.f45520a.f45538a)) {
                JSONObject jSONObject = this.f48570g.f45555g;
                if (jSONObject != null) {
                    try {
                        jSONObject.put("code", iVar.f45520a.f45538a);
                        this.f48569f.f48546d = true;
                    } catch (JSONException e2) {
                        if (k.f46983a) {
                            d.a.m0.a.t1.d.a.a(Log.getStackTraceString(e2));
                        }
                    }
                    this.f48569f.f48547e = jSONObject.toString();
                }
                this.f48568e.a(this.f48569f);
                return;
            }
            d.a.m0.a.t1.d.a.a("login failure, can't get login code");
            this.f48568e.a(this.f48569f);
        }
    }

    @Override // d.a.m0.a.t1.c.d.b
    public d.a.m0.a.u.h.b b(JSONObject jSONObject) {
        return null;
    }

    @Override // d.a.m0.a.t1.c.d.b
    public String g() {
        return "snsapi_userinfo";
    }

    @Override // d.a.m0.a.t1.c.d.b
    public String h() {
        return "SwanPluginUserInfoFunPage";
    }

    @Override // d.a.m0.a.t1.c.d.a
    public void p(SwanAppActivity swanAppActivity, String str, d.a.m0.a.t1.c.b.b bVar, d.a.m0.a.e2.d.a aVar, d.a.m0.a.h0.j.b<d.a.m0.a.t1.c.c.a> bVar2) {
        d.a.m0.a.t1.c.c.a aVar2 = new d.a.m0.a.t1.c.c.a(bVar.f48539f);
        aVar2.f48543a = bVar.f48538e;
        if (aVar != null && aVar.j.a() == 0) {
            d.a.m0.a.t1.d.a.a("obtain user info detail, get login code");
            c.C0891c c0891c = new c.C0891c(bVar.f48540g);
            Bundle bundle = new Bundle();
            bundle.putString("__plugin__", bVar.f48534a);
            d.a.m0.a.a2.d.g().r().T().r(swanAppActivity, c0891c, bundle, new a(this, bVar2, aVar2, aVar), "SwanPluginUserInfoFunPage");
            return;
        }
        d.a.m0.a.t1.d.a.a("open data result failure");
        bVar2.a(aVar2);
    }
}
