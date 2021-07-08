package d.f.b.a.a0.n;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.a0.e;
import d.f.b.a.a0.f;
import d.f.b.a.a0.g;
import d.f.b.a.a0.k;
import d.f.b.a.a0.l;
import d.f.b.a.i0.v;
import java.io.IOException;
/* loaded from: classes8.dex */
public final class b implements e, l {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.f.b.a.i0.l f69237a;

    /* renamed from: b  reason: collision with root package name */
    public final d.f.b.a.i0.l f69238b;

    /* renamed from: c  reason: collision with root package name */
    public final d.f.b.a.i0.l f69239c;

    /* renamed from: d  reason: collision with root package name */
    public final d.f.b.a.i0.l f69240d;

    /* renamed from: e  reason: collision with root package name */
    public g f69241e;

    /* renamed from: f  reason: collision with root package name */
    public int f69242f;

    /* renamed from: g  reason: collision with root package name */
    public int f69243g;

    /* renamed from: h  reason: collision with root package name */
    public int f69244h;

    /* renamed from: i  reason: collision with root package name */
    public int f69245i;
    public long j;
    public a k;
    public d l;
    public c m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1942550015, "Ld/f/b/a/a0/n/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1942550015, "Ld/f/b/a/a0/n/b;");
                return;
            }
        }
        n = v.q("FLV");
    }

    public b() {
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
        this.f69237a = new d.f.b.a.i0.l(4);
        this.f69238b = new d.f.b.a.i0.l(9);
        this.f69239c = new d.f.b.a.i0.l(11);
        this.f69240d = new d.f.b.a.i0.l();
        this.f69242f = 1;
    }

    @Override // d.f.b.a.a0.e
    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f69242f = 1;
            this.f69243g = 0;
        }
    }

    @Override // d.f.b.a.a0.l
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.f.b.a.a0.l
    public long c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            return 0L;
        }
        return invokeJ.longValue;
    }

    @Override // d.f.b.a.a0.e
    public boolean d(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            fVar.c(this.f69237a.f70489a, 0, 3);
            this.f69237a.J(0);
            if (this.f69237a.A() != n) {
                return false;
            }
            fVar.c(this.f69237a.f70489a, 0, 2);
            this.f69237a.J(0);
            if ((this.f69237a.D() & 250) != 0) {
                return false;
            }
            fVar.c(this.f69237a.f70489a, 0, 4);
            this.f69237a.J(0);
            int i2 = this.f69237a.i();
            fVar.e();
            fVar.g(i2);
            fVar.c(this.f69237a.f70489a, 0, 4);
            this.f69237a.J(0);
            return this.f69237a.i() == 0;
        }
        return invokeL.booleanValue;
    }

    @Override // d.f.b.a.a0.e
    public int e(f fVar, k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048580, this, fVar, kVar)) != null) {
            return invokeLL.intValue;
        }
        while (true) {
            int i2 = this.f69242f;
            if (i2 != 1) {
                if (i2 == 2) {
                    m(fVar);
                } else if (i2 != 3) {
                    if (i2 == 4 && k(fVar)) {
                        return 0;
                    }
                } else if (!l(fVar)) {
                    return -1;
                }
            } else if (!j(fVar)) {
                return -1;
            }
        }
    }

    @Override // d.f.b.a.a0.e
    public void f(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.f69241e = gVar;
        }
    }

    @Override // d.f.b.a.a0.l
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.m.d() : invokeV.longValue;
    }

    public final d.f.b.a.i0.l i(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fVar)) == null) {
            if (this.f69245i > this.f69240d.b()) {
                d.f.b.a.i0.l lVar = this.f69240d;
                lVar.H(new byte[Math.max(lVar.b() * 2, this.f69245i)], 0);
            } else {
                this.f69240d.J(0);
            }
            this.f69240d.I(this.f69245i);
            fVar.readFully(this.f69240d.f70489a, 0, this.f69245i);
            return this.f69240d;
        }
        return (d.f.b.a.i0.l) invokeL.objValue;
    }

    public final boolean j(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar)) == null) {
            if (fVar.a(this.f69238b.f70489a, 0, 9, true)) {
                this.f69238b.J(0);
                this.f69238b.K(4);
                int x = this.f69238b.x();
                boolean z = (x & 4) != 0;
                boolean z2 = (x & 1) != 0;
                if (z && this.k == null) {
                    this.k = new a(this.f69241e.a(8, 1));
                }
                if (z2 && this.l == null) {
                    this.l = new d(this.f69241e.a(9, 2));
                }
                if (this.m == null) {
                    this.m = new c(null);
                }
                this.f69241e.j();
                this.f69241e.p(this);
                this.f69243g = (this.f69238b.i() - 9) + 4;
                this.f69242f = 2;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean k(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        boolean z;
        c cVar;
        d dVar;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, fVar)) == null) {
            if (this.f69244h == 8 && (aVar = this.k) != null) {
                aVar.a(i(fVar), this.j);
            } else if (this.f69244h == 9 && (dVar = this.l) != null) {
                dVar.a(i(fVar), this.j);
            } else if (this.f69244h == 18 && (cVar = this.m) != null) {
                cVar.a(i(fVar), this.j);
            } else {
                fVar.h(this.f69245i);
                z = false;
                this.f69243g = 4;
                this.f69242f = 2;
                return z;
            }
            z = true;
            this.f69243g = 4;
            this.f69242f = 2;
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean l(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, fVar)) == null) {
            if (fVar.a(this.f69239c.f70489a, 0, 11, true)) {
                this.f69239c.J(0);
                this.f69244h = this.f69239c.x();
                this.f69245i = this.f69239c.A();
                this.j = this.f69239c.A();
                this.j = ((this.f69239c.x() << 24) | this.j) * 1000;
                this.f69239c.K(3);
                this.f69242f = 4;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void m(f fVar) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
            fVar.h(this.f69243g);
            this.f69243g = 0;
            this.f69242f = 3;
        }
    }

    @Override // d.f.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }
}
