package d.a.o0.a.n0.k;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import com.facebook.common.internal.Sets;
import d.a.o0.a.n0.k.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f46773a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f46774b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f46775c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, a> f46776d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f46777e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1477425747, "Ld/a/o0/a/n0/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1477425747, "Ld/a/o0/a/n0/k/b;");
                return;
            }
        }
        f46773a = Sets.newHashSet(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
        f46774b = new HashSet(f46773a);
        f46775c = new HashSet(f46774b);
        f46776d = new HashMap();
        f46777e = false;
    }

    public static a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            c();
            return f46776d.get(str);
        }
        return (a) invokeL.objValue;
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            a.b bVar = new a.b();
            bVar.d(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
            bVar.e(d.a.o0.a.c1.a.n0().a());
            bVar.b(d.a.o0.a.c1.a.n0().d());
            return bVar.a();
        }
        return (a) invokeV.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (!f46777e) {
                for (String str : f46775c) {
                    if (ZeusWebViewPreloadClass.ZEUS_FILE_DIR.equals(str)) {
                        f46776d.put(str, b());
                    }
                }
            }
            f46777e = true;
        }
    }
}
