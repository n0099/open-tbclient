package d.b.g0.a.t1.k.j0;

import android.content.Context;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import d.b.g0.a.e0.l.f;
import d.b.g0.a.q1.b.c.a;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
@Deprecated
/* loaded from: classes3.dex */
public class a extends a0 {
    public a(j jVar) {
        super(jVar, "/swanAPI/hideLoading");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (a0.f46680b) {
            Log.d("HideLoadingAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (!(context instanceof SwanAppActivity)) {
            d.b.g0.a.c0.c.b("hideLoading", "context not support");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not support");
            return false;
        }
        f swanAppFragmentManager = ((SwanAppActivity) context).getSwanAppFragmentManager();
        if (swanAppFragmentManager == null) {
            d.b.g0.a.c0.c.b("hideLoading", "none fragmentManger");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none fragmentManger");
            return false;
        }
        d.b.g0.a.e0.l.c m = swanAppFragmentManager.m();
        if (!(m instanceof a.InterfaceC0777a)) {
            d.b.g0.a.c0.c.b("hideLoading", "fragment not support");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment not support");
            return false;
        } else if (m.l() == null) {
            d.b.g0.a.c0.c.b("hideLoading", "fragment has detached");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment has detached");
            return false;
        } else {
            d.b.g0.a.q1.b.c.a floatLayer = ((a.InterfaceC0777a) m).getFloatLayer();
            if (floatLayer != null && (floatLayer.e() instanceof FrameLayout) && (((FrameLayout) floatLayer.e()).getChildAt(0) instanceof LoadingView)) {
                floatLayer.g();
            }
            d.b.g0.a.c0.c.g("hideLoading", "hide loading success");
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
