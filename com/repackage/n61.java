package com.repackage;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.interfa.IPackageDownloadCallback;
import com.baidu.nps.interfa.IPackageGetCallback;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.nps.utils.Constant;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.TKBase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class n61 {
    public static /* synthetic */ Interceptable $ic;
    public static final String d;
    public static final String e;
    public static final String f;
    public static final int g;
    public static n61 h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public Map<String, BundleInfo> b;
    public Set<String> c;

    /* loaded from: classes6.dex */
    public class a implements IPackageGetCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ CountDownLatch b;

        public a(n61 n61Var, d dVar, CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n61Var, dVar, countDownLatch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            this.b = countDownLatch;
        }

        @Override // com.baidu.nps.interfa.IPackageGetCallback
        public void onBundleInfoGetFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                d dVar = this.a;
                dVar.a = i;
                dVar.b = new ArrayList();
                this.b.countDown();
            }
        }

        @Override // com.baidu.nps.interfa.IPackageGetCallback
        public void onBundleInfoGetSuccess(List<IBundleInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                d dVar = this.a;
                dVar.a = 0;
                if (list == null) {
                    list = new ArrayList<>();
                }
                dVar.b = list;
                this.b.countDown();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements IPackageDownloadCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ d b;
        public final /* synthetic */ CountDownLatch c;
        public final /* synthetic */ BundleInfo d;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ b c;

            public a(b bVar, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str, str2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Context context = this.c.a;
                    File g = u61.g(context, this.a + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                    if (g.exists()) {
                        g.delete();
                    }
                    boolean z = false;
                    try {
                        z = new File(this.b).renameTo(g);
                    } catch (Exception unused) {
                    }
                    if (z) {
                        this.c.b.a = 2;
                    } else {
                        this.c.b.a = 11;
                    }
                    this.c.c.countDown();
                }
            }
        }

        /* renamed from: com.repackage.n61$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0478b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ b b;

            public RunnableC0478b(b bVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.b;
                    bVar.b.a = this.a;
                    bVar.c.countDown();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ long b;
            public final /* synthetic */ b c;

            public c(b bVar, long j, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Long.valueOf(j), Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = j;
                this.b = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.c.a.getContentResolver().notifyChange(b71.c(this.c.d.getPackageName(), this.a, this.b), null);
                }
            }
        }

        public b(n61 n61Var, Context context, d dVar, CountDownLatch countDownLatch, BundleInfo bundleInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n61Var, context, dVar, countDownLatch, bundleInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = dVar;
            this.c = countDownLatch;
            this.d = bundleInfo;
        }

        @Override // com.baidu.nps.interfa.IPackageDownloadCallback
        public void onPackageDownloadFail(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, str2) == null) {
                d61.a().b().run(new RunnableC0478b(this, i));
            }
        }

        @Override // com.baidu.nps.interfa.IPackageDownloadCallback
        public void onPackageDownloadSuccess(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
                d61.a().b().run(new a(this, str, str2));
            }
        }

        @Override // com.baidu.nps.interfa.IPackageDownloadCallback
        public void onProgress(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                d61.a().b().run(new c(this, j, j2));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BundleInfo a;
        public final /* synthetic */ String b;

        public c(n61 n61Var, BundleInfo bundleInfo, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n61Var, bundleInfo, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bundleInfo;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            FileOutputStream fileOutputStream;
            Throwable th;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                File file = new File(ContextHolder.getApplicationContext().getCacheDir(), "nps");
                file.mkdirs();
                File file2 = new File(file, "ext_nps_upgradle_application");
                if (file2.exists() && file2.length() > 1048576) {
                    file2.delete();
                    file2.createNewFile();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("v_c", this.a.getVersionCode());
                jSONObject.put("name", this.a.getPackageName());
                jSONObject.put("upgrade", this.a.getUpdateV());
                jSONObject.put("f_u", this.a.needForceUpdate());
                jSONObject.put("f_b", this.a.isForbidden());
                jSONObject.put(TKBase.VISIBILITY_VISIBLE, this.a.isVisible());
                try {
                    fileOutputStream = new FileOutputStream(file2, true);
                    try {
                        fileOutputStream.write(jSONObject.toString().getBytes());
                        fileOutputStream.write(this.b.getBytes());
                        fileOutputStream.write(String.valueOf(System.currentTimeMillis()).getBytes());
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    fileOutputStream = null;
                    th = th3;
                }
            } catch (IOException | Exception unused2) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public List<IBundleInfo> b;

        public d() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755517656, "Lcom/repackage/n61;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755517656, "Lcom/repackage/n61;");
                return;
            }
        }
        d = "nps" + File.separator + "preset";
        e = d + File.separator + "info";
        f = d + File.separator + "bundle";
        g = 4;
        h = new n61();
    }

    public n61() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = new HashMap();
        this.c = new HashSet();
    }

    public static n61 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? h : (n61) invokeV.objValue;
    }

    public final void a(File file, boolean z) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, file, z) == null) || !file.exists() || file.isFile() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isFile()) {
                listFiles[i].delete();
            } else {
                a(listFiles[i], true);
            }
        }
        if (z) {
            file.delete();
        }
    }

    public int b(BundleInfo bundleInfo, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundleInfo, i)) == null) {
            d dVar = new d();
            dVar.a = 2;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Application applicationContext = ContextHolder.getApplicationContext();
            z51.a().b().downloadBundle(bundleInfo, u61.h(applicationContext).getAbsolutePath(), i, new b(this, applicationContext, dVar, countDownLatch, bundleInfo));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
            return dVar.a;
        }
        return invokeLI.intValue;
    }

    public d c(List<IBundleInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            d dVar = new d();
            dVar.a = 0;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            z51.a().b().getBundleInfo(list, new a(this, dVar, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < stackTrace.length; i++) {
                sb.append(stackTrace[i].getClassName());
                sb.append(":");
                sb.append(stackTrace[i].getMethodName());
                sb.append(";");
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public synchronized Map<String, BundleInfo> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                if (this.a) {
                    return this.b;
                }
                try {
                    AssetManager assets = ContextHolder.getApplicationContext().getAssets();
                    InputStream open = assets.open(e + File.separator + "preset.json");
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, Xml.Encoding.UTF_8.toString()), 8192);
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    this.b = l(new JSONArray(sb.toString()));
                    this.a = true;
                } catch (IOException e2) {
                    if (t61.a()) {
                        Log.e("PRESET", "e=" + e2.getMessage());
                    }
                } catch (JSONException e3) {
                    if (t61.a()) {
                        Log.e("PRESET", "e=" + e3.getMessage());
                    }
                }
                return this.b;
            }
        }
        return (Map) invokeV.objValue;
    }

    public int g(BundleInfo bundleInfo, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundleInfo, file)) == null) {
            try {
                n(bundleInfo, e());
            } catch (Exception unused) {
            }
            Application applicationContext = ContextHolder.getApplicationContext();
            PackageInfo a2 = w61.a(file.getAbsolutePath(), 128);
            if (a2 == null) {
                return 8;
            }
            if (TextUtils.equals(bundleInfo.getPackageName(), a2.packageName)) {
                if (b61.a().b().checkSignature(bundleInfo.getPackageName(), a71.a(file.getAbsolutePath()))) {
                    u61.f(applicationContext, bundleInfo.getPackageName()).mkdirs();
                    File e2 = u61.e(applicationContext, bundleInfo.getPackageName());
                    e2.mkdirs();
                    File d2 = u61.d(applicationContext, bundleInfo.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                    if (!u61.b(file, d2)) {
                        if (d2.exists()) {
                            d2.delete();
                            return 11;
                        }
                        return 11;
                    }
                    a(e2, false);
                    if (!i(d2.getAbsolutePath(), e2.getAbsolutePath())) {
                        if (d2.exists()) {
                            d2.delete();
                            return 12;
                        }
                        return 12;
                    } else if (file.exists()) {
                        file.delete();
                        return 13;
                    } else {
                        return 13;
                    }
                }
                return 10;
            }
            return 9;
        }
        return invokeLL.intValue;
    }

    public int h(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bundleInfo)) == null) {
            Application applicationContext = ContextHolder.getApplicationContext();
            File g2 = u61.g(applicationContext, System.currentTimeMillis() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
            if (g2.exists()) {
                g2.delete();
            }
            String apkPath = bundleInfo.getApkPath();
            if (TextUtils.isEmpty(apkPath)) {
                return 6;
            }
            File file = new File(apkPath);
            if (file.exists()) {
                if (u61.b(file, g2)) {
                    return g(bundleInfo, g2);
                }
                return 11;
            }
            return 7;
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, IF, INVOKE, IF, IF] complete} */
    public final boolean i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            String str3 = Build.CPU_ABI;
            String str4 = Build.CPU_ABI2;
            try {
                ZipFile zipFile = new ZipFile(str);
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                boolean z = false;
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    String name = nextElement.getName();
                    if (name.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX) && name.endsWith(".so")) {
                        int lastIndexOf = name.lastIndexOf("/");
                        String substring = name.substring(g, lastIndexOf);
                        if (str3.equals(substring)) {
                            z = true;
                        } else if (str4.equals(substring) && !z) {
                        }
                        InputStream inputStream = null;
                        String substring2 = name.substring(lastIndexOf);
                        File file = new File(str2, substring2 + System.currentTimeMillis());
                        File file2 = new File(str2, substring2);
                        try {
                            inputStream = zipFile.getInputStream(nextElement);
                            if (!u61.c(inputStream, file)) {
                                if (file.exists()) {
                                    file.delete();
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                return false;
                            }
                            if (file2.exists()) {
                                file2.delete();
                            }
                            file.renameTo(file2);
                            if (file.exists()) {
                                file.delete();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                        } catch (IOException unused3) {
                            if (file.exists()) {
                                file.delete();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused4) {
                                }
                            }
                            return false;
                        } catch (Throwable th) {
                            if (file.exists()) {
                                file.delete();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused5) {
                                }
                            }
                            throw th;
                        }
                    }
                }
                try {
                    zipFile.close();
                } catch (IOException unused6) {
                }
                return true;
            } catch (IOException unused7) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public int j(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundleInfo)) == null) {
            Application applicationContext = ContextHolder.getApplicationContext();
            File g2 = u61.g(applicationContext, System.currentTimeMillis() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
            if (g2.exists()) {
                g2.delete();
            }
            if (u61.a(applicationContext, f + File.separator + bundleInfo.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX, g2.getAbsolutePath())) {
                return g(bundleInfo, g2);
            }
            return 11;
        }
        return invokeL.intValue;
    }

    public synchronized boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return this.c.contains(str);
            }
        }
        return invokeL.booleanValue;
    }

    public final Map<String, BundleInfo> l(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, jSONArray)) == null) {
            HashMap hashMap = new HashMap();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    BundleInfo bundleInfo = new BundleInfo();
                    bundleInfo.setPackageName(jSONObject.optString(EmotionResourceInfo.JSON_KEY_PKG_NAME));
                    bundleInfo.setMd5(jSONObject.optString(PackageTable.MD5));
                    bundleInfo.setType(2);
                    bundleInfo.setVersionCode(jSONObject.optInt("version_code"));
                    bundleInfo.setName(jSONObject.optString("name"));
                    bundleInfo.setDescription(jSONObject.optString("description"));
                    bundleInfo.setIconUrl(jSONObject.optString("icon_url"));
                    hashMap.put(bundleInfo.getPackageName(), bundleInfo);
                } catch (JSONException unused) {
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public synchronized void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.c.add(str);
            }
        }
    }

    public final void n(BundleInfo bundleInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, bundleInfo, str) == null) {
            d61.a().b().run(new c(this, bundleInfo, str));
        }
    }
}
