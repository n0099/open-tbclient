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
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PollingModeInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.PayOrderResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetChargeOrderStatusReqParams;
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
/* loaded from: classes8.dex */
public class AppPayServiceImpl implements IAppPayService, IPayServiceCallback, IRevenueDataReceiver, IRevenueService.IRevenueServiceListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AppPayServiceImpl";
    public transient /* synthetic */ FieldHolder $fh;
    public List<IAppPayServiceListener> listeners;
    public int mAppId;
    public IPayEventStatistics mPayEventStatistics;
    public PayOrderResultPoller mPayOrderResultPoller;
    public PayRespDispatcher mPayRespDispatcher;
    public IPayServiceStatistics mPayServiceStatistics;
    public ProtocolType mProtocolType;
    public RevenueService mRevenueService;
    public int mUsedChannel;

    private boolean checkNotNull(RequestParams requestParams, IResult iResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, requestParams, iResult)) == null) ? (requestParams == null || iResult == null) ? false : true : invokeLL.booleanValue;
    }

    public AppPayServiceImpl(int i, int i2, boolean z, IRevenueDataSender iRevenueDataSender, IPayMetricsStatistics iPayMetricsStatistics, IPayEventStatistics iPayEventStatistics, ProtocolType protocolType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), iRevenueDataSender, iPayMetricsStatistics, iPayEventStatistics, protocolType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.listeners = new ArrayList();
        this.mAppId = i;
        this.mUsedChannel = i2;
        this.mPayEventStatistics = iPayEventStatistics;
        this.mProtocolType = protocolType;
        this.mRevenueService = new RevenueService(i, i2, iRevenueDataSender, this, z, protocolType);
        PayServiceStatisticsImpl payServiceStatisticsImpl = new PayServiceStatisticsImpl(iPayMetricsStatistics, this.mAppId, this.mUsedChannel);
        this.mPayServiceStatistics = payServiceStatisticsImpl;
        this.mPayRespDispatcher = new PayRespDispatcher(payServiceStatisticsImpl, this);
        this.mPayOrderResultPoller = new PayOrderResultPoller(this, this, this.mPayEventStatistics);
        RLog.info("AppPayServiceImpl", "create AppPayServiceImpl versionName:4.3.30-bdpay-fix.2-SNAPSHOT appId:" + i + " usedChannel:" + i2);
    }

    private void doOrderRequest(@NonNull Activity activity, @NonNull ChargeCurrencyReqParams chargeCurrencyReqParams, @NonNull ProductInfo productInfo, @NonNull PayType payType, int i, int i2, int i3, IPayCallback iPayCallback) {
        String onUpdateToken;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{activity, chargeCurrencyReqParams, productInfo, payType, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iPayCallback}) == null) {
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
    }

    private void reportOrderProductFail(IResponse iResponse, ChargeCurrencyReqParams chargeCurrencyReqParams, PayOrderResult payOrderResult, HiidoReport.CReportResponse cReportResponse) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, iResponse, chargeCurrencyReqParams, payOrderResult, cReportResponse) == null) {
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
    }

    private void reportOrderProductSuccess(IResponse iResponse, ChargeCurrencyReqParams chargeCurrencyReqParams, PayOrderResult payOrderResult, HiidoReport.CReportResponse cReportResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, this, iResponse, chargeCurrencyReqParams, payOrderResult, cReportResponse) == null) {
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
    }

    private void reportPayRequestEvent(String str, String str2, ChargeCurrencyReqParams chargeCurrencyReqParams) {
        IPayEventStatistics iPayEventStatistics;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65542, this, str, str2, chargeCurrencyReqParams) == null) && (iPayEventStatistics = this.mPayEventStatistics) != null) {
            iPayEventStatistics.reportPayFlowEvent(PayFlowEventType.payingaddpaymentrequest, "0", str2, str, "" + chargeCurrencyReqParams.getRequestTime(), chargeCurrencyReqParams.getProductId(), chargeCurrencyReqParams.getPayType().getChannel(), chargeCurrencyReqParams.getTraceid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestH5Pay(String str, ChargeCurrencyReqParams chargeCurrencyReqParams, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, this, str, chargeCurrencyReqParams, payCallBackBean) == null) {
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
    }

    private void requestH5PayOnMainThread(ChargeCurrencyReqParams chargeCurrencyReqParams, PayOrderResult payOrderResult, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, this, chargeCurrencyReqParams, payOrderResult, payCallBackBean) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                IPayCallback iPayCallback = (IPayCallback) chargeCurrencyReqParams.getCallback();
                if (iPayCallback != null) {
                    iPayCallback.onPayStatus(PurchaseStatus.ORDER_SUCCESS, payCallBackBean);
                }
                ((IPayCallback) chargeCurrencyReqParams.getCallback()).onSuccess(payOrderResult.getPayUrl(), payCallBackBean);
                requestH5Pay(payOrderResult.getOrderId(), chargeCurrencyReqParams, payCallBackBean);
                return;
            }
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                        IPayCallback iPayCallback2 = (IPayCallback) this.val$req.getCallback();
                        if (iPayCallback2 != null) {
                            iPayCallback2.onPayStatus(PurchaseStatus.ORDER_SUCCESS, this.val$backBean);
                        }
                        ((IPayCallback) this.val$req.getCallback()).onSuccess(this.val$result.getPayUrl(), this.val$backBean);
                        this.this$0.requestH5Pay(this.val$result.getOrderId(), this.val$req, this.val$backBean);
                    }
                }
            });
        }
    }

    private void requestPay(String str, Activity activity, ChargeCurrencyReqParams chargeCurrencyReqParams, PayType payType, String str2, String str3, IPayCallback iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{str, activity, chargeCurrencyReqParams, payType, str2, str3, iPayCallback}) == null) {
            RLog.info("AppPayServiceImpl", "payingaddpaymentrequest request sdk Pay orderId:" + str);
            PayMethodFactory.valueOf(payType).requestPay(activity, chargeCurrencyReqParams.getUid(), str2, str3, iPayCallback);
            reportPayRequestEvent(str, "request sdk pay", chargeCurrencyReqParams);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public synchronized void addPayListener(IAppPayServiceListener iAppPayServiceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iAppPayServiceListener) == null) {
            synchronized (this) {
                if (iAppPayServiceListener != null) {
                    this.listeners.add(iAppPayServiceListener);
                }
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.IPayServiceCallback
    public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, currencyChargeMessage) == null) {
            for (IAppPayServiceListener iAppPayServiceListener : this.listeners) {
                iAppPayServiceListener.onCurrencyChargeMessage(currencyChargeMessage);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void registerPayServiceStatistics(IPayServiceStatistics iPayServiceStatistics) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, iPayServiceStatistics) == null) {
            RLog.debug("AppPayServiceImpl", "registerPayReporter IPayServiceReporter = " + iPayServiceStatistics);
            this.mPayServiceStatistics = iPayServiceStatistics;
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
        if (interceptable == null || interceptable.invokeL(1048593, this, iAppPayServiceListener) == null) {
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
    public void cancelAllRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            RLog.info("AppPayServiceImpl", "cancelAllRequest");
            this.mRevenueService.cancelAllRequest();
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public IPayServiceStatistics getPayServiceStatistics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mPayServiceStatistics;
        }
        return (IPayServiceStatistics) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.IPayServiceCallback
    public void dealOnOrderInter(IResponse iResponse, ChargeCurrencyReqParams chargeCurrencyReqParams, PayOrderResult payOrderResult, IRequest iRequest, HiidoReport.CReportResponse cReportResponse, long j) {
        IPayCallback iPayCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{iResponse, chargeCurrencyReqParams, payOrderResult, iRequest, cReportResponse, Long.valueOf(j)}) == null) {
            if (iResponse.isSuccess() && chargeCurrencyReqParams != null && payOrderResult != null) {
                RLog.info("AppPayServiceImpl", "payorder success! orderid=" + payOrderResult.getOrderId());
                String payUrl = payOrderResult.getPayUrl();
                PayCallBackBean payCallBackBean = new PayCallBackBean(payOrderResult.getOrderId(), chargeCurrencyReqParams.getProductId(), null, chargeCurrencyReqParams.getRequestTime(), JsonDataParerUtil.getChOrderidByPayload(payUrl), payUrl, null, null, PurchaseStatus.ORDER_SUCCESS, chargeCurrencyReqParams.getAppClientExpand());
                if (chargeCurrencyReqParams.getPayType() != PayType.DXM_PAY_KJ && chargeCurrencyReqParams.getPayType() != PayType.MOCK_TEST_PAY && chargeCurrencyReqParams.getPayType() != PayType.UNION_PAY && chargeCurrencyReqParams.getPayType() != PayType.DXM_PAY_H5) {
                    IPayCallback iPayCallback2 = (IPayCallback) chargeCurrencyReqParams.getCallback();
                    if (iPayCallback2 != null) {
                        iPayCallback2.onPayStatus(PurchaseStatus.ORDER_SUCCESS, payCallBackBean);
                    }
                    requestPay(payOrderResult.getOrderId(), chargeCurrencyReqParams.getContext(), chargeCurrencyReqParams, chargeCurrencyReqParams.getPayType(), chargeCurrencyReqParams.getProductId(), payUrl, new PayCallbackProxy(chargeCurrencyReqParams.getPayType(), payOrderResult.getOrderId(), chargeCurrencyReqParams, payUrl, payOrderResult.getPollingModeInfo(), this.mPayEventStatistics, this, this, iPayCallback2));
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
            this.mPayRespDispatcher.onFail(iRequest.getReqSeq(), iResponse.getResponseCode(), iResponse.getMessage(), chargeCurrencyReqParams.getCallback(), payCallBackBean2);
            reportOrderProductFail(iResponse, chargeCurrencyReqParams, payOrderResult, cReportResponse);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public boolean isSupported(Activity activity, PayType payType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, activity, payType)) == null) {
            IPayMethod valueOf = PayMethodFactory.valueOf(payType);
            if (valueOf != null) {
                return valueOf.isSupported(activity);
            }
            RLog.warn("AppPayServiceImpl", "isSupported but pay null");
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void onQQPayResult(int i, String str) {
        IPayMethod valueOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048582, this, i, str) == null) && (valueOf = PayMethodFactory.valueOf(PayType.QQ_PAY)) != null) {
            valueOf.onQQPayResult(i, str);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.IRevenueService.IRevenueServiceListener
    public void onRevenueResponse(int i, IResponse iResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i, iResponse) == null) {
            RLog.debug("AppPayServiceImpl", "onRevenueResponse command = " + i);
            this.mPayRespDispatcher.onRevenueResponse(i, iResponse);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void onWxPayResult(int i, String str) {
        IPayMethod valueOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048586, this, i, str) == null) && (valueOf = PayMethodFactory.valueOf(PayType.WECHAT_PAY)) != null) {
            valueOf.onWxPayResult(i, str);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryMyBalance(@NonNull QueryCurrencyReqParams queryCurrencyReqParams, IResult<MyBalanceResult> iResult) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, queryCurrencyReqParams, iResult) != null) || !checkNotNull(queryCurrencyReqParams, iResult)) {
            return;
        }
        queryCurrencyReqParams.setCallback(iResult);
        IRequest obtainRequest = this.mRevenueService.obtainRequest(1005, queryCurrencyReqParams);
        obtainRequest.setExtParam(queryCurrencyReqParams);
        this.mRevenueService.sendRequest(obtainRequest);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onRequestError(int i, int i2, String str, int i3, int i4, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), str2}) == null) {
            RLog.debug("AppPayServiceImpl", "onResponseData cmd = " + i3 + " srvErrorCode = " + i4 + " message =" + str2);
            this.mRevenueService.onRequestError(i, i2, str, i3, i4, str2);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onResponseData(int i, int i2, PSCIMessageResponse pSCIMessageResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, pSCIMessageResponse) == null) {
            RLog.debug("AppPayServiceImpl", "onResponseData responseData = " + pSCIMessageResponse);
            this.mRevenueService.onResponseData(i, i2, pSCIMessageResponse);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.IPayServiceCallback
    public void requestPayOrderResult(ChargeCurrencyReqParams chargeCurrencyReqParams, String str, PollingModeInfo pollingModeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, chargeCurrencyReqParams, str, pollingModeInfo) == null) {
            chargeCurrencyReqParams.setProtocolType(this.mProtocolType);
            this.mPayOrderResultPoller.tryGetPayResult(chargeCurrencyReqParams, this.mAppId, str, pollingModeInfo, new PayOrderResultPoller.PollerListener(this, str) { // from class: com.yy.mobile.framework.revenuesdk.payservice.AppPayServiceImpl.1
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$orderId = str;
                }

                @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.PayOrderResultPoller.PollerListener
                public void onFail(ChargeCurrencyReqParams chargeCurrencyReqParams2, int i, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, chargeCurrencyReqParams2, i, str2) == null) {
                        RLog.error("AppPayServiceImpl", "paychargeorderStatus onFail orderId:" + this.val$orderId + " code:" + i + " failReason:" + str2, new Object[0]);
                    }
                }

                @Override // com.yy.mobile.framework.revenuesdk.payservice.impl.PayOrderResultPoller.PollerListener
                public void onSuccess(ChargeCurrencyReqParams chargeCurrencyReqParams2, GetChargeOrderStatusResult getChargeOrderStatusResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chargeCurrencyReqParams2, getChargeOrderStatusResult) == null) {
                        RLog.info("AppPayServiceImpl", "paychargeorderStatus success orderId:" + this.val$orderId);
                    }
                }
            });
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void payWithProductInfo(@NonNull Activity activity, @NonNull ChargeCurrencyReqParams chargeCurrencyReqParams, @NonNull ProductInfo productInfo, @NonNull PayType payType, int i, int i2, int i3, IPayCallback<String> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{activity, chargeCurrencyReqParams, productInfo, payType, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iPayCallback}) == null) {
            RLog.info("AppPayServiceImpl", "---payWithProductInfo---");
            doOrderRequest(activity, chargeCurrencyReqParams, productInfo, payType, i, i2, i3, iPayCallback);
            IPayEventStatistics iPayEventStatistics = this.mPayEventStatistics;
            if (iPayEventStatistics != null) {
                iPayEventStatistics.reportPayFlowEvent(PayFlowEventType.payingstart, "0", "doOrderRequest", "", "" + chargeCurrencyReqParams.getRequestTime(), productInfo.productId, payType.getChannel(), chargeCurrencyReqParams.getTraceid());
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryBannerConfigRequest(@NonNull GetBannerConfigReqParams getBannerConfigReqParams, IResult<BannerConfigResult> iResult) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, getBannerConfigReqParams, iResult) != null) || !checkNotNull(getBannerConfigReqParams, iResult)) {
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
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, getChargeOrderStatusReqParams, iResult) != null) || !checkNotNull(getChargeOrderStatusReqParams, iResult)) {
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
    public void queryProductList(@NonNull QueryCurrencyReqParams queryCurrencyReqParams, IResult<ProductListResult> iResult) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048591, this, queryCurrencyReqParams, iResult) != null) || !checkNotNull(queryCurrencyReqParams, iResult)) {
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
    public void requestPay(Activity activity, PayType payType, String str, String str2, IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048594, this, activity, payType, str, str2, iPayCallback) == null) {
            RLog.info("AppPayServiceImpl", "requstPay,payType:" + payType + ",productId:" + str + ",payload:" + str2);
            PayMethodFactory.valueOf(payType).requestPay(activity, 0L, str, str2, iPayCallback);
        }
    }
}
