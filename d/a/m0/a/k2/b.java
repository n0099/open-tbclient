package d.a.m0.a.k2;

import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.m0.a.a1.e;
import d.a.m0.a.a2.e;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.k;
import d.a.m0.t.f;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47006a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static String f47007b = "/aiapp";

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f47008c = new HashSet(Arrays.asList("extension_core", "js_native", "swan_core"));

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f47009a;

        static {
            int[] iArr = new int[PathType.values().length];
            f47009a = iArr;
            try {
                iArr[PathType.BD_FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47009a[PathType.RELATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static File A() {
        return new File(p(), "swan_plugin_workspace");
    }

    @NonNull
    public static File B() {
        return new File(d.a.m0.a.k2.h.c.A());
    }

    @Nullable
    public static String C(@NonNull String str) {
        e i2 = e.i();
        if (i2 == null) {
            return null;
        }
        String d2 = i2.j() != null ? i2.j().d() : "";
        if (!TextUtils.isEmpty(d2)) {
            String d3 = f.d(d2.getBytes(), false);
            if (D(str + f47007b + File.separator + d3)) {
                if (f47006a) {
                    Log.d("StorageUtil", "the filesystem base path is under UID ");
                }
                return d3;
            }
        }
        String i3 = d.a.m0.a.c1.a.a0().i(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(i3)) {
            i3 = i3.replace("|", "");
        }
        return f.d(i3.getBytes(), false);
    }

    public static boolean D(String str) {
        File[] listFiles;
        return (TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length <= 0) ? false : true;
    }

    public static boolean E(String str) {
        PathType s = s(str);
        return s == PathType.BD_FILE || s == PathType.RELATIVE;
    }

    public static boolean F(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("bdfile://tmp_");
    }

    public static boolean G(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("bdfile://usr/") || TextUtils.equals(str, d.a.m0.a.r0.a.USER_DATA_PATH));
    }

    public static String H(String str, @NonNull e eVar) {
        String M;
        int i2 = a.f47009a[s(str).ordinal()];
        if (i2 != 1) {
            M = i2 != 2 ? str : L(str, eVar, eVar.Z());
        } else {
            M = M(str, eVar.f44533f);
        }
        return M == null ? str : M;
    }

    @Nullable
    public static String I(String str, String str2) {
        String replace;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (f47006a) {
                Log.d("StorageUtil", "——> path2Scheme: path " + str + " swanAppId " + str2);
            }
            String v = v(str2);
            String x = x(str2);
            String z = z(str2);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(WebGLImageLoader.BDFILE);
            if (!TextUtils.isEmpty(x) && str.startsWith(x)) {
                replace = str.replace(x, "");
                stringBuffer.append("tmp_");
            } else if (!TextUtils.isEmpty(v) && str.startsWith(v)) {
                replace = str.replace(v, "");
                stringBuffer.append("store_");
            } else if (!TextUtils.isEmpty(z) && str.startsWith(z)) {
                String replace2 = str.replace(z + File.separator, "");
                return "bdfile://usr/" + replace2;
            }
            if (f47006a) {
                Log.d("StorageUtil", "——> path2Scheme: relative path " + replace);
            }
            if (TextUtils.isEmpty(replace)) {
                return null;
            }
            stringBuffer.append(new String(Base64.encode(replace.getBytes(), 10)));
            if (f47006a) {
                Log.d("StorageUtil", "——> path2Scheme: url " + ((Object) stringBuffer));
            }
            return stringBuffer.toString();
        }
        return null;
    }

    @Nullable
    public static String J(String str, String str2) {
        String I = I(str, str2);
        String p = d.a.m0.t.d.p(d.a.m0.t.d.q(str));
        if (I != null && !I.contains(".") && p != null) {
            I = I + "." + p;
        }
        if (f47006a) {
            Log.d("StorageUtil", "path2SchemeWithExt: url" + I);
        }
        return I;
    }

    @Nullable
    public static String K(String str) {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
        if (file.exists()) {
            String replace = str.replace("//", "/");
            if (replace.startsWith("/")) {
                return file.getAbsolutePath() + replace;
            }
            if (replace.startsWith("./")) {
                replace = replace.replace("./", "");
            }
            return file.getAbsolutePath() + File.separator + replace;
        }
        return null;
    }

    public static String L(String str, e eVar, String str2) {
        File i2;
        if (eVar != null && !d.a.m0.t.d.w(str)) {
            b.a N = eVar.N();
            boolean z = N != null && N.m0();
            if (f47006a && z) {
                Log.d("StorageUtil", "relative path : " + str);
                i2 = e.b.e();
            } else if (!TextUtils.isEmpty(eVar.f44533f) && !TextUtils.isEmpty(str2) && s(str) == PathType.RELATIVE) {
                i2 = e.C0620e.i(eVar.f44533f, str2);
            }
            if (i2.exists()) {
                String replace = str.replace("//", "/");
                if (replace.startsWith("/")) {
                    return i2.getAbsolutePath() + replace;
                }
                if (replace.startsWith("./")) {
                    replace = replace.replace("./", "");
                }
                return i2.getAbsolutePath() + File.separator + replace;
            }
        }
        return null;
    }

    @Nullable
    public static String M(String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (G(str)) {
                return N(str, str2);
            }
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return null;
            }
            String host = parse.getHost();
            if (f47006a) {
                Log.d("StorageUtil", "——> getFileStorePathFromScheme: uri " + str + "  host " + host);
            }
            if (TextUtils.isEmpty(host)) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (host.startsWith("tmp_")) {
                str3 = host.replace("tmp_", "");
                int indexOf = str3.indexOf(".");
                if (indexOf > 0) {
                    str3 = str3.substring(0, indexOf);
                }
                String x = x(str2);
                if (TextUtils.isEmpty(x)) {
                    return null;
                }
                stringBuffer.append(x);
            } else if (host.startsWith("store_")) {
                str3 = host.replace("store_", "");
                int indexOf2 = str3.indexOf(".");
                if (indexOf2 > 0) {
                    str3 = str3.substring(0, indexOf2);
                }
                String v = v(str2);
                if (TextUtils.isEmpty(v)) {
                    return null;
                }
                stringBuffer.append(v);
            } else {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                String str4 = new String(Base64.decode(str3, 10));
                if (d.a.m0.t.d.w(str4)) {
                    return null;
                }
                stringBuffer.append(str4);
                if (f47006a) {
                    Log.d("StorageUtil", "——> scheme2Path: encodePath " + str3);
                    Log.d("StorageUtil", "——> scheme2Path:  path " + stringBuffer.toString());
                }
                return stringBuffer.toString();
            } catch (IllegalArgumentException e2) {
                if (f47006a) {
                    Log.d("StorageUtil", "——> scheme2Path: IllegalArgumentException " + e2.getMessage());
                }
            }
        }
        return null;
    }

    @Nullable
    public static String N(@NonNull String str, @NonNull String str2) {
        String z;
        String replace = TextUtils.equals(str, d.a.m0.a.r0.a.USER_DATA_PATH) ? "" : str.replace("bdfile://usr/", "");
        if (d.a.m0.t.d.w(replace) || (z = z(str2)) == null) {
            return null;
        }
        return z + File.separator + replace;
    }

    public static long a() {
        Map<String, PMSAppInfo> t = d.a.m0.n.g.a.h().t();
        if (t.isEmpty()) {
            return 0L;
        }
        return d.a.m0.t.d.c(o(), t.keySet());
    }

    public static int b() {
        return (int) (a() / 1024);
    }

    public static long c() {
        return d.a.m0.t.d.a(q());
    }

    public static long d() {
        return d.a.m0.t.d.a(r());
    }

    public static long e() {
        return c() + h();
    }

    public static long f() {
        return d.a.m0.t.d.b(B(), "aiapp_", "aiapp_setting_");
    }

    public static long g() {
        return d.a.m0.t.d.c(o(), f47008c);
    }

    public static long h() {
        return d.a.m0.t.d.b(B(), "aiapp_setting_", null);
    }

    public static int i() {
        long g2 = g();
        long l = l();
        return (int) ((((g2 + l) + e()) + j()) / 1024);
    }

    public static long j() {
        return d.a.m0.t.d.a(A());
    }

    public static int k() {
        return (int) ((f() + d()) / 1024);
    }

    public static long l() {
        return d.a.m0.t.d.a(new File(p(), "ubcdir"));
    }

    public static boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    public static String n(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!TextUtils.isEmpty(str3)) {
            return x(str) + File.separator + str2 + ("." + str3);
        }
        return x(str) + File.separator + str2;
    }

    @NonNull
    public static File o() {
        return new File(p(), "aiapps_folder");
    }

    public static File p() {
        return AppRuntime.getAppContext().getFilesDir();
    }

    @NonNull
    public static File q() {
        return new File(o(), "cloud_config");
    }

    @Nullable
    public static File r() {
        File externalFilesDir;
        if (!"mounted".equals(Environment.getExternalStorageState()) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
            return null;
        }
        return new File(externalFilesDir, "aiapp" + File.separator + "usr");
    }

    public static PathType s(String str) {
        if (TextUtils.isEmpty(str)) {
            return PathType.ERROR;
        }
        String str2 = null;
        try {
            str2 = new URI(str).getScheme();
        } catch (URISyntaxException e2) {
            if (f47006a) {
                e2.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return PathType.RELATIVE;
        }
        if (TextUtils.equals(str2, "bdfile")) {
            return PathType.BD_FILE;
        }
        if (!TextUtils.equals(str2, "http") && !TextUtils.equals(str2, "https")) {
            if (TextUtils.equals(str2, "cloud")) {
                return PathType.CLOUD;
            }
            return PathType.ERROR;
        }
        return PathType.NETWORK;
    }

    public static String t(d.a.m0.a.a2.e eVar) {
        b.a N = eVar.N();
        if (N != null && !TextUtils.isEmpty(N.I()) && N.t1() == 1) {
            return N.I() + "_dev";
        }
        return eVar.f44533f;
    }

    public static String u(String str, int i2) {
        String str2 = "aiapp_setting_" + str;
        if (i2 == 1) {
            return str2 + "_dev";
        }
        return str2;
    }

    public static String v(String str) {
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
            return null;
        }
        if (f47006a) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
        }
        String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + f47007b + "/store" + File.separator + "aiapp_" + str;
        m(str2);
        return str2;
    }

    public static String w() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (f47006a) {
                Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
            }
            return AppRuntime.getAppContext().getExternalFilesDir(null) + f47007b;
        }
        return null;
    }

    public static String x(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (f47006a) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        String str2 = AppRuntime.getAppContext().getExternalCacheDir() + f47007b + "/tmp" + File.separator + "aiapp_" + str;
        m(str2);
        return str2;
    }

    public static String y() {
        if (f47006a) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        return AppRuntime.getAppContext().getExternalCacheDir() + f47007b;
    }

    public static String z(String str) {
        File externalFilesDir;
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (f47006a) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + absolutePath);
        }
        String C = C(absolutePath);
        if (C == null) {
            return null;
        }
        String str2 = absolutePath + f47007b + "/usr" + File.separator + C + File.separator + "aiapp_" + str;
        m(str2);
        return str2;
    }
}
