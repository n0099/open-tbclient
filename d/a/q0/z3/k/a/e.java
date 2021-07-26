package d.a.q0.z3.k.a;

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
import d.a.w0.p.b;
/* loaded from: classes8.dex */
public class e implements b.InterfaceC1939b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f67493a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC1939b f67494b;

    /* renamed from: c  reason: collision with root package name */
    public b.InterfaceC1939b f67495c;

    /* renamed from: d  reason: collision with root package name */
    public b.InterfaceC1939b f67496d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67497e;

    /* renamed from: f  reason: collision with root package name */
    public b.f f67498f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f67499g;

    /* renamed from: h  reason: collision with root package name */
    public int f67500h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f67501i;
    public b.a j;

    /* loaded from: classes8.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f67502a;

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
            this.f67502a = eVar;
        }

        @Override // d.a.w0.p.b.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof String) {
                    String str = (String) obj;
                }
                this.f67502a.C();
                this.f67502a.f67496d.k(this.f67502a.f67499g, this.f67502a.f67498f);
                if (this.f67502a.f67501i) {
                    this.f67502a.f67501i = false;
                    this.f67502a.f67496d.n();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-509125645, "Ld/a/q0/z3/k/a/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-509125645, "Ld/a/q0/z3/k/a/e;");
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
        this.f67497e = false;
        this.f67501i = false;
        this.j = new a(this);
        if (Build.VERSION.SDK_INT >= 21) {
            if (System.currentTimeMillis() - c.f67490b.c() >= c.f67489a) {
                c.f67490b.k(0);
            }
            if (1 != c.f67490b.d().intValue()) {
                this.f67495c = b.U(tbPageContext);
            }
        }
        d B = d.B(tbPageContext);
        this.f67494b = B;
        this.f67496d = B;
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
                        k.f67493a = tbPageContext;
                    }
                }
            }
            return k;
        }
        return (e) invokeL.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f67495c == null) {
            return;
        }
        this.f67494b.u(this.f67500h);
        this.f67494b.i(this.f67495c.o());
        this.f67494b.m(this.f67495c.a());
        this.f67494b.j(this.f67495c.p());
        this.f67495c.q();
        this.f67495c.release();
        this.f67496d = this.f67494b;
        this.f67497e = false;
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.InterfaceC1939b interfaceC1939b = this.f67496d;
            if (interfaceC1939b != null) {
                return interfaceC1939b.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.InterfaceC1939b interfaceC1939b = this.f67496d;
            if (interfaceC1939b != null) {
                return interfaceC1939b.b();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public void c(int i2, int i3, int i4, int i5) {
        b.InterfaceC1939b interfaceC1939b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) || (interfaceC1939b = this.f67496d) == null) {
            return;
        }
        interfaceC1939b.c(i2, i3, i4, i5);
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public void d(byte[] bArr) {
        b.InterfaceC1939b interfaceC1939b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) && (interfaceC1939b = this.f67496d) == this.f67494b && interfaceC1939b != null) {
            interfaceC1939b.d(bArr);
        }
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.InterfaceC1939b interfaceC1939b = this.f67496d;
            if (interfaceC1939b != null) {
                return interfaceC1939b.e();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b.InterfaceC1939b interfaceC1939b = this.f67496d;
            if (interfaceC1939b != null) {
                return interfaceC1939b.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public void g(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            this.f67494b.g(i2, i3, i4, z);
            b.InterfaceC1939b interfaceC1939b = this.f67495c;
            if (interfaceC1939b != null) {
                interfaceC1939b.g(i2, i3, i4, z);
            }
        }
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public void h(boolean z) {
        b.InterfaceC1939b interfaceC1939b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f67497e = z;
            if (z && (interfaceC1939b = this.f67495c) != null) {
                interfaceC1939b.s(this.j);
                this.f67496d = this.f67495c;
                return;
            }
            b.InterfaceC1939b interfaceC1939b2 = this.f67495c;
            if (interfaceC1939b2 != null) {
                interfaceC1939b2.release();
            }
            this.f67496d = this.f67494b;
        }
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public void i(boolean z) {
        b.InterfaceC1939b interfaceC1939b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (interfaceC1939b = this.f67496d) == null) {
            return;
        }
        interfaceC1939b.i(z);
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public void j(boolean z) {
        b.InterfaceC1939b interfaceC1939b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (interfaceC1939b = this.f67496d) == null) {
            return;
        }
        interfaceC1939b.j(z);
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public boolean k(SurfaceTexture surfaceTexture, b.f fVar) {
        InterceptResult invokeLL;
        b.InterfaceC1939b interfaceC1939b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, surfaceTexture, fVar)) == null) {
            this.f67499g = surfaceTexture;
            this.f67498f = fVar;
            if (this.f67497e && (interfaceC1939b = this.f67495c) != null) {
                if (interfaceC1939b.k(surfaceTexture, fVar)) {
                    return true;
                }
                C();
                b.InterfaceC1939b interfaceC1939b2 = this.f67496d;
                if (interfaceC1939b2 != null) {
                    boolean k2 = interfaceC1939b2.k(surfaceTexture, fVar);
                    if (this.f67501i) {
                        this.f67501i = false;
                        this.f67496d.n();
                    }
                    return k2;
                }
                return false;
            }
            b.InterfaceC1939b interfaceC1939b3 = this.f67494b;
            this.f67496d = interfaceC1939b3;
            if (interfaceC1939b3 != null) {
                return interfaceC1939b3.k(surfaceTexture, fVar);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public void l(int i2) {
        b.InterfaceC1939b interfaceC1939b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (interfaceC1939b = this.f67496d) == null) {
            return;
        }
        interfaceC1939b.l(i2);
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public void m(boolean z) {
        b.InterfaceC1939b interfaceC1939b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (interfaceC1939b = this.f67496d) == null) {
            return;
        }
        interfaceC1939b.m(z);
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f67501i = true;
            b.InterfaceC1939b interfaceC1939b = this.f67496d;
            if (interfaceC1939b != null) {
                interfaceC1939b.n();
            }
        }
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            b.InterfaceC1939b interfaceC1939b = this.f67496d;
            if (interfaceC1939b != null) {
                return interfaceC1939b.o();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            b.InterfaceC1939b interfaceC1939b = this.f67496d;
            if (interfaceC1939b != null) {
                return interfaceC1939b.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public void q() {
        b.InterfaceC1939b interfaceC1939b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (interfaceC1939b = this.f67496d) == null) {
            return;
        }
        interfaceC1939b.q();
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            b.InterfaceC1939b interfaceC1939b = this.f67496d;
            if (interfaceC1939b != null) {
                return interfaceC1939b.r();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            q();
            this.f67496d = null;
            b.InterfaceC1939b interfaceC1939b = this.f67494b;
            if (interfaceC1939b != null) {
                interfaceC1939b.release();
            }
            b.InterfaceC1939b interfaceC1939b2 = this.f67495c;
            if (interfaceC1939b2 != null) {
                interfaceC1939b2.release();
            }
            k = null;
            this.f67498f = null;
            this.f67499g = null;
            this.j = null;
        }
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public void s(b.a aVar) {
        b.InterfaceC1939b interfaceC1939b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) || (interfaceC1939b = this.f67495c) == null) {
            return;
        }
        interfaceC1939b.s(aVar);
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public void t(int i2, int i3, int i4, int i5) {
        b.InterfaceC1939b interfaceC1939b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048597, this, i2, i3, i4, i5) == null) || (interfaceC1939b = this.f67496d) == null) {
            return;
        }
        interfaceC1939b.t(i2, i3, i4, i5);
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f67500h = i2;
            b.InterfaceC1939b interfaceC1939b = this.f67496d;
            if (interfaceC1939b != null) {
                interfaceC1939b.u(i2);
            }
        }
    }

    @Override // d.a.w0.p.b.InterfaceC1939b
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            b.InterfaceC1939b interfaceC1939b = this.f67496d;
            if (interfaceC1939b != null) {
                return interfaceC1939b.v();
            }
            return -1;
        }
        return invokeV.intValue;
    }
}
