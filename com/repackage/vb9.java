package com.repackage;

import android.graphics.Color;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.DecimalFormat;
/* loaded from: classes7.dex */
public class vb9 {
    public static /* synthetic */ Interceptable $ic;
    public static final DecimalFormat a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755236796, "Lcom/repackage/vb9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755236796, "Lcom/repackage/vb9;");
                return;
            }
        }
        a = new DecimalFormat("0.00");
    }

    public static String a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return a.format(((float) j) / 1048576.0f) + "M/" + a.format(((float) j2) / 1048576.0f) + "M";
        }
        return (String) invokeCommon.objValue;
    }

    public static int b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            try {
                String hexString = Integer.toHexString((int) (Float.parseFloat(str2) * 255.0f));
                return Color.parseColor("#" + hexString + str);
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return invokeLL.intValue;
    }
}
