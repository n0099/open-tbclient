package com.yy.mobile.framework.revenuesdk.payservice.revenueservice;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u0003:\u0001\u0003B\u0007¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/RevenueServerConst;", "<init>", "()V", "Companion", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class RevenueServerConst {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AccountDelayMessage = 40424536;
    public static final int ChargeCurrencyHistoryRequest = 1054;
    public static final int ChargeCurrencyHistoryResponse = 2054;
    public static final int ChargeCurrencyRequest = 1022;
    public static final int ChargeCurrencyResponse = 2022;
    public static final Companion Companion;
    public static final int ConsumeConfirmMessage = 40423235;
    public static final int CurrencyChargeMessage = 40423898;
    public static final int ExchangeCurrencyRequest = 1025;
    public static final int ExchangeCurrencyResponse = 2025;
    public static final int GetBannerConfigRequest = 1071;
    public static final int GetBannerConfigResponse = 2071;
    public static final int GetChargeCouponDiscountRequest = 1052;
    public static final int GetChargeCouponDiscountResponse = 2052;
    public static final int GetChargeCurrencyConfigByChannelsRequest = 1060;
    public static final int GetChargeCurrencyConfigByChannelsResponse = 2060;
    public static final int GetChargeCurrencyConfigRequest = 1021;
    public static final int GetChargeCurrencyConfigResponse = 2021;
    public static final int GetChargeOrderStatusRequest = 1061;
    public static final int GetChargeOrderStatusResponse = 2061;
    public static final int GetHasChargeInActivityRequest = 1026;
    public static final int GetHasChargeInActivityResponse = 2026;
    public static final int GetUserAccountHistoryRequest = 1046;
    public static final int GetUserAccountHistoryResponse = 2046;
    public static final int GetUserAccountRequest = 1005;
    public static final int GetUserAccountResponse = 2005;
    public static final int GetUserCouponStoreRequest = 1047;
    public static final int GetUserCouponStoreResponse = 2047;
    public static final int GetUserYbDetailsRequest = 1068;
    public static final int GetUserYbDetailsResponse = 2068;
    public static final int ReportPurchaseRequest = 1045;
    public static final int ReportPurchaseResponse = 2045;
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b#\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\"\u0010#R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0003R\u0016\u0010\u000b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0003R\u0016\u0010\f\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0003R\u0016\u0010\r\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0003R\u0016\u0010\u000e\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0003R\u0016\u0010\u000f\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0003R\u0016\u0010\u0010\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0003R\u0016\u0010\u0011\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0003R\u0016\u0010\u0012\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0003R\u0016\u0010\u0013\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0003R\u0016\u0010\u0014\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0003R\u0016\u0010\u0015\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0003R\u0016\u0010\u0016\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0003R\u0016\u0010\u0017\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0003R\u0016\u0010\u0018\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0003R\u0016\u0010\u0019\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0003R\u0016\u0010\u001a\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0003R\u0016\u0010\u001b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0003R\u0016\u0010\u001c\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0003R\u0016\u0010\u001d\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0003R\u0016\u0010\u001e\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0003R\u0016\u0010\u001f\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0003R\u0016\u0010 \u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u0003R\u0016\u0010!\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\u0003¨\u0006$"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/RevenueServerConst$Companion;", "", "AccountDelayMessage", "I", "ChargeCurrencyHistoryRequest", "ChargeCurrencyHistoryResponse", "ChargeCurrencyRequest", "ChargeCurrencyResponse", "ConsumeConfirmMessage", "CurrencyChargeMessage", "ExchangeCurrencyRequest", "ExchangeCurrencyResponse", "GetBannerConfigRequest", "GetBannerConfigResponse", "GetChargeCouponDiscountRequest", "GetChargeCouponDiscountResponse", "GetChargeCurrencyConfigByChannelsRequest", "GetChargeCurrencyConfigByChannelsResponse", "GetChargeCurrencyConfigRequest", "GetChargeCurrencyConfigResponse", "GetChargeOrderStatusRequest", "GetChargeOrderStatusResponse", "GetHasChargeInActivityRequest", "GetHasChargeInActivityResponse", "GetUserAccountHistoryRequest", "GetUserAccountHistoryResponse", "GetUserAccountRequest", "GetUserAccountResponse", "GetUserCouponStoreRequest", "GetUserCouponStoreResponse", "GetUserYbDetailsRequest", "GetUserYbDetailsResponse", "ReportPurchaseRequest", "ReportPurchaseResponse", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1372084101, "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/RevenueServerConst;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1372084101, "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/RevenueServerConst;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    public RevenueServerConst() {
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
}
