package d.a.n0.a.h0.l.g;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class m implements b<a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f44907c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile Boolean f44908a;

    /* renamed from: b  reason: collision with root package name */
    public volatile b<a> f44909b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(961088714, "Ld/a/n0/a/h0/l/g/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(961088714, "Ld/a/n0/a/h0/l/g/m;");
                return;
            }
        }
        f44907c = d.a.n0.a.k.f45831a;
    }

    public m() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f44908a = null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: d.a.n0.a.h0.l.g.d<d.a.n0.a.h0.l.g.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.a.n0.a.h0.l.g.c
    public void b(d<a> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            l().b(dVar);
        }
    }

    @Override // d.a.n0.a.h0.l.g.b
    public void c(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, pMSAppInfo) == null) {
            l().c(cVar, pMSAppInfo);
        }
    }

    @Override // d.a.n0.a.h0.l.g.b
    public void d(d.a.n0.a.o0.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            l().d(aVar);
        }
    }

    @Override // d.a.n0.a.h0.l.g.c
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? l().f() : invokeV.booleanValue;
    }

    @Override // d.a.n0.a.h0.l.g.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? l().g() : invokeV.booleanValue;
    }

    @Override // d.a.n0.a.h0.l.g.c
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? l().h() : invokeV.booleanValue;
    }

    @Override // d.a.n0.a.h0.l.g.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? l().i() : invokeV.booleanValue;
    }

    @Override // d.a.n0.a.h0.l.g.b
    public void j(boolean z, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, jVar) == null) {
            l().j(z, jVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.a.h0.l.g.c
    /* renamed from: k */
    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (a) l().a() : (a) invokeV.objValue;
    }

    public final b<a> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f44909b == null) {
                synchronized (this) {
                    if (this.f44909b == null) {
                        this.f44909b = m() ? new d.a.n0.a.h0.l.g.o.c() : new l();
                        if (f44907c) {
                            Log.d("SwanAppMasterProviderWrapper", "provider - " + this.f44909b.getClass().getSimpleName());
                        }
                    }
                }
            }
            return this.f44909b;
        }
        return (b) invokeV.objValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f44908a == null) {
                this.f44908a = Boolean.valueOf(d.a.n0.a.h0.o.e.a.j() > 0 && d.a.n0.a.h0.o.e.a.g());
            }
            if (f44907c) {
                Log.d("SwanAppMasterProviderWrapper", "loaded swan core version - " + d.a.n0.a.h0.u.g.N().V());
                Log.d("SwanAppMasterProviderWrapper", "use multi preload - " + this.f44908a);
            }
            return this.f44908a.booleanValue();
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.a.h0.l.g.c
    /* renamed from: n */
    public a e(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, pMSAppInfo)) == null) ? (a) l().e(pMSAppInfo) : (a) invokeL.objValue;
    }

    @Override // d.a.n0.a.h0.l.g.c
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            l().reset();
            synchronized (this) {
                this.f44908a = null;
                this.f44909b = null;
            }
        }
    }
}
