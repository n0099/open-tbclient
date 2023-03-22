package com.yy.mobile.framework.revenuesdk.payapi;

import android.app.Activity;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaySignInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.SplitOrderConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetChargeOrderStatusReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetSplitOrderConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.statistics.IPayServiceStatistics;
@Keep
/* loaded from: classes9.dex */
public interface IAppPayService {
    void addPayListener(IAppPayServiceListener iAppPayServiceListener);

    void cancelAllRequest();

    IPayServiceStatistics getPayServiceStatistics();

    boolean isSupported(@NonNull Activity activity, @NonNull PayType payType);

    void onQQPayResult(int i, String str);

    void onWxPayResult(int i, String str);

    void payWithProductInfo(@NonNull Activity activity, @NonNull ChargeCurrencyReqParams chargeCurrencyReqParams, @NonNull ProductInfo productInfo, @NonNull PayType payType, int i, int i2, int i3, IPayCallback<String> iPayCallback);

    void queryBannerConfigRequest(@NonNull GetBannerConfigReqParams getBannerConfigReqParams, IResult<BannerConfigResult> iResult);

    void queryChargeOrderStatus(@NonNull GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, IResult<GetChargeOrderStatusResult> iResult);

    void queryMyBalance(@NonNull QueryCurrencyReqParams queryCurrencyReqParams, IResult<MyBalanceResult> iResult);

    void queryProductList(@NonNull QueryCurrencyReqParams queryCurrencyReqParams, IResult<ProductListResult> iResult);

    void querySplitOrderConfig(GetSplitOrderConfigReqParams getSplitOrderConfigReqParams, IResult<SplitOrderConfigResult> iResult);

    void registerPayServiceStatistics(IPayServiceStatistics iPayServiceStatistics);

    void removePayListener(IAppPayServiceListener iAppPayServiceListener);

    void requestPay(@NonNull Activity activity, @NonNull PayType payType, String str, String str2, IPayCallback<PurchaseInfo> iPayCallback);

    void signAliPay(@NonNull Activity activity, PaySignInfo paySignInfo, IPaySignCallback iPaySignCallback);
}
