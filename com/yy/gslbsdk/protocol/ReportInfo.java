package com.yy.gslbsdk.protocol;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.device.NetStatusInfo;
import java.util.HashMap;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class ReportInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int ct;
    public int fc;
    public LinkedList<HijackInfo> hijack;
    public String host;
    public int lc;
    public NetStatusInfo netInfo;
    public StatsInfo stats0;
    public HashMap<String, StatsInfo> stats1;
    public HashMap<String, StatsInfo> stats15;
    public int tt;

    /* renamed from: view  reason: collision with root package name */
    public String f1033view;

    public ReportInfo() {
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
        this.host = null;
        this.f1033view = null;
        this.netInfo = null;
        this.stats0 = null;
        this.stats1 = null;
        this.stats15 = null;
        this.ct = -1;
        this.tt = -1;
        this.fc = -1;
        this.lc = -1;
        this.hijack = null;
        this.stats1 = new HashMap<>();
        this.stats15 = new HashMap<>();
        this.hijack = new LinkedList<>();
    }

    public int getCt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.ct : invokeV.intValue;
    }

    public int getFc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.fc : invokeV.intValue;
    }

    public LinkedList<HijackInfo> getHijack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.hijack : (LinkedList) invokeV.objValue;
    }

    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.host : (String) invokeV.objValue;
    }

    public int getLc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.lc : invokeV.intValue;
    }

    public NetStatusInfo getNetInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.netInfo : (NetStatusInfo) invokeV.objValue;
    }

    public StatsInfo getStats0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.stats0 : (StatsInfo) invokeV.objValue;
    }

    public HashMap<String, StatsInfo> getStats1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.stats1 : (HashMap) invokeV.objValue;
    }

    public HashMap<String, StatsInfo> getStats15() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.stats15 : (HashMap) invokeV.objValue;
    }

    public int getTt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.tt : invokeV.intValue;
    }

    public String getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f1033view : (String) invokeV.objValue;
    }

    public void setCt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.ct = i;
        }
    }

    public void setFc(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.fc = i;
        }
    }

    public void setHijack(LinkedList<HijackInfo> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, linkedList) == null) {
            this.hijack = linkedList;
        }
    }

    public void setHost(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.host = str;
        }
    }

    public void setLc(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.lc = i;
        }
    }

    public void setNetInfo(NetStatusInfo netStatusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, netStatusInfo) == null) {
            this.netInfo = netStatusInfo;
        }
    }

    public void setStats0(StatsInfo statsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, statsInfo) == null) {
            this.stats0 = statsInfo;
        }
    }

    public void setStats1(HashMap<String, StatsInfo> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, hashMap) == null) {
            this.stats1 = hashMap;
        }
    }

    public void setStats15(HashMap<String, StatsInfo> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, hashMap) == null) {
            this.stats15 = hashMap;
        }
    }

    public void setTt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.tt = i;
        }
    }

    public void setView(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.f1033view = str;
        }
    }
}
