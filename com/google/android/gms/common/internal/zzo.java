package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public final class zzo implements ServiceConnection, zzs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ zzr zza;
    public final Map<ServiceConnection, ServiceConnection> zzb;
    public int zzc;
    public boolean zzd;
    @Nullable
    public IBinder zze;
    public final zzn zzf;
    public ComponentName zzg;

    public final int zza() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.zzc : invokeV.intValue;
    }

    public final ComponentName zzb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.zzg : (ComponentName) invokeV.objValue;
    }

    @Nullable
    public final IBinder zzc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.zze : (IBinder) invokeV.objValue;
    }

    public final boolean zzj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.zzd : invokeV.booleanValue;
    }

    public zzo(zzr zzrVar, zzn zznVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zzrVar, zznVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zza = zzrVar;
        this.zzf = zznVar;
        this.zzb = new HashMap();
        this.zzc = 2;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
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
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
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
    }

    public final void zzd(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, serviceConnection, serviceConnection2, str) == null) {
            this.zzb.put(serviceConnection, serviceConnection2);
        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, executor) == null) {
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
    }

    public final void zzf(ServiceConnection serviceConnection, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, serviceConnection, str) == null) {
            this.zzb.remove(serviceConnection);
        }
    }

    public final void zzg(String str) {
        Handler handler;
        ConnectionTracker connectionTracker;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            handler = this.zza.zzd;
            handler.removeMessages(1, this.zzf);
            zzr zzrVar = this.zza;
            connectionTracker = zzrVar.zzf;
            context = zzrVar.zzc;
            connectionTracker.unbindService(context, this);
            this.zzd = false;
            this.zzc = 2;
        }
    }

    public final boolean zzh(ServiceConnection serviceConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, serviceConnection)) == null) {
            return this.zzb.containsKey(serviceConnection);
        }
        return invokeL.booleanValue;
    }

    public final boolean zzi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.zzb.isEmpty();
        }
        return invokeV.booleanValue;
    }
}
