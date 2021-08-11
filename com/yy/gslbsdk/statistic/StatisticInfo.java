package com.yy.gslbsdk.statistic;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.util.LogTools;
import com.yy.gslbsdk.util.StringTools;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class StatisticInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "StatisticInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public int async;
    public int cacheType;
    public DevInfo devInfo;
    public String host;
    public int http;
    public int httpErrCode;
    public String httpErrMsg;
    public int netType;
    public String network;
    public String requestId;
    public List<String> rsIp;
    public List<String> rsIpV4;
    public List<String> rsIpV6;
    public List<String> srvIp;
    public int ts;
    public String uip;

    public StatisticInfo() {
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
        this.requestId = "";
        this.uip = "";
        this.host = "";
        this.rsIp = new LinkedList();
        this.rsIpV4 = new LinkedList();
        this.rsIpV6 = new LinkedList();
        this.cacheType = 0;
        this.ts = 0;
        this.srvIp = new LinkedList();
        this.devInfo = new DevInfo();
        this.async = 0;
        this.http = 0;
        this.httpErrCode = -1;
        this.httpErrMsg = "";
        this.netType = -1;
        this.network = "";
    }

    public void setSrvIp(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        if (this.srvIp == null) {
            this.srvIp = new LinkedList();
        }
        synchronized (this.srvIp) {
            this.srvIp.addAll(list);
        }
    }

    public Map<String, String> toMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            try {
                linkedHashMap.put("requestId", StringTools.optString(this.requestId));
                linkedHashMap.put("uip", this.uip);
                linkedHashMap.put("host", this.host);
                linkedHashMap.put("rsIp", this.rsIp.toString());
                linkedHashMap.put("rsIpV4", this.rsIpV4.toString());
                linkedHashMap.put("rsIpV6", this.rsIpV6.toString());
                linkedHashMap.put("cacheType", String.valueOf(this.cacheType));
                linkedHashMap.put("ts", String.valueOf(this.ts));
                synchronized (this.srvIp) {
                    linkedHashMap.put("srvIp", this.srvIp.toString());
                }
                linkedHashMap.put("async", String.valueOf(this.async));
                linkedHashMap.put("http", String.valueOf(this.http));
                linkedHashMap.put("httpErrCode", String.valueOf(this.httpErrCode));
                linkedHashMap.put("httpErrMsg", this.httpErrMsg);
                linkedHashMap.put("netType", String.valueOf(this.netType));
                linkedHashMap.put("network", this.network);
                linkedHashMap.putAll(this.devInfo.toMap());
            } catch (Exception e2) {
                LogTools.printWarning(TAG, e2);
            }
            return linkedHashMap;
        }
        return (Map) invokeV.objValue;
    }
}
