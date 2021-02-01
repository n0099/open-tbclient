package com.yy.mediaframework.utils;
/* loaded from: classes4.dex */
public class TimerUtil {
    private static final boolean on = false;
    private boolean isOpen;
    private long mEndTime;
    private String mFuncName;
    private long mStartTime;
    private String mTAG;

    public TimerUtil(String str, String str2, boolean z) {
        this.mTAG = str;
        this.mFuncName = str2;
        this.isOpen = z;
        start();
    }

    private void start() {
    }

    public void end() {
    }
}
