package d.a.o0.a.n0.h;

import android.app.Activity;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.a.v2.n0;
/* loaded from: classes7.dex */
public abstract class a implements d.a.o0.a.g1.k.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46732a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1477336343, "Ld/a/o0/a/n0/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1477336343, "Ld/a/o0/a/n0/h/a;");
                return;
            }
        }
        f46732a = k.f46335a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // d.a.o0.a.g1.k.a
    public void a(boolean z, Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048576, this, z, activity) == null) && c.a() && !z) {
            long currentTimeMillis = f46732a ? System.currentTimeMillis() : 0L;
            boolean C = n0.C();
            if (f46732a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("DiskCleanerLifecycleObserver", "detect all process is on baground cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            if (C) {
                boolean n = e.n();
                d.a.o0.a.e0.d.h("DiskCleanerLifecycleObserver", "all app process in background，run clean task");
                d.a.o0.a.n0.f.c().d().u(null, n, 16);
                e.p(false);
            }
        }
    }
}
