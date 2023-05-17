package com.yy.mobile.framework.revenuesdk.payapi.bean;
/* loaded from: classes10.dex */
public class PayWayInfo {
    public String id;
    public String name;
    public boolean passFreeAlwaysConfirm;
    public String payChannel;
    public String payMethod;
    public double perFreePassAmount;
    public boolean showInAmountView;
    public String tips;

    public String toString() {
        return "PayWayInfo{id='" + this.id + "', name='" + this.name + "', showInAmountView='" + this.showInAmountView + "', tips='" + this.tips + "', payChannel='" + this.payChannel + "', payMethod='" + this.payMethod + "', perFreePassAmount='" + this.perFreePassAmount + "', passFreeAlwaysConfirm='" + this.passFreeAlwaysConfirm + "'}";
    }
}
