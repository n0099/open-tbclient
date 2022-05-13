package com.repackage;

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
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.e92;
import com.repackage.sx1;
/* loaded from: classes6.dex */
public final class g92 implements e92.d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public e92 a;
    public volatile boolean b;
    public final boolean c;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ em1 a;

        public a(g92 g92Var, em1 em1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g92Var, em1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = em1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(g92 g92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                bk2.s0().b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ g92 c;

        public c(g92 g92Var, int i, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g92Var, Integer.valueOf(i), bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g92Var;
            this.a = i;
            this.b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (g92.d) {
                    Log.d("SwanAppEnv", "zygoteSwanProcess delay - run. switch: " + this.a);
                }
                sx2.k(this.c.a(), this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final g92 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-400617039, "Lcom/repackage/g92$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-400617039, "Lcom/repackage/g92$d;");
                    return;
                }
            }
            a = new g92(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755723279, "Lcom/repackage/g92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755723279, "Lcom/repackage/g92;");
                return;
            }
        }
        d = eh1.a;
    }

    public /* synthetic */ g92(a aVar) {
        this();
    }

    public static g92 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? d.a : (g92) invokeV.objValue;
    }

    @Override // com.repackage.c92
    @NonNull
    public Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? AppRuntime.getAppContext() : (Context) invokeV.objValue;
    }

    public e92 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (e92) invokeV.objValue;
    }

    public void e(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) || this.b) {
            return;
        }
        synchronized (this) {
            if (!this.b) {
                f(bundle);
                this.b = true;
            }
        }
    }

    public final void f(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            g(bundle);
            SwanLauncher.j().l(null);
            sx1.b.d();
            ve3.a();
            if (d) {
                Log.d("SwanAppEnv", "swan_env_init_thread_pool_optimize: " + this.c);
            }
            if (this.c) {
                ExecutorUtilsExt.postOnElastic(new a(this, bk2.s0()), "requestBatchRebateInfo", 2);
            } else {
                ExecutorUtilsExt.postOnElastic(new b(this), "requestBatchRebateInfo", 2);
            }
        }
    }

    public final void g(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            if (d) {
                Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
            }
            xk1 g = bk2.g();
            if (g == null) {
                return;
            }
            int a2 = g.a();
            if (d) {
                Log.d("SwanAppEnv", "zygoteSwanProcess switch : " + a2);
            }
            if (g.e()) {
                return;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (TextUtils.isEmpty(bundle.getString("bundle_key_preload_preload_scene"))) {
                bundle.putString("bundle_key_preload_preload_scene", "0");
            }
            if (bundle.getBoolean("bundle_key_preload_delay", false) && g.f()) {
                if (d) {
                    Log.d("SwanAppEnv", "zygoteSwanProcess delay - start. switch: " + a2);
                }
                oe3.b0(new c(this, a2, bundle), bk2.g().c());
                return;
            }
            if (d) {
                Log.d("SwanAppEnv", "zygoteSwanProcess start. switch: " + a2);
            }
            sx2.k(a(), bundle);
        }
    }

    public g92() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        bk2.g0().getSwitch("swan_env_init_thread_pool_optimize", true);
        this.c = true;
        this.a = new e92(this);
        he2.i();
        SwanFavorDataManager.h();
        hb2.d().f();
    }
}
