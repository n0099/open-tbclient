package com.google.android.gms.common.internal;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public abstract class zzc<TListener> {
    @Nullable
    public TListener zza;
    public boolean zzb = false;
    public final /* synthetic */ BaseGmsClient zzd;

    public zzc(BaseGmsClient baseGmsClient, TListener tlistener) {
        this.zzd = baseGmsClient;
        this.zza = tlistener;
    }

    public abstract void zza(TListener tlistener);

    public abstract void zzc();

    public final void zze() {
        TListener tlistener;
        synchronized (this) {
            tlistener = this.zza;
            if (this.zzb) {
                String obj = toString();
                StringBuilder sb = new StringBuilder(obj.length() + 47);
                sb.append("Callback proxy ");
                sb.append(obj);
                sb.append(" being reused. This is not safe.");
                Log.w("GmsClient", sb.toString());
            }
        }
        if (tlistener != null) {
            try {
                zza(tlistener);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        synchronized (this) {
            this.zzb = true;
        }
        zzg();
    }

    public final void zzf() {
        synchronized (this) {
            this.zza = null;
        }
    }

    public final void zzg() {
        ArrayList arrayList;
        ArrayList arrayList2;
        zzf();
        arrayList = this.zzd.zzt;
        synchronized (arrayList) {
            arrayList2 = this.zzd.zzt;
            arrayList2.remove(this);
        }
    }
}
