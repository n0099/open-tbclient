package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.d0a;
import com.baidu.tieba.e0a;
import com.baidu.tieba.j0a;
import com.baidu.tieba.m1a;
import com.baidu.tieba.rz9;
import com.baidu.tieba.tz9;
import com.baidu.tieba.uz9;
import com.baidu.tieba.v3a;
import com.baidu.tieba.xz9;
import com.baidu.tieba.y3a;
import com.baidu.tieba.yz9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes9.dex */
public final class ScalarSynchronousObservable<T> extends rz9<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public final T b;

    /* loaded from: classes9.dex */
    public class b implements j0a<e0a, yz9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz9 a;

        /* loaded from: classes9.dex */
        public class a implements e0a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e0a a;
            public final /* synthetic */ uz9.a b;

            public a(b bVar, e0a e0aVar, uz9.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, e0aVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = e0aVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.e0a
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

        public b(ScalarSynchronousObservable scalarSynchronousObservable, uz9 uz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, uz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uz9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j0a
        public yz9 call(e0a e0aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e0aVar)) == null) {
                uz9.a createWorker = this.a.createWorker();
                createWorker.b(new a(this, e0aVar, createWorker));
                return createWorker;
            }
            return (yz9) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements tz9, e0a {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2466317989629281651L;
        public transient /* synthetic */ FieldHolder $fh;
        public final xz9<? super T> actual;
        public final j0a<e0a, yz9> onSchedule;
        public final T value;

        public ScalarAsyncProducer(xz9<? super T> xz9Var, T t, j0a<e0a, yz9> j0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var, t, j0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = xz9Var;
            this.value = t;
            this.onSchedule = j0aVar;
        }

        @Override // com.baidu.tieba.e0a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xz9<? super T> xz9Var = this.actual;
                if (xz9Var.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    xz9Var.onNext(obj);
                    if (xz9Var.isUnsubscribed()) {
                        return;
                    }
                    xz9Var.onCompleted();
                } catch (Throwable th) {
                    d0a.g(th, xz9Var, obj);
                }
            }
        }

        @Override // com.baidu.tieba.tz9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i >= 0) {
                    if (i != 0 && compareAndSet(false, true)) {
                        this.actual.b(this.onSchedule.call(this));
                        return;
                    }
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

    /* loaded from: classes9.dex */
    public class a implements j0a<e0a, yz9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m1a a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, m1a m1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, m1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m1aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j0a
        public yz9 call(e0a e0aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e0aVar)) == null) {
                return this.a.a(e0aVar);
            }
            return (yz9) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c implements rz9.a<R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j0a a;
        public final /* synthetic */ ScalarSynchronousObservable b;

        public c(ScalarSynchronousObservable scalarSynchronousObservable, j0a j0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, j0aVar};
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
            this.a = j0aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rz9.a, com.baidu.tieba.f0a
        public void call(xz9<? super R> xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xz9Var) == null) {
                rz9 rz9Var = (rz9) this.a.call(this.b.b);
                if (rz9Var instanceof ScalarSynchronousObservable) {
                    xz9Var.f(ScalarSynchronousObservable.D(xz9Var, ((ScalarSynchronousObservable) rz9Var).b));
                } else {
                    rz9Var.B(v3a.c(xz9Var));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class d<T> implements rz9.a<T> {
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

        public void call(xz9<? super T> xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xz9Var) == null) {
                xz9Var.f(ScalarSynchronousObservable.D(xz9Var, this.a));
            }
        }

        @Override // com.baidu.tieba.rz9.a, com.baidu.tieba.f0a
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((xz9) ((xz9) obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class e<T> implements rz9.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final T a;
        public final j0a<e0a, yz9> b;

        public e(T t, j0a<e0a, yz9> j0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t, j0aVar};
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
            this.b = j0aVar;
        }

        public void call(xz9<? super T> xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xz9Var) == null) {
                xz9Var.f(new ScalarAsyncProducer(xz9Var, this.a, this.b));
            }
        }

        @Override // com.baidu.tieba.rz9.a, com.baidu.tieba.f0a
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((xz9) ((xz9) obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class f<T> implements tz9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final xz9<? super T> a;
        public final T b;
        public boolean c;

        public f(xz9<? super T> xz9Var, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz9Var;
            this.b = t;
        }

        @Override // com.baidu.tieba.tz9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeJ(1048576, this, j) != null) || this.c) {
                return;
            }
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i == 0) {
                    return;
                }
                this.c = true;
                xz9<? super T> xz9Var = this.a;
                if (xz9Var.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    xz9Var.onNext(obj);
                    if (xz9Var.isUnsubscribed()) {
                        return;
                    }
                    xz9Var.onCompleted();
                    return;
                } catch (Throwable th) {
                    d0a.g(th, xz9Var, obj);
                    return;
                }
            }
            throw new IllegalStateException("n >= required but it was " + j);
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

    public T E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (T) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScalarSynchronousObservable(T t) {
        super(y3a.h(new d(t)));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rz9.a) newInitContext.callArgs[0]);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, t)) == null) {
            return new ScalarSynchronousObservable<>(t);
        }
        return (ScalarSynchronousObservable) invokeL.objValue;
    }

    public <R> rz9<R> F(j0a<? super T, ? extends rz9<? extends R>> j0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j0aVar)) == null) {
            return rz9.a(new c(this, j0aVar));
        }
        return (rz9) invokeL.objValue;
    }

    public rz9<T> G(uz9 uz9Var) {
        InterceptResult invokeL;
        j0a bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uz9Var)) == null) {
            if (uz9Var instanceof m1a) {
                bVar = new a(this, (m1a) uz9Var);
            } else {
                bVar = new b(this, uz9Var);
            }
            return rz9.a(new e(this.b, bVar));
        }
        return (rz9) invokeL.objValue;
    }

    public static <T> tz9 D(xz9<? super T> xz9Var, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, xz9Var, t)) == null) {
            if (c) {
                return new SingleProducer(xz9Var, t);
            }
            return new f(xz9Var, t);
        }
        return (tz9) invokeLL.objValue;
    }
}
