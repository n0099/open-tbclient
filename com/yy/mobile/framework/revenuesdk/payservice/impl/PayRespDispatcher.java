package com.yy.mobile.framework.revenuesdk.payservice.impl;

import android.os.Looper;
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
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.SplitOrderConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.RequestParams;
import com.yy.mobile.framework.revenuesdk.payapi.statistics.IPayServiceStatisticsApi;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.response.IResponse;
import com.yy.mobile.framework.revenuesdk.payservice.utils.JsonDataParerUtil;
/* loaded from: classes2.dex */
public class PayRespDispatcher {
    public static final String TAG = "PayRespDispatcher";
    public IPayServiceStatisticsApi mPayReporter;
    public IPayServiceCallback mPayServiceCallback;

    public PayRespDispatcher(IPayServiceStatisticsApi iPayServiceStatisticsApi, IPayServiceCallback iPayServiceCallback) {
        this.mPayReporter = iPayServiceStatisticsApi;
        this.mPayServiceCallback = iPayServiceCallback;
    }

    private <T> T getResponseData(Class<T> cls, IResponse iResponse) {
        Object responseData = iResponse.getResponseData();
        if (responseData != null) {
            return cls.cast(responseData);
        }
        return null;
    }

    private void onCurrencyChargeMessage(IResponse iResponse) {
        final CurrencyChargeMessage currencyChargeMessage = (CurrencyChargeMessage) getResponseData(CurrencyChargeMessage.class, iResponse);
        if (currencyChargeMessage == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.mPayServiceCallback.onCurrencyChargeMessage(currencyChargeMessage);
        } else {
            ThreadPool.getDefault().mainThreadIO().execute(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.PayRespDispatcher.1
                @Override // java.lang.Runnable
                public void run() {
                    PayRespDispatcher.this.mPayServiceCallback.onCurrencyChargeMessage(currencyChargeMessage);
                }
            });
        }
    }

    private void onBannerConfig(IResponse iResponse) {
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

    private void onGetSplitOrderConfig(IResponse iResponse) {
        IRequest request = iResponse.getRequest();
        SplitOrderConfigResult splitOrderConfigResult = (SplitOrderConfigResult) getResponseData(SplitOrderConfigResult.class, iResponse);
        if (request != null) {
            RequestParams requestParams = (RequestParams) request.getExtParam();
            if (iResponse.isSuccess() && splitOrderConfigResult != null) {
                onSuccess(requestParams, splitOrderConfigResult, null);
                RLog.info(TAG, "onGetSplitOrderConfig success");
                return;
            }
            RLog.error(TAG, "onGetSplitOrderConfig fail code = %d, errMsg = %s", Integer.valueOf(iResponse.getResponseCode()), iResponse.getMessage());
            onFail("", iResponse.getResponseCode(), iResponse.getMessage(), requestParams.getCallback(), null);
        }
    }

    private void onQueryUserAccount(IResponse iResponse) {
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

    private void onErrorRespone(IResponse iResponse) {
        IRequest request = iResponse.getRequest();
        RLog.info("AppPayServiceImpl", "---onErrorRespone---");
        if (request != null) {
            RLog.info("AppPayServiceImpl", "---onErrorRespone---onFail：" + iResponse.getResponseCode());
            onFail("", iResponse.getResponseCode(), iResponse.getMessage(), ((RequestParams) request.getExtParam()).getCallback(), null);
        }
    }

    private void onGetChargeOrderStatus(IResponse iResponse, int i) {
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

    private void onQueryProductList(IResponse iResponse, int i) {
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

    private void onOrderProduct(IResponse iResponse, int i) {
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

    public void onFail(String str, final int i, final String str2, final IResult iResult, final PayCallBackBean payCallBackBean) {
        if (iResult == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            iResult.onFail(i, str2, payCallBackBean);
        } else {
            ThreadPool.getDefault().mainThreadIO().execute(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.PayRespDispatcher.3
                @Override // java.lang.Runnable
                public void run() {
                    iResult.onFail(i, str2, payCallBackBean);
                }
            });
        }
    }

    public void onRevenueResponse(int i, IResponse iResponse) {
        RLog.debug(TAG, "onRevenueResponse command = " + i);
        if (i != 1005) {
            if (i != 1061) {
                if (i != 1071) {
                    if (i != 1079) {
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
                    onGetSplitOrderConfig(iResponse);
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

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> void onSuccess(RequestParams requestParams, final T t, final PayCallBackBean payCallBackBean) {
        final IResult<?> callback;
        if (requestParams == null || (callback = requestParams.getCallback()) == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            callback.onSuccess(t, payCallBackBean);
        } else {
            ThreadPool.getDefault().mainThreadIO().execute(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.PayRespDispatcher.2
                @Override // java.lang.Runnable
                public void run() {
                    callback.onSuccess(t, payCallBackBean);
                }
            });
        }
    }
}
