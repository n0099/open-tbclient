package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagItemInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.SplitRecordItem;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class GetChargeOrderStatusResponse implements IBaseJsonResponse {
    public long amount;
    public int appId;
    public long currencyAmount;
    public int currencyType;
    public String expand;
    public boolean finish;
    public int hasGotSalePromotion;
    public String message;
    public int result;
    public String seq;
    public int status;
    public long uid;
    public int usedChannel;
    public int cmd = RevenueServerConst.GetChargeOrderStatusResponse;
    public List<GiftBagsInfo> giftbags = new ArrayList();
    public List<SplitRecordItem> splitRecordItemList = new ArrayList();

    public GetChargeOrderStatusResponse(String str) {
        parserResponse(str);
    }

    public GetChargeOrderStatusResult getResponse() {
        return new GetChargeOrderStatusResult(this.expand, this.status, this.message, this.hasGotSalePromotion, this.currencyType, this.amount, this.currencyAmount, this.finish, this.giftbags, this.splitRecordItemList);
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

    public List<SplitRecordItem> optSplitRecordItemList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                SplitRecordItem splitRecordItem = new SplitRecordItem();
                splitRecordItem.type = optJSONObject.optInt("type");
                splitRecordItem.id = optJSONObject.optString("id");
                splitRecordItem.name = optJSONObject.optString("name");
                splitRecordItem.value = optJSONObject.optString("value");
                arrayList.add(splitRecordItem);
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
                    this.uid = jSONObject.optLong("uid");
                    this.seq = jSONObject.optString("seq");
                    this.result = jSONObject.optInt("result");
                    this.message = jSONObject.optString("message");
                    this.appId = jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                    this.usedChannel = jSONObject.optInt("usedChannel");
                    this.expand = jSONObject.optString("expand");
                    this.status = jSONObject.optInt("status");
                    this.hasGotSalePromotion = jSONObject.optInt("hasGotSalePromotion");
                    this.currencyAmount = jSONObject.optLong("currencyAmount");
                    this.currencyType = jSONObject.optInt("currencyType");
                    this.amount = jSONObject.optLong(PayUiEventContent.AMOUNT);
                    this.finish = jSONObject.optBoolean("finish", false);
                    this.giftbags.addAll(optGiftBagsInfoList(jSONObject.optJSONArray("giftbags")));
                    this.splitRecordItemList.addAll(optSplitRecordItemList(jSONObject.optJSONArray("splitDetailList")));
                    return;
                }
                throw new Exception(this.cmd + " != " + optInt);
            } catch (JSONException e) {
                RLog.error("GetChargeOrderStatusResponse", "parserResponse error.", e);
                return;
            } catch (Exception e2) {
                RLog.error("GetChargeOrderStatusResponse", "parserResponse error.", e2);
                return;
            }
        }
        RLog.error("GetChargeOrderStatusResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
    }
}
