package com.google.android.gms.common.internal;

import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public abstract class zzc<TListener> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public TListener zza;
    public boolean zzb;
    public final /* synthetic */ BaseGmsClient zzd;

    public zzc(BaseGmsClient baseGmsClient, TListener tlistener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseGmsClient, tlistener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zzd = baseGmsClient;
        this.zza = tlistener;
        this.zzb = false;
    }

    public abstract void zza(TListener tlistener);

    public abstract void zzc();

    public final void zze() {
        TListener tlistener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) {
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
    }

    public final void zzf() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.zza = null;
            }
        }
    }

    public final void zzg() {
        ArrayList arrayList;
        ArrayList arrayList2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            zzf();
            arrayList = this.zzd.zzt;
            synchronized (arrayList) {
                arrayList2 = this.zzd.zzt;
                arrayList2.remove(this);
            }
        }
    }
}
