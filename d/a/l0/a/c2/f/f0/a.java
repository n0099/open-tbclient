package d.a.l0.a.c2.f.f0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.a.h;
import d.a.l0.a.k;
import d.a.l0.a.p.d.f0;
import d.a.l0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends b {

    /* renamed from: d.a.l0.a.c2.f.f0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0579a implements d.a.l0.a.q0.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f40984a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f40985b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f40986c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f40987d;

        public C0579a(d.a.l0.a.a2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            this.f40984a = eVar;
            this.f40985b = callbackHandler;
            this.f40986c = unitedSchemeEntity;
            this.f40987d = str;
        }

        @Override // d.a.l0.a.q0.b.a
        public void a() {
            if (a.this.f40990d) {
                d.a.l0.a.z1.b.f.e f2 = d.a.l0.a.z1.b.f.e.f(this.f40984a.getApplicationContext(), h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.F();
            }
            a.this.n(this.f40986c, this.f40985b, this.f40987d);
        }

        @Override // d.a.l0.a.q0.b.a
        public void b() {
            if (a.this.f40990d) {
                d.a.l0.a.z1.b.f.e f2 = d.a.l0.a.z1.b.f.e.f(this.f40984a.getApplicationContext(), h.aiapps_fav_fail);
                f2.l(2);
                f2.F();
            }
            a.this.n(this.f40986c, this.f40985b, this.f40987d);
        }

        @Override // d.a.l0.a.q0.b.a
        public void c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("success", "1");
            } catch (JSONException e2) {
                if (k.f43199a) {
                    e2.printStackTrace();
                }
            }
            if (a.this.f40990d) {
                b.m("1", "btn", "success");
                d.a.l0.a.j0.b.a.t();
                if (d.a.l0.a.j1.a.k(this.f40984a.x())) {
                    d.a.l0.a.j1.a.p("addmyswan", q0.n().f());
                } else {
                    Context applicationContext = this.f40984a.getApplicationContext();
                    d.a.l0.a.z1.b.f.e g2 = d.a.l0.a.z1.b.f.e.g(applicationContext, d.a.l0.a.c1.a.e0().f(applicationContext));
                    g2.l(2);
                    g2.p(2);
                    g2.F();
                }
            }
            UnitedSchemeUtility.safeCallback(this.f40985b, this.f40986c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f40987d);
        }
    }

    public a(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/addFavor");
    }

    @Override // d.a.l0.a.c2.f.f0.b
    public boolean j(d.a.l0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            return false;
        }
        try {
            String D = this.f40990d ? eVar.D() : new JSONObject(param).optString("appid");
            this.f40989c = D;
            return !TextUtils.isEmpty(D);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.a.l0.a.c2.f.f0.b
    public void k(d.a.l0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        PMSAppInfo s = d.a.l0.n.g.a.h().s(this.f40989c);
        if (s != null && !TextUtils.isEmpty(s.appId)) {
            if (this.f40990d) {
                b.m("1", "btn", "invoke");
            } else {
                b.m("1", RetrieveTaskManager.KEY, "invoke");
            }
            SwanFavorDataManager.h().b(this.f40989c, new C0579a(eVar, callbackHandler, unitedSchemeEntity, str));
            return;
        }
        n(unitedSchemeEntity, callbackHandler, str);
    }

    @Override // d.a.l0.a.c2.f.f0.b
    public void l(d.a.l0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        f0 e0;
        if (!this.f40990d || (e0 = d.a.l0.a.c1.a.e0()) == null) {
            return;
        }
        e0.g(eVar);
    }
}
