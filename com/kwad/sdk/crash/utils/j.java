package com.kwad.sdk.crash.utils;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.SimpleDateFormat;
/* loaded from: classes2.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static SimpleDateFormat f65519a;
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
        f65519a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static String a(long j) {
        InterceptResult invokeJ;
        String valueOf;
        String valueOf2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j)) == null) {
            long j2 = j / 60000;
            long j3 = (j - (60000 * j2)) / 1000;
            if (j2 < 10) {
                valueOf = "0" + j2;
            } else {
                valueOf = String.valueOf(j2);
            }
            if (j3 < 10) {
                valueOf2 = "0" + j3;
            } else {
                valueOf2 = String.valueOf(j3);
            }
            return valueOf + ":" + valueOf2;
        }
        return (String) invokeJ.objValue;
    }
}
