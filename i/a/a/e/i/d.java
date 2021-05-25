package i.a.a.e.i;

import android.text.TextUtils;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import java.util.HashMap;
import tv.athena.revenue.api.MiddleReportConfig;
import tv.athena.revenue.api.MiddleRevenueConfig;
/* loaded from: classes8.dex */
public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    public MiddleRevenueConfig f68829a;

    public d(MiddleRevenueConfig middleRevenueConfig) {
        this.f68829a = middleRevenueConfig;
    }

    @Override // i.a.a.e.i.a
    public QueryCurrencyReqParams a() {
        QueryCurrencyReqParams queryCurrencyReqParams = new QueryCurrencyReqParams();
        queryCurrencyReqParams.setCurrencyType(this.f68829a.getCurrencyType());
        queryCurrencyReqParams.setAppId(this.f68829a.getAppId());
        queryCurrencyReqParams.setUsedChannel(this.f68829a.getUseChannel());
        queryCurrencyReqParams.setUid(this.f68829a.getUid());
        queryCurrencyReqParams.setToken(this.f68829a.getToken());
        queryCurrencyReqParams.setTokenCallback(this.f68829a.getTokenCallback());
        return queryCurrencyReqParams;
    }

    @Override // i.a.a.e.i.a
    public i.a.a.b.b.a.a b() {
        i.a.a.b.b.a.a aVar = new i.a.a.b.b.a.a();
        aVar.v(this.f68829a.getUid());
        aVar.t(this.f68829a.getToken());
        aVar.w(this.f68829a.getUseChannel());
        aVar.p(this.f68829a.getCurrencyType());
        aVar.u(this.f68829a.getTokenCallback());
        String deviceId = this.f68829a.getDeviceId();
        MiddleReportConfig reportConfig = this.f68829a.getReportConfig();
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
