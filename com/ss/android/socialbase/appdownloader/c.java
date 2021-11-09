package com.ss.android.socialbase.appdownloader;

import android.annotation.TargetApi;
import android.app.Activity;
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
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.text.FormattableUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f68923a;

    /* renamed from: b  reason: collision with root package name */
    public static NotificationChannel f68924b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1522867405, "Lcom/ss/android/socialbase/appdownloader/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1522867405, "Lcom/ss/android/socialbase/appdownloader/c;");
        }
    }

    public static int d(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65578, null, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (com.ss.android.socialbase.downloader.g.a.a(i2).b("notification_opt_2") == 1) {
                com.ss.android.socialbase.downloader.notification.b.a().f(i2);
            }
            a((Activity) h.a().b());
            if (com.ss.android.socialbase.downloader.g.a.a(i2).a("install_queue_enable", 0) == 1) {
                return h.a().a(context, i2, z);
            }
            return b(context, i2, z);
        }
        return invokeCommon.intValue;
    }

    public static String a(long j, long j2, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, Boolean.valueOf(z)})) == null) {
            double d2 = j;
            if (j2 > 1) {
                d2 /= j2;
            }
            if (!z && !"GB".equals(str) && !"TB".equals(str)) {
                return new DecimalFormat("#").format(d2) + " " + str;
            }
            return new DecimalFormat("#.##").format(d2) + " " + str;
        }
        return (String) invokeCommon.objValue;
    }

    public static String b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65569, null, j)) == null) {
            long[] jArr = {1099511627776L, 1073741824, 1048576, 1024, 1};
            String[] strArr = {"TB", "GB", "MB", "KB", "B"};
            if (j < 1) {
                return "0 " + strArr[4];
            }
            for (int i2 = 0; i2 < 5; i2++) {
                long j2 = jArr[i2];
                if (j >= j2) {
                    return a(j, j2, strArr[i2]);
                }
            }
            return null;
        }
        return (String) invokeJ.objValue;
    }

    public static boolean c(Context context, DownloadInfo downloadInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65576, null, context, downloadInfo)) == null) {
            if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
                return false;
            }
            return b(context, downloadInfo, a(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName()));
        }
        return invokeLL.booleanValue;
    }

    public static String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65547, null, j)) == null) ? a(j, true) : (String) invokeJ.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65577, null, str)) == null) ? !TextUtils.isEmpty(str) && str.equals("application/vnd.android.package-archive") : invokeL.booleanValue;
    }

    public static String a(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            long[] jArr = {1099511627776L, 1073741824, 1048576, 1024, 1};
            String[] strArr = {"TB", "GB", "MB", "KB", "B"};
            if (j < 1) {
                return "0 " + strArr[4];
            }
            for (int i2 = 0; i2 < 5; i2++) {
                long j2 = jArr[i2];
                if (j >= j2) {
                    return a(j, j2, strArr[i2], z);
                }
            }
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    public static List<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add("application/vnd.android.package-archive");
            arrayList.add("application/ttpatch");
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static int b(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65566, null, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2);
            if (downloadInfo != null && "application/vnd.android.package-archive".equals(downloadInfo.getMimeType()) && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.exists()) {
                    com.ss.android.socialbase.downloader.downloader.c.a(new Runnable(context, i2, z, downloadInfo, file) { // from class: com.ss.android.socialbase.appdownloader.c.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Context f68928a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ int f68929b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ boolean f68930c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ DownloadInfo f68931d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ File f68932e;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {context, Integer.valueOf(i2), Boolean.valueOf(z), downloadInfo, file};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f68928a = context;
                            this.f68929b = i2;
                            this.f68930c = z;
                            this.f68931d = downloadInfo;
                            this.f68932e = file;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                int a2 = c.a(this.f68928a, this.f68929b, this.f68930c, this.f68931d, this.f68932e);
                                if (a2 == 1 && d.j().o() != null) {
                                    d.j().o().a(this.f68931d, null);
                                }
                                c.b(this.f68931d, this.f68930c, a2);
                            }
                        }
                    });
                    return 1;
                }
            }
            b(downloadInfo, z, 2);
            return 2;
        }
        return invokeCommon.intValue;
    }

    public static JSONObject d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new JSONObject(str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static String a(long j, long j2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), str})) == null) {
            double d2 = j;
            if (j2 > 1) {
                d2 /= j2;
            }
            if ("MB".equals(str)) {
                return new DecimalFormat("#").format(d2) + str;
            }
            return new DecimalFormat("#.##").format(d2) + str;
        }
        return (String) invokeCommon.objValue;
    }

    public static void b(DownloadInfo downloadInfo, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65571, null, new Object[]{downloadInfo, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || downloadInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z ? 1 : 2);
            jSONObject.put("view_result", i2);
            jSONObject.put("real_package_name", downloadInfo.getFilePackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.c.P().a(downloadInfo.getId(), "install_view_result", jSONObject);
    }

    public static int a(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            j g2 = d.j().g();
            if (g2 == null) {
                return d(context, i2, z);
            }
            DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2);
            f68923a = 1;
            g2.a(downloadInfo, new com.ss.android.socialbase.appdownloader.c.i(context, i2, z) { // from class: com.ss.android.socialbase.appdownloader.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f68925a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f68926b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f68927c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, Integer.valueOf(i2), Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68925a = context;
                    this.f68926b = i2;
                    this.f68927c = z;
                }

                @Override // com.ss.android.socialbase.appdownloader.c.i
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int unused = c.f68923a = c.d(this.f68925a, this.f68926b, this.f68927c);
                    }
                }
            });
            return f68923a;
        }
        return invokeCommon.intValue;
    }

    public static boolean b(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65572, null, context, downloadInfo, packageInfo)) == null) ? a(context, downloadInfo, packageInfo, false) : invokeLLL.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
        if (r0 == null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Context context, int i2, boolean z, DownloadInfo downloadInfo, File file) {
        InterceptResult invokeCommon;
        PackageInfo packageInfo;
        Intent a2;
        Process process;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z), downloadInfo, file})) == null) {
            if (file.getPath().startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                try {
                    process = Runtime.getRuntime().exec("chmod 555 " + file.getAbsolutePath());
                    try {
                        process.waitFor();
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.printStackTrace();
                        } finally {
                            if (process != null) {
                                process.destroy();
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    process = null;
                }
            }
            try {
                packageInfo = a(downloadInfo, file);
                if (packageInfo != null) {
                    try {
                        downloadInfo.setFilePackageName(packageInfo.packageName);
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                th = null;
            } catch (Throwable th4) {
                th = th4;
                packageInfo = null;
            }
            if (d.j().c() != null) {
                if (packageInfo == null) {
                    BaseException baseException = new BaseException(2001, th);
                    d.j().c().a(downloadInfo, baseException, baseException.getErrorCode());
                } else {
                    d.j().c().a(downloadInfo, null, 11);
                }
            }
            if (a(context, downloadInfo, packageInfo)) {
                return 2;
            }
            if (packageInfo != null && com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("install_callback_error")) {
                downloadInfo.getTempCacheData().put("extra_apk_package_name", packageInfo.packageName);
                downloadInfo.getTempCacheData().put("extra_apk_version_code", Integer.valueOf(packageInfo.versionCode));
            }
            int[] iArr = new int[1];
            if (b(context, downloadInfo, packageInfo)) {
                a2 = context.getPackageManager().getLaunchIntentForPackage(packageInfo.packageName);
            } else if (!z && a(context, i2, file)) {
                downloadInfo.getTempCacheData().put("extra_silent_install_succeed", Boolean.TRUE);
                return 1;
            } else {
                a2 = a(context, downloadInfo, file, z, iArr);
            }
            if (a2 == null) {
                return iArr[0] == 1 ? 2 : 0;
            }
            a2.addFlags(268435456);
            if (downloadInfo.getLinkMode() > 0 && com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("app_install_return_result", 0) == 1) {
                a2.putExtra("android.intent.extra.RETURN_RESULT", true);
            }
            if (iArr[0] == 0 && b.a(context, downloadInfo, a2, z)) {
                return 1;
            }
            return a(context, a2);
        }
        return invokeCommon.intValue;
    }

    public static int b(Context context, DownloadInfo downloadInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65567, null, context, downloadInfo)) == null) {
            if (context != null && downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
                int appVersionCode = downloadInfo.getAppVersionCode();
                if (appVersionCode > 0) {
                    return appVersionCode;
                }
                try {
                    PackageInfo a2 = a(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
                    if (a2 != null) {
                        int i2 = a2.versionCode;
                        downloadInfo.setAppVersionCode(i2);
                        return i2;
                    }
                } catch (Throwable unused) {
                }
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) ? com.ss.android.socialbase.downloader.i.f.e() : (String) invokeV.objValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (!jSONObject.optBoolean("bind_app", false)) {
                if (jSONObject.optBoolean("auto_install_with_notification", true)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @TargetApi(26)
    public static String b(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            try {
                if (f68924b == null) {
                    NotificationChannel notificationChannel = new NotificationChannel("111111", "channel_appdownloader", 3);
                    f68924b = notificationChannel;
                    notificationChannel.setSound(null, null);
                    f68924b.setShowBadge(false);
                    ((NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)).createNotificationChannel(f68924b);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return "111111";
        }
        return (String) invokeL.objValue;
    }

    public static int a(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, intent)) == null) {
            try {
                if (d.j().n() != null) {
                    if (d.j().n().a(intent)) {
                        return 1;
                    }
                }
            } catch (Throwable unused) {
            }
            try {
                context.startActivity(intent);
                return 1;
            } catch (Throwable unused2) {
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65559, null, context, downloadInfo, packageInfo)) == null) {
            if (packageInfo == null || packageInfo.packageName.equals(downloadInfo.getPackageName())) {
                return false;
            }
            com.ss.android.socialbase.appdownloader.c.d b2 = d.j().b();
            if (b2 != null) {
                b2.a(downloadInfo.getId(), 8, downloadInfo.getPackageName(), packageInfo.packageName, "");
                if (b2.a()) {
                    return true;
                }
            }
            z downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
            if (downloadNotificationEventListener != null) {
                downloadNotificationEventListener.a(8, downloadInfo, packageInfo.packageName, "");
                com.ss.android.socialbase.appdownloader.c.c a2 = d.j().a();
                return (a2 instanceof com.ss.android.socialbase.appdownloader.c.a) && ((com.ss.android.socialbase.appdownloader.c.a) a2).c();
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean a(Context context, int i2, File file) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65557, null, context, i2, file)) == null) {
            if (com.ss.android.socialbase.downloader.g.a.a(i2).a("back_miui_silent_install", 1) == 1) {
                return false;
            }
            if ((com.ss.android.socialbase.appdownloader.f.d.l() || com.ss.android.socialbase.appdownloader.f.d.m()) && com.ss.android.socialbase.downloader.i.j.a(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"));
                Bundle bundle = new Bundle();
                bundle.putInt("userId", 0);
                bundle.putInt("flag", 256);
                bundle.putString("apkPath", file.getPath());
                bundle.putString("installerPkg", "com.miui.securitycore");
                intent.putExtras(bundle);
                try {
                    context.startService(intent);
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? d.j().f() ? 16384 : 0 : invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Uri a(int i2, IDownloadFileUriProvider iDownloadFileUriProvider, Context context, String str, File file) {
        Uri uri;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Integer.valueOf(i2), iDownloadFileUriProvider, context, str, file})) == null) {
            if (iDownloadFileUriProvider != null) {
                uri = iDownloadFileUriProvider.getUriForFile(str, file.getAbsolutePath());
            } else {
                com.ss.android.socialbase.appdownloader.c.f e2 = d.j().e();
                if (e2 != null) {
                    uri = e2.a(i2, str, file.getAbsolutePath());
                }
                uri = null;
                if (uri == null) {
                    try {
                        if (Build.VERSION.SDK_INT >= 24 && !TextUtils.isEmpty(str)) {
                            uri = FileProvider.getUriForFile(context, str, file);
                        } else {
                            uri = Uri.fromFile(file);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                return uri;
            }
            if (uri == null) {
            }
            return uri;
        }
        return (Uri) invokeCommon.objValue;
    }

    public static Intent a(Context context, DownloadInfo downloadInfo, @NonNull File file, boolean z, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{context, downloadInfo, file, Boolean.valueOf(z), iArr})) == null) {
            Uri a2 = a(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, d.j().d(), file);
            if (a2 == null) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            if (Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(1);
            }
            intent.setDataAndType(a2, "application/vnd.android.package-archive");
            com.ss.android.socialbase.appdownloader.c.d b2 = d.j().b();
            boolean a3 = b2 != null ? b2.a(downloadInfo.getId(), z) : 0;
            z downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
            int i2 = a3;
            if (downloadNotificationEventListener != null) {
                i2 = downloadNotificationEventListener.a(z);
            }
            iArr[0] = i2;
            if (i2 != 0) {
                return null;
            }
            return intent;
        }
        return (Intent) invokeCommon.objValue;
    }

    public static boolean a(DownloadInfo downloadInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, downloadInfo, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (TextUtils.isEmpty(downloadInfo.getPackageName()) || !str.equals(downloadInfo.getPackageName())) {
                return !TextUtils.isEmpty(downloadInfo.getName()) && a(com.ss.android.socialbase.downloader.downloader.c.N(), downloadInfo, str);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65561, null, context, downloadInfo, str)) == null) {
            if (context == null) {
                return false;
            }
            try {
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                PackageInfo packageInfo = null;
                if (file.exists()) {
                    String str2 = "isPackageNameEqualsWithApk fileName:" + downloadInfo.getName() + " apkFileSize：" + file.length() + " fileUrl：" + downloadInfo.getUrl();
                    PackageInfo a2 = a(downloadInfo, file);
                    if (a2 == null || !a2.packageName.equals(str)) {
                        return false;
                    }
                    int i2 = a2.versionCode;
                    try {
                        packageInfo = context.getPackageManager().getPackageInfo(str, a());
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                    if (packageInfo == null || i2 != packageInfo.versionCode) {
                        return false;
                    }
                } else if (!com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("install_callback_error")) {
                    return false;
                } else {
                    String a3 = com.ss.android.socialbase.downloader.i.f.a(downloadInfo.getTempCacheData().get("extra_apk_package_name"), (String) null);
                    int a4 = com.ss.android.socialbase.downloader.i.f.a(downloadInfo.getTempCacheData().get("extra_apk_version_code"), 0);
                    if (a3 == null || TextUtils.isEmpty(a3) || !a3.equals(str)) {
                        return false;
                    }
                    try {
                        packageInfo = context.getPackageManager().getPackageInfo(str, a());
                    } catch (PackageManager.NameNotFoundException unused2) {
                    }
                    if (packageInfo == null || a4 != packageInfo.versionCode) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, boolean z) {
        InterceptResult invokeCommon;
        PackageInfo packageInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, null, new Object[]{context, downloadInfo, packageInfo, Boolean.valueOf(z)})) == null) {
            if (packageInfo == null) {
                return false;
            }
            String str = packageInfo.packageName;
            int i2 = packageInfo.versionCode;
            if (downloadInfo != null) {
                downloadInfo.setAppVersionCode(i2);
            }
            try {
                packageInfo2 = context.getPackageManager().getPackageInfo(str, a());
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo2 = null;
            }
            if (packageInfo2 == null) {
                return false;
            }
            int i3 = packageInfo2.versionCode;
            return z ? i2 < i3 : (downloadInfo == null || com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("install_with_same_version_code", 0) != 1) ? i2 <= i3 : i2 < i3;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(Context context, DownloadInfo downloadInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, context, downloadInfo)) == null) ? a(context, downloadInfo, true) : invokeLL.booleanValue;
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65562, null, context, downloadInfo, z)) == null) {
            if (downloadInfo == null) {
                return false;
            }
            String packageName = downloadInfo.getPackageName();
            int appVersionCode = downloadInfo.getAppVersionCode();
            if (appVersionCode <= 0 && z) {
                return c(context, downloadInfo);
            }
            PackageInfo packageInfo = null;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(packageName, a());
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (packageInfo == null) {
                return false;
            }
            return com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("install_with_same_version_code", 0) == 1 ? appVersionCode < packageInfo.versionCode : appVersionCode <= packageInfo.versionCode;
        }
        return invokeLLZ.booleanValue;
    }

    public static PackageInfo a(Context context, DownloadInfo downloadInfo, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65544, null, context, downloadInfo, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            File file = new File(str, str2);
            if (file.exists()) {
                String str3 = "isApkInstalled apkFileSize：fileName:" + file.getPath() + " apkFileSize" + file.length();
                return a(downloadInfo, file);
            }
            return null;
        }
        return (PackageInfo) invokeLLLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
        if (android.text.TextUtils.isEmpty(r5) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{str, str2, str3, Boolean.valueOf(z)})) != null) {
            return (String) invokeCommon.objValue;
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri parse = Uri.parse(str);
        if (z) {
            if (TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(parse.getLastPathSegment())) {
                    str2 = parse.getLastPathSegment();
                }
                str2 = "default.apk";
            }
            if (!c(str3) && !str2.endsWith(".apk")) {
                return str2 + ".apk";
            }
        }
        String lastPathSegment = parse.getLastPathSegment();
        if (!TextUtils.isEmpty(lastPathSegment)) {
            str2 = lastPathSegment;
        }
        return !c(str3) ? str2 : str2;
    }

    public static String a(String str, com.ss.android.socialbase.downloader.g.a aVar) {
        InterceptResult invokeLL;
        JSONObject d2;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, aVar)) == null) {
            if (aVar == null || (d2 = aVar.d("download_dir")) == null) {
                return "";
            }
            String optString = d2.optString("dir_name");
            if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
                optString = optString.substring(1);
            }
            if (TextUtils.isEmpty(optString)) {
                return optString;
            }
            if (!optString.contains(FormattableUtils.SIMPLEST_FORMAT)) {
                format = optString + str;
            } else {
                try {
                    format = String.format(optString, str);
                } catch (Throwable unused) {
                }
            }
            optString = format;
            return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return new JSONObject(str).optBoolean("bind_app", false);
        }
        return invokeL.booleanValue;
    }

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 == 0) {
                return 0;
            }
            if (i2 == -2) {
                return 2;
            }
            if (i2 == 1) {
                return 4;
            }
            if (DownloadStatus.isDownloading(i2) || i2 == 11) {
                return 1;
            }
            return DownloadStatus.isDownloadOver(i2) ? 3 : 0;
        }
        return invokeI.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
        if (r0 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
        r0.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
        if (r0 != null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            if (Build.VERSION.SDK_INT > 20 && context != null) {
                TypedArray typedArray = null;
                try {
                    int color = context.getResources().getColor(e.b());
                    typedArray = context.obtainStyledAttributes(e.e(), new int[]{e.c(), e.d()});
                    if (color == typedArray.getColor(0, 0)) {
                        if (typedArray != null) {
                            try {
                                typedArray.recycle();
                            } catch (Throwable unused) {
                            }
                        }
                        return true;
                    }
                } catch (Throwable unused2) {
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void a(DownloadInfo downloadInfo, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{downloadInfo, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            d.j().a(new f(com.ss.android.socialbase.downloader.downloader.c.N(), downloadInfo.getUrl()).a(downloadInfo.getTitle()).b(downloadInfo.getName()).c(downloadInfo.getSavePath()).a(downloadInfo.isShowNotification()).b(downloadInfo.isAutoInstallWithoutNotification()).c(downloadInfo.isOnlyWifi() || z2).d(downloadInfo.getExtra()).e(downloadInfo.getMimeType()).a(downloadInfo.getExtraHeaders()).e(true).b(downloadInfo.getRetryCount()).c(downloadInfo.getBackUpUrlRetryCount()).b(downloadInfo.getBackUpUrls()).d(downloadInfo.getMinProgressTimeMsInterval()).e(downloadInfo.getMaxProgressCount()).f(z).d(downloadInfo.isNeedHttpsToHttpRetry()).f(downloadInfo.getPackageName()).g(downloadInfo.getMd5()).a(downloadInfo.getExpectFileLength()).i(downloadInfo.isNeedDefaultHttpServiceBackUp()).j(downloadInfo.isNeedReuseFirstConnection()).l(downloadInfo.isNeedIndependentProcess()).a(downloadInfo.getEnqueueType()).n(downloadInfo.isForce()).m(downloadInfo.isHeadConnectionAvailable()).g(downloadInfo.isNeedRetryDelay()).h(downloadInfo.getRetryDelayTimeArray()).a(d(downloadInfo.getDownloadSettingString())).j(downloadInfo.getIconUrl()).f(downloadInfo.getExecutorGroup()).p(downloadInfo.isAutoInstall()));
        }
    }

    public static void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65553, null, activity) == null) || activity == null) {
            return;
        }
        try {
            if (activity.isFinishing()) {
                return;
            }
            activity.finish();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static PackageInfo a(DownloadInfo downloadInfo, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, downloadInfo, file)) == null) {
            if (downloadInfo == null) {
                return com.ss.android.socialbase.appdownloader.f.a.e.a(com.ss.android.socialbase.downloader.downloader.c.N(), file, a());
            }
            PackageInfo packageInfo = downloadInfo.getPackageInfo();
            if (packageInfo == null) {
                PackageInfo a2 = com.ss.android.socialbase.appdownloader.f.a.e.a(com.ss.android.socialbase.downloader.downloader.c.N(), file, a());
                downloadInfo.setPackageInfo(a2);
                return a2;
            }
            return packageInfo;
        }
        return (PackageInfo) invokeLL.objValue;
    }

    public static int a(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65539, null, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }
}
