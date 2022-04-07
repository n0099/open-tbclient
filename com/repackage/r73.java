package com.repackage;

import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.fj2;
import com.repackage.gl2;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public final class r73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public static final Set<String> c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-87513722, "Lcom/repackage/r73$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-87513722, "Lcom/repackage/r73$a;");
                    return;
                }
            }
            int[] iArr = new int[PathType.values().length];
            a = iArr;
            try {
                iArr[PathType.BD_FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PathType.RELATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755397469, "Lcom/repackage/r73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755397469, "Lcom/repackage/r73;");
                return;
            }
        }
        a = tg1.a;
        b = "/aiapp";
        c = new HashSet(Arrays.asList("extension_core", "js_native", "swan_core"));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new File(a93.e()) : (File) invokeV.objValue;
    }

    @Nullable
    public static String C(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            j03 L = j03.L();
            if (L == null) {
                return null;
            }
            String d = L.M() != null ? L.M().d() : "";
            if (!TextUtils.isEmpty(d)) {
                String d2 = pg4.d(d.getBytes(), false);
                if (D(str + b + File.separator + d2)) {
                    if (a) {
                        Log.d("StorageUtil", "the filesystem base path is under UID ");
                    }
                    return d2;
                }
            }
            String i = qj2.h0().i(AppRuntime.getAppContext());
            if (!TextUtils.isEmpty(i)) {
                i = i.replace("|", "");
            }
            return pg4.d(i.getBytes(), false);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            PathType s = s(str);
            return s == PathType.BD_FILE || s == PathType.RELATIVE;
        }
        return invokeL.booleanValue;
    }

    public static boolean F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? !TextUtils.isEmpty(str) && str.startsWith("bdfile://tmp_") : invokeL.booleanValue;
    }

    public static boolean G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? !TextUtils.isEmpty(str) && (str.startsWith("bdfile://usr/") || TextUtils.equals(str, gc2.USER_DATA_PATH)) : invokeL.booleanValue;
    }

    public static String H(String str, @NonNull j03 j03Var) {
        InterceptResult invokeLL;
        String M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, j03Var)) == null) {
            int i = a.a[s(str).ordinal()];
            if (i != 1) {
                M = i != 2 ? str : L(str, j03Var, j03Var.j0());
            } else {
                M = M(str, j03Var.b);
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
                if (a) {
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
                if (a) {
                    Log.d("StorageUtil", "——> path2Scheme: relative path " + replace);
                }
                if (TextUtils.isEmpty(replace)) {
                    return null;
                }
                stringBuffer.append(new String(Base64.encode(replace.getBytes(), 10)));
                if (a) {
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
            String r = ng4.r(ng4.s(str));
            if (I != null && !I.contains(".") && r != null) {
                I = I + "." + r;
            }
            if (a) {
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

    public static String L(String str, j03 j03Var, String str2) {
        InterceptResult invokeLLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, str, j03Var, str2)) == null) {
            if (j03Var != null && !ng4.x(str)) {
                gl2.a X = j03Var.X();
                boolean z = X != null && X.n0();
                if (a && z) {
                    Log.d("StorageUtil", "relative path : " + str);
                    i = fj2.b.e();
                } else if (!TextUtils.isEmpty(j03Var.b) && !TextUtils.isEmpty(str2) && s(str) == PathType.RELATIVE) {
                    i = fj2.e.i(j03Var.b, str2);
                }
                if (i.exists()) {
                    String replace = str.replace("//", "/");
                    if (replace.startsWith("/")) {
                        return i.getAbsolutePath() + replace;
                    }
                    if (replace.startsWith("./")) {
                        replace = replace.replace("./", "");
                    }
                    return i.getAbsolutePath() + File.separator + replace;
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
                if (a) {
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
                    if (ng4.x(str4)) {
                        return null;
                    }
                    stringBuffer.append(str4);
                    if (a) {
                        Log.d("StorageUtil", "——> scheme2Path: encodePath " + str3);
                        Log.d("StorageUtil", "——> scheme2Path:  path " + stringBuffer.toString());
                    }
                    return stringBuffer.toString();
                } catch (IllegalArgumentException e) {
                    if (a) {
                        Log.d("StorageUtil", "——> scheme2Path: IllegalArgumentException " + e.getMessage());
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
            String replace = TextUtils.equals(str, gc2.USER_DATA_PATH) ? "" : str.replace("bdfile://usr/", "");
            if (ng4.x(replace) || (z = z(str2)) == null) {
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
            Map<String, PMSAppInfo> v = f84.i().v();
            if (v.isEmpty()) {
                return 0L;
            }
            return ng4.c(o(), v.keySet());
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? ng4.a(q()) : invokeV.longValue;
    }

    public static long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? ng4.a(r()) : invokeV.longValue;
    }

    public static long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? c() + h() : invokeV.longValue;
    }

    public static long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? ng4.b(B(), "aiapp_", "aiapp_setting_") : invokeV.longValue;
    }

    public static long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? ng4.c(o(), c) : invokeV.longValue;
    }

    public static long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? ng4.b(B(), "aiapp_setting_", null) : invokeV.longValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? ng4.a(A()) : invokeV.longValue;
    }

    public static int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? (int) ((f() + d()) / 1024) : invokeV.intValue;
    }

    public static long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? ng4.a(new File(p(), "ubcdir")) : invokeV.longValue;
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
            } catch (URISyntaxException e) {
                if (a) {
                    e.printStackTrace();
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

    public static String t(j03 j03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, j03Var)) == null) {
            gl2.a X = j03Var.X();
            if (X != null && !TextUtils.isEmpty(X.I()) && X.getType() == 1) {
                return X.I() + "_dev";
            }
            return j03Var.b;
        }
        return (String) invokeL.objValue;
    }

    public static String u(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65571, null, str, i)) == null) {
            String str2 = "aiapp_setting_" + str;
            if (i == 1) {
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
            try {
                if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
                    return null;
                }
                if (a) {
                    Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
                }
                String str2 = AppRuntime.getAppContext().getExternalFilesDir(null) + b + "/store" + File.separator + "aiapp_" + str;
                m(str2);
                return str2;
            } catch (Exception e) {
                if (a) {
                    Log.d("StorageUtil", Log.getStackTraceString(e));
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                if (a) {
                    Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null));
                }
                return AppRuntime.getAppContext().getExternalFilesDir(null) + b;
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
            if (a) {
                Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
            }
            String str2 = AppRuntime.getAppContext().getExternalCacheDir() + b + "/tmp" + File.separator + "aiapp_" + str;
            m(str2);
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            if (a) {
                Log.d("StorageUtil", "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir());
            }
            return AppRuntime.getAppContext().getExternalCacheDir() + b;
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
            if (a) {
                Log.d("StorageUtil", "——> getSwanAppStoreDirectory: " + absolutePath);
            }
            String C = C(absolutePath);
            if (C == null) {
                return null;
            }
            String str2 = absolutePath + b + "/usr" + File.separator + C + File.separator + "aiapp_" + str;
            m(str2);
            return str2;
        }
        return (String) invokeL.objValue;
    }
}
