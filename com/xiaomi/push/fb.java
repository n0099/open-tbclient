package com.xiaomi.push;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.fe;
/* loaded from: classes7.dex */
public class fb {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56375036, "Lcom/xiaomi/push/fb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56375036, "Lcom/xiaomi/push/fb;");
                return;
            }
        }
        a = Log.isLoggable("BCompressed", 3);
    }

    public static byte[] a(fa faVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, faVar, bArr)) == null) {
            try {
                byte[] a2 = fe.a.a(bArr);
                if (a) {
                    com.xiaomi.channel.commonutils.logger.b.m113a("BCompressed", "decompress " + bArr.length + " to " + a2.length + " for " + faVar);
                    if (faVar.f341a == 1) {
                        com.xiaomi.channel.commonutils.logger.b.m113a("BCompressed", "decompress not support upStream");
                    }
                }
                return a2;
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m113a("BCompressed", "decompress error " + e2);
                return bArr;
            }
        }
        return (byte[]) invokeLL.objValue;
    }
}
