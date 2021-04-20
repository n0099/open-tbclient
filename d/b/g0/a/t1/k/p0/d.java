package d.b.g0.a.t1.k.p0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.b.g0.a.e0.l.f;
import d.b.g0.a.t1.k.a0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class d extends a0 {
    public d(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/navigateBack");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        int optInt;
        if (a0.f46680b) {
            Log.d("NavigateBackAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String uuid = UUID.randomUUID().toString();
        d.b.g0.a.j1.j.b(uuid);
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            optInt = 1;
        } else {
            try {
                optInt = new JSONObject(str).optInt("delta", 1);
            } catch (JSONException e2) {
                if (a0.f46680b) {
                    e2.printStackTrace();
                }
                d.b.g0.a.c0.c.b("navigateBack", "params parse fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
        }
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        if (W == null) {
            d.b.g0.a.c0.c.b("navigateBack", "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        int k = W.k();
        if (a0.f46680b) {
            Log.d("NavigateBackAction", "back delta: " + optInt);
        }
        if (k == 1) {
            d.b.g0.a.c0.c.b("NavigateBackAction", "navigateBack api can only work when slave's count greater than 1");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "navigateBack api can only work when slave's count greater than 1");
            return false;
        }
        if (optInt >= k) {
            optInt = k - 1;
        }
        if (a0.f46680b) {
            Log.d("NavigateBackAction", "real back delta: " + optInt);
        }
        d.b.g0.a.i2.f.a(W, context);
        f.b i = W.i("navigateBack");
        i.n(d.b.g0.a.e0.l.f.i, d.b.g0.a.e0.l.f.f44406h);
        i.h(optInt);
        i.a();
        d.b.g0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid).A(new UbcFlowEvent("na_push_page_end"));
        d.b.g0.a.j1.j.c(1, uuid);
        d.b.g0.a.j1.j.a(uuid);
        if (!(W.m() instanceof d.b.g0.a.e0.l.e)) {
            d.b.g0.a.c0.c.b("navigateBack", "top fragment error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        d.b.g0.a.e0.l.e eVar2 = (d.b.g0.a.e0.l.e) W.m();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.b(eVar2 != null ? eVar2.X2() : ""), 0));
        return true;
    }
}
