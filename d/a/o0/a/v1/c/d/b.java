package d.a.o0.a.v1.c.d;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.a.k;
import d.a.o0.a.v1.c.f.c;
import d.a.o0.a.v1.c.f.e;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48440a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1888937651, "Ld/a/o0/a/v1/c/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1888937651, "Ld/a/o0/a/v1/c/d/b;");
                return;
            }
        }
        f48440a = k.f46335a;
    }

    public static void a(@Nullable Bundle bundle, @NonNull Class<? extends d.a.o0.a.v1.a.a.a> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, bundle, cls) == null) {
            Iterator<c> it = e.k().q().iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null && next.H()) {
                    b(next.f48461f, bundle, cls, null);
                }
            }
        }
    }

    public static void b(SwanAppProcessInfo swanAppProcessInfo, @Nullable Bundle bundle, @NonNull Class<? extends d.a.o0.a.v1.a.a.a> cls, @Nullable d.a.o0.a.v1.a.b.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, swanAppProcessInfo, bundle, cls, cVar) == null) {
            if (f48440a) {
                Log.d("SwanAppMessageChannel", "sendMessageToClient: delegation: " + cls.getName());
            }
            Message obtain = Message.obtain((Handler) null, 125);
            obtain.replyTo = e.k().f48472d;
            Bundle bundle2 = new Bundle();
            bundle2.putString("ai_apps_delegation_name", cls.getName());
            if (cVar != null) {
                bundle2.putString("ai_apps_observer_id", cVar.b());
                d.a.o0.a.v1.a.b.b.a.b().e(cVar);
            }
            if (bundle != null) {
                bundle2.putBundle("ai_apps_data", bundle);
            }
            obtain.obj = bundle2;
            d.a.o0.a.v1.c.a e2 = d.a.o0.a.v1.c.a.e();
            d.a.o0.a.v1.c.c cVar2 = new d.a.o0.a.v1.c.c(obtain);
            cVar2.b(swanAppProcessInfo);
            e2.h(cVar2);
        }
    }

    public static void c(@Nullable Bundle bundle, @NonNull Class<? extends d.a.o0.a.v1.a.a.a> cls, @Nullable d.a.o0.a.v1.a.b.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, bundle, cls, cVar) == null) {
            d.a.o0.a.v1.c.e.a.E().L(bundle, cls, cVar);
        }
    }
}
