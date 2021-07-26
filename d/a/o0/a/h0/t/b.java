package d.a.o0.a.h0.t;

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
import d.a.o0.a.a2.d;
import d.a.o0.a.j2.h;
import d.a.o0.a.k;
import d.a.o0.a.v2.q;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f45722i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SwanAppSlaveManager f45723a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f45724b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f45725c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f45726d;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f45727e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.a.l1.b f45728f;

    /* renamed from: g  reason: collision with root package name */
    public String f45729g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f45730h;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f45731e;

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
            this.f45731e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45731e.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(447639076, "Ld/a/o0/a/h0/t/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(447639076, "Ld/a/o0/a/h0/t/b;");
                return;
            }
        }
        f45722i = k.f46335a;
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
        this.f45724b = false;
        this.f45725c = false;
        this.f45726d = false;
        this.f45730h = false;
        this.f45723a = swanAppSlaveManager;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q.c(new a(this), "delayDownloadGuideRes", 3L, TimeUnit.SECONDS);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f45725c || this.f45730h) {
            return;
        }
        this.f45730h = true;
        d.a.o0.a.c1.a.e0().c(d.g().getAppId());
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f45725c) {
            SwanAppSlaveManager swanAppSlaveManager = this.f45723a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
            h.e(this.f45729g, "realsuccess", swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.O(), this.f45727e);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f45724b = true;
            if (this.f45723a instanceof SwanAppWebViewWidget) {
                return;
            }
            g();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!(this.f45723a instanceof SwanAppWebViewWidget)) {
                f();
            }
            this.f45724b = false;
            this.f45727e = h.c();
            if (this.f45725c) {
                h.e(this.f45729g, "success", null, this.f45727e);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f45726d = false;
            boolean b2 = h.b();
            boolean a2 = h.a();
            if (b2) {
                this.f45725c = false;
            } else if (this.f45724b) {
                this.f45725c = true;
                if (a2) {
                    return;
                }
                h.g(this.f45729g);
                if (f45722i) {
                    Log.d("SwanAppSlavePresenter", "mCurPageParams = " + this.f45728f);
                }
            } else {
                this.f45725c = !TextUtils.isEmpty(this.f45723a.k0());
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (f45722i) {
                Log.d("SwanAppSlavePresenter", "mCurPageParams = " + this.f45728f);
            }
            if (!this.f45725c || this.f45726d) {
                return;
            }
            this.f45726d = true;
            SwanAppSlaveManager swanAppSlaveManager = this.f45723a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
            d.a.o0.a.p.e.j.d O = swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.O();
            if (O != null && O.f47132c > 0) {
                h.e(this.f45729g, "arrivesuccess", O, this.f45727e);
            } else {
                h.e(this.f45729g, "arrivecancel", O, this.f45727e);
            }
        }
    }

    public void h(@NonNull d.a.o0.a.l1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f45728f = bVar;
            this.f45729g = bVar.f46493e;
        }
    }
}
