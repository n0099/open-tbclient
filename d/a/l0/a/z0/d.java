package d.a.l0.a.z0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.l0.a.c0.c.f.a;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.g1.f;
import d.a.l0.a.h0.g.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends a0 {

    /* loaded from: classes3.dex */
    public class a implements a.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45988a;

        public a(CallbackHandler callbackHandler) {
            this.f45988a = callbackHandler;
        }

        @Override // d.a.l0.a.c0.c.f.a.g
        public void a(String str, JSONObject jSONObject) {
            d.this.k(this.f45988a, 0, str, jSONObject);
        }
    }

    public d(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/openInput");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (a0.f40949b) {
            Log.d("OpenInputAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        f V = f.V();
        if (optParamsAsJo == null) {
            d.a.l0.a.e0.d.b("openInput", "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        g W = V.W();
        if (W == null) {
            d.a.l0.a.e0.d.b("openInput", "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragmentManager is null");
            return false;
        }
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            d.a.l0.a.e0.d.b("openInput", "activity is null when add input");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "activity is null when add input");
            return false;
        }
        d.a.l0.a.h0.g.f o = W.o();
        if (o == null) {
            d.a.l0.a.e0.d.b("openInput", "fragment is null when add input");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment is null when add input");
            return false;
        }
        d.a.l0.a.c0.c.f.b bVar = new d.a.l0.a.c0.c.f.b();
        try {
            bVar.a(optParamsAsJo);
        } catch (JSONException e2) {
            e2.printStackTrace();
            d.a.l0.a.e0.d.c("OpenInputAction", "model parse exception:", e2);
        }
        boolean a2 = new d.a.l0.a.c0.c.f.a(context, bVar, activity, o, new a(callbackHandler)).w().a();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a2 ? 0 : 1001));
        return a2;
    }

    public final void k(CallbackHandler callbackHandler, int i2, String str, JSONObject jSONObject) {
        if (a0.f40949b) {
            Log.d("OpenInputAction", "sendAsyncCallback, arg0: " + i2 + ", arg1: " + jSONObject);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
    }
}
