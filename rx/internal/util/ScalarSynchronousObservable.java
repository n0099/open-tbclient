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
import com.repackage.as9;
import com.repackage.bs9;
import com.repackage.bw9;
import com.repackage.gs9;
import com.repackage.hs9;
import com.repackage.ms9;
import com.repackage.pt9;
import com.repackage.ur9;
import com.repackage.wr9;
import com.repackage.xr9;
import com.repackage.yv9;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes8.dex */
public final class ScalarSynchronousObservable<T> extends ur9<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public final T b;

    /* loaded from: classes8.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements wr9, hs9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2466317989629281651L;
        public transient /* synthetic */ FieldHolder $fh;
        public final as9<? super T> actual;
        public final ms9<hs9, bs9> onSchedule;
        public final T value;

        public ScalarAsyncProducer(as9<? super T> as9Var, T t, ms9<hs9, bs9> ms9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as9Var, t, ms9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = as9Var;
            this.value = t;
            this.onSchedule = ms9Var;
        }

        @Override // com.repackage.hs9
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                as9<? super T> as9Var = this.actual;
                if (as9Var.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    as9Var.onNext(obj);
                    if (as9Var.isUnsubscribed()) {
                        return;
                    }
                    as9Var.onCompleted();
                } catch (Throwable th) {
                    gs9.g(th, as9Var, obj);
                }
            }
        }

        @Override // com.repackage.wr9
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
    public class a implements ms9<hs9, bs9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pt9 a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, pt9 pt9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, pt9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pt9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ms9
        public bs9 call(hs9 hs9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hs9Var)) == null) ? this.a.a(hs9Var) : (bs9) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ms9<hs9, bs9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xr9 a;

        /* loaded from: classes8.dex */
        public class a implements hs9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ hs9 a;
            public final /* synthetic */ xr9.a b;

            public a(b bVar, hs9 hs9Var, xr9.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, hs9Var, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hs9Var;
                this.b = aVar;
            }

            @Override // com.repackage.hs9
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

        public b(ScalarSynchronousObservable scalarSynchronousObservable, xr9 xr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, xr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xr9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ms9
        public bs9 call(hs9 hs9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hs9Var)) == null) {
                xr9.a createWorker = this.a.createWorker();
                createWorker.b(new a(this, hs9Var, createWorker));
                return createWorker;
            }
            return (bs9) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ur9.a<R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ms9 a;
        public final /* synthetic */ ScalarSynchronousObservable b;

        public c(ScalarSynchronousObservable scalarSynchronousObservable, ms9 ms9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, ms9Var};
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
            this.a = ms9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ur9.a, com.repackage.is9
        public void call(as9<? super R> as9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
                ur9 ur9Var = (ur9) this.a.call(this.b.b);
                if (ur9Var instanceof ScalarSynchronousObservable) {
                    as9Var.f(ScalarSynchronousObservable.D(as9Var, ((ScalarSynchronousObservable) ur9Var).b));
                } else {
                    ur9Var.B(yv9.c(as9Var));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d<T> implements ur9.a<T> {
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

        @Override // com.repackage.ur9.a, com.repackage.is9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((as9) ((as9) obj));
        }

        public void call(as9<? super T> as9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
                as9Var.f(ScalarSynchronousObservable.D(as9Var, this.a));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class e<T> implements ur9.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final T a;
        public final ms9<hs9, bs9> b;

        public e(T t, ms9<hs9, bs9> ms9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t, ms9Var};
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
            this.b = ms9Var;
        }

        @Override // com.repackage.ur9.a, com.repackage.is9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((as9) ((as9) obj));
        }

        public void call(as9<? super T> as9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
                as9Var.f(new ScalarAsyncProducer(as9Var, this.a, this.b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class f<T> implements wr9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final as9<? super T> a;
        public final T b;
        public boolean c;

        public f(as9<? super T> as9Var, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as9Var, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as9Var;
            this.b = t;
        }

        @Override // com.repackage.wr9
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
                as9<? super T> as9Var = this.a;
                if (as9Var.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    as9Var.onNext(obj);
                    if (as9Var.isUnsubscribed()) {
                        return;
                    }
                    as9Var.onCompleted();
                } catch (Throwable th) {
                    gs9.g(th, as9Var, obj);
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
        super(bw9.h(new d(t)));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ur9.a) newInitContext.callArgs[0]);
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

    public static <T> wr9 D(as9<? super T> as9Var, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, as9Var, t)) == null) {
            if (c) {
                return new SingleProducer(as9Var, t);
            }
            return new f(as9Var, t);
        }
        return (wr9) invokeLL.objValue;
    }

    public T E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (T) invokeV.objValue;
    }

    public <R> ur9<R> F(ms9<? super T, ? extends ur9<? extends R>> ms9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ms9Var)) == null) ? ur9.a(new c(this, ms9Var)) : (ur9) invokeL.objValue;
    }

    public ur9<T> G(xr9 xr9Var) {
        InterceptResult invokeL;
        ms9 bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xr9Var)) == null) {
            if (xr9Var instanceof pt9) {
                bVar = new a(this, (pt9) xr9Var);
            } else {
                bVar = new b(this, xr9Var);
            }
            return ur9.a(new e(this.b, bVar));
        }
        return (ur9) invokeL.objValue;
    }
}
