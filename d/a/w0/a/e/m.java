package d.a.w0.a.e;

import android.app.Activity;
import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubs.analytics.a.n;
import d.a.w0.a.c;
import d.a.w0.a.e.a;
import d.a.w0.a.e.d;
import java.util.UUID;
/* loaded from: classes9.dex */
public final class m implements a.InterfaceC1961a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static n f70938f;

    /* renamed from: g  reason: collision with root package name */
    public static long f70939g;

    /* renamed from: h  reason: collision with root package name */
    public static long f70940h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f70941a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f70942b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f70943c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f70944d;

    /* renamed from: e  reason: collision with root package name */
    public e f70945e;

    /* loaded from: classes9.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f70946a;

        /* renamed from: d.a.w0.a.e.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1962a extends d.a.w0.a.f.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C1962a(a aVar) {
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

            @Override // d.a.w0.a.f.c
            public final void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.w0.a.f.a.b("记录一次app启动事件");
                    d.a.w0.a.a.c("power_on", "", "", null);
                    d.a.w0.a.c.i().d(false);
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
            this.f70946a = mVar;
        }

        @Override // d.a.w0.a.e.m.e
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                d.a.w0.a.f.a.b("app   went foreground ");
                if (currentTimeMillis - m.f70940h > m.f70939g) {
                    this.f70946a.m(currentTimeMillis);
                }
                if (d.a.w0.a.c.i().h()) {
                    d.a.w0.a.f.b.a(new C1962a(this));
                }
            }
        }

        @Override // d.a.w0.a.e.m.e
        public final void b() {
            d.a.w0.a.e.d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                dVar = d.a.f70914a;
                if (dVar.a().size() == 0) {
                    d.a.w0.a.f.a.b("后台应用退出了 了               ");
                    d.a.w0.a.c.i().d(true);
                    long unused = m.f70940h = 0L;
                    return;
                }
                d.a.w0.a.f.a.b("进入后台但没退出                  ");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f70947e;

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
            this.f70947e = mVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f70947e.f70941a && this.f70947e.f70942b) {
                this.f70947e.f70941a = false;
                try {
                    this.f70947e.f70945e.b();
                } catch (Exception e2) {
                    d.a.w0.a.f.i.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends d.a.w0.a.f.c {
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

        @Override // d.a.w0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                m.f70938f.z(String.valueOf(currentTimeMillis));
                try {
                    m.f70938f.A(String.valueOf(currentTimeMillis - Long.parseLong(m.f70938f.N())));
                } catch (NumberFormatException e2) {
                    d.a.w0.a.f.a.b(e2.getLocalizedMessage());
                }
                c.l lVar = new c.l();
                if (lVar.b(m.f70938f.I())) {
                    lVar.e(m.f70938f);
                } else {
                    lVar.f(m.f70938f);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends d.a.w0.a.f.c {
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

        @Override // d.a.w0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.w0.a.f.a.b("超时了……………… 一个新的session");
                new c.l().f(m.f70938f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface e {
        void a();

        void b();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1419824553, "Ld/a/w0/a/e/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1419824553, "Ld/a/w0/a/e/m;");
                return;
            }
        }
        f70939g = f.a();
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
        this.f70941a = false;
        this.f70942b = true;
        this.f70943c = new Handler();
        this.f70945e = new a(this);
        long currentTimeMillis = System.currentTimeMillis();
        f70940h = currentTimeMillis;
        m(currentTimeMillis);
    }

    public static n e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? f70938f : (n) invokeV.objValue;
    }

    @Override // d.a.w0.a.e.a.InterfaceC1961a
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f70942b = false;
            boolean z = !this.f70941a;
            this.f70941a = true;
            Runnable runnable = this.f70944d;
            if (runnable != null) {
                this.f70943c.removeCallbacks(runnable);
            }
            if (z) {
                try {
                    this.f70945e.a();
                } catch (Exception e2) {
                    d.a.w0.a.f.i.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    @Override // d.a.w0.a.e.a.InterfaceC1961a
    public final void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
        }
    }

    @Override // d.a.w0.a.e.a.InterfaceC1961a
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f70942b = true;
            Runnable runnable = this.f70944d;
            if (runnable != null) {
                this.f70943c.removeCallbacks(runnable);
                this.f70944d = null;
            }
            f70940h = System.currentTimeMillis();
            d.a.w0.a.f.b.c(new c(this));
            Handler handler = this.f70943c;
            b bVar = new b(this);
            this.f70944d = bVar;
            handler.postDelayed(bVar, 1000L);
        }
    }

    public final void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            n nVar = new n();
            f70938f = nVar;
            nVar.setStartTime(String.valueOf(j));
            f70938f.x(UUID.randomUUID().toString().replace("-", ""));
            d.a.w0.a.f.b.c(new d(this));
        }
    }

    @Override // d.a.w0.a.e.a.InterfaceC1961a
    public final void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
        }
    }
}
