package com.yy.gslbsdk.protocol;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.device.NetStatusInfo;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class ResInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedHashMap<String, DnsInfo> dns;
    public HttpDnsInfo httpdns;
    public List<Map<String, String>> listRefresh;
    public NetStatusInfo netInfo;
    public int status;
    public String userIp;
    public String userView;

    public ResInfo() {
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
        this.listRefresh = new LinkedList();
        this.status = 2;
    }

    public void addRefresh(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            if (this.listRefresh == null) {
                this.listRefresh = new LinkedList();
            }
            this.listRefresh.add(map);
        }
    }

    public LinkedHashMap<String, DnsInfo> getDns() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.dns : (LinkedHashMap) invokeV.objValue;
    }

    public HttpDnsInfo getHttpdns() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.httpdns : (HttpDnsInfo) invokeV.objValue;
    }

    public List<Map<String, String>> getListRefresh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.listRefresh : (List) invokeV.objValue;
    }

    public NetStatusInfo getNetInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.netInfo : (NetStatusInfo) invokeV.objValue;
    }

    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.status : invokeV.intValue;
    }

    public String getUserIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.userIp : (String) invokeV.objValue;
    }

    public String getUserView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.userView : (String) invokeV.objValue;
    }

    public void setDns(LinkedHashMap<String, DnsInfo> linkedHashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, linkedHashMap) == null) {
            this.dns = linkedHashMap;
        }
    }

    public void setHttpdns(HttpDnsInfo httpDnsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, httpDnsInfo) == null) {
            this.httpdns = httpDnsInfo;
        }
    }

    public void setNetInfo(NetStatusInfo netStatusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, netStatusInfo) == null) {
            this.netInfo = netStatusInfo;
        }
    }

    public void setStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.status = i2;
        }
    }

    public void setUserIp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.userIp = str;
        }
    }

    public void setUserView(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.userView = str;
        }
    }

    public void updateResInfo(ResInfo resInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, resInfo) == null) {
            this.status = resInfo.getStatus();
            this.userView = resInfo.getUserView();
            this.userIp = resInfo.getUserIp();
            this.dns = resInfo.getDns();
            this.httpdns = resInfo.getHttpdns();
            this.netInfo = resInfo.getNetInfo();
        }
    }
}
