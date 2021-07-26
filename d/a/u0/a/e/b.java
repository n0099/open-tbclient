package d.a.u0.a.e;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.u0.a.e.a;
import java.util.Date;
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f68241a;

    /* renamed from: b  reason: collision with root package name */
    public static a.InterfaceC1919a f68242b;

    /* renamed from: c  reason: collision with root package name */
    public static a.InterfaceC1919a f68243c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2099883264, "Ld/a/u0/a/e/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2099883264, "Ld/a/u0/a/e/b;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (b.class) {
                if (!f68241a) {
                    d.a.u0.a.f.a.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    f68242b = new c();
                    f68243c = new m();
                    a.a().c();
                    a.a().d(f68243c);
                    a.a().d(f68242b);
                    a.a().e(context);
                    f68241a = true;
                    return;
                }
                d.a.u0.a.f.a.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
