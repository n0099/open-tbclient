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
import com.repackage.dv9;
import com.repackage.ev9;
import com.repackage.jv9;
import com.repackage.mw9;
import com.repackage.ru9;
import com.repackage.tu9;
import com.repackage.uu9;
import com.repackage.vy9;
import com.repackage.xu9;
import com.repackage.yu9;
import com.repackage.yy9;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes8.dex */
public final class ScalarSynchronousObservable<T> extends ru9<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public final T b;

    /* loaded from: classes8.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements tu9, ev9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2466317989629281651L;
        public transient /* synthetic */ FieldHolder $fh;
        public final xu9<? super T> actual;
        public final jv9<ev9, yu9> onSchedule;
        public final T value;

        public ScalarAsyncProducer(xu9<? super T> xu9Var, T t, jv9<ev9, yu9> jv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xu9Var, t, jv9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = xu9Var;
            this.value = t;
            this.onSchedule = jv9Var;
        }

        @Override // com.repackage.ev9
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xu9<? super T> xu9Var = this.actual;
                if (xu9Var.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    xu9Var.onNext(obj);
                    if (xu9Var.isUnsubscribed()) {
                        return;
                    }
                    xu9Var.onCompleted();
                } catch (Throwable th) {
                    dv9.g(th, xu9Var, obj);
                }
            }
        }

        @Override // com.repackage.tu9
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
    public class a implements jv9<ev9, yu9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mw9 a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, mw9 mw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, mw9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mw9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jv9
        public yu9 call(ev9 ev9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ev9Var)) == null) ? this.a.a(ev9Var) : (yu9) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements jv9<ev9, yu9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uu9 a;

        /* loaded from: classes8.dex */
        public class a implements ev9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ev9 a;
            public final /* synthetic */ uu9.a b;

            public a(b bVar, ev9 ev9Var, uu9.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, ev9Var, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = ev9Var;
                this.b = aVar;
            }

            @Override // com.repackage.ev9
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

        public b(ScalarSynchronousObservable scalarSynchronousObservable, uu9 uu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, uu9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uu9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jv9
        public yu9 call(ev9 ev9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ev9Var)) == null) {
                uu9.a createWorker = this.a.createWorker();
                createWorker.b(new a(this, ev9Var, createWorker));
                return createWorker;
            }
            return (yu9) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ru9.a<R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jv9 a;
        public final /* synthetic */ ScalarSynchronousObservable b;

        public c(ScalarSynchronousObservable scalarSynchronousObservable, jv9 jv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, jv9Var};
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
            this.a = jv9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ru9.a, com.repackage.fv9
        public void call(xu9<? super R> xu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xu9Var) == null) {
                ru9 ru9Var = (ru9) this.a.call(this.b.b);
                if (ru9Var instanceof ScalarSynchronousObservable) {
                    xu9Var.f(ScalarSynchronousObservable.D(xu9Var, ((ScalarSynchronousObservable) ru9Var).b));
                } else {
                    ru9Var.B(vy9.c(xu9Var));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d<T> implements ru9.a<T> {
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

        @Override // com.repackage.ru9.a, com.repackage.fv9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((xu9) ((xu9) obj));
        }

        public void call(xu9<? super T> xu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xu9Var) == null) {
                xu9Var.f(ScalarSynchronousObservable.D(xu9Var, this.a));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class e<T> implements ru9.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final T a;
        public final jv9<ev9, yu9> b;

        public e(T t, jv9<ev9, yu9> jv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t, jv9Var};
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
            this.b = jv9Var;
        }

        @Override // com.repackage.ru9.a, com.repackage.fv9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((xu9) ((xu9) obj));
        }

        public void call(xu9<? super T> xu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xu9Var) == null) {
                xu9Var.f(new ScalarAsyncProducer(xu9Var, this.a, this.b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class f<T> implements tu9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final xu9<? super T> a;
        public final T b;
        public boolean c;

        public f(xu9<? super T> xu9Var, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xu9Var, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xu9Var;
            this.b = t;
        }

        @Override // com.repackage.tu9
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
                xu9<? super T> xu9Var = this.a;
                if (xu9Var.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    xu9Var.onNext(obj);
                    if (xu9Var.isUnsubscribed()) {
                        return;
                    }
                    xu9Var.onCompleted();
                } catch (Throwable th) {
                    dv9.g(th, xu9Var, obj);
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
        super(yy9.h(new d(t)));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ru9.a) newInitContext.callArgs[0]);
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

    public static <T> tu9 D(xu9<? super T> xu9Var, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, xu9Var, t)) == null) {
            if (c) {
                return new SingleProducer(xu9Var, t);
            }
            return new f(xu9Var, t);
        }
        return (tu9) invokeLL.objValue;
    }

    public T E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (T) invokeV.objValue;
    }

    public <R> ru9<R> F(jv9<? super T, ? extends ru9<? extends R>> jv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jv9Var)) == null) ? ru9.a(new c(this, jv9Var)) : (ru9) invokeL.objValue;
    }

    public ru9<T> G(uu9 uu9Var) {
        InterceptResult invokeL;
        jv9 bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uu9Var)) == null) {
            if (uu9Var instanceof mw9) {
                bVar = new a(this, (mw9) uu9Var);
            } else {
                bVar = new b(this, uu9Var);
            }
            return ru9.a(new e(this.b, bVar));
        }
        return (ru9) invokeL.objValue;
    }
}
