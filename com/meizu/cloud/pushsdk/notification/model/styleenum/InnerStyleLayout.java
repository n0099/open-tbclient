package com.meizu.cloud.pushsdk.notification.model.styleenum;
/* loaded from: classes16.dex */
public enum InnerStyleLayout {
    EXPANDABLE_STANDARD(0),
    EXPANDABLE_TEXT(1),
    EXPANDABLE_PIC(2),
    EXPANDABLE_VIDEO(3);
    
    private int code;

    InnerStyleLayout(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }
}
