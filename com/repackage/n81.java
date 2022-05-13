package com.repackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class n81 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            Context a = aa1.a();
            Intrinsics.checkExpressionValueIsNotNull(a, "SdkRunTime.getAppContext()");
            PackageManager packageManager = a.getPackageManager();
            try {
                Context a2 = aa1.a();
                Intrinsics.checkExpressionValueIsNotNull(a2, "SdkRunTime.getAppContext()");
                String str = packageManager.getPackageInfo(a2.getPackageName(), 0).packageName;
                Intrinsics.checkExpressionValueIsNotNull(str, "packageInfo.packageName");
                return str;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            Context a = aa1.a();
            Intrinsics.checkExpressionValueIsNotNull(a, "SdkRunTime.getAppContext()");
            PackageManager packageManager = a.getPackageManager();
            try {
                Context a2 = aa1.a();
                Intrinsics.checkExpressionValueIsNotNull(a2, "SdkRunTime.getAppContext()");
                String str = packageManager.getPackageInfo(a2.getPackageName(), 0).versionName;
                Intrinsics.checkExpressionValueIsNotNull(str, "packageInfo.versionName");
                return str;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static final void c(g81 g81Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, g81Var, str) == null) || g81Var == null) {
            return;
        }
        boolean z = false;
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            return;
        }
        String a = g81Var.a("Cookie");
        String str2 = "BDUSS=" + str;
        if ((a == null || StringsKt__StringsJVMKt.isBlank(a)) ? true : true) {
            g81Var.d("Cookie", str2);
            return;
        }
        g81Var.d("Cookie", a + "; " + str2);
    }

    public static final void d(g81 g81Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, g81Var) == null) || g81Var == null) {
            return;
        }
        g81Var.d("channel", "cashiersdk");
        g81Var.d("deviceType", "ANDROID");
        g81Var.d("osVersion", Build.VERSION.RELEASE);
        g81Var.d(CommandMessage.SDK_VERSION, "2.8.7.9");
        g81Var.d("appVersion", b());
        g81Var.d("sdkPgName", a());
        g81Var.d("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
    }

    public static final f81 e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            f81 f81Var = new f81();
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    f81Var.d(next, jSONObject.optString(next));
                }
            }
            return f81Var;
        }
        return (f81) invokeL.objValue;
    }
}
