package com.yy.mobile.framework.revenuesdk.payapi.request;

import androidx.annotation.Keep;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/request/QueryCurrencyChannelsReqParams;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "", "currencyType", "I", "getCurrencyType", "()I", "setCurrencyType", "(I)V", "", "usedChannelList", "Ljava/util/List;", "getUsedChannelList", "()Ljava/util/List;", "setUsedChannelList", "(Ljava/util/List;)V", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class QueryCurrencyChannelsReqParams extends RequestParams {
    public int currencyType;
    public List<Integer> usedChannelList = CollectionsKt__CollectionsKt.emptyList();

    public final int getCurrencyType() {
        return this.currencyType;
    }

    public final List<Integer> getUsedChannelList() {
        return this.usedChannelList;
    }

    public final void setCurrencyType(int i2) {
        this.currencyType = i2;
    }

    public final void setUsedChannelList(List<Integer> list) {
        this.usedChannelList = list;
    }
}
