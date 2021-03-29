package d.b.g0.a.x0.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.tencent.connect.common.Constants;
import d.b.g0.a.a2.g.h;
import d.b.g0.a.e0.w.d;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46953a = k.f45051a;

    @NonNull
    public static String a(d.b.g0.a.e0.k.a aVar) {
        JSONObject jSONObject = new JSONObject();
        if (aVar != null) {
            try {
                jSONObject.put("containerId", aVar.getContainerId());
            } catch (JSONException e2) {
                if (!f46953a) {
                    e2.printStackTrace();
                } else {
                    throw new RuntimeException(e2);
                }
            }
        }
        jSONObject.put("scheme", SchemeConfig.getSchemeHead());
        jSONObject.put("sdkExtension", b(d.L().K()));
        jSONObject.put("gameSdkExtension", b(d.b.g0.g.m.a.m().k()));
        jSONObject.put("isDebugSdk", f46953a);
        String string = h.a().getString("ctsUrl", "");
        if (!TextUtils.isEmpty(string) && d.b.g0.a.m1.a.a.q()) {
            jSONObject.put("ctsJsAddress", new JSONObject(string));
        }
        String t = d.b.g0.a.w0.a.l().t();
        if (!TextUtils.isEmpty(t)) {
            jSONObject.put("hostName", t);
        }
        jSONObject.put(Constants.PARAM_PLATFORM, "android");
        JSONObject a2 = d.b.g0.a.b2.c.a.a();
        a2.put("swanswitch_common_sys_info_binding", true);
        a2.put("swanswitch_ab_sync_auth", true);
        jSONObject.put("abTestSwitch", a2);
        jSONObject.put("userDataPath", d.b.g0.g.l.a.USER_DATA_PATH);
        jSONObject.put("preloadId", d.L().Q());
        String jSONObject2 = jSONObject.toString();
        return TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2;
    }

    public static String b(ExtensionCore extensionCore) {
        return (extensionCore == null || TextUtils.isEmpty(extensionCore.extensionCorePath)) ? "" : extensionCore.extensionCorePath;
    }
}
