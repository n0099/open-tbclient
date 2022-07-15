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
import com.repackage.dj2;
import com.repackage.gj2;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes7.dex */
public final class z32 {
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
                jg4.j(new File(filesDir, "aiapps_zip"));
                jg4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                for (File file2 : listFiles) {
                    long lastModified = file2.lastModified();
                    if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                        jg4.L(file2);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755163016, "Lcom/repackage/z32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755163016, "Lcom/repackage/z32;");
                return;
            }
        }
        a = rg1.a;
        b = false;
    }

    public z32() {
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

    public static ac3 a(ReadableByteChannel readableByteChannel, String str, x74 x74Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, x74Var)) == null) {
            if (readableByteChannel == null) {
                ac3 ac3Var = new ac3();
                ac3Var.k(11L);
                ac3Var.i(2300L);
                ac3Var.f("empty source");
                ec3.a().f(ac3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + ac3Var);
                }
                return ac3Var;
            }
            x74Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            x74Var.n("770", "na_pms_start_check_sign");
            if (ud3.d(readableByteChannel, str, new oe3())) {
                x74Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                x74Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            ac3 ac3Var2 = new ac3();
            ac3Var2.k(11L);
            ac3Var2.i(2300L);
            ac3Var2.f("check zip file sign fail.");
            ec3.a().f(ac3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + ac3Var2);
            }
            return ac3Var2;
        }
        return (ac3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable d94 d94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, d94Var)) == null) {
            if (d94Var == null || TextUtils.isEmpty(d94Var.a)) {
                return false;
            }
            File file = new File(d94Var.a);
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
        synchronized (z32.class) {
            if (b) {
                return;
            }
            b = true;
            bd3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? dj2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? pj2.g().c() : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? pj2.g().c() : (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? dj2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? dj2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? pj2.g().c() : (String) invokeV.objValue;
    }

    public static boolean j(z84 z84Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, z84Var)) == null) {
            if (z84Var == null) {
                return false;
            }
            int i = z84Var.a;
            return i == 1013 || i == 1015;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, e94 e94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, e94Var) == null) || pMSAppInfo == null || e94Var == null) {
            return;
        }
        pMSAppInfo.copyMainPkgInfo(e94Var);
        if (e94Var.h == 1) {
            pMSAppInfo.setOrientation(pj2.i().u(e94Var.g, e94Var.i));
        } else {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, f94 f94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, f94Var) == null) || pMSAppInfo == null || f94Var == null) {
            return;
        }
        pMSAppInfo.copySubPkgInfo(f94Var);
        if (f94Var.h == 0) {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static ac3 m(d94 d94Var, x74 x74Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, d94Var, x74Var)) == null) {
            if (d94Var == null) {
                ac3 ac3Var = new ac3();
                ac3Var.k(11L);
                ac3Var.i(2320L);
                ac3Var.f("pkg info is empty");
                ec3.a().f(ac3Var);
                return ac3Var;
            }
            File file = new File(d94Var.a);
            int i2 = d94Var.h;
            if (i2 == 1) {
                i = pj2.g().a(d94Var.g, String.valueOf(d94Var.i));
                if (i == null) {
                    ac3 ac3Var2 = new ac3();
                    ac3Var2.k(11L);
                    ac3Var2.i(2320L);
                    ac3Var2.f("获取解压目录失败");
                    ec3.a().f(ac3Var2);
                    return ac3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = dj2.e.i(d94Var.g, String.valueOf(d94Var.i));
            } else {
                ac3 ac3Var3 = new ac3();
                ac3Var3.k(11L);
                ac3Var3.i(2320L);
                ac3Var3.f("pkh category illegal");
                ec3.a().f(ac3Var3);
                return ac3Var3;
            }
            if (!file.exists()) {
                ac3 ac3Var4 = new ac3();
                ac3Var4.k(11L);
                ac3Var4.i(2320L);
                ac3Var4.f("解压失败：包不存在");
                ec3.a().f(ac3Var4);
                return ac3Var4;
            } else if (i.isFile() && !i.delete()) {
                hx1.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                ac3 ac3Var5 = new ac3();
                ac3Var5.k(11L);
                ac3Var5.i(2320L);
                ac3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                ec3.a().f(ac3Var5);
                return ac3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                ac3 ac3Var6 = new ac3();
                ac3Var6.k(11L);
                ac3Var6.i(2320L);
                ac3Var6.f("解压失败：解压文件夹创建失败");
                ec3.a().f(ac3Var6);
                return ac3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, x74Var).b) {
                    return null;
                }
                b n = n(file, i, x74Var);
                if (n.b) {
                    w63.a(x74Var, d94Var.h, true);
                    return null;
                }
                w63.a(x74Var, d94Var.h, false);
                hx1.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                jg4.L(i);
                ac3 ac3Var7 = new ac3();
                int i3 = n.a;
                if (i3 == 0) {
                    ac3Var7.k(11L);
                    ac3Var7.i(2320L);
                    ac3Var7.f("unzip failed");
                } else if (i3 != 1 && i3 != 2) {
                    ac3Var7.k(4L);
                    ac3Var7.i(7L);
                    ac3Var7.f("Unkown bundle type");
                } else {
                    ac3Var7.k(11L);
                    ac3Var7.i(2330L);
                    ac3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                }
                ec3.a().f(ac3Var7);
                return ac3Var7;
            }
        }
        return (ac3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull x74 x74Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, x74Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            gj2.c j = gj2.j(file);
            int i = 0;
            if (j.b != -1) {
                x74Var.n("670", "package_start_decrypt");
                x74Var.n("770", "na_package_start_decrypt");
                gj2.b d = gj2.d(j.a, file2, j.b);
                x74Var.n("670", "package_end_decrypt");
                x74Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                x74Var.n("670", "package_start_unzip");
                x74Var.n("770", "na_package_start_unzip");
                boolean U = jg4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = jg4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        i73 i73Var = new i73();
                        ac3 ac3Var = new ac3();
                        ac3Var.k(4L);
                        ac3Var.i(52L);
                        i73Var.p(ac3Var);
                        i73Var.l("path", file2.getAbsolutePath());
                        i73Var.l("eMsg", "unzip files not match zip content");
                        i73Var.l("decryptType", String.valueOf(j.b));
                        i73Var.l("stack", be3.z(30));
                        a73.R(i73Var);
                    }
                }
                x74Var.n("670", "package_end_unzip");
                x74Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                gj2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            b84.a(x74Var, bundle, "event_download_package_type");
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
            z03.u(pMSAppInfo.appId, "", hd3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            z03.t("", hd3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            z03.s(pMSAppInfo.appId, hd3.d(pMSAppInfo.domains));
        }
        if (TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            return;
        }
        z03.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
    }
}
