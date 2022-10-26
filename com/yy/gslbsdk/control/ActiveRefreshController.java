package com.yy.gslbsdk.control;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.u;
import com.yy.gslbsdk.cache.DataCacheMgr;
import com.yy.gslbsdk.device.NetStatusInfo;
import com.yy.gslbsdk.flow.DnsResolveFlow;
import com.yy.gslbsdk.protocol.DnsInfo;
import com.yy.gslbsdk.protocol.ResInfo;
import com.yy.gslbsdk.thread.ThreadInfo;
import com.yy.gslbsdk.thread.ThreadPoolMgr;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class ActiveRefreshController {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ActiveRefreshController";
    public static ActiveRefreshController sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-358982968, "Lcom/yy/gslbsdk/control/ActiveRefreshController;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-358982968, "Lcom/yy/gslbsdk/control/ActiveRefreshController;");
        }
    }

    public ActiveRefreshController() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static synchronized ActiveRefreshController getInstance() {
        InterceptResult invokeV;
        ActiveRefreshController activeRefreshController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (ActiveRefreshController.class) {
                if (sInstance == null) {
                    sInstance = new ActiveRefreshController();
                }
                activeRefreshController = sInstance;
            }
            return activeRefreshController;
        }
        return (ActiveRefreshController) invokeV.objValue;
    }

    public static void refreshHostCache(ResInfo resInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, resInfo) != null) || resInfo == null) {
            return;
        }
        NetStatusInfo cachedNetStatusInfo = DataCacheMgr.INSTANCE.getCachedNetStatusInfo();
        ArrayList arrayList = new ArrayList();
        List listRefresh = resInfo.getListRefresh();
        if (listRefresh != null && !listRefresh.isEmpty()) {
            for (int i = 0; i < listRefresh.size(); i++) {
                try {
                    Map map = (Map) listRefresh.get(i);
                    if (map != null && !map.isEmpty()) {
                        String str = (String) map.get(u.A);
                        if (!TextUtils.isEmpty(str)) {
                            String str2 = (String) map.get("ut");
                            if (!TextUtils.isEmpty(str2) && TextUtils.isDigitsOnly(str2)) {
                                long longValue = Long.valueOf(str2).longValue() * 1000;
                                if (longValue >= 1) {
                                    DnsInfo dnsInfo = new DnsInfo();
                                    if (IpVersionController.getInstance().getHttpDNSFromCache(GlobalTools.APP_CONTEXT, cachedNetStatusInfo, str, dnsInfo) == 0 && dnsInfo.getEndTime() - (dnsInfo.getTtl() * 1000) < longValue) {
                                        arrayList.add(str);
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    LogTools.printWarning(TAG, e);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            ThreadInfo threadInfo = new ThreadInfo("Refresh-" + cachedNetStatusInfo + "-" + arrayList.toString());
            threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper(arrayList, cachedNetStatusInfo) { // from class: com.yy.gslbsdk.control.ActiveRefreshController.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ List val$listHost;
                public final /* synthetic */ NetStatusInfo val$network;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {arrayList, cachedNetStatusInfo};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$listHost = arrayList;
                    this.val$network = cachedNetStatusInfo;
                }

                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                public void handleOper(String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str3) == null) {
                        DnsResolveFlow.getInstance().handleDnsSync((String[]) this.val$listHost.toArray(new String[0]), "", this.val$network);
                    }
                }
            });
            ThreadPoolMgr.getInstance().addTask(threadInfo);
        }
    }
}
