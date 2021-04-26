package i.a.a.f;

import android.content.Context;
import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.baseapi.log.IRLogDelegate;
import com.yy.mobile.framework.revenuesdk.giftapi.IGiftService;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import d.r.b.a.a.b;
import d.r.b.a.a.f.d.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.adapter.DataProtocolAdapterFactory;
import tv.athena.revenue.api.IMiddleRevenue;
import tv.athena.revenue.api.MiddleReportConfig;
import tv.athena.revenue.api.MiddleRevenueConfig;
/* loaded from: classes7.dex */
public class c implements i.a.a.b.a {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, d.r.b.a.a.f.c.a> f68222a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, MiddleRevenueConfig> f68223b = new HashMap();

    public static String a(int i2, int i3) {
        return i2 + "-" + i3;
    }

    @Override // i.a.a.b.a
    public synchronized void addLogDelegate(IRLogDelegate iRLogDelegate) {
        d.b("RevenueService", "addLogDelegate");
        d.r.b.a.a.d.a(iRLogDelegate);
    }

    @Override // i.a.a.b.a
    public synchronized void addRevenueConfig(MiddleRevenueConfig middleRevenueConfig) {
        d.f("RevenueService", "addRevenueConfig -> versionName:4.1.4-bdpay");
        if (middleRevenueConfig == null) {
            d.b("RevenueService", "addRevenueConfig fail! config == null");
            return;
        }
        String a2 = a(middleRevenueConfig.getAppId(), middleRevenueConfig.getUseChannel());
        d.b("RevenueService", "addRevenueConfig mapKey=" + a2);
        if (f68223b.get(a2) != null) {
            d.e("RevenueService", "addRevenueConfig fail! duplicate init revenue  appId:" + middleRevenueConfig.getAppId() + " usechanel:" + middleRevenueConfig.getUseChannel(), new Object[0]);
            return;
        }
        f68223b.put(a2, middleRevenueConfig);
        d.r.b.a.a.f.a.c().b(middleRevenueConfig.isTestEnv(), middleRevenueConfig.getProtoType());
        if (f68222a.get(a2) != null) {
            d.e("RevenueService", "addRevenueConfig fail! duplicate init IDataProtocolAdapter appId:" + middleRevenueConfig.getAppId(), new Object[0]);
            return;
        }
        d.r.b.a.a.f.c.a valueOf = DataProtocolAdapterFactory.valueOf(middleRevenueConfig.getProtoType());
        valueOf.initProtocol();
        f68222a.put(a2, valueOf);
        i.a.a.a.a aVar = new i.a.a.a.a(middleRevenueConfig.getHttpDataSender());
        aVar.init(middleRevenueConfig.getHostId(), middleRevenueConfig.getPackageName(), middleRevenueConfig.getVersion(), d.r.b.a.a.f.a.c().f66959c, middleRevenueConfig.getProtoType(), middleRevenueConfig.getAuthType());
        b(middleRevenueConfig.getAppId(), middleRevenueConfig.getAppContext(), middleRevenueConfig.getUid(), middleRevenueConfig.getUseChannel(), middleRevenueConfig.getCurrencyType(), middleRevenueConfig.getCountry(), middleRevenueConfig.getLanguage(), middleRevenueConfig.getPackageName(), middleRevenueConfig.getVersion(), middleRevenueConfig.isOpenRisk(), middleRevenueConfig.getAuthType(), aVar, middleRevenueConfig.getReportConfig());
    }

    public final IRevenue b(int i2, Context context, long j, int i3, int i4, String str, String str2, String str3, String str4, boolean z, int i5, d.r.b.a.a.f.c.d dVar, MiddleReportConfig middleReportConfig) {
        d.g("RevenueService", "initRevenue: appId = %d, uid = %d, usedChannel = %d, currencyType = %d, countryCode = %s", Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(i4), str);
        b.a a2 = b.a.a();
        a2.n(j);
        a2.c(i2);
        a2.o(i3);
        a2.h(i4);
        a2.g(str);
        a2.k(str2);
        a2.i(dVar);
        a2.f(context);
        a2.j(z);
        a2.l(str3);
        a2.e(str4);
        a2.m(middleReportConfig);
        a2.d(i5);
        IRevenue b2 = d.r.b.a.a.d.b(i2, i3, a2.b());
        if (b2 != null) {
            IGiftService giftService = b2.getGiftService();
            if (giftService != null) {
                giftService.addGiftEventCallback(a.a());
            }
            IAppPayService appPayService = b2.getAppPayService();
            if (appPayService != null) {
                appPayService.addPayListener(b.f68221a);
            }
        }
        return b2;
    }

    @Override // i.a.a.b.a
    public List<IRevenue> getAllRevenue() {
        return d.r.b.a.a.d.c();
    }

    @Override // i.a.a.b.a
    public synchronized IMiddleRevenue getMiddleRevenue(int i2, int i3) {
        MiddleRevenueConfig middleRevenueConfig = f68223b.get(a(i2, i3));
        if (middleRevenueConfig == null) {
            d.f("RevenueService", "getMiddleRevenue fail,not yet config appId:" + i2 + " usechanel:" + i3);
            return null;
        }
        return new i.a.a.d.c(middleRevenueConfig, getRevenue(middleRevenueConfig.getAppId(), middleRevenueConfig.getUseChannel()));
    }

    @Override // i.a.a.b.a
    public IRevenue getRevenue(int i2, int i3) {
        return d.r.b.a.a.d.d(i2, i3);
    }

    @Override // i.a.a.b.a
    public synchronized void removeRevenueConfig(int i2, int i3) {
        String a2 = a(i2, i3);
        d.b("RevenueService", "removeRevenueConfig mapKey=" + a2);
        f68223b.remove(a2);
        f68222a.remove(a2);
        d.r.b.a.a.d.f(i2, i3);
    }

    @Override // i.a.a.b.a
    public synchronized void subscribeBroadcast(long j, long j2) {
        for (int i2 = 0; i2 < f68222a.size(); i2++) {
            f68222a.get(Integer.valueOf(i2)).subscribeBroadcast(j, j2);
        }
    }

    @Override // i.a.a.b.a
    public synchronized void unSubscribeBroadcast(long j, long j2) {
        for (int i2 = 0; i2 < f68222a.size(); i2++) {
            f68222a.get(Integer.valueOf(i2)).unSubscribeBroadcast(j, j2);
        }
    }

    @Override // i.a.a.b.a
    public void updateMiddleRevenueConfig(int i2, int i3, Long l, String str) {
        d.r.b.a.a.b b2 = d.r.b.a.a.c.b(i2);
        if (b2 != null) {
            b2.C(str);
            b2.D(l.longValue());
            getRevenue(i2, i3).updateConfig(b2);
        }
    }
}
