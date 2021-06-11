package com.yy.mobile.framework.revenuesdk.payservice.impl;

import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.HiidoReport;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.ISDKReporter;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PollingModeInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payservice.utils.JsonDataParerUtil;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayEventType;
import java.util.Locale;
/* loaded from: classes7.dex */
public class PayCallbackProxy implements IPayCallback<PurchaseInfo> {
    public final String TAG = "AppPayServiceImpl";
    public IAppPayService appPayService;
    public IPayCallback iPayCallback;
    public ISDKReporter mSDKRepoter;
    public String orderId;
    public ChargeCurrencyReqParams params;
    public IPayInnerLogic payInnerLogic;
    public String payLoad;
    public PayType payType;
    public PollingModeInfo pollingModeInfo;
    public HiidoReport.CReportResponse reportResponse;
    public long requestTime;

    public PayCallbackProxy(PayType payType, String str, ChargeCurrencyReqParams chargeCurrencyReqParams, String str2, PollingModeInfo pollingModeInfo, String str3, ISDKReporter iSDKReporter, IAppPayService iAppPayService, IPayInnerLogic iPayInnerLogic, IPayCallback iPayCallback) {
        this.orderId = "";
        this.payType = payType;
        if (str != null) {
            this.orderId = str;
        }
        this.requestTime = System.currentTimeMillis();
        this.params = chargeCurrencyReqParams;
        this.iPayCallback = iPayCallback;
        this.payLoad = str2;
        this.pollingModeInfo = pollingModeInfo;
        this.mSDKRepoter = iSDKReporter;
        this.payInnerLogic = iPayInnerLogic;
        this.appPayService = iAppPayService;
        HiidoReport.CReportResponse cReportResponse = new HiidoReport.CReportResponse();
        this.reportResponse = cReportResponse;
        cReportResponse.mPaysource = chargeCurrencyReqParams.getFrom();
        this.reportResponse.mUid = chargeCurrencyReqParams.getUid();
        HiidoReport.CReportResponse cReportResponse2 = this.reportResponse;
        cReportResponse2.mOrderId = this.orderId;
        cReportResponse2.mPayTraceId = chargeCurrencyReqParams.getTraceid();
        this.reportResponse.mPageId = str3;
    }

    private void failCallBackInternal(int i2, String str, PayCallBackBean payCallBackBean) {
        if (payCallBackBean == null) {
            new PayCallBackBean(this.orderId, this.params.getProductId(), "", this.requestTime, null, this.payLoad, null, null, PurchaseStatus.PAY_FAIL, this.params.getAppClientExpand());
        }
        if (this.iPayCallback != null) {
            PayCallBackBean payCallBackBean2 = new PayCallBackBean(this.orderId, this.params.getProductId(), "", this.requestTime, null, this.payLoad, null, null, PurchaseStatus.PAY_FAIL, this.params.getAppClientExpand());
            this.iPayCallback.onPayStatus(PurchaseStatus.PAY_FAIL, payCallBackBean2);
            this.iPayCallback.onFail(i2, "pay fail! failReason:" + str, payCallBackBean2);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.requestTime;
        RLog.info("AppPayServiceImpl", String.format(Locale.ENGLISH, "---PayCallbackProxy, pay onFail: requestTime = %s, delay = %s, uid = %s, orderid = %s", Long.valueOf(j), (currentTimeMillis - j) + "", Long.valueOf(this.params.getUid()), this.orderId));
        ISDKReporter iSDKReporter = this.mSDKRepoter;
        if (iSDKReporter != null) {
            iSDKReporter.reportPayFlow(PayEventType.payingaddpaymentrespone, i2 + "", "pay fail! failReason:" + str, this.orderId, "" + this.requestTime, this.params.getProductId(), this.payType.getChannel(), this.params.getTraceid());
        }
        RLog.warn("AppPayServiceImpl", "payingaddpaymentrespone pay fail! failReason:" + str + " code:" + i2 + " orderId:" + this.orderId);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
    public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
        failCallBackInternal(i2, str, payCallBackBean);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
    public void onPayStart() {
        if (this.iPayCallback != null) {
            this.iPayCallback.onPayStatus(PurchaseStatus.PAY_START, new PayCallBackBean(this.orderId, this.params.getProductId(), "", this.requestTime, JsonDataParerUtil.getChOrderidByPayload(this.payLoad), this.payLoad, null, null, PurchaseStatus.PAY_START, this.params.getAppClientExpand()));
            this.iPayCallback.onPayStart();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.requestTime;
        Locale locale = Locale.ENGLISH;
        RLog.info("AppPayServiceImpl", String.format(locale, "---PayCallbackProxy-onPayStart: requestTime = %s, delay = %s, uid = %s, orderid = %s", Long.valueOf(j), (currentTimeMillis - j) + "", Long.valueOf(this.params.getUid()), this.orderId));
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
    public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
        this.iPayCallback.onPayStatus(purchaseStatus, payCallBackBean);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
    public void onSuccess(PurchaseInfo purchaseInfo, PayCallBackBean payCallBackBean) {
        PayCallBackBean payCallBackBean2;
        long currentTimeMillis = System.currentTimeMillis() - this.requestTime;
        if (purchaseInfo != null) {
            payCallBackBean2 = payCallBackBean == null ? new PayCallBackBean(this.orderId, this.params.getProductId(), "", this.requestTime, null, this.payLoad, null, null, PurchaseStatus.PAY_SUCCESS, this.params.getAppClientExpand()) : payCallBackBean;
            this.iPayCallback.onSuccess("pay success!", payCallBackBean2);
            Locale locale = Locale.ENGLISH;
            RLog.info("AppPayServiceImpl", String.format(locale, "---PayCallbackProxy-pay-onSuccess: requestTime = %s, delay = %s, Uid =%s, OrderId =%s", Long.valueOf(this.requestTime), currentTimeMillis + "", Long.valueOf(this.params.getUid()), this.orderId));
        } else {
            payCallBackBean2 = payCallBackBean;
        }
        IPayCallback iPayCallback = this.iPayCallback;
        if (iPayCallback != null) {
            iPayCallback.onPayStatus(PurchaseStatus.PAY_SUCCESS, payCallBackBean2);
        }
        this.payInnerLogic.pollingForChargeResult(this.params, this.orderId, this.pollingModeInfo);
        ISDKReporter iSDKReporter = this.mSDKRepoter;
        if (iSDKReporter != null) {
            String str = this.orderId;
            iSDKReporter.reportPayFlow(PayEventType.payingaddpaymentrespone, "0", "pay success!", str, "" + this.requestTime, this.params.getProductId(), this.payType.getChannel(), this.params.getTraceid());
        }
        RLog.warn("AppPayServiceImpl", "payingaddpaymentrespone pay success! orderId=" + this.orderId);
    }
}
