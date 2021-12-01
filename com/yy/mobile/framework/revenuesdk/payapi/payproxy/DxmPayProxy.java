package com.yy.mobile.framework.revenuesdk.payapi.payproxy;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import com.yy.mobile.framework.revenuesdk.baseapi.PayFailMsg;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b&\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b\u0011\u0010\u0012JM\u0010\u0019\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u00022\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJM\u0010\u0019\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u00022\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0019\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/DxmPayProxy;", "Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/DefaultPayMethod;", "", "isPayingStatus", "()Z", "Landroid/app/Activity;", "act", "isSupported", "(Landroid/app/Activity;)Z", "", "state", "", ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/PurchaseInfo;", "callback", "", "onPayResult", "(ILjava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "", "uid", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/ProductInfo;", "info", "payload", "isSetAccountId", "requestPay", "(Landroid/app/Activity;JLcom/yy/mobile/framework/revenuesdk/payapi/bean/ProductInfo;Ljava/lang/String;ZLcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "productId", "(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;ZLcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "TAG", "Ljava/lang/String;", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IDxmSdkServiceProxy;", "dxmPayServiceService", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IDxmSdkServiceProxy;", "getDxmPayServiceService", "()Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IDxmSdkServiceProxy;", "setDxmPayServiceService", "(Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IDxmSdkServiceProxy;)V", "<init>", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class DxmPayProxy extends DefaultPayMethod {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String TAG;
    public IDxmSdkServiceProxy dxmPayServiceService;

    public DxmPayProxy(IDxmSdkServiceProxy iDxmSdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iDxmSdkServiceProxy};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.dxmPayServiceService = iDxmSdkServiceProxy;
        this.TAG = "DxmPayProxy";
    }

    public final IDxmSdkServiceProxy getDxmPayServiceService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.dxmPayServiceService : (IDxmSdkServiceProxy) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean isPayingStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? super.isPayingStatus() : invokeV.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean isSupported(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void onPayResult(int i2, String str, IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, str, iPayCallback) == null) {
            String str2 = this.TAG;
            RLog.info(str2, "onPayResult state=" + i2 + " p1=" + str);
            if (i2 == 0) {
                if (iPayCallback != null) {
                    iPayCallback.onSuccess(new PurchaseInfo("", ""), null);
                }
            } else if (i2 == 1) {
                if (iPayCallback != null) {
                    iPayCallback.onFail(i2, "正常调起支付,支付中", null);
                }
            } else if (i2 == 2) {
                if (iPayCallback != null) {
                    iPayCallback.onFail(com.yy.mobile.framework.revenuesdk.payapi.PayStatus.CANCEL.getCode(), "正常调起支付,支付取消", null);
                }
            } else if (iPayCallback != null) {
                iPayCallback.onFail(i2, PayFailMsg.THIRD_PARTY_CALLBACK_OTHER_STATE, null);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestPay(Activity activity, long j2, ProductInfo productInfo, String str, boolean z, final IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{activity, Long.valueOf(j2), productInfo, str, Boolean.valueOf(z), iPayCallback}) == null) {
            RLog.info(this.TAG, "requestPay1");
            this.dxmPayServiceService.sendPay(j2, activity, str, new IDxmProxyCallback(this, iPayCallback) { // from class: com.yy.mobile.framework.revenuesdk.payapi.payproxy.DxmPayProxy$requestPay$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ IPayCallback $callback;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DxmPayProxy this$0;

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

                @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IDxmProxyCallback
                public void onFail(int i2, String str2) {
                    String str3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        str3 = this.this$0.TAG;
                        RLog.error(str3, "onFail1 failReasonn:" + str2, new Object[0]);
                        IPayCallback iPayCallback2 = this.$callback;
                        if (iPayCallback2 != null) {
                            iPayCallback2.onFail(-1006, PayFailMsg.FAILED_CALL_THIRD_PARTY_SDK, null);
                        }
                    }
                }

                @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IDxmProxyCallback
                public void onSuccess(int i2, String str2) {
                    String str3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        str3 = this.this$0.TAG;
                        RLog.info(str3, "requestPay onSuccess1");
                        this.this$0.onPayResult(i2, str2, this.$callback);
                    }
                }
            });
        }
    }

    public final void setDxmPayServiceService(IDxmSdkServiceProxy iDxmSdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iDxmSdkServiceProxy) == null) {
            this.dxmPayServiceService = iDxmSdkServiceProxy;
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestPay(Activity activity, long j2, String str, String str2, boolean z, final IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{activity, Long.valueOf(j2), str, str2, Boolean.valueOf(z), iPayCallback}) == null) {
            RLog.info(this.TAG, "requestPay2");
            this.dxmPayServiceService.sendPay(j2, activity, str2, new IDxmProxyCallback(this, iPayCallback) { // from class: com.yy.mobile.framework.revenuesdk.payapi.payproxy.DxmPayProxy$requestPay$2
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ IPayCallback $callback;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DxmPayProxy this$0;

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

                @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IDxmProxyCallback
                public void onFail(int i2, String str3) {
                    String str4;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str3) == null) {
                        str4 = this.this$0.TAG;
                        RLog.error(str4, "onFail2 failReasonn:" + str3, new Object[0]);
                        IPayCallback iPayCallback2 = this.$callback;
                        if (iPayCallback2 != null) {
                            iPayCallback2.onFail(-1007, PayFailMsg.FAILED_CALL_THIRD_PARTY_SDK, null);
                        }
                    }
                }

                @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IDxmProxyCallback
                public void onSuccess(int i2, String str3) {
                    String str4;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str3) == null) {
                        str4 = this.this$0.TAG;
                        RLog.info(str4, "requestPay onSuccess2");
                        this.this$0.onPayResult(i2, str3, this.$callback);
                    }
                }
            });
        }
    }
}
