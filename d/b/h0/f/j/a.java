package d.b.h0.f.j;

import android.app.Application;
import android.net.Uri;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import d.b.h0.a.r1.e;
import d.b.h0.a.t.e.b;
import d.b.h0.a.y0.e.b;
import d.b.h0.a.y0.e.c;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a extends d.b.h0.f.i.a {
    public a() {
        super("navigateToSwanGame");
    }

    @Override // d.b.h0.f.i.a
    public b a(JSONObject jSONObject, d.b.h0.a.p0.b bVar) {
        b.a J;
        String H;
        b.a J2;
        Application c2 = d.b.h0.a.w0.a.c();
        if (c2 == null) {
            bVar.onFail(202, "params may be error");
            return null;
        }
        String optString = jSONObject.optString("appKey");
        boolean z = false;
        if (optString == null || optString.length() == 0) {
            bVar.onFail(202, "params may be error");
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        e O = e.O();
        String str = "";
        jSONObject2.put("pre_source", (O == null || (J2 = O.J()) == null || (r8 = J2.S()) == null) ? "" : "");
        e O2 = e.O();
        if (O2 != null && (J = O2.J()) != null && (H = J.H()) != null) {
            str = H;
        }
        jSONObject2.put("pre_appid", str);
        jSONObject.put(UBCCloudControlProcessor.UBC_KEY, jSONObject2);
        String U0 = c.U0(optString, 1, jSONObject);
        Uri parse = (U0 == null || U0.length() == 0) ? true : true ? null : Uri.parse(U0);
        if (parse == null) {
            bVar.onFail(202, "params may be error");
            return null;
        }
        if (SchemeRouter.invokeScheme(c2, parse, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
            bVar.a(null);
        } else {
            bVar.onFail(202, "params may be error");
        }
        return null;
    }
}
