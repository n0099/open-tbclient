package com.repackage;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class t92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755335996, "Lcom/repackage/t92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755335996, "Lcom/repackage/t92;");
                return;
            }
        }
        a = jh1.a;
    }

    public static String a(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, str)) == null) {
            return "frame_type_" + i + "_" + str;
        }
        return (String) invokeIL.objValue;
    }

    public static long b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            long j = n93.a().getLong(a(i, "launch_time"), 0L);
            if (a) {
                Log.d("LaunchRecorder", "frame_type : " + i + " , launch time : " + j);
            }
            return j;
        }
        return invokeI.longValue;
    }

    public static void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i) == null) {
            String a2 = a(i, "launch_time");
            long currentTimeMillis = System.currentTimeMillis();
            n93.a().putLong(a2, currentTimeMillis);
            if (a) {
                Log.d("LaunchRecorder", "frame_type : " + i + " , launch time : " + currentTimeMillis);
            }
        }
    }
}
