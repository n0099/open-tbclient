package com.yy.mobile.framework.revenuesdk.statistics;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.reporter.SDKReporter;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.BaseHiidoContent;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import java.util.Map;
/* loaded from: classes8.dex */
public class PayUIReporter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public BaseHiidoContent mBaseHiidoContent;

    public PayUIReporter(BaseHiidoContent baseHiidoContent) {
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
        this.TAG = "PayUIReporter";
        this.mBaseHiidoContent = baseHiidoContent;
    }

    public void reportUIEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
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
    }

    public void reportUIEvent(String str, String str2) {
        PayUiEventContent build;
        String act;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || (act = (build = new PayUiEventContent.UiEventContentBuilder().setAbstractHiidoContent(this.mBaseHiidoContent).setEvent(str).setAmount(str2).build()).getAct()) == null) {
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
