package d.a.m0.a.c2.f.j0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.h0.g.g;
import d.a.m0.a.v2.n0;
import d.a.m0.a.z1.b.c.a;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class d extends a0 {
    public d(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/showLoading");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        LoadingView loadingView;
        if (a0.f44733b) {
            Log.d("ShowLoadingAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (eVar != null && eVar.d0()) {
            if (a0.f44733b) {
                Log.d("ShowLoadingAction", "ShowLoadingAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        } else if (!(context instanceof SwanAppActivity)) {
            d.a.m0.a.e0.d.b("showLoading", "context not support");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not support");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.a.m0.a.e0.d.b("showLoading", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            d.a.m0.a.e0.d.g("showLoading", "handleShowLoading : joParams = \n" + optParamsAsJo);
            String optString = optParamsAsJo.optString("title");
            if (TextUtils.isEmpty(optString)) {
                d.a.m0.a.e0.d.b("showLoading", "none title");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            boolean optBoolean = optParamsAsJo.optBoolean("mask", false);
            g swanAppFragmentManager = ((SwanAppActivity) context).getSwanAppFragmentManager();
            if (swanAppFragmentManager == null) {
                d.a.m0.a.e0.d.b("showLoading", "none fragment");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none fragment");
                return false;
            }
            d.a.m0.a.h0.g.d m = swanAppFragmentManager.m();
            if (!(m instanceof a.InterfaceC0994a)) {
                d.a.m0.a.e0.d.b("showLoading", "fragment not support");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment not support");
                return false;
            }
            d.a.m0.a.z1.b.c.a floatLayer = ((a.InterfaceC0994a) m).getFloatLayer();
            if (floatLayer == null) {
                d.a.m0.a.e0.d.b("showLoading", "can't get floatLayer");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can't create floatLayer");
                return false;
            }
            View e2 = floatLayer.e();
            if (e2 instanceof LoadingView) {
                loadingView = (LoadingView) e2;
            } else {
                loadingView = new LoadingView(context);
                FrameLayout frameLayout = new FrameLayout(context);
                frameLayout.setPadding(0, 0, 0, n0.g(160.0f));
                frameLayout.addView(loadingView);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                floatLayer.l(frameLayout, layoutParams);
            }
            if (!TextUtils.isEmpty(optString)) {
                loadingView.setMsg(optString);
            }
            floatLayer.i(optBoolean);
            d.a.m0.a.e0.d.g("showLoading", "show loading success");
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
