package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.e;
import i.f;
import i.j;
import i.k;
import i.o.a.o;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class OperatorOnBackpressureLatest$LatestEmitter<T> extends AtomicLong implements f, k, e<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Object EMPTY;
    public static final long NOT_REQUESTED = -4611686018427387904L;
    public static final long serialVersionUID = -1364393685005146274L;
    public transient /* synthetic */ FieldHolder $fh;
    public final j<? super T> child;
    public volatile boolean done;
    public boolean emitting;
    public boolean missed;
    public o<? super T> parent;
    public Throwable terminal;
    public final AtomicReference<Object> value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(391241293, "Lrx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(391241293, "Lrx/internal/operators/OperatorOnBackpressureLatest$LatestEmitter;");
                return;
            }
        }
        EMPTY = new Object();
    }

    public OperatorOnBackpressureLatest$LatestEmitter(j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.child = jVar;
        this.value = new AtomicReference<>(EMPTY);
        lazySet(-4611686018427387904L);
    }

    public void emit() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        synchronized (this) {
            boolean z2 = true;
            if (this.emitting) {
                this.missed = true;
                return;
            }
            this.emitting = true;
            this.missed = false;
            while (true) {
                try {
                    long j2 = get();
                    if (j2 == Long.MIN_VALUE) {
                        return;
                    }
                    Object obj = this.value.get();
                    if (j2 > 0 && obj != EMPTY) {
                        this.child.onNext(obj);
                        this.value.compareAndSet(obj, EMPTY);
                        produced(1L);
                        obj = EMPTY;
                    }
                    if (obj == EMPTY && this.done) {
                        Throwable th = this.terminal;
                        if (th != null) {
                            this.child.onError(th);
                        } else {
                            this.child.onCompleted();
                        }
                    }
                    try {
                        synchronized (this) {
                            try {
                                if (!this.missed) {
                                    this.emitting = false;
                                    return;
                                }
                                this.missed = false;
                            } catch (Throwable th2) {
                                th = th2;
                                z2 = false;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        z = z2;
                        th = th4;
                        if (!z) {
                            synchronized (this) {
                                this.emitting = false;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    z = false;
                }
            }
        }
    }

    @Override // i.k
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() == Long.MIN_VALUE : invokeV.booleanValue;
    }

    @Override // i.e
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.done = true;
            emit();
        }
    }

    @Override // i.e
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
            this.terminal = th;
            this.done = true;
            emit();
        }
    }

    @Override // i.e
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
            this.value.lazySet(t);
            emit();
        }
    }

    public long produced(long j2) {
        long j3;
        long j4;
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            do {
                j3 = get();
                if (j3 < 0) {
                    return j3;
                }
                j4 = j3 - j2;
            } while (!compareAndSet(j3, j4));
            return j4;
        }
        return invokeJ.longValue;
    }

    @Override // i.f
    public void request(long j2) {
        long j3;
        int i2;
        long j4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) || j2 < 0) {
            return;
        }
        do {
            j3 = get();
            if (j3 == Long.MIN_VALUE) {
                return;
            }
            i2 = (j3 > (-4611686018427387904L) ? 1 : (j3 == (-4611686018427387904L) ? 0 : -1));
            if (i2 == 0) {
                j4 = j2;
            } else {
                j4 = j3 + j2;
                if (j4 < 0) {
                    j4 = Long.MAX_VALUE;
                }
            }
        } while (!compareAndSet(j3, j4));
        if (i2 == 0) {
            this.parent.g(Long.MAX_VALUE);
        }
        emit();
    }

    @Override // i.k
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || get() < 0) {
            return;
        }
        getAndSet(Long.MIN_VALUE);
    }
}
