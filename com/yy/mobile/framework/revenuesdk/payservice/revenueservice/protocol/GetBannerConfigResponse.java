package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import com.yy.mobile.framework.revenuesdk.payapi.bean.BannerConfigItem;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetBannerConfigResponse implements IBaseJsonResponse {
    public String expand;
    public String message;
    public int result;
    public String seq;
    public long uid;
    public int cmd = RevenueServerConst.GetBannerConfigResponse;
    public List<BannerConfigItem> bannerConfigItemList = new ArrayList();

    public GetBannerConfigResponse(String str) {
        parserResponse(str);
    }

    public BannerConfigResult getResponse() {
        return new BannerConfigResult(this.bannerConfigItemList);
    }

    public List<BannerConfigItem> optBannerConfigItemList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                BannerConfigItem bannerConfigItem = new BannerConfigItem();
                bannerConfigItem.type = optJSONObject.optInt("type");
                bannerConfigItem.autoPlayTime = optJSONObject.optInt("autoPlayTime");
                ArrayList arrayList2 = new ArrayList();
                bannerConfigItem.bannerInfoList = arrayList2;
                arrayList2.addAll(optBannerInfoList(optJSONObject.optJSONArray("bannerInfoList")));
                arrayList.add(bannerConfigItem);
            }
        }
        return arrayList;
    }

    public List<BannerConfigItem.BannerInfo> optBannerInfoList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                BannerConfigItem.BannerInfo bannerInfo = new BannerConfigItem.BannerInfo();
                bannerInfo.id = optJSONObject.optString("id");
                bannerInfo.imageUrl = optJSONObject.optString("imageUrl");
                bannerInfo.jumpData = optJSONObject.optString("jumpData");
                bannerInfo.jumpType = optJSONObject.optInt("jumpType");
                arrayList.add(bannerInfo);
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
                    this.expand = jSONObject.optString("expand");
                    this.message = jSONObject.optString("message");
                    this.bannerConfigItemList.addAll(optBannerConfigItemList(jSONObject.optJSONArray("confList")));
                    return;
                }
                throw new Exception(this.cmd + " != " + optInt);
            } catch (Exception e) {
                RLog.error("GetBannerConfigResponse", "parserResponse error.", e);
                return;
            }
        }
        RLog.error("ChargeCurrencyResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
    }
}
