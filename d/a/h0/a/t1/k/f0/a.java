package d.a.h0.a.t1.k.f0;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.h0.a.h;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import d.a.h0.a.t1.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends b {

    /* renamed from: d.a.h0.a.t1.k.f0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0804a implements d.a.h0.a.m0.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f44416a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44417b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44418c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f44419d;

        public C0804a(d.a.h0.a.r1.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            this.f44416a = eVar;
            this.f44417b = callbackHandler;
            this.f44418c = unitedSchemeEntity;
            this.f44419d = str;
        }

        @Override // d.a.h0.a.m0.b.a
        public void a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("success", "0");
            } catch (JSONException e2) {
                if (k.f43101a) {
                    e2.printStackTrace();
                }
            }
            if (a.this.f44422d) {
                d.a.h0.a.q1.b.f.d e3 = d.a.h0.a.q1.b.f.d.e(this.f44416a.getApplicationContext(), h.aiapps_fav_fail);
                e3.k(2);
                e3.C();
            }
            UnitedSchemeUtility.safeCallback(this.f44417b, this.f44418c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f44419d);
        }

        @Override // d.a.h0.a.m0.b.a
        public void b() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("success", "1");
            } catch (JSONException e2) {
                if (k.f43101a) {
                    e2.printStackTrace();
                }
            }
            if (a.this.f44422d) {
                d.a.h0.a.g0.c.a.t();
                if (d.a.h0.a.c1.a.l(this.f44416a.v())) {
                    d.a.h0.a.c1.a.q("addmyswan", k0.n().d());
                } else {
                    d.a.h0.a.q1.b.f.d e3 = d.a.h0.a.q1.b.f.d.e(this.f44416a.getApplicationContext(), h.aiapps_fav_success);
                    e3.k(2);
                    e3.o(2);
                    e3.C();
                }
            }
            UnitedSchemeUtility.safeCallback(this.f44417b, this.f44418c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f44419d);
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/addFavor");
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
        PMSAppInfo r = d.a.h0.l.i.a.h().r(this.f44421c);
        if (r != null && !TextUtils.isEmpty(r.appId)) {
            SwanFavorDataManager.i().b(this.f44421c, 1, new C0804a(eVar, callbackHandler, unitedSchemeEntity, str));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", "0");
        } catch (JSONException e2) {
            if (k.f43101a) {
                e2.printStackTrace();
            }
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
