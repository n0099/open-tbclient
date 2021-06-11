package com.yy.mobile.framework.revenuesdk.statistics.hiido.payflow;

import com.baidu.tbadk.core.util.TbEnum;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.AbstractHiidoContent;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.BaseHiidoContent;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u001b\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u000eR\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/payflow/PayFlowContent;", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/AbstractHiidoContent;", "", "buildContent", "()Ljava/lang/String;", "getAct", "getContent", "", "getMapContent", "()Ljava/util/Map;", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;", "mBaseHiidoContent", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;", "mCode", "Ljava/lang/String;", "mEventId", "mMsg", "mOrderId", "mPayEntranceId", "mPayFrom", "mPayTraceId", "mProductId", "mPurchaseTime", "<init>", "()V", "Companion", "PayFlowContentBuilder", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class PayFlowContent extends AbstractHiidoContent {
    public static final String CODE = "code";
    public static final Companion Companion = new Companion(null);
    public static final String EVENT = "event";
    public static final String MSG = "msg";
    public static final String ORDERID = "orderid";
    public static final String PAYENTRANCEID = "payentranceid";
    public static final String PAYTRACEID = "paytraceid";
    public static final String PAY_FROM = "pay_from";
    public static final String PRODUCTID = "productid";
    public static final String PURCHASETIME = "purchasetime";
    public BaseHiidoContent mBaseHiidoContent;
    public String mCode;
    public String mEventId;
    public String mMsg;
    public String mOrderId;
    public String mPayEntranceId;
    public String mPayFrom;
    public String mPayTraceId;
    public String mProductId;
    public String mPurchaseTime;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0003R\u0016\u0010\u000b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0003¨\u0006\u000e"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/payflow/PayFlowContent$Companion;", "", "CODE", "Ljava/lang/String;", "EVENT", "MSG", "ORDERID", "PAYENTRANCEID", "PAYTRACEID", "PAY_FROM", "PRODUCTID", "PURCHASETIME", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u0000B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u000bJ\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u000bJ\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u000bJ\u0015\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u000bJ\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u000bJ\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u000bJ\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u000bR\u0016\u0010\u001c\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/payflow/PayFlowContent$PayFlowContentBuilder;", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/payflow/PayFlowContent;", "build", "()Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/payflow/PayFlowContent;", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;", "content", "setAbstractHiidoContent", "(Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;)Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/payflow/PayFlowContent$PayFlowContentBuilder;", "", "code", "setCode", "(Ljava/lang/String;)Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/payflow/PayFlowContent$PayFlowContentBuilder;", TbEnum.SystemMessage.KEY_EVENT_ID, "setEventId", "msg", "setMsg", "orderId", "setOrderId", "payentraceId", "setPayEntraceId", "payFrom", "setPayFrom", "paytraceId", "setPayTraceId", "productId", "setProductId", "purchaceTime", "setPurchaceTime", "mPayFlowContent", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/payflow/PayFlowContent;", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class PayFlowContentBuilder {
        public final PayFlowContent mPayFlowContent = new PayFlowContent(null);

        public final PayFlowContent build() {
            return this.mPayFlowContent;
        }

        public final PayFlowContentBuilder setAbstractHiidoContent(BaseHiidoContent baseHiidoContent) {
            this.mPayFlowContent.mBaseHiidoContent = baseHiidoContent;
            return this;
        }

        public final PayFlowContentBuilder setCode(String str) {
            this.mPayFlowContent.mCode = str;
            return this;
        }

        public final PayFlowContentBuilder setEventId(String str) {
            this.mPayFlowContent.mEventId = str;
            return this;
        }

        public final PayFlowContentBuilder setMsg(String str) {
            this.mPayFlowContent.mMsg = str;
            return this;
        }

        public final PayFlowContentBuilder setOrderId(String str) {
            this.mPayFlowContent.mOrderId = str;
            return this;
        }

        public final PayFlowContentBuilder setPayEntraceId(String str) {
            this.mPayFlowContent.mPayEntranceId = str;
            return this;
        }

        public final PayFlowContentBuilder setPayFrom(String str) {
            this.mPayFlowContent.mPayFrom = str;
            return this;
        }

        public final PayFlowContentBuilder setPayTraceId(String str) {
            this.mPayFlowContent.mPayTraceId = str;
            return this;
        }

        public final PayFlowContentBuilder setProductId(String str) {
            this.mPayFlowContent.mProductId = str;
            return this;
        }

        public final PayFlowContentBuilder setPurchaceTime(String str) {
            this.mPayFlowContent.mPurchaseTime = str;
            return this;
        }
    }

    public PayFlowContent() {
        this.mOrderId = "";
        this.mPurchaseTime = "";
        this.mProductId = "";
        this.mPayEntranceId = "";
        this.mPayTraceId = "";
        this.mEventId = "";
        this.mCode = "";
        this.mMsg = "";
        this.mPayFrom = "";
    }

    private final String buildContent() {
        String str = "orderid=" + URLEncoder.encode(this.mOrderId, "UTF-8") + "&" + PURCHASETIME + "=" + URLEncoder.encode(this.mPurchaseTime, "UTF-8") + "&productid=" + URLEncoder.encode(this.mProductId, "UTF-8") + "&" + PAYENTRANCEID + "=" + URLEncoder.encode(this.mPayEntranceId, "UTF-8") + "&" + PAYTRACEID + "=" + URLEncoder.encode(this.mPayTraceId, "UTF-8") + "&event=" + URLEncoder.encode(this.mEventId, "UTF-8") + "&code=" + this.mCode + "&msg=" + URLEncoder.encode(this.mMsg, "UTF-8") + "&pay_from=" + URLEncoder.encode(this.mPayFrom, "UTF-8");
        Intrinsics.checkExpressionValueIsNotNull(str, "contents.toString()");
        return str;
    }

    @Override // com.yy.mobile.framework.revenuesdk.statistics.hiido.AbstractHiidoContent
    public String getAct() {
        BaseHiidoContent baseHiidoContent = this.mBaseHiidoContent;
        if (baseHiidoContent != null) {
            return baseHiidoContent.getAct();
        }
        return null;
    }

    @Override // com.yy.mobile.framework.revenuesdk.statistics.hiido.AbstractHiidoContent
    public String getContent() {
        StringBuilder sb = new StringBuilder();
        BaseHiidoContent baseHiidoContent = this.mBaseHiidoContent;
        sb.append(baseHiidoContent != null ? baseHiidoContent.getContent() : null);
        sb.append("&");
        sb.append(buildContent());
        return sb.toString();
    }

    @Override // com.yy.mobile.framework.revenuesdk.statistics.hiido.AbstractHiidoContent
    public Map<String, String> getMapContent() {
        BaseHiidoContent baseHiidoContent = this.mBaseHiidoContent;
        Map<String, String> mapContent = baseHiidoContent != null ? baseHiidoContent.getMapContent() : null;
        if (mapContent == null) {
            mapContent = new LinkedHashMap<>();
        }
        mapContent.put("event", this.mEventId);
        mapContent.put("orderid", this.mOrderId);
        mapContent.put(PURCHASETIME, this.mPurchaseTime);
        mapContent.put("productid", this.mProductId);
        mapContent.put(PAYENTRANCEID, this.mPayEntranceId);
        mapContent.put(PAYTRACEID, this.mPayTraceId);
        mapContent.put("code", this.mCode);
        mapContent.put("msg", this.mMsg);
        mapContent.put("pay_from", this.mPayFrom);
        return mapContent;
    }

    public /* synthetic */ PayFlowContent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
