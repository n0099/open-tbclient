package com.yy.mobile.framework.revenuesdk.payapi.payproxy;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.dlna.DlnaManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.sina.weibo.sdk.utils.WbAuthConstants;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00108\u001a\u000207¢\u0006\u0004\b>\u0010=J1\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\r2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u0019\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J)\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\r2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJM\u0010\"\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\f\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u0010!\u001a\u00020\u000f2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\"\u0010#JM\u0010\"\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u0010!\u001a\u00020\u000f2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\"\u0010%JM\u0010&\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u0010!\u001a\u00020\u000f2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015H\u0016¢\u0006\u0004\b&\u0010%J\u001b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010'\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b)\u0010*J%\u0010.\u001a\u00020-2\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010+H\u0002¢\u0006\u0004\b.\u0010/J_\u00103\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\b\u00100\u001a\u0004\u0018\u00010\r2\b\u00101\u001a\u0004\u0018\u00010\r2\u0006\u00102\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u0010!\u001a\u00020\u000f2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015H\u0016¢\u0006\u0004\b3\u00104R\u0016\u00105\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006?"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/AlipayProxy;", "Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/DefaultPayMethod;", "Landroid/app/Activity;", "act", "", "type", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IResult;", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/PurchaseInfo;", "iResult", "", "clearHangPayJob", "(Landroid/app/Activity;ILcom/yy/mobile/framework/revenuesdk/baseapi/IResult;)V", "info", "", "result", "", "doHangJob", "(Lcom/yy/mobile/framework/revenuesdk/payapi/bean/PurchaseInfo;Lcom/yy/mobile/framework/revenuesdk/baseapi/IResult;)Z", "isSupported", "(Landroid/app/Activity;)Z", "resultStatus", "Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;", WebChromeClient.KEY_ARG_CALLBACK, "onPayResult", "(Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "onProxyPayResult", "product", "queryHistoryPurchaseByProductId", "(Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/baseapi/IResult;)Z", "", "uid", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/ProductInfo;", "payload", "isSetAccountId", "requestPay", "(Landroid/app/Activity;JLcom/yy/mobile/framework/revenuesdk/payapi/bean/ProductInfo;Ljava/lang/String;ZLcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "productId", "(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;ZLcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "requestSubscription", "aliRecharge", "Lorg/json/JSONObject;", "splitPayResult", "(Ljava/lang/String;)Lorg/json/JSONObject;", "", "rawResult", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/PayResult;", "transToPayResult", "(Ljava/util/Map;)Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/PayResult;", "oldProductId", "newProductId", "prorationMode", "updateSubscription", "(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "TAG", "Ljava/lang/String;", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IAlipaySdkServiceProxy;", "alipayServiceService", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IAlipaySdkServiceProxy;", "getAlipayServiceService", "()Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IAlipaySdkServiceProxy;", "setAlipayServiceService", "(Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IAlipaySdkServiceProxy;)V", "<init>", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class AlipayProxy extends DefaultPayMethod {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String TAG;
    public IAlipaySdkServiceProxy alipayServiceService;

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

    private final void onPayResult(String str, IPayCallback<PurchaseInfo> iPayCallback) {
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
                            iPayCallback.onFail(6002, "网络连接出错", null);
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
            int intValue = intOrNull != null ? intOrNull.intValue() : -1;
            if (iPayCallback != null) {
                iPayCallback.onFail(intValue, PayFailMsg.THIRD_PARTY_CALLBACK_OTHER_STATE, null);
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
                if (transToPayResult == null) {
                    if (iPayCallback != null) {
                        iPayCallback.onFail(-2005, PayFailMsg.FAILED_PARSE_THIRD_PARTY_CALLBACK, null);
                        return;
                    }
                    return;
                }
                String resultStatus = transToPayResult.getResultStatus();
                if (resultStatus == null) {
                    Intrinsics.throwNpe();
                }
                onPayResult(resultStatus, iPayCallback);
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
            List<String> split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{ParamableElem.DIVIDE_PARAM}, false, 0, 6, (Object) null);
            JSONObject jSONObject = new JSONObject();
            for (String str4 : split$default) {
                List split$default2 = StringsKt__StringsKt.split$default((CharSequence) str4, new String[]{"="}, false, 0, 6, (Object) null);
                if (split$default2.size() > 1) {
                    String str5 = (String) split$default2.get(1);
                    if (str5.length() > 2) {
                        int length = str5.length() - 1;
                        if (str5 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        str2 = str5.substring(1, length);
                        Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
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
                    if (TextUtils.equals(str, "resultStatus")) {
                        payResult.setResultStatus(map.get(str));
                    } else if (TextUtils.equals(str, "result")) {
                        payResult.setResult(map.get(str));
                    } else if (TextUtils.equals(str, "memo")) {
                        payResult.setMemo(map.get(str));
                    }
                }
            }
            return payResult;
        }
        return (PayResult) invokeL.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void clearHangPayJob(Activity activity, int i, IResult<PurchaseInfo> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, activity, i, iResult) == null) {
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

    public final IAlipaySdkServiceProxy getAlipayServiceService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.alipayServiceService : (IAlipaySdkServiceProxy) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean isSupported(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean queryHistoryPurchaseByProductId(String str, IResult<PurchaseInfo> iResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, iResult)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestPay(Activity activity, long j, ProductInfo productInfo, String str, boolean z, final IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{activity, Long.valueOf(j), productInfo, str, Boolean.valueOf(z), iPayCallback}) == null) {
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
    public void requestSubscription(Activity activity, long j, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{activity, Long.valueOf(j), str, str2, Boolean.valueOf(z), iPayCallback}) == null) {
            RLog.error(this.TAG, "Alipay can't requestSubscription", new Object[0]);
        }
    }

    public final void setAlipayServiceService(IAlipaySdkServiceProxy iAlipaySdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iAlipaySdkServiceProxy) == null) {
            this.alipayServiceService = iAlipaySdkServiceProxy;
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void updateSubscription(Activity activity, long j, String str, String str2, int i, String str3, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{activity, Long.valueOf(j), str, str2, Integer.valueOf(i), str3, Boolean.valueOf(z), iPayCallback}) == null) {
            RLog.error(this.TAG, "Alipay can't updateSubscription", new Object[0]);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestPay(Activity activity, long j, String str, String str2, boolean z, final IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{activity, Long.valueOf(j), str, str2, Boolean.valueOf(z), iPayCallback}) == null) {
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
