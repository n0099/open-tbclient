package d.p.a.e.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
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
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.util.io.ActionJsonData;
import com.kwai.video.player.KsMediaMeta;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.p.a.e.a.h.a;
import d.p.a.e.b.f.u;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f67960a;

    /* renamed from: b  reason: collision with root package name */
    public static NotificationChannel f67961b;

    /* loaded from: classes6.dex */
    public static class a implements k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f67962a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f67963b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f67964c;

        public a(Context context, int i, boolean z) {
            this.f67962a = context;
            this.f67963b = i;
            this.f67964c = z;
        }

        @Override // d.p.a.e.a.d.k
        public void a() {
            int unused = d.f67960a = d.P(this.f67962a, this.f67963b, this.f67964c);
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f67965e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f67966f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f67967g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f67968h;
        public final /* synthetic */ File i;

        public b(Context context, int i, boolean z, DownloadInfo downloadInfo, File file) {
            this.f67965e = context;
            this.f67966f = i;
            this.f67967g = z;
            this.f67968h = downloadInfo;
            this.i = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.I(this.f67968h, this.f67967g, d.e(this.f67965e, this.f67966f, this.f67967g, this.f67968h, this.i));
        }
    }

    /* loaded from: classes6.dex */
    public class c implements e {
        @Override // d.p.a.e.a.d.e
        public n a(Context context) {
            return null;
        }

        @Override // d.p.a.e.a.d.e
        public boolean a() {
            return true;
        }

        public boolean b() {
            return false;
        }
    }

    /* renamed from: d.p.a.e.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public abstract class AbstractC1879d implements n {
        @Override // d.p.a.e.a.d.n
        public n a(boolean z) {
            return null;
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        n a(Context context);

        boolean a();
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a(int i, int i2, String str, String str2, String str3);

        void a(Context context, String str);

        void a(DownloadInfo downloadInfo);

        boolean a();

        boolean a(int i, boolean z);

        void b(int i, int i2, String str, int i3, long j);
    }

    /* loaded from: classes6.dex */
    public interface g {
        String a();

        void a(int i, String str, int i2, long j);

        void a(Context context, String str);

        void a(DownloadInfo downloadInfo);

        boolean a(boolean z);

        void b(int i, String str, String str2, String str3);
    }

    /* loaded from: classes6.dex */
    public interface h {
        Uri a(int i, String str, String str2);
    }

    /* loaded from: classes6.dex */
    public interface i {
        void a(DownloadInfo downloadInfo, boolean z);

        void a(List<DownloadInfo> list);
    }

    /* loaded from: classes6.dex */
    public interface j {
        void a(DownloadInfo downloadInfo, BaseException baseException, int i);
    }

    /* loaded from: classes6.dex */
    public interface k {
        void a();
    }

    /* loaded from: classes6.dex */
    public interface l {
        void a(DownloadInfo downloadInfo, k kVar);
    }

    /* loaded from: classes6.dex */
    public interface m {
        void a();

        boolean b();
    }

    /* loaded from: classes6.dex */
    public interface n {
        m a();

        n a(int i);

        n a(int i, DialogInterface.OnClickListener onClickListener);

        n a(String str);

        n a(boolean z);

        n b(int i, DialogInterface.OnClickListener onClickListener);

        n c(DialogInterface.OnCancelListener onCancelListener);
    }

    /* loaded from: classes6.dex */
    public interface o {
        NotificationCompat.Builder a(Context context, String str);
    }

    /* loaded from: classes6.dex */
    public interface p {
        void a();

        void b();
    }

    public static boolean A(DownloadInfo downloadInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(downloadInfo.v0()) || !str.equals(downloadInfo.v0())) {
            return !TextUtils.isEmpty(downloadInfo.q0()) && y(d.p.a.e.b.g.d.l(), downloadInfo, str);
        }
        return true;
    }

    public static boolean B(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new JSONObject(str).optBoolean("bind_app", false);
    }

    public static int D(Context context, int i2, boolean z) {
        DownloadInfo f2 = d.p.a.e.b.g.a.l(context).f(i2);
        if (f2 != null && "application/vnd.android.package-archive".equals(f2.m0()) && !TextUtils.isEmpty(f2.F0()) && !TextUtils.isEmpty(f2.q0())) {
            File file = new File(f2.F0(), f2.q0());
            if (file.exists()) {
                d.p.a.e.b.g.d.Q(new b(context, i2, z, f2, file));
                return 1;
            }
        }
        I(f2, z, 2);
        return 2;
    }

    public static int E(Context context, DownloadInfo downloadInfo) {
        if (context != null && downloadInfo != null && !TextUtils.isEmpty(downloadInfo.F0()) && !TextUtils.isEmpty(downloadInfo.q0())) {
            int t = downloadInfo.t();
            if (t > 0) {
                return t;
            }
            try {
                PackageInfo h2 = h(context, downloadInfo, downloadInfo.F0(), downloadInfo.q0());
                if (h2 != null) {
                    int i2 = h2.versionCode;
                    downloadInfo.e2(i2);
                    return i2;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static String F() {
        return d.p.a.e.b.l.e.E0();
    }

    public static String G(long j2) {
        long[] jArr = {1099511627776L, KsMediaMeta.AV_CH_STEREO_RIGHT, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j2 < 1) {
            return "0 " + strArr[4];
        }
        for (int i2 = 0; i2 < 5; i2++) {
            long j3 = jArr[i2];
            if (j2 >= j3) {
                return l(j2, j3, strArr[i2]);
            }
        }
        return null;
    }

    @TargetApi(26)
    public static String H(@NonNull Context context) {
        try {
            if (f67961b == null) {
                NotificationChannel notificationChannel = new NotificationChannel("111111", "channel_appdownloader", 3);
                f67961b = notificationChannel;
                notificationChannel.setSound(null, null);
                f67961b.setShowBadge(false);
                ((NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)).createNotificationChannel(f67961b);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "111111";
    }

    public static void I(DownloadInfo downloadInfo, boolean z, int i2) {
        if (downloadInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z ? 1 : 2);
            jSONObject.put("view_result", i2);
            jSONObject.put("real_package_name", downloadInfo.W());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        d.p.a.e.b.g.d.n().b(downloadInfo.c0(), "install_view_result", jSONObject);
    }

    public static boolean J(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        return x(context, downloadInfo, packageInfo, false);
    }

    public static boolean K(String str) {
        JSONObject jSONObject;
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

    public static List<String> M() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add("application/vnd.android.package-archive");
        arrayList.add("application/ttpatch");
        return arrayList;
    }

    public static boolean N(Context context, DownloadInfo downloadInfo) {
        if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.F0()) || TextUtils.isEmpty(downloadInfo.q0())) {
            return false;
        }
        return J(context, downloadInfo, h(context, downloadInfo, downloadInfo.F0(), downloadInfo.q0()));
    }

    public static boolean O(String str) {
        return !TextUtils.isEmpty(str) && str.equals("application/vnd.android.package-archive");
    }

    public static int P(Context context, int i2, boolean z) {
        if (d.p.a.e.b.j.a.d(i2).m("notification_opt_2") == 1) {
            d.p.a.e.b.p.b.a().m(i2);
        }
        q(d.p.a.e.a.k.d().i());
        if (d.p.a.e.b.j.a.d(i2).b("install_queue_enable", 0) == 1) {
            return d.p.a.e.a.k.d().a(context, i2, z);
        }
        return D(context, i2, z);
    }

    public static JSONObject Q(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int a() {
        return d.p.a.e.a.e.F().B() ? 16384 : 0;
    }

    public static int b(int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (i2 == -2) {
            return 2;
        }
        if (i2 == 1) {
            return 4;
        }
        if (d.p.a.e.b.d.a.b(i2) || i2 == 11) {
            return 1;
        }
        return d.p.a.e.b.d.a.a(i2) ? 3 : 0;
    }

    public static int c(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int d(Context context, int i2, boolean z) {
        l C = d.p.a.e.a.e.F().C();
        if (C == null) {
            return P(context, i2, z);
        }
        DownloadInfo f2 = d.p.a.e.b.g.a.l(context).f(i2);
        f67960a = 1;
        C.a(f2, new a(context, i2, z));
        return f67960a;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        if (r0 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int e(Context context, int i2, boolean z, DownloadInfo downloadInfo, File file) {
        PackageInfo packageInfo;
        Intent g2;
        Process process;
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
            packageInfo = i(downloadInfo, file);
            if (packageInfo != null) {
                try {
                    downloadInfo.s2(packageInfo.packageName);
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            th = null;
        } catch (Throwable th4) {
            th = th4;
            packageInfo = null;
        }
        if (d.p.a.e.a.e.F().x() != null) {
            if (packageInfo == null) {
                BaseException baseException = new BaseException(2001, th);
                d.p.a.e.a.e.F().x().a(downloadInfo, baseException, baseException.getErrorCode());
            } else {
                d.p.a.e.a.e.F().x().a(downloadInfo, null, 11);
            }
        }
        if (w(context, downloadInfo, packageInfo)) {
            return 2;
        }
        if (packageInfo != null && d.p.a.e.b.j.a.d(downloadInfo.c0()).l("install_callback_error")) {
            downloadInfo.L0().put("extra_apk_package_name", packageInfo.packageName);
            downloadInfo.L0().put("extra_apk_version_code", Integer.valueOf(packageInfo.versionCode));
        }
        int[] iArr = new int[1];
        if (J(context, downloadInfo, packageInfo)) {
            g2 = context.getPackageManager().getLaunchIntentForPackage(packageInfo.packageName);
        } else if (!z && u(context, i2, file)) {
            downloadInfo.L0().put("extra_silent_install_succeed", Boolean.TRUE);
            return 1;
        } else {
            g2 = g(context, downloadInfo, file, z, iArr);
        }
        if (g2 == null) {
            return iArr[0] == 1 ? 2 : 0;
        }
        g2.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        if (downloadInfo.i0() > 0 && d.p.a.e.b.j.a.d(downloadInfo.c0()).b("app_install_return_result", 0) == 1) {
            g2.putExtra("android.intent.extra.RETURN_RESULT", true);
        }
        if (iArr[0] == 0 && d.p.a.e.a.c.r(context, downloadInfo, g2, z)) {
            return 1;
        }
        return f(context, g2);
    }

    public static int f(Context context, Intent intent) {
        try {
            if (d.p.a.e.a.e.F().J() != null) {
                if (d.p.a.e.a.e.F().J().a(intent)) {
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

    public static Intent g(Context context, DownloadInfo downloadInfo, @NonNull File file, boolean z, int[] iArr) {
        Uri j2 = j(downloadInfo.c0(), d.p.a.e.b.g.a.l(context).e(downloadInfo.c0()), context, d.p.a.e.a.e.F().z(), file);
        if (j2 == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(j2, "application/vnd.android.package-archive");
        f t = d.p.a.e.a.e.F().t();
        boolean a2 = t != null ? t.a(downloadInfo.c0(), z) : 0;
        d.p.a.e.b.f.d i2 = d.p.a.e.b.g.a.l(context).i(downloadInfo.c0());
        int i3 = a2;
        if (i2 != null) {
            i3 = i2.a(z);
        }
        iArr[0] = i3;
        if (i3 != 0) {
            return null;
        }
        return intent;
    }

    public static PackageInfo h(Context context, DownloadInfo downloadInfo, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            Log.e("AppDownloadUtils", "isApkInstalled apkFileSize：fileName:" + file.getPath() + " apkFileSize" + file.length());
            return i(downloadInfo, file);
        }
        return null;
    }

    public static PackageInfo i(DownloadInfo downloadInfo, File file) {
        if (downloadInfo == null) {
            return a.e.a(d.p.a.e.b.g.d.l(), file, a());
        }
        PackageInfo u0 = downloadInfo.u0();
        if (u0 == null) {
            PackageInfo a2 = a.e.a(d.p.a.e.b.g.d.l(), file, a());
            downloadInfo.R2(a2);
            return a2;
        }
        return u0;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Uri j(int i2, u uVar, Context context, String str, File file) {
        Uri uri;
        if (uVar != null) {
            uri = uVar.a(str, file.getAbsolutePath());
        } else {
            h A = d.p.a.e.a.e.F().A();
            if (A != null) {
                uri = A.a(i2, str, file.getAbsolutePath());
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

    public static String k(long j2) {
        return n(j2, true);
    }

    public static String l(long j2, long j3, String str) {
        double d2 = j2;
        if (j3 > 1) {
            d2 /= j3;
        }
        if ("MB".equals(str)) {
            return new DecimalFormat("#").format(d2) + str;
        }
        return new DecimalFormat("#.##").format(d2) + str;
    }

    public static String m(long j2, long j3, String str, boolean z) {
        double d2 = j2;
        if (j3 > 1) {
            d2 /= j3;
        }
        if (!z && !"GB".equals(str) && !"TB".equals(str)) {
            return new DecimalFormat("#").format(d2) + " " + str;
        }
        return new DecimalFormat("#.##").format(d2) + " " + str;
    }

    public static String n(long j2, boolean z) {
        long[] jArr = {1099511627776L, KsMediaMeta.AV_CH_STEREO_RIGHT, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j2 < 1) {
            return "0 " + strArr[4];
        }
        for (int i2 = 0; i2 < 5; i2++) {
            long j3 = jArr[i2];
            if (j2 >= j3) {
                return m(j2, j3, strArr[i2], z);
            }
        }
        return null;
    }

    public static String o(String str, d.p.a.e.b.j.a aVar) {
        JSONObject u;
        String format;
        if (aVar == null || (u = aVar.u("download_dir")) == null) {
            return "";
        }
        String optString = u.optString("dir_name");
        if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
            optString = optString.substring(1);
        }
        if (TextUtils.isEmpty(optString)) {
            return optString;
        }
        if (!optString.contains("%s")) {
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

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
        if (android.text.TextUtils.isEmpty(r2) == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String p(String str, String str2, String str3, boolean z) {
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
            if (!O(str3) && !str2.endsWith(".apk")) {
                return str2 + ".apk";
            }
        }
        String lastPathSegment = parse.getLastPathSegment();
        if (!TextUtils.isEmpty(lastPathSegment)) {
            str2 = lastPathSegment;
        }
        return !O(str3) ? str2 : str2;
    }

    public static void q(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                activity.finish();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void s(DownloadInfo downloadInfo, boolean z, boolean z2) {
        d.p.a.e.a.i iVar = new d.p.a.e.a.i(d.p.a.e.b.g.d.l(), downloadInfo.T0());
        iVar.J(downloadInfo.P0());
        iVar.U(downloadInfo.q0());
        iVar.Y(downloadInfo.F0());
        iVar.M(downloadInfo.Q1());
        iVar.W(downloadInfo.c1());
        iVar.Z(downloadInfo.K1() || z2);
        iVar.c0(downloadInfo.R());
        iVar.g0(downloadInfo.m0());
        iVar.K(downloadInfo.S());
        iVar.h0(true);
        iVar.T(downloadInfo.B0());
        iVar.X(downloadInfo.v());
        iVar.V(downloadInfo.w());
        iVar.b0(downloadInfo.o0());
        iVar.f0(downloadInfo.k0());
        iVar.l0(z);
        iVar.d0(downloadInfo.B1());
        iVar.k0(downloadInfo.v0());
        iVar.n0(downloadInfo.l0());
        iVar.B(downloadInfo.Q());
        iVar.u0(downloadInfo.A1());
        iVar.x0(downloadInfo.G1());
        iVar.B0(downloadInfo.C1());
        iVar.C(downloadInfo.N());
        iVar.F0(downloadInfo.v1());
        iVar.D0(downloadInfo.w1());
        iVar.o0(downloadInfo.E1());
        iVar.q0(downloadInfo.D0());
        iVar.L(Q(downloadInfo.K()));
        iVar.w0(downloadInfo.b0());
        iVar.j0(downloadInfo.P());
        d.p.a.e.a.e.F().a(iVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
        if (r0 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        r0.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
        if (r0 != null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean t(Context context) {
        if (Build.VERSION.SDK_INT > 20 && context != null) {
            TypedArray typedArray = null;
            try {
                int color = context.getResources().getColor(d.p.a.e.a.g.b());
                typedArray = context.obtainStyledAttributes(d.p.a.e.a.g.e(), new int[]{d.p.a.e.a.g.c(), d.p.a.e.a.g.d()});
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

    public static boolean u(Context context, int i2, File file) {
        if (d.p.a.e.b.j.a.d(i2).b("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((d.p.a.e.a.h.c.m() || d.p.a.e.a.h.c.n()) && d.p.a.e.b.l.g.a(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
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

    public static boolean v(Context context, DownloadInfo downloadInfo) {
        return z(context, downloadInfo, true);
    }

    public static boolean w(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName.equals(downloadInfo.v0())) {
            return false;
        }
        f t = d.p.a.e.a.e.F().t();
        if (t != null) {
            t.a(downloadInfo.c0(), 8, downloadInfo.v0(), packageInfo.packageName, "");
            if (t.a()) {
                return true;
            }
        }
        d.p.a.e.b.f.d i2 = d.p.a.e.b.g.a.l(context).i(downloadInfo.c0());
        if (i2 != null) {
            i2.a(8, downloadInfo, packageInfo.packageName, "");
            e b2 = d.p.a.e.a.e.F().b();
            return (b2 instanceof c) && ((c) b2).b();
        }
        return false;
    }

    public static boolean x(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        int i2 = packageInfo.versionCode;
        if (downloadInfo != null) {
            downloadInfo.e2(i2);
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
        return z ? i2 < i3 : (downloadInfo == null || d.p.a.e.b.j.a.d(downloadInfo.c0()).b("install_with_same_version_code", 0) != 1) ? i2 <= i3 : i2 < i3;
    }

    public static boolean y(Context context, DownloadInfo downloadInfo, String str) {
        if (context == null) {
            return false;
        }
        try {
            File file = new File(downloadInfo.F0(), downloadInfo.q0());
            PackageInfo packageInfo = null;
            if (file.exists()) {
                Log.e("AppDownloadUtils", "isPackageNameEqualsWithApk fileName:" + downloadInfo.q0() + " apkFileSize：" + file.length() + " fileUrl：" + downloadInfo.T0());
                PackageInfo i2 = i(downloadInfo, file);
                if (i2 == null || !i2.packageName.equals(str)) {
                    return false;
                }
                int i3 = i2.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, a());
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo == null || i3 != packageInfo.versionCode) {
                    return false;
                }
            } else if (!d.p.a.e.b.j.a.d(downloadInfo.c0()).l("install_callback_error")) {
                return false;
            } else {
                String h2 = d.p.a.e.b.l.e.h(downloadInfo.L0().get("extra_apk_package_name"), null);
                int c2 = d.p.a.e.b.l.e.c(downloadInfo.L0().get("extra_apk_version_code"), 0);
                if (h2 == null || TextUtils.isEmpty(h2) || !h2.equals(str)) {
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, a());
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                if (packageInfo == null || c2 != packageInfo.versionCode) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean z(Context context, DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return false;
        }
        String v0 = downloadInfo.v0();
        int t = downloadInfo.t();
        if (t <= 0 && z) {
            return N(context, downloadInfo);
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(v0, a());
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (packageInfo == null) {
            return false;
        }
        return d.p.a.e.b.j.a.d(downloadInfo.c0()).b("install_with_same_version_code", 0) == 1 ? t < packageInfo.versionCode : t <= packageInfo.versionCode;
    }
}
