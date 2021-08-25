package com.kwad.sdk.crash.utils;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.SimpleDateFormat;
/* loaded from: classes10.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static SimpleDateFormat f72542a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(639243314, "Lcom/kwad/sdk/crash/utils/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(639243314, "Lcom/kwad/sdk/crash/utils/j;");
                return;
            }
        }
        f72542a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static String a(long j2) {
        InterceptResult invokeJ;
        String valueOf;
        String valueOf2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j2)) == null) {
            long j3 = j2 / 60000;
            long j4 = (j2 - (60000 * j3)) / 1000;
            if (j3 < 10) {
                valueOf = "0" + j3;
            } else {
                valueOf = String.valueOf(j3);
            }
            if (j4 < 10) {
                valueOf2 = "0" + j4;
            } else {
                valueOf2 = String.valueOf(j4);
            }
            return valueOf + ":" + valueOf2;
        }
        return (String) invokeJ.objValue;
    }
}
