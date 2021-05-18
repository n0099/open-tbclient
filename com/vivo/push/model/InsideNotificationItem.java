package com.vivo.push.model;
/* loaded from: classes7.dex */
public class InsideNotificationItem extends UPSNotificationMessage {
    public int mAppType;
    public boolean mIsShowBigPicOnMobileNet;
    public int mMessageType;
    public String mReactPackage;
    public String mSuitReactVersion;

    public int getAppType() {
        return this.mAppType;
    }

    public int getMessageType() {
        return this.mMessageType;
    }

    public String getReactPackage() {
        return this.mReactPackage;
    }

    public String getSuitReactVersion() {
        return this.mSuitReactVersion;
    }

    public boolean isShowBigPicOnMobileNet() {
        return this.mIsShowBigPicOnMobileNet;
    }

    public void setAppType(int i2) {
        this.mAppType = i2;
    }

    public void setIsShowBigPicOnMobileNet(boolean z) {
        this.mIsShowBigPicOnMobileNet = z;
    }

    public void setMessageType(int i2) {
        this.mMessageType = i2;
    }

    public void setReactPackage(String str) {
        this.mReactPackage = str;
    }

    public void setSuitReactVersion(String str) {
        this.mSuitReactVersion = str;
    }
}
