package com.google.android.gms.internal.common;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class zzs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int zza(int i, int i2, String str) {
        InterceptResult invokeIIL;
        String zza;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65536, null, i, i2, str)) == null) {
            if (i >= 0 && i < i2) {
                return i;
            }
            if (i >= 0) {
                if (i2 < 0) {
                    StringBuilder sb = new StringBuilder(26);
                    sb.append("negative size: ");
                    sb.append(i2);
                    throw new IllegalArgumentException(sb.toString());
                }
                zza = zzy.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
            } else {
                zza = zzy.zza("%s (%s) must not be negative", "index", Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(zza);
        }
        return invokeIIL.intValue;
    }

    public static int zzb(int i, int i2, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65537, null, i, i2, str)) == null) {
            if (i >= 0 && i <= i2) {
                return i;
            }
            throw new IndexOutOfBoundsException(zzd(i, i2, "index"));
        }
        return invokeIIL.intValue;
    }

    public static void zzc(int i, int i2, int i3) {
        String zzd;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65538, null, i, i2, i3) == null) {
            if (i >= 0 && i2 >= i && i2 <= i3) {
                return;
            }
            if (i >= 0 && i <= i3) {
                if (i2 >= 0 && i2 <= i3) {
                    zzd = zzy.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
                } else {
                    zzd = zzd(i2, i3, "end index");
                }
            } else {
                zzd = zzd(i, i3, "start index");
            }
            throw new IndexOutOfBoundsException(zzd);
        }
    }

    public static String zzd(int i, int i2, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65539, null, i, i2, str)) == null) {
            if (i < 0) {
                return zzy.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
            }
            if (i2 >= 0) {
                return zzy.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
            }
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
        return (String) invokeIIL.objValue;
    }
}
