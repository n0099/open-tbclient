package rx.subjects;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c3a;
import com.baidu.tieba.d3a;
import com.baidu.tieba.e3a;
import com.baidu.tieba.i3a;
import com.baidu.tieba.j3a;
import com.baidu.tieba.o3a;
import com.baidu.tieba.p3a;
import com.baidu.tieba.s5a;
import com.baidu.tieba.s6a;
import com.baidu.tieba.t5a;
import com.baidu.tieba.t6a;
import com.baidu.tieba.u7a;
import com.baidu.tieba.x3a;
import com.baidu.tieba.z6a;
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
public final class UnicastSubject<T> extends u7a<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final State<T> b;

    /* loaded from: classes9.dex */
    public static final class State<T> extends AtomicLong implements e3a, d3a<T>, c3a.a<T>, j3a {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -9044104859202255786L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean caughtUp;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public final Queue<Object> queue;
        public final AtomicReference<i3a<? super T>> subscriber;
        public final AtomicReference<p3a> terminateOnce;

        public State(int i, p3a p3aVar) {
            AtomicReference<p3a> atomicReference;
            Queue<Object> s5aVar;
            Queue<Object> queue;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), p3aVar};
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
            if (p3aVar != null) {
                atomicReference = new AtomicReference<>(p3aVar);
            } else {
                atomicReference = null;
            }
            this.terminateOnce = atomicReference;
            if (i > 1) {
                if (z6a.b()) {
                    queue = new t6a<>(i);
                } else {
                    queue = new t5a<>(i);
                }
            } else {
                if (z6a.b()) {
                    s5aVar = new s6a<>();
                } else {
                    s5aVar = new s5a<>();
                }
                queue = s5aVar;
            }
            this.queue = queue;
        }

        public void call(i3a<? super T> i3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, i3aVar) == null) {
                if (this.subscriber.compareAndSet(null, i3aVar)) {
                    i3aVar.b(this);
                    i3aVar.f(this);
                    return;
                }
                i3aVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
            }
        }

        @Override // com.baidu.tieba.e3a
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i >= 0) {
                    if (i > 0) {
                        x3a.b(this, j);
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

        @Override // com.baidu.tieba.c3a.a, com.baidu.tieba.q3a
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((i3a) ((i3a) obj));
        }

        public boolean checkTerminated(boolean z, boolean z2, i3a<? super T> i3aVar) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), i3aVar})) == null) {
                if (i3aVar.isUnsubscribed()) {
                    this.queue.clear();
                    return true;
                } else if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.queue.clear();
                        i3aVar.onError(th);
                        return true;
                    } else if (z2) {
                        i3aVar.onCompleted();
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
            AtomicReference<p3a> atomicReference;
            p3a p3aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (atomicReference = this.terminateOnce) != null && (p3aVar = atomicReference.get()) != null && atomicReference.compareAndSet(p3aVar, null)) {
                p3aVar.call();
            }
        }

        @Override // com.baidu.tieba.j3a
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.done;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.j3a
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

        @Override // com.baidu.tieba.d3a
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

        @Override // com.baidu.tieba.d3a
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

        @Override // com.baidu.tieba.d3a
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
                i3a<? super T> i3aVar = this.subscriber.get();
                try {
                    i3aVar.onNext(t);
                } catch (Throwable th) {
                    o3a.g(th, i3aVar, t);
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
                        i3a<? super T> i3aVar = this.subscriber.get();
                        if (i3aVar != null) {
                            if (checkTerminated(this.done, queue.isEmpty(), i3aVar)) {
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
                                if (checkTerminated(z3, z2, i3aVar)) {
                                    return;
                                }
                                if (z2) {
                                    break;
                                }
                                Object obj = (Object) NotificationLite.e(poll);
                                try {
                                    i3aVar.onNext(obj);
                                    j--;
                                    j2++;
                                } catch (Throwable th) {
                                    queue.clear();
                                    o3a.e(th);
                                    i3aVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
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
                super((c3a.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = state;
    }

    public static <T> UnicastSubject<T> D(int i, p3a p3aVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, p3aVar)) == null) {
            return new UnicastSubject<>(new State(i, p3aVar));
        }
        return (UnicastSubject) invokeIL.objValue;
    }

    @Override // com.baidu.tieba.d3a
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.onCompleted();
        }
    }

    @Override // com.baidu.tieba.d3a
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            this.b.onError(th);
        }
    }

    @Override // com.baidu.tieba.d3a
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
            this.b.onNext(t);
        }
    }
}
