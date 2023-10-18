package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.dto.IsShowRealNameGuideDTO;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagItemInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagTagInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaysSettingInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PropsInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.SplitMinAmountInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GetChargeCurrencyConfigResponse implements IBaseJsonResponse {
    public String bubbleActMsg;
    public String currencyName;
    public int currencyType;
    public int defaultCid;
    public String expend;
    public PaysSettingInfo paysSettingInfo;
    public int result;
    public String seq;
    public long uid;
    public int cmd = 2021;
    public List<ProductInfo> confList = new ArrayList();
    public List<PayWayInfo> payWayInfoList = new ArrayList();

    public GetChargeCurrencyConfigResponse(String str) {
        parserResponse(str);
    }

    public List<SplitMinAmountInfo> optSplitMinAmountInfoList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                SplitMinAmountInfo splitMinAmountInfo = new SplitMinAmountInfo();
                splitMinAmountInfo.minAmount = optJSONObject.optInt("minAmount");
                splitMinAmountInfo.splitType = optJSONObject.optInt("type");
                arrayList.add(splitMinAmountInfo);
            }
        }
        return arrayList;
    }

    private List<CurrencyInfo> optOtherCurrencies(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
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

    private List<PropsInfo> optProps(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
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

    public List<GiftBagTagInfo> optGiftBagTagInfoList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                GiftBagTagInfo giftBagTagInfo = new GiftBagTagInfo();
                giftBagTagInfo.tag = optJSONObject.optString("tag", "");
                giftBagTagInfo.tagPos = optJSONObject.optInt("tagPos");
                arrayList.add(giftBagTagInfo);
            }
        }
        return arrayList;
    }

    public List<GiftBagItemInfo> optGiftBagItemInfoList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                GiftBagItemInfo giftBagItemInfo = new GiftBagItemInfo();
                giftBagItemInfo.type = optJSONObject.optString("type");
                giftBagItemInfo.name = optJSONObject.optString("name");
                giftBagItemInfo.pid = optJSONObject.optString("pid");
                giftBagItemInfo.count = optJSONObject.optInt("count");
                giftBagItemInfo.imgUrl = optJSONObject.optString("imgUrl");
                giftBagItemInfo.typeName = optJSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME);
                giftBagItemInfo.countDisplay = optJSONObject.optString("countDisplay");
                arrayList.add(giftBagItemInfo);
            }
        }
        return arrayList;
    }

    public List<GiftBagsInfo> optGiftBagsInfoList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                GiftBagsInfo giftBagsInfo = new GiftBagsInfo();
                giftBagsInfo.giftbagTitle = optJSONObject.optString("giftbagTitle", "");
                giftBagsInfo.offersTips = optJSONObject.optString("offersTips", "");
                giftBagsInfo.giveupTitle = optJSONObject.optString("giveupTitle", "");
                giftBagsInfo.giveupSubtitle = optJSONObject.optString("giveupSubtitle", "");
                giftBagsInfo.giveupButtonMsg = optJSONObject.optString("giveupButtonMsg", "");
                giftBagsInfo.successTitle = optJSONObject.optString("successTitle", "");
                giftBagsInfo.successButtonMsg = optJSONObject.optString("successButtonMsg", "");
                giftBagsInfo.giftbag.addAll(optGiftBagItemInfoList(optJSONObject.optJSONArray("giftbag")));
                arrayList.add(giftBagsInfo);
            }
        }
        return arrayList;
    }

    public List<PayWayInfo> optPayWayInfoList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                PayWayInfo payWayInfo = new PayWayInfo();
                payWayInfo.id = optJSONObject.optString("id");
                payWayInfo.name = optJSONObject.optString("name");
                payWayInfo.payChannel = optJSONObject.optString("payChannel");
                payWayInfo.payMethod = optJSONObject.optString("payMethod");
                payWayInfo.tips = optJSONObject.optString("tips");
                payWayInfo.payMethod = optJSONObject.optString("payMethod");
                payWayInfo.showInAmountView = optJSONObject.optBoolean("showInAmountView", false);
                payWayInfo.perFreePassAmount = optJSONObject.optDouble("perFreePassAmount", 0.0d);
                payWayInfo.passFreeAlwaysConfirm = optJSONObject.optBoolean("passFreeAlwaysConfirm", false);
                arrayList.add(payWayInfo);
            }
        }
        return arrayList;
    }

    public List<ProductInfo> optProductList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                ProductInfo productInfo = new ProductInfo();
                productInfo.cid = optJSONObject.optInt("cid");
                productInfo.offersTips = optJSONObject.optString("offersTips");
                productInfo.name = optJSONObject.optString("name");
                productInfo.level = optJSONObject.optInt("level");
                productInfo.srcAmount = optJSONObject.optDouble("srcAmount");
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
                productInfo.giftbags.addAll(optGiftBagsInfoList(optJSONObject.optJSONArray("giftbags")));
                productInfo.giftBagTagInfos.addAll(optGiftBagTagInfoList(optJSONObject.optJSONArray("tags")));
                arrayList.add(productInfo);
            }
        }
        return arrayList;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse
    public void parserResponse(String str) {
        if (str != null && !"".equals(str.trim())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("cmd");
                if (this.cmd == optInt) {
                    this.result = jSONObject.optInt("result");
                    this.uid = jSONObject.optLong("uid");
                    this.seq = jSONObject.optString("seq");
                    this.expend = jSONObject.optString("expand");
                    this.currencyType = jSONObject.optInt("currencyType");
                    this.currencyName = jSONObject.optString("currencyName");
                    this.paysSettingInfo = new PaysSettingInfo();
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString(IsShowRealNameGuideDTO.TYPE_SETTING));
                    this.paysSettingInfo.customerServiceHotline = jSONObject2.optString("payChargeAmountLimit");
                    this.paysSettingInfo.customerServiceMsg = jSONObject2.optString("customerServiceMsg");
                    this.paysSettingInfo.payChargeAmountLimit = jSONObject2.optInt("payChargeAmountLimit");
                    this.paysSettingInfo.successMsg = jSONObject2.optString("successMsg");
                    this.paysSettingInfo.payRemindMsg = jSONObject2.optString("payRemindMsg");
                    this.paysSettingInfo.feedbackSwitch = jSONObject2.optInt("feedbackSwitch");
                    this.paysSettingInfo.splitMinAmountInfoList.addAll(optSplitMinAmountInfoList(jSONObject.optJSONArray("splitMinAmountConfigs")));
                    this.defaultCid = jSONObject.optInt("defaultCid");
                    this.confList.addAll(optProductList(jSONObject.optJSONArray("confList")));
                    this.payWayInfoList.addAll(optPayWayInfoList(jSONObject.optJSONArray("payWayList")));
                    this.bubbleActMsg = jSONObject.optString("bubbleActMsg");
                    return;
                }
                throw new Exception(this.cmd + " != " + optInt);
            } catch (JSONException e) {
                RLog.error("GetChargeCurrencyConfigResponse", "parserResponse error.", e);
                return;
            } catch (Exception e2) {
                RLog.error("GetChargeCurrencyConfigResponse", "parserResponse error.", e2);
                return;
            }
        }
        RLog.error("GetChargeCurrencyConfigResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
    }

    public String toString() {
        return "GetChargeCurrencyConfigResponse{cmd=" + this.cmd + ", seq='" + this.seq + "', expand='" + this.expend + "', currencyType=" + this.currencyType + ", confList=" + this.confList + '}';
    }
}
