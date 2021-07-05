package d.a.q0.a.n0.k;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import com.facebook.common.internal.Sets;
import d.a.q0.a.n0.k.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f49571a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f49572b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f49573c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, a> f49574d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f49575e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1735591185, "Ld/a/q0/a/n0/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1735591185, "Ld/a/q0/a/n0/k/b;");
                return;
            }
        }
        f49571a = Sets.newHashSet(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
        f49572b = new HashSet(f49571a);
        f49573c = new HashSet(f49572b);
        f49574d = new HashMap();
        f49575e = false;
    }

    public static a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            c();
            return f49574d.get(str);
        }
        return (a) invokeL.objValue;
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            a.b bVar = new a.b();
            bVar.d(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
            bVar.e(d.a.q0.a.c1.a.n0().a());
            bVar.b(d.a.q0.a.c1.a.n0().d());
            return bVar.a();
        }
        return (a) invokeV.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (!f49575e) {
                for (String str : f49573c) {
                    if (ZeusWebViewPreloadClass.ZEUS_FILE_DIR.equals(str)) {
                        f49574d.put(str, b());
                    }
                }
            }
            f49575e = true;
        }
    }
}
