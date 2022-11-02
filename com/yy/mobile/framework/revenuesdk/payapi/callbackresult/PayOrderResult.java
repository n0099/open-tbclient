package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PollingModeInfo;
@Keep
/* loaded from: classes8.dex */
public class PayOrderResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String closeRiskEnhance;
    public final String expand;
    public final String orderId;
    public final String payChannel;
    public final String payMethod;
    public final String payUrl;
    public final PollingModeInfo pollingModeInfo;
    public final int result;

    public PayOrderResult(int i, String str, String str2, String str3, String str4, String str5, String str6, PollingModeInfo pollingModeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, str2, str3, str4, str5, str6, pollingModeInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.result = i;
        this.payUrl = str;
        this.payChannel = str2;
        this.orderId = str3;
        this.payMethod = str4;
        this.closeRiskEnhance = str5;
        this.expand = str6;
        this.pollingModeInfo = pollingModeInfo;
    }

    public String getCloseRiskEnhance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.closeRiskEnhance;
        }
        return (String) invokeV.objValue;
    }

    public String getExpand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.expand;
        }
        return (String) invokeV.objValue;
    }

    public String getOrderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.orderId;
        }
        return (String) invokeV.objValue;
    }

    public String getPayChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.payChannel;
        }
        return (String) invokeV.objValue;
    }

    public String getPayMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.payMethod;
        }
        return (String) invokeV.objValue;
    }

    public String getPayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.payUrl;
        }
        return (String) invokeV.objValue;
    }

    public PollingModeInfo getPollingModeInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.pollingModeInfo;
        }
        return (PollingModeInfo) invokeV.objValue;
    }

    public int getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.result;
        }
        return invokeV.intValue;
    }

    public int getResultCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.result;
        }
        return invokeV.intValue;
    }

    public boolean isSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.result == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "PayOrderResult{result=" + this.result + ", payUrl='" + this.payUrl + "', payChannel='" + this.payChannel + "', orderId='" + this.orderId + "', payMethod='" + this.payMethod + "', expand='" + this.expand + "'}";
        }
        return (String) invokeV.objValue;
    }
}
