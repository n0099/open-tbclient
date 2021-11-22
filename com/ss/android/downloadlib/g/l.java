package com.ss.android.downloadlib.g;

import android.annotation.SuppressLint;
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
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ss.android.download.api.config.n;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f69786a;

    /* renamed from: b  reason: collision with root package name */
    public static Object[] f69787b;

    /* renamed from: c  reason: collision with root package name */
    public static Object[] f69788c;

    /* renamed from: d  reason: collision with root package name */
    public static String f69789d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1671141598, "Lcom/ss/android/downloadlib/g/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1671141598, "Lcom/ss/android/downloadlib/g/l;");
                return;
            }
        }
        f69787b = new Object[0];
        f69788c = new Object[73];
        f69786a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f69789d = null;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return new File(str).exists();
        }
        return invokeL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) ? !TextUtils.isEmpty(str) && new File(str).exists() : invokeL.booleanValue;
    }

    public static Drawable c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            return null;
        }
        return (Drawable) invokeLL.objValue;
    }

    public static boolean d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, context, str)) == null) {
            if (context == null) {
                context = com.ss.android.downloadlib.addownload.j.getContext();
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
        return invokeLL.booleanValue;
    }

    public static boolean e(Context context, String str) {
        InterceptResult invokeLL;
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65569, null, context, str)) == null) {
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
        return invokeLL.booleanValue;
    }

    public static Intent f(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65570, null, context, str)) == null) {
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
        return (Intent) invokeLL.objValue;
    }

    public static Signature[] g(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65571, null, context, str)) == null) {
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
        return (Signature[]) invokeLL.objValue;
    }

    public static Signature[] h(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, context, str)) == null) {
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
        return (Signature[]) invokeLL.objValue;
    }

    public static File i(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65573, null, context, str)) == null) {
            File parentFile = context.getExternalFilesDir(null).getParentFile();
            String parent = parentFile != null ? parentFile.getParent() : null;
            File file = new File(parent + File.separator + str);
            StringBuilder sb = new StringBuilder();
            sb.append("getExtDir: file.toString()-->");
            sb.append(file.toString());
            com.ss.android.socialbase.downloader.c.a.b("ToolUtils", sb.toString());
            return file;
        }
        return (File) invokeLL.objValue;
    }

    public static long a(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, jSONObject, str)) == null) ? com.ss.android.download.api.c.b.a(jSONObject, str) : invokeLL.longValue;
    }

    public static int b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, context, str)) == null) {
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
        return invokeLL.intValue;
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, jSONObject, jSONObject2)) == null) ? com.ss.android.download.api.c.b.a(jSONObject, jSONObject2) : (JSONObject) invokeLL.objValue;
    }

    @WorkerThread
    public static boolean c(String str) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, str)) == null) {
            Context context = com.ss.android.downloadlib.addownload.j.getContext();
            if (!TextUtils.isEmpty(str) && d(context, str)) {
                int i2 = context.getApplicationInfo().targetSdkVersion;
                if (com.ss.android.downloadlib.addownload.j.i().optInt("get_ext_dir_mode") != 0 || Build.VERSION.SDK_INT < 29 || ((i2 != 29 || Environment.isExternalStorageLegacy()) && i2 <= 29)) {
                    try {
                        if (Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 && com.ss.android.downloadlib.addownload.j.i().optInt("get_ext_dir_mode") == 1) {
                            file = i(context, str);
                        } else {
                            String path = Environment.getExternalStorageDirectory().getPath();
                            file = new File(path, "android/data/" + str);
                        }
                        if (file.exists()) {
                            long a2 = g.a(file);
                            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                            if (packageInfo != null) {
                                if (packageInfo.lastUpdateTime < a2) {
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
        return invokeL.booleanValue;
    }

    @NonNull
    public static JSONObject a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, jSONObject)) == null) ? com.ss.android.download.api.c.b.a(jSONObject) : (JSONObject) invokeL.objValue;
    }

    @NonNull
    public static JSONObject a(JSONObject... jSONObjectArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, jSONObjectArr)) == null) ? com.ss.android.download.api.c.b.a(jSONObjectArr) : (JSONObject) invokeL.objValue;
    }

    public static boolean a(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, context, intent)) == null) {
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
        return invokeLL.booleanValue;
    }

    public static boolean b(com.ss.android.downloadad.api.a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            return a(bVar.e(), bVar.I(), bVar.J()).a();
        }
        return invokeL.booleanValue;
    }

    public static boolean b(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, context, intent)) == null) {
            if (intent == null) {
                return false;
            }
            if (context == null) {
                context = com.ss.android.downloadlib.addownload.j.getContext();
            }
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            return queryIntentActivities != null && queryIntentActivities.size() > 0;
        }
        return invokeLL.booleanValue;
    }

    public static PackageInfo a(com.ss.android.downloadad.api.a.b bVar) {
        InterceptResult invokeL;
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bVar)) == null) {
            if (bVar == null || (downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.j.getContext()).getDownloadInfo(bVar.s())) == null) {
                return null;
            }
            try {
                return com.ss.android.socialbase.appdownloader.c.a(com.ss.android.downloadlib.addownload.j.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
            } catch (Throwable unused) {
                return null;
            }
        }
        return (PackageInfo) invokeL.objValue;
    }

    public static Drawable a(Context context, String str) {
        InterceptResult invokeLL;
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
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
        return (Drawable) invokeLL.objValue;
    }

    @SuppressLint({"MissingPermission"})
    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, null) == null) {
            try {
                if (com.ss.android.downloadlib.addownload.j.e().a(com.ss.android.downloadlib.addownload.j.getContext(), "android.permission.REORDER_TASKS")) {
                    ActivityManager activityManager = (ActivityManager) com.ss.android.downloadlib.addownload.j.getContext().getSystemService("activity");
                    for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(20)) {
                        if (com.ss.android.downloadlib.addownload.j.getContext().getPackageName().equals(runningTaskInfo.topActivity.getPackageName())) {
                            activityManager.moveTaskToFront(runningTaskInfo.id, 1);
                            return;
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @NonNull
    public static HashMap<String, String> b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, jSONObject)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (jSONObject != null) {
                try {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject.optString(next));
                    }
                    return hashMap;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static com.ss.android.downloadlib.addownload.b.c a(String str, int i2, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65545, null, str, i2, str2)) == null) {
            com.ss.android.downloadlib.addownload.b.c cVar = new com.ss.android.downloadlib.addownload.b.c();
            if (TextUtils.isEmpty(str)) {
                return cVar;
            }
            try {
                PackageInfo packageInfo = com.ss.android.downloadlib.addownload.j.getContext().getPackageManager().getPackageInfo(str, 0);
                if (packageInfo != null) {
                    cVar.b(packageInfo.versionCode);
                    cVar.a(com.ss.android.downloadlib.addownload.b.c.f69416b);
                    n g2 = com.ss.android.downloadlib.addownload.j.g();
                    if (g2 != null && g2.a() && !a(packageInfo.versionCode, i2, packageInfo.versionName, str2)) {
                        cVar.a(com.ss.android.downloadlib.addownload.b.c.f69417c);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return cVar;
        }
        return (com.ss.android.downloadlib.addownload.b.c) invokeLIL.objValue;
    }

    public static boolean a(int i2, int i3, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2})) == null) {
            if (i3 == 0 && TextUtils.isEmpty(str2)) {
                return true;
            }
            return (i3 > 0 && i2 >= i3) || a(str, str2) >= 0;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(DownloadModel downloadModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, downloadModel)) == null) {
            if (downloadModel == null) {
                return false;
            }
            return a(downloadModel.getPackageName(), downloadModel.getVersionCode(), downloadModel.getVersionName()).a();
        }
        return invokeL.booleanValue;
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65556, null, context, str, str2)) == null) {
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
        return invokeLLL.booleanValue;
    }

    public static boolean a(Signature[] signatureArr, Signature[] signatureArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, signatureArr, signatureArr2)) == null) {
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
        return invokeLL.booleanValue;
    }

    public static int a(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    public static String a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, str, i2)) == null) ? i2 == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i2) ? str : str.substring(0, i2) : (String) invokeLI.objValue;
    }

    public static int a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
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
        return invokeLL.intValue;
    }

    public static String a(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, strArr)) == null) ? com.ss.android.download.api.c.b.a(strArr) : (String) invokeL.objValue;
    }

    @NonNull
    public static <T> T a(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tArr)) == null) {
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
        return (T) invokeL.objValue;
    }

    public static long a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) {
            try {
                return a(Environment.getExternalStorageDirectory(), j);
            } catch (Exception e2) {
                e2.printStackTrace();
                return j;
            }
        }
        return invokeJ.longValue;
    }

    public static long a(File file, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(AdIconUtil.AD_TEXT_ID, null, file, j)) == null) {
            if (file == null) {
                return j;
            }
            try {
                return com.ss.android.socialbase.downloader.i.f.d(file.getAbsolutePath());
            } catch (Exception e2) {
                e2.printStackTrace();
                return j;
            }
        }
        return invokeLJ.longValue;
    }

    public static long a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
            if (file == null) {
                return -1L;
            }
            try {
                StatFs statFs = new StatFs(file.getAbsolutePath());
                if (Build.VERSION.SDK_INT >= 18) {
                    return statFs.getTotalBytes();
                }
                return -1L;
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? Looper.myLooper() == Looper.getMainLooper() : invokeV.booleanValue;
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65552, null, jSONObject, str, obj) == null) || jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.putOpt(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
