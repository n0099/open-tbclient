package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class dl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, bArr) == null) || bArr.length < 2) {
            return;
        }
        bArr[0] = 99;
        bArr[1] = 100;
    }

    public static boolean a(Context context, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, Long.valueOf(j2)})) == null) {
            if (com.xiaomi.push.service.aq.a(context).a(hk.aY.a(), false)) {
                return (Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) && !ag.a(context, str, j2);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static byte[] a(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, bArr)) == null) {
            byte[] m243a = bj.m243a(str);
            try {
                a(m243a);
                return h.a(m243a, bArr);
            } catch (Exception unused) {
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] b(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, bArr)) == null) {
            byte[] m243a = bj.m243a(str);
            try {
                a(m243a);
                return h.b(m243a, bArr);
            } catch (Exception unused) {
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }
}
