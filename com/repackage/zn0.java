package com.repackage;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes7.dex */
public final class zn0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) ? (TextUtils.equals(str, "GET") || TextUtils.equals(str, "HEAD")) ? false : true : invokeL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? TextUtils.equals(str, "POST") || TextUtils.equals(str, "PATCH") || TextUtils.equals(str, HttpPut.METHOD_NAME) || TextUtils.equals(str, "PROPPATCH") || TextUtils.equals(str, "REPORT") : invokeL.booleanValue;
    }
}
