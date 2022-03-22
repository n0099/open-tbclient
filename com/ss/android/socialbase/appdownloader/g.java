package com.ss.android.socialbase.appdownloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
/* loaded from: classes7.dex */
public final class g {

    /* loaded from: classes7.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f43096b;

        /* renamed from: c  reason: collision with root package name */
        public Drawable f43097c;

        /* renamed from: d  reason: collision with root package name */
        public String f43098d;

        /* renamed from: e  reason: collision with root package name */
        public String f43099e;

        /* renamed from: f  reason: collision with root package name */
        public int f43100f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f43101g;

        public a(String str, String str2, Drawable drawable, String str3, String str4, int i, boolean z) {
            b(str2);
            a(drawable);
            a(str);
            c(str3);
            d(str4);
            a(i);
            a(z);
        }

        public Drawable a() {
            return this.f43097c;
        }

        public boolean b() {
            return this.f43101g;
        }

        public String c() {
            return this.a;
        }

        public String d() {
            return this.f43096b;
        }

        public String e() {
            return this.f43098d;
        }

        public int f() {
            return this.f43100f;
        }

        public String g() {
            return this.f43099e;
        }

        public String toString() {
            return "{\n  pkg name: " + c() + "\n  app icon: " + a() + "\n  app name: " + d() + "\n  app path: " + e() + "\n  app v name: " + g() + "\n  app v code: " + f() + "\n  is system: " + b() + "}";
        }

        public void a(Drawable drawable) {
            this.f43097c = drawable;
        }

        public void b(String str) {
            this.f43096b = str;
        }

        public void c(String str) {
            this.f43098d = str;
        }

        public void d(String str) {
            this.f43099e = str;
        }

        public void a(boolean z) {
            this.f43101g = z;
        }

        public void a(String str) {
            this.a = str;
        }

        public void a(int i) {
            this.f43100f = i;
        }
    }

    public static int a(String str) {
        if (c(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = com.ss.android.socialbase.downloader.downloader.c.N().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static a b(String str) {
        try {
            PackageManager packageManager = com.ss.android.socialbase.downloader.downloader.c.N().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return a(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean c(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static a a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        return new a(packageInfo.packageName, applicationInfo.loadLabel(packageManager).toString(), applicationInfo.loadIcon(packageManager), applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }
}
