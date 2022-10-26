package com.win.opensdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes8.dex */
public class Y1 {
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
            boolean z2 = false;
            int i = 0;
            while (true) {
                if (i < length) {
                    str = split[i] + "/su";
                    if (new File(str).exists()) {
                        break;
                    }
                    i++;
                } else {
                    str = null;
                    break;
                }
            }
            if (str != null) {
                z2 = true;
            }
            a = z2;
            return z2;
        }
        return invokeV.booleanValue;
    }
}
