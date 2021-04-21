package d.b.h0.b.m.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.v1.c.i.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f48070e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48071f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48072g;

        public a(Context context, CallbackHandler callbackHandler, String str) {
            this.f48070e = context;
            this.f48071f = callbackHandler;
            this.f48072g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.c.h<b.e> hVar) {
            c.this.k(hVar, this.f48070e, this.f48071f, this.f48072g);
        }
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/getBDUSS");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
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
            eVar.R().g(context, "mapp_i_get_bduss", new a(context, callbackHandler, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public final void k(d.b.h0.a.v1.c.h<b.e> hVar, Context context, CallbackHandler callbackHandler, String str) {
        JSONObject wrapCallbackParams;
        if (!d.b.h0.a.v1.c.c.h(hVar)) {
            d.b.h0.a.v1.c.c.o(hVar, callbackHandler, str);
            return;
        }
        String i = d.b.h0.b.i.a.i(context);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bduss", i);
            wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
        } catch (JSONException e2) {
            if (a0.f47009b) {
                e2.printStackTrace();
            }
            wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
        }
        callbackHandler.handleSchemeDispatchCallback(str, wrapCallbackParams.toString());
    }
}
