package com.yy.mobile.framework.revenuesdk.statistics;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.reporter.EventReporter;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.BaseHiidoContent;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uvevent.PayUVEventContent;
import java.util.Map;
/* loaded from: classes2.dex */
public class PayUVReporter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public BaseHiidoContent mBaseHiidoContent;

    public PayUVReporter(BaseHiidoContent baseHiidoContent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseHiidoContent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.TAG = "PayUVReporter";
        this.mBaseHiidoContent = baseHiidoContent;
    }

    public void report(String str, String str2, String str3, String str4) {
        PayUVEventContent build;
        String act;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, str4) == null) || (act = (build = new PayUVEventContent.ProductEventBuilder().setAbstractHiidoContent(this.mBaseHiidoContent).setEvent(str).setPayChannel(str2).setPayMethod(str3).setChargeConfigId(str4).build()).getAct()) == null) {
            return;
        }
        Map<String, String> mapContent = build.getMapContent();
        StatisContent statisContent = new StatisContent();
        for (Map.Entry<String, String> entry : mapContent.entrySet()) {
            statisContent.put(entry.getKey(), entry.getValue());
        }
        RLog.debug("PayUVReporter", "report statisContent:" + statisContent.toString());
        EventReporter.reportStatisticContent(act, statisContent);
    }
}
