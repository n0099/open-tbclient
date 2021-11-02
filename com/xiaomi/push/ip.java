package com.xiaomi.push;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.ix;
import com.xiaomi.push.jh;
/* loaded from: classes2.dex */
public class ip {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static short a(Context context, ib ibVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, ibVar)) == null) {
            return (short) (g.a(context, ibVar.f643b, false).a() + 0 + (ah.b(context) ? 4 : 0) + (ah.a(context) ? 8 : 0));
        }
        return invokeLL.shortValue;
    }

    public static <T extends iq<T, ?>> void a(T t, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, t, bArr) == null) {
            if (bArr == null) {
                throw new iv("the message byte is empty.");
            }
            new iu(new jh.a(true, true, bArr.length)).a(t, bArr);
        }
    }

    public static <T extends iq<T, ?>> byte[] a(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, t)) == null) {
            if (t == null) {
                return null;
            }
            try {
                return new iw(new ix.a()).a(t);
            } catch (iv e2) {
                com.xiaomi.channel.commonutils.logger.b.a("convertThriftObjectToBytes catch TException.", e2);
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
