package rx.subjects;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dv9;
import com.repackage.ev9;
import com.repackage.jv9;
import com.repackage.kv9;
import com.repackage.nx9;
import com.repackage.ny9;
import com.repackage.ox9;
import com.repackage.oy9;
import com.repackage.pz9;
import com.repackage.sv9;
import com.repackage.uy9;
import com.repackage.xu9;
import com.repackage.yu9;
import com.repackage.zu9;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes8.dex */
public final class UnicastSubject<T> extends pz9<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final State<T> b;

    /* loaded from: classes8.dex */
    public static final class State<T> extends AtomicLong implements zu9, yu9<T>, xu9.a<T>, ev9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -9044104859202255786L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean caughtUp;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public final Queue<Object> queue;
        public final AtomicReference<dv9<? super T>> subscriber;
        public final AtomicReference<kv9> terminateOnce;

        public State(int i, kv9 kv9Var) {
            Queue<Object> ny9Var;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), kv9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.subscriber = new AtomicReference<>();
            this.terminateOnce = kv9Var != null ? new AtomicReference<>(kv9Var) : null;
            if (i > 1) {
                ny9Var = uy9.b() ? new oy9<>(i) : new ox9<>(i);
            } else {
                ny9Var = uy9.b() ? new ny9<>() : new nx9<>();
            }
            this.queue = ny9Var;
        }

        @Override // com.repackage.xu9.a, com.repackage.lv9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((dv9) ((dv9) obj));
        }

        public boolean checkTerminated(boolean z, boolean z2, dv9<? super T> dv9Var) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), dv9Var})) == null) {
                if (dv9Var.isUnsubscribed()) {
                    this.queue.clear();
                    return true;
                } else if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.queue.clear();
                        dv9Var.onError(th);
                        return true;
                    } else if (z2) {
                        dv9Var.onCompleted();
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return invokeCommon.booleanValue;
        }

        public void doTerminate() {
            AtomicReference<kv9> atomicReference;
            kv9 kv9Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (atomicReference = this.terminateOnce) == null || (kv9Var = atomicReference.get()) == null || !atomicReference.compareAndSet(kv9Var, null)) {
                return;
            }
            kv9Var.call();
        }

        @Override // com.repackage.ev9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.done : invokeV.booleanValue;
        }

        @Override // com.repackage.yu9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.done) {
                return;
            }
            doTerminate();
            boolean z = true;
            this.done = true;
            if (!this.caughtUp) {
                synchronized (this) {
                    if (this.caughtUp) {
                        z = false;
                    }
                }
                if (z) {
                    replay();
                    return;
                }
            }
            this.subscriber.get().onCompleted();
        }

        @Override // com.repackage.yu9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, th) == null) || this.done) {
                return;
            }
            doTerminate();
            this.error = th;
            boolean z = true;
            this.done = true;
            if (!this.caughtUp) {
                synchronized (this) {
                    if (this.caughtUp) {
                        z = false;
                    }
                }
                if (z) {
                    replay();
                    return;
                }
            }
            this.subscriber.get().onError(th);
        }

        @Override // com.repackage.yu9
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, t) == null) || this.done) {
                return;
            }
            if (!this.caughtUp) {
                boolean z = false;
                synchronized (this) {
                    if (!this.caughtUp) {
                        this.queue.offer(NotificationLite.h(t));
                        z = true;
                    }
                }
                if (z) {
                    replay();
                    return;
                }
            }
            dv9<? super T> dv9Var = this.subscriber.get();
            try {
                dv9Var.onNext(t);
            } catch (Throwable th) {
                jv9.g(th, dv9Var, t);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x0083, code lost:
            if (r6 == false) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0089, code lost:
            if (r0.isEmpty() == false) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x008b, code lost:
            r14.caughtUp = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008d, code lost:
            r14.emitting = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0090, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void replay() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) {
                return;
            }
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                Queue<Object> queue = this.queue;
                while (true) {
                    dv9<? super T> dv9Var = this.subscriber.get();
                    if (dv9Var == null) {
                        z = false;
                    } else if (checkTerminated(this.done, queue.isEmpty(), dv9Var)) {
                        return;
                    } else {
                        long j = get();
                        z = j == Long.MAX_VALUE;
                        long j2 = 0;
                        while (j != 0) {
                            boolean z2 = this.done;
                            Object poll = queue.poll();
                            boolean z3 = poll == null;
                            if (checkTerminated(z2, z3, dv9Var)) {
                                return;
                            }
                            if (z3) {
                                break;
                            }
                            Object obj = (Object) NotificationLite.e(poll);
                            try {
                                dv9Var.onNext(obj);
                                j--;
                                j2++;
                            } catch (Throwable th) {
                                queue.clear();
                                jv9.e(th);
                                dv9Var.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
                                return;
                            }
                        }
                        if (!z && j2 != 0) {
                            addAndGet(-j2);
                        }
                    }
                    synchronized (this) {
                        if (!this.missed) {
                            break;
                        }
                        this.missed = false;
                    }
                }
            }
        }

        @Override // com.repackage.zu9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i < 0) {
                    throw new IllegalArgumentException("n >= 0 required");
                }
                if (i > 0) {
                    sv9.b(this, j);
                    replay();
                } else if (this.done) {
                    replay();
                }
            }
        }

        @Override // com.repackage.ev9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                doTerminate();
                this.done = true;
                synchronized (this) {
                    if (this.emitting) {
                        return;
                    }
                    this.emitting = true;
                    this.queue.clear();
                }
            }
        }

        public void call(dv9<? super T> dv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dv9Var) == null) {
                if (this.subscriber.compareAndSet(null, dv9Var)) {
                    dv9Var.b(this);
                    dv9Var.f(this);
                    return;
                }
                dv9Var.onError(new IllegalStateException("Only a single subscriber is allowed"));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnicastSubject(State<T> state) {
        super(state);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {state};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((xu9.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = state;
    }

    public static <T> UnicastSubject<T> D(int i, kv9 kv9Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, kv9Var)) == null) ? new UnicastSubject<>(new State(i, kv9Var)) : (UnicastSubject) invokeIL.objValue;
    }

    @Override // com.repackage.yu9
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.onCompleted();
        }
    }

    @Override // com.repackage.yu9
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            this.b.onError(th);
        }
    }

    @Override // com.repackage.yu9
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
            this.b.onNext(t);
        }
    }
}
