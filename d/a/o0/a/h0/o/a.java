package d.a.o0.a.h0.o;

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
import d.a.o0.a.k;
import d.a.o0.a.v1.c.f.c;
import d.a.o0.a.v1.c.f.e;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45557a;

    /* renamed from: b  reason: collision with root package name */
    public static f f45558b;

    /* renamed from: c  reason: collision with root package name */
    public static g f45559c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45560d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.a.h0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0763a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f45561a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent f45562b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f45563c;

        public C0763a(a aVar, e eVar, PrefetchEvent prefetchEvent) {
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
            this.f45563c = aVar;
            this.f45561a = eVar;
            this.f45562b = prefetchEvent;
        }

        @Override // d.a.o0.a.h0.o.a.d
        public void a(d.a.o0.a.v1.c.f.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null) {
                return;
            }
            if (a.f45560d || !cVar.C()) {
                this.f45563c.f(cVar, this.f45562b, this.f45561a);
            } else {
                this.f45561a.a(cVar, null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f45564a;

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
            this.f45564a = dVar;
        }

        @Override // d.a.o0.a.v1.c.f.c.b
        public void a(d.a.o0.a.v1.c.f.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f45564a.a(cVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends d.a.o0.a.h0.c.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.v1.c.f.c f45565b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f45566c;

        public c(a aVar, d.a.o0.a.v1.c.f.c cVar, e eVar) {
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
            this.f45565b = cVar;
            this.f45566c = eVar;
        }

        @Override // d.a.o0.a.h0.c.a.a, d.a.o0.a.h0.c.a.b.InterfaceC0721b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                boolean z = a.f45560d && this.f45565b.C();
                if (this.f45565b.G() || z) {
                    this.f45566c.a(this.f45565b, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a(d.a.o0.a.v1.c.f.c cVar);
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(@NonNull d.a.o0.a.v1.c.f.c cVar, @Nullable PMSAppInfo pMSAppInfo);
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
        @Override // d.a.o0.a.v1.c.f.e.c
        /* renamed from: b */
        public boolean a(String str, d.a.o0.a.v1.c.f.c cVar) {
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

        public /* synthetic */ f(C0763a c0763a) {
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
        @Override // d.a.o0.a.v1.c.f.e.c
        /* renamed from: b */
        public boolean a(String str, d.a.o0.a.v1.c.f.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar)) == null) ? cVar.C() && TextUtils.equals(str, cVar.f48462g) : invokeLL.booleanValue;
        }

        public /* synthetic */ g(C0763a c0763a) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(447490090, "Ld/a/o0/a/h0/o/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(447490090, "Ld/a/o0/a/h0/o/a;");
                return;
            }
        }
        f45557a = k.f46335a;
        f45558b = new f(null);
        f45559c = new g(null);
        f45560d = d.a.o0.a.h0.o.e.a.m();
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

    public static d.a.o0.a.v1.c.f.c c(@NonNull PrefetchEvent prefetchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, prefetchEvent)) == null) ? d.a.o0.a.v1.c.f.e.k().p(prefetchEvent.appId, f45558b) : (d.a.o0.a.v1.c.f.c) invokeL.objValue;
    }

    public static d.a.o0.a.v1.c.f.c d(@NonNull PrefetchEvent prefetchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, prefetchEvent)) == null) ? d.a.o0.a.v1.c.f.e.k().p(prefetchEvent.appId, f45559c) : (d.a.o0.a.v1.c.f.c) invokeL.objValue;
    }

    public final void e(@NonNull d.a.o0.a.v1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, cVar, prefetchEvent, eVar) == null) {
            d.a.o0.a.h0.c.a.b.g(prefetchEvent.appId, "swan", prefetchEvent.scene, false, prefetchEvent.schema, new c(this, cVar, eVar));
        }
    }

    public final void f(@NonNull d.a.o0.a.v1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, prefetchEvent, eVar) == null) {
            e(cVar, prefetchEvent, eVar);
        }
    }

    public void g(@NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, prefetchEvent, eVar) == null) {
            h(prefetchEvent, new C0763a(this, eVar, prefetchEvent));
        }
    }

    @Nullable
    public final void h(@NonNull PrefetchEvent prefetchEvent, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, prefetchEvent, dVar) == null) {
            d.a.o0.a.v1.c.f.c d2 = d(prefetchEvent);
            if (d2 != null) {
                dVar.a(d2);
                return;
            }
            d.a.o0.a.v1.c.f.c c2 = c(prefetchEvent);
            if (c2 != null && c2.G()) {
                dVar.a(c2);
                return;
            }
            d.a.o0.a.v1.c.f.c e2 = d.a.o0.a.v1.c.f.e.k().e();
            if (e2.C()) {
                if (f45557a) {
                    Log.e("PrefetchEnv", "prepareEnv isSwanAppLoaded.");
                }
                dVar.a(null);
            } else if (e2.G()) {
                if (f45557a) {
                    Log.d("PrefetchEnv", "prepareEnv isPreloaded.");
                }
                dVar.a(e2);
            } else {
                e2.Y(new b(this, dVar));
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "8");
                d.a.o0.a.v1.c.f.b.m(d.a.o0.a.c1.a.b(), e2, bundle);
            }
        }
    }
}
