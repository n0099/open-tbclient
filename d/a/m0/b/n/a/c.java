package d.a.m0.b.n.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e2.c.i;
import d.a.m0.a.e2.c.j.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f50097e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50098f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f50099g;

        public a(Context context, CallbackHandler callbackHandler, String str) {
            this.f50097e = context;
            this.f50098f = callbackHandler;
            this.f50099g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            c.this.k(iVar, this.f50097e, this.f50098f, this.f50099g);
        }
    }

    public c(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getBDUSS");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
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
        } else if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
            return false;
        } else {
            eVar.T().g(context, "mapp_i_get_bduss", new a(context, callbackHandler, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public final void k(i<b.e> iVar, Context context, CallbackHandler callbackHandler, String str) {
        JSONObject wrapCallbackParams;
        if (!d.a.m0.a.e2.c.d.h(iVar)) {
            d.a.m0.a.e2.c.d.p(iVar, callbackHandler, str);
            return;
        }
        String i2 = d.a.m0.b.j.a.i(context);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bduss", i2);
            wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
        } catch (JSONException e2) {
            if (a0.f44733b) {
                e2.printStackTrace();
            }
            wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
        }
        callbackHandler.handleSchemeDispatchCallback(str, wrapCallbackParams.toString());
    }
}
