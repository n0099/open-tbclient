package com.yy.mobile.framework.revenuesdk.payapi.payproxy;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.dlna.DlnaManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import com.yy.mobile.framework.revenuesdk.baseapi.PayFailMsg;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b#\u0010\"J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010JE\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017JE\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/DxmPayProxy;", "Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/DefaultPayMethod;", "Landroid/app/Activity;", "act", "", "isSupported", "(Landroid/app/Activity;)Z", "", "state", "", ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/PurchaseInfo;", WebChromeClient.KEY_ARG_CALLBACK, "", "onPayResult", "(ILjava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "", "uid", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/ProductInfo;", "info", "payload", "requestPay", "(Landroid/app/Activity;JLcom/yy/mobile/framework/revenuesdk/payapi/bean/ProductInfo;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "productId", "(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "TAG", "Ljava/lang/String;", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IDxmSdkServiceProxy;", "dxmPayServiceService", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IDxmSdkServiceProxy;", "getDxmPayServiceService", "()Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IDxmSdkServiceProxy;", "setDxmPayServiceService", "(Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IDxmSdkServiceProxy;)V", "<init>", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
    public boolean isSupported(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void onPayResult(int i, String str, IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, iPayCallback) == null) {
            String str2 = this.TAG;
            RLog.info(str2, "onPayResult state=" + i + " p1=" + str);
            if (i == 0) {
                if (iPayCallback != null) {
                    iPayCallback.onSuccess(new PurchaseInfo("", ""), null);
                }
            } else if (i == 1) {
                if (iPayCallback != null) {
                    iPayCallback.onFail(i, "正常调起支付,支付中", null);
                }
            } else if (i == 2) {
                if (iPayCallback != null) {
                    iPayCallback.onFail(com.yy.mobile.framework.revenuesdk.payapi.PayStatus.CANCEL.getCode(), "正常调起支付,支付取消", null);
                }
            } else if (iPayCallback != null) {
                iPayCallback.onFail(i, PayFailMsg.THIRD_PARTY_CALLBACK_OTHER_STATE, null);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestPay(Activity activity, long j, ProductInfo productInfo, String str, final IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{activity, Long.valueOf(j), productInfo, str, iPayCallback}) == null) {
            RLog.info(this.TAG, "requestPay1");
            if (activity == null) {
                RLog.error(this.TAG, "pay failed params activity null", new Object[0]);
                if (iPayCallback != null) {
                    iPayCallback.onFail(DlnaManager.DLNA_ERROR_CREATE_CTRL_POINT_TIMER_THREAD_FAIL, PayFailMsg.FAILED_CALL_THIRD_PARTY_SDK, null);
                    return;
                }
                return;
            }
            this.dxmPayServiceService.sendPay(j, activity, str, new IDxmProxyCallback(this, iPayCallback) { // from class: com.yy.mobile.framework.revenuesdk.payapi.payproxy.DxmPayProxy$requestPay$1
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

                @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IDxmProxyCallback
                public void onFail(int i, String str2) {
                    String str3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str2) == null) {
                        str3 = this.this$0.TAG;
                        RLog.error(str3, "onFail1 failReasonn:" + str2, new Object[0]);
                        IPayCallback iPayCallback2 = this.$callback;
                        if (iPayCallback2 != null) {
                            iPayCallback2.onFail(-1006, PayFailMsg.FAILED_CALL_THIRD_PARTY_SDK, null);
                        }
                    }
                }

                @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IDxmProxyCallback
                public void onSuccess(int i, String str2) {
                    String str3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str2) == null) {
                        str3 = this.this$0.TAG;
                        RLog.info(str3, "requestPay onSuccess1 state:" + i + " msg:" + str2);
                        this.this$0.onPayResult(i, str2, this.$callback);
                    }
                }
            });
        }
    }

    public final void setDxmPayServiceService(IDxmSdkServiceProxy iDxmSdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iDxmSdkServiceProxy) == null) {
            this.dxmPayServiceService = iDxmSdkServiceProxy;
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestPay(Activity activity, long j, String str, String str2, final IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{activity, Long.valueOf(j), str, str2, iPayCallback}) == null) {
            RLog.info(this.TAG, "requestPay2");
            if (activity == null) {
                RLog.error(this.TAG, "pay failed params activity null", new Object[0]);
                if (iPayCallback != null) {
                    iPayCallback.onFail(-1012, PayFailMsg.FAILED_CALL_THIRD_PARTY_SDK, null);
                    return;
                }
                return;
            }
            this.dxmPayServiceService.sendPay(j, activity, str2, new IDxmProxyCallback(this, iPayCallback) { // from class: com.yy.mobile.framework.revenuesdk.payapi.payproxy.DxmPayProxy$requestPay$2
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

                @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IDxmProxyCallback
                public void onFail(int i, String str3) {
                    String str4;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str3) == null) {
                        str4 = this.this$0.TAG;
                        RLog.error(str4, "onFail2 failReasonn:" + str3, new Object[0]);
                        IPayCallback iPayCallback2 = this.$callback;
                        if (iPayCallback2 != null) {
                            iPayCallback2.onFail(-1007, PayFailMsg.FAILED_CALL_THIRD_PARTY_SDK, null);
                        }
                    }
                }

                @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IDxmProxyCallback
                public void onSuccess(int i, String str3) {
                    String str4;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str3) == null) {
                        str4 = this.this$0.TAG;
                        RLog.info(str4, "requestPay onSuccess2 state:" + i + " msg:" + str3);
                        this.this$0.onPayResult(i, str3, this.$callback);
                    }
                }
            });
        }
    }
}
