package com.huawei.hms.common.api;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes8.dex */
public class AvailabilityException extends Exception {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String TAG;
    public String message;

    public AvailabilityException() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.TAG = "AvailabilityException";
        this.message = null;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.message;
        }
        return (String) invokeV.objValue;
    }

    private ConnectionResult generateConnectionResult(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            String str = this.TAG;
            HMSLog.i(str, "The availability check result is: " + i);
            setMessage(i);
            return new ConnectionResult(i);
        }
        return (ConnectionResult) invokeI.objValue;
    }

    private void setMessage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i) == null) {
            if (i != 21) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                this.message = "INTERNAL_ERROR";
                                return;
                            } else {
                                this.message = "SERVICE_DISABLED";
                                return;
                            }
                        }
                        this.message = "SERVICE_VERSION_UPDATE_REQUIRED";
                        return;
                    }
                    this.message = "SERVICE_MISSING";
                    return;
                }
                this.message = "success";
                return;
            }
            this.message = "ANDROID_VERSION_UNSUPPORT";
        }
    }

    public ConnectionResult getConnectionResult(HuaweiApi<? extends Api.ApiOptions> huaweiApi) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, huaweiApi)) == null) {
            if (huaweiApi == null) {
                HMSLog.e(this.TAG, "The huaweiApi is null.");
                return generateConnectionResult(8);
            }
            return generateConnectionResult(HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(huaweiApi.getContext(), 30000000));
        }
        return (ConnectionResult) invokeL.objValue;
    }

    public ConnectionResult getConnectionResult(HuaweiApiCallable huaweiApiCallable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, huaweiApiCallable)) == null) {
            if (huaweiApiCallable != null && huaweiApiCallable.getHuaweiApi() != null) {
                return generateConnectionResult(HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(huaweiApiCallable.getHuaweiApi().getContext(), 30000000));
            }
            HMSLog.e(this.TAG, "The huaweiApi is null.");
            return generateConnectionResult(8);
        }
        return (ConnectionResult) invokeL.objValue;
    }
}
