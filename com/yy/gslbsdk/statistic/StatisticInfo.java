package com.yy.gslbsdk.statistic;

import com.yy.gslbsdk.util.LogTools;
import com.yy.gslbsdk.util.StringTools;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class StatisticInfo {
    public static final String TAG = "StatisticInfo";
    public String requestId = "";
    public String uip = "";
    public String host = "";
    public List<String> rsIp = new LinkedList();
    public List<String> rsIpV4 = new LinkedList();
    public List<String> rsIpV6 = new LinkedList();
    public int cacheType = 0;
    public int ts = 0;
    public List<String> srvIp = new LinkedList();
    public DevInfo devInfo = new DevInfo();
    public int async = 0;
    public int http = 0;
    public int httpErrCode = -1;
    public String httpErrMsg = "";
    public int netType = -1;
    public String network = "";

    public void setSrvIp(List<String> list) {
        if (list == null || list.isEmpty()) {
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
}
