package com.kwad.sdk.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Locale;
/* loaded from: classes2.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            String[] strArr = {" B", " KB", " MB", " GB", " TB", " PB", " EB", " ZB", " YB"};
            if (j2 <= 1) {
                return j2 + "B";
            }
            double d2 = j2;
            double d3 = 1024;
            int log = (int) (Math.log(d2) / Math.log(d3));
            double pow = j2 > 1024 ? d2 / Math.pow(d3, log) : d2 / d3;
            return z ? String.format(Locale.ENGLISH, "%.1f%s", Double.valueOf(pow), strArr[log]) : String.format(Locale.ENGLISH, "%.1f", Double.valueOf(pow));
        }
        return (String) invokeCommon.objValue;
    }
}
