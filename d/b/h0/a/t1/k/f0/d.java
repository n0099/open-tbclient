package d.b.h0.a.t1.k.f0;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import d.b.h0.a.h;
import d.b.h0.a.k;
import d.b.h0.a.t1.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends b {

    /* loaded from: classes3.dex */
    public class a implements d.b.h0.a.m0.b.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f47038a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47039b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47040c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f47041d;

        public a(d.b.h0.a.r1.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            this.f47038a = eVar;
            this.f47039b = callbackHandler;
            this.f47040c = unitedSchemeEntity;
            this.f47041d = str;
        }

        @Override // d.b.h0.a.m0.b.b
        public void a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("success", "0");
            } catch (JSONException e2) {
                if (k.f45772a) {
                    e2.printStackTrace();
                }
            }
            if (d.this.f47033d) {
                d.b.h0.a.q1.b.f.d e3 = d.b.h0.a.q1.b.f.d.e(this.f47038a.getApplicationContext(), h.aiapps_cancel_fav_fail);
                e3.k(2);
                e3.C();
            }
            UnitedSchemeUtility.safeCallback(this.f47039b, this.f47040c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f47041d);
        }

        @Override // d.b.h0.a.m0.b.b
        public void b() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("success", "1");
            } catch (JSONException e2) {
                if (k.f45772a) {
                    e2.printStackTrace();
                }
            }
            if (d.this.f47033d) {
                d.b.h0.a.q1.b.f.d e3 = d.b.h0.a.q1.b.f.d.e(this.f47038a.getApplicationContext(), h.aiapps_cancel_fav_success);
                e3.k(2);
                e3.x();
            }
            UnitedSchemeUtility.safeCallback(this.f47039b, this.f47040c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f47041d);
        }
    }

    public d(j jVar) {
        super(jVar, "/swanAPI/deleteFavor");
    }

    @Override // d.b.h0.a.t1.k.f0.b
    public boolean j(d.b.h0.a.r1.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            return false;
        }
        try {
            String appId = this.f47033d ? eVar.getAppId() : new JSONObject(param).optString("appid");
            this.f47032c = appId;
            return !TextUtils.isEmpty(appId);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.b.h0.a.t1.k.f0.b
    public void k(d.b.h0.a.r1.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        SwanFavorDataManager i = SwanFavorDataManager.i();
        String str2 = this.f47032c;
        a aVar = new a(eVar, callbackHandler, unitedSchemeEntity, str);
        d.b.h0.a.j0.j.c k = d.b.h0.a.j0.j.c.k();
        k.m(3);
        i.d(str2, aVar, k.j());
    }
}
