package com.vivo.push.model;
/* loaded from: classes6.dex */
public class SubscribeAppInfo {
    public static final int SUBSCIRBE = 1;
    public static final int SUBSCIRBE_CANCLE = 2;
    public int mActualStatus;
    public String mName;
    public int mTargetStatus;

    public SubscribeAppInfo(String str, int i2, int i3) {
        this.mName = str;
        this.mTargetStatus = i2;
        this.mActualStatus = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SubscribeAppInfo.class == obj.getClass()) {
            SubscribeAppInfo subscribeAppInfo = (SubscribeAppInfo) obj;
            String str = this.mName;
            if (str == null) {
                if (subscribeAppInfo.mName != null) {
                    return false;
                }
            } else if (!str.equals(subscribeAppInfo.mName)) {
                return false;
            }
            return this.mTargetStatus == subscribeAppInfo.mTargetStatus;
        }
        return false;
    }

    public int getActualStatus() {
        return this.mActualStatus;
    }

    public String getName() {
        return this.mName;
    }

    public int getTargetStatus() {
        return this.mTargetStatus;
    }

    public int hashCode() {
        String str = this.mName;
        return (((str == null ? 0 : str.hashCode()) + 31) * 31) + this.mTargetStatus;
    }

    public void setActualStatus(int i2) {
        this.mActualStatus = i2;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setTargetStatus(int i2) {
        this.mTargetStatus = i2;
    }

    public String toString() {
        return "SubscribeAppInfo [mName=" + this.mName + ", mTargetStatus=" + this.mTargetStatus + ", mActualStatus=" + this.mActualStatus + "]";
    }
}
