package d.f.e.a.a.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f73882a;

    /* renamed from: b  reason: collision with root package name */
    public g f73883b;

    /* renamed from: c  reason: collision with root package name */
    public g f73884c;

    /* renamed from: d  reason: collision with root package name */
    public g f73885d;

    /* renamed from: e  reason: collision with root package name */
    public g f73886e;

    /* renamed from: f  reason: collision with root package name */
    public c f73887f;

    /* renamed from: g  reason: collision with root package name */
    public c f73888g;

    /* renamed from: h  reason: collision with root package name */
    public g f73889h;

    /* renamed from: i  reason: collision with root package name */
    public g f73890i;

    public e() {
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
        this.f73882a = new g();
        this.f73883b = new g();
        this.f73884c = new g();
        this.f73885d = new g();
        this.f73886e = new g();
        this.f73887f = new c();
        this.f73888g = new c();
        this.f73889h = new g();
        this.f73890i = new g();
    }

    public static void b(g gVar, double d2, double d3, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{gVar, Double.valueOf(d2), Double.valueOf(d3), cVar}) == null) {
            double d4 = gVar.f73891a;
            double d5 = d4 * d4;
            double d6 = gVar.f73892b;
            double d7 = d6 * d6;
            double d8 = gVar.f73893c;
            double d9 = d8 * d8;
            cVar.e(0, 0, 1.0d - ((d7 + d9) * d3));
            cVar.e(1, 1, 1.0d - ((d9 + d5) * d3));
            cVar.e(2, 2, 1.0d - ((d5 + d7) * d3));
            double d10 = gVar.f73893c * d2;
            double d11 = gVar.f73891a * gVar.f73892b * d3;
            cVar.e(0, 1, d11 - d10);
            cVar.e(1, 0, d11 + d10);
            double d12 = gVar.f73892b * d2;
            double d13 = gVar.f73891a * gVar.f73893c * d3;
            cVar.e(0, 2, d13 + d12);
            cVar.e(2, 0, d13 - d12);
            double d14 = gVar.f73891a * d2;
            double d15 = gVar.f73892b * gVar.f73893c * d3;
            cVar.e(1, 2, d15 - d14);
            cVar.e(2, 1, d15 + d14);
        }
    }

    public void a(c cVar, g gVar) {
        double acos;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, gVar) == null) {
            double a2 = (((cVar.a(0, 0) + cVar.a(1, 1)) + cVar.a(2, 2)) - 1.0d) * 0.5d;
            gVar.d((cVar.a(2, 1) - cVar.a(1, 2)) / 2.0d, (cVar.a(0, 2) - cVar.a(2, 0)) / 2.0d, (cVar.a(1, 0) - cVar.a(0, 1)) / 2.0d);
            double l = gVar.l();
            if (a2 > 0.7071067811865476d) {
                if (l > 0.0d) {
                    acos = Math.asin(l);
                }
            } else if (a2 <= -0.7071067811865476d) {
                double asin = 3.141592653589793d - Math.asin(l);
                double a3 = cVar.a(0, 0) - a2;
                double a4 = cVar.a(1, 1) - a2;
                double a5 = cVar.a(2, 2) - a2;
                g gVar2 = this.f73889h;
                double d2 = a3 * a3;
                double d3 = a4 * a4;
                if (d2 > d3 && d2 > a5 * a5) {
                    gVar2.d(a3, (cVar.a(1, 0) + cVar.a(0, 1)) / 2.0d, (cVar.a(0, 2) + cVar.a(2, 0)) / 2.0d);
                } else if (d3 > a5 * a5) {
                    gVar2.d((cVar.a(1, 0) + cVar.a(0, 1)) / 2.0d, a4, (cVar.a(2, 1) + cVar.a(1, 2)) / 2.0d);
                } else {
                    gVar2.d((cVar.a(0, 2) + cVar.a(2, 0)) / 2.0d, (cVar.a(2, 1) + cVar.a(1, 2)) / 2.0d, a5);
                }
                if (g.a(gVar2, gVar) < 0.0d) {
                    gVar2.c(-1.0d);
                }
                gVar2.i();
                gVar2.c(asin);
                gVar.f(gVar2);
                return;
            } else {
                acos = Math.acos(a2);
            }
            gVar.c(acos / l);
        }
    }

    public final void c(g gVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, cVar) == null) {
            this.f73890i.f(gVar);
            g gVar2 = this.f73890i;
            gVar2.c(3.141592653589793d / gVar2.l());
            b(this.f73890i, 0.0d, 0.20264236728467558d, cVar);
        }
    }

    public void d(g gVar, g gVar2, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, gVar, gVar2, cVar) == null) {
            g.m(gVar, gVar2, this.f73883b);
            if (this.f73883b.l() == 0.0d) {
                if (g.a(gVar, gVar2) >= 0.0d) {
                    cVar.j();
                    return;
                }
                g.j(gVar, this.f73886e);
                c(this.f73886e, cVar);
                return;
            }
            this.f73884c.f(gVar);
            this.f73885d.f(gVar2);
            this.f73883b.i();
            this.f73884c.i();
            this.f73885d.i();
            c cVar2 = this.f73887f;
            cVar2.f(0, this.f73884c);
            cVar2.f(1, this.f73883b);
            g.m(this.f73883b, this.f73884c, this.f73882a);
            cVar2.f(2, this.f73882a);
            c cVar3 = this.f73888g;
            cVar3.f(0, this.f73885d);
            cVar3.f(1, this.f73883b);
            g.m(this.f73883b, this.f73885d, this.f73882a);
            cVar3.f(2, this.f73882a);
            cVar2.n();
            c.m(cVar3, cVar2, cVar);
        }
    }
}
