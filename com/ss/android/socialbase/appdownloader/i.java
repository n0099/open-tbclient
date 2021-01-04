package com.ss.android.socialbase.appdownloader;

import android.content.Context;
/* loaded from: classes4.dex */
public class i {
    public static int a(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.b.eHp().getResources().getIdentifier(str, "layout", com.ss.android.socialbase.downloader.downloader.b.eHp().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int a(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "string", context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int b(String str) {
        return a(com.ss.android.socialbase.downloader.downloader.b.eHp(), str);
    }

    public static int c(String str) {
        try {
            return a(str, com.ss.android.socialbase.downloader.downloader.b.eHp().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int a(String str, String str2) {
        try {
            return com.ss.android.socialbase.downloader.downloader.b.eHp().getResources().getIdentifier(str, "drawable", str2);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int d(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.b.eHp().getResources().getIdentifier(str, "style", com.ss.android.socialbase.downloader.downloader.b.eHp().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int e(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.b.eHp().getResources().getIdentifier(str, "id", com.ss.android.socialbase.downloader.downloader.b.eHp().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int f(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.b.eHp().getResources().getIdentifier(str, "color", com.ss.android.socialbase.downloader.downloader.b.eHp().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int b(String str, String str2) {
        try {
            return com.ss.android.socialbase.downloader.downloader.b.eHp().getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
