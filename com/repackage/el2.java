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
/* loaded from: classes6.dex */
public class el2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755733850, "Lcom/repackage/el2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755733850, "Lcom/repackage/el2;");
                return;
            }
        }
        a = eh1.a;
    }

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public static String a(sz1 sz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sz1Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (sz1Var != null) {
                try {
                    jSONObject.put("containerId", sz1Var.getContainerId());
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
            String b = b(o72.U().T());
            ux1.k("SwanAppNativeSwanUtils", "getEnvVariables extensionAvailable:" + hc2.r(b));
            jSONObject.put("sdkExtension", b);
            jSONObject.put("gameSdkExtension", b(ck2.i().t()));
            jSONObject.put("isDebugSdk", a);
            if ((sz1Var instanceof NgWebView) && ((NgWebView) sz1Var).isSwanWebMode()) {
                jSONObject.put("ctsEnabled", i93.a().getInt("aiapps_web_mode_cts_use_key", 0));
            }
            String string = i93.a().getString("ctsUrl", "");
            if (!TextUtils.isEmpty(string) && tw2.s()) {
                jSONObject.put("ctsJsAddress", new JSONObject(string));
            }
            String i = bk2.o().i();
            if (!TextUtils.isEmpty(i)) {
                jSONObject.put("hostName", i);
            }
            jSONObject.put(Constants.PARAM_PLATFORM, "android");
            JSONObject a2 = aa3.a();
            a2.put("swanswitch_common_sys_info_binding", true);
            a2.put("swanswitch_ab_sync_auth", true);
            jSONObject.put("abTestSwitch", a2);
            jSONObject.put("userDataPath", rc2.USER_DATA_PATH);
            jSONObject.put("preloadId", o72.U().a0());
            jSONObject.put("isBaiduSeries", SwanAppAllianceLoginHelper.d.h());
            jSONObject.put("ttsExtractJSUrl", bd4.b().a());
            jSONObject.put("coreJSPath", o72.U().c0());
            if (eq1.d()) {
                jSONObject.put("pendingList", new JSONArray((Collection) ps1.d()));
            }
            jSONObject.put("swanNativeVersion", fh1.a());
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
