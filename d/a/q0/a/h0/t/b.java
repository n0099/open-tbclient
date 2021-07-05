package d.a.q0.a.h0.t;

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
import d.a.q0.a.a2.d;
import d.a.q0.a.j2.h;
import d.a.q0.a.k;
import d.a.q0.a.v2.q;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f48520i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SwanAppSlaveManager f48521a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f48522b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f48523c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f48524d;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f48525e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.a.l1.b f48526f;

    /* renamed from: g  reason: collision with root package name */
    public String f48527g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f48528h;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f48529e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48529e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48529e.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(705804514, "Ld/a/q0/a/h0/t/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(705804514, "Ld/a/q0/a/h0/t/b;");
                return;
            }
        }
        f48520i = k.f49133a;
    }

    public b(@NonNull SwanAppSlaveManager swanAppSlaveManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppSlaveManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48522b = false;
        this.f48523c = false;
        this.f48524d = false;
        this.f48528h = false;
        this.f48521a = swanAppSlaveManager;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q.c(new a(this), "delayDownloadGuideRes", 3L, TimeUnit.SECONDS);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f48523c || this.f48528h) {
            return;
        }
        this.f48528h = true;
        d.a.q0.a.c1.a.e0().c(d.g().getAppId());
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f48523c) {
            SwanAppSlaveManager swanAppSlaveManager = this.f48521a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
            h.e(this.f48527g, "realsuccess", swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.O(), this.f48525e);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f48522b = true;
            if (this.f48521a instanceof SwanAppWebViewWidget) {
                return;
            }
            g();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!(this.f48521a instanceof SwanAppWebViewWidget)) {
                f();
            }
            this.f48522b = false;
            this.f48525e = h.c();
            if (this.f48523c) {
                h.e(this.f48527g, "success", null, this.f48525e);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f48524d = false;
            boolean b2 = h.b();
            boolean a2 = h.a();
            if (b2) {
                this.f48523c = false;
            } else if (this.f48522b) {
                this.f48523c = true;
                if (a2) {
                    return;
                }
                h.g(this.f48527g);
                if (f48520i) {
                    Log.d("SwanAppSlavePresenter", "mCurPageParams = " + this.f48526f);
                }
            } else {
                this.f48523c = !TextUtils.isEmpty(this.f48521a.j0());
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (f48520i) {
                Log.d("SwanAppSlavePresenter", "mCurPageParams = " + this.f48526f);
            }
            if (!this.f48523c || this.f48524d) {
                return;
            }
            this.f48524d = true;
            SwanAppSlaveManager swanAppSlaveManager = this.f48521a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
            d.a.q0.a.p.e.j.d O = swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.O();
            if (O != null && O.f49930c > 0) {
                h.e(this.f48527g, "arrivesuccess", O, this.f48525e);
            } else {
                h.e(this.f48527g, "arrivecancel", O, this.f48525e);
            }
        }
    }

    public void h(@NonNull d.a.q0.a.l1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f48526f = bVar;
            this.f48527g = bVar.f49291e;
        }
    }
}
