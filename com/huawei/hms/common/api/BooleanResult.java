package com.huawei.hms.common.api;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
/* loaded from: classes10.dex */
public class BooleanResult extends Result {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Status myStatus;
    public final boolean resultValue;

    public BooleanResult(Status status, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {status, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Preconditions.checkNotNull(status, "status cannot be null");
        this.myStatus = status;
        this.resultValue = z;
    }

    public final boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BooleanResult)) {
                return false;
            }
            BooleanResult booleanResult = (BooleanResult) obj;
            if (this.resultValue == booleanResult.getValue() && this.myStatus.equals(booleanResult.getStatus())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.huawei.hms.support.api.client.Result
    public Status getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.myStatus;
        }
        return (Status) invokeV.objValue;
    }

    public boolean getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.resultValue;
        }
        return invokeV.booleanValue;
    }

    public final int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (this.resultValue ? 1 : 0) + ((this.myStatus.hashCode() + 127) * 77);
        }
        return invokeV.intValue;
    }
}
