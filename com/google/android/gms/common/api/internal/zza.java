package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class zza implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ LifecycleCallback zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzb zzc;

    public zza(zzb zzbVar, LifecycleCallback lifecycleCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zzbVar, lifecycleCallback, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zzc = zzbVar;
        this.zza = lifecycleCallback;
        this.zzb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            zzb zzbVar = this.zzc;
            i = zzbVar.zzc;
            if (i > 0) {
                LifecycleCallback lifecycleCallback = this.zza;
                bundle = zzbVar.zzd;
                if (bundle != null) {
                    bundle3 = zzbVar.zzd;
                    bundle2 = bundle3.getBundle(this.zzb);
                } else {
                    bundle2 = null;
                }
                lifecycleCallback.onCreate(bundle2);
            }
            i2 = this.zzc.zzc;
            if (i2 >= 2) {
                this.zza.onStart();
            }
            i3 = this.zzc.zzc;
            if (i3 >= 3) {
                this.zza.onResume();
            }
            i4 = this.zzc.zzc;
            if (i4 >= 4) {
                this.zza.onStop();
            }
            i5 = this.zzc.zzc;
            if (i5 >= 5) {
                this.zza.onDestroy();
            }
        }
    }
}
