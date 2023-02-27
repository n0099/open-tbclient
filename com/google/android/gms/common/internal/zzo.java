package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public final class zzo implements ServiceConnection, zzs {
    public final /* synthetic */ zzr zza;
    public final Map<ServiceConnection, ServiceConnection> zzb = new HashMap();
    public int zzc = 2;
    public boolean zzd;
    @Nullable
    public IBinder zze;
    public final zzn zzf;
    public ComponentName zzg;

    public final int zza() {
        return this.zzc;
    }

    public final ComponentName zzb() {
        return this.zzg;
    }

    @Nullable
    public final IBinder zzc() {
        return this.zze;
    }

    public final boolean zzj() {
        return this.zzd;
    }

    public zzo(zzr zzrVar, zzn zznVar) {
        this.zza = zzrVar;
        this.zzf = zznVar;
    }

    public final void zzf(ServiceConnection serviceConnection, String str) {
        this.zzb.remove(serviceConnection);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.zza.zzb;
        synchronized (hashMap) {
            handler = this.zza.zzd;
            handler.removeMessages(1, this.zzf);
            this.zze = iBinder;
            this.zzg = componentName;
            for (ServiceConnection serviceConnection : this.zzb.values()) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.zzc = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.zza.zzb;
        synchronized (hashMap) {
            handler = this.zza.zzd;
            handler.removeMessages(1, this.zzf);
            this.zze = null;
            this.zzg = componentName;
            for (ServiceConnection serviceConnection : this.zzb.values()) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.zzc = 2;
        }
    }

    public final void zzd(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.zzb.put(serviceConnection, serviceConnection2);
    }

    public final void zze(String str, @Nullable Executor executor) {
        ConnectionTracker connectionTracker;
        Context context;
        Context context2;
        ConnectionTracker connectionTracker2;
        Context context3;
        Handler handler;
        Handler handler2;
        long j;
        this.zzc = 3;
        zzr zzrVar = this.zza;
        connectionTracker = zzrVar.zzf;
        context = zzrVar.zzc;
        zzn zznVar = this.zzf;
        context2 = zzrVar.zzc;
        boolean zza = connectionTracker.zza(context, str, zznVar.zzc(context2), this, this.zzf.zza(), executor);
        this.zzd = zza;
        if (zza) {
            handler = this.zza.zzd;
            Message obtainMessage = handler.obtainMessage(1, this.zzf);
            handler2 = this.zza.zzd;
            j = this.zza.zzh;
            handler2.sendMessageDelayed(obtainMessage, j);
            return;
        }
        this.zzc = 2;
        try {
            zzr zzrVar2 = this.zza;
            connectionTracker2 = zzrVar2.zzf;
            context3 = zzrVar2.zzc;
            connectionTracker2.unbindService(context3, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void zzg(String str) {
        Handler handler;
        ConnectionTracker connectionTracker;
        Context context;
        handler = this.zza.zzd;
        handler.removeMessages(1, this.zzf);
        zzr zzrVar = this.zza;
        connectionTracker = zzrVar.zzf;
        context = zzrVar.zzc;
        connectionTracker.unbindService(context, this);
        this.zzd = false;
        this.zzc = 2;
    }

    public final boolean zzh(ServiceConnection serviceConnection) {
        return this.zzb.containsKey(serviceConnection);
    }

    public final boolean zzi() {
        return this.zzb.isEmpty();
    }
}
