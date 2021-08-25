package com.yy.mobile.framework.revenuesdk.payapi;

import android.app.Activity;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ExchangeResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetUserYbDetailsResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.RechargeHistoryResult;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IAlipaySdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IDxmSdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IWechatSdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.reporter.IPayReporter;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.ExchangeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetChargeOrderStatusReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetUserYbDetailsReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyChannelsReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryRechargeHistoryReqParams;
@Keep
/* loaded from: classes10.dex */
public interface IAppPayService {
    void addAlipaySdkProxy(IAlipaySdkServiceProxy iAlipaySdkServiceProxy);

    void addDxmPaySdkProxy(IDxmSdkServiceProxy iDxmSdkServiceProxy);

    void addPayListener(IAppPayServiceListener iAppPayServiceListener);

    void addWechatSdkProxy(IWechatSdkServiceProxy iWechatSdkServiceProxy);

    void cancelAllRequest();

    void exchangeCurrency(@NonNull ExchangeCurrencyReqParams exchangeCurrencyReqParams, IResult<ExchangeResult> iResult);

    boolean isPayingStatus(@NonNull PayType payType);

    boolean isSupported(@NonNull Activity activity, @NonNull PayType payType);

    void onQQPayResult(int i2, String str);

    void onWxPayResult(int i2, String str);

    void payWithProductInfo(@NonNull Activity activity, @NonNull ChargeCurrencyReqParams chargeCurrencyReqParams, @NonNull ProductInfo productInfo, @NonNull PayType payType, int i2, int i3, int i4, IPayCallback<String> iPayCallback);

    void payWithProductInfo(@NonNull Activity activity, @NonNull ChargeCurrencyReqParams chargeCurrencyReqParams, @NonNull ProductInfo productInfo, @NonNull PayType payType, IPayCallback<String> iPayCallback);

    void queryBannerConfigRequest(@NonNull GetBannerConfigReqParams getBannerConfigReqParams, IResult<BannerConfigResult> iResult);

    void queryChargeOrderStatus(@NonNull GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, IResult<GetChargeOrderStatusResult> iResult);

    void queryMyBalance(@NonNull QueryCurrencyReqParams queryCurrencyReqParams, IResult<MyBalanceResult> iResult);

    void queryProductList(@NonNull QueryCurrencyReqParams queryCurrencyReqParams, IResult<ProductListResult> iResult);

    void queryProductListChannels(@NonNull QueryCurrencyChannelsReqParams queryCurrencyChannelsReqParams, IResult<ProductListResult> iResult);

    void queryRechargeHistory(@NonNull QueryRechargeHistoryReqParams queryRechargeHistoryReqParams, IResult<RechargeHistoryResult> iResult);

    void queryUserYbDetailsRequest(@NonNull GetUserYbDetailsReqParams getUserYbDetailsReqParams, IResult<GetUserYbDetailsResult> iResult);

    void registerPayReporter(IPayReporter iPayReporter);

    void removePayListener(IAppPayServiceListener iAppPayServiceListener);

    void reportPayEntrancePage(int i2);

    void requestPay(@NonNull Activity activity, @NonNull PayType payType, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback);
}
