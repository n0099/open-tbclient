package d.a.o0.a.j2;

import android.util.Log;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.v2.q;
/* loaded from: classes7.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46237a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.j2.p.e f46238e;

        public a(d.a.o0.a.j2.p.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46238e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.k("934", this.f46238e.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(511868583, "Ld/a/o0/a/j2/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(511868583, "Ld/a/o0/a/j2/d;");
                return;
            }
        }
        f46237a = d.a.o0.a.k.f46335a;
    }

    public static void a(d.a.o0.a.j2.p.e eVar, d.a.o0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, eVar, bVar) == null) || eVar == null || bVar == null) {
            return;
        }
        eVar.f46321a = k.m(bVar.G());
        eVar.f46326f = bVar.H();
        eVar.f46323c = bVar.T();
        eVar.a("swan", d.a.o0.a.m2.b.h(bVar.G()));
        eVar.a("appversion", bVar.u1());
        eVar.a("thirdversion", bVar.v1());
        eVar.b(k.k(bVar.W()));
        eVar.d(bVar.r0().getString(UBCCloudControlProcessor.UBC_KEY));
    }

    public static void b(d.a.o0.a.j2.p.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, fVar) == null) {
            if (fVar == null) {
                if (f46237a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            d.a.o0.a.j2.p.e eVar = new d.a.o0.a.j2.p.e();
            eVar.f46326f = fVar.f46326f;
            eVar.f46321a = fVar.f46321a;
            eVar.f46327g = fVar.f46327g;
            eVar.f46323c = fVar.f46323c;
            eVar.f46322b = fVar.f46322b;
            eVar.f46325e = fVar.f46325e;
            eVar.e(fVar.c());
            c(eVar);
        }
    }

    public static void c(d.a.o0.a.j2.p.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, eVar) == null) {
            q.i(new a(eVar), "SwanAppFuncClickUBC");
        }
    }
}
