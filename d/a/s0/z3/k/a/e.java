package d.a.s0.z3.k.a;

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
import d.a.y0.p.b;
/* loaded from: classes9.dex */
public class e implements b.InterfaceC1975b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f70012a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC1975b f70013b;

    /* renamed from: c  reason: collision with root package name */
    public b.InterfaceC1975b f70014c;

    /* renamed from: d  reason: collision with root package name */
    public b.InterfaceC1975b f70015d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f70016e;

    /* renamed from: f  reason: collision with root package name */
    public b.f f70017f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f70018g;

    /* renamed from: h  reason: collision with root package name */
    public int f70019h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f70020i;
    public b.a j;

    /* loaded from: classes9.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f70021a;

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
            this.f70021a = eVar;
        }

        @Override // d.a.y0.p.b.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof String) {
                    String str = (String) obj;
                }
                this.f70021a.C();
                this.f70021a.f70015d.k(this.f70021a.f70018g, this.f70021a.f70017f);
                if (this.f70021a.f70020i) {
                    this.f70021a.f70020i = false;
                    this.f70021a.f70015d.n();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-250960207, "Ld/a/s0/z3/k/a/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-250960207, "Ld/a/s0/z3/k/a/e;");
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
        this.f70016e = false;
        this.f70020i = false;
        this.j = new a(this);
        if (Build.VERSION.SDK_INT >= 21) {
            if (System.currentTimeMillis() - c.f70009b.c() >= c.f70008a) {
                c.f70009b.k(0);
            }
            if (1 != c.f70009b.d().intValue()) {
                this.f70014c = b.U(tbPageContext);
            }
        }
        d B = d.B(tbPageContext);
        this.f70013b = B;
        this.f70015d = B;
    }

    public static e D(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, tbPageContext)) == null) {
            if (k == null) {
                synchronized (e.class) {
                    if (k == null) {
                        k = new e(tbPageContext);
                    } else if (tbPageContext != null) {
                        k.f70012a = tbPageContext;
                    }
                }
            }
            return k;
        }
        return (e) invokeL.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f70014c == null) {
            return;
        }
        this.f70013b.u(this.f70019h);
        this.f70013b.i(this.f70014c.o());
        this.f70013b.m(this.f70014c.a());
        this.f70013b.j(this.f70014c.p());
        this.f70014c.q();
        this.f70014c.release();
        this.f70015d = this.f70013b;
        this.f70016e = false;
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.InterfaceC1975b interfaceC1975b = this.f70015d;
            if (interfaceC1975b != null) {
                return interfaceC1975b.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.InterfaceC1975b interfaceC1975b = this.f70015d;
            if (interfaceC1975b != null) {
                return interfaceC1975b.b();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public void c(int i2, int i3, int i4, int i5) {
        b.InterfaceC1975b interfaceC1975b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) || (interfaceC1975b = this.f70015d) == null) {
            return;
        }
        interfaceC1975b.c(i2, i3, i4, i5);
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public void d(byte[] bArr) {
        b.InterfaceC1975b interfaceC1975b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) && (interfaceC1975b = this.f70015d) == this.f70013b && interfaceC1975b != null) {
            interfaceC1975b.d(bArr);
        }
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.InterfaceC1975b interfaceC1975b = this.f70015d;
            if (interfaceC1975b != null) {
                return interfaceC1975b.e();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b.InterfaceC1975b interfaceC1975b = this.f70015d;
            if (interfaceC1975b != null) {
                return interfaceC1975b.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public void g(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            this.f70013b.g(i2, i3, i4, z);
            b.InterfaceC1975b interfaceC1975b = this.f70014c;
            if (interfaceC1975b != null) {
                interfaceC1975b.g(i2, i3, i4, z);
            }
        }
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public void h(boolean z) {
        b.InterfaceC1975b interfaceC1975b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f70016e = z;
            if (z && (interfaceC1975b = this.f70014c) != null) {
                interfaceC1975b.s(this.j);
                this.f70015d = this.f70014c;
                return;
            }
            b.InterfaceC1975b interfaceC1975b2 = this.f70014c;
            if (interfaceC1975b2 != null) {
                interfaceC1975b2.release();
            }
            this.f70015d = this.f70013b;
        }
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public void i(boolean z) {
        b.InterfaceC1975b interfaceC1975b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (interfaceC1975b = this.f70015d) == null) {
            return;
        }
        interfaceC1975b.i(z);
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public void j(boolean z) {
        b.InterfaceC1975b interfaceC1975b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (interfaceC1975b = this.f70015d) == null) {
            return;
        }
        interfaceC1975b.j(z);
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public boolean k(SurfaceTexture surfaceTexture, b.f fVar) {
        InterceptResult invokeLL;
        b.InterfaceC1975b interfaceC1975b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, surfaceTexture, fVar)) == null) {
            this.f70018g = surfaceTexture;
            this.f70017f = fVar;
            if (this.f70016e && (interfaceC1975b = this.f70014c) != null) {
                if (interfaceC1975b.k(surfaceTexture, fVar)) {
                    return true;
                }
                C();
                b.InterfaceC1975b interfaceC1975b2 = this.f70015d;
                if (interfaceC1975b2 != null) {
                    boolean k2 = interfaceC1975b2.k(surfaceTexture, fVar);
                    if (this.f70020i) {
                        this.f70020i = false;
                        this.f70015d.n();
                    }
                    return k2;
                }
                return false;
            }
            b.InterfaceC1975b interfaceC1975b3 = this.f70013b;
            this.f70015d = interfaceC1975b3;
            if (interfaceC1975b3 != null) {
                return interfaceC1975b3.k(surfaceTexture, fVar);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public void l(int i2) {
        b.InterfaceC1975b interfaceC1975b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (interfaceC1975b = this.f70015d) == null) {
            return;
        }
        interfaceC1975b.l(i2);
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public void m(boolean z) {
        b.InterfaceC1975b interfaceC1975b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (interfaceC1975b = this.f70015d) == null) {
            return;
        }
        interfaceC1975b.m(z);
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f70020i = true;
            b.InterfaceC1975b interfaceC1975b = this.f70015d;
            if (interfaceC1975b != null) {
                interfaceC1975b.n();
            }
        }
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            b.InterfaceC1975b interfaceC1975b = this.f70015d;
            if (interfaceC1975b != null) {
                return interfaceC1975b.o();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            b.InterfaceC1975b interfaceC1975b = this.f70015d;
            if (interfaceC1975b != null) {
                return interfaceC1975b.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public void q() {
        b.InterfaceC1975b interfaceC1975b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (interfaceC1975b = this.f70015d) == null) {
            return;
        }
        interfaceC1975b.q();
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            b.InterfaceC1975b interfaceC1975b = this.f70015d;
            if (interfaceC1975b != null) {
                return interfaceC1975b.r();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            q();
            this.f70015d = null;
            b.InterfaceC1975b interfaceC1975b = this.f70013b;
            if (interfaceC1975b != null) {
                interfaceC1975b.release();
            }
            b.InterfaceC1975b interfaceC1975b2 = this.f70014c;
            if (interfaceC1975b2 != null) {
                interfaceC1975b2.release();
            }
            k = null;
            this.f70017f = null;
            this.f70018g = null;
            this.j = null;
        }
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public void s(b.a aVar) {
        b.InterfaceC1975b interfaceC1975b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) || (interfaceC1975b = this.f70014c) == null) {
            return;
        }
        interfaceC1975b.s(aVar);
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public void t(int i2, int i3, int i4, int i5) {
        b.InterfaceC1975b interfaceC1975b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048597, this, i2, i3, i4, i5) == null) || (interfaceC1975b = this.f70015d) == null) {
            return;
        }
        interfaceC1975b.t(i2, i3, i4, i5);
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f70019h = i2;
            b.InterfaceC1975b interfaceC1975b = this.f70015d;
            if (interfaceC1975b != null) {
                interfaceC1975b.u(i2);
            }
        }
    }

    @Override // d.a.y0.p.b.InterfaceC1975b
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            b.InterfaceC1975b interfaceC1975b = this.f70015d;
            if (interfaceC1975b != null) {
                return interfaceC1975b.v();
            }
            return -1;
        }
        return invokeV.intValue;
    }
}
