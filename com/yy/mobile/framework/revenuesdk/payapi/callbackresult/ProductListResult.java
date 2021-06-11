package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaysSettingInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import java.util.List;
@Keep
/* loaded from: classes7.dex */
public class ProductListResult {
    public String currencyName;
    public int currencyType;
    public List<PayWayInfo> payWayInfoList;
    public PaysSettingInfo paysSettingInfo;
    public List<ProductInfo> productInfoList;

    public ProductListResult(int i2, String str, PaysSettingInfo paysSettingInfo, List<ProductInfo> list, List<PayWayInfo> list2) {
        this.currencyType = i2;
        this.productInfoList = list;
        this.payWayInfoList = list2;
        this.currencyName = str;
        this.paysSettingInfo = paysSettingInfo;
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
        return "ProductListResult{currencyType=" + this.currencyType + ", productInfoList=" + this.productInfoList + ", payWayInfoList=" + this.payWayInfoList + ", currencyName=" + this.currencyName + ", paysSettingInfo=" + this.paysSettingInfo + '}';
    }
}
