package com.yy.mobile.framework.revenuesdk.payapi;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetChargeOrderStatusReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.statistics.IPayServiceStatistics;
/* loaded from: classes8.dex */
public interface IAppPayService {
    void addPayListener(IAppPayServiceListener iAppPayServiceListener);

    void cancelAllRequest();

    IPayServiceStatistics getPayServiceStatistics();

    boolean isSupported(Activity activity, PayType payType);

    void onQQPayResult(int i, String str);

    void onWxPayResult(int i, String str);

    void payWithProductInfo(Activity activity, ChargeCurrencyReqParams chargeCurrencyReqParams, ProductInfo productInfo, PayType payType, int i, int i2, int i3, IPayCallback iPayCallback);

    void queryBannerConfigRequest(GetBannerConfigReqParams getBannerConfigReqParams, IResult iResult);

    void queryChargeOrderStatus(GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, IResult iResult);

    void queryMyBalance(QueryCurrencyReqParams queryCurrencyReqParams, IResult iResult);

    void queryProductList(QueryCurrencyReqParams queryCurrencyReqParams, IResult iResult);

    void registerPayServiceStatistics(IPayServiceStatistics iPayServiceStatistics);

    void removePayListener(IAppPayServiceListener iAppPayServiceListener);

    void requestPay(Activity activity, PayType payType, String str, String str2, IPayCallback iPayCallback);
}
