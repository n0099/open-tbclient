package d.a.o0.h.h0;

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
import d.a.o0.a.a2.e;
import d.a.o0.a.f1.e.b;
import d.a.o0.a.j2.k;
import d.a.o0.a.n1.m;
import d.a.o0.h.f0.h;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f50522a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends d.a.o0.a.v1.a.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.h.h0.a f50523c;

        public a(d.a.o0.h.h0.a aVar) {
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
            this.f50523c = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v1.a.b.c.b, d.a.o0.a.v1.a.b.c.c, d.a.o0.a.v1.a.b.c.a
        public void onEvent(@NonNull d.a.o0.a.v1.a.b.a.b bVar) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (SwanAppNetworkUtils.i(null)) {
                    i2 = bVar.a() != null ? bVar.a().getInt("net_quality") : -1;
                } else {
                    i2 = -2;
                }
                if (b.f50522a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i2);
                }
                d.a.o0.h.h0.a aVar = this.f50523c;
                aVar.m = i2;
                k.u("976", aVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1867446928, "Ld/a/o0/h/h0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1867446928, "Ld/a/o0/h/h0/b;");
                return;
            }
        }
        f50522a = d.a.o0.a.k.f46335a;
    }

    public static void b(d.a.o0.h.h0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, aVar) == null) || aVar == null) {
            return;
        }
        d.a.o0.a.v1.c.e.a.E().L(null, m.class, new a(aVar));
    }

    public static void c(d.a.j0.a.d.b bVar) {
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
        if (f50522a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(d.a.o0.h.q.c.b.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= d.a.o0.h.q.c.b.a()) {
            return;
        }
        d.a.o0.h.h0.a aVar = new d.a.o0.h.h0.a();
        aVar.f46322b = "stuck";
        aVar.f46325e = "jserror";
        aVar.f46326f = e.V();
        if (e.i() != null && e.i().N() != null) {
            b.a N = e.i().N();
            aVar.f46323c = N.T();
            aVar.f46321a = k.m(N.G());
        }
        aVar.l = str + ";" + str2;
        aVar.k = h.d() ? 20 : 10;
        aVar.n = d.a.o0.h.q.c.b.b();
        aVar.o = System.currentTimeMillis() - a2.exceptionTime;
        b(aVar);
    }
}
