package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.sina.weibo.sdk.utils.ResourceManager;
/* loaded from: classes7.dex */
public class i {
    public static int a(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.c.N().getResources().getIdentifier(str, TtmlNode.TAG_LAYOUT, com.ss.android.socialbase.downloader.downloader.c.N().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int b(String str) {
        return a(com.ss.android.socialbase.downloader.downloader.c.N(), str);
    }

    public static int c(String str) {
        try {
            return a(str, com.ss.android.socialbase.downloader.downloader.c.N().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int d(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.c.N().getResources().getIdentifier(str, "style", com.ss.android.socialbase.downloader.downloader.c.N().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int e(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.c.N().getResources().getIdentifier(str, "id", com.ss.android.socialbase.downloader.downloader.c.N().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int f(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.c.N().getResources().getIdentifier(str, "color", com.ss.android.socialbase.downloader.downloader.c.N().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int b(String str, String str2) {
        try {
            return com.ss.android.socialbase.downloader.downloader.c.N().getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int a(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, EMABTest.TYPE_STRING, context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int a(String str, String str2) {
        try {
            return com.ss.android.socialbase.downloader.downloader.c.N().getResources().getIdentifier(str, ResourceManager.DRAWABLE, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
