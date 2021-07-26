package d.a.u0.a.e;

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
import d.a.u0.a.c;
import d.a.u0.a.e.a;
import d.a.u0.a.e.d;
import java.util.UUID;
/* loaded from: classes8.dex */
public final class m implements a.InterfaceC1919a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static n f68269f;

    /* renamed from: g  reason: collision with root package name */
    public static long f68270g;

    /* renamed from: h  reason: collision with root package name */
    public static long f68271h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f68272a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f68273b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f68274c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f68275d;

    /* renamed from: e  reason: collision with root package name */
    public e f68276e;

    /* loaded from: classes8.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f68277a;

        /* renamed from: d.a.u0.a.e.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1920a extends d.a.u0.a.f.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C1920a(a aVar) {
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

            @Override // d.a.u0.a.f.c
            public final void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.u0.a.f.a.b("记录一次app启动事件");
                    d.a.u0.a.a.c("power_on", "", "", null);
                    d.a.u0.a.c.i().d(false);
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
            this.f68277a = mVar;
        }

        @Override // d.a.u0.a.e.m.e
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                d.a.u0.a.f.a.b("app   went foreground ");
                if (currentTimeMillis - m.f68271h > m.f68270g) {
                    this.f68277a.m(currentTimeMillis);
                }
                if (d.a.u0.a.c.i().h()) {
                    d.a.u0.a.f.b.a(new C1920a(this));
                }
            }
        }

        @Override // d.a.u0.a.e.m.e
        public final void b() {
            d.a.u0.a.e.d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                dVar = d.a.f68245a;
                if (dVar.a().size() == 0) {
                    d.a.u0.a.f.a.b("后台应用退出了 了               ");
                    d.a.u0.a.c.i().d(true);
                    long unused = m.f68271h = 0L;
                    return;
                }
                d.a.u0.a.f.a.b("进入后台但没退出                  ");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f68278e;

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
            this.f68278e = mVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f68278e.f68272a && this.f68278e.f68273b) {
                this.f68278e.f68272a = false;
                try {
                    this.f68278e.f68276e.b();
                } catch (Exception e2) {
                    d.a.u0.a.f.i.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends d.a.u0.a.f.c {
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

        @Override // d.a.u0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                m.f68269f.z(String.valueOf(currentTimeMillis));
                try {
                    m.f68269f.A(String.valueOf(currentTimeMillis - Long.parseLong(m.f68269f.N())));
                } catch (NumberFormatException e2) {
                    d.a.u0.a.f.a.b(e2.getLocalizedMessage());
                }
                c.l lVar = new c.l();
                if (lVar.b(m.f68269f.I())) {
                    lVar.e(m.f68269f);
                } else {
                    lVar.f(m.f68269f);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends d.a.u0.a.f.c {
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

        @Override // d.a.u0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.u0.a.f.a.b("超时了……………… 一个新的session");
                new c.l().f(m.f68269f);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2099882923, "Ld/a/u0/a/e/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2099882923, "Ld/a/u0/a/e/m;");
                return;
            }
        }
        f68270g = f.a();
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
        this.f68272a = false;
        this.f68273b = true;
        this.f68274c = new Handler();
        this.f68276e = new a(this);
        long currentTimeMillis = System.currentTimeMillis();
        f68271h = currentTimeMillis;
        m(currentTimeMillis);
    }

    public static n e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f68269f : (n) invokeV.objValue;
    }

    @Override // d.a.u0.a.e.a.InterfaceC1919a
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f68273b = false;
            boolean z = !this.f68272a;
            this.f68272a = true;
            Runnable runnable = this.f68275d;
            if (runnable != null) {
                this.f68274c.removeCallbacks(runnable);
            }
            if (z) {
                try {
                    this.f68276e.a();
                } catch (Exception e2) {
                    d.a.u0.a.f.i.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    @Override // d.a.u0.a.e.a.InterfaceC1919a
    public final void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
        }
    }

    @Override // d.a.u0.a.e.a.InterfaceC1919a
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f68273b = true;
            Runnable runnable = this.f68275d;
            if (runnable != null) {
                this.f68274c.removeCallbacks(runnable);
                this.f68275d = null;
            }
            f68271h = System.currentTimeMillis();
            d.a.u0.a.f.b.c(new c(this));
            Handler handler = this.f68274c;
            b bVar = new b(this);
            this.f68275d = bVar;
            handler.postDelayed(bVar, 1000L);
        }
    }

    public final void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            n nVar = new n();
            f68269f = nVar;
            nVar.setStartTime(String.valueOf(j));
            f68269f.x(UUID.randomUUID().toString().replace("-", ""));
            d.a.u0.a.f.b.c(new d(this));
        }
    }

    @Override // d.a.u0.a.e.a.InterfaceC1919a
    public final void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
        }
    }
}
