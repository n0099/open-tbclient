package com.yy.gslbsdk;

import android.content.Context;
import android.text.TextUtils;
import com.yy.gslbsdk.GslbEvent;
import com.yy.gslbsdk.cache.DataCacheMgr;
import com.yy.gslbsdk.cache.ExternalCache;
import com.yy.gslbsdk.cache.HttpsLevelMgr;
import com.yy.gslbsdk.cache.ServerIPMgr;
import com.yy.gslbsdk.cache.ServerIPV6Mgr;
import com.yy.gslbsdk.control.IpVersionController;
import com.yy.gslbsdk.control.SwitchController;
import com.yy.gslbsdk.flow.DnsResolveFlow;
import com.yy.gslbsdk.flow.QualityDetectFlow;
import com.yy.gslbsdk.statistic.StatisticMgr;
import com.yy.gslbsdk.thread.AsynTaskMgr;
import com.yy.gslbsdk.thread.ThreadPoolMgr;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.IPTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class HttpDnsService {
    public static final String TAG = "HttpDnsService";
    public static HttpDnsService mHttpDnsService;
    public DegradationFilter mDegradationFilter = null;
    public AtomicBoolean mInit = new AtomicBoolean(false);

    /* loaded from: classes7.dex */
    public interface DegradationFilter {
        boolean shouldDegradeHttpDNS(String str);
    }

    public static synchronized void destroyService() {
        synchronized (HttpDnsService.class) {
            ThreadPoolMgr.getInstance().stop(200L);
            AsynTaskMgr.INSTANCE.stopMonitors();
            AsynTaskMgr.INSTANCE.stop();
            LogTools.printDebug(TAG, "destroyService, mHttpDnsService: " + mHttpDnsService);
            mHttpDnsService = null;
        }
    }

    public static synchronized HttpDnsService getService(Context context, String str, ThreadPoolMgr.ITaskExecutor iTaskExecutor, String str2) {
        HttpDnsService service;
        synchronized (HttpDnsService.class) {
            service = getService(context, str, iTaskExecutor, str2, false);
        }
        return service;
    }

    private void init() {
        synchronized (this.mInit) {
            if (this.mInit.get()) {
                return;
            }
            IpVersionController.getInstance().judgeIpVersion();
            ServerIPMgr.getInstance().initServerIP(GlobalTools.APP_CONTEXT, GlobalTools.APP_LOCALIZE_CODE);
            ServerIPV6Mgr.getInstance().initServerIP(GlobalTools.APP_CONTEXT, GlobalTools.APP_LOCALIZE_CODE);
            ServerIPMgr.getInstance().updateServerIpByLocalDns(GlobalTools.APP_CONTEXT);
            AsynTaskMgr.INSTANCE.startMonitors();
            this.mInit.set(true);
            LogTools.printDebug(TAG, "init, mHttpDnsService: " + mHttpDnsService);
        }
    }

    @Deprecated
    public void cancelRequest(String str, int i2) {
        LogTools.printDebug(TAG, "This interface is Deprecated.");
    }

    public DegradationFilter getDegradationFilter() {
        return this.mDegradationFilter;
    }

    public String getGslbID() {
        return DataCacheMgr.INSTANCE.getIdentity(GlobalTools.APP_CONTEXT);
    }

    public DnsResultInfo getIpsByHost(String str) {
        return getIpsByHost(str, false);
    }

    public DnsResultInfo getIpsByHostAsync(String str) {
        return getIpsByHostAsync(str, false);
    }

    @Deprecated
    public int getNextRequestId() {
        LogTools.printDebug(TAG, "This interface is Deprecated.");
        return -1;
    }

    public String getSdkVersion() {
        return "2.2.18-lianyun";
    }

    public void loadAssetsIp(String str) {
        ExternalCache.getInstance().loadFromAssets(GlobalTools.APP_CONTEXT, str);
    }

    public void setBackgroundModel(boolean z) {
        GlobalTools.IS_BACKGOUND_MODEL = z;
    }

    public void setCacheMaxExpired(int i2) {
        GlobalTools.TTL_HOST_ALIVE_SECOND = Math.max(GlobalTools.TTL_HOST_ALIVE_SECOND, i2);
    }

    public void setDectorHost(String str, int i2, int i3, String str2) {
        QualityDetectFlow.getInstance().updateDectorList(str, i2, i3, str2);
    }

    public void setDegradationFilter(DegradationFilter degradationFilter) {
        this.mDegradationFilter = degradationFilter;
    }

    public void setEnableIpv6(boolean z) {
        IpVersionController.getInstance().setEnableIpv6(z);
    }

    public void setExternalIpData(Map<String, Map<String, List<String>>> map, int i2) {
        ExternalCache.getInstance().setData(map);
        ExternalCache.getInstance().setScene(i2);
    }

    public void setExternalIpEnable(boolean z) {
        ExternalCache.getInstance().setEnable(z);
    }

    public void setExternalIpNetType(ExternalCache.NetType netType) {
        ExternalCache.getInstance().setNetType(netType);
    }

    public void setExternalIpScene(int i2) {
        ExternalCache.getInstance().setScene(i2);
    }

    public void setGslbEventMessager(GslbEvent.GslbEventListener gslbEventListener) {
        GslbEvent.INSTANCE.setListener(gslbEventListener);
    }

    public void setGslbStatistic(StatisticMgr.IGslbStatistic iGslbStatistic) {
        StatisticMgr.getInstance().setStatistic(iGslbStatistic);
    }

    public void setHttpsEnable(boolean z) {
        if (z) {
            setHttpsEnable(1);
        } else {
            setHttpsEnable(0);
        }
    }

    public void setLogEnabled(boolean z) {
        GlobalTools.LOG_IS_OPEN = z;
    }

    public void setMinTTL(int i2) {
        if (i2 < 180) {
            return;
        }
        GlobalTools.sMinSecondTTL = i2;
    }

    public void setNetworkStatus(int i2) {
        IpVersionController.getInstance().setNetworkStatus(i2);
    }

    @Deprecated
    public void setNetworkSupportV6(boolean z) {
        IpVersionController.getInstance().setNetworkStatus(z ? 3 : 1);
    }

    @Deprecated
    public void setPreResolveAfterNetworkChanged(boolean z) {
        GlobalTools.REFRESH_AFTER_NETWORK_CHANGE = z;
    }

    public void setPreResolveHosts(ArrayList<String> arrayList) {
        DnsResolveFlow.getInstance().updateHostList(arrayList, true);
    }

    public void setReport(String str, String str2, long j) {
        if (QualityDetectFlow.getInstance().canReport(str)) {
            QualityDetectFlow.getInstance().addReportData(str, str2, j);
        }
    }

    public static synchronized HttpDnsService getService(Context context, String str, ThreadPoolMgr.ITaskExecutor iTaskExecutor, String str2, boolean z) {
        HttpDnsService service;
        synchronized (HttpDnsService.class) {
            service = getService(context, str, iTaskExecutor, str2, z, "");
        }
        return service;
    }

    @Deprecated
    public DnsResultInfo getIpsByHost(String str, int i2) {
        return getIpsByHost(str);
    }

    public DnsResultInfo getIpsByHostAsync(String str, boolean z) {
        return getIpsByHostAsync(str, z, true);
    }

    public void setPreResolveHosts(final ArrayList<String> arrayList, long j) {
        AsynTaskMgr.INSTANCE.postDelayed(new Runnable() { // from class: com.yy.gslbsdk.HttpDnsService.1
            @Override // java.lang.Runnable
            public void run() {
                DnsResolveFlow.getInstance().updateHostList(arrayList, true);
            }
        }, j);
    }

    public static synchronized HttpDnsService getService(Context context, String str, ThreadPoolMgr.ITaskExecutor iTaskExecutor, String str2, boolean z, String str3) {
        HttpDnsService service;
        synchronized (HttpDnsService.class) {
            service = getService(context, str, iTaskExecutor, str2, "CN", z, str3);
        }
        return service;
    }

    public DnsResultInfo getIpsByHost(String str, boolean z) {
        return getIpsByHost(str, z, true);
    }

    public DnsResultInfo getIpsByHostAsync(String str, boolean z, boolean z2) {
        if (!SwitchController.getInstance().switchGslb()) {
            return new DnsResultInfo();
        }
        init();
        if (!IPTools.isHost(str)) {
            return new DnsResultInfo();
        }
        DegradationFilter degradationFilter = this.mDegradationFilter;
        boolean shouldDegradeHttpDNS = degradationFilter != null ? degradationFilter.shouldDegradeHttpDNS(str) : false;
        LogTools.printDebug(TAG, String.format(Locale.US, "getIpsByHostAsync, host: %s, expiredIPEnabled: %b, enableLocalDns: %b", str, Boolean.valueOf(z), Boolean.valueOf(z2)));
        return DnsResolveFlow.getInstance().handleDNS(str, shouldDegradeHttpDNS, true, z, false, z2);
    }

    public void setExternalIpData(Map<String, Map<String, List<String>>> map) {
        ExternalCache.getInstance().setData(map);
    }

    public void setHttpsEnable(int i2) {
        HttpsLevelMgr.getInstance().setHttpsLevel(i2);
    }

    @Deprecated
    public static synchronized HttpDnsService getService(Context context, String str, ThreadPoolMgr.ITaskExecutor iTaskExecutor, String str2, String str3) {
        HttpDnsService service;
        synchronized (HttpDnsService.class) {
            service = getService(context, str, iTaskExecutor, str2, str3, false);
        }
        return service;
    }

    public DnsResultInfo getIpsByHost(String str, boolean z, boolean z2) {
        if (!SwitchController.getInstance().switchGslb()) {
            return new DnsResultInfo();
        }
        init();
        if (!IPTools.isHost(str)) {
            return new DnsResultInfo();
        }
        DegradationFilter degradationFilter = this.mDegradationFilter;
        boolean shouldDegradeHttpDNS = degradationFilter != null ? degradationFilter.shouldDegradeHttpDNS(str) : false;
        LogTools.printDebug(TAG, String.format(Locale.US, "getIpsByHost, host: %s, forceRefresh: %b, enableLocalDns: %b", str, Boolean.valueOf(z), Boolean.valueOf(z2)));
        return DnsResolveFlow.getInstance().handleDNS(str, shouldDegradeHttpDNS, false, false, z, z2);
    }

    @Deprecated
    public static synchronized HttpDnsService getService(Context context, String str, ThreadPoolMgr.ITaskExecutor iTaskExecutor, String str2, String str3, boolean z) {
        HttpDnsService service;
        synchronized (HttpDnsService.class) {
            service = getService(context, str, iTaskExecutor, str2, str3, z, "");
        }
        return service;
    }

    @Deprecated
    public static synchronized HttpDnsService getService(Context context, String str, ThreadPoolMgr.ITaskExecutor iTaskExecutor, String str2, String str3, boolean z, String str4) {
        HttpDnsService httpDnsService;
        synchronized (HttpDnsService.class) {
            if (mHttpDnsService == null) {
                if (context != null) {
                    GlobalTools.APP_CONTEXT = context.getApplicationContext();
                    if (str == null) {
                        str = "";
                    }
                    GlobalTools.ACCOUNT_ID = str;
                    if (str2 == null) {
                        str2 = "";
                    }
                    GlobalTools.APP_DEV_ID = str2;
                    GlobalTools.APP_LOCALIZE_CODE = "CN";
                    GlobalTools.IS_TEST_ENV = z;
                    if (z) {
                        if (!TextUtils.isEmpty(str4)) {
                            GlobalTools.HTTPDNS_REPORT_HOST = str4;
                            GlobalTools.HTTPDNS_SERVER_HOST = str4;
                        } else {
                            GlobalTools.HTTPDNS_REPORT_HOST = GlobalTools.HTTPDNS_HOST_TEST;
                            GlobalTools.HTTPDNS_SERVER_HOST = GlobalTools.HTTPDNS_HOST_TEST;
                        }
                    }
                    mHttpDnsService = new HttpDnsService();
                    ThreadPoolMgr.getInstance().create(iTaskExecutor);
                    AsynTaskMgr.INSTANCE.start();
                    HttpsLevelMgr.getInstance().update();
                    LogTools.printDebug(TAG, "getService, create mHttpDnsService: " + mHttpDnsService);
                } else {
                    throw new IllegalArgumentException("Context is null");
                }
            }
            httpDnsService = mHttpDnsService;
        }
        return httpDnsService;
    }

    public static synchronized HttpDnsService getService() {
        HttpDnsService httpDnsService;
        synchronized (HttpDnsService.class) {
            httpDnsService = mHttpDnsService;
        }
        return httpDnsService;
    }
}
