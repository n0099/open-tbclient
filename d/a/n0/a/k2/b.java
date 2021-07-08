package d.a.n0.a.k2;

import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.n0.a.a1.e;
import d.a.n0.a.a2.e;
import d.a.n0.a.f1.e.b;
import d.a.n0.a.k;
import d.a.n0.t.f;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45854a;

    /* renamed from: b  reason: collision with root package name */
    public static String f45855b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f45856c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f45857a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1257188434, "Ld/a/n0/a/k2/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1257188434, "Ld/a/n0/a/k2/b$a;");
                    return;
                }
            }
            int[] iArr = new int[PathType.values().length];
            f45857a = iArr;
            try {
                iArr[PathType.BD_FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45857a[PathType.RELATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(709305547, "Ld/a/n0/a/k2/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(709305547, "Ld/a/n0/a/k2/b;");
                return;
            }
        }
        f45854a = k.f45831a;
        f45855b = "/aiapp";
        f45856c = new HashSet(Arrays.asList("extension_core", "js_native", "swan_core"));
    }

    public static File A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new File(p(), "swan_plugin_workspace") : (File) invokeV.objValue;
    }

    @NonNull
    public static File B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new File(d.a.n0.a.k2.h.c.A()) : (File) invokeV.objValue;
    }

    @Nullable
    public static String C(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            e i2 = e.i();
            if (i2 == null) {
                return null;
            }
            String d2 = i2.j() != null ? i2.j().d() : "";
            if (!TextUtils.isEmpty(d2)) {
                String d3 = f.d(d2.getBytes(), false);
                if (D(str + f45855b + File.separator + d3)) {
                    if (f45854a) {
                        Log.d("StorageUtil", "the filesystem base path is under UID ");
                    }
                    return d3;
                }
            }
            String i3 = d.a.n0.a.c1.a.a0().i(AppRuntime.getAppContext());
            if (!TextUtils.isEmpty(i3)) {
                i3 = i3.replace("|", "");
            }
            return f.d(i3.getBytes(), false);
        }
        return (String) invokeL.objValue;
    }

    public static boolean D(String str) {
        InterceptResult invokeL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length <= 0) ? false : true : invokeL.booleanValue;
    }

    public static boolean E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            PathType s = s(str);
            return s == PathType.BD_FILE || s == PathType.RELATIVE;
        }
        return invokeL.booleanValue;
    }

    public static boolean F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? !TextUtils.isEmpty(str) && str.startsWith("bdfile://tmp_") : invokeL.booleanValue;
    }

    public static boolean G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? !TextUtils.isEmpty(str) && (str.startsWith("bdfile://usr/") || TextUtils.equals(str, d.a.n0.a.r0.a.USER_DATA_PATH)) : invokeL.booleanValue;
    }

    public static String H(String str, @NonNull e eVar) {
        InterceptResult invokeLL;
        String M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, eVar)) == null) {
            int i2 = a.f45857a[s(str).ordinal()];
            if (i2 != 1) {
                M = i2 != 2 ? str : L(str, eVar, eVar.Z());
            } else {
                M = M(str, eVar.f43381f);
            }
            return M == null ? str : M;
        }
        return (String) invokeLL.objValue;
    }

    @Nullable
    public static String I(String str, String str2) {
        InterceptResult invokeLL;
        String replace;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (f45854a) {
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
                if (f45854a) {
                    Log.d("StorageUtil", "——> path2Scheme: relative path " + replace);
                }
                if (TextUtils.isEmpty(replace)) {
                    return null;
                }
                stringBuffer.append(new String(Base64.encode(replace.getBytes(), 10)));
                if (f45854a) {
                    Log.d("StorageUtil", "——> path2Scheme: url " + ((Object) stringBuffer));
                }
                return stringBuffer.toString();
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @Nullable
    public static String J(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) {
            String I = I(str, str2);
            String p = d.a.n0.t.d.p(d.a.n0.t.d.q(str));
            if (I != null && !I.contains(".") && p != null) {
                I = I + "." + p;
            }
            if (f45854a) {
                Log.d("StorageUtil", "path2SchemeWithExt: url" + I);
            }
            return I;
        }
        return (String) invokeLL.objValue;
    }

    @Nullable
    public static String K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static String L(String str, e eVar, String str2) {
        InterceptResult invokeLLL;
        File i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, str, eVar, str2)) == null) {
            if (eVar != null && !d.a.n0.t.d.w(str)) {
                b.a N = eVar.N();
                boolean z = N != null && N.m0();
                if (f45854a && z) {
                    Log.d("StorageUtil", "relative path : " + str);
                    i2 = e.b.e();
                } else if (!TextUtils.isEmpty(eVar.f43381f) && !TextUtils.isEmpty(str2) && s(str) == PathType.RELATIVE) {
                    i2 = e.C0629e.i(eVar.f43381f, str2);
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
        return (String) invokeLLL.objValue;
    }

    @Nullable
    public static String M(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (G(str)) {
                    return N(str, str2);
                }
                Uri parse = Uri.parse(str);
                if (parse == null) {
                    return null;
                }
                String host = parse.getHost();
                if (f45854a) {
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
                    if (d.a.n0.t.d.w(str4)) {
                        return null;
                    }
                    stringBuffer.append(str4);
                    if (f45854a) {
                        Log.d("StorageUtil", "——> scheme2Path: encodePath " + str3);
                        Log.d("StorageUtil", "——> scheme2Path:  path " + stringBuffer.toString());
                    }
                    return stringBuffer.toString();
                } catch (IllegalArgumentException e2) {
                    if (f45854a) {
                        Log.d("StorageUtil", "——> scheme2Path: IllegalArgumentException " + e2.getMessage());
                    }
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @Nullable
    public static String N(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        String z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, str2)) == null) {
            String replace = TextUtils.equals(str, d.a.n0.a.r0.a.USER_DATA_PATH) ? "" : str.replace("bdfile://usr/", "");
            if (d.a.n0.t.d.w(replace) || (z = z(str2)) == null) {
                return null;
            }
            return z + File.separator + replace;
        }
        return (String) invokeLL.objValue;
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            Map<String, PMSAppInfo> t = d.a.n0.n.g.a.h().t();
            if (t.isEmpty()) {
                return 0L;
            }
            return d.a.n0.t.d.c(o(), t.keySet());
        }
        return invokeV.longValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? (int) (a() / 1024) : invokeV.intValue;
    }

    public static long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? d.a.n0.t.d.a(q()) : invokeV.longValue;
    }

    public static long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? d.a.n0.t.d.a(r()) : invokeV.longValue;
    }

    public static long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? c() + h() : invokeV.longValue;
    }

    public static long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? d.a.n0.t.d.b(B(), "aiapp_", "aiapp_setting_") : invokeV.longValue;
    }

    public static long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? d.a.n0.t.d.c(o(), f45856c) : invokeV.longValue;
    }

    public static long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? d.a.n0.t.d.b(B(), "aiapp_setting_", null) : invokeV.longValue;
    }

    public static int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            return (int) ((((g() + l()) + e()) + j()) / 1024);
        }
        return invokeV.intValue;
    }

    public static long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? d.a.n0.t.d.a(A()) : invokeV.longValue;
    }

    public static int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? (int) ((f() + d()) / 1024) : invokeV.intValue;
    }

    public static long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? d.a.n0.t.d.a(new File(p(), "ubcdir")) : invokeV.longValue;
    }

    public static boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        }
        return invokeL.booleanValue;
    }

    public static String n(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65564, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return "";
            }
            if (!TextUtils.isEmpty(str3)) {
                return x(str) + File.separator + str2 + ("." + str3);
            }
            return x(str) + File.separator + str2;
        }
        return (String) invokeLLL.objValue;
    }

    @NonNull
    public static File o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? new File(p(), "aiapps_folder") : (File) invokeV.objValue;
    }

    public static File p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? AppRuntime.getAppContext().getFilesDir() : (File) invokeV.objValue;
    }

    @NonNull
    public static File q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) ? new File(o(), "cloud_config") : (File) invokeV.objValue;
    }

    @Nullable
    public static File r() {
        InterceptResult invokeV;
        File externalFilesDir;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            if (!"mounted".equals(Environment.getExternalStorageState()) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
                return null;
            }
            return new File(externalFilesDir, "aiapp" + File.separator + "usr");
        }
        return (File) invokeV.objValue;
    }

    public static PathType s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return PathType.ERROR;
            }
            String str2 = null;
            try {
                str2 = new URI(str).getScheme();
            } catch (URISyntaxException e2) {
                if (f45854a) {
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
        return (PathType) invokeL.objValue;
    }

    public static String t(d.a.n0.a.a2.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, eVar)) == null) {
            b.a N = eVar.N();
            if (N != null && !TextUtils.isEmpty(N.I()) && N.t1() == 1) {
                return N.I() + "_dev";
            }
            return eVar.f43381f;
        }
        return (String) invokeL.objValue;
    }

    public static String u(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65571, null, str, i2)) == null) {
            String str2 = "aiapp_setting_" + str;
            if (i2 == 1) {
                return str2 + "_dev";
            }
            return str2;
        }
        return (String) invokeLI.objValue;
    }

    public static String v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, str)) == null) {
            if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
                return null;
            }
            if (f45854a) {
                Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
            }
            String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + f45855b + "/store" + File.separator + "aiapp_" + str;
            m(str2);
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                if (f45854a) {
                    Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
                }
                return AppRuntime.getAppContext().getExternalFilesDir(null) + f45855b;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (f45854a) {
                Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
            }
            String str2 = AppRuntime.getAppContext().getExternalCacheDir() + f45855b + "/tmp" + File.separator + "aiapp_" + str;
            m(str2);
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            if (f45854a) {
                Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
            }
            return AppRuntime.getAppContext().getExternalCacheDir() + f45855b;
        }
        return (String) invokeV.objValue;
    }

    public static String z(String str) {
        InterceptResult invokeL;
        File externalFilesDir;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, str)) == null) {
            if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
                return null;
            }
            String absolutePath = externalFilesDir.getAbsolutePath();
            if (f45854a) {
                Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + absolutePath);
            }
            String C = C(absolutePath);
            if (C == null) {
                return null;
            }
            String str2 = absolutePath + f45855b + "/usr" + File.separator + C + File.separator + "aiapp_" + str;
            m(str2);
            return str2;
        }
        return (String) invokeL.objValue;
    }
}
