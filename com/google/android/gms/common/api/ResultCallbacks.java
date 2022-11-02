package com.google.android.gms.common.api;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
/* loaded from: classes7.dex */
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ResultCallbacks() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract void onFailure(@NonNull Status status);

    public abstract void onSuccess(@NonNull R r);

    @Override // com.google.android.gms.common.api.ResultCallback
    @KeepForSdk
    public final void onResult(@NonNull R r) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r) == null) {
            Status status = r.getStatus();
            if (status.isSuccess()) {
                onSuccess(r);
                return;
            }
            onFailure(status);
            if (r instanceof Releasable) {
                try {
                    ((Releasable) r).release();
                } catch (RuntimeException e) {
                    String valueOf = String.valueOf(r);
                    String.valueOf(valueOf).length();
                    Log.w("ResultCallbacks", "Unable to release ".concat(String.valueOf(valueOf)), e);
                }
            }
        }
    }
}
