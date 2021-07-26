package d.a.o0.a.n0;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.e0.b;
import d.a.o0.a.k;
import d.a.o0.a.n0.d;
import d.a.o0.a.p.d.t;
import d.a.o0.a.p.d.v0;
import d.a.o0.a.v2.q0;
import d.a.o0.a.v2.w0;
/* loaded from: classes7.dex */
public final class f implements d.InterfaceC0836d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46724c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f46725a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f46726b;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v0 f46727e;

        public a(f fVar, v0 v0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, v0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46727e = v0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46727e.b();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f46728e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f46729f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f46730g;

        public b(f fVar, int i2, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2), bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46730g = fVar;
            this.f46728e = i2;
            this.f46729f = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (f.f46724c) {
                    Log.d("SwanAppEnv", "zygoteSwanProcess delay - run. switch: " + this.f46728e);
                }
                d.a.o0.a.v1.c.f.b.k(this.f46730g.a(), this.f46729f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final f f46731a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1477266252, "Ld/a/o0/a/n0/f$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1477266252, "Ld/a/o0/a/n0/f$c;");
                    return;
                }
            }
            f46731a = new f(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(515503147, "Ld/a/o0/a/n0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(515503147, "Ld/a/o0/a/n0/f;");
                return;
            }
        }
        f46724c = k.f46335a;
    }

    public /* synthetic */ f(a aVar) {
        this();
    }

    public static f c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.f46731a : (f) invokeV.objValue;
    }

    @Override // d.a.o0.a.n0.b
    @NonNull
    public Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? AppRuntime.getAppContext() : (Context) invokeV.objValue;
    }

    public d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f46725a : (d) invokeV.objValue;
    }

    public void e(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) || this.f46726b) {
            return;
        }
        synchronized (this) {
            if (!this.f46726b) {
                f(bundle);
                this.f46726b = true;
            }
        }
    }

    public final void f(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            g(bundle);
            SwanLauncher.j().l(null);
            b.C0674b.e();
            w0.a();
            ExecutorUtilsExt.postOnElastic(new a(this, d.a.o0.a.c1.a.j0()), "requestBatchRebateInfo", 2);
        }
    }

    public final void g(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            if (f46724c) {
                Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
            }
            t f2 = d.a.o0.a.c1.a.f();
            if (f2 == null) {
                return;
            }
            int a2 = f2.a();
            if (f46724c) {
                Log.d("SwanAppEnv", "zygoteSwanProcess switch : " + a2);
            }
            if (f2.e()) {
                return;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (TextUtils.isEmpty(bundle.getString("bundle_key_preload_preload_scene"))) {
                bundle.putString("bundle_key_preload_preload_scene", "0");
            }
            if (bundle.getBoolean("bundle_key_preload_delay", false) && f2.f()) {
                if (f46724c) {
                    Log.d("SwanAppEnv", "zygoteSwanProcess delay - start. switch: " + a2);
                }
                q0.Y(new b(this, a2, bundle), d.a.o0.a.c1.a.f().c());
                return;
            }
            if (f46724c) {
                Log.d("SwanAppEnv", "zygoteSwanProcess start. switch: " + a2);
            }
            d.a.o0.a.v1.c.f.b.k(a(), bundle);
        }
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f46726b = false;
        this.f46725a = new d(this);
        d.a.o0.a.p0.e.a.d().f();
    }
}
