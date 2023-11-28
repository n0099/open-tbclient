package com.yy.mobile.framework.revenuesdk.payapi.bean;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ProductInfo {
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
    public int otherCurrenciesSum;
    public String otherPrice;
    public String payChannel;
    public String payMethod;
    public String payType;
    public String productId;
    public int propsSum;
    public long spAmount;
    public long spSumAmount;
    public double srcAmount;
    public String srcCurrencySymbol;
    public String subChannel;
    public int usedChannelType;
    public List<CurrencyInfo> otherCurrencies = new ArrayList();
    public List<PropsInfo> props = new ArrayList();
    public List<GiftBagsInfo> giftbags = new ArrayList();
    public List<GiftBagTagInfo> giftBagTagInfos = new ArrayList();

    public String toString() {
        return "ProductInfo{cid=" + this.cid + ", offersTips='" + this.offersTips + "', name='" + this.name + "', level=" + this.level + ", srcAmount=" + this.srcAmount + ", srcCurrencySymbol=" + this.srcCurrencySymbol + ", destAmount=" + this.destAmount + ", offersType=" + this.offersType + ", offersRate=" + this.offersRate + ", offers_currency_same=" + this.offers_currency_same + ", offers_currency_type=" + this.offers_currency_type + ", offers_currency_name='" + this.offers_currency_name + "', hasAct=" + this.hasAct + ", hasCurrencyAct=" + this.hasCurrencyAct + ", hasDestCurrencyAct=" + this.hasDestCurrencyAct + ", spAmount=" + this.spAmount + ", spSumAmount=" + this.spSumAmount + ", hasOtherCurrencyAct=" + this.hasOtherCurrencyAct + ", otherCurrenciesSum=" + this.otherCurrenciesSum + ", otherCurrencies=" + this.otherCurrencies + ", giftbags=" + this.giftbags + ", giftBagTagInfos=" + this.giftBagTagInfos + ", hasFirstRush=" + this.hasFirstRush + ", firstRushAmount=" + this.firstRushAmount + ", hasPropsAct=" + this.hasPropsAct + ", propsSum=" + this.propsSum + ", props=" + this.props + ", chargeRate=" + this.chargeRate + ", productId='" + this.productId + "', expand=" + this.expand + ", currencyCode=" + this.currencyCode + ", otherPrice=" + this.otherPrice + ", payChannel=" + this.payChannel + ", payMethod=" + this.payMethod + ", subChannel=" + this.subChannel + ", payType=" + this.payType + ", usedChannelType=" + this.usedChannelType + '}';
    }
}
