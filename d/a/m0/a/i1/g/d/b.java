package d.a.m0.a.i1.g.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends g {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46780b = d.a.m0.a.k.f46983a;

    public b(String str) {
        super(str);
    }

    @Override // d.a.m0.a.i1.g.d.g
    public boolean a(d.a.m0.a.i1.g.a aVar, d.a.m0.a.i1.g.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        d.a.m0.a.e0.d.g("video", "fullscreen, video id:" + cVar.n + " slave id: " + cVar.f44630g);
        e(aVar, cVar.w, unitedSchemeEntity, callbackHandler);
        return true;
    }

    public final int d(HashMap<String, String> hashMap) {
        String str = hashMap.get("params");
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return new JSONObject(str).optInt("direction", -1);
        } catch (JSONException e2) {
            if (f46780b) {
                e2.printStackTrace();
                return -1;
            }
            return -1;
        }
    }

    public final void e(d.a.m0.a.i1.g.a aVar, boolean z, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params == null || params.isEmpty()) {
            return;
        }
        aVar.t(z, d(params));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
