package d.a.l0.a.d1.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.tencent.connect.common.Constants;
import d.a.l0.a.e0.d;
import d.a.l0.a.h0.u.g;
import d.a.l0.a.k;
import d.a.l0.a.k2.g.h;
import d.a.l0.a.s.a.f;
import d.a.l0.n.j.i.n;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44991a = k.f46875a;

    @NonNull
    public static String a(d.a.l0.a.h0.f.a aVar) {
        JSONObject jSONObject = new JSONObject();
        if (aVar != null) {
            try {
                jSONObject.put("containerId", aVar.getContainerId());
            } catch (JSONException e2) {
                if (!f44991a) {
                    e2.printStackTrace();
                } else {
                    throw new RuntimeException(e2);
                }
            }
        }
        jSONObject.put("scheme", SchemeConfig.getSchemeHead());
        String b2 = b(g.N().M());
        d.h("SwanAppNativeSwanUtils", "getEnvVariables extensionAvailable:" + d.a.l0.a.p0.h.c.a.r(b2));
        jSONObject.put("sdkExtension", b2);
        jSONObject.put("gameSdkExtension", b(d.a.l0.a.c1.b.i().t()));
        jSONObject.put("isDebugSdk", f44991a);
        String string = h.a().getString("ctsUrl", "");
        if (!TextUtils.isEmpty(string) && d.a.l0.a.u1.a.a.s()) {
            jSONObject.put("ctsJsAddress", new JSONObject(string));
        }
        String i2 = d.a.l0.a.c1.a.n().i();
        if (!TextUtils.isEmpty(i2)) {
            jSONObject.put("hostName", i2);
        }
        jSONObject.put(Constants.PARAM_PLATFORM, "android");
        JSONObject a2 = d.a.l0.a.m2.c.a.a();
        a2.put("swanswitch_common_sys_info_binding", true);
        a2.put("swanswitch_ab_sync_auth", true);
        jSONObject.put("abTestSwitch", a2);
        jSONObject.put("userDataPath", d.a.l0.a.r0.a.USER_DATA_PATH);
        jSONObject.put("preloadId", g.N().S());
        jSONObject.put("isBaiduSeries", f.f48256d.h());
        jSONObject.put("ttsExtractJSUrl", n.b().a());
        jSONObject.put("coreJSPath", g.N().U());
        String jSONObject2 = jSONObject.toString();
        return TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2;
    }

    public static String b(ExtensionCore extensionCore) {
        return (extensionCore == null || TextUtils.isEmpty(extensionCore.extensionCorePath)) ? "" : extensionCore.extensionCorePath;
    }
}
