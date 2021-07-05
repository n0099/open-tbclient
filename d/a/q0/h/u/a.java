package d.a.q0.h.u;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.v2.q0;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.a.l0.c f53609a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.h.o0.f.a f53610b;

    /* renamed from: c  reason: collision with root package name */
    public Context f53611c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.a.y.b.a f53612d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.a.y.b.a f53613e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.a.y.b.a f53614f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.h.u.c f53615g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.h.u.e.b f53616h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.h.u.e.a f53617i;
    public d.a.q0.h.u.e.a j;
    public d.a.q0.h.u.b k;
    public f l;

    /* renamed from: d.a.q0.h.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1171a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f53618a;

        public C1171a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53618a = aVar;
        }

        @Override // d.a.q0.h.u.a.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53618a.j();
            }
        }

        @Override // d.a.q0.h.u.a.f
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                d.a.q0.h.u.e.b bVar = new d.a.q0.h.u.e.b();
                bVar.errMsg = "showKeyboard:ok";
                bVar.height = i2;
                d.a.q0.h.m0.c.a(this.f53618a.f53612d, true, bVar);
            }
        }

        @Override // d.a.q0.h.u.a.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f53618a.k == null) {
                return;
            }
            this.f53618a.k.c(str);
        }

        @Override // d.a.q0.h.u.a.f
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f53618a.k == null) {
                return;
            }
            this.f53618a.k.b(str);
        }

        @Override // d.a.q0.h.u.a.f
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.f53618a.k == null) {
                return;
            }
            this.f53618a.k.d(str);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f53619e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53619e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!d.a.q0.h.o0.f.b.p().n(this.f53619e.f53610b)) {
                    this.f53619e.f53616h.errMsg = "showKeyboard:fail";
                    d.a.q0.h.m0.c.a(this.f53619e.f53612d, false, this.f53619e.f53616h);
                    return;
                }
                this.f53619e.f53610b.j(this.f53619e.f53615g);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f53620e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53620e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.a.q0.h.o0.f.b.p().s(this.f53620e.f53610b)) {
                    this.f53620e.f53617i.errMsg = "hideKeyboard:ok";
                    d.a.q0.h.m0.c.a(this.f53620e.f53613e, true, this.f53620e.f53617i);
                    return;
                }
                this.f53620e.f53617i.errMsg = "hideKeyboard:fail";
                d.a.q0.h.m0.c.a(this.f53620e.f53613e, false, this.f53620e.f53617i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f53621e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53621e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.h.o0.f.b.p().s(this.f53621e.f53610b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f53622e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f53623f;

        public e(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53623f = aVar;
            this.f53622e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f53623f.f53610b.m(this.f53622e)) {
                    this.f53623f.j.errMsg = "updateKeyboard:ok";
                    d.a.q0.h.m0.c.a(this.f53623f.f53614f, true, this.f53623f.j);
                    return;
                }
                this.f53623f.j.errMsg = "updateKeyboard:fail";
                d.a.q0.h.m0.c.a(this.f53623f.f53614f, false, this.f53623f.j);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface f {
        void a();

        void b(int i2);

        void c(String str);

        void d(String str);

        void e(String str);
    }

    public a(d.a.q0.a.l0.c cVar, d.a.q0.h.u.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = null;
        this.l = new C1171a(this);
        this.f53609a = cVar;
        Context appContext = AppRuntime.getAppContext();
        this.f53611c = appContext;
        d.a.q0.h.o0.f.a aVar = new d.a.q0.h.o0.f.a(appContext);
        this.f53610b = aVar;
        aVar.i(this.l);
        this.k = bVar;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q0.b0(new d(this));
        }
    }

    public void k(JsObject jsObject) {
        d.a.q0.h.o0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            this.f53617i = new d.a.q0.h.u.e.a();
            d.a.q0.a.y.b.a G = d.a.q0.a.y.b.a.G(jsObject);
            this.f53613e = G;
            if (G == null) {
                this.f53613e = new d.a.q0.a.y.b.a();
            }
            if (this.f53609a != null && (aVar = this.f53610b) != null && aVar.g()) {
                q0.b0(new c(this));
                return;
            }
            d.a.q0.h.u.e.a aVar2 = this.f53617i;
            aVar2.errMsg = "hideKeyboard:fail";
            d.a.q0.h.m0.c.a(this.f53613e, false, aVar2);
        }
    }

    public void l(JsObject jsObject) {
        d.a.q0.h.o0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            this.f53616h = new d.a.q0.h.u.e.b();
            d.a.q0.a.y.b.a G = d.a.q0.a.y.b.a.G(jsObject);
            this.f53612d = G;
            if (G == null) {
                this.f53612d = new d.a.q0.a.y.b.a();
            }
            if (this.f53609a != null && (aVar = this.f53610b) != null && !aVar.g()) {
                d.a.q0.h.u.c cVar = new d.a.q0.h.u.c();
                this.f53615g = cVar;
                try {
                    if (cVar.a(this.f53612d)) {
                        q0.c0(new b(this), 500L);
                    } else {
                        this.f53616h.errMsg = "showKeyboard:fail";
                        d.a.q0.h.m0.c.a(this.f53612d, false, this.f53616h);
                    }
                    return;
                } catch (JSTypeMismatchException unused) {
                    d.a.q0.h.u.e.b bVar = this.f53616h;
                    bVar.errMsg = "showKeyboard:fail";
                    d.a.q0.h.m0.c.a(this.f53612d, false, bVar);
                    return;
                }
            }
            d.a.q0.h.u.e.b bVar2 = this.f53616h;
            bVar2.errMsg = "showKeyboard:fail";
            d.a.q0.h.m0.c.a(this.f53612d, false, bVar2);
        }
    }

    public void m(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            this.j = new d.a.q0.h.u.e.a();
            d.a.q0.a.y.b.a G = d.a.q0.a.y.b.a.G(jsObject);
            this.f53614f = G;
            if (G == null) {
                this.f53614f = new d.a.q0.a.y.b.a();
            }
            if (this.f53609a != null && this.f53610b != null) {
                q0.b0(new e(this, this.f53614f.C("value")));
                return;
            }
            d.a.q0.h.u.e.a aVar = this.j;
            aVar.errMsg = "updateKeyboard:fail";
            d.a.q0.h.m0.c.a(this.f53614f, false, aVar);
        }
    }
}
