package com.yy.gslbsdk.flow;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
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
/* loaded from: classes8.dex */
public class DnsResolveFlow {
    public static final String TAG = "DnsResolveFlow";
    public static DnsResolveFlow mDnsResolveFlow;
    public AtomicInteger mIncreaseId = new AtomicInteger(1);
    public ConcurrentHashMap<String, AtomicBoolean> mPendingReqs = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, AtomicInteger> mPendingHttpCode = new ConcurrentHashMap<>();
    public NetStatusReceiver mNetStatusReceiver = null;
    public Runnable mRunnable = new Runnable() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.4
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

    public static DnsResolveFlow getInstance() {
        if (mDnsResolveFlow == null) {
            mDnsResolveFlow = new DnsResolveFlow();
        }
        return mDnsResolveFlow;
    }

    public synchronized int beginNetworkMonitor() {
        if (GlobalTools.APP_CONTEXT != null) {
            if (this.mNetStatusReceiver == null) {
                this.mNetStatusReceiver = new NetStatusReceiver(new NetStatusReceiver.ChangeNetworkInter() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.5
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

    public String createRequestId() {
        String identity = DataCacheMgr.INSTANCE.getIdentity(GlobalTools.APP_CONTEXT);
        return identity + "_" + System.currentTimeMillis() + "_" + this.mIncreaseId.getAndIncrement();
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

    private int handleLocalDNS(final String str) {
        ThreadInfo threadInfo = new ThreadInfo("LocalDNS-" + str);
        threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.2
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

    private boolean isDead(long j) {
        if (System.currentTimeMillis() >= j + (GlobalTools.TTL_LIVE_SECOND * 1000)) {
            return true;
        }
        return false;
    }

    private boolean isExpired(long j) {
        if (System.currentTimeMillis() >= j) {
            return true;
        }
        return false;
    }

    private boolean isHostDead(long j) {
        if (System.currentTimeMillis() >= j + (GlobalTools.TTL_HOST_ALIVE_SECOND * 1000)) {
            return true;
        }
        return false;
    }

    private boolean isNearlyExpired(long j) {
        if (j - System.currentTimeMillis() < GlobalTools.TTL_NEARLY_EXPIRED_TIME_SPAN) {
            return true;
        }
        return false;
    }

    private void collectStat0(long j, DnsResultInfo dnsResultInfo) {
        DataCacheMgr.INSTANCE.addDnsCost(SystemClock.uptimeMillis() - j);
        if (dnsResultInfo.mErrorCode != 0) {
            DataCacheMgr.INSTANCE.addFailedDnsCount();
        } else if (dnsResultInfo.mDataSource == 4) {
            DataCacheMgr.INSTANCE.addLocalDnsCount();
        }
    }

    public void updateHostList(ArrayList<String> arrayList, boolean z) {
        AsynTaskMgr.INSTANCE.updateHost(arrayList, z);
    }

    private int handleDegradation(final String str, final DnsResultInfo dnsResultInfo) {
        LogTools.printDebug(TAG, String.format(Locale.US, "handleDegradation, start, host: %s", str));
        final AtomicInteger atomicInteger = new AtomicInteger(-1);
        synchronized (atomicInteger) {
            final String str2 = "LocalDNS-" + str;
            ThreadInfo threadInfo = new ThreadInfo(str2);
            threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.1
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
            } catch (InterruptedException e) {
                LogTools.printWarning(TAG, e);
            }
            LogTools.printDebug(TAG, String.format(Locale.US, "handleDegradation, end, host: %s", str));
            if (atomicInteger.get() == -1) {
                LogTools.printDebug(TAG, String.format(Locale.US, "handleDegradation, requestLock timeout, host: %s", str));
                return 1;
            }
            return atomicInteger.get();
        }
    }

    private int synUpdateHostList(ArrayList<String> arrayList, boolean z) {
        if (GlobalTools.APP_CONTEXT != null) {
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
        } else {
            return 5;
        }
    }

    private void handleDnsAsync(final String str, final String str2, final NetStatusInfo netStatusInfo) {
        ThreadInfo threadInfo = new ThreadInfo("HttpDNS-" + netStatusInfo.getNetStatusID() + "-" + str);
        threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.8
            @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
            public void handleOper(String str3) {
                DnsResolveFlow.this.judgeUpdateHost(str, DnsResolveFlow.this.handleDnsSync(str, str2, netStatusInfo), IpVersionController.getInstance().getHttpDNSFromCache(GlobalTools.APP_CONTEXT, netStatusInfo, str, new DnsInfo()));
            }
        });
        ThreadPoolMgr.getInstance().addTask(threadInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void judgeUpdateHost(String str, int i, int i2) {
        if (i == 0 && i2 == 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            updateHostList(arrayList, false);
        }
    }

    public int handleDnsSync(String str, String str2, NetStatusInfo netStatusInfo) {
        return handleDnsSync(new String[]{str}, str2, netStatusInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    private int[] handleDnsCache(String str, DnsResultInfo dnsResultInfo, NetStatusInfo netStatusInfo, String str2, int i, boolean z) {
        ?? r14;
        int i2;
        DnsInfo dnsInfo = new DnsInfo();
        int httpDNSFromCache = IpVersionController.getInstance().getHttpDNSFromCache(GlobalTools.APP_CONTEXT, netStatusInfo, str2, dnsInfo);
        LogTools.printDebug(TAG, String.format(Locale.US, "===== handleDnsCache host: %s, ips: %s, ttl: %d, net: %s", str2, dnsInfo.getIPStr(), Integer.valueOf(dnsInfo.getTtl()), netStatusInfo.getNetStatusID()));
        StatisticInfo statisticInfo = StatisticMgr.getInstance().getStatisticInfo(str);
        if (httpDNSFromCache == 0) {
            boolean isExpired = isExpired(dnsInfo.getEndTime());
            if (dnsInfo.getIps().size() == 0) {
                dnsResultInfo.mErrorCode = 6;
                dnsResultInfo.mDataSource = 0;
                dnsResultInfo.mIps = new String[0];
                r14 = isExpired;
            } else if (!z && isExpired) {
                dnsResultInfo.mErrorCode = 2;
                r14 = isExpired;
            } else {
                dnsResultInfo.mErrorCode = 0;
                if (i == 0) {
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
                dnsResultInfo.mIpsV4 = strArr;
                dnsResultInfo.mIpsV6 = strArr2;
                if (netStatusInfo.getNetworkStatus().getStatus() == 3) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(Arrays.asList(strArr2));
                    arrayList.addAll(Arrays.asList(strArr));
                    dnsResultInfo.mIps = (String[]) arrayList.toArray(new String[0]);
                } else if (netStatusInfo.getNetworkStatus().canV6() && strArr2 != null && strArr2.length > 0) {
                    dnsResultInfo.mIps = strArr2;
                } else {
                    dnsResultInfo.mIps = strArr;
                }
                if (isExpired) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                statisticInfo.cacheType = i2;
                statisticInfo.uip = dnsInfo.getUip();
                r14 = isExpired;
            }
        } else {
            r14 = 1;
        }
        if (dnsResultInfo.mErrorCode != 0) {
            int localDNSFromCache = IpVersionController.getInstance().getLocalDNSFromCache(str2, dnsInfo);
            LogTools.printDebug(TAG, String.format("===== handleDnsCache codeCacheLocal: %d", Integer.valueOf(localDNSFromCache)));
            if (localDNSFromCache == 0) {
                dnsResultInfo.mErrorCode = 0;
                dnsResultInfo.mDataSource = 4;
                dnsResultInfo.mIps = (String[]) dnsInfo.getIps().toArray(new String[0]);
                statisticInfo.cacheType = 3;
            } else {
                dnsResultInfo.mErrorCode = i;
                dnsResultInfo.mDataSource = 0;
                dnsResultInfo.mIps = new String[0];
            }
        }
        return new int[]{httpDNSFromCache, r14};
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
        boolean z2;
        final String str3;
        ThreadInfo threadInfo;
        DnsResolveFlow dnsResolveFlow;
        int i;
        final int i2;
        int i3;
        final StatisticInfo statisticInfo;
        StatisticInfo statisticInfo2;
        ArrayList<String> arrayList;
        NetworkStatus networkStatus = netStatusInfo.getNetworkStatus();
        int i4 = 3;
        int i5 = 2;
        LogTools.printDebug(TAG, String.format(Locale.US, "handleHttpDNS, start, network: %s, host: %s, requestId: %s", networkStatus.toString(), Arrays.toString(strArr), str));
        ArrayList<String> bestServerIPCache = IpVersionController.getInstance().getBestServerIPCache(networkStatus);
        i4 = (networkStatus.canV6() && networkStatus.canV4()) ? 2 : 2;
        LogTools.printDebug(TAG, String.format(Locale.US, "handleHttpDNS, minSrvIp: %d, best: %s", Integer.valueOf(i4), bestServerIPCache.toString()));
        if (bestServerIPCache.size() < i4) {
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
        int i6 = GlobalTools.HTTPS_LEVEL;
        synchronized (atomicInteger3) {
            int i7 = 0;
            Object obj2 = obj;
            while (i7 < arrayList2.size()) {
                try {
                    try {
                        str2 = arrayList2.get(i7);
                        if (i6 == i5) {
                            z = true;
                        } else if (i6 == 1) {
                            if (i7 < arrayList2.size() / i5) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            z = z2;
                        } else {
                            z = false;
                        }
                        str3 = "HttpDNS-" + netStatusInfo.getNetStatusID() + "-" + str2 + "-" + IPTools.hosts2String(strArr);
                        threadInfo = new ThreadInfo(str3);
                        dnsResolveFlow = this;
                        i = i7;
                        i2 = i6;
                        i3 = i6;
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
                    threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.3
                        @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                        public void handleOper(String str4) {
                            LogTools.printDebug(DnsResolveFlow.TAG, String.format(Locale.US, "handleHttpDNS.handleOper, HttpDns thread[%s], serverIp: %s, is_https: %b, httpsLevel: %d, requestId: %s", str3, str2, Boolean.valueOf(z), Integer.valueOf(i2), str));
                            long uptimeMillis = SystemClock.uptimeMillis();
                            String[] requestHttpDnsV2 = HttpDNSProtocolMgr.requestHttpDnsV2(strArr, str2, false, z, str);
                            LogTools.printDebug(DnsResolveFlow.TAG, String.format(Locale.US, "handleHttpDNS.handleOper, cost HttpDns thread[%s], requestId: %s , cost : %d", str3, str, Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis)));
                            if (requestHttpDnsV2 != null && BasicPushStatus.SUCCESS_CODE.equals(requestHttpDnsV2[0])) {
                                LogTools.printDebug(DnsResolveFlow.TAG, String.format(Locale.US, "HttpDns succeed response serverIp: %s, requestId: %s, res: %s", str2, str, requestHttpDnsV2[1]));
                                synchronized (atomicInteger) {
                                    long uptimeMillis2 = SystemClock.uptimeMillis();
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
                                } catch (Exception e) {
                                    LogTools.printWarning(DnsResolveFlow.TAG, e);
                                }
                                statisticInfo.httpErrMsg = requestHttpDnsV2[1];
                            } else {
                                StatisticInfo statisticInfo4 = statisticInfo;
                                statisticInfo4.httpErrCode = -999;
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
                    i7 = i + 1;
                    i6 = i3;
                    atomicInteger3 = atomicInteger;
                    statisticInfo3 = statisticInfo2;
                    arrayList2 = arrayList;
                    i5 = 2;
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
            } catch (InterruptedException e) {
                e = e;
                atomicInteger2 = atomicInteger;
            }
            try {
                atomicInteger2.wait(GlobalTools.HTTPDNS_TIMEOUT);
            } catch (InterruptedException e2) {
                e = e2;
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
            int i8 = atomicInteger2.get();
            return i8;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTTL() {
        if (GlobalTools.IS_BACKGOUND_MODEL || !SwitchController.getInstance().switchGslb()) {
            return;
        }
        DBAccessMgr dBAccessMgr = DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT);
        NetStatusInfo netStatusInfo = new NetStatusInfo();
        netStatusInfo.resetVal(DeviceMgr.getNetworkInfo(GlobalTools.APP_CONTEXT));
        DataCacheMgr.INSTANCE.setCachedNetStateInfo(netStatusInfo);
        if (netStatusInfo.getNetType() == 0) {
            return;
        }
        HashSet hashSet = new HashSet();
        List<HostTB> allHost = dBAccessMgr.getAllHost();
        String netStatusID = netStatusInfo.getNetStatusID();
        String ssid = netStatusInfo.getSsid();
        for (HostTB hostTB : allHost) {
            if (isHostDead(hostTB.getInsertTime())) {
                dBAccessMgr.delHost(hostTB);
                IpVersionController.getInstance().delResultByHost(hostTB.getHost());
            } else {
                if (!ssid.equals(IpVersionController.IPV6_ONLY) && (netStatusInfo.getNetworkStatus() == null || netStatusInfo.getNetworkStatus().canV4())) {
                    List<ResultTB> resultByNetworkHost = IpVersionController.getInstance().getResultByNetworkHost(netStatusID, hostTB.getHost(), 1);
                    if (resultByNetworkHost != null && !resultByNetworkHost.isEmpty()) {
                        ResultTB resultTB = resultByNetworkHost.get(0);
                        if (isDead(resultTB.getUpdateTime())) {
                            IpVersionController.getInstance().delResult(resultTB);
                        }
                        if (isNearlyExpired(resultTB.getEndTime())) {
                            hashSet.add(resultTB.getHost());
                            LogTools.printDebug(TAG, String.format(Locale.US, "result %s ttl Nearly Expired, ipv4", resultTB.getHost()));
                            if (hashSet.size() >= 10) {
                                break;
                            }
                        }
                    } else {
                        hashSet.add(hostTB.getHost());
                        if (hashSet.size() >= 10) {
                            break;
                        }
                    }
                }
                if (!ssid.equals(IpVersionController.IPV4_ONLY) && (netStatusInfo.getNetworkStatus() == null || netStatusInfo.getNetworkStatus().canV6())) {
                    List<ResultTB> resultByNetworkHost2 = IpVersionController.getInstance().getResultByNetworkHost(netStatusID, hostTB.getHost(), 2);
                    if (resultByNetworkHost2 != null && !resultByNetworkHost2.isEmpty()) {
                        ResultTB resultTB2 = resultByNetworkHost2.get(0);
                        if (isDead(resultTB2.getUpdateTime())) {
                            IpVersionController.getInstance().delResult(resultTB2);
                        }
                        if (isNearlyExpired(resultTB2.getEndTime())) {
                            hashSet.add(resultTB2.getHost());
                            LogTools.printDebug(TAG, String.format(Locale.US, "result %s ttl Nearly Expired, ipv6", resultTB2.getHost()));
                            if (hashSet.size() >= 10) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        hashSet.add(hostTB.getHost());
                        if (hashSet.size() >= 10) {
                            break;
                        }
                    }
                }
            }
        }
        if (!hashSet.isEmpty()) {
            updateIps(netStatusInfo, hashSet);
        }
    }

    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v7 */
    private int preHandleHttpDNS(NetStatusInfo netStatusInfo, String[] strArr, String str) {
        int i;
        boolean z;
        NetworkStatus networkStatus = netStatusInfo.getNetworkStatus();
        ?? r8 = 0;
        int i2 = 1;
        int i3 = 2;
        LogTools.printDebug(TAG, String.format(Locale.US, "preHandleHttpDNS, start, network: %s, host: %s, requestId: %s", networkStatus.toString(), Arrays.toString(strArr), str));
        ArrayList<String> bestServerIPCache = IpVersionController.getInstance().getBestServerIPCache(networkStatus);
        if (networkStatus.canV6() && networkStatus.canV4()) {
            i = 3;
        } else {
            i = 2;
        }
        LogTools.printDebug(TAG, String.format(Locale.US, "preHandleHttpDNS, minSrvIp: %d, best: %s", Integer.valueOf(i), bestServerIPCache.toString()));
        if (bestServerIPCache.size() < i) {
            if (netStatusInfo.isKnowIsp()) {
                bestServerIPCache = IpVersionController.getInstance().getServerIPByKnownISP(GlobalTools.APP_CONTEXT, netStatusInfo.getIsp(), networkStatus);
            } else {
                bestServerIPCache = IpVersionController.getInstance().getServerIPByUnKnownISP(GlobalTools.APP_CONTEXT, networkStatus);
            }
            LogTools.printDebug(TAG, String.format(Locale.US, "preHandleHttpDNS, cache: %s", bestServerIPCache.toString()));
        }
        if (bestServerIPCache.size() == 0) {
            LogTools.printError(TAG, "request HttpDns no ServerIp");
            return 8;
        }
        LogTools.printDebug(TAG, String.format(Locale.US, "handleHttpDNS, list: %s", bestServerIPCache.toString()));
        StatisticInfo statisticInfo = StatisticMgr.getInstance().getStatisticInfo(str);
        statisticInfo.setSrvIp(bestServerIPCache);
        statisticInfo.network = PreferencesUtil.LEFT_MOUNT + netStatusInfo.getNetStatusID() + "] " + networkStatus.toString() + "";
        AtomicInteger atomicInteger = new AtomicInteger(-1);
        int i4 = GlobalTools.HTTPS_LEVEL;
        synchronized (atomicInteger) {
            int i5 = 0;
            while (i5 < bestServerIPCache.size()) {
                String str2 = bestServerIPCache.get(i5);
                if (i4 == i3 || (i4 == i2 && i5 >= bestServerIPCache.size() / i3)) {
                    z = true;
                } else {
                    z = false;
                }
                String str3 = "HttpDNS-" + netStatusInfo.getNetStatusID() + "-" + str2 + "-" + IPTools.hosts2String(strArr);
                Locale locale = Locale.US;
                Object[] objArr = new Object[5];
                objArr[r8] = str3;
                objArr[i2] = str2;
                objArr[i3] = Boolean.valueOf(z);
                objArr[3] = Integer.valueOf(i4);
                objArr[4] = str;
                LogTools.printDebug(TAG, String.format(locale, "preHandleHttpDNS.handleOper, HttpDns thread[%s], serverIp: %s, is_https: %b, httpsLevel: %d, requestId: %s", objArr));
                long uptimeMillis = SystemClock.uptimeMillis();
                String[] requestHttpDnsV2 = HttpDNSProtocolMgr.requestHttpDnsV2(strArr, str2, r8, z, str);
                ArrayList<String> arrayList = bestServerIPCache;
                LogTools.printDebug(TAG, String.format(Locale.US, "preHandleHttpDNS.handleOper, cost HttpDns thread[%s], requestId: %s , cost : %d", str3, str, Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis)));
                if (requestHttpDnsV2 != null && BasicPushStatus.SUCCESS_CODE.equals(requestHttpDnsV2[0])) {
                    LogTools.printDebug(TAG, String.format(Locale.US, "preHandleHttpDNS succeed response serverIp: %s, requestId: %s, res: %s", str2, str, requestHttpDnsV2[1]));
                    long uptimeMillis2 = SystemClock.uptimeMillis();
                    ResInfo resInfo = new ResInfo();
                    resInfo.setNetInfo(netStatusInfo);
                    HttpDNSProtocolMgr.responseProtocolV2(requestHttpDnsV2[1], resInfo, IpVersionController.tellIpVer(str2));
                    if (resInfo.getStatus() != 0 && resInfo.getStatus() != 6) {
                        i5++;
                        bestServerIPCache = arrayList;
                        i3 = 2;
                        r8 = 0;
                        i2 = 1;
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
                    return 0;
                }
                LogTools.printDebug(TAG, String.format(Locale.US, "preHandleHttpDNS.handleOper, httpdns parse error, HttpDns thread[%s], serverIp: %s, requestId: %s", str3, str2, str));
                if (requestHttpDnsV2 != null) {
                    try {
                        statisticInfo.httpErrCode = Integer.parseInt(requestHttpDnsV2[0]);
                    } catch (Exception e) {
                        LogTools.printWarning(TAG, e);
                    }
                    statisticInfo.httpErrMsg = requestHttpDnsV2[1];
                } else {
                    statisticInfo.httpErrCode = -999;
                    statisticInfo.httpErrMsg = "result is null";
                }
                i5++;
                bestServerIPCache = arrayList;
                i3 = 2;
                r8 = 0;
                i2 = 1;
            }
            return 4;
        }
    }

    private void updateIps(final NetStatusInfo netStatusInfo, final Set<String> set) {
        ThreadInfo threadInfo = new ThreadInfo("HttpDNS-TTL-Update-" + System.currentTimeMillis());
        LogTools.printDebug(TAG, String.format(Locale.US, "===== handleTTL host2Update: %s", set.toString()));
        threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.9
            @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
            public void handleOper(String str) {
                long uptimeMillis = SystemClock.uptimeMillis();
                Set set2 = set;
                String createRequestId = DnsResolveFlow.this.createRequestId();
                final StatisticInfo statisticInfo = new StatisticInfo();
                StatisticMgr.getInstance().setStatisticInfo(createRequestId, statisticInfo);
                statisticInfo.requestId = createRequestId;
                statisticInfo.host = TextUtils.join("|", (String[]) set2.toArray(new String[set2.size()]));
                statisticInfo.async = 0;
                statisticInfo.netType = netStatusInfo.getNetType();
                statisticInfo.http = 1;
                statisticInfo.cacheType = 4;
                DnsResolveFlow dnsResolveFlow = DnsResolveFlow.this;
                NetStatusInfo netStatusInfo2 = netStatusInfo;
                Set set3 = set;
                dnsResolveFlow.handleHttpDNS(netStatusInfo2, (String[]) set3.toArray(new String[set3.size()]), createRequestId);
                statisticInfo.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                if (StatisticMgr.getInstance().getStatistic() != null) {
                    ThreadInfo threadInfo2 = new ThreadInfo("Statistic");
                    threadInfo2.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.9.1
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

    public synchronized int beginTTLMonitor() {
        if (GlobalTools.APP_CONTEXT != null) {
            TimerTaskInfo timerTaskInfo = new TimerTaskInfo();
            timerTaskInfo.setTaskName(GlobalTools.TTL_MONITOR_NAME);
            timerTaskInfo.setWorker(new TimerTask() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.6
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:127:0x03be */
    /* JADX DEBUG: Multi-variable search result rejected for r1v13, resolved type: int[] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.yy.gslbsdk.statistic.StatisticInfo */
    /* JADX DEBUG: Multi-variable search result rejected for r3v11, resolved type: char */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0405  */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DnsResultInfo handleDNS(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        String str2;
        final StatisticInfo statisticInfo;
        String str3;
        String str4;
        final StatisticInfo statisticInfo2;
        long j;
        int i;
        int i2;
        final StatisticInfo statisticInfo3;
        String str5;
        boolean z7;
        boolean z8;
        long uptimeMillis = SystemClock.uptimeMillis();
        DataCacheMgr.INSTANCE.addInvokeApiNum(str);
        String trim = str.trim();
        String createRequestId = createRequestId();
        final StatisticInfo statisticInfo4 = new StatisticInfo();
        StatisticMgr.getInstance().setStatisticInfo(createRequestId, statisticInfo4);
        statisticInfo4.requestId = createRequestId;
        statisticInfo4.host = trim;
        statisticInfo4.async = z2 ? 1 : 0;
        NetStatusInfo cachedNetStatusInfo = DataCacheMgr.INSTANCE.getCachedNetStatusInfo();
        DnsResultInfo dnsResultInfo = new DnsResultInfo();
        if (trim != null) {
            try {
                if (!"".equals(trim.trim())) {
                    if (GlobalTools.APP_CONTEXT == null) {
                        collectStat0(uptimeMillis, dnsResultInfo);
                        statisticInfo4.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                        if (dnsResultInfo.mErrorCode == 0) {
                            statisticInfo4.rsIp.addAll(Arrays.asList(dnsResultInfo.mIps));
                            statisticInfo4.rsIpV4.addAll(Arrays.asList(dnsResultInfo.mIpsV4));
                            statisticInfo4.rsIpV6.addAll(Arrays.asList(dnsResultInfo.mIpsV6));
                        }
                        if (StatisticMgr.getInstance().getStatistic() != null) {
                            ThreadInfo threadInfo = new ThreadInfo("Statistic");
                            threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.7
                                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                public void handleOper(String str6) {
                                    StatisticMgr.getInstance().removeStatisticInfo(statisticInfo4.requestId);
                                    StatisticMgr.getInstance().onStatistic(statisticInfo4.toMap());
                                }
                            });
                            StatisticMgr.getInstance().addTask(threadInfo, 5000L);
                        }
                        return dnsResultInfo;
                    } else if (z && z5) {
                        deleteHost(trim);
                        handleDegradation(trim, dnsResultInfo);
                        collectStat0(uptimeMillis, dnsResultInfo);
                        statisticInfo4.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                        if (dnsResultInfo.mErrorCode == 0) {
                            statisticInfo4.rsIp.addAll(Arrays.asList(dnsResultInfo.mIps));
                            statisticInfo4.rsIpV4.addAll(Arrays.asList(dnsResultInfo.mIpsV4));
                            statisticInfo4.rsIpV6.addAll(Arrays.asList(dnsResultInfo.mIpsV6));
                        }
                        if (StatisticMgr.getInstance().getStatistic() != null) {
                            ThreadInfo threadInfo2 = new ThreadInfo("Statistic");
                            threadInfo2.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.7
                                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                public void handleOper(String str6) {
                                    StatisticMgr.getInstance().removeStatisticInfo(statisticInfo4.requestId);
                                    StatisticMgr.getInstance().onStatistic(statisticInfo4.toMap());
                                }
                            });
                            StatisticMgr.getInstance().addTask(threadInfo2, 5000L);
                        }
                        return dnsResultInfo;
                    } else {
                        if (!z4) {
                            boolean enableExpired = TtlController.getInstance().enableExpired();
                            if (!enableExpired && (!z2 || !z3)) {
                                str5 = TAG;
                                z7 = false;
                            } else {
                                str5 = TAG;
                                z7 = true;
                            }
                            try {
                                int[] handleDnsCache = handleDnsCache(createRequestId, dnsResultInfo, cachedNetStatusInfo, trim, 2, z7);
                                int i3 = handleDnsCache[0];
                                if (handleDnsCache[1] == 1) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                if (z2) {
                                    if (i3 == 0 && dnsResultInfo.mIps != null && dnsResultInfo.mIps.length >= 1) {
                                        if (z8) {
                                            ExternalCache.getInstance().getResult(trim, 8, dnsResultInfo);
                                        }
                                    }
                                    ExternalCache.getInstance().getResult(trim, 4, dnsResultInfo);
                                }
                                i = 3;
                                str3 = str5;
                                LogTools.printDebug(str3, String.format(Locale.US, "===== handleDNS handleDnsCache host: %s, codeCacheHttp: %d, expiredCacheHttp: %b, forceEnableExpired: %b ,isUpdateIp: %b", trim, Integer.valueOf(i3), Boolean.valueOf(z8), Boolean.valueOf(enableExpired), Boolean.valueOf(z6)));
                                if (i3 == 0 && (z6 || !z8)) {
                                    if (z8 || dnsResultInfo.mIps.length == 0) {
                                        if (z5) {
                                            handleLocalDNS(trim);
                                        }
                                        handleDnsAsync(trim, createRequestId, cachedNetStatusInfo);
                                    }
                                    collectStat0(uptimeMillis, dnsResultInfo);
                                    statisticInfo4.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                                    if (dnsResultInfo.mErrorCode == 0) {
                                        statisticInfo4.rsIp.addAll(Arrays.asList(dnsResultInfo.mIps));
                                        statisticInfo4.rsIpV4.addAll(Arrays.asList(dnsResultInfo.mIpsV4));
                                        statisticInfo4.rsIpV6.addAll(Arrays.asList(dnsResultInfo.mIpsV6));
                                    }
                                    if (StatisticMgr.getInstance().getStatistic() != null) {
                                        ThreadInfo threadInfo3 = new ThreadInfo("Statistic");
                                        threadInfo3.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.7
                                            @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                            public void handleOper(String str6) {
                                                StatisticMgr.getInstance().removeStatisticInfo(statisticInfo4.requestId);
                                                StatisticMgr.getInstance().onStatistic(statisticInfo4.toMap());
                                            }
                                        });
                                        StatisticMgr.getInstance().addTask(threadInfo3, 5000L);
                                    }
                                    return dnsResultInfo;
                                }
                                statisticInfo2 = statisticInfo4;
                                str4 = "Statistic";
                                j = 5000;
                            } catch (Throwable th) {
                                th = th;
                                statisticInfo = statisticInfo4;
                                str2 = "Statistic";
                                collectStat0(uptimeMillis, dnsResultInfo);
                                statisticInfo.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                                if (dnsResultInfo.mErrorCode == 0) {
                                    statisticInfo.rsIp.addAll(Arrays.asList(dnsResultInfo.mIps));
                                    statisticInfo.rsIpV4.addAll(Arrays.asList(dnsResultInfo.mIpsV4));
                                    statisticInfo.rsIpV6.addAll(Arrays.asList(dnsResultInfo.mIpsV6));
                                }
                                if (StatisticMgr.getInstance().getStatistic() != null) {
                                    ThreadInfo threadInfo4 = new ThreadInfo(str2);
                                    threadInfo4.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.7
                                        @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                        public void handleOper(String str6) {
                                            StatisticMgr.getInstance().removeStatisticInfo(statisticInfo.requestId);
                                            StatisticMgr.getInstance().onStatistic(statisticInfo.toMap());
                                        }
                                    });
                                    StatisticMgr.getInstance().addTask(threadInfo4, 5000L);
                                }
                                throw th;
                            }
                        } else {
                            str3 = TAG;
                            str4 = "Statistic";
                            statisticInfo2 = statisticInfo4;
                            j = 5000;
                            i = 3;
                        }
                        try {
                            if (z2) {
                                if (z4) {
                                    LogTools.printError(str3, String.format(Locale.US, "force refresh is valid only in asynchronous function! ", new Object[0]));
                                    dnsResultInfo.mErrorCode = 5;
                                    collectStat0(uptimeMillis, dnsResultInfo);
                                    statisticInfo2.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                                    if (dnsResultInfo.mErrorCode == 0) {
                                        statisticInfo2.rsIp.addAll(Arrays.asList(dnsResultInfo.mIps));
                                        statisticInfo2.rsIpV4.addAll(Arrays.asList(dnsResultInfo.mIpsV4));
                                        statisticInfo2.rsIpV6.addAll(Arrays.asList(dnsResultInfo.mIpsV6));
                                    }
                                    if (StatisticMgr.getInstance().getStatistic() != null) {
                                        ThreadInfo threadInfo5 = new ThreadInfo(str4);
                                        threadInfo5.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.7
                                            @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                            public void handleOper(String str6) {
                                                StatisticMgr.getInstance().removeStatisticInfo(statisticInfo2.requestId);
                                                StatisticMgr.getInstance().onStatistic(statisticInfo2.toMap());
                                            }
                                        });
                                        StatisticMgr.getInstance().addTask(threadInfo5, j);
                                    }
                                    return dnsResultInfo;
                                }
                                if (z5) {
                                    handleLocalDNS(trim);
                                }
                                handleDnsAsync(trim, createRequestId, cachedNetStatusInfo);
                                str2 = str4;
                                statisticInfo3 = statisticInfo2;
                            } else {
                                if (z3) {
                                    LogTools.printError(str3, String.format(Locale.US, "enableExpiredIp is valid only in asynchronous function! ", new Object[0]));
                                }
                                int handleDnsSync = handleDnsSync(trim, createRequestId, cachedNetStatusInfo);
                                str2 = str4;
                                final StatisticInfo statisticInfo5 = statisticInfo2;
                                String str6 = str3;
                                try {
                                    int[] handleDnsCache2 = handleDnsCache(createRequestId, dnsResultInfo, cachedNetStatusInfo, trim, handleDnsSync, false);
                                    i2 = handleDnsCache2[0];
                                    statisticInfo = handleDnsCache2[1];
                                } catch (Throwable th2) {
                                    th = th2;
                                    statisticInfo = statisticInfo5;
                                }
                                try {
                                    if (z4 && (handleDnsSync != 0 || dnsResultInfo.mDataSource != i)) {
                                        Locale locale = Locale.US;
                                        Object[] objArr = new Object[i];
                                        objArr[0] = trim;
                                        objArr[1] = Integer.valueOf(handleDnsSync);
                                        objArr[2] = Integer.valueOf(dnsResultInfo.mDataSource);
                                        LogTools.printError(str6, String.format(locale, "force fresh failed! host: %s, codeHttp: %d, dataSource: %d", objArr));
                                        dnsResultInfo.mErrorCode = handleDnsSync;
                                        dnsResultInfo.mDataSource = 0;
                                        dnsResultInfo.mIps = new String[0];
                                        dnsResultInfo.mIpsV6 = new String[0];
                                        dnsResultInfo.mIpsV4 = new String[0];
                                        statisticInfo5.cacheType = 0;
                                        collectStat0(uptimeMillis, dnsResultInfo);
                                        statisticInfo5.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                                        if (dnsResultInfo.mErrorCode == 0) {
                                            statisticInfo5.rsIp.addAll(Arrays.asList(dnsResultInfo.mIps));
                                            statisticInfo5.rsIpV4.addAll(Arrays.asList(dnsResultInfo.mIpsV4));
                                            statisticInfo5.rsIpV6.addAll(Arrays.asList(dnsResultInfo.mIpsV6));
                                        }
                                        if (StatisticMgr.getInstance().getStatistic() != null) {
                                            ThreadInfo threadInfo6 = new ThreadInfo(str2);
                                            threadInfo6.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.7
                                                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                                public void handleOper(String str62) {
                                                    StatisticMgr.getInstance().removeStatisticInfo(statisticInfo5.requestId);
                                                    StatisticMgr.getInstance().onStatistic(statisticInfo5.toMap());
                                                }
                                            });
                                            StatisticMgr.getInstance().addTask(threadInfo6, 5000L);
                                        }
                                        return dnsResultInfo;
                                    }
                                    statisticInfo3 = statisticInfo5;
                                    if (handleDnsSync == 0 && i2 != 0) {
                                        LogTools.printDebug(str6, String.format(Locale.US, "%s not support by gslb", trim));
                                    }
                                    if (dnsResultInfo.mDataSource == 0 && z5) {
                                        handleLocalDNS(trim);
                                    }
                                    if (i2 != 0 || dnsResultInfo.mIps == null || dnsResultInfo.mIps.length < 1) {
                                        ExternalCache.getInstance().getResult(trim, 2, dnsResultInfo);
                                    }
                                    judgeUpdateHost(trim, handleDnsSync, i2);
                                } catch (Throwable th3) {
                                    th = th3;
                                    collectStat0(uptimeMillis, dnsResultInfo);
                                    statisticInfo.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                                    if (dnsResultInfo.mErrorCode == 0) {
                                    }
                                    if (StatisticMgr.getInstance().getStatistic() != null) {
                                    }
                                    throw th;
                                }
                            }
                            collectStat0(uptimeMillis, dnsResultInfo);
                            statisticInfo3.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                            if (dnsResultInfo.mErrorCode == 0) {
                                statisticInfo3.rsIp.addAll(Arrays.asList(dnsResultInfo.mIps));
                                statisticInfo3.rsIpV4.addAll(Arrays.asList(dnsResultInfo.mIpsV4));
                                statisticInfo3.rsIpV6.addAll(Arrays.asList(dnsResultInfo.mIpsV6));
                            }
                            if (StatisticMgr.getInstance().getStatistic() != null) {
                                ThreadInfo threadInfo7 = new ThreadInfo(str2);
                                threadInfo7.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.7
                                    @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                    public void handleOper(String str62) {
                                        StatisticMgr.getInstance().removeStatisticInfo(statisticInfo3.requestId);
                                        StatisticMgr.getInstance().onStatistic(statisticInfo3.toMap());
                                    }
                                });
                                StatisticMgr.getInstance().addTask(threadInfo7, 5000L);
                            }
                            return dnsResultInfo;
                        } catch (Throwable th4) {
                            th = th4;
                            str2 = str4;
                            statisticInfo = statisticInfo2;
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                str2 = "Statistic";
                statisticInfo = statisticInfo4;
            }
        }
        collectStat0(uptimeMillis, dnsResultInfo);
        statisticInfo4.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
        if (dnsResultInfo.mErrorCode == 0) {
            statisticInfo4.rsIp.addAll(Arrays.asList(dnsResultInfo.mIps));
            statisticInfo4.rsIpV4.addAll(Arrays.asList(dnsResultInfo.mIpsV4));
            statisticInfo4.rsIpV6.addAll(Arrays.asList(dnsResultInfo.mIpsV6));
        }
        if (StatisticMgr.getInstance().getStatistic() != null) {
            ThreadInfo threadInfo8 = new ThreadInfo("Statistic");
            threadInfo8.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.7
                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                public void handleOper(String str62) {
                    StatisticMgr.getInstance().removeStatisticInfo(statisticInfo4.requestId);
                    StatisticMgr.getInstance().onStatistic(statisticInfo4.toMap());
                }
            });
            StatisticMgr.getInstance().addTask(threadInfo8, 5000L);
        }
        return dnsResultInfo;
    }

    public int handleDnsSync(String[] strArr, String str, NetStatusInfo netStatusInfo) {
        AtomicBoolean atomicBoolean;
        AtomicInteger atomicInteger;
        char c;
        int i;
        String str2;
        String str3 = TextUtils.join(",", strArr) + netStatusInfo.getNetStatusID();
        StatisticInfo statisticInfo = StatisticMgr.getInstance().getStatisticInfo(str);
        LogTools.printDebug(TAG, String.format(Locale.US, "handleDnsSync, start, key: %s, requestId: %s", str3, str));
        synchronized (this.mPendingReqs) {
            atomicBoolean = this.mPendingReqs.get(str3);
            if (atomicBoolean == null) {
                atomicBoolean = new AtomicBoolean(false);
                this.mPendingReqs.putIfAbsent(str3, atomicBoolean);
            }
            atomicInteger = this.mPendingHttpCode.get(str3);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger(2);
                this.mPendingHttpCode.putIfAbsent(str3, atomicInteger);
            }
        }
        if (atomicBoolean.compareAndSet(false, true)) {
            long currentTimeMillis = System.currentTimeMillis();
            i = handleHttpDNS(netStatusInfo, strArr, str);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (strArr != null && strArr.length != 0) {
                str2 = strArr[0];
            } else {
                str2 = "";
            }
            LogTools.printDebug(TAG, String.format(Locale.US, "handleDnsSync , request end cost, requestId: %s ,domain : %s, cost: %d", str, str2, Long.valueOf(currentTimeMillis2)));
            statisticInfo.http = 1;
            atomicInteger.set(i);
            atomicBoolean.set(false);
            str3 = str3;
            this.mPendingHttpCode.remove(str3);
            this.mPendingReqs.remove(str3);
            synchronized (atomicBoolean) {
                LogTools.printDebug(TAG, String.format(Locale.US, "handleDnsSync, req notifyAll, key: %s, requestId: %s", str3, str));
                atomicBoolean.notifyAll();
            }
            c = 2;
        } else {
            if (atomicBoolean.get()) {
                synchronized (atomicBoolean) {
                    try {
                        LogTools.printDebug(TAG, String.format(Locale.US, "handleDnsSync, req wait, key: %s, requestId: %s", str3, str));
                        atomicBoolean.wait(GlobalTools.HTTPDNS_TIMEOUT);
                    } catch (Exception unused) {
                    }
                }
            }
            c = 2;
            statisticInfo.http = 2;
            i = atomicInteger.get();
        }
        Locale locale = Locale.US;
        Object[] objArr = new Object[3];
        objArr[0] = str3;
        objArr[1] = str;
        objArr[c] = Integer.valueOf(i);
        LogTools.printDebug(TAG, String.format(locale, "handleDnsSync, end, key: %s, requestId: %s, codeHttp: %d", objArr));
        return i;
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

    public synchronized void preHost() {
        if (GlobalTools.IS_BACKGOUND_MODEL) {
            return;
        }
        if (!SwitchController.getInstance().switchGslb()) {
            return;
        }
        DBAccessMgr dBAccessMgr = DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT);
        NetStatusInfo netStatusInfo = new NetStatusInfo();
        netStatusInfo.resetVal(DeviceMgr.getNetworkInfo(GlobalTools.APP_CONTEXT));
        DataCacheMgr.INSTANCE.setCachedNetStateInfo(netStatusInfo);
        if (netStatusInfo.getNetType() == 0) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (HostTB hostTB : dBAccessMgr.getAllHost()) {
            if (1 == hostTB.getIsPre()) {
                if (hashSet.size() >= 10) {
                    break;
                }
                hashSet.add(hostTB.getHost());
            }
        }
        if (!hashSet.isEmpty()) {
            updateIps(netStatusInfo, hashSet);
        }
    }

    public synchronized void preHost(ArrayList<String> arrayList) {
        if (GlobalTools.IS_BACKGOUND_MODEL) {
            return;
        }
        if (!SwitchController.getInstance().switchGslb()) {
            return;
        }
        NetStatusInfo netStatusInfo = new NetStatusInfo();
        netStatusInfo.resetVal(DeviceMgr.getNetworkInfo(GlobalTools.APP_CONTEXT));
        DataCacheMgr.INSTANCE.setCachedNetStateInfo(netStatusInfo);
        if (netStatusInfo.getNetType() == 0) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (hashSet.size() >= 10) {
                break;
            }
            hashSet.add(next);
        }
        if (!hashSet.isEmpty()) {
            updateIps(netStatusInfo, hashSet);
        }
    }
}
