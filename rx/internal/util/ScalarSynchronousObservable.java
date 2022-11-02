package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.b1a;
import com.baidu.tieba.gz9;
import com.baidu.tieba.iz9;
import com.baidu.tieba.jz9;
import com.baidu.tieba.k3a;
import com.baidu.tieba.mz9;
import com.baidu.tieba.n3a;
import com.baidu.tieba.nz9;
import com.baidu.tieba.sz9;
import com.baidu.tieba.tz9;
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
public final class ScalarSynchronousObservable<T> extends gz9<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public final T b;

    /* loaded from: classes9.dex */
    public class b implements yz9<tz9, nz9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz9 a;

        /* loaded from: classes9.dex */
        public class a implements tz9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tz9 a;
            public final /* synthetic */ jz9.a b;

            public a(b bVar, tz9 tz9Var, jz9.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, tz9Var, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = tz9Var;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.tz9
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

        public b(ScalarSynchronousObservable scalarSynchronousObservable, jz9 jz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, jz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yz9
        public nz9 call(tz9 tz9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tz9Var)) == null) {
                jz9.a createWorker = this.a.createWorker();
                createWorker.b(new a(this, tz9Var, createWorker));
                return createWorker;
            }
            return (nz9) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements iz9, tz9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2466317989629281651L;
        public transient /* synthetic */ FieldHolder $fh;
        public final mz9<? super T> actual;
        public final yz9<tz9, nz9> onSchedule;
        public final T value;

        public ScalarAsyncProducer(mz9<? super T> mz9Var, T t, yz9<tz9, nz9> yz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz9Var, t, yz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = mz9Var;
            this.value = t;
            this.onSchedule = yz9Var;
        }

        @Override // com.baidu.tieba.tz9
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                mz9<? super T> mz9Var = this.actual;
                if (mz9Var.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    mz9Var.onNext(obj);
                    if (mz9Var.isUnsubscribed()) {
                        return;
                    }
                    mz9Var.onCompleted();
                } catch (Throwable th) {
                    sz9.g(th, mz9Var, obj);
                }
            }
        }

        @Override // com.baidu.tieba.iz9
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
    public class a implements yz9<tz9, nz9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b1a a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, b1a b1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, b1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b1aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yz9
        public nz9 call(tz9 tz9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tz9Var)) == null) {
                return this.a.a(tz9Var);
            }
            return (nz9) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c implements gz9.a<R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz9 a;
        public final /* synthetic */ ScalarSynchronousObservable b;

        public c(ScalarSynchronousObservable scalarSynchronousObservable, yz9 yz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, yz9Var};
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
            this.a = yz9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gz9.a, com.baidu.tieba.uz9
        public void call(mz9<? super R> mz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mz9Var) == null) {
                gz9 gz9Var = (gz9) this.a.call(this.b.b);
                if (gz9Var instanceof ScalarSynchronousObservable) {
                    mz9Var.f(ScalarSynchronousObservable.D(mz9Var, ((ScalarSynchronousObservable) gz9Var).b));
                } else {
                    gz9Var.B(k3a.c(mz9Var));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class d<T> implements gz9.a<T> {
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

        public void call(mz9<? super T> mz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mz9Var) == null) {
                mz9Var.f(ScalarSynchronousObservable.D(mz9Var, this.a));
            }
        }

        @Override // com.baidu.tieba.gz9.a, com.baidu.tieba.uz9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((mz9) ((mz9) obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class e<T> implements gz9.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final T a;
        public final yz9<tz9, nz9> b;

        public e(T t, yz9<tz9, nz9> yz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t, yz9Var};
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
            this.b = yz9Var;
        }

        public void call(mz9<? super T> mz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mz9Var) == null) {
                mz9Var.f(new ScalarAsyncProducer(mz9Var, this.a, this.b));
            }
        }

        @Override // com.baidu.tieba.gz9.a, com.baidu.tieba.uz9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((mz9) ((mz9) obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class f<T> implements iz9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final mz9<? super T> a;
        public final T b;
        public boolean c;

        public f(mz9<? super T> mz9Var, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz9Var, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mz9Var;
            this.b = t;
        }

        @Override // com.baidu.tieba.iz9
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
                mz9<? super T> mz9Var = this.a;
                if (mz9Var.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    mz9Var.onNext(obj);
                    if (mz9Var.isUnsubscribed()) {
                        return;
                    }
                    mz9Var.onCompleted();
                    return;
                } catch (Throwable th) {
                    sz9.g(th, mz9Var, obj);
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
        super(n3a.h(new d(t)));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((gz9.a) newInitContext.callArgs[0]);
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

    public <R> gz9<R> F(yz9<? super T, ? extends gz9<? extends R>> yz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yz9Var)) == null) {
            return gz9.a(new c(this, yz9Var));
        }
        return (gz9) invokeL.objValue;
    }

    public gz9<T> G(jz9 jz9Var) {
        InterceptResult invokeL;
        yz9 bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jz9Var)) == null) {
            if (jz9Var instanceof b1a) {
                bVar = new a(this, (b1a) jz9Var);
            } else {
                bVar = new b(this, jz9Var);
            }
            return gz9.a(new e(this.b, bVar));
        }
        return (gz9) invokeL.objValue;
    }

    public static <T> iz9 D(mz9<? super T> mz9Var, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, mz9Var, t)) == null) {
            if (c) {
                return new SingleProducer(mz9Var, t);
            }
            return new f(mz9Var, t);
        }
        return (iz9) invokeLL.objValue;
    }
}
