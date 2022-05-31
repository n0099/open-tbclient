package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gw2;
import com.repackage.iw2;
/* loaded from: classes5.dex */
public final class d32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static f b;
    public static g c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;
        public final /* synthetic */ PrefetchEvent b;
        public final /* synthetic */ d32 c;

        public a(d32 d32Var, e eVar, PrefetchEvent prefetchEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d32Var, eVar, prefetchEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = d32Var;
            this.a = eVar;
            this.b = prefetchEvent;
        }

        @Override // com.repackage.d32.d
        public void a(gw2 gw2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, gw2Var) == null) || gw2Var == null) {
                return;
            }
            if (d32.d || !gw2Var.D()) {
                this.c.f(gw2Var, this.b, this.a);
            } else {
                this.a.a(gw2Var, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements gw2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d32 d32Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d32Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.repackage.gw2.b
        public void a(gw2 gw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gw2Var) == null) {
                this.a.a(gw2Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends wx1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw2 b;
        public final /* synthetic */ e c;

        public c(d32 d32Var, gw2 gw2Var, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d32Var, gw2Var, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gw2Var;
            this.c = eVar;
        }

        @Override // com.repackage.wx1, com.repackage.xx1.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                boolean z = d32.d && this.b.D();
                if (this.b.R() || z) {
                    this.c.a(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(gw2 gw2Var);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(@NonNull gw2 gw2Var, @Nullable PMSAppInfo pMSAppInfo);
    }

    /* loaded from: classes5.dex */
    public static class f implements iw2.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.iw2.c
        /* renamed from: b */
        public boolean a(String str, gw2 gw2Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, gw2Var)) == null) {
                PrefetchEvent prefetchEvent = gw2Var.f;
                if (prefetchEvent == null) {
                    return false;
                }
                return TextUtils.equals(str, prefetchEvent.appId);
            }
            return invokeLL.booleanValue;
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements iw2.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.iw2.c
        /* renamed from: b */
        public boolean a(String str, gw2 gw2Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, gw2Var)) == null) ? gw2Var.D() && TextUtils.equals(str, gw2Var.c) : invokeLL.booleanValue;
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755818418, "Lcom/repackage/d32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755818418, "Lcom/repackage/d32;");
                return;
            }
        }
        a = rf1.a;
        b = new f(null);
        c = new g(null);
        d = h32.p();
    }

    public d32() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static gw2 c(@NonNull PrefetchEvent prefetchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, prefetchEvent)) == null) ? iw2.k().p(prefetchEvent.appId, b) : (gw2) invokeL.objValue;
    }

    public static gw2 d(@NonNull PrefetchEvent prefetchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, prefetchEvent)) == null) ? iw2.k().p(prefetchEvent.appId, c) : (gw2) invokeL.objValue;
    }

    public final void e(@NonNull gw2 gw2Var, @NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, gw2Var, prefetchEvent, eVar) == null) {
            xx1.g(prefetchEvent.appId, "swan", prefetchEvent.scene, false, prefetchEvent.schema, new c(this, gw2Var, eVar));
        }
    }

    public final void f(@NonNull gw2 gw2Var, @NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gw2Var, prefetchEvent, eVar) == null) {
            e(gw2Var, prefetchEvent, eVar);
        }
    }

    public void g(@NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, prefetchEvent, eVar) == null) {
            h(prefetchEvent, new a(this, eVar, prefetchEvent));
        }
    }

    @Nullable
    public final void h(@NonNull PrefetchEvent prefetchEvent, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, prefetchEvent, dVar) == null) {
            gw2 d2 = d(prefetchEvent);
            if (d2 != null) {
                dVar.a(d2);
                return;
            }
            gw2 c2 = c(prefetchEvent);
            if (c2 != null && c2.R()) {
                dVar.a(c2);
                return;
            }
            gw2 e2 = iw2.k().e();
            if (e2.D()) {
                if (a) {
                    Log.e("PrefetchEnv", "prepareEnv isSwanAppLoaded.");
                }
                dVar.a(null);
            } else if (e2.R()) {
                if (a) {
                    Log.d("PrefetchEnv", "prepareEnv isPreloaded.");
                }
                dVar.a(e2);
            } else {
                e2.j0(new b(this, dVar));
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "8");
                fw2.m(oi2.c(), e2, bundle);
            }
        }
    }
}
