package com.huawei.hms.support.api.client;

import android.app.Activity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.log.HMSLog;
@Deprecated
/* loaded from: classes9.dex */
public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ResolvingResultCallbacks";
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity mActivity;
    public final int requestCode;

    @Override // com.huawei.hms.support.api.client.ResultCallbacks
    public abstract void onSuccess(R r);

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
        this.mActivity = (Activity) Preconditions.checkNotNull(activity, "Activity must not be null");
        this.requestCode = i;
    }

    @Override // com.huawei.hms.support.api.client.ResultCallbacks
    public final void onFailure(Status status) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, status) == null) {
            try {
                if (status.hasResolution()) {
                    status.startResolutionForResult(this.mActivity, this.requestCode);
                } else {
                    onUnresolvableFailure(status);
                }
            } catch (Exception e) {
                HMSLog.e(TAG, "Failed to start resolution: " + e);
                onUnresolvableFailure(Status.RESULT_INTERNAL_ERROR);
            }
        }
    }
}
