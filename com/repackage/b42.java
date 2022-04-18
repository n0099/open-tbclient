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
import com.repackage.fj2;
import com.repackage.ij2;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes5.dex */
public final class b42 {
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
                mg4.j(new File(filesDir, "aiapps_zip"));
                mg4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                for (File file2 : listFiles) {
                    long lastModified = file2.lastModified();
                    if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                        mg4.L(file2);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755877039, "Lcom/repackage/b42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755877039, "Lcom/repackage/b42;");
                return;
            }
        }
        a = tg1.a;
        b = false;
    }

    public b42() {
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

    public static cc3 a(ReadableByteChannel readableByteChannel, String str, z74 z74Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, z74Var)) == null) {
            if (readableByteChannel == null) {
                cc3 cc3Var = new cc3();
                cc3Var.k(11L);
                cc3Var.i(2300L);
                cc3Var.f("empty source");
                gc3.a().f(cc3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + cc3Var);
                }
                return cc3Var;
            }
            z74Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            z74Var.n("770", "na_pms_start_check_sign");
            if (wd3.d(readableByteChannel, str, new qe3())) {
                z74Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                z74Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            cc3 cc3Var2 = new cc3();
            cc3Var2.k(11L);
            cc3Var2.i(2300L);
            cc3Var2.f("check zip file sign fail.");
            gc3.a().f(cc3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + cc3Var2);
            }
            return cc3Var2;
        }
        return (cc3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable f94 f94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, f94Var)) == null) {
            if (f94Var == null || TextUtils.isEmpty(f94Var.a)) {
                return false;
            }
            File file = new File(f94Var.a);
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
        synchronized (b42.class) {
            if (b) {
                return;
            }
            b = true;
            dd3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? fj2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? rj2.g().c() : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? rj2.g().c() : (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? fj2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? fj2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? rj2.g().c() : (String) invokeV.objValue;
    }

    public static boolean j(b94 b94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, b94Var)) == null) {
            if (b94Var == null) {
                return false;
            }
            int i = b94Var.a;
            return i == 1013 || i == 1015;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, g94 g94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, g94Var) == null) || pMSAppInfo == null || g94Var == null) {
            return;
        }
        pMSAppInfo.copyMainPkgInfo(g94Var);
        if (g94Var.h == 1) {
            pMSAppInfo.setOrientation(rj2.i().v(g94Var.g, g94Var.i));
        } else {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, h94 h94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, h94Var) == null) || pMSAppInfo == null || h94Var == null) {
            return;
        }
        pMSAppInfo.copySubPkgInfo(h94Var);
        if (h94Var.h == 0) {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static cc3 m(f94 f94Var, z74 z74Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, f94Var, z74Var)) == null) {
            if (f94Var == null) {
                cc3 cc3Var = new cc3();
                cc3Var.k(11L);
                cc3Var.i(2320L);
                cc3Var.f("pkg info is empty");
                gc3.a().f(cc3Var);
                return cc3Var;
            }
            File file = new File(f94Var.a);
            int i2 = f94Var.h;
            if (i2 == 1) {
                i = rj2.g().a(f94Var.g, String.valueOf(f94Var.i));
                if (i == null) {
                    cc3 cc3Var2 = new cc3();
                    cc3Var2.k(11L);
                    cc3Var2.i(2320L);
                    cc3Var2.f("获取解压目录失败");
                    gc3.a().f(cc3Var2);
                    return cc3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = fj2.e.i(f94Var.g, String.valueOf(f94Var.i));
            } else {
                cc3 cc3Var3 = new cc3();
                cc3Var3.k(11L);
                cc3Var3.i(2320L);
                cc3Var3.f("pkh category illegal");
                gc3.a().f(cc3Var3);
                return cc3Var3;
            }
            if (!file.exists()) {
                cc3 cc3Var4 = new cc3();
                cc3Var4.k(11L);
                cc3Var4.i(2320L);
                cc3Var4.f("解压失败：包不存在");
                gc3.a().f(cc3Var4);
                return cc3Var4;
            } else if (i.isFile() && !i.delete()) {
                jx1.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                cc3 cc3Var5 = new cc3();
                cc3Var5.k(11L);
                cc3Var5.i(2320L);
                cc3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                gc3.a().f(cc3Var5);
                return cc3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                cc3 cc3Var6 = new cc3();
                cc3Var6.k(11L);
                cc3Var6.i(2320L);
                cc3Var6.f("解压失败：解压文件夹创建失败");
                gc3.a().f(cc3Var6);
                return cc3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, z74Var).b) {
                    return null;
                }
                b n = n(file, i, z74Var);
                if (n.b) {
                    y63.a(z74Var, f94Var.h, true);
                    return null;
                }
                y63.a(z74Var, f94Var.h, false);
                jx1.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                mg4.L(i);
                cc3 cc3Var7 = new cc3();
                int i3 = n.a;
                if (i3 == 0) {
                    cc3Var7.k(11L);
                    cc3Var7.i(2320L);
                    cc3Var7.f("unzip failed");
                } else if (i3 != 1 && i3 != 2) {
                    cc3Var7.k(4L);
                    cc3Var7.i(7L);
                    cc3Var7.f("Unkown bundle type");
                } else {
                    cc3Var7.k(11L);
                    cc3Var7.i(2330L);
                    cc3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                }
                gc3.a().f(cc3Var7);
                return cc3Var7;
            }
        }
        return (cc3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull z74 z74Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, z74Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            ij2.c j = ij2.j(file);
            int i = 0;
            if (j.b != -1) {
                z74Var.n("670", "package_start_decrypt");
                z74Var.n("770", "na_package_start_decrypt");
                ij2.b d = ij2.d(j.a, file2, j.b);
                z74Var.n("670", "package_end_decrypt");
                z74Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                z74Var.n("670", "package_start_unzip");
                z74Var.n("770", "na_package_start_unzip");
                boolean U = mg4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = mg4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        k73 k73Var = new k73();
                        cc3 cc3Var = new cc3();
                        cc3Var.k(4L);
                        cc3Var.i(52L);
                        k73Var.p(cc3Var);
                        k73Var.l("path", file2.getAbsolutePath());
                        k73Var.l("eMsg", "unzip files not match zip content");
                        k73Var.l("decryptType", String.valueOf(j.b));
                        k73Var.l("stack", de3.z(30));
                        c73.R(k73Var);
                    }
                }
                z74Var.n("670", "package_end_unzip");
                z74Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                ij2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            d84.a(z74Var, bundle, "event_download_package_type");
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
            b13.u(pMSAppInfo.appId, "", jd3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            b13.t("", jd3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            b13.s(pMSAppInfo.appId, jd3.d(pMSAppInfo.domains));
        }
        if (TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            return;
        }
        b13.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
    }
}
