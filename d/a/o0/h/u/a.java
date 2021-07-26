package d.a.o0.h.u;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.v2.q0;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.a.l0.c f50811a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.h.o0.f.a f50812b;

    /* renamed from: c  reason: collision with root package name */
    public Context f50813c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.a.y.b.a f50814d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.a.y.b.a f50815e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.a.y.b.a f50816f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.h.u.c f50817g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.h.u.e.b f50818h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.h.u.e.a f50819i;
    public d.a.o0.h.u.e.a j;
    public d.a.o0.h.u.b k;
    public f l;

    /* renamed from: d.a.o0.h.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1129a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f50820a;

        public C1129a(a aVar) {
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
            this.f50820a = aVar;
        }

        @Override // d.a.o0.h.u.a.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50820a.j();
            }
        }

        @Override // d.a.o0.h.u.a.f
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                d.a.o0.h.u.e.b bVar = new d.a.o0.h.u.e.b();
                bVar.errMsg = "showKeyboard:ok";
                bVar.height = i2;
                d.a.o0.h.m0.c.a(this.f50820a.f50814d, true, bVar);
            }
        }

        @Override // d.a.o0.h.u.a.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f50820a.k == null) {
                return;
            }
            this.f50820a.k.c(str);
        }

        @Override // d.a.o0.h.u.a.f
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f50820a.k == null) {
                return;
            }
            this.f50820a.k.b(str);
        }

        @Override // d.a.o0.h.u.a.f
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.f50820a.k == null) {
                return;
            }
            this.f50820a.k.d(str);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50821e;

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
            this.f50821e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!d.a.o0.h.o0.f.b.p().n(this.f50821e.f50812b)) {
                    this.f50821e.f50818h.errMsg = "showKeyboard:fail";
                    d.a.o0.h.m0.c.a(this.f50821e.f50814d, false, this.f50821e.f50818h);
                    return;
                }
                this.f50821e.f50812b.j(this.f50821e.f50817g);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50822e;

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
            this.f50822e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.a.o0.h.o0.f.b.p().s(this.f50822e.f50812b)) {
                    this.f50822e.f50819i.errMsg = "hideKeyboard:ok";
                    d.a.o0.h.m0.c.a(this.f50822e.f50815e, true, this.f50822e.f50819i);
                    return;
                }
                this.f50822e.f50819i.errMsg = "hideKeyboard:fail";
                d.a.o0.h.m0.c.a(this.f50822e.f50815e, false, this.f50822e.f50819i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50823e;

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
            this.f50823e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.h.o0.f.b.p().s(this.f50823e.f50812b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50824e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f50825f;

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
            this.f50825f = aVar;
            this.f50824e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f50825f.f50812b.m(this.f50824e)) {
                    this.f50825f.j.errMsg = "updateKeyboard:ok";
                    d.a.o0.h.m0.c.a(this.f50825f.f50816f, true, this.f50825f.j);
                    return;
                }
                this.f50825f.j.errMsg = "updateKeyboard:fail";
                d.a.o0.h.m0.c.a(this.f50825f.f50816f, false, this.f50825f.j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface f {
        void a();

        void b(int i2);

        void c(String str);

        void d(String str);

        void e(String str);
    }

    public a(d.a.o0.a.l0.c cVar, d.a.o0.h.u.b bVar) {
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
        this.l = new C1129a(this);
        this.f50811a = cVar;
        Context appContext = AppRuntime.getAppContext();
        this.f50813c = appContext;
        d.a.o0.h.o0.f.a aVar = new d.a.o0.h.o0.f.a(appContext);
        this.f50812b = aVar;
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
        d.a.o0.h.o0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            this.f50819i = new d.a.o0.h.u.e.a();
            d.a.o0.a.y.b.a G = d.a.o0.a.y.b.a.G(jsObject);
            this.f50815e = G;
            if (G == null) {
                this.f50815e = new d.a.o0.a.y.b.a();
            }
            if (this.f50811a != null && (aVar = this.f50812b) != null && aVar.g()) {
                q0.b0(new c(this));
                return;
            }
            d.a.o0.h.u.e.a aVar2 = this.f50819i;
            aVar2.errMsg = "hideKeyboard:fail";
            d.a.o0.h.m0.c.a(this.f50815e, false, aVar2);
        }
    }

    public void l(JsObject jsObject) {
        d.a.o0.h.o0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            this.f50818h = new d.a.o0.h.u.e.b();
            d.a.o0.a.y.b.a G = d.a.o0.a.y.b.a.G(jsObject);
            this.f50814d = G;
            if (G == null) {
                this.f50814d = new d.a.o0.a.y.b.a();
            }
            if (this.f50811a != null && (aVar = this.f50812b) != null && !aVar.g()) {
                d.a.o0.h.u.c cVar = new d.a.o0.h.u.c();
                this.f50817g = cVar;
                try {
                    if (cVar.a(this.f50814d)) {
                        q0.c0(new b(this), 500L);
                    } else {
                        this.f50818h.errMsg = "showKeyboard:fail";
                        d.a.o0.h.m0.c.a(this.f50814d, false, this.f50818h);
                    }
                    return;
                } catch (JSTypeMismatchException unused) {
                    d.a.o0.h.u.e.b bVar = this.f50818h;
                    bVar.errMsg = "showKeyboard:fail";
                    d.a.o0.h.m0.c.a(this.f50814d, false, bVar);
                    return;
                }
            }
            d.a.o0.h.u.e.b bVar2 = this.f50818h;
            bVar2.errMsg = "showKeyboard:fail";
            d.a.o0.h.m0.c.a(this.f50814d, false, bVar2);
        }
    }

    public void m(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            this.j = new d.a.o0.h.u.e.a();
            d.a.o0.a.y.b.a G = d.a.o0.a.y.b.a.G(jsObject);
            this.f50816f = G;
            if (G == null) {
                this.f50816f = new d.a.o0.a.y.b.a();
            }
            if (this.f50811a != null && this.f50812b != null) {
                q0.b0(new e(this, this.f50816f.C("value")));
                return;
            }
            d.a.o0.h.u.e.a aVar = this.j;
            aVar.errMsg = "updateKeyboard:fail";
            d.a.o0.h.m0.c.a(this.f50816f, false, aVar);
        }
    }
}
