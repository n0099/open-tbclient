package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.ConnectionResult;
/* loaded from: classes7.dex */
public abstract class zza extends zzc<Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int zza;
    @Nullable
    public final Bundle zzb;
    public final /* synthetic */ BaseGmsClient zzc;

    public abstract void zzb(ConnectionResult connectionResult);

    @Override // com.google.android.gms.common.internal.zzc
    public final void zzc() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public abstract boolean zzd();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    public zza(BaseGmsClient baseGmsClient, @Nullable int i, Bundle bundle) {
        super(baseGmsClient, Boolean.TRUE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseGmsClient, Integer.valueOf(i), bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaseGmsClient) objArr2[0], objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zzc = baseGmsClient;
        this.zza = i;
        this.zzb = bundle;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.common.internal.zzc
    public final /* bridge */ /* synthetic */ void zza(Boolean bool) {
        PendingIntent pendingIntent = null;
        if (this.zza == 0) {
            if (!zzd()) {
                this.zzc.zzp(1, null);
                zzb(new ConnectionResult(8, null));
                return;
            }
            return;
        }
        this.zzc.zzp(1, null);
        Bundle bundle = this.zzb;
        if (bundle != null) {
            pendingIntent = (PendingIntent) bundle.getParcelable(BaseGmsClient.KEY_PENDING_INTENT);
        }
        zzb(new ConnectionResult(this.zza, pendingIntent));
    }
}
