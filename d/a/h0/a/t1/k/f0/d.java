package d.a.h0.a.t1.k.f0;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import d.a.h0.a.h;
import d.a.h0.a.k;
import d.a.h0.a.t1.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends b {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.m0.b.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f44428a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44429b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44430c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f44431d;

        public a(d.a.h0.a.r1.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            this.f44428a = eVar;
            this.f44429b = callbackHandler;
            this.f44430c = unitedSchemeEntity;
            this.f44431d = str;
        }

        @Override // d.a.h0.a.m0.b.b
        public void a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("success", "0");
            } catch (JSONException e2) {
                if (k.f43101a) {
                    e2.printStackTrace();
                }
            }
            if (d.this.f44422d) {
                d.a.h0.a.q1.b.f.d e3 = d.a.h0.a.q1.b.f.d.e(this.f44428a.getApplicationContext(), h.aiapps_cancel_fav_fail);
                e3.k(2);
                e3.C();
            }
            UnitedSchemeUtility.safeCallback(this.f44429b, this.f44430c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f44431d);
        }

        @Override // d.a.h0.a.m0.b.b
        public void b() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("success", "1");
            } catch (JSONException e2) {
                if (k.f43101a) {
                    e2.printStackTrace();
                }
            }
            if (d.this.f44422d) {
                d.a.h0.a.q1.b.f.d e3 = d.a.h0.a.q1.b.f.d.e(this.f44428a.getApplicationContext(), h.aiapps_cancel_fav_success);
                e3.k(2);
                e3.x();
            }
            UnitedSchemeUtility.safeCallback(this.f44429b, this.f44430c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f44431d);
        }
    }

    public d(j jVar) {
        super(jVar, "/swanAPI/deleteFavor");
    }

    @Override // d.a.h0.a.t1.k.f0.b
    public boolean j(d.a.h0.a.r1.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            return false;
        }
        try {
            String appId = this.f44422d ? eVar.getAppId() : new JSONObject(param).optString("appid");
            this.f44421c = appId;
            return !TextUtils.isEmpty(appId);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.a.h0.a.t1.k.f0.b
    public void k(d.a.h0.a.r1.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        SwanFavorDataManager i2 = SwanFavorDataManager.i();
        String str2 = this.f44421c;
        a aVar = new a(eVar, callbackHandler, unitedSchemeEntity, str);
        d.a.h0.a.j0.j.c k = d.a.h0.a.j0.j.c.k();
        k.m(3);
        i2.d(str2, aVar, k.j());
    }
}
