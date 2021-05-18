package i.a.a.e.i;

import android.text.TextUtils;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import java.util.HashMap;
import tv.athena.revenue.api.MiddleReportConfig;
import tv.athena.revenue.api.MiddleRevenueConfig;
/* loaded from: classes8.dex */
public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    public MiddleRevenueConfig f68786a;

    public d(MiddleRevenueConfig middleRevenueConfig) {
        this.f68786a = middleRevenueConfig;
    }

    @Override // i.a.a.e.i.a
    public QueryCurrencyReqParams a() {
        QueryCurrencyReqParams queryCurrencyReqParams = new QueryCurrencyReqParams();
        queryCurrencyReqParams.setCurrencyType(this.f68786a.getCurrencyType());
        queryCurrencyReqParams.setAppId(this.f68786a.getAppId());
        queryCurrencyReqParams.setUsedChannel(this.f68786a.getUseChannel());
        queryCurrencyReqParams.setUid(this.f68786a.getUid());
        queryCurrencyReqParams.setToken(this.f68786a.getToken());
        queryCurrencyReqParams.setTokenCallback(this.f68786a.getTokenCallback());
        return queryCurrencyReqParams;
    }

    @Override // i.a.a.e.i.a
    public i.a.a.b.b.a.a b() {
        i.a.a.b.b.a.a aVar = new i.a.a.b.b.a.a();
        aVar.v(this.f68786a.getUid());
        aVar.t(this.f68786a.getToken());
        aVar.w(this.f68786a.getUseChannel());
        aVar.p(this.f68786a.getCurrencyType());
        aVar.u(this.f68786a.getTokenCallback());
        String deviceId = this.f68786a.getDeviceId();
        MiddleReportConfig reportConfig = this.f68786a.getReportConfig();
        if (TextUtils.isEmpty(deviceId) && reportConfig != null && !TextUtils.isEmpty(reportConfig.getDeviceId())) {
            deviceId = reportConfig.getDeviceId();
        }
        if (deviceId != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("deviceId", deviceId);
            aVar.q(hashMap);
        }
        return aVar;
    }
}
