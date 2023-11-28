package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaysSettingInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import java.util.List;
@Keep
/* loaded from: classes2.dex */
public class ProductListResult {
    public String bubbleActMsg;
    public String currencyName;
    public int currencyType;
    public int defaultCid;
    public List<PayWayInfo> payWayInfoList;
    public PaysSettingInfo paysSettingInfo;
    public List<ProductInfo> productInfoList;

    public ProductListResult(int i, String str, PaysSettingInfo paysSettingInfo, List<ProductInfo> list, List<PayWayInfo> list2, int i2, String str2) {
        this.currencyType = i;
        this.productInfoList = list;
        this.payWayInfoList = list2;
        this.currencyName = str;
        this.paysSettingInfo = paysSettingInfo;
        this.defaultCid = i2;
        this.bubbleActMsg = str2;
    }

    public String getBubbleActMsg() {
        return this.bubbleActMsg;
    }

    public String getCurrencyName() {
        return this.currencyName;
    }

    public int getCurrencyType() {
        return this.currencyType;
    }

    public List<PayWayInfo> getPayWayInfoList() {
        return this.payWayInfoList;
    }

    public PaysSettingInfo getPaysSettingInfo() {
        return this.paysSettingInfo;
    }

    public List<ProductInfo> getProductInfoList() {
        return this.productInfoList;
    }

    public String toString() {
        return "ProductListResult{currencyType=" + this.currencyType + ", productInfoList=" + this.productInfoList + ", payWayInfoList=" + this.payWayInfoList + ", currencyName=" + this.currencyName + ", paysSettingInfo=" + this.paysSettingInfo + ", defaultCid=" + this.defaultCid + ", bubbleActMsg=" + this.bubbleActMsg + '}';
    }
}
