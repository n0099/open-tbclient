package com.yy.mobile.framework.revenuesdk.payservice.impl;

import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.yy.mobile.framework.revenuesdk.payapi.bean.AccountDelayMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ConsumeConfirmMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.CouponDiscountResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ExchangeResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetUserYbDetailsResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.HasChargeInActivityResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.PayOrderResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.RechargeHistoryResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.RevenueRecordResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.UserCouponStoreResult;
import com.yy.mobile.framework.revenuesdk.payapi.reporter.IPayReporter;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.RequestParams;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.response.IResponse;
import com.yy.mobile.framework.revenuesdk.payservice.utils.JsonDataParerUtil;
/* loaded from: classes10.dex */
public class PayRespManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AppPayServiceImpl-RespM";
    public transient /* synthetic */ FieldHolder $fh;
    public IPayReporter iPayReporter;
    public String mDefalutFunctionName;
    public String mDefalutServiceName;
    public IPayInnerLogic payInnerLogic;

    public PayRespManager(IPayReporter iPayReporter, IPayInnerLogic iPayInnerLogic, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iPayReporter, iPayInnerLogic, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDefalutServiceName = "";
        this.mDefalutFunctionName = "";
        this.iPayReporter = iPayReporter;
        this.payInnerLogic = iPayInnerLogic;
        this.mDefalutServiceName = str;
        this.mDefalutFunctionName = str2;
    }

    private <T> T getResponseData(Class<T> cls, IResponse iResponse) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, cls, iResponse)) == null) {
            Object responseData = iResponse.getResponseData();
            if (responseData != null) {
                return cls.cast(responseData);
            }
            return null;
        }
        return (T) invokeLL.objValue;
    }

    private void onAccountDelayMessage(IResponse iResponse) {
        AccountDelayMessage accountDelayMessage;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, iResponse) == null) || (accountDelayMessage = (AccountDelayMessage) getResponseData(AccountDelayMessage.class, iResponse)) == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.payInnerLogic.onAccountDelayMessage(accountDelayMessage);
        } else {
            ThreadPool.getDefault().mainThreadIO().execute(new Runnable(this, accountDelayMessage) { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.PayRespManager.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayRespManager this$0;
                public final /* synthetic */ AccountDelayMessage val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, accountDelayMessage};
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
                    this.val$result = accountDelayMessage;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.payInnerLogic.onAccountDelayMessage(this.val$result);
                    }
                }
            });
        }
    }

    private void onBannerConfig(IResponse iResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, iResponse) == null) {
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

    private void onConsumeConfirmMessage(IResponse iResponse) {
        ConsumeConfirmMessage consumeConfirmMessage;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, iResponse) == null) || (consumeConfirmMessage = (ConsumeConfirmMessage) getResponseData(ConsumeConfirmMessage.class, iResponse)) == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.payInnerLogic.onConsumeConfirmMessage(consumeConfirmMessage);
        } else {
            ThreadPool.getDefault().mainThreadIO().execute(new Runnable(this, consumeConfirmMessage) { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.PayRespManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayRespManager this$0;
                public final /* synthetic */ ConsumeConfirmMessage val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, consumeConfirmMessage};
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
                    this.val$result = consumeConfirmMessage;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.payInnerLogic.onConsumeConfirmMessage(this.val$result);
                    }
                }
            });
        }
    }

    private void onCurrencyChargeMessage(IResponse iResponse) {
        CurrencyChargeMessage currencyChargeMessage;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, iResponse) == null) || (currencyChargeMessage = (CurrencyChargeMessage) getResponseData(CurrencyChargeMessage.class, iResponse)) == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.payInnerLogic.onCurrencyChargeMessage(currencyChargeMessage);
        } else {
            ThreadPool.getDefault().mainThreadIO().execute(new Runnable(this, currencyChargeMessage) { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.PayRespManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayRespManager this$0;
                public final /* synthetic */ CurrencyChargeMessage val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, currencyChargeMessage};
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
                    this.val$result = currencyChargeMessage;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.payInnerLogic.onCurrencyChargeMessage(this.val$result);
                    }
                }
            });
        }
    }

    private void onErrorRespone(IResponse iResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, iResponse) == null) {
            IRequest request = iResponse.getRequest();
            RLog.info("AppPayServiceImpl", "---onErrorRespone---");
            if (request != null) {
                RLog.info("AppPayServiceImpl", "---onErrorRespone---onFail：" + iResponse.getResponseCode());
                onFail("", iResponse.getResponseCode(), iResponse.getMessage(), ((RequestParams) request.getExtParam()).getCallback(), null);
            }
        }
    }

    private void onExchangeCurrency(IResponse iResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, iResponse) == null) {
            IRequest request = iResponse.getRequest();
            ExchangeResult exchangeResult = (ExchangeResult) getResponseData(ExchangeResult.class, iResponse);
            if (request != null) {
                RequestParams requestParams = (RequestParams) request.getExtParam();
                if (iResponse.isSuccess() && exchangeResult != null) {
                    onSuccess(requestParams, exchangeResult, null);
                    RLog.info(TAG, "onExchangeCurrency success");
                    return;
                }
                RLog.error(TAG, "onExchangeCurrency fail code = %d, errMsg = %s", Integer.valueOf(iResponse.getResponseCode()), iResponse.getMessage());
                onFail("", iResponse.getResponseCode(), iResponse.getMessage(), requestParams.getCallback(), null);
            }
        }
    }

    private void onGetChargeCouponDiscount(IResponse iResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, iResponse) == null) {
            IRequest request = iResponse.getRequest();
            CouponDiscountResult couponDiscountResult = (CouponDiscountResult) getResponseData(CouponDiscountResult.class, iResponse);
            if (request != null) {
                RequestParams requestParams = (RequestParams) request.getExtParam();
                if (iResponse.isSuccess() && couponDiscountResult != null) {
                    RLog.info(TAG, "onGetChargeCouponDiscount success");
                    onSuccess(requestParams, couponDiscountResult, null);
                    return;
                }
                RLog.error(TAG, "onGetChargeCouponDiscount fail code = %d, errMsg = %s", Integer.valueOf(iResponse.getResponseCode()), iResponse.getMessage());
                onFail(request.getReqSeq(), iResponse.getResponseCode(), iResponse.getMessage(), requestParams.getCallback(), null);
            }
        }
    }

    private void onGetChargeOrderStatus(IResponse iResponse, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, this, iResponse, i2) == null) {
            GetChargeOrderStatusResult getChargeOrderStatusResult = (GetChargeOrderStatusResult) getResponseData(GetChargeOrderStatusResult.class, iResponse);
            IRequest request = iResponse.getRequest();
            HiidoReport.CReportResponse cReportResponse = new HiidoReport.CReportResponse();
            if (request != null) {
                RequestParams requestParams = (RequestParams) request.getExtParam();
                if (iResponse.isSuccess() && getChargeOrderStatusResult != null) {
                    onSuccess(requestParams, getChargeOrderStatusResult, null);
                    RLog.info(TAG, "onGetChargeOrderStatus success");
                    if (this.iPayReporter != null) {
                        cReportResponse.mEventId = EventType.PayEventID.QUERY_CHARGE_ORDER_STATUS_SUCCESS;
                        cReportResponse.mEventaliae = EventAlias.PayEventAlias.QUERY_CHARGE_ORDER_STATUS_SUCCESS;
                        cReportResponse.mErrCode = iResponse.getResponseCode() + "";
                        cReportResponse.mErrMsg = "onQueryChargeOrderStatus success!" + iResponse.getMessage();
                        cReportResponse.mCmd = i2;
                        this.iPayReporter.onQueryChargeOrderStatus(cReportResponse);
                        return;
                    }
                    return;
                }
                RLog.error(TAG, "onGetChargeOrderStatus fail code = %d, errMsg = %s", Integer.valueOf(iResponse.getResponseCode()), iResponse.getMessage());
                onFail("", iResponse.getResponseCode(), iResponse.getMessage(), requestParams.getCallback(), null);
                if (this.iPayReporter != null) {
                    cReportResponse.mEventId = EventType.PayEventID.QUERY_CHARGE_ORDER_STATUS_FAIL;
                    cReportResponse.mEventaliae = EventAlias.PayEventAlias.QUERY_CHARGE_ORDER_STATUS_FAIL;
                    cReportResponse.mErrCode = iResponse.getResponseCode() + "";
                    cReportResponse.mErrMsg = "onQueryChargeOrderStatus fail!" + iResponse.getMessage();
                    cReportResponse.mCmd = i2;
                    this.iPayReporter.onQueryUserYbDetails(cReportResponse);
                }
            }
        }
    }

    private void onGetHasChargeInActivity(IResponse iResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, iResponse) == null) {
            IRequest request = iResponse.getRequest();
            HasChargeInActivityResult hasChargeInActivityResult = (HasChargeInActivityResult) getResponseData(HasChargeInActivityResult.class, iResponse);
            if (request != null) {
                RequestParams requestParams = (RequestParams) request.getExtParam();
                if (iResponse.isSuccess() && hasChargeInActivityResult != null) {
                    RLog.info(TAG, "onGetHasChargeInActivity success");
                    onSuccess(requestParams, hasChargeInActivityResult, null);
                    return;
                }
                RLog.error(TAG, "onGetHasChargeInActivity fail code = %d, errMsg = %s", Integer.valueOf(iResponse.getResponseCode()), iResponse.getMessage());
                onFail(request.getReqSeq(), iResponse.getResponseCode(), iResponse.getMessage(), requestParams.getCallback(), null);
            }
        }
    }

    private void onGetUserCouponStore(IResponse iResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, iResponse) == null) {
            IRequest request = iResponse.getRequest();
            UserCouponStoreResult userCouponStoreResult = (UserCouponStoreResult) getResponseData(UserCouponStoreResult.class, iResponse);
            if (request != null) {
                RequestParams requestParams = (RequestParams) request.getExtParam();
                if (iResponse.isSuccess() && userCouponStoreResult != null) {
                    RLog.info(TAG, "onGetUserCouponStore success");
                    onSuccess(requestParams, userCouponStoreResult, null);
                    return;
                }
                RLog.error(TAG, "onGetUserCouponStore fail code = %d, errMsg = %s", Integer.valueOf(iResponse.getResponseCode()), iResponse.getMessage());
                onFail(request.getReqSeq(), iResponse.getResponseCode(), iResponse.getMessage(), requestParams.getCallback(), null);
            }
        }
    }

    private void onGetUserYbDetails(IResponse iResponse, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65549, this, iResponse, i2) == null) {
            GetUserYbDetailsResult getUserYbDetailsResult = (GetUserYbDetailsResult) getResponseData(GetUserYbDetailsResult.class, iResponse);
            IRequest request = iResponse.getRequest();
            HiidoReport.CReportResponse cReportResponse = new HiidoReport.CReportResponse();
            if (request != null) {
                RequestParams requestParams = (RequestParams) request.getExtParam();
                if (iResponse.isSuccess() && getUserYbDetailsResult != null) {
                    onSuccess(requestParams, getUserYbDetailsResult, null);
                    RLog.info(TAG, "onGetUserYbDetails success");
                    if (this.iPayReporter != null) {
                        cReportResponse.mEventId = EventType.PayEventID.QUERY_USER_YB_DETAIL_SUCCESS;
                        cReportResponse.mEventaliae = EventAlias.PayEventAlias.QUERY_USER_YB_DETAIL_SUCCESS;
                        cReportResponse.mErrCode = iResponse.getResponseCode() + "";
                        cReportResponse.mErrMsg = "onQueryUserYbDetails success!" + iResponse.getMessage();
                        cReportResponse.mCmd = i2;
                        this.iPayReporter.onQueryUserYbDetails(cReportResponse);
                        return;
                    }
                    return;
                }
                RLog.error(TAG, "onGetChargeOrderStatus fail code = %d, errMsg = %s", Integer.valueOf(iResponse.getResponseCode()), iResponse.getMessage());
                onFail("", iResponse.getResponseCode(), iResponse.getMessage(), requestParams.getCallback(), null);
                if (this.iPayReporter != null) {
                    cReportResponse.mEventId = EventType.PayEventID.QUERY_USER_YB_DETAIL_FAIL;
                    cReportResponse.mEventaliae = EventAlias.PayEventAlias.QUERY_USER_YB_DETAIL_FAIL;
                    cReportResponse.mErrCode = iResponse.getResponseCode() + "";
                    cReportResponse.mErrMsg = "onQueryUserYbDetails fail!" + iResponse.getMessage();
                    cReportResponse.mCmd = i2;
                    this.iPayReporter.onQueryUserYbDetails(cReportResponse);
                }
            }
        }
    }

    private void onOrderProduct(IResponse iResponse, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, this, iResponse, i2) == null) {
            IRequest request = iResponse.getRequest();
            PayOrderResult payOrderResult = (PayOrderResult) getResponseData(PayOrderResult.class, iResponse);
            if (request != null) {
                ChargeCurrencyReqParams chargeCurrencyReqParams = (ChargeCurrencyReqParams) request.getExtParam();
                HiidoReport.CReportResponse cReportResponse = new HiidoReport.CReportResponse();
                long j2 = 0;
                if (chargeCurrencyReqParams != null) {
                    cReportResponse.mPaysource = chargeCurrencyReqParams.getFrom();
                    cReportResponse.mUid = chargeCurrencyReqParams.getUid();
                    j2 = System.currentTimeMillis() - chargeCurrencyReqParams.getRequestTime();
                    cReportResponse.mDelay = j2 + "";
                    cReportResponse.mCmd = i2;
                    cReportResponse.mServiceName = this.mDefalutServiceName;
                    cReportResponse.mFunctionName = this.mDefalutFunctionName;
                }
                long j3 = j2;
                RLog.info("AppPayServiceImpl", "onOrderProduct---mDefalutServiceName:" + this.mDefalutServiceName + "---mDefalutFunctionName:" + this.mDefalutFunctionName + "---mRealFunctionName:" + cReportResponse.mServiceName + "---mRealFunctionName:" + cReportResponse.mFunctionName);
                if (payOrderResult != null) {
                    cReportResponse.mOrderId = payOrderResult.getOrderId();
                }
                if (chargeCurrencyReqParams != null) {
                    if (payOrderResult != null) {
                        String challengeExtension = JsonDataParerUtil.getChallengeExtension(payOrderResult.getExpand());
                        if (challengeExtension != null && !challengeExtension.equals("")) {
                            this.payInnerLogic.showVerifyViewWithInfoString(challengeExtension, chargeCurrencyReqParams, iResponse, request);
                            return;
                        } else {
                            this.payInnerLogic.dealOnOrderInter(iResponse, chargeCurrencyReqParams, payOrderResult, request, cReportResponse, j3);
                            return;
                        }
                    }
                    this.payInnerLogic.dealOnOrderInter(iResponse, chargeCurrencyReqParams, null, request, cReportResponse, j3);
                }
            }
        }
    }

    private void onQueryProductList(IResponse iResponse, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65551, this, iResponse, i2) == null) {
            IRequest request = iResponse.getRequest();
            ProductListResult productListResult = (ProductListResult) getResponseData(ProductListResult.class, iResponse);
            HiidoReport.CReportResponse cReportResponse = new HiidoReport.CReportResponse();
            if (request != null) {
                RequestParams requestParams = (RequestParams) request.getExtParam();
                if (iResponse.isSuccess() && productListResult != null) {
                    RLog.info(TAG, "onQueryProductList success");
                    onSuccess(requestParams, productListResult, null);
                    if (this.iPayReporter != null) {
                        cReportResponse.mEventId = EventType.PayEventID.QUERY_PRODUCT_LIST_SUCCESS;
                        cReportResponse.mEventaliae = EventAlias.PayEventAlias.QUERY_PRODUCT_LIST_SUCCESS;
                        cReportResponse.mErrCode = iResponse.getResponseCode() + "";
                        cReportResponse.mErrMsg = "queryProductList success!" + iResponse.getMessage();
                        cReportResponse.mCmd = i2;
                        this.iPayReporter.onQueryProductList(cReportResponse);
                        return;
                    }
                    return;
                }
                RLog.error(TAG, "onQueryProductList fail code = %d, errMsg = %s", Integer.valueOf(iResponse.getResponseCode()), iResponse.getMessage());
                onFail(request.getReqSeq(), iResponse.getResponseCode(), iResponse.getMessage(), requestParams.getCallback(), null);
                if (this.iPayReporter != null) {
                    cReportResponse.mEventId = EventType.PayEventID.QUERY_PRODUCT_LIST_FAIL;
                    cReportResponse.mEventaliae = EventAlias.PayEventAlias.QUERY_PRODUCT_LIST_FAIL;
                    cReportResponse.mErrCode = iResponse.getResponseCode() + "";
                    cReportResponse.mErrMsg = "queryProductList fail!" + iResponse.getMessage();
                    cReportResponse.mCmd = i2;
                    this.iPayReporter.onQueryProductList(cReportResponse);
                }
            }
        }
    }

    private void onQueryProductListChannels(IResponse iResponse, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65552, this, iResponse, i2) == null) {
            IRequest request = iResponse.getRequest();
            ProductListResult productListResult = (ProductListResult) getResponseData(ProductListResult.class, iResponse);
            HiidoReport.CReportResponse cReportResponse = new HiidoReport.CReportResponse();
            if (request != null) {
                RequestParams requestParams = (RequestParams) request.getExtParam();
                if (iResponse.isSuccess() && productListResult != null) {
                    RLog.info(TAG, "onQueryProductChannelsList success");
                    onSuccess(requestParams, productListResult, null);
                    if (this.iPayReporter != null) {
                        cReportResponse.mEventId = EventType.PayEventID.QUERY_PRODUCT_LIST_SUCCESS;
                        cReportResponse.mEventaliae = EventAlias.PayEventAlias.QUERY_PRODUCT_LIST_SUCCESS;
                        cReportResponse.mErrCode = iResponse.getResponseCode() + "";
                        cReportResponse.mErrMsg = "onQueryProductListChannels success!" + iResponse.getMessage();
                        cReportResponse.mCmd = i2;
                        this.iPayReporter.onQueryProductList(cReportResponse);
                        return;
                    }
                    return;
                }
                RLog.error(TAG, "onQueryProductChannelsList fail code = %d, errMsg = %s", Integer.valueOf(iResponse.getResponseCode()), iResponse.getMessage());
                onFail(request.getReqSeq(), iResponse.getResponseCode(), iResponse.getMessage(), requestParams.getCallback(), null);
                if (this.iPayReporter != null) {
                    cReportResponse.mEventId = EventType.PayEventID.QUERY_PRODUCT_LIST_FAIL;
                    cReportResponse.mEventaliae = EventAlias.PayEventAlias.QUERY_PRODUCT_LIST_FAIL;
                    cReportResponse.mErrCode = iResponse.getResponseCode() + "";
                    cReportResponse.mErrMsg = "onQueryProductListChannels fail!" + iResponse.getMessage();
                    cReportResponse.mCmd = i2;
                    this.iPayReporter.onQueryProductList(cReportResponse);
                }
            }
        }
    }

    private void onQueryRechargeHistory(IResponse iResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, iResponse) == null) {
            IRequest request = iResponse.getRequest();
            RechargeHistoryResult rechargeHistoryResult = (RechargeHistoryResult) getResponseData(RechargeHistoryResult.class, iResponse);
            if (request != null) {
                RequestParams requestParams = (RequestParams) request.getExtParam();
                if (iResponse.isSuccess() && rechargeHistoryResult != null) {
                    onSuccess(requestParams, rechargeHistoryResult, null);
                    RLog.info(TAG, "onQueryRechargeHistory success");
                    return;
                }
                RLog.error(TAG, "onQueryRechargeHistory fail code = %d, errMsg = %s", Integer.valueOf(iResponse.getResponseCode()), iResponse.getMessage());
                onFail("", iResponse.getResponseCode(), iResponse.getMessage(), requestParams.getCallback(), null);
            }
        }
    }

    private void onQueryUserAccount(IResponse iResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, iResponse) == null) {
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

    private void onQueryUserAccountHistory(IResponse iResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, iResponse) == null) {
            IRequest request = iResponse.getRequest();
            RevenueRecordResult revenueRecordResult = (RevenueRecordResult) getResponseData(RevenueRecordResult.class, iResponse);
            if (request != null) {
                RequestParams requestParams = (RequestParams) request.getExtParam();
                if (iResponse.isSuccess() && revenueRecordResult != null) {
                    RLog.info(TAG, "onQueryUserAccountHistory success");
                    onSuccess(requestParams, revenueRecordResult, null);
                    return;
                }
                RLog.error(TAG, "onQueryUserAccountHistory fail code = %d, errMsg = %s", Integer.valueOf(iResponse.getResponseCode()), iResponse.getMessage());
                onFail("", iResponse.getResponseCode(), iResponse.getMessage(), requestParams.getCallback(), null);
            }
        }
    }

    public void onFail(String str, int i2, String str2, IResult iResult, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i2), str2, iResult, payCallBackBean}) == null) || iResult == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            iResult.onFail(i2, str2, payCallBackBean);
        } else {
            ThreadPool.getDefault().mainThreadIO().execute(new Runnable(this, iResult, i2, str2, payCallBackBean) { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.PayRespManager.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayRespManager this$0;
                public final /* synthetic */ IResult val$callback;
                public final /* synthetic */ int val$code;
                public final /* synthetic */ String val$message;
                public final /* synthetic */ PayCallBackBean val$payCallBackBean;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iResult, Integer.valueOf(i2), str2, payCallBackBean};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = iResult;
                    this.val$code = i2;
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

    public void onRevenueResponse(int i2, IResponse iResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, iResponse) == null) {
            RLog.debug(TAG, "onRevenueResponse command = %d", Integer.valueOf(i2));
            if (i2 == 1005) {
                onQueryUserAccount(iResponse);
            } else if (i2 == 1052) {
                onGetChargeCouponDiscount(iResponse);
            } else if (i2 == 1054) {
                onQueryRechargeHistory(iResponse);
            } else if (i2 == 1068) {
                onGetUserYbDetails(iResponse, RevenueServerConst.GetUserYbDetailsRequest);
            } else if (i2 == 1071) {
                onBannerConfig(iResponse);
            } else if (i2 == 40423235) {
                onConsumeConfirmMessage(iResponse);
            } else if (i2 == 40423898) {
                onCurrencyChargeMessage(iResponse);
            } else if (i2 == 40424536) {
                onAccountDelayMessage(iResponse);
            } else if (i2 == 1021) {
                onQueryProductList(iResponse, 1021);
            } else if (i2 == 1022) {
                onOrderProduct(iResponse, 1022);
            } else if (i2 == 1025) {
                onExchangeCurrency(iResponse);
            } else if (i2 == 1026) {
                onGetHasChargeInActivity(iResponse);
            } else if (i2 == 1046) {
                onQueryUserAccountHistory(iResponse);
            } else if (i2 == 1047) {
                onGetUserCouponStore(iResponse);
            } else if (i2 == 1060) {
                onQueryProductListChannels(iResponse, RevenueServerConst.GetChargeCurrencyConfigByChannelsRequest);
            } else if (i2 != 1061) {
                onErrorRespone(iResponse);
            } else {
                onGetChargeOrderStatus(iResponse, RevenueServerConst.GetChargeOrderStatusRequest);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> void onSuccess(RequestParams requestParams, T t, PayCallBackBean payCallBackBean) {
        IResult<?> callback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, requestParams, t, payCallBackBean) == null) || requestParams == null || (callback = requestParams.getCallback()) == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            callback.onSuccess(t, payCallBackBean);
        } else {
            ThreadPool.getDefault().mainThreadIO().execute(new Runnable(this, callback, t, payCallBackBean) { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.PayRespManager.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayRespManager this$0;
                public final /* synthetic */ IResult val$callback;
                public final /* synthetic */ Object val$data;
                public final /* synthetic */ PayCallBackBean val$payCallBackBean;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, callback, t, payCallBackBean};
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
                    this.val$callback = callback;
                    this.val$data = t;
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
