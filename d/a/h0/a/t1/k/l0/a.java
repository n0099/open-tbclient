package d.a.h0.a.t1.k.l0;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.kwad.sdk.core.config.item.TipsConfigItem;
import d.a.h0.a.e0.l.c;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.i2.h0;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {
    public a(j jVar) {
        super(jVar, "/swanAPI/getMenuButtonBoundingClientRect");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (a0.f44398b) {
            Log.d("GetMenuButtonBounding", "handle entity: " + unitedSchemeEntity.toString());
        }
        f W = d.a.h0.a.z0.f.V().W();
        if (W == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        c m = W.m();
        if (m == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (eVar.i0() && (m instanceof d.a.h0.a.e0.l.j)) {
            View U2 = ((d.a.h0.a.e0.l.j) m).U2();
            if (U2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            unitedSchemeEntity.result = j(U2);
            return true;
        } else {
            SwanAppActionBar C1 = m.C1();
            if (C1 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            View rightMenu = C1.getRightMenu();
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
        e h2 = e.h();
        int I = h2 != null ? h2.i0() : false ? 0 : (int) (h0.I(h0.s()) + 0.5f);
        int I2 = (int) (h0.I(view.getLeft()) + 0.5f);
        int I3 = (int) (h0.I(view.getRight()) + 0.5f);
        int I4 = ((int) (h0.I(view.getTop()) + 0.5f)) + I;
        int I5 = ((int) (h0.I(view.getBottom()) + 0.5f)) + I;
        int i2 = I3 - I2;
        int i3 = I5 - I4;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i2);
            jSONObject.put("height", i3);
            jSONObject.put(CustomDialogData.POS_LEFT, I2);
            jSONObject.put("right", I3);
            jSONObject.put("top", I4);
            jSONObject.put(TipsConfigItem.TipConfigData.BOTTOM, I5);
            wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
        } catch (JSONException e2) {
            if (a0.f44398b) {
                e2.printStackTrace();
            }
            wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
        }
        if (a0.f44398b) {
            Log.e("GetMenuButtonBounding", wrapCallbackParams.toString());
        }
        return wrapCallbackParams;
    }
}
