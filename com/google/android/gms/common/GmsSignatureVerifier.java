package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.common.zzag;
@ShowFirstParty
@KeepForSdk
/* loaded from: classes9.dex */
public class GmsSignatureVerifier {
    public static final zzz zza;
    public static final zzz zzb;

    static {
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
