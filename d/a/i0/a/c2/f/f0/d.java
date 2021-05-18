package d.a.i0.a.c2.f.f0;

import android.text.TextUtils;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import d.a.i0.a.h;
import d.a.i0.a.k;
import d.a.i0.a.p.d.f0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends b {

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.q0.b.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f40822a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f40823b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f40824c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f40825d;

        public a(d.a.i0.a.a2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            this.f40822a = eVar;
            this.f40823b = callbackHandler;
            this.f40824c = unitedSchemeEntity;
            this.f40825d = str;
        }

        @Override // d.a.i0.a.q0.b.b
        public void a() {
            if (d.this.f40816d) {
                d.a.i0.a.z1.b.f.e f2 = d.a.i0.a.z1.b.f.e.f(this.f40822a.getApplicationContext(), h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.F();
            }
            d.this.n(this.f40824c, this.f40823b, this.f40825d);
        }

        @Override // d.a.i0.a.q0.b.b
        public void b() {
            if (d.this.f40816d) {
                d.a.i0.a.z1.b.f.e f2 = d.a.i0.a.z1.b.f.e.f(this.f40822a.getApplicationContext(), h.aiapps_cancel_fav_fail);
                f2.l(2);
                f2.F();
            }
            d.this.n(this.f40824c, this.f40823b, this.f40825d);
        }

        @Override // d.a.i0.a.q0.b.b
        public void c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("success", "1");
            } catch (JSONException e2) {
                if (k.f43025a) {
                    e2.printStackTrace();
                }
            }
            if (d.this.f40816d) {
                b.m("0", "btn", "success");
                d.a.i0.a.z1.b.f.e f2 = d.a.i0.a.z1.b.f.e.f(this.f40822a.getApplicationContext(), h.aiapps_cancel_fav_success);
                f2.l(2);
                f2.F();
            }
            UnitedSchemeUtility.safeCallback(this.f40823b, this.f40824c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f40825d);
        }
    }

    public d(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/deleteFavor");
    }

    @Override // d.a.i0.a.c2.f.f0.b
    public boolean j(d.a.i0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            return false;
        }
        try {
            String D = this.f40816d ? eVar.D() : new JSONObject(param).optString("appid");
            this.f40815c = D;
            return !TextUtils.isEmpty(D);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.a.i0.a.c2.f.f0.b
    public void k(d.a.i0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        if (this.f40816d) {
            b.m("0", "btn", "invoke");
        } else {
            b.m("0", RetrieveTaskManager.KEY, "invoke");
        }
        SwanFavorDataManager h2 = SwanFavorDataManager.h();
        String str2 = this.f40815c;
        a aVar = new a(eVar, callbackHandler, unitedSchemeEntity, str);
        d.a.i0.a.n0.l.c l = d.a.i0.a.n0.l.c.l();
        l.n(3);
        h2.c(str2, aVar, l.k());
    }

    @Override // d.a.i0.a.c2.f.f0.b
    public void l(d.a.i0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        f0 e0;
        if (!this.f40816d || (e0 = d.a.i0.a.c1.a.e0()) == null) {
            return;
        }
        e0.e(eVar);
    }
}
