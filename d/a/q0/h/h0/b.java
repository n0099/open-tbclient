package d.a.q0.h.h0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.e;
import d.a.q0.a.f1.e.b;
import d.a.q0.a.j2.k;
import d.a.q0.a.n1.m;
import d.a.q0.h.f0.h;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f53320a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends d.a.q0.a.v1.a.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.h.h0.a f53321c;

        public a(d.a.q0.h.h0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53321c = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v1.a.b.c.b, d.a.q0.a.v1.a.b.c.c, d.a.q0.a.v1.a.b.c.a
        public void onEvent(@NonNull d.a.q0.a.v1.a.b.a.b bVar) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (SwanAppNetworkUtils.i(null)) {
                    i2 = bVar.a() != null ? bVar.a().getInt("net_quality") : -1;
                } else {
                    i2 = -2;
                }
                if (b.f53320a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i2);
                }
                d.a.q0.h.h0.a aVar = this.f53321c;
                aVar.m = i2;
                k.u("976", aVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2034493358, "Ld/a/q0/h/h0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2034493358, "Ld/a/q0/h/h0/b;");
                return;
            }
        }
        f53320a = d.a.q0.a.k.f49133a;
    }

    public static void b(d.a.q0.h.h0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, aVar) == null) || aVar == null) {
            return;
        }
        d.a.q0.a.v1.c.e.a.E().L(null, m.class, new a(aVar));
    }

    public static void c(d.a.l0.a.d.b bVar) {
        V8ExceptionInfo a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, bVar) == null) || bVar == null || (a2 = bVar.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (f53320a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(d.a.q0.h.q.c.b.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= d.a.q0.h.q.c.b.a()) {
            return;
        }
        d.a.q0.h.h0.a aVar = new d.a.q0.h.h0.a();
        aVar.f49120b = "stuck";
        aVar.f49123e = "jserror";
        aVar.f49124f = e.V();
        if (e.i() != null && e.i().N() != null) {
            b.a N = e.i().N();
            aVar.f49121c = N.T();
            aVar.f49119a = k.m(N.G());
        }
        aVar.l = str + ";" + str2;
        aVar.k = h.d() ? 20 : 10;
        aVar.n = d.a.q0.h.q.c.b.b();
        aVar.o = System.currentTimeMillis() - a2.exceptionTime;
        b(aVar);
    }
}
