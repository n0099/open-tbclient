package d.a.l0.a.e2.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.u.e.l.b;
import d.a.l0.a.v2.w;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class e extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<JSONObject>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41606e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41607f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f41608g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f41609h;

        public a(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, d.a.l0.a.a2.e eVar2) {
            this.f41606e = callbackHandler;
            this.f41607f = unitedSchemeEntity;
            this.f41608g = str;
            this.f41609h = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<JSONObject> iVar) {
            JSONObject jSONObject;
            if (iVar.c() && (jSONObject = iVar.f41736a) != null) {
                UnitedSchemeUtility.safeCallback(this.f41606e, this.f41607f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f41608g);
                d.a.l0.a.a2.e eVar = this.f41609h;
                if (eVar != null) {
                    this.f41609h.T().B(b.h.a(eVar), iVar.f41736a.toString());
                }
                d.a.l0.a.e0.d.g("getSwanId", "getSwanId success");
                return;
            }
            UnitedSchemeUtility.safeCallback(this.f41606e, this.f41607f, UnitedSchemeUtility.wrapCallbackParams(10001, "internal_error").toString(), this.f41608g);
            d.a.l0.a.e0.d.b("getSwanId", "getSwanId failed: internal_error");
        }
    }

    public e(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getSwanId");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (eVar == null) {
            d.a.l0.a.e0.d.b("getSwanId", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.a.l0.a.e0.d.b("getSwanId", "empty joParams");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.l0.a.e0.d.b("getSwanId", "empty cb");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        }
        if (d.a.l0.a.r1.l.b.j()) {
            String q = eVar.T().q(b.h.a(eVar), null);
            if (TextUtils.isEmpty(q)) {
                j(context, unitedSchemeEntity, callbackHandler, eVar, optString);
            } else {
                JSONObject d2 = w.d(q);
                JSONObject optJSONObject = d2.optJSONObject("data");
                if (optJSONObject != null) {
                    String optString2 = optJSONObject.optString("swanid");
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.equals(StringUtil.NULL_STRING, optString2)) {
                        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(d2, 0).toString(), optString);
                        d.a.l0.a.e0.d.g("getSwanId", "getSwanId success");
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

    public final void j(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, String str) {
        d.a.l0.a.e0.d.g("getSwanId", "getSwanId start");
        if (!SwanAppNetworkUtils.i(context)) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(10002, "network_error").toString(), str);
            d.a.l0.a.e0.d.b("getSwanId", "network_error");
            return;
        }
        d.a.l0.a.e2.c.j.e e2 = d.a.l0.a.a2.d.g().y().a().b().e(context);
        e2.p(new a(this, callbackHandler, unitedSchemeEntity, str, eVar));
        e2.a();
    }
}
