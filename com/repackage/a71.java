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
/* loaded from: classes5.dex */
public final class a71 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            Context a = n81.a();
            Intrinsics.checkExpressionValueIsNotNull(a, "SdkRunTime.getAppContext()");
            PackageManager packageManager = a.getPackageManager();
            try {
                Context a2 = n81.a();
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
            Context a = n81.a();
            Intrinsics.checkExpressionValueIsNotNull(a, "SdkRunTime.getAppContext()");
            PackageManager packageManager = a.getPackageManager();
            try {
                Context a2 = n81.a();
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

    public static final void c(t61 t61Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, t61Var, str) == null) || t61Var == null) {
            return;
        }
        boolean z = false;
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            return;
        }
        String a = t61Var.a("Cookie");
        String str2 = "BDUSS=" + str;
        if ((a == null || StringsKt__StringsJVMKt.isBlank(a)) ? true : true) {
            t61Var.d("Cookie", str2);
            return;
        }
        t61Var.d("Cookie", a + "; " + str2);
    }

    public static final void d(t61 t61Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, t61Var) == null) || t61Var == null) {
            return;
        }
        t61Var.d("channel", "cashiersdk");
        t61Var.d("deviceType", "ANDROID");
        t61Var.d("osVersion", Build.VERSION.RELEASE);
        t61Var.d(CommandMessage.SDK_VERSION, "2.8.7.9");
        t61Var.d("appVersion", b());
        t61Var.d("sdkPgName", a());
        t61Var.d("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
    }

    public static final s61 e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            s61 s61Var = new s61();
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    s61Var.d(next, jSONObject.optString(next));
                }
            }
            return s61Var;
        }
        return (s61) invokeL.objValue;
    }
}
