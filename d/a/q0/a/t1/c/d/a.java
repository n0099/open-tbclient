package d.a.q0.a.t1.c.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class a extends d.a.q0.a.t1.c.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.a.t1.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0946a implements d.a.q0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.t1.c.b.b f50695e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h0.j.b f50696f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f50697g;

        public C0946a(a aVar, d.a.q0.a.t1.c.b.b bVar, d.a.q0.a.h0.j.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50697g = aVar;
            this.f50695e = bVar;
            this.f50696f = bVar2;
        }

        @Override // d.a.q0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    d.a.q0.a.t1.c.c.a aVar = new d.a.q0.a.t1.c.c.a(this.f50695e.f50685f);
                    aVar.f50689a = this.f50695e.f50684e;
                    this.f50696f.a(aVar);
                    return;
                }
                this.f50697g.o(this.f50695e, this.f50696f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.q0.a.v2.e1.b<d.a.q0.a.e2.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f50698e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f50699f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.t1.c.b.b f50700g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h0.j.b f50701h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f50702i;

        public b(a aVar, d.a.q0.a.a2.e eVar, SwanAppActivity swanAppActivity, d.a.q0.a.t1.c.b.b bVar, d.a.q0.a.h0.j.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, eVar, swanAppActivity, bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50702i = aVar;
            this.f50698e = eVar;
            this.f50699f = swanAppActivity;
            this.f50700g = bVar;
            this.f50701h = bVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.e2.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f50702i.p(this.f50699f, this.f50698e.D(), this.f50700g, aVar, this.f50701h);
            }
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
            }
        }
    }

    @Override // d.a.q0.a.t1.c.d.b
    public d.a.q0.a.t1.c.b.a f(d.a.q0.a.t1.c.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            return null;
        }
        return (d.a.q0.a.t1.c.b.a) invokeL.objValue;
    }

    @Override // d.a.q0.a.t1.c.d.b
    public d.a.q0.a.u.h.b j(String str, d.a.q0.a.t1.c.b.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar)) == null) ? new d.a.q0.a.u.h.b(0) : (d.a.q0.a.u.h.b) invokeLL.objValue;
    }

    @Override // d.a.q0.a.t1.c.d.b
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.a.t1.c.d.b
    public d.a.q0.a.u.h.b m(d.a.q0.a.t1.c.b.b bVar, d.a.q0.a.h0.j.b<d.a.q0.a.t1.c.c.a> bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, bVar2)) == null) {
            if (bVar == null || TextUtils.isEmpty(bVar.f50680a)) {
                return new d.a.q0.a.u.h.b(1001, "get fun page info, provider appKey is empty");
            }
            if (bVar2 == null) {
                return new d.a.q0.a.u.h.b(1001, "get fun page info, cb is null");
            }
            d.a.q0.a.a2.e r = d.a.q0.a.a2.d.g().r();
            SwanAppActivity x = r.x();
            if (x != null && !x.isFinishing()) {
                if (!r.j().e(r)) {
                    r.j().f(x, null, new C0946a(this, bVar, bVar2));
                    return new d.a.q0.a.u.h.b(1001, "not login");
                }
                o(bVar, bVar2);
                return new d.a.q0.a.u.h.b(0);
            }
            return new d.a.q0.a.u.h.b(1001, "get fun page info, master has dead");
        }
        return (d.a.q0.a.u.h.b) invokeLL.objValue;
    }

    public final void o(d.a.q0.a.t1.c.b.b bVar, d.a.q0.a.h0.j.b<d.a.q0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, bVar2) == null) {
            d.a.q0.a.t1.d.a.a("start get open data");
            d.a.q0.a.a2.e r = d.a.q0.a.a2.d.g().r();
            SwanAppActivity x = r.x();
            d.a.q0.a.e2.d.a.C(x, g(), bVar.f50680a, true, h(), new b(this, r, x, bVar, bVar2));
        }
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, d.a.q0.a.t1.c.b.b bVar, d.a.q0.a.e2.d.a aVar, d.a.q0.a.h0.j.b<d.a.q0.a.t1.c.c.a> bVar2);
}
