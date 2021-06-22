package d.a.m0.a.p2.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.m0.a.c0.c.g.a;
import d.a.m0.a.c2.e;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e0.d;
import d.a.m0.a.g1.f;
import d.a.m0.a.h0.g.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* loaded from: classes3.dex */
    public class a implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47912a;

        public a(CallbackHandler callbackHandler) {
            this.f47912a = callbackHandler;
        }

        @Override // d.a.m0.a.c0.c.g.a.h
        public void a(String str, String str2, JSONObject jSONObject) {
            b.this.k(str, str2, this.f47912a, 0, jSONObject);
        }
    }

    public b(e eVar) {
        super(eVar, "/swanAPI/openTextarea");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (a0.f44733b) {
            Log.d("OpenTextAreaAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.g("OpenTextAreaAction", "OpenTextAreaAction paramsJson: " + optParamsAsJo);
        d.a.m0.a.c0.c.g.b bVar = new d.a.m0.a.c0.c.g.b();
        try {
            bVar.a(optParamsAsJo);
        } catch (JSONException e2) {
            e2.printStackTrace();
            d.c("OpenTextAreaAction", "model parse exception:", e2);
        }
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            d.b("OpenTextAreaAction", "activity is null when add textarea");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "activity is null when add textarea");
            return false;
        }
        g W = f.V().W();
        if (W == null) {
            d.b("OpenTextAreaAction", "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragmentManager is null");
            return false;
        }
        d.a.m0.a.h0.g.f o = W.o();
        if (o == null) {
            d.b("OpenTextAreaAction", "fragment is null when add input");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment is null when add input");
            return false;
        }
        d.a.m0.a.c0.b.c w = new d.a.m0.a.c0.c.g.a(context, bVar, activity, o, new a(callbackHandler)).w();
        if (!w.a()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, w.f44634b);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public final void k(String str, String str2, CallbackHandler callbackHandler, int i2, JSONObject jSONObject) {
        d.g("OpenTextAreaAction", "sendAsyncCallback, arg0: " + i2 + ", arg1: " + jSONObject);
        if (TextUtils.isEmpty(str2)) {
            d.a.m0.a.c0.g.a.a("OpenTextAreaAction", "sendAsyncCallback with a empty callback");
        } else {
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        }
    }
}
