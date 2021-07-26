package d.a.o0.j;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.a.v2.q0;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f50963b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f50964c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile c f50965d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<d.a.o0.a.p.e.b, b> f50966a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-799569850, "Ld/a/o0/j/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-799569850, "Ld/a/o0/j/c;");
                return;
            }
        }
        f50963b = k.f46335a;
        f50964c = c.class.getSimpleName();
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a.a();
        this.f50966a = new HashMap();
    }

    public static c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f50965d == null) {
                synchronized (c.class) {
                    if (f50965d == null) {
                        f50965d = new c();
                    }
                }
            }
            return f50965d;
        }
        return (c) invokeV.objValue;
    }

    public static void d(d.a.o0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bVar) == null) {
            synchronized (c.class) {
                if (f50965d != null) {
                    f50965d.c(bVar).i();
                }
            }
        }
    }

    public static void e(d.a.o0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar) == null) {
            synchronized (c.class) {
                if (f50965d != null) {
                    f50965d.f(bVar);
                } else if (f50963b) {
                    Log.v(f50964c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(d.a.o0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bVar) == null) {
            synchronized (c.class) {
                if (f50965d != null) {
                    f50965d.c(bVar).l();
                }
            }
        }
    }

    public boolean a(Context context, d.a.o0.a.h1.c.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, cVar)) == null) {
            d.a.o0.a.e0.d.g("map", "map create start");
            if (q0.m(cVar.f43982g) != null && cVar.isValid()) {
                d.a.o0.a.p.e.d B = d.a.o0.a.g1.f.V().B(cVar.f43982g);
                if (!(B instanceof d.a.o0.a.p.e.b)) {
                    d.a.o0.a.e0.d.b("map", "WebViewManager is null");
                    return false;
                }
                b c2 = c((d.a.o0.a.p.e.b) B);
                if (c2.d(cVar.f43981f) != null) {
                    d.a.o0.a.e0.d.b("map", "map with id " + cVar.f43981f + " exist");
                    return false;
                }
                d.a.o0.j.n.c M = d.a.o0.j.n.c.M(context, cVar);
                if (M == null) {
                    d.a.o0.a.e0.d.b("map", "map with id " + cVar.f43981f + " model is invalid");
                    return false;
                }
                d.a.o0.a.c0.b.c w = M.w();
                if (!w.a()) {
                    d.a.o0.a.e0.d.b("map", "map with id " + cVar.f43981f + " create fail: " + w.f43986b);
                    return false;
                } else if (c2.g(M)) {
                    d.a.o0.a.e0.d.g("map", "map with id " + cVar.f43981f + " init start");
                    d.a.o0.j.k.f.f.a(context, M, cVar, c2);
                    d.a.o0.a.e0.d.g("map", "map with id " + cVar.f43981f + " init end");
                    d.a.o0.a.e0.d.g("map", "map create end");
                    return true;
                } else {
                    return false;
                }
            }
            d.a.o0.a.e0.d.b("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public synchronized b c(d.a.o0.a.p.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
            synchronized (this) {
                if (bVar == null) {
                    return null;
                }
                b bVar2 = this.f50966a.get(bVar);
                if (bVar2 == null) {
                    bVar2 = new b();
                    this.f50966a.put(bVar, bVar2);
                }
                return bVar2;
            }
        }
        return (b) invokeL.objValue;
    }

    public final synchronized void f(d.a.o0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            synchronized (this) {
                if (bVar == null) {
                    return;
                }
                b remove = this.f50966a.remove(bVar);
                if (remove != null) {
                    remove.j();
                }
            }
        }
    }

    public boolean g(d.a.o0.a.h1.c.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            d.a.o0.a.e0.d.g("map", "map remove start");
            if (q0.m(cVar.f43982g) == null) {
                d.a.o0.a.e0.d.b("map", "webView is null or mapModel is null");
                return false;
            }
            d.a.o0.a.p.e.d B = d.a.o0.a.g1.f.V().B(cVar.f43982g);
            if (!(B instanceof d.a.o0.a.p.e.b)) {
                d.a.o0.a.e0.d.b("map", "WebViewManager is null");
                return false;
            }
            b c2 = c((d.a.o0.a.p.e.b) B);
            d.a.o0.j.n.c d2 = c2.d(cVar.f43981f);
            if (d2 == null) {
                d.a.o0.a.e0.d.b("map", "remove map with id " + cVar.f43981f + " not exist");
                return false;
            } else if (c2.k(cVar.f43981f)) {
                d.a.o0.a.e0.d.g("map", "map remove end");
                if (d.a.o0.a.c0.d.a.a(cVar) == null) {
                    d.a.o0.a.c0.g.a.a("map", "remove with a null map component");
                }
                d.a.o0.a.c0.b.c C = d2.C();
                boolean a2 = C.a();
                if (!a2) {
                    String str = f50964c;
                    d.a.o0.a.e0.d.b(str, "map remove fail: " + C.f43986b);
                }
                return a2;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean i(Context context, d.a.o0.a.h1.c.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, cVar)) == null) {
            d.a.o0.a.e0.d.g("map", "map update start");
            if (q0.m(cVar.f43982g) == null) {
                d.a.o0.a.e0.d.b("map", "webView is null or mapModel is null");
                return false;
            }
            d.a.o0.a.p.e.d B = d.a.o0.a.g1.f.V().B(cVar.f43982g);
            if (B != null && (B instanceof d.a.o0.a.p.e.b)) {
                b c2 = c((d.a.o0.a.p.e.b) B);
                d.a.o0.j.n.c d2 = c2.d(cVar.f43981f);
                if (d2 == null) {
                    d.a.o0.a.e0.d.b("map", "remove map with id " + cVar.f43981f + " not exist");
                    return false;
                }
                d2.H();
                d.a.o0.j.k.f.f.b(context, d2, cVar, c2, true);
                d.a.o0.a.e0.d.g("map", "map update end");
                if (d.a.o0.a.c0.d.a.a(cVar) == null) {
                    d.a.o0.a.c0.g.a.a("map", "update with a null map component");
                }
                d.a.o0.a.c0.b.c G = d2.G(cVar);
                boolean a2 = G.a();
                if (!a2) {
                    String str = f50964c;
                    d.a.o0.a.e0.d.b(str, "map update fail: " + G.f43986b);
                }
                return a2;
            }
            d.a.o0.a.e0.d.b("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
