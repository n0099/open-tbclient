package d.a.t0.a.e;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.t0.a.e.a;
import java.util.Date;
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f67563a;

    /* renamed from: b  reason: collision with root package name */
    public static a.InterfaceC1914a f67564b;

    /* renamed from: c  reason: collision with root package name */
    public static a.InterfaceC1914a f67565c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-292428801, "Ld/a/t0/a/e/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-292428801, "Ld/a/t0/a/e/b;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (b.class) {
                if (!f67563a) {
                    d.a.t0.a.f.a.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    f67564b = new c();
                    f67565c = new m();
                    a.a().c();
                    a.a().d(f67565c);
                    a.a().d(f67564b);
                    a.a().e(context);
                    f67563a = true;
                    return;
                }
                d.a.t0.a.f.a.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
