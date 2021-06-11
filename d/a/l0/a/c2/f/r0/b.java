package d.a.l0.a.c2.f.r0;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.f.a0;
/* loaded from: classes3.dex */
public class b extends e {
    public b(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/removeWebView");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (a0.f44625b) {
            Log.d("RemoveWebViewAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        d h2 = d.h(unitedSchemeEntity);
        if (!h2.isValid()) {
            d.a.l0.a.e0.d.b("removeWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return true;
        }
        d.a.l0.a.p.e.b bVar = (d.a.l0.a.p.e.b) d.a.l0.a.g1.f.V().B(h2.f44522g);
        if (bVar == null) {
            d.a.l0.a.e0.d.b("removeWebView", "viewManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return true;
        } else if (!bVar.Y(h2)) {
            d.a.l0.a.e0.d.b("removeWebView", "remove webview widget fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return true;
        } else {
            d.a.l0.a.e0.d.g("removeWebView", "remove webview widget success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
