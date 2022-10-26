package rx.subjects;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dy9;
import com.baidu.tieba.ey9;
import com.baidu.tieba.jy9;
import com.baidu.tieba.ky9;
import com.baidu.tieba.n0a;
import com.baidu.tieba.n1a;
import com.baidu.tieba.o0a;
import com.baidu.tieba.o1a;
import com.baidu.tieba.p2a;
import com.baidu.tieba.sy9;
import com.baidu.tieba.u1a;
import com.baidu.tieba.xx9;
import com.baidu.tieba.yx9;
import com.baidu.tieba.zx9;
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
public final class UnicastSubject extends p2a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final State b;

    /* loaded from: classes9.dex */
    public final class State extends AtomicLong implements zx9, yx9, xx9.a, ey9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -9044104859202255786L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean caughtUp;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public final Queue queue;
        public final AtomicReference subscriber;
        public final AtomicReference terminateOnce;

        public State(int i, ky9 ky9Var) {
            AtomicReference atomicReference;
            Queue n0aVar;
            Queue queue;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), ky9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.subscriber = new AtomicReference();
            if (ky9Var != null) {
                atomicReference = new AtomicReference(ky9Var);
            } else {
                atomicReference = null;
            }
            this.terminateOnce = atomicReference;
            if (i > 1) {
                if (u1a.b()) {
                    queue = new o1a(i);
                } else {
                    queue = new o0a(i);
                }
            } else {
                if (u1a.b()) {
                    n0aVar = new n1a();
                } else {
                    n0aVar = new n0a();
                }
                queue = n0aVar;
            }
            this.queue = queue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xx9.a, com.baidu.tieba.ly9
        public void call(dy9 dy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dy9Var) == null) {
                if (this.subscriber.compareAndSet(null, dy9Var)) {
                    dy9Var.b(this);
                    dy9Var.f(this);
                    return;
                }
                dy9Var.onError(new IllegalStateException("Only a single subscriber is allowed"));
            }
        }

        @Override // com.baidu.tieba.zx9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i >= 0) {
                    if (i > 0) {
                        sy9.b(this, j);
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

        public boolean checkTerminated(boolean z, boolean z2, dy9 dy9Var) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), dy9Var})) == null) {
                if (dy9Var.isUnsubscribed()) {
                    this.queue.clear();
                    return true;
                } else if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.queue.clear();
                        dy9Var.onError(th);
                        return true;
                    } else if (z2) {
                        dy9Var.onCompleted();
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
            AtomicReference atomicReference;
            ky9 ky9Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (atomicReference = this.terminateOnce) != null && (ky9Var = (ky9) atomicReference.get()) != null && atomicReference.compareAndSet(ky9Var, null)) {
                ky9Var.call();
            }
        }

        @Override // com.baidu.tieba.ey9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.done;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.ey9
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

        @Override // com.baidu.tieba.yx9
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
                ((dy9) this.subscriber.get()).onCompleted();
            }
        }

        @Override // com.baidu.tieba.yx9
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
                ((dy9) this.subscriber.get()).onError(th);
            }
        }

        @Override // com.baidu.tieba.yx9
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, obj) == null) && !this.done) {
                if (!this.caughtUp) {
                    boolean z = false;
                    synchronized (this) {
                        if (!this.caughtUp) {
                            this.queue.offer(NotificationLite.h(obj));
                            z = true;
                        }
                    }
                    if (z) {
                        replay();
                        return;
                    }
                }
                dy9 dy9Var = (dy9) this.subscriber.get();
                try {
                    dy9Var.onNext(obj);
                } catch (Throwable th) {
                    jy9.g(th, dy9Var, obj);
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
                    Queue queue = this.queue;
                    while (true) {
                        dy9 dy9Var = (dy9) this.subscriber.get();
                        if (dy9Var != null) {
                            if (checkTerminated(this.done, queue.isEmpty(), dy9Var)) {
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
                                if (checkTerminated(z3, z2, dy9Var)) {
                                    return;
                                }
                                if (z2) {
                                    break;
                                }
                                Object e = NotificationLite.e(poll);
                                try {
                                    dy9Var.onNext(e);
                                    j--;
                                    j2++;
                                } catch (Throwable th) {
                                    queue.clear();
                                    jy9.e(th);
                                    dy9Var.onError(OnErrorThrowable.addValueAsLastCause(th, e));
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
    public UnicastSubject(State state) {
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
                super((xx9.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = state;
    }

    public static UnicastSubject D(int i, ky9 ky9Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, ky9Var)) == null) {
            return new UnicastSubject(new State(i, ky9Var));
        }
        return (UnicastSubject) invokeIL.objValue;
    }

    @Override // com.baidu.tieba.yx9
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.onCompleted();
        }
    }

    @Override // com.baidu.tieba.yx9
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            this.b.onError(th);
        }
    }

    @Override // com.baidu.tieba.yx9
    public void onNext(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            this.b.onNext(obj);
        }
    }
}
