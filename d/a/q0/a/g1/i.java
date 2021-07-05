package d.a.q0.a.g1;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static List<WeakReference<h>> f47864a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(116041374, "Ld/a/q0/a/g1/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(116041374, "Ld/a/q0/a/g1/i;");
                return;
            }
        }
        f47864a = new ArrayList();
    }

    public static void a(d.a.q0.a.p.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, dVar) == null) {
            for (int size = f47864a.size() - 1; size >= 0; size--) {
                h hVar = f47864a.get(size).get();
                if (hVar == null) {
                    f47864a.remove(size);
                } else {
                    hVar.d(dVar);
                }
            }
        }
    }

    public static void b(d.a.q0.a.p.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, dVar) == null) {
            for (int size = f47864a.size() - 1; size >= 0; size--) {
                h hVar = f47864a.get(size).get();
                if (hVar == null) {
                    f47864a.remove(size);
                } else {
                    hVar.b(dVar);
                }
            }
        }
    }

    public static void c(d.a.q0.a.p.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, dVar) == null) {
            for (int size = f47864a.size() - 1; size >= 0; size--) {
                h hVar = f47864a.get(size).get();
                if (hVar == null) {
                    f47864a.remove(size);
                } else {
                    hVar.c(dVar);
                }
            }
        }
    }

    public static void d(d.a.q0.a.p.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, dVar) == null) {
            for (int size = f47864a.size() - 1; size >= 0; size--) {
                h hVar = f47864a.get(size).get();
                if (hVar == null) {
                    f47864a.remove(size);
                } else {
                    hVar.a(dVar);
                }
            }
        }
    }

    public static void e(h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, hVar) == null) || hVar == null) {
            return;
        }
        boolean z = false;
        for (int size = f47864a.size() - 1; size >= 0; size--) {
            h hVar2 = f47864a.get(size).get();
            if (hVar2 == null) {
                f47864a.remove(size);
            } else {
                z = hVar2 == hVar;
            }
        }
        if (z) {
            return;
        }
        f47864a.add(new WeakReference<>(hVar));
    }

    public static void f(h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, hVar) == null) || hVar == null) {
            return;
        }
        for (int size = f47864a.size() - 1; size >= 0; size--) {
            h hVar2 = f47864a.get(size).get();
            if (hVar2 == null || hVar == hVar2) {
                f47864a.remove(size);
            }
        }
    }
}
