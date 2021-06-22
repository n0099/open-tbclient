package d.a.m0.a.c2.f;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.e2.c.j.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44748e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44749f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44750g;

        public a(e eVar, CallbackHandler callbackHandler, String str, String str2) {
            this.f44748e = callbackHandler;
            this.f44749f = str;
            this.f44750g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.e2.c.i<b.e> iVar) {
            if (!d.a.m0.a.e2.c.d.h(iVar)) {
                d.a.m0.a.e2.c.d.p(iVar, this.f44748e, this.f44749f);
                return;
            }
            this.f44748e.handleSchemeDispatchCallback(this.f44749f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            d.a.m0.a.v0.a.b().e(this.f44750g);
        }
    }

    public e(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/confirmSwanClose");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (eVar == null) {
            d.a.m0.a.e0.d.b("SwanConfirmClose", "framework runtime exception");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "framework runtime exception");
            return false;
        } else if (!(context instanceof Activity)) {
            d.a.m0.a.e0.d.b("SwanConfirmClose", "handle action, but context is not Activity");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.a.m0.a.e0.d.b("SwanConfirmClose", "empty params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.m0.a.e0.d.b("SwanConfirmClose", "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            eVar.T().g(context, "mapp_confirm_close", new a(this, callbackHandler, optString, optParamsAsJo.optString("content")));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
