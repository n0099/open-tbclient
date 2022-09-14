package com.google.android.gms.ads.identifier;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
@VisibleForTesting
/* loaded from: classes7.dex */
public final class zzb extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CountDownLatch zza;
    public boolean zzb;
    public final WeakReference<AdvertisingIdClient> zzc;
    public final long zzd;

    public zzb(AdvertisingIdClient advertisingIdClient, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {advertisingIdClient, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zzc = new WeakReference<>(advertisingIdClient);
        this.zzd = j;
        this.zza = new CountDownLatch(1);
        this.zzb = false;
        start();
    }

    private final void zza() {
        AdvertisingIdClient advertisingIdClient;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (advertisingIdClient = this.zzc.get()) == null) {
            return;
        }
        advertisingIdClient.zza();
        this.zzb = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.zza.await(this.zzd, TimeUnit.MILLISECONDS)) {
                    return;
                }
                zza();
            } catch (InterruptedException unused) {
                zza();
            }
        }
    }
}
