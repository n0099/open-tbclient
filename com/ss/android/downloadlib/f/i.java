package com.ss.android.downloadlib.f;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.a.a.a.o;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: b  reason: collision with root package name */
    private static Object[] f12991b = new Object[0];
    private static Object[] c = new Object[73];

    /* renamed from: a  reason: collision with root package name */
    static final char[] f12990a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static String d = null;

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static long C(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0L;
        }
        try {
            return Long.valueOf(jSONObject.optString(str)).longValue();
        } catch (Exception e) {
            return 0L;
        }
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject2;
    }

    @NonNull
    public static JSONObject a(JSONObject jSONObject) {
        return a(jSONObject, new JSONObject());
    }

    @NonNull
    public static JSONObject a(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        if (jSONObjectArr != null && jSONObjectArr.length != 0) {
            for (JSONObject jSONObject2 : jSONObjectArr) {
                if (jSONObject2 != null) {
                    a(jSONObject2, jSONObject);
                }
            }
        }
        return jSONObject;
    }

    public static boolean a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null) {
                return !queryIntentActivities.isEmpty();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static PackageInfo h(com.ss.android.b.a.b.a aVar) {
        com.ss.android.socialbase.downloader.g.c h;
        if (aVar == null || (h = com.ss.android.socialbase.downloader.downloader.f.iB(com.ss.android.downloadlib.a.j.a()).h(aVar.t())) == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.appdownloader.c.a(com.ss.android.downloadlib.a.j.a(), h, h.k(), h.h());
        } catch (Throwable th) {
            return null;
        }
    }

    public static Drawable a(Context context, String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (context == null || TextUtils.isEmpty(str) || (packageArchiveInfo = (packageManager = context.getPackageManager()).getPackageArchiveInfo(str, 0)) == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadIcon(packageManager);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                if (packageInfo != null) {
                    return packageInfo.versionCode;
                }
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        return -1;
    }

    public static Drawable c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static boolean d(Context context, String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.a.j.a();
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public static com.ss.android.downloadlib.a.b.b A(String str, int i, String str2) {
        com.ss.android.downloadlib.a.b.b bVar = new com.ss.android.downloadlib.a.b.b();
        if (!TextUtils.isEmpty(str)) {
            try {
                PackageInfo packageInfo = com.ss.android.downloadlib.a.j.a().getPackageManager().getPackageInfo(str, 0);
                if (packageInfo != null) {
                    bVar.QU(packageInfo.versionCode);
                    bVar.QT(com.ss.android.downloadlib.a.b.b.f12934b);
                    o eER = com.ss.android.downloadlib.a.j.eER();
                    if (eER != null && eER.a() && !b(packageInfo.versionCode, i, packageInfo.versionName, str2)) {
                        bVar.QT(com.ss.android.downloadlib.a.b.b.c);
                    }
                }
            } catch (Exception e) {
            }
        }
        return bVar;
    }

    private static boolean b(int i, int i2, String str, String str2) {
        if (i2 == 0 && TextUtils.isEmpty(str2)) {
            return true;
        }
        return (i2 > 0 && i >= i2) || a(str, str2) >= 0;
    }

    public static boolean i(com.ss.android.b.a.b.a aVar) {
        if (aVar == null) {
            return false;
        }
        return A(aVar.m(), aVar.r(), aVar.s()).a();
    }

    public static boolean b(com.ss.android.a.a.b.c cVar) {
        if (cVar == null) {
            return false;
        }
        return A(cVar.v(), cVar.r(), cVar.s()).a();
    }

    public static boolean j(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context == null) {
            context = com.ss.android.downloadlib.a.j.a();
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public static boolean a(Context context, String str, String str2) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists() && (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) != null && packageArchiveInfo.packageName.equals(str2)) {
                int i = packageArchiveInfo.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
                } catch (PackageManager.NameNotFoundException e) {
                    packageInfo = null;
                }
                if (packageInfo != null) {
                    return i == packageInfo.versionCode;
                }
                return false;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean e(Context context, String str) {
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
            int i = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException e) {
                packageInfo = null;
            }
            if (packageInfo != null) {
                return i <= packageInfo.versionCode;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static Intent bB(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Signature[] bC(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public static Signature[] bD(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.signatures;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public static boolean b(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == signatureArr2) {
            return true;
        }
        if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
            return false;
        }
        for (int i = 0; i < signatureArr.length; i++) {
            if (signatureArr[i] == null && signatureArr2[i] != null) {
                return false;
            }
            if (signatureArr[i] != null && !signatureArr[i].equals(signatureArr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static int a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, String str) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, str);
        Mac mac = Mac.getInstance(str);
        mac.init(secretKeySpec);
        return mac.doFinal(bArr);
    }

    public static String a(String str, int i) {
        if (i == 0) {
            return "";
        }
        return (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("http://ad.toutiao.com/advertiser_package/") || str.startsWith("https://ad.toutiao.com/advertiser_package/")) {
            return true;
        }
        return d(str);
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http://lf3-ttcdn-tos.pstatp.com/") || str.startsWith("https://lf3-ttcdn-tos.pstatp.com/");
    }

    public static int a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return -2;
            }
            if (str.equals(str2)) {
                return 0;
            }
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            int min = Math.min(split.length, split2.length);
            int i = 0;
            int i2 = 0;
            while (i2 < min) {
                i = Integer.parseInt(split[i2]) - Integer.parseInt(split2[i2]);
                if (i != 0) {
                    break;
                }
                i2++;
            }
            if (i != 0) {
                return i <= 0 ? -1 : 1;
            }
            for (int i3 = i2; i3 < split.length; i3++) {
                if (Integer.parseInt(split[i3]) > 0) {
                    return 1;
                }
            }
            for (int i4 = i2; i4 < split2.length; i4++) {
                if (Integer.parseInt(split2[i4]) > 0) {
                    return -1;
                }
            }
            return 0;
        } catch (Exception e) {
            return -2;
        }
    }

    public static String a(String... strArr) {
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "ERROR";
    }

    public static void a(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            activity.finish();
        }
    }

    @NonNull
    public static <T> T M(T... tArr) {
        if (tArr == null) {
            throw new IllegalArgumentException("args is null");
        }
        for (T t : tArr) {
            if (t != null) {
                return t;
            }
        }
        throw new IllegalArgumentException("args is null");
    }

    public static long a(File file) {
        if (file == null) {
            return -1L;
        }
        try {
            return com.ss.android.socialbase.downloader.m.d.c(file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public static long b(File file) {
        long j = -1;
        if (file != null) {
            try {
                StatFs statFs = new StatFs(file.getAbsolutePath());
                if (Build.VERSION.SDK_INT >= 18) {
                    j = statFs.getTotalBytes();
                } else {
                    j = statFs.getBlockSize() * statFs.getTotalBytes();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return j;
    }

    public static boolean a() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void b() {
        a(new Throwable());
    }

    public static void a(@NonNull Throwable th) {
        com.ss.android.downloadlib.a.j.eEQ().a(null, new com.ss.android.socialbase.downloader.e.a(1, b(th)), 1);
    }

    public static String b(Throwable th) {
        if (th == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
