package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
@SuppressLint({"ApplySharedPref"})
/* loaded from: classes10.dex */
public class g0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(Context context, String str, String str2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, str, str2, Long.valueOf(j)})) == null) {
            if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                y.f("hmsSdk", "context is null or spName empty or spkey is empty");
                return j;
            }
            SharedPreferences b = b(context, str);
            return b != null ? b.getLong(str2, j) : j;
        }
        return invokeCommon.longValue;
    }

    public static String a(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, context, str, str2, str3)) == null) {
            if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                y.f("hmsSdk", "context is null or spName empty or spkey is empty");
                return str3;
            }
            SharedPreferences b = b(context, str);
            return b != null ? b.getString(str2, str3) : str3;
        }
        return (String) invokeLLLL.objValue;
    }

    public static Map<String, ?> a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) ? b(context, str).getAll() : (Map) invokeLL.objValue;
    }

    public static void a(Context context, String str, String... strArr) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, context, str, strArr) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                str2 = "clearData(): parameter error.context,spname";
            } else if (strArr != null) {
                SharedPreferences b = b(context, str);
                if (b != null) {
                    SharedPreferences.Editor edit = b.edit();
                    if (strArr.length == 0) {
                        edit.clear();
                        edit.commit();
                        return;
                    }
                    for (String str3 : strArr) {
                        if (b.contains(str3)) {
                            edit.remove(str3);
                            edit.commit();
                        }
                    }
                    return;
                }
                return;
            } else {
                str2 = "clearData(): No data need to be deleted,keys is null";
            }
            y.f("hmsSdk", str2);
        }
    }

    public static SharedPreferences b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) ? context.getSharedPreferences(c(context, str), 0) : (SharedPreferences) invokeLL.objValue;
    }

    public static void b(Context context, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, str, str2, Long.valueOf(j)}) == null) {
            if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                y.f("hmsSdk", "context is null or spName empty or spkey is empty");
                return;
            }
            SharedPreferences b = b(context, str);
            if (b != null) {
                SharedPreferences.Editor edit = b.edit();
                edit.putLong(str2, j);
                edit.commit();
            }
        }
    }

    public static void b(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, null, context, str, str2, str3) == null) {
            if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                y.e("hmsSdk", "context is null or spName empty or spkey is empty");
                return;
            }
            SharedPreferences b = b(context, str);
            if (b != null) {
                SharedPreferences.Editor edit = b.edit();
                edit.putString(str2, str3);
                edit.commit();
            }
        }
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            String packageName = context.getPackageName();
            String n = c.n("_hms_config_tag", "oper");
            if (TextUtils.isEmpty(n)) {
                return "hms_" + str + "_" + packageName;
            }
            return "hms_" + str + "_" + packageName + "_" + n;
        }
        return (String) invokeLL.objValue;
    }
}
