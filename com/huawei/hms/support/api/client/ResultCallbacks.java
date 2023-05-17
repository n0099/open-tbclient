package com.huawei.hms.support.api.client;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.common.api.Releasable;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.log.HMSLog;
@Deprecated
/* loaded from: classes9.dex */
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ResultCallbacks";
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void onFailure(Status status);

    public abstract void onSuccess(R r);

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

    public final void onResult(R r) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r) == null) {
            try {
                Status status = r.getStatus();
                if (status.isSuccess()) {
                    onSuccess(r);
                    return;
                }
                onFailure(status);
                if (r instanceof Releasable) {
                    ((Releasable) r).release();
                }
            } catch (Exception e) {
                HMSLog.w(TAG, "Failed to release " + r + ", reason: " + e);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.huawei.hms.support.api.client.ResultCallbacks<R extends com.huawei.hms.support.api.client.Result> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.hms.support.api.client.ResultCallback
    public /* bridge */ /* synthetic */ void onResult(Object obj) {
        onResult((ResultCallbacks<R>) ((Result) obj));
    }
}
