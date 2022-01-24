package com.cmic.sso.sdk.d;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes3.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis())) : (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a(new Date()) : (String) invokeV.objValue;
    }

    public static String a(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, date)) == null) ? a("yyyyMMdd", date) : (String) invokeL.objValue;
    }

    public static String a(String str, Date date) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, date)) == null) {
            if (date == null || TextUtils.isEmpty(str)) {
                return null;
            }
            return new SimpleDateFormat(str).format(date);
        }
        return (String) invokeLL.objValue;
    }
}
