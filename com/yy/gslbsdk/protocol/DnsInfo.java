package com.yy.gslbsdk.protocol;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class DnsInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DnsInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public CmdInfo cmd;
    public long endTime;
    public String host;
    public LinkedList<String> ips;
    public int nt;
    public long probeTime;
    public int source;
    public int status;
    public int ttl;
    public String uip;

    /* renamed from: view  reason: collision with root package name */
    public String f1032view;

    public DnsInfo() {
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
        this.ips = new LinkedList<>();
        this.source = 0;
        this.status = 0;
    }

    public void cloneDnsInfo(DnsInfo dnsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dnsInfo) == null) {
            this.host = dnsInfo.getHost();
            this.uip = dnsInfo.getUip();
            this.f1032view = dnsInfo.getView();
            this.ttl = dnsInfo.getTtl();
            this.probeTime = dnsInfo.getProbeTime();
            this.endTime = dnsInfo.getEndTime();
            this.cmd = dnsInfo.getCmd();
            this.ips = (LinkedList) dnsInfo.getIps().clone();
            this.source = dnsInfo.getSource();
            this.status = dnsInfo.status;
        }
    }

    public CmdInfo getCmd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cmd : (CmdInfo) invokeV.objValue;
    }

    public String getCmdStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.cmd != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pe", this.cmd.isPe());
                    jSONObject.put("re", this.cmd.isRe());
                    return jSONObject.toString();
                } catch (Exception e) {
                    LogTools.printError(TAG, "getCmdStr() exception:" + e.getMessage());
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public long getEndTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.endTime : invokeV.longValue;
    }

    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.host : (String) invokeV.objValue;
    }

    public String getIPStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            LinkedList<String> linkedList = this.ips;
            if (linkedList == null || linkedList.isEmpty()) {
                return null;
            }
            String str = "";
            for (int i = 0; i < this.ips.size(); i++) {
                str = str + this.ips.get(i);
                if (i != this.ips.size() - 1) {
                    str = str + ",";
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public LinkedList<String> getIps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.ips : (LinkedList) invokeV.objValue;
    }

    public int getNt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.nt : invokeV.intValue;
    }

    public long getProbeTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.probeTime : invokeV.longValue;
    }

    public int getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.source : invokeV.intValue;
    }

    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.status : invokeV.intValue;
    }

    public int getTtl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.ttl : invokeV.intValue;
    }

    public String getUip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.uip : (String) invokeV.objValue;
    }

    public String getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f1032view : (String) invokeV.objValue;
    }

    public void setCmd(CmdInfo cmdInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cmdInfo) == null) {
            this.cmd = cmdInfo;
        }
    }

    public void setCmdStr(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || str == null || str.equals("")) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.cmd = new CmdInfo();
            if (jSONObject.has("pe")) {
                this.cmd.setPe(jSONObject.getBoolean("pe"));
            }
            if (jSONObject.has("re")) {
                this.cmd.setRe(jSONObject.getBoolean("re"));
            }
        } catch (Exception e) {
            LogTools.printError(TAG, "setCmdStr() exception:" + e.getMessage());
        }
    }

    public void setEndTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.endTime = j;
        }
    }

    public void setHost(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.host = str;
        }
    }

    public void setIPStr(String str) {
        String[] split;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || str == null) {
            return;
        }
        for (String str2 : str.split(",")) {
            if (str2 != null) {
                if (this.ips == null) {
                    this.ips = new LinkedList<>();
                }
                this.ips.add(str2);
            }
        }
    }

    public void setIps(LinkedList<String> linkedList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, linkedList) == null) || linkedList == null) {
            return;
        }
        this.ips = linkedList;
    }

    public void setNt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.nt = i;
        }
    }

    public void setProbeTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.probeTime = j;
        }
    }

    public void setSource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.source = i;
        }
    }

    public void setStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.status = i;
        }
    }

    public void setTtl(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.ttl = i;
            float f = i;
            this.endTime = System.currentTimeMillis() + ((int) (GlobalTools.TTL_EXPIRED_FACTOR * f * 1000.0f));
            this.probeTime = System.currentTimeMillis() + ((int) (f * GlobalTools.TTL_PROBE_FACTOR * 1000.0f));
        }
    }

    public void setUip(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.uip = str;
        }
    }

    public void setView(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.f1032view = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.host + ":[" + getIPStr() + "],ttl=" + String.valueOf(this.ttl) + ", status=" + String.valueOf(this.status);
        }
        return (String) invokeV.objValue;
    }
}
