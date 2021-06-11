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
    public MiddleRevenueConfig f72086a;

    public d(MiddleRevenueConfig middleRevenueConfig) {
        this.f72086a = middleRevenueConfig;
    }

    @Override // i.a.a.e.k.a
    public GetBannerConfigReqParams a() {
        GetBannerConfigReqParams getBannerConfigReqParams = new GetBannerConfigReqParams();
        getBannerConfigReqParams.setAppId(this.f72086a.getAppId());
        getBannerConfigReqParams.setUsedChannel(this.f72086a.getUseChannel());
        getBannerConfigReqParams.setUid(this.f72086a.getUid());
        getBannerConfigReqParams.setToken(this.f72086a.getToken());
        getBannerConfigReqParams.setTokenCallback(this.f72086a.getTokenCallback());
        return getBannerConfigReqParams;
    }

    @Override // i.a.a.e.k.a
    public QueryCurrencyReqParams b() {
        QueryCurrencyReqParams queryCurrencyReqParams = new QueryCurrencyReqParams();
        queryCurrencyReqParams.setCurrencyType(this.f72086a.getCurrencyType());
        queryCurrencyReqParams.setAppId(this.f72086a.getAppId());
        queryCurrencyReqParams.setUsedChannel(this.f72086a.getUseChannel());
        queryCurrencyReqParams.setUid(this.f72086a.getUid());
        queryCurrencyReqParams.setToken(this.f72086a.getToken());
        queryCurrencyReqParams.setTokenCallback(this.f72086a.getTokenCallback());
        queryCurrencyReqParams.setReturnYb(true);
        return queryCurrencyReqParams;
    }

    @Override // i.a.a.e.k.a
    public QueryCurrencyReqParams c() {
        QueryCurrencyReqParams queryCurrencyReqParams = new QueryCurrencyReqParams();
        queryCurrencyReqParams.setCurrencyType(this.f72086a.getCurrencyType());
        queryCurrencyReqParams.setAppId(this.f72086a.getAppId());
        queryCurrencyReqParams.setUsedChannel(this.f72086a.getUseChannel());
        queryCurrencyReqParams.setUid(this.f72086a.getUid());
        queryCurrencyReqParams.setToken(this.f72086a.getToken());
        queryCurrencyReqParams.setTokenCallback(this.f72086a.getTokenCallback());
        return queryCurrencyReqParams;
    }

    @Override // i.a.a.e.k.a
    public i.a.a.b.b.a.a d() {
        i.a.a.b.b.a.a aVar = new i.a.a.b.b.a.a();
        aVar.A(this.f72086a.getUid());
        aVar.x(this.f72086a.getToken());
        aVar.B(this.f72086a.getUseChannel());
        aVar.s(this.f72086a.getCurrencyType());
        aVar.y(this.f72086a.getTokenCallback());
        String deviceId = this.f72086a.getDeviceId();
        MiddleReportConfig reportConfig = this.f72086a.getReportConfig();
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
