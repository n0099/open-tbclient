package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.c9a;
import com.baidu.tieba.faa;
import com.baidu.tieba.k8a;
import com.baidu.tieba.m8a;
import com.baidu.tieba.n8a;
import com.baidu.tieba.oca;
import com.baidu.tieba.q8a;
import com.baidu.tieba.r8a;
import com.baidu.tieba.rca;
import com.baidu.tieba.w8a;
import com.baidu.tieba.x8a;
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
public final class ScalarSynchronousObservable<T> extends k8a<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public final T b;

    /* loaded from: classes9.dex */
    public class b implements c9a<x8a, r8a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n8a a;

        /* loaded from: classes9.dex */
        public class a implements x8a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ x8a a;
            public final /* synthetic */ n8a.a b;

            public a(b bVar, x8a x8aVar, n8a.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, x8aVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = x8aVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.x8a
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

        public b(ScalarSynchronousObservable scalarSynchronousObservable, n8a n8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, n8aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n8aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c9a
        public r8a call(x8a x8aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, x8aVar)) == null) {
                n8a.a createWorker = this.a.createWorker();
                createWorker.b(new a(this, x8aVar, createWorker));
                return createWorker;
            }
            return (r8a) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements m8a, x8a {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2466317989629281651L;
        public transient /* synthetic */ FieldHolder $fh;
        public final q8a<? super T> actual;
        public final c9a<x8a, r8a> onSchedule;
        public final T value;

        public ScalarAsyncProducer(q8a<? super T> q8aVar, T t, c9a<x8a, r8a> c9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q8aVar, t, c9aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = q8aVar;
            this.value = t;
            this.onSchedule = c9aVar;
        }

        @Override // com.baidu.tieba.x8a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q8a<? super T> q8aVar = this.actual;
                if (q8aVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    q8aVar.onNext(obj);
                    if (q8aVar.isUnsubscribed()) {
                        return;
                    }
                    q8aVar.onCompleted();
                } catch (Throwable th) {
                    w8a.g(th, q8aVar, obj);
                }
            }
        }

        @Override // com.baidu.tieba.m8a
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
    public class a implements c9a<x8a, r8a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ faa a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, faa faaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, faaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c9a
        public r8a call(x8a x8aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, x8aVar)) == null) {
                return this.a.a(x8aVar);
            }
            return (r8a) invokeL.objValue;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes9.dex */
    public class c<R> implements k8a.a<R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c9a a;
        public final /* synthetic */ ScalarSynchronousObservable b;

        public c(ScalarSynchronousObservable scalarSynchronousObservable, c9a c9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, c9aVar};
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
            this.a = c9aVar;
        }

        public void call(q8a<? super R> q8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q8aVar) == null) {
                k8a k8aVar = (k8a) this.a.call(this.b.b);
                if (k8aVar instanceof ScalarSynchronousObservable) {
                    q8aVar.f(ScalarSynchronousObservable.D(q8aVar, ((ScalarSynchronousObservable) k8aVar).b));
                } else {
                    k8aVar.B(oca.c(q8aVar));
                }
            }
        }

        @Override // com.baidu.tieba.k8a.a, com.baidu.tieba.y8a
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((q8a) ((q8a) obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class d<T> implements k8a.a<T> {
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

        public void call(q8a<? super T> q8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q8aVar) == null) {
                q8aVar.f(ScalarSynchronousObservable.D(q8aVar, this.a));
            }
        }

        @Override // com.baidu.tieba.k8a.a, com.baidu.tieba.y8a
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((q8a) ((q8a) obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class e<T> implements k8a.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final T a;
        public final c9a<x8a, r8a> b;

        public e(T t, c9a<x8a, r8a> c9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t, c9aVar};
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
            this.b = c9aVar;
        }

        public void call(q8a<? super T> q8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q8aVar) == null) {
                q8aVar.f(new ScalarAsyncProducer(q8aVar, this.a, this.b));
            }
        }

        @Override // com.baidu.tieba.k8a.a, com.baidu.tieba.y8a
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((q8a) ((q8a) obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class f<T> implements m8a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final q8a<? super T> a;
        public final T b;
        public boolean c;

        public f(q8a<? super T> q8aVar, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q8aVar, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q8aVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.m8a
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
                q8a<? super T> q8aVar = this.a;
                if (q8aVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    q8aVar.onNext(obj);
                    if (q8aVar.isUnsubscribed()) {
                        return;
                    }
                    q8aVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    w8a.g(th, q8aVar, obj);
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
        super(rca.h(new d(t)));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k8a.a) newInitContext.callArgs[0]);
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

    public <R> k8a<R> F(c9a<? super T, ? extends k8a<? extends R>> c9aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c9aVar)) == null) {
            return k8a.a(new c(this, c9aVar));
        }
        return (k8a) invokeL.objValue;
    }

    public k8a<T> G(n8a n8aVar) {
        InterceptResult invokeL;
        c9a bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, n8aVar)) == null) {
            if (n8aVar instanceof faa) {
                bVar = new a(this, (faa) n8aVar);
            } else {
                bVar = new b(this, n8aVar);
            }
            return k8a.a(new e(this.b, bVar));
        }
        return (k8a) invokeL.objValue;
    }

    public static <T> m8a D(q8a<? super T> q8aVar, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, q8aVar, t)) == null) {
            if (c) {
                return new SingleProducer(q8aVar, t);
            }
            return new f(q8aVar, t);
        }
        return (m8a) invokeLL.objValue;
    }
}
