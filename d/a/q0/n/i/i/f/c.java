package d.a.q0.n.i.i.f;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import okhttp3.Response;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f53972a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(304093145, "Ld/a/q0/n/i/i/f/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(304093145, "Ld/a/q0/n/i/i/f/c;");
                return;
            }
        }
        f53972a = d.a.q0.n.c.f53910a;
    }

    public static e a(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (f53972a) {
                Log.d("PMSGetRequestManager", "executeGetRequestSync-url:" + str);
            }
            Response executeSync = d.a.q0.m.e.a.g().getRequest().url(str).build().executeSync();
            if (executeSync == null) {
                return null;
            }
            return new a(executeSync);
        }
        return (e) invokeL.objValue;
    }
}
