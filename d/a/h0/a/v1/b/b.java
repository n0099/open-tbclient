package d.a.h0.a.v1.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<JSONObject>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44822e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44823f;

        public a(b bVar, CallbackHandler callbackHandler, String str) {
            this.f44822e = callbackHandler;
            this.f44823f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<JSONObject> hVar) {
            JSONObject wrapCallbackParams;
            if (hVar.c() && d.a.h0.a.t.c.a.a.r(hVar.f44952a)) {
                JSONObject optJSONObject = hVar.f44952a.optJSONObject("data");
                if (optJSONObject.optBoolean("result")) {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0);
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "session key expired");
                }
            } else {
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(hVar.b());
                d.a.h0.g.c0.c.b(this.f44822e, wrapCallbackParams.toString());
            }
            this.f44822e.handleSchemeDispatchCallback(this.f44823f, wrapCallbackParams.toString());
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/checkSession");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            d.a.h0.g.c0.c.b(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return false;
        }
        String B = eVar.B();
        if (TextUtils.isEmpty(B)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key");
            d.a.h0.g.c0.c.b(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key").toString());
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            d.a.h0.g.c0.c.b(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            d.a.h0.g.c0.c.b(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            return false;
        } else if (!eVar.i().e(context)) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in");
            unitedSchemeEntity.result = wrapCallbackParams;
            d.a.h0.g.c0.c.b(callbackHandler, wrapCallbackParams.toString());
            return true;
        } else {
            d.a.h0.a.v1.c.i.c g2 = d.a.h0.a.r1.d.e().w().a().b().g((Activity) context, B);
            g2.p(new a(this, callbackHandler, optString));
            g2.a();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
