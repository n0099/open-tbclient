package d.b.h0.a.t1.k.r0;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
/* loaded from: classes3.dex */
public class b extends e {
    public b(j jVar) {
        super(jVar, "/swanAPI/removeWebView");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (a0.f47009b) {
            Log.d("RemoveWebViewAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        d h2 = d.h(unitedSchemeEntity);
        if (!h2.isValid()) {
            d.b.h0.a.c0.c.b("removeWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return true;
        }
        d.b.h0.a.p.d.b bVar = (d.b.h0.a.p.d.b) d.b.h0.a.z0.f.V().j(h2.f43835g);
        if (bVar == null) {
            d.b.h0.a.c0.c.b("removeWebView", "viewManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return true;
        } else if (!bVar.M(h2)) {
            d.b.h0.a.c0.c.b("removeWebView", "remove webview widget fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return true;
        } else {
            d.b.h0.a.c0.c.g("removeWebView", "remove webview widget success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
