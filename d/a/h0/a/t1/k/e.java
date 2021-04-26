package d.a.h0.a.t1.k;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.v1.c.i.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44413e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44414f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44415g;

        public a(e eVar, CallbackHandler callbackHandler, String str, String str2) {
            this.f44413e = callbackHandler;
            this.f44414f = str;
            this.f44415g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            if (!d.a.h0.a.v1.c.c.h(hVar)) {
                d.a.h0.a.v1.c.c.o(hVar, this.f44413e, this.f44414f);
                return;
            }
            this.f44413e.handleSchemeDispatchCallback(this.f44414f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            d.a.h0.a.q0.a.b().e(this.f44415g);
        }
    }

    public e(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/confirmSwanClose");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (eVar == null) {
            d.a.h0.a.c0.c.b("SwanConfirmClose", "framework runtime exception");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "framework runtime exception");
            return false;
        } else if (!(context instanceof Activity)) {
            d.a.h0.a.c0.c.b("SwanConfirmClose", "handle action, but context is not Activity");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.a.h0.a.c0.c.b("SwanConfirmClose", "empty params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.h0.a.c0.c.b("SwanConfirmClose", "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            eVar.R().g(context, "mapp_confirm_close", new a(this, callbackHandler, optString, optParamsAsJo.optString("content")));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
