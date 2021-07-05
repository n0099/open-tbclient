package d.a.s0.t.a.j;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.SplashDealyTimeoutSwitch;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.s0.t.a.f.b;
import java.io.File;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static long f65503a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static String f65504b = "1";

    /* renamed from: c  reason: collision with root package name */
    public static String f65505c = "5";

    /* renamed from: d  reason: collision with root package name */
    public static String f65506d = "6";

    /* renamed from: e  reason: collision with root package name */
    public static String f65507e = "7";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1414880907, "Ld/a/s0/t/a/j/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1414880907, "Ld/a/s0/t/a/j/a;");
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            File file = new File(d.a.s0.t.a.i.a.f65496b);
            if (file.exists()) {
                FileHelper.deleteFileOrDir(file);
            }
        }
    }

    public static void b(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, file) == null) {
            File file2 = new File(d.a.s0.t.a.i.a.f65496b);
            if (!file2.exists() || (listFiles = file2.listFiles()) == null) {
                return;
            }
            for (File file3 : listFiles) {
                if (file3 != null && !file3.equals(file)) {
                    FileHelper.deleteFileOrDir(file3);
                }
            }
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).edit().putString("bc_splash_info_new", "").apply();
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).getString("bc_splash_info_new", "") : (String) invokeV.objValue;
    }

    public static long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (SplashDealyTimeoutSwitch.isOpen()) {
                return 2000L;
            }
            return d.a.s0.t.a.h.a.c().e() ? 1400L : 1000L;
        }
        return invokeV.longValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - f65503a;
            if (0 >= j || j >= 500) {
                f65503a = currentTimeMillis;
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static void g(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, adInfo) == null) {
            TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).edit().putString("bc_splash_info_new", b.a(adInfo).toString()).apply();
        }
    }

    public static void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, bVar) == null) {
            if (bVar == null) {
                c();
            } else {
                TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).edit().putString("bc_splash_info_new", bVar.toString()).apply();
            }
        }
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", str).param("obj_locate", 2).param("obj_type", "a064").eventStat();
        }
    }

    public static void j(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65546, null, str, str2, i2) == null) {
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", str).param("obj_type", "a064").param("obj_locate", str2).param(TiebaStatic.Params.RESOURCE_ID, Math.max(i2, 0)).eventStat();
        }
    }

    public static void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) {
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", str).param("obj_type", "a064").param("obj_locate", str2).eventStat();
        }
    }
}
