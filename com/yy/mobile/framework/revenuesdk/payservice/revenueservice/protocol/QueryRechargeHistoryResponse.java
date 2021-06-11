package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.kwai.video.player.KsMediaMeta;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ChargeOrder;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.RechargeHistoryResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010C\u001a\u00020\u0005¢\u0006\u0004\bD\u0010\tJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\"\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010\tR\"\u0010!\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010\tR\"\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010\u001f\"\u0004\b&\u0010\tR\"\u0010'\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010\tR\"\u0010*\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u001d\u001a\u0004\b+\u0010\u001f\"\u0004\b,\u0010\tR\"\u0010-\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\f\u001a\u0004\b.\u0010\u000e\"\u0004\b/\u0010\u0010R\"\u00100\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010\u001d\u001a\u0004\b1\u0010\u001f\"\u0004\b2\u0010\tR\"\u00103\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010\f\u001a\u0004\b4\u0010\u000e\"\u0004\b5\u0010\u0010R\"\u00106\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010\u001d\u001a\u0004\b7\u0010\u001f\"\u0004\b8\u0010\tR\"\u0010:\u001a\u0002098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010@\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010\f\u001a\u0004\bA\u0010\u000e\"\u0004\bB\u0010\u0010¨\u0006E"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/protocol/QueryRechargeHistoryResponse;", "Lcom/yy/mobile/framework/revenuesdk/baseapi/protocolbase/IBaseJsonResponse;", "Lcom/yy/mobile/framework/revenuesdk/payapi/callbackresult/RechargeHistoryResult;", "getResponse", "()Lcom/yy/mobile/framework/revenuesdk/payapi/callbackresult/RechargeHistoryResult;", "", "jsonMsg", "", "parserResponse", "(Ljava/lang/String;)V", "", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "I", "getAppId", "()I", "setAppId", "(I)V", "", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/ChargeOrder;", "chargeOrderList", "Ljava/util/List;", "getChargeOrderList", "()Ljava/util/List;", "setChargeOrderList", "(Ljava/util/List;)V", "cmd", "getCmd", "setCmd", "countryCode", "Ljava/lang/String;", "getCountryCode", "()Ljava/lang/String;", "setCountryCode", "expand", "getExpand", "setExpand", KsMediaMeta.KSM_KEY_LANGUAGE, "getLanguage", "setLanguage", "liveCategoryId", "getLiveCategoryId", "setLiveCategoryId", "message", "getMessage", "setMessage", "result", "getResult", "setResult", IAdRequestParam.SEQ, "getSeq", "setSeq", "total", "getTotal", "setTotal", "traceId", "getTraceId", "setTraceId", "", "uid", "J", "getUid", "()J", "setUid", "(J)V", "usedChannel", "getUsedChannel", "setUsedChannel", "rspData", "<init>", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class QueryRechargeHistoryResponse implements IBaseJsonResponse {
    public int appId;
    public int cmd;
    public int total;
    public long uid;
    public int usedChannel;
    public String seq = "";
    public int result = -1;
    public String message = "";
    public String expand = "";
    public String countryCode = "";
    public String language = "";
    public String liveCategoryId = "";
    public String traceId = "";
    public List<ChargeOrder> chargeOrderList = new ArrayList();

    public QueryRechargeHistoryResponse(String str) {
        parserResponse(str);
    }

    public final int getAppId() {
        return this.appId;
    }

    public final List<ChargeOrder> getChargeOrderList() {
        return this.chargeOrderList;
    }

    public final int getCmd() {
        return this.cmd;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getExpand() {
        return this.expand;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getLiveCategoryId() {
        return this.liveCategoryId;
    }

    public final String getMessage() {
        return this.message;
    }

    public final RechargeHistoryResult getResponse() {
        return new RechargeHistoryResult(this.chargeOrderList, this.total);
    }

    public final int getResult() {
        return this.result;
    }

    public final String getSeq() {
        return this.seq;
    }

    public final int getTotal() {
        return this.total;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final long getUid() {
        return this.uid;
    }

    public final int getUsedChannel() {
        return this.usedChannel;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse
    public void parserResponse(String str) {
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString(IAdRequestParam.SEQ, "");
        Intrinsics.checkExpressionValueIsNotNull(optString, "jObject.optString(\"seq\", \"\")");
        this.seq = optString;
        this.uid = jSONObject.optLong("uid", 0L);
        int i2 = 0;
        this.result = jSONObject.optInt("result", 0);
        String optString2 = jSONObject.optString("message", "");
        Intrinsics.checkExpressionValueIsNotNull(optString2, "jObject.optString(\"message\", \"\")");
        this.message = optString2;
        this.total = jSONObject.optInt("total", 0);
        String optString3 = jSONObject.optString("countryCode", "");
        Intrinsics.checkExpressionValueIsNotNull(optString3, "jObject.optString(\"countryCode\", \"\")");
        this.countryCode = optString3;
        String optString4 = jSONObject.optString(KsMediaMeta.KSM_KEY_LANGUAGE, "");
        Intrinsics.checkExpressionValueIsNotNull(optString4, "jObject.optString(\"language\", \"\")");
        this.language = optString4;
        String optString5 = jSONObject.optString("liveCategoryId", "");
        Intrinsics.checkExpressionValueIsNotNull(optString5, "jObject.optString(\"liveCategoryId\", \"\")");
        this.liveCategoryId = optString5;
        String optString6 = jSONObject.optString("traceId", "");
        Intrinsics.checkExpressionValueIsNotNull(optString6, "jObject.optString(\"traceId\", \"\")");
        this.traceId = optString6;
        JSONArray optJSONArray = jSONObject.optJSONArray("chargeOrderList");
        if (optJSONArray != null) {
            if (!(optJSONArray.length() > 0)) {
                optJSONArray = null;
            }
            if (optJSONArray != null) {
                for (int length = optJSONArray.length(); i2 < length; length = length) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    String optString7 = optJSONObject.optString("rechargeAmount");
                    Intrinsics.checkExpressionValueIsNotNull(optString7, "jsonOrder.optString(\"rechargeAmount\")");
                    long optLong = optJSONObject.optLong("createTime");
                    int optInt = optJSONObject.optInt("diamondAmount");
                    String optString8 = optJSONObject.optString("currencySymbol");
                    Intrinsics.checkExpressionValueIsNotNull(optString8, "jsonOrder.optString(\"currencySymbol\")");
                    String optString9 = optJSONObject.optString("payChannel");
                    Intrinsics.checkExpressionValueIsNotNull(optString9, "jsonOrder.optString(\"payChannel\")");
                    long optLong2 = optJSONObject.optLong("id");
                    int optInt2 = optJSONObject.optInt("status");
                    JSONArray jSONArray = optJSONArray;
                    int optInt3 = optJSONObject.optInt("offersType");
                    int optInt4 = optJSONObject.optInt("offersRate");
                    int optInt5 = optJSONObject.optInt("srcAmount");
                    int optInt6 = optJSONObject.optInt("destAmount");
                    int optInt7 = optJSONObject.optInt("destCurrencyType");
                    int optInt8 = optJSONObject.optInt("payAmount");
                    String optString10 = optJSONObject.optString("otherChargeOrderId");
                    Intrinsics.checkExpressionValueIsNotNull(optString10, "jsonOrder.optString(\"otherChargeOrderId\")");
                    this.chargeOrderList.add(new ChargeOrder(optString7, optLong, optInt, optString8, optString9, optLong2, optInt2, optInt3, optInt4, optInt5, optInt6, optInt7, optInt8, optString10, optJSONObject.optInt("chargeConfigType")));
                    i2++;
                    optJSONArray = jSONArray;
                }
            }
        }
    }

    public final void setAppId(int i2) {
        this.appId = i2;
    }

    public final void setChargeOrderList(List<ChargeOrder> list) {
        this.chargeOrderList = list;
    }

    public final void setCmd(int i2) {
        this.cmd = i2;
    }

    public final void setCountryCode(String str) {
        this.countryCode = str;
    }

    public final void setExpand(String str) {
        this.expand = str;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    public final void setLiveCategoryId(String str) {
        this.liveCategoryId = str;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final void setResult(int i2) {
        this.result = i2;
    }

    public final void setSeq(String str) {
        this.seq = str;
    }

    public final void setTotal(int i2) {
        this.total = i2;
    }

    public final void setTraceId(String str) {
        this.traceId = str;
    }

    public final void setUid(long j) {
        this.uid = j;
    }

    public final void setUsedChannel(int i2) {
        this.usedChannel = i2;
    }
}
