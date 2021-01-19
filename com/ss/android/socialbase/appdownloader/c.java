package com.ss.android.socialbase.appdownloader;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.kwai.video.player.KsMediaMeta;
import com.ss.android.socialbase.downloader.d.ah;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private static NotificationChannel pTc = null;

    private static String e(long j, long j2, String str) {
        return new DecimalFormat("#.##").format(j2 > 1 ? j / j2 : j) + " " + str;
    }

    public static String a(long j) {
        long[] jArr = {1099511627776L, KsMediaMeta.AV_CH_STEREO_RIGHT, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[strArr.length - 1];
        }
        for (int i = 0; i < jArr.length; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return e(j, j2, strArr[i]);
            }
        }
        return null;
    }

    public static int f(Context context, int i, boolean z) {
        if (com.ss.android.socialbase.downloader.k.a.RA(i).a("install_queue_enable", 0) == 1) {
            return h.eDx().f(context, i, z);
        }
        return g(context, i, z);
    }

    public static int g(final Context context, final int i, final boolean z) {
        final com.ss.android.socialbase.downloader.g.c h = com.ss.android.socialbase.downloader.downloader.f.iy(context).h(i);
        if (h != null && "application/vnd.android.package-archive".equals(h.eEO()) && !TextUtils.isEmpty(h.k()) && !TextUtils.isEmpty(h.h())) {
            final File file = new File(h.k(), h.h());
            if (file.exists()) {
                com.ss.android.socialbase.downloader.downloader.b.a(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.a(h, z, c.a(context, i, z, h, file));
                    }
                });
                return 1;
            }
        }
        a(h, z, 2);
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.ss.android.socialbase.downloader.g.c cVar, boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z ? 1 : 2);
            jSONObject.put("view_result", i);
            jSONObject.put("real_package_name", cVar.E());
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.ss.android.socialbase.downloader.h.b eEf = com.ss.android.socialbase.downloader.downloader.b.eEf();
        if (eEf != null) {
            eEf.a(cVar, "install_view_result", jSONObject);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [164=4] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0079 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Context context, int i, boolean z, com.ss.android.socialbase.downloader.g.c cVar, File file) {
        Process process;
        PackageInfo packageInfo;
        Intent a2;
        if (file.getPath().startsWith(Environment.getDataDirectory().getAbsolutePath())) {
            try {
                process = Runtime.getRuntime().exec("chmod 555 " + file.getAbsolutePath());
            } catch (Throwable th) {
                th = th;
                process = null;
            }
            try {
                process.waitFor();
                if (process != null) {
                    process.destroy();
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    if (process != null) {
                        process.destroy();
                    }
                    context.getPackageManager();
                    packageInfo = com.ss.android.socialbase.appdownloader.f.a.e.a(context, file, a());
                    if (packageInfo != null) {
                    }
                    th = null;
                    if (d.eCW().eCT() != null) {
                    }
                    if (a(context, cVar, packageInfo)) {
                    }
                } catch (Throwable th3) {
                    Process process2 = process;
                    if (process2 != null) {
                        process2.destroy();
                    }
                    throw th3;
                }
            }
        }
        context.getPackageManager();
        try {
            packageInfo = com.ss.android.socialbase.appdownloader.f.a.e.a(context, file, a());
            if (packageInfo != null) {
                try {
                    cVar.b(packageInfo.packageName);
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            th = null;
        } catch (Throwable th5) {
            th = th5;
            packageInfo = null;
        }
        if (d.eCW().eCT() != null) {
            if (packageInfo == null) {
                com.ss.android.socialbase.downloader.e.a aVar = new com.ss.android.socialbase.downloader.e.a(2001, th);
                d.eCW().eCT().a(cVar, aVar, aVar.a());
            } else {
                d.eCW().eCT().a(cVar, null, 11);
            }
        }
        if (a(context, cVar, packageInfo)) {
            if (packageInfo != null && com.ss.android.socialbase.downloader.k.a.RA(cVar.g()).a("install_callback_error")) {
                cVar.eFG().putString("extra_apk_package_name", packageInfo.packageName);
                cVar.eFG().putInt("extra_apk_version_code", packageInfo.versionCode);
            }
            int[] iArr = new int[1];
            if (b(context, cVar, packageInfo)) {
                a2 = context.getPackageManager().getLaunchIntentForPackage(packageInfo.packageName);
            } else if (!z && a(context, i, file)) {
                cVar.eFG().putBoolean("extra_silent_install_succeed", true);
                return 1;
            } else {
                a2 = a(context, cVar, file, z, iArr);
            }
            if (a2 == null) {
                return iArr[0] == 1 ? 2 : 0;
            }
            a2.addFlags(268435456);
            if (iArr[0] == 0 && b.a(context, cVar, a2, z)) {
                return 1;
            }
            return k(context, a2);
        }
        return 2;
    }

    public static int k(Context context, Intent intent) {
        try {
            if (d.eCW().eDa() != null) {
                if (d.eCW().eDa().a(intent)) {
                    return 1;
                }
            }
        } catch (Throwable th) {
        }
        try {
            context.startActivity(intent);
            return 1;
        } catch (Throwable th2) {
            return 0;
        }
    }

    public static boolean a(Context context, com.ss.android.socialbase.downloader.g.c cVar, PackageInfo packageInfo) {
        if (packageInfo != null && !packageInfo.packageName.equals(cVar.D())) {
            com.ss.android.socialbase.appdownloader.c.d eCS = d.eCW().eCS();
            if (eCS != null) {
                eCS.a(cVar.g(), 8, cVar.D(), packageInfo.packageName, "");
                if (eCS.a()) {
                    return true;
                }
            }
            com.ss.android.socialbase.downloader.d.d QX = com.ss.android.socialbase.downloader.downloader.f.iy(context).QX(cVar.g());
            if (QX != null) {
                QX.a(8, cVar, packageInfo.packageName, "");
                com.ss.android.socialbase.appdownloader.c.c eCR = d.eCW().eCR();
                if ((eCR instanceof com.ss.android.socialbase.appdownloader.c.a) && ((com.ss.android.socialbase.appdownloader.c.a) eCR).c()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(Context context, int i, File file) {
        if (com.ss.android.socialbase.downloader.k.a.RA(i).a("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((com.ss.android.socialbase.downloader.m.g.j() || com.ss.android.socialbase.downloader.m.g.k()) && com.ss.android.socialbase.downloader.m.i.a(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"));
            Bundle bundle = new Bundle();
            bundle.putInt(TbEnum.SystemMessage.KEY_USER_ID, 0);
            bundle.putInt(FrsActivityConfig.FLAG, 256);
            bundle.putString("apkPath", file.getPath());
            bundle.putString("installerPkg", "com.miui.securitycore");
            intent.putExtras(bundle);
            try {
                context.startService(intent);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static int a() {
        return d.eCW().f() ? 16384 : 0;
    }

    public static Uri a(int i, ah ahVar, Context context, String str, File file) {
        Uri uri = null;
        if (ahVar != null) {
            try {
                uri = ahVar.a(str, file.getAbsolutePath());
            } catch (Throwable th) {
            }
        } else {
            com.ss.android.socialbase.appdownloader.c.f eCU = d.eCW().eCU();
            if (eCU != null) {
                try {
                    uri = eCU.r(i, str, file.getAbsolutePath());
                } catch (Throwable th2) {
                }
            }
        }
        if (uri == null) {
            try {
                if (Build.VERSION.SDK_INT >= 24 && !TextUtils.isEmpty(str)) {
                    uri = FileProvider.getUriForFile(context, str, file);
                } else {
                    uri = Uri.fromFile(file);
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
        return uri;
    }

    private static Intent a(Context context, com.ss.android.socialbase.downloader.g.c cVar, @NonNull File file, boolean z, int[] iArr) {
        Uri a2 = a(cVar.g(), com.ss.android.socialbase.downloader.downloader.f.iy(context).QY(cVar.g()), context, d.eCW().d(), file);
        if (a2 == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(a2, "application/vnd.android.package-archive");
        com.ss.android.socialbase.appdownloader.c.d eCS = d.eCW().eCS();
        boolean a3 = eCS != null ? eCS.a(cVar.g(), z) : false;
        com.ss.android.socialbase.downloader.d.d QX = com.ss.android.socialbase.downloader.downloader.f.iy(context).QX(cVar.g());
        boolean a4 = QX != null ? QX.a(z) : a3;
        iArr[0] = a4 ? 1 : 0;
        if (a4) {
            return null;
        }
        return intent;
    }

    public static boolean c(com.ss.android.socialbase.downloader.g.c cVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(cVar.D()) || !str.equals(cVar.D())) {
            return !TextUtils.isEmpty(cVar.h()) && a(com.ss.android.socialbase.downloader.downloader.b.eEd(), cVar, str);
        }
        return true;
    }

    public static boolean a(Context context, com.ss.android.socialbase.downloader.g.c cVar, String str) {
        PackageInfo packageInfo = null;
        if (context == null) {
            return false;
        }
        try {
            File file = new File(cVar.k(), cVar.h());
            if (file.exists()) {
                context.getPackageManager();
                Log.e("AppDownloadUtils", "isPackageNameEqualsWithApk fileName:" + cVar.h() + " apkFileSize：" + file.length() + " fileUrl：" + cVar.j());
                PackageInfo a2 = com.ss.android.socialbase.appdownloader.f.a.e.a(context, file, a());
                if (a2 == null || !a2.packageName.equals(str)) {
                    return false;
                }
                int i = a2.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, a());
                } catch (PackageManager.NameNotFoundException e) {
                }
                return packageInfo != null && i == packageInfo.versionCode;
            } else if (com.ss.android.socialbase.downloader.k.a.RA(cVar.g()).a("install_callback_error")) {
                String string = cVar.eFG().getString("extra_apk_package_name");
                int i2 = cVar.eFG().getInt("extra_apk_version_code");
                if (string == null || TextUtils.isEmpty(string) || !string.equals(str)) {
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, a());
                } catch (PackageManager.NameNotFoundException e2) {
                }
                return packageInfo != null && i2 == packageInfo.versionCode;
            } else {
                return false;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public static boolean b(Context context, com.ss.android.socialbase.downloader.g.c cVar, PackageInfo packageInfo) {
        return a(context, cVar, packageInfo, false);
    }

    public static boolean a(Context context, com.ss.android.socialbase.downloader.g.c cVar, PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        int i = packageInfo.versionCode;
        if (cVar != null) {
            cVar.g(i);
        }
        try {
            packageInfo2 = context.getPackageManager().getPackageInfo(str, a());
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo2 = null;
        }
        if (packageInfo2 == null) {
            return false;
        }
        int i2 = packageInfo2.versionCode;
        return z ? i < i2 : (cVar == null || com.ss.android.socialbase.downloader.k.a.RA(cVar.g()).a("install_with_same_version_code", 0) != 1) ? i <= i2 : i < i2;
    }

    public static boolean b(Context context, com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar == null) {
            return false;
        }
        String D = cVar.D();
        int eEU = cVar.eEU();
        if (eEU > 0) {
            PackageInfo packageInfo = null;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(D, a());
            } catch (PackageManager.NameNotFoundException e) {
            }
            return packageInfo != null && packageInfo.versionCode >= eEU;
        }
        return d(context, cVar);
    }

    public static int c(Context context, com.ss.android.socialbase.downloader.g.c cVar) {
        if (context == null || cVar == null || TextUtils.isEmpty(cVar.k()) || TextUtils.isEmpty(cVar.h())) {
            return 0;
        }
        int eEU = cVar.eEU();
        if (eEU <= 0) {
            try {
                PackageInfo a2 = a(context, cVar, cVar.k(), cVar.h());
                if (a2 != null) {
                    int i = a2.versionCode;
                    cVar.g(i);
                    return i;
                }
            } catch (Throwable th) {
            }
            return 0;
        }
        return eEU;
    }

    public static boolean d(Context context, com.ss.android.socialbase.downloader.g.c cVar) {
        if (context == null || cVar == null || TextUtils.isEmpty(cVar.k()) || TextUtils.isEmpty(cVar.h())) {
            return false;
        }
        return b(context, cVar, a(context, cVar, cVar.k(), cVar.h()));
    }

    public static PackageInfo a(Context context, com.ss.android.socialbase.downloader.g.c cVar, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            Log.e("AppDownloadUtils", "isApkInstalled apkFileSize：fileName:" + file.getPath() + " apkFileSize" + file.length());
            return com.ss.android.socialbase.appdownloader.f.a.e.a(context, file, a());
        }
        return null;
    }

    public static String a(String str, String str2, String str3, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri parse = Uri.parse(str);
        if (z) {
            if (TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(parse.getLastPathSegment())) {
                    str2 = parse.getLastPathSegment();
                } else {
                    str2 = "default.apk";
                }
            }
        } else {
            String lastPathSegment = parse.getLastPathSegment();
            if (!TextUtils.isEmpty(lastPathSegment)) {
                str2 = lastPathSegment;
            } else if (TextUtils.isEmpty(str2)) {
                str2 = "default.apk";
            }
        }
        if (d(str3) && !str2.endsWith(".apk")) {
            return str2 + ".apk";
        }
        return str2;
    }

    public static String b() {
        Context eEd = com.ss.android.socialbase.downloader.downloader.b.eEd();
        File h = d.eCW().h();
        if (h == null || !h.exists() || !h.isDirectory()) {
            h = c(eEd);
        }
        if (h == null) {
            throw new IllegalStateException("Failed to get storage directory");
        }
        if (h.exists()) {
            if (!h.isDirectory()) {
                throw new IllegalStateException(h.getAbsolutePath() + " already exists and is not a directory");
            }
        } else if (!h.mkdirs()) {
            throw new IllegalStateException("Unable to create directory: " + h.getAbsolutePath());
        }
        return h.getAbsolutePath();
    }

    public static String a(String str, com.ss.android.socialbase.downloader.k.a aVar) {
        JSONObject aau;
        if (aVar == null || (aau = aVar.aau("anti_hijack_dir")) == null) {
            return "";
        }
        String optString = aau.optString("dir_name");
        if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
            optString = optString.substring(1);
        }
        if (!TextUtils.isEmpty(optString)) {
            if (optString.contains("%s")) {
                try {
                    optString = String.format(optString, str);
                } catch (Throwable th) {
                }
            } else {
                optString = optString + str;
            }
            if (optString.length() > 255) {
                return optString.substring(optString.length() + UIMsg.m_AppUI.V_WM_ADDLISTUPDATE);
            }
            return optString;
        }
        return optString;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                return jSONObject.optBoolean("bind_app", false);
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                if (!jSONObject.optBoolean("bind_app", false)) {
                    if (jSONObject.optBoolean("auto_install_with_notification", true)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                return jSONObject.optBoolean("auto_install_without_notification", false);
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int a(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == -2) {
            return 2;
        }
        if (i == 1) {
            return 4;
        }
        if (com.ss.android.socialbase.downloader.b.f.b(i) || i == 11) {
            return 1;
        }
        return com.ss.android.socialbase.downloader.b.f.a(i) ? 3 : 0;
    }

    public static boolean d(String str) {
        return !TextUtils.isEmpty(str) && str.equals("application/vnd.android.package-archive");
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [788=4, 789=4] */
    public static boolean a(Context context) {
        TypedArray typedArray;
        int color;
        TypedArray obtainStyledAttributes;
        if (Build.VERSION.SDK_INT <= 20 || context == null) {
            return false;
        }
        try {
            color = context.getResources().getColor(e.b());
            obtainStyledAttributes = context.obtainStyledAttributes(e.e(), new int[]{e.c(), e.d()});
            try {
            } catch (Throwable th) {
                typedArray = obtainStyledAttributes;
                if (typedArray != null) {
                    try {
                        typedArray.recycle();
                    } catch (Throwable th2) {
                    }
                }
                return false;
            }
        } catch (Throwable th3) {
            typedArray = null;
        }
        if (color != obtainStyledAttributes.getColor(0, 0)) {
            if (obtainStyledAttributes != null) {
                try {
                    obtainStyledAttributes.recycle();
                } catch (Throwable th4) {
                }
            }
            return false;
        } else if (obtainStyledAttributes != null) {
            try {
                obtainStyledAttributes.recycle();
                return true;
            } catch (Throwable th5) {
                return true;
            }
        } else {
            return true;
        }
    }

    @TargetApi(26)
    public static String b(@NonNull Context context) {
        try {
            if (pTc == null) {
                pTc = new NotificationChannel("111111", "channel_appdownloader", 3);
                pTc.setSound(null, null);
                pTc.setShowBadge(false);
                ((NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)).createNotificationChannel(pTc);
                return "111111";
            }
            return "111111";
        } catch (Throwable th) {
            th.printStackTrace();
            return "111111";
        }
    }

    public static File c(Context context) {
        String str;
        Context applicationContext = context.getApplicationContext();
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError e) {
            str = "";
        } catch (NullPointerException e2) {
            str = "";
        }
        if ("mounted".equals(str)) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        }
        return applicationContext.getFilesDir();
    }

    public static List<String> c() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add("application/vnd.android.package-archive");
        arrayList.add("application/ttpatch");
        return arrayList;
    }
}
