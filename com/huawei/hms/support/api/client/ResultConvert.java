package com.huawei.hms.support.api.client;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.client.Result;
/* loaded from: classes10.dex */
public abstract class ResultConvert<R extends Result, S extends Result> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract PendingResult onSuccess(Result result);

    /* loaded from: classes10.dex */
    public class FailPendingResult extends EmptyPendingResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ResultConvert this$0;

        public FailPendingResult(ResultConvert resultConvert, Status status) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {resultConvert, status};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = resultConvert;
            setResult(status);
        }
    }

    public ResultConvert() {
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

    public final PendingResult newFailedPendingResult(Status status) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, status)) == null) {
            Preconditions.checkNotNull(status, "The input status cannot be null");
            Preconditions.checkArgument(!status.isSuccess(), "The input status must be call with success status");
            return new FailPendingResult(this, status);
        }
        return (PendingResult) invokeL.objValue;
    }

    public Status onFailed(Status status) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, status)) == null) {
            Preconditions.checkNotNull(status, "The input status cannot be null");
            if (status.getStatusCode() != 0) {
                return status;
            }
            return Status.CoreException;
        }
        return (Status) invokeL.objValue;
    }
}
