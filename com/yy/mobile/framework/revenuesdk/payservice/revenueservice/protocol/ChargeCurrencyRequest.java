package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.aps.megapp_interface.BuildConfig;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public static class ExpandBuilder {
        public final String hdid;
        public final String product_id;
        public final int quantity;
        public final String srcCurrencySymbol;
        public final Double unitPrice;

        public ExpandBuilder(int i2, Double d2, String str, String str2, String str3) {
            this.quantity = i2;
            this.unitPrice = d2;
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
            } catch (JSONException e2) {
                RLog.error("ChargeCurrencyRequest", "ExpandBuilder.toJson", e2);
            }
            return jSONObject.toString();
        }
    }

    public ChargeCurrencyRequest(int i2, int i3, String str, String str2, String str3, double d2) {
        this(0, i2, i3, str, str2, str3, d2);
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
            jSONObject.put(IAdRequestParam.SEQ, this.seq);
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
        } catch (JSONException e2) {
            RLog.error("ChargeCurrencyRequest", "constructPSCIMessageRequest", e2);
            return "";
        }
    }

    public ChargeCurrencyRequest(int i2, int i3, int i4, String str, String str2, String str3, double d2) {
        this(i2, 0, i3, 10002, i4, str, str2, str3, d2, 0, true, "", "", BuildConfig.VERSION_NAME, "");
    }

    public ChargeCurrencyRequest(long j, int i2, int i3, int i4, int i5, String str, String str2, String str3, double d2, int i6, boolean z, String str4, String str5, String str6, String str7) {
        this.sid = 0;
        this.usedChannel = 10002;
        this.chargeCurrencyConfigId = 0;
        this.needUnicast = true;
        this.returnUrl = "";
        this.expand = "";
        this.clientVersion = "";
        this.uid = j;
        this.sid = i2;
        this.appId = i3;
        this.usedChannel = i4;
        this.currencyType = i5;
        this.seq = str;
        this.payChannel = str2;
        this.payMethod = str3;
        this.amount = d2;
        this.chargeCurrencyConfigId = i6;
        this.needUnicast = z;
        this.returnUrl = str4;
        this.expand = str5;
        this.clientVersion = str6;
    }
}
