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
import com.repackage.a2a;
import com.repackage.cy9;
import com.repackage.d2a;
import com.repackage.dy9;
import com.repackage.iy9;
import com.repackage.jy9;
import com.repackage.oy9;
import com.repackage.rz9;
import com.repackage.wx9;
import com.repackage.yx9;
import com.repackage.zx9;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes8.dex */
public final class ScalarSynchronousObservable<T> extends wx9<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public final T b;

    /* loaded from: classes8.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements yx9, jy9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2466317989629281651L;
        public transient /* synthetic */ FieldHolder $fh;
        public final cy9<? super T> actual;
        public final oy9<jy9, dy9> onSchedule;
        public final T value;

        public ScalarAsyncProducer(cy9<? super T> cy9Var, T t, oy9<jy9, dy9> oy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cy9Var, t, oy9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = cy9Var;
            this.value = t;
            this.onSchedule = oy9Var;
        }

        @Override // com.repackage.jy9
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                cy9<? super T> cy9Var = this.actual;
                if (cy9Var.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    cy9Var.onNext(obj);
                    if (cy9Var.isUnsubscribed()) {
                        return;
                    }
                    cy9Var.onCompleted();
                } catch (Throwable th) {
                    iy9.g(th, cy9Var, obj);
                }
            }
        }

        @Override // com.repackage.yx9
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
    public class a implements oy9<jy9, dy9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz9 a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, rz9 rz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, rz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rz9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.oy9
        public dy9 call(jy9 jy9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jy9Var)) == null) ? this.a.a(jy9Var) : (dy9) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements oy9<jy9, dy9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zx9 a;

        /* loaded from: classes8.dex */
        public class a implements jy9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ jy9 a;
            public final /* synthetic */ zx9.a b;

            public a(b bVar, jy9 jy9Var, zx9.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, jy9Var, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jy9Var;
                this.b = aVar;
            }

            @Override // com.repackage.jy9
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

        public b(ScalarSynchronousObservable scalarSynchronousObservable, zx9 zx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, zx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zx9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.oy9
        public dy9 call(jy9 jy9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jy9Var)) == null) {
                zx9.a createWorker = this.a.createWorker();
                createWorker.b(new a(this, jy9Var, createWorker));
                return createWorker;
            }
            return (dy9) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements wx9.a<R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy9 a;
        public final /* synthetic */ ScalarSynchronousObservable b;

        public c(ScalarSynchronousObservable scalarSynchronousObservable, oy9 oy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scalarSynchronousObservable, oy9Var};
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
            this.a = oy9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.wx9.a, com.repackage.ky9
        public void call(cy9<? super R> cy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cy9Var) == null) {
                wx9 wx9Var = (wx9) this.a.call(this.b.b);
                if (wx9Var instanceof ScalarSynchronousObservable) {
                    cy9Var.f(ScalarSynchronousObservable.D(cy9Var, ((ScalarSynchronousObservable) wx9Var).b));
                } else {
                    wx9Var.B(a2a.c(cy9Var));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d<T> implements wx9.a<T> {
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

        @Override // com.repackage.wx9.a, com.repackage.ky9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((cy9) ((cy9) obj));
        }

        public void call(cy9<? super T> cy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cy9Var) == null) {
                cy9Var.f(ScalarSynchronousObservable.D(cy9Var, this.a));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class e<T> implements wx9.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final T a;
        public final oy9<jy9, dy9> b;

        public e(T t, oy9<jy9, dy9> oy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t, oy9Var};
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
            this.b = oy9Var;
        }

        @Override // com.repackage.wx9.a, com.repackage.ky9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((cy9) ((cy9) obj));
        }

        public void call(cy9<? super T> cy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cy9Var) == null) {
                cy9Var.f(new ScalarAsyncProducer(cy9Var, this.a, this.b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class f<T> implements yx9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final cy9<? super T> a;
        public final T b;
        public boolean c;

        public f(cy9<? super T> cy9Var, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cy9Var, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cy9Var;
            this.b = t;
        }

        @Override // com.repackage.yx9
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
                cy9<? super T> cy9Var = this.a;
                if (cy9Var.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    cy9Var.onNext(obj);
                    if (cy9Var.isUnsubscribed()) {
                        return;
                    }
                    cy9Var.onCompleted();
                } catch (Throwable th) {
                    iy9.g(th, cy9Var, obj);
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
        super(d2a.h(new d(t)));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wx9.a) newInitContext.callArgs[0]);
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

    public static <T> yx9 D(cy9<? super T> cy9Var, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cy9Var, t)) == null) {
            if (c) {
                return new SingleProducer(cy9Var, t);
            }
            return new f(cy9Var, t);
        }
        return (yx9) invokeLL.objValue;
    }

    public T E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (T) invokeV.objValue;
    }

    public <R> wx9<R> F(oy9<? super T, ? extends wx9<? extends R>> oy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oy9Var)) == null) ? wx9.a(new c(this, oy9Var)) : (wx9) invokeL.objValue;
    }

    public wx9<T> G(zx9 zx9Var) {
        InterceptResult invokeL;
        oy9 bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zx9Var)) == null) {
            if (zx9Var instanceof rz9) {
                bVar = new a(this, (rz9) zx9Var);
            } else {
                bVar = new b(this, zx9Var);
            }
            return wx9.a(new e(this.b, bVar));
        }
        return (wx9) invokeL.objValue;
    }
}
