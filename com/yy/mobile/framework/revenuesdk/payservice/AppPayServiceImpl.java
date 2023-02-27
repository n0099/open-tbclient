package com.yy.mobile.framework.revenuesdk.payservice;

import android.app.Activity;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.IToken;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver;
import com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageResponse;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.HiidoReport;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayEventStatistics;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayMetricsStatistics;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.TraceIdUtil;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.IPaySignCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaySignInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PollingModeInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.PayOrderResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.SplitOrderConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayAliSignMethod;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetChargeOrderStatusReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetSplitOrderConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.RequestParams;
import com.yy.mobile.framework.revenuesdk.payapi.statistics.IPayServiceStatistics;
import com.yy.mobile.framework.revenuesdk.payapi.statistics.PayServiceStatisticsImpl;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayManager;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayParams;
import com.yy.mobile.framework.revenuesdk.payservice.impl.IPayServiceCallback;
import com.yy.mobile.framework.revenuesdk.payservice.impl.PayCallbackProxy;
import com.yy.mobile.framework.revenuesdk.payservice.impl.PayOrderResultPoller;
import com.yy.mobile.framework.revenuesdk.payservice.impl.PayRespDispatcher;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.IRevenueService;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueService;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.response.IResponse;
import com.yy.mobile.framework.revenuesdk.payservice.utils.JsonDataParerUtil;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayFlowEventType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class AppPayServiceImpl implements IAppPayService, IPayServiceCallback, IRevenueDataReceiver, IRevenueService.IRevenueServiceListener {
    public static final String TAG = "AppPayServiceImpl";
    public List<IAppPayServiceListener> listeners = new ArrayList();
    public int mAppId;
    public IPayEventStatistics mPayEventStatistics;
    public PayOrderResultPoller mPayOrderResultPoller;
    public PayRespDispatcher mPayRespDispatcher;
    public IPayServiceStatistics mPayServiceStatistics;
    public ProtocolType mProtocolType;
    public RevenueService mRevenueService;
    public int mUsedChannel;

    private boolean checkNotNull(RequestParams requestParams, IResult iResult) {
        return (requestParams == null || iResult == null) ? false : true;
    }

    public AppPayServiceImpl(int i, int i2, boolean z, IRevenueDataSender iRevenueDataSender, IPayMetricsStatistics iPayMetricsStatistics, IPayEventStatistics iPayEventStatistics, ProtocolType protocolType) {
        this.mAppId = i;
        this.mUsedChannel = i2;
        this.mPayEventStatistics = iPayEventStatistics;
        this.mProtocolType = protocolType;
        this.mRevenueService = new RevenueService(i, i2, iRevenueDataSender, this, z, protocolType);
        PayServiceStatisticsImpl payServiceStatisticsImpl = new PayServiceStatisticsImpl(iPayMetricsStatistics, this.mAppId, this.mUsedChannel);
        this.mPayServiceStatistics = payServiceStatisticsImpl;
        this.mPayRespDispatcher = new PayRespDispatcher(payServiceStatisticsImpl, this);
        this.mPayOrderResultPoller = new PayOrderResultPoller(this, this, this.mPayEventStatistics);
        RLog.info("AppPayServiceImpl", "create AppPayServiceImpl versionName:4.3.36-bdpay appId:" + i + " usedChannel:" + i2);
    }

    private void doOrderRequest(@NonNull Activity activity, @NonNull ChargeCurrencyReqParams chargeCurrencyReqParams, @NonNull ProductInfo productInfo, @NonNull PayType payType, int i, int i2, int i3, IPayCallback iPayCallback) {
        String onUpdateToken;
        RLog.info("AppPayServiceImpl", "---doOrderRequest---");
        if (!checkNotNull(chargeCurrencyReqParams, iPayCallback)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!isSupported(activity, payType)) {
            iPayCallback.onFail(IPayMethod.Status.NOT_SUPPORT.getCode(), IPayMethod.Status.NOT_SUPPORT.getMessage(), new PayCallBackBean(null, productInfo.productId, null, currentTimeMillis, null, null, null, null, PurchaseStatus.ORDER_FAIL, chargeCurrencyReqParams.getAppClientExpand()));
            return;
        }
        chargeCurrencyReqParams.setContextWeakRef(new WeakReference<>(activity));
        chargeCurrencyReqParams.setCallback(iPayCallback);
        chargeCurrencyReqParams.setPayChannel(payType.getChannel());
        chargeCurrencyReqParams.setPayMethod(payType.getMethod());
        chargeCurrencyReqParams.setSrcAmount(productInfo.srcAmount);
        chargeCurrencyReqParams.setProductId(productInfo.productId);
        chargeCurrencyReqParams.setCid(productInfo.cid);
        ChargeCurrencyReqParams clone = ChargeCurrencyReqParams.Companion.clone(chargeCurrencyReqParams);
        clone.setPayChannel(payType.getChannel());
        clone.setPayMethod(payType.getMethod());
        clone.setSrcAmount(productInfo.srcAmount);
        clone.setProductId(productInfo.productId);
        clone.setCid(productInfo.cid);
        clone.setRetryCount(i);
        clone.setIntervalMs(i2);
        clone.setTimeOutMs(i3);
        clone.setPayType(payType);
        clone.setProductId(chargeCurrencyReqParams.getProductId());
        clone.setFrom(chargeCurrencyReqParams.getFrom());
        clone.setSubscriptionType(chargeCurrencyReqParams.getSubscriptionType());
        clone.setOldProductId(chargeCurrencyReqParams.getOldProductId());
        clone.setProrationMode(chargeCurrencyReqParams.getProrationMode());
        clone.setReturnUrl(chargeCurrencyReqParams.getReturnUrl());
        clone.setExpand(chargeCurrencyReqParams.getExpand());
        clone.setRequestTime(currentTimeMillis);
        clone.setTokenCallback(chargeCurrencyReqParams.getTokenCallback());
        clone.setTraceid(chargeCurrencyReqParams.getTraceid());
        clone.setFrom(chargeCurrencyReqParams.getFrom());
        clone.setAppClientExpand(chargeCurrencyReqParams.getAppClientExpand());
        clone.setPayFlowTypeId(chargeCurrencyReqParams.getPayFlowTypeId());
        IToken tokenCallback = chargeCurrencyReqParams.getTokenCallback();
        if (tokenCallback != null && (onUpdateToken = tokenCallback.onUpdateToken()) != null) {
            clone.setToken(onUpdateToken);
            RLog.info("AppPayServiceImpl", "doOrderRequest---onUpdateToken");
        }
        clone.setCid(chargeCurrencyReqParams.getCid());
        clone.setCurrencyType(chargeCurrencyReqParams.getCurrencyType());
        clone.setCurrencyType(chargeCurrencyReqParams.getCurrencyType());
        RLog.info("AppPayServiceImpl", "doOrderRequest---reqParams:" + clone.getPayType() + " " + clone.getSubscriptionType() + " " + clone.getCid() + "requestTime:" + currentTimeMillis + "--productId:" + clone.getProductId());
        iPayCallback.onPayStatus(PurchaseStatus.ORDER_START, new PayCallBackBean(null, clone.getProductId(), null, clone.getRequestTime(), null, null, null, null, PurchaseStatus.ORDER_START, clone.getAppClientExpand()));
        IRequest obtainRequest = this.mRevenueService.obtainRequest(1022, chargeCurrencyReqParams);
        obtainRequest.setExtParam(clone);
        this.mRevenueService.sendRequest(obtainRequest);
        HiidoReport.CReportResponse cReportResponse = new HiidoReport.CReportResponse();
        cReportResponse.mPaysource = chargeCurrencyReqParams.getFrom();
        cReportResponse.mUid = chargeCurrencyReqParams.getUid();
        cReportResponse.mPayTraceId = chargeCurrencyReqParams.getTraceid();
        IPayServiceStatistics iPayServiceStatistics = this.mPayServiceStatistics;
        if (iPayServiceStatistics != null) {
            cReportResponse.mEventId = "0";
            cReportResponse.mEventaliae = EventAlias.PayEventAlias.REQUUEST_PAY;
            cReportResponse.mErrCode = "1";
            cReportResponse.mErrMsg = "doOrderRequest";
            iPayServiceStatistics.onRequestPay(cReportResponse);
        }
    }

    private void reportOrderProductFail(IResponse iResponse, ChargeCurrencyReqParams chargeCurrencyReqParams, PayOrderResult payOrderResult, HiidoReport.CReportResponse cReportResponse) {
        String str;
        if (this.mPayServiceStatistics != null) {
            cReportResponse.mEventId = "2";
            cReportResponse.mEventaliae = EventAlias.PayEventAlias.ORDER_FAIL;
            cReportResponse.mErrCode = iResponse.getResponseCode() + "";
            cReportResponse.mErrMsg = "order fail, reason:" + iResponse.getMessage();
            this.mPayServiceStatistics.onOrderResult(cReportResponse);
        }
        if (this.mPayEventStatistics != null) {
            if (payOrderResult == null) {
                str = "";
            } else {
                str = payOrderResult.getOrderId();
            }
            this.mPayEventStatistics.reportPayFlowEvent(PayFlowEventType.payorder, iResponse.getResponseCode() + "", "order fail, reason:" + iResponse.getMessage(), str, "" + chargeCurrencyReqParams.getRequestTime(), chargeCurrencyReqParams.getProductId(), chargeCurrencyReqParams.getPayType().getChannel(), chargeCurrencyReqParams.getTraceid());
        }
    }

    private void reportOrderProductSuccess(IResponse iResponse, ChargeCurrencyReqParams chargeCurrencyReqParams, PayOrderResult payOrderResult, HiidoReport.CReportResponse cReportResponse) {
        IPayEventStatistics iPayEventStatistics = this.mPayEventStatistics;
        if (iPayEventStatistics != null) {
            iPayEventStatistics.reportPayFlowEvent(PayFlowEventType.payorder, iResponse.getResponseCode() + "", "order success!" + iResponse.getMessage(), payOrderResult.getOrderId(), "" + chargeCurrencyReqParams.getRequestTime(), chargeCurrencyReqParams.getProductId(), chargeCurrencyReqParams.getPayType().getChannel(), chargeCurrencyReqParams.getTraceid());
        }
        if (this.mPayServiceStatistics != null) {
            cReportResponse.mEventId = "1";
            cReportResponse.mEventaliae = EventAlias.PayEventAlias.ORDER_SUCCESS;
            cReportResponse.mErrCode = iResponse.getResponseCode() + "";
            cReportResponse.mErrMsg = "order success!" + iResponse.getMessage();
            this.mPayServiceStatistics.onOrderResult(cReportResponse);
        }
    }

    private void reportPayRequestEvent(String str, String str2, ChargeCurrencyReqParams chargeCurrencyReqParams) {
        IPayEventStatistics iPayEventStatistics = this.mPayEventStatistics;
        if (iPayEventStatistics != null) {
            iPayEventStatistics.reportPayFlowEvent(PayFlowEventType.payingaddpaymentrequest, "0", str2, str, "" + chargeCurrencyReqParams.getRequestTime(), chargeCurrencyReqParams.getProductId(), chargeCurrencyReqParams.getPayType().getChannel(), chargeCurrencyReqParams.getTraceid());
        }
    }

    private void requestH5PayOnMainThread(final ChargeCurrencyReqParams chargeCurrencyReqParams, final PayOrderResult payOrderResult, final PayCallBackBean payCallBackBean) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            IPayCallback iPayCallback = (IPayCallback) chargeCurrencyReqParams.getCallback();
            if (iPayCallback != null) {
                iPayCallback.onPayStatus(PurchaseStatus.ORDER_SUCCESS, payCallBackBean);
            }
            ((IPayCallback) chargeCurrencyReqParams.getCallback()).onSuccess(payOrderResult.getPayUrl(), payCallBackBean);
            requestH5Pay(payOrderResult.getOrderId(), chargeCurrencyReqParams, payCallBackBean);
            return;
        }
        ThreadPool.getDefault().mainThreadIO().execute(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.payservice.AppPayServiceImpl.2
            @Override // java.lang.Runnable
            public void run() {
                IPayCallback iPayCallback2 = (IPayCallback) chargeCurrencyReqParams.getCallback();
                if (iPayCallback2 != null) {
                    iPayCallback2.onPayStatus(PurchaseStatus.ORDER_SUCCESS, payCallBackBean);
                }
                ((IPayCallback) chargeCurrencyReqParams.getCallback()).onSuccess(payOrderResult.getPayUrl(), payCallBackBean);
                AppPayServiceImpl.this.requestH5Pay(payOrderResult.getOrderId(), chargeCurrencyReqParams, payCallBackBean);
            }
        });
    }

    private void reportSignPayFlowEvent(ChargeCurrencyReqParams chargeCurrencyReqParams, PayType payType, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        IPayEventStatistics iPayEventStatistics = this.mPayEventStatistics;
        if (iPayEventStatistics != null) {
            iPayEventStatistics.reportPayFlowEvent(PayFlowEventType.payingaddpaymentrespone, "0", "sign pay success!", str, "" + currentTimeMillis, chargeCurrencyReqParams.getProductId(), payType.getChannel(), chargeCurrencyReqParams.getTraceid());
        }
        HiidoReport.CReportResponse cReportResponse = new HiidoReport.CReportResponse();
        cReportResponse.mPaysource = chargeCurrencyReqParams.getFrom();
        cReportResponse.mUid = chargeCurrencyReqParams.getUid();
        cReportResponse.mOrderId = str;
        cReportResponse.mPayTraceId = chargeCurrencyReqParams.getTraceid();
        IPayServiceStatistics payServiceStatistics = getPayServiceStatistics();
        if (payServiceStatistics != null) {
            cReportResponse.mEventId = "4";
            cReportResponse.mEventaliae = EventAlias.PayEventAlias.PAY_SUCCESS;
            cReportResponse.mErrCode = "1";
            cReportResponse.mErrMsg = "sign pay success";
            payServiceStatistics.onPayResult(cReportResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestH5Pay(String str, ChargeCurrencyReqParams chargeCurrencyReqParams, PayCallBackBean payCallBackBean) {
        H5PayParams h5PayParams = new H5PayParams();
        h5PayParams.orderId = str;
        h5PayParams.payBackBean = payCallBackBean;
        h5PayParams.appClientExpand = chargeCurrencyReqParams.getAppClientExpand();
        h5PayParams.appId = chargeCurrencyReqParams.getAppId();
        h5PayParams.usedChannel = chargeCurrencyReqParams.getUsedChannel();
        h5PayParams.uid = chargeCurrencyReqParams.getUid();
        h5PayParams.payType = chargeCurrencyReqParams.getPayType();
        h5PayParams.sid = chargeCurrencyReqParams.getSid();
        h5PayParams.token = chargeCurrencyReqParams.getToken();
        h5PayParams.tokenCallback = chargeCurrencyReqParams.getTokenCallback();
        h5PayParams.payChannel = chargeCurrencyReqParams.getPayChannel();
        h5PayParams.payMethod = chargeCurrencyReqParams.getPayMethod();
        h5PayParams.traceid = chargeCurrencyReqParams.getTraceid();
        h5PayParams.cid = chargeCurrencyReqParams.getCid();
        h5PayParams.payFlowTypeId = chargeCurrencyReqParams.getPayFlowTypeId();
        h5PayParams.appPayService = this;
        h5PayParams.payServiceCallback = this;
        H5PayManager.getInstance().requestH5Pay(chargeCurrencyReqParams.getContext(), str, h5PayParams);
        reportPayRequestEvent(str, "request h5 pay", chargeCurrencyReqParams);
    }

    private void requestPay(String str, Activity activity, ChargeCurrencyReqParams chargeCurrencyReqParams, PayType payType, String str2, String str3, IPayCallback iPayCallback) {
        RLog.info("AppPayServiceImpl", "payingaddpaymentrequest request sdk Pay orderId:" + str);
        PayMethodFactory.valueOf(payType).requestPay(activity, chargeCurrencyReqParams.getUid(), str2, str3, iPayCallback);
        reportPayRequestEvent(str, "request sdk pay", chargeCurrencyReqParams);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public synchronized void addPayListener(IAppPayServiceListener iAppPayServiceListener) {
        if (iAppPayServiceListener != null) {
            this.listeners.add(iAppPayServiceListener);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.IPayServiceCallback
    public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
        for (IAppPayServiceListener iAppPayServiceListener : this.listeners) {
            iAppPayServiceListener.onCurrencyChargeMessage(currencyChargeMessage);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void registerPayServiceStatistics(IPayServiceStatistics iPayServiceStatistics) {
        RLog.debug("AppPayServiceImpl", "registerPayReporter IPayServiceReporter = " + iPayServiceStatistics);
        this.mPayServiceStatistics = iPayServiceStatistics;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
        r0.remove();
     */
    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void removePayListener(IAppPayServiceListener iAppPayServiceListener) {
        Iterator<IAppPayServiceListener> it = this.listeners.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (iAppPayServiceListener == it.next()) {
                break;
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void cancelAllRequest() {
        RLog.info("AppPayServiceImpl", "cancelAllRequest");
        this.mRevenueService.cancelAllRequest();
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public IPayServiceStatistics getPayServiceStatistics() {
        return this.mPayServiceStatistics;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.IPayServiceCallback
    public void dealOnOrderInter(IResponse iResponse, ChargeCurrencyReqParams chargeCurrencyReqParams, PayOrderResult payOrderResult, IRequest iRequest, HiidoReport.CReportResponse cReportResponse, long j) {
        IPayCallback iPayCallback;
        if (iResponse.isSuccess() && chargeCurrencyReqParams != null && payOrderResult != null) {
            RLog.info("AppPayServiceImpl", "payorder success! orderid=" + payOrderResult.getOrderId());
            String payUrl = payOrderResult.getPayUrl();
            PayCallBackBean payCallBackBean = new PayCallBackBean(payOrderResult.getOrderId(), chargeCurrencyReqParams.getProductId(), null, chargeCurrencyReqParams.getRequestTime(), JsonDataParerUtil.getChOrderidByPayload(payUrl), payUrl, null, null, PurchaseStatus.ORDER_SUCCESS, chargeCurrencyReqParams.getAppClientExpand());
            if (chargeCurrencyReqParams.getPayType() != PayType.DXM_PAY_KJ && chargeCurrencyReqParams.getPayType() != PayType.MOCK_TEST_PAY && chargeCurrencyReqParams.getPayType() != PayType.UNION_PAY && chargeCurrencyReqParams.getPayType() != PayType.DXM_PAY_H5) {
                IPayCallback iPayCallback2 = (IPayCallback) chargeCurrencyReqParams.getCallback();
                if (iPayCallback2 != null) {
                    iPayCallback2.onPayStatus(PurchaseStatus.ORDER_SUCCESS, payCallBackBean);
                }
                if (chargeCurrencyReqParams.getPayType() == PayType.ALI_PAY_SIGN) {
                    iPayCallback2.onPayStatus(PurchaseStatus.PAY_SUCCESS, payCallBackBean);
                    iPayCallback2.onSuccess("ali sign pay success", null);
                    requestPayOrderResult(chargeCurrencyReqParams, payOrderResult.getOrderId(), payOrderResult.getPollingModeInfo());
                    reportSignPayFlowEvent(chargeCurrencyReqParams, chargeCurrencyReqParams.getPayType(), payOrderResult.getOrderId());
                } else {
                    requestPay(payOrderResult.getOrderId(), chargeCurrencyReqParams.getContext(), chargeCurrencyReqParams, chargeCurrencyReqParams.getPayType(), chargeCurrencyReqParams.getProductId(), payUrl, new PayCallbackProxy(chargeCurrencyReqParams.getPayType(), payOrderResult.getOrderId(), chargeCurrencyReqParams, payUrl, payOrderResult.getPollingModeInfo(), this.mPayEventStatistics, this, this, iPayCallback2));
                }
            } else {
                requestH5PayOnMainThread(chargeCurrencyReqParams, payOrderResult, payCallBackBean);
            }
            reportOrderProductSuccess(iResponse, chargeCurrencyReqParams, payOrderResult, cReportResponse);
            return;
        }
        if (chargeCurrencyReqParams != null && payOrderResult != null) {
            RLog.error("AppPayServiceImpl", "payorder fail! orderid=" + payOrderResult.getOrderId() + " code=" + iResponse.getResponseCode() + " errMsg=" + iResponse.getMessage(), new Object[0]);
        } else {
            RLog.error("AppPayServiceImpl", "payorder fail! code=" + iResponse.getResponseCode() + "errMsg=" + iResponse.getMessage(), new Object[0]);
        }
        PayCallBackBean payCallBackBean2 = new PayCallBackBean(null, chargeCurrencyReqParams.getProductId(), null, chargeCurrencyReqParams.getRequestTime(), null, null, null, null, PurchaseStatus.ORDER_FAIL, chargeCurrencyReqParams.getAppClientExpand());
        if (chargeCurrencyReqParams != null && (iPayCallback = (IPayCallback) chargeCurrencyReqParams.getCallback()) != null) {
            iPayCallback.onPayStatus(PurchaseStatus.ORDER_FAIL, payCallBackBean2);
        }
        if (chargeCurrencyReqParams.getPayType() != PayType.ALI_PAY_SIGN) {
            this.mPayRespDispatcher.onFail(iRequest.getReqSeq(), iResponse.getResponseCode(), iResponse.getMessage(), chargeCurrencyReqParams.getCallback(), payCallBackBean2);
        }
        reportOrderProductFail(iResponse, chargeCurrencyReqParams, payOrderResult, cReportResponse);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public boolean isSupported(Activity activity, PayType payType) {
        boolean z;
        boolean z2;
        IPayMethod valueOf = PayMethodFactory.valueOf(payType);
        if (valueOf != null) {
            z = valueOf.isSupported(activity);
        } else {
            z = false;
        }
        IPayAliSignMethod valueOf2 = PaySignMethodFactory.valueOf(payType);
        if (valueOf2 != null) {
            z2 = valueOf2.isSupported(activity);
        } else {
            z2 = false;
        }
        if (valueOf == null && valueOf2 == null) {
            RLog.warn("AppPayServiceImpl", "isSupported but pay null");
        }
        if (!z && !z2) {
            return false;
        }
        return true;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void onQQPayResult(int i, String str) {
        IPayMethod valueOf = PayMethodFactory.valueOf(PayType.QQ_PAY);
        if (valueOf != null) {
            valueOf.onQQPayResult(i, str);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.IRevenueService.IRevenueServiceListener
    public void onRevenueResponse(int i, IResponse iResponse) {
        RLog.debug("AppPayServiceImpl", "onRevenueResponse command = " + i);
        this.mPayRespDispatcher.onRevenueResponse(i, iResponse);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void onWxPayResult(int i, String str) {
        IPayMethod valueOf = PayMethodFactory.valueOf(PayType.WECHAT_PAY);
        if (valueOf != null) {
            valueOf.onWxPayResult(i, str);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryBannerConfigRequest(@NonNull GetBannerConfigReqParams getBannerConfigReqParams, IResult<BannerConfigResult> iResult) {
        if (!checkNotNull(getBannerConfigReqParams, iResult)) {
            return;
        }
        getBannerConfigReqParams.setCallback(iResult);
        getBannerConfigReqParams.setRequestTime(System.currentTimeMillis());
        getBannerConfigReqParams.setTraceid(TraceIdUtil.newTraceId());
        IRequest obtainRequest = this.mRevenueService.obtainRequest(RevenueServerConst.GetBannerConfigRequest, getBannerConfigReqParams);
        obtainRequest.setExtParam(getBannerConfigReqParams);
        this.mRevenueService.sendRequest(obtainRequest);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryChargeOrderStatus(@NonNull GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, IResult<GetChargeOrderStatusResult> iResult) {
        if (!checkNotNull(getChargeOrderStatusReqParams, iResult)) {
            return;
        }
        getChargeOrderStatusReqParams.setCallback(iResult);
        getChargeOrderStatusReqParams.setRequestTime(System.currentTimeMillis());
        getChargeOrderStatusReqParams.setTraceid(TraceIdUtil.newTraceId());
        IRequest obtainRequest = this.mRevenueService.obtainRequest(RevenueServerConst.GetChargeOrderStatusRequest, getChargeOrderStatusReqParams);
        obtainRequest.setExtParam(getChargeOrderStatusReqParams);
        this.mRevenueService.sendRequest(obtainRequest);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryMyBalance(@NonNull QueryCurrencyReqParams queryCurrencyReqParams, IResult<MyBalanceResult> iResult) {
        if (!checkNotNull(queryCurrencyReqParams, iResult)) {
            return;
        }
        queryCurrencyReqParams.setCallback(iResult);
        IRequest obtainRequest = this.mRevenueService.obtainRequest(1005, queryCurrencyReqParams);
        obtainRequest.setExtParam(queryCurrencyReqParams);
        this.mRevenueService.sendRequest(obtainRequest);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryProductList(@NonNull QueryCurrencyReqParams queryCurrencyReqParams, IResult<ProductListResult> iResult) {
        if (!checkNotNull(queryCurrencyReqParams, iResult)) {
            return;
        }
        queryCurrencyReqParams.setCallback(iResult);
        queryCurrencyReqParams.setRequestTime(System.currentTimeMillis());
        queryCurrencyReqParams.setTraceid(TraceIdUtil.newTraceId());
        IRequest obtainRequest = this.mRevenueService.obtainRequest(1021, queryCurrencyReqParams);
        obtainRequest.setExtParam(queryCurrencyReqParams);
        this.mRevenueService.sendRequest(obtainRequest);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void querySplitOrderConfig(GetSplitOrderConfigReqParams getSplitOrderConfigReqParams, IResult<SplitOrderConfigResult> iResult) {
        if (!checkNotNull(getSplitOrderConfigReqParams, iResult)) {
            return;
        }
        getSplitOrderConfigReqParams.setCallback(iResult);
        getSplitOrderConfigReqParams.setRequestTime(System.currentTimeMillis());
        getSplitOrderConfigReqParams.setTraceid(TraceIdUtil.newTraceId());
        IRequest obtainRequest = this.mRevenueService.obtainRequest(RevenueServerConst.GetChargeCurrencySplitRequest, getSplitOrderConfigReqParams);
        obtainRequest.setExtParam(getSplitOrderConfigReqParams);
        this.mRevenueService.sendRequest(obtainRequest);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onRequestError(int i, int i2, String str, int i3, int i4, String str2) {
        RLog.debug("AppPayServiceImpl", "onResponseData cmd = " + i3 + " srvErrorCode = " + i4 + " message =" + str2);
        this.mRevenueService.onRequestError(i, i2, str, i3, i4, str2);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onResponseData(int i, int i2, PSCIMessageResponse pSCIMessageResponse) {
        RLog.debug("AppPayServiceImpl", "onResponseData responseData = " + pSCIMessageResponse);
        this.mRevenueService.onResponseData(i, i2, pSCIMessageResponse);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.IPayServiceCallback
    public void requestPayOrderResult(ChargeCurrencyReqParams chargeCurrencyReqParams, final String str, PollingModeInfo pollingModeInfo) {
        chargeCurrencyReqParams.setProtocolType(this.mProtocolType);
        this.mPayOrderResultPoller.tryGetPayResult(chargeCurrencyReqParams, this.mAppId, str, pollingModeInfo, new PayOrderResultPoller.PollerListener() { // from class: com.yy.mobile.framework.revenuesdk.payservice.AppPayServiceImpl.1
            @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.PayOrderResultPoller.PollerListener
            public void onSuccess(ChargeCurrencyReqParams chargeCurrencyReqParams2, GetChargeOrderStatusResult getChargeOrderStatusResult) {
                RLog.info("AppPayServiceImpl", "paychargeorderStatus success orderId:" + str);
            }

            @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.PayOrderResultPoller.PollerListener
            public void onFail(ChargeCurrencyReqParams chargeCurrencyReqParams2, int i, String str2) {
                RLog.error("AppPayServiceImpl", "paychargeorderStatus onFail orderId:" + str + " code:" + i + " failReason:" + str2, new Object[0]);
            }
        });
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void signAliPay(Activity activity, PaySignInfo paySignInfo, IPaySignCallback iPaySignCallback) {
        PaySignMethodFactory.valueOf(PayType.ALI_PAY_SIGN).requestSign(activity, paySignInfo, iPaySignCallback);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void payWithProductInfo(@NonNull Activity activity, @NonNull ChargeCurrencyReqParams chargeCurrencyReqParams, @NonNull ProductInfo productInfo, @NonNull PayType payType, int i, int i2, int i3, IPayCallback<String> iPayCallback) {
        RLog.info("AppPayServiceImpl", "---payWithProductInfo---");
        doOrderRequest(activity, chargeCurrencyReqParams, productInfo, payType, i, i2, i3, iPayCallback);
        IPayEventStatistics iPayEventStatistics = this.mPayEventStatistics;
        if (iPayEventStatistics != null) {
            iPayEventStatistics.reportPayFlowEvent(PayFlowEventType.payingstart, "0", "doOrderRequest", "", "" + chargeCurrencyReqParams.getRequestTime(), productInfo.productId, payType.getChannel(), chargeCurrencyReqParams.getTraceid());
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void requestPay(Activity activity, PayType payType, String str, String str2, IPayCallback<PurchaseInfo> iPayCallback) {
        RLog.info("AppPayServiceImpl", "requstPay,payType:" + payType + ",productId:" + str + ",payload:" + str2);
        PayMethodFactory.valueOf(payType).requestPay(activity, 0L, str, str2, iPayCallback);
    }
}
