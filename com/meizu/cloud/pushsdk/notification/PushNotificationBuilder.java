package com.meizu.cloud.pushsdk.notification;
/* loaded from: classes8.dex */
public class PushNotificationBuilder {
    protected String clickPackageName;
    protected int mLargIcon;
    protected int mNotificationDefaults;
    protected int mNotificationFlags;
    protected String mNotificationsound;
    protected int mStatusbarIcon;
    protected long[] mVibratePattern;

    public String getClickPackageName() {
        return this.clickPackageName;
    }

    public int getmLargIcon() {
        return this.mLargIcon;
    }

    public int getmNotificationDefaults() {
        return this.mNotificationDefaults;
    }

    public int getmNotificationFlags() {
        return this.mNotificationFlags;
    }

    public String getmNotificationsound() {
        return this.mNotificationsound;
    }

    public int getmStatusbarIcon() {
        return this.mStatusbarIcon;
    }

    public long[] getmVibratePattern() {
        return this.mVibratePattern;
    }

    public void setClickPackageName(String str) {
        this.clickPackageName = str;
    }

    public void setmLargIcon(int i) {
        this.mLargIcon = i;
    }

    public void setmNotificationDefaults(int i) {
        this.mNotificationDefaults = i;
    }

    public void setmNotificationFlags(int i) {
        this.mNotificationFlags = i;
    }

    public void setmNotificationsound(String str) {
        this.mNotificationsound = str;
    }

    public void setmStatusbarIcon(int i) {
        this.mStatusbarIcon = i;
    }

    public void setmVibratePattern(long[] jArr) {
        this.mVibratePattern = jArr;
    }
}
