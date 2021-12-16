package com.yy.mobile.framework.revenuesdk.payapi.payservice;

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
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.SkuDetailInfo;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0012\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b=\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J1\u0010\f\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\n2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0015\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0014\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u0017\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0014\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010 \u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b \u0010\u001fJ)\u0010\"\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016¢\u0006\u0004\b\"\u0010#J7\u0010%\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0014\u0018\u00010\tH\u0016¢\u0006\u0004\b%\u0010&JC\u0010*\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0'2\u0006\u0010$\u001a\u00020\u000f2\u0014\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0'\u0018\u00010\tH\u0016¢\u0006\u0004\b*\u0010+JM\u00103\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010-\u001a\u00020,2\b\u0010\u000e\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010\u000f2\u0006\u00100\u001a\u00020\u00112\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u000101H\u0016¢\u0006\u0004\b3\u00104JM\u00103\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010-\u001a\u00020,2\b\u00105\u001a\u0004\u0018\u00010\u000f2\b\u0010/\u001a\u0004\u0018\u00010\u000f2\u0006\u00100\u001a\u00020\u00112\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u000101H\u0016¢\u0006\u0004\b3\u00106JM\u00107\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010-\u001a\u00020,2\b\u00105\u001a\u0004\u0018\u00010\u000f2\b\u0010/\u001a\u0004\u0018\u00010\u000f2\u0006\u00100\u001a\u00020\u00112\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u000101H\u0016¢\u0006\u0004\b7\u00106J_\u0010;\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010-\u001a\u00020,2\b\u00108\u001a\u0004\u0018\u00010\u000f2\b\u00109\u001a\u0004\u0018\u00010\u000f2\u0006\u0010:\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010\u000f2\u0006\u00100\u001a\u00020\u00112\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u000101H\u0016¢\u0006\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/DefaultPayMethod;", "Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/IPayMethod;", "", "appHasReturnToForegroud", "()V", "Landroid/app/Activity;", "act", "", "type", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IResult;", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/PurchaseInfo;", "iResult", "clearHangPayJob", "(Landroid/app/Activity;ILcom/yy/mobile/framework/revenuesdk/baseapi/IResult;)V", "info", "", "result", "", "doHangJob", "(Lcom/yy/mobile/framework/revenuesdk/payapi/bean/PurchaseInfo;Lcom/yy/mobile/framework/revenuesdk/baseapi/IResult;)Z", "", "hasHangPayJobs", "(Landroid/app/Activity;Lcom/yy/mobile/framework/revenuesdk/baseapi/IResult;)Z", "hasHangSubscribeJobs", "isPayingStatus", "()Z", "isSupported", "(Landroid/app/Activity;)Z", "code", "msg", "onQQPayResult", "(ILjava/lang/String;)V", "onWxPayResult", "product", "queryHistoryPurchaseByProductId", "(Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/baseapi/IResult;)Z", "skuType", "queryHistoryPurchaseBySkuType", "(Landroid/app/Activity;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/baseapi/IResult;)Z", "", "skusList", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/SkuDetailInfo;", "querySkuDetails", "(Landroid/app/Activity;Ljava/util/List;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/baseapi/IResult;)Z", "", "uid", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/ProductInfo;", "payload", "isSetAccountId", "Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;", "callback", "requestPay", "(Landroid/app/Activity;JLcom/yy/mobile/framework/revenuesdk/payapi/bean/ProductInfo;Ljava/lang/String;ZLcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "productId", "(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;ZLcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "requestSubscription", "oldProductId", "newProductId", "prorationMode", "updateSubscription", "(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "<init>", "Companion", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public class DefaultPayMethod implements IPayMethod {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final String TAG = "DefaultPayMethod";
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/DefaultPayMethod$Companion;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1756883866, "Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/DefaultPayMethod;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1756883866, "Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/DefaultPayMethod;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    public DefaultPayMethod() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void appHasReturnToForegroud() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            RLog.warn(TAG, "appHasReturnToForegroud be invoked but nothing could be done in DefaultPayMethod");
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void clearHangPayJob(Activity activity, int i2, IResult<PurchaseInfo> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, i2, iResult) == null) {
            RLog.warn(TAG, "clearHangPayJob be invoked but nothing could be done in DefaultPayMethod");
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean doHangJob(PurchaseInfo purchaseInfo, IResult<String> iResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, purchaseInfo, iResult)) == null) {
            RLog.warn(TAG, "doHangJob be invoked but nothing could be done in DefaultPayMethod");
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean hasHangPayJobs(Activity activity, IResult<List<PurchaseInfo>> iResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, activity, iResult)) == null) {
            RLog.warn(TAG, "hasHangPayJobs be invoked but nothing could be done in DefaultPayMethod");
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean hasHangSubscribeJobs(Activity activity, IResult<List<PurchaseInfo>> iResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, activity, iResult)) == null) {
            RLog.warn(TAG, "hasHangSubscribeJobs be invoked but nothing could be done in DefaultPayMethod");
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean isPayingStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RLog.warn(TAG, "isPayingStatus be invoked but nothing could be done in DefaultPayMethod");
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean isSupported(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, activity)) == null) {
            RLog.warn(TAG, "isSupported be invoked but nothing could be done in DefaultPayMethod");
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void onQQPayResult(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, str) == null) {
            RLog.warn(TAG, "onQQPayResult be invoked but nothing could be done in DefaultPayMethod");
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void onWxPayResult(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, str) == null) {
            RLog.warn(TAG, "onWxPayResult be invoked but nothing could be done in DefaultPayMethod");
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean queryHistoryPurchaseByProductId(String str, IResult<PurchaseInfo> iResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, iResult)) == null) {
            RLog.warn(TAG, "queryHistoryPurchaseByProductId be invoked but nothing could be done in DefaultPayMethod");
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean queryHistoryPurchaseBySkuType(Activity activity, String str, IResult<List<PurchaseInfo>> iResult) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, activity, str, iResult)) == null) {
            RLog.warn(TAG, "requestPay be invoked but nothing could be done in DefaultPayMethod");
            if (iResult != null) {
                IPayMethod.Status status = IPayMethod.Status.ERROR;
                iResult.onFail(status.code, status.message, null);
                return false;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean querySkuDetails(Activity activity, List<String> list, String str, IResult<List<SkuDetailInfo>> iResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, activity, list, str, iResult)) == null) {
            RLog.warn(TAG, "querySkuDetailsAsync be invoked but nothing could be done in DefaultPayMethod");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestPay(Activity activity, long j2, ProductInfo productInfo, String str, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{activity, Long.valueOf(j2), productInfo, str, Boolean.valueOf(z), iPayCallback}) == null) {
            RLog.warn(TAG, "requestPay be invoked but nothing could be done in DefaultPayMethod");
            if (iPayCallback != null) {
                IPayMethod.Status status = IPayMethod.Status.ERROR;
                iPayCallback.onFail(status.code, status.message, null);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestSubscription(Activity activity, long j2, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{activity, Long.valueOf(j2), str, str2, Boolean.valueOf(z), iPayCallback}) == null) {
            RLog.warn(TAG, "requestSubscription be invoked but nothing could be done in DefaultPayMethod");
            if (iPayCallback != null) {
                IPayMethod.Status status = IPayMethod.Status.ERROR;
                iPayCallback.onFail(status.code, status.message, null);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void updateSubscription(Activity activity, long j2, String str, String str2, int i2, String str3, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{activity, Long.valueOf(j2), str, str2, Integer.valueOf(i2), str3, Boolean.valueOf(z), iPayCallback}) == null) {
            RLog.warn(TAG, "updateSubscription be invoked but nothing could be done in DefaultPayMethod");
            if (iPayCallback != null) {
                IPayMethod.Status status = IPayMethod.Status.ERROR;
                iPayCallback.onFail(status.code, status.message, null);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestPay(Activity activity, long j2, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{activity, Long.valueOf(j2), str, str2, Boolean.valueOf(z), iPayCallback}) == null) {
            RLog.warn(TAG, "requestPay be invoked but nothing could be done in DefaultPayMethod");
            if (iPayCallback != null) {
                IPayMethod.Status status = IPayMethod.Status.ERROR;
                iPayCallback.onFail(status.code, status.message, null);
            }
        }
    }
}
