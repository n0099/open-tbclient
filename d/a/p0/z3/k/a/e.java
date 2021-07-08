package d.a.p0.z3.k.a;

import android.graphics.SurfaceTexture;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.v0.p.b;
/* loaded from: classes8.dex */
public class e implements b.InterfaceC1934b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f66815a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC1934b f66816b;

    /* renamed from: c  reason: collision with root package name */
    public b.InterfaceC1934b f66817c;

    /* renamed from: d  reason: collision with root package name */
    public b.InterfaceC1934b f66818d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66819e;

    /* renamed from: f  reason: collision with root package name */
    public b.f f66820f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f66821g;

    /* renamed from: h  reason: collision with root package name */
    public int f66822h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f66823i;
    public b.a j;

    /* loaded from: classes8.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f66824a;

        public a(e eVar) {
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
            this.f66824a = eVar;
        }

        @Override // d.a.v0.p.b.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof String) {
                    String str = (String) obj;
                }
                this.f66824a.C();
                this.f66824a.f66818d.k(this.f66824a.f66821g, this.f66824a.f66820f);
                if (this.f66824a.f66823i) {
                    this.f66824a.f66823i = false;
                    this.f66824a.f66818d.n();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-638208364, "Ld/a/p0/z3/k/a/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-638208364, "Ld/a/p0/z3/k/a/e;");
        }
    }

    public e(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f66819e = false;
        this.f66823i = false;
        this.j = new a(this);
        if (Build.VERSION.SDK_INT >= 21) {
            if (System.currentTimeMillis() - c.f66812b.c() >= c.f66811a) {
                c.f66812b.k(0);
            }
            if (1 != c.f66812b.d().intValue()) {
                this.f66817c = b.U(tbPageContext);
            }
        }
        d B = d.B(tbPageContext);
        this.f66816b = B;
        this.f66818d = B;
    }

    public static e D(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            if (k == null) {
                synchronized (e.class) {
                    if (k == null) {
                        k = new e(tbPageContext);
                    } else if (tbPageContext != null) {
                        k.f66815a = tbPageContext;
                    }
                }
            }
            return k;
        }
        return (e) invokeL.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f66817c == null) {
            return;
        }
        this.f66816b.u(this.f66822h);
        this.f66816b.i(this.f66817c.o());
        this.f66816b.m(this.f66817c.a());
        this.f66816b.j(this.f66817c.p());
        this.f66817c.q();
        this.f66817c.release();
        this.f66818d = this.f66816b;
        this.f66819e = false;
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.InterfaceC1934b interfaceC1934b = this.f66818d;
            if (interfaceC1934b != null) {
                return interfaceC1934b.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.InterfaceC1934b interfaceC1934b = this.f66818d;
            if (interfaceC1934b != null) {
                return interfaceC1934b.b();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public void c(int i2, int i3, int i4, int i5) {
        b.InterfaceC1934b interfaceC1934b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) || (interfaceC1934b = this.f66818d) == null) {
            return;
        }
        interfaceC1934b.c(i2, i3, i4, i5);
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public void d(byte[] bArr) {
        b.InterfaceC1934b interfaceC1934b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) && (interfaceC1934b = this.f66818d) == this.f66816b && interfaceC1934b != null) {
            interfaceC1934b.d(bArr);
        }
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.InterfaceC1934b interfaceC1934b = this.f66818d;
            if (interfaceC1934b != null) {
                return interfaceC1934b.e();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b.InterfaceC1934b interfaceC1934b = this.f66818d;
            if (interfaceC1934b != null) {
                return interfaceC1934b.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public void g(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            this.f66816b.g(i2, i3, i4, z);
            b.InterfaceC1934b interfaceC1934b = this.f66817c;
            if (interfaceC1934b != null) {
                interfaceC1934b.g(i2, i3, i4, z);
            }
        }
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public void h(boolean z) {
        b.InterfaceC1934b interfaceC1934b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f66819e = z;
            if (z && (interfaceC1934b = this.f66817c) != null) {
                interfaceC1934b.s(this.j);
                this.f66818d = this.f66817c;
                return;
            }
            b.InterfaceC1934b interfaceC1934b2 = this.f66817c;
            if (interfaceC1934b2 != null) {
                interfaceC1934b2.release();
            }
            this.f66818d = this.f66816b;
        }
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public void i(boolean z) {
        b.InterfaceC1934b interfaceC1934b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (interfaceC1934b = this.f66818d) == null) {
            return;
        }
        interfaceC1934b.i(z);
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public void j(boolean z) {
        b.InterfaceC1934b interfaceC1934b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (interfaceC1934b = this.f66818d) == null) {
            return;
        }
        interfaceC1934b.j(z);
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public boolean k(SurfaceTexture surfaceTexture, b.f fVar) {
        InterceptResult invokeLL;
        b.InterfaceC1934b interfaceC1934b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, surfaceTexture, fVar)) == null) {
            this.f66821g = surfaceTexture;
            this.f66820f = fVar;
            if (this.f66819e && (interfaceC1934b = this.f66817c) != null) {
                if (interfaceC1934b.k(surfaceTexture, fVar)) {
                    return true;
                }
                C();
                b.InterfaceC1934b interfaceC1934b2 = this.f66818d;
                if (interfaceC1934b2 != null) {
                    boolean k2 = interfaceC1934b2.k(surfaceTexture, fVar);
                    if (this.f66823i) {
                        this.f66823i = false;
                        this.f66818d.n();
                    }
                    return k2;
                }
                return false;
            }
            b.InterfaceC1934b interfaceC1934b3 = this.f66816b;
            this.f66818d = interfaceC1934b3;
            if (interfaceC1934b3 != null) {
                return interfaceC1934b3.k(surfaceTexture, fVar);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public void l(int i2) {
        b.InterfaceC1934b interfaceC1934b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (interfaceC1934b = this.f66818d) == null) {
            return;
        }
        interfaceC1934b.l(i2);
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public void m(boolean z) {
        b.InterfaceC1934b interfaceC1934b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (interfaceC1934b = this.f66818d) == null) {
            return;
        }
        interfaceC1934b.m(z);
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f66823i = true;
            b.InterfaceC1934b interfaceC1934b = this.f66818d;
            if (interfaceC1934b != null) {
                interfaceC1934b.n();
            }
        }
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            b.InterfaceC1934b interfaceC1934b = this.f66818d;
            if (interfaceC1934b != null) {
                return interfaceC1934b.o();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            b.InterfaceC1934b interfaceC1934b = this.f66818d;
            if (interfaceC1934b != null) {
                return interfaceC1934b.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public void q() {
        b.InterfaceC1934b interfaceC1934b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (interfaceC1934b = this.f66818d) == null) {
            return;
        }
        interfaceC1934b.q();
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            b.InterfaceC1934b interfaceC1934b = this.f66818d;
            if (interfaceC1934b != null) {
                return interfaceC1934b.r();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            q();
            this.f66818d = null;
            b.InterfaceC1934b interfaceC1934b = this.f66816b;
            if (interfaceC1934b != null) {
                interfaceC1934b.release();
            }
            b.InterfaceC1934b interfaceC1934b2 = this.f66817c;
            if (interfaceC1934b2 != null) {
                interfaceC1934b2.release();
            }
            k = null;
            this.f66820f = null;
            this.f66821g = null;
            this.j = null;
        }
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public void s(b.a aVar) {
        b.InterfaceC1934b interfaceC1934b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) || (interfaceC1934b = this.f66817c) == null) {
            return;
        }
        interfaceC1934b.s(aVar);
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public void t(int i2, int i3, int i4, int i5) {
        b.InterfaceC1934b interfaceC1934b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048597, this, i2, i3, i4, i5) == null) || (interfaceC1934b = this.f66818d) == null) {
            return;
        }
        interfaceC1934b.t(i2, i3, i4, i5);
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f66822h = i2;
            b.InterfaceC1934b interfaceC1934b = this.f66818d;
            if (interfaceC1934b != null) {
                interfaceC1934b.u(i2);
            }
        }
    }

    @Override // d.a.v0.p.b.InterfaceC1934b
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            b.InterfaceC1934b interfaceC1934b = this.f66818d;
            if (interfaceC1934b != null) {
                return interfaceC1934b.v();
            }
            return -1;
        }
        return invokeV.intValue;
    }
}
