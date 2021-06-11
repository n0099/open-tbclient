package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GetChargeCurrencyConfigChannelsRequest implements IRequestProtocol {
    public int appId;
    public int currencyType;
    public String expand;
    public String seq;
    public long uid;
    public List<Integer> usedChannelList;

    public GetChargeCurrencyConfigChannelsRequest(int i2, int i3, String str) {
        this(0L, i2, i3, str);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        List<Integer> list = this.usedChannelList;
        if (list != null) {
            for (Integer num : list) {
                jSONArray.put(num);
            }
        }
        try {
            jSONObject.put("cmd", RevenueServerConst.GetChargeCurrencyConfigByChannelsRequest);
            jSONObject.put("uid", this.uid);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
            jSONObject.put("usedChannelList", jSONArray);
            jSONObject.put("currencyType", this.currencyType);
            jSONObject.put(IAdRequestParam.SEQ, this.seq);
            jSONObject.put("expand", this.expand);
            return jSONObject.toString();
        } catch (JSONException e2) {
            RLog.error("GetChargeCurrencyConfigChannelsRequest", "GetChargeCurrencyConfigChannelsRequest error.", e2);
            return "";
        }
    }

    public GetChargeCurrencyConfigChannelsRequest(long j, int i2, int i3, String str) {
        this(j, i2, new ArrayList(), i3, str, "", "");
    }

    public GetChargeCurrencyConfigChannelsRequest(long j, int i2, List<Integer> list, int i3, String str, String str2, String str3) {
        this.expand = "";
        this.uid = j;
        this.appId = i2;
        this.usedChannelList = list;
        this.currencyType = i3;
        this.seq = str;
        this.expand = str3;
    }
}
