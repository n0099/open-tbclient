package com.google.android.gms.common;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.common.zzag;
@ShowFirstParty
@KeepForSdk
/* loaded from: classes7.dex */
public class GmsSignatureVerifier {
    public static /* synthetic */ Interceptable $ic;
    public static final zzz zza;
    public static final zzz zzb;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1513868564, "Lcom/google/android/gms/common/GmsSignatureVerifier;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1513868564, "Lcom/google/android/gms/common/GmsSignatureVerifier;");
                return;
            }
        }
        zzx zzxVar = new zzx();
        zzxVar.zzd("com.google.android.gms");
        zzxVar.zza(204200000L);
        zzxVar.zzc(zzag.zzn(zzm.zzd.zzf(), zzm.zzb.zzf()));
        zzxVar.zzb(zzag.zzn(zzm.zzc.zzf(), zzm.zza.zzf()));
        zza = zzxVar.zze();
        zzx zzxVar2 = new zzx();
        zzxVar2.zzd("com.android.vending");
        zzxVar2.zza(82240000L);
        zzxVar2.zzc(zzag.zzm(zzm.zzd.zzf()));
        zzxVar2.zzb(zzag.zzm(zzm.zzc.zzf()));
        zzb = zzxVar2.zze();
    }
}
