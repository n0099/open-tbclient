package com.yy.mobile.framework.revenuesdk.payservice;

import android.app.Activity;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IEventReporter;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IMonitorReporter;
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
import com.yy.mobile.framework.revenuesdk.payservice.impl.IPayServiceCallback;
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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class AppPayServiceImpl implements IAppPayService, IPayServiceCallback, IRevenueDataReceiver, IRevenueService.IRevenueServiceListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AppPayServiceImpl";
    public transient /* synthetic */ FieldHolder $fh;
    public List<IAppPayServiceListener> listeners;
    public int mAppId;
    public String mClientVer;
    public String mDefalutFunctionName;
    public String mDefalutServiceName;
    public IEventReporter mEventRepoter;
    public String mPageId;
    public IPayReporter mPayReporter;
    public PayRespManager mPayRespManager;
    public PayResultPoller mPayResultPoller;
    public ProtocolType mProtocolType;
    public RevenueService mRevenueService;
    public int mUsedChannel;

    public AppPayServiceImpl(int i2, int i3, String str, String str2, String str3, String str4, boolean z, boolean z2, IRevenueDataSender iRevenueDataSender, IMonitorReporter iMonitorReporter, IEventReporter iEventReporter, ProtocolType protocolType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), str, str2, str3, str4, Boolean.valueOf(z), Boolean.valueOf(z2), iRevenueDataSender, iMonitorReporter, iEventReporter, protocolType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPageId = "";
        this.mClientVer = "";
        this.mDefalutServiceName = "";
        this.mDefalutFunctionName = "";
        this.listeners = new ArrayList();
        this.mAppId = i2;
        this.mUsedChannel = i3;
        this.mDefalutServiceName = str3;
        this.mDefalutFunctionName = str4;
        this.mClientVer = str2;
        this.mEventRepoter = iEventReporter;
        this.mProtocolType = protocolType;
        this.mRevenueService = new RevenueService(i2, i3, iRevenueDataSender, this, z, protocolType);
        DefaultPayReporter defaultPayReporter = new DefaultPayReporter(iMonitorReporter, this.mAppId, this.mUsedChannel);
        this.mPayReporter = defaultPayReporter;
        this.mPayRespManager = new PayRespManager(defaultPayReporter, this, this.mDefalutServiceName, this.mDefalutFunctionName);
        this.mPayResultPoller = new PayResultPoller(this, this);
        RLog.info("AppPayServiceImpl", "create AppPayServiceImpl versionName:4.3.9-bdpay212004-SNAPSHOT appId:" + i2 + " usedChannel:" + i3);
    }

    private boolean checkNotNull(RequestParams requestParams, IResult iResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, requestParams, iResult)) == null) ? (requestParams == null || iResult == null) ? false : true : invokeLL.booleanValue;
    }

    private void doOrderRequest(@NonNull Activity activity, @NonNull ChargeCurrencyReqParams chargeCurrencyReqParams, @NonNull ProductInfo productInfo, @NonNull PayType payType, int i2, int i3, int i4, IPayCallback iPayCallback) {
        String onUpdateToken;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{activity, chargeCurrencyReqParams, productInfo, payType, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iPayCallback}) == null) {
            RLog.info("AppPayServiceImpl", "---doOrderRequest---");
            if (checkNotNull(chargeCurrencyReqParams, iPayCallback)) {
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
                cReportResponse.mPageId = this.mPageId;
                cReportResponse.mServiceName = this.mDefalutServiceName;
                cReportResponse.mFunctionName = this.mDefalutFunctionName;
                IPayReporter iPayReporter = this.mPayReporter;
                if (iPayReporter != null) {
                    cReportResponse.mEventId = "0";
                    cReportResponse.mEventaliae = EventAlias.PayEventAlias.REQUUEST_PAY;
                    cReportResponse.mErrCode = "0";
                    cReportResponse.mErrMsg = "doOrderRequest";
                    iPayReporter.onRequestPay(cReportResponse);
                }
                IEventReporter iEventReporter = this.mEventRepoter;
                if (iEventReporter != null) {
                    iEventReporter.reportPayFlow(PayEventType.payingstart, "0", "doOrderRequest", "", "" + clone.getRequestTime(), productInfo.productId, payType.getChannel(), clone.getTraceid());
                }
                RLog.info("AppPayServiceImpl", "payingstart requestTime:" + clone.getRequestTime() + " paychannel:" + payType.getChannel());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestH5Pay(String str, ChargeCurrencyReqParams chargeCurrencyReqParams, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, this, str, chargeCurrencyReqParams, payCallBackBean) == null) {
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
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addAlipaySdkProxy(IAlipaySdkServiceProxy iAlipaySdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iAlipaySdkServiceProxy) == null) {
            PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.ALI_PAY, iAlipaySdkServiceProxy);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addDxmPaySdkProxy(IDxmSdkServiceProxy iDxmSdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iDxmSdkServiceProxy) == null) {
            PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.DXM_PAY, iDxmSdkServiceProxy);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public synchronized void addPayListener(IAppPayServiceListener iAppPayServiceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iAppPayServiceListener) == null) {
            synchronized (this) {
                if (iAppPayServiceListener != null) {
                    this.listeners.add(iAppPayServiceListener);
                }
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addWechatSdkProxy(IWechatSdkServiceProxy iWechatSdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iWechatSdkServiceProxy) == null) {
            PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.WECHAT_PAY, iWechatSdkServiceProxy);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void cancelAllRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            RLog.info("AppPayServiceImpl", "cancelAllRequest");
            this.mRevenueService.cancelAllRequest();
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.IPayServiceCallback
    public void dealOnOrderInter(IResponse iResponse, ChargeCurrencyReqParams chargeCurrencyReqParams, PayOrderResult payOrderResult, IRequest iRequest, HiidoReport.CReportResponse cReportResponse, long j2) {
        IPayCallback iPayCallback;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{iResponse, chargeCurrencyReqParams, payOrderResult, iRequest, cReportResponse, Long.valueOf(j2)}) == null) {
            if (iResponse.isSuccess() && chargeCurrencyReqParams != null && payOrderResult != null) {
                RLog.info("AppPayServiceImpl", "payorder success! orderid=" + payOrderResult.getOrderId());
                IEventReporter iEventReporter = this.mEventRepoter;
                if (iEventReporter != null) {
                    iEventReporter.reportPayFlow(PayEventType.payorder, iResponse.getResponseCode() + "", "order success!" + iResponse.getMessage(), payOrderResult.getOrderId(), "" + chargeCurrencyReqParams.getRequestTime(), chargeCurrencyReqParams.getProductId(), chargeCurrencyReqParams.getPayType().getChannel(), chargeCurrencyReqParams.getTraceid());
                }
                String payUrl = payOrderResult.getPayUrl();
                PayCallBackBean payCallBackBean = new PayCallBackBean(payOrderResult.getOrderId(), chargeCurrencyReqParams.getProductId(), null, chargeCurrencyReqParams.getRequestTime(), JsonDataParerUtil.getChOrderidByPayload(payUrl), payUrl, null, null, PurchaseStatus.ORDER_SUCCESS, chargeCurrencyReqParams.getAppClientExpand());
                if (chargeCurrencyReqParams.getPayType() != PayType.PAYTM_PAY && chargeCurrencyReqParams.getPayType() != PayType.DXM_PAY_KJ && chargeCurrencyReqParams.getPayType() != PayType.MOCK_TEST_PAY && chargeCurrencyReqParams.getPayType() != PayType.UNION_PAY) {
                    String closeRiskEnhance = payOrderResult.getCloseRiskEnhance();
                    boolean z = closeRiskEnhance == null || !closeRiskEnhance.equals("true");
                    IPayCallback iPayCallback2 = (IPayCallback) chargeCurrencyReqParams.getCallback();
                    if (iPayCallback2 != null) {
                        iPayCallback2.onPayStatus(PurchaseStatus.ORDER_SUCCESS, payCallBackBean);
                    }
                    str = "order success!";
                    requestPay(payOrderResult.getOrderId(), chargeCurrencyReqParams.getContext(), chargeCurrencyReqParams, chargeCurrencyReqParams.getPayType(), chargeCurrencyReqParams.getProductId(), payUrl, z, new PayCallbackProxy(chargeCurrencyReqParams.getPayType(), payOrderResult.getOrderId(), chargeCurrencyReqParams, payUrl, payOrderResult.getPollingModeInfo(), this.mPageId, this.mEventRepoter, this, this, iPayCallback2));
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
                        ThreadPool.getDefault().mainThreadIO().execute(new Runnable(this, chargeCurrencyReqParams, payCallBackBean, payOrderResult) { // from class: com.yy.mobile.framework.revenuesdk.payservice.AppPayServiceImpl.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AppPayServiceImpl this$0;
                            public final /* synthetic */ PayCallBackBean val$backBean;
                            public final /* synthetic */ ChargeCurrencyReqParams val$req;
                            public final /* synthetic */ PayOrderResult val$result;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, chargeCurrencyReqParams, payCallBackBean, payOrderResult};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$req = chargeCurrencyReqParams;
                                this.val$backBean = payCallBackBean;
                                this.val$result = payOrderResult;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    IPayCallback iPayCallback4 = (IPayCallback) this.val$req.getCallback();
                                    if (iPayCallback4 != null) {
                                        iPayCallback4.onPayStatus(PurchaseStatus.ORDER_SUCCESS, this.val$backBean);
                                    }
                                    ((IPayCallback) this.val$req.getCallback()).onSuccess(this.val$result.getPayUrl(), this.val$backBean);
                                    this.this$0.requestH5Pay(this.val$result.getOrderId(), this.val$req, this.val$backBean);
                                }
                            }
                        });
                    }
                }
                if (this.mPayReporter != null) {
                    cReportResponse.mEventId = "1";
                    cReportResponse.mEventaliae = EventAlias.PayEventAlias.ORDER_SUCCESS;
                    cReportResponse.mErrCode = iResponse.getResponseCode() + "";
                    cReportResponse.mErrMsg = str + iResponse.getMessage();
                    this.mPayReporter.onOrderResult(cReportResponse);
                    return;
                }
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
            this.mPayRespManager.onFail(iRequest.getReqSeq(), iResponse.getResponseCode(), iResponse.getMessage(), chargeCurrencyReqParams.getCallback(), payCallBackBean2);
            if (this.mPayReporter != null) {
                cReportResponse.mEventId = "2";
                cReportResponse.mEventaliae = EventAlias.PayEventAlias.ORDER_FAIL;
                cReportResponse.mErrCode = iResponse.getResponseCode() + "";
                cReportResponse.mErrMsg = "order fail, reason:" + iResponse.getMessage();
                this.mPayReporter.onOrderResult(cReportResponse);
            }
            if (this.mEventRepoter != null) {
                String orderId = payOrderResult != null ? payOrderResult.getOrderId() : "";
                this.mEventRepoter.reportPayFlow(PayEventType.payorder, iResponse.getResponseCode() + "", "order fail, reason:" + iResponse.getMessage(), orderId, "" + chargeCurrencyReqParams.getRequestTime(), chargeCurrencyReqParams.getProductId(), chargeCurrencyReqParams.getPayType().getChannel(), chargeCurrencyReqParams.getTraceid());
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void exchangeCurrency(@NonNull ExchangeCurrencyReqParams exchangeCurrencyReqParams, IResult<ExchangeResult> iResult) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, exchangeCurrencyReqParams, iResult) == null) && checkNotNull(exchangeCurrencyReqParams, iResult)) {
            exchangeCurrencyReqParams.setCallback(iResult);
            IRequest obtainRequest = this.mRevenueService.obtainRequest(1025, exchangeCurrencyReqParams);
            obtainRequest.setExtParam(exchangeCurrencyReqParams);
            this.mRevenueService.sendRequest(obtainRequest);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public IPayReporter getPayRepoter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPayReporter : (IPayReporter) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public boolean isPayingStatus(PayType payType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, payType)) == null) {
            IPayMethod valueOf = PayMethodFactory.valueOf(payType);
            if (valueOf != null) {
                return valueOf.isPayingStatus();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public boolean isSupported(Activity activity, PayType payType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, activity, payType)) == null) {
            IPayMethod valueOf = PayMethodFactory.valueOf(payType);
            if (valueOf != null) {
                return valueOf.isSupported(activity);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.IPayServiceCallback
    public void onAccountDelayMessage(AccountDelayMessage accountDelayMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, accountDelayMessage) == null) {
            for (IAppPayServiceListener iAppPayServiceListener : this.listeners) {
                iAppPayServiceListener.onAccountDelayMessage(accountDelayMessage);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onBroadcastData(int i2, PSCIMessageBroadcast pSCIMessageBroadcast) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, pSCIMessageBroadcast) == null) {
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.IPayServiceCallback
    public void onConsumeConfirmMessage(ConsumeConfirmMessage consumeConfirmMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, consumeConfirmMessage) == null) {
            for (IAppPayServiceListener iAppPayServiceListener : this.listeners) {
                iAppPayServiceListener.onConsumeConfirmMessage(consumeConfirmMessage);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.IPayServiceCallback
    public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, currencyChargeMessage) == null) {
            for (IAppPayServiceListener iAppPayServiceListener : this.listeners) {
                iAppPayServiceListener.onCurrencyChargeMessage(currencyChargeMessage);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void onQQPayResult(int i2, String str) {
        IPayMethod valueOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048590, this, i2, str) == null) || (valueOf = PayMethodFactory.valueOf(PayType.QQ_PAY)) == null) {
            return;
        }
        valueOf.onQQPayResult(i2, str);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onRequestError(int i2, int i3, String str, int i4, int i5, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), Integer.valueOf(i5), str2}) == null) {
            this.mRevenueService.onRequestError(i2, i3, str, i4, i5, str2);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onResponseData(int i2, int i3, PSCIMessageResponse pSCIMessageResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048592, this, i2, i3, pSCIMessageResponse) == null) {
            this.mRevenueService.onResponseData(i2, i3, pSCIMessageResponse);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.IRevenueService.IRevenueServiceListener
    public void onRevenueResponse(int i2, IResponse iResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048593, this, i2, iResponse) == null) {
            RLog.debug("AppPayServiceImpl", "onRevenueResponse command = " + i2);
            this.mPayRespManager.onRevenueResponse(i2, iResponse);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onUnicastData(int i2, PSCIMessageUnicast pSCIMessageUnicast) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i2, pSCIMessageUnicast) == null) {
            this.mRevenueService.onUnicastData(i2, pSCIMessageUnicast);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void onWxPayResult(int i2, String str) {
        IPayMethod valueOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048595, this, i2, str) == null) || (valueOf = PayMethodFactory.valueOf(PayType.WECHAT_PAY)) == null) {
            return;
        }
        valueOf.onWxPayResult(i2, str);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void payWithProductInfo(@NonNull Activity activity, @NonNull ChargeCurrencyReqParams chargeCurrencyReqParams, @NonNull ProductInfo productInfo, @NonNull PayType payType, IPayCallback<String> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048597, this, activity, chargeCurrencyReqParams, productInfo, payType, iPayCallback) == null) {
            payWithProductInfo(activity, chargeCurrencyReqParams, productInfo, payType, 0, 0, 0, iPayCallback);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.IPayServiceCallback
    public void pollingPayResult(ChargeCurrencyReqParams chargeCurrencyReqParams, String str, PollingModeInfo pollingModeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048598, this, chargeCurrencyReqParams, str, pollingModeInfo) == null) {
            chargeCurrencyReqParams.setProtocolType(this.mProtocolType);
            this.mPayResultPoller.tryGetPayResult(chargeCurrencyReqParams, this.mAppId, str, pollingModeInfo, new PayResultPoller.PollerListener(this, str) { // from class: com.yy.mobile.framework.revenuesdk.payservice.AppPayServiceImpl.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AppPayServiceImpl this$0;
                public final /* synthetic */ String val$orderId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$orderId = str;
                }

                @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.PayResultPoller.PollerListener
                public void onFail(ChargeCurrencyReqParams chargeCurrencyReqParams2, int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, chargeCurrencyReqParams2, i2, str2) == null) {
                        if (this.this$0.mEventRepoter != null) {
                            this.this$0.mEventRepoter.reportPayFlow(PayEventType.paychargeorderStatus, i2 + "", "poller fail! failReason:" + str2, this.val$orderId, "" + chargeCurrencyReqParams2.getRequestTime(), chargeCurrencyReqParams2.getProductId(), chargeCurrencyReqParams2.getPayType().getChannel(), chargeCurrencyReqParams2.getTraceid());
                        }
                        RLog.error("AppPayServiceImpl", "paychargeorderStatus onFail orderId:" + this.val$orderId + " code:" + i2 + " failReason:" + str2, new Object[0]);
                    }
                }

                @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.PayResultPoller.PollerListener
                public void onSuccess(ChargeCurrencyReqParams chargeCurrencyReqParams2, GetChargeOrderStatusResult getChargeOrderStatusResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chargeCurrencyReqParams2, getChargeOrderStatusResult) == null) {
                        if (this.this$0.mEventRepoter != null) {
                            this.this$0.mEventRepoter.reportPayFlow(PayEventType.paychargeorderStatus, getChargeOrderStatusResult.getStatus() + "", "poller success!", this.val$orderId, "" + chargeCurrencyReqParams2.getRequestTime(), chargeCurrencyReqParams2.getProductId(), chargeCurrencyReqParams2.getPayType().getChannel(), chargeCurrencyReqParams2.getTraceid());
                        }
                        RLog.info("AppPayServiceImpl", "paychargeorderStatus success orderId:" + this.val$orderId);
                    }
                }
            });
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryBannerConfigRequest(@NonNull GetBannerConfigReqParams getBannerConfigReqParams, IResult<BannerConfigResult> iResult) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048599, this, getBannerConfigReqParams, iResult) == null) && checkNotNull(getBannerConfigReqParams, iResult)) {
            getBannerConfigReqParams.setCallback(iResult);
            getBannerConfigReqParams.setRequestTime(System.currentTimeMillis());
            getBannerConfigReqParams.setTraceid(TraceIdUtil.newTraceId());
            IRequest obtainRequest = this.mRevenueService.obtainRequest(RevenueServerConst.GetBannerConfigRequest, getBannerConfigReqParams);
            obtainRequest.setExtParam(getBannerConfigReqParams);
            this.mRevenueService.sendRequest(obtainRequest);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryChargeOrderStatus(@NonNull GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, IResult<GetChargeOrderStatusResult> iResult) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048600, this, getChargeOrderStatusReqParams, iResult) == null) && checkNotNull(getChargeOrderStatusReqParams, iResult)) {
            getChargeOrderStatusReqParams.setCallback(iResult);
            getChargeOrderStatusReqParams.setRequestTime(System.currentTimeMillis());
            getChargeOrderStatusReqParams.setTraceid(TraceIdUtil.newTraceId());
            IRequest obtainRequest = this.mRevenueService.obtainRequest(RevenueServerConst.GetChargeOrderStatusRequest, getChargeOrderStatusReqParams);
            obtainRequest.setExtParam(getChargeOrderStatusReqParams);
            this.mRevenueService.sendRequest(obtainRequest);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryMyBalance(@NonNull QueryCurrencyReqParams queryCurrencyReqParams, IResult<MyBalanceResult> iResult) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048601, this, queryCurrencyReqParams, iResult) == null) && checkNotNull(queryCurrencyReqParams, iResult)) {
            queryCurrencyReqParams.setCallback(iResult);
            IRequest obtainRequest = this.mRevenueService.obtainRequest(1005, queryCurrencyReqParams);
            obtainRequest.setExtParam(queryCurrencyReqParams);
            this.mRevenueService.sendRequest(obtainRequest);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryProductList(@NonNull QueryCurrencyReqParams queryCurrencyReqParams, IResult<ProductListResult> iResult) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048602, this, queryCurrencyReqParams, iResult) == null) && checkNotNull(queryCurrencyReqParams, iResult)) {
            queryCurrencyReqParams.setCallback(iResult);
            queryCurrencyReqParams.setRequestTime(System.currentTimeMillis());
            queryCurrencyReqParams.setTraceid(TraceIdUtil.newTraceId());
            IRequest obtainRequest = this.mRevenueService.obtainRequest(1021, queryCurrencyReqParams);
            obtainRequest.setExtParam(queryCurrencyReqParams);
            this.mRevenueService.sendRequest(obtainRequest);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryProductListChannels(@NonNull QueryCurrencyChannelsReqParams queryCurrencyChannelsReqParams, IResult<ProductListResult> iResult) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048603, this, queryCurrencyChannelsReqParams, iResult) == null) && checkNotNull(queryCurrencyChannelsReqParams, iResult)) {
            queryCurrencyChannelsReqParams.setCallback(iResult);
            queryCurrencyChannelsReqParams.setRequestTime(System.currentTimeMillis());
            queryCurrencyChannelsReqParams.setTraceid(TraceIdUtil.newTraceId());
            IRequest obtainRequest = this.mRevenueService.obtainRequest(RevenueServerConst.GetChargeCurrencyConfigByChannelsRequest, queryCurrencyChannelsReqParams);
            obtainRequest.setExtParam(queryCurrencyChannelsReqParams);
            this.mRevenueService.sendRequest(obtainRequest);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryRechargeHistory(@NonNull QueryRechargeHistoryReqParams queryRechargeHistoryReqParams, IResult<RechargeHistoryResult> iResult) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048604, this, queryRechargeHistoryReqParams, iResult) == null) && checkNotNull(queryRechargeHistoryReqParams, iResult)) {
            queryRechargeHistoryReqParams.setCallback(iResult);
            IRequest obtainRequest = this.mRevenueService.obtainRequest(RevenueServerConst.ChargeCurrencyHistoryRequest, queryRechargeHistoryReqParams);
            obtainRequest.setExtParam(queryRechargeHistoryReqParams);
            this.mRevenueService.sendRequest(obtainRequest);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryUserYbDetailsRequest(@NonNull GetUserYbDetailsReqParams getUserYbDetailsReqParams, IResult<GetUserYbDetailsResult> iResult) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048605, this, getUserYbDetailsReqParams, iResult) == null) && checkNotNull(getUserYbDetailsReqParams, iResult)) {
            getUserYbDetailsReqParams.setCallback(iResult);
            getUserYbDetailsReqParams.setRequestTime(System.currentTimeMillis());
            getUserYbDetailsReqParams.setTraceid(TraceIdUtil.newTraceId());
            IRequest obtainRequest = this.mRevenueService.obtainRequest(RevenueServerConst.GetUserYbDetailsRequest, getUserYbDetailsReqParams);
            obtainRequest.setExtParam(getUserYbDetailsReqParams);
            this.mRevenueService.sendRequest(obtainRequest);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void registerPayReporter(IPayReporter iPayReporter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, iPayReporter) == null) {
            this.mPayReporter = iPayReporter;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        r0.remove();
     */
    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void removePayListener(IAppPayServiceListener iAppPayServiceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, iAppPayServiceListener) == null) {
            synchronized (this) {
                Iterator<IAppPayServiceListener> it = this.listeners.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (iAppPayServiceListener == it.next()) {
                        break;
                    }
                }
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void reportPayEntrancePage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.mPageId = PageIdUtil.newPageId();
            HiidoReport.CReportResponse cReportResponse = new HiidoReport.CReportResponse();
            cReportResponse.mEventId = EventType.PayEventID.ENTRANCE_PAGE;
            cReportResponse.mEventaliae = EventAlias.PayEventAlias.ENTRANCE_PAGE;
            cReportResponse.mPageId = this.mPageId;
            cReportResponse.mPaysource = i2;
            cReportResponse.mErrCode = "0";
            cReportResponse.mErrMsg = "pay-entrance-page（支付入口页面）";
            IPayReporter iPayReporter = this.mPayReporter;
            if (iPayReporter != null) {
                iPayReporter.onPayEntrancePage(cReportResponse);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void requestPay(Activity activity, PayType payType, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{activity, payType, str, str2, Boolean.valueOf(z), iPayCallback}) == null) {
            RLog.info("AppPayServiceImpl", "requstPay,payType:" + payType + ",productId:" + str + ",payload:" + str2);
            PayMethodFactory.valueOf(payType).requestPay(activity, 0L, str, str2, z, iPayCallback);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.IPayServiceCallback
    public void showVerifyViewWithInfoString(String str, ChargeCurrencyReqParams chargeCurrencyReqParams, IResponse iResponse, IRequest iRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048610, this, str, chargeCurrencyReqParams, iResponse, iRequest) == null) {
            RLog.info("AppPayServiceImpl", "showVerifyViewWithInfoString");
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void payWithProductInfo(@NonNull Activity activity, @NonNull ChargeCurrencyReqParams chargeCurrencyReqParams, @NonNull ProductInfo productInfo, @NonNull PayType payType, int i2, int i3, int i4, IPayCallback<String> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{activity, chargeCurrencyReqParams, productInfo, payType, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iPayCallback}) == null) {
            RLog.info("AppPayServiceImpl", "---payWithProductInfo---");
            doOrderRequest(activity, chargeCurrencyReqParams, productInfo, payType, i2, i3, i4, iPayCallback);
        }
    }

    private void requestPay(String str, Activity activity, ChargeCurrencyReqParams chargeCurrencyReqParams, PayType payType, String str2, String str3, boolean z, IPayCallback iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{str, activity, chargeCurrencyReqParams, payType, str2, str3, Boolean.valueOf(z), iPayCallback}) == null) {
            RLog.info("AppPayServiceImpl", "payingaddpaymentrequest request sdk Pay orderId:" + str);
            PayMethodFactory.valueOf(payType).requestPay(activity, chargeCurrencyReqParams.getUid(), str2, str3, z, iPayCallback);
            IEventReporter iEventReporter = this.mEventRepoter;
            if (iEventReporter != null) {
                iEventReporter.reportPayFlow(PayEventType.payingaddpaymentrequest, "0", "request sdk pay", str, "" + chargeCurrencyReqParams.getRequestTime(), chargeCurrencyReqParams.getProductId(), chargeCurrencyReqParams.getPayType().getChannel(), chargeCurrencyReqParams.getTraceid());
            }
        }
    }
}
