package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class n62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppSlaveManager a;
    public volatile boolean b;
    public volatile boolean c;
    public volatile boolean d;
    public hq2 e;
    public volatile boolean f;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n62 a;

        public a(n62 n62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n62Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755517625, "Lcom/repackage/n62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755517625, "Lcom/repackage/n62;");
                return;
            }
        }
        g = rg1.a;
    }

    public n62(@NonNull SwanAppSlaveManager swanAppSlaveManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppSlaveManager};
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
        this.c = false;
        this.d = false;
        this.f = false;
        this.a = swanAppSlaveManager;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            bd3.c(new a(this), "delayDownloadGuideRes", 3L, TimeUnit.SECONDS);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.c || this.f) {
            return;
        }
        this.f = true;
        oj2.l0().c(g03.K().getAppId());
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.c) {
            SwanAppSlaveManager swanAppSlaveManager = this.a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.y;
            v63.d(this.e, "realsuccess", swanAppWebViewWidget == null ? swanAppSlaveManager.H : swanAppWebViewWidget.O());
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b = true;
            if (this.a instanceof SwanAppWebViewWidget) {
                return;
            }
            g();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!(this.a instanceof SwanAppWebViewWidget)) {
                f();
            }
            this.b = false;
            if (this.c) {
                v63.d(this.e, "success", null);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.d = false;
            boolean b = v63.b();
            boolean a2 = v63.a();
            if (b) {
                this.c = false;
            } else if (this.b) {
                this.c = true;
                if (a2) {
                    return;
                }
                this.e.f = UUID.randomUUID().toString();
                hq2 hq2Var = this.e;
                hq2Var.e = "6";
                v63.h(hq2Var);
                if (g) {
                    Log.d("SwanAppSlavePresenter", "mCurPageParams = " + this.e);
                }
            } else {
                this.c = !TextUtils.isEmpty(this.a.l0());
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (g) {
                Log.d("SwanAppSlavePresenter", "mCurPageParams = " + this.e);
            }
            if (!this.c || this.d) {
                return;
            }
            this.d = true;
            SwanAppSlaveManager swanAppSlaveManager = this.a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.y;
            ym1 O = swanAppWebViewWidget == null ? swanAppSlaveManager.H : swanAppWebViewWidget.O();
            if (O != null && O.c > 0) {
                v63.d(this.e, "arrivesuccess", O);
            } else {
                v63.d(this.e, "arrivecancel", O);
            }
        }
    }

    public void h(@NonNull hq2 hq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, hq2Var) == null) {
            this.e = hq2Var;
        }
    }
}
