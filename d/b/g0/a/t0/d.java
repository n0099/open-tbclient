package d.b.g0.a.t0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.g0.a.a0.c.f.a;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.z0.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends a0 {

    /* loaded from: classes3.dex */
    public class a implements a.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46226a;

        public a(CallbackHandler callbackHandler) {
            this.f46226a = callbackHandler;
        }

        @Override // d.b.g0.a.a0.c.f.a.g
        public void a(String str, JSONObject jSONObject) {
            d.this.k(this.f46226a, 0, str, jSONObject);
        }
    }

    public d(j jVar) {
        super(jVar, "/swanAPI/openInput");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (a0.f46287b) {
            Log.d("OpenInputAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        f V = f.V();
        if (optParamsAsJo == null) {
            d.b.g0.a.c0.c.b("openInput", "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.b.g0.a.e0.l.f W = V.W();
        if (W == null) {
            d.b.g0.a.c0.c.b("openInput", "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragmentManager is null");
            return false;
        }
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            d.b.g0.a.c0.c.b("openInput", "activity is null when add input");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "activity is null when add input");
            return false;
        }
        d.b.g0.a.e0.l.e o = W.o();
        if (o == null) {
            d.b.g0.a.c0.c.b("openInput", "fragment is null when add input");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment is null when add input");
            return false;
        }
        d.b.g0.a.a0.c.f.b bVar = new d.b.g0.a.a0.c.f.b();
        try {
            bVar.a(optParamsAsJo);
        } catch (JSONException e2) {
            e2.printStackTrace();
            d.b.g0.a.c0.c.c("OpenInputAction", "model parse exception:", e2);
        }
        boolean a2 = new d.b.g0.a.a0.c.f.a(context, bVar, activity, o, new a(callbackHandler)).w().a();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a2 ? 0 : 1001));
        return a2;
    }

    public final void k(CallbackHandler callbackHandler, int i, String str, JSONObject jSONObject) {
        if (a0.f46287b) {
            Log.d("OpenInputAction", "sendAsyncCallback, arg0: " + i + ", arg1: " + jSONObject);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
    }
}
