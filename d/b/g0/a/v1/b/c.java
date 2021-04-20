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
public class c extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47079e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47080f;

        public a(c cVar, CallbackHandler callbackHandler, String str) {
            this.f47079e = callbackHandler;
            this.f47080f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.d.a aVar) {
            d.b.g0.a.c0.c.a("OpenData", "onOpenDataCallback:: ", aVar);
            if (!aVar.x()) {
                d.b.g0.a.v1.c.c.l(aVar, this.f47079e, this.f47080f);
            } else {
                this.f47079e.handleSchemeDispatchCallback(this.f47080f, UnitedSchemeUtility.wrapCallbackParams(aVar.f47231g, 0).toString());
            }
        }
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/getPhoneNumber");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        }
        Activity n = context instanceof Activity ? (Activity) context : eVar.n();
        if (n == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
            return false;
        }
        d.b.g0.a.v1.d.a.v(n, "mobile", null, false, new a(this, callbackHandler, optString));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
