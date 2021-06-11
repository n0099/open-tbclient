package com.yy.mobile.framework.revenuesdk.statistics;

import com.yy.hiidostatis.api.StatisContent;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.reporter.SDKReporter;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.BaseHiidoContent;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.payflow.PayFlowContent;
import java.util.Map;
/* loaded from: classes7.dex */
public class PayFlowReporter {
    public final String TAG = "PayFlowReporter";
    public BaseHiidoContent mBaseHiidoContent;

    public PayFlowReporter(BaseHiidoContent baseHiidoContent) {
        this.mBaseHiidoContent = baseHiidoContent;
    }

    public void reportPayFlow(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        PayFlowContent build = new PayFlowContent.PayFlowContentBuilder().setAbstractHiidoContent(this.mBaseHiidoContent).setEventId(str).setCode(str2).setMsg(str3).setOrderId(str4).setPurchaceTime(str5).setProductId(str6).setPayEntraceId(str7).setPayTraceId(str8).build();
        String act = build.getAct();
        if (act == null) {
            return;
        }
        Map<String, String> mapContent = build.getMapContent();
        StatisContent statisContent = new StatisContent();
        for (Map.Entry<String, String> entry : mapContent.entrySet()) {
            statisContent.put(entry.getKey(), entry.getValue());
        }
        RLog.debug("PayFlowReporter", "reportPayFlow statisContent:" + statisContent.toString());
        SDKReporter.reportStatisticContent(act, statisContent);
    }
}
