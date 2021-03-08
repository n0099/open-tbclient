package com.ss.android.socialbase.appdownloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
/* loaded from: classes6.dex */
public final class g {
    public static a abh(String str) {
        try {
            PackageManager packageManager = com.ss.android.socialbase.downloader.downloader.b.eGG().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return a(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static a a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        return new a(packageInfo.packageName, applicationInfo.loadLabel(packageManager).toString(), applicationInfo.loadIcon(packageManager), applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f7768a;
        private String b;
        private String d;
        private String e;
        private int f;
        private boolean g;
        private Drawable qfp;

        public Drawable a() {
            return this.qfp;
        }

        public void a(Drawable drawable) {
            this.qfp = drawable;
        }

        public boolean b() {
            return this.g;
        }

        public void a(boolean z) {
            this.g = z;
        }

        public String c() {
            return this.f7768a;
        }

        public void a(String str) {
            this.f7768a = str;
        }

        public String d() {
            return this.b;
        }

        public void b(String str) {
            this.b = str;
        }

        public String e() {
            return this.d;
        }

        public void c(String str) {
            this.d = str;
        }

        public int f() {
            return this.f;
        }

        public void a(int i) {
            this.f = i;
        }

        public String g() {
            return this.e;
        }

        public void d(String str) {
            this.e = str;
        }

        public a(String str, String str2, Drawable drawable, String str3, String str4, int i, boolean z) {
            b(str2);
            a(drawable);
            a(str);
            c(str3);
            d(str4);
            a(i);
            a(z);
        }

        public String toString() {
            return "{\n  pkg name: " + c() + "\n  app icon: " + a() + "\n  app name: " + d() + "\n  app path: " + e() + "\n  app v name: " + g() + "\n  app v code: " + f() + "\n  is system: " + b() + "}";
        }
    }
}
