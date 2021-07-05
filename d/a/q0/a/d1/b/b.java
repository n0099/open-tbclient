package d.a.q0.a.d1.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.common.Constants;
import d.a.q0.a.e0.d;
import d.a.q0.a.h0.u.g;
import d.a.q0.a.k;
import d.a.q0.a.k2.g.h;
import d.a.q0.a.s.a.f;
import d.a.q0.n.j.i.n;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47249a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1478849999, "Ld/a/q0/a/d1/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1478849999, "Ld/a/q0/a/d1/b/b;");
                return;
            }
        }
        f47249a = k.f49133a;
    }

    @NonNull
    public static String a(d.a.q0.a.h0.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (aVar != null) {
                try {
                    jSONObject.put("containerId", aVar.getContainerId());
                } catch (JSONException e2) {
                    if (!f47249a) {
                        e2.printStackTrace();
                    } else {
                        throw new RuntimeException(e2);
                    }
                }
            }
            jSONObject.put("scheme", SchemeConfig.getSchemeHead());
            String b2 = b(g.N().M());
            d.h("SwanAppNativeSwanUtils", "getEnvVariables extensionAvailable:" + d.a.q0.a.p0.h.c.a.r(b2));
            jSONObject.put("sdkExtension", b2);
            jSONObject.put("gameSdkExtension", b(d.a.q0.a.c1.b.i().t()));
            jSONObject.put("isDebugSdk", f47249a);
            String string = h.a().getString("ctsUrl", "");
            if (!TextUtils.isEmpty(string) && d.a.q0.a.u1.a.a.s()) {
                jSONObject.put("ctsJsAddress", new JSONObject(string));
            }
            String i2 = d.a.q0.a.c1.a.n().i();
            if (!TextUtils.isEmpty(i2)) {
                jSONObject.put("hostName", i2);
            }
            jSONObject.put(Constants.PARAM_PLATFORM, "android");
            JSONObject a2 = d.a.q0.a.m2.c.a.a();
            a2.put("swanswitch_common_sys_info_binding", true);
            a2.put("swanswitch_ab_sync_auth", true);
            jSONObject.put("abTestSwitch", a2);
            jSONObject.put("userDataPath", d.a.q0.a.r0.a.USER_DATA_PATH);
            jSONObject.put("preloadId", g.N().S());
            jSONObject.put("isBaiduSeries", f.f50510d.h());
            jSONObject.put("ttsExtractJSUrl", n.b().a());
            jSONObject.put("coreJSPath", g.N().U());
            String jSONObject2 = jSONObject.toString();
            return TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2;
        }
        return (String) invokeL.objValue;
    }

    public static String b(ExtensionCore extensionCore) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, extensionCore)) == null) ? (extensionCore == null || TextUtils.isEmpty(extensionCore.extensionCorePath)) ? "" : extensionCore.extensionCorePath : (String) invokeL.objValue;
    }
}
