package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import android.text.TextUtils;
import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ChargeCurrencyRequest implements IRequestProtocol {
    public double amount;
    public int appId;
    public int chargeCurrencyConfigId;
    public String clientVersion;
    public int currencyType;
    public String expand;
    public boolean needUnicast;
    public String payChannel;
    public String payMethod;
    public String returnUrl;
    public String seq;
    public int sid;
    public long uid;
    public int usedChannel;

    /* loaded from: classes9.dex */
    public static class ExpandBuilder {
        public final String hdid;
        public final String product_id;
        public final int quantity;
        public final String srcCurrencySymbol;
        public final Double unitPrice;

        public ExpandBuilder(int i, Double d, String str, String str2, String str3) {
            this.quantity = i;
            this.unitPrice = d;
            this.product_id = str;
            this.hdid = str2;
            this.srcCurrencySymbol = str3;
        }

        public String toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("quantity", this.quantity);
                jSONObject.put("unitPrice", this.unitPrice);
                jSONObject.put("product_id", this.product_id);
                jSONObject.put("hdid", this.hdid);
                jSONObject.put("srcCurrencySymbol", this.srcCurrencySymbol);
            } catch (JSONException e) {
                RLog.error("ChargeCurrencyRequest", "ExpandBuilder.toJson", e);
            }
            return jSONObject.toString();
        }
    }

    public ChargeCurrencyRequest(int i, int i2, String str, String str2, String str3, double d) {
        this(0L, i, i2, str, str2, str3, d);
    }

    public ChargeCurrencyRequest(long j, int i, int i2, int i3, int i4, String str, String str2, String str3, double d, int i5, boolean z, String str4, String str5, String str6, String str7) {
        this.sid = 0;
        this.usedChannel = 10002;
        this.chargeCurrencyConfigId = 0;
        this.needUnicast = true;
        this.returnUrl = "";
        this.expand = "";
        this.clientVersion = "";
        this.uid = j;
        this.sid = i;
        this.appId = i2;
        this.usedChannel = i3;
        this.currencyType = i4;
        this.seq = str;
        this.payChannel = str2;
        this.payMethod = str3;
        this.amount = d;
        this.chargeCurrencyConfigId = i5;
        this.needUnicast = z;
        this.returnUrl = str4;
        this.expand = str5;
        this.clientVersion = str6;
    }

    public ChargeCurrencyRequest(long j, int i, int i2, String str, String str2, String str3, double d) {
        this(j, 0, i, 10002, i2, str, str2, str3, d, 0, true, "", "", "1.0.0", "");
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", 1022);
            jSONObject.put("uid", this.uid);
            jSONObject.put("sid", this.sid);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
            jSONObject.put("usedChannel", this.usedChannel);
            jSONObject.put("currencyType", this.currencyType);
            jSONObject.put("seq", this.seq);
            jSONObject.put("payChannel", this.payChannel);
            jSONObject.put("payMethod", this.payMethod);
            jSONObject.put(PayUiEventContent.AMOUNT, this.amount);
            jSONObject.put("chargeCurrencyConfigId", this.chargeCurrencyConfigId);
            jSONObject.put("needUnicast", this.needUnicast);
            jSONObject.put("returnUrl", this.returnUrl);
            jSONObject.put("clientVersion", this.clientVersion);
            if (!TextUtils.isEmpty(this.expand)) {
                jSONObject.put("expand", this.expand);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            RLog.error("ChargeCurrencyRequest", "constructPSCIMessageRequest", e);
            return "";
        }
    }
}
