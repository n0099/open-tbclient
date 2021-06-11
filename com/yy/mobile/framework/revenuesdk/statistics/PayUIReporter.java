package com.yy.mobile.framework.revenuesdk.statistics;

import com.yy.hiidostatis.api.StatisContent;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.reporter.SDKReporter;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.BaseHiidoContent;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import java.util.Map;
/* loaded from: classes7.dex */
public class PayUIReporter {
    public final String TAG = "PayUIReporter";
    public BaseHiidoContent mBaseHiidoContent;

    public PayUIReporter(BaseHiidoContent baseHiidoContent) {
        this.mBaseHiidoContent = baseHiidoContent;
    }

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
        RLog.debug("PayUIReporter", "reportUIEvent statisContent:" + statisContent.toString());
        SDKReporter.reportStatisticContent(act, statisContent);
    }

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
        RLog.debug("PayUIReporter", "reportUIEvent statisContent:" + statisContent.toString());
        SDKReporter.reportStatisticContent(act, statisContent);
    }
}
