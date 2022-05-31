package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cv9;
import com.repackage.dv9;
import com.repackage.iv9;
import com.repackage.lw9;
import com.repackage.qu9;
import com.repackage.su9;
import com.repackage.tu9;
import com.repackage.uy9;
import com.repackage.wu9;
import com.repackage.xu9;
import com.repackage.xy9;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes8.dex */
public final class ScalarSynchronousObservable<T> extends qu9<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public final T b;

    /* loaded from: classes8.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements su9, dv9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2466317989629281651L;
        public transient /* synthetic */ FieldHolder $fh;
        public final wu9<? super T> actual;
        public final iv9<dv9, xu9> onSchedule;
        public final T value;

        public ScalarAsyncProducer(wu9<? super T> wu9Var, T t, iv9<dv9, xu9> iv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wu9Var, t, iv9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = wu9Var;
            this.value = t;
            this.onSchedule = iv9Var;
        }

        @Override // com.repackage.dv9
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wu9<? super T> wu9Var = this.actual;
                if (wu9Var.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    wu9Var.onNext(obj);
                    if (wu9Var.isUnsubscribed()) {
                        return;
                    }
                    wu9Var.onCompleted();
                } catch (Throwable th) {
                    cv9.g(th, wu9Var, obj);
                }
            }
        }

        @Override // com.repackage.su9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i >= 0) {
                    if (i == 0 || !compareAndSet(false, true)) {
                        return;
                    }
                    this.actual.b(this.onSchedule.call(this));
                    return;
                }
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class a implements iv9<dv9, xu9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lw9 a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, lw9 lw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, lw9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lw9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.iv9
        public xu9 call(dv9 dv9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dv9Var)) == null) ? this.a.a(dv9Var) : (xu9) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements iv9<dv9, xu9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tu9 a;

        /* loaded from: classes8.dex */
        public class a implements dv9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ dv9 a;
            public final /* synthetic */ tu9.a b;

            public a(b bVar, dv9 dv9Var, tu9.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, dv9Var, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dv9Var;
                this.b = aVar;
            }

            @Override // com.repackage.dv9
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.a.call();
                    } finally {
                        this.b.unsubscribe();
                    }
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, tu9 tu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, tu9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tu9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.iv9
        public xu9 call(dv9 dv9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dv9Var)) == null) {
                tu9.a createWorker = this.a.createWorker();
                createWorker.b(new a(this, dv9Var, createWorker));
                return createWorker;
            }
            return (xu9) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements qu9.a<R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iv9 a;
        public final /* synthetic */ ScalarSynchronousObservable b;

        public c(ScalarSynchronousObservable scalarSynchronousObservable, iv9 iv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, iv9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = scalarSynchronousObservable;
            this.a = iv9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.qu9.a, com.repackage.ev9
        public void call(wu9<? super R> wu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wu9Var) == null) {
                qu9 qu9Var = (qu9) this.a.call(this.b.b);
                if (qu9Var instanceof ScalarSynchronousObservable) {
                    wu9Var.f(ScalarSynchronousObservable.D(wu9Var, ((ScalarSynchronousObservable) qu9Var).b));
                } else {
                    qu9Var.B(uy9.c(wu9Var));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d<T> implements qu9.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final T a;

        public d(T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t;
        }

        @Override // com.repackage.qu9.a, com.repackage.ev9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((wu9) ((wu9) obj));
        }

        public void call(wu9<? super T> wu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wu9Var) == null) {
                wu9Var.f(ScalarSynchronousObservable.D(wu9Var, this.a));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class e<T> implements qu9.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final T a;
        public final iv9<dv9, xu9> b;

        public e(T t, iv9<dv9, xu9> iv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t, iv9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t;
            this.b = iv9Var;
        }

        @Override // com.repackage.qu9.a, com.repackage.ev9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((wu9) ((wu9) obj));
        }

        public void call(wu9<? super T> wu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wu9Var) == null) {
                wu9Var.f(new ScalarAsyncProducer(wu9Var, this.a, this.b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class f<T> implements su9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final wu9<? super T> a;
        public final T b;
        public boolean c;

        public f(wu9<? super T> wu9Var, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wu9Var, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wu9Var;
            this.b = t;
        }

        @Override // com.repackage.su9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || this.c) {
                return;
            }
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i < 0) {
                throw new IllegalStateException("n >= required but it was " + j);
            } else if (i == 0) {
            } else {
                this.c = true;
                wu9<? super T> wu9Var = this.a;
                if (wu9Var.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    wu9Var.onNext(obj);
                    if (wu9Var.isUnsubscribed()) {
                        return;
                    }
                    wu9Var.onCompleted();
                } catch (Throwable th) {
                    cv9.g(th, wu9Var, obj);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1705646541, "Lrx/internal/util/ScalarSynchronousObservable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1705646541, "Lrx/internal/util/ScalarSynchronousObservable;");
                return;
            }
        }
        c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScalarSynchronousObservable(T t) {
        super(xy9.h(new d(t)));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((qu9.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> C(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, t)) == null) ? new ScalarSynchronousObservable<>(t) : (ScalarSynchronousObservable) invokeL.objValue;
    }

    public static <T> su9 D(wu9<? super T> wu9Var, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, wu9Var, t)) == null) {
            if (c) {
                return new SingleProducer(wu9Var, t);
            }
            return new f(wu9Var, t);
        }
        return (su9) invokeLL.objValue;
    }

    public T E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (T) invokeV.objValue;
    }

    public <R> qu9<R> F(iv9<? super T, ? extends qu9<? extends R>> iv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iv9Var)) == null) ? qu9.a(new c(this, iv9Var)) : (qu9) invokeL.objValue;
    }

    public qu9<T> G(tu9 tu9Var) {
        InterceptResult invokeL;
        iv9 bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tu9Var)) == null) {
            if (tu9Var instanceof lw9) {
                bVar = new a(this, (lw9) tu9Var);
            } else {
                bVar = new b(this, tu9Var);
            }
            return qu9.a(new e(this.b, bVar));
        }
        return (qu9) invokeL.objValue;
    }
}
