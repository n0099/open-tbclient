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
import com.repackage.ej2;
import com.repackage.hj2;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes5.dex */
public final class a42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
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
                kg4.j(new File(filesDir, "aiapps_zip"));
                kg4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                for (File file2 : listFiles) {
                    long lastModified = file2.lastModified();
                    if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                        kg4.L(file2);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755906830, "Lcom/repackage/a42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755906830, "Lcom/repackage/a42;");
                return;
            }
        }
        a = sg1.a;
        b = false;
    }

    public a42() {
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

    public static bc3 a(ReadableByteChannel readableByteChannel, String str, y74 y74Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, y74Var)) == null) {
            if (readableByteChannel == null) {
                bc3 bc3Var = new bc3();
                bc3Var.k(11L);
                bc3Var.i(2300L);
                bc3Var.f("empty source");
                fc3.a().f(bc3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + bc3Var);
                }
                return bc3Var;
            }
            y74Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            y74Var.n("770", "na_pms_start_check_sign");
            if (vd3.d(readableByteChannel, str, new pe3())) {
                y74Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                y74Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            bc3 bc3Var2 = new bc3();
            bc3Var2.k(11L);
            bc3Var2.i(2300L);
            bc3Var2.f("check zip file sign fail.");
            fc3.a().f(bc3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + bc3Var2);
            }
            return bc3Var2;
        }
        return (bc3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable e94 e94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, e94Var)) == null) {
            if (e94Var == null || TextUtils.isEmpty(e94Var.a)) {
                return false;
            }
            File file = new File(e94Var.a);
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
        synchronized (a42.class) {
            if (b) {
                return;
            }
            b = true;
            cd3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? ej2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? qj2.g().c() : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? qj2.g().c() : (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? ej2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? ej2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? qj2.g().c() : (String) invokeV.objValue;
    }

    public static boolean j(a94 a94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, a94Var)) == null) {
            if (a94Var == null) {
                return false;
            }
            int i = a94Var.a;
            return i == 1013 || i == 1015;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, f94 f94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, f94Var) == null) || pMSAppInfo == null || f94Var == null) {
            return;
        }
        pMSAppInfo.copyMainPkgInfo(f94Var);
        if (f94Var.h == 1) {
            pMSAppInfo.setOrientation(qj2.i().u(f94Var.g, f94Var.i));
        } else {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, g94 g94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, g94Var) == null) || pMSAppInfo == null || g94Var == null) {
            return;
        }
        pMSAppInfo.copySubPkgInfo(g94Var);
        if (g94Var.h == 0) {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static bc3 m(e94 e94Var, y74 y74Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, e94Var, y74Var)) == null) {
            if (e94Var == null) {
                bc3 bc3Var = new bc3();
                bc3Var.k(11L);
                bc3Var.i(2320L);
                bc3Var.f("pkg info is empty");
                fc3.a().f(bc3Var);
                return bc3Var;
            }
            File file = new File(e94Var.a);
            int i2 = e94Var.h;
            if (i2 == 1) {
                i = qj2.g().a(e94Var.g, String.valueOf(e94Var.i));
                if (i == null) {
                    bc3 bc3Var2 = new bc3();
                    bc3Var2.k(11L);
                    bc3Var2.i(2320L);
                    bc3Var2.f("获取解压目录失败");
                    fc3.a().f(bc3Var2);
                    return bc3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = ej2.e.i(e94Var.g, String.valueOf(e94Var.i));
            } else {
                bc3 bc3Var3 = new bc3();
                bc3Var3.k(11L);
                bc3Var3.i(2320L);
                bc3Var3.f("pkh category illegal");
                fc3.a().f(bc3Var3);
                return bc3Var3;
            }
            if (!file.exists()) {
                bc3 bc3Var4 = new bc3();
                bc3Var4.k(11L);
                bc3Var4.i(2320L);
                bc3Var4.f("解压失败：包不存在");
                fc3.a().f(bc3Var4);
                return bc3Var4;
            } else if (i.isFile() && !i.delete()) {
                ix1.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                bc3 bc3Var5 = new bc3();
                bc3Var5.k(11L);
                bc3Var5.i(2320L);
                bc3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                fc3.a().f(bc3Var5);
                return bc3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                bc3 bc3Var6 = new bc3();
                bc3Var6.k(11L);
                bc3Var6.i(2320L);
                bc3Var6.f("解压失败：解压文件夹创建失败");
                fc3.a().f(bc3Var6);
                return bc3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, y74Var).b) {
                    return null;
                }
                b n = n(file, i, y74Var);
                if (n.b) {
                    x63.a(y74Var, e94Var.h, true);
                    return null;
                }
                x63.a(y74Var, e94Var.h, false);
                ix1.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                kg4.L(i);
                bc3 bc3Var7 = new bc3();
                int i3 = n.a;
                if (i3 == 0) {
                    bc3Var7.k(11L);
                    bc3Var7.i(2320L);
                    bc3Var7.f("unzip failed");
                } else if (i3 != 1 && i3 != 2) {
                    bc3Var7.k(4L);
                    bc3Var7.i(7L);
                    bc3Var7.f("Unkown bundle type");
                } else {
                    bc3Var7.k(11L);
                    bc3Var7.i(2330L);
                    bc3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                }
                fc3.a().f(bc3Var7);
                return bc3Var7;
            }
        }
        return (bc3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull y74 y74Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, y74Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            hj2.c j = hj2.j(file);
            int i = 0;
            if (j.b != -1) {
                y74Var.n("670", "package_start_decrypt");
                y74Var.n("770", "na_package_start_decrypt");
                hj2.b d = hj2.d(j.a, file2, j.b);
                y74Var.n("670", "package_end_decrypt");
                y74Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                y74Var.n("670", "package_start_unzip");
                y74Var.n("770", "na_package_start_unzip");
                boolean U = kg4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = kg4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        j73 j73Var = new j73();
                        bc3 bc3Var = new bc3();
                        bc3Var.k(4L);
                        bc3Var.i(52L);
                        j73Var.p(bc3Var);
                        j73Var.l("path", file2.getAbsolutePath());
                        j73Var.l("eMsg", "unzip files not match zip content");
                        j73Var.l("decryptType", String.valueOf(j.b));
                        j73Var.l("stack", ce3.z(30));
                        b73.R(j73Var);
                    }
                }
                y74Var.n("670", "package_end_unzip");
                y74Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                hj2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            c84.a(y74Var, bundle, "event_download_package_type");
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
            a13.u(pMSAppInfo.appId, "", id3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            a13.t("", id3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            a13.s(pMSAppInfo.appId, id3.d(pMSAppInfo.domains));
        }
        if (TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            return;
        }
        a13.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
    }
}
