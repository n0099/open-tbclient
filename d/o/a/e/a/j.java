package d.o.a.e.a;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
/* loaded from: classes7.dex */
public final class j {

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f71017a;

        /* renamed from: b  reason: collision with root package name */
        public String f71018b;

        /* renamed from: c  reason: collision with root package name */
        public Drawable f71019c;

        /* renamed from: d  reason: collision with root package name */
        public String f71020d;

        /* renamed from: e  reason: collision with root package name */
        public String f71021e;

        /* renamed from: f  reason: collision with root package name */
        public int f71022f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f71023g;

        public a(String str, String str2, Drawable drawable, String str3, String str4, int i2, boolean z) {
            f(str2);
            c(drawable);
            d(str);
            i(str3);
            k(str4);
            b(i2);
            e(z);
        }

        public Drawable a() {
            return this.f71019c;
        }

        public void b(int i2) {
            this.f71022f = i2;
        }

        public void c(Drawable drawable) {
            this.f71019c = drawable;
        }

        public void d(String str) {
            this.f71017a = str;
        }

        public void e(boolean z) {
            this.f71023g = z;
        }

        public void f(String str) {
            this.f71018b = str;
        }

        public boolean g() {
            return this.f71023g;
        }

        public String h() {
            return this.f71017a;
        }

        public void i(String str) {
            this.f71020d = str;
        }

        public String j() {
            return this.f71018b;
        }

        public void k(String str) {
            this.f71021e = str;
        }

        public String l() {
            return this.f71020d;
        }

        public int m() {
            return this.f71022f;
        }

        public String n() {
            return this.f71021e;
        }

        public String toString() {
            return "{\n  pkg name: " + h() + "\n  app icon: " + a() + "\n  app name: " + j() + "\n  app path: " + l() + "\n  app v name: " + n() + "\n  app v code: " + m() + "\n  is system: " + g() + "}";
        }
    }

    public static int a(String str) {
        if (d(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = d.o.a.e.b.g.d.l().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static a b(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        return new a(packageInfo.packageName, applicationInfo.loadLabel(packageManager).toString(), applicationInfo.loadIcon(packageManager), applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }

    public static a c(String str) {
        try {
            PackageManager packageManager = d.o.a.e.b.g.d.l().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return b(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean d(String str) {
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
}
