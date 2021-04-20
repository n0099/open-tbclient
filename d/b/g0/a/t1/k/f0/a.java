package d.b.g0.a.t1.k.f0;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.g0.a.h;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.t1.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends b {

    /* renamed from: d.b.g0.a.t1.k.f0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0845a implements d.b.g0.a.m0.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46698a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46699b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46700c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f46701d;

        public C0845a(d.b.g0.a.r1.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            this.f46698a = eVar;
            this.f46699b = callbackHandler;
            this.f46700c = unitedSchemeEntity;
            this.f46701d = str;
        }

        @Override // d.b.g0.a.m0.b.a
        public void a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("success", "1");
            } catch (JSONException e2) {
                if (k.f45443a) {
                    e2.printStackTrace();
                }
            }
            if (a.this.f46704d) {
                d.b.g0.a.g0.c.a.t();
                if (d.b.g0.a.c1.a.l(this.f46698a.n())) {
                    d.b.g0.a.c1.a.q("addmyswan", k0.n().d());
                } else {
                    d.b.g0.a.q1.b.f.d e3 = d.b.g0.a.q1.b.f.d.e(this.f46698a.getApplicationContext(), h.aiapps_fav_success);
                    e3.k(2);
                    e3.o(2);
                    e3.C();
                }
            }
            UnitedSchemeUtility.safeCallback(this.f46699b, this.f46700c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f46701d);
        }

        @Override // d.b.g0.a.m0.b.a
        public void b() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("success", "0");
            } catch (JSONException e2) {
                if (k.f45443a) {
                    e2.printStackTrace();
                }
            }
            if (a.this.f46704d) {
                d.b.g0.a.q1.b.f.d e3 = d.b.g0.a.q1.b.f.d.e(this.f46698a.getApplicationContext(), h.aiapps_fav_fail);
                e3.k(2);
                e3.C();
            }
            UnitedSchemeUtility.safeCallback(this.f46699b, this.f46700c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f46701d);
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/addFavor");
    }

    @Override // d.b.g0.a.t1.k.f0.b
    public boolean j(d.b.g0.a.r1.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            return false;
        }
        try {
            String appId = this.f46704d ? eVar.getAppId() : new JSONObject(param).optString("appid");
            this.f46703c = appId;
            return !TextUtils.isEmpty(appId);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.b.g0.a.t1.k.f0.b
    public void k(d.b.g0.a.r1.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        PMSAppInfo r = d.b.g0.l.i.a.h().r(this.f46703c);
        if (r != null && !TextUtils.isEmpty(r.appId)) {
            SwanFavorDataManager.i().b(this.f46703c, 1, new C0845a(eVar, callbackHandler, unitedSchemeEntity, str));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", "0");
        } catch (JSONException e2) {
            if (k.f45443a) {
                e2.printStackTrace();
            }
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
