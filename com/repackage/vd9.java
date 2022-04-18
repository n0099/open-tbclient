package com.repackage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class vd9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = true;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = true;
    public static long e = 300000;
    public static int f = 10;
    public static long g = 604800000;
    public static long h = 104857600;
    public static int i = 100;
    public static int j = 5;
    public static long k = 104857600;
    public static int l = 0;
    public static int m = 1;
    public static int n;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755234874, "Lcom/repackage/vd9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755234874, "Lcom/repackage/vd9;");
        }
    }
}
