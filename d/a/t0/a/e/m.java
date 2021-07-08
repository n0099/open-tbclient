package d.a.t0.a.e;

import android.app.Activity;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubs.analytics.a.n;
import d.a.t0.a.c;
import d.a.t0.a.e.a;
import d.a.t0.a.e.d;
import java.util.UUID;
/* loaded from: classes8.dex */
public final class m implements a.InterfaceC1914a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static n f67591f;

    /* renamed from: g  reason: collision with root package name */
    public static long f67592g;

    /* renamed from: h  reason: collision with root package name */
    public static long f67593h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f67594a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f67595b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f67596c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f67597d;

    /* renamed from: e  reason: collision with root package name */
    public e f67598e;

    /* loaded from: classes8.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f67599a;

        /* renamed from: d.a.t0.a.e.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1915a extends d.a.t0.a.f.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C1915a(a aVar) {
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
                    }
                }
            }

            @Override // d.a.t0.a.f.c
            public final void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.t0.a.f.a.b("记录一次app启动事件");
                    d.a.t0.a.a.c("power_on", "", "", null);
                    d.a.t0.a.c.i().d(false);
                }
            }
        }

        public a(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67599a = mVar;
        }

        @Override // d.a.t0.a.e.m.e
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                d.a.t0.a.f.a.b("app   went foreground ");
                if (currentTimeMillis - m.f67593h > m.f67592g) {
                    this.f67599a.m(currentTimeMillis);
                }
                if (d.a.t0.a.c.i().h()) {
                    d.a.t0.a.f.b.a(new C1915a(this));
                }
            }
        }

        @Override // d.a.t0.a.e.m.e
        public final void b() {
            d.a.t0.a.e.d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                dVar = d.a.f67567a;
                if (dVar.a().size() == 0) {
                    d.a.t0.a.f.a.b("后台应用退出了 了               ");
                    d.a.t0.a.c.i().d(true);
                    long unused = m.f67593h = 0L;
                    return;
                }
                d.a.t0.a.f.a.b("进入后台但没退出                  ");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f67600e;

        public b(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67600e = mVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f67600e.f67594a && this.f67600e.f67595b) {
                this.f67600e.f67594a = false;
                try {
                    this.f67600e.f67598e.b();
                } catch (Exception e2) {
                    d.a.t0.a.f.i.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends d.a.t0.a.f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.t0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                m.f67591f.z(String.valueOf(currentTimeMillis));
                try {
                    m.f67591f.A(String.valueOf(currentTimeMillis - Long.parseLong(m.f67591f.N())));
                } catch (NumberFormatException e2) {
                    d.a.t0.a.f.a.b(e2.getLocalizedMessage());
                }
                c.l lVar = new c.l();
                if (lVar.b(m.f67591f.I())) {
                    lVar.e(m.f67591f);
                } else {
                    lVar.f(m.f67591f);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends d.a.t0.a.f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.t0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.t0.a.f.a.b("超时了……………… 一个新的session");
                new c.l().f(m.f67591f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a();

        void b();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-292428460, "Ld/a/t0/a/e/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-292428460, "Ld/a/t0/a/e/m;");
                return;
            }
        }
        f67592g = f.a();
    }

    public m() {
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
        this.f67594a = false;
        this.f67595b = true;
        this.f67596c = new Handler();
        this.f67598e = new a(this);
        long currentTimeMillis = System.currentTimeMillis();
        f67593h = currentTimeMillis;
        m(currentTimeMillis);
    }

    public static n e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f67591f : (n) invokeV.objValue;
    }

    @Override // d.a.t0.a.e.a.InterfaceC1914a
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f67595b = false;
            boolean z = !this.f67594a;
            this.f67594a = true;
            Runnable runnable = this.f67597d;
            if (runnable != null) {
                this.f67596c.removeCallbacks(runnable);
            }
            if (z) {
                try {
                    this.f67598e.a();
                } catch (Exception e2) {
                    d.a.t0.a.f.i.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    @Override // d.a.t0.a.e.a.InterfaceC1914a
    public final void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
        }
    }

    @Override // d.a.t0.a.e.a.InterfaceC1914a
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f67595b = true;
            Runnable runnable = this.f67597d;
            if (runnable != null) {
                this.f67596c.removeCallbacks(runnable);
                this.f67597d = null;
            }
            f67593h = System.currentTimeMillis();
            d.a.t0.a.f.b.c(new c(this));
            Handler handler = this.f67596c;
            b bVar = new b(this);
            this.f67597d = bVar;
            handler.postDelayed(bVar, 1000L);
        }
    }

    public final void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            n nVar = new n();
            f67591f = nVar;
            nVar.setStartTime(String.valueOf(j));
            f67591f.x(UUID.randomUUID().toString().replace("-", ""));
            d.a.t0.a.f.b.c(new d(this));
        }
    }

    @Override // d.a.t0.a.e.a.InterfaceC1914a
    public final void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
        }
    }
}
