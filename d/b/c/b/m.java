package d.b.c.b;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes8.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static Context f69483a = null;

    /* renamed from: b  reason: collision with root package name */
    public static long f69484b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static String f69485c = "default";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f69486d;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    public static d.b.c.b.h.b f69487e;

    /* renamed from: f  reason: collision with root package name */
    public static c f69488f;

    /* renamed from: g  reason: collision with root package name */
    public static d f69489g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile ConcurrentHashMap<Integer, String> f69490h;

    /* renamed from: i  reason: collision with root package name */
    public static d.b.c.b.h.k f69491i;
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
        f69488f = new c();
        f69489g = new d();
        f69491i = null;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f69487e : (d.b.c.b.h.b) invokeV.objValue;
    }

    public static void b(Context context, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, gVar) == null) {
            f69484b = System.currentTimeMillis();
            f69483a = context;
            f69487e = new d.b.c.b.h.b(context, gVar);
        }
    }

    public static d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f69489g : (d) invokeV.objValue;
    }

    public static d.b.c.b.h.k d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f69491i == null) {
                synchronized (m.class) {
                    f69491i = new d.b.c.b.h.k(f69483a);
                }
            }
            return f69491i;
        }
        return (d.b.c.b.h.k) invokeV.objValue;
    }

    public static Context e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f69483a : (Context) invokeV.objValue;
    }

    public static c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f69488f : (c) invokeV.objValue;
    }

    public static long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f69484b : invokeV.longValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f69485c : (String) invokeV.objValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? f69486d : invokeV.booleanValue;
    }

    public static ConcurrentHashMap<Integer, String> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f69490h : (ConcurrentHashMap) invokeV.objValue;
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
