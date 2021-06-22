package i.a.a.d;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.IToken;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
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
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.api.pay.IMiddlePayService;
import tv.athena.revenue.api.pay.MiddlePayStatus;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.api.pay.params.RefreshAppExpandInfo;
/* loaded from: classes8.dex */
public final class a implements IMiddlePayService {

    /* renamed from: a  reason: collision with root package name */
    public final MiddleRevenueConfig f72147a;

    /* renamed from: b  reason: collision with root package name */
    public final IAppPayService f72148b;

    /* renamed from: i.a.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C1995a implements IPayCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f72149a;

        public C1995a(IPayCallback iPayCallback) {
            this.f72149a = iPayCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(String str, PayCallBackBean payCallBackBean) {
            RLog.debug("MiddlePayService", "doPayProduct onSuccess");
            IPayCallback iPayCallback = this.f72149a;
            if (iPayCallback != null) {
                iPayCallback.onSuccess(str, payCallBackBean);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            RLog.debug("MiddlePayService", "doPayProduct onFail [code = " + i2 + ", failReason=" + str + ']');
            IPayCallback iPayCallback = this.f72149a;
            if (iPayCallback != null) {
                iPayCallback.onFail(i2, str, payCallBackBean);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            RLog.debug("MiddlePayService", "doPayProduct onPayStart");
            IPayCallback iPayCallback = this.f72149a;
            if (iPayCallback != null) {
                iPayCallback.onPayStart();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
            IPayCallback iPayCallback = this.f72149a;
            if (iPayCallback != null) {
                iPayCallback.onPayStatus(purchaseStatus, payCallBackBean);
            }
        }
    }

    public a(MiddleRevenueConfig middleRevenueConfig, IAppPayService iAppPayService) {
        this.f72147a = middleRevenueConfig;
        this.f72148b = iAppPayService;
    }

    @Override // tv.athena.revenue.api.pay.IMiddlePayService
    public void a(i.a.a.b.b.a.a aVar) {
        f(aVar.a(), aVar.h(), aVar.n(), aVar.k(), aVar.g(), aVar.o(), aVar.e(), aVar.j(), aVar.d(), aVar.i(), aVar.f(), aVar.c(), aVar.l(), aVar.b(), aVar.m());
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addAlipaySdkProxy(IAlipaySdkServiceProxy iAlipaySdkServiceProxy) {
        this.f72148b.addAlipaySdkProxy(iAlipaySdkServiceProxy);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addDxmPaySdkProxy(IDxmSdkServiceProxy iDxmSdkServiceProxy) {
        this.f72148b.addDxmPaySdkProxy(iDxmSdkServiceProxy);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addPayListener(IAppPayServiceListener iAppPayServiceListener) {
        this.f72148b.addPayListener(iAppPayServiceListener);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addWechatSdkProxy(IWechatSdkServiceProxy iWechatSdkServiceProxy) {
        this.f72148b.addWechatSdkProxy(iWechatSdkServiceProxy);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(Activity activity, PayType payType, long j, String str, ProductInfo productInfo, int i2, int i3, int i4, String str2, String str3, Map<String, Object> map, IPayCallback<String> iPayCallback, IToken iToken, AppCustomExpand appCustomExpand, String str4) {
        a aVar;
        Map<String, Object> map2;
        RLog.info("MiddlePayService", "doPayProduct");
        if (e(activity)) {
            Map<String, String> map3 = appCustomExpand != null ? appCustomExpand.appServerExpand : null;
            if ((appCustomExpand != null ? appCustomExpand.iAppServerExpand : null) != null) {
                RefreshAppExpandInfo refreshAppExpandInfo = new RefreshAppExpandInfo();
                refreshAppExpandInfo.payType = payType;
                Map<String, String> appServerExpand = (appCustomExpand != null ? appCustomExpand.iAppServerExpand : null).getAppServerExpand(refreshAppExpandInfo);
                if (appServerExpand != null) {
                    map2 = map;
                    map3 = appServerExpand;
                    aVar = this;
                    payWithProductInfo(activity, c(activity, payType, productInfo, j, str, i2, i3, str3, i4, aVar.d(map3, map2), str2, iToken, appCustomExpand != null ? appCustomExpand.appClientExpand : null, str4), productInfo, payType, 5, 3000, 10000, new C1995a(iPayCallback));
                }
            }
            aVar = this;
            map2 = map;
            payWithProductInfo(activity, c(activity, payType, productInfo, j, str, i2, i3, str3, i4, aVar.d(map3, map2), str2, iToken, appCustomExpand != null ? appCustomExpand.appClientExpand : null, str4), productInfo, payType, 5, 3000, 10000, new C1995a(iPayCallback));
        }
    }

    public final ChargeCurrencyReqParams c(Activity activity, PayType payType, ProductInfo productInfo, long j, String str, int i2, int i3, String str2, int i4, String str3, String str4, IToken iToken, Map<String, String> map, String str5) {
        ChargeCurrencyReqParams chargeCurrencyReqParams = new ChargeCurrencyReqParams();
        chargeCurrencyReqParams.setUid(j);
        chargeCurrencyReqParams.setToken(str);
        chargeCurrencyReqParams.setAppId(this.f72147a.getAppId());
        chargeCurrencyReqParams.setSid(0);
        chargeCurrencyReqParams.setUsedChannel(i2);
        chargeCurrencyReqParams.setCurrencyType(i3);
        chargeCurrencyReqParams.setClientVersion(this.f72147a.getVersion());
        chargeCurrencyReqParams.setSubscriptionType(i4);
        chargeCurrencyReqParams.setExpand(str3);
        chargeCurrencyReqParams.setReturnUrl(str2);
        chargeCurrencyReqParams.setAppClientExpand(map);
        if (str5 != null) {
            chargeCurrencyReqParams.setTraceid(str5);
        }
        chargeCurrencyReqParams.setPayType(payType);
        chargeCurrencyReqParams.setProductId(productInfo.productId);
        Double d2 = productInfo.srcAmount;
        Intrinsics.checkExpressionValueIsNotNull(d2, "info.srcAmount");
        chargeCurrencyReqParams.setSrcAmount(d2.doubleValue());
        chargeCurrencyReqParams.setCid(productInfo.cid);
        chargeCurrencyReqParams.setTokenCallback(iToken);
        if (str4.equals(IMiddlePayService.ChargeSource.WALLET_CHARGE)) {
            chargeCurrencyReqParams.setFrom(1);
        } else if (str4.equals(IMiddlePayService.ChargeSource.ROOM_CHARGE)) {
            chargeCurrencyReqParams.setFrom(2);
        } else if (str4.equals(IMiddlePayService.ChargeSource.OTHER_CHARGE)) {
            chargeCurrencyReqParams.setFrom(3);
        }
        return chargeCurrencyReqParams;
    }

    public final String d(Map<String, String> map, Map<String, Object> map2) {
        JSONObject jSONObject = new JSONObject();
        if (map2 != null) {
            try {
                if (map2.size() > 0) {
                    for (Map.Entry<String, Object> entry : map2.entrySet()) {
                        if (entry.getKey() != null && entry.getValue() != null) {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        } else {
                            RLog.info("MiddlePayService", "expandMap parse error! key or value null");
                        }
                    }
                }
            } catch (JSONException e2) {
                RLog.error("ChargeCurrencyRequest", "ExpandBuilder.toJson", e2);
            }
        }
        if (map != null && map.size() > 0) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, String> entry2 : map.entrySet()) {
                if (entry2.getKey() != null && entry2.getValue() != null) {
                    jSONObject2.put(entry2.getKey(), entry2.getValue());
                } else {
                    RLog.info("MiddlePayService", "expandMap parse error! key or value null");
                }
            }
            jSONObject.put("yyBussinessPenetrateMsg", jSONObject2);
        }
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject3, "expand.toString()");
        return jSONObject3;
    }

    public final boolean e(Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            RLog.info("MiddlePayService", "act not alive");
            return false;
        }
        return true;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void exchangeCurrency(ExchangeCurrencyReqParams exchangeCurrencyReqParams, IResult<ExchangeResult> iResult) {
        exchangeCurrencyReqParams.setAppId(this.f72147a.getAppId());
        exchangeCurrencyReqParams.setClientVersion(this.f72147a.getVersion());
        this.f72148b.exchangeCurrency(exchangeCurrencyReqParams, iResult);
    }

    public final void f(Activity activity, PayType payType, long j, String str, ProductInfo productInfo, int i2, int i3, IMiddlePayService.SubscriptType subscriptType, IMiddlePayService.ChargeSource chargeSource, String str2, Map<String, Object> map, IPayCallback<String> iPayCallback, IToken iToken, AppCustomExpand appCustomExpand, String str3) {
        if (isSupported(activity, payType)) {
            b(activity, payType, j, str, productInfo, i2, i3, subscriptType.getValue(), chargeSource.getValue(), str2, map, iPayCallback, iToken, appCustomExpand, str3);
        } else if (iPayCallback != null) {
            iPayCallback.onFail(MiddlePayStatus.NOT_SUPPORT.getCode(), MiddlePayStatus.NOT_SUPPORT.getMessage(), null);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public boolean isPayingStatus(PayType payType) {
        return this.f72148b.isPayingStatus(payType);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public boolean isSupported(Activity activity, PayType payType) {
        return this.f72148b.isSupported(activity, payType);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void onWxPayResult(int i2, String str) {
        this.f72148b.onWxPayResult(i2, str);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void payWithProductInfo(Activity activity, ChargeCurrencyReqParams chargeCurrencyReqParams, ProductInfo productInfo, PayType payType, IPayCallback<String> iPayCallback) {
        this.f72148b.payWithProductInfo(activity, chargeCurrencyReqParams, productInfo, payType, iPayCallback);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryBannerConfigRequest(GetBannerConfigReqParams getBannerConfigReqParams, IResult<BannerConfigResult> iResult) {
        this.f72148b.queryBannerConfigRequest(getBannerConfigReqParams, iResult);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryChargeOrderStatus(GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, IResult<GetChargeOrderStatusResult> iResult) {
        getChargeOrderStatusReqParams.setAppId(this.f72147a.getAppId());
        this.f72148b.queryChargeOrderStatus(getChargeOrderStatusReqParams, iResult);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryMyBalance(QueryCurrencyReqParams queryCurrencyReqParams, IResult<MyBalanceResult> iResult) {
        this.f72148b.queryMyBalance(queryCurrencyReqParams, iResult);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryProductList(QueryCurrencyReqParams queryCurrencyReqParams, IResult<ProductListResult> iResult) {
        queryCurrencyReqParams.setAppId(this.f72147a.getAppId());
        this.f72148b.queryProductList(queryCurrencyReqParams, iResult);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryProductListChannels(QueryCurrencyChannelsReqParams queryCurrencyChannelsReqParams, IResult<ProductListResult> iResult) {
        queryCurrencyChannelsReqParams.setAppId(this.f72147a.getAppId());
        this.f72148b.queryProductListChannels(queryCurrencyChannelsReqParams, iResult);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryRechargeHistory(QueryRechargeHistoryReqParams queryRechargeHistoryReqParams, IResult<RechargeHistoryResult> iResult) {
        this.f72148b.queryRechargeHistory(queryRechargeHistoryReqParams, iResult);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryUserYbDetailsRequest(GetUserYbDetailsReqParams getUserYbDetailsReqParams, IResult<GetUserYbDetailsResult> iResult) {
        getUserYbDetailsReqParams.setAppId(this.f72147a.getAppId());
        this.f72148b.queryUserYbDetailsRequest(getUserYbDetailsReqParams, iResult);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void registerPayReporter(IPayReporter iPayReporter) {
        this.f72148b.registerPayReporter(iPayReporter);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void removePayListener(IAppPayServiceListener iAppPayServiceListener) {
        this.f72148b.removePayListener(iAppPayServiceListener);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void reportPayEntrancePage(int i2) {
        this.f72148b.reportPayEntrancePage(i2);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void requestPay(Activity activity, PayType payType, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        this.f72148b.requestPay(activity, payType, str, str2, z, iPayCallback);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void payWithProductInfo(Activity activity, ChargeCurrencyReqParams chargeCurrencyReqParams, ProductInfo productInfo, PayType payType, int i2, int i3, int i4, IPayCallback<String> iPayCallback) {
        this.f72148b.payWithProductInfo(activity, chargeCurrencyReqParams, productInfo, payType, i2, i3, i4, iPayCallback);
    }
}
