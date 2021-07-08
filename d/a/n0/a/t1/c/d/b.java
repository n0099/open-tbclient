package d.a.n0.a.t1.c.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.h0.m.o.a;
import d.a.n0.n.i.m.f;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.t1.c.b.b f47401a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h0.j.b f47402b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f47403c;

        public a(b bVar, d.a.n0.a.t1.c.b.b bVar2, d.a.n0.a.h0.j.b bVar3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2, bVar3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47403c = bVar;
            this.f47401a = bVar2;
            this.f47402b = bVar3;
        }

        @Override // d.a.n0.a.h0.m.o.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.t1.d.a.a("payment fun page, your pkg is latest");
            }
        }

        @Override // d.a.n0.a.h0.m.o.a.b
        public void b(d.a.n0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f47403c.d(this.f47401a, false, this.f47402b);
            }
        }

        @Override // d.a.n0.a.h0.m.o.a.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f47403c.d(this.f47401a, true, this.f47402b);
            }
        }
    }

    /* renamed from: d.a.n0.a.t1.c.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0896b implements d.a.n0.a.h0.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.t1.c.b.b f47404a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h0.j.b f47405b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f47406c;

        public C0896b(b bVar, d.a.n0.a.t1.c.b.b bVar2, d.a.n0.a.h0.j.b bVar3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2, bVar3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47406c = bVar;
            this.f47404a = bVar2;
            this.f47405b = bVar3;
        }

        @Override // d.a.n0.a.h0.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47406c.d(this.f47404a, true, this.f47405b);
            }
        }

        @Override // d.a.n0.a.h0.m.b
        public void b(int i2, d.a.n0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                this.f47406c.d(this.f47404a, false, this.f47405b);
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract d.a.n0.a.u.h.b b(JSONObject jSONObject);

    public final void c(d.a.n0.a.t1.c.b.b bVar, String str, d.a.n0.a.h0.j.b<d.a.n0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str, bVar2) == null) {
            d.a.n0.a.t1.d.a.a("local has not main pkg, download fun page main pkg");
            d.a.n0.n.i.m.c cVar = new d.a.n0.n.i.m.c(str, d.a.n0.a.a2.d.g().l());
            cVar.o(0L);
            cVar.r(bVar.f47380c);
            cVar.d("3");
            d.a.n0.n.b.b(cVar, new d.a.n0.a.h0.m.o.a(str, new a(this, bVar, bVar2)));
        }
    }

    public final void d(d.a.n0.a.t1.c.b.b bVar, boolean z, d.a.n0.a.h0.j.b<d.a.n0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, Boolean.valueOf(z), bVar2}) == null) {
            if (z) {
                d.a.n0.a.t1.c.b.a f2 = f(bVar);
                if (f2 != null && f2.f47377f) {
                    d.a.n0.a.t1.d.a.a("payment fun page, download success, ready to jump");
                    j(f2.f47374c, bVar);
                    return;
                }
                d.a.n0.a.t1.d.a.a("payment fun page, download success, but not exist");
                d.a.n0.a.t1.c.c.a aVar = new d.a.n0.a.t1.c.c.a(bVar.f47383f);
                aVar.f47387a = bVar.f47382e;
                bVar2.a(aVar);
                return;
            }
            d.a.n0.a.t1.d.a.a("payment fun page, download failed");
            d.a.n0.a.t1.c.c.a aVar2 = new d.a.n0.a.t1.c.c.a(bVar.f47383f);
            aVar2.f47387a = bVar.f47382e;
            bVar2.a(aVar2);
        }
    }

    public final void e(d.a.n0.a.t1.c.b.b bVar, d.a.n0.a.t1.c.b.a aVar, d.a.n0.a.h0.j.b<d.a.n0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, bVar, aVar, bVar2) == null) {
            d.a.n0.a.t1.d.a.a("main pkg is exist, download fun page sub pkg");
            String str = aVar.f47372a;
            int i2 = aVar.f47375d;
            d.a.n0.n.b.f(new f(str, i2, d.a.n0.a.t1.g.b.e(aVar.f47374c, aVar.f47373b), 0), new d.a.n0.a.h0.m.q.a(str, String.valueOf(i2), new C0896b(this, bVar, bVar2)));
        }
    }

    public abstract d.a.n0.a.t1.c.b.a f(d.a.n0.a.t1.c.b.b bVar);

    public abstract String g();

    public abstract String h();

    public final boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(str, "develop") : invokeL.booleanValue;
    }

    public abstract d.a.n0.a.u.h.b j(String str, d.a.n0.a.t1.c.b.b bVar);

    public abstract boolean k();

    public final d.a.n0.a.u.h.b l(d.a.n0.a.t1.c.b.b bVar, d.a.n0.a.h0.j.b<d.a.n0.a.t1.c.c.a> bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bVar, bVar2)) == null) {
            d.a.n0.a.t1.d.a.a("open fun page start");
            if (bVar != null && bVar.a()) {
                d.a.n0.a.u.h.b b2 = b(bVar.f47384g);
                if (b2 != null) {
                    d.a.n0.a.t1.d.a.a("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    d.a.n0.a.t1.d.a.a("open payment fun page");
                    d.a.n0.a.t1.c.b.a f2 = f(bVar);
                    if (f2 == null) {
                        return new d.a.n0.a.u.h.b(1001, "fun page not exists");
                    }
                    if (!f2.f47377f) {
                        d.a.n0.a.t1.d.a.a("payment fun page, " + bVar.f47381d + " mode");
                        if (i(bVar.f47381d)) {
                            if (f2.f47376e) {
                                e(bVar, f2, bVar2);
                            } else {
                                return new d.a.n0.a.u.h.b(1001, "fun page not exists");
                            }
                        } else if (f2.f47376e) {
                            e(bVar, f2, bVar2);
                        } else {
                            c(bVar, f2.f47372a, bVar2);
                        }
                        d.a.n0.a.t1.d.a.a("open fun page end");
                        return new d.a.n0.a.u.h.b(0);
                    }
                    return j(f2.f47374c, bVar);
                } else {
                    d.a.n0.a.t1.d.a.a("open user info or choose address fun page");
                    return m(bVar, bVar2);
                }
            }
            d.a.n0.a.t1.d.a.a("params parse fail");
            return new d.a.n0.a.u.h.b(202, "params parse fail");
        }
        return (d.a.n0.a.u.h.b) invokeLL.objValue;
    }

    public abstract d.a.n0.a.u.h.b m(d.a.n0.a.t1.c.b.b bVar, d.a.n0.a.h0.j.b<d.a.n0.a.t1.c.c.a> bVar2);
}
