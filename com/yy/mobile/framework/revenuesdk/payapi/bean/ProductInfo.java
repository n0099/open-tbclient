package com.yy.mobile.framework.revenuesdk.payapi.bean;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes10.dex */
public class ProductInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Double chargeRate;
    public int cid;
    public String currencyCode;
    public long destAmount;
    public String expand;
    public long firstRushAmount;
    public boolean hasAct;
    public boolean hasCurrencyAct;
    public boolean hasDestCurrencyAct;
    public boolean hasFirstRush;
    public boolean hasOtherCurrencyAct;
    public boolean hasPropsAct;
    public int level;
    public String name;
    public int offersRate;
    public String offersTips;
    public int offersType;
    public String offers_currency_name;
    public boolean offers_currency_same;
    public int offers_currency_type;
    public List<CurrencyInfo> otherCurrencies;
    public int otherCurrenciesSum;
    public String otherPrice;
    public String payChannel;
    public String payMethod;
    public String payType;
    public String productId;
    public List<PropsInfo> props;
    public int propsSum;
    public long spAmount;
    public long spSumAmount;
    public Double srcAmount;
    public String srcCurrencySymbol;
    public String subChannel;
    public int usedChannelType;

    public ProductInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.otherCurrencies = new ArrayList();
        this.props = new ArrayList();
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "ProductInfo{cid=" + this.cid + ", offersTips='" + this.offersTips + ExtendedMessageFormat.QUOTE + ", name='" + this.name + ExtendedMessageFormat.QUOTE + ", level=" + this.level + ", srcAmount=" + this.srcAmount + ", srcCurrencySymbol=" + this.srcCurrencySymbol + ", destAmount=" + this.destAmount + ", offersType=" + this.offersType + ", offersRate=" + this.offersRate + ", offers_currency_same=" + this.offers_currency_same + ", offers_currency_type=" + this.offers_currency_type + ", offers_currency_name='" + this.offers_currency_name + ExtendedMessageFormat.QUOTE + ", hasAct=" + this.hasAct + ", hasCurrencyAct=" + this.hasCurrencyAct + ", hasDestCurrencyAct=" + this.hasDestCurrencyAct + ", spAmount=" + this.spAmount + ", spSumAmount=" + this.spSumAmount + ", hasOtherCurrencyAct=" + this.hasOtherCurrencyAct + ", otherCurrenciesSum=" + this.otherCurrenciesSum + ", otherCurrencies=" + this.otherCurrencies + ", hasFirstRush=" + this.hasFirstRush + ", firstRushAmount=" + this.firstRushAmount + ", hasPropsAct=" + this.hasPropsAct + ", propsSum=" + this.propsSum + ", props=" + this.props + ", chargeRate=" + this.chargeRate + ", productId='" + this.productId + ExtendedMessageFormat.QUOTE + ", expand=" + this.expand + ", currencyCode=" + this.currencyCode + ", otherPrice=" + this.otherPrice + ", payChannel=" + this.payChannel + ", payMethod=" + this.payMethod + ", subChannel=" + this.subChannel + ", payType=" + this.payType + ", usedChannelType=" + this.usedChannelType + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
