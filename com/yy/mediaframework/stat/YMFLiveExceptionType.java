package com.yy.mediaframework.stat;
/* loaded from: classes6.dex */
public enum YMFLiveExceptionType {
    AnchorStatus_CAPTURE_ERROR(1),
    AnchorStatus_ENCODE_ERROR(2),
    AnchorStatus_SWITCH_BACKGROUND(3),
    AnchorStatus_BACK_TO_NORMAL(4),
    AnchorStatus_CAPTURE_USED_BY_HIGHER_PRIORITY(5);
    
    private final int value;

    YMFLiveExceptionType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
