package com.xiaomi.push;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.fp;
/* loaded from: classes8.dex */
public class fm {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56374695, "Lcom/xiaomi/push/fm;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56374695, "Lcom/xiaomi/push/fm;");
                return;
            }
        }
        a = Log.isLoggable("BCompressed", 3);
    }

    public static byte[] a(fl flVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, flVar, bArr)) == null) {
            try {
                byte[] a2 = fp.a.a(bArr);
                if (a) {
                    com.xiaomi.channel.commonutils.logger.b.m91a("BCompressed", "decompress " + bArr.length + " to " + a2.length + " for " + flVar);
                    if (flVar.f371a == 1) {
                        com.xiaomi.channel.commonutils.logger.b.m91a("BCompressed", "decompress not support upStream");
                    }
                }
                return a2;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m91a("BCompressed", "decompress error " + e);
                return bArr;
            }
        }
        return (byte[]) invokeLL.objValue;
    }
}
