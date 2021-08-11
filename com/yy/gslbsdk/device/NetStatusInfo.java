package com.yy.gslbsdk.device;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.control.NetworkStatus;
import com.yy.gslbsdk.util.GlobalTools;
/* loaded from: classes10.dex */
public class NetStatusInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int isp;
    public int netType;
    public NetworkStatus networkStatus;
    public String ssid;

    public NetStatusInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.netType = 1;
        this.isp = 0;
        this.ssid = null;
        this.networkStatus = NetworkStatus.getInstanceClone();
    }

    public int getIsp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.isp : invokeV.intValue;
    }

    public String getNetStatusID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                if (this.netType != 0 && this.netType != 1) {
                    if (this.netType == 2) {
                        return String.valueOf(this.netType) + "-" + this.ssid + "-" + GlobalTools.APP_LOCALIZE_CODE;
                    }
                    return String.valueOf(this.netType) + "-" + this.isp + "-" + GlobalTools.APP_LOCALIZE_CODE;
                }
                return String.valueOf(this.netType) + "-" + GlobalTools.APP_LOCALIZE_CODE;
            } catch (Exception unused) {
                return "unknown";
            }
        }
        return (String) invokeV.objValue;
    }

    public int getNetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.netType : invokeV.intValue;
    }

    public NetworkStatus getNetworkStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.networkStatus : (NetworkStatus) invokeV.objValue;
    }

    public String getSsid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.ssid : (String) invokeV.objValue;
    }

    public boolean isKnowIsp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i2 = this.netType;
            return (i2 == 0 || i2 == 1 || i2 == 2 || this.isp == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void resetVal(NetStatusInfo netStatusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, netStatusInfo) == null) {
            this.netType = netStatusInfo.netType;
            this.isp = netStatusInfo.isp;
            this.ssid = netStatusInfo.ssid;
            this.networkStatus = netStatusInfo.networkStatus.m647clone();
        }
    }

    public void setIsp(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.isp = i2;
        }
    }

    public void setNetType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.netType = i2;
        }
    }

    public void setNetworkStatus(NetworkStatus networkStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, networkStatus) == null) {
            this.networkStatus = networkStatus;
        }
    }

    public void setSsid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.ssid = str;
        }
    }
}
