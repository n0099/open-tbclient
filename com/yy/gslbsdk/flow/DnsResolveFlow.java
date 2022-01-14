package com.yy.gslbsdk.flow;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup;
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
/* loaded from: classes4.dex */
public class DnsResolveFlow {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DnsResolveFlow";
    public static DnsResolveFlow mDnsResolveFlow;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicInteger mIncreaseId;
    public NetStatusReceiver mNetStatusReceiver;
    public ConcurrentHashMap<String, AtomicInteger> mPendingHttpCode;
    public ConcurrentHashMap<String, AtomicBoolean> mPendingReqs;
    public Runnable mRunnable;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1279088469, "Lcom/yy/gslbsdk/flow/DnsResolveFlow;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1279088469, "Lcom/yy/gslbsdk/flow/DnsResolveFlow;");
        }
    }

    public DnsResolveFlow() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIncreaseId = new AtomicInteger(1);
        this.mPendingReqs = new ConcurrentHashMap<>();
        this.mPendingHttpCode = new ConcurrentHashMap<>();
        this.mNetStatusReceiver = null;
        this.mRunnable = new Runnable(this) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DnsResolveFlow this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
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
            }
        };
    }

    private void collectStat0(long j2, DnsResultInfo dnsResultInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65543, this, j2, dnsResultInfo) == null) {
            DataCacheMgr.INSTANCE.addDnsCost(SystemClock.uptimeMillis() - j2);
            if (dnsResultInfo.mErrorCode != 0) {
                DataCacheMgr.INSTANCE.addFailedDnsCount();
            } else if (dnsResultInfo.mDataSource == 4) {
                DataCacheMgr.INSTANCE.addLocalDnsCount();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String createRequestId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? String.format(Locale.US, "%s_%d_%d", DataCacheMgr.INSTANCE.getIdentity(GlobalTools.APP_CONTEXT), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.mIncreaseId.getAndIncrement())) : (String) invokeV.objValue;
    }

    private int deleteHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) {
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
        return invokeL.intValue;
    }

    public static DnsResolveFlow getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (mDnsResolveFlow == null) {
                mDnsResolveFlow = new DnsResolveFlow();
            }
            return mDnsResolveFlow;
        }
        return (DnsResolveFlow) invokeV.objValue;
    }

    private int handleDegradation(String str, DnsResultInfo dnsResultInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, str, dnsResultInfo)) == null) {
            LogTools.printDebug(TAG, String.format(Locale.US, "handleDegradation, start, host: %s", str));
            AtomicInteger atomicInteger = new AtomicInteger(-1);
            synchronized (atomicInteger) {
                String str2 = "LocalDNS-" + str;
                ThreadInfo threadInfo = new ThreadInfo(str2);
                threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, str, dnsResultInfo, atomicInteger, str2) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DnsResolveFlow this$0;
                    public final /* synthetic */ String val$host;
                    public final /* synthetic */ AtomicInteger val$requestLock;
                    public final /* synthetic */ DnsResultInfo val$resultInfo;
                    public final /* synthetic */ String val$taskId;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, dnsResultInfo, atomicInteger, str2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$host = str;
                        this.val$resultInfo = dnsResultInfo;
                        this.val$requestLock = atomicInteger;
                        this.val$taskId = str2;
                    }

                    @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                    public void handleOper(String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str3) == null) {
                            DnsInfo requestProtocol = LocalDNSProtocolMgr.requestProtocol(this.val$host);
                            if (requestProtocol == null) {
                                DnsResultInfo dnsResultInfo2 = this.val$resultInfo;
                                dnsResultInfo2.mErrorCode = 2;
                                dnsResultInfo2.mDataSource = 0;
                                dnsResultInfo2.mIps = new String[0];
                            } else {
                                IpVersionController.getInstance().putLocalDNSIntoCache(requestProtocol);
                                DnsResultInfo dnsResultInfo3 = this.val$resultInfo;
                                dnsResultInfo3.mErrorCode = 0;
                                dnsResultInfo3.mDataSource = 4;
                                dnsResultInfo3.mIps = (String[]) requestProtocol.getIps().toArray(new String[0]);
                            }
                            synchronized (this.val$requestLock) {
                                this.val$requestLock.set(this.val$resultInfo.mErrorCode);
                                LogTools.printDebug(DnsResolveFlow.TAG, String.format(Locale.US, "handleDegradation.handleOper, requestLock notifyAll, host: %s, taskId: %s", this.val$host, this.val$taskId));
                                this.val$requestLock.notifyAll();
                            }
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
        return invokeLL.intValue;
    }

    private void handleDnsAsync(String str, String str2, NetStatusInfo netStatusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, this, str, str2, netStatusInfo) == null) {
            ThreadInfo threadInfo = new ThreadInfo("HttpDNS-" + netStatusInfo.getNetStatusID() + "-" + str);
            threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, str, str2, netStatusInfo) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DnsResolveFlow this$0;
                public final /* synthetic */ String val$host;
                public final /* synthetic */ NetStatusInfo val$netStatus;
                public final /* synthetic */ String val$requestId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2, netStatusInfo};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$host = str;
                    this.val$requestId = str2;
                    this.val$netStatus = netStatusInfo;
                }

                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                public void handleOper(String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str3) == null) {
                        this.this$0.judgeUpdateHost(this.val$host, this.this$0.handleDnsSync(this.val$host, this.val$requestId, this.val$netStatus), IpVersionController.getInstance().getHttpDNSFromCache(GlobalTools.APP_CONTEXT, this.val$netStatus, this.val$host, new DnsInfo()));
                    }
                }
            });
            ThreadPoolMgr.getInstance().addTask(threadInfo);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int[]] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    private int[] handleDnsCache(String str, DnsResultInfo dnsResultInfo, NetStatusInfo netStatusInfo, String str2, int i2, boolean z) {
        InterceptResult invokeCommon;
        ?? r12;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, this, new Object[]{str, dnsResultInfo, netStatusInfo, str2, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
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
        return (int[]) invokeCommon.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x01f8 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01d2 A[Catch: all -> 0x01f8, TryCatch #2 {all -> 0x01f8, blocks: (B:62:0x01f6, B:43:0x01a7, B:52:0x01b9, B:54:0x01d2, B:55:0x01ec, B:57:0x01ee, B:58:0x01f2, B:51:0x01b4), top: B:70:0x0102 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ee A[Catch: all -> 0x01f8, TryCatch #2 {all -> 0x01f8, blocks: (B:62:0x01f6, B:43:0x01a7, B:52:0x01b9, B:54:0x01d2, B:55:0x01ec, B:57:0x01ee, B:58:0x01f2, B:51:0x01b4), top: B:70:0x0102 }] */
    /* JADX WARN: Type inference failed for: r19v1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int handleHttpDNS(NetStatusInfo netStatusInfo, String[] strArr, String str) {
        InterceptResult invokeLLL;
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        String str2;
        boolean z;
        String str3;
        ThreadInfo threadInfo;
        DnsResolveFlow dnsResolveFlow;
        int i2;
        int i3;
        StatisticInfo statisticInfo;
        ArrayList<String> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, this, netStatusInfo, strArr, str)) == null) {
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
            StatisticInfo statisticInfo2 = StatisticMgr.getInstance().getStatisticInfo(str);
            statisticInfo2.setSrvIp(arrayList2);
            StringBuilder sb = new StringBuilder();
            sb.append(PreferencesUtil.LEFT_MOUNT);
            sb.append(netStatusInfo.getNetStatusID());
            Object obj = "] ";
            sb.append("] ");
            sb.append(networkStatus.toString());
            sb.append("");
            statisticInfo2.network = sb.toString();
            Object atomicInteger3 = new AtomicInteger(-1);
            AtomicInteger atomicInteger4 = new AtomicInteger(arrayList2.size());
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
                                z = i7 >= arrayList2.size() / i5;
                            } else {
                                z = false;
                            }
                            str3 = "HttpDNS-" + netStatusInfo.getNetStatusID() + "-" + str2 + "-" + IPTools.hosts2String(strArr);
                            threadInfo = new ThreadInfo(str3);
                            dnsResolveFlow = this;
                            i2 = i7;
                            i3 = i6;
                            atomicInteger = atomicInteger3;
                            statisticInfo = statisticInfo2;
                            arrayList = arrayList2;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        obj2 = atomicInteger3;
                    }
                    try {
                        threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper(dnsResolveFlow, str3, str2, z, i6, str, strArr, statisticInfo2, atomicInteger4, atomicInteger, netStatusInfo) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ DnsResolveFlow this$0;
                            public final /* synthetic */ String[] val$host;
                            public final /* synthetic */ boolean val$https;
                            public final /* synthetic */ int val$httpsLevel;
                            public final /* synthetic */ String val$ip;
                            public final /* synthetic */ AtomicInteger val$mRequestLock;
                            public final /* synthetic */ NetStatusInfo val$network;
                            public final /* synthetic */ AtomicInteger val$requestFailedCount;
                            public final /* synthetic */ String val$requestId;
                            public final /* synthetic */ StatisticInfo val$rsInfo;
                            public final /* synthetic */ String val$taskId;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r3;
                                    Object[] objArr = {dnsResolveFlow, str3, str2, Boolean.valueOf(z), Integer.valueOf(i6), str, strArr, statisticInfo2, atomicInteger4, atomicInteger, netStatusInfo};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i8 = newInitContext.flag;
                                    if ((i8 & 1) != 0) {
                                        int i9 = i8 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = dnsResolveFlow;
                                this.val$taskId = str3;
                                this.val$ip = str2;
                                this.val$https = z;
                                this.val$httpsLevel = i6;
                                this.val$requestId = str;
                                this.val$host = strArr;
                                this.val$rsInfo = statisticInfo2;
                                this.val$requestFailedCount = atomicInteger4;
                                this.val$mRequestLock = atomicInteger;
                                this.val$network = netStatusInfo;
                            }

                            @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                            public void handleOper(String str4) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str4) == null) {
                                    LogTools.printDebug(DnsResolveFlow.TAG, String.format(Locale.US, "handleHttpDNS.handleOper, HttpDns thread[%s], serverIp: %s, is_https: %b, httpsLevel: %d, requestId: %s", this.val$taskId, this.val$ip, Boolean.valueOf(this.val$https), Integer.valueOf(this.val$httpsLevel), this.val$requestId));
                                    long uptimeMillis = SystemClock.uptimeMillis();
                                    String[] requestHttpDnsV2 = HttpDNSProtocolMgr.requestHttpDnsV2(this.val$host, this.val$ip, false, this.val$https, this.val$requestId);
                                    if (requestHttpDnsV2 != null && BasicPushStatus.SUCCESS_CODE.equals(requestHttpDnsV2[0])) {
                                        synchronized (this.val$mRequestLock) {
                                            long uptimeMillis2 = SystemClock.uptimeMillis();
                                            LogTools.printDebug(DnsResolveFlow.TAG, String.format(Locale.US, "HttpDns succeed response serverIp: %s, requestId: %s", this.val$ip, this.val$requestId));
                                            ResInfo resInfo = new ResInfo();
                                            resInfo.setNetInfo(this.val$network);
                                            HttpDNSProtocolMgr.responseProtocolV2(requestHttpDnsV2[1], resInfo, IpVersionController.tellIpVer(this.val$ip));
                                            if (resInfo.getStatus() != 0 && resInfo.getStatus() != 6) {
                                                if (this.val$requestFailedCount.decrementAndGet() == 0) {
                                                    this.val$mRequestLock.compareAndSet(-1, resInfo.getStatus());
                                                    LogTools.printDebug(DnsResolveFlow.TAG, String.format(Locale.US, "handleHttpDNS.handleOper result, requestLock notifyAll(3), HttpDns thread[%s], serverIp: %s, requestId: %s", this.val$taskId, this.val$ip, this.val$requestId));
                                                    this.val$mRequestLock.notifyAll();
                                                }
                                            }
                                            this.val$rsInfo.httpErrCode = 0;
                                            this.val$rsInfo.httpErrMsg = "success";
                                            long j2 = uptimeMillis2 - uptimeMillis;
                                            this.val$mRequestLock.compareAndSet(-1, resInfo.getStatus());
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
                                            serverIPInfo.setIp(this.val$ip);
                                            serverIPInfo.setScore(j2);
                                            IpVersionController.getInstance().resetBestServerIPCache(serverIPInfo);
                                            if (resInfo.getHttpdns().isRe()) {
                                                QualityDetectFlow.getInstance().addReportData(GlobalTools.HTTPDNS_REPORT_HOST, this.val$ip, j2);
                                            }
                                            if (ServerIPMgr.getInstance().canUpdate(GlobalTools.APP_CONTEXT, resInfo.getHttpdns().getVer())) {
                                                ServerIPMgr.getInstance().updateServerIP(GlobalTools.APP_CONTEXT, this.val$ip);
                                            }
                                            ActiveRefreshController.getInstance();
                                            ActiveRefreshController.refreshHostCache(resInfo);
                                            LogTools.printDebug(DnsResolveFlow.TAG, String.format(Locale.US, "handleHttpDNS.handleOper result, requestLock notifyAll(2), HttpDns thread[%s], serverIp: %s, requestId: %s", this.val$taskId, this.val$ip, this.val$requestId));
                                            this.val$mRequestLock.notifyAll();
                                        }
                                        return;
                                    }
                                    LogTools.printDebug(DnsResolveFlow.TAG, String.format(Locale.US, "handleHttpDNS.handleOper, httpdns parse error, HttpDns thread[%s], serverIp: %s, requestId: %s", this.val$taskId, this.val$ip, this.val$requestId));
                                    if (requestHttpDnsV2 != null) {
                                        try {
                                            this.val$rsInfo.httpErrCode = Integer.parseInt(requestHttpDnsV2[0]);
                                        } catch (Exception e2) {
                                            LogTools.printWarning(DnsResolveFlow.TAG, e2);
                                        }
                                        this.val$rsInfo.httpErrMsg = requestHttpDnsV2[1];
                                    } else {
                                        StatisticInfo statisticInfo3 = this.val$rsInfo;
                                        statisticInfo3.httpErrCode = BannerFocusImageViewGroup.f50773f;
                                        statisticInfo3.httpErrMsg = "result is null";
                                    }
                                    if (this.val$requestFailedCount.decrementAndGet() == 0) {
                                        this.val$mRequestLock.compareAndSet(-1, this.val$rsInfo.httpErrCode);
                                        synchronized (this.val$mRequestLock) {
                                            LogTools.printDebug(DnsResolveFlow.TAG, String.format(Locale.US, "handleHttpDNS.handleOper, requestLock notifyAll(1), HttpDns thread[%s], serverIp: %s, requestId: %s", this.val$taskId, this.val$ip, this.val$requestId));
                                            this.val$mRequestLock.notifyAll();
                                        }
                                    }
                                }
                            }
                        });
                        ThreadPoolMgr.getInstance().addTask(threadInfo);
                        i7 = i2 + 1;
                        i6 = i3;
                        atomicInteger3 = atomicInteger;
                        statisticInfo2 = statisticInfo;
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
                StatisticInfo statisticInfo3 = statisticInfo2;
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
                    statisticInfo3.httpErrCode = 1;
                    statisticInfo3.httpErrMsg = "all httpdns request timeout";
                    return 1;
                }
                int i8 = atomicInteger2.get();
                return i8;
            }
        }
        return invokeLLL.intValue;
    }

    private int handleLocalDNS(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, str)) == null) {
            ThreadInfo threadInfo = new ThreadInfo("LocalDNS-" + str);
            threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, str) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DnsResolveFlow this$0;
                public final /* synthetic */ String val$host;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$host = str;
                }

                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                public void handleOper(String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str2) == null) {
                        DnsInfo requestProtocol = LocalDNSProtocolMgr.requestProtocol(this.val$host);
                        if (requestProtocol != null) {
                            NetStatusInfo networkInfo = DeviceMgr.getNetworkInfo(GlobalTools.APP_CONTEXT);
                            requestProtocol.setNt(networkInfo.getNetType());
                            DnsInfo dnsInfo = new DnsInfo();
                            if (IpVersionController.getInstance().getHttpDNSFromCache(GlobalTools.APP_CONTEXT, networkInfo, this.val$host, dnsInfo) == 0) {
                                requestProtocol.setUip(dnsInfo.getUip());
                            }
                            requestProtocol.setEndTime(System.currentTimeMillis() + 600000);
                            IpVersionController.getInstance().putLocalDNSIntoCache(requestProtocol);
                            return;
                        }
                        LogTools.printError(DnsResolveFlow.TAG, "local parse error");
                    }
                }
            });
            ThreadPoolMgr.getInstance().addTask(threadInfo);
            return 0;
        }
        return invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTTL() {
        List<ResultTB> resultByNetworkHost;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65552, this) == null) && !GlobalTools.IS_BACKGOUND_MODEL && SwitchController.getInstance().switchGslb()) {
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
            threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, hashSet, netStatusInfo) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DnsResolveFlow this$0;
                public final /* synthetic */ Set val$host2Update;
                public final /* synthetic */ NetStatusInfo val$network;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, hashSet, netStatusInfo};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$host2Update = hashSet;
                    this.val$network = netStatusInfo;
                }

                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                public void handleOper(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        Set set = this.val$host2Update;
                        String createRequestId = this.this$0.createRequestId();
                        StatisticInfo statisticInfo = new StatisticInfo();
                        StatisticMgr.getInstance().setStatisticInfo(createRequestId, statisticInfo);
                        statisticInfo.requestId = createRequestId;
                        statisticInfo.host = TextUtils.join("|", (String[]) set.toArray(new String[set.size()]));
                        statisticInfo.async = 0;
                        statisticInfo.netType = this.val$network.getNetType();
                        statisticInfo.http = 1;
                        statisticInfo.cacheType = 4;
                        DnsResolveFlow dnsResolveFlow = this.this$0;
                        NetStatusInfo netStatusInfo2 = this.val$network;
                        Set set2 = this.val$host2Update;
                        dnsResolveFlow.handleHttpDNS(netStatusInfo2, (String[]) set2.toArray(new String[set2.size()]), createRequestId);
                        statisticInfo.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                        if (StatisticMgr.getInstance().getStatistic() != null) {
                            ThreadInfo threadInfo2 = new ThreadInfo("Statistic");
                            threadInfo2.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, statisticInfo) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$1;
                                public final /* synthetic */ StatisticInfo val$rsInfo;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, statisticInfo};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$rsInfo = statisticInfo;
                                }

                                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                public void handleOper(String str2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(1048576, this, str2) == null) {
                                        StatisticMgr.getInstance().removeStatisticInfo(this.val$rsInfo.requestId);
                                        StatisticMgr.getInstance().onStatistic(this.val$rsInfo.toMap());
                                    }
                                }
                            });
                            StatisticMgr.getInstance().addTask(threadInfo2);
                        }
                    }
                }
            });
            ThreadPoolMgr.getInstance().addTask(threadInfo);
        }
    }

    private boolean isDead(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65553, this, j2)) == null) ? System.currentTimeMillis() >= j2 + ((long) (GlobalTools.TTL_LIVE_SECOND * 1000)) : invokeJ.booleanValue;
    }

    private boolean isExpired(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65554, this, j2)) == null) ? System.currentTimeMillis() >= j2 : invokeJ.booleanValue;
    }

    private boolean isHostDead(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65555, this, j2)) == null) ? System.currentTimeMillis() >= j2 + ((long) (GlobalTools.TTL_HOST_ALIVE_SECOND * 1000)) : invokeJ.booleanValue;
    }

    private boolean isNearlyExpired(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65556, this, j2)) == null) ? j2 - System.currentTimeMillis() < ((long) GlobalTools.TTL_NEARLY_EXPIRED_TIME_SPAN) : invokeJ.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void judgeUpdateHost(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65557, this, str, i2, i3) == null) && i2 == 0 && i3 == 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            updateHostList(arrayList, false);
        }
    }

    private int synUpdateHostList(ArrayList<String> arrayList, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLZ = interceptable.invokeLZ(65558, this, arrayList, z)) != null) {
            return invokeLZ.intValue;
        }
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (GlobalTools.APP_CONTEXT != null) {
                    if (this.mNetStatusReceiver == null) {
                        this.mNetStatusReceiver = new NetStatusReceiver(new NetStatusReceiver.ChangeNetworkInter(this) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.6
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ DnsResolveFlow this$0;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                            }

                            @Override // com.yy.gslbsdk.device.NetStatusReceiver.ChangeNetworkInter
                            public void onNetStateChanged() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    AsynTaskMgr.INSTANCE.postDelayed(this.this$0.mRunnable, 2000L);
                                }
                            }
                        });
                    }
                    this.mNetStatusReceiver.register(GlobalTools.APP_CONTEXT);
                    LogTools.printDebug(TAG, "beginNetworkMonitor...");
                    return 0;
                }
                return 5;
            }
        }
        return invokeV.intValue;
    }

    public synchronized int beginTTLMonitor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                if (GlobalTools.APP_CONTEXT != null) {
                    TimerTaskInfo timerTaskInfo = new TimerTaskInfo();
                    timerTaskInfo.setTaskName(GlobalTools.TTL_MONITOR_NAME);
                    timerTaskInfo.setWorker(new TimerTask(this) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DnsResolveFlow this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.handleTTL();
                            }
                        }
                    });
                    TimerMgr.getInstance().addWorker(timerTaskInfo, 0L, GlobalTools.TTL_MONITOR_PERIOD);
                    LogTools.printDebug(TAG, "beginTTLMonitor...");
                    return 0;
                }
                return 5;
            }
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DnsResultInfo handleDNS(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        InterceptResult invokeCommon;
        String str2;
        String str3;
        String str4;
        long j2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)})) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            DataCacheMgr.INSTANCE.addInvokeApiNum(str);
            String trim = str.trim();
            String createRequestId = createRequestId();
            StatisticInfo statisticInfo = new StatisticInfo();
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
                                threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, statisticInfo) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.8
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ DnsResolveFlow this$0;
                                    public final /* synthetic */ StatisticInfo val$rsInfo;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, statisticInfo};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$0 = this;
                                        this.val$rsInfo = statisticInfo;
                                    }

                                    @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                    public void handleOper(String str5) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str5) == null) {
                                            StatisticMgr.getInstance().removeStatisticInfo(this.val$rsInfo.requestId);
                                            StatisticMgr.getInstance().onStatistic(this.val$rsInfo.toMap());
                                        }
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
                                threadInfo2.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, statisticInfo) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.8
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ DnsResolveFlow this$0;
                                    public final /* synthetic */ StatisticInfo val$rsInfo;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = objArr;
                                            Object[] objArr = {this, statisticInfo};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$0 = this;
                                        this.val$rsInfo = statisticInfo;
                                    }

                                    @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                    public void handleOper(String str5) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str5) == null) {
                                            StatisticMgr.getInstance().removeStatisticInfo(this.val$rsInfo.requestId);
                                            StatisticMgr.getInstance().onStatistic(this.val$rsInfo.toMap());
                                        }
                                    }
                                });
                                StatisticMgr.getInstance().addTask(threadInfo2, 5000L);
                            }
                            return dnsResultInfo;
                        } else {
                            if (z4) {
                                str3 = createRequestId;
                                str4 = "Statistic";
                                j2 = 5000;
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
                                            threadInfo3.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, statisticInfo) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.8
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;
                                                public final /* synthetic */ DnsResolveFlow this$0;
                                                public final /* synthetic */ StatisticInfo val$rsInfo;

                                                {
                                                    Interceptable interceptable2 = $ic;
                                                    if (interceptable2 != null) {
                                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                                        newInitContext.initArgs = objArr;
                                                        Object[] objArr = {this, statisticInfo};
                                                        interceptable2.invokeUnInit(65536, newInitContext);
                                                        int i32 = newInitContext.flag;
                                                        if ((i32 & 1) != 0) {
                                                            int i4 = i32 & 2;
                                                            newInitContext.thisArg = this;
                                                            interceptable2.invokeInitBody(65536, newInitContext);
                                                            return;
                                                        }
                                                    }
                                                    this.this$0 = this;
                                                    this.val$rsInfo = statisticInfo;
                                                }

                                                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                                public void handleOper(String str5) {
                                                    Interceptable interceptable2 = $ic;
                                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str5) == null) {
                                                        StatisticMgr.getInstance().removeStatisticInfo(this.val$rsInfo.requestId);
                                                        StatisticMgr.getInstance().onStatistic(this.val$rsInfo.toMap());
                                                    }
                                                }
                                            });
                                            StatisticMgr.getInstance().addTask(threadInfo3, 5000L);
                                        }
                                        return dnsResultInfo;
                                    }
                                    j2 = 5000;
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
                                            threadInfo4.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, statisticInfo) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.8
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;
                                                public final /* synthetic */ DnsResolveFlow this$0;
                                                public final /* synthetic */ StatisticInfo val$rsInfo;

                                                {
                                                    Interceptable interceptable2 = $ic;
                                                    if (interceptable2 != null) {
                                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                                        newInitContext.initArgs = objArr;
                                                        Object[] objArr = {this, statisticInfo};
                                                        interceptable2.invokeUnInit(65536, newInitContext);
                                                        int i32 = newInitContext.flag;
                                                        if ((i32 & 1) != 0) {
                                                            int i42 = i32 & 2;
                                                            newInitContext.thisArg = this;
                                                            interceptable2.invokeInitBody(65536, newInitContext);
                                                            return;
                                                        }
                                                    }
                                                    this.this$0 = this;
                                                    this.val$rsInfo = statisticInfo;
                                                }

                                                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                                public void handleOper(String str52) {
                                                    Interceptable interceptable2 = $ic;
                                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str52) == null) {
                                                        StatisticMgr.getInstance().removeStatisticInfo(this.val$rsInfo.requestId);
                                                        StatisticMgr.getInstance().onStatistic(this.val$rsInfo.toMap());
                                                    }
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
                                                threadInfo5.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, statisticInfo) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.8
                                                    public static /* synthetic */ Interceptable $ic;
                                                    public transient /* synthetic */ FieldHolder $fh;
                                                    public final /* synthetic */ DnsResolveFlow this$0;
                                                    public final /* synthetic */ StatisticInfo val$rsInfo;

                                                    {
                                                        Interceptable interceptable2 = $ic;
                                                        if (interceptable2 != null) {
                                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                                            newInitContext.initArgs = objArr;
                                                            Object[] objArr = {this, statisticInfo};
                                                            interceptable2.invokeUnInit(65536, newInitContext);
                                                            int i32 = newInitContext.flag;
                                                            if ((i32 & 1) != 0) {
                                                                int i42 = i32 & 2;
                                                                newInitContext.thisArg = this;
                                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                                return;
                                                            }
                                                        }
                                                        this.this$0 = this;
                                                        this.val$rsInfo = statisticInfo;
                                                    }

                                                    @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                                    public void handleOper(String str52) {
                                                        Interceptable interceptable2 = $ic;
                                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str52) == null) {
                                                            StatisticMgr.getInstance().removeStatisticInfo(this.val$rsInfo.requestId);
                                                            StatisticMgr.getInstance().onStatistic(this.val$rsInfo.toMap());
                                                        }
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
                                    threadInfo6.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, statisticInfo) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.8
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ DnsResolveFlow this$0;
                                        public final /* synthetic */ StatisticInfo val$rsInfo;

                                        {
                                            Interceptable interceptable2 = $ic;
                                            if (interceptable2 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = objArr;
                                                Object[] objArr = {this, statisticInfo};
                                                interceptable2.invokeUnInit(65536, newInitContext);
                                                int i32 = newInitContext.flag;
                                                if ((i32 & 1) != 0) {
                                                    int i42 = i32 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable2.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$0 = this;
                                            this.val$rsInfo = statisticInfo;
                                        }

                                        @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                        public void handleOper(String str52) {
                                            Interceptable interceptable2 = $ic;
                                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, str52) == null) {
                                                StatisticMgr.getInstance().removeStatisticInfo(this.val$rsInfo.requestId);
                                                StatisticMgr.getInstance().onStatistic(this.val$rsInfo.toMap());
                                            }
                                        }
                                    });
                                    StatisticMgr.getInstance().addTask(threadInfo6, j2);
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
                                threadInfo7.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, statisticInfo) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.8
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ DnsResolveFlow this$0;
                                    public final /* synthetic */ StatisticInfo val$rsInfo;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = objArr;
                                            Object[] objArr = {this, statisticInfo};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i32 = newInitContext.flag;
                                            if ((i32 & 1) != 0) {
                                                int i42 = i32 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$0 = this;
                                        this.val$rsInfo = statisticInfo;
                                    }

                                    @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                    public void handleOper(String str52) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str52) == null) {
                                            StatisticMgr.getInstance().removeStatisticInfo(this.val$rsInfo.requestId);
                                            StatisticMgr.getInstance().onStatistic(this.val$rsInfo.toMap());
                                        }
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
                threadInfo8.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, statisticInfo) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DnsResolveFlow this$0;
                    public final /* synthetic */ StatisticInfo val$rsInfo;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = objArr;
                            Object[] objArr = {this, statisticInfo};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i32 = newInitContext.flag;
                            if ((i32 & 1) != 0) {
                                int i42 = i32 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$rsInfo = statisticInfo;
                    }

                    @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                    public void handleOper(String str52) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str52) == null) {
                            StatisticMgr.getInstance().removeStatisticInfo(this.val$rsInfo.requestId);
                            StatisticMgr.getInstance().onStatistic(this.val$rsInfo.toMap());
                        }
                    }
                });
                StatisticMgr.getInstance().addTask(threadInfo8, 5000L);
            }
            return dnsResultInfo;
        }
        return (DnsResultInfo) invokeCommon.objValue;
    }

    public int handleDnsSync(String str, String str2, NetStatusInfo netStatusInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, netStatusInfo)) == null) ? handleDnsSync(new String[]{str}, str2, netStatusInfo) : invokeLLL.intValue;
    }

    public int handleHttpDNSIgnoreCache(NetStatusInfo netStatusInfo, String[] strArr, ResInfo resInfo, boolean z) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{netStatusInfo, strArr, resInfo, Boolean.valueOf(z)})) == null) {
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
        return invokeCommon.intValue;
    }

    public synchronized int stopNetworkMonitor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                if (GlobalTools.APP_CONTEXT != null) {
                    if (this.mNetStatusReceiver != null) {
                        this.mNetStatusReceiver.unregister(GlobalTools.APP_CONTEXT);
                    }
                    return 0;
                }
                return 5;
            }
        }
        return invokeV.intValue;
    }

    public void updateHostList(ArrayList<String> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, arrayList, z) == null) {
            AsynTaskMgr.INSTANCE.updateHost(arrayList, z);
        }
    }

    public int handleDnsSync(String[] strArr, String str, NetStatusInfo netStatusInfo) {
        InterceptResult invokeLLL;
        AtomicBoolean atomicBoolean;
        AtomicInteger atomicInteger;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, strArr, str, netStatusInfo)) == null) {
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
        return invokeLLL.intValue;
    }
}
