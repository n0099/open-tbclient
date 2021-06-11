package com.yy.mobile.framework.revenuesdk.statistics.hiido.uvevent;

import android.text.TextUtils;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.AbstractHiidoContent;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.BaseHiidoContent;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.HiidoConstantContent;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u001b\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uvevent/PayUVEventContent;", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/AbstractHiidoContent;", "", "buildContent", "()Ljava/lang/String;", "getAct", "getContent", "", "getMapContent", "()Ljava/util/Map;", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;", "mBaseHiidoContent", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;", "mChargeConfigId", "Ljava/lang/String;", "mEvent", "mPayChannel", "mPayMethod", "<init>", "()V", "Companion", "ProductEventBuilder", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class PayUVEventContent extends AbstractHiidoContent {
    public static final String CHARGE_CONFIGID = "chargeconfigid";
    public static final Companion Companion = new Companion(null);
    public static final String EVENT = "event";
    public static final String OPENID = "openid";
    public static final String PAY_CHANNEL = "paychannel";
    public static final String PAY_METHOD = "paymethod2";
    public static final String USER_TYPE = "usertype";
    public BaseHiidoContent mBaseHiidoContent;
    public String mChargeConfigId;
    public String mEvent;
    public String mPayChannel;
    public String mPayMethod;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0003¨\u0006\u000b"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uvevent/PayUVEventContent$Companion;", "", "CHARGE_CONFIGID", "Ljava/lang/String;", "EVENT", "OPENID", "PAY_CHANNEL", "PAY_METHOD", "USER_TYPE", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0004\b\r\u0010\nR\u0016\u0010\u000e\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uvevent/PayUVEventContent$ProductEventBuilder;", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uvevent/PayUVEventContent;", "build", "()Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uvevent/PayUVEventContent;", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;", "content", "setAbstractHiidoContent", "(Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;)Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uvevent/PayUVEventContent$ProductEventBuilder;", "", "setChargeConfigId", "(Ljava/lang/String;)Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uvevent/PayUVEventContent$ProductEventBuilder;", "setEvent", "setPayChannel", "setPayMethod", "mProductEventContent", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uvevent/PayUVEventContent;", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class ProductEventBuilder {
        public PayUVEventContent mProductEventContent = new PayUVEventContent(null);

        public final PayUVEventContent build() {
            return this.mProductEventContent;
        }

        public final ProductEventBuilder setAbstractHiidoContent(BaseHiidoContent baseHiidoContent) {
            this.mProductEventContent.mBaseHiidoContent = baseHiidoContent;
            return this;
        }

        public final ProductEventBuilder setChargeConfigId(String str) {
            this.mProductEventContent.mChargeConfigId = str;
            return this;
        }

        public final ProductEventBuilder setEvent(String str) {
            this.mProductEventContent.mEvent = str;
            return this;
        }

        public final ProductEventBuilder setPayChannel(String str) {
            this.mProductEventContent.mPayChannel = str;
            return this;
        }

        public final ProductEventBuilder setPayMethod(String str) {
            this.mProductEventContent.mPayMethod = str;
            return this;
        }
    }

    public PayUVEventContent() {
        this.mEvent = "";
        this.mPayChannel = "";
        this.mPayMethod = "";
        this.mChargeConfigId = "";
    }

    private final String buildContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("event");
        sb.append("=");
        sb.append(URLEncoder.encode(this.mEvent, "UTF-8"));
        if (!TextUtils.isEmpty(HiidoConstantContent.mUserType)) {
            sb.append("&");
            sb.append(USER_TYPE);
            sb.append("=");
            sb.append(HiidoConstantContent.mUserType);
        }
        if (!TextUtils.isEmpty(HiidoConstantContent.mOpenId)) {
            sb.append("&");
            sb.append("openid");
            sb.append("=");
            sb.append(HiidoConstantContent.mOpenId);
        }
        if (!TextUtils.isEmpty(this.mPayChannel)) {
            sb.append("&");
            sb.append(PAY_CHANNEL);
            sb.append("=");
            sb.append(this.mPayChannel);
        }
        if (!TextUtils.isEmpty(this.mPayMethod)) {
            sb.append("&");
            sb.append(PAY_METHOD);
            sb.append("=");
            sb.append(this.mPayMethod);
        }
        if (!TextUtils.isEmpty(this.mChargeConfigId)) {
            sb.append("&");
            sb.append(CHARGE_CONFIGID);
            sb.append("=");
            sb.append(this.mChargeConfigId);
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "contents.toString()");
        return sb2;
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
        mapContent.put("event", this.mEvent);
        String str = HiidoConstantContent.mUserType;
        Intrinsics.checkExpressionValueIsNotNull(str, "HiidoConstantContent.mUserType");
        mapContent.put(USER_TYPE, str);
        String str2 = HiidoConstantContent.mOpenId;
        Intrinsics.checkExpressionValueIsNotNull(str2, "HiidoConstantContent.mOpenId");
        mapContent.put("openid", str2);
        mapContent.put(PAY_CHANNEL, this.mPayChannel);
        mapContent.put(PAY_METHOD, this.mPayMethod);
        mapContent.put(CHARGE_CONFIGID, this.mChargeConfigId);
        return mapContent;
    }

    public /* synthetic */ PayUVEventContent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
