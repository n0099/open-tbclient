package i.a.a.d;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes9.dex */
public final class a implements IMiddlePayService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final MiddleRevenueConfig f73227a;

    /* renamed from: b  reason: collision with root package name */
    public final IAppPayService f73228b;

    /* renamed from: i.a.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C2083a implements IPayCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f73229a;

        public C2083a(IPayCallback iPayCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iPayCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73229a = iPayCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, payCallBackBean) == null) {
                RLog.debug("MiddlePayService", "doPayProduct onSuccess");
                IPayCallback iPayCallback = this.f73229a;
                if (iPayCallback != null) {
                    iPayCallback.onSuccess(str, payCallBackBean);
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) {
                RLog.debug("MiddlePayService", "doPayProduct onFail [code = " + i2 + ", failReason=" + str + ']');
                IPayCallback iPayCallback = this.f73229a;
                if (iPayCallback != null) {
                    iPayCallback.onFail(i2, str, payCallBackBean);
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                RLog.debug("MiddlePayService", "doPayProduct onPayStart");
                IPayCallback iPayCallback = this.f73229a;
                if (iPayCallback != null) {
                    iPayCallback.onPayStart();
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
            IPayCallback iPayCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048579, this, purchaseStatus, payCallBackBean) == null) || (iPayCallback = this.f73229a) == null) {
                return;
            }
            iPayCallback.onPayStatus(purchaseStatus, payCallBackBean);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1500925971, "Li/a/a/d/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1500925971, "Li/a/a/d/a;");
        }
    }

    public a(MiddleRevenueConfig middleRevenueConfig, IAppPayService iAppPayService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {middleRevenueConfig, iAppPayService};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f73227a = middleRevenueConfig;
        this.f73228b = iAppPayService;
    }

    @Override // tv.athena.revenue.api.pay.IMiddlePayService
    public void a(i.a.a.b.b.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            f(aVar.a(), aVar.h(), aVar.n(), aVar.k(), aVar.g(), aVar.o(), aVar.e(), aVar.j(), aVar.d(), aVar.i(), aVar.f(), aVar.c(), aVar.l(), aVar.b(), aVar.m());
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addAlipaySdkProxy(IAlipaySdkServiceProxy iAlipaySdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iAlipaySdkServiceProxy) == null) {
            this.f73228b.addAlipaySdkProxy(iAlipaySdkServiceProxy);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addDxmPaySdkProxy(IDxmSdkServiceProxy iDxmSdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iDxmSdkServiceProxy) == null) {
            this.f73228b.addDxmPaySdkProxy(iDxmSdkServiceProxy);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addPayListener(IAppPayServiceListener iAppPayServiceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iAppPayServiceListener) == null) {
            this.f73228b.addPayListener(iAppPayServiceListener);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addWechatSdkProxy(IWechatSdkServiceProxy iWechatSdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iWechatSdkServiceProxy) == null) {
            this.f73228b.addWechatSdkProxy(iWechatSdkServiceProxy);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(Activity activity, PayType payType, long j, String str, ProductInfo productInfo, int i2, int i3, int i4, String str2, String str3, Map<String, Object> map, IPayCallback<String> iPayCallback, IToken iToken, AppCustomExpand appCustomExpand, String str4) {
        a aVar;
        Map<String, Object> map2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{activity, payType, Long.valueOf(j), str, productInfo, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str2, str3, map, iPayCallback, iToken, appCustomExpand, str4}) == null) {
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
                        payWithProductInfo(activity, c(activity, payType, productInfo, j, str, i2, i3, str3, i4, aVar.d(map3, map2), str2, iToken, appCustomExpand != null ? appCustomExpand.appClientExpand : null, str4), productInfo, payType, 5, 3000, 10000, new C2083a(iPayCallback));
                    }
                }
                aVar = this;
                map2 = map;
                payWithProductInfo(activity, c(activity, payType, productInfo, j, str, i2, i3, str3, i4, aVar.d(map3, map2), str2, iToken, appCustomExpand != null ? appCustomExpand.appClientExpand : null, str4), productInfo, payType, 5, 3000, 10000, new C2083a(iPayCallback));
            }
        }
    }

    public final ChargeCurrencyReqParams c(Activity activity, PayType payType, ProductInfo productInfo, long j, String str, int i2, int i3, String str2, int i4, String str3, String str4, IToken iToken, Map<String, String> map, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{activity, payType, productInfo, Long.valueOf(j), str, Integer.valueOf(i2), Integer.valueOf(i3), str2, Integer.valueOf(i4), str3, str4, iToken, map, str5})) == null) {
            ChargeCurrencyReqParams chargeCurrencyReqParams = new ChargeCurrencyReqParams();
            chargeCurrencyReqParams.setUid(j);
            chargeCurrencyReqParams.setToken(str);
            chargeCurrencyReqParams.setAppId(this.f73227a.getAppId());
            chargeCurrencyReqParams.setSid(0);
            chargeCurrencyReqParams.setUsedChannel(i2);
            chargeCurrencyReqParams.setCurrencyType(i3);
            chargeCurrencyReqParams.setClientVersion(this.f73227a.getVersion());
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
        return (ChargeCurrencyReqParams) invokeCommon.objValue;
    }

    public final String d(Map<String, String> map, Map<String, Object> map2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, map, map2)) == null) {
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
        return (String) invokeLL.objValue;
    }

    public final boolean e(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity)) == null) {
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                RLog.info("MiddlePayService", "act not alive");
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void exchangeCurrency(ExchangeCurrencyReqParams exchangeCurrencyReqParams, IResult<ExchangeResult> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, exchangeCurrencyReqParams, iResult) == null) {
            exchangeCurrencyReqParams.setAppId(this.f73227a.getAppId());
            exchangeCurrencyReqParams.setClientVersion(this.f73227a.getVersion());
            this.f73228b.exchangeCurrency(exchangeCurrencyReqParams, iResult);
        }
    }

    public final void f(Activity activity, PayType payType, long j, String str, ProductInfo productInfo, int i2, int i3, IMiddlePayService.SubscriptType subscriptType, IMiddlePayService.ChargeSource chargeSource, String str2, Map<String, Object> map, IPayCallback<String> iPayCallback, IToken iToken, AppCustomExpand appCustomExpand, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{activity, payType, Long.valueOf(j), str, productInfo, Integer.valueOf(i2), Integer.valueOf(i3), subscriptType, chargeSource, str2, map, iPayCallback, iToken, appCustomExpand, str3}) == null) {
            if (isSupported(activity, payType)) {
                b(activity, payType, j, str, productInfo, i2, i3, subscriptType.getValue(), chargeSource.getValue(), str2, map, iPayCallback, iToken, appCustomExpand, str3);
            } else if (iPayCallback != null) {
                iPayCallback.onFail(MiddlePayStatus.NOT_SUPPORT.getCode(), MiddlePayStatus.NOT_SUPPORT.getMessage(), null);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public boolean isPayingStatus(PayType payType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, payType)) == null) ? this.f73228b.isPayingStatus(payType) : invokeL.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public boolean isSupported(Activity activity, PayType payType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, activity, payType)) == null) ? this.f73228b.isSupported(activity, payType) : invokeLL.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void onWxPayResult(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i2, str) == null) {
            this.f73228b.onWxPayResult(i2, str);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void payWithProductInfo(Activity activity, ChargeCurrencyReqParams chargeCurrencyReqParams, ProductInfo productInfo, PayType payType, IPayCallback<String> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048591, this, activity, chargeCurrencyReqParams, productInfo, payType, iPayCallback) == null) {
            this.f73228b.payWithProductInfo(activity, chargeCurrencyReqParams, productInfo, payType, iPayCallback);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryBannerConfigRequest(GetBannerConfigReqParams getBannerConfigReqParams, IResult<BannerConfigResult> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, getBannerConfigReqParams, iResult) == null) {
            this.f73228b.queryBannerConfigRequest(getBannerConfigReqParams, iResult);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryChargeOrderStatus(GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, IResult<GetChargeOrderStatusResult> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, getChargeOrderStatusReqParams, iResult) == null) {
            getChargeOrderStatusReqParams.setAppId(this.f73227a.getAppId());
            this.f73228b.queryChargeOrderStatus(getChargeOrderStatusReqParams, iResult);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryMyBalance(QueryCurrencyReqParams queryCurrencyReqParams, IResult<MyBalanceResult> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, queryCurrencyReqParams, iResult) == null) {
            this.f73228b.queryMyBalance(queryCurrencyReqParams, iResult);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryProductList(QueryCurrencyReqParams queryCurrencyReqParams, IResult<ProductListResult> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, queryCurrencyReqParams, iResult) == null) {
            queryCurrencyReqParams.setAppId(this.f73227a.getAppId());
            this.f73228b.queryProductList(queryCurrencyReqParams, iResult);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryProductListChannels(QueryCurrencyChannelsReqParams queryCurrencyChannelsReqParams, IResult<ProductListResult> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, queryCurrencyChannelsReqParams, iResult) == null) {
            queryCurrencyChannelsReqParams.setAppId(this.f73227a.getAppId());
            this.f73228b.queryProductListChannels(queryCurrencyChannelsReqParams, iResult);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryRechargeHistory(QueryRechargeHistoryReqParams queryRechargeHistoryReqParams, IResult<RechargeHistoryResult> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, queryRechargeHistoryReqParams, iResult) == null) {
            this.f73228b.queryRechargeHistory(queryRechargeHistoryReqParams, iResult);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryUserYbDetailsRequest(GetUserYbDetailsReqParams getUserYbDetailsReqParams, IResult<GetUserYbDetailsResult> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, getUserYbDetailsReqParams, iResult) == null) {
            getUserYbDetailsReqParams.setAppId(this.f73227a.getAppId());
            this.f73228b.queryUserYbDetailsRequest(getUserYbDetailsReqParams, iResult);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void registerPayReporter(IPayReporter iPayReporter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iPayReporter) == null) {
            this.f73228b.registerPayReporter(iPayReporter);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void removePayListener(IAppPayServiceListener iAppPayServiceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, iAppPayServiceListener) == null) {
            this.f73228b.removePayListener(iAppPayServiceListener);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void reportPayEntrancePage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.f73228b.reportPayEntrancePage(i2);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void requestPay(Activity activity, PayType payType, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{activity, payType, str, str2, Boolean.valueOf(z), iPayCallback}) == null) {
            this.f73228b.requestPay(activity, payType, str, str2, z, iPayCallback);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void payWithProductInfo(Activity activity, ChargeCurrencyReqParams chargeCurrencyReqParams, ProductInfo productInfo, PayType payType, int i2, int i3, int i4, IPayCallback<String> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{activity, chargeCurrencyReqParams, productInfo, payType, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iPayCallback}) == null) {
            this.f73228b.payWithProductInfo(activity, chargeCurrencyReqParams, productInfo, payType, i2, i3, i4, iPayCallback);
        }
    }
}
