package d.a.l0.a.r;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends c {
    public e(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/cloudGetUrl");
    }

    @Override // d.a.l0.a.r.c, d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        return super.d(context, unitedSchemeEntity, callbackHandler, eVar);
    }

    @Override // d.a.l0.a.r.c
    public void j(Response response, CallbackHandler callbackHandler, String str) {
        String header = response.header("Content-Type", "");
        if (header != null && header.contains("application/json")) {
            try {
                JSONObject m = a.m(response);
                if (m == null) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "response body is null").toString());
                    return;
                } else if (!TextUtils.isEmpty(m.optString("DownloadUrl"))) {
                    m(callbackHandler, str, m);
                    return;
                } else {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "downloadUrl is empty").toString());
                    return;
                }
            } catch (Exception e2) {
                k(callbackHandler, str, 1001, e2.getMessage());
                if (c.f44247c) {
                    e2.printStackTrace();
                    return;
                }
                return;
            }
        }
        k(callbackHandler, str, 1001, "content type error.");
    }
}
