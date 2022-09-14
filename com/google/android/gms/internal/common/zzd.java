package com.google.android.gms.internal.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class zzd {
    public static /* synthetic */ Interceptable $ic;
    public static final int zza;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-193693753, "Lcom/google/android/gms/internal/common/zzd;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-193693753, "Lcom/google/android/gms/internal/common/zzd;");
                return;
            }
        }
        int i = Build.VERSION.SDK_INT;
        int i2 = 33554432;
        if (i < 31 && (i < 30 || Build.VERSION.CODENAME.length() != 1 || Build.VERSION.CODENAME.charAt(0) < 'S' || Build.VERSION.CODENAME.charAt(0) > 'Z')) {
            i2 = 0;
        }
        zza = i2;
    }

    public static PendingIntent zza(Context context, int i, Intent intent, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, Integer.valueOf(i), intent, Integer.valueOf(i2)})) == null) ? PendingIntent.getActivity(context, i, intent, i2) : (PendingIntent) invokeCommon.objValue;
    }
}
