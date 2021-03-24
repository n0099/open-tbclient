package com.meizu.cloud.pushsdk.notification;

import android.content.Context;
import android.graphics.Bitmap;
/* loaded from: classes6.dex */
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
