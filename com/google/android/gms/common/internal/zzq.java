package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class zzq implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ zzr zza;

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.google.android.gms.common.internal.zzr.<init>(android.content.Context, android.os.Looper):void] */
    public /* synthetic */ zzq(zzr zzrVar, zzp zzpVar) {
        this.zza = zzrVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        InterceptResult invokeL;
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        HashMap hashMap4;
        HashMap hashMap5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
            int i = message.what;
            if (i == 0) {
                hashMap = this.zza.zzb;
                synchronized (hashMap) {
                    zzn zznVar = (zzn) message.obj;
                    hashMap2 = this.zza.zzb;
                    zzo zzoVar = (zzo) hashMap2.get(zznVar);
                    if (zzoVar != null && zzoVar.zzi()) {
                        if (zzoVar.zzj()) {
                            zzoVar.zzg("GmsClientSupervisor");
                        }
                        hashMap3 = this.zza.zzb;
                        hashMap3.remove(zznVar);
                    }
                }
                return true;
            } else if (i != 1) {
                return false;
            } else {
                hashMap4 = this.zza.zzb;
                synchronized (hashMap4) {
                    zzn zznVar2 = (zzn) message.obj;
                    hashMap5 = this.zza.zzb;
                    zzo zzoVar2 = (zzo) hashMap5.get(zznVar2);
                    if (zzoVar2 != null && zzoVar2.zza() == 3) {
                        String valueOf = String.valueOf(zznVar2);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                        sb.append("Timeout waiting for ServiceConnection callback ");
                        sb.append(valueOf);
                        Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                        ComponentName zzb = zzoVar2.zzb();
                        if (zzb == null) {
                            zzb = zznVar2.zzb();
                        }
                        if (zzb == null) {
                            String zzd = zznVar2.zzd();
                            Preconditions.checkNotNull(zzd);
                            zzb = new ComponentName(zzd, "unknown");
                        }
                        zzoVar2.onServiceDisconnected(zzb);
                    }
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
