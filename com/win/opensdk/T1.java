package com.win.opensdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes10.dex */
public class T1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f76724a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            boolean z = f76724a;
            if (z) {
                return z;
            }
            String[] split = System.getenv("PATH").split(":");
            int length = split.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    str = null;
                    break;
                }
                str = split[i2] + "/su";
                if (new File(str).exists()) {
                    break;
                }
                i2++;
            }
            boolean z2 = str != null;
            f76724a = z2;
            return z2;
        }
        return invokeV.booleanValue;
    }
}
