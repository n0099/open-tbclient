package com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent;

import android.text.TextUtils;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.AbstractHiidoContent;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.BaseHiidoContent;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u001b\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uievent/PayUiEventContent;", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/AbstractHiidoContent;", "", "buildContent", "()Ljava/lang/String;", "getAct", "getContent", "", "getMapContent", "()Ljava/util/Map;", "mAmount", "Ljava/lang/String;", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;", "mBaseHiidoContent", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;", "mEvent", "<init>", "()V", "Companion", "UiEventContentBuilder", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class PayUiEventContent extends AbstractHiidoContent {
    public static final String AMOUNT = "amount";
    public static final Companion Companion = new Companion(null);
    public static final String EVENT = "event";
    public String mAmount;
    public BaseHiidoContent mBaseHiidoContent;
    public String mEvent;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uievent/PayUiEventContent$Companion;", "", "AMOUNT", "Ljava/lang/String;", "EVENT", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nR\u0016\u0010\f\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uievent/PayUiEventContent$UiEventContentBuilder;", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uievent/PayUiEventContent;", "build", "()Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uievent/PayUiEventContent;", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;", "content", "setAbstractHiidoContent", "(Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;)Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uievent/PayUiEventContent$UiEventContentBuilder;", "", "setAmount", "(Ljava/lang/String;)Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uievent/PayUiEventContent$UiEventContentBuilder;", "setEvent", "mUiEventContent", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/uievent/PayUiEventContent;", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class UiEventContentBuilder {
        public PayUiEventContent mUiEventContent = new PayUiEventContent(null);

        public final PayUiEventContent build() {
            return this.mUiEventContent;
        }

        public final UiEventContentBuilder setAbstractHiidoContent(BaseHiidoContent baseHiidoContent) {
            this.mUiEventContent.mBaseHiidoContent = baseHiidoContent;
            return this;
        }

        public final UiEventContentBuilder setAmount(String str) {
            this.mUiEventContent.mAmount = str;
            return this;
        }

        public final UiEventContentBuilder setEvent(String str) {
            this.mUiEventContent.mEvent = str;
            return this;
        }
    }

    public PayUiEventContent() {
        this.mEvent = "";
        this.mAmount = "";
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
        String str;
        StringBuilder sb = new StringBuilder();
        BaseHiidoContent baseHiidoContent = this.mBaseHiidoContent;
        if (baseHiidoContent != null) {
            str = baseHiidoContent.getContent();
        } else {
            str = null;
        }
        sb.append(str);
        sb.append("&");
        sb.append(buildContent());
        return sb.toString();
    }

    @Override // com.yy.mobile.framework.revenuesdk.statistics.hiido.AbstractHiidoContent
    public Map<String, String> getMapContent() {
        Map<String, String> map;
        BaseHiidoContent baseHiidoContent = this.mBaseHiidoContent;
        if (baseHiidoContent != null) {
            map = baseHiidoContent.getMapContent();
        } else {
            map = null;
        }
        if (map == null) {
            map = new LinkedHashMap<>();
        }
        map.put("event", this.mEvent);
        map.put(AMOUNT, this.mAmount);
        return map;
    }

    public /* synthetic */ PayUiEventContent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final String buildContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("event");
        sb.append("=");
        sb.append(URLEncoder.encode(this.mEvent, "UTF-8"));
        if (!TextUtils.isEmpty(this.mAmount)) {
            sb.append("&");
            sb.append(AMOUNT);
            sb.append("=");
            sb.append(this.mAmount);
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "contents.toString()");
        return sb2;
    }
}
