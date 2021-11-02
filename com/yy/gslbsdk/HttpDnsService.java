package com.yy.gslbsdk;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes2.dex */
public class HttpDnsService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HttpDnsService";
    public static HttpDnsService mHttpDnsService;
    public transient /* synthetic */ FieldHolder $fh;
    public DegradationFilter mDegradationFilter;
    public AtomicBoolean mInit;

    /* loaded from: classes2.dex */
    public interface DegradationFilter {
        boolean shouldDegradeHttpDNS(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(628547291, "Lcom/yy/gslbsdk/HttpDnsService;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(628547291, "Lcom/yy/gslbsdk/HttpDnsService;");
        }
    }

    public HttpDnsService() {
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
        this.mDegradationFilter = null;
        this.mInit = new AtomicBoolean(false);
    }

    public static synchronized void destroyService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (HttpDnsService.class) {
                ThreadPoolMgr.getInstance().stop(200L);
                AsynTaskMgr.INSTANCE.stopMonitors();
                AsynTaskMgr.INSTANCE.stop();
                LogTools.printDebug(TAG, "destroyService, mHttpDnsService: " + mHttpDnsService);
                mHttpDnsService = null;
            }
        }
    }

    public static synchronized HttpDnsService getService(Context context, String str, ThreadPoolMgr.ITaskExecutor iTaskExecutor, String str2) {
        InterceptResult invokeLLLL;
        HttpDnsService service;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, iTaskExecutor, str2)) == null) {
            synchronized (HttpDnsService.class) {
                service = getService(context, str, iTaskExecutor, str2, false);
            }
            return service;
        }
        return (HttpDnsService) invokeLLLL.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
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
    }

    @Deprecated
    public void cancelRequest(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
            LogTools.printDebug(TAG, "This interface is Deprecated.");
        }
    }

    public DegradationFilter getDegradationFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDegradationFilter : (DegradationFilter) invokeV.objValue;
    }

    public String getGslbID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? DataCacheMgr.INSTANCE.getIdentity(GlobalTools.APP_CONTEXT) : (String) invokeV.objValue;
    }

    public DnsResultInfo getIpsByHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? getIpsByHost(str, false) : (DnsResultInfo) invokeL.objValue;
    }

    public DnsResultInfo getIpsByHostAsync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? getIpsByHostAsync(str, false) : (DnsResultInfo) invokeL.objValue;
    }

    @Deprecated
    public int getNextRequestId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            LogTools.printDebug(TAG, "This interface is Deprecated.");
            return -1;
        }
        return invokeV.intValue;
    }

    public String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? "2.2.18-lianyun" : (String) invokeV.objValue;
    }

    public void loadAssetsIp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            ExternalCache.getInstance().loadFromAssets(GlobalTools.APP_CONTEXT, str);
        }
    }

    public void setBackgroundModel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            GlobalTools.IS_BACKGOUND_MODEL = z;
        }
    }

    public void setCacheMaxExpired(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            GlobalTools.TTL_HOST_ALIVE_SECOND = Math.max(GlobalTools.TTL_HOST_ALIVE_SECOND, i2);
        }
    }

    public void setDectorHost(String str, int i2, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), str2}) == null) {
            QualityDetectFlow.getInstance().updateDectorList(str, i2, i3, str2);
        }
    }

    public void setDegradationFilter(DegradationFilter degradationFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, degradationFilter) == null) {
            this.mDegradationFilter = degradationFilter;
        }
    }

    public void setEnableIpv6(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            IpVersionController.getInstance().setEnableIpv6(z);
        }
    }

    public void setExternalIpData(Map<String, Map<String, List<String>>> map, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, map, i2) == null) {
            ExternalCache.getInstance().setData(map);
            ExternalCache.getInstance().setScene(i2);
        }
    }

    public void setExternalIpEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            ExternalCache.getInstance().setEnable(z);
        }
    }

    public void setExternalIpNetType(ExternalCache.NetType netType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, netType) == null) {
            ExternalCache.getInstance().setNetType(netType);
        }
    }

    public void setExternalIpScene(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            ExternalCache.getInstance().setScene(i2);
        }
    }

    public void setGslbEventMessager(GslbEvent.GslbEventListener gslbEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, gslbEventListener) == null) {
            GslbEvent.INSTANCE.setListener(gslbEventListener);
        }
    }

    public void setGslbStatistic(StatisticMgr.IGslbStatistic iGslbStatistic) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, iGslbStatistic) == null) {
            StatisticMgr.getInstance().setStatistic(iGslbStatistic);
        }
    }

    public void setHttpsEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            if (z) {
                setHttpsEnable(1);
            } else {
                setHttpsEnable(0);
            }
        }
    }

    public void setLogEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            GlobalTools.LOG_IS_OPEN = z;
        }
    }

    public void setMinTTL(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048604, this, i2) == null) || i2 < 180) {
            return;
        }
        GlobalTools.sMinSecondTTL = i2;
    }

    public void setNetworkStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            IpVersionController.getInstance().setNetworkStatus(i2);
        }
    }

    @Deprecated
    public void setNetworkSupportV6(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            IpVersionController.getInstance().setNetworkStatus(z ? 3 : 1);
        }
    }

    @Deprecated
    public void setPreResolveAfterNetworkChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            GlobalTools.REFRESH_AFTER_NETWORK_CHANGE = z;
        }
    }

    public void setPreResolveHosts(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, arrayList) == null) {
            DnsResolveFlow.getInstance().updateHostList(arrayList, true);
        }
    }

    public void setReport(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{str, str2, Long.valueOf(j)}) == null) && QualityDetectFlow.getInstance().canReport(str)) {
            QualityDetectFlow.getInstance().addReportData(str, str2, j);
        }
    }

    public static synchronized HttpDnsService getService(Context context, String str, ThreadPoolMgr.ITaskExecutor iTaskExecutor, String str2, boolean z) {
        InterceptResult invokeCommon;
        HttpDnsService service;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{context, str, iTaskExecutor, str2, Boolean.valueOf(z)})) == null) {
            synchronized (HttpDnsService.class) {
                service = getService(context, str, iTaskExecutor, str2, z, "");
            }
            return service;
        }
        return (HttpDnsService) invokeCommon.objValue;
    }

    @Deprecated
    public DnsResultInfo getIpsByHost(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i2)) == null) ? getIpsByHost(str) : (DnsResultInfo) invokeLI.objValue;
    }

    public DnsResultInfo getIpsByHostAsync(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z)) == null) ? getIpsByHostAsync(str, z, true) : (DnsResultInfo) invokeLZ.objValue;
    }

    public void setPreResolveHosts(ArrayList<String> arrayList, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048609, this, arrayList, j) == null) {
            AsynTaskMgr.INSTANCE.postDelayed(new Runnable(this, arrayList) { // from class: com.yy.gslbsdk.HttpDnsService.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HttpDnsService this$0;
                public final /* synthetic */ ArrayList val$hostList;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, arrayList};
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
                    this.val$hostList = arrayList;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        DnsResolveFlow.getInstance().updateHostList(this.val$hostList, true);
                    }
                }
            }, j);
        }
    }

    public static synchronized HttpDnsService getService(Context context, String str, ThreadPoolMgr.ITaskExecutor iTaskExecutor, String str2, boolean z, String str3) {
        InterceptResult invokeCommon;
        HttpDnsService service;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{context, str, iTaskExecutor, str2, Boolean.valueOf(z), str3})) == null) {
            synchronized (HttpDnsService.class) {
                service = getService(context, str, iTaskExecutor, str2, "CN", z, str3);
            }
            return service;
        }
        return (HttpDnsService) invokeCommon.objValue;
    }

    public DnsResultInfo getIpsByHost(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, str, z)) == null) ? getIpsByHost(str, z, true) : (DnsResultInfo) invokeLZ.objValue;
    }

    public DnsResultInfo getIpsByHostAsync(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
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
        return (DnsResultInfo) invokeCommon.objValue;
    }

    public void setExternalIpData(Map<String, Map<String, List<String>>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, map) == null) {
            ExternalCache.getInstance().setData(map);
        }
    }

    public void setHttpsEnable(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            HttpsLevelMgr.getInstance().setHttpsLevel(i2);
        }
    }

    @Deprecated
    public static synchronized HttpDnsService getService(Context context, String str, ThreadPoolMgr.ITaskExecutor iTaskExecutor, String str2, String str3) {
        InterceptResult invokeLLLLL;
        HttpDnsService service;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(AdIconUtil.AD_TEXT_ID, null, context, str, iTaskExecutor, str2, str3)) == null) {
            synchronized (HttpDnsService.class) {
                service = getService(context, str, iTaskExecutor, str2, str3, false);
            }
            return service;
        }
        return (HttpDnsService) invokeLLLLL.objValue;
    }

    public DnsResultInfo getIpsByHost(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
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
        return (DnsResultInfo) invokeCommon.objValue;
    }

    @Deprecated
    public static synchronized HttpDnsService getService(Context context, String str, ThreadPoolMgr.ITaskExecutor iTaskExecutor, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        HttpDnsService service;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, str, iTaskExecutor, str2, str3, Boolean.valueOf(z)})) == null) {
            synchronized (HttpDnsService.class) {
                service = getService(context, str, iTaskExecutor, str2, str3, z, "");
            }
            return service;
        }
        return (HttpDnsService) invokeCommon.objValue;
    }

    @Deprecated
    public static synchronized HttpDnsService getService(Context context, String str, ThreadPoolMgr.ITaskExecutor iTaskExecutor, String str2, String str3, boolean z, String str4) {
        InterceptResult invokeCommon;
        HttpDnsService httpDnsService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{context, str, iTaskExecutor, str2, str3, Boolean.valueOf(z), str4})) == null) {
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
        return (HttpDnsService) invokeCommon.objValue;
    }

    public static synchronized HttpDnsService getService() {
        InterceptResult invokeV;
        HttpDnsService httpDnsService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (HttpDnsService.class) {
                httpDnsService = mHttpDnsService;
            }
            return httpDnsService;
        }
        return (HttpDnsService) invokeV.objValue;
    }
}
