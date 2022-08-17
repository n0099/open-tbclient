package com.repackage;

import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import java.util.Map;
import tv.athena.revenue.payui.model.PayFlowType;
/* loaded from: classes7.dex */
public interface v1a {
    GetBannerConfigReqParams a();

    qz9 b(PayFlowType payFlowType, Map<String, String> map);

    QueryCurrencyReqParams c();

    QueryCurrencyReqParams d(Map<String, String> map);
}
