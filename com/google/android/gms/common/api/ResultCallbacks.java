package com.google.android.gms.common.api;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class ResultCallbacks implements ResultCallback {
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

    public abstract void onFailure(Status status);

    public abstract void onSuccess(Result result);

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, result) == null) {
            Status status = result.getStatus();
            if (status.isSuccess()) {
                onSuccess(result);
                return;
            }
            onFailure(status);
            if (result instanceof Releasable) {
                try {
                    ((Releasable) result).release();
                } catch (RuntimeException e) {
                    String valueOf = String.valueOf(result);
                    String.valueOf(valueOf).length();
                    Log.w("ResultCallbacks", "Unable to release ".concat(String.valueOf(valueOf)), e);
                }
            }
        }
    }
}
