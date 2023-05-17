package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;
/* loaded from: classes9.dex */
public final class zzq implements Handler.Callback {
    public final /* synthetic */ zzr zza;

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.google.android.gms.common.internal.zzr.<init>(android.content.Context, android.os.Looper):void] */
    public /* synthetic */ zzq(zzr zzrVar, zzp zzpVar) {
        this.zza = zzrVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        HashMap hashMap4;
        HashMap hashMap5;
        int i = message.what;
        if (i != 0) {
            if (i != 1) {
                return false;
            }
            hashMap4 = this.zza.zzb;
            synchronized (hashMap4) {
                zzn zznVar = (zzn) message.obj;
                hashMap5 = this.zza.zzb;
                zzo zzoVar = (zzo) hashMap5.get(zznVar);
                if (zzoVar != null && zzoVar.zza() == 3) {
                    String valueOf = String.valueOf(zznVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName zzb = zzoVar.zzb();
                    if (zzb == null) {
                        zzb = zznVar.zzb();
                    }
                    if (zzb == null) {
                        String zzd = zznVar.zzd();
                        Preconditions.checkNotNull(zzd);
                        zzb = new ComponentName(zzd, "unknown");
                    }
                    zzoVar.onServiceDisconnected(zzb);
                }
            }
            return true;
        }
        hashMap = this.zza.zzb;
        synchronized (hashMap) {
            zzn zznVar2 = (zzn) message.obj;
            hashMap2 = this.zza.zzb;
            zzo zzoVar2 = (zzo) hashMap2.get(zznVar2);
            if (zzoVar2 != null && zzoVar2.zzi()) {
                if (zzoVar2.zzj()) {
                    zzoVar2.zzg("GmsClientSupervisor");
                }
                hashMap3 = this.zza.zzb;
                hashMap3.remove(zznVar2);
            }
        }
        return true;
    }
}
