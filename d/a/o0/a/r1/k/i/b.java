package d.a.o0.a.r1.k.i;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.r1.l.e;
import d.a.o0.a.v2.q;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class b implements d.a.o0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final int f47631e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f47632b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Runnable, String> f47633c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.a.r1.r.c.a f47634d;

    /* loaded from: classes7.dex */
    public class a implements d.a.o0.a.r1.r.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f47635b;

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
            this.f47635b = bVar;
        }

        @Override // d.a.o0.a.r1.r.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // d.a.o0.a.r1.r.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f47635b.f47632b = false;
                this.f47635b.d();
            }
        }

        @Override // d.a.o0.a.r1.r.c.a
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.f47635b.f47632b = false;
                long currentTimeMillis = System.currentTimeMillis();
                int size = this.f47635b.f47633c.size();
                this.f47635b.d();
                if (d.a.o0.a.f1.f.a.f44988a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Log.d("SwanPerformance", "thread dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + size);
                }
            }
        }

        @Override // d.a.o0.a.r1.r.c.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f47635b.f47632b = true;
            }
        }

        @Override // d.a.o0.a.r1.r.c.a
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "ThreadDispatch" : (String) invokeV.objValue;
        }
    }

    /* renamed from: d.a.o0.a.r1.k.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0886b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f47636a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1300661982, "Ld/a/o0/a/r1/k/i/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1300661982, "Ld/a/o0/a/r1/k/i/b$b;");
                    return;
                }
            }
            f47636a = new b(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1275095068, "Ld/a/o0/a/r1/k/i/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1275095068, "Ld/a/o0/a/r1/k/i/b;");
                return;
            }
        }
        f47631e = e.i();
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? C0886b.f47636a : (b) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f47633c.isEmpty()) {
            return;
        }
        for (Map.Entry<Runnable, String> entry : this.f47633c.entrySet()) {
            if (entry != null) {
                q.k(entry.getKey(), entry.getValue());
            }
        }
        this.f47633c.clear();
    }

    public boolean f(Runnable runnable, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, str)) == null) {
            if (runnable == null) {
                return false;
            }
            if (f47631e > 0 && this.f47632b) {
                this.f47633c.put(runnable, str);
                return true;
            }
            q.k(runnable, str);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.f().g();
            if (f47631e <= 0) {
                if (d.a.o0.a.f1.f.a.f44988a) {
                    Log.e("SwanPerformance", "launch thread dispatch can't register. ab is closed");
                    return;
                }
                return;
            }
            d.a.o0.a.r1.r.a.f().h(this.f47634d, f47631e);
        }
    }

    public b() {
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
        this.f47632b = false;
        this.f47633c = new ConcurrentHashMap();
        this.f47634d = new a(this);
    }
}
