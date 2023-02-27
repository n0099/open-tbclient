package com.yy.mobile.framework.revenuesdk.payapi.bean;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class PaysSettingInfo {
    public String customerServiceHotline;
    public String customerServiceMsg;
    public int feedbackSwitch;
    public int payChargeAmountLimit;
    public String payRemindMsg;
    public List<SplitMinAmountInfo> splitMinAmountInfoList = new ArrayList();
    public String successMsg;

    public String toString() {
        return "PaysSettingInfo {payChargeAmountLimit=" + this.payChargeAmountLimit + ", splitMinAmountInfoList='" + this.splitMinAmountInfoList + "'}";
    }
}
