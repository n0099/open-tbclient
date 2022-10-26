package com.yy.mobile.framework.revenuesdk.payservice.impl;

import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.HiidoReport;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.PayOrderResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.RequestParams;
import com.yy.mobile.framework.revenuesdk.payapi.statistics.IPayServiceStatistics;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.response.IResponse;
import com.yy.mobile.framework.revenuesdk.payservice.utils.JsonDataParerUtil;
/* loaded from: classes8.dex */
public class PayRespDispatcher {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PayRespDispatcher";
    public transient /* synthetic */ FieldHolder $fh;
    public IPayServiceStatistics mPayReporter;
    public IPayServiceCallback mPayServiceCallback;

    public PayRespDispatcher(IPayServiceStatistics iPayServiceStatistics, IPayServiceCallback iPayServiceCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iPayServiceStatistics, iPayServiceCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPayReporter = iPayServiceStatistics;
        this.mPayServiceCallback = iPayServiceCallback;
    }

    private Object getResponseData(Class cls, IResponse iResponse) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, cls, iResponse)) == null) {
            Object responseData = iResponse.getResponseData();
            if (responseData != null) {
                return cls.cast(responseData);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    private void onBannerConfig(IResponse iResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, iResponse) == null) {
            IRequest request = iResponse.getRequest();
            BannerConfigResult bannerConfigResult = (BannerConfigResult) getResponseData(BannerConfigResult.class, iResponse);
            if (request != null) {
                RequestParams requestParams = (RequestParams) request.getExtParam();
                if (iResponse.isSuccess() && bannerConfigResult != null) {
                    onSuccess(requestParams, bannerConfigResult, null);
                    RLog.info(TAG, "onBannerConfig success");
                    return;
                }
                RLog.error(TAG, "onBannerConfig fail code = %d, errMsg = %s", Integer.valueOf(iResponse.getResponseCode()), iResponse.getMessage());
                onFail("", iResponse.getResponseCode(), iResponse.getMessage(), requestParams.getCallback(), null);
            }
        }
    }

    private void onQueryUserAccount(IResponse iResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, iResponse) == null) {
            IRequest request = iResponse.getRequest();
            MyBalanceResult myBalanceResult = (MyBalanceResult) getResponseData(MyBalanceResult.class, iResponse);
            if (request != null) {
                RequestParams requestParams = (RequestParams) request.getExtParam();
                if (iResponse.isSuccess() && myBalanceResult != null) {
                    onSuccess(requestParams, myBalanceResult, null);
                    RLog.info(TAG, "onQueryUserAccount success");
                    return;
                }
                RLog.error(TAG, "onQueryUserAccount fail code = %d, errMsg = %s", Integer.valueOf(iResponse.getResponseCode()), iResponse.getMessage());
                onFail("", iResponse.getResponseCode(), iResponse.getMessage(), requestParams.getCallback(), null);
            }
        }
    }

    private void onCurrencyChargeMessage(IResponse iResponse) {
        CurrencyChargeMessage currencyChargeMessage;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, iResponse) != null) || (currencyChargeMessage = (CurrencyChargeMessage) getResponseData(CurrencyChargeMessage.class, iResponse)) == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.mPayServiceCallback.onCurrencyChargeMessage(currencyChargeMessage);
        } else {
            ThreadPool.getDefault().mainThreadIO().execute(new Runnable(this, currencyChargeMessage) { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.PayRespDispatcher.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayRespDispatcher this$0;
                public final /* synthetic */ CurrencyChargeMessage val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, currencyChargeMessage};
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
                    this.val$result = currencyChargeMessage;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.mPayServiceCallback.onCurrencyChargeMessage(this.val$result);
                    }
                }
            });
        }
    }

    private void onErrorRespone(IResponse iResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, iResponse) == null) {
            IRequest request = iResponse.getRequest();
            RLog.info("AppPayServiceImpl", "---onErrorRespone---");
            if (request != null) {
                RLog.info("AppPayServiceImpl", "---onErrorRespone---onFail：" + iResponse.getResponseCode());
                onFail("", iResponse.getResponseCode(), iResponse.getMessage(), ((RequestParams) request.getExtParam()).getCallback(), null);
            }
        }
    }

    private void onGetChargeOrderStatus(IResponse iResponse, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, this, iResponse, i) == null) {
            GetChargeOrderStatusResult getChargeOrderStatusResult = (GetChargeOrderStatusResult) getResponseData(GetChargeOrderStatusResult.class, iResponse);
            IRequest request = iResponse.getRequest();
            HiidoReport.CReportResponse cReportResponse = new HiidoReport.CReportResponse();
            if (request != null) {
                RequestParams requestParams = (RequestParams) request.getExtParam();
                if (iResponse.isSuccess() && getChargeOrderStatusResult != null) {
                    onSuccess(requestParams, getChargeOrderStatusResult, null);
                    RLog.info(TAG, "onGetChargeOrderStatus success");
                    if (this.mPayReporter != null) {
                        cReportResponse.mEventId = EventType.PayEventID.QUERY_CHARGE_ORDER_STATUS_SUCCESS;
                        cReportResponse.mEventaliae = EventAlias.PayEventAlias.QUERY_CHARGE_ORDER_STATUS_SUCCESS;
                        cReportResponse.mErrCode = iResponse.getResponseCode() + "";
                        cReportResponse.mErrMsg = "onQueryChargeOrderStatus success!" + iResponse.getMessage();
                        cReportResponse.mCmd = i;
                        this.mPayReporter.onQueryChargeOrderStatus(cReportResponse);
                        return;
                    }
                    return;
                }
                RLog.error(TAG, "onGetChargeOrderStatus fail code = %d, errMsg = %s", Integer.valueOf(iResponse.getResponseCode()), iResponse.getMessage());
                onFail("", iResponse.getResponseCode(), iResponse.getMessage(), requestParams.getCallback(), null);
                if (this.mPayReporter != null) {
                    cReportResponse.mEventId = EventType.PayEventID.QUERY_CHARGE_ORDER_STATUS_FAIL;
                    cReportResponse.mEventaliae = EventAlias.PayEventAlias.QUERY_CHARGE_ORDER_STATUS_FAIL;
                    cReportResponse.mErrCode = iResponse.getResponseCode() + "";
                    cReportResponse.mErrMsg = "onQueryChargeOrderStatus fail!" + iResponse.getMessage();
                    cReportResponse.mCmd = i;
                    this.mPayReporter.onQueryUserYbDetails(cReportResponse);
                }
            }
        }
    }

    private void onQueryProductList(IResponse iResponse, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, this, iResponse, i) == null) {
            IRequest request = iResponse.getRequest();
            ProductListResult productListResult = (ProductListResult) getResponseData(ProductListResult.class, iResponse);
            HiidoReport.CReportResponse cReportResponse = new HiidoReport.CReportResponse();
            if (request != null) {
                RequestParams requestParams = (RequestParams) request.getExtParam();
                if (iResponse.isSuccess() && productListResult != null) {
                    RLog.info(TAG, "onQueryProductList success");
                    onSuccess(requestParams, productListResult, null);
                    if (this.mPayReporter != null) {
                        cReportResponse.mEventId = EventType.PayEventID.QUERY_PRODUCT_LIST_SUCCESS;
                        cReportResponse.mEventaliae = EventAlias.PayEventAlias.QUERY_PRODUCT_LIST_SUCCESS;
                        cReportResponse.mErrCode = iResponse.getResponseCode() + "";
                        cReportResponse.mErrMsg = "queryProductList success!" + iResponse.getMessage();
                        cReportResponse.mCmd = i;
                        this.mPayReporter.onQueryProductList(cReportResponse);
                        return;
                    }
                    return;
                }
                RLog.error(TAG, "onQueryProductList fail code = %d, errMsg = %s", Integer.valueOf(iResponse.getResponseCode()), iResponse.getMessage());
                onFail(request.getReqSeq(), iResponse.getResponseCode(), iResponse.getMessage(), requestParams.getCallback(), null);
                if (this.mPayReporter != null) {
                    cReportResponse.mEventId = EventType.PayEventID.QUERY_PRODUCT_LIST_FAIL;
                    cReportResponse.mEventaliae = EventAlias.PayEventAlias.QUERY_PRODUCT_LIST_FAIL;
                    cReportResponse.mErrCode = iResponse.getResponseCode() + "";
                    cReportResponse.mErrMsg = "queryProductList fail!" + iResponse.getMessage();
                    cReportResponse.mCmd = i;
                    this.mPayReporter.onQueryProductList(cReportResponse);
                }
            }
        }
    }

    private void onOrderProduct(IResponse iResponse, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, this, iResponse, i) == null) {
            IRequest request = iResponse.getRequest();
            PayOrderResult payOrderResult = (PayOrderResult) getResponseData(PayOrderResult.class, iResponse);
            if (request != null) {
                ChargeCurrencyReqParams chargeCurrencyReqParams = (ChargeCurrencyReqParams) request.getExtParam();
                HiidoReport.CReportResponse cReportResponse = new HiidoReport.CReportResponse();
                long j = 0;
                if (chargeCurrencyReqParams != null) {
                    cReportResponse.mPaysource = chargeCurrencyReqParams.getFrom();
                    cReportResponse.mUid = chargeCurrencyReqParams.getUid();
                    j = System.currentTimeMillis() - chargeCurrencyReqParams.getRequestTime();
                    cReportResponse.mDelay = j + "";
                    cReportResponse.mCmd = i;
                }
                long j2 = j;
                if (payOrderResult != null) {
                    cReportResponse.mOrderId = payOrderResult.getOrderId();
                }
                if (chargeCurrencyReqParams != null) {
                    if (payOrderResult != null) {
                        String challengeExtension = JsonDataParerUtil.getChallengeExtension(payOrderResult.getExpand());
                        if (challengeExtension != null && !challengeExtension.equals("")) {
                            RLog.error(TAG, "showVerifyViewWithInfoString", new Object[0]);
                            return;
                        } else {
                            this.mPayServiceCallback.dealOnOrderInter(iResponse, chargeCurrencyReqParams, payOrderResult, request, cReportResponse, j2);
                            return;
                        }
                    }
                    this.mPayServiceCallback.dealOnOrderInter(iResponse, chargeCurrencyReqParams, null, request, cReportResponse, j2);
                }
            }
        }
    }

    public void onFail(String str, int i, String str2, IResult iResult, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i), str2, iResult, payCallBackBean}) != null) || iResult == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            iResult.onFail(i, str2, payCallBackBean);
        } else {
            ThreadPool.getDefault().mainThreadIO().execute(new Runnable(this, iResult, i, str2, payCallBackBean) { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.PayRespDispatcher.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayRespDispatcher this$0;
                public final /* synthetic */ IResult val$callback;
                public final /* synthetic */ int val$code;
                public final /* synthetic */ String val$message;
                public final /* synthetic */ PayCallBackBean val$payCallBackBean;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iResult, Integer.valueOf(i), str2, payCallBackBean};
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
                    this.val$callback = iResult;
                    this.val$code = i;
                    this.val$message = str2;
                    this.val$payCallBackBean = payCallBackBean;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$callback.onFail(this.val$code, this.val$message, this.val$payCallBackBean);
                    }
                }
            });
        }
    }

    public void onRevenueResponse(int i, IResponse iResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, iResponse) == null) {
            RLog.debug(TAG, "onRevenueResponse command = " + i);
            if (i != 1005) {
                if (i != 1061) {
                    if (i != 1071) {
                        if (i != 40423898) {
                            if (i != 1021) {
                                if (i != 1022) {
                                    onErrorRespone(iResponse);
                                    return;
                                } else {
                                    onOrderProduct(iResponse, 1022);
                                    return;
                                }
                            }
                            onQueryProductList(iResponse, 1021);
                            return;
                        }
                        onCurrencyChargeMessage(iResponse);
                        return;
                    }
                    onBannerConfig(iResponse);
                    return;
                }
                onGetChargeOrderStatus(iResponse, RevenueServerConst.GetChargeOrderStatusRequest);
                return;
            }
            onQueryUserAccount(iResponse);
        }
    }

    public void onSuccess(RequestParams requestParams, Object obj, PayCallBackBean payCallBackBean) {
        IResult callback;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, requestParams, obj, payCallBackBean) != null) || requestParams == null || (callback = requestParams.getCallback()) == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            callback.onSuccess(obj, payCallBackBean);
        } else {
            ThreadPool.getDefault().mainThreadIO().execute(new Runnable(this, callback, obj, payCallBackBean) { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.PayRespDispatcher.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayRespDispatcher this$0;
                public final /* synthetic */ IResult val$callback;
                public final /* synthetic */ Object val$data;
                public final /* synthetic */ PayCallBackBean val$payCallBackBean;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, callback, obj, payCallBackBean};
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
                    this.val$callback = callback;
                    this.val$data = obj;
                    this.val$payCallBackBean = payCallBackBean;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$callback.onSuccess(this.val$data, this.val$payCallBackBean);
                    }
                }
            });
        }
    }
}
