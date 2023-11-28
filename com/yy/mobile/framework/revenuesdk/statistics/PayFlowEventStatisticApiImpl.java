package com.yy.mobile.framework.revenuesdk.statistics;

import com.yy.hiidostatis.api.StatisContent;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.statistics.PayEventStatisticsApiImpl;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.BaseHiidoContent;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.payflow.PayFlowContent;
import java.util.Map;
/* loaded from: classes2.dex */
public class PayFlowEventStatisticApiImpl implements PayEventStatisticsApiImpl.IPayFlowEventStatisticApi {
    public final String TAG = "PayFlowEventContentImpl";
    public BaseHiidoContent mBaseHiidoContent;

    public PayFlowEventStatisticApiImpl(BaseHiidoContent baseHiidoContent) {
        this.mBaseHiidoContent = baseHiidoContent;
    }

    @Override // com.yy.mobile.framework.revenuesdk.statistics.PayEventStatisticsApiImpl.IPayFlowEventStatisticApi
    public void reportPayFlow(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        reportPayFlow(str, str2, str3, str4, str5, str6, str7, str8, null);
    }

    @Override // com.yy.mobile.framework.revenuesdk.statistics.PayEventStatisticsApiImpl.IPayFlowEventStatisticApi
    public void reportPayFlow(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        PayFlowContent.PayFlowContentBuilder payTraceId = new PayFlowContent.PayFlowContentBuilder().setAbstractHiidoContent(this.mBaseHiidoContent).setEventId(str).setCode(str2).setMsg(str3).setOrderId(str4).setPurchaceTime(str5).setProductId(str6).setPayEntraceId(str7).setPayTraceId(str8);
        if (str9 != null) {
            payTraceId.setPayFrom(str9);
        }
        PayFlowContent build = payTraceId.build();
        String act = build.getAct();
        if (act == null) {
            return;
        }
        Map<String, String> mapContent = build.getMapContent();
        StatisContent statisContent = new StatisContent();
        for (Map.Entry<String, String> entry : mapContent.entrySet()) {
            statisContent.put(entry.getKey(), entry.getValue());
        }
        RLog.debug("PayFlowEventContentImpl", "reportPayFlow statisContent:" + statisContent.toString());
        HiidoSDKApi.reportStatisticContent(act, statisContent);
    }
}
