package com.repackage;

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
import com.yy.mobile.framework.revenuesdk.payapi.PayStatus;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetChargeOrderStatusReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.statistics.IPayServiceStatistics;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.api.pay.IMiddlePayService;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.api.pay.params.RefreshAppExpandInfo;
/* loaded from: classes7.dex */
public final class vz9 implements IMiddlePayService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MiddleRevenueConfig a;
    public final IAppPayService b;

    /* loaded from: classes7.dex */
    public static final class a implements IPayCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IPayCallback a;

        public a(IPayCallback iPayCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iPayCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iPayCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, payCallBackBean) == null) {
                RLog.debug("MiddlePayService", "doPayProduct onSuccess");
                IPayCallback iPayCallback = this.a;
                if (iPayCallback != null) {
                    iPayCallback.onSuccess(str, payCallBackBean);
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) {
                RLog.debug("MiddlePayService", "doPayProduct onFail [code = " + i + ", failReason=" + str + ']');
                IPayCallback iPayCallback = this.a;
                if (iPayCallback != null) {
                    iPayCallback.onFail(i, str, payCallBackBean);
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                RLog.debug("MiddlePayService", "doPayProduct onPayStart");
                IPayCallback iPayCallback = this.a;
                if (iPayCallback != null) {
                    iPayCallback.onPayStart();
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
            IPayCallback iPayCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048579, this, purchaseStatus, payCallBackBean) == null) || (iPayCallback = this.a) == null) {
                return;
            }
            iPayCallback.onPayStatus(purchaseStatus, payCallBackBean);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755213732, "Lcom/repackage/vz9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755213732, "Lcom/repackage/vz9;");
        }
    }

    public vz9(MiddleRevenueConfig middleRevenueConfig, IAppPayService iAppPayService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {middleRevenueConfig, iAppPayService};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = middleRevenueConfig;
        this.b = iAppPayService;
    }

    @Override // tv.athena.revenue.api.pay.IMiddlePayService
    public void a(qz9 qz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qz9Var) == null) {
            g(qz9Var.getActivity(), qz9Var.h(), qz9Var.n(), qz9Var.k(), qz9Var.f(), qz9Var.o(), qz9Var.d(), qz9Var.j(), qz9Var.c(), qz9Var.i(), qz9Var.e(), qz9Var.b(), qz9Var.l(), qz9Var.a(), qz9Var.m(), qz9Var.g());
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void addPayListener(IAppPayServiceListener iAppPayServiceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iAppPayServiceListener) == null) {
            this.b.addPayListener(iAppPayServiceListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(Activity activity, PayType payType, long j, String str, ProductInfo productInfo, int i, int i2, int i3, String str2, String str3, Map<String, Object> map, IPayCallback<String> iPayCallback, IToken iToken, AppCustomExpand appCustomExpand, String str4, int i4) {
        vz9 vz9Var;
        Map<String, Object> map2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, payType, Long.valueOf(j), str, productInfo, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2, str3, map, iPayCallback, iToken, appCustomExpand, str4, Integer.valueOf(i4)}) == null) {
            RLog.info("MiddlePayService", "doPayProduct");
            if (f(activity)) {
                Map<String, String> map3 = appCustomExpand != null ? appCustomExpand.appServerExpand : null;
                if ((appCustomExpand != null ? appCustomExpand.iAppServerExpand : null) != null) {
                    RefreshAppExpandInfo refreshAppExpandInfo = new RefreshAppExpandInfo();
                    refreshAppExpandInfo.payType = payType;
                    Map<String, String> appServerExpand = (appCustomExpand != null ? appCustomExpand.iAppServerExpand : null).getAppServerExpand(refreshAppExpandInfo);
                    if (appServerExpand != null) {
                        map2 = map;
                        map3 = appServerExpand;
                        vz9Var = this;
                        String d = vz9Var.d(map3, map2);
                        RLog.info("MiddlePayService", "doPayProduct params expand:" + d);
                        payWithProductInfo(activity, c(payType, productInfo, j, str, i, i2, str3, i3, d, str2, iToken, appCustomExpand != null ? appCustomExpand.appClientExpand : null, str4, i4), productInfo, payType, 5, 3000, 10000, new a(iPayCallback));
                    }
                }
                vz9Var = this;
                map2 = map;
                String d2 = vz9Var.d(map3, map2);
                RLog.info("MiddlePayService", "doPayProduct params expand:" + d2);
                payWithProductInfo(activity, c(payType, productInfo, j, str, i, i2, str3, i3, d2, str2, iToken, appCustomExpand != null ? appCustomExpand.appClientExpand : null, str4, i4), productInfo, payType, 5, 3000, 10000, new a(iPayCallback));
            }
        }
    }

    public final ChargeCurrencyReqParams c(PayType payType, ProductInfo productInfo, long j, String str, int i, int i2, String str2, int i3, String str3, String str4, IToken iToken, Map<String, String> map, String str5, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{payType, productInfo, Long.valueOf(j), str, Integer.valueOf(i), Integer.valueOf(i2), str2, Integer.valueOf(i3), str3, str4, iToken, map, str5, Integer.valueOf(i4)})) == null) {
            ChargeCurrencyReqParams chargeCurrencyReqParams = new ChargeCurrencyReqParams();
            chargeCurrencyReqParams.setUid(j);
            chargeCurrencyReqParams.setToken(str);
            chargeCurrencyReqParams.setAppId(this.a.getAppId());
            chargeCurrencyReqParams.setSid(0);
            chargeCurrencyReqParams.setUsedChannel(i);
            chargeCurrencyReqParams.setCurrencyType(i2);
            chargeCurrencyReqParams.setClientVersion(this.a.getVersion());
            chargeCurrencyReqParams.setSubscriptionType(i3);
            chargeCurrencyReqParams.setExpand(str3);
            chargeCurrencyReqParams.setReturnUrl(str2);
            chargeCurrencyReqParams.setAppClientExpand(map);
            if (str5 != null) {
                chargeCurrencyReqParams.setTraceid(str5);
            }
            chargeCurrencyReqParams.setPayType(payType);
            chargeCurrencyReqParams.setProductId(productInfo.productId);
            chargeCurrencyReqParams.setSrcAmount(productInfo.srcAmount);
            chargeCurrencyReqParams.setCid(productInfo.cid);
            chargeCurrencyReqParams.setTokenCallback(iToken);
            chargeCurrencyReqParams.setPayFlowTypeId(i4);
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

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void cancelAllRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.cancelAllRequest();
        }
    }

    public final String d(Map<String, String> map, Map<String, Object> map2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, map, map2)) == null) {
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
                } catch (JSONException e) {
                    RLog.error("MiddlePayService", "ChargeCurrencyRequest JSONException" + e.getLocalizedMessage(), new Object[0]);
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

    public final String e(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, map)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                try {
                    if (map.size() > 0) {
                        for (Map.Entry<String, Object> entry : map.entrySet()) {
                            if (entry.getKey() != null && entry.getValue() != null) {
                                jSONObject.put(entry.getKey(), entry.getValue());
                            } else {
                                RLog.info("MiddlePayService", "getQueryProductListExpand parse error! key or value null");
                            }
                        }
                    }
                } catch (JSONException e) {
                    RLog.error("MiddlePayService", "getQueryProductListExpand JSONException:" + e.getLocalizedMessage(), new Object[0]);
                }
            }
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "expand.toString()");
            return jSONObject2;
        }
        return (String) invokeL.objValue;
    }

    public final boolean f(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, activity)) == null) {
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                RLog.info("MiddlePayService", "act not alive");
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void g(Activity activity, PayType payType, long j, String str, ProductInfo productInfo, int i, int i2, IMiddlePayService.SubscriptType subscriptType, IMiddlePayService.ChargeSource chargeSource, String str2, Map<String, Object> map, IPayCallback<String> iPayCallback, IToken iToken, AppCustomExpand appCustomExpand, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{activity, payType, Long.valueOf(j), str, productInfo, Integer.valueOf(i), Integer.valueOf(i2), subscriptType, chargeSource, str2, map, iPayCallback, iToken, appCustomExpand, str3, Integer.valueOf(i3)}) == null) {
            if (!isSupported(activity, payType)) {
                if (iPayCallback != null) {
                    iPayCallback.onFail(PayStatus.DEVICE_NOT_SUPPORT.getCode(), PayStatus.DEVICE_NOT_SUPPORT.getMessage(), null);
                }
                RLog.error("MiddlePayService", "当前不支持该种支付方式,是否正确接入第三方支付SDK实现?", new Object[0]);
                return;
            }
            b(activity, payType, j, str, productInfo, i, i2, subscriptType.getValue(), chargeSource.getValue(), str2, map, iPayCallback, iToken, appCustomExpand, str3, i3);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public IPayServiceStatistics getPayServiceStatistics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            IPayServiceStatistics payServiceStatistics = this.b.getPayServiceStatistics();
            Intrinsics.checkExpressionValueIsNotNull(payServiceStatistics, "payService.payServiceStatistics");
            return payServiceStatistics;
        }
        return (IPayServiceStatistics) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public boolean isSupported(Activity activity, PayType payType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, activity, payType)) == null) ? this.b.isSupported(activity, payType) : invokeLL.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void onQQPayResult(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i, str) == null) {
            this.b.onQQPayResult(i, str);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void onWxPayResult(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, str) == null) {
            this.b.onWxPayResult(i, str);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void payWithProductInfo(Activity activity, ChargeCurrencyReqParams chargeCurrencyReqParams, ProductInfo productInfo, PayType payType, int i, int i2, int i3, IPayCallback<String> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{activity, chargeCurrencyReqParams, productInfo, payType, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iPayCallback}) == null) {
            this.b.payWithProductInfo(activity, chargeCurrencyReqParams, productInfo, payType, i, i2, i3, iPayCallback);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryBannerConfigRequest(GetBannerConfigReqParams getBannerConfigReqParams, IResult<BannerConfigResult> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, getBannerConfigReqParams, iResult) == null) {
            this.b.queryBannerConfigRequest(getBannerConfigReqParams, iResult);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryChargeOrderStatus(GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, IResult<GetChargeOrderStatusResult> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, getChargeOrderStatusReqParams, iResult) == null) {
            getChargeOrderStatusReqParams.setAppId(this.a.getAppId());
            this.b.queryChargeOrderStatus(getChargeOrderStatusReqParams, iResult);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryMyBalance(QueryCurrencyReqParams queryCurrencyReqParams, IResult<MyBalanceResult> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, queryCurrencyReqParams, iResult) == null) {
            this.b.queryMyBalance(queryCurrencyReqParams, iResult);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void queryProductList(QueryCurrencyReqParams queryCurrencyReqParams, IResult<ProductListResult> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, queryCurrencyReqParams, iResult) == null) {
            queryCurrencyReqParams.setAppId(this.a.getAppId());
            queryCurrencyReqParams.setExpand(e(queryCurrencyReqParams.getExpandMap()));
            RLog.info("MiddlePayService", "queryProductList params expand:" + queryCurrencyReqParams.getExpand());
            this.b.queryProductList(queryCurrencyReqParams, iResult);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void registerPayServiceStatistics(IPayServiceStatistics iPayServiceStatistics) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, iPayServiceStatistics) == null) {
            this.b.registerPayServiceStatistics(iPayServiceStatistics);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void removePayListener(IAppPayServiceListener iAppPayServiceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, iAppPayServiceListener) == null) {
            this.b.removePayListener(iAppPayServiceListener);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayService
    public void requestPay(Activity activity, PayType payType, String str, String str2, IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048596, this, activity, payType, str, str2, iPayCallback) == null) {
            this.b.requestPay(activity, payType, str, str2, iPayCallback);
        }
    }
}
