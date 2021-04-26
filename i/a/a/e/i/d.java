package i.a.a.e.i;

import android.text.TextUtils;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import java.util.HashMap;
import tv.athena.revenue.api.MiddleReportConfig;
import tv.athena.revenue.api.MiddleRevenueConfig;
/* loaded from: classes7.dex */
public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    public MiddleRevenueConfig f68106a;

    public d(MiddleRevenueConfig middleRevenueConfig) {
        this.f68106a = middleRevenueConfig;
    }

    @Override // i.a.a.e.i.a
    public QueryCurrencyReqParams a() {
        QueryCurrencyReqParams queryCurrencyReqParams = new QueryCurrencyReqParams();
        queryCurrencyReqParams.setCurrencyType(this.f68106a.getCurrencyType());
        queryCurrencyReqParams.setAppId(this.f68106a.getAppId());
        queryCurrencyReqParams.setUsedChannel(this.f68106a.getUseChannel());
        queryCurrencyReqParams.setUid(this.f68106a.getUid());
        queryCurrencyReqParams.setToken(this.f68106a.getToken());
        queryCurrencyReqParams.setTokenCallback(this.f68106a.getTokenCallback());
        return queryCurrencyReqParams;
    }

    @Override // i.a.a.e.i.a
    public i.a.a.b.b.a.a b() {
        i.a.a.b.b.a.a aVar = new i.a.a.b.b.a.a();
        aVar.v(this.f68106a.getUid());
        aVar.t(this.f68106a.getToken());
        aVar.w(this.f68106a.getUseChannel());
        aVar.p(this.f68106a.getCurrencyType());
        aVar.u(this.f68106a.getTokenCallback());
        String deviceId = this.f68106a.getDeviceId();
        MiddleReportConfig reportConfig = this.f68106a.getReportConfig();
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
