package com.yy.mobile.framework.revenuesdk.statistics;

import com.yy.hiidostatis.api.StatisContent;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.statistics.PayEventStatistics;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.BaseHiidoContent;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uvevent.PayUVEventContent;
import java.util.Map;
/* loaded from: classes9.dex */
public class PayUVEventContentImpl implements PayEventStatistics.IPayUVEventContent {
    public final String TAG = "PayUVEventContentImpl";
    public BaseHiidoContent mBaseHiidoContent;

    public PayUVEventContentImpl(BaseHiidoContent baseHiidoContent) {
        this.mBaseHiidoContent = baseHiidoContent;
    }

    @Override // com.yy.mobile.framework.revenuesdk.statistics.PayEventStatistics.IPayUVEventContent
    public void report(String str, String str2, String str3, String str4) {
        PayUVEventContent build = new PayUVEventContent.ProductEventBuilder().setAbstractHiidoContent(this.mBaseHiidoContent).setEvent(str).setPayChannel(str2).setPayMethod(str3).setChargeConfigId(str4).build();
        String act = build.getAct();
        if (act == null) {
            return;
        }
        Map<String, String> mapContent = build.getMapContent();
        StatisContent statisContent = new StatisContent();
        for (Map.Entry<String, String> entry : mapContent.entrySet()) {
            statisContent.put(entry.getKey(), entry.getValue());
        }
        RLog.debug("PayUVEventContentImpl", "report statisContent:" + statisContent.toString());
        HiidoSDKApi.reportStatisticContent(act, statisContent);
    }
}
