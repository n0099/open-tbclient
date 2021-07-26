package d.a.o0.a.v2;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
/* loaded from: classes7.dex */
public final class q {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48570a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile i f48571b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile i f48572c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile i f48573d;

    /* renamed from: e  reason: collision with root package name */
    public static final h.n.b f48574e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements h.n.b<Pair<Runnable, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Pair<Runnable, String> pair) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pair) == null) {
                String name = Thread.currentThread().getName();
                Thread currentThread = Thread.currentThread();
                currentThread.setName(name + "-" + ((String) pair.second));
                try {
                    long currentTimeMillis = q.f48570a ? System.currentTimeMillis() : 0L;
                    ((Runnable) pair.first).run();
                    if (q.f48570a) {
                        Log.d("SwanAppExecutorUtils", "Task [" + ((String) pair.second) + "] caused " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                    }
                } finally {
                    if (z) {
                    }
                    Thread.currentThread().setName(name);
                }
                Thread.currentThread().setName(name);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements h.n.f<Pair<Runnable, String>, h.d<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.d<?> call(Pair<Runnable, String> pair) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pair)) == null) ? h.h.g(pair).h(Schedulers.io()).f(q.f48574e).l() : (h.d) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements h.n.f<Pair<Runnable, String>, h.d<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.d<?> call(Pair<Runnable, String> pair) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pair)) == null) ? h.h.g(pair).h(Schedulers.computation()).f(q.f48574e).l() : (h.d) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements h.n.b<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48575e;

        public d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48575e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, th) == null) && q.f48570a) {
                Log.wtf("SwanAppExecutorUtils", "delay task [" + this.f48575e + "] fail!", th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements h.n.b<Pair<Runnable, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Pair<Runnable, String> pair) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pair) == null) {
                q.f().execute((Runnable) pair.first, (String) pair.second);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class f implements h.n.b<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48576e;

        public f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48576e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, th) == null) && q.f48570a) {
                Log.wtf("SwanAppExecutorUtils", "delay task [" + this.f48576e + "] fail!", th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class g implements h.n.b<Pair<Runnable, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Pair<Runnable, String> pair) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pair) == null) {
                q.e().execute((Runnable) pair.first, (String) pair.second);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface h extends Executor {
        void execute(@NonNull Runnable runnable, @NonNull String str);
    }

    /* loaded from: classes7.dex */
    public static class i extends h.t.c<Pair<Runnable, String>, Pair<Runnable, String>> implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(h.t.d dVar) {
            super(dVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((h.t.d) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                execute(runnable, "");
            }
        }

        @Override // d.a.o0.a.v2.q.h
        public void execute(@NonNull Runnable runnable, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, str) == null) {
                onNext(Pair.create(runnable, q.h(str)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(522951238, "Ld/a/o0/a/v2/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(522951238, "Ld/a/o0/a/v2/q;");
                return;
            }
        }
        f48570a = d.a.o0.a.k.f46335a;
        f48574e = new a();
    }

    public q() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static h.k c(@NonNull Runnable runnable, @NonNull String str, @NonNull long j, @NonNull TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{runnable, str, Long.valueOf(j), timeUnit})) == null) ? h.h.g(Pair.create(runnable, h(str))).c(j, timeUnit).f(new g()).e(new f(str)).i() : (h.k) invokeCommon.objValue;
    }

    public static h.k d(@NonNull Runnable runnable, @NonNull String str, @NonNull long j, @NonNull TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{runnable, str, Long.valueOf(j), timeUnit})) == null) ? h.h.g(Pair.create(runnable, h(str))).c(j, timeUnit).f(new e()).e(new d(str)).i() : (h.k) invokeCommon.objValue;
    }

    public static h e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (f48572c == null) {
                synchronized (q.class) {
                    if (f48572c == null) {
                        f48572c = new i(PublishSubject.K());
                        f48572c.s().g(new c()).x().y();
                    }
                }
            }
            return f48572c;
        }
        return (h) invokeV.objValue;
    }

    public static h f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f48571b == null) {
                synchronized (q.class) {
                    if (f48571b == null) {
                        f48571b = new i(PublishSubject.K());
                        f48571b.s().g(new b()).x().y();
                    }
                }
            }
            return f48571b;
        }
        return (h) invokeV.objValue;
    }

    public static h g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (f48573d == null) {
                synchronized (q.class) {
                    if (f48573d == null) {
                        f48573d = new i(PublishSubject.K());
                        f48573d.s().o(Schedulers.io()).d(f48574e).x().y();
                    }
                }
            }
            return f48573d;
        }
        return (h) invokeV.objValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (str == null) {
                str = null;
            } else if (!str.startsWith("SwanAppExecutorUtils_")) {
                str = "SwanAppExecutorUtils_" + str;
            }
            if (str == null) {
                str = "SwanAppExecutorUtils";
            }
            return str.length() > 256 ? str.substring(0, 255) : str;
        }
        return (String) invokeL.objValue;
    }

    public static void i(@NonNull Runnable runnable, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, runnable, str) == null) {
            e().execute(runnable, str);
        }
    }

    public static void j(@NonNull Runnable runnable, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, runnable, str) == null) {
            f().execute(runnable, str);
        }
    }

    public static void k(@NonNull Runnable runnable, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, runnable, str) == null) {
            g().execute(runnable, str);
        }
    }
}
