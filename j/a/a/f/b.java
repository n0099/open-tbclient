package j.a.a.f;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.RevenueConfig;
import com.yy.mobile.framework.revenuesdk.RevenueConfigCenter;
import com.yy.mobile.framework.revenuesdk.RevenueSdk;
import com.yy.mobile.framework.revenuesdk.baseapi.Env;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.data.DataSenderConfig;
import com.yy.mobile.framework.revenuesdk.baseapi.data.IDataSenderAdapter;
import com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender;
import com.yy.mobile.framework.revenuesdk.baseapi.log.IRLogDelegate;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.utils.HiidoUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.api.IMiddleRevenue;
import tv.athena.revenue.api.MiddleReportConfig;
import tv.athena.revenue.api.MiddleRevenueConfig;
/* loaded from: classes2.dex */
public class b implements j.a.a.b.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, MiddleRevenueConfig> f78821a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1304472079, "Lj/a/a/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1304472079, "Lj/a/a/f/b;");
                return;
            }
        }
        f78821a = new HashMap();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) {
            return i2 + "-" + i3;
        }
        return (String) invokeII.objValue;
    }

    @Override // j.a.a.b.a
    public synchronized void addLogDelegate(IRLogDelegate iRLogDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iRLogDelegate) == null) {
            synchronized (this) {
                RLog.debug("RevenueService", "addLogDelegate");
                RevenueSdk.addLogDelegate(iRLogDelegate);
            }
        }
    }

    @Override // j.a.a.b.a
    public synchronized void addRevenueConfig(MiddleRevenueConfig middleRevenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, middleRevenueConfig) == null) {
            synchronized (this) {
                if (middleRevenueConfig == null) {
                    RLog.debug("RevenueService", "addRevenueConfig fail! config == null");
                    return;
                }
                RLog.info("RevenueService", "addRevenueConfig -> versionName:4.2.20-bdpay config:" + middleRevenueConfig.toString());
                String a2 = a(middleRevenueConfig.getAppId(), middleRevenueConfig.getUseChannel());
                if (f78821a.get(a2) != null) {
                    RLog.error("RevenueService", "addRevenueConfig fail! duplicate init revenue  appId:" + middleRevenueConfig.getAppId() + " usechanel:" + middleRevenueConfig.getUseChannel(), new Object[0]);
                    return;
                }
                f78821a.put(a2, middleRevenueConfig);
                RLog.info("RevenueService", "addRevenueConfig mapKey=" + a2 + " mapSize=" + f78821a.size());
                Env.instance().init(middleRevenueConfig.isTestEnv());
                c(middleRevenueConfig.getAppId(), middleRevenueConfig.getAppContext(), middleRevenueConfig.getUid(), middleRevenueConfig.getUseChannel(), middleRevenueConfig.getCurrencyType(), middleRevenueConfig.getCountry(), middleRevenueConfig.getLanguage(), middleRevenueConfig.getPackageName(), middleRevenueConfig.getVersion(), middleRevenueConfig.isOpenRisk(), middleRevenueConfig.getAuthType(), middleRevenueConfig.getProtoType(), b(middleRevenueConfig), middleRevenueConfig.getReportConfig());
            }
        }
    }

    public final IDataSenderAdapter b(MiddleRevenueConfig middleRevenueConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, middleRevenueConfig)) == null) {
            j.a.a.a.a aVar = new j.a.a.a.a(middleRevenueConfig.getDataSender());
            DataSenderConfig dataSenderConfig = new DataSenderConfig();
            dataSenderConfig.hostId = middleRevenueConfig.getHostId();
            dataSenderConfig.pakageName = middleRevenueConfig.getPackageName();
            dataSenderConfig.version = middleRevenueConfig.getVersion();
            dataSenderConfig.httpUrl = Env.instance().REVENUE_HTTP_URL;
            dataSenderConfig.protoType = middleRevenueConfig.getProtoType();
            dataSenderConfig.authType = middleRevenueConfig.getAuthType();
            dataSenderConfig.appContext = middleRevenueConfig.getAppContext();
            dataSenderConfig.gslbAppId = middleRevenueConfig.getGslbAppId();
            dataSenderConfig.hdid = HiidoUtils.getHdid(middleRevenueConfig.getAppContext());
            aVar.init(dataSenderConfig);
            return aVar;
        }
        return (IDataSenderAdapter) invokeL.objValue;
    }

    public final IRevenue c(int i2, Context context, long j2, int i3, int i4, String str, String str2, String str3, String str4, boolean z, int i5, ProtocolType protocolType, IRevenueDataSender iRevenueDataSender, MiddleReportConfig middleReportConfig) {
        InterceptResult invokeCommon;
        IAppPayService appPayService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), context, Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2, str3, str4, Boolean.valueOf(z), Integer.valueOf(i5), protocolType, iRevenueDataSender, middleReportConfig})) == null) {
            RLog.info("RevenueService", "initRevenue: appId = %d, uid = %d, usedChannel = %d, currencyType = %d, authType = %s", Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
            IRevenue addRevenueConfig = RevenueSdk.addRevenueConfig(i2, i3, RevenueConfig.RevenueConfigBuilder.aRevenueConfig().setUid(j2).setAppId(i2).setUsedChannel(i3).setCurrencyType(i4).setCountryCode(str).setLanguage(str2).setDataSender(iRevenueDataSender).setContext(context).setIsOpenRisk(z).setProtoType(protocolType).setPakageName(str3).setClientVersion(str4).setReportConfig(middleReportConfig).setAuthType(i5).build());
            if (addRevenueConfig != null && (appPayService = addRevenueConfig.getAppPayService()) != null) {
                appPayService.addPayListener(a.f78820a);
            }
            return addRevenueConfig;
        }
        return (IRevenue) invokeCommon.objValue;
    }

    @Override // j.a.a.b.a
    public List<IRevenue> getAllRevenue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? RevenueSdk.getAllRevenue() : (List) invokeV.objValue;
    }

    @Override // j.a.a.b.a
    public synchronized IMiddleRevenue getMiddleRevenue(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i2, i3)) == null) {
            synchronized (this) {
                MiddleRevenueConfig middleRevenueConfig = f78821a.get(a(i2, i3));
                if (middleRevenueConfig == null) {
                    RLog.info("RevenueService", "getMiddleRevenue fail,not yet config appId:" + i2 + " usechanel:" + i3);
                    return null;
                }
                return new j.a.a.d.b(middleRevenueConfig, getRevenue(middleRevenueConfig.getAppId(), middleRevenueConfig.getUseChannel()));
            }
        }
        return (IMiddleRevenue) invokeII.objValue;
    }

    @Override // j.a.a.b.a
    public IRevenue getRevenue(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i2, i3)) == null) ? RevenueSdk.getRevenue(i2, i3) : (IRevenue) invokeII.objValue;
    }

    @Override // j.a.a.b.a
    public synchronized void removeRevenueConfig(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            synchronized (this) {
                String a2 = a(i2, i3);
                f78821a.remove(a2);
                RLog.info("RevenueService", "removeRevenueConfig mapKey=" + a2 + " mapSize:" + f78821a.size());
                RevenueSdk.removeRevenueConfig(i2, i3);
            }
        }
    }

    @Override // j.a.a.b.a
    public void updateMiddleRevenueConfig(int i2, int i3, Long l, String str) {
        RevenueConfig config;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), l, str}) == null) || (config = RevenueConfigCenter.getConfig(i2, i3)) == null) {
            return;
        }
        config.setCountryCode(str);
        config.setUid(l.longValue());
        getRevenue(i2, i3).updateConfig(config);
    }
}
