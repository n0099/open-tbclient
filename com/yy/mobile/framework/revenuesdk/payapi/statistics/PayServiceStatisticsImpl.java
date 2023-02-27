package com.yy.mobile.framework.revenuesdk.payapi.statistics;

import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.HiidoReport;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayMetricsStatistics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/statistics/PayServiceStatisticsImpl;", "Lcom/yy/mobile/framework/revenuesdk/payapi/statistics/IPayServiceStatistics;", "Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/HiidoReport$CReportResponse;", "response", "", "onOrderResult", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/HiidoReport$CReportResponse;)V", "onPayEntrancePage", "onPayResult", "onQueryChargeOrderStatus", "onQueryProductList", "onQueryUserYbDetails", "onRequestPay", "onShowPayResult", "", "TAG", "Ljava/lang/String;", "", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "I", "Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/IPayMetricsStatistics;", "payMetricsStatistics", "Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/IPayMetricsStatistics;", "usedChannel", "<init>", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/IPayMetricsStatistics;II)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class PayServiceStatisticsImpl implements IPayServiceStatistics {
    public final String TAG = "PayServiceStatisticsImpl";
    public final int appId;
    public final IPayMetricsStatistics payMetricsStatistics;
    public final int usedChannel;

    @Override // com.yy.mobile.framework.revenuesdk.payapi.statistics.IPayServiceStatistics
    public void onPayEntrancePage(HiidoReport.CReportResponse cReportResponse) {
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.statistics.IPayServiceStatistics
    public void onRequestPay(HiidoReport.CReportResponse cReportResponse) {
    }

    public PayServiceStatisticsImpl(IPayMetricsStatistics iPayMetricsStatistics, int i, int i2) {
        this.payMetricsStatistics = iPayMetricsStatistics;
        this.appId = i;
        this.usedChannel = i2;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.statistics.IPayServiceStatistics
    public void onOrderResult(HiidoReport.CReportResponse cReportResponse) {
        String str;
        IPayMetricsStatistics iPayMetricsStatistics = this.payMetricsStatistics;
        if (iPayMetricsStatistics != null) {
            if (cReportResponse.mCmd == 0) {
                str = "onOrderResult";
            } else {
                str = "" + cReportResponse.mCmd;
            }
            String revenueUri = HiidoReport.getInstance().getRevenueUri(this.appId, this.usedChannel, str);
            Intrinsics.checkExpressionValueIsNotNull(revenueUri, "HiidoReport.getInstance(…(appId, usedChannel, cmd)");
            int i = HiidoReport.CReportParam.REVENUE_SCODE;
            String str2 = cReportResponse.mDelay;
            Intrinsics.checkExpressionValueIsNotNull(str2, "(response.mDelay)");
            iPayMetricsStatistics.reportReturnCode(i, revenueUri, Long.parseLong(str2), cReportResponse.mErrCode.toString());
            RLog.debug(this.TAG, "onOrderResult uri:" + revenueUri);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.statistics.IPayServiceStatistics
    public void onPayResult(HiidoReport.CReportResponse cReportResponse) {
        String str;
        IPayMetricsStatistics iPayMetricsStatistics = this.payMetricsStatistics;
        if (iPayMetricsStatistics != null) {
            if (cReportResponse.mCmd == 0) {
                str = "onPayResult";
            } else {
                str = "" + cReportResponse.mCmd;
            }
            String revenueUri = HiidoReport.getInstance().getRevenueUri(this.appId, this.usedChannel, str);
            Intrinsics.checkExpressionValueIsNotNull(revenueUri, "HiidoReport.getInstance(…(appId, usedChannel, cmd)");
            int i = HiidoReport.CReportParam.REVENUE_SCODE;
            String str2 = cReportResponse.mDelay;
            Intrinsics.checkExpressionValueIsNotNull(str2, "(response.mDelay)");
            iPayMetricsStatistics.reportReturnCode(i, revenueUri, Long.parseLong(str2), cReportResponse.mErrCode.toString());
            RLog.debug(this.TAG, "onPayResult uri:" + revenueUri);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.statistics.IPayServiceStatistics
    public void onQueryChargeOrderStatus(HiidoReport.CReportResponse cReportResponse) {
        String str;
        IPayMetricsStatistics iPayMetricsStatistics = this.payMetricsStatistics;
        if (iPayMetricsStatistics != null) {
            if (cReportResponse.mCmd == 0) {
                str = "onQueryChargeOrderStatus";
            } else {
                str = "" + cReportResponse.mCmd;
            }
            String revenueUri = HiidoReport.getInstance().getRevenueUri(this.appId, this.usedChannel, str);
            Intrinsics.checkExpressionValueIsNotNull(revenueUri, "HiidoReport.getInstance(…(appId, usedChannel, cmd)");
            int i = HiidoReport.CReportParam.REVENUE_SCODE;
            String str2 = cReportResponse.mDelay;
            Intrinsics.checkExpressionValueIsNotNull(str2, "(response.mDelay)");
            iPayMetricsStatistics.reportReturnCode(i, revenueUri, Long.parseLong(str2), cReportResponse.mErrCode.toString());
            RLog.debug(this.TAG, "onQueryChargeOrderStatus uri:" + revenueUri);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.statistics.IPayServiceStatistics
    public void onQueryProductList(HiidoReport.CReportResponse cReportResponse) {
        String str;
        IPayMetricsStatistics iPayMetricsStatistics = this.payMetricsStatistics;
        if (iPayMetricsStatistics != null) {
            if (cReportResponse.mCmd == 0) {
                str = "onQueryProductList";
            } else {
                str = "" + cReportResponse.mCmd;
            }
            String revenueUri = HiidoReport.getInstance().getRevenueUri(this.appId, this.usedChannel, str);
            Intrinsics.checkExpressionValueIsNotNull(revenueUri, "HiidoReport.getInstance(…(appId, usedChannel, cmd)");
            int i = HiidoReport.CReportParam.REVENUE_SCODE;
            String str2 = cReportResponse.mDelay;
            Intrinsics.checkExpressionValueIsNotNull(str2, "(response.mDelay)");
            iPayMetricsStatistics.reportReturnCode(i, revenueUri, Long.parseLong(str2), cReportResponse.mErrCode.toString());
            RLog.debug(this.TAG, "onQueryProductList uri:" + revenueUri);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.statistics.IPayServiceStatistics
    public void onQueryUserYbDetails(HiidoReport.CReportResponse cReportResponse) {
        String str;
        IPayMetricsStatistics iPayMetricsStatistics = this.payMetricsStatistics;
        if (iPayMetricsStatistics != null) {
            if (cReportResponse.mCmd == 0) {
                str = "onQueryUserYbDetails";
            } else {
                str = "" + cReportResponse.mCmd;
            }
            String revenueUri = HiidoReport.getInstance().getRevenueUri(this.appId, this.usedChannel, str);
            Intrinsics.checkExpressionValueIsNotNull(revenueUri, "HiidoReport.getInstance(…(appId, usedChannel, cmd)");
            int i = HiidoReport.CReportParam.REVENUE_SCODE;
            String str2 = cReportResponse.mDelay;
            Intrinsics.checkExpressionValueIsNotNull(str2, "(response.mDelay)");
            iPayMetricsStatistics.reportReturnCode(i, revenueUri, Long.parseLong(str2), cReportResponse.mErrCode.toString());
            RLog.debug(this.TAG, "onQueryUserYbDetails uri:" + revenueUri);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.statistics.IPayServiceStatistics
    public void onShowPayResult(HiidoReport.CReportResponse cReportResponse) {
        String str;
        IPayMetricsStatistics iPayMetricsStatistics = this.payMetricsStatistics;
        if (iPayMetricsStatistics != null) {
            if (cReportResponse.mCmd == 0) {
                str = "onShowPayResult";
            } else {
                str = "" + cReportResponse.mCmd;
            }
            String revenueUri = HiidoReport.getInstance().getRevenueUri(this.appId, this.usedChannel, str);
            Intrinsics.checkExpressionValueIsNotNull(revenueUri, "HiidoReport.getInstance(…(appId, usedChannel, cmd)");
            int i = HiidoReport.CReportParam.REVENUE_SCODE;
            String str2 = cReportResponse.mDelay;
            Intrinsics.checkExpressionValueIsNotNull(str2, "(response.mDelay)");
            iPayMetricsStatistics.reportReturnCode(i, revenueUri, Long.parseLong(str2), cReportResponse.mErrCode.toString());
            RLog.debug(this.TAG, "onShowPayResult uri:" + revenueUri);
        }
    }
}
