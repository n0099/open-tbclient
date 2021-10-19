package com.xiaomi.push;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public class af {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f77693a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56379717, "Lcom/xiaomi/push/af;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56379717, "Lcom/xiaomi/push/af;");
                return;
            }
        }
        f77693a = "0123456789ABCDEF".toCharArray();
    }

    public static String a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, bArr, i2, i3)) == null) {
            StringBuilder sb = new StringBuilder(i3 * 2);
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = bArr[i2 + i4] & 255;
                sb.append(f77693a[i5 >> 4]);
                sb.append(f77693a[i5 & 15]);
            }
            return sb.toString();
        }
        return (String) invokeLII.objValue;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? ae.f109a : invokeL.booleanValue;
    }
}
