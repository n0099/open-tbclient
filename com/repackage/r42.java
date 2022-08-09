package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.vj2;
import com.repackage.yj2;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes7.dex */
public final class r42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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
            File[] listFiles;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File filesDir = AppRuntime.getAppContext().getFilesDir();
                bh4.j(new File(filesDir, "aiapps_zip"));
                bh4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                for (File file2 : listFiles) {
                    long lastModified = file2.lastModified();
                    if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                        bh4.L(file2);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public boolean b;
        public String c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0;
            this.b = false;
            this.c = "";
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755400383, "Lcom/repackage/r42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755400383, "Lcom/repackage/r42;");
                return;
            }
        }
        a = jh1.a;
        b = false;
    }

    public r42() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static sc3 a(ReadableByteChannel readableByteChannel, String str, p84 p84Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, p84Var)) == null) {
            if (readableByteChannel == null) {
                sc3 sc3Var = new sc3();
                sc3Var.k(11L);
                sc3Var.i(2300L);
                sc3Var.f("empty source");
                wc3.a().f(sc3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + sc3Var);
                }
                return sc3Var;
            }
            p84Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            p84Var.n("770", "na_pms_start_check_sign");
            if (me3.d(readableByteChannel, str, new gf3())) {
                p84Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                p84Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            sc3 sc3Var2 = new sc3();
            sc3Var2.k(11L);
            sc3Var2.i(2300L);
            sc3Var2.f("check zip file sign fail.");
            wc3.a().f(sc3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + sc3Var2);
            }
            return sc3Var2;
        }
        return (sc3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable v94 v94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, v94Var)) == null) {
            if (v94Var == null || TextUtils.isEmpty(v94Var.a)) {
                return false;
            }
            File file = new File(v94Var.a);
            return file.exists() && file.isFile() && file.delete();
        }
        return invokeL.booleanValue;
    }

    @AnyThread
    public static void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || b) {
            return;
        }
        synchronized (r42.class) {
            if (b) {
                return;
            }
            b = true;
            td3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? vj2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? hk2.g().c() : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? hk2.g().c() : (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? vj2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? vj2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? hk2.g().c() : (String) invokeV.objValue;
    }

    public static boolean j(r94 r94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, r94Var)) == null) {
            if (r94Var == null) {
                return false;
            }
            int i = r94Var.a;
            return i == 1013 || i == 1015;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, w94 w94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, w94Var) == null) || pMSAppInfo == null || w94Var == null) {
            return;
        }
        pMSAppInfo.copyMainPkgInfo(w94Var);
        if (w94Var.h == 1) {
            pMSAppInfo.setOrientation(hk2.i().u(w94Var.g, w94Var.i));
        } else {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, x94 x94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, x94Var) == null) || pMSAppInfo == null || x94Var == null) {
            return;
        }
        pMSAppInfo.copySubPkgInfo(x94Var);
        if (x94Var.h == 0) {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static sc3 m(v94 v94Var, p84 p84Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, v94Var, p84Var)) == null) {
            if (v94Var == null) {
                sc3 sc3Var = new sc3();
                sc3Var.k(11L);
                sc3Var.i(2320L);
                sc3Var.f("pkg info is empty");
                wc3.a().f(sc3Var);
                return sc3Var;
            }
            File file = new File(v94Var.a);
            int i2 = v94Var.h;
            if (i2 == 1) {
                i = hk2.g().a(v94Var.g, String.valueOf(v94Var.i));
                if (i == null) {
                    sc3 sc3Var2 = new sc3();
                    sc3Var2.k(11L);
                    sc3Var2.i(2320L);
                    sc3Var2.f("获取解压目录失败");
                    wc3.a().f(sc3Var2);
                    return sc3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = vj2.e.i(v94Var.g, String.valueOf(v94Var.i));
            } else {
                sc3 sc3Var3 = new sc3();
                sc3Var3.k(11L);
                sc3Var3.i(2320L);
                sc3Var3.f("pkh category illegal");
                wc3.a().f(sc3Var3);
                return sc3Var3;
            }
            if (!file.exists()) {
                sc3 sc3Var4 = new sc3();
                sc3Var4.k(11L);
                sc3Var4.i(2320L);
                sc3Var4.f("解压失败：包不存在");
                wc3.a().f(sc3Var4);
                return sc3Var4;
            } else if (i.isFile() && !i.delete()) {
                zx1.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                sc3 sc3Var5 = new sc3();
                sc3Var5.k(11L);
                sc3Var5.i(2320L);
                sc3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                wc3.a().f(sc3Var5);
                return sc3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                sc3 sc3Var6 = new sc3();
                sc3Var6.k(11L);
                sc3Var6.i(2320L);
                sc3Var6.f("解压失败：解压文件夹创建失败");
                wc3.a().f(sc3Var6);
                return sc3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, p84Var).b) {
                    return null;
                }
                b n = n(file, i, p84Var);
                if (n.b) {
                    o73.a(p84Var, v94Var.h, true);
                    return null;
                }
                o73.a(p84Var, v94Var.h, false);
                zx1.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                bh4.L(i);
                sc3 sc3Var7 = new sc3();
                int i3 = n.a;
                if (i3 == 0) {
                    sc3Var7.k(11L);
                    sc3Var7.i(2320L);
                    sc3Var7.f("unzip failed");
                } else if (i3 != 1 && i3 != 2) {
                    sc3Var7.k(4L);
                    sc3Var7.i(7L);
                    sc3Var7.f("Unkown bundle type");
                } else {
                    sc3Var7.k(11L);
                    sc3Var7.i(2330L);
                    sc3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                }
                wc3.a().f(sc3Var7);
                return sc3Var7;
            }
        }
        return (sc3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull p84 p84Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, p84Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            yj2.c j = yj2.j(file);
            int i = 0;
            if (j.b != -1) {
                p84Var.n("670", "package_start_decrypt");
                p84Var.n("770", "na_package_start_decrypt");
                yj2.b d = yj2.d(j.a, file2, j.b);
                p84Var.n("670", "package_end_decrypt");
                p84Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                p84Var.n("670", "package_start_unzip");
                p84Var.n("770", "na_package_start_unzip");
                boolean U = bh4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = bh4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        a83 a83Var = new a83();
                        sc3 sc3Var = new sc3();
                        sc3Var.k(4L);
                        sc3Var.i(52L);
                        a83Var.p(sc3Var);
                        a83Var.l("path", file2.getAbsolutePath());
                        a83Var.l("eMsg", "unzip files not match zip content");
                        a83Var.l("decryptType", String.valueOf(j.b));
                        a83Var.l("stack", te3.z(30));
                        s73.R(a83Var);
                    }
                }
                p84Var.n("670", "package_end_unzip");
                p84Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                yj2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            t84.a(p84Var, bundle, "event_download_package_type");
            return bVar;
        }
        return (b) invokeLLL.objValue;
    }

    public static void o(@Nullable PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, null, pMSAppInfo) == null) || pMSAppInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
            r13.u(pMSAppInfo.appId, "", zd3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            r13.t("", zd3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            r13.s(pMSAppInfo.appId, zd3.d(pMSAppInfo.domains));
        }
        if (TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            return;
        }
        r13.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
    }
}
