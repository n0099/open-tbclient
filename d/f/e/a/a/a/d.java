package d.f.e.a.a.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c A;
    public g B;
    public c C;
    public c D;
    public c E;
    public c F;
    public c G;
    public c H;
    public c I;
    public g J;
    public g K;
    public g L;
    public c M;
    public c N;
    public c O;
    public boolean P;
    public e Q;

    /* renamed from: a  reason: collision with root package name */
    public double[] f73873a;

    /* renamed from: b  reason: collision with root package name */
    public c f73874b;

    /* renamed from: c  reason: collision with root package name */
    public c f73875c;

    /* renamed from: d  reason: collision with root package name */
    public c f73876d;

    /* renamed from: e  reason: collision with root package name */
    public c f73877e;

    /* renamed from: f  reason: collision with root package name */
    public c f73878f;

    /* renamed from: g  reason: collision with root package name */
    public c f73879g;

    /* renamed from: h  reason: collision with root package name */
    public c f73880h;

    /* renamed from: i  reason: collision with root package name */
    public c f73881i;
    public c j;
    public g k;
    public g l;
    public g m;
    public g n;
    public g o;
    public g p;
    public g q;
    public long r;
    public final g s;
    public double t;
    public double u;
    public float v;
    public boolean w;
    public int x;
    public boolean y;
    public c z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1828934123, "Ld/f/e/a/a/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1828934123, "Ld/f/e/a/a/a/d;");
                return;
            }
        }
        d.class.desiredAssertionStatus();
    }

    public d() {
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
        this.f73873a = new double[16];
        this.f73874b = new c();
        this.f73875c = new c();
        this.f73876d = new c();
        this.f73877e = new c();
        this.f73878f = new c();
        this.f73879g = new c();
        this.f73880h = new c();
        this.f73881i = new c();
        this.j = new c();
        this.k = new g();
        this.l = new g();
        this.m = new g();
        this.n = new g();
        this.o = new g();
        this.p = new g();
        this.q = new g();
        this.s = new g();
        this.t = 0.0d;
        this.u = 0.0d;
        this.w = false;
        this.y = true;
        this.z = new c();
        this.A = new c();
        this.B = new g();
        this.C = new c();
        this.D = new c();
        this.E = new c();
        this.F = new c();
        this.G = new c();
        this.H = new c();
        this.I = new c();
        this.J = new g();
        this.K = new g();
        this.L = new g();
        this.M = new c();
        this.N = new c();
        this.O = new c();
        this.Q = new e();
        a();
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.r = 0L;
                this.f73874b.j();
                this.f73875c.j();
                this.f73876d.b();
                this.f73876d.c(25.0d);
                this.f73877e.b();
                this.f73877e.c(1.0d);
                this.f73878f.b();
                this.f73878f.c(0.0625d);
                this.f73879g.b();
                this.f73879g.c(0.5625d);
                this.f73880h.b();
                this.f73881i.b();
                this.j.b();
                this.k.b();
                this.l.b();
                this.m.b();
                this.n.b();
                this.o.b();
                this.p.d(0.0d, 0.0d, 9.81d);
                this.q.d(0.0d, 1.0d, 0.0d);
                this.P = false;
            }
        }
    }

    public final void b(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            if (!this.w) {
                this.v = f2;
                this.x = 1;
                this.w = true;
                return;
            }
            this.v = (this.v * 0.95f) + (f2 * 0.050000012f);
            int i2 = this.x + 1;
            this.x = i2;
            if (i2 > 10.0f) {
                this.y = true;
            }
        }
    }

    public final void c(c cVar, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, gVar) == null) {
            c.i(cVar, this.p, this.m);
            this.Q.d(this.m, this.l, this.O);
            this.Q.a(this.O, gVar);
        }
    }

    public synchronized void d(g gVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, gVar, j) == null) {
            synchronized (this) {
                if (this.r != 0) {
                    float f2 = ((float) (j - this.r)) * 1.0E-9f;
                    if (f2 > 0.04f) {
                        f2 = this.y ? this.v : 0.01f;
                    } else {
                        b(f2);
                    }
                    this.n.f(gVar);
                    this.n.c(-f2);
                    f.b(this.n, this.f73875c);
                    this.C.g(this.f73874b);
                    c.m(this.f73875c, this.f73874b, this.C);
                    this.f73874b.g(this.C);
                    j();
                    this.D.g(this.f73877e);
                    this.D.k(f2 * f2);
                    this.f73876d.l(this.D);
                }
                this.r = j;
                this.s.f(gVar);
            }
        }
    }

    public double[] e(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d2)})) == null) {
            g gVar = this.B;
            gVar.f(this.s);
            gVar.c(-d2);
            c cVar = this.z;
            f.b(gVar, cVar);
            c cVar2 = this.A;
            c.m(cVar, this.f73874b, cVar2);
            return f(cVar2);
        }
        return (double[]) invokeCommon.objValue;
    }

    public final double[] f(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
            for (int i2 = 0; i2 < 3; i2++) {
                for (int i3 = 0; i3 < 3; i3++) {
                    this.f73873a[(i3 * 4) + i2] = cVar.a(i2, i3);
                }
            }
            double[] dArr = this.f73873a;
            dArr[11] = 0.0d;
            dArr[7] = 0.0d;
            dArr[3] = 0.0d;
            dArr[14] = 0.0d;
            dArr[13] = 0.0d;
            dArr[12] = 0.0d;
            dArr[15] = 1.0d;
            return dArr;
        }
        return (double[]) invokeL.objValue;
    }

    public final void g(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Double.valueOf(d2)}) == null) {
            double abs = Math.abs(d2 - this.t);
            this.t = d2;
            double d3 = (abs * 0.5d) + (this.u * 0.5d);
            this.u = d3;
            double min = Math.min(7.0d, ((d3 / 0.15d) * 6.25d) + 0.75d);
            this.f73879g.c(min * min);
        }
    }

    public synchronized void h(g gVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048583, this, gVar, j) == null) {
            synchronized (this) {
                this.l.f(gVar);
                g(this.l.l());
                if (this.P) {
                    c(this.f73874b, this.k);
                    for (int i2 = 0; i2 < 3; i2++) {
                        g gVar2 = this.L;
                        gVar2.b();
                        gVar2.e(i2, 1.0E-7d);
                        f.b(gVar2, this.E);
                        c.m(this.E, this.f73874b, this.F);
                        c(this.F, this.J);
                        g.k(this.k, this.J, this.K);
                        this.K.c(1.0E7d);
                        this.f73881i.f(i2, this.K);
                    }
                    this.f73881i.q(this.G);
                    c.m(this.f73876d, this.G, this.H);
                    c.m(this.f73881i, this.H, this.I);
                    c.h(this.I, this.f73879g, this.f73880h);
                    this.f73880h.r(this.G);
                    this.f73881i.q(this.H);
                    c.m(this.H, this.G, this.I);
                    c.m(this.f73876d, this.I, this.j);
                    c.i(this.j, this.k, this.o);
                    c.m(this.j, this.f73881i, this.G);
                    this.H.j();
                    this.H.o(this.G);
                    c.m(this.H, this.f73876d, this.G);
                    this.f73876d.g(this.G);
                    f.b(this.o, this.f73875c);
                    c.m(this.f73875c, this.f73874b, this.f73874b);
                    j();
                } else {
                    this.Q.d(this.p, this.l, this.f73874b);
                    this.P = true;
                }
            }
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.P : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f73875c.q(this.M);
            c.m(this.f73876d, this.M, this.N);
            c.m(this.f73875c, this.N, this.f73876d);
            this.f73875c.j();
        }
    }
}
