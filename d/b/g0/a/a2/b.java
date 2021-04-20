package d.b.g0.a.a2;

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
import com.baidu.tbadk.core.util.FieldBuilder;
import d.b.g0.a.k;
import d.b.g0.a.r1.e;
import d.b.g0.a.u0.d;
import d.b.g0.a.y0.e.b;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43610a = k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public static String f43611b = "/aiapp";

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f43612a;

        static {
            int[] iArr = new int[PathType.values().length];
            f43612a = iArr;
            try {
                iArr[PathType.BD_FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43612a[PathType.RELATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    public static String b(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!TextUtils.isEmpty(str3)) {
            return h(str) + File.separator + str2 + ("." + str3);
        }
        return h(str) + File.separator + str2;
    }

    public static PathType c(String str) {
        if (TextUtils.isEmpty(str)) {
            return PathType.ERROR;
        }
        String str2 = null;
        try {
            str2 = new URI(str).getScheme();
        } catch (URISyntaxException e2) {
            if (f43610a) {
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

    public static String d(e eVar) {
        b.a L = eVar.L();
        if (L != null && !TextUtils.isEmpty(L.H()) && L.m1() == 1) {
            return L.H() + "_dev";
        }
        return eVar.f46132f;
    }

    public static String e(String str, int i) {
        String str2 = "aiapp_setting_" + str;
        if (i == 1) {
            return str2 + "_dev";
        }
        return str2;
    }

    public static String f(String str) {
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
            return null;
        }
        if (f43610a) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
        }
        String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + f43611b + "/store" + File.separator + "aiapp_" + str;
        a(str2);
        return str2;
    }

    public static String g() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (f43610a) {
                Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
            }
            return AppRuntime.getAppContext().getExternalFilesDir(null) + f43611b;
        }
        return null;
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (f43610a) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        String str2 = AppRuntime.getAppContext().getExternalCacheDir() + f43611b + "/tmp" + File.separator + "aiapp_" + str;
        a(str2);
        return str2;
    }

    public static String i() {
        if (f43610a) {
            Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
        }
        return AppRuntime.getAppContext().getExternalCacheDir() + f43611b;
    }

    public static String j(String str) {
        File externalFilesDir;
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (f43610a) {
            Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + absolutePath);
        }
        String k = k(absolutePath);
        if (k == null) {
            return null;
        }
        String str2 = absolutePath + f43611b + "/usr" + File.separator + k + File.separator + "aiapp_" + str;
        a(str2);
        return str2;
    }

    @Nullable
    public static String k(@NonNull String str) {
        e y = e.y();
        if (y == null) {
            return null;
        }
        String d2 = y.z() != null ? y.z().d() : "";
        if (!TextUtils.isEmpty(d2)) {
            String d3 = d.b.g0.p.e.d(d2.getBytes(), false);
            if (l(str + f43611b + File.separator + d3)) {
                if (f43610a) {
                    Log.d("StorageUtil", "the filesystem base path is under UID ");
                }
                return d3;
            }
        }
        String c2 = d.b.g0.a.w0.a.O().c(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(c2)) {
            c2 = c2.replace(FieldBuilder.SE, "");
        }
        return d.b.g0.p.e.d(c2.getBytes(), false);
    }

    public static boolean l(String str) {
        File[] listFiles;
        return (TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length <= 0) ? false : true;
    }

    public static boolean m(String str) {
        PathType c2 = c(str);
        return c2 == PathType.BD_FILE || c2 == PathType.RELATIVE;
    }

    public static boolean n(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("bdfile://tmp_");
    }

    public static boolean o(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("bdfile://usr/") || TextUtils.equals(str, d.b.g0.g.l.a.USER_DATA_PATH));
    }

    public static String p(String str, @NonNull e eVar) {
        String u;
        int i = a.f43612a[c(str).ordinal()];
        if (i != 1) {
            u = i != 2 ? str : t(str, eVar, eVar.W());
        } else {
            u = u(str, eVar.f46132f);
        }
        return u == null ? str : u;
    }

    @Nullable
    public static String q(String str, String str2) {
        String replace;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (f43610a) {
                Log.d("StorageUtil", "——> path2Scheme: path " + str + " swanAppId " + str2);
            }
            String f2 = f(str2);
            String h2 = h(str2);
            String j = j(str2);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(WebGLImageLoader.BDFILE);
            if (!TextUtils.isEmpty(h2) && str.startsWith(h2)) {
                replace = str.replace(h2, "");
                stringBuffer.append("tmp_");
            } else if (!TextUtils.isEmpty(f2) && str.startsWith(f2)) {
                replace = str.replace(f2, "");
                stringBuffer.append("store_");
            } else if (!TextUtils.isEmpty(j) && str.startsWith(j)) {
                String replace2 = str.replace(j + File.separator, "");
                return "bdfile://usr/" + replace2;
            }
            if (f43610a) {
                Log.d("StorageUtil", "——> path2Scheme: relative path " + replace);
            }
            if (TextUtils.isEmpty(replace)) {
                return null;
            }
            stringBuffer.append(new String(Base64.encode(replace.getBytes(), 10)));
            if (f43610a) {
                Log.d("StorageUtil", "——> path2Scheme: url " + ((Object) stringBuffer));
            }
            return stringBuffer.toString();
        }
        return null;
    }

    @Nullable
    public static String r(String str, String str2) {
        String q = q(str, str2);
        String j = d.b.g0.p.d.j(d.b.g0.p.d.k(str));
        if (q != null && !q.contains(".") && j != null) {
            q = q + "." + j;
        }
        if (f43610a) {
            Log.d("StorageUtil", "path2SchemeWithExt: url" + q);
        }
        return q;
    }

    @Nullable
    public static String s(String str) {
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

    public static String t(String str, e eVar, String str2) {
        File h2;
        if (eVar == null) {
            return null;
        }
        b.a L = eVar.L();
        boolean z = L != null && L.j0();
        if (f43610a && z) {
            Log.d("StorageUtil", "relative path : " + str);
            h2 = d.b.d();
        } else {
            if (!TextUtils.isEmpty(eVar.f46132f) && !TextUtils.isEmpty(str2) && c(str) == PathType.RELATIVE) {
                h2 = d.e.h(eVar.f46132f, str2);
            }
            return null;
        }
        if (h2.exists()) {
            String replace = str.replace("//", "/");
            if (replace.startsWith("/")) {
                return h2.getAbsolutePath() + replace;
            }
            if (replace.startsWith("./")) {
                replace = replace.replace("./", "");
            }
            return h2.getAbsolutePath() + File.separator + replace;
        }
        return null;
    }

    @Nullable
    public static String u(String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (o(str)) {
                return v(str, str2);
            }
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return null;
            }
            String host = parse.getHost();
            if (f43610a) {
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
                String h2 = h(str2);
                if (TextUtils.isEmpty(h2)) {
                    return null;
                }
                stringBuffer.append(h2);
            } else if (host.startsWith("store_")) {
                str3 = host.replace("store_", "");
                int indexOf2 = str3.indexOf(".");
                if (indexOf2 > 0) {
                    str3 = str3.substring(0, indexOf2);
                }
                String f2 = f(str2);
                if (TextUtils.isEmpty(f2)) {
                    return null;
                }
                stringBuffer.append(f2);
            } else {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                String str4 = new String(Base64.decode(str3, 10));
                if (d.b.g0.p.d.o(str4)) {
                    return null;
                }
                stringBuffer.append(str4);
                if (f43610a) {
                    Log.d("StorageUtil", "——> scheme2Path: encodePath " + str3);
                    Log.d("StorageUtil", "——> scheme2Path:  path " + stringBuffer.toString());
                }
                return stringBuffer.toString();
            } catch (IllegalArgumentException e2) {
                if (f43610a) {
                    Log.d("StorageUtil", "——> scheme2Path: IllegalArgumentException " + e2.getMessage());
                }
            }
        }
        return null;
    }

    @Nullable
    public static String v(@NonNull String str, @NonNull String str2) {
        String j;
        String replace = TextUtils.equals(str, d.b.g0.g.l.a.USER_DATA_PATH) ? "" : str.replace("bdfile://usr/", "");
        if (d.b.g0.p.d.o(replace) || (j = j(str2)) == null) {
            return null;
        }
        return j + File.separator + replace;
    }
}
