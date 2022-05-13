package rx.subjects;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cy9;
import com.repackage.dy9;
import com.repackage.iy9;
import com.repackage.jy9;
import com.repackage.m0a;
import com.repackage.m1a;
import com.repackage.n0a;
import com.repackage.n1a;
import com.repackage.o2a;
import com.repackage.ry9;
import com.repackage.t1a;
import com.repackage.wx9;
import com.repackage.xx9;
import com.repackage.yx9;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes8.dex */
public final class UnicastSubject<T> extends o2a<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final State<T> b;

    /* loaded from: classes8.dex */
    public static final class State<T> extends AtomicLong implements yx9, xx9<T>, wx9.a<T>, dy9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -9044104859202255786L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean caughtUp;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public final Queue<Object> queue;
        public final AtomicReference<cy9<? super T>> subscriber;
        public final AtomicReference<jy9> terminateOnce;

        public State(int i, jy9 jy9Var) {
            Queue<Object> m1aVar;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), jy9Var};
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
            this.terminateOnce = jy9Var != null ? new AtomicReference<>(jy9Var) : null;
            if (i > 1) {
                m1aVar = t1a.b() ? new n1a<>(i) : new n0a<>(i);
            } else {
                m1aVar = t1a.b() ? new m1a<>() : new m0a<>();
            }
            this.queue = m1aVar;
        }

        @Override // com.repackage.wx9.a, com.repackage.ky9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((cy9) ((cy9) obj));
        }

        public boolean checkTerminated(boolean z, boolean z2, cy9<? super T> cy9Var) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), cy9Var})) == null) {
                if (cy9Var.isUnsubscribed()) {
                    this.queue.clear();
                    return true;
                } else if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.queue.clear();
                        cy9Var.onError(th);
                        return true;
                    } else if (z2) {
                        cy9Var.onCompleted();
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
            AtomicReference<jy9> atomicReference;
            jy9 jy9Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (atomicReference = this.terminateOnce) == null || (jy9Var = atomicReference.get()) == null || !atomicReference.compareAndSet(jy9Var, null)) {
                return;
            }
            jy9Var.call();
        }

        @Override // com.repackage.dy9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.done : invokeV.booleanValue;
        }

        @Override // com.repackage.xx9
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

        @Override // com.repackage.xx9
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

        @Override // com.repackage.xx9
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
            cy9<? super T> cy9Var = this.subscriber.get();
            try {
                cy9Var.onNext(t);
            } catch (Throwable th) {
                iy9.g(th, cy9Var, t);
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
                    cy9<? super T> cy9Var = this.subscriber.get();
                    if (cy9Var == null) {
                        z = false;
                    } else if (checkTerminated(this.done, queue.isEmpty(), cy9Var)) {
                        return;
                    } else {
                        long j = get();
                        z = j == Long.MAX_VALUE;
                        long j2 = 0;
                        while (j != 0) {
                            boolean z2 = this.done;
                            Object poll = queue.poll();
                            boolean z3 = poll == null;
                            if (checkTerminated(z2, z3, cy9Var)) {
                                return;
                            }
                            if (z3) {
                                break;
                            }
                            Object obj = (Object) NotificationLite.e(poll);
                            try {
                                cy9Var.onNext(obj);
                                j--;
                                j2++;
                            } catch (Throwable th) {
                                queue.clear();
                                iy9.e(th);
                                cy9Var.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
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

        @Override // com.repackage.yx9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i < 0) {
                    throw new IllegalArgumentException("n >= 0 required");
                }
                if (i > 0) {
                    ry9.b(this, j);
                    replay();
                } else if (this.done) {
                    replay();
                }
            }
        }

        @Override // com.repackage.dy9
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

        public void call(cy9<? super T> cy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cy9Var) == null) {
                if (this.subscriber.compareAndSet(null, cy9Var)) {
                    cy9Var.b(this);
                    cy9Var.f(this);
                    return;
                }
                cy9Var.onError(new IllegalStateException("Only a single subscriber is allowed"));
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
                super((wx9.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = state;
    }

    public static <T> UnicastSubject<T> D(int i, jy9 jy9Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, jy9Var)) == null) ? new UnicastSubject<>(new State(i, jy9Var)) : (UnicastSubject) invokeIL.objValue;
    }

    @Override // com.repackage.xx9
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.onCompleted();
        }
    }

    @Override // com.repackage.xx9
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            this.b.onError(th);
        }
    }

    @Override // com.repackage.xx9
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
            this.b.onNext(t);
        }
    }
}
