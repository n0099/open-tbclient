package com.yy.mobile.framework.revenuesdk.payapi.payproxy;

import android.app.Activity;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.dlna.DlnaManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.wallet.YYPayManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.yy.mobile.framework.revenuesdk.baseapi.PayFailMsg;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.PackageInstallUtil;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod;
import java.util.Map;
import kotlin.Metadata;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b.\u0010-J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u0013\u001a\u00020\u000e2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016JE\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJE\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u001fJ;\u0010!\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002¢\u0006\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\t8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b%\u0010$R\u0016\u0010&\u001a\u00020\t8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b&\u0010$R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/WechatPayProxy;", "Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/DefaultPayMethod;", "Landroid/app/Activity;", "act", "", "isSupported", "(Landroid/app/Activity;)Z", "", "code", "", "msg", "Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/PurchaseInfo;", WebChromeClient.KEY_ARG_CALLBACK, "", "onPayResult", "(ILjava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "", TiebaStatic.LogFields.RESULT, "onProxyPayResult", "(Ljava/util/Map;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "onWxPayResult", "(ILjava/lang/String;)V", "", "uid", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/ProductInfo;", "info", "payload", "requestPay", "(Landroid/app/Activity;JLcom/yy/mobile/framework/revenuesdk/payapi/bean/ProductInfo;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "productId", "(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "activity", "wxPayInterval", "(JLandroid/app/Activity;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "TAG", "Ljava/lang/String;", "errCodeKey", "errStrKey", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IWechatSdkServiceProxy;", "wxPayService", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IWechatSdkServiceProxy;", "getWxPayService", "()Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IWechatSdkServiceProxy;", "setWxPayService", "(Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IWechatSdkServiceProxy;)V", "<init>", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.wxPayService = iWechatSdkServiceProxy;
        this.TAG = "WechatPayProxy";
        this.errCodeKey = YYPayManager.KEY_WX_RECHARGE_RESULT_ERROR_CODE;
        this.errStrKey = YYPayManager.KEY_WX_RECHARGE_RESULT_ERROR_STR;
    }

    private final void onPayResult(int i, String str, IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, this, i, str, iPayCallback) == null) {
            if (i == -2) {
                if (iPayCallback != null) {
                    iPayCallback.onFail(com.yy.mobile.framework.revenuesdk.payapi.PayStatus.CANCEL.getCode(), "取消支付", null);
                }
            } else if (i != 0) {
                if (iPayCallback != null) {
                    iPayCallback.onFail(i, PayFailMsg.THIRD_PARTY_CALLBACK_OTHER_STATE, null);
                }
            } else if (iPayCallback != null) {
                iPayCallback.onSuccess(new PurchaseInfo("", ""), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onProxyPayResult(Map<String, String> map, IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, map, iPayCallback) == null) {
            if (map == null) {
                RLog.error(this.TAG, " onProxyPayResult null", new Object[0]);
                if (iPayCallback != null) {
                    iPayCallback.onFail(DlnaManager.DLNA_SUB_ERROR_NETWORK_NOT_WIFI, PayFailMsg.FAILED_PARSE_THIRD_PARTY_CALLBACK, null);
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
                iPayCallback.onFail(DlnaManager.DLNA_SUB_ERROR_NETWORK_UNREACHABLE, PayFailMsg.FAILED_PARSE_THIRD_PARTY_CALLBACK, null);
            }
        }
    }

    private final void wxPayInterval(long j, Activity activity, String str, final IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{Long.valueOf(j), activity, str, iPayCallback}) == null) {
            if (activity == null) {
                RLog.error(this.TAG, "pay failed params activity null", new Object[0]);
                if (iPayCallback != null) {
                    iPayCallback.onFail(-1008, PayFailMsg.FAILED_CALL_THIRD_PARTY_SDK, null);
                    return;
                }
                return;
            }
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                            iPayCallback2.onFail(-1005, PayFailMsg.FAILED_CALL_THIRD_PARTY_SDK, null);
                        }
                    }
                }

                @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IWechatProxyCallback
                public void onSuccess(Map<String, String> map) {
                    String str2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
                        str2 = this.this$0.TAG;
                        RLog.info(str2, "wxPayInterval onSuccess result:" + map);
                        this.this$0.onProxyPayResult(map, this.$callback);
                    }
                }
            });
        }
    }

    public final IWechatSdkServiceProxy getWxPayService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.wxPayService : (IWechatSdkServiceProxy) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean isSupported(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) ? PackageInstallUtil.isInstallWechat(activity) : invokeL.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void onWxPayResult(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
            RLog.info(this.TAG, "onWxPayResult");
            this.wxPayService.onWxPayResult(i, str);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestPay(Activity activity, long j, ProductInfo productInfo, String str, IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{activity, Long.valueOf(j), productInfo, str, iPayCallback}) == null) {
            wxPayInterval(j, activity, str, iPayCallback);
        }
    }

    public final void setWxPayService(IWechatSdkServiceProxy iWechatSdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iWechatSdkServiceProxy) == null) {
            this.wxPayService = iWechatSdkServiceProxy;
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestPay(Activity activity, long j, String str, String str2, IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{activity, Long.valueOf(j), str, str2, iPayCallback}) == null) {
            wxPayInterval(j, activity, str2, iPayCallback);
        }
    }
}
