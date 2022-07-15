package com.repackage;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.common.Constants;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rk2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755347528, "Lcom/repackage/rk2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755347528, "Lcom/repackage/rk2;");
                return;
            }
        }
        a = rg1.a;
    }

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public static String a(fz1 fz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fz1Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (fz1Var != null) {
                try {
                    jSONObject.put("containerId", fz1Var.getContainerId());
                    jSONObject.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, BdZeusUtil.isWebkitLoaded());
                } catch (JSONException e) {
                    if (!a) {
                        e.printStackTrace();
                    } else {
                        throw new RuntimeException(e);
                    }
                }
            }
            jSONObject.put("scheme", SchemeConfig.getSchemeHead());
            String b = b(b72.U().T());
            hx1.k("SwanAppNativeSwanUtils", "getEnvVariables extensionAvailable:" + ub2.r(b));
            jSONObject.put("sdkExtension", b);
            jSONObject.put("gameSdkExtension", b(pj2.i().s()));
            jSONObject.put("isDebugSdk", a);
            if ((fz1Var instanceof NgWebView) && ((NgWebView) fz1Var).isSwanWebMode()) {
                jSONObject.put("ctsEnabled", v83.a().getInt("aiapps_web_mode_cts_use_key", 0));
            }
            String string = v83.a().getString("ctsUrl", "");
            if (!TextUtils.isEmpty(string) && gw2.s()) {
                jSONObject.put("ctsJsAddress", new JSONObject(string));
            }
            String i = oj2.o().i();
            if (!TextUtils.isEmpty(i)) {
                jSONObject.put("hostName", i);
            }
            jSONObject.put(Constants.PARAM_PLATFORM, "android");
            JSONObject a2 = n93.a();
            a2.put("swanswitch_common_sys_info_binding", true);
            a2.put("swanswitch_ab_sync_auth", true);
            jSONObject.put("abTestSwitch", a2);
            jSONObject.put("userDataPath", ec2.USER_DATA_PATH);
            jSONObject.put("preloadId", b72.U().a0());
            jSONObject.put("isBaiduSeries", SwanAppAllianceLoginHelper.d.h());
            jSONObject.put("ttsExtractJSUrl", oc4.b().a());
            jSONObject.put("coreJSPath", b72.U().c0());
            if (rp1.d()) {
                jSONObject.put("pendingList", new JSONArray((Collection) cs1.d()));
            }
            jSONObject.put("swanNativeVersion", sg1.a());
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
