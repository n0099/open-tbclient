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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
@Keep
/* loaded from: classes10.dex */
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

    public PayOrderResult(int i2, String str, String str2, String str3, String str4, String str5, String str6, PollingModeInfo pollingModeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, str2, str3, str4, str5, str6, pollingModeInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.result = i2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.closeRiskEnhance : (String) invokeV.objValue;
    }

    public String getExpand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.expand : (String) invokeV.objValue;
    }

    public String getOrderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.orderId : (String) invokeV.objValue;
    }

    public String getPayChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.payChannel : (String) invokeV.objValue;
    }

    public String getPayMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.payMethod : (String) invokeV.objValue;
    }

    public String getPayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.payUrl : (String) invokeV.objValue;
    }

    public PollingModeInfo getPollingModeInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.pollingModeInfo : (PollingModeInfo) invokeV.objValue;
    }

    public int getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.result : invokeV.intValue;
    }

    public int getResultCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.result : invokeV.intValue;
    }

    public boolean isSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.result == 1 : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "PayOrderResult{result=" + this.result + ", payUrl='" + this.payUrl + ExtendedMessageFormat.QUOTE + ", payChannel='" + this.payChannel + ExtendedMessageFormat.QUOTE + ", orderId='" + this.orderId + ExtendedMessageFormat.QUOTE + ", payMethod='" + this.payMethod + ExtendedMessageFormat.QUOTE + ", expand='" + this.expand + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
