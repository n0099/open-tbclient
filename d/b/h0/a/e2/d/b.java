package d.b.h0.a.e2.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.h0.a.a0.c.g.a;
import d.b.h0.a.r1.e;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.z0.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* loaded from: classes3.dex */
    public class a implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45115a;

        public a(CallbackHandler callbackHandler) {
            this.f45115a = callbackHandler;
        }

        @Override // d.b.h0.a.a0.c.g.a.h
        public void a(String str, String str2, JSONObject jSONObject) {
            b.this.k(str, str2, this.f45115a, 0, jSONObject);
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/openTextarea");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a0.f47009b) {
            Log.d("OpenTextAreaAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.b.h0.a.c0.c.g("OpenTextAreaAction", "OpenTextAreaAction paramsJson: " + optParamsAsJo);
        d.b.h0.a.a0.c.g.b bVar = new d.b.h0.a.a0.c.g.b();
        try {
            bVar.a(optParamsAsJo);
        } catch (JSONException e2) {
            e2.printStackTrace();
            d.b.h0.a.c0.c.c("OpenTextAreaAction", "model parse exception:", e2);
        }
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            d.b.h0.a.c0.c.b("OpenTextAreaAction", "activity is null when add textarea");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "activity is null when add textarea");
            return false;
        }
        d.b.h0.a.e0.l.f W = f.V().W();
        if (W == null) {
            d.b.h0.a.c0.c.b("OpenTextAreaAction", "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragmentManager is null");
            return false;
        }
        d.b.h0.a.e0.l.e o = W.o();
        if (o == null) {
            d.b.h0.a.c0.c.b("OpenTextAreaAction", "fragment is null when add input");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment is null when add input");
            return false;
        }
        d.b.h0.a.a0.b.c w = new d.b.h0.a.a0.c.g.a(context, bVar, activity, o, new a(callbackHandler)).w();
        if (!w.a()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, w.f43838b);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public final void k(String str, String str2, CallbackHandler callbackHandler, int i, JSONObject jSONObject) {
        d.b.h0.a.c0.c.g("OpenTextAreaAction", "sendAsyncCallback, arg0: " + i + ", arg1: " + jSONObject);
        if (TextUtils.isEmpty(str2)) {
            d.b.h0.a.a0.g.a.a("OpenTextAreaAction", "sendAsyncCallback with a empty callback");
        } else {
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        }
    }
}
