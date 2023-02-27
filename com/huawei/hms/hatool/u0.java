package com.huawei.hms.hatool;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes8.dex */
public abstract class u0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65536, null, str, j)) == null) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
                return simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(j))).getTime();
            } catch (ParseException unused) {
                y.f("hmsSdk/stringUtil", "getMillisOfDate(): Time conversion Exception !");
                return 0L;
            }
        }
        return invokeLJ.longValue;
    }

    public static Pair<String, String> a(String str) {
        InterceptResult invokeL;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (HianalyticsHelper.DEAULT_HA_SERVICE_TAG.equals(str)) {
                return new Pair<>(str, "");
            }
            String[] split = str.split("-");
            if (split.length > 2) {
                str3 = split[split.length - 1];
                str2 = str.substring(0, (str.length() - str3.length()) - 1);
            } else {
                str2 = split[0];
                str3 = split[1];
            }
            return new Pair<>(str2, str3);
        }
        return (Pair) invokeL.objValue;
    }

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i != 0 ? i != 1 ? i != 2 ? i != 3 ? "alltype" : "diffprivacy" : "preins" : "maint" : "oper" : (String) invokeI.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (HianalyticsHelper.DEAULT_HA_SERVICE_TAG.equals(str)) {
                return str;
            }
            return str + "-" + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3)) == null) {
            if (HianalyticsHelper.DEAULT_HA_SERVICE_TAG.equals(str)) {
                return "_default_config_tag#" + str3;
            }
            return str + "-" + str2 + "#" + str3;
        }
        return (String) invokeLLL.objValue;
    }

    public static Set<String> a(Set<String> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, set)) == null) {
            if (set == null || set.size() == 0) {
                return new HashSet();
            }
            HashSet hashSet = new HashSet();
            for (String str : set) {
                if (HianalyticsHelper.DEAULT_HA_SERVICE_TAG.equals(str)) {
                    hashSet.add(HianalyticsHelper.DEAULT_HA_SERVICE_TAG);
                } else {
                    String str2 = str + "-oper";
                    String str3 = str + "-maint";
                    hashSet.add(str2);
                    hashSet.add(str3);
                    hashSet.add(str + "-diffprivacy");
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }
}
