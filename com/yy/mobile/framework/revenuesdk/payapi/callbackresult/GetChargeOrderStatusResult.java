package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.SplitRecordItem;
import java.util.ArrayList;
import java.util.List;
@Keep
/* loaded from: classes2.dex */
public class GetChargeOrderStatusResult {
    public long amount;
    public long currencyAmount;
    public int currencyType;
    public String expand;
    public boolean finish;
    public List<GiftBagsInfo> giftbags;
    public int hasGotSalePromotion;
    public String message;
    public List<SplitRecordItem> splitRecordItemList;
    public int status;

    public GetChargeOrderStatusResult() {
        this.giftbags = new ArrayList();
        this.splitRecordItemList = new ArrayList();
    }

    public long getAmount() {
        return this.amount;
    }

    public long getCurrencyAmount() {
        return this.currencyAmount;
    }

    public int getCurrencyType() {
        return this.currencyType;
    }

    public String getExpand() {
        return this.expand;
    }

    public int getHasGotSalePromotion() {
        return this.hasGotSalePromotion;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isFinish() {
        return this.finish;
    }

    public GetChargeOrderStatusResult(String str, int i, String str2, int i2, int i3, long j, long j2, boolean z, List<GiftBagsInfo> list, List<SplitRecordItem> list2) {
        this.giftbags = new ArrayList();
        this.splitRecordItemList = new ArrayList();
        this.expand = str;
        this.status = i;
        this.message = str2;
        this.hasGotSalePromotion = i2;
        this.currencyType = i3;
        this.amount = j;
        this.currencyAmount = j2;
        this.finish = z;
        this.giftbags = list;
        this.splitRecordItemList = list2;
    }

    public void setAmount(long j) {
        this.amount = j;
    }

    public void setCurrencyAmount(long j) {
        this.currencyAmount = j;
    }

    public void setCurrencyType(int i) {
        this.currencyType = i;
    }

    public void setExpand(String str) {
        this.expand = str;
    }

    public void setFinish(boolean z) {
        this.finish = z;
    }

    public void setHasGotSalePromotion(int i) {
        this.hasGotSalePromotion = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String toString() {
        return "GetChargeOrderStatusResult{status=" + this.status + ", hasGotSalePromotion=" + this.hasGotSalePromotion + ", currencyType=" + this.currencyType + ", splitRecordItemList=" + this.splitRecordItemList + ", amount=" + this.amount + ", currencyAmount=" + this.currencyAmount + ", finish=" + this.finish + ", message=" + this.message + ", giftbags=" + this.giftbags + '}';
    }
}
