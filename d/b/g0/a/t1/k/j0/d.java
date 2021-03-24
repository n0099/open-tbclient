package d.b.g0.a.t1.k.j0;

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
import d.b.g0.a.e0.l.f;
import d.b.g0.a.i2.h0;
import d.b.g0.a.q1.b.c.a;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class d extends a0 {
    public d(j jVar) {
        super(jVar, "/swanAPI/showLoading");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        LoadingView loadingView;
        if (a0.f46287b) {
            Log.d("ShowLoadingAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (eVar != null && eVar.Z()) {
            if (a0.f46287b) {
                Log.d("ShowLoadingAction", "ShowLoadingAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        } else if (!(context instanceof SwanAppActivity)) {
            d.b.g0.a.c0.c.b("showLoading", "context not support");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not support");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.b.g0.a.c0.c.b("showLoading", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            d.b.g0.a.c0.c.g("showLoading", "handleShowLoading : joParams = \n" + optParamsAsJo);
            String optString = optParamsAsJo.optString("title");
            if (TextUtils.isEmpty(optString)) {
                d.b.g0.a.c0.c.b("showLoading", "none title");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            boolean optBoolean = optParamsAsJo.optBoolean("mask", false);
            f swanAppFragmentManager = ((SwanAppActivity) context).getSwanAppFragmentManager();
            if (swanAppFragmentManager == null) {
                d.b.g0.a.c0.c.b("showLoading", "none fragment");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none fragment");
                return false;
            }
            d.b.g0.a.e0.l.c m = swanAppFragmentManager.m();
            if (!(m instanceof a.InterfaceC0764a)) {
                d.b.g0.a.c0.c.b("showLoading", "fragment not support");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment not support");
                return false;
            }
            d.b.g0.a.q1.b.c.a floatLayer = ((a.InterfaceC0764a) m).getFloatLayer();
            if (floatLayer == null) {
                d.b.g0.a.c0.c.b("showLoading", "can't get floatLayer");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can't create floatLayer");
                return false;
            }
            View e2 = floatLayer.e();
            if (e2 instanceof LoadingView) {
                loadingView = (LoadingView) e2;
            } else {
                loadingView = new LoadingView(context);
                FrameLayout frameLayout = new FrameLayout(context);
                frameLayout.setPadding(0, 0, 0, h0.f(160.0f));
                frameLayout.addView(loadingView);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                floatLayer.k(frameLayout, layoutParams);
            }
            if (!TextUtils.isEmpty(optString)) {
                loadingView.setMsg(optString);
            }
            floatLayer.i(optBoolean);
            d.b.g0.a.c0.c.g("showLoading", "show loading success");
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
