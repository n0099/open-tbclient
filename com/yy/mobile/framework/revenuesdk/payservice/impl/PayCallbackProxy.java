package com.yy.mobile.framework.revenuesdk.payservice.impl;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.HiidoReport;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayEventStatistics;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PollingModeInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payservice.utils.JsonDataParerUtil;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayFlowEventType;
/* loaded from: classes8.dex */
public class PayCallbackProxy implements IPayCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public IAppPayService appPayService;
    public IPayCallback iPayCallback;
    public IPayEventStatistics mPayEventReporter;
    public String orderId;
    public ChargeCurrencyReqParams params;
    public String payLoad;
    public IPayServiceCallback payServiceCallback;
    public PayType payType;
    public PollingModeInfo pollingModeInfo;
    public HiidoReport.CReportResponse reportResponse;
    public long requestTime;

    public PayCallbackProxy(PayType payType, String str, ChargeCurrencyReqParams chargeCurrencyReqParams, String str2, PollingModeInfo pollingModeInfo, IPayEventStatistics iPayEventStatistics, IAppPayService iAppPayService, IPayServiceCallback iPayServiceCallback, IPayCallback iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {payType, str, chargeCurrencyReqParams, str2, pollingModeInfo, iPayEventStatistics, iAppPayService, iPayServiceCallback, iPayCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.TAG = "PayCallbackProxy";
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
        this.mPayEventReporter = iPayEventStatistics;
        this.payServiceCallback = iPayServiceCallback;
        this.appPayService = iAppPayService;
        HiidoReport.CReportResponse cReportResponse = new HiidoReport.CReportResponse();
        this.reportResponse = cReportResponse;
        cReportResponse.mPaysource = chargeCurrencyReqParams.getFrom();
        this.reportResponse.mUid = chargeCurrencyReqParams.getUid();
        HiidoReport.CReportResponse cReportResponse2 = this.reportResponse;
        cReportResponse2.mOrderId = this.orderId;
        cReportResponse2.mPayTraceId = chargeCurrencyReqParams.getTraceid();
    }

    private void failCallBackInternal(int i, String str, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65537, this, i, str, payCallBackBean) == null) {
            if (this.iPayCallback != null) {
                PayCallBackBean payCallBackBean2 = new PayCallBackBean(this.orderId, this.params.getProductId(), "", this.requestTime, null, this.payLoad, null, null, PurchaseStatus.PAY_FAIL, this.params.getAppClientExpand());
                this.iPayCallback.onPayStatus(PurchaseStatus.PAY_FAIL, payCallBackBean2);
                this.iPayCallback.onFail(i, " " + str, payCallBackBean2);
            }
            IPayEventStatistics iPayEventStatistics = this.mPayEventReporter;
            if (iPayEventStatistics != null) {
                iPayEventStatistics.reportPayFlowEvent(PayFlowEventType.payingaddpaymentrespone, i + "", "pay failed reason:" + str, this.orderId, "" + this.requestTime, this.params.getProductId(), this.payType.getChannel(), this.params.getTraceid());
            }
            IAppPayService iAppPayService = this.appPayService;
            if (iAppPayService != null && iAppPayService.getPayServiceStatistics() != null) {
                HiidoReport.CReportResponse cReportResponse = this.reportResponse;
                cReportResponse.mEventId = "5";
                cReportResponse.mEventaliae = EventAlias.PayEventAlias.PAY_FAIL;
                cReportResponse.mErrCode = i + "";
                this.reportResponse.mErrMsg = "pay failed reason:" + str;
                this.appPayService.getPayServiceStatistics().onPayResult(this.reportResponse);
            }
            RLog.info("PayCallbackProxy", "payingaddpaymentrespone pay fail! failReason:" + str + " code:" + i + " orderId:" + this.orderId);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
    public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, payCallBackBean) == null) {
            failCallBackInternal(i, str, payCallBackBean);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
    public void onPayStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.iPayCallback != null) {
                this.iPayCallback.onPayStatus(PurchaseStatus.PAY_START, new PayCallBackBean(this.orderId, this.params.getProductId(), "", this.requestTime, JsonDataParerUtil.getChOrderidByPayload(this.payLoad), this.payLoad, null, null, PurchaseStatus.PAY_START, this.params.getAppClientExpand()));
                this.iPayCallback.onPayStart();
            }
            RLog.info("PayCallbackProxy", "onPayStart orderId=" + this.orderId);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
    public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, purchaseStatus, payCallBackBean) == null) {
            this.iPayCallback.onPayStatus(purchaseStatus, payCallBackBean);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
    public void onSuccess(PurchaseInfo purchaseInfo, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, purchaseInfo, payCallBackBean) == null) {
            if (purchaseInfo != null) {
                if (payCallBackBean == null) {
                    payCallBackBean = new PayCallBackBean(this.orderId, this.params.getProductId(), "", this.requestTime, null, this.payLoad, null, null, PurchaseStatus.PAY_SUCCESS, this.params.getAppClientExpand());
                }
                this.iPayCallback.onSuccess("pay success!", payCallBackBean);
            }
            IPayCallback iPayCallback = this.iPayCallback;
            if (iPayCallback != null) {
                iPayCallback.onPayStatus(PurchaseStatus.PAY_SUCCESS, payCallBackBean);
            }
            this.payServiceCallback.requestPayOrderResult(this.params, this.orderId, this.pollingModeInfo);
            IPayEventStatistics iPayEventStatistics = this.mPayEventReporter;
            if (iPayEventStatistics != null) {
                String str = this.orderId;
                iPayEventStatistics.reportPayFlowEvent(PayFlowEventType.payingaddpaymentrespone, "0", "pay success!", str, "" + this.requestTime, this.params.getProductId(), this.payType.getChannel(), this.params.getTraceid());
            }
            IAppPayService iAppPayService = this.appPayService;
            if (iAppPayService != null && iAppPayService.getPayServiceStatistics() != null) {
                HiidoReport.CReportResponse cReportResponse = this.reportResponse;
                cReportResponse.mEventId = "4";
                cReportResponse.mEventaliae = EventAlias.PayEventAlias.PAY_SUCCESS;
                cReportResponse.mErrCode = "1";
                cReportResponse.mErrMsg = "pay success";
                this.appPayService.getPayServiceStatistics().onPayResult(this.reportResponse);
            }
            RLog.info("PayCallbackProxy", "payingaddpaymentrespone pay success! orderId=" + this.orderId);
        }
    }
}
