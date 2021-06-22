package com.yy.gslbsdk.flow;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup;
import com.yy.gslbsdk.DnsResultInfo;
import com.yy.gslbsdk.cache.DataCacheMgr;
import com.yy.gslbsdk.cache.ExternalCache;
import com.yy.gslbsdk.cache.ServerIPInfo;
import com.yy.gslbsdk.cache.ServerIPMgr;
import com.yy.gslbsdk.control.ActiveRefreshController;
import com.yy.gslbsdk.control.IpVersionController;
import com.yy.gslbsdk.control.NetworkStatus;
import com.yy.gslbsdk.control.SwitchController;
import com.yy.gslbsdk.control.TtlController;
import com.yy.gslbsdk.db.DBAccessMgr;
import com.yy.gslbsdk.db.HostTB;
import com.yy.gslbsdk.db.ResultTB;
import com.yy.gslbsdk.device.DeviceMgr;
import com.yy.gslbsdk.device.NetStatusInfo;
import com.yy.gslbsdk.device.NetStatusReceiver;
import com.yy.gslbsdk.protocol.DnsInfo;
import com.yy.gslbsdk.protocol.HttpDNSProtocolMgr;
import com.yy.gslbsdk.protocol.LocalDNSProtocolMgr;
import com.yy.gslbsdk.protocol.ResInfo;
import com.yy.gslbsdk.statistic.StatisticInfo;
import com.yy.gslbsdk.statistic.StatisticMgr;
import com.yy.gslbsdk.thread.AsynTaskMgr;
import com.yy.gslbsdk.thread.ThreadInfo;
import com.yy.gslbsdk.thread.ThreadPoolMgr;
import com.yy.gslbsdk.thread.TimerMgr;
import com.yy.gslbsdk.thread.TimerTaskInfo;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.IPTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class DnsResolveFlow {
    public static final String TAG = "DnsResolveFlow";
    public static DnsResolveFlow mDnsResolveFlow;
    public AtomicInteger mIncreaseId = new AtomicInteger(1);
    public ConcurrentHashMap<String, AtomicBoolean> mPendingReqs = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, AtomicInteger> mPendingHttpCode = new ConcurrentHashMap<>();
    public NetStatusReceiver mNetStatusReceiver = null;
    public Runnable mRunnable = new Runnable() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.5
        @Override // java.lang.Runnable
        public void run() {
            DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT);
            if (GlobalTools.REFRESH_AFTER_NETWORK_CHANGE) {
                IpVersionController.getInstance().clearBestServerIPCache();
            }
            DataCacheMgr.INSTANCE.deleteAllDelay();
            DataCacheMgr.INSTANCE.clearAllInvokeApiNum();
            DataCacheMgr.INSTANCE.clearAllHitCacheNum();
            IpVersionController.getInstance().judgeIpVersion();
            DataCacheMgr.INSTANCE.setCachedNetStateInfo(DeviceMgr.getNetworkInfo(GlobalTools.APP_CONTEXT));
        }
    };

    private void collectStat0(long j, DnsResultInfo dnsResultInfo) {
        DataCacheMgr.INSTANCE.addDnsCost(SystemClock.uptimeMillis() - j);
        if (dnsResultInfo.mErrorCode != 0) {
            DataCacheMgr.INSTANCE.addFailedDnsCount();
        } else if (dnsResultInfo.mDataSource == 4) {
            DataCacheMgr.INSTANCE.addLocalDnsCount();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String createRequestId() {
        return String.format(Locale.US, "%s_%d_%d", DataCacheMgr.INSTANCE.getIdentity(GlobalTools.APP_CONTEXT), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.mIncreaseId.getAndIncrement()));
    }

    private int deleteHost(String str) {
        Context context = GlobalTools.APP_CONTEXT;
        if (context != null) {
            DBAccessMgr dBAccessMgr = DBAccessMgr.getInstance(context);
            HostTB hostTB = new HostTB();
            hostTB.setHost(str);
            dBAccessMgr.delHost(hostTB);
            return 0;
        }
        return 5;
    }

    public static DnsResolveFlow getInstance() {
        if (mDnsResolveFlow == null) {
            mDnsResolveFlow = new DnsResolveFlow();
        }
        return mDnsResolveFlow;
    }

    private int handleDegradation(final String str, final DnsResultInfo dnsResultInfo) {
        LogTools.printDebug(TAG, String.format(Locale.US, "handleDegradation, start, host: %s", str));
        final AtomicInteger atomicInteger = new AtomicInteger(-1);
        synchronized (atomicInteger) {
            final String str2 = "LocalDNS-" + str;
            ThreadInfo threadInfo = new ThreadInfo(str2);
            threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.2
                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                public void handleOper(String str3) {
                    DnsInfo requestProtocol = LocalDNSProtocolMgr.requestProtocol(str);
                    if (requestProtocol == null) {
                        DnsResultInfo dnsResultInfo2 = dnsResultInfo;
                        dnsResultInfo2.mErrorCode = 2;
                        dnsResultInfo2.mDataSource = 0;
                        dnsResultInfo2.mIps = new String[0];
                    } else {
                        IpVersionController.getInstance().putLocalDNSIntoCache(requestProtocol);
                        DnsResultInfo dnsResultInfo3 = dnsResultInfo;
                        dnsResultInfo3.mErrorCode = 0;
                        dnsResultInfo3.mDataSource = 4;
                        dnsResultInfo3.mIps = (String[]) requestProtocol.getIps().toArray(new String[0]);
                    }
                    synchronized (atomicInteger) {
                        atomicInteger.set(dnsResultInfo.mErrorCode);
                        LogTools.printDebug(DnsResolveFlow.TAG, String.format(Locale.US, "handleDegradation.handleOper, requestLock notifyAll, host: %s, taskId: %s", str, str2));
                        atomicInteger.notifyAll();
                    }
                }
            });
            ThreadPoolMgr.getInstance().addTask(threadInfo);
            try {
                LogTools.printDebug(TAG, String.format(Locale.US, "handleDegradation, requestLock wait, host: %s", str));
                atomicInteger.wait(GlobalTools.LOCALDNS_TIMEOUT);
            } catch (InterruptedException e2) {
                LogTools.printWarning(TAG, e2);
            }
            LogTools.printDebug(TAG, String.format(Locale.US, "handleDegradation, end, host: %s", str));
            if (atomicInteger.get() == -1) {
                LogTools.printDebug(TAG, String.format(Locale.US, "handleDegradation, requestLock timeout, host: %s", str));
                return 1;
            }
            return atomicInteger.get();
        }
    }

    private void handleDnsAsync(final String str, final String str2, final NetStatusInfo netStatusInfo) {
        ThreadInfo threadInfo = new ThreadInfo("HttpDNS-" + netStatusInfo.getNetStatusID() + "-" + str);
        threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.9
            @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
            public void handleOper(String str3) {
                DnsResolveFlow.this.judgeUpdateHost(str, DnsResolveFlow.this.handleDnsSync(str, str2, netStatusInfo), IpVersionController.getInstance().getHttpDNSFromCache(GlobalTools.APP_CONTEXT, netStatusInfo, str, new DnsInfo()));
            }
        });
        ThreadPoolMgr.getInstance().addTask(threadInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    private int[] handleDnsCache(String str, DnsResultInfo dnsResultInfo, NetStatusInfo netStatusInfo, String str2, int i2, boolean z) {
        ?? r12;
        DnsInfo dnsInfo = new DnsInfo();
        int httpDNSFromCache = IpVersionController.getInstance().getHttpDNSFromCache(GlobalTools.APP_CONTEXT, netStatusInfo, str2, dnsInfo);
        StatisticInfo statisticInfo = StatisticMgr.getInstance().getStatisticInfo(str);
        if (httpDNSFromCache == 0) {
            boolean isExpired = isExpired(dnsInfo.getEndTime());
            if (dnsInfo.getIps().size() == 0) {
                dnsResultInfo.mErrorCode = 6;
                dnsResultInfo.mDataSource = 0;
                dnsResultInfo.mIps = new String[0];
                r12 = isExpired;
            } else if (!z && isExpired) {
                dnsResultInfo.mErrorCode = 2;
                r12 = isExpired;
            } else {
                dnsResultInfo.mErrorCode = 0;
                if (i2 == 0) {
                    dnsResultInfo.mDataSource = 3;
                } else {
                    dnsResultInfo.mDataSource = 1;
                }
                Map<Integer, List<String>> filterIpVer = IpVersionController.filterIpVer(dnsInfo.getIps());
                String[] strArr = new String[0];
                String[] strArr2 = new String[0];
                List<String> list = filterIpVer.get(6);
                if (list != null && !list.isEmpty()) {
                    strArr2 = (String[]) list.toArray(new String[0]);
                }
                List<String> list2 = filterIpVer.get(4);
                if (list2 != null && !list2.isEmpty()) {
                    strArr = (String[]) list2.toArray(new String[0]);
                }
                if (netStatusInfo.getNetworkStatus().canV6() && strArr2 != null && strArr2.length > 0) {
                    dnsResultInfo.mIps = strArr2;
                } else {
                    dnsResultInfo.mIps = strArr;
                }
                dnsResultInfo.mIpsV4 = strArr;
                dnsResultInfo.mIpsV6 = strArr2;
                statisticInfo.cacheType = isExpired ? 2 : 1;
                statisticInfo.uip = dnsInfo.getUip();
                r12 = isExpired;
            }
        } else {
            r12 = 1;
        }
        if (dnsResultInfo.mErrorCode != 0) {
            if (IpVersionController.getInstance().getLocalDNSFromCache(str2, dnsInfo) == 0) {
                dnsResultInfo.mErrorCode = 0;
                dnsResultInfo.mDataSource = 4;
                dnsResultInfo.mIps = (String[]) dnsInfo.getIps().toArray(new String[0]);
                statisticInfo.cacheType = 3;
            } else {
                dnsResultInfo.mErrorCode = i2;
                dnsResultInfo.mDataSource = 0;
                dnsResultInfo.mIps = new String[0];
            }
        }
        return new int[]{httpDNSFromCache, r12};
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:62:0x01f4 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01ce A[Catch: all -> 0x01f4, TryCatch #1 {all -> 0x01f4, blocks: (B:60:0x01f2, B:41:0x01a3, B:50:0x01b5, B:52:0x01ce, B:53:0x01e8, B:55:0x01ea, B:56:0x01ee, B:49:0x01b0), top: B:64:0x00fe }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ea A[Catch: all -> 0x01f4, TryCatch #1 {all -> 0x01f4, blocks: (B:60:0x01f2, B:41:0x01a3, B:50:0x01b5, B:52:0x01ce, B:53:0x01e8, B:55:0x01ea, B:56:0x01ee, B:49:0x01b0), top: B:64:0x00fe }] */
    /* JADX WARN: Type inference failed for: r19v1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int handleHttpDNS(final NetStatusInfo netStatusInfo, final String[] strArr, final String str) {
        final AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        final String str2;
        final boolean z;
        final String str3;
        ThreadInfo threadInfo;
        DnsResolveFlow dnsResolveFlow;
        int i2;
        final int i3;
        int i4;
        final StatisticInfo statisticInfo;
        StatisticInfo statisticInfo2;
        ArrayList<String> arrayList;
        NetworkStatus networkStatus = netStatusInfo.getNetworkStatus();
        int i5 = 3;
        int i6 = 2;
        LogTools.printDebug(TAG, String.format(Locale.US, "handleHttpDNS, start, network: %s, host: %s, requestId: %s", networkStatus.toString(), Arrays.toString(strArr), str));
        ArrayList<String> bestServerIPCache = IpVersionController.getInstance().getBestServerIPCache(networkStatus);
        i5 = (networkStatus.canV6() && networkStatus.canV4()) ? 2 : 2;
        LogTools.printDebug(TAG, String.format(Locale.US, "handleHttpDNS, minSrvIp: %d, best: %s", Integer.valueOf(i5), bestServerIPCache.toString()));
        if (bestServerIPCache.size() < i5) {
            if (netStatusInfo.isKnowIsp()) {
                bestServerIPCache = IpVersionController.getInstance().getServerIPByKnownISP(GlobalTools.APP_CONTEXT, netStatusInfo.getIsp(), networkStatus);
            } else {
                bestServerIPCache = IpVersionController.getInstance().getServerIPByUnKnownISP(GlobalTools.APP_CONTEXT, networkStatus);
            }
            LogTools.printDebug(TAG, String.format(Locale.US, "handleHttpDNS, cache: %s", bestServerIPCache.toString()));
        }
        ArrayList<String> arrayList2 = bestServerIPCache;
        if (arrayList2.size() == 0) {
            LogTools.printError(TAG, "request HttpDns no ServerIp");
            return 8;
        }
        LogTools.printDebug(TAG, String.format(Locale.US, "handleHttpDNS, list: %s", arrayList2.toString()));
        StatisticInfo statisticInfo3 = StatisticMgr.getInstance().getStatisticInfo(str);
        statisticInfo3.setSrvIp(arrayList2);
        StringBuilder sb = new StringBuilder();
        sb.append(PreferencesUtil.LEFT_MOUNT);
        sb.append(netStatusInfo.getNetStatusID());
        Object obj = "] ";
        sb.append("] ");
        sb.append(networkStatus.toString());
        sb.append("");
        statisticInfo3.network = sb.toString();
        Object atomicInteger3 = new AtomicInteger(-1);
        final AtomicInteger atomicInteger4 = new AtomicInteger(arrayList2.size());
        int i7 = GlobalTools.HTTPS_LEVEL;
        synchronized (atomicInteger3) {
            int i8 = 0;
            Object obj2 = obj;
            while (i8 < arrayList2.size()) {
                try {
                    try {
                        str2 = arrayList2.get(i8);
                        if (i7 == i6) {
                            z = true;
                        } else if (i7 == 1) {
                            z = i8 >= arrayList2.size() / i6;
                        } else {
                            z = false;
                        }
                        str3 = "HttpDNS-" + netStatusInfo.getNetStatusID() + "-" + str2 + "-" + IPTools.hosts2String(strArr);
                        threadInfo = new ThreadInfo(str3);
                        dnsResolveFlow = this;
                        i2 = i8;
                        i3 = i7;
                        i4 = i7;
                        atomicInteger = atomicInteger3;
                        statisticInfo = statisticInfo3;
                        statisticInfo2 = statisticInfo3;
                        arrayList = arrayList2;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obj2 = atomicInteger3;
                }
                try {
                    threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.4
                        @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                        public void handleOper(String str4) {
                            LogTools.printDebug(DnsResolveFlow.TAG, String.format(Locale.US, "handleHttpDNS.handleOper, HttpDns thread[%s], serverIp: %s, is_https: %b, httpsLevel: %d, requestId: %s", str3, str2, Boolean.valueOf(z), Integer.valueOf(i3), str));
                            long uptimeMillis = SystemClock.uptimeMillis();
                            String[] requestHttpDnsV2 = HttpDNSProtocolMgr.requestHttpDnsV2(strArr, str2, false, z, str);
                            if (requestHttpDnsV2 != null && "200".equals(requestHttpDnsV2[0])) {
                                synchronized (atomicInteger) {
                                    long uptimeMillis2 = SystemClock.uptimeMillis();
                                    LogTools.printDebug(DnsResolveFlow.TAG, String.format(Locale.US, "HttpDns succeed response serverIp: %s, requestId: %s", str2, str));
                                    ResInfo resInfo = new ResInfo();
                                    resInfo.setNetInfo(netStatusInfo);
                                    HttpDNSProtocolMgr.responseProtocolV2(requestHttpDnsV2[1], resInfo, IpVersionController.tellIpVer(str2));
                                    if (resInfo.getStatus() != 0 && resInfo.getStatus() != 6) {
                                        if (atomicInteger4.decrementAndGet() == 0) {
                                            atomicInteger.compareAndSet(-1, resInfo.getStatus());
                                            LogTools.printDebug(DnsResolveFlow.TAG, String.format(Locale.US, "handleHttpDNS.handleOper result, requestLock notifyAll(3), HttpDns thread[%s], serverIp: %s, requestId: %s", str3, str2, str));
                                            atomicInteger.notifyAll();
                                        }
                                    }
                                    statisticInfo.httpErrCode = 0;
                                    statisticInfo.httpErrMsg = "success";
                                    long j = uptimeMillis2 - uptimeMillis;
                                    atomicInteger.compareAndSet(-1, resInfo.getStatus());
                                    if (resInfo.getStatus() == 6 && resInfo.getDns() != null) {
                                        for (DnsInfo dnsInfo : resInfo.getDns().values()) {
                                            if (dnsInfo.getIps().isEmpty()) {
                                                dnsInfo.setTtl(31536000);
                                                dnsInfo.setStatus(6);
                                            }
                                        }
                                    }
                                    IpVersionController.getInstance().putHttpDNSIntoCache(GlobalTools.APP_CONTEXT, resInfo);
                                    ServerIPInfo serverIPInfo = new ServerIPInfo();
                                    serverIPInfo.setIp(str2);
                                    serverIPInfo.setScore(j);
                                    IpVersionController.getInstance().resetBestServerIPCache(serverIPInfo);
                                    if (resInfo.getHttpdns().isRe()) {
                                        QualityDetectFlow.getInstance().addReportData(GlobalTools.HTTPDNS_REPORT_HOST, str2, j);
                                    }
                                    if (ServerIPMgr.getInstance().canUpdate(GlobalTools.APP_CONTEXT, resInfo.getHttpdns().getVer())) {
                                        ServerIPMgr.getInstance().updateServerIP(GlobalTools.APP_CONTEXT, str2);
                                    }
                                    ActiveRefreshController.getInstance();
                                    ActiveRefreshController.refreshHostCache(resInfo);
                                    LogTools.printDebug(DnsResolveFlow.TAG, String.format(Locale.US, "handleHttpDNS.handleOper result, requestLock notifyAll(2), HttpDns thread[%s], serverIp: %s, requestId: %s", str3, str2, str));
                                    atomicInteger.notifyAll();
                                }
                                return;
                            }
                            LogTools.printDebug(DnsResolveFlow.TAG, String.format(Locale.US, "handleHttpDNS.handleOper, httpdns parse error, HttpDns thread[%s], serverIp: %s, requestId: %s", str3, str2, str));
                            if (requestHttpDnsV2 != null) {
                                try {
                                    statisticInfo.httpErrCode = Integer.parseInt(requestHttpDnsV2[0]);
                                } catch (Exception e2) {
                                    LogTools.printWarning(DnsResolveFlow.TAG, e2);
                                }
                                statisticInfo.httpErrMsg = requestHttpDnsV2[1];
                            } else {
                                StatisticInfo statisticInfo4 = statisticInfo;
                                statisticInfo4.httpErrCode = BannerFocusImageViewGroup.f23778f;
                                statisticInfo4.httpErrMsg = "result is null";
                            }
                            if (atomicInteger4.decrementAndGet() == 0) {
                                atomicInteger.compareAndSet(-1, statisticInfo.httpErrCode);
                                synchronized (atomicInteger) {
                                    LogTools.printDebug(DnsResolveFlow.TAG, String.format(Locale.US, "handleHttpDNS.handleOper, requestLock notifyAll(1), HttpDns thread[%s], serverIp: %s, requestId: %s", str3, str2, str));
                                    atomicInteger.notifyAll();
                                }
                            }
                        }
                    });
                    ThreadPoolMgr.getInstance().addTask(threadInfo);
                    i8 = i2 + 1;
                    i7 = i4;
                    atomicInteger3 = atomicInteger;
                    statisticInfo3 = statisticInfo2;
                    arrayList2 = arrayList;
                    i6 = 2;
                    obj2 = dnsResolveFlow;
                } catch (Throwable th3) {
                    th = th3;
                    obj2 = atomicInteger;
                    throw th;
                }
            }
            atomicInteger = atomicInteger3;
            StatisticInfo statisticInfo4 = statisticInfo3;
            try {
                LogTools.printDebug(TAG, String.format(Locale.US, "handleHttpDNS, requestLock wait, requestId: %s", str));
                atomicInteger2 = atomicInteger;
            } catch (InterruptedException e2) {
                e = e2;
                atomicInteger2 = atomicInteger;
            }
            try {
                atomicInteger2.wait(GlobalTools.HTTPDNS_TIMEOUT);
            } catch (InterruptedException e3) {
                e = e3;
                LogTools.printWarning(TAG, e);
                LogTools.printDebug(TAG, String.format(Locale.US, "handleHttpDNS, end, requestId: %s", str));
                if (atomicInteger2.get() != -1) {
                }
            }
            LogTools.printDebug(TAG, String.format(Locale.US, "handleHttpDNS, end, requestId: %s", str));
            if (atomicInteger2.get() != -1) {
                LogTools.printWarning(TAG, String.format(Locale.US, "handleHttpDNS, requestLock timeout, requestId: %s", str));
                statisticInfo4.httpErrCode = 1;
                statisticInfo4.httpErrMsg = "all httpdns request timeout";
                return 1;
            }
            int i9 = atomicInteger2.get();
            return i9;
        }
    }

    private int handleLocalDNS(final String str) {
        ThreadInfo threadInfo = new ThreadInfo("LocalDNS-" + str);
        threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.3
            @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
            public void handleOper(String str2) {
                DnsInfo requestProtocol = LocalDNSProtocolMgr.requestProtocol(str);
                if (requestProtocol != null) {
                    NetStatusInfo networkInfo = DeviceMgr.getNetworkInfo(GlobalTools.APP_CONTEXT);
                    requestProtocol.setNt(networkInfo.getNetType());
                    DnsInfo dnsInfo = new DnsInfo();
                    if (IpVersionController.getInstance().getHttpDNSFromCache(GlobalTools.APP_CONTEXT, networkInfo, str, dnsInfo) == 0) {
                        requestProtocol.setUip(dnsInfo.getUip());
                    }
                    requestProtocol.setEndTime(System.currentTimeMillis() + 600000);
                    IpVersionController.getInstance().putLocalDNSIntoCache(requestProtocol);
                    return;
                }
                LogTools.printError(DnsResolveFlow.TAG, "local parse error");
            }
        });
        ThreadPoolMgr.getInstance().addTask(threadInfo);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTTL() {
        List<ResultTB> resultByNetworkHost;
        if (!GlobalTools.IS_BACKGOUND_MODEL && SwitchController.getInstance().switchGslb()) {
            DBAccessMgr dBAccessMgr = DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT);
            final NetStatusInfo netStatusInfo = new NetStatusInfo();
            netStatusInfo.resetVal(DeviceMgr.getNetworkInfo(GlobalTools.APP_CONTEXT));
            DataCacheMgr.INSTANCE.setCachedNetStateInfo(netStatusInfo);
            if (netStatusInfo.getNetType() == 0) {
                return;
            }
            final HashSet hashSet = new HashSet();
            List<HostTB> allHost = dBAccessMgr.getAllHost();
            String netStatusID = netStatusInfo.getNetStatusID();
            for (HostTB hostTB : allHost) {
                if (isHostDead(hostTB.getInsertTime())) {
                    dBAccessMgr.delHost(hostTB);
                    IpVersionController.getInstance().delResultByHost(hostTB.getHost());
                } else {
                    if ((netStatusInfo.getNetworkStatus() == null || netStatusInfo.getNetworkStatus().canV4()) && (resultByNetworkHost = IpVersionController.getInstance().getResultByNetworkHost(netStatusID, hostTB.getHost(), 1)) != null && !resultByNetworkHost.isEmpty()) {
                        ResultTB resultTB = resultByNetworkHost.get(0);
                        if (isNearlyExpired(resultTB.getEndTime())) {
                            hashSet.add(resultTB.getHost());
                            LogTools.printDebug(TAG, String.format(Locale.US, "result %s ttl Nearly Expired, ipv4", resultTB.getHost()));
                            if (hashSet.size() >= 10) {
                                break;
                            }
                        }
                    }
                    if (netStatusInfo.getNetworkStatus() == null || netStatusInfo.getNetworkStatus().canV6()) {
                        List<ResultTB> resultByNetworkHost2 = IpVersionController.getInstance().getResultByNetworkHost(netStatusID, hostTB.getHost(), 2);
                        if (resultByNetworkHost2 != null && !resultByNetworkHost2.isEmpty()) {
                            ResultTB resultTB2 = resultByNetworkHost2.get(0);
                            if (isNearlyExpired(resultTB2.getEndTime())) {
                                hashSet.add(resultTB2.getHost());
                                LogTools.printDebug(TAG, String.format(Locale.US, "result %s ttl Nearly Expired, ipv6", resultTB2.getHost()));
                                if (hashSet.size() >= 10) {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
            }
            if (hashSet.isEmpty()) {
                return;
            }
            ThreadInfo threadInfo = new ThreadInfo("HttpDNS-TTL-Update-" + String.valueOf(System.currentTimeMillis()));
            threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.1
                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                public void handleOper(String str) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    Set set = hashSet;
                    String createRequestId = DnsResolveFlow.this.createRequestId();
                    final StatisticInfo statisticInfo = new StatisticInfo();
                    StatisticMgr.getInstance().setStatisticInfo(createRequestId, statisticInfo);
                    statisticInfo.requestId = createRequestId;
                    statisticInfo.host = TextUtils.join("|", (String[]) set.toArray(new String[set.size()]));
                    statisticInfo.async = 0;
                    statisticInfo.netType = netStatusInfo.getNetType();
                    statisticInfo.http = 1;
                    statisticInfo.cacheType = 4;
                    DnsResolveFlow dnsResolveFlow = DnsResolveFlow.this;
                    NetStatusInfo netStatusInfo2 = netStatusInfo;
                    Set set2 = hashSet;
                    dnsResolveFlow.handleHttpDNS(netStatusInfo2, (String[]) set2.toArray(new String[set2.size()]), createRequestId);
                    statisticInfo.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                    if (StatisticMgr.getInstance().getStatistic() != null) {
                        ThreadInfo threadInfo2 = new ThreadInfo("Statistic");
                        threadInfo2.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.1.1
                            @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                            public void handleOper(String str2) {
                                StatisticMgr.getInstance().removeStatisticInfo(statisticInfo.requestId);
                                StatisticMgr.getInstance().onStatistic(statisticInfo.toMap());
                            }
                        });
                        StatisticMgr.getInstance().addTask(threadInfo2);
                    }
                }
            });
            ThreadPoolMgr.getInstance().addTask(threadInfo);
        }
    }

    private boolean isDead(long j) {
        return System.currentTimeMillis() >= j + ((long) (GlobalTools.TTL_LIVE_SECOND * 1000));
    }

    private boolean isExpired(long j) {
        return System.currentTimeMillis() >= j;
    }

    private boolean isHostDead(long j) {
        return System.currentTimeMillis() >= j + ((long) (GlobalTools.TTL_HOST_ALIVE_SECOND * 1000));
    }

    private boolean isNearlyExpired(long j) {
        return j - System.currentTimeMillis() < ((long) GlobalTools.TTL_NEARLY_EXPIRED_TIME_SPAN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void judgeUpdateHost(String str, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            updateHostList(arrayList, false);
        }
    }

    private int synUpdateHostList(ArrayList<String> arrayList, boolean z) {
        if (GlobalTools.APP_CONTEXT == null) {
            return 5;
        }
        long currentTimeMillis = System.currentTimeMillis();
        DBAccessMgr dBAccessMgr = DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            List<HostTB> hostByHost = dBAccessMgr.getHostByHost(next);
            if (hostByHost.isEmpty()) {
                HostTB hostTB = new HostTB();
                hostTB.setHost(next);
                hostTB.setInsertTime(currentTimeMillis);
                hostTB.setIsPre(z ? 1 : 0);
                dBAccessMgr.addHost(hostTB);
            } else {
                HostTB hostTB2 = hostByHost.get(0);
                hostTB2.setInsertTime(currentTimeMillis);
                hostTB2.setIsPre(z ? 1 : 0);
                dBAccessMgr.updateHost(hostTB2);
            }
        }
        List<HostTB> allHost = dBAccessMgr.getAllHost();
        int size = allHost.size();
        while (true) {
            size--;
            if (size >= GlobalTools.KEEP_HOST_NUM) {
                dBAccessMgr.delHost(allHost.get(size));
            } else {
                allHost.clear();
                return 0;
            }
        }
    }

    public synchronized int beginNetworkMonitor() {
        if (GlobalTools.APP_CONTEXT != null) {
            if (this.mNetStatusReceiver == null) {
                this.mNetStatusReceiver = new NetStatusReceiver(new NetStatusReceiver.ChangeNetworkInter() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.6
                    @Override // com.yy.gslbsdk.device.NetStatusReceiver.ChangeNetworkInter
                    public void onNetStateChanged() {
                        AsynTaskMgr.INSTANCE.postDelayed(DnsResolveFlow.this.mRunnable, 2000L);
                    }
                });
            }
            this.mNetStatusReceiver.register(GlobalTools.APP_CONTEXT);
            LogTools.printDebug(TAG, "beginNetworkMonitor...");
            return 0;
        }
        return 5;
    }

    public synchronized int beginTTLMonitor() {
        if (GlobalTools.APP_CONTEXT != null) {
            TimerTaskInfo timerTaskInfo = new TimerTaskInfo();
            timerTaskInfo.setTaskName(GlobalTools.TTL_MONITOR_NAME);
            timerTaskInfo.setWorker(new TimerTask() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.7
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    DnsResolveFlow.this.handleTTL();
                }
            });
            TimerMgr.getInstance().addWorker(timerTaskInfo, 0L, GlobalTools.TTL_MONITOR_PERIOD);
            LogTools.printDebug(TAG, "beginTTLMonitor...");
            return 0;
        }
        return 5;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DnsResultInfo handleDNS(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        String str2;
        String str3;
        String str4;
        long j;
        int i2;
        long uptimeMillis = SystemClock.uptimeMillis();
        DataCacheMgr.INSTANCE.addInvokeApiNum(str);
        String trim = str.trim();
        String createRequestId = createRequestId();
        final StatisticInfo statisticInfo = new StatisticInfo();
        StatisticMgr.getInstance().setStatisticInfo(createRequestId, statisticInfo);
        statisticInfo.requestId = createRequestId;
        statisticInfo.host = trim;
        statisticInfo.async = z2 ? 1 : 0;
        NetStatusInfo cachedNetStatusInfo = DataCacheMgr.INSTANCE.getCachedNetStatusInfo();
        DnsResultInfo dnsResultInfo = new DnsResultInfo();
        if (trim != null) {
            try {
                if (!"".equals(trim.trim())) {
                    if (GlobalTools.APP_CONTEXT == null) {
                        collectStat0(uptimeMillis, dnsResultInfo);
                        statisticInfo.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                        if (dnsResultInfo.mErrorCode == 0) {
                            statisticInfo.rsIp.addAll(Arrays.asList(dnsResultInfo.mIps));
                            statisticInfo.rsIpV4.addAll(Arrays.asList(dnsResultInfo.mIpsV4));
                            statisticInfo.rsIpV6.addAll(Arrays.asList(dnsResultInfo.mIpsV6));
                        }
                        if (StatisticMgr.getInstance().getStatistic() != null) {
                            ThreadInfo threadInfo = new ThreadInfo("Statistic");
                            threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.8
                                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                public void handleOper(String str5) {
                                    StatisticMgr.getInstance().removeStatisticInfo(statisticInfo.requestId);
                                    StatisticMgr.getInstance().onStatistic(statisticInfo.toMap());
                                }
                            });
                            StatisticMgr.getInstance().addTask(threadInfo, 5000L);
                        }
                        return dnsResultInfo;
                    } else if (z && z5) {
                        deleteHost(trim);
                        handleDegradation(trim, dnsResultInfo);
                        collectStat0(uptimeMillis, dnsResultInfo);
                        statisticInfo.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                        if (dnsResultInfo.mErrorCode == 0) {
                            statisticInfo.rsIp.addAll(Arrays.asList(dnsResultInfo.mIps));
                            statisticInfo.rsIpV4.addAll(Arrays.asList(dnsResultInfo.mIpsV4));
                            statisticInfo.rsIpV6.addAll(Arrays.asList(dnsResultInfo.mIpsV6));
                        }
                        if (StatisticMgr.getInstance().getStatistic() != null) {
                            ThreadInfo threadInfo2 = new ThreadInfo("Statistic");
                            threadInfo2.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.8
                                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                public void handleOper(String str5) {
                                    StatisticMgr.getInstance().removeStatisticInfo(statisticInfo.requestId);
                                    StatisticMgr.getInstance().onStatistic(statisticInfo.toMap());
                                }
                            });
                            StatisticMgr.getInstance().addTask(threadInfo2, 5000L);
                        }
                        return dnsResultInfo;
                    } else {
                        if (z4) {
                            str3 = createRequestId;
                            str4 = "Statistic";
                            j = 5000;
                            i2 = 0;
                        } else {
                            boolean enableExpired = TtlController.getInstance().enableExpired();
                            str3 = createRequestId;
                            str4 = "Statistic";
                            try {
                                int[] handleDnsCache = handleDnsCache(createRequestId, dnsResultInfo, cachedNetStatusInfo, trim, 2, enableExpired || (z2 && z3));
                                i2 = 0;
                                int i3 = handleDnsCache[0];
                                boolean z6 = handleDnsCache[1] == 1;
                                if (z2) {
                                    if (i3 == 0 && dnsResultInfo.mIps != null && dnsResultInfo.mIps.length >= 1) {
                                        if (z6) {
                                            ExternalCache.getInstance().getResult(trim, 8, dnsResultInfo);
                                        }
                                    }
                                    ExternalCache.getInstance().getResult(trim, 4, dnsResultInfo);
                                }
                                if (i3 == 0 && (enableExpired || !z6)) {
                                    collectStat0(uptimeMillis, dnsResultInfo);
                                    statisticInfo.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                                    if (dnsResultInfo.mErrorCode == 0) {
                                        statisticInfo.rsIp.addAll(Arrays.asList(dnsResultInfo.mIps));
                                        statisticInfo.rsIpV4.addAll(Arrays.asList(dnsResultInfo.mIpsV4));
                                        statisticInfo.rsIpV6.addAll(Arrays.asList(dnsResultInfo.mIpsV6));
                                    }
                                    if (StatisticMgr.getInstance().getStatistic() != null) {
                                        ThreadInfo threadInfo3 = new ThreadInfo(str4);
                                        threadInfo3.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.8
                                            @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                            public void handleOper(String str5) {
                                                StatisticMgr.getInstance().removeStatisticInfo(statisticInfo.requestId);
                                                StatisticMgr.getInstance().onStatistic(statisticInfo.toMap());
                                            }
                                        });
                                        StatisticMgr.getInstance().addTask(threadInfo3, 5000L);
                                    }
                                    return dnsResultInfo;
                                }
                                j = 5000;
                            } catch (Throwable th) {
                                th = th;
                                str2 = str4;
                                collectStat0(uptimeMillis, dnsResultInfo);
                                statisticInfo.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                                if (dnsResultInfo.mErrorCode == 0) {
                                }
                                if (StatisticMgr.getInstance().getStatistic() != null) {
                                }
                                throw th;
                            }
                        }
                        if (!z2) {
                            String str5 = str3;
                            if (z3) {
                                LogTools.printError(TAG, String.format(Locale.US, "enableExpiredIp is valid only in asynchronous function! ", new Object[i2]));
                            }
                            int handleDnsSync = handleDnsSync(trim, str5, cachedNetStatusInfo);
                            String str6 = str4;
                            try {
                                int[] handleDnsCache2 = handleDnsCache(str5, dnsResultInfo, cachedNetStatusInfo, trim, handleDnsSync, false);
                                int i4 = handleDnsCache2[0];
                                int i5 = handleDnsCache2[1];
                                if (z4 && (handleDnsSync != 0 || dnsResultInfo.mDataSource != 3)) {
                                    LogTools.printError(TAG, String.format(Locale.US, "force fresh failed! host: %s, codeHttp: %d, dataSource: %d", trim, Integer.valueOf(handleDnsSync), Integer.valueOf(dnsResultInfo.mDataSource)));
                                    dnsResultInfo.mErrorCode = handleDnsSync;
                                    dnsResultInfo.mDataSource = 0;
                                    dnsResultInfo.mIps = new String[0];
                                    dnsResultInfo.mIpsV6 = new String[0];
                                    dnsResultInfo.mIpsV4 = new String[0];
                                    statisticInfo.cacheType = 0;
                                    collectStat0(uptimeMillis, dnsResultInfo);
                                    statisticInfo.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                                    if (dnsResultInfo.mErrorCode == 0) {
                                        statisticInfo.rsIp.addAll(Arrays.asList(dnsResultInfo.mIps));
                                        statisticInfo.rsIpV4.addAll(Arrays.asList(dnsResultInfo.mIpsV4));
                                        statisticInfo.rsIpV6.addAll(Arrays.asList(dnsResultInfo.mIpsV6));
                                    }
                                    if (StatisticMgr.getInstance().getStatistic() != null) {
                                        ThreadInfo threadInfo4 = new ThreadInfo(str6);
                                        threadInfo4.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.8
                                            @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                            public void handleOper(String str52) {
                                                StatisticMgr.getInstance().removeStatisticInfo(statisticInfo.requestId);
                                                StatisticMgr.getInstance().onStatistic(statisticInfo.toMap());
                                            }
                                        });
                                        StatisticMgr.getInstance().addTask(threadInfo4, 5000L);
                                    }
                                    return dnsResultInfo;
                                }
                                str2 = str6;
                                if (handleDnsSync == 0 && i4 != 0) {
                                    try {
                                        LogTools.printDebug(TAG, String.format(Locale.US, "%s not support by gslb", trim));
                                    } catch (Throwable th2) {
                                        th = th2;
                                        collectStat0(uptimeMillis, dnsResultInfo);
                                        statisticInfo.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                                        if (dnsResultInfo.mErrorCode == 0) {
                                            statisticInfo.rsIp.addAll(Arrays.asList(dnsResultInfo.mIps));
                                            statisticInfo.rsIpV4.addAll(Arrays.asList(dnsResultInfo.mIpsV4));
                                            statisticInfo.rsIpV6.addAll(Arrays.asList(dnsResultInfo.mIpsV6));
                                        }
                                        if (StatisticMgr.getInstance().getStatistic() != null) {
                                            ThreadInfo threadInfo5 = new ThreadInfo(str2);
                                            threadInfo5.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.8
                                                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                                public void handleOper(String str52) {
                                                    StatisticMgr.getInstance().removeStatisticInfo(statisticInfo.requestId);
                                                    StatisticMgr.getInstance().onStatistic(statisticInfo.toMap());
                                                }
                                            });
                                            StatisticMgr.getInstance().addTask(threadInfo5, 5000L);
                                        }
                                        throw th;
                                    }
                                }
                                if (dnsResultInfo.mDataSource == 0 && z5) {
                                    handleLocalDNS(trim);
                                }
                                if (i4 != 0 || dnsResultInfo.mIps == null || dnsResultInfo.mIps.length < 1) {
                                    ExternalCache.getInstance().getResult(trim, 2, dnsResultInfo);
                                }
                                judgeUpdateHost(trim, handleDnsSync, i4);
                            } catch (Throwable th3) {
                                th = th3;
                                str2 = str6;
                            }
                        } else if (z4) {
                            LogTools.printError(TAG, String.format(Locale.US, "force refresh is valid only in synchronous function! ", new Object[i2]));
                            dnsResultInfo.mErrorCode = 5;
                            collectStat0(uptimeMillis, dnsResultInfo);
                            statisticInfo.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                            if (dnsResultInfo.mErrorCode == 0) {
                                statisticInfo.rsIp.addAll(Arrays.asList(dnsResultInfo.mIps));
                                statisticInfo.rsIpV4.addAll(Arrays.asList(dnsResultInfo.mIpsV4));
                                statisticInfo.rsIpV6.addAll(Arrays.asList(dnsResultInfo.mIpsV6));
                            }
                            if (StatisticMgr.getInstance().getStatistic() != null) {
                                ThreadInfo threadInfo6 = new ThreadInfo(str4);
                                threadInfo6.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.8
                                    @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                    public void handleOper(String str52) {
                                        StatisticMgr.getInstance().removeStatisticInfo(statisticInfo.requestId);
                                        StatisticMgr.getInstance().onStatistic(statisticInfo.toMap());
                                    }
                                });
                                StatisticMgr.getInstance().addTask(threadInfo6, j);
                            }
                            return dnsResultInfo;
                        } else {
                            if (z5) {
                                handleLocalDNS(trim);
                            }
                            handleDnsAsync(trim, str3, cachedNetStatusInfo);
                            str2 = str4;
                        }
                        collectStat0(uptimeMillis, dnsResultInfo);
                        statisticInfo.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                        if (dnsResultInfo.mErrorCode == 0) {
                            statisticInfo.rsIp.addAll(Arrays.asList(dnsResultInfo.mIps));
                            statisticInfo.rsIpV4.addAll(Arrays.asList(dnsResultInfo.mIpsV4));
                            statisticInfo.rsIpV6.addAll(Arrays.asList(dnsResultInfo.mIpsV6));
                        }
                        if (StatisticMgr.getInstance().getStatistic() != null) {
                            ThreadInfo threadInfo7 = new ThreadInfo(str2);
                            threadInfo7.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.8
                                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                public void handleOper(String str52) {
                                    StatisticMgr.getInstance().removeStatisticInfo(statisticInfo.requestId);
                                    StatisticMgr.getInstance().onStatistic(statisticInfo.toMap());
                                }
                            });
                            StatisticMgr.getInstance().addTask(threadInfo7, 5000L);
                        }
                        return dnsResultInfo;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                str2 = "Statistic";
            }
        }
        collectStat0(uptimeMillis, dnsResultInfo);
        statisticInfo.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
        if (dnsResultInfo.mErrorCode == 0) {
            statisticInfo.rsIp.addAll(Arrays.asList(dnsResultInfo.mIps));
            statisticInfo.rsIpV4.addAll(Arrays.asList(dnsResultInfo.mIpsV4));
            statisticInfo.rsIpV6.addAll(Arrays.asList(dnsResultInfo.mIpsV6));
        }
        if (StatisticMgr.getInstance().getStatistic() != null) {
            ThreadInfo threadInfo8 = new ThreadInfo("Statistic");
            threadInfo8.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.8
                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                public void handleOper(String str52) {
                    StatisticMgr.getInstance().removeStatisticInfo(statisticInfo.requestId);
                    StatisticMgr.getInstance().onStatistic(statisticInfo.toMap());
                }
            });
            StatisticMgr.getInstance().addTask(threadInfo8, 5000L);
        }
        return dnsResultInfo;
    }

    public int handleDnsSync(String str, String str2, NetStatusInfo netStatusInfo) {
        return handleDnsSync(new String[]{str}, str2, netStatusInfo);
    }

    public int handleHttpDNSIgnoreCache(NetStatusInfo netStatusInfo, String[] strArr, ResInfo resInfo, boolean z) {
        String str;
        ArrayList<String> bestServerIPCache = IpVersionController.getInstance().getBestServerIPCache(netStatusInfo.getNetworkStatus());
        if (bestServerIPCache.isEmpty()) {
            str = IpVersionController.getInstance().getOneServerIPByUnKnownISP(GlobalTools.APP_CONTEXT, netStatusInfo.getNetworkStatus());
        } else {
            str = bestServerIPCache.get(0);
        }
        if (str == null) {
            LogTools.printDebug(TAG, "ServerIP is NULL");
            return 8;
        }
        String[] requestHttpDnsV2 = HttpDNSProtocolMgr.requestHttpDnsV2(strArr, str, z);
        if (requestHttpDnsV2 != null) {
            HttpDNSProtocolMgr.responseProtocolV2(requestHttpDnsV2[1], resInfo, IpVersionController.tellIpVer(str));
        }
        return resInfo.getStatus();
    }

    public synchronized int stopNetworkMonitor() {
        if (GlobalTools.APP_CONTEXT != null) {
            if (this.mNetStatusReceiver != null) {
                this.mNetStatusReceiver.unregister(GlobalTools.APP_CONTEXT);
            }
            return 0;
        }
        return 5;
    }

    public void updateHostList(ArrayList<String> arrayList, boolean z) {
        AsynTaskMgr.INSTANCE.updateHost(arrayList, z);
    }

    public int handleDnsSync(String[] strArr, String str, NetStatusInfo netStatusInfo) {
        AtomicBoolean atomicBoolean;
        AtomicInteger atomicInteger;
        int i2;
        String str2 = TextUtils.join(",", strArr) + netStatusInfo.getNetStatusID();
        StatisticInfo statisticInfo = StatisticMgr.getInstance().getStatisticInfo(str);
        LogTools.printDebug(TAG, String.format(Locale.US, "handleDnsSync, start, key: %s, requestId: %s", str2, str));
        synchronized (this.mPendingReqs) {
            atomicBoolean = this.mPendingReqs.get(str2);
            if (atomicBoolean == null) {
                atomicBoolean = new AtomicBoolean(false);
                this.mPendingReqs.putIfAbsent(str2, atomicBoolean);
            }
            atomicInteger = this.mPendingHttpCode.get(str2);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger(2);
                this.mPendingHttpCode.putIfAbsent(str2, atomicInteger);
            }
        }
        if (atomicBoolean.compareAndSet(false, true)) {
            i2 = handleHttpDNS(netStatusInfo, strArr, str);
            statisticInfo.http = 1;
            atomicInteger.set(i2);
            atomicBoolean.set(false);
            this.mPendingHttpCode.remove(str2);
            this.mPendingReqs.remove(str2);
            synchronized (atomicBoolean) {
                LogTools.printDebug(TAG, String.format(Locale.US, "handleDnsSync, req notifyAll, key: %s, requestId: %s", str2, str));
                atomicBoolean.notifyAll();
            }
        } else {
            if (atomicBoolean.get()) {
                synchronized (atomicBoolean) {
                    try {
                        LogTools.printDebug(TAG, String.format(Locale.US, "handleDnsSync, req wait, key: %s, requestId: %s", str2, str));
                        atomicBoolean.wait(GlobalTools.HTTPDNS_TIMEOUT);
                    } catch (Exception unused) {
                    }
                }
            }
            statisticInfo.http = 2;
            i2 = atomicInteger.get();
        }
        LogTools.printDebug(TAG, String.format(Locale.US, "handleDnsSync, end, key: %s, requestId: %s, codeHttp: %d", str2, str, Integer.valueOf(i2)));
        return i2;
    }
}
