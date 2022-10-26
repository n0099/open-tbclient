package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.Preconditions;
/* loaded from: classes7.dex */
public abstract class ResolvingResultCallbacks extends ResultCallbacks {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity zza;
    public final int zzb;

    @Override // com.google.android.gms.common.api.ResultCallbacks
    public abstract void onSuccess(Result result);

    public abstract void onUnresolvableFailure(Status status);

    public ResolvingResultCallbacks(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Preconditions.checkNotNull(activity, "Activity must not be null");
        this.zza = activity;
        this.zzb = i;
    }

    @Override // com.google.android.gms.common.api.ResultCallbacks
    public final void onFailure(Status status) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, status) == null) {
            if (status.hasResolution()) {
                try {
                    status.startResolutionForResult(this.zza, this.zzb);
                    return;
                } catch (IntentSender.SendIntentException e) {
                    Log.e("ResolvingResultCallback", "Failed to start resolution", e);
                    onUnresolvableFailure(new Status(8));
                    return;
                }
            }
            onUnresolvableFailure(status);
        }
    }
}
