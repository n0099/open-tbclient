package com.yy.mobile.framework.revenuesdk.payapi.bean;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class SkuDetailInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String description;
    public String freeTrialPeriod;
    public String introductoryPrice;
    public String introductoryPriceAmountMicros;
    public String introductoryPriceCycles;
    public String introductoryPricePeriod;
    public boolean isRewarded;
    public long originalPriceAmountMicros;
    public String price;
    public long priceAmountMicros;
    public String priceCurrencyCode;
    public String sku;
    public String subscriptionPeriod;
    public String title;
    public String type;

    public SkuDetailInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SkuDetailInfo{description=" + this.description + ", freeTrialPeriod=" + this.freeTrialPeriod + ", introductoryPrice=" + this.introductoryPrice + ", introductoryPriceAmountMicros=" + this.introductoryPriceAmountMicros + ", introductoryPriceCycles=" + this.introductoryPriceCycles + ", introductoryPricePeriod=" + this.introductoryPricePeriod + ", originalPriceAmountMicros=" + this.originalPriceAmountMicros + ", price=" + this.price + ", priceAmountMicros=" + this.priceAmountMicros + ", priceCurrencyCode=" + this.priceCurrencyCode + ", subscriptionPeriod=" + this.subscriptionPeriod + ", title=" + this.title + ", type=" + this.type + ", isRewarded=" + this.isRewarded + '}';
        }
        return (String) invokeV.objValue;
    }
}
