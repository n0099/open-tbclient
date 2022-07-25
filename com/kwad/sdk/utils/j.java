package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.util.Locale;
/* loaded from: classes5.dex */
public final class j {
    public static String cb(Context context) {
        try {
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 64);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static int cc(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    public static int cd(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return (int) (displayMetrics.widthPixels / displayMetrics.density);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int ce(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return (int) (displayMetrics.heightPixels / displayMetrics.density);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static int getScreenHeight(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getScreenWidth(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String y(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(str, 64);
                if (packageInfo != null) {
                    return packageInfo.versionName;
                }
            } catch (Exception unused) {
            }
        }
        return "";
    }
}
