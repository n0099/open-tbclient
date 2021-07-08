package d.a.n0.h.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f49985a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f49986b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile List<d.a.n0.a.o0.d.b> f49987c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132169846, "Ld/a/n0/h/f/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2132169846, "Ld/a/n0/h/f/i;");
                return;
            }
        }
        f49987c = new ArrayList();
    }

    public i() {
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

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && f49985a && !f49986b) {
            synchronized (i.class) {
                if (f49987c != null) {
                    for (int i2 = 0; i2 < f49987c.size(); i2++) {
                        d.a.n0.a.g1.f.V().m("console", f49987c.get(i2));
                    }
                    f49987c.clear();
                    f49987c = null;
                }
            }
            f49986b = true;
        }
    }

    public static String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 6 ? TbConfig.TMP_LOG_DIR_NAME : "debug" : "warn" : "error" : "info" : "debug" : (String) invokeI.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (i.class) {
                f49987c = new ArrayList();
            }
            f49986b = false;
        }
    }

    public static void d(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, null, i2, str) == null) {
            e(b(i2), str);
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) && f49985a) {
            f(c.h(str, str2));
        }
    }

    public static void f(d.a.n0.a.o0.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, bVar) == null) {
            if (!f49986b) {
                synchronized (i.class) {
                    if (f49987c != null) {
                        f49987c.add(bVar);
                        return;
                    }
                }
            }
            d.a.n0.a.g1.f.V().m("console", bVar);
        }
    }

    public static void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) && f49985a) {
            f(c.j(str, str2));
        }
    }

    public static void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            f49985a = z;
            d.a.n0.a.e0.d.k(z);
        }
    }
}
