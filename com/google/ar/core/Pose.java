package com.google.ar.core;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Locale;
/* loaded from: classes7.dex */
public class Pose {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.i.b.a.a a;

    /* renamed from: b  reason: collision with root package name */
    public final float[] f52941b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-207807844, "Lcom/google/ar/core/Pose;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-207807844, "Lcom/google/ar/core/Pose;");
                return;
            }
        }
        c.i.b.a.a aVar = c.i.b.a.a.f28610e;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format(Locale.ENGLISH, "t:[x:%.3f, y:%.3f, z:%.3f], q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", Float.valueOf(this.f52941b[0]), Float.valueOf(this.f52941b[1]), Float.valueOf(this.f52941b[2]), Float.valueOf(this.a.a()), Float.valueOf(this.a.c()), Float.valueOf(this.a.d()), Float.valueOf(this.a.e())) : (String) invokeV.objValue;
    }
}
