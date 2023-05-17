package com.yy.gslbsdk.cache;

import android.content.Context;
import android.text.TextUtils;
import com.yy.gslbsdk.db.DBAccessMgr;
import com.yy.gslbsdk.db.ResultTB;
import com.yy.gslbsdk.protocol.DnsInfo;
import com.yy.gslbsdk.protocol.ResInfo;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public enum DataV6CacheMgr {
    INSTANCE;
    
    public static final String TAG = "DataV6CacheMgr";
    public ConcurrentHashMap<String, DnsInfo> mLocalDNSCache = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, ResultTB> mHttpDNSCache = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, DnsInfo> getAllLocalDNSFromCache() {
        return this.mLocalDNSCache;
    }

    DataV6CacheMgr() {
    }

    public ResultTB getHttpDNSFromMemCache(String str, String str2) {
        try {
            ResultTB resultTB = this.mHttpDNSCache.get(str2);
            if (resultTB != null) {
                if (str.equals(resultTB.getNetwork())) {
                    return resultTB;
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            LogTools.printWarning(TAG, e);
            return null;
        }
    }

    public int getLocalDNSFromCache(String str, DnsInfo dnsInfo) {
        if (dnsInfo != null) {
            if (this.mLocalDNSCache.containsKey(str)) {
                DnsInfo dnsInfo2 = this.mLocalDNSCache.get(str);
                if (dnsInfo2.getEndTime() > System.currentTimeMillis()) {
                    dnsInfo.cloneDnsInfo(dnsInfo2);
                    return 0;
                }
            }
            return 2;
        }
        return 5;
    }

    public void deleteHttpDNSFromMemCache(String str) {
        try {
            this.mHttpDNSCache.remove(str);
        } catch (Exception e) {
            LogTools.printWarning(TAG, e);
        }
    }

    public int putHttpDNSIntoMemCache(ResultTB resultTB) {
        if (resultTB != null) {
            try {
                this.mHttpDNSCache.put(resultTB.getHost(), resultTB);
                return 0;
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
                return 0;
            }
        }
        return 0;
    }

    public void putLocalDNSIntoCache(DnsInfo dnsInfo) {
        if (dnsInfo != null) {
            this.mLocalDNSCache.put(dnsInfo.getHost(), dnsInfo);
        }
    }

    public int getHttpDNSFromCache(Context context, String str, String str2, DnsInfo dnsInfo) {
        List<ResultTB> resultV6ByNetworkHost;
        if (dnsInfo != null) {
            ResultTB httpDNSFromMemCache = getHttpDNSFromMemCache(str, str2);
            if (httpDNSFromMemCache == null && (resultV6ByNetworkHost = DBAccessMgr.getInstance(context).getResultV6ByNetworkHost(str, str2)) != null && !resultV6ByNetworkHost.isEmpty()) {
                httpDNSFromMemCache = resultV6ByNetworkHost.get(0);
            }
            if (httpDNSFromMemCache != null) {
                dnsInfo.setHost(httpDNSFromMemCache.getHost());
                dnsInfo.setTtl(httpDNSFromMemCache.getTtl());
                dnsInfo.setIPStr(httpDNSFromMemCache.getIp());
                dnsInfo.setCmdStr(httpDNSFromMemCache.getCmd());
                dnsInfo.setView(httpDNSFromMemCache.getView());
                dnsInfo.setUip(httpDNSFromMemCache.getUip());
                dnsInfo.setEndTime(httpDNSFromMemCache.getEndTime());
                dnsInfo.setProbeTime(httpDNSFromMemCache.getUpdateTime() + ((int) (httpDNSFromMemCache.getTtl() * GlobalTools.TTL_PROBE_FACTOR * 1000.0f)));
                return 0;
            }
            return 2;
        }
        return 5;
    }

    public int putHttpDNSIntoCache(Context context, ResInfo resInfo) {
        if (resInfo.getNetInfo() != null) {
            DBAccessMgr dBAccessMgr = DBAccessMgr.getInstance(context);
            String netStatusID = resInfo.getNetInfo().getNetStatusID();
            if (resInfo.getDns() != null) {
                for (DnsInfo dnsInfo : resInfo.getDns().values()) {
                    ResultTB resultTB = new ResultTB();
                    resultTB.setNetwork(netStatusID);
                    resultTB.setHost(dnsInfo.getHost());
                    resultTB.setTtl(dnsInfo.getTtl());
                    resultTB.setEndTime(dnsInfo.getEndTime());
                    resultTB.setCmd(dnsInfo.getCmdStr());
                    resultTB.setUpdateTime(System.currentTimeMillis());
                    resultTB.setView(dnsInfo.getView());
                    resultTB.setUip(dnsInfo.getUip());
                    resultTB.setSource(dnsInfo.getSource());
                    String iPStr = dnsInfo.getIPStr();
                    if (!TextUtils.isEmpty(iPStr)) {
                        resultTB.setIp(iPStr);
                        dBAccessMgr.addOrUpdateV6(resultTB, true);
                    }
                    putHttpDNSIntoMemCache(resultTB);
                }
                return 0;
            }
        }
        return 5;
    }
}
