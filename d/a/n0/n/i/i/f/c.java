package d.a.n0.n.i.i.f;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import okhttp3.Response;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f50670a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1184302166, "Ld/a/n0/n/i/i/f/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1184302166, "Ld/a/n0/n/i/i/f/c;");
                return;
            }
        }
        f50670a = d.a.n0.n.c.f50608a;
    }

    public static e a(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (f50670a) {
                Log.d("PMSGetRequestManager", "executeGetRequestSync-url:" + str);
            }
            Response executeSync = d.a.n0.m.e.a.g().getRequest().url(str).build().executeSync();
            if (executeSync == null) {
                return null;
            }
            return new a(executeSync);
        }
        return (e) invokeL.objValue;
    }
}
