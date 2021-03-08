package com.yy.mediaframework.stat;
/* loaded from: classes6.dex */
public class YMFLiveExceptionStat {
    private static YMFLiveExceptionStat mInstance;
    private String tag = "YMFLive";
    private boolean mExistError = false;
    public IYMFExceptionListener mExceptionListener = null;

    public static YMFLiveExceptionStat getInstance() {
        if (mInstance == null) {
            mInstance = new YMFLiveExceptionStat();
        }
        return mInstance;
    }

    public void setYMFExceptionListener(IYMFExceptionListener iYMFExceptionListener) {
        this.mExceptionListener = iYMFExceptionListener;
    }

    public void notifyException(YMFLiveExceptionType yMFLiveExceptionType) {
        if (this.mExceptionListener != null) {
            this.mExceptionListener.onVideoLiveAbnormalStateNotification(yMFLiveExceptionType);
        }
    }
}
