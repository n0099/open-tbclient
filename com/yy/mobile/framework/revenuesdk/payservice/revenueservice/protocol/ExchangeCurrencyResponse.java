package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ExchangeResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b#\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00102\u001a\u00020\u0005¢\u0006\u0004\b3\u0010\tJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R\"\u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010\tR\"\u0010#\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0013\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\"\u0010&\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!\"\u0004\b(\u0010\tR\"\u0010)\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0013\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\"\u0010,\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\f\u001a\u0004\b-\u0010\u000e\"\u0004\b.\u0010\u0010R\"\u0010/\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\f\u001a\u0004\b0\u0010\u000e\"\u0004\b1\u0010\u0010¨\u00064"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/protocol/ExchangeCurrencyResponse;", "Lcom/yy/mobile/framework/revenuesdk/baseapi/protocolbase/IBaseJsonResponse;", "Lcom/yy/mobile/framework/revenuesdk/payapi/callbackresult/ExchangeResult;", "getResponse", "()Lcom/yy/mobile/framework/revenuesdk/payapi/callbackresult/ExchangeResult;", "", "jsonMsg", "", "parserResponse", "(Ljava/lang/String;)V", "", "descRemainAmount", "J", "getDescRemainAmount", "()J", "setDescRemainAmount", "(J)V", "", "destCurrencyType", "I", "getDestCurrencyType", "()I", "setDestCurrencyType", "(I)V", "exchangeAmount", "getExchangeAmount", "setExchangeAmount", "exchangeDestAmount", "getExchangeDestAmount", "setExchangeDestAmount", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "result", "getResult", "setResult", IAdRequestParam.SEQ, "getSeq", "setSeq", "srcCurrencyType", "getSrcCurrencyType", "setSrcCurrencyType", "srcRemainAmount", "getSrcRemainAmount", "setSrcRemainAmount", "uid", "getUid", "setUid", "rspData", "<init>", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class ExchangeCurrencyResponse implements IBaseJsonResponse {
    public long descRemainAmount;
    public int destCurrencyType;
    public int exchangeAmount;
    public long exchangeDestAmount;
    public int srcCurrencyType;
    public long srcRemainAmount;
    public long uid;
    public String seq = "";
    public int result = -1;
    public String message = "";

    public ExchangeCurrencyResponse(String str) {
        parserResponse(str);
    }

    public final long getDescRemainAmount() {
        return this.descRemainAmount;
    }

    public final int getDestCurrencyType() {
        return this.destCurrencyType;
    }

    public final int getExchangeAmount() {
        return this.exchangeAmount;
    }

    public final long getExchangeDestAmount() {
        return this.exchangeDestAmount;
    }

    public final String getMessage() {
        return this.message;
    }

    public final ExchangeResult getResponse() {
        return new ExchangeResult(this.srcCurrencyType, this.srcRemainAmount, this.destCurrencyType, this.descRemainAmount, this.exchangeDestAmount, this.exchangeAmount);
    }

    public final int getResult() {
        return this.result;
    }

    public final String getSeq() {
        return this.seq;
    }

    public final int getSrcCurrencyType() {
        return this.srcCurrencyType;
    }

    public final long getSrcRemainAmount() {
        return this.srcRemainAmount;
    }

    public final long getUid() {
        return this.uid;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse
    public void parserResponse(String str) {
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString(IAdRequestParam.SEQ, "");
        Intrinsics.checkExpressionValueIsNotNull(optString, "jObject.optString(\"seq\", \"\")");
        this.seq = optString;
        this.uid = jSONObject.optLong("uid", 0L);
        this.result = jSONObject.optInt("result", 0);
        String optString2 = jSONObject.optString("message", "");
        Intrinsics.checkExpressionValueIsNotNull(optString2, "jObject.optString(\"message\", \"\")");
        this.message = optString2;
        this.srcCurrencyType = jSONObject.optInt("srcCurrencyType", 0);
        this.srcRemainAmount = jSONObject.optLong("srcRemainAmount", 0L);
        this.destCurrencyType = jSONObject.optInt("destCurrencyType", 0);
        this.descRemainAmount = jSONObject.optLong("descRemainAmount", 0L);
        this.exchangeDestAmount = jSONObject.optLong("exchangeDestAmount", 0L);
        this.exchangeAmount = jSONObject.optInt("exchangeAmount", 0);
    }

    public final void setDescRemainAmount(long j) {
        this.descRemainAmount = j;
    }

    public final void setDestCurrencyType(int i2) {
        this.destCurrencyType = i2;
    }

    public final void setExchangeAmount(int i2) {
        this.exchangeAmount = i2;
    }

    public final void setExchangeDestAmount(long j) {
        this.exchangeDestAmount = j;
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

    public final void setSrcCurrencyType(int i2) {
        this.srcCurrencyType = i2;
    }

    public final void setSrcRemainAmount(long j) {
        this.srcRemainAmount = j;
    }

    public final void setUid(long j) {
        this.uid = j;
    }
}
