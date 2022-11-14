package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.response;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.MyBalanceInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.PayOrderResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.SplitOrderConfigResult;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.ChargeCurrencyResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.ErrorResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetBannerConfigResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetChargeCurrencyConfigResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetChargeOrderStatusResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetSplitOrderConfigResponse;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetUserAccountResponse;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\n\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\r\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ=\u0010\r\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\r\u0010\u0010J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0012\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/response/ProtocolDecoder;", "", "command", "", "data", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/response/ServiceResponse;", "decode", "(ILjava/lang/String;)Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/response/ServiceResponse;", "seq", TiebaStatic.LogFields.RESULT, "decodeError", "(ILjava/lang/String;ILjava/lang/String;)Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/response/ServiceResponse;", "", "newResponse", "(ILjava/lang/String;Ljava/lang/Object;)Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/response/ServiceResponse;", "message", "(ILjava/lang/String;Ljava/lang/Object;ILjava/lang/String;)Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/response/ServiceResponse;", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/CurrencyChargeMessage;", "parseCurrencyChargeMessage", "(Ljava/lang/String;)Lcom/yy/mobile/framework/revenuesdk/payapi/bean/CurrencyChargeMessage;", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)Lcom/yy/mobile/framework/revenuesdk/payapi/bean/CurrencyChargeMessage;", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class ProtocolDecoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ProtocolDecoder() {
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

    private final ServiceResponse newResponse(int i, String str, Object obj) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65537, this, i, str, obj)) == null) {
            return newResponse(i, str, obj, 1, "");
        }
        return (ServiceResponse) invokeILL.objValue;
    }

    private final ServiceResponse newResponse(int i, String str, Object obj, int i2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i), str, obj, Integer.valueOf(i2), str2})) == null) {
            ServiceResponse serviceResponse = new ServiceResponse(i, str, i2, str2);
            serviceResponse.setData(obj);
            return serviceResponse;
        }
        return (ServiceResponse) invokeCommon.objValue;
    }

    private final CurrencyChargeMessage parseCurrencyChargeMessage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            RLog.error("ProtocolDecoder", "parseCurrencyChargeMessage:" + str, new Object[0]);
            try {
                return parseCurrencyChargeMessage(new JSONObject(str));
            } catch (JSONException unused) {
                return null;
            }
        }
        return (CurrencyChargeMessage) invokeL.objValue;
    }

    private final CurrencyChargeMessage parseCurrencyChargeMessage(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONObject)) == null) {
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

    public final ServiceResponse decode(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, str)) == null) {
            if (i != 2005) {
                if (i != 2061) {
                    if (i != 2071) {
                        if (i != 2079) {
                            if (i != 40423898) {
                                if (i != 2021) {
                                    if (i != 2022) {
                                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                        String format = String.format("decode  null", Arrays.copyOf(new Object[0], 0));
                                        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                                        RLog.info("ProtocolDecoder", format);
                                        return decodeError(i, "", -1, str);
                                    }
                                    ChargeCurrencyResponse chargeCurrencyResponse = new ChargeCurrencyResponse(str);
                                    PayOrderResult payOrderResult = new PayOrderResult(chargeCurrencyResponse.result, chargeCurrencyResponse.payUrl, chargeCurrencyResponse.payChannel, chargeCurrencyResponse.orderId, chargeCurrencyResponse.payMethod, chargeCurrencyResponse.closeRiskEnhance, chargeCurrencyResponse.expand, chargeCurrencyResponse.pollingModeInfo);
                                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                                    String format2 = String.format("ChargeCurrencyResponse response.seq = %s", Arrays.copyOf(new Object[]{chargeCurrencyResponse.seq}, 1));
                                    Intrinsics.checkExpressionValueIsNotNull(format2, "java.lang.String.format(format, *args)");
                                    RLog.debug("ProtocolDecoder", format2);
                                    return newResponse(1022, chargeCurrencyResponse.seq, payOrderResult, chargeCurrencyResponse.result, chargeCurrencyResponse.message);
                                }
                                GetChargeCurrencyConfigResponse getChargeCurrencyConfigResponse = new GetChargeCurrencyConfigResponse(str);
                                ProductListResult productListResult = new ProductListResult(getChargeCurrencyConfigResponse.currencyType, getChargeCurrencyConfigResponse.currencyName, getChargeCurrencyConfigResponse.paysSettingInfo, getChargeCurrencyConfigResponse.confList, getChargeCurrencyConfigResponse.payWayInfoList, getChargeCurrencyConfigResponse.defaultCid, getChargeCurrencyConfigResponse.bubbleActMsg);
                                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                                String format3 = String.format("GetChargeCurrencyConfigResponse response.seq = %s", Arrays.copyOf(new Object[]{getChargeCurrencyConfigResponse.seq}, 1));
                                Intrinsics.checkExpressionValueIsNotNull(format3, "java.lang.String.format(format, *args)");
                                RLog.debug("ProtocolDecoder", format3);
                                return newResponse(1021, getChargeCurrencyConfigResponse.seq, productListResult, getChargeCurrencyConfigResponse.result, "");
                            }
                            return newResponse(RevenueServerConst.CurrencyChargeMessage, "", parseCurrencyChargeMessage(str));
                        }
                        GetSplitOrderConfigResponse getSplitOrderConfigResponse = new GetSplitOrderConfigResponse(str);
                        return newResponse(RevenueServerConst.GetChargeCurrencySplitRequest, getSplitOrderConfigResponse.seq, new SplitOrderConfigResult(getSplitOrderConfigResponse.needSplit, getSplitOrderConfigResponse.splitId, getSplitOrderConfigResponse.hintMsg, getSplitOrderConfigResponse.splitRecordItemList, getSplitOrderConfigResponse.bottomGuideMsg), getSplitOrderConfigResponse.result, getSplitOrderConfigResponse.message);
                    }
                    GetBannerConfigResponse getBannerConfigResponse = new GetBannerConfigResponse(str);
                    return newResponse(RevenueServerConst.GetBannerConfigRequest, getBannerConfigResponse.seq, getBannerConfigResponse.getResponse(), getBannerConfigResponse.result, getBannerConfigResponse.message);
                }
                GetChargeOrderStatusResponse getChargeOrderStatusResponse = new GetChargeOrderStatusResponse(str);
                return newResponse(RevenueServerConst.GetChargeOrderStatusRequest, getChargeOrderStatusResponse.seq, getChargeOrderStatusResponse.getResponse(), getChargeOrderStatusResponse.result, getChargeOrderStatusResponse.message);
            }
            GetUserAccountResponse getUserAccountResponse = new GetUserAccountResponse(str);
            return newResponse(1005, getUserAccountResponse.seq, new MyBalanceResult(new MyBalanceInfo(getUserAccountResponse.accountList, getUserAccountResponse.accountPeriodList, getUserAccountResponse.minAmountLimit, getUserAccountResponse.imid)), getUserAccountResponse.result, getUserAccountResponse.message);
        }
        return (ServiceResponse) invokeIL.objValue;
    }

    public final ServiceResponse decodeError(int i, String str, int i2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), str2})) == null) {
            return newResponse(new ErrorResponse(str2).cmd, str, null, i2, "revenue sdk respone parse error");
        }
        return (ServiceResponse) invokeCommon.objValue;
    }
}
