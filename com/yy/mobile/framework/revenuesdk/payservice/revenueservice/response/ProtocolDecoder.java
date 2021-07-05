package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.response;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.activity.LoadExternalWebViewActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.AccountDelayMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ConsumeConfirmMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.MyBalanceInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.CouponDiscountResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.HasChargeInActivityResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.PayOrderResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ReportPurchaseResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.RevenueRecordResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.UserCouponStoreResult;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.ChargeCurrencyResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.ErrorResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.ExchangeCurrencyResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetBannerConfigResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetChargeCouponDiscountResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetChargeCurrencyConfigChannelsResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetChargeCurrencyConfigResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetChargeOrderStatusResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetHasChargeInActivityResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetUserAccountHistoryResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetUserAccountResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetUserCouponStoreResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetUserYbDetailsResponsee;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.QueryRechargeHistoryResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.ReportPurchaseResponse;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\n\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\r\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ=\u0010\r\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\r\u0010\u0010J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0012\u0010\u0015J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0004\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0017\u0010\u0019J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u001b\u0010\u001d¨\u0006 "}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/response/ProtocolDecoder;", "", "command", "", "data", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/response/ServiceResponse;", "decode", "(ILjava/lang/String;)Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/response/ServiceResponse;", IAdRequestParam.SEQ, "result", "decodeError", "(ILjava/lang/String;ILjava/lang/String;)Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/response/ServiceResponse;", "", "newResponse", "(ILjava/lang/String;Ljava/lang/Object;)Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/response/ServiceResponse;", "message", "(ILjava/lang/String;Ljava/lang/Object;ILjava/lang/String;)Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/response/ServiceResponse;", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/AccountDelayMessage;", "parseAccountDelayMessage", "(Ljava/lang/String;)Lcom/yy/mobile/framework/revenuesdk/payapi/bean/AccountDelayMessage;", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)Lcom/yy/mobile/framework/revenuesdk/payapi/bean/AccountDelayMessage;", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/ConsumeConfirmMessage;", "parseConsumeConfirmMessage", "(Ljava/lang/String;)Lcom/yy/mobile/framework/revenuesdk/payapi/bean/ConsumeConfirmMessage;", "(Lorg/json/JSONObject;)Lcom/yy/mobile/framework/revenuesdk/payapi/bean/ConsumeConfirmMessage;", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/CurrencyChargeMessage;", "parseCurrencyChargeMessage", "(Ljava/lang/String;)Lcom/yy/mobile/framework/revenuesdk/payapi/bean/CurrencyChargeMessage;", "(Lorg/json/JSONObject;)Lcom/yy/mobile/framework/revenuesdk/payapi/bean/CurrencyChargeMessage;", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class ProtocolDecoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ProtocolDecoder() {
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

    private final ServiceResponse newResponse(int i2, String str, Object obj) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(65537, this, i2, str, obj)) == null) ? newResponse(i2, str, obj, 1, "") : (ServiceResponse) invokeILL.objValue;
    }

    private final AccountDelayMessage parseAccountDelayMessage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            try {
                return parseAccountDelayMessage(new JSONObject(str));
            } catch (JSONException unused) {
                return null;
            }
        }
        return (AccountDelayMessage) invokeL.objValue;
    }

    private final ConsumeConfirmMessage parseConsumeConfirmMessage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) {
            try {
                return parseConsumeConfirmMessage(new JSONObject(str));
            } catch (JSONException unused) {
                return null;
            }
        }
        return (ConsumeConfirmMessage) invokeL.objValue;
    }

    private final CurrencyChargeMessage parseCurrencyChargeMessage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) {
            RLog.error("ProtocolDecoder", "parseCurrencyChargeMessage:" + str, new Object[0]);
            try {
                return parseCurrencyChargeMessage(new JSONObject(str));
            } catch (JSONException unused) {
                return null;
            }
        }
        return (CurrencyChargeMessage) invokeL.objValue;
    }

    public final ServiceResponse decode(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, str)) == null) {
            switch (i2) {
                case 2005:
                    GetUserAccountResponse getUserAccountResponse = new GetUserAccountResponse(str);
                    return newResponse(1005, getUserAccountResponse.seq, new MyBalanceResult(new MyBalanceInfo(getUserAccountResponse.accountList, getUserAccountResponse.accountPeriodList, getUserAccountResponse.minAmountLimit)), getUserAccountResponse.result, getUserAccountResponse.message);
                case RevenueServerConst.GetChargeCurrencyConfigResponse /* 2021 */:
                    GetChargeCurrencyConfigResponse getChargeCurrencyConfigResponse = new GetChargeCurrencyConfigResponse(str);
                    Object productListResult = new ProductListResult(getChargeCurrencyConfigResponse.currencyType, getChargeCurrencyConfigResponse.currencyName, getChargeCurrencyConfigResponse.paysSettingInfo, getChargeCurrencyConfigResponse.confList, getChargeCurrencyConfigResponse.payWayInfoList);
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("GetChargeCurrencyConfigResponse response.seq = %s", Arrays.copyOf(new Object[]{getChargeCurrencyConfigResponse.seq}, 1));
                    Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                    RLog.debug("ProtocolDecoder", format);
                    return newResponse(1021, getChargeCurrencyConfigResponse.seq, productListResult, getChargeCurrencyConfigResponse.result, "");
                case RevenueServerConst.ChargeCurrencyResponse /* 2022 */:
                    ChargeCurrencyResponse chargeCurrencyResponse = new ChargeCurrencyResponse(str);
                    Object payOrderResult = new PayOrderResult(chargeCurrencyResponse.result, chargeCurrencyResponse.payUrl, chargeCurrencyResponse.payChannel, chargeCurrencyResponse.orderId, chargeCurrencyResponse.payMethod, chargeCurrencyResponse.closeRiskEnhance, chargeCurrencyResponse.expand, chargeCurrencyResponse.pollingModeInfo);
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String format2 = String.format("ChargeCurrencyResponse response.seq = %s", Arrays.copyOf(new Object[]{chargeCurrencyResponse.seq}, 1));
                    Intrinsics.checkExpressionValueIsNotNull(format2, "java.lang.String.format(format, *args)");
                    RLog.debug("ProtocolDecoder", format2);
                    return newResponse(1022, chargeCurrencyResponse.seq, payOrderResult, chargeCurrencyResponse.result, "");
                case RevenueServerConst.ExchangeCurrencyResponse /* 2025 */:
                    ExchangeCurrencyResponse exchangeCurrencyResponse = new ExchangeCurrencyResponse(str);
                    return newResponse(1025, exchangeCurrencyResponse.getSeq(), exchangeCurrencyResponse.getResponse(), exchangeCurrencyResponse.getResult(), exchangeCurrencyResponse.getMessage());
                case RevenueServerConst.GetHasChargeInActivityResponse /* 2026 */:
                    GetHasChargeInActivityResponse getHasChargeInActivityResponse = new GetHasChargeInActivityResponse(str);
                    return newResponse(1026, getHasChargeInActivityResponse.seq, new HasChargeInActivityResult(getHasChargeInActivityResponse.activityId, getHasChargeInActivityResponse.startTime, getHasChargeInActivityResponse.endTime, getHasChargeInActivityResponse.hasCharge, getHasChargeInActivityResponse.tip, getHasChargeInActivityResponse.chargeCount), getHasChargeInActivityResponse.result, getHasChargeInActivityResponse.message);
                case RevenueServerConst.ReportPurchaseResponse /* 2045 */:
                    ReportPurchaseResponse reportPurchaseResponse = new ReportPurchaseResponse(str);
                    return newResponse(1045, reportPurchaseResponse.seq, new ReportPurchaseResult(reportPurchaseResponse.purchaseData, reportPurchaseResponse.purchaseSign, reportPurchaseResponse.orderId), reportPurchaseResponse.result, reportPurchaseResponse.message);
                case RevenueServerConst.GetUserAccountHistoryResponse /* 2046 */:
                    GetUserAccountHistoryResponse getUserAccountHistoryResponse = new GetUserAccountHistoryResponse(str);
                    return newResponse(1046, getUserAccountHistoryResponse.seq, new RevenueRecordResult(getUserAccountHistoryResponse.userAccountHistoryInfos, getUserAccountHistoryResponse.hasMore), getUserAccountHistoryResponse.result, getUserAccountHistoryResponse.message);
                case RevenueServerConst.GetUserCouponStoreResponse /* 2047 */:
                    GetUserCouponStoreResponse getUserCouponStoreResponse = new GetUserCouponStoreResponse(str);
                    return newResponse(1047, getUserCouponStoreResponse.seq, new UserCouponStoreResult(getUserCouponStoreResponse.serverCurrentTime, getUserCouponStoreResponse.userCouponStoreList), getUserCouponStoreResponse.result, getUserCouponStoreResponse.message);
                case RevenueServerConst.GetChargeCouponDiscountResponse /* 2052 */:
                    GetChargeCouponDiscountResponse getChargeCouponDiscountResponse = new GetChargeCouponDiscountResponse(str);
                    return newResponse(RevenueServerConst.GetChargeCouponDiscountRequest, getChargeCouponDiscountResponse.seq, new CouponDiscountResult(getChargeCouponDiscountResponse.userCouponId, getChargeCouponDiscountResponse.couponDiscountInfoList), getChargeCouponDiscountResponse.result, getChargeCouponDiscountResponse.message);
                case RevenueServerConst.ChargeCurrencyHistoryResponse /* 2054 */:
                    QueryRechargeHistoryResponse queryRechargeHistoryResponse = new QueryRechargeHistoryResponse(str);
                    return newResponse(RevenueServerConst.ChargeCurrencyHistoryRequest, queryRechargeHistoryResponse.getSeq(), queryRechargeHistoryResponse.getResponse(), queryRechargeHistoryResponse.getResult(), queryRechargeHistoryResponse.getMessage());
                case RevenueServerConst.GetChargeCurrencyConfigByChannelsResponse /* 2060 */:
                    GetChargeCurrencyConfigChannelsResponse getChargeCurrencyConfigChannelsResponse = new GetChargeCurrencyConfigChannelsResponse(str);
                    Object productListResult2 = new ProductListResult(getChargeCurrencyConfigChannelsResponse.currencyType, null, null, getChargeCurrencyConfigChannelsResponse.confList, null);
                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                    String format3 = String.format("GetChargeCurrencyConfigByChannelsResponse response.seq = %s", Arrays.copyOf(new Object[]{getChargeCurrencyConfigChannelsResponse.seq}, 1));
                    Intrinsics.checkExpressionValueIsNotNull(format3, "java.lang.String.format(format, *args)");
                    RLog.debug("ProtocolDecoder", format3);
                    return newResponse(RevenueServerConst.GetChargeCurrencyConfigByChannelsRequest, getChargeCurrencyConfigChannelsResponse.seq, productListResult2);
                case RevenueServerConst.GetChargeOrderStatusResponse /* 2061 */:
                    GetChargeOrderStatusResponse getChargeOrderStatusResponse = new GetChargeOrderStatusResponse(str);
                    return newResponse(RevenueServerConst.GetChargeOrderStatusRequest, getChargeOrderStatusResponse.seq, getChargeOrderStatusResponse.getResponse(), getChargeOrderStatusResponse.result, getChargeOrderStatusResponse.message);
                case RevenueServerConst.GetUserYbDetailsResponse /* 2068 */:
                    GetUserYbDetailsResponsee getUserYbDetailsResponsee = new GetUserYbDetailsResponsee(str);
                    return newResponse(RevenueServerConst.GetUserYbDetailsRequest, getUserYbDetailsResponsee.getSeq(), getUserYbDetailsResponsee.getResponse(), getUserYbDetailsResponsee.getResult(), getUserYbDetailsResponsee.getMessage());
                case RevenueServerConst.GetBannerConfigResponse /* 2071 */:
                    GetBannerConfigResponse getBannerConfigResponse = new GetBannerConfigResponse(str);
                    return newResponse(RevenueServerConst.GetBannerConfigRequest, getBannerConfigResponse.seq, getBannerConfigResponse.getResponse(), getBannerConfigResponse.result, getBannerConfigResponse.message);
                case RevenueServerConst.ConsumeConfirmMessage /* 40423235 */:
                    ConsumeConfirmMessage parseConsumeConfirmMessage = parseConsumeConfirmMessage(str);
                    return newResponse(RevenueServerConst.ConsumeConfirmMessage, parseConsumeConfirmMessage != null ? parseConsumeConfirmMessage.seq : null, parseConsumeConfirmMessage);
                case RevenueServerConst.CurrencyChargeMessage /* 40423898 */:
                    return newResponse(RevenueServerConst.CurrencyChargeMessage, "", parseCurrencyChargeMessage(str));
                case RevenueServerConst.AccountDelayMessage /* 40424536 */:
                    return newResponse(RevenueServerConst.AccountDelayMessage, "", parseAccountDelayMessage(str));
                default:
                    StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                    String format4 = String.format("decode  null", Arrays.copyOf(new Object[0], 0));
                    Intrinsics.checkExpressionValueIsNotNull(format4, "java.lang.String.format(format, *args)");
                    RLog.info("ProtocolDecoder", format4);
                    return decodeError(i2, "", -1, str);
            }
        }
        return (ServiceResponse) invokeIL.objValue;
    }

    public final ServiceResponse decodeError(int i2, String str, int i3, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2})) == null) ? newResponse(new ErrorResponse(str2).cmd, str, null, i3, "revenue sdk respone parse error") : (ServiceResponse) invokeCommon.objValue;
    }

    private final ServiceResponse newResponse(int i2, String str, Object obj, int i3, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), str, obj, Integer.valueOf(i3), str2})) == null) {
            ServiceResponse serviceResponse = new ServiceResponse(i2, str, i3, str2);
            serviceResponse.setData(obj);
            return serviceResponse;
        }
        return (ServiceResponse) invokeCommon.objValue;
    }

    private final AccountDelayMessage parseAccountDelayMessage(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, jSONObject)) == null) {
            if (jSONObject != null) {
                AccountDelayMessage accountDelayMessage = new AccountDelayMessage();
                accountDelayMessage.appid = jSONObject.optInt("appid");
                accountDelayMessage.uid = jSONObject.optLong("uid");
                accountDelayMessage.usedChannel = jSONObject.optInt("usedChannel");
                accountDelayMessage.currencyType = jSONObject.optInt("currencyType");
                accountDelayMessage.amount = jSONObject.optLong(PayUiEventContent.AMOUNT);
                accountDelayMessage.currencyAmount = jSONObject.optLong("currencyAmount");
                accountDelayMessage.expand = jSONObject.optString("expand");
                return accountDelayMessage;
            }
            return null;
        }
        return (AccountDelayMessage) invokeL.objValue;
    }

    public final ConsumeConfirmMessage parseConsumeConfirmMessage(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            if (jSONObject != null) {
                ConsumeConfirmMessage consumeConfirmMessage = new ConsumeConfirmMessage();
                consumeConfirmMessage.result = jSONObject.optInt("result", -1);
                consumeConfirmMessage.seq = jSONObject.optString(IAdRequestParam.SEQ, "");
                consumeConfirmMessage.uid = jSONObject.optLong("uid", 0L);
                consumeConfirmMessage.user_yy_num = jSONObject.optString("user_yy_num", "");
                consumeConfirmMessage.user_nick_name = jSONObject.optString("user_nick_name", "");
                consumeConfirmMessage.recv_uid = jSONObject.optLong("recv_uid", 0L);
                consumeConfirmMessage.recv_yy_num = jSONObject.optString("recv_yy_num", "");
                consumeConfirmMessage.recv_nick_name = jSONObject.optString("recv_nick_name", "");
                consumeConfirmMessage.business_type = jSONObject.optInt(LoadExternalWebViewActivity.EXTRA_BUSINESS_TYPE, 0);
                consumeConfirmMessage.props_id = jSONObject.optInt("props_id", 0);
                consumeConfirmMessage.props_count = jSONObject.optInt("props_count", 0);
                consumeConfirmMessage.props_buy_count = jSONObject.optInt("props_buy_count", 0);
                consumeConfirmMessage.props_buy_currency_type = jSONObject.optInt("props_buy_currency_type", 0);
                consumeConfirmMessage.props_buy_currency_amount = jSONObject.optDouble("props_buy_currency_amount", 0.0d);
                consumeConfirmMessage.version = jSONObject.optInt("version", 0);
                consumeConfirmMessage.expand = jSONObject.optString("expand", "");
                consumeConfirmMessage.appid = jSONObject.optInt("appid", 0);
                return consumeConfirmMessage;
            }
            return null;
        }
        return (ConsumeConfirmMessage) invokeL.objValue;
    }

    private final CurrencyChargeMessage parseCurrencyChargeMessage(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, jSONObject)) == null) {
            if (jSONObject != null) {
                CurrencyChargeMessage currencyChargeMessage = new CurrencyChargeMessage();
                currencyChargeMessage.status = 1;
                currencyChargeMessage.appid = jSONObject.optInt("appid");
                currencyChargeMessage.uid = jSONObject.optLong("uid");
                currencyChargeMessage.usedChannel = jSONObject.optInt("usedChannel");
                currencyChargeMessage.currencyType = jSONObject.optInt("currencyType");
                currencyChargeMessage.amount = jSONObject.optLong(PayUiEventContent.AMOUNT);
                currencyChargeMessage.currencyAmount = jSONObject.optLong("currencyAmount");
                currencyChargeMessage.orderId = jSONObject.optString("orderId");
                currencyChargeMessage.expand = jSONObject.optString("expand");
                return currencyChargeMessage;
            }
            return null;
        }
        return (CurrencyChargeMessage) invokeL.objValue;
    }
}
