package com.yy.mobile.framework.revenuesdk.payapi.request;

import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0006\n\u0002\b\r\b\u0007\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bA\u0010BJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R0\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u0004\"\u0004\b \u0010\u001dR$\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u0004\"\u0004\b#\u0010\u001dR$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010+\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u001a\u001a\u0004\b,\u0010\u0004\"\u0004\b-\u0010\u001dR\"\u0010.\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u000e\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0012R$\u00101\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u001a\u001a\u0004\b2\u0010\u0004\"\u0004\b3\u0010\u001dR\"\u00104\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\u000e\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R\"\u00108\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010>\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010\u000e\u001a\u0004\b?\u0010\u0010\"\u0004\b@\u0010\u0012¨\u0006D"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "", "toString", "()Ljava/lang/String;", "", "appClientExpand", "Ljava/util/Map;", "getAppClientExpand", "()Ljava/util/Map;", "setAppClientExpand", "(Ljava/util/Map;)V", "", "cid", "I", "getCid", "()I", "setCid", "(I)V", "currencyType", "getCurrencyType", "setCurrencyType", "from", "getFrom", "setFrom", "oldProductId", "Ljava/lang/String;", "getOldProductId", "setOldProductId", "(Ljava/lang/String;)V", "payChannel", "getPayChannel", "setPayChannel", "payMethod", "getPayMethod", "setPayMethod", "Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;", "payType", "Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;", "getPayType", "()Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;", "setPayType", "(Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;)V", "productId", "getProductId", "setProductId", "prorationMode", "getProrationMode", "setProrationMode", "returnUrl", "getReturnUrl", "setReturnUrl", "sid", "getSid", "setSid", "", "srcAmount", "D", "getSrcAmount", "()D", "setSrcAmount", "(D)V", "subscriptionType", "getSubscriptionType", "setSubscriptionType", "<init>", "()V", "Companion", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class ChargeCurrencyReqParams extends RequestParams {
    public static /* synthetic */ Interceptable $ic;
    public static final Companion Companion;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> appClientExpand;
    public int cid;
    public int currencyType;
    public int from;
    public String oldProductId;
    public String payChannel;
    public String payMethod;
    public PayType payType;
    public String productId;
    public int prorationMode;
    public String returnUrl;
    public int sid;
    public double srcAmount;
    public int subscriptionType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams$Companion;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams;", "other", "clone", "(Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams;)Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams;", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
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

        public final ChargeCurrencyReqParams clone(ChargeCurrencyReqParams chargeCurrencyReqParams) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chargeCurrencyReqParams)) == null) {
                ChargeCurrencyReqParams chargeCurrencyReqParams2 = new ChargeCurrencyReqParams();
                chargeCurrencyReqParams2.clone(chargeCurrencyReqParams);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public final int getCurrencyType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.currencyType : invokeV.intValue;
    }

    public final int getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.from : invokeV.intValue;
    }

    public final String getOldProductId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.oldProductId : (String) invokeV.objValue;
    }

    public final String getPayChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.payChannel : (String) invokeV.objValue;
    }

    public final String getPayMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.payMethod : (String) invokeV.objValue;
    }

    public final PayType getPayType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.payType : (PayType) invokeV.objValue;
    }

    public final String getProductId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.productId : (String) invokeV.objValue;
    }

    public final int getProrationMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.prorationMode : invokeV.intValue;
    }

    public final String getReturnUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.returnUrl : (String) invokeV.objValue;
    }

    public final int getSid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.sid : invokeV.intValue;
    }

    public final double getSrcAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.srcAmount : invokeV.doubleValue;
    }

    public final int getSubscriptionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.subscriptionType : invokeV.intValue;
    }

    public final void setAppClientExpand(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, map) == null) {
            this.appClientExpand = map;
        }
    }

    public final void setCid(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.cid = i2;
        }
    }

    public final void setCurrencyType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.currencyType = i2;
        }
    }

    public final void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.from = i2;
        }
    }

    public final void setOldProductId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.oldProductId = str;
        }
    }

    public final void setPayChannel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.payChannel = str;
        }
    }

    public final void setPayMethod(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.payMethod = str;
        }
    }

    public final void setPayType(PayType payType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, payType) == null) {
            this.payType = payType;
        }
    }

    public final void setProductId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.productId = str;
        }
    }

    public final void setProrationMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.prorationMode = i2;
        }
    }

    public final void setReturnUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.returnUrl = str;
        }
    }

    public final void setSid(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.sid = i2;
        }
    }

    public final void setSrcAmount(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.srcAmount = d2;
        }
    }

    public final void setSubscriptionType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.subscriptionType = i2;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return "ChargeCurrencyReqParams{cmd=" + getCmd() + ", appId=" + getAppId() + ", clientVersion =" + getClientVersion() + ",requestTime = " + getRequestTime() + ", clientVersion =" + getClientVersion() + ", retryCount =" + getRetryCount() + ", intervalMs =" + getIntervalMs() + ", retryType =" + getRetryType() + ", timeOutMs =" + getTimeOutMs() + ", cid=" + this.cid + ", sid=" + this.sid + ",payType = " + this.payType + ", productId =" + this.productId + ",subscriptionType = " + this.subscriptionType + ",oldProductId = " + this.oldProductId + ",prorationMode = " + this.prorationMode + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
