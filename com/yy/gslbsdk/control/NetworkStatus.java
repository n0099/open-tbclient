package com.yy.gslbsdk.control;

import java.util.Locale;
/* loaded from: classes7.dex */
public class NetworkStatus {
    public static final int IP_V4 = 1;
    public static final int IP_V6 = 2;
    public static final int STATUS_IP_V4_AND_V6 = 3;
    public static final int STATUS_IP_V4_ONLY = 1;
    public static final int STATUS_IP_V6_ONLY = 2;
    public static final int STATUS_IP_V_NONE = 0;
    public static NetworkStatus sInstance = new NetworkStatus();
    public boolean mEnableV6 = true;
    public int mStatus = 0;

    public static NetworkStatus getInstance() {
        if (sInstance == null) {
            sInstance = new NetworkStatus();
        }
        return sInstance;
    }

    public static NetworkStatus getInstanceClone() {
        return getInstance().m630clone();
    }

    public static void updateEnableV6(boolean z) {
        getInstance().mEnableV6 = z;
    }

    public static void updateStatus(int i2) {
        getInstance().mStatus = i2;
    }

    public boolean canV4() {
        return (this.mStatus == 1) || ((this.mStatus & 1) > 0) || this.mStatus == 0;
    }

    public boolean canV6() {
        boolean z = (this.mStatus & 2) > 0;
        if (this.mStatus == 2) {
            return true;
        }
        return this.mEnableV6 && z;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public boolean isEnableV6() {
        return this.mEnableV6;
    }

    public String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        objArr[0] = this.mEnableV6 ? "true" : "false";
        objArr[1] = Integer.valueOf(this.mStatus);
        return String.format(locale, "[EnableV6=%s, Status=%d]", objArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public NetworkStatus m630clone() {
        NetworkStatus networkStatus = new NetworkStatus();
        networkStatus.mEnableV6 = this.mEnableV6;
        networkStatus.mStatus = this.mStatus;
        return networkStatus;
    }
}
