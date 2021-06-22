package i.a.a.e.k;

import android.text.TextUtils;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import java.util.HashMap;
import tv.athena.revenue.api.MiddleReportConfig;
import tv.athena.revenue.api.MiddleRevenueConfig;
/* loaded from: classes8.dex */
public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    public MiddleRevenueConfig f72190a;

    public d(MiddleRevenueConfig middleRevenueConfig) {
        this.f72190a = middleRevenueConfig;
    }

    @Override // i.a.a.e.k.a
    public GetBannerConfigReqParams a() {
        GetBannerConfigReqParams getBannerConfigReqParams = new GetBannerConfigReqParams();
        getBannerConfigReqParams.setAppId(this.f72190a.getAppId());
        getBannerConfigReqParams.setUsedChannel(this.f72190a.getUseChannel());
        getBannerConfigReqParams.setUid(this.f72190a.getUid());
        getBannerConfigReqParams.setToken(this.f72190a.getToken());
        getBannerConfigReqParams.setTokenCallback(this.f72190a.getTokenCallback());
        return getBannerConfigReqParams;
    }

    @Override // i.a.a.e.k.a
    public QueryCurrencyReqParams b() {
        QueryCurrencyReqParams queryCurrencyReqParams = new QueryCurrencyReqParams();
        queryCurrencyReqParams.setCurrencyType(this.f72190a.getCurrencyType());
        queryCurrencyReqParams.setAppId(this.f72190a.getAppId());
        queryCurrencyReqParams.setUsedChannel(this.f72190a.getUseChannel());
        queryCurrencyReqParams.setUid(this.f72190a.getUid());
        queryCurrencyReqParams.setToken(this.f72190a.getToken());
        queryCurrencyReqParams.setTokenCallback(this.f72190a.getTokenCallback());
        queryCurrencyReqParams.setReturnYb(true);
        return queryCurrencyReqParams;
    }

    @Override // i.a.a.e.k.a
    public QueryCurrencyReqParams c() {
        QueryCurrencyReqParams queryCurrencyReqParams = new QueryCurrencyReqParams();
        queryCurrencyReqParams.setCurrencyType(this.f72190a.getCurrencyType());
        queryCurrencyReqParams.setAppId(this.f72190a.getAppId());
        queryCurrencyReqParams.setUsedChannel(this.f72190a.getUseChannel());
        queryCurrencyReqParams.setUid(this.f72190a.getUid());
        queryCurrencyReqParams.setToken(this.f72190a.getToken());
        queryCurrencyReqParams.setTokenCallback(this.f72190a.getTokenCallback());
        return queryCurrencyReqParams;
    }

    @Override // i.a.a.e.k.a
    public i.a.a.b.b.a.a d() {
        i.a.a.b.b.a.a aVar = new i.a.a.b.b.a.a();
        aVar.A(this.f72190a.getUid());
        aVar.x(this.f72190a.getToken());
        aVar.B(this.f72190a.getUseChannel());
        aVar.s(this.f72190a.getCurrencyType());
        aVar.y(this.f72190a.getTokenCallback());
        String deviceId = this.f72190a.getDeviceId();
        MiddleReportConfig reportConfig = this.f72190a.getReportConfig();
        if (TextUtils.isEmpty(deviceId) && reportConfig != null && !TextUtils.isEmpty(reportConfig.getDeviceId())) {
            deviceId = reportConfig.getDeviceId();
        }
        if (deviceId != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("deviceId", deviceId);
            aVar.t(hashMap);
        }
        return aVar;
    }
}
