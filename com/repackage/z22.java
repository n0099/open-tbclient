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
import com.repackage.di2;
import com.repackage.gi2;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes7.dex */
public final class z22 {
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
                kf4.j(new File(filesDir, "aiapps_zip"));
                kf4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                for (File file2 : listFiles) {
                    long lastModified = file2.lastModified();
                    if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                        kf4.L(file2);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755163977, "Lcom/repackage/z22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755163977, "Lcom/repackage/z22;");
                return;
            }
        }
        a = rf1.a;
        b = false;
    }

    public z22() {
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

    public static ab3 a(ReadableByteChannel readableByteChannel, String str, x64 x64Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, x64Var)) == null) {
            if (readableByteChannel == null) {
                ab3 ab3Var = new ab3();
                ab3Var.k(11L);
                ab3Var.i(2300L);
                ab3Var.f("empty source");
                eb3.a().f(ab3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + ab3Var);
                }
                return ab3Var;
            }
            x64Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            x64Var.n("770", "na_pms_start_check_sign");
            if (uc3.d(readableByteChannel, str, new od3())) {
                x64Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                x64Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            ab3 ab3Var2 = new ab3();
            ab3Var2.k(11L);
            ab3Var2.i(2300L);
            ab3Var2.f("check zip file sign fail.");
            eb3.a().f(ab3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + ab3Var2);
            }
            return ab3Var2;
        }
        return (ab3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable d84 d84Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, d84Var)) == null) {
            if (d84Var == null || TextUtils.isEmpty(d84Var.a)) {
                return false;
            }
            File file = new File(d84Var.a);
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
        synchronized (z22.class) {
            if (b) {
                return;
            }
            b = true;
            bc3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? di2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? pi2.g().c() : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? pi2.g().c() : (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? di2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? di2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? pi2.g().c() : (String) invokeV.objValue;
    }

    public static boolean j(z74 z74Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, z74Var)) == null) {
            if (z74Var == null) {
                return false;
            }
            int i = z74Var.a;
            return i == 1013 || i == 1015;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, e84 e84Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, e84Var) == null) || pMSAppInfo == null || e84Var == null) {
            return;
        }
        pMSAppInfo.copyMainPkgInfo(e84Var);
        if (e84Var.h == 1) {
            pMSAppInfo.setOrientation(pi2.i().v(e84Var.g, e84Var.i));
        } else {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, f84 f84Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, f84Var) == null) || pMSAppInfo == null || f84Var == null) {
            return;
        }
        pMSAppInfo.copySubPkgInfo(f84Var);
        if (f84Var.h == 0) {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static ab3 m(d84 d84Var, x64 x64Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, d84Var, x64Var)) == null) {
            if (d84Var == null) {
                ab3 ab3Var = new ab3();
                ab3Var.k(11L);
                ab3Var.i(2320L);
                ab3Var.f("pkg info is empty");
                eb3.a().f(ab3Var);
                return ab3Var;
            }
            File file = new File(d84Var.a);
            int i2 = d84Var.h;
            if (i2 == 1) {
                i = pi2.g().a(d84Var.g, String.valueOf(d84Var.i));
                if (i == null) {
                    ab3 ab3Var2 = new ab3();
                    ab3Var2.k(11L);
                    ab3Var2.i(2320L);
                    ab3Var2.f("获取解压目录失败");
                    eb3.a().f(ab3Var2);
                    return ab3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = di2.e.i(d84Var.g, String.valueOf(d84Var.i));
            } else {
                ab3 ab3Var3 = new ab3();
                ab3Var3.k(11L);
                ab3Var3.i(2320L);
                ab3Var3.f("pkh category illegal");
                eb3.a().f(ab3Var3);
                return ab3Var3;
            }
            if (!file.exists()) {
                ab3 ab3Var4 = new ab3();
                ab3Var4.k(11L);
                ab3Var4.i(2320L);
                ab3Var4.f("解压失败：包不存在");
                eb3.a().f(ab3Var4);
                return ab3Var4;
            } else if (i.isFile() && !i.delete()) {
                hw1.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                ab3 ab3Var5 = new ab3();
                ab3Var5.k(11L);
                ab3Var5.i(2320L);
                ab3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                eb3.a().f(ab3Var5);
                return ab3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                ab3 ab3Var6 = new ab3();
                ab3Var6.k(11L);
                ab3Var6.i(2320L);
                ab3Var6.f("解压失败：解压文件夹创建失败");
                eb3.a().f(ab3Var6);
                return ab3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, x64Var).b) {
                    return null;
                }
                b n = n(file, i, x64Var);
                if (n.b) {
                    w53.a(x64Var, d84Var.h, true);
                    return null;
                }
                w53.a(x64Var, d84Var.h, false);
                hw1.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                kf4.L(i);
                ab3 ab3Var7 = new ab3();
                int i3 = n.a;
                if (i3 == 0) {
                    ab3Var7.k(11L);
                    ab3Var7.i(2320L);
                    ab3Var7.f("unzip failed");
                } else if (i3 != 1 && i3 != 2) {
                    ab3Var7.k(4L);
                    ab3Var7.i(7L);
                    ab3Var7.f("Unkown bundle type");
                } else {
                    ab3Var7.k(11L);
                    ab3Var7.i(2330L);
                    ab3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                }
                eb3.a().f(ab3Var7);
                return ab3Var7;
            }
        }
        return (ab3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull x64 x64Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, x64Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            gi2.c j = gi2.j(file);
            int i = 0;
            if (j.b != -1) {
                x64Var.n("670", "package_start_decrypt");
                x64Var.n("770", "na_package_start_decrypt");
                gi2.b d = gi2.d(j.a, file2, j.b);
                x64Var.n("670", "package_end_decrypt");
                x64Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                x64Var.n("670", "package_start_unzip");
                x64Var.n("770", "na_package_start_unzip");
                boolean U = kf4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = kf4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        i63 i63Var = new i63();
                        ab3 ab3Var = new ab3();
                        ab3Var.k(4L);
                        ab3Var.i(52L);
                        i63Var.p(ab3Var);
                        i63Var.l("path", file2.getAbsolutePath());
                        i63Var.l("eMsg", "unzip files not match zip content");
                        i63Var.l("decryptType", String.valueOf(j.b));
                        i63Var.l("stack", bd3.z(30));
                        a63.R(i63Var);
                    }
                }
                x64Var.n("670", "package_end_unzip");
                x64Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                gi2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            b74.a(x64Var, bundle, "event_download_package_type");
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
            zz2.u(pMSAppInfo.appId, "", hc3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            zz2.t("", hc3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            zz2.s(pMSAppInfo.appId, hc3.d(pMSAppInfo.domains));
        }
        if (TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            return;
        }
        zz2.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
    }
}
