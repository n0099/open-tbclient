package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
import d.r.b.a.a.i.c.g;
import d.r.b.a.a.i.c.h;
import d.r.b.a.a.i.c.j;
import java.util.List;
@Keep
/* loaded from: classes7.dex */
public class ProductListResult {
    public String currencyName;
    public int currencyType;
    public List<g> payWayInfoList;
    public h paysSettingInfo;
    public List<j> productInfoList;

    public ProductListResult(int i2, String str, h hVar, List<j> list, List<g> list2) {
        this.currencyType = i2;
        this.productInfoList = list;
        this.payWayInfoList = list2;
        this.currencyName = str;
        this.paysSettingInfo = hVar;
    }

    public String getCurrencyName() {
        return this.currencyName;
    }

    public int getCurrencyType() {
        return this.currencyType;
    }

    public List<g> getPayWayInfoList() {
        return this.payWayInfoList;
    }

    public h getPaysSettingInfo() {
        return this.paysSettingInfo;
    }

    public List<j> getProductInfoList() {
        return this.productInfoList;
    }

    public String toString() {
        return "ProductListResult{currencyType=" + this.currencyType + ", productInfoList=" + this.productInfoList + ", payWayInfoList=" + this.payWayInfoList + ", currencyName=" + this.currencyName + ", paysSettingInfo=" + this.paysSettingInfo + '}';
    }
}
