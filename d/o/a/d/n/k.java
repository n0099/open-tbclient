package d.o.a.d.n;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.alibaba.fastjson.asm.Label;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.a.a.a.o;
import d.o.a.d.f.c;
import d.o.a.d.f.n;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static Object[] f66277a = new Object[0];

    /* renamed from: b  reason: collision with root package name */
    public static Object[] f66278b = new Object[73];

    public static String A(Throwable th) {
        if (th == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static void B() {
        q(new Throwable());
    }

    public static boolean C(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context == null) {
            context = n.a();
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public static boolean D(d.o.a.b.a.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        return j(bVar.e(), bVar.D(), bVar.E()).b();
    }

    public static boolean E(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static Drawable F(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    public static void G() {
        try {
            ActivityManager activityManager = (ActivityManager) n.a().getSystemService("activity");
            for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(20)) {
                if (n.a().getPackageName().equals(runningTaskInfo.topActivity.getPackageName())) {
                    activityManager.moveTaskToFront(runningTaskInfo.id, 1);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @WorkerThread
    public static boolean H(String str) {
        File file;
        Context a2 = n.a();
        if (!TextUtils.isEmpty(str) && I(a2, str)) {
            int i2 = a2.getApplicationInfo().targetSdkVersion;
            if (n.s().optInt("get_ext_dir_mode") != 0 || Build.VERSION.SDK_INT < 29 || ((i2 != 29 || Environment.isExternalStorageLegacy()) && i2 <= 29)) {
                try {
                    if (Build.VERSION.SDK_INT >= 29 && a2.getApplicationInfo().targetSdkVersion >= 29 && n.s().optInt("get_ext_dir_mode") == 1) {
                        file = P(a2, str);
                    } else {
                        String path = Environment.getExternalStorageDirectory().getPath();
                        file = new File(path, "android/data/" + str);
                    }
                    if (file.exists()) {
                        long a3 = g.a(file);
                        PackageInfo packageInfo = a2.getPackageManager().getPackageInfo(str, 0);
                        if (packageInfo != null) {
                            if (packageInfo.lastUpdateTime < a3) {
                                return true;
                            }
                        }
                        return false;
                    }
                    return false;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean I(Context context, String str) {
        if (context == null) {
            context = n.a();
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean J(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("http://ad.toutiao.com/advertiser_package/") || str.startsWith("https://ad.toutiao.com/advertiser_package/")) {
            return true;
        }
        return L(str);
    }

    public static boolean K(Context context, String str) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null) {
                return false;
            }
            String str2 = packageArchiveInfo.packageName;
            int i2 = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i2 <= packageInfo.versionCode;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean L(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http://lf3-ttcdn-tos.pstatp.com/") || str.startsWith("https://lf3-ttcdn-tos.pstatp.com/");
    }

    public static Intent M(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        return launchIntentForPackage;
    }

    public static Signature[] N(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Signature[] O(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static File P(Context context, String str) {
        File parentFile = context.getExternalFilesDir(null).getParentFile();
        String parent = parentFile != null ? parentFile.getParent() : null;
        File file = new File(parent + File.separator + str);
        StringBuilder sb = new StringBuilder();
        sb.append("getExtDir: file.toString()-->");
        sb.append(file.toString());
        d.o.a.e.b.c.a.g("ToolUtils", sb.toString());
        return file;
    }

    public static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int b(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int c(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.equals(str2)) {
                    return 0;
                }
                String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                int min = Math.min(split.length, split2.length);
                int i2 = 0;
                int i3 = 0;
                while (i2 < min) {
                    i3 = Integer.parseInt(split[i2]) - Integer.parseInt(split2[i2]);
                    if (i3 != 0) {
                        break;
                    }
                    i2++;
                }
                if (i3 != 0) {
                    return i3 > 0 ? 1 : -1;
                }
                for (int i4 = i2; i4 < split.length; i4++) {
                    if (Integer.parseInt(split[i4]) > 0) {
                        return 1;
                    }
                }
                while (i2 < split2.length) {
                    if (Integer.parseInt(split2[i2]) > 0) {
                        return -1;
                    }
                    i2++;
                }
                return 0;
            }
        } catch (Exception unused) {
        }
        return -2;
    }

    public static long d(long j) {
        try {
            return f(Environment.getExternalStorageDirectory(), j);
        } catch (Exception e2) {
            e2.printStackTrace();
            return j;
        }
    }

    public static long e(File file) {
        long j = -1;
        if (file == null) {
            return -1L;
        }
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                j = statFs.getTotalBytes();
            } else {
                j = statFs.getTotalBytes() * statFs.getBlockSize();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return j;
    }

    public static long f(File file, long j) {
        if (file == null) {
            return j;
        }
        try {
            return d.o.a.e.b.l.e.w0(file.getAbsolutePath());
        } catch (Exception e2) {
            e2.printStackTrace();
            return j;
        }
    }

    public static long g(JSONObject jSONObject, String str) {
        return d.o.a.a.a.e.a.a(jSONObject, str);
    }

    public static PackageInfo h(d.o.a.b.a.c.b bVar) {
        DownloadInfo f2;
        if (bVar == null || (f2 = d.o.a.e.b.g.a.l(n.a()).f(bVar.s())) == null) {
            return null;
        }
        try {
            return d.o.a.e.a.d.h(n.a(), f2, f2.F0(), f2.q0());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Drawable i(Context context, String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (context != null && !TextUtils.isEmpty(str) && (packageArchiveInfo = (packageManager = context.getPackageManager()).getPackageArchiveInfo(str, 0)) != null) {
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                return applicationInfo.loadIcon(packageManager);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static c.d j(String str, int i2, String str2) {
        c.d dVar = new c.d();
        if (TextUtils.isEmpty(str)) {
            return dVar;
        }
        try {
            PackageInfo packageInfo = n.a().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                dVar.d(packageInfo.versionCode);
                dVar.a(c.d.f66016d);
                o r = n.r();
                if (r != null && r.a() && !t(packageInfo.versionCode, i2, packageInfo.versionName, str2)) {
                    dVar.a(c.d.f66017e);
                }
            }
        } catch (Exception unused) {
        }
        return dVar;
    }

    @NonNull
    public static <T> T k(T... tArr) {
        if (tArr != null) {
            for (T t : tArr) {
                if (t != null) {
                    return t;
                }
            }
            throw new IllegalArgumentException("args is null");
        }
        throw new IllegalArgumentException("args is null");
    }

    public static String l(String str, int i2) {
        return i2 == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i2) ? str : str.substring(0, i2);
    }

    public static String m(String... strArr) {
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "ERROR";
    }

    @NonNull
    public static JSONObject n(JSONObject jSONObject) {
        return d.o.a.a.a.e.a.b(jSONObject);
    }

    public static JSONObject o(JSONObject jSONObject, JSONObject jSONObject2) {
        d.o.a.a.a.e.a.c(jSONObject, jSONObject2);
        return jSONObject2;
    }

    @NonNull
    public static JSONObject p(JSONObject... jSONObjectArr) {
        return d.o.a.a.a.e.a.d(jSONObjectArr);
    }

    public static void q(@NonNull Throwable th) {
        n.q().a(null, new BaseException(1, A(th)), 1);
    }

    public static void r(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.putOpt(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean s() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean t(int i2, int i3, String str, String str2) {
        if (i3 == 0 && TextUtils.isEmpty(str2)) {
            return true;
        }
        return (i3 > 0 && i2 >= i3) || c(str, str2) >= 0;
    }

    public static boolean u(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null) {
                return !queryIntentActivities.isEmpty();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean v(Context context, String str, String str2) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists() && (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) != null && packageArchiveInfo.packageName.equals(str2)) {
                int i2 = packageArchiveInfo.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
                } catch (PackageManager.NameNotFoundException unused) {
                    packageInfo = null;
                }
                if (packageInfo == null) {
                    return false;
                }
                return i2 == packageInfo.versionCode;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean w(d.o.a.a.a.c.d dVar) {
        if (dVar == null) {
            return false;
        }
        return j(dVar.v(), dVar.r(), dVar.s()).b();
    }

    public static boolean x(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean y(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == signatureArr2) {
            return true;
        }
        if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < signatureArr.length; i2++) {
            if ((signatureArr[i2] == null && signatureArr2[i2] != null) || (signatureArr[i2] != null && !signatureArr[i2].equals(signatureArr2[i2]))) {
                return false;
            }
        }
        return true;
    }

    public static int z(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }
}
