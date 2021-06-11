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
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageBroadcast;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageResponse;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageUnicast;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.HiidoReport;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IReporter;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.ISDKReporter;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.PageIdUtil;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.TraceIdUtil;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.AccountDelayMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ConsumeConfirmMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PollingModeInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ExchangeResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetUserYbDetailsResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.PayOrderResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.RechargeHistoryResult;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IAlipaySdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IDxmSdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IWechatSdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.PayMethodProxyFactory;
import com.yy.mobile.framework.revenuesdk.payapi.reporter.IPayReporter;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.ExchangeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetChargeOrderStatusReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetUserYbDetailsReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyChannelsReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryRechargeHistoryReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.RequestParams;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayManager;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayParams;
import com.yy.mobile.framework.revenuesdk.payservice.impl.IPayInnerLogic;
import com.yy.mobile.framework.revenuesdk.payservice.impl.PayCallbackProxy;
import com.yy.mobile.framework.revenuesdk.payservice.impl.PayRespManager;
import com.yy.mobile.framework.revenuesdk.payservice.impl.PayResultPoller;
import com.yy.mobile.framework.revenuesdk.payservice.reporter.DefaultPayReporter;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.IRevenueService;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueService;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.response.IResponse;
import com.yy.mobile.framework.revenuesdk.payservice.utils.JsonDataParerUtil;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayEventType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class AppPayServiceImpl implements IAppPayService, IPayInnerLogic, IRevenueDataReceiver, IRevenueService.IRevenueServiceListener {
    public static final String TAG = "AppPayServiceImpl";
    public int appId;
    public IPayReporter iPayReporter;
    public String mClientVer;
    public String mDefalutFunctionName;
    public String mDefalutServiceName;
    public boolean mIsOpenRisk;
    public PayRespManager mPayRespManager;
    public ProtocolType mProtocolType;
    public ISDKReporter mSDKRepoter;
    public PayResultPoller payResultPoller;
    public RevenueService revenueService;
    public int usedChannel;
    public String mPageId = "";
    public List<IAppPayServiceListener> listeners = new ArrayList();

    public AppPayServiceImpl(int i2, int i3, String str, String str2, String str3, String str4, boolean z, boolean z2, IRevenueDataSender iRevenueDataSender, IReporter iReporter, ISDKReporter iSDKReporter, ProtocolType protocolType) {
        this.mClientVer = "";
        this.mDefalutServiceName = "";
        this.mDefalutFunctionName = "";
        this.appId = i2;
        this.usedChannel = i3;
        this.mIsOpenRisk = z2;
        this.mDefalutServiceName = str3;
        this.mDefalutFunctionName = str4;
        this.mClientVer = str2;
        this.mSDKRepoter = iSDKReporter;
        this.mProtocolType = protocolType;
        this.revenueService = new RevenueService(i2, i3, iRevenueDataSender, this, z, protocolType);
        DefaultPayReporter defaultPayReporter = new DefaultPayReporter(iReporter, str2, str);
        this.iPayReporter = defaultPayReporter;
        this.mPayRespManager = new PayRespManager(defaultPayReporter, this, this.mDefalutServiceName, this.mDefalutFunctionName);
        this.payResultPoller = new PayResultPoller(this, this);
        RLog.info("AppPayServiceImpl", "construct versionName:4.2.20-bdpay appId:" + i2 + " usedChannel:" + i3);
    }

    private boolean checkNotNull(RequestParams requestParams, IResult iResult) {
        return (requestParams == null || iResult == null) ? false : true;
    }

    private void doOrderRequest(@NonNull Activity activity, @NonNull ChargeCurrencyReqParams chargeCurrencyReqParams, @NonNull ProductInfo productInfo, @NonNull PayType payType, int i2, int i3, int i4, IPayCallback iPayCallback) {
        String onUpdateToken;
        RLog.info("AppPayServiceImpl", "---doOrderRequest---");
        if (checkNotNull(chargeCurrencyReqParams, iPayCallback)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!isSupported(activity, payType)) {
                iPayCallback.onFail(IPayMethod.Status.NOT_SUPPORT.getCode(), IPayMethod.Status.NOT_SUPPORT.getMessage(), new PayCallBackBean(null, productInfo.productId, null, currentTimeMillis, null, null, null, null, PurchaseStatus.ORDER_FAIL, chargeCurrencyReqParams.getAppClientExpand()));
                return;
            }
            chargeCurrencyReqParams.setContext(activity);
            chargeCurrencyReqParams.setCallback(iPayCallback);
            chargeCurrencyReqParams.setPayChannel(payType.getChannel());
            chargeCurrencyReqParams.setPayMethod(payType.getMethod());
            chargeCurrencyReqParams.setSrcAmount(productInfo.srcAmount.doubleValue());
            chargeCurrencyReqParams.setProductId(productInfo.productId);
            chargeCurrencyReqParams.setCid(productInfo.cid);
            ChargeCurrencyReqParams clone = ChargeCurrencyReqParams.Companion.clone(chargeCurrencyReqParams);
            clone.setPayChannel(payType.getChannel());
            clone.setPayMethod(payType.getMethod());
            clone.setSrcAmount(productInfo.srcAmount.doubleValue());
            clone.setProductId(productInfo.productId);
            clone.setCid(productInfo.cid);
            clone.setRetryCount(i2);
            clone.setIntervalMs(i3);
            clone.setTimeOutMs(i4);
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
            IToken tokenCallback = chargeCurrencyReqParams.getTokenCallback();
            if (tokenCallback != null && (onUpdateToken = tokenCallback.onUpdateToken()) != null) {
                clone.setToken(onUpdateToken);
                RLog.info("AppPayServiceImpl", "doOrderRequest---newToken:" + onUpdateToken);
            }
            clone.setCid(chargeCurrencyReqParams.getCid());
            clone.setCurrencyType(chargeCurrencyReqParams.getCurrencyType());
            clone.setCurrencyType(chargeCurrencyReqParams.getCurrencyType());
            RLog.info("AppPayServiceImpl", "doOrderRequest---reqParams:" + clone.getPayType() + " " + clone.getSubscriptionType() + " " + clone.getCid() + "requestTime:" + currentTimeMillis + "--uid:" + clone.getUid() + "--productId:" + clone.getProductId());
            iPayCallback.onPayStatus(PurchaseStatus.ORDER_START, new PayCallBackBean(null, clone.getProductId(), null, clone.getRequestTime(), null, null, null, null, PurchaseStatus.ORDER_START, clone.getAppClientExpand()));
            IRequest obtainRequest = this.revenueService.obtainRequest(1022, chargeCurrencyReqParams);
            obtainRequest.setExtParam(clone);
            this.revenueService.sendRequest(obtainRequest);
            HiidoReport.CReportResponse cReportResponse = new HiidoReport.CReportResponse();
            cReportResponse.mPaysource = chargeCurrencyReqParams.getFrom();
            cReportResponse.mUid = chargeCurrencyReqParams.getUid();
            cReportResponse.mPayTraceId = chargeCurrencyReqParams.getTraceid();
            cReportResponse.mPageId = this.mPageId;
            cReportResponse.mServiceName = this.mDefalutServiceName;
            cReportResponse.mFunctionName = this.mDefalutFunctionName;
            RLog.info("AppPayServiceImpl", "doOrderRequest---mServiceName:" + cReportResponse.mServiceName + "---mFunctionName" + cReportResponse.mFunctionName);
            IPayReporter iPayReporter = this.iPayReporter;
            if (iPayReporter != null) {
                cReportResponse.mEventId = "0";
                cReportResponse.mEventaliae = EventAlias.PayEventAlias.REQUUEST_PAY;
                cReportResponse.mErrCode = "0";
                cReportResponse.mErrMsg = "doOrderRequest";
                iPayReporter.onRequestPay(cReportResponse);
            }
            ISDKReporter iSDKReporter = this.mSDKRepoter;
            if (iSDKReporter != null) {
                iSDKReporter.reportPayFlow(PayEventType.payingstart, "0", "doOrderRequest", "", "" + clone.getRequestTime(), productInfo.productId, payType.getChannel(), clone.getTraceid());
            }
            RLog.warn("AppPayServiceImpl", "payingstart requestTime:" + clone.getRequestTime() + " paychannel:" + payType.getChannel());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestH5Pay(String str, ChargeCurrencyReqParams chargeCurrencyReqParams, PayCallBackBean payCallBackBean) {
        H5PayParams h5PayParams = new H5PayParams();
        h5PayParams.payCallback = (IPayCallback) chargeCurrencyReqParams.getCallback();
        h5PayParams.orderId = str;
        h5PayParams.reqParams = chargeCurrencyReqParams;
        h5PayParams.payBackBean = payCallBackBean;
        h5PayParams.appPayService = this;
        h5PayParams.payInnerLogic = this;
        H5PayManager.getInstance().requestH5Pay(str, h5PayParams);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addAlipaySdkProxy(IAlipaySdkServiceProxy iAlipaySdkServiceProxy) {
        PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.ALI_PAY, iAlipaySdkServiceProxy);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addDxmPaySdkProxy(IDxmSdkServiceProxy iDxmSdkServiceProxy) {
        PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.DXM_PAY, iDxmSdkServiceProxy);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public synchronized void addPayListener(IAppPayServiceListener iAppPayServiceListener) {
        if (iAppPayServiceListener != null) {
            this.listeners.add(iAppPayServiceListener);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addWechatSdkProxy(IWechatSdkServiceProxy iWechatSdkServiceProxy) {
        PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.WECHAT_PAY, iWechatSdkServiceProxy);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.IPayInnerLogic
    public void dealOnOrderInter(IResponse iResponse, final ChargeCurrencyReqParams chargeCurrencyReqParams, final PayOrderResult payOrderResult, IRequest iRequest, HiidoReport.CReportResponse cReportResponse, long j) {
        IPayCallback iPayCallback;
        String str;
        if (iResponse.isSuccess() && chargeCurrencyReqParams != null && payOrderResult != null) {
            RLog.warn("AppPayServiceImpl", "payorder --- order sucess! orderid=" + payOrderResult.getOrderId());
            ISDKReporter iSDKReporter = this.mSDKRepoter;
            if (iSDKReporter != null) {
                iSDKReporter.reportPayFlow(PayEventType.payorder, iResponse.getResponseCode() + "", "order success!" + iResponse.getMessage(), payOrderResult.getOrderId(), "" + chargeCurrencyReqParams.getRequestTime(), chargeCurrencyReqParams.getProductId(), chargeCurrencyReqParams.getPayType().getChannel(), chargeCurrencyReqParams.getTraceid());
            }
            String payUrl = payOrderResult.getPayUrl();
            final PayCallBackBean payCallBackBean = new PayCallBackBean(payOrderResult.getOrderId(), chargeCurrencyReqParams.getProductId(), null, chargeCurrencyReqParams.getRequestTime(), JsonDataParerUtil.getChOrderidByPayload(payUrl), payUrl, null, null, PurchaseStatus.ORDER_SUCCESS, chargeCurrencyReqParams.getAppClientExpand());
            if (chargeCurrencyReqParams.getPayType() != PayType.PAYTM_PAY && chargeCurrencyReqParams.getPayType() != PayType.DXM_PAY_KJ && chargeCurrencyReqParams.getPayType() != PayType.MOCK_TEST_PAY) {
                String closeRiskEnhance = payOrderResult.getCloseRiskEnhance();
                boolean z = closeRiskEnhance == null || !closeRiskEnhance.equals("true");
                IPayCallback iPayCallback2 = (IPayCallback) chargeCurrencyReqParams.getCallback();
                if (iPayCallback2 != null) {
                    iPayCallback2.onPayStatus(PurchaseStatus.ORDER_SUCCESS, payCallBackBean);
                }
                str = "order success!";
                requestPay(payOrderResult.getOrderId(), chargeCurrencyReqParams.getContext(), chargeCurrencyReqParams, chargeCurrencyReqParams.getPayType(), chargeCurrencyReqParams.getProductId(), payUrl, z, new PayCallbackProxy(chargeCurrencyReqParams.getPayType(), payOrderResult.getOrderId(), chargeCurrencyReqParams, payUrl, payOrderResult.getPollingModeInfo(), this.mPageId, this.mSDKRepoter, this, this, iPayCallback2));
            } else {
                str = "order success!";
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    IPayCallback iPayCallback3 = (IPayCallback) chargeCurrencyReqParams.getCallback();
                    if (iPayCallback3 != null) {
                        iPayCallback3.onPayStatus(PurchaseStatus.ORDER_SUCCESS, payCallBackBean);
                    }
                    ((IPayCallback) chargeCurrencyReqParams.getCallback()).onSuccess(payOrderResult.getPayUrl(), payCallBackBean);
                    requestH5Pay(payOrderResult.getOrderId(), chargeCurrencyReqParams, payCallBackBean);
                } else {
                    ThreadPool.getDefault().mainThreadIO().execute(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.payservice.AppPayServiceImpl.2
                        @Override // java.lang.Runnable
                        public void run() {
                            IPayCallback iPayCallback4 = (IPayCallback) chargeCurrencyReqParams.getCallback();
                            if (iPayCallback4 != null) {
                                iPayCallback4.onPayStatus(PurchaseStatus.ORDER_SUCCESS, payCallBackBean);
                            }
                            ((IPayCallback) chargeCurrencyReqParams.getCallback()).onSuccess(payOrderResult.getPayUrl(), payCallBackBean);
                            AppPayServiceImpl.this.requestH5Pay(payOrderResult.getOrderId(), chargeCurrencyReqParams, payCallBackBean);
                        }
                    });
                }
            }
            if (this.iPayReporter != null) {
                cReportResponse.mEventId = "1";
                cReportResponse.mEventaliae = EventAlias.PayEventAlias.ORDER_SUCCESS;
                cReportResponse.mErrCode = iResponse.getResponseCode() + "";
                cReportResponse.mErrMsg = str + iResponse.getMessage();
                this.iPayReporter.onOrderResult(cReportResponse);
                return;
            }
            return;
        }
        if (chargeCurrencyReqParams != null && payOrderResult != null) {
            RLog.error("AppPayServiceImpl", "payorder -- order fail! orderid=" + payOrderResult.getOrderId() + " code=" + iResponse.getResponseCode() + " errMsg=" + iResponse.getMessage(), new Object[0]);
        } else {
            RLog.error("AppPayServiceImpl", "payorder -- order fail ! code=" + iResponse.getResponseCode() + "errMsg=" + iResponse.getMessage(), new Object[0]);
        }
        PayCallBackBean payCallBackBean2 = new PayCallBackBean(null, chargeCurrencyReqParams.getProductId(), null, chargeCurrencyReqParams.getRequestTime(), null, null, null, null, PurchaseStatus.ORDER_FAIL, chargeCurrencyReqParams.getAppClientExpand());
        if (chargeCurrencyReqParams != null && (iPayCallback = (IPayCallback) chargeCurrencyReqParams.getCallback()) != null) {
            iPayCallback.onPayStatus(PurchaseStatus.ORDER_FAIL, payCallBackBean2);
        }
        this.mPayRespManager.onFail(iRequest.getReqSeq(), iResponse.getResponseCode(), "order fial, fialReason:" + iResponse.getMessage(), chargeCurrencyReqParams.getCallback(), payCallBackBean2);
        if (this.iPayReporter != null) {
            cReportResponse.mEventId = "2";
            cReportResponse.mEventaliae = EventAlias.PayEventAlias.ORDER_FAIL;
            cReportResponse.mErrCode = iResponse.getResponseCode() + "";
            cReportResponse.mErrMsg = "order fial, fialReason:" + iResponse.getMessage();
            this.iPayReporter.onOrderResult(cReportResponse);
            cReportResponse.mEventId = "101";
            cReportResponse.mEventaliae = EventAlias.PaySummaryEventAlias.SUMMARY_PURCHASE_FAIL;
            this.iPayReporter.onPurchaseSummaryResult(cReportResponse);
        }
        if (this.mSDKRepoter != null) {
            String orderId = payOrderResult != null ? payOrderResult.getOrderId() : "";
            this.mSDKRepoter.reportPayFlow(PayEventType.payorder, iResponse.getResponseCode() + "", "order fial, fialReason:" + iResponse.getMessage(), orderId, "" + chargeCurrencyReqParams.getRequestTime(), chargeCurrencyReqParams.getProductId(), chargeCurrencyReqParams.getPayType().getChannel(), chargeCurrencyReqParams.getTraceid());
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void exchangeCurrency(@NonNull ExchangeCurrencyReqParams exchangeCurrencyReqParams, IResult<ExchangeResult> iResult) {
        if (checkNotNull(exchangeCurrencyReqParams, iResult)) {
            exchangeCurrencyReqParams.setCallback(iResult);
            IRequest obtainRequest = this.revenueService.obtainRequest(1025, exchangeCurrencyReqParams);
            obtainRequest.setExtParam(exchangeCurrencyReqParams);
            this.revenueService.sendRequest(obtainRequest);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public boolean isPayingStatus(PayType payType) {
        IPayMethod valueOf = PayMethodFactory.valueOf(payType);
        if (valueOf != null) {
            return valueOf.isPayingStatus();
        }
        return false;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public boolean isSupported(Activity activity, PayType payType) {
        IPayMethod valueOf = PayMethodFactory.valueOf(payType);
        if (valueOf != null) {
            return valueOf.isSupported(activity);
        }
        return false;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.IPayInnerLogic
    public void onAccountDelayMessage(AccountDelayMessage accountDelayMessage) {
        for (IAppPayServiceListener iAppPayServiceListener : this.listeners) {
            iAppPayServiceListener.onAccountDelayMessage(accountDelayMessage);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onBroadcastData(int i2, PSCIMessageBroadcast pSCIMessageBroadcast) {
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.IPayInnerLogic
    public void onConsumeConfirmMessage(ConsumeConfirmMessage consumeConfirmMessage) {
        for (IAppPayServiceListener iAppPayServiceListener : this.listeners) {
            iAppPayServiceListener.onConsumeConfirmMessage(consumeConfirmMessage);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.IPayInnerLogic
    public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
        for (IAppPayServiceListener iAppPayServiceListener : this.listeners) {
            iAppPayServiceListener.onCurrencyChargeMessage(currencyChargeMessage);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onRequestError(int i2, String str, int i3, int i4, String str2) {
        this.revenueService.onRequestError(i2, str, i3, i4, str2);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onResponseData(int i2, PSCIMessageResponse pSCIMessageResponse) {
        this.revenueService.onResponseData(i2, pSCIMessageResponse);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.IRevenueService.IRevenueServiceListener
    public void onRevenueResponse(int i2, IResponse iResponse) {
        RLog.debug("AppPayServiceImpl", "onRevenueResponse command = %d", Integer.valueOf(i2));
        this.mPayRespManager.onRevenueResponse(i2, iResponse);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onUnicastData(int i2, PSCIMessageUnicast pSCIMessageUnicast) {
        this.revenueService.onUnicastData(i2, pSCIMessageUnicast);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void onWxPayResult(int i2, String str) {
        IPayMethod valueOf = PayMethodFactory.valueOf(PayType.WECHAT_PAY);
        if (valueOf != null) {
            valueOf.onWxPayResult(i2, str);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void payWithProductInfo(@NonNull Activity activity, @NonNull ChargeCurrencyReqParams chargeCurrencyReqParams, @NonNull ProductInfo productInfo, @NonNull PayType payType, IPayCallback<String> iPayCallback) {
        payWithProductInfo(activity, chargeCurrencyReqParams, productInfo, payType, 0, 0, 0, iPayCallback);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.IPayInnerLogic
    public void pollingForChargeResult(ChargeCurrencyReqParams chargeCurrencyReqParams, final String str, PollingModeInfo pollingModeInfo) {
        chargeCurrencyReqParams.setProtocolType(this.mProtocolType);
        this.payResultPoller.pollingForChargeResult(chargeCurrencyReqParams, this.appId, str, pollingModeInfo, new PayResultPoller.PollerListener() { // from class: com.yy.mobile.framework.revenuesdk.payservice.AppPayServiceImpl.1
            @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.PayResultPoller.PollerListener
            public void onFail(ChargeCurrencyReqParams chargeCurrencyReqParams2, int i2, String str2) {
                if (AppPayServiceImpl.this.mSDKRepoter != null) {
                    AppPayServiceImpl.this.mSDKRepoter.reportPayFlow(PayEventType.paychargeorderStatus, i2 + "", "poller fail! failReason:" + str2, str, "" + chargeCurrencyReqParams2.getRequestTime(), chargeCurrencyReqParams2.getProductId(), chargeCurrencyReqParams2.getPayType().getChannel(), chargeCurrencyReqParams2.getTraceid());
                }
                RLog.warn("AppPayServiceImpl", "paychargeorderStatus onFail orderId:" + str + " code:" + i2 + " failReason:" + str2);
            }

            @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.PayResultPoller.PollerListener
            public void onSuccess(ChargeCurrencyReqParams chargeCurrencyReqParams2, GetChargeOrderStatusResult getChargeOrderStatusResult) {
                if (AppPayServiceImpl.this.mSDKRepoter != null) {
                    AppPayServiceImpl.this.mSDKRepoter.reportPayFlow(PayEventType.paychargeorderStatus, getChargeOrderStatusResult.getStatus() + "", "poller success!", str, "" + chargeCurrencyReqParams2.getRequestTime(), chargeCurrencyReqParams2.getProductId(), chargeCurrencyReqParams2.getPayType().getChannel(), chargeCurrencyReqParams2.getTraceid());
                }
                RLog.warn("AppPayServiceImpl", "paychargeorderStatus success orderId:" + str);
            }
        });
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryBannerConfigRequest(@NonNull GetBannerConfigReqParams getBannerConfigReqParams, IResult<BannerConfigResult> iResult) {
        if (checkNotNull(getBannerConfigReqParams, iResult)) {
            getBannerConfigReqParams.setCallback(iResult);
            getBannerConfigReqParams.setRequestTime(System.currentTimeMillis());
            getBannerConfigReqParams.setTraceid(TraceIdUtil.newTraceId());
            IRequest obtainRequest = this.revenueService.obtainRequest(RevenueServerConst.GetBannerConfigRequest, getBannerConfigReqParams);
            obtainRequest.setExtParam(getBannerConfigReqParams);
            this.revenueService.sendRequest(obtainRequest);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryChargeOrderStatus(@NonNull GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, IResult<GetChargeOrderStatusResult> iResult) {
        if (checkNotNull(getChargeOrderStatusReqParams, iResult)) {
            getChargeOrderStatusReqParams.setCallback(iResult);
            getChargeOrderStatusReqParams.setRequestTime(System.currentTimeMillis());
            getChargeOrderStatusReqParams.setTraceid(TraceIdUtil.newTraceId());
            IRequest obtainRequest = this.revenueService.obtainRequest(RevenueServerConst.GetChargeOrderStatusRequest, getChargeOrderStatusReqParams);
            obtainRequest.setExtParam(getChargeOrderStatusReqParams);
            this.revenueService.sendRequest(obtainRequest);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryMyBalance(@NonNull QueryCurrencyReqParams queryCurrencyReqParams, IResult<MyBalanceResult> iResult) {
        if (checkNotNull(queryCurrencyReqParams, iResult)) {
            queryCurrencyReqParams.setCallback(iResult);
            IRequest obtainRequest = this.revenueService.obtainRequest(1005, queryCurrencyReqParams);
            obtainRequest.setExtParam(queryCurrencyReqParams);
            this.revenueService.sendRequest(obtainRequest);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryProductList(@NonNull QueryCurrencyReqParams queryCurrencyReqParams, IResult<ProductListResult> iResult) {
        if (checkNotNull(queryCurrencyReqParams, iResult)) {
            queryCurrencyReqParams.setCallback(iResult);
            queryCurrencyReqParams.setRequestTime(System.currentTimeMillis());
            queryCurrencyReqParams.setTraceid(TraceIdUtil.newTraceId());
            IRequest obtainRequest = this.revenueService.obtainRequest(1021, queryCurrencyReqParams);
            obtainRequest.setExtParam(queryCurrencyReqParams);
            this.revenueService.sendRequest(obtainRequest);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryProductListChannels(@NonNull QueryCurrencyChannelsReqParams queryCurrencyChannelsReqParams, IResult<ProductListResult> iResult) {
        if (checkNotNull(queryCurrencyChannelsReqParams, iResult)) {
            queryCurrencyChannelsReqParams.setCallback(iResult);
            queryCurrencyChannelsReqParams.setRequestTime(System.currentTimeMillis());
            queryCurrencyChannelsReqParams.setTraceid(TraceIdUtil.newTraceId());
            IRequest obtainRequest = this.revenueService.obtainRequest(RevenueServerConst.GetChargeCurrencyConfigByChannelsRequest, queryCurrencyChannelsReqParams);
            obtainRequest.setExtParam(queryCurrencyChannelsReqParams);
            this.revenueService.sendRequest(obtainRequest);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryRechargeHistory(@NonNull QueryRechargeHistoryReqParams queryRechargeHistoryReqParams, IResult<RechargeHistoryResult> iResult) {
        if (checkNotNull(queryRechargeHistoryReqParams, iResult)) {
            queryRechargeHistoryReqParams.setCallback(iResult);
            IRequest obtainRequest = this.revenueService.obtainRequest(RevenueServerConst.ChargeCurrencyHistoryRequest, queryRechargeHistoryReqParams);
            obtainRequest.setExtParam(queryRechargeHistoryReqParams);
            this.revenueService.sendRequest(obtainRequest);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryUserYbDetailsRequest(@NonNull GetUserYbDetailsReqParams getUserYbDetailsReqParams, IResult<GetUserYbDetailsResult> iResult) {
        if (checkNotNull(getUserYbDetailsReqParams, iResult)) {
            getUserYbDetailsReqParams.setCallback(iResult);
            getUserYbDetailsReqParams.setRequestTime(System.currentTimeMillis());
            getUserYbDetailsReqParams.setTraceid(TraceIdUtil.newTraceId());
            IRequest obtainRequest = this.revenueService.obtainRequest(RevenueServerConst.GetUserYbDetailsRequest, getUserYbDetailsReqParams);
            obtainRequest.setExtParam(getUserYbDetailsReqParams);
            this.revenueService.sendRequest(obtainRequest);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void registerPayReporter(IPayReporter iPayReporter) {
        this.iPayReporter = iPayReporter;
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
    public void reportPayEntrancePage(int i2) {
        this.mPageId = PageIdUtil.newPageId();
        HiidoReport.CReportResponse cReportResponse = new HiidoReport.CReportResponse();
        cReportResponse.mEventId = EventType.PayEventID.ENTRANCE_PAGE;
        cReportResponse.mEventaliae = EventAlias.PayEventAlias.ENTRANCE_PAGE;
        cReportResponse.mPageId = this.mPageId;
        cReportResponse.mPaysource = i2;
        cReportResponse.mErrCode = "0";
        cReportResponse.mErrMsg = "pay-entrance-page（支付入口页面）";
        IPayReporter iPayReporter = this.iPayReporter;
        if (iPayReporter != null) {
            iPayReporter.onPayEntrancePage(cReportResponse);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void requestPay(Activity activity, PayType payType, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        RLog.info("AppPayServiceImpl", "requstPay,payType:" + payType + ",productId:" + str + ",payload:" + str2);
        PayMethodFactory.valueOf(payType).requestPay(activity, 0L, str, str2, z, iPayCallback);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.IPayInnerLogic
    public void showVerifyViewWithInfoString(String str, ChargeCurrencyReqParams chargeCurrencyReqParams, IResponse iResponse, IRequest iRequest) {
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void payWithProductInfo(@NonNull Activity activity, @NonNull ChargeCurrencyReqParams chargeCurrencyReqParams, @NonNull ProductInfo productInfo, @NonNull PayType payType, int i2, int i3, int i4, IPayCallback<String> iPayCallback) {
        RLog.info("AppPayServiceImpl", "---payWithProductInfo---");
        doOrderRequest(activity, chargeCurrencyReqParams, productInfo, payType, i2, i3, i4, iPayCallback);
    }

    private void requestPay(String str, Activity activity, ChargeCurrencyReqParams chargeCurrencyReqParams, PayType payType, String str2, String str3, boolean z, IPayCallback iPayCallback) {
        PayMethodFactory.valueOf(payType).requestPay(activity, chargeCurrencyReqParams.getUid(), str2, str3, z, iPayCallback);
        RLog.warn("AppPayServiceImpl", "payingaddpaymentrequest request sdk Pay orderId:" + str);
        ISDKReporter iSDKReporter = this.mSDKRepoter;
        if (iSDKReporter != null) {
            iSDKReporter.reportPayFlow(PayEventType.payingaddpaymentrequest, "0", "request sdk pay", str, "" + chargeCurrencyReqParams.getRequestTime(), chargeCurrencyReqParams.getProductId(), chargeCurrencyReqParams.getPayType().getChannel(), chargeCurrencyReqParams.getTraceid());
        }
    }
}
