package d.a.p0.q2;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes8.dex */
public class j implements d.a.p0.x1.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f61745a;

    /* renamed from: b  reason: collision with root package name */
    public String f61746b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, d.a.p0.x1.e> f61747c;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d.a.p0.x1.g f61748a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1663569463, "Ld/a/p0/q2/j$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1663569463, "Ld/a/p0/q2/j$b;");
                    return;
                }
            }
            f61748a = new j(null);
        }
    }

    public /* synthetic */ j(a aVar) {
        this();
    }

    public static d.a.p0.x1.g m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f61748a : (d.a.p0.x1.g) invokeV.objValue;
    }

    @Override // d.a.p0.x1.g
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            n().c(this.f61745a, i2, str);
        }
    }

    @Override // d.a.p0.x1.g
    public void b(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            n().f(this.f61745a, i2, str);
        }
    }

    @Override // d.a.p0.x1.g
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            n().k(this.f61745a);
            q(this.f61745a);
        }
    }

    @Override // d.a.p0.x1.g
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f61746b = this.f61745a;
        }
    }

    @Override // d.a.p0.x1.g
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || StringUtils.isNull(this.f61746b)) {
            return;
        }
        if (!o(this.f61746b) && !p(this.f61746b)) {
            d.a.p0.x1.d.b(this.f61746b);
            this.f61747c.remove(this.f61745a);
        } else {
            q(this.f61746b);
        }
        g();
        n().h(this.f61746b, str);
        this.f61746b = null;
    }

    @Override // d.a.p0.x1.g
    public void f(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, str) == null) {
            n().b(this.f61745a, i2, i3, str);
        }
    }

    @Override // d.a.p0.x1.g
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f61745a = UUID.randomUUID().toString();
        }
    }

    @Override // d.a.p0.x1.g
    public void h(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, str) == null) {
            n().g(this.f61745a, i2, str);
        }
    }

    @Override // d.a.p0.x1.g
    public void i(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, str) == null) {
            n().l(this.f61745a, i2, str);
        }
    }

    @Override // d.a.p0.x1.g
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            n().j(this.f61745a);
        }
    }

    @Override // d.a.p0.x1.g
    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            n().i(this.f61745a, str);
            if (!o(this.f61745a) && !p(this.f61745a)) {
                d.a.p0.x1.d.b(this.f61745a);
                this.f61747c.remove(this.f61745a);
            } else {
                q(this.f61745a);
            }
            this.f61745a = null;
        }
    }

    public final d.a.p0.x1.e l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            i iVar = new i(this.f61745a);
            this.f61747c.put(this.f61745a, iVar);
            return iVar;
        }
        return (d.a.p0.x1.e) invokeV.objValue;
    }

    public final d.a.p0.x1.e n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            d.a.p0.x1.e eVar = this.f61747c.get(this.f61745a);
            return eVar == null ? l() : eVar;
        }
        return (d.a.p0.x1.e) invokeV.objValue;
    }

    public boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? n().d(str) : invokeL.booleanValue;
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? n().e(str) : invokeL.booleanValue;
    }

    public void q(String str) {
        d.a.p0.x1.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || (eVar = this.f61747c.get(str)) == null) {
            return;
        }
        eVar.a(str);
        this.f61747c.remove(str);
    }

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61747c = new HashMap<>();
    }
}
