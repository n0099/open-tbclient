package com.yy.mobile.framework.revenuesdk.payapi.bean;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class GiftBagsInfo {
    public List<GiftBagItemInfo> giftbag = new ArrayList();
    public String giftbagTitle;
    public String giveupButtonMsg;
    public String giveupSubtitle;
    public String giveupTitle;
    public String offersTips;
    public String successButtonMsg;
    public String successTitle;

    public String toString() {
        return "GiftBagsInfo {offersTips=" + this.offersTips + ", giveupTitle=" + this.giveupTitle + ", giveupSubtitle=" + this.giveupSubtitle + ", giveupButtonMsg=" + this.giveupButtonMsg + ", successTitle=" + this.successTitle + ", successButtonMsg=" + this.successButtonMsg + ", giftbag='" + this.giftbag + "', giftbagTitle='" + this.giftbagTitle + "'}";
    }
}
