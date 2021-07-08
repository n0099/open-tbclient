package com.yy.mobile.framework.revenuesdk.payapi.reporter;

import com.yy.mobile.framework.revenuesdk.baseapi.reporter.HiidoReport;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0006J\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0006J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/reporter/IPayReporter;", "Lkotlin/Any;", "Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/HiidoReport$CReportResponse;", "response", "", "onDoHangJob", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/HiidoReport$CReportResponse;)V", "onDoHangJobByProductId", "onOrderResult", "onPayEntrancePage", "onPayResult", "onPayStart", "onPurchaseReportResult", "onPurchaseSummaryResult", "onQueryChargeOrderStatus", "onQueryProductList", "onQueryUserYbDetails", "onRequestPay", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes6.dex */
public interface IPayReporter {
    void onDoHangJob(HiidoReport.CReportResponse cReportResponse);

    void onDoHangJobByProductId(HiidoReport.CReportResponse cReportResponse);

    void onOrderResult(HiidoReport.CReportResponse cReportResponse);

    void onPayEntrancePage(HiidoReport.CReportResponse cReportResponse);

    void onPayResult(HiidoReport.CReportResponse cReportResponse);

    void onPayStart(HiidoReport.CReportResponse cReportResponse);

    void onPurchaseReportResult(HiidoReport.CReportResponse cReportResponse);

    void onPurchaseSummaryResult(HiidoReport.CReportResponse cReportResponse);

    void onQueryChargeOrderStatus(HiidoReport.CReportResponse cReportResponse);

    void onQueryProductList(HiidoReport.CReportResponse cReportResponse);

    void onQueryUserYbDetails(HiidoReport.CReportResponse cReportResponse);

    void onRequestPay(HiidoReport.CReportResponse cReportResponse);
}
