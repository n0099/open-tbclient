package d.a.n0.a.h0.o;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
import d.a.n0.a.v1.c.f.c;
import d.a.n0.a.v1.c.f.e;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45053a;

    /* renamed from: b  reason: collision with root package name */
    public static f f45054b;

    /* renamed from: c  reason: collision with root package name */
    public static g f45055c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45056d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.n0.a.h0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0754a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f45057a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent f45058b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f45059c;

        public C0754a(a aVar, e eVar, PrefetchEvent prefetchEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, eVar, prefetchEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45059c = aVar;
            this.f45057a = eVar;
            this.f45058b = prefetchEvent;
        }

        @Override // d.a.n0.a.h0.o.a.d
        public void a(d.a.n0.a.v1.c.f.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null) {
                return;
            }
            if (a.f45056d || !cVar.C()) {
                this.f45059c.f(cVar, this.f45058b, this.f45057a);
            } else {
                this.f45057a.a(cVar, null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f45060a;

        public b(a aVar, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45060a = dVar;
        }

        @Override // d.a.n0.a.v1.c.f.c.b
        public void a(d.a.n0.a.v1.c.f.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f45060a.a(cVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends d.a.n0.a.h0.c.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.v1.c.f.c f45061b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f45062c;

        public c(a aVar, d.a.n0.a.v1.c.f.c cVar, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45061b = cVar;
            this.f45062c = eVar;
        }

        @Override // d.a.n0.a.h0.c.a.a, d.a.n0.a.h0.c.a.b.InterfaceC0712b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                boolean z = a.f45056d && this.f45061b.C();
                if (this.f45061b.G() || z) {
                    this.f45062c.a(this.f45061b, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a(d.a.n0.a.v1.c.f.c cVar);
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(@NonNull d.a.n0.a.v1.c.f.c cVar, @Nullable PMSAppInfo pMSAppInfo);
    }

    /* loaded from: classes7.dex */
    public static class f implements e.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v1.c.f.e.c
        /* renamed from: b */
        public boolean a(String str, d.a.n0.a.v1.c.f.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar)) == null) {
                PrefetchEvent prefetchEvent = cVar.j;
                if (prefetchEvent == null) {
                    return false;
                }
                return TextUtils.equals(str, prefetchEvent.appId);
            }
            return invokeLL.booleanValue;
        }

        public /* synthetic */ f(C0754a c0754a) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static class g implements e.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v1.c.f.e.c
        /* renamed from: b */
        public boolean a(String str, d.a.n0.a.v1.c.f.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar)) == null) ? cVar.C() && TextUtils.equals(str, cVar.f47958g) : invokeLL.booleanValue;
        }

        public /* synthetic */ g(C0754a c0754a) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(318407371, "Ld/a/n0/a/h0/o/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(318407371, "Ld/a/n0/a/h0/o/a;");
                return;
            }
        }
        f45053a = k.f45831a;
        f45054b = new f(null);
        f45055c = new g(null);
        f45056d = d.a.n0.a.h0.o.e.a.m();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static d.a.n0.a.v1.c.f.c c(@NonNull PrefetchEvent prefetchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, prefetchEvent)) == null) ? d.a.n0.a.v1.c.f.e.k().p(prefetchEvent.appId, f45054b) : (d.a.n0.a.v1.c.f.c) invokeL.objValue;
    }

    public static d.a.n0.a.v1.c.f.c d(@NonNull PrefetchEvent prefetchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, prefetchEvent)) == null) ? d.a.n0.a.v1.c.f.e.k().p(prefetchEvent.appId, f45055c) : (d.a.n0.a.v1.c.f.c) invokeL.objValue;
    }

    public final void e(@NonNull d.a.n0.a.v1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, cVar, prefetchEvent, eVar) == null) {
            d.a.n0.a.h0.c.a.b.g(prefetchEvent.appId, "swan", prefetchEvent.scene, false, prefetchEvent.schema, new c(this, cVar, eVar));
        }
    }

    public final void f(@NonNull d.a.n0.a.v1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, prefetchEvent, eVar) == null) {
            e(cVar, prefetchEvent, eVar);
        }
    }

    public void g(@NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, prefetchEvent, eVar) == null) {
            h(prefetchEvent, new C0754a(this, eVar, prefetchEvent));
        }
    }

    @Nullable
    public final void h(@NonNull PrefetchEvent prefetchEvent, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, prefetchEvent, dVar) == null) {
            d.a.n0.a.v1.c.f.c d2 = d(prefetchEvent);
            if (d2 != null) {
                dVar.a(d2);
                return;
            }
            d.a.n0.a.v1.c.f.c c2 = c(prefetchEvent);
            if (c2 != null && c2.G()) {
                dVar.a(c2);
                return;
            }
            d.a.n0.a.v1.c.f.c e2 = d.a.n0.a.v1.c.f.e.k().e();
            if (e2.C()) {
                if (f45053a) {
                    Log.e("PrefetchEnv", "prepareEnv isSwanAppLoaded.");
                }
                dVar.a(null);
            } else if (e2.G()) {
                if (f45053a) {
                    Log.d("PrefetchEnv", "prepareEnv isPreloaded.");
                }
                dVar.a(e2);
            } else {
                e2.Y(new b(this, dVar));
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "8");
                d.a.n0.a.v1.c.f.b.m(d.a.n0.a.c1.a.b(), e2, bundle);
            }
        }
    }
}
