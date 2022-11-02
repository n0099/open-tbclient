package com.google.android.gms.internal.common;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.CheckForNull;
/* loaded from: classes7.dex */
public abstract class zzw extends zzj<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CharSequence zzb;
    public final zzo zzc;
    public final boolean zzd;
    public int zze;
    public int zzf;

    public abstract int zzc(int i);

    public abstract int zzd(int i);

    public zzw(zzx zzxVar, CharSequence charSequence) {
        zzo zzoVar;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zzxVar, charSequence};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zze = 0;
        zzoVar = zzxVar.zza;
        this.zzc = zzoVar;
        z = zzxVar.zzb;
        this.zzd = z;
        this.zzf = Integer.MAX_VALUE;
        this.zzb = charSequence;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
        r3 = r5.zzf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
        if (r3 != 1) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
        r1 = r5.zzb.length();
        r5.zze = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
        if (r1 <= r0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
        r5.zzb.charAt(r1 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
        r5.zzf = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
        return r5.zzb.subSequence(r0, r1).toString();
     */
    @Override // com.google.android.gms.internal.common.zzj
    @CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ String zza() {
        int zzc;
        int i = this.zze;
        while (true) {
            int i2 = this.zze;
            if (i2 != -1) {
                int zzd = zzd(i2);
                if (zzd == -1) {
                    zzd = this.zzb.length();
                    this.zze = -1;
                    zzc = -1;
                } else {
                    zzc = zzc(zzd);
                    this.zze = zzc;
                }
                if (zzc == i) {
                    int i3 = zzc + 1;
                    this.zze = i3;
                    if (i3 > this.zzb.length()) {
                        this.zze = -1;
                    }
                } else {
                    if (i < zzd) {
                        this.zzb.charAt(i);
                    }
                    if (i < zzd) {
                        this.zzb.charAt(zzd - 1);
                    }
                    if (!this.zzd || i != zzd) {
                        break;
                    }
                    i = this.zze;
                }
            } else {
                zzb();
                return null;
            }
        }
    }
}
