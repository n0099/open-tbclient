package i.a.a.d;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.IToken;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ExchangeResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetUserYbDetailsResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.RechargeHistoryResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.ExchangeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetChargeOrderStatusReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetUserYbDetailsReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyChannelsReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryRechargeHistoryReqParams;
import d.r.b.a.a.f.d.d;
import d.r.b.a.a.i.c.j;
import d.r.b.a.a.i.d.e;
import d.r.b.a.a.i.d.h;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.api.pay.IMiddlePayService;
import tv.athena.revenue.api.pay.MiddlePayStatus;
/* loaded from: classes8.dex */
public final class b implements IMiddlePayService {

    /* renamed from: a  reason: collision with root package name */
    public final MiddleRevenueConfig f68743a;

    /* renamed from: b  reason: collision with root package name */
    public final IAppPayService f68744b;

    /* loaded from: classes8.dex */
    public static final class a implements IPayCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f68745a;

        public a(IPayCallback iPayCallback) {
            this.f68745a = iPayCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(String str, d.r.b.a.a.f.b bVar) {
            d.b("MiddlePayService", "doPayProduct onSuccess");
            IPayCallback iPayCallback = this.f68745a;
            if (iPayCallback != null) {
                iPayCallback.onSuccess(str, bVar);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, d.r.b.a.a.f.b bVar) {
            d.b("MiddlePayService", "doPayProduct onFail [code = " + i2 + ", failReason=" + str + ']');
            IPayCallback iPayCallback = this.f68745a;
            if (iPayCallback != null) {
                iPayCallback.onFail(i2, str, bVar);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            d.b("MiddlePayService", "doPayProduct onPayStart");
            IPayCallback iPayCallback = this.f68745a;
            if (iPayCallback != null) {
                iPayCallback.onPayStart();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, d.r.b.a.a.f.b bVar) {
            IPayCallback iPayCallback = this.f68745a;
            if (iPayCallback != null) {
                iPayCallback.onPayStatus(purchaseStatus, bVar);
            }
        }
    }

    public b(MiddleRevenueConfig middleRevenueConfig, IAppPayService iAppPayService) {
        this.f68743a = middleRevenueConfig;
        this.f68744b = iAppPayService;
    }

    public final void a(Activity activity, PayType payType, long j, String str, j jVar, int i2, int i3, int i4, String str2, String str3, Map<String, Object> map, IPayCallback<String> iPayCallback, IToken iToken) {
        d.f("MiddlePayService", "doPayProduct");
        if (d(activity)) {
            Double d2 = jVar.f67793e;
            String str4 = jVar.A;
            Intrinsics.checkExpressionValueIsNotNull(str4, "info.productId");
            String str5 = jVar.f67794f;
            Intrinsics.checkExpressionValueIsNotNull(str5, "info.srcCurrencySymbol");
            payWithProductInfo(activity, b(activity, payType, jVar, j, str, i2, i3, str3, i4, c(1, d2, str4, str5, str2, "", map), str2, iToken), jVar, payType, 5, 3000, 10000, new a(iPayCallback));
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addAlipaySdkProxy(d.r.b.a.a.i.d.c cVar) {
        this.f68744b.addAlipaySdkProxy(cVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addDxmPaySdkProxy(e eVar) {
        this.f68744b.addDxmPaySdkProxy(eVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addPayListener(d.r.b.a.a.i.b bVar) {
        this.f68744b.addPayListener(bVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addWechatSdkProxy(h hVar) {
        this.f68744b.addWechatSdkProxy(hVar);
    }

    public final ChargeCurrencyReqParams b(Activity activity, PayType payType, j jVar, long j, String str, int i2, int i3, String str2, int i4, String str3, String str4, IToken iToken) {
        ChargeCurrencyReqParams chargeCurrencyReqParams = new ChargeCurrencyReqParams();
        chargeCurrencyReqParams.setUid(j);
        chargeCurrencyReqParams.setToken(str);
        chargeCurrencyReqParams.setAppId(this.f68743a.getAppId());
        chargeCurrencyReqParams.setSid(0);
        chargeCurrencyReqParams.setUsedChannel(i2);
        chargeCurrencyReqParams.setCurrencyType(i3);
        chargeCurrencyReqParams.setClientVersion(this.f68743a.getVersion());
        chargeCurrencyReqParams.setSubscriptionType(i4);
        chargeCurrencyReqParams.setExpand(str3);
        chargeCurrencyReqParams.setReturnUrl(str2);
        chargeCurrencyReqParams.setPayType(payType);
        chargeCurrencyReqParams.setProductId(jVar.A);
        Double d2 = jVar.f67793e;
        Intrinsics.checkExpressionValueIsNotNull(d2, "info.srcAmount");
        chargeCurrencyReqParams.setSrcAmount(d2.doubleValue());
        chargeCurrencyReqParams.setCid(jVar.f67789a);
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

    public final String c(int i2, Double d2, String str, String str2, String str3, String str4, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        if (entry.getKey() != null && entry.getValue() != null) {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        } else {
                            d.f("MiddlePayService", "expandMap parse error! key or value null");
                        }
                    }
                }
            } catch (JSONException e2) {
                d.d("ChargeCurrencyRequest", "ExpandBuilder.toJson", e2);
            }
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "expand.toString()");
        return jSONObject2;
    }

    public final boolean d(Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            d.f("MiddlePayService", "act not alive");
            return false;
        }
        return true;
    }

    @Override // tv.athena.revenue.api.pay.IMiddlePayService
    public void e(i.a.a.b.b.a.a aVar) {
        f(aVar.a(), aVar.g(), aVar.l(), aVar.j(), aVar.f(), aVar.m(), aVar.d(), aVar.i(), aVar.c(), aVar.h(), aVar.e(), aVar.b(), aVar.k());
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void exchangeCurrency(ExchangeCurrencyReqParams exchangeCurrencyReqParams, IResult<ExchangeResult> iResult) {
        exchangeCurrencyReqParams.setAppId(this.f68743a.getAppId());
        exchangeCurrencyReqParams.setClientVersion(this.f68743a.getVersion());
        this.f68744b.exchangeCurrency(exchangeCurrencyReqParams, iResult);
    }

    public final void f(Activity activity, PayType payType, long j, String str, j jVar, int i2, int i3, IMiddlePayService.SubscriptType subscriptType, IMiddlePayService.ChargeSource chargeSource, String str2, Map<String, Object> map, IPayCallback<String> iPayCallback, IToken iToken) {
        if (isSupported(activity, payType)) {
            a(activity, payType, j, str, jVar, i2, i3, subscriptType.getValue(), chargeSource.getValue(), str2, map, iPayCallback, iToken);
        } else if (iPayCallback != null) {
            iPayCallback.onFail(MiddlePayStatus.NOT_SUPPORT.getCode(), MiddlePayStatus.NOT_SUPPORT.getMessage(), null);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public boolean isPayingStatus(PayType payType) {
        return this.f68744b.isPayingStatus(payType);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public boolean isSupported(Activity activity, PayType payType) {
        return this.f68744b.isSupported(activity, payType);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void onWxPayResult(int i2, String str) {
        this.f68744b.onWxPayResult(i2, str);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void payWithProductInfo(Activity activity, ChargeCurrencyReqParams chargeCurrencyReqParams, j jVar, PayType payType, IPayCallback<String> iPayCallback) {
        this.f68744b.payWithProductInfo(activity, chargeCurrencyReqParams, jVar, payType, iPayCallback);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryChargeOrderStatus(GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, IResult<GetChargeOrderStatusResult> iResult) {
        getChargeOrderStatusReqParams.setAppId(this.f68743a.getAppId());
        this.f68744b.queryChargeOrderStatus(getChargeOrderStatusReqParams, iResult);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryMyBalance(QueryCurrencyReqParams queryCurrencyReqParams, IResult<MyBalanceResult> iResult) {
        this.f68744b.queryMyBalance(queryCurrencyReqParams, iResult);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryProductList(QueryCurrencyReqParams queryCurrencyReqParams, IResult<ProductListResult> iResult) {
        queryCurrencyReqParams.setAppId(this.f68743a.getAppId());
        this.f68744b.queryProductList(queryCurrencyReqParams, iResult);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryProductListChannels(QueryCurrencyChannelsReqParams queryCurrencyChannelsReqParams, IResult<ProductListResult> iResult) {
        queryCurrencyChannelsReqParams.setAppId(this.f68743a.getAppId());
        this.f68744b.queryProductListChannels(queryCurrencyChannelsReqParams, iResult);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryRechargeHistory(QueryRechargeHistoryReqParams queryRechargeHistoryReqParams, IResult<RechargeHistoryResult> iResult) {
        this.f68744b.queryRechargeHistory(queryRechargeHistoryReqParams, iResult);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryUserYbDetailsRequest(GetUserYbDetailsReqParams getUserYbDetailsReqParams, IResult<GetUserYbDetailsResult> iResult) {
        getUserYbDetailsReqParams.setAppId(this.f68743a.getAppId());
        this.f68744b.queryUserYbDetailsRequest(getUserYbDetailsReqParams, iResult);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void registerPayReporter(d.r.b.a.a.i.f.a aVar) {
        this.f68744b.registerPayReporter(aVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void removePayListener(d.r.b.a.a.i.b bVar) {
        this.f68744b.removePayListener(bVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void reportPayEntrancePage(int i2) {
        this.f68744b.reportPayEntrancePage(i2);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void requestPay(Activity activity, PayType payType, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        this.f68744b.requestPay(activity, payType, str, str2, z, iPayCallback);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void payWithProductInfo(Activity activity, ChargeCurrencyReqParams chargeCurrencyReqParams, j jVar, PayType payType, int i2, int i3, int i4, IPayCallback<String> iPayCallback) {
        this.f68744b.payWithProductInfo(activity, chargeCurrencyReqParams, jVar, payType, i2, i3, i4, iPayCallback);
    }
}
