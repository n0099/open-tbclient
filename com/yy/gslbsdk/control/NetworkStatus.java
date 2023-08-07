package com.yy.gslbsdk.control;

import com.baidu.searchbox.player.model.YYOption;
import java.util.Locale;
/* loaded from: classes10.dex */
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
        return getInstance().m842clone();
    }

    public boolean canV4() {
        boolean z;
        boolean z2;
        if ((this.mStatus & 1) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.mStatus == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || z || this.mStatus == 0) {
            return true;
        }
        return false;
    }

    public boolean canV6() {
        boolean z;
        boolean z2;
        if ((this.mStatus & 2) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.mStatus == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return true;
        }
        if (this.mEnableV6 && z) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public NetworkStatus m842clone() {
        NetworkStatus networkStatus = new NetworkStatus();
        networkStatus.mEnableV6 = this.mEnableV6;
        networkStatus.mStatus = this.mStatus;
        return networkStatus;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public boolean isEnableV6() {
        return this.mEnableV6;
    }

    public String toString() {
        String str;
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        if (this.mEnableV6) {
            str = YYOption.IsLive.VALUE_TRUE;
        } else {
            str = "false";
        }
        objArr[0] = str;
        objArr[1] = Integer.valueOf(this.mStatus);
        return String.format(locale, "[EnableV6=%s, Status=%d]", objArr);
    }

    public static void updateEnableV6(boolean z) {
        getInstance().mEnableV6 = z;
    }

    public static void updateStatus(int i) {
        getInstance().mStatus = i;
    }
}
