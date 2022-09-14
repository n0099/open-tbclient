package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes7.dex */
public final class zzr extends GmsClientSupervisor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @GuardedBy("connectionStatus")
    public final HashMap<zzn, zzo> zzb;
    public final Context zzc;
    public volatile Handler zzd;
    public final zzq zze;
    public final ConnectionTracker zzf;
    public final long zzg;
    public final long zzh;

    public zzr(Context context, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zzb = new HashMap<>();
        this.zze = new zzq(this, null);
        this.zzc = context.getApplicationContext();
        this.zzd = new com.google.android.gms.internal.common.zzi(looper, this.zze);
        this.zzf = ConnectionTracker.getInstance();
        this.zzg = 5000L;
        this.zzh = 300000L;
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final void zza(zzn zznVar, ServiceConnection serviceConnection, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, zznVar, serviceConnection, str) == null) {
            Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
            synchronized (this.zzb) {
                zzo zzoVar = this.zzb.get(zznVar);
                if (zzoVar != null) {
                    if (zzoVar.zzh(serviceConnection)) {
                        zzoVar.zzf(serviceConnection, str);
                        if (zzoVar.zzi()) {
                            this.zzd.sendMessageDelayed(this.zzd.obtainMessage(0, zznVar), this.zzg);
                        }
                    } else {
                        String zznVar2 = zznVar.toString();
                        StringBuilder sb = new StringBuilder(zznVar2.length() + 76);
                        sb.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                        sb.append(zznVar2);
                        throw new IllegalStateException(sb.toString());
                    }
                } else {
                    String zznVar3 = zznVar.toString();
                    StringBuilder sb2 = new StringBuilder(zznVar3.length() + 50);
                    sb2.append("Nonexistent connection status for service config: ");
                    sb2.append(zznVar3);
                    throw new IllegalStateException(sb2.toString());
                }
            }
        }
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final boolean zzc(zzn zznVar, ServiceConnection serviceConnection, String str, @Nullable Executor executor) {
        InterceptResult invokeLLLL;
        boolean zzj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zznVar, serviceConnection, str, executor)) == null) {
            Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
            synchronized (this.zzb) {
                zzo zzoVar = this.zzb.get(zznVar);
                if (zzoVar == null) {
                    zzoVar = new zzo(this, zznVar);
                    zzoVar.zzd(serviceConnection, serviceConnection, str);
                    zzoVar.zze(str, executor);
                    this.zzb.put(zznVar, zzoVar);
                } else {
                    this.zzd.removeMessages(0, zznVar);
                    if (!zzoVar.zzh(serviceConnection)) {
                        zzoVar.zzd(serviceConnection, serviceConnection, str);
                        int zza = zzoVar.zza();
                        if (zza == 1) {
                            serviceConnection.onServiceConnected(zzoVar.zzb(), zzoVar.zzc());
                        } else if (zza == 2) {
                            zzoVar.zze(str, executor);
                        }
                    } else {
                        String zznVar2 = zznVar.toString();
                        StringBuilder sb = new StringBuilder(zznVar2.length() + 81);
                        sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                        sb.append(zznVar2);
                        throw new IllegalStateException(sb.toString());
                    }
                }
                zzj = zzoVar.zzj();
            }
            return zzj;
        }
        return invokeLLLL.booleanValue;
    }

    public final void zzi(Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, looper) == null) {
            synchronized (this.zzb) {
                this.zzd = new com.google.android.gms.internal.common.zzi(looper, this.zze);
            }
        }
    }
}
