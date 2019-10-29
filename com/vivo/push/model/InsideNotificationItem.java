package com.vivo.push.model;
/* loaded from: classes3.dex */
public class InsideNotificationItem extends UPSNotificationMessage {
    private int mAppType;
    private boolean mIsShowBigPicOnMobileNet;
    private int mMessageType;
    private String mReactPackage;
    private String mSuitReactVersion;

    public int getAppType() {
        return this.mAppType;
    }

    public void setAppType(int i) {
        this.mAppType = i;
    }

    public String getReactPackage() {
        return this.mReactPackage;
    }

    public void setReactPackage(String str) {
        this.mReactPackage = str;
    }

    public boolean isShowBigPicOnMobileNet() {
        return this.mIsShowBigPicOnMobileNet;
    }

    public void setIsShowBigPicOnMobileNet(boolean z) {
        this.mIsShowBigPicOnMobileNet = z;
    }

    public String getSuitReactVersion() {
        return this.mSuitReactVersion;
    }

    public void setSuitReactVersion(String str) {
        this.mSuitReactVersion = str;
    }

    public int getMessageType() {
        return this.mMessageType;
    }

    public void setMessageType(int i) {
        this.mMessageType = i;
    }
}
