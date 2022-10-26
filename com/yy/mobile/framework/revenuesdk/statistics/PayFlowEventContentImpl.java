package com.yy.mobile.framework.revenuesdk.statistics;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.statistics.PayEventStatistics;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.BaseHiidoContent;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.payflow.PayFlowContent;
import java.util.Map;
/* loaded from: classes8.dex */
public class PayFlowEventContentImpl implements PayEventStatistics.IPayFlowEventContent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public BaseHiidoContent mBaseHiidoContent;

    public PayFlowEventContentImpl(BaseHiidoContent baseHiidoContent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseHiidoContent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.TAG = "PayFlowEventContentImpl";
        this.mBaseHiidoContent = baseHiidoContent;
    }

    @Override // com.yy.mobile.framework.revenuesdk.statistics.PayEventStatistics.IPayFlowEventContent
    public void reportPayFlow(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        PayFlowContent build;
        String act;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8}) != null) || (act = (build = new PayFlowContent.PayFlowContentBuilder().setAbstractHiidoContent(this.mBaseHiidoContent).setEventId(str).setCode(str2).setMsg(str3).setOrderId(str4).setPurchaceTime(str5).setProductId(str6).setPayEntraceId(str7).setPayTraceId(str8).build()).getAct()) == null) {
            return;
        }
        Map mapContent = build.getMapContent();
        StatisContent statisContent = new StatisContent();
        for (Map.Entry entry : mapContent.entrySet()) {
            statisContent.put((String) entry.getKey(), (String) entry.getValue());
        }
        RLog.debug("PayFlowEventContentImpl", "reportPayFlow statisContent:" + statisContent.toString());
        HiidoSDKApi.reportStatisticContent(act, statisContent);
    }
}
