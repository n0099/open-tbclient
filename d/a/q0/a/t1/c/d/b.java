package d.a.q0.a.t1.c.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.h0.m.o.a;
import d.a.q0.n.i.m.f;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.t1.c.b.b f50703a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h0.j.b f50704b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f50705c;

        public a(b bVar, d.a.q0.a.t1.c.b.b bVar2, d.a.q0.a.h0.j.b bVar3) {
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
            this.f50705c = bVar;
            this.f50703a = bVar2;
            this.f50704b = bVar3;
        }

        @Override // d.a.q0.a.h0.m.o.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.t1.d.a.a("payment fun page, your pkg is latest");
            }
        }

        @Override // d.a.q0.a.h0.m.o.a.b
        public void b(d.a.q0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f50705c.d(this.f50703a, false, this.f50704b);
            }
        }

        @Override // d.a.q0.a.h0.m.o.a.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f50705c.d(this.f50703a, true, this.f50704b);
            }
        }
    }

    /* renamed from: d.a.q0.a.t1.c.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0947b implements d.a.q0.a.h0.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.t1.c.b.b f50706a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h0.j.b f50707b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f50708c;

        public C0947b(b bVar, d.a.q0.a.t1.c.b.b bVar2, d.a.q0.a.h0.j.b bVar3) {
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
            this.f50708c = bVar;
            this.f50706a = bVar2;
            this.f50707b = bVar3;
        }

        @Override // d.a.q0.a.h0.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50708c.d(this.f50706a, true, this.f50707b);
            }
        }

        @Override // d.a.q0.a.h0.m.b
        public void b(int i2, d.a.q0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                this.f50708c.d(this.f50706a, false, this.f50707b);
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

    public abstract d.a.q0.a.u.h.b b(JSONObject jSONObject);

    public final void c(d.a.q0.a.t1.c.b.b bVar, String str, d.a.q0.a.h0.j.b<d.a.q0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str, bVar2) == null) {
            d.a.q0.a.t1.d.a.a("local has not main pkg, download fun page main pkg");
            d.a.q0.n.i.m.c cVar = new d.a.q0.n.i.m.c(str, d.a.q0.a.a2.d.g().l());
            cVar.o(0L);
            cVar.r(bVar.f50682c);
            cVar.d("3");
            d.a.q0.n.b.b(cVar, new d.a.q0.a.h0.m.o.a(str, new a(this, bVar, bVar2)));
        }
    }

    public final void d(d.a.q0.a.t1.c.b.b bVar, boolean z, d.a.q0.a.h0.j.b<d.a.q0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, Boolean.valueOf(z), bVar2}) == null) {
            if (z) {
                d.a.q0.a.t1.c.b.a f2 = f(bVar);
                if (f2 != null && f2.f50679f) {
                    d.a.q0.a.t1.d.a.a("payment fun page, download success, ready to jump");
                    j(f2.f50676c, bVar);
                    return;
                }
                d.a.q0.a.t1.d.a.a("payment fun page, download success, but not exist");
                d.a.q0.a.t1.c.c.a aVar = new d.a.q0.a.t1.c.c.a(bVar.f50685f);
                aVar.f50689a = bVar.f50684e;
                bVar2.a(aVar);
                return;
            }
            d.a.q0.a.t1.d.a.a("payment fun page, download failed");
            d.a.q0.a.t1.c.c.a aVar2 = new d.a.q0.a.t1.c.c.a(bVar.f50685f);
            aVar2.f50689a = bVar.f50684e;
            bVar2.a(aVar2);
        }
    }

    public final void e(d.a.q0.a.t1.c.b.b bVar, d.a.q0.a.t1.c.b.a aVar, d.a.q0.a.h0.j.b<d.a.q0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, bVar, aVar, bVar2) == null) {
            d.a.q0.a.t1.d.a.a("main pkg is exist, download fun page sub pkg");
            String str = aVar.f50674a;
            int i2 = aVar.f50677d;
            d.a.q0.n.b.f(new f(str, i2, d.a.q0.a.t1.g.b.e(aVar.f50676c, aVar.f50675b), 0), new d.a.q0.a.h0.m.q.a(str, String.valueOf(i2), new C0947b(this, bVar, bVar2)));
        }
    }

    public abstract d.a.q0.a.t1.c.b.a f(d.a.q0.a.t1.c.b.b bVar);

    public abstract String g();

    public abstract String h();

    public final boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(str, "develop") : invokeL.booleanValue;
    }

    public abstract d.a.q0.a.u.h.b j(String str, d.a.q0.a.t1.c.b.b bVar);

    public abstract boolean k();

    public final d.a.q0.a.u.h.b l(d.a.q0.a.t1.c.b.b bVar, d.a.q0.a.h0.j.b<d.a.q0.a.t1.c.c.a> bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bVar, bVar2)) == null) {
            d.a.q0.a.t1.d.a.a("open fun page start");
            if (bVar != null && bVar.a()) {
                d.a.q0.a.u.h.b b2 = b(bVar.f50686g);
                if (b2 != null) {
                    d.a.q0.a.t1.d.a.a("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    d.a.q0.a.t1.d.a.a("open payment fun page");
                    d.a.q0.a.t1.c.b.a f2 = f(bVar);
                    if (f2 == null) {
                        return new d.a.q0.a.u.h.b(1001, "fun page not exists");
                    }
                    if (!f2.f50679f) {
                        d.a.q0.a.t1.d.a.a("payment fun page, " + bVar.f50683d + " mode");
                        if (i(bVar.f50683d)) {
                            if (f2.f50678e) {
                                e(bVar, f2, bVar2);
                            } else {
                                return new d.a.q0.a.u.h.b(1001, "fun page not exists");
                            }
                        } else if (f2.f50678e) {
                            e(bVar, f2, bVar2);
                        } else {
                            c(bVar, f2.f50674a, bVar2);
                        }
                        d.a.q0.a.t1.d.a.a("open fun page end");
                        return new d.a.q0.a.u.h.b(0);
                    }
                    return j(f2.f50676c, bVar);
                } else {
                    d.a.q0.a.t1.d.a.a("open user info or choose address fun page");
                    return m(bVar, bVar2);
                }
            }
            d.a.q0.a.t1.d.a.a("params parse fail");
            return new d.a.q0.a.u.h.b(202, "params parse fail");
        }
        return (d.a.q0.a.u.h.b) invokeLL.objValue;
    }

    public abstract d.a.q0.a.u.h.b m(d.a.q0.a.t1.c.b.b bVar, d.a.q0.a.h0.j.b<d.a.q0.a.t1.c.c.a> bVar2);
}
