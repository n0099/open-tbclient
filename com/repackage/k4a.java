package com.repackage;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.BannerConfigItem;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import org.json.JSONObject;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.model.NativeOperationParams;
import tv.athena.revenue.payui.model.PayFlowModel;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes6.dex */
public class k4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements IPayCallback<CurrencyChargeMessage> {
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
        public void onSuccess(CurrencyChargeMessage currencyChargeMessage, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, currencyChargeMessage, payCallBackBean) == null) {
                RLog.debug("PayWebViewCallHelper", "onSuccess");
                IPayCallback iPayCallback = this.a;
                if (iPayCallback != null) {
                    iPayCallback.onSuccess(currencyChargeMessage, payCallBackBean);
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) {
                RLog.debug("PayWebViewCallHelper", "onFail code:" + i + " failReason:" + str);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                RLog.debug("PayWebViewCallHelper", "onPayStart");
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, purchaseStatus, payCallBackBean) == null) {
                RLog.debug("PayWebViewCallHelper", "onPayStatus");
            }
        }
    }

    public static void a(int i, int i2, PayFlowType payFlowType, NativeOperationParams nativeOperationParams) {
        AbsViewEventHandler absViewEventHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), payFlowType, nativeOperationParams}) == null) {
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(i, i2);
            if (uIKit == null) {
                RLog.error("PayWebViewCallHelper", "onNativeOperation null yyPayUIKit", new Object[0]);
            } else if (nativeOperationParams.params == null) {
                RLog.error("PayWebViewCallHelper", "onNativeOperation error h5 params null", new Object[0]);
            } else {
                BannerConfigItem.BannerInfo bannerInfo = new BannerConfigItem.BannerInfo();
                try {
                    JSONObject jSONObject = new JSONObject(nativeOperationParams.params);
                    bannerInfo.id = jSONObject.optString("id");
                    bannerInfo.jumpType = jSONObject.optInt("jumpType");
                    bannerInfo.jumpData = jSONObject.optString("jumpData", "");
                    bannerInfo.imageUrl = jSONObject.optString("imageUrl", "");
                    PayFlowModel payFlowModel = uIKit.getPayFlowModel(payFlowType);
                    if (payFlowModel != null && (absViewEventHandler = payFlowModel.viewEventListener) != null) {
                        absViewEventHandler.onBannerClick(bannerInfo);
                    } else {
                        RLog.error("PayWebViewCallHelper", "onNativeOperation error h5PayFlowModel null", new Object[0]);
                    }
                } catch (Exception e) {
                    RLog.error("PayWebViewCallHelper", "get bannerInfo error:", e.getLocalizedMessage());
                }
            }
        }
    }

    public static void b(int i, int i2, Activity activity, NativeOperationParams nativeOperationParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), activity, nativeOperationParams, iPayCallback}) == null) {
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(i, i2);
            if (uIKit == null) {
                RLog.error("PayWebViewCallHelper", "onNativeOperation null yyPayUIKit", new Object[0]);
            } else if (nativeOperationParams.params == null) {
                RLog.error("PayWebViewCallHelper", "onNativeOperation error h5 params null", new Object[0]);
            } else {
                ProductInfo productInfo = new ProductInfo();
                try {
                    JSONObject jSONObject = new JSONObject(nativeOperationParams.params);
                    productInfo.cid = jSONObject.optInt("cid");
                    productInfo.productId = jSONObject.optString(AdUploadHttpRequest.KEY_PRODUCT_ID, "");
                    productInfo.srcCurrencySymbol = jSONObject.optString("srcCurrencySymbol", "");
                    productInfo.destAmount = jSONObject.optInt("destAmount");
                    productInfo.srcAmount = jSONObject.optDouble("srcAmount", 0.0d);
                    IYYPayWayView.b bVar = new IYYPayWayView.b();
                    PayUIKitConfig payUIKitConfig = uIKit.getPayUIKitConfig();
                    MiddleRevenueConfig middleRevenueConfig = payUIKitConfig != null ? payUIKitConfig.revenueConfig : null;
                    if (middleRevenueConfig != null) {
                        bVar.b = new y5a(productInfo, middleRevenueConfig.getCurrencyType());
                    } else {
                        bVar.b = new y5a(productInfo);
                    }
                    RLog.info("PayWebViewCallHelper", "startPayChannelDialog: payAmount:%s", bVar.b);
                    uIKit.startPayChannelDialog(activity, bVar, new a(iPayCallback));
                } catch (Exception e) {
                    RLog.error("PayWebViewCallHelper", "get productInfo error:", e.getLocalizedMessage());
                }
            }
        }
    }

    public static void c(int i, int i2, PayFlowType payFlowType, NativeOperationParams nativeOperationParams) {
        AbsViewEventHandler absViewEventHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), payFlowType, nativeOperationParams}) == null) {
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(i, i2);
            if (uIKit == null) {
                RLog.error("PayWebViewCallHelper", "onNativeOperation null yyPayUIKit", new Object[0]);
                return;
            }
            PayFlowModel payFlowModel = uIKit.getPayFlowModel(payFlowType);
            if (payFlowModel != null && (absViewEventHandler = payFlowModel.viewEventListener) != null) {
                absViewEventHandler.onHandleUrl(nativeOperationParams.params);
            } else {
                RLog.error("PayWebViewCallHelper", "onNativeOperation error h5PayFlowModel null", new Object[0]);
            }
        }
    }
}
