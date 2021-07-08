package d.a.n0.h.u;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.v2.q0;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.a.l0.c f50307a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.h.o0.f.a f50308b;

    /* renamed from: c  reason: collision with root package name */
    public Context f50309c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.a.y.b.a f50310d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.a.y.b.a f50311e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.a.y.b.a f50312f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.h.u.c f50313g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.h.u.e.b f50314h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.h.u.e.a f50315i;
    public d.a.n0.h.u.e.a j;
    public d.a.n0.h.u.b k;
    public f l;

    /* renamed from: d.a.n0.h.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1120a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f50316a;

        public C1120a(a aVar) {
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
            this.f50316a = aVar;
        }

        @Override // d.a.n0.h.u.a.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50316a.j();
            }
        }

        @Override // d.a.n0.h.u.a.f
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                d.a.n0.h.u.e.b bVar = new d.a.n0.h.u.e.b();
                bVar.errMsg = "showKeyboard:ok";
                bVar.height = i2;
                d.a.n0.h.m0.c.a(this.f50316a.f50310d, true, bVar);
            }
        }

        @Override // d.a.n0.h.u.a.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f50316a.k == null) {
                return;
            }
            this.f50316a.k.c(str);
        }

        @Override // d.a.n0.h.u.a.f
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f50316a.k == null) {
                return;
            }
            this.f50316a.k.b(str);
        }

        @Override // d.a.n0.h.u.a.f
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.f50316a.k == null) {
                return;
            }
            this.f50316a.k.d(str);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50317e;

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
            this.f50317e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!d.a.n0.h.o0.f.b.p().n(this.f50317e.f50308b)) {
                    this.f50317e.f50314h.errMsg = "showKeyboard:fail";
                    d.a.n0.h.m0.c.a(this.f50317e.f50310d, false, this.f50317e.f50314h);
                    return;
                }
                this.f50317e.f50308b.j(this.f50317e.f50313g);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50318e;

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
            this.f50318e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.a.n0.h.o0.f.b.p().s(this.f50318e.f50308b)) {
                    this.f50318e.f50315i.errMsg = "hideKeyboard:ok";
                    d.a.n0.h.m0.c.a(this.f50318e.f50311e, true, this.f50318e.f50315i);
                    return;
                }
                this.f50318e.f50315i.errMsg = "hideKeyboard:fail";
                d.a.n0.h.m0.c.a(this.f50318e.f50311e, false, this.f50318e.f50315i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50319e;

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
            this.f50319e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.h.o0.f.b.p().s(this.f50319e.f50308b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50320e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f50321f;

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
            this.f50321f = aVar;
            this.f50320e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f50321f.f50308b.m(this.f50320e)) {
                    this.f50321f.j.errMsg = "updateKeyboard:ok";
                    d.a.n0.h.m0.c.a(this.f50321f.f50312f, true, this.f50321f.j);
                    return;
                }
                this.f50321f.j.errMsg = "updateKeyboard:fail";
                d.a.n0.h.m0.c.a(this.f50321f.f50312f, false, this.f50321f.j);
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

    public a(d.a.n0.a.l0.c cVar, d.a.n0.h.u.b bVar) {
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
        this.l = new C1120a(this);
        this.f50307a = cVar;
        Context appContext = AppRuntime.getAppContext();
        this.f50309c = appContext;
        d.a.n0.h.o0.f.a aVar = new d.a.n0.h.o0.f.a(appContext);
        this.f50308b = aVar;
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
        d.a.n0.h.o0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            this.f50315i = new d.a.n0.h.u.e.a();
            d.a.n0.a.y.b.a G = d.a.n0.a.y.b.a.G(jsObject);
            this.f50311e = G;
            if (G == null) {
                this.f50311e = new d.a.n0.a.y.b.a();
            }
            if (this.f50307a != null && (aVar = this.f50308b) != null && aVar.g()) {
                q0.b0(new c(this));
                return;
            }
            d.a.n0.h.u.e.a aVar2 = this.f50315i;
            aVar2.errMsg = "hideKeyboard:fail";
            d.a.n0.h.m0.c.a(this.f50311e, false, aVar2);
        }
    }

    public void l(JsObject jsObject) {
        d.a.n0.h.o0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            this.f50314h = new d.a.n0.h.u.e.b();
            d.a.n0.a.y.b.a G = d.a.n0.a.y.b.a.G(jsObject);
            this.f50310d = G;
            if (G == null) {
                this.f50310d = new d.a.n0.a.y.b.a();
            }
            if (this.f50307a != null && (aVar = this.f50308b) != null && !aVar.g()) {
                d.a.n0.h.u.c cVar = new d.a.n0.h.u.c();
                this.f50313g = cVar;
                try {
                    if (cVar.a(this.f50310d)) {
                        q0.c0(new b(this), 500L);
                    } else {
                        this.f50314h.errMsg = "showKeyboard:fail";
                        d.a.n0.h.m0.c.a(this.f50310d, false, this.f50314h);
                    }
                    return;
                } catch (JSTypeMismatchException unused) {
                    d.a.n0.h.u.e.b bVar = this.f50314h;
                    bVar.errMsg = "showKeyboard:fail";
                    d.a.n0.h.m0.c.a(this.f50310d, false, bVar);
                    return;
                }
            }
            d.a.n0.h.u.e.b bVar2 = this.f50314h;
            bVar2.errMsg = "showKeyboard:fail";
            d.a.n0.h.m0.c.a(this.f50310d, false, bVar2);
        }
    }

    public void m(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            this.j = new d.a.n0.h.u.e.a();
            d.a.n0.a.y.b.a G = d.a.n0.a.y.b.a.G(jsObject);
            this.f50312f = G;
            if (G == null) {
                this.f50312f = new d.a.n0.a.y.b.a();
            }
            if (this.f50307a != null && this.f50308b != null) {
                q0.b0(new e(this, this.f50312f.C("value")));
                return;
            }
            d.a.n0.h.u.e.a aVar = this.j;
            aVar.errMsg = "updateKeyboard:fail";
            d.a.n0.h.m0.c.a(this.f50312f, false, aVar);
        }
    }
}
