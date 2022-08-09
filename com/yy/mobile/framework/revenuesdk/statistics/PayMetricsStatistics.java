package com.yy.mobile.framework.revenuesdk.statistics;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.RevenueConfig;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayMetricsStatistics;
/* loaded from: classes8.dex */
public class PayMetricsStatistics implements IPayMetricsStatistics {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;

    public PayMetricsStatistics(RevenueConfig revenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {revenueConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.TAG = "MonitorReporter";
        HiidoSDKApi.initHiidoSdk(revenueConfig);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayMetricsStatistics
    public void reportCount(int i, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, Long.valueOf(j)}) == null) {
            RLog.info("MonitorReporter", "reportReturnCode uri:" + str + " count:" + j);
            HiidoSDKApi.reportCount(i, str, str2, j);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayMetricsStatistics
    public void reportReturnCode(int i, String str, long j, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), str2}) == null) {
            RLog.info("MonitorReporter", "reportReturnCode uri:" + str + " code:" + str2);
            HiidoSDKApi.reportReturnCode(i, str, j, str2);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayMetricsStatistics
    public void reportCount(int i, String str, String str2, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, str2, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            RLog.info("MonitorReporter", "reportReturnCode uri:" + str + " count:" + j);
            HiidoSDKApi.reportCount(i, str, str2, j);
        }
    }
}
