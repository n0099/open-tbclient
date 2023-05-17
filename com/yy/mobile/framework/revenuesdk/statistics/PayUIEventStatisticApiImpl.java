package com.yy.mobile.framework.revenuesdk.statistics;

import com.yy.hiidostatis.api.StatisContent;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.statistics.PayEventStatisticsApiImpl;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.BaseHiidoContent;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import java.util.Map;
/* loaded from: classes10.dex */
public class PayUIEventStatisticApiImpl implements PayEventStatisticsApiImpl.IPayUIEventStatisticApi {
    public final String TAG = "PayUIEventStatisticApiImpl";
    public BaseHiidoContent mBaseHiidoContent;

    public PayUIEventStatisticApiImpl(BaseHiidoContent baseHiidoContent) {
        this.mBaseHiidoContent = baseHiidoContent;
    }

    @Override // com.yy.mobile.framework.revenuesdk.statistics.PayEventStatisticsApiImpl.IPayUIEventStatisticApi
    public void reportUIEvent(String str) {
        PayUiEventContent build = new PayUiEventContent.UiEventContentBuilder().setAbstractHiidoContent(this.mBaseHiidoContent).setEvent(str).build();
        String act = build.getAct();
        Map<String, String> mapContent = build.getMapContent();
        if (act == null) {
            return;
        }
        StatisContent statisContent = new StatisContent();
        for (Map.Entry<String, String> entry : mapContent.entrySet()) {
            statisContent.put(entry.getKey(), entry.getValue());
        }
        RLog.debug("PayUIEventStatisticApiImpl", "reportUIEvent statisContent:" + statisContent.toString());
        HiidoSDKApi.reportStatisticContent(act, statisContent);
    }

    @Override // com.yy.mobile.framework.revenuesdk.statistics.PayEventStatisticsApiImpl.IPayUIEventStatisticApi
    public void reportUIEvent(String str, String str2) {
        PayUiEventContent build = new PayUiEventContent.UiEventContentBuilder().setAbstractHiidoContent(this.mBaseHiidoContent).setEvent(str).setAmount(str2).build();
        String act = build.getAct();
        if (act == null) {
            return;
        }
        Map<String, String> mapContent = build.getMapContent();
        StatisContent statisContent = new StatisContent();
        for (Map.Entry<String, String> entry : mapContent.entrySet()) {
            statisContent.put(entry.getKey(), entry.getValue());
        }
        RLog.debug("PayUIEventStatisticApiImpl", "reportUIEvent statisContent:" + statisContent.toString());
        HiidoSDKApi.reportStatisticContent(act, statisContent);
    }
}
