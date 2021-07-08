package d.a.n0.a.j0.c;

import android.net.Uri;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f45682a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f45683b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f45684c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2093057241, "Ld/a/n0/a/j0/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2093057241, "Ld/a/n0/a/j0/c/a;");
                return;
            }
        }
        f45682a = "content://" + d.a.n0.a.j0.b.b.f45678b + "/history_with_app";
        f45683b = "content://" + d.a.n0.a.j0.b.b.f45678b + "/history";
        f45684c = "content://" + d.a.n0.a.j0.b.b.f45678b + "/history_with_aps_pms";
    }

    public static Uri a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? Uri.parse(f45683b) : (Uri) invokeV.objValue;
    }

    public static Uri b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Uri.parse(f45682a) : (Uri) invokeV.objValue;
    }

    public static Uri c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Uri.parse(f45684c) : (Uri) invokeV.objValue;
    }
}
