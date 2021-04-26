package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes7.dex */
public class GetChargeOrderStatusResult {
    public long amount;
    public long currencyAmount;
    public int currencyType;
    public String expand;
    public boolean finish;
    public int hasGotSalePromotion;
    public int status;

    public GetChargeOrderStatusResult() {
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

    public void setAmount(long j) {
        this.amount = j;
    }

    public void setCurrencyAmount(long j) {
        this.currencyAmount = j;
    }

    public void setCurrencyType(int i2) {
        this.currencyType = i2;
    }

    public void setExpand(String str) {
        this.expand = str;
    }

    public void setFinish(boolean z) {
        this.finish = z;
    }

    public void setHasGotSalePromotion(int i2) {
        this.hasGotSalePromotion = i2;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public GetChargeOrderStatusResult(String str, int i2, int i3, int i4, long j, long j2, boolean z) {
        this.expand = str;
        this.status = i2;
        this.hasGotSalePromotion = i3;
        this.currencyType = i4;
        this.amount = j;
        this.currencyAmount = j2;
        this.finish = z;
    }
}
