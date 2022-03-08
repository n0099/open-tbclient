package com.meizu.cloud.pushsdk.notification;

import android.content.Context;
import android.graphics.Bitmap;
/* loaded from: classes8.dex */
public class PushNotificationBuilder {
    public String appLabel;
    public Bitmap appLargeIcon;
    public String clickPackageName;
    public Context context;
    public int mLargIcon;
    public int mNotificationDefaults;
    public int mNotificationFlags;
    public String mNotificationsound;
    public int mStatusbarIcon;
    public long[] mVibratePattern;

    public PushNotificationBuilder() {
    }

    public PushNotificationBuilder(Context context) {
        this.context = context;
    }

    public String getAppLabel() {
        return this.appLabel;
    }

    public Bitmap getAppLargeIcon() {
        return this.appLargeIcon;
    }

    public String getClickPackageName() {
        return this.clickPackageName;
    }

    public Context getContext() {
        return this.context;
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

    public void setAppLabel(String str) {
        this.appLabel = str;
    }

    public void setAppLargeIcon(Bitmap bitmap) {
        this.appLargeIcon = bitmap;
    }

    public void setClickPackageName(String str) {
        this.clickPackageName = str;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setmLargIcon(int i2) {
        this.mLargIcon = i2;
    }

    public void setmNotificationDefaults(int i2) {
        this.mNotificationDefaults = i2;
    }

    public void setmNotificationFlags(int i2) {
        this.mNotificationFlags = i2;
    }

    public void setmNotificationsound(String str) {
        this.mNotificationsound = str;
    }

    public void setmStatusbarIcon(int i2) {
        this.mStatusbarIcon = i2;
    }

    public void setmVibratePattern(long[] jArr) {
        this.mVibratePattern = jArr;
    }
}
