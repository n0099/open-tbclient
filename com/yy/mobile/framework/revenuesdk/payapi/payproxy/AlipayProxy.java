package com.yy.mobile.framework.revenuesdk.payapi.payproxy;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.util.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.dlna.DlnaManager;
import com.baidu.platform.comapi.map.NodeType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.sina.weibo.sdk.utils.WbAuthConstants;
import com.yy.mobile.framework.revenuesdk.baseapi.PayFailMsg;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod;
import com.yy.mobile.framework.revenuesdk.payapi.utils.JsonUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b,\u0010+J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJE\u0010\u0016\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017JE\u0010\u0016\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0019J\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010!\u001a\u00020 2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001eH\u0002¢\u0006\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/AlipayProxy;", "Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/DefaultPayMethod;", "Landroid/app/Activity;", "act", "", "isSupported", "(Landroid/app/Activity;)Z", "", j.a, "Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/PurchaseInfo;", WebChromeClient.KEY_ARG_CALLBACK, "", "onPayResult", "(Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "result", "onProxyPayResult", "", "uid", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/ProductInfo;", "info", "payload", "requestPay", "(Landroid/app/Activity;JLcom/yy/mobile/framework/revenuesdk/payapi/bean/ProductInfo;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "productId", "(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "aliRecharge", "Lorg/json/JSONObject;", "splitPayResult", "(Ljava/lang/String;)Lorg/json/JSONObject;", "", "rawResult", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/PayResult;", "transToPayResult", "(Ljava/util/Map;)Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/PayResult;", "TAG", "Ljava/lang/String;", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IAlipaySdkServiceProxy;", "alipayServiceService", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IAlipaySdkServiceProxy;", "getAlipayServiceService", "()Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IAlipaySdkServiceProxy;", "setAlipayServiceService", "(Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IAlipaySdkServiceProxy;)V", "<init>", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class AlipayProxy extends DefaultPayMethod {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String TAG;
    public IAlipaySdkServiceProxy alipayServiceService;

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean isSupported(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public AlipayProxy(IAlipaySdkServiceProxy iAlipaySdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iAlipaySdkServiceProxy};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.alipayServiceService = iAlipaySdkServiceProxy;
        this.TAG = "AlipayProxy";
    }

    public final void setAlipayServiceService(IAlipaySdkServiceProxy iAlipaySdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iAlipaySdkServiceProxy) == null) {
            this.alipayServiceService = iAlipaySdkServiceProxy;
        }
    }

    private final void onPayResult(String str, IPayCallback<PurchaseInfo> iPayCallback) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, iPayCallback) == null) {
            switch (str.hashCode()) {
                case 1596796:
                    if (str.equals("4000")) {
                        if (iPayCallback != null) {
                            iPayCallback.onFail(4000, "订单支付失败", null);
                            return;
                        }
                        return;
                    }
                    break;
                case 1626587:
                    if (str.equals("5000")) {
                        if (iPayCallback != null) {
                            iPayCallback.onFail(5000, "重复请求", null);
                            return;
                        }
                        return;
                    }
                    break;
                case 1656379:
                    if (str.equals("6001")) {
                        if (iPayCallback != null) {
                            iPayCallback.onFail(com.yy.mobile.framework.revenuesdk.payapi.PayStatus.CANCEL.getCode(), "取消支付", null);
                            return;
                        }
                        return;
                    }
                    break;
                case 1656380:
                    if (str.equals("6002")) {
                        if (iPayCallback != null) {
                            iPayCallback.onFail(NodeType.E_TRAFFIC_UGC, "网络连接出错", null);
                            return;
                        }
                        return;
                    }
                    break;
                case 1656382:
                    if (str.equals("6004")) {
                        if (iPayCallback != null) {
                            iPayCallback.onFail(6004, "支付结果未知", null);
                            return;
                        }
                        return;
                    }
                    break;
                case 1715960:
                    if (str.equals(WbAuthConstants.AUTH_FAILED_NOT_INSTALL_CODE)) {
                        if (iPayCallback != null) {
                            iPayCallback.onFail(8000, "正在处理中", null);
                            return;
                        }
                        return;
                    }
                    break;
                case 1745751:
                    if (str.equals("9000")) {
                        if (iPayCallback != null) {
                            iPayCallback.onSuccess(new PurchaseInfo("", ""), null);
                            return;
                        }
                        return;
                    }
                    break;
            }
            Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
            if (intOrNull != null) {
                i = intOrNull.intValue();
            } else {
                i = -1;
            }
            if (iPayCallback != null) {
                iPayCallback.onFail(i, PayFailMsg.THIRD_PARTY_CALLBACK_OTHER_STATE, null);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.yy.mobile.framework.revenuesdk.payapi.payproxy.AlipayProxy */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void onProxyPayResult(String str, IPayCallback<PurchaseInfo> iPayCallback) {
        Map<String, Object> mapForJson;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, str, iPayCallback) == null) {
            if (str == null) {
                RLog.error(this.TAG, "onPayResult result null", new Object[0]);
                if (iPayCallback != null) {
                    iPayCallback.onFail(-2002, PayFailMsg.FAILED_PARSE_THIRD_PARTY_CALLBACK, null);
                    return;
                }
                return;
            }
            try {
                mapForJson = JsonUtils.getMapForJson(str);
            } catch (Exception unused) {
                RLog.debug(this.TAG, "getMapForJson exception split");
                JSONObject splitPayResult = splitPayResult(str);
                if (splitPayResult == null) {
                    RLog.error(this.TAG, "onPayResult jsonResultString null", new Object[0]);
                    if (iPayCallback != null) {
                        iPayCallback.onFail(-2003, PayFailMsg.FAILED_PARSE_THIRD_PARTY_CALLBACK, null);
                        return;
                    }
                    return;
                }
                mapForJson = JsonUtils.getMapForJson(splitPayResult.toString());
                if (mapForJson == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                }
            }
            if (mapForJson == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            } else if (mapForJson == null) {
                if (iPayCallback != null) {
                    iPayCallback.onFail(-2004, PayFailMsg.FAILED_PARSE_THIRD_PARTY_CALLBACK, null);
                }
            } else {
                PayResult transToPayResult = transToPayResult(mapForJson);
                if (transToPayResult != null) {
                    String resultStatus = transToPayResult.getResultStatus();
                    if (resultStatus == null) {
                        Intrinsics.throwNpe();
                    }
                    onPayResult(resultStatus, iPayCallback);
                } else if (iPayCallback != null) {
                    iPayCallback.onFail(-2005, PayFailMsg.FAILED_PARSE_THIRD_PARTY_CALLBACK, null);
                }
            }
        }
    }

    private final JSONObject splitPayResult(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            String str3 = this.TAG;
            RLog.debug(str3, "aliRechargeResult " + str);
            if (str == null) {
                return null;
            }
            List<String> split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{";"}, false, 0, 6, (Object) null);
            JSONObject jSONObject = new JSONObject();
            for (String str4 : split$default) {
                List split$default2 = StringsKt__StringsKt.split$default((CharSequence) str4, new String[]{"="}, false, 0, 6, (Object) null);
                if (split$default2.size() > 1) {
                    String str5 = (String) split$default2.get(1);
                    if (str5.length() > 2) {
                        int length = str5.length() - 1;
                        if (str5 != null) {
                            str2 = str5.substring(1, length);
                            Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                    } else {
                        str2 = "";
                    }
                    jSONObject.put((String) split$default2.get(0), str2);
                }
            }
            String str6 = this.TAG;
            RLog.debug(str6, "aliRechargeResult " + jSONObject);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    private final PayResult transToPayResult(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, map)) == null) {
            PayResult payResult = new PayResult("-1", "失败", "");
            if (map != null) {
                for (String str : map.keySet()) {
                    if (TextUtils.equals(str, j.a)) {
                        payResult.setResultStatus(map.get(str));
                    } else if (TextUtils.equals(str, "result")) {
                        payResult.setResult(map.get(str));
                    } else if (TextUtils.equals(str, j.b)) {
                        payResult.setMemo(map.get(str));
                    }
                }
            }
            return payResult;
        }
        return (PayResult) invokeL.objValue;
    }

    public final IAlipaySdkServiceProxy getAlipayServiceService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.alipayServiceService;
        }
        return (IAlipaySdkServiceProxy) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestPay(Activity activity, long j, ProductInfo productInfo, String str, final IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, Long.valueOf(j), productInfo, str, iPayCallback}) == null) {
            RLog.info(this.TAG, "requestPay1");
            if (activity == null) {
                RLog.error(this.TAG, "pay failed params activity null", new Object[0]);
                if (iPayCallback != null) {
                    iPayCallback.onFail(DlnaManager.DLNA_ERROR_GET_POSITION_INFO_ACTION_NOT_FOUND, PayFailMsg.FAILED_CALL_THIRD_PARTY_SDK, null);
                    return;
                }
                return;
            }
            this.alipayServiceService.sendPay(j, activity, str, new IAlipayProxyCallback(this, iPayCallback) { // from class: com.yy.mobile.framework.revenuesdk.payapi.payproxy.AlipayProxy$requestPay$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ IPayCallback $callback;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AlipayProxy this$0;

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

                @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IAlipayProxyCallback
                public void onFail(String str2) {
                    String str3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str2) == null) {
                        str3 = this.this$0.TAG;
                        RLog.error(str3, "onFail1 failReasonn:" + str2, new Object[0]);
                        IPayCallback iPayCallback2 = this.$callback;
                        if (iPayCallback2 != null) {
                            iPayCallback2.onFail(-1000, PayFailMsg.FAILED_CALL_THIRD_PARTY_SDK, null);
                        }
                    }
                }

                @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IAlipayProxyCallback
                public void onSuccess(String str2) {
                    String str3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                        str3 = this.this$0.TAG;
                        RLog.info(str3, "onSuccess1 result:" + str2);
                        this.this$0.onProxyPayResult(str2, this.$callback);
                    }
                }
            });
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestPay(Activity activity, long j, String str, String str2, final IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{activity, Long.valueOf(j), str, str2, iPayCallback}) == null) {
            RLog.info(this.TAG, "requestPay2");
            if (activity == null) {
                RLog.error(this.TAG, "pay failed params activity null", new Object[0]);
                if (iPayCallback != null) {
                    iPayCallback.onFail(-1010, PayFailMsg.FAILED_CALL_THIRD_PARTY_SDK, null);
                    return;
                }
                return;
            }
            this.alipayServiceService.sendPay(j, activity, str2, new IAlipayProxyCallback(this, iPayCallback) { // from class: com.yy.mobile.framework.revenuesdk.payapi.payproxy.AlipayProxy$requestPay$2
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ IPayCallback $callback;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AlipayProxy this$0;

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

                @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IAlipayProxyCallback
                public void onFail(String str3) {
                    String str4;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str3) == null) {
                        str4 = this.this$0.TAG;
                        RLog.error(str4, "onFail2 failReasonn:" + str3, new Object[0]);
                        IPayCallback iPayCallback2 = this.$callback;
                        if (iPayCallback2 != null) {
                            iPayCallback2.onFail(-1002, PayFailMsg.FAILED_CALL_THIRD_PARTY_SDK, null);
                        }
                    }
                }

                @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IAlipayProxyCallback
                public void onSuccess(String str3) {
                    String str4;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str3) == null) {
                        str4 = this.this$0.TAG;
                        RLog.info(str4, "onSuccess2 result:" + str3);
                        this.this$0.onProxyPayResult(str3, this.$callback);
                    }
                }
            });
        }
    }
}
