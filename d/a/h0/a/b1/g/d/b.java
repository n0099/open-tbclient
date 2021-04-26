package d.a.h0.a.b1.g.d;

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
    public static final boolean f41549b = d.a.h0.a.k.f43101a;

    public b(String str) {
        super(str);
    }

    @Override // d.a.h0.a.b1.g.d.g
    public boolean a(d.a.h0.a.b1.g.a aVar, d.a.h0.a.b1.g.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        d.a.h0.a.c0.c.g("video", "fullscreen, video id:" + cVar.n + " slave id: " + cVar.f41093g);
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
            if (f41549b) {
                e2.printStackTrace();
                return -1;
            }
            return -1;
        }
    }

    public final void e(d.a.h0.a.b1.g.a aVar, boolean z, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params == null || params.isEmpty()) {
            return;
        }
        aVar.v(z, d(params));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
