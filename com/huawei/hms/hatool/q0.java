package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes10.dex */
public class q0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) ? System.currentTimeMillis() - g0.a(context, "Privacy_MY", "flashKeyTime", -1L) > com.heytap.mcssdk.constant.a.g : invokeL.booleanValue;
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            if (context == null) {
                return true;
            }
            if (Build.VERSION.SDK_INT < 23) {
                if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
                    y.f("hmsSdk", "not have read phone permission!");
                    return true;
                }
                return false;
            } else if (context.checkSelfPermission(str) != 0) {
                y.f("hmsSdk", "not have read phone permission!");
                return true;
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean a(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, context, str, i)) == null) {
            String str2 = g0.c(context, str) + ActivityChooserModel.HISTORY_FILE_EXTENSION;
            long length = new File(context.getFilesDir(), "../shared_prefs/" + str2).length();
            if (length > i) {
                y.c("hmsSdk", String.format("reach local file limited size - file len: %d limitedSize: %d", Long.valueOf(length), Integer.valueOf(i)));
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static boolean a(String str, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            try {
                return j - Long.parseLong(str) > j2;
            } catch (NumberFormatException unused) {
                y.f("hmsSdk", "isTimeExpired(): Data type conversion error : number format !");
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }
}
