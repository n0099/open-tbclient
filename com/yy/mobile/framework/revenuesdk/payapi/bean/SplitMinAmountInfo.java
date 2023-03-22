package com.yy.mobile.framework.revenuesdk.payapi.bean;
/* loaded from: classes9.dex */
public class SplitMinAmountInfo {
    public static final int SPLIT_TYPE_OF_BEFOREE_PAY = 1;
    public static final int SPLIT_TYPE_OF_PAY_FAILED = 2;
    public int minAmount;
    public int splitType;

    public SplitMinAmountInfo() {
    }

    public String toString() {
        return "SplitMinAmountInfo{splitType='" + this.splitType + "', minAmount='" + this.minAmount + "'}";
    }

    public SplitMinAmountInfo(int i, int i2) {
        this.splitType = i;
        this.minAmount = i2;
    }
}
