package com.yy.gslbsdk.flow;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DnsResolveFlow";
    public static DnsResolveFlow mDnsResolveFlow;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicInteger mIncreaseId;
    public NetStatusReceiver mNetStatusReceiver;
    public ConcurrentHashMap mPendingHttpCode;
    public ConcurrentHashMap mPendingReqs;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIncreaseId = new AtomicInteger(1);
        this.mPendingReqs = new ConcurrentHashMap();
        this.mPendingHttpCode = new ConcurrentHashMap();
        this.mNetStatusReceiver = null;
        this.mRunnable = new Runnable(this) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.4
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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

    public synchronized int beginNetworkMonitor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (GlobalTools.APP_CONTEXT != null) {
                    if (this.mNetStatusReceiver == null) {
                        this.mNetStatusReceiver = new NetStatusReceiver(new NetStatusReceiver.ChangeNetworkInter(this) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.5
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
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
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
                    timerTaskInfo.setWorker(new TimerTask(this) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.6
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
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
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

    public String createRequestId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String identity = DataCacheMgr.INSTANCE.getIdentity(GlobalTools.APP_CONTEXT);
            return identity + "_" + System.currentTimeMillis() + "_" + this.mIncreaseId.getAndIncrement();
        }
        return (String) invokeV.objValue;
    }

    private int deleteHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
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

    private boolean isDead(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65551, this, j)) == null) {
            if (System.currentTimeMillis() >= j + (GlobalTools.TTL_LIVE_SECOND * 1000)) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    private boolean isExpired(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65552, this, j)) == null) {
            if (System.currentTimeMillis() >= j) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    private boolean isHostDead(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65553, this, j)) == null) {
            if (System.currentTimeMillis() >= j + (GlobalTools.TTL_HOST_ALIVE_SECOND * 1000)) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    private boolean isNearlyExpired(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65554, this, j)) == null) {
            if (j - System.currentTimeMillis() < GlobalTools.TTL_NEARLY_EXPIRED_TIME_SPAN) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    private void collectStat0(long j, DnsResultInfo dnsResultInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65542, this, j, dnsResultInfo) == null) {
            DataCacheMgr.INSTANCE.addDnsCost(SystemClock.uptimeMillis() - j);
            if (dnsResultInfo.mErrorCode != 0) {
                DataCacheMgr.INSTANCE.addFailedDnsCount();
            } else if (dnsResultInfo.mDataSource == 4) {
                DataCacheMgr.INSTANCE.addLocalDnsCount();
            }
        }
    }

    public void updateHostList(ArrayList arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, arrayList, z) == null) {
            AsynTaskMgr.INSTANCE.updateHost(arrayList, z);
        }
    }

    public static DnsResolveFlow getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (mDnsResolveFlow == null) {
                mDnsResolveFlow = new DnsResolveFlow();
            }
            return mDnsResolveFlow;
        }
        return (DnsResolveFlow) invokeV.objValue;
    }

    public synchronized int stopNetworkMonitor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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

    private int handleDegradation(String str, DnsResultInfo dnsResultInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, str, dnsResultInfo)) == null) {
            LogTools.printDebug(TAG, String.format(Locale.US, "handleDegradation, start, host: %s", str));
            AtomicInteger atomicInteger = new AtomicInteger(-1);
            synchronized (atomicInteger) {
                String str2 = "LocalDNS-" + str;
                ThreadInfo threadInfo = new ThreadInfo(str2);
                threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, str, dnsResultInfo, atomicInteger, str2) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.1
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
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
        return invokeLL.intValue;
    }

    private void handleDnsAsync(String str, String str2, NetStatusInfo netStatusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, this, str, str2, netStatusInfo) == null) {
            ThreadInfo threadInfo = new ThreadInfo("HttpDNS-" + netStatusInfo.getNetStatusID() + "-" + str);
            threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, str, str2, netStatusInfo) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.8
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    private int[] handleDnsCache(String str, DnsResultInfo dnsResultInfo, NetStatusInfo netStatusInfo, String str2, int i, boolean z) {
        InterceptResult invokeCommon;
        ?? r14;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, this, new Object[]{str, dnsResultInfo, netStatusInfo, str2, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
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
                    Map filterIpVer = IpVersionController.filterIpVer(dnsInfo.getIps());
                    String[] strArr = new String[0];
                    String[] strArr2 = new String[0];
                    List list = (List) filterIpVer.get(6);
                    if (list != null && !list.isEmpty()) {
                        strArr2 = (String[]) list.toArray(new String[0]);
                    }
                    List list2 = (List) filterIpVer.get(4);
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
        boolean z2;
        String str3;
        ThreadInfo threadInfo;
        DnsResolveFlow dnsResolveFlow;
        int i;
        int i2;
        StatisticInfo statisticInfo;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, this, netStatusInfo, strArr, str)) == null) {
            NetworkStatus networkStatus = netStatusInfo.getNetworkStatus();
            int i3 = 3;
            int i4 = 2;
            LogTools.printDebug(TAG, String.format(Locale.US, "handleHttpDNS, start, network: %s, host: %s, requestId: %s", networkStatus.toString(), Arrays.toString(strArr), str));
            ArrayList bestServerIPCache = IpVersionController.getInstance().getBestServerIPCache(networkStatus);
            i3 = (networkStatus.canV6() && networkStatus.canV4()) ? 2 : 2;
            LogTools.printDebug(TAG, String.format(Locale.US, "handleHttpDNS, minSrvIp: %d, best: %s", Integer.valueOf(i3), bestServerIPCache.toString()));
            if (bestServerIPCache.size() < i3) {
                if (netStatusInfo.isKnowIsp()) {
                    bestServerIPCache = IpVersionController.getInstance().getServerIPByKnownISP(GlobalTools.APP_CONTEXT, netStatusInfo.getIsp(), networkStatus);
                } else {
                    bestServerIPCache = IpVersionController.getInstance().getServerIPByUnKnownISP(GlobalTools.APP_CONTEXT, networkStatus);
                }
                LogTools.printDebug(TAG, String.format(Locale.US, "handleHttpDNS, cache: %s", bestServerIPCache.toString()));
            }
            ArrayList arrayList2 = bestServerIPCache;
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
            int i5 = GlobalTools.HTTPS_LEVEL;
            synchronized (atomicInteger3) {
                int i6 = 0;
                Object obj2 = obj;
                while (i6 < arrayList2.size()) {
                    try {
                        try {
                            str2 = (String) arrayList2.get(i6);
                            if (i5 == i4) {
                                z = true;
                            } else if (i5 == 1) {
                                if (i6 < arrayList2.size() / i4) {
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
                            i = i6;
                            i2 = i5;
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
                        threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper(dnsResolveFlow, str3, str2, z, i5, str, strArr, statisticInfo2, atomicInteger4, atomicInteger, netStatusInfo) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.3
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
                                    Object[] objArr = {dnsResolveFlow, str3, str2, Boolean.valueOf(z), Integer.valueOf(i5), str, strArr, statisticInfo2, atomicInteger4, atomicInteger, netStatusInfo};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i7 = newInitContext.flag;
                                    if ((i7 & 1) != 0) {
                                        int i8 = i7 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = dnsResolveFlow;
                                this.val$taskId = str3;
                                this.val$ip = str2;
                                this.val$https = z;
                                this.val$httpsLevel = i5;
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
                                    LogTools.printDebug(DnsResolveFlow.TAG, String.format(Locale.US, "handleHttpDNS.handleOper, cost HttpDns thread[%s], requestId: %s , cost : %d", this.val$taskId, this.val$requestId, Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis)));
                                    if (requestHttpDnsV2 != null && BasicPushStatus.SUCCESS_CODE.equals(requestHttpDnsV2[0])) {
                                        LogTools.printDebug(DnsResolveFlow.TAG, String.format(Locale.US, "HttpDns succeed response serverIp: %s, requestId: %s, res: %s", this.val$ip, this.val$requestId, requestHttpDnsV2[1]));
                                        synchronized (this.val$mRequestLock) {
                                            long uptimeMillis2 = SystemClock.uptimeMillis();
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
                                            long j = uptimeMillis2 - uptimeMillis;
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
                                            serverIPInfo.setScore(j);
                                            IpVersionController.getInstance().resetBestServerIPCache(serverIPInfo);
                                            if (resInfo.getHttpdns().isRe()) {
                                                QualityDetectFlow.getInstance().addReportData(GlobalTools.HTTPDNS_REPORT_HOST, this.val$ip, j);
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
                                        } catch (Exception e) {
                                            LogTools.printWarning(DnsResolveFlow.TAG, e);
                                        }
                                        this.val$rsInfo.httpErrMsg = requestHttpDnsV2[1];
                                    } else {
                                        StatisticInfo statisticInfo3 = this.val$rsInfo;
                                        statisticInfo3.httpErrCode = -999;
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
                        i6 = i + 1;
                        i5 = i2;
                        atomicInteger3 = atomicInteger;
                        statisticInfo2 = statisticInfo;
                        arrayList2 = arrayList;
                        i4 = 2;
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
                    statisticInfo3.httpErrCode = 1;
                    statisticInfo3.httpErrMsg = "all httpdns request timeout";
                    return 1;
                }
                int i7 = atomicInteger2.get();
                return i7;
            }
        }
        return invokeLLL.intValue;
    }

    private int handleLocalDNS(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, str)) == null) {
            ThreadInfo threadInfo = new ThreadInfo("LocalDNS-" + str);
            threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, str) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.2
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65550, this) != null) || GlobalTools.IS_BACKGOUND_MODEL || !SwitchController.getInstance().switchGslb()) {
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
                    List resultByNetworkHost = IpVersionController.getInstance().getResultByNetworkHost(netStatusID, hostTB.getHost(), 1);
                    if (resultByNetworkHost != null && !resultByNetworkHost.isEmpty()) {
                        ResultTB resultTB = (ResultTB) resultByNetworkHost.get(0);
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
                    List resultByNetworkHost2 = IpVersionController.getInstance().getResultByNetworkHost(netStatusID, hostTB.getHost(), 2);
                    if (resultByNetworkHost2 != null && !resultByNetworkHost2.isEmpty()) {
                        ResultTB resultTB2 = (ResultTB) resultByNetworkHost2.get(0);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void judgeUpdateHost(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65555, this, str, i, i2) == null) && i == 0 && i2 == 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            updateHostList(arrayList, false);
        }
    }

    public int handleDnsSync(String str, String str2, NetStatusInfo netStatusInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, netStatusInfo)) == null) {
            return handleDnsSync(new String[]{str}, str2, netStatusInfo);
        }
        return invokeLLL.intValue;
    }

    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v7 */
    private int preHandleHttpDNS(NetStatusInfo netStatusInfo, String[] strArr, String str) {
        InterceptResult invokeLLL;
        int i;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65556, this, netStatusInfo, strArr, str)) == null) {
            NetworkStatus networkStatus = netStatusInfo.getNetworkStatus();
            ?? r8 = 0;
            int i2 = 1;
            int i3 = 2;
            LogTools.printDebug(TAG, String.format(Locale.US, "preHandleHttpDNS, start, network: %s, host: %s, requestId: %s", networkStatus.toString(), Arrays.toString(strArr), str));
            ArrayList bestServerIPCache = IpVersionController.getInstance().getBestServerIPCache(networkStatus);
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
                    String str2 = (String) bestServerIPCache.get(i5);
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
                    ArrayList arrayList = bestServerIPCache;
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
        return invokeLLL.intValue;
    }

    private int synUpdateHostList(ArrayList arrayList, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65557, this, arrayList, z)) == null) {
            if (GlobalTools.APP_CONTEXT != null) {
                long currentTimeMillis = System.currentTimeMillis();
                DBAccessMgr dBAccessMgr = DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    List hostByHost = dBAccessMgr.getHostByHost(str);
                    if (hostByHost.isEmpty()) {
                        HostTB hostTB = new HostTB();
                        hostTB.setHost(str);
                        hostTB.setInsertTime(currentTimeMillis);
                        hostTB.setIsPre(z ? 1 : 0);
                        dBAccessMgr.addHost(hostTB);
                    } else {
                        HostTB hostTB2 = (HostTB) hostByHost.get(0);
                        hostTB2.setInsertTime(currentTimeMillis);
                        hostTB2.setIsPre(z ? 1 : 0);
                        dBAccessMgr.updateHost(hostTB2);
                    }
                }
                List allHost = dBAccessMgr.getAllHost();
                int size = allHost.size();
                while (true) {
                    size--;
                    if (size >= GlobalTools.KEEP_HOST_NUM) {
                        dBAccessMgr.delHost((HostTB) allHost.get(size));
                    } else {
                        allHost.clear();
                        return 0;
                    }
                }
            } else {
                return 5;
            }
        } else {
            return invokeLZ.intValue;
        }
    }

    private void updateIps(NetStatusInfo netStatusInfo, Set set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, this, netStatusInfo, set) == null) {
            ThreadInfo threadInfo = new ThreadInfo("HttpDNS-TTL-Update-" + System.currentTimeMillis());
            LogTools.printDebug(TAG, String.format(Locale.US, "===== handleTTL host2Update: %s", set.toString()));
            threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, set, netStatusInfo) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.9
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
                        Object[] objArr = {this, set, netStatusInfo};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$host2Update = set;
                    this.val$network = netStatusInfo;
                }

                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                public void handleOper(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        Set set2 = this.val$host2Update;
                        String createRequestId = this.this$0.createRequestId();
                        StatisticInfo statisticInfo = new StatisticInfo();
                        StatisticMgr.getInstance().setStatisticInfo(createRequestId, statisticInfo);
                        statisticInfo.requestId = createRequestId;
                        statisticInfo.host = TextUtils.join("|", (String[]) set2.toArray(new String[set2.size()]));
                        statisticInfo.async = 0;
                        statisticInfo.netType = this.val$network.getNetType();
                        statisticInfo.http = 1;
                        statisticInfo.cacheType = 4;
                        DnsResolveFlow dnsResolveFlow = this.this$0;
                        NetStatusInfo netStatusInfo2 = this.val$network;
                        Set set3 = this.val$host2Update;
                        dnsResolveFlow.handleHttpDNS(netStatusInfo2, (String[]) set3.toArray(new String[set3.size()]), createRequestId);
                        statisticInfo.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                        if (StatisticMgr.getInstance().getStatistic() != null) {
                            ThreadInfo threadInfo2 = new ThreadInfo("Statistic");
                            threadInfo2.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, statisticInfo) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.9.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass9 this$1;
                                public final /* synthetic */ StatisticInfo val$rsInfo;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, statisticInfo};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:129:0x03c2 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v14, resolved type: com.yy.gslbsdk.statistic.StatisticInfo */
    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: int[] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v13, resolved type: char */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0409  */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DnsResultInfo handleDNS(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        InterceptResult invokeCommon;
        String str2;
        StatisticInfo statisticInfo;
        String str3;
        String str4;
        StatisticInfo statisticInfo2;
        long j;
        int i;
        StatisticInfo statisticInfo3;
        String str5;
        boolean z7;
        boolean z8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6)})) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            DataCacheMgr.INSTANCE.addInvokeApiNum(str);
            String trim = str.trim();
            String createRequestId = createRequestId();
            StatisticInfo statisticInfo4 = new StatisticInfo();
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
                                threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, statisticInfo4) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.7
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ DnsResolveFlow this$0;
                                    public final /* synthetic */ StatisticInfo val$rsInfo;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, statisticInfo4};
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
                                        this.val$rsInfo = statisticInfo4;
                                    }

                                    @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                    public void handleOper(String str6) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str6) == null) {
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
                            statisticInfo4.ts = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                            if (dnsResultInfo.mErrorCode == 0) {
                                statisticInfo4.rsIp.addAll(Arrays.asList(dnsResultInfo.mIps));
                                statisticInfo4.rsIpV4.addAll(Arrays.asList(dnsResultInfo.mIpsV4));
                                statisticInfo4.rsIpV6.addAll(Arrays.asList(dnsResultInfo.mIpsV6));
                            }
                            if (StatisticMgr.getInstance().getStatistic() != null) {
                                ThreadInfo threadInfo2 = new ThreadInfo("Statistic");
                                threadInfo2.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, statisticInfo4) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.7
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ DnsResolveFlow this$0;
                                    public final /* synthetic */ StatisticInfo val$rsInfo;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = objArr;
                                            Object[] objArr = {this, statisticInfo4};
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
                                        this.val$rsInfo = statisticInfo4;
                                    }

                                    @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                    public void handleOper(String str6) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str6) == null) {
                                            StatisticMgr.getInstance().removeStatisticInfo(this.val$rsInfo.requestId);
                                            StatisticMgr.getInstance().onStatistic(this.val$rsInfo.toMap());
                                        }
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
                                    int i2 = handleDnsCache[0];
                                    if (handleDnsCache[1] == 1) {
                                        z8 = true;
                                    } else {
                                        z8 = false;
                                    }
                                    if (z2) {
                                        if (i2 == 0 && dnsResultInfo.mIps != null && dnsResultInfo.mIps.length >= 1) {
                                            if (z8) {
                                                ExternalCache.getInstance().getResult(trim, 8, dnsResultInfo);
                                            }
                                        }
                                        ExternalCache.getInstance().getResult(trim, 4, dnsResultInfo);
                                    }
                                    i = 3;
                                    str3 = str5;
                                    LogTools.printDebug(str3, String.format(Locale.US, "===== handleDNS handleDnsCache host: %s, codeCacheHttp: %d, expiredCacheHttp: %b, forceEnableExpired: %b ,isUpdateIp: %b", trim, Integer.valueOf(i2), Boolean.valueOf(z8), Boolean.valueOf(enableExpired), Boolean.valueOf(z6)));
                                    if (i2 == 0 && (z6 || !z8)) {
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
                                            threadInfo3.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, statisticInfo4) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.7
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;
                                                public final /* synthetic */ DnsResolveFlow this$0;
                                                public final /* synthetic */ StatisticInfo val$rsInfo;

                                                {
                                                    Interceptable interceptable2 = $ic;
                                                    if (interceptable2 != null) {
                                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                                        newInitContext.initArgs = objArr;
                                                        Object[] objArr = {this, statisticInfo4};
                                                        interceptable2.invokeUnInit(65536, newInitContext);
                                                        int i22 = newInitContext.flag;
                                                        if ((i22 & 1) != 0) {
                                                            int i3 = i22 & 2;
                                                            newInitContext.thisArg = this;
                                                            interceptable2.invokeInitBody(65536, newInitContext);
                                                            return;
                                                        }
                                                    }
                                                    this.this$0 = this;
                                                    this.val$rsInfo = statisticInfo4;
                                                }

                                                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                                public void handleOper(String str6) {
                                                    Interceptable interceptable2 = $ic;
                                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str6) == null) {
                                                        StatisticMgr.getInstance().removeStatisticInfo(this.val$rsInfo.requestId);
                                                        StatisticMgr.getInstance().onStatistic(this.val$rsInfo.toMap());
                                                    }
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
                                    }
                                    if (StatisticMgr.getInstance().getStatistic() != null) {
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
                                            ThreadInfo threadInfo4 = new ThreadInfo(str4);
                                            threadInfo4.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, statisticInfo2) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.7
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;
                                                public final /* synthetic */ DnsResolveFlow this$0;
                                                public final /* synthetic */ StatisticInfo val$rsInfo;

                                                {
                                                    Interceptable interceptable2 = $ic;
                                                    if (interceptable2 != null) {
                                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                                        newInitContext.initArgs = objArr;
                                                        Object[] objArr = {this, statisticInfo2};
                                                        interceptable2.invokeUnInit(65536, newInitContext);
                                                        int i22 = newInitContext.flag;
                                                        if ((i22 & 1) != 0) {
                                                            int i3 = i22 & 2;
                                                            newInitContext.thisArg = this;
                                                            interceptable2.invokeInitBody(65536, newInitContext);
                                                            return;
                                                        }
                                                    }
                                                    this.this$0 = this;
                                                    this.val$rsInfo = statisticInfo2;
                                                }

                                                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                                public void handleOper(String str6) {
                                                    Interceptable interceptable2 = $ic;
                                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str6) == null) {
                                                        StatisticMgr.getInstance().removeStatisticInfo(this.val$rsInfo.requestId);
                                                        StatisticMgr.getInstance().onStatistic(this.val$rsInfo.toMap());
                                                    }
                                                }
                                            });
                                            StatisticMgr.getInstance().addTask(threadInfo4, j);
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
                                    StatisticInfo statisticInfo5 = statisticInfo2;
                                    String str6 = str3;
                                    try {
                                        int[] handleDnsCache2 = handleDnsCache(createRequestId, dnsResultInfo, cachedNetStatusInfo, trim, handleDnsSync, false);
                                        int i3 = handleDnsCache2[0];
                                        statisticInfo = handleDnsCache2[1];
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
                                                    ThreadInfo threadInfo5 = new ThreadInfo(str2);
                                                    threadInfo5.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, statisticInfo5) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.7
                                                        public static /* synthetic */ Interceptable $ic;
                                                        public transient /* synthetic */ FieldHolder $fh;
                                                        public final /* synthetic */ DnsResolveFlow this$0;
                                                        public final /* synthetic */ StatisticInfo val$rsInfo;

                                                        {
                                                            Interceptable interceptable2 = $ic;
                                                            if (interceptable2 != null) {
                                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                                newInitContext.initArgs = objArr;
                                                                Object[] objArr2 = {this, statisticInfo5};
                                                                interceptable2.invokeUnInit(65536, newInitContext);
                                                                int i22 = newInitContext.flag;
                                                                if ((i22 & 1) != 0) {
                                                                    int i32 = i22 & 2;
                                                                    newInitContext.thisArg = this;
                                                                    interceptable2.invokeInitBody(65536, newInitContext);
                                                                    return;
                                                                }
                                                            }
                                                            this.this$0 = this;
                                                            this.val$rsInfo = statisticInfo5;
                                                        }

                                                        @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                                        public void handleOper(String str62) {
                                                            Interceptable interceptable2 = $ic;
                                                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, str62) == null) {
                                                                StatisticMgr.getInstance().removeStatisticInfo(this.val$rsInfo.requestId);
                                                                StatisticMgr.getInstance().onStatistic(this.val$rsInfo.toMap());
                                                            }
                                                        }
                                                    });
                                                    StatisticMgr.getInstance().addTask(threadInfo5, 5000L);
                                                }
                                                return dnsResultInfo;
                                            }
                                            statisticInfo3 = statisticInfo5;
                                            if (handleDnsSync == 0 && i3 != 0) {
                                                LogTools.printDebug(str6, String.format(Locale.US, "%s not support by gslb", trim));
                                            }
                                            if (dnsResultInfo.mDataSource == 0 && z5) {
                                                handleLocalDNS(trim);
                                            }
                                            if (i3 != 0 || dnsResultInfo.mIps == null || dnsResultInfo.mIps.length < 1) {
                                                ExternalCache.getInstance().getResult(trim, 2, dnsResultInfo);
                                            }
                                            judgeUpdateHost(trim, handleDnsSync, i3);
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
                                                ThreadInfo threadInfo6 = new ThreadInfo(str2);
                                                threadInfo6.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, statisticInfo) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.7
                                                    public static /* synthetic */ Interceptable $ic;
                                                    public transient /* synthetic */ FieldHolder $fh;
                                                    public final /* synthetic */ DnsResolveFlow this$0;
                                                    public final /* synthetic */ StatisticInfo val$rsInfo;

                                                    {
                                                        Interceptable interceptable2 = $ic;
                                                        if (interceptable2 != null) {
                                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                                            newInitContext.initArgs = objArr2;
                                                            Object[] objArr2 = {this, statisticInfo};
                                                            interceptable2.invokeUnInit(65536, newInitContext);
                                                            int i22 = newInitContext.flag;
                                                            if ((i22 & 1) != 0) {
                                                                int i32 = i22 & 2;
                                                                newInitContext.thisArg = this;
                                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                                return;
                                                            }
                                                        }
                                                        this.this$0 = this;
                                                        this.val$rsInfo = statisticInfo;
                                                    }

                                                    @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                                    public void handleOper(String str62) {
                                                        Interceptable interceptable2 = $ic;
                                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str62) == null) {
                                                            StatisticMgr.getInstance().removeStatisticInfo(this.val$rsInfo.requestId);
                                                            StatisticMgr.getInstance().onStatistic(this.val$rsInfo.toMap());
                                                        }
                                                    }
                                                });
                                                StatisticMgr.getInstance().addTask(threadInfo6, 5000L);
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        statisticInfo = statisticInfo5;
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
                                    threadInfo7.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, statisticInfo3) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.7
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ DnsResolveFlow this$0;
                                        public final /* synthetic */ StatisticInfo val$rsInfo;

                                        {
                                            Interceptable interceptable2 = $ic;
                                            if (interceptable2 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = objArr2;
                                                Object[] objArr2 = {this, statisticInfo3};
                                                interceptable2.invokeUnInit(65536, newInitContext);
                                                int i22 = newInitContext.flag;
                                                if ((i22 & 1) != 0) {
                                                    int i32 = i22 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable2.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$0 = this;
                                            this.val$rsInfo = statisticInfo3;
                                        }

                                        @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                                        public void handleOper(String str62) {
                                            Interceptable interceptable2 = $ic;
                                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, str62) == null) {
                                                StatisticMgr.getInstance().removeStatisticInfo(this.val$rsInfo.requestId);
                                                StatisticMgr.getInstance().onStatistic(this.val$rsInfo.toMap());
                                            }
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
                threadInfo8.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, statisticInfo4) { // from class: com.yy.gslbsdk.flow.DnsResolveFlow.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DnsResolveFlow this$0;
                    public final /* synthetic */ StatisticInfo val$rsInfo;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = objArr2;
                            Object[] objArr2 = {this, statisticInfo4};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i22 = newInitContext.flag;
                            if ((i22 & 1) != 0) {
                                int i32 = i22 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$rsInfo = statisticInfo4;
                    }

                    @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                    public void handleOper(String str62) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str62) == null) {
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

    public int handleDnsSync(String[] strArr, String str, NetStatusInfo netStatusInfo) {
        InterceptResult invokeLLL;
        AtomicBoolean atomicBoolean;
        AtomicInteger atomicInteger;
        char c;
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, strArr, str, netStatusInfo)) == null) {
            String str3 = TextUtils.join(",", strArr) + netStatusInfo.getNetStatusID();
            StatisticInfo statisticInfo = StatisticMgr.getInstance().getStatisticInfo(str);
            LogTools.printDebug(TAG, String.format(Locale.US, "handleDnsSync, start, key: %s, requestId: %s", str3, str));
            synchronized (this.mPendingReqs) {
                atomicBoolean = (AtomicBoolean) this.mPendingReqs.get(str3);
                if (atomicBoolean == null) {
                    atomicBoolean = new AtomicBoolean(false);
                    this.mPendingReqs.putIfAbsent(str3, atomicBoolean);
                }
                atomicInteger = (AtomicInteger) this.mPendingHttpCode.get(str3);
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
        return invokeLLL.intValue;
    }

    public int handleHttpDNSIgnoreCache(NetStatusInfo netStatusInfo, String[] strArr, ResInfo resInfo, boolean z) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{netStatusInfo, strArr, resInfo, Boolean.valueOf(z)})) == null) {
            ArrayList bestServerIPCache = IpVersionController.getInstance().getBestServerIPCache(netStatusInfo.getNetworkStatus());
            if (bestServerIPCache.isEmpty()) {
                str = IpVersionController.getInstance().getOneServerIPByUnKnownISP(GlobalTools.APP_CONTEXT, netStatusInfo.getNetworkStatus());
            } else {
                str = (String) bestServerIPCache.get(0);
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

    public synchronized void preHost() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
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
        }
    }

    public synchronized void preHost(ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            synchronized (this) {
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
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (hashSet.size() >= 10) {
                        break;
                    }
                    hashSet.add(str);
                }
                if (!hashSet.isEmpty()) {
                    updateIps(netStatusInfo, hashSet);
                }
            }
        }
    }
}
