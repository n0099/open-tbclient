package d.a.n0.a.h0.m.r;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a1.e;
import d.a.n0.a.a1.h.a;
import d.a.n0.a.j2.i;
import d.a.n0.a.k;
import d.a.n0.a.q2.e;
import d.a.n0.a.v2.j0;
import d.a.n0.a.v2.q;
import d.a.n0.a.v2.q0;
import d.a.n0.a.v2.w;
import d.a.n0.n.f.h;
import d.a.n0.n.h.f;
import d.a.n0.n.h.g;
import d.a.n0.t.d;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45044a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f45045b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.n0.a.h0.m.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class RunnableC0753a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0753a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                d.K(new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_zip"));
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                for (File file2 : listFiles) {
                    long lastModified = file2.lastModified();
                    if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                        d.K(file2);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f45046a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f45047b;

        /* renamed from: c  reason: collision with root package name */
        public String f45048c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45046a = 0;
            this.f45047b = false;
            this.f45048c = "";
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(990045194, "Ld/a/n0/a/h0/m/r/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(990045194, "Ld/a/n0/a/h0/m/r/a;");
                return;
            }
        }
        f45044a = k.f45831a;
        f45045b = false;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static d.a.n0.a.q2.a a(ReadableByteChannel readableByteChannel, String str, d.a.n0.n.f.d dVar) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, dVar)) == null) {
            if (readableByteChannel == null) {
                d.a.n0.a.q2.a aVar = new d.a.n0.a.q2.a();
                aVar.j(11L);
                aVar.h(2300L);
                aVar.e("empty source");
                e.a().f(aVar);
                if (f45044a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + aVar);
                }
                return aVar;
            }
            dVar.n("670", "aiapp_aps_check_sign_start_timestamp");
            dVar.n("770", "na_pms_start_check_sign");
            if (j0.d(readableByteChannel, str, new d.a.n0.a.v2.a1.c())) {
                dVar.n("670", "aiapp_aps_check_sign_end_timestamp");
                dVar.n("770", "na_pms_end_check_sign");
                return null;
            }
            d.a.n0.a.q2.a aVar2 = new d.a.n0.a.q2.a();
            aVar2.j(11L);
            aVar2.h(2300L);
            aVar2.e("check zip file sign fail.");
            e.a().f(aVar2);
            if (f45044a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + aVar2);
            }
            return aVar2;
        }
        return (d.a.n0.a.q2.a) invokeLLL.objValue;
    }

    public static boolean b(@Nullable d.a.n0.n.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, eVar)) == null) {
            if (eVar == null || TextUtils.isEmpty(eVar.f50630a)) {
                return false;
            }
            File file = new File(eVar.f50630a);
            return file.exists() && file.isFile() && file.delete();
        }
        return invokeL.booleanValue;
    }

    @AnyThread
    public static void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || f45045b) {
            return;
        }
        synchronized (a.class) {
            if (f45045b) {
                return;
            }
            f45045b = true;
            q.j(new RunnableC0753a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? e.C0629e.h().getPath() : (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? d.a.n0.a.c1.b.g().c() : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? d.a.n0.a.c1.b.g().c() : (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? e.C0629e.h().getPath() : (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? e.C0629e.h().getPath() : (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? d.a.n0.a.c1.b.g().c() : (String) invokeV.objValue;
    }

    public static void j(PMSAppInfo pMSAppInfo, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, pMSAppInfo, fVar) == null) || pMSAppInfo == null || fVar == null) {
            return;
        }
        pMSAppInfo.copyMainPkgInfo(fVar);
        if (fVar.f50637h == 1) {
            pMSAppInfo.setOrientation(d.a.n0.a.c1.b.i().v(fVar.f50636g, fVar.f50638i));
        } else {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static void k(PMSAppInfo pMSAppInfo, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, gVar) == null) || pMSAppInfo == null || gVar == null) {
            return;
        }
        pMSAppInfo.copySubPkgInfo(gVar);
        if (gVar.f50637h == 0) {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static d.a.n0.a.q2.a l(d.a.n0.n.h.e eVar, d.a.n0.n.f.d dVar) {
        InterceptResult invokeLL;
        File i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, eVar, dVar)) == null) {
            if (eVar == null) {
                d.a.n0.a.q2.a aVar = new d.a.n0.a.q2.a();
                aVar.j(11L);
                aVar.h(2320L);
                aVar.e("pkg info is empty");
                d.a.n0.a.q2.e.a().f(aVar);
                return aVar;
            }
            File file = new File(eVar.f50630a);
            int i3 = eVar.f50637h;
            if (i3 == 1) {
                i2 = d.a.n0.a.c1.b.g().a(eVar.f50636g, String.valueOf(eVar.f50638i));
                if (i2 == null) {
                    d.a.n0.a.q2.a aVar2 = new d.a.n0.a.q2.a();
                    aVar2.j(11L);
                    aVar2.h(2320L);
                    aVar2.e("获取解压目录失败");
                    d.a.n0.a.q2.e.a().f(aVar2);
                    return aVar2;
                } else if (f45044a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i3 == 0) {
                i2 = e.C0629e.i(eVar.f50636g, String.valueOf(eVar.f50638i));
            } else {
                d.a.n0.a.q2.a aVar3 = new d.a.n0.a.q2.a();
                aVar3.j(11L);
                aVar3.h(2320L);
                aVar3.e("pkh category illegal");
                d.a.n0.a.q2.e.a().f(aVar3);
                return aVar3;
            }
            if (!file.exists()) {
                d.a.n0.a.q2.a aVar4 = new d.a.n0.a.q2.a();
                aVar4.j(11L);
                aVar4.h(2320L);
                aVar4.e("解压失败：包不存在");
                d.a.n0.a.q2.e.a().f(aVar4);
                return aVar4;
            } else if (i2.isFile() && !i2.delete()) {
                d.a.n0.a.e0.d.h("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i2.getAbsolutePath());
                d.a.n0.a.q2.a aVar5 = new d.a.n0.a.q2.a();
                aVar5.j(11L);
                aVar5.h(2320L);
                aVar5.e("解压失败：解压目录被文件占用，且无法删除");
                d.a.n0.a.q2.e.a().f(aVar5);
                return aVar5;
            } else if (!i2.exists() && !i2.mkdirs()) {
                if (f45044a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i2.getAbsolutePath());
                }
                d.a.n0.a.q2.a aVar6 = new d.a.n0.a.q2.a();
                aVar6.j(11L);
                aVar6.h(2320L);
                aVar6.e("解压失败：解压文件夹创建失败");
                d.a.n0.a.q2.e.a().f(aVar6);
                return aVar6;
            } else {
                if (f45044a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i2.getPath());
                }
                if (m(file, i2, dVar).f45047b) {
                    return null;
                }
                b m = m(file, i2, dVar);
                if (m.f45047b) {
                    i.a(dVar, eVar.f50637h, true);
                    return null;
                }
                i.a(dVar, eVar.f50637h, false);
                d.a.n0.a.e0.d.h("PkgDownloadUtil", "解压失败后删除解压目录: " + i2.getAbsolutePath());
                d.K(i2);
                d.a.n0.a.q2.a aVar7 = new d.a.n0.a.q2.a();
                int i4 = m.f45046a;
                if (i4 == 0) {
                    aVar7.j(11L);
                    aVar7.h(2320L);
                    aVar7.e("unzip failed");
                } else if (i4 != 1 && i4 != 2) {
                    aVar7.j(4L);
                    aVar7.h(7L);
                    aVar7.e("Unkown bundle type");
                } else {
                    aVar7.j(11L);
                    aVar7.h(2330L);
                    aVar7.e("decryt failed:" + m.f45048c + ", PkgType=" + m.f45046a);
                }
                d.a.n0.a.q2.e.a().f(aVar7);
                return aVar7;
            }
        }
        return (d.a.n0.a.q2.a) invokeLL.objValue;
    }

    @NonNull
    public static b m(@NonNull File file, @NonNull File file2, @NonNull d.a.n0.n.f.d dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, file, file2, dVar)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            a.b i2 = d.a.n0.a.a1.h.a.i(file);
            int i3 = 0;
            if (i2.f43347b != -1) {
                dVar.n("670", "package_start_decrypt");
                dVar.n("770", "na_package_start_decrypt");
                a.C0630a c2 = d.a.n0.a.a1.h.a.c(i2.f43346a, file2, i2.f43347b);
                dVar.n("670", "package_end_decrypt");
                dVar.n("770", "na_package_end_decrypt");
                bVar.f45047b = c2.f43344a;
                bVar.f45048c = c2.f43345b;
                i3 = i2.f43347b;
                bVar.f45046a = i3;
            } else {
                bVar.f45046a = 0;
                dVar.n("670", "package_start_unzip");
                dVar.n("770", "na_package_start_unzip");
                boolean T = d.T(file.getPath(), file2.getPath());
                bVar.f45047b = T;
                if (T) {
                    boolean A = d.A(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.f45047b = A;
                    if (!A) {
                        d.a.n0.a.j2.p.d dVar2 = new d.a.n0.a.j2.p.d();
                        d.a.n0.a.q2.a aVar = new d.a.n0.a.q2.a();
                        aVar.j(4L);
                        aVar.h(52L);
                        dVar2.p(aVar);
                        dVar2.l("path", file2.getAbsolutePath());
                        dVar2.l("eMsg", "unzip files not match zip content");
                        dVar2.l("decryptType", String.valueOf(i2.f43347b));
                        dVar2.l("stack", q0.z(30));
                        d.a.n0.a.j2.k.L(dVar2);
                    }
                }
                dVar.n("670", "package_end_unzip");
                dVar.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (f45044a) {
                d.a.n0.a.a1.h.a.g((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i3);
            h.a(dVar, bundle, "event_download_package_type");
            return bVar;
        }
        return (b) invokeLLL.objValue;
    }

    public static void n(@Nullable PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, null, pMSAppInfo) == null) || pMSAppInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
            d.a.n0.a.b2.a.c.u(pMSAppInfo.appId, "", w.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            d.a.n0.a.b2.a.c.t("", w.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            d.a.n0.a.b2.a.c.s(pMSAppInfo.appId, w.d(pMSAppInfo.domains));
        }
        if (TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            return;
        }
        d.a.n0.a.b2.a.c.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
    }
}
