package d.b.c.b;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.b.c.b.h.c;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static Context f71926a = null;

    /* renamed from: b  reason: collision with root package name */
    public static long f71927b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static String f71928c = "default";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f71929d;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    public static d.b.c.b.h.b f71930e;

    /* renamed from: f  reason: collision with root package name */
    public static c f71931f;

    /* renamed from: g  reason: collision with root package name */
    public static d f71932g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile ConcurrentHashMap<Integer, String> f71933h;

    /* renamed from: i  reason: collision with root package name */
    public static d.b.c.b.h.k f71934i;
    public static volatile int j;
    public static volatile String k;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-11464373, "Ld/b/c/b/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-11464373, "Ld/b/c/b/m;");
                return;
            }
        }
        f71931f = new c();
        f71932g = new d();
        f71934i = null;
    }

    public m() {
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

    public static d.b.c.b.h.b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f71930e : (d.b.c.b.h.b) invokeV.objValue;
    }

    public static void b(Context context, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, gVar) == null) {
            f71927b = System.currentTimeMillis();
            f71926a = context;
            f71930e = new d.b.c.b.h.b(context, gVar);
        }
    }

    public static d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? f71932g : (d) invokeV.objValue;
    }

    public static d.b.c.b.h.k d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f71934i == null) {
                synchronized (m.class) {
                    f71934i = new d.b.c.b.h.k(f71926a);
                }
            }
            return f71934i;
        }
        return (d.b.c.b.h.k) invokeV.objValue;
    }

    public static Context e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f71926a : (Context) invokeV.objValue;
    }

    public static c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f71931f : (c) invokeV.objValue;
    }

    public static long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f71927b : invokeV.longValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f71928c : (String) invokeV.objValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? f71929d : invokeV.booleanValue;
    }

    public static ConcurrentHashMap<Integer, String> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f71933h : (ConcurrentHashMap) invokeV.objValue;
    }

    public static int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? j : invokeV.intValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? k : (String) invokeV.objValue;
    }
}
