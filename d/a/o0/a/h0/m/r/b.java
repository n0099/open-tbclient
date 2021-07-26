package d.a.o0.a.h0.m.r;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.a.a1.e;
import d.a.o0.a.a1.h.a;
import d.a.o0.a.k;
import d.a.o0.n.h.g;
import d.a.o0.t.d;
import java.io.File;
import java.util.List;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45553a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(484486600, "Ld/a/o0/a/h0/m/r/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(484486600, "Ld/a/o0/a/h0/m/r/b;");
                return;
            }
        }
        f45553a = k.f46335a;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? e(str, "swan_sub_package_zip") : (String) invokeL.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) ? a(e.C0638e.i(str, str2).getPath()) : (String) invokeLL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? e(str, "swan_sub_package_zip") : (String) invokeL.objValue;
    }

    public static String d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            File a2 = d.a.o0.a.c1.b.g().a(str, str2);
            if (a2 != null) {
                return c(a2.getPath());
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File file = new File(str, str2);
                if (file.exists()) {
                    return file.getPath();
                }
                if (file.mkdirs()) {
                    return file.getPath();
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean f(List<g> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return false;
            }
            return list.get(0).r;
        }
        return invokeL.booleanValue;
    }

    public static boolean g(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, gVar)) == null) {
            if (gVar == null || TextUtils.isEmpty(gVar.o)) {
                return false;
            }
            return h(new File(gVar.f51134a), new File(e.C0638e.i(gVar.o, String.valueOf(gVar.f51142i)).getPath(), gVar.p));
        }
        return invokeL.booleanValue;
    }

    public static boolean h(File file, File file2) {
        InterceptResult invokeLL;
        boolean T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, file, file2)) == null) {
            if (file != null && file2 != null) {
                if (!file.exists()) {
                    if (f45553a) {
                        Log.e("SubPkgDownloadUtil", "解压分包时，ZIP包不存在");
                    }
                    return false;
                } else if (!file2.exists() && !file2.mkdirs()) {
                    if (f45553a) {
                        Log.e("SubPkgDownloadUtil", "创建分包解压文件夹失败");
                    }
                    return false;
                } else {
                    a.b i2 = d.a.o0.a.a1.h.a.i(file);
                    int i3 = i2.f43851b;
                    if (i3 != -1) {
                        T = d.a.o0.a.a1.h.a.c(i2.f43850a, file2, i3).f43848a;
                    } else {
                        T = d.T(file.getAbsolutePath(), file2.getAbsolutePath());
                    }
                    if (T) {
                        if (f45553a) {
                            Log.e("SubPkgDownloadUtil", "分包解压成功");
                            return true;
                        }
                        return true;
                    } else if (f45553a) {
                        Log.e("SubPkgDownloadUtil", "分包解压文件失败, file:" + file.getAbsolutePath() + " folder:" + file2.getAbsolutePath());
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
