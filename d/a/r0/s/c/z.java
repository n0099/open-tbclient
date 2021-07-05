package d.a.r0.s.c;

import android.net.Uri;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.core.Domains;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes9.dex */
public class z {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f56474a;

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f56475b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-457221291, "Ld/a/r0/s/c/z;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-457221291, "Ld/a/r0/s/c/z;");
                return;
            }
        }
        f56474a = Arrays.asList(Domains.BAIDU, Domains.NUOMI, Domains.BAIFUBAO, ".hao123.com");
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        String p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (d.a.c.e.p.k.isEmpty(str)) {
                return false;
            }
            Uri parse = Uri.parse(str);
            if (parse == null || !"file".equals(parse.getScheme()) || parse.getPath() == null || !parse.getPath().contains("bdtbNWCache")) {
                if (f56475b == null && (p = d.a.r0.r.d0.b.j().p("js_host_white_list", null)) != null) {
                    f56475b = b(p);
                }
                if (f56475b == null) {
                    f56475b = f56474a;
                }
                if (parse != null) {
                    String host = parse.getHost();
                    for (String str2 : f56475b) {
                        if (host.endsWith(str2)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static List<String> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (d.a.c.e.p.k.isEmpty(str)) {
                return null;
            }
            return Arrays.asList(str.split(";"));
        }
        return (List) invokeL.objValue;
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            if (str == null) {
                d.a.r0.r.d0.b.j().x("js_host_white_list", "");
            } else {
                d.a.r0.r.d0.b.j().x("js_host_white_list", str);
            }
            f56475b = b(str);
        }
    }
}
