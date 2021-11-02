package com.yy.gslbsdk.db;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class ResultTB implements Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CMD = "cmd";
    public static final String ENDTIME = "end_time";
    public static final String HOST = "host";
    public static final String ID = "_id";
    public static final String IP = "ip";
    public static final String NETWORK = "network";
    public static final String SOURCE = "src";
    public static final String TTL = "ttl";
    public static final String UIP = "uip";
    public static final String UPDATETIME = "update_time";
    public static final String VIEW = "_view";
    public static final long serialVersionUID = -3157206435418951459L;
    public transient /* synthetic */ FieldHolder $fh;
    public String cmd;
    public long endTime;
    public String host;
    public int id;
    public String ip;
    public String network;
    public int source;
    public int ttl;
    public String uip;
    public long updateTime;
    public String view;

    public ResultTB() {
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
        this.id = -1;
        this.network = null;
        this.host = null;
        this.ip = null;
        this.ttl = -1;
        this.endTime = -1L;
        this.cmd = null;
        this.updateTime = -1L;
        this.view = null;
        this.uip = null;
        this.source = 0;
    }

    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.clone() : invokeV.objValue;
    }

    public String getCmd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cmd : (String) invokeV.objValue;
    }

    public long getEndTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.endTime : invokeV.longValue;
    }

    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.host : (String) invokeV.objValue;
    }

    public int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.id : invokeV.intValue;
    }

    public String getIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.ip : (String) invokeV.objValue;
    }

    public String getNetwork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.network : (String) invokeV.objValue;
    }

    public int getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.source : invokeV.intValue;
    }

    public int getTtl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.ttl : invokeV.intValue;
    }

    public String getUip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.uip : (String) invokeV.objValue;
    }

    public long getUpdateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.updateTime : invokeV.longValue;
    }

    public String getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.view : (String) invokeV.objValue;
    }

    public void setCmd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.cmd = str;
        }
    }

    public void setEndTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            this.endTime = j;
        }
    }

    public void setHost(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.host = str;
        }
    }

    public void setId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.id = i2;
        }
    }

    public void setIp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.ip = str;
        }
    }

    public void setNetwork(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.network = str;
        }
    }

    public void setSource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.source = i2;
        }
    }

    public void setTtl(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.ttl = i2;
        }
    }

    public void setUip(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.uip = str;
        }
    }

    public void setUpdateTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.updateTime = j;
        }
    }

    public void setView(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.view = str;
        }
    }
}
