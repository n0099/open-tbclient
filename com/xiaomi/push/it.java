package com.xiaomi.push;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.jb;
import com.xiaomi.push.jl;
/* loaded from: classes8.dex */
public class it {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static short a(Context context, Cif cif) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, cif)) == null) ? a(context, cif.f633b) : invokeLL.shortValue;
    }

    public static short a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            return (short) (h.a(context, str, false).a() + 0 + (ak.b(context) ? 4 : 0) + (ak.a(context) ? 8 : 0) + (com.xiaomi.push.service.ax.m623a(context) ? 16 : 0));
        }
        return invokeLL.shortValue;
    }

    public static void a(iu iuVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, iuVar, bArr) == null) {
            if (bArr == null) {
                throw new iz("the message byte is empty.");
            }
            new iy(new jl.a(true, true, bArr.length)).a(iuVar, bArr);
        }
    }

    public static byte[] a(iu iuVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iuVar)) == null) {
            if (iuVar == null) {
                return null;
            }
            try {
                return new ja(new jb.a()).a(iuVar);
            } catch (iz e) {
                com.xiaomi.channel.commonutils.logger.b.a("convertThriftObjectToBytes catch TException.", e);
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
