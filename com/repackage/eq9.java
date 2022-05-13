package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes6.dex */
public class eq9 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            boolean z = a;
            if (z) {
                return z;
            }
            String[] split = System.getenv("PATH").split(":");
            int length = split.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    str = null;
                    break;
                }
                str = split[i] + "/su";
                if (new File(str).exists()) {
                    break;
                }
                i++;
            }
            boolean z2 = str != null;
            a = z2;
            return z2;
        }
        return invokeV.booleanValue;
    }
}
