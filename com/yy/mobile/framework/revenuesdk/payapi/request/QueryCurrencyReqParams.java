package com.yy.mobile.framework.revenuesdk.payapi.request;

import androidx.annotation.Keep;
import java.util.Map;
import kotlin.Metadata;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/request/QueryCurrencyReqParams;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "", "currencyType", "I", "getCurrencyType", "()I", "setCurrencyType", "(I)V", "", "", "", "expandMap", "Ljava/util/Map;", "getExpandMap", "()Ljava/util/Map;", "setExpandMap", "(Ljava/util/Map;)V", "", "returnYb", "Z", "getReturnYb", "()Z", "setReturnYb", "(Z)V", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class QueryCurrencyReqParams extends RequestParams {
    public int currencyType;
    public Map<String, Object> expandMap;
    public boolean returnYb;

    public final int getCurrencyType() {
        return this.currencyType;
    }

    public final Map<String, Object> getExpandMap() {
        return this.expandMap;
    }

    public final boolean getReturnYb() {
        return this.returnYb;
    }

    public final void setCurrencyType(int i) {
        this.currencyType = i;
    }

    public final void setExpandMap(Map<String, Object> map) {
        this.expandMap = map;
    }

    public final void setReturnYb(boolean z) {
        this.returnYb = z;
    }
}
