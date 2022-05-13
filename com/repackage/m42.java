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
import com.repackage.qj2;
import com.repackage.tj2;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes6.dex */
public final class m42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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
                xg4.j(new File(filesDir, "aiapps_zip"));
                xg4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                for (File file2 : listFiles) {
                    long lastModified = file2.lastModified();
                    if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                        xg4.L(file2);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755549338, "Lcom/repackage/m42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755549338, "Lcom/repackage/m42;");
                return;
            }
        }
        a = eh1.a;
        b = false;
    }

    public m42() {
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

    public static nc3 a(ReadableByteChannel readableByteChannel, String str, k84 k84Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, k84Var)) == null) {
            if (readableByteChannel == null) {
                nc3 nc3Var = new nc3();
                nc3Var.k(11L);
                nc3Var.i(2300L);
                nc3Var.f("empty source");
                rc3.a().f(nc3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + nc3Var);
                }
                return nc3Var;
            }
            k84Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            k84Var.n("770", "na_pms_start_check_sign");
            if (he3.d(readableByteChannel, str, new bf3())) {
                k84Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                k84Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            nc3 nc3Var2 = new nc3();
            nc3Var2.k(11L);
            nc3Var2.i(2300L);
            nc3Var2.f("check zip file sign fail.");
            rc3.a().f(nc3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + nc3Var2);
            }
            return nc3Var2;
        }
        return (nc3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable q94 q94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, q94Var)) == null) {
            if (q94Var == null || TextUtils.isEmpty(q94Var.a)) {
                return false;
            }
            File file = new File(q94Var.a);
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
        synchronized (m42.class) {
            if (b) {
                return;
            }
            b = true;
            od3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? qj2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? ck2.g().c() : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? ck2.g().c() : (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? qj2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? qj2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? ck2.g().c() : (String) invokeV.objValue;
    }

    public static boolean j(m94 m94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, m94Var)) == null) {
            if (m94Var == null) {
                return false;
            }
            int i = m94Var.a;
            return i == 1013 || i == 1015;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, r94 r94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, r94Var) == null) || pMSAppInfo == null || r94Var == null) {
            return;
        }
        pMSAppInfo.copyMainPkgInfo(r94Var);
        if (r94Var.h == 1) {
            pMSAppInfo.setOrientation(ck2.i().v(r94Var.g, r94Var.i));
        } else {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, s94 s94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, s94Var) == null) || pMSAppInfo == null || s94Var == null) {
            return;
        }
        pMSAppInfo.copySubPkgInfo(s94Var);
        if (s94Var.h == 0) {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static nc3 m(q94 q94Var, k84 k84Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, q94Var, k84Var)) == null) {
            if (q94Var == null) {
                nc3 nc3Var = new nc3();
                nc3Var.k(11L);
                nc3Var.i(2320L);
                nc3Var.f("pkg info is empty");
                rc3.a().f(nc3Var);
                return nc3Var;
            }
            File file = new File(q94Var.a);
            int i2 = q94Var.h;
            if (i2 == 1) {
                i = ck2.g().a(q94Var.g, String.valueOf(q94Var.i));
                if (i == null) {
                    nc3 nc3Var2 = new nc3();
                    nc3Var2.k(11L);
                    nc3Var2.i(2320L);
                    nc3Var2.f("获取解压目录失败");
                    rc3.a().f(nc3Var2);
                    return nc3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = qj2.e.i(q94Var.g, String.valueOf(q94Var.i));
            } else {
                nc3 nc3Var3 = new nc3();
                nc3Var3.k(11L);
                nc3Var3.i(2320L);
                nc3Var3.f("pkh category illegal");
                rc3.a().f(nc3Var3);
                return nc3Var3;
            }
            if (!file.exists()) {
                nc3 nc3Var4 = new nc3();
                nc3Var4.k(11L);
                nc3Var4.i(2320L);
                nc3Var4.f("解压失败：包不存在");
                rc3.a().f(nc3Var4);
                return nc3Var4;
            } else if (i.isFile() && !i.delete()) {
                ux1.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                nc3 nc3Var5 = new nc3();
                nc3Var5.k(11L);
                nc3Var5.i(2320L);
                nc3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                rc3.a().f(nc3Var5);
                return nc3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                nc3 nc3Var6 = new nc3();
                nc3Var6.k(11L);
                nc3Var6.i(2320L);
                nc3Var6.f("解压失败：解压文件夹创建失败");
                rc3.a().f(nc3Var6);
                return nc3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, k84Var).b) {
                    return null;
                }
                b n = n(file, i, k84Var);
                if (n.b) {
                    j73.a(k84Var, q94Var.h, true);
                    return null;
                }
                j73.a(k84Var, q94Var.h, false);
                ux1.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                xg4.L(i);
                nc3 nc3Var7 = new nc3();
                int i3 = n.a;
                if (i3 == 0) {
                    nc3Var7.k(11L);
                    nc3Var7.i(2320L);
                    nc3Var7.f("unzip failed");
                } else if (i3 != 1 && i3 != 2) {
                    nc3Var7.k(4L);
                    nc3Var7.i(7L);
                    nc3Var7.f("Unkown bundle type");
                } else {
                    nc3Var7.k(11L);
                    nc3Var7.i(2330L);
                    nc3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                }
                rc3.a().f(nc3Var7);
                return nc3Var7;
            }
        }
        return (nc3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull k84 k84Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, k84Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            tj2.c j = tj2.j(file);
            int i = 0;
            if (j.b != -1) {
                k84Var.n("670", "package_start_decrypt");
                k84Var.n("770", "na_package_start_decrypt");
                tj2.b d = tj2.d(j.a, file2, j.b);
                k84Var.n("670", "package_end_decrypt");
                k84Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                k84Var.n("670", "package_start_unzip");
                k84Var.n("770", "na_package_start_unzip");
                boolean U = xg4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = xg4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        v73 v73Var = new v73();
                        nc3 nc3Var = new nc3();
                        nc3Var.k(4L);
                        nc3Var.i(52L);
                        v73Var.p(nc3Var);
                        v73Var.l("path", file2.getAbsolutePath());
                        v73Var.l("eMsg", "unzip files not match zip content");
                        v73Var.l("decryptType", String.valueOf(j.b));
                        v73Var.l("stack", oe3.z(30));
                        n73.R(v73Var);
                    }
                }
                k84Var.n("670", "package_end_unzip");
                k84Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                tj2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            o84.a(k84Var, bundle, "event_download_package_type");
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
            m13.u(pMSAppInfo.appId, "", ud3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            m13.t("", ud3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            m13.s(pMSAppInfo.appId, ud3.d(pMSAppInfo.domains));
        }
        if (TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            return;
        }
        m13.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
    }
}
