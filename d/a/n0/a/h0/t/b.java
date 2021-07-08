package d.a.n0.a.h0.t;

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
import d.a.n0.a.a2.d;
import d.a.n0.a.j2.h;
import d.a.n0.a.k;
import d.a.n0.a.v2.q;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f45218i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SwanAppSlaveManager f45219a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f45220b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f45221c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f45222d;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f45223e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.a.l1.b f45224f;

    /* renamed from: g  reason: collision with root package name */
    public String f45225g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f45226h;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f45227e;

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
            this.f45227e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45227e.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(318556357, "Ld/a/n0/a/h0/t/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(318556357, "Ld/a/n0/a/h0/t/b;");
                return;
            }
        }
        f45218i = k.f45831a;
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
        this.f45220b = false;
        this.f45221c = false;
        this.f45222d = false;
        this.f45226h = false;
        this.f45219a = swanAppSlaveManager;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q.c(new a(this), "delayDownloadGuideRes", 3L, TimeUnit.SECONDS);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f45221c || this.f45226h) {
            return;
        }
        this.f45226h = true;
        d.a.n0.a.c1.a.e0().c(d.g().getAppId());
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f45221c) {
            SwanAppSlaveManager swanAppSlaveManager = this.f45219a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
            h.e(this.f45225g, "realsuccess", swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.O(), this.f45223e);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f45220b = true;
            if (this.f45219a instanceof SwanAppWebViewWidget) {
                return;
            }
            g();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!(this.f45219a instanceof SwanAppWebViewWidget)) {
                f();
            }
            this.f45220b = false;
            this.f45223e = h.c();
            if (this.f45221c) {
                h.e(this.f45225g, "success", null, this.f45223e);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f45222d = false;
            boolean b2 = h.b();
            boolean a2 = h.a();
            if (b2) {
                this.f45221c = false;
            } else if (this.f45220b) {
                this.f45221c = true;
                if (a2) {
                    return;
                }
                h.g(this.f45225g);
                if (f45218i) {
                    Log.d("SwanAppSlavePresenter", "mCurPageParams = " + this.f45224f);
                }
            } else {
                this.f45221c = !TextUtils.isEmpty(this.f45219a.j0());
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (f45218i) {
                Log.d("SwanAppSlavePresenter", "mCurPageParams = " + this.f45224f);
            }
            if (!this.f45221c || this.f45222d) {
                return;
            }
            this.f45222d = true;
            SwanAppSlaveManager swanAppSlaveManager = this.f45219a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
            d.a.n0.a.p.e.j.d O = swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.O();
            if (O != null && O.f46628c > 0) {
                h.e(this.f45225g, "arrivesuccess", O, this.f45223e);
            } else {
                h.e(this.f45225g, "arrivecancel", O, this.f45223e);
            }
        }
    }

    public void h(@NonNull d.a.n0.a.l1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f45224f = bVar;
            this.f45225g = bVar.f45989e;
        }
    }
}
