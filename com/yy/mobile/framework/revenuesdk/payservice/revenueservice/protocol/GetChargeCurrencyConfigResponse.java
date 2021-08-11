package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.alipay.sdk.sys.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaysSettingInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PropsInfo;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GetChargeCurrencyConfigResponse implements IBaseJsonResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int cmd;
    public List<ProductInfo> confList;
    public String currencyName;
    public int currencyType;
    public String expend;
    public List<PayWayInfo> payWayInfoList;
    public PaysSettingInfo paysSettingInfo;
    public int result;
    public String seq;
    public long uid;

    public GetChargeCurrencyConfigResponse(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cmd = 2021;
        this.confList = new ArrayList();
        this.payWayInfoList = new ArrayList();
        parserResponse(str);
    }

    private List<CurrencyInfo> optOtherCurrencies(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray == null) {
                return arrayList;
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    CurrencyInfo currencyInfo = new CurrencyInfo();
                    currencyInfo.offers_currency_type = optJSONObject.optInt("offers_currency_type");
                    currencyInfo.offers_currency_amount = optJSONObject.optLong("offers_currency_amount");
                    currencyInfo.offers_currency_name = optJSONObject.optString("offers_currency_name");
                    arrayList.add(currencyInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    private List<PropsInfo> optProps(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray == null) {
                return arrayList;
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    PropsInfo propsInfo = new PropsInfo();
                    propsInfo.propid = optJSONObject.optInt(PersonalBackgroundPreviewActivityConfig.PROPID);
                    propsInfo.count = optJSONObject.optInt("count");
                    propsInfo.type = optJSONObject.optInt("type");
                    arrayList.add(propsInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public List<PayWayInfo> optPayWayInfoList(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray == null) {
                return arrayList;
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    PayWayInfo payWayInfo = new PayWayInfo();
                    payWayInfo.id = optJSONObject.optString("id");
                    payWayInfo.name = optJSONObject.optString("name");
                    payWayInfo.payChannel = optJSONObject.optString("payChannel");
                    payWayInfo.payMethod = optJSONObject.optString("payMethod");
                    payWayInfo.tips = optJSONObject.optString("tips");
                    payWayInfo.payMethod = optJSONObject.optString("payMethod");
                    arrayList.add(payWayInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public List<ProductInfo> optProductList(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray == null) {
                return arrayList;
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    ProductInfo productInfo = new ProductInfo();
                    productInfo.cid = optJSONObject.optInt(IAdRequestParam.CELL_ID);
                    productInfo.offersTips = optJSONObject.optString("offersTips");
                    productInfo.name = optJSONObject.optString("name");
                    productInfo.level = optJSONObject.optInt("level");
                    productInfo.srcAmount = Double.valueOf(optJSONObject.optDouble("srcAmount"));
                    productInfo.srcCurrencySymbol = optJSONObject.optString("srcCurrencySymbol");
                    productInfo.destAmount = optJSONObject.optLong("destAmount");
                    productInfo.offersType = optJSONObject.optInt("offersType");
                    productInfo.offersRate = optJSONObject.optInt("offersRate");
                    productInfo.offers_currency_same = optJSONObject.optBoolean("offers_currency_same");
                    productInfo.offers_currency_name = optJSONObject.optString("offers_currency_name");
                    productInfo.offers_currency_type = optJSONObject.optInt("offers_currency_type");
                    productInfo.hasAct = optJSONObject.optBoolean("hasAct");
                    productInfo.hasCurrencyAct = optJSONObject.optBoolean("hasCurrencyAct");
                    productInfo.hasDestCurrencyAct = optJSONObject.optBoolean("hasDestCurrencyAct");
                    productInfo.spAmount = optJSONObject.optLong("spAmount");
                    productInfo.spSumAmount = optJSONObject.optLong("spSumAmount");
                    productInfo.hasOtherCurrencyAct = optJSONObject.optBoolean("hasOtherCurrencyAct");
                    productInfo.otherCurrenciesSum = optJSONObject.optInt("otherCurrenciesSum");
                    productInfo.otherCurrencies.addAll(optOtherCurrencies(optJSONObject.optJSONArray("otherCurrencies")));
                    productInfo.hasFirstRush = optJSONObject.optBoolean("hasFirstRush");
                    productInfo.firstRushAmount = optJSONObject.optLong("firstRushAmount");
                    productInfo.hasPropsAct = optJSONObject.optBoolean("hasPropsAct");
                    productInfo.propsSum = optJSONObject.optInt("propsSum");
                    productInfo.props.addAll(optProps(optJSONObject.optJSONArray("props")));
                    productInfo.chargeRate = Double.valueOf(optJSONObject.optDouble("chargeRate"));
                    productInfo.productId = optJSONObject.optString("productId");
                    productInfo.expand = optJSONObject.optString("expand");
                    productInfo.currencyCode = optJSONObject.optString("currencyCode");
                    productInfo.otherPrice = optJSONObject.optString("otherPrice");
                    productInfo.payChannel = optJSONObject.optString("payChannel");
                    productInfo.payMethod = optJSONObject.optString("payMethod");
                    productInfo.subChannel = optJSONObject.optString("subChannel");
                    productInfo.payType = optJSONObject.optString("payType");
                    productInfo.usedChannelType = optJSONObject.optInt("usedChannelType");
                    arrayList.add(productInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse
    public void parserResponse(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (str != null && !"".equals(str.trim())) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("cmd");
                    if (this.cmd == optInt) {
                        this.result = jSONObject.optInt("result");
                        this.uid = jSONObject.optLong("uid");
                        this.seq = jSONObject.optString(IAdRequestParam.SEQ);
                        this.expend = jSONObject.optString("expand");
                        this.currencyType = jSONObject.optInt("currencyType");
                        this.currencyName = jSONObject.optString("currencyName");
                        this.paysSettingInfo = new PaysSettingInfo();
                        JSONObject jSONObject2 = new JSONObject(jSONObject.optString(a.f35824j));
                        this.paysSettingInfo.customerServiceHotline = jSONObject2.optString("payChargeAmountLimit");
                        this.paysSettingInfo.customerServiceMsg = jSONObject2.optString("customerServiceMsg");
                        this.paysSettingInfo.payChargeAmountLimit = jSONObject2.optInt("payChargeAmountLimit");
                        this.paysSettingInfo.successMsg = jSONObject2.optString("successMsg");
                        this.confList.addAll(optProductList(jSONObject.optJSONArray("confList")));
                        this.payWayInfoList.addAll(optPayWayInfoList(jSONObject.optJSONArray("payWayList")));
                        return;
                    }
                    throw new Exception(this.cmd + " != " + optInt);
                } catch (JSONException e2) {
                    RLog.error("GetChargeCurrencyConfigResponse", "parserResponse error.", e2);
                    return;
                } catch (Exception e3) {
                    RLog.error("GetChargeCurrencyConfigResponse", "parserResponse error.", e3);
                    return;
                }
            }
            RLog.error("GetChargeCurrencyConfigResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "GetChargeCurrencyConfigResponse{cmd=" + this.cmd + ", uid=" + this.uid + ", seq='" + this.seq + ExtendedMessageFormat.QUOTE + ", expand='" + this.expend + ExtendedMessageFormat.QUOTE + ", currencyType=" + this.currencyType + ", confList=" + this.confList + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
