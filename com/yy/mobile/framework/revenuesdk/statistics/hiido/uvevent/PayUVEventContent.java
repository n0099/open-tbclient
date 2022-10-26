package com.yy.mobile.framework.revenuesdk.statistics.hiido.uvevent;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.AbstractHiidoContent;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.BaseHiidoContent;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.HiidoConstantContent;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u001b\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uvevent/PayUVEventContent;", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/AbstractHiidoContent;", "", "buildContent", "()Ljava/lang/String;", "getAct", "getContent", "", "getMapContent", "()Ljava/util/Map;", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;", "mBaseHiidoContent", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;", "mChargeConfigId", "Ljava/lang/String;", "mEvent", "mPayChannel", "mPayMethod", "<init>", "()V", "Companion", "ProductEventBuilder", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class PayUVEventContent extends AbstractHiidoContent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHARGE_CONFIGID = "chargeconfigid";
    public static final Companion Companion;
    public static final String EVENT = "event";
    public static final String OPENID = "openid";
    public static final String PAY_CHANNEL = "paychannel";
    public static final String PAY_METHOD = "paymethod2";
    public static final String USER_TYPE = "usertype";
    public transient /* synthetic */ FieldHolder $fh;
    public BaseHiidoContent mBaseHiidoContent;
    public String mChargeConfigId;
    public String mEvent;
    public String mPayChannel;
    public String mPayMethod;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1349931831, "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uvevent/PayUVEventContent;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1349931831, "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uvevent/PayUVEventContent;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0003¨\u0006\u000b"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uvevent/PayUVEventContent$Companion;", "", "CHARGE_CONFIGID", "Ljava/lang/String;", "EVENT", "OPENID", "PAY_CHANNEL", "PAY_METHOD", "USER_TYPE", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public final class Companion {
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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0004\b\r\u0010\nR\u0016\u0010\u000e\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uvevent/PayUVEventContent$ProductEventBuilder;", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uvevent/PayUVEventContent;", "build", "()Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uvevent/PayUVEventContent;", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;", "content", "setAbstractHiidoContent", "(Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;)Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uvevent/PayUVEventContent$ProductEventBuilder;", "", "setChargeConfigId", "(Ljava/lang/String;)Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uvevent/PayUVEventContent$ProductEventBuilder;", "setEvent", "setPayChannel", "setPayMethod", "mProductEventContent", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uvevent/PayUVEventContent;", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public final class ProductEventBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PayUVEventContent mProductEventContent;

        public ProductEventBuilder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mProductEventContent = new PayUVEventContent(null);
        }

        public final PayUVEventContent build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mProductEventContent;
            }
            return (PayUVEventContent) invokeV.objValue;
        }

        public final ProductEventBuilder setAbstractHiidoContent(BaseHiidoContent baseHiidoContent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseHiidoContent)) != null) {
                return (ProductEventBuilder) invokeL.objValue;
            }
            this.mProductEventContent.mBaseHiidoContent = baseHiidoContent;
            return this;
        }

        public final ProductEventBuilder setChargeConfigId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) != null) {
                return (ProductEventBuilder) invokeL.objValue;
            }
            this.mProductEventContent.mChargeConfigId = str;
            return this;
        }

        public final ProductEventBuilder setEvent(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, str)) != null) {
                return (ProductEventBuilder) invokeL.objValue;
            }
            this.mProductEventContent.mEvent = str;
            return this;
        }

        public final ProductEventBuilder setPayChannel(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, str)) != null) {
                return (ProductEventBuilder) invokeL.objValue;
            }
            this.mProductEventContent.mPayChannel = str;
            return this;
        }

        public final ProductEventBuilder setPayMethod(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048581, this, str)) != null) {
                return (ProductEventBuilder) invokeL.objValue;
            }
            this.mProductEventContent.mPayMethod = str;
            return this;
        }
    }

    public PayUVEventContent() {
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
        this.mEvent = "";
        this.mPayChannel = "";
        this.mPayMethod = "";
        this.mChargeConfigId = "";
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

    public /* synthetic */ PayUVEventContent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final String buildContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("event");
            sb.append("=");
            sb.append(URLEncoder.encode(this.mEvent, "UTF-8"));
            if (!TextUtils.isEmpty(HiidoConstantContent.mUserType)) {
                sb.append("&");
                sb.append(USER_TYPE);
                sb.append("=");
                sb.append(HiidoConstantContent.mUserType);
            }
            if (!TextUtils.isEmpty(HiidoConstantContent.mOpenId)) {
                sb.append("&");
                sb.append("openid");
                sb.append("=");
                sb.append(HiidoConstantContent.mOpenId);
            }
            if (!TextUtils.isEmpty(this.mPayChannel)) {
                sb.append("&");
                sb.append(PAY_CHANNEL);
                sb.append("=");
                sb.append(this.mPayChannel);
            }
            if (!TextUtils.isEmpty(this.mPayMethod)) {
                sb.append("&");
                sb.append(PAY_METHOD);
                sb.append("=");
                sb.append(this.mPayMethod);
            }
            if (!TextUtils.isEmpty(this.mChargeConfigId)) {
                sb.append("&");
                sb.append(CHARGE_CONFIGID);
                sb.append("=");
                sb.append(this.mChargeConfigId);
            }
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "contents.toString()");
            return sb2;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.statistics.hiido.AbstractHiidoContent
    public String getContent() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            BaseHiidoContent baseHiidoContent = this.mBaseHiidoContent;
            if (baseHiidoContent != null) {
                str = baseHiidoContent.getContent();
            } else {
                str = null;
            }
            sb.append(str);
            sb.append("&");
            sb.append(buildContent());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.statistics.hiido.AbstractHiidoContent
    public Map getMapContent() {
        InterceptResult invokeV;
        Map map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BaseHiidoContent baseHiidoContent = this.mBaseHiidoContent;
            if (baseHiidoContent != null) {
                map = baseHiidoContent.getMapContent();
            } else {
                map = null;
            }
            if (map == null) {
                map = new LinkedHashMap();
            }
            map.put("event", this.mEvent);
            String str = HiidoConstantContent.mUserType;
            Intrinsics.checkExpressionValueIsNotNull(str, "HiidoConstantContent.mUserType");
            map.put(USER_TYPE, str);
            String str2 = HiidoConstantContent.mOpenId;
            Intrinsics.checkExpressionValueIsNotNull(str2, "HiidoConstantContent.mOpenId");
            map.put("openid", str2);
            map.put(PAY_CHANNEL, this.mPayChannel);
            map.put(PAY_METHOD, this.mPayMethod);
            map.put(CHARGE_CONFIGID, this.mChargeConfigId);
            return map;
        }
        return (Map) invokeV.objValue;
    }
}
