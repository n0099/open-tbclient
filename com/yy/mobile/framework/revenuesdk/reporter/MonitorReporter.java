package com.yy.mobile.framework.revenuesdk.reporter;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.StatisAPI;
import com.yy.mobile.framework.revenuesdk.RevenueConfig;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.HiidoReport;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IMonitorReporter;
/* loaded from: classes3.dex */
public class MonitorReporter implements IMonitorReporter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;

    public MonitorReporter(RevenueConfig revenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {revenueConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.TAG = "MonitorReporter";
        initReportConfig(revenueConfig);
        HiidoSDKApi.initHiidoSdk(revenueConfig);
    }

    private void initReportConfig(RevenueConfig revenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, revenueConfig) == null) {
            HiidoReport.CReportResponse.mAppId = String.valueOf(revenueConfig.getAppId());
            HiidoReport.CReportResponse.mSys = 2;
            HiidoReport.CReportResponse.mDevice = Build.MANUFACTURER + "_" + Build.MODEL;
            StringBuilder sb = new StringBuilder();
            sb.append("Android");
            sb.append(Build.VERSION.RELEASE);
            HiidoReport.CReportResponse.mOS = sb.toString();
            HiidoReport.CReportResponse.mCountry = revenueConfig.getCountryCode();
            HiidoReport.CReportConfig.mReportRatio = Float.valueOf(revenueConfig.getReportConfig().getReportRatio());
            HiidoReport.CReportConfig.mAppName = revenueConfig.getReportConfig().getAppName();
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.IMonitorReporter
    public void reportCount(int i2, String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, Long.valueOf(j2)}) == null) {
            RLog.info("MonitorReporter", "reportReturnCode uri:" + str + " count:" + j2);
            StatisAPI statisAPI = HiidoSDKApi.mStatisAPI;
            if (statisAPI != null) {
                statisAPI.reportCount(i2, str, str2, j2);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.IMonitorReporter
    public void reportReturnCode(int i2, String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2), str2}) == null) {
            RLog.info("MonitorReporter", "reportReturnCode uri:" + str + " code:" + str2);
            StatisAPI statisAPI = HiidoSDKApi.mStatisAPI;
            if (statisAPI != null) {
                statisAPI.reportReturnCode(i2, str, j2, str2, null);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.IMonitorReporter
    public void reportCount(int i2, String str, String str2, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, str2, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            RLog.info("MonitorReporter", "reportReturnCode uri:" + str + " count:" + j2);
            StatisAPI statisAPI = HiidoSDKApi.mStatisAPI;
            if (statisAPI != null) {
                statisAPI.reportCount(i2, str, str2, j2);
            }
        }
    }
}
