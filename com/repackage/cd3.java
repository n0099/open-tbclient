package com.repackage;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes5.dex */
public final class cd3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile k b;
    public static volatile k c;
    public static volatile k d;
    public static final is9 e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements is9<Pair<Runnable, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.is9
        public void call(Pair<Runnable, String> pair) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pair) == null) {
                String name = Thread.currentThread().getName();
                Thread currentThread = Thread.currentThread();
                currentThread.setName(name + "-" + ((String) pair.second));
                try {
                    long currentTimeMillis = cd3.a ? System.currentTimeMillis() : 0L;
                    ((Runnable) pair.first).run();
                    if (cd3.a) {
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

    /* loaded from: classes5.dex */
    public static class b implements ms9<Pair<Runnable, String>, ur9<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ms9
        public ur9<?> call(Pair<Runnable, String> pair) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pair)) == null) ? yr9.g(pair).h(Schedulers.io()).f(cd3.e).l() : (ur9) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements ms9<Pair<Runnable, String>, ur9<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ms9
        public ur9<?> call(Pair<Runnable, String> pair) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pair)) == null) ? yr9.g(pair).h(Schedulers.computation()).f(cd3.e).l() : (ur9) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements is9<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.is9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) && cd3.a) {
                Log.wtf("SwanAppExecutorUtils", "delay task [" + this.a + "] fail!", th);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements is9<Pair<Runnable, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.is9
        public void call(Pair<Runnable, String> pair) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pair) == null) {
                cd3.g().execute((Runnable) pair.first, (String) pair.second);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements is9<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.is9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) && cd3.a) {
                Log.wtf("SwanAppExecutorUtils", "delay task [" + this.a + "] fail!", th);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements is9<Pair<Runnable, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.is9
        public void call(Pair<Runnable, String> pair) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pair) == null) {
                cd3.f().execute((Runnable) pair.first, (String) pair.second);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements is9<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public h(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.is9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) && cd3.a) {
                Log.wtf("SwanAppExecutorUtils", "delay task [" + this.a + "] fail!", th);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class i implements is9<Pair<Runnable, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.is9
        public void call(Pair<Runnable, String> pair) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pair) == null) {
                cd3.h().execute((Runnable) pair.first, (String) pair.second);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface j extends Executor {
        void execute(@NonNull Runnable runnable, @NonNull String str);
    }

    /* loaded from: classes5.dex */
    public static class k extends lw9<Pair<Runnable, String>, Pair<Runnable, String>> implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(mw9 mw9Var) {
            super(mw9Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mw9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((mw9) newInitContext.callArgs[0]);
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

        @Override // com.repackage.cd3.j
        public void execute(@NonNull Runnable runnable, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, str) == null) {
                onNext(Pair.create(runnable, cd3.i(str)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755801089, "Lcom/repackage/cd3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755801089, "Lcom/repackage/cd3;");
                return;
            }
        }
        a = sg1.a;
        e = new a();
    }

    public cd3() {
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

    public static bs9 c(@NonNull Runnable runnable, @NonNull String str, @NonNull long j2, @NonNull TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{runnable, str, Long.valueOf(j2), timeUnit})) == null) ? yr9.g(Pair.create(runnable, i(str))).c(j2, timeUnit).f(new g()).e(new f(str)).i() : (bs9) invokeCommon.objValue;
    }

    public static bs9 d(@NonNull Runnable runnable, @NonNull String str, @NonNull long j2, @NonNull TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{runnable, str, Long.valueOf(j2), timeUnit})) == null) ? yr9.g(Pair.create(runnable, i(str))).c(j2, timeUnit).f(new e()).e(new d(str)).i() : (bs9) invokeCommon.objValue;
    }

    public static bs9 e(@NonNull Runnable runnable, @NonNull String str, @NonNull long j2, @NonNull TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{runnable, str, Long.valueOf(j2), timeUnit})) == null) ? yr9.g(Pair.create(runnable, i(str))).c(j2, timeUnit).f(new i()).e(new h(str)).i() : (bs9) invokeCommon.objValue;
    }

    public static j f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (c == null) {
                synchronized (cd3.class) {
                    if (c == null) {
                        c = new k(PublishSubject.D());
                        c.n().d(new c()).s().t();
                    }
                }
            }
            return c;
        }
        return (j) invokeV.objValue;
    }

    public static j g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (b == null) {
                synchronized (cd3.class) {
                    if (b == null) {
                        b = new k(PublishSubject.D());
                        b.n().d(new b()).s().t();
                    }
                }
            }
            return b;
        }
        return (j) invokeV.objValue;
    }

    public static j h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (d == null) {
                synchronized (cd3.class) {
                    if (d == null) {
                        d = new k(PublishSubject.D());
                        d.n().k(Schedulers.io()).b(e).s().t();
                    }
                }
            }
            return d;
        }
        return (j) invokeV.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
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

    public static void l(@NonNull Runnable runnable, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, runnable, str) == null) {
            h().execute(runnable, str);
        }
    }
}
