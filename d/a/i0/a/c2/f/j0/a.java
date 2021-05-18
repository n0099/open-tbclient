package d.a.i0.a.c2.f.j0;

import android.content.Context;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.h0.g.g;
import d.a.i0.a.z1.b.c.a;
@Deprecated
/* loaded from: classes3.dex */
public class a extends a0 {
    public a(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/hideLoading");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (a0.f40775b) {
            Log.d("HideLoadingAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (!(context instanceof SwanAppActivity)) {
            d.a.i0.a.e0.d.b("hideLoading", "context not support");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not support");
            return false;
        }
        g swanAppFragmentManager = ((SwanAppActivity) context).getSwanAppFragmentManager();
        if (swanAppFragmentManager == null) {
            d.a.i0.a.e0.d.b("hideLoading", "none fragmentManger");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none fragmentManger");
            return false;
        }
        d.a.i0.a.h0.g.d m = swanAppFragmentManager.m();
        if (!(m instanceof a.InterfaceC0924a)) {
            d.a.i0.a.e0.d.b("hideLoading", "fragment not support");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment not support");
            return false;
        } else if (m.q() == null) {
            d.a.i0.a.e0.d.b("hideLoading", "fragment has detached");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment has detached");
            return false;
        } else {
            d.a.i0.a.z1.b.c.a floatLayer = ((a.InterfaceC0924a) m).getFloatLayer();
            if (floatLayer != null && (floatLayer.e() instanceof FrameLayout) && (((FrameLayout) floatLayer.e()).getChildAt(0) instanceof LoadingView)) {
                floatLayer.g();
            }
            d.a.i0.a.e0.d.g("hideLoading", "hide loading success");
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
