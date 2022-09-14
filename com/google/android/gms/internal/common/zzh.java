package com.google.android.gms.internal.common;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class zzh {
    public static /* synthetic */ Interceptable $ic;
    public static final zze zza;
    public static volatile zze zzb;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-193693629, "Lcom/google/android/gms/internal/common/zzh;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-193693629, "Lcom/google/android/gms/internal/common/zzh;");
                return;
            }
        }
        zzg zzgVar = new zzg(null);
        zza = zzgVar;
        zzb = zzgVar;
    }

    public static zze zza() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? zzb : (zze) invokeV.objValue;
    }
}
