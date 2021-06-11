package d.a.l0.a.c2.f.l0;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.kwad.sdk.core.config.item.TipsConfigItem;
import d.a.l0.a.c1.b;
import d.a.l0.a.c2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.g1.f;
import d.a.l0.a.h0.g.d;
import d.a.l0.a.h0.g.g;
import d.a.l0.a.v2.n0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {
    public a(e eVar) {
        super(eVar, "/swanAPI/getMenuButtonBoundingClientRect");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (a0.f44625b) {
            Log.d("GetMenuButtonBounding", "handle entity: " + unitedSchemeEntity.toString());
        }
        g W = f.V().W();
        if (W == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d m = W.m();
        if (m == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (eVar.m0()) {
            View r = b.i().r(m);
            if (r == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            unitedSchemeEntity.result = j(r);
            return true;
        } else {
            SwanAppActionBar H1 = m.H1();
            if (H1 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            View rightMenu = H1.getRightMenu();
            if (rightMenu == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            unitedSchemeEntity.result = j(rightMenu);
            return true;
        }
    }

    public final JSONObject j(View view) {
        JSONObject wrapCallbackParams;
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        int L = i2 != null ? i2.m0() : false ? 0 : (int) (n0.L(n0.u()) + 0.5f);
        int L2 = (int) (n0.L(view.getLeft()) + 0.5f);
        int L3 = (int) (n0.L(view.getRight()) + 0.5f);
        int L4 = ((int) (n0.L(view.getTop()) + 0.5f)) + L;
        int L5 = ((int) (n0.L(view.getBottom()) + 0.5f)) + L;
        int i3 = L3 - L2;
        int i4 = L5 - L4;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i3);
            jSONObject.put("height", i4);
            jSONObject.put(CustomDialogData.POS_LEFT, L2);
            jSONObject.put("right", L3);
            jSONObject.put("top", L4);
            jSONObject.put(TipsConfigItem.TipConfigData.BOTTOM, L5);
            wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
        } catch (JSONException e2) {
            if (a0.f44625b) {
                e2.printStackTrace();
            }
            wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
        }
        if (a0.f44625b) {
            Log.e("GetMenuButtonBounding", wrapCallbackParams.toString());
        }
        return wrapCallbackParams;
    }
}
