package d.b.g0.a.v1.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<JSONObject>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47077e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47078f;

        public a(b bVar, CallbackHandler callbackHandler, String str) {
            this.f47077e = callbackHandler;
            this.f47078f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<JSONObject> hVar) {
            JSONObject wrapCallbackParams;
            if (hVar.c() && d.b.g0.a.t.c.a.a.r(hVar.f47200a)) {
                JSONObject optJSONObject = hVar.f47200a.optJSONObject("data");
                if (optJSONObject.optBoolean("result")) {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0);
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "session key expired");
                }
            } else {
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(hVar.b());
                d.b.g0.g.c0.c.b(this.f47077e, wrapCallbackParams.toString());
            }
            this.f47077e.handleSchemeDispatchCallback(this.f47078f, wrapCallbackParams.toString());
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/checkSession");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            d.b.g0.g.c0.c.b(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return false;
        }
        String B = eVar.B();
        if (TextUtils.isEmpty(B)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key");
            d.b.g0.g.c0.c.b(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key").toString());
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            d.b.g0.g.c0.c.b(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            d.b.g0.g.c0.c.b(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            return false;
        } else if (!eVar.z().e(context)) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in");
            unitedSchemeEntity.result = wrapCallbackParams;
            d.b.g0.g.c0.c.b(callbackHandler, wrapCallbackParams.toString());
            return true;
        } else {
            d.b.g0.a.v1.c.i.c g2 = d.b.g0.a.r1.d.e().o().a().a().g((Activity) context, B);
            g2.p(new a(this, callbackHandler, optString));
            g2.a();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
