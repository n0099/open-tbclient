package com.yy.mobile.framework.revenuesdk.statistics.hiido.payflow;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.AbstractHiidoContent;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.BaseHiidoContent;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u001b\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u000eR\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/payflow/PayFlowContent;", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/AbstractHiidoContent;", "", "buildContent", "()Ljava/lang/String;", "getAct", "getContent", "", "getMapContent", "()Ljava/util/Map;", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;", "mBaseHiidoContent", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;", "mCode", "Ljava/lang/String;", "mEventId", "mMsg", "mOrderId", "mPayEntranceId", "mPayFrom", "mPayTraceId", "mProductId", "mPurchaseTime", "<init>", "()V", "Companion", "PayFlowContentBuilder", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes6.dex */
public final class PayFlowContent extends AbstractHiidoContent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CODE = "code";
    public static final Companion Companion;
    public static final String EVENT = "event";
    public static final String MSG = "msg";
    public static final String ORDERID = "orderid";
    public static final String PAYENTRANCEID = "payentranceid";
    public static final String PAYTRACEID = "paytraceid";
    public static final String PAY_FROM = "pay_from";
    public static final String PRODUCTID = "productid";
    public static final String PURCHASETIME = "purchasetime";
    public transient /* synthetic */ FieldHolder $fh;
    public BaseHiidoContent mBaseHiidoContent;
    public String mCode;
    public String mEventId;
    public String mMsg;
    public String mOrderId;
    public String mPayEntranceId;
    public String mPayFrom;
    public String mPayTraceId;
    public String mProductId;
    public String mPurchaseTime;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0003R\u0016\u0010\u000b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0003¨\u0006\u000e"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/payflow/PayFlowContent$Companion;", "", "CODE", "Ljava/lang/String;", "EVENT", "MSG", "ORDERID", "PAYENTRANCEID", "PAYTRACEID", "PAY_FROM", "PRODUCTID", "PURCHASETIME", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes6.dex */
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u0000B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u000bJ\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u000bJ\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u000bJ\u0015\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u000bJ\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u000bJ\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u000bJ\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u000bR\u0016\u0010\u001c\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/payflow/PayFlowContent$PayFlowContentBuilder;", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/payflow/PayFlowContent;", "build", "()Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/payflow/PayFlowContent;", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;", "content", "setAbstractHiidoContent", "(Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;)Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/payflow/PayFlowContent$PayFlowContentBuilder;", "", "code", "setCode", "(Ljava/lang/String;)Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/payflow/PayFlowContent$PayFlowContentBuilder;", TbEnum.SystemMessage.KEY_EVENT_ID, "setEventId", "msg", "setMsg", "orderId", "setOrderId", "payentraceId", "setPayEntraceId", "payFrom", "setPayFrom", "paytraceId", "setPayTraceId", "productId", "setProductId", "purchaceTime", "setPurchaceTime", "mPayFlowContent", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/payflow/PayFlowContent;", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes6.dex */
    public static final class PayFlowContentBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final PayFlowContent mPayFlowContent;

        public PayFlowContentBuilder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPayFlowContent = new PayFlowContent(null);
        }

        public final PayFlowContent build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mPayFlowContent : (PayFlowContent) invokeV.objValue;
        }

        public final PayFlowContentBuilder setAbstractHiidoContent(BaseHiidoContent baseHiidoContent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseHiidoContent)) == null) {
                this.mPayFlowContent.mBaseHiidoContent = baseHiidoContent;
                return this;
            }
            return (PayFlowContentBuilder) invokeL.objValue;
        }

        public final PayFlowContentBuilder setCode(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.mPayFlowContent.mCode = str;
                return this;
            }
            return (PayFlowContentBuilder) invokeL.objValue;
        }

        public final PayFlowContentBuilder setEventId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.mPayFlowContent.mEventId = str;
                return this;
            }
            return (PayFlowContentBuilder) invokeL.objValue;
        }

        public final PayFlowContentBuilder setMsg(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.mPayFlowContent.mMsg = str;
                return this;
            }
            return (PayFlowContentBuilder) invokeL.objValue;
        }

        public final PayFlowContentBuilder setOrderId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.mPayFlowContent.mOrderId = str;
                return this;
            }
            return (PayFlowContentBuilder) invokeL.objValue;
        }

        public final PayFlowContentBuilder setPayEntraceId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.mPayFlowContent.mPayEntranceId = str;
                return this;
            }
            return (PayFlowContentBuilder) invokeL.objValue;
        }

        public final PayFlowContentBuilder setPayFrom(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.mPayFlowContent.mPayFrom = str;
                return this;
            }
            return (PayFlowContentBuilder) invokeL.objValue;
        }

        public final PayFlowContentBuilder setPayTraceId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.mPayFlowContent.mPayTraceId = str;
                return this;
            }
            return (PayFlowContentBuilder) invokeL.objValue;
        }

        public final PayFlowContentBuilder setProductId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.mPayFlowContent.mProductId = str;
                return this;
            }
            return (PayFlowContentBuilder) invokeL.objValue;
        }

        public final PayFlowContentBuilder setPurchaceTime(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                this.mPayFlowContent.mPurchaseTime = str;
                return this;
            }
            return (PayFlowContentBuilder) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1328940545, "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/payflow/PayFlowContent;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1328940545, "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/payflow/PayFlowContent;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    public PayFlowContent() {
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
        this.mOrderId = "";
        this.mPurchaseTime = "";
        this.mProductId = "";
        this.mPayEntranceId = "";
        this.mPayTraceId = "";
        this.mEventId = "";
        this.mCode = "";
        this.mMsg = "";
        this.mPayFrom = "";
    }

    private final String buildContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            String str = "orderid=" + URLEncoder.encode(this.mOrderId, "UTF-8") + "&" + PURCHASETIME + "=" + URLEncoder.encode(this.mPurchaseTime, "UTF-8") + "&productid=" + URLEncoder.encode(this.mProductId, "UTF-8") + "&" + PAYENTRANCEID + "=" + URLEncoder.encode(this.mPayEntranceId, "UTF-8") + "&" + PAYTRACEID + "=" + URLEncoder.encode(this.mPayTraceId, "UTF-8") + "&event=" + URLEncoder.encode(this.mEventId, "UTF-8") + "&code=" + this.mCode + "&msg=" + URLEncoder.encode(this.mMsg, "UTF-8") + "&pay_from=" + URLEncoder.encode(this.mPayFrom, "UTF-8");
            Intrinsics.checkExpressionValueIsNotNull(str, "contents.toString()");
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.statistics.hiido.AbstractHiidoContent
    public String getAct() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BaseHiidoContent baseHiidoContent = this.mBaseHiidoContent;
            if (baseHiidoContent != null) {
                return baseHiidoContent.getAct();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.statistics.hiido.AbstractHiidoContent
    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            BaseHiidoContent baseHiidoContent = this.mBaseHiidoContent;
            sb.append(baseHiidoContent != null ? baseHiidoContent.getContent() : null);
            sb.append("&");
            sb.append(buildContent());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.statistics.hiido.AbstractHiidoContent
    public Map<String, String> getMapContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BaseHiidoContent baseHiidoContent = this.mBaseHiidoContent;
            Map<String, String> mapContent = baseHiidoContent != null ? baseHiidoContent.getMapContent() : null;
            if (mapContent == null) {
                mapContent = new LinkedHashMap<>();
            }
            mapContent.put("event", this.mEventId);
            mapContent.put("orderid", this.mOrderId);
            mapContent.put(PURCHASETIME, this.mPurchaseTime);
            mapContent.put("productid", this.mProductId);
            mapContent.put(PAYENTRANCEID, this.mPayEntranceId);
            mapContent.put(PAYTRACEID, this.mPayTraceId);
            mapContent.put("code", this.mCode);
            mapContent.put("msg", this.mMsg);
            mapContent.put("pay_from", this.mPayFrom);
            return mapContent;
        }
        return (Map) invokeV.objValue;
    }

    public /* synthetic */ PayFlowContent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
