package i.a.a.f;

import android.content.Context;
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
/* loaded from: classes8.dex */
public class b implements i.a.a.b.a {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, MiddleRevenueConfig> f72359a = new HashMap();

    public static String a(int i2, int i3) {
        return i2 + "-" + i3;
    }

    @Override // i.a.a.b.a
    public synchronized void addLogDelegate(IRLogDelegate iRLogDelegate) {
        RLog.debug("RevenueService", "addLogDelegate");
        RevenueSdk.addLogDelegate(iRLogDelegate);
    }

    @Override // i.a.a.b.a
    public synchronized void addRevenueConfig(MiddleRevenueConfig middleRevenueConfig) {
        if (middleRevenueConfig == null) {
            RLog.debug("RevenueService", "addRevenueConfig fail! config == null");
            return;
        }
        RLog.info("RevenueService", "addRevenueConfig -> versionName:4.2.20-bdpay config:" + middleRevenueConfig.toString());
        String a2 = a(middleRevenueConfig.getAppId(), middleRevenueConfig.getUseChannel());
        if (f72359a.get(a2) != null) {
            RLog.error("RevenueService", "addRevenueConfig fail! duplicate init revenue  appId:" + middleRevenueConfig.getAppId() + " usechanel:" + middleRevenueConfig.getUseChannel(), new Object[0]);
            return;
        }
        f72359a.put(a2, middleRevenueConfig);
        RLog.info("RevenueService", "addRevenueConfig mapKey=" + a2 + " mapSize=" + f72359a.size());
        Env.instance().init(middleRevenueConfig.isTestEnv());
        c(middleRevenueConfig.getAppId(), middleRevenueConfig.getAppContext(), middleRevenueConfig.getUid(), middleRevenueConfig.getUseChannel(), middleRevenueConfig.getCurrencyType(), middleRevenueConfig.getCountry(), middleRevenueConfig.getLanguage(), middleRevenueConfig.getPackageName(), middleRevenueConfig.getVersion(), middleRevenueConfig.isOpenRisk(), middleRevenueConfig.getAuthType(), middleRevenueConfig.getProtoType(), b(middleRevenueConfig), middleRevenueConfig.getReportConfig());
    }

    public final IDataSenderAdapter b(MiddleRevenueConfig middleRevenueConfig) {
        i.a.a.a.a aVar = new i.a.a.a.a(middleRevenueConfig.getDataSender());
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

    public final IRevenue c(int i2, Context context, long j, int i3, int i4, String str, String str2, String str3, String str4, boolean z, int i5, ProtocolType protocolType, IRevenueDataSender iRevenueDataSender, MiddleReportConfig middleReportConfig) {
        IAppPayService appPayService;
        RLog.info("RevenueService", "initRevenue: appId = %d, uid = %d, usedChannel = %d, currencyType = %d, authType = %s", Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        IRevenue addRevenueConfig = RevenueSdk.addRevenueConfig(i2, i3, RevenueConfig.RevenueConfigBuilder.aRevenueConfig().setUid(j).setAppId(i2).setUsedChannel(i3).setCurrencyType(i4).setCountryCode(str).setLanguage(str2).setDataSender(iRevenueDataSender).setContext(context).setIsOpenRisk(z).setProtoType(protocolType).setPakageName(str3).setClientVersion(str4).setReportConfig(middleReportConfig).setAuthType(i5).build());
        if (addRevenueConfig != null && (appPayService = addRevenueConfig.getAppPayService()) != null) {
            appPayService.addPayListener(a.f72358a);
        }
        return addRevenueConfig;
    }

    @Override // i.a.a.b.a
    public List<IRevenue> getAllRevenue() {
        return RevenueSdk.getAllRevenue();
    }

    @Override // i.a.a.b.a
    public synchronized IMiddleRevenue getMiddleRevenue(int i2, int i3) {
        MiddleRevenueConfig middleRevenueConfig = f72359a.get(a(i2, i3));
        if (middleRevenueConfig == null) {
            RLog.info("RevenueService", "getMiddleRevenue fail,not yet config appId:" + i2 + " usechanel:" + i3);
            return null;
        }
        return new i.a.a.d.b(middleRevenueConfig, getRevenue(middleRevenueConfig.getAppId(), middleRevenueConfig.getUseChannel()));
    }

    @Override // i.a.a.b.a
    public IRevenue getRevenue(int i2, int i3) {
        return RevenueSdk.getRevenue(i2, i3);
    }

    @Override // i.a.a.b.a
    public synchronized void removeRevenueConfig(int i2, int i3) {
        String a2 = a(i2, i3);
        f72359a.remove(a2);
        RLog.info("RevenueService", "removeRevenueConfig mapKey=" + a2 + " mapSize:" + f72359a.size());
        RevenueSdk.removeRevenueConfig(i2, i3);
    }

    @Override // i.a.a.b.a
    public void updateMiddleRevenueConfig(int i2, int i3, Long l, String str) {
        RevenueConfig config = RevenueConfigCenter.getConfig(i2, i3);
        if (config != null) {
            config.setCountryCode(str);
            config.setUid(l.longValue());
            getRevenue(i2, i3).updateConfig(config);
        }
    }
}
