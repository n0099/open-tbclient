package com.yy.gslbsdk.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.yy.gslbsdk.db.DBAccessMgr;
import com.yy.gslbsdk.db.DelayTB;
import com.yy.gslbsdk.db.ProbeTB;
import com.yy.gslbsdk.db.ResultTB;
import com.yy.gslbsdk.device.DeviceMgr;
import com.yy.gslbsdk.device.NetStatusInfo;
import com.yy.gslbsdk.protocol.DnsInfo;
import com.yy.gslbsdk.protocol.ResInfo;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public enum DataCacheMgr {
    INSTANCE;
    
    public static final String TAG = "DataCacheMgr";
    public ConcurrentHashMap<String, DnsInfo> mLocalDNSCache = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, ResultTB> mHttpDNSCache = new ConcurrentHashMap<>();
    public ArrayList<ProbeTB> mProbeCache = new ArrayList<>();
    public HashMap<String, ArrayList<DelayTB>> mDelayCacheUpper = new HashMap<>();
    public HashMap<String, ArrayList<DelayTB>> mDelayCacheLower = new HashMap<>();
    public HashMap<String, Integer> mInvokeApiNum = new HashMap<>();
    public HashMap<String, Integer> mHitCacheNum = new HashMap<>();
    public NetStatusInfo mCacheNetStatusInfo = null;
    public String mCacheIdentity = null;
    public int mCountFailedDns = 0;
    public int mCountLocalDns = 0;
    public List<Long> mListDnsCost = new LinkedList();

    public void addFailedDnsCount() {
        this.mCountFailedDns++;
    }

    public void addLocalDnsCount() {
        this.mCountLocalDns++;
    }

    public synchronized void clearAllHitCacheNum() {
        this.mHitCacheNum.clear();
    }

    public synchronized void clearAllInvokeApiNum() {
        this.mInvokeApiNum.clear();
    }

    public void deleteAllDelay() {
        synchronized (this.mDelayCacheLower) {
            this.mDelayCacheLower.clear();
        }
        synchronized (this.mDelayCacheUpper) {
            this.mDelayCacheUpper.clear();
        }
    }

    public ArrayList<ProbeTB> getALlProbe() {
        ArrayList<ProbeTB> arrayList;
        synchronized (this.mProbeCache) {
            arrayList = (ArrayList) this.mProbeCache.clone();
        }
        return arrayList;
    }

    public ArrayList<DelayTB> getAllDelayLower() {
        ArrayList<DelayTB> arrayList = new ArrayList<>();
        synchronized (this.mDelayCacheLower) {
            for (Map.Entry<String, ArrayList<DelayTB>> entry : this.mDelayCacheLower.entrySet()) {
                arrayList.addAll(entry.getValue());
            }
        }
        return arrayList;
    }

    public ArrayList<DelayTB> getAllDelayUpper() {
        ArrayList<DelayTB> arrayList = new ArrayList<>();
        synchronized (this.mDelayCacheUpper) {
            for (Map.Entry<String, ArrayList<DelayTB>> entry : this.mDelayCacheUpper.entrySet()) {
                arrayList.addAll(entry.getValue());
            }
        }
        return arrayList;
    }

    public ConcurrentHashMap<String, DnsInfo> getAllLocalDNSFromCache() {
        return this.mLocalDNSCache;
    }

    public NetStatusInfo getCachedNetStatusInfo() {
        if (this.mCacheNetStatusInfo == null) {
            NetStatusInfo networkInfo = DeviceMgr.getNetworkInfo(GlobalTools.APP_CONTEXT);
            synchronized (this) {
                this.mCacheNetStatusInfo = networkInfo;
            }
        }
        return this.mCacheNetStatusInfo;
    }

    public int getFailedDnsCount() {
        return this.mCountFailedDns;
    }

    public List<Long> getListDnsCost() {
        List<Long> list;
        if (this.mListDnsCost == null) {
            this.mListDnsCost = new LinkedList();
        }
        synchronized (this.mListDnsCost) {
            list = (List) ((LinkedList) this.mListDnsCost).clone();
        }
        return list;
    }

    public int getLocalDnsCount() {
        return this.mCountLocalDns;
    }

    public void resetFailedDnsCount() {
        this.mCountFailedDns = 0;
    }

    public void resetListDnsCost() {
        List<Long> list = this.mListDnsCost;
        if (list == null) {
            this.mListDnsCost = new LinkedList();
            return;
        }
        synchronized (list) {
            this.mListDnsCost.clear();
        }
    }

    public void resetLocalDnsCount() {
        this.mCountLocalDns = 0;
    }

    DataCacheMgr() {
    }

    public void addDnsCost(long j) {
        if (this.mListDnsCost == null) {
            this.mListDnsCost = new LinkedList();
        }
        synchronized (this.mListDnsCost) {
            this.mListDnsCost.add(Long.valueOf(j));
        }
    }

    public synchronized void addHitCacheNum(String str) {
        int i = 0;
        if (this.mHitCacheNum.containsKey(str)) {
            i = this.mHitCacheNum.get(str).intValue();
        }
        this.mHitCacheNum.put(str, Integer.valueOf(i + 1));
    }

    public synchronized void addInvokeApiNum(String str) {
        int i = 0;
        if (this.mInvokeApiNum.containsKey(str)) {
            i = this.mInvokeApiNum.get(str).intValue();
        }
        this.mInvokeApiNum.put(str, Integer.valueOf(i + 1));
    }

    public void addProbe(ProbeTB probeTB) {
        if (probeTB != null) {
            synchronized (this.mProbeCache) {
                if (!this.mProbeCache.contains(probeTB)) {
                    this.mProbeCache.add(probeTB);
                }
            }
        }
    }

    public synchronized void clearHitCacheNum(String str) {
        this.mHitCacheNum.remove(str);
    }

    public synchronized void clearInvokeApiNum(String str) {
        this.mInvokeApiNum.remove(str);
    }

    public void deleteDelayByHostFromLower(String str) {
        if (str != null) {
            synchronized (this.mDelayCacheLower) {
                this.mDelayCacheLower.remove(str);
            }
        }
    }

    public void deleteDelayByHostFromUpper(String str) {
        if (str != null) {
            synchronized (this.mDelayCacheUpper) {
                this.mDelayCacheUpper.remove(str);
            }
        }
    }

    public void deleteHttpDNSFromMemCache(String str) {
        try {
            this.mHttpDNSCache.remove(str);
        } catch (Exception e) {
            LogTools.printWarning(TAG, e);
        }
    }

    public synchronized int getHitCacheNum(String str) {
        int i;
        i = 0;
        if (this.mHitCacheNum.containsKey(str)) {
            i = this.mHitCacheNum.get(str).intValue();
        }
        return i;
    }

    public synchronized int getInvokeApiNum(String str) {
        int i;
        i = 0;
        if (this.mInvokeApiNum.containsKey(str)) {
            i = this.mInvokeApiNum.get(str).intValue();
        }
        return i;
    }

    public String getReportDate(Context context) {
        return context.getSharedPreferences("reportConfig", 0).getString("last_hijack", new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis() - GlobalTools.ONE_DAY_MILSEC)));
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

    public void setCachedNetStateInfo(NetStatusInfo netStatusInfo) {
        synchronized (this) {
            this.mCacheNetStatusInfo = netStatusInfo;
        }
    }

    public void addDelay(DelayTB delayTB) {
        if (delayTB != null) {
            if (delayTB.getDelay() >= 500) {
                synchronized (this.mDelayCacheUpper) {
                    ArrayList<DelayTB> arrayList = this.mDelayCacheUpper.get(delayTB.getHost());
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                        this.mDelayCacheUpper.put(delayTB.getHost(), arrayList);
                    }
                    arrayList.add(delayTB);
                }
                return;
            }
            synchronized (this.mDelayCacheLower) {
                ArrayList<DelayTB> arrayList2 = this.mDelayCacheLower.get(delayTB.getHost());
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.mDelayCacheLower.put(delayTB.getHost(), arrayList2);
                }
                arrayList2.add(delayTB);
            }
        }
    }

    public int getHttpDNSFromCache(Context context, String str, String str2, DnsInfo dnsInfo) {
        List<ResultTB> resultByNetworkHost;
        if (dnsInfo != null) {
            ResultTB httpDNSFromMemCache = getHttpDNSFromMemCache(str, str2);
            if (httpDNSFromMemCache == null && (resultByNetworkHost = DBAccessMgr.getInstance(context).getResultByNetworkHost(str, str2)) != null && !resultByNetworkHost.isEmpty()) {
                httpDNSFromMemCache = resultByNetworkHost.get(0);
            }
            if (httpDNSFromMemCache != null) {
                dnsInfo.setHost(httpDNSFromMemCache.getHost());
                dnsInfo.setTtl(httpDNSFromMemCache.getTtl());
                dnsInfo.setIPStr(httpDNSFromMemCache.getIp());
                dnsInfo.setCmdStr(httpDNSFromMemCache.getCmd());
                dnsInfo.setView(httpDNSFromMemCache.getView());
                dnsInfo.setUip(httpDNSFromMemCache.getUip());
                dnsInfo.setSource(httpDNSFromMemCache.getSource());
                dnsInfo.setEndTime(httpDNSFromMemCache.getEndTime());
                dnsInfo.setProbeTime(httpDNSFromMemCache.getUpdateTime() + ((int) (httpDNSFromMemCache.getTtl() * GlobalTools.TTL_PROBE_FACTOR * 1000.0f)));
                return 0;
            }
            return 2;
        }
        return 5;
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

    public void setReportDate(Context context, String str) {
        context.getSharedPreferences("reportConfig", 0).edit().putString("last_hijack", str).commit();
    }

    public synchronized String getIdentity(Context context) {
        if (this.mCacheIdentity != null) {
            return this.mCacheIdentity;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString("gslb_identity", "");
        this.mCacheIdentity = string;
        if (string.length() == 0) {
            this.mCacheIdentity = UUID.randomUUID().toString();
            defaultSharedPreferences.edit().putString("gslb_identity", this.mCacheIdentity).commit();
        }
        return this.mCacheIdentity;
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
                        dBAccessMgr.addOrUpdate(resultTB, true);
                    }
                    putHttpDNSIntoMemCache(resultTB);
                }
                return 0;
            }
        }
        return 5;
    }
}
