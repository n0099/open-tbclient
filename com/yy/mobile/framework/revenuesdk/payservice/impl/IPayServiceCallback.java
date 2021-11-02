package com.yy.mobile.framework.revenuesdk.payservice.impl;

import com.yy.mobile.framework.revenuesdk.baseapi.reporter.HiidoReport;
import com.yy.mobile.framework.revenuesdk.payapi.bean.AccountDelayMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ConsumeConfirmMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PollingModeInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.PayOrderResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.response.IResponse;
/* loaded from: classes2.dex */
public interface IPayServiceCallback {
    void dealOnOrderInter(IResponse iResponse, ChargeCurrencyReqParams chargeCurrencyReqParams, PayOrderResult payOrderResult, IRequest iRequest, HiidoReport.CReportResponse cReportResponse, long j);

    void onAccountDelayMessage(AccountDelayMessage accountDelayMessage);

    void onConsumeConfirmMessage(ConsumeConfirmMessage consumeConfirmMessage);

    void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage);

    void pollingPayResult(ChargeCurrencyReqParams chargeCurrencyReqParams, String str, PollingModeInfo pollingModeInfo);

    void showVerifyViewWithInfoString(String str, ChargeCurrencyReqParams chargeCurrencyReqParams, IResponse iResponse, IRequest iRequest);
}
