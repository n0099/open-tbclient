package com.yy.mobile.framework.revenuesdk.payapi.payproxy;

import android.app.Activity;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.wallet.pay.PayActivityStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.PackageInstallUtil;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod;
import java.util.Map;
import kotlin.Metadata;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00109\u001a\u000208¢\u0006\u0004\b?\u0010>J1\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J1\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J5\u0010\u001b\u001a\u00020\t2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u001a2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ)\u0010 \u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\r2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016¢\u0006\u0004\b \u0010!JM\u0010'\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010#\u001a\u00020\"2\b\u0010\f\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\r2\u0006\u0010&\u001a\u00020\u000f2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016H\u0016¢\u0006\u0004\b'\u0010(JM\u0010'\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010#\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010\r2\b\u0010%\u001a\u0004\u0018\u00010\r2\u0006\u0010&\u001a\u00020\u000f2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016H\u0016¢\u0006\u0004\b'\u0010*JM\u0010+\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010#\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010\r2\b\u0010%\u001a\u0004\u0018\u00010\r2\u0006\u0010&\u001a\u00020\u000f2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016H\u0016¢\u0006\u0004\b+\u0010*J_\u0010/\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010#\u001a\u00020\"2\b\u0010,\u001a\u0004\u0018\u00010\r2\b\u0010-\u001a\u0004\u0018\u00010\r2\u0006\u0010.\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\r2\u0006\u0010&\u001a\u00020\u000f2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016H\u0016¢\u0006\u0004\b/\u00100J;\u00102\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"2\b\u00101\u001a\u0004\u0018\u00010\u00022\b\u0010%\u001a\u0004\u0018\u00010\r2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016H\u0002¢\u0006\u0004\b2\u00103R\u0016\u00104\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\r8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00107\u001a\u00020\r8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b7\u00105R\"\u00109\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006@"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/WechatPayProxy;", "Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/DefaultPayMethod;", "Landroid/app/Activity;", "act", "", "type", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IResult;", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/PurchaseInfo;", "iResult", "", "clearHangPayJob", "(Landroid/app/Activity;ILcom/yy/mobile/framework/revenuesdk/baseapi/IResult;)V", "info", "", "result", "", "doHangJob", "(Lcom/yy/mobile/framework/revenuesdk/payapi/bean/PurchaseInfo;Lcom/yy/mobile/framework/revenuesdk/baseapi/IResult;)Z", "isSupported", "(Landroid/app/Activity;)Z", "code", "msg", "Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;", "callback", "onPayResult", "(ILjava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "", "onProxyPayResult", "(Ljava/util/Map;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "onWxPayResult", "(ILjava/lang/String;)V", "product", "queryHistoryPurchaseByProductId", "(Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/baseapi/IResult;)Z", "", "uid", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/ProductInfo;", "payload", "isSetAccountId", "requestPay", "(Landroid/app/Activity;JLcom/yy/mobile/framework/revenuesdk/payapi/bean/ProductInfo;Ljava/lang/String;ZLcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "productId", "(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;ZLcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "requestSubscription", "oldProductId", "newProductId", "prorationMode", "updateSubscription", "(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "activity", "wxPayInterval", "(JLandroid/app/Activity;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "TAG", "Ljava/lang/String;", "errCodeKey", "errStrKey", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IWechatSdkServiceProxy;", "wxPayService", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IWechatSdkServiceProxy;", "getWxPayService", "()Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IWechatSdkServiceProxy;", "setWxPayService", "(Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IWechatSdkServiceProxy;)V", "<init>", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes6.dex */
public final class WechatPayProxy extends DefaultPayMethod {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String TAG;
    public final String errCodeKey;
    public final String errStrKey;
    public IWechatSdkServiceProxy wxPayService;

    public WechatPayProxy(IWechatSdkServiceProxy iWechatSdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iWechatSdkServiceProxy};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.wxPayService = iWechatSdkServiceProxy;
        this.TAG = "WechatPayProxy";
        this.errCodeKey = PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_CODE;
        this.errStrKey = PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_STR;
    }

    private final void onPayResult(int i2, String str, IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, str, iPayCallback) == null) {
            if (i2 == -2) {
                if (iPayCallback != null) {
                    iPayCallback.onFail(com.yy.mobile.framework.revenuesdk.payapi.PayStatus.CANCEL.getCode(), "取消支付", null);
                }
            } else if (i2 != 0) {
                if (iPayCallback != null) {
                    iPayCallback.onFail(i2, "支付异常", null);
                }
            } else if (iPayCallback != null) {
                iPayCallback.onSuccess(new PurchaseInfo("", ""), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onProxyPayResult(Map<String, String> map, IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, map, iPayCallback) == null) {
            if (map == null) {
                RLog.error(this.TAG, " onProxyPayResult null", new Object[0]);
                if (iPayCallback != null) {
                    iPayCallback.onFail(-1, "onProxyPayResult null", null);
                    return;
                }
                return;
            }
            String str = map.get(this.errCodeKey);
            Integer valueOf = str != null ? Integer.valueOf(Integer.parseInt(str)) : null;
            String str2 = map.get(this.errStrKey);
            if (valueOf != null) {
                onPayResult(valueOf.intValue(), str2, iPayCallback);
                return;
            }
            RLog.error(this.TAG, " onProxyPayResult errCode null", new Object[0]);
            if (iPayCallback != null) {
                iPayCallback.onFail(-2, "onProxyPayResult errCode null", null);
            }
        }
    }

    private final void wxPayInterval(long j, Activity activity, String str, final IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{Long.valueOf(j), activity, str, iPayCallback}) == null) {
            if (activity != null) {
                RLog.info(this.TAG, "wxPayInterval");
                this.wxPayService.sendPay(j, activity, str, new IWechatProxyCallback(this, iPayCallback) { // from class: com.yy.mobile.framework.revenuesdk.payapi.payproxy.WechatPayProxy$wxPayInterval$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ IPayCallback $callback;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WechatPayProxy this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, iPayCallback};
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
                        this.$callback = iPayCallback;
                    }

                    @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IWechatProxyCallback
                    public void onFail(String str2) {
                        String str3;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str2) == null) {
                            str3 = this.this$0.TAG;
                            RLog.error(str3, " onFail failReasonn:" + str2, new Object[0]);
                            IPayCallback iPayCallback2 = this.$callback;
                            if (iPayCallback2 != null) {
                                iPayCallback2.onFail(-1, "proxy onFail failReasonn:" + str2, null);
                            }
                        }
                    }

                    @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IWechatProxyCallback
                    public void onSuccess(Map<String, String> map) {
                        String str2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
                            str2 = this.this$0.TAG;
                            RLog.info(str2, "wxPayInterval onSuccess");
                            this.this$0.onProxyPayResult(map, this.$callback);
                        }
                    }
                });
            } else if (iPayCallback != null) {
                iPayCallback.onFail(-1, "param activity is null", null);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void clearHangPayJob(Activity activity, int i2, IResult<PurchaseInfo> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, activity, i2, iResult) == null) {
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean doHangJob(PurchaseInfo purchaseInfo, IResult<String> iResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, purchaseInfo, iResult)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final IWechatSdkServiceProxy getWxPayService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.wxPayService : (IWechatSdkServiceProxy) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean isSupported(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) ? PackageInstallUtil.isInstallWechat(activity) : invokeL.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void onWxPayResult(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
            RLog.info(this.TAG, "onWxPayResult");
            this.wxPayService.onWxPayResult(i2, str);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean queryHistoryPurchaseByProductId(String str, IResult<PurchaseInfo> iResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, iResult)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestPay(Activity activity, long j, ProductInfo productInfo, String str, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{activity, Long.valueOf(j), productInfo, str, Boolean.valueOf(z), iPayCallback}) == null) {
            wxPayInterval(j, activity, str, iPayCallback);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestSubscription(Activity activity, long j, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{activity, Long.valueOf(j), str, str2, Boolean.valueOf(z), iPayCallback}) == null) {
            RLog.error(this.TAG, "WechatPay can't requestSubscription", new Object[0]);
        }
    }

    public final void setWxPayService(IWechatSdkServiceProxy iWechatSdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iWechatSdkServiceProxy) == null) {
            this.wxPayService = iWechatSdkServiceProxy;
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void updateSubscription(Activity activity, long j, String str, String str2, int i2, String str3, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{activity, Long.valueOf(j), str, str2, Integer.valueOf(i2), str3, Boolean.valueOf(z), iPayCallback}) == null) {
            RLog.error(this.TAG, "WechatPay can't updateSubscription", new Object[0]);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestPay(Activity activity, long j, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{activity, Long.valueOf(j), str, str2, Boolean.valueOf(z), iPayCallback}) == null) {
            wxPayInterval(j, activity, str2, iPayCallback);
        }
    }
}
