package com.ss.android.socialbase.appdownloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public final class g {

    /* loaded from: classes3.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f59801b;

        /* renamed from: c  reason: collision with root package name */
        public Drawable f59802c;

        /* renamed from: d  reason: collision with root package name */
        public String f59803d;

        /* renamed from: e  reason: collision with root package name */
        public String f59804e;

        /* renamed from: f  reason: collision with root package name */
        public int f59805f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f59806g;

        public a(String str, String str2, Drawable drawable, String str3, String str4, int i2, boolean z) {
            b(str2);
            a(drawable);
            a(str);
            c(str3);
            d(str4);
            a(i2);
            a(z);
        }

        public Drawable a() {
            return this.f59802c;
        }

        public boolean b() {
            return this.f59806g;
        }

        public String c() {
            return this.a;
        }

        public String d() {
            return this.f59801b;
        }

        public String e() {
            return this.f59803d;
        }

        public int f() {
            return this.f59805f;
        }

        public String g() {
            return this.f59804e;
        }

        public String toString() {
            return "{\n  pkg name: " + c() + "\n  app icon: " + a() + "\n  app name: " + d() + "\n  app path: " + e() + "\n  app v name: " + g() + "\n  app v code: " + f() + "\n  is system: " + b() + "}";
        }

        public void a(Drawable drawable) {
            this.f59802c = drawable;
        }

        public void b(String str) {
            this.f59801b = str;
        }

        public void c(String str) {
            this.f59803d = str;
        }

        public void d(String str) {
            this.f59804e = str;
        }

        public void a(boolean z) {
            this.f59806g = z;
        }

        public void a(String str) {
            this.a = str;
        }

        public void a(int i2) {
            this.f59805f = i2;
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
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
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
