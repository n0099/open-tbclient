package d.a.o0.a.e0.f;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.a.e0.f.f.d;
import d.a.o0.a.k;
import d.a.o0.a.v2.v;
import java.io.File;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44489a;

    /* renamed from: b  reason: collision with root package name */
    public static String f44490b;

    /* renamed from: c  reason: collision with root package name */
    public static String f44491c;

    /* renamed from: d  reason: collision with root package name */
    public static a f44492d;

    /* renamed from: e  reason: collision with root package name */
    public static int f44493e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2079678255, "Ld/a/o0/a/e0/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2079678255, "Ld/a/o0/a/e0/f/b;");
                return;
            }
        }
        f44489a = k.f46335a;
        f44490b = "";
        f44491c = "";
        f44493e = 0;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f44490b : (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f44492d != null) {
                return f44492d.c() + File.separator + f44490b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f44491c : (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f44492d != null) {
                return f44492d.c() + File.separator + f44491c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f44493e == 2 : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f44493e == 1 : invokeV.booleanValue;
    }

    public static void g(Bundle bundle) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, bundle) == null) || (aVar = f44492d) == null) {
            return;
        }
        aVar.b(bundle);
    }

    public static void h(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, bundle) == null) {
            String i2 = v.i(bundle, "extraWSUrl");
            String i3 = v.i(bundle, "adb_debug_path");
            if (!TextUtils.isEmpty(i2)) {
                f44492d = new d();
                f44493e = 1;
            } else if (!TextUtils.isEmpty(i3)) {
                f44492d = new d.a.o0.a.e0.f.c.b();
                f44493e = 2;
            } else {
                if (f44489a) {
                    Log.d("UserDebugParams", "not debug mode");
                }
                f44493e = 0;
                f44492d = null;
                return;
            }
            f44492d.a(bundle);
        }
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            f44490b = str;
        }
    }

    public static void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            f44491c = str;
        }
    }
}
