package com.huawei.hms.push;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, bundle, str)) == null) {
            try {
                byte[] byteArray = bundle.getByteArray(str);
                if (byteArray == null) {
                    return new byte[0];
                }
                return byteArray;
            } catch (Exception e) {
                HMSLog.i("BundleUtil", "getByteArray exception" + e.getMessage());
                return new byte[0];
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static String b(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bundle, str)) == null) {
            try {
                return bundle.getString(str);
            } catch (Exception e) {
                HMSLog.i("BundleUtil", "getString exception" + e.getMessage());
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String c(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bundle, str)) == null) {
            try {
                String string = bundle.getString(str);
                if (string == null) {
                    return "";
                }
                return string;
            } catch (Exception e) {
                HMSLog.i("BundleUtil", "getString exception" + e.getMessage());
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }
}
