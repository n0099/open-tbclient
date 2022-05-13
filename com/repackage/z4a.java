package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.HiidoReport;
import com.yy.mobile.framework.revenuesdk.payapi.reporter.IPayReporter;
import tv.athena.revenue.RevenueManager;
/* loaded from: classes7.dex */
public class z4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static IPayReporter a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65536, null, i, i2)) == null) {
            IRevenue revenue = RevenueManager.instance().getRevenue(i, i2);
            if (revenue == null) {
                RLog.error("MonitorReporter", "getMonitorReporter error revenue null", new Object[0]);
                return null;
            }
            return revenue.getPayReporter();
        }
        return (IPayReporter) invokeII.objValue;
    }

    public static void b(int i, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            IPayReporter a = a(i, i2);
            if (a == null) {
                RLog.error("MonitorReporter", "onShowPayFailResult error payReporter null", new Object[0]);
                return;
            }
            HiidoReport.CReportResponse cReportResponse = new HiidoReport.CReportResponse();
            cReportResponse.mEventId = "6";
            cReportResponse.mEventaliae = EventAlias.PayEventAlias.SHOW_PAY_RESULT;
            cReportResponse.mErrCode = i3 + "";
            cReportResponse.mErrMsg = str;
            a.onShowPayResult(cReportResponse);
        }
    }
}
