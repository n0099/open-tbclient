package d.b.g0.a.v1.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.b.g0.a.i2.v;
import d.b.g0.a.t.c.j.a;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class e extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<JSONObject>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47081e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47082f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47083g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f47084h;

        public a(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, d.b.g0.a.r1.e eVar2) {
            this.f47081e = callbackHandler;
            this.f47082f = unitedSchemeEntity;
            this.f47083g = str;
            this.f47084h = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<JSONObject> hVar) {
            JSONObject jSONObject;
            if (hVar.c() && (jSONObject = hVar.f47200a) != null) {
                UnitedSchemeUtility.safeCallback(this.f47081e, this.f47082f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f47083g);
                d.b.g0.a.r1.e eVar = this.f47084h;
                if (eVar != null) {
                    this.f47084h.R().A(a.f.a(eVar), hVar.f47200a.toString());
                }
                d.b.g0.a.c0.c.g("getSwanId", "getSwanId success");
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f47081e, this.f47082f, UnitedSchemeUtility.wrapCallbackParams(10001, "internal_error").toString(), this.f47083g);
            d.b.g0.a.c0.c.b("getSwanId", "getSwanId failed: internal_error");
        }
    }

    public e(j jVar) {
        super(jVar, "/swanAPI/getSwanId");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (eVar == null) {
            d.b.g0.a.c0.c.b("getSwanId", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.b.g0.a.c0.c.b("getSwanId", "empty joParams");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.g0.a.c0.c.b("getSwanId", "empty cb");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        }
        if (d.b.g0.a.j1.m.c.b()) {
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
                        d.b.g0.a.c0.c.g("getSwanId", "getSwanId success");
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

    public final void j(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, String str) {
        d.b.g0.a.c0.c.g("getSwanId", "getSwanId start");
        if (!SwanAppNetworkUtils.h(context)) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(10002, "network_error").toString(), str);
            d.b.g0.a.c0.c.b("getSwanId", "network_error");
            return;
        }
        d.b.g0.a.v1.c.i.e d2 = d.b.g0.a.r1.d.e().o().a().a().d(context);
        d2.p(new a(this, callbackHandler, unitedSchemeEntity, str, eVar));
        d2.a();
    }
}
