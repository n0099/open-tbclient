package com.kwad.sdk.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes2.dex */
public class aw {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65536, null, j2)) == null) {
            if (j2 <= 0 || j2 >= 86400000) {
                return "00:00";
            }
            try {
                long j3 = j2 / 1000;
                long j4 = j3 % 60;
                long j5 = (j3 / 60) % 60;
                long j6 = j3 / 3600;
                Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
                return j6 > 0 ? formatter.format("%d:%02d:%02d", Long.valueOf(j6), Long.valueOf(j5), Long.valueOf(j4)).toString() : formatter.format("%02d:%02d", Long.valueOf(j5), Long.valueOf(j4)).toString();
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return "";
            }
        }
        return (String) invokeJ.objValue;
    }
}
