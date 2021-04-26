package d.a.h0.a.v1.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.a.h0.a.i2.v;
import d.a.h0.a.t.c.j.a;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class e extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<JSONObject>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44826e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44827f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44828g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f44829h;

        public a(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, d.a.h0.a.r1.e eVar2) {
            this.f44826e = callbackHandler;
            this.f44827f = unitedSchemeEntity;
            this.f44828g = str;
            this.f44829h = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<JSONObject> hVar) {
            JSONObject jSONObject;
            if (hVar.c() && (jSONObject = hVar.f44952a) != null) {
                UnitedSchemeUtility.safeCallback(this.f44826e, this.f44827f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f44828g);
                d.a.h0.a.r1.e eVar = this.f44829h;
                if (eVar != null) {
                    this.f44829h.R().A(a.f.a(eVar), hVar.f44952a.toString());
                }
                d.a.h0.a.c0.c.g("getSwanId", "getSwanId success");
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f44826e, this.f44827f, UnitedSchemeUtility.wrapCallbackParams(10001, "internal_error").toString(), this.f44828g);
            d.a.h0.a.c0.c.b("getSwanId", "getSwanId failed: internal_error");
        }
    }

    public e(j jVar) {
        super(jVar, "/swanAPI/getSwanId");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (eVar == null) {
            d.a.h0.a.c0.c.b("getSwanId", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.a.h0.a.c0.c.b("getSwanId", "empty joParams");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.h0.a.c0.c.b("getSwanId", "empty cb");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        }
        if (d.a.h0.a.j1.m.c.b()) {
            String p = eVar.R().p(a.f.a(eVar), null);
            if (TextUtils.isEmpty(p)) {
                j(context, unitedSchemeEntity, callbackHandler, eVar, optString);
            } else {
                JSONObject b2 = v.b(p);
                JSONObject optJSONObject = b2.optJSONObject("data");
                if (optJSONObject != null) {
                    String optString2 = optJSONObject.optString("swanid");
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.equals(StringUtil.NULL_STRING, optString2)) {
                        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(b2, 0).toString(), optString);
                        d.a.h0.a.c0.c.g("getSwanId", "getSwanId success");
                    } else {
                        j(context, unitedSchemeEntity, callbackHandler, eVar, optString);
                    }
                } else {
                    j(context, unitedSchemeEntity, callbackHandler, eVar, optString);
                }
            }
        } else {
            j(context, unitedSchemeEntity, callbackHandler, eVar, optString);
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void j(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar, String str) {
        d.a.h0.a.c0.c.g("getSwanId", "getSwanId start");
        if (!SwanAppNetworkUtils.h(context)) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(10002, "network_error").toString(), str);
            d.a.h0.a.c0.c.b("getSwanId", "network_error");
            return;
        }
        d.a.h0.a.v1.c.i.e e2 = d.a.h0.a.r1.d.e().w().a().b().e(context);
        e2.p(new a(this, callbackHandler, unitedSchemeEntity, str, eVar));
        e2.a();
    }
}
