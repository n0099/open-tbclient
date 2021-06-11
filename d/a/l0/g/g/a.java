package d.a.l0.g.g;

import android.app.Application;
import android.net.Uri;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import d.a.l0.a.a2.e;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.f1.e.c;
import d.a.l0.a.u.h.b;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a extends d.a.l0.g.f.a {
    public a() {
        super("navigateToSwanGame");
    }

    @Override // d.a.l0.g.f.a
    public b a(JSONObject paramsJson, d.a.l0.a.u0.b callback) {
        b.a L;
        String I;
        b.a L2;
        Intrinsics.checkNotNullParameter(paramsJson, "paramsJson");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Application b2 = d.a.l0.a.c1.a.b();
        if (b2 == null) {
            callback.onFail(202, "params may be error");
            return null;
        }
        String optString = paramsJson.optString("appKey");
        boolean z = false;
        if (optString == null || optString.length() == 0) {
            callback.onFail(202, "params may be error");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        e Q = e.Q();
        String str = "";
        jSONObject.put("pre_source", (Q == null || (L2 = Q.L()) == null || (r8 = L2.T()) == null) ? "" : "");
        e Q2 = e.Q();
        if (Q2 != null && (L = Q2.L()) != null && (I = L.I()) != null) {
            str = I;
        }
        jSONObject.put("pre_appid", str);
        paramsJson.put(UBCCloudControlProcessor.UBC_KEY, jSONObject);
        String b1 = c.b1(optString, 1, paramsJson);
        Uri parse = (b1 == null || b1.length() == 0) ? true : true ? null : Uri.parse(b1);
        if (parse == null) {
            callback.onFail(202, "params may be error");
            return null;
        }
        if (SchemeRouter.invokeScheme(b2, parse, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
            callback.a(null);
        } else {
            callback.onFail(202, "params may be error");
        }
        return null;
    }
}
