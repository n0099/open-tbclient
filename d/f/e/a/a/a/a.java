package d.f.e.a.a.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f73857a;

    /* renamed from: b  reason: collision with root package name */
    public b f73858b;

    /* renamed from: c  reason: collision with root package name */
    public b f73859c;

    /* renamed from: d  reason: collision with root package name */
    public g f73860d;

    /* renamed from: e  reason: collision with root package name */
    public g f73861e;

    /* renamed from: f  reason: collision with root package name */
    public C2037a f73862f;

    /* renamed from: g  reason: collision with root package name */
    public C2037a f73863g;

    /* renamed from: d.f.e.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C2037a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f73864a;

        /* renamed from: b  reason: collision with root package name */
        public int f73865b;

        public C2037a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73864a = i2;
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f73865b = !z ? 0 : this.f73865b + 1;
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f73865b >= this.f73864a : invokeV.booleanValue;
        }
    }

    public a() {
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
        a();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f73860d = new g();
            this.f73861e = new g();
            this.f73857a = new b(1.0d);
            this.f73858b = new b(10.0d);
            this.f73859c = new b(0.15000000596046448d);
            this.f73862f = new C2037a(10);
            this.f73863g = new C2037a(10);
        }
    }

    public void b(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
            if (this.f73859c.a() < 30) {
                gVar.b();
                return;
            }
            gVar.f(this.f73859c.d());
            gVar.c(Math.min(1.0d, (this.f73859c.a() - 30) / 100.0d));
        }
    }

    public void c(g gVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, gVar, j) == null) {
            this.f73858b.b(gVar, j);
            g.k(gVar, this.f73858b.d(), this.f73860d);
            this.f73863g.a(this.f73860d.l() < 0.00800000037997961d);
            if (this.f73863g.b() && this.f73862f.b()) {
                e(gVar, j);
            }
        }
    }

    public void d(g gVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, gVar, j) == null) {
            this.f73857a.b(gVar, j);
            g.k(gVar, this.f73857a.d(), this.f73861e);
            this.f73862f.a(this.f73861e.l() < 0.5d);
        }
    }

    public final void e(g gVar, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048580, this, gVar, j) == null) || gVar.l() >= 0.3499999940395355d) {
            return;
        }
        double max = Math.max(0.0d, 1.0d - (gVar.l() / 0.3499999940395355d));
        this.f73859c.c(this.f73858b.d(), j, max * max);
    }
}
