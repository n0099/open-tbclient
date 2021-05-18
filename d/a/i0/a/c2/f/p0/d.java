package d.a.i0.a.c2.f.p0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.h0.g.g;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class d extends a0 {
    public d(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/navigateBack");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        int optInt;
        if (a0.f40775b) {
            Log.d("NavigateBackAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String uuid = UUID.randomUUID().toString();
        d.a.i0.a.r1.i.b(uuid);
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            optInt = 1;
        } else {
            try {
                optInt = new JSONObject(str).optInt("delta", 1);
            } catch (JSONException e2) {
                if (a0.f40775b) {
                    e2.printStackTrace();
                }
                d.a.i0.a.e0.d.b("navigateBack", "params parse fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
        }
        d.a.i0.a.h0.g.g W = d.a.i0.a.g1.f.V().W();
        if (W == null) {
            d.a.i0.a.e0.d.b("navigateBack", "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        int k = W.k();
        if (a0.f40775b) {
            Log.d("NavigateBackAction", "back delta: " + optInt);
        }
        if (k == 1) {
            d.a.i0.a.e0.d.b("NavigateBackAction", "navigateBack api can only work when slave's count greater than 1");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "navigateBack api can only work when slave's count greater than 1");
            return false;
        }
        if (optInt >= k) {
            optInt = k - 1;
        }
        if (a0.f40775b) {
            Log.d("NavigateBackAction", "real back delta: " + optInt);
        }
        d.a.i0.a.h0.g.d j = W.j((k - optInt) - 1);
        d.a.i0.a.j2.h.f((j == null || j.K1() == null) ? "" : j.K1().g(), "1");
        d.a.i0.a.r1.i.c(1, uuid);
        d.a.i0.a.v2.g.a(W, context);
        g.b i2 = W.i("navigateBack");
        i2.n(d.a.i0.a.h0.g.g.f41904i, d.a.i0.a.h0.g.g.f41903h);
        i2.h(optInt);
        i2.a();
        d.a.i0.a.h0.g.f o = W.o();
        d.a.i0.a.l1.b Z2 = o == null ? null : o.Z2();
        d.a.i0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid).C(new UbcFlowEvent("na_push_page_end"));
        d.a.i0.a.r1.i.a(uuid, Z2);
        if (!(W.m() instanceof d.a.i0.a.h0.g.f)) {
            d.a.i0.a.e0.d.b("navigateBack", "top fragment error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        d.a.i0.a.h0.g.f fVar = (d.a.i0.a.h0.g.f) W.m();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.c(fVar != null ? fVar.g3() : ""), 0));
        return true;
    }
}
