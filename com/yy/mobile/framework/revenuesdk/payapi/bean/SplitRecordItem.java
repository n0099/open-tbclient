package com.yy.mobile.framework.revenuesdk.payapi.bean;
/* loaded from: classes8.dex */
public class SplitRecordItem {
    public static final int ITEM_TYPE_LINK = 2;
    public static final int ITEN_TYPE_AMOUNT = 1;
    public String id;
    public String name;
    public int type;
    public String value;

    public SplitRecordItem() {
    }

    public SplitRecordItem(String str, int i, String str2, String str3) {
        this.type = i;
        this.name = str2;
        this.value = str3;
        this.id = str;
    }

    public String toString() {
        return "SplitRecordItem{type='" + this.type + "', id='" + this.id + "', name='" + this.name + "'value='" + this.value + "'}";
    }
}
