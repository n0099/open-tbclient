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
import com.repackage.oi2;
import com.repackage.ri2;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes6.dex */
public final class k32 {
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
                uf4.j(new File(filesDir, "aiapps_zip"));
                uf4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                for (File file2 : listFiles) {
                    long lastModified = file2.lastModified();
                    if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                        uf4.L(file2);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755609881, "Lcom/repackage/k32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755609881, "Lcom/repackage/k32;");
                return;
            }
        }
        a = cg1.a;
        b = false;
    }

    public k32() {
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

    public static lb3 a(ReadableByteChannel readableByteChannel, String str, i74 i74Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, i74Var)) == null) {
            if (readableByteChannel == null) {
                lb3 lb3Var = new lb3();
                lb3Var.k(11L);
                lb3Var.i(2300L);
                lb3Var.f("empty source");
                pb3.a().f(lb3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + lb3Var);
                }
                return lb3Var;
            }
            i74Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            i74Var.n("770", "na_pms_start_check_sign");
            if (fd3.d(readableByteChannel, str, new zd3())) {
                i74Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                i74Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            lb3 lb3Var2 = new lb3();
            lb3Var2.k(11L);
            lb3Var2.i(2300L);
            lb3Var2.f("check zip file sign fail.");
            pb3.a().f(lb3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + lb3Var2);
            }
            return lb3Var2;
        }
        return (lb3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable o84 o84Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, o84Var)) == null) {
            if (o84Var == null || TextUtils.isEmpty(o84Var.a)) {
                return false;
            }
            File file = new File(o84Var.a);
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
        synchronized (k32.class) {
            if (b) {
                return;
            }
            b = true;
            mc3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? oi2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? aj2.g().c() : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? aj2.g().c() : (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? oi2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? oi2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? aj2.g().c() : (String) invokeV.objValue;
    }

    public static boolean j(k84 k84Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, k84Var)) == null) {
            if (k84Var == null) {
                return false;
            }
            int i = k84Var.a;
            return i == 1013 || i == 1015;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, p84 p84Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, p84Var) == null) || pMSAppInfo == null || p84Var == null) {
            return;
        }
        pMSAppInfo.copyMainPkgInfo(p84Var);
        if (p84Var.h == 1) {
            pMSAppInfo.setOrientation(aj2.i().v(p84Var.g, p84Var.i));
        } else {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, q84 q84Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, q84Var) == null) || pMSAppInfo == null || q84Var == null) {
            return;
        }
        pMSAppInfo.copySubPkgInfo(q84Var);
        if (q84Var.h == 0) {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static lb3 m(o84 o84Var, i74 i74Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, o84Var, i74Var)) == null) {
            if (o84Var == null) {
                lb3 lb3Var = new lb3();
                lb3Var.k(11L);
                lb3Var.i(2320L);
                lb3Var.f("pkg info is empty");
                pb3.a().f(lb3Var);
                return lb3Var;
            }
            File file = new File(o84Var.a);
            int i2 = o84Var.h;
            if (i2 == 1) {
                i = aj2.g().a(o84Var.g, String.valueOf(o84Var.i));
                if (i == null) {
                    lb3 lb3Var2 = new lb3();
                    lb3Var2.k(11L);
                    lb3Var2.i(2320L);
                    lb3Var2.f("获取解压目录失败");
                    pb3.a().f(lb3Var2);
                    return lb3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = oi2.e.i(o84Var.g, String.valueOf(o84Var.i));
            } else {
                lb3 lb3Var3 = new lb3();
                lb3Var3.k(11L);
                lb3Var3.i(2320L);
                lb3Var3.f("pkh category illegal");
                pb3.a().f(lb3Var3);
                return lb3Var3;
            }
            if (!file.exists()) {
                lb3 lb3Var4 = new lb3();
                lb3Var4.k(11L);
                lb3Var4.i(2320L);
                lb3Var4.f("解压失败：包不存在");
                pb3.a().f(lb3Var4);
                return lb3Var4;
            } else if (i.isFile() && !i.delete()) {
                sw1.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                lb3 lb3Var5 = new lb3();
                lb3Var5.k(11L);
                lb3Var5.i(2320L);
                lb3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                pb3.a().f(lb3Var5);
                return lb3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                lb3 lb3Var6 = new lb3();
                lb3Var6.k(11L);
                lb3Var6.i(2320L);
                lb3Var6.f("解压失败：解压文件夹创建失败");
                pb3.a().f(lb3Var6);
                return lb3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, i74Var).b) {
                    return null;
                }
                b n = n(file, i, i74Var);
                if (n.b) {
                    h63.a(i74Var, o84Var.h, true);
                    return null;
                }
                h63.a(i74Var, o84Var.h, false);
                sw1.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                uf4.L(i);
                lb3 lb3Var7 = new lb3();
                int i3 = n.a;
                if (i3 == 0) {
                    lb3Var7.k(11L);
                    lb3Var7.i(2320L);
                    lb3Var7.f("unzip failed");
                } else if (i3 != 1 && i3 != 2) {
                    lb3Var7.k(4L);
                    lb3Var7.i(7L);
                    lb3Var7.f("Unkown bundle type");
                } else {
                    lb3Var7.k(11L);
                    lb3Var7.i(2330L);
                    lb3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                }
                pb3.a().f(lb3Var7);
                return lb3Var7;
            }
        }
        return (lb3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull i74 i74Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, i74Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            ri2.c j = ri2.j(file);
            int i = 0;
            if (j.b != -1) {
                i74Var.n("670", "package_start_decrypt");
                i74Var.n("770", "na_package_start_decrypt");
                ri2.b d = ri2.d(j.a, file2, j.b);
                i74Var.n("670", "package_end_decrypt");
                i74Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                i74Var.n("670", "package_start_unzip");
                i74Var.n("770", "na_package_start_unzip");
                boolean U = uf4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = uf4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        t63 t63Var = new t63();
                        lb3 lb3Var = new lb3();
                        lb3Var.k(4L);
                        lb3Var.i(52L);
                        t63Var.p(lb3Var);
                        t63Var.l("path", file2.getAbsolutePath());
                        t63Var.l("eMsg", "unzip files not match zip content");
                        t63Var.l("decryptType", String.valueOf(j.b));
                        t63Var.l("stack", md3.z(30));
                        l63.R(t63Var);
                    }
                }
                i74Var.n("670", "package_end_unzip");
                i74Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                ri2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            m74.a(i74Var, bundle, "event_download_package_type");
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
            k03.u(pMSAppInfo.appId, "", sc3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            k03.t("", sc3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            k03.s(pMSAppInfo.appId, sc3.d(pMSAppInfo.domains));
        }
        if (TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            return;
        }
        k03.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
    }
}
