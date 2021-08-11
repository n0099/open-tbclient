package com.bytedance.sdk.openadsdk.preload.a.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes9.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static DateFormat a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i2, i3)) == null) {
            return new SimpleDateFormat(a(i2) + " " + b(i3), Locale.US);
        }
        return (DateFormat) invokeII.objValue;
    }

    public static String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 == 0 || i2 == 1) {
                return "h:mm:ss a z";
            }
            if (i2 != 2) {
                if (i2 == 3) {
                    return "h:mm a";
                }
                throw new IllegalArgumentException("Unknown DateFormat style: " + i2);
            }
            return "h:mm:ss a";
        }
        return (String) invokeI.objValue;
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            return "M/d/yy";
                        }
                        throw new IllegalArgumentException("Unknown DateFormat style: " + i2);
                    }
                    return "MMM d, yyyy";
                }
                return "MMMM d, yyyy";
            }
            return "EEEE, MMMM d, yyyy";
        }
        return (String) invokeI.objValue;
    }
}
