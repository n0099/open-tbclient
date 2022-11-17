package rx.subjects;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e0a;
import com.baidu.tieba.f0a;
import com.baidu.tieba.i2a;
import com.baidu.tieba.i3a;
import com.baidu.tieba.j2a;
import com.baidu.tieba.j3a;
import com.baidu.tieba.k4a;
import com.baidu.tieba.n0a;
import com.baidu.tieba.p3a;
import com.baidu.tieba.sz9;
import com.baidu.tieba.tz9;
import com.baidu.tieba.uz9;
import com.baidu.tieba.yz9;
import com.baidu.tieba.zz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes9.dex */
public final class UnicastSubject<T> extends k4a<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final State<T> b;

    /* loaded from: classes9.dex */
    public static final class State<T> extends AtomicLong implements uz9, tz9<T>, sz9.a<T>, zz9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -9044104859202255786L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean caughtUp;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public final Queue<Object> queue;
        public final AtomicReference<yz9<? super T>> subscriber;
        public final AtomicReference<f0a> terminateOnce;

        public State(int i, f0a f0aVar) {
            AtomicReference<f0a> atomicReference;
            Queue<Object> i2aVar;
            Queue<Object> queue;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), f0aVar};
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
            if (f0aVar != null) {
                atomicReference = new AtomicReference<>(f0aVar);
            } else {
                atomicReference = null;
            }
            this.terminateOnce = atomicReference;
            if (i > 1) {
                if (p3a.b()) {
                    queue = new j3a<>(i);
                } else {
                    queue = new j2a<>(i);
                }
            } else {
                if (p3a.b()) {
                    i2aVar = new i3a<>();
                } else {
                    i2aVar = new i2a<>();
                }
                queue = i2aVar;
            }
            this.queue = queue;
        }

        public void call(yz9<? super T> yz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, yz9Var) == null) {
                if (this.subscriber.compareAndSet(null, yz9Var)) {
                    yz9Var.b(this);
                    yz9Var.f(this);
                    return;
                }
                yz9Var.onError(new IllegalStateException("Only a single subscriber is allowed"));
            }
        }

        @Override // com.baidu.tieba.uz9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i >= 0) {
                    if (i > 0) {
                        n0a.b(this, j);
                        replay();
                        return;
                    } else if (this.done) {
                        replay();
                        return;
                    } else {
                        return;
                    }
                }
                throw new IllegalArgumentException("n >= 0 required");
            }
        }

        @Override // com.baidu.tieba.sz9.a, com.baidu.tieba.g0a
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((yz9) ((yz9) obj));
        }

        public boolean checkTerminated(boolean z, boolean z2, yz9<? super T> yz9Var) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), yz9Var})) == null) {
                if (yz9Var.isUnsubscribed()) {
                    this.queue.clear();
                    return true;
                } else if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.queue.clear();
                        yz9Var.onError(th);
                        return true;
                    } else if (z2) {
                        yz9Var.onCompleted();
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
            AtomicReference<f0a> atomicReference;
            f0a f0aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (atomicReference = this.terminateOnce) != null && (f0aVar = atomicReference.get()) != null && atomicReference.compareAndSet(f0aVar, null)) {
                f0aVar.call();
            }
        }

        @Override // com.baidu.tieba.zz9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.done;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.zz9
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

        @Override // com.baidu.tieba.tz9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !this.done) {
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
        }

        @Override // com.baidu.tieba.tz9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, th) == null) && !this.done) {
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
        }

        @Override // com.baidu.tieba.tz9
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, t) == null) && !this.done) {
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
                yz9<? super T> yz9Var = this.subscriber.get();
                try {
                    yz9Var.onNext(t);
                } catch (Throwable th) {
                    e0a.g(th, yz9Var, t);
                }
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
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                synchronized (this) {
                    if (this.emitting) {
                        this.missed = true;
                        return;
                    }
                    this.emitting = true;
                    Queue<Object> queue = this.queue;
                    while (true) {
                        yz9<? super T> yz9Var = this.subscriber.get();
                        if (yz9Var != null) {
                            if (checkTerminated(this.done, queue.isEmpty(), yz9Var)) {
                                return;
                            }
                            long j = get();
                            if (j == Long.MAX_VALUE) {
                                z = true;
                            } else {
                                z = false;
                            }
                            long j2 = 0;
                            while (j != 0) {
                                boolean z3 = this.done;
                                Object poll = queue.poll();
                                if (poll == null) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (checkTerminated(z3, z2, yz9Var)) {
                                    return;
                                }
                                if (z2) {
                                    break;
                                }
                                Object obj = (Object) NotificationLite.e(poll);
                                try {
                                    yz9Var.onNext(obj);
                                    j--;
                                    j2++;
                                } catch (Throwable th) {
                                    queue.clear();
                                    e0a.e(th);
                                    yz9Var.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
                                    return;
                                }
                            }
                            if (!z && j2 != 0) {
                                addAndGet(-j2);
                            }
                        } else {
                            z = false;
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
                super((sz9.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = state;
    }

    public static <T> UnicastSubject<T> D(int i, f0a f0aVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, f0aVar)) == null) {
            return new UnicastSubject<>(new State(i, f0aVar));
        }
        return (UnicastSubject) invokeIL.objValue;
    }

    @Override // com.baidu.tieba.tz9
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.onCompleted();
        }
    }

    @Override // com.baidu.tieba.tz9
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            this.b.onError(th);
        }
    }

    @Override // com.baidu.tieba.tz9
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
            this.b.onNext(t);
        }
    }
}
