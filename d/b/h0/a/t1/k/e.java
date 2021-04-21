package d.b.h0.a.t1.k;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.v1.c.i.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47024e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47025f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47026g;

        public a(e eVar, CallbackHandler callbackHandler, String str, String str2) {
            this.f47024e = callbackHandler;
            this.f47025f = str;
            this.f47026g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.c.h<b.e> hVar) {
            if (!d.b.h0.a.v1.c.c.h(hVar)) {
                d.b.h0.a.v1.c.c.o(hVar, this.f47024e, this.f47025f);
                return;
            }
            this.f47024e.handleSchemeDispatchCallback(this.f47025f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            d.b.h0.a.q0.a.b().e(this.f47026g);
        }
    }

    public e(d.b.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/confirmSwanClose");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (eVar == null) {
            d.b.h0.a.c0.c.b("SwanConfirmClose", "framework runtime exception");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "framework runtime exception");
            return false;
        } else if (!(context instanceof Activity)) {
            d.b.h0.a.c0.c.b("SwanConfirmClose", "handle action, but context is not Activity");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.b.h0.a.c0.c.b("SwanConfirmClose", "empty params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.b.h0.a.c0.c.b("SwanConfirmClose", "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            eVar.R().g(context, "mapp_confirm_close", new a(this, callbackHandler, optString, optParamsAsJo.optString("content")));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
