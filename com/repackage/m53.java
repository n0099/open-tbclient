package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.so.SoLoader;
import com.baidu.swan.apps.so.SoUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.ZipFile;
/* loaded from: classes6.dex */
public class m53 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final String b;
    public static final boolean c;
    public static final String[] d;
    public static String e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.repackage.m53$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class RunnableC0471a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0471a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    m53.a();
                }
            }
        }

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                ExecutorUtilsExt.postOnElastic(new RunnableC0471a(), "V8SoCleaner", 3);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755548346, "Lcom/repackage/m53;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755548346, "Lcom/repackage/m53;");
                return;
            }
        }
        a = cg1.a;
        b = oi2.g() + "/v8_so/";
        c = zi2.e0().b();
        d = zi2.e0().a();
        e = null;
    }

    public static void a() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            File file = new File(b);
            if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
                return;
            }
            String D = md3.D();
            for (File file2 : listFiles) {
                if (!TextUtils.equals(file2.getName(), D)) {
                    uf4.L(file2);
                }
            }
        }
    }

    @NonNull
    public static ArrayList<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("v8.engine");
            arrayList.add("zeusv8");
            if (c) {
                arrayList.add("com.baidu.zeus");
            }
            String[] strArr = d;
            if (strArr != null && strArr.length != 0) {
                arrayList.addAll(Arrays.asList(strArr));
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "v8.engine" : (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (c) {
                return e;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"BDSoLoader"})
    public static boolean e(@Nullable String str, @NonNull SoLoader soLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, soLoader)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                System.loadLibrary(str);
                return true;
            } catch (Throwable th) {
                soLoader.appendErrorLog("loadLibsSo: " + th.getMessage());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode", "BDSoLoader"})
    public static boolean f(@Nullable String str, @NonNull SoLoader soLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, soLoader)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                System.load(str);
                return true;
            } catch (Throwable th) {
                soLoader.appendErrorLog("loadSoByPath: " + th.getMessage());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean g(@NonNull Context context, @NonNull SoLoader soLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, soLoader)) == null) {
            if (c) {
                File findSoFilesInLibrary = SoLoader.findSoFilesInLibrary(context, "com.baidu.zeus");
                if (findSoFilesInLibrary == null || findSoFilesInLibrary.length() == 0) {
                    return false;
                }
                e = findSoFilesInLibrary.getAbsolutePath();
                m("loadV8EngineSo: v8 dependentFile:" + e);
            }
            return l(null, soLoader) && e("v8.engine", soLoader);
        }
        return invokeLL.booleanValue;
    }

    public static n53 h(@NonNull Context context, @NonNull SoLoader soLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, soLoader)) == null) {
            if (g(context, soLoader)) {
                m("loadV8EngineBySystemMethod:success.");
                return n53.e();
            }
            n53 k = k(context, soLoader);
            if (k.b()) {
                m("loadV8EngineSoWithSystemPath:success.");
                return k;
            }
            n53 j = j(context, soLoader);
            if (!j.b()) {
                SoUtils.onEvent("26", soLoader.getErrorLog());
            } else {
                m("loadV8EngineSoWithCustomPath:success.");
            }
            return j;
        }
        return (n53) invokeLL.objValue;
    }

    public static n53 i(@NonNull HashMap<String, String> hashMap, @NonNull SoLoader soLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, hashMap, soLoader)) == null) {
            m("loadV8EngineSoByMap:" + hashMap);
            String str = hashMap.get("com.baidu.zeus");
            boolean z = false;
            if (c && str == null) {
                return n53.d(false, false);
            }
            boolean f = f(hashMap.get("zeusv8"), soLoader);
            boolean l = l(hashMap, soLoader);
            boolean f2 = f(hashMap.get("v8.engine"), soLoader);
            if (f2) {
                e = str;
            }
            if (l && f2) {
                z = true;
            }
            return n53.d(f, z);
        }
        return (n53) invokeLL.objValue;
    }

    public static n53 j(@NonNull Context context, @NonNull SoLoader soLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, soLoader)) == null) {
            e = null;
            HashMap hashMap = new HashMap();
            String D = md3.D();
            File file = new File(b, D);
            Iterator<String> it = b().iterator();
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                File file2 = new File(file, SoUtils.getFullName(next));
                hashMap.put(next, (!file2.exists() || file2.length() == 0) ? false : false ? file2.getAbsolutePath() : null);
            }
            if (!hashMap.containsValue(null)) {
                return i(hashMap, soLoader);
            }
            String str = "swan_v8so_unzip_times_" + D;
            int i = g83.a().getInt(str, 0);
            if (i >= 3) {
                soLoader.appendErrorLog("loadV8EngineSoWithCustomPath:reach max unzip times.");
                return k(context, soLoader);
            }
            g83.a().putInt(str, i + 1);
            String str2 = "lib" + File.separator + SoUtils.getCurrentCpuAbi();
            ZipFile apkZipFile = soLoader.getApkZipFile(context);
            try {
                if (apkZipFile == null) {
                    soLoader.appendErrorLog("loadV8EngineSoWithCustomPath:zipFile is null.");
                    return k(context, soLoader);
                }
                try {
                    for (String str3 : hashMap.keySet()) {
                        if (hashMap.get(str3) == null) {
                            String fullName = SoUtils.getFullName(str3);
                            File file3 = new File(file, fullName);
                            if (soLoader.executeRelease(apkZipFile, fullName, str2, file3)) {
                                hashMap.put(str3, file3.getAbsolutePath());
                            }
                        }
                    }
                } catch (Exception e2) {
                    soLoader.appendErrorLog("loadV8EngineSoWithCustomPath:" + e2.getMessage());
                    if (a) {
                        Log.e("V8InnerSoLoader", "loadV8EngineSoWithCustomPath:" + e2);
                    }
                }
                return i(hashMap, soLoader);
            } finally {
                uf4.d(apkZipFile);
            }
        }
        return (n53) invokeLL.objValue;
    }

    public static n53 k(@NonNull Context context, @NonNull SoLoader soLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, soLoader)) == null) {
            e = null;
            HashMap hashMap = new HashMap();
            Iterator<String> it = b().iterator();
            while (it.hasNext()) {
                String next = it.next();
                File findSoFilesInLibrary = SoLoader.findSoFilesInLibrary(context, next);
                hashMap.put(next, findSoFilesInLibrary != null && findSoFilesInLibrary.exists() && (findSoFilesInLibrary.length() > 0L ? 1 : (findSoFilesInLibrary.length() == 0L ? 0 : -1)) != 0 ? findSoFilesInLibrary.getAbsolutePath() : null);
            }
            return i(hashMap, soLoader);
        }
        return (n53) invokeLL.objValue;
    }

    public static boolean l(@Nullable HashMap<String, String> hashMap, @NonNull SoLoader soLoader) {
        InterceptResult invokeLL;
        boolean f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, hashMap, soLoader)) == null) {
            String[] strArr = d;
            boolean z = true;
            if (strArr != null && strArr.length != 0) {
                for (String str : strArr) {
                    if (hashMap == null) {
                        f = e(str, soLoader);
                    } else {
                        f = f(hashMap.get(str), soLoader);
                    }
                    if (!f) {
                        z = false;
                    }
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static void m(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, null, str) == null) && a) {
            Log.d("V8InnerSoLoader", str);
        }
    }
}
