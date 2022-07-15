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
/* loaded from: classes7.dex */
public final class z71 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            Context a = m91.a();
            Intrinsics.checkExpressionValueIsNotNull(a, "SdkRunTime.getAppContext()");
            PackageManager packageManager = a.getPackageManager();
            try {
                Context a2 = m91.a();
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
            Context a = m91.a();
            Intrinsics.checkExpressionValueIsNotNull(a, "SdkRunTime.getAppContext()");
            PackageManager packageManager = a.getPackageManager();
            try {
                Context a2 = m91.a();
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

    public static final void c(s71 s71Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, s71Var, str) == null) || s71Var == null) {
            return;
        }
        boolean z = false;
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            return;
        }
        String a = s71Var.a("Cookie");
        String str2 = "BDUSS=" + str;
        if ((a == null || StringsKt__StringsJVMKt.isBlank(a)) ? true : true) {
            s71Var.d("Cookie", str2);
            return;
        }
        s71Var.d("Cookie", a + "; " + str2);
    }

    public static final void d(s71 s71Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, s71Var) == null) || s71Var == null) {
            return;
        }
        s71Var.d("channel", "cashiersdk");
        s71Var.d("deviceType", "ANDROID");
        s71Var.d("osVersion", Build.VERSION.RELEASE);
        s71Var.d(CommandMessage.SDK_VERSION, "2.8.7.9");
        s71Var.d("appVersion", b());
        s71Var.d("sdkPgName", a());
        s71Var.d("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
    }

    public static final r71 e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            r71 r71Var = new r71();
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    r71Var.d(next, jSONObject.optString(next));
                }
            }
            return r71Var;
        }
        return (r71) invokeL.objValue;
    }
}
