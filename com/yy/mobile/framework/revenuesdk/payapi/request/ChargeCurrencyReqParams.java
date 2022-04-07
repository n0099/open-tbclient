package com.yy.mobile.framework.revenuesdk.payapi.request;

import android.app.Activity;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0006\n\u0002\b\r\b\u0007\u0018\u0000 P2\u00020\u0001:\u0001PB\u0007¢\u0006\u0004\bN\u0010OJ\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R0\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\"\u0010 \u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R$\u0010#\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010'R$\u0010(\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010$\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010'R\"\u0010+\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0011\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015R$\u0010.\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010$\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010'R$\u00102\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u00108\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010$\u001a\u0004\b9\u0010\u0007\"\u0004\b:\u0010'R\"\u0010;\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0011\u001a\u0004\b<\u0010\u0013\"\u0004\b=\u0010\u0015R$\u0010>\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010$\u001a\u0004\b?\u0010\u0007\"\u0004\b@\u0010'R\"\u0010A\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010\u0011\u001a\u0004\bB\u0010\u0013\"\u0004\bC\u0010\u0015R\"\u0010E\u001a\u00020D8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010K\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010\u0011\u001a\u0004\bL\u0010\u0013\"\u0004\bM\u0010\u0015¨\u0006Q"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "", "toString", "()Ljava/lang/String;", "", "appClientExpand", "Ljava/util/Map;", "getAppClientExpand", "()Ljava/util/Map;", "setAppClientExpand", "(Ljava/util/Map;)V", "", "cid", "I", "getCid", "()I", "setCid", "(I)V", "Ljava/lang/ref/WeakReference;", "contextWeakRef", "Ljava/lang/ref/WeakReference;", "getContextWeakRef", "()Ljava/lang/ref/WeakReference;", "setContextWeakRef", "(Ljava/lang/ref/WeakReference;)V", "currencyType", "getCurrencyType", "setCurrencyType", "from", "getFrom", "setFrom", "oldProductId", "Ljava/lang/String;", "getOldProductId", "setOldProductId", "(Ljava/lang/String;)V", "payChannel", "getPayChannel", "setPayChannel", "payFlowTypeId", "getPayFlowTypeId", "setPayFlowTypeId", "payMethod", "getPayMethod", "setPayMethod", "Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;", "payType", "Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;", "getPayType", "()Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;", "setPayType", "(Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;)V", AdUploadHttpRequest.KEY_PRODUCT_ID, "getProductId", "setProductId", "prorationMode", "getProrationMode", "setProrationMode", "returnUrl", "getReturnUrl", "setReturnUrl", "sid", "getSid", "setSid", "", "srcAmount", "D", "getSrcAmount", "()D", "setSrcAmount", "(D)V", "subscriptionType", "getSubscriptionType", "setSubscriptionType", "<init>", "()V", "Companion", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class ChargeCurrencyReqParams extends RequestParams {
    public static /* synthetic */ Interceptable $ic;
    public static final Companion Companion;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> appClientExpand;
    public int cid;
    public WeakReference<Activity> contextWeakRef;
    public int currencyType;
    public int from;
    public String oldProductId;
    public String payChannel;
    public int payFlowTypeId;
    public String payMethod;
    public PayType payType;
    public String productId;
    public int prorationMode;
    public String returnUrl;
    public int sid;
    public double srcAmount;
    public int subscriptionType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams$Companion;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams;", "other", "clone", "(Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams;)Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams;", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final ChargeCurrencyReqParams clone(ChargeCurrencyReqParams chargeCurrencyReqParams) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chargeCurrencyReqParams)) == null) {
                ChargeCurrencyReqParams chargeCurrencyReqParams2 = new ChargeCurrencyReqParams();
                chargeCurrencyReqParams2.clone(chargeCurrencyReqParams);
                chargeCurrencyReqParams2.setContextWeakRef(chargeCurrencyReqParams.getContextWeakRef());
                return chargeCurrencyReqParams2;
            }
            return (ChargeCurrencyReqParams) invokeL.objValue;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(979780881, "Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(979780881, "Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    public ChargeCurrencyReqParams() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.oldProductId = "";
    }

    public final Map<String, String> getAppClientExpand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.appClientExpand : (Map) invokeV.objValue;
    }

    public final int getCid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cid : invokeV.intValue;
    }

    public final Activity getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            WeakReference<Activity> weakReference = this.contextWeakRef;
            if (weakReference != null) {
                if (weakReference == null) {
                    Intrinsics.throwNpe();
                }
                return weakReference.get();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    public final WeakReference<Activity> getContextWeakRef() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.contextWeakRef : (WeakReference) invokeV.objValue;
    }

    public final int getCurrencyType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.currencyType : invokeV.intValue;
    }

    public final int getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.from : invokeV.intValue;
    }

    public final String getOldProductId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.oldProductId : (String) invokeV.objValue;
    }

    public final String getPayChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.payChannel : (String) invokeV.objValue;
    }

    public final int getPayFlowTypeId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.payFlowTypeId : invokeV.intValue;
    }

    public final String getPayMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.payMethod : (String) invokeV.objValue;
    }

    public final PayType getPayType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.payType : (PayType) invokeV.objValue;
    }

    public final String getProductId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.productId : (String) invokeV.objValue;
    }

    public final int getProrationMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.prorationMode : invokeV.intValue;
    }

    public final String getReturnUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.returnUrl : (String) invokeV.objValue;
    }

    public final int getSid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.sid : invokeV.intValue;
    }

    public final double getSrcAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.srcAmount : invokeV.doubleValue;
    }

    public final int getSubscriptionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.subscriptionType : invokeV.intValue;
    }

    public final void setAppClientExpand(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, map) == null) {
            this.appClientExpand = map;
        }
    }

    public final void setCid(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.cid = i;
        }
    }

    public final void setContextWeakRef(WeakReference<Activity> weakReference) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, weakReference) == null) {
            this.contextWeakRef = weakReference;
        }
    }

    public final void setCurrencyType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.currencyType = i;
        }
    }

    public final void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.from = i;
        }
    }

    public final void setOldProductId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.oldProductId = str;
        }
    }

    public final void setPayChannel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.payChannel = str;
        }
    }

    public final void setPayFlowTypeId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.payFlowTypeId = i;
        }
    }

    public final void setPayMethod(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.payMethod = str;
        }
    }

    public final void setPayType(PayType payType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, payType) == null) {
            this.payType = payType;
        }
    }

    public final void setProductId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.productId = str;
        }
    }

    public final void setProrationMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.prorationMode = i;
        }
    }

    public final void setReturnUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.returnUrl = str;
        }
    }

    public final void setSid(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.sid = i;
        }
    }

    public final void setSrcAmount(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Double.valueOf(d)}) == null) {
            this.srcAmount = d;
        }
    }

    public final void setSubscriptionType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.subscriptionType = i;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return "ChargeCurrencyReqParams{cmd=" + getCmd() + ", appId=" + getAppId() + ", clientVersion =" + getClientVersion() + ",requestTime = " + getRequestTime() + ", clientVersion =" + getClientVersion() + ", retryCount =" + getRetryCount() + ", intervalMs =" + getIntervalMs() + ", retryType =" + getRetryType() + ", timeOutMs =" + getTimeOutMs() + ", cid=" + this.cid + ", sid=" + this.sid + ",payType = " + this.payType + ", productId =" + this.productId + ", payFlowTypeId =" + this.payFlowTypeId + ",subscriptionType = " + this.subscriptionType + ",oldProductId = " + this.oldProductId + ",prorationMode = " + this.prorationMode + '}';
        }
        return (String) invokeV.objValue;
    }
}
