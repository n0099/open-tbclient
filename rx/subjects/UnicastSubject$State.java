package rx.subjects;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import i.e;
import i.f;
import i.j;
import i.k;
import i.n.a;
import i.o.d.j.f0;
import i.o.d.j.y;
import i.o.d.j.z;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes2.dex */
public final class UnicastSubject$State<T> extends AtomicLong implements f, e<T>, d.a<T>, k {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -9044104859202255786L;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean caughtUp;
    public volatile boolean done;
    public boolean emitting;
    public Throwable error;
    public boolean missed;
    public final Queue<Object> queue;
    public final AtomicReference<j<? super T>> subscriber;
    public final AtomicReference<a> terminateOnce;

    public UnicastSubject$State(int i2, a aVar) {
        Queue<Object> yVar;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.subscriber = new AtomicReference<>();
        this.terminateOnce = aVar != null ? new AtomicReference<>(aVar) : null;
        if (i2 > 1) {
            yVar = f0.b() ? new z<>(i2) : new i.o.d.i.f<>(i2);
        } else {
            yVar = f0.b() ? new y<>() : new i.o.d.i.e<>();
        }
        this.queue = yVar;
    }

    @Override // i.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((j) ((j) obj));
    }

    public boolean checkTerminated(boolean z, boolean z2, j<? super T> jVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), jVar})) == null) {
            if (jVar.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    jVar.onError(th);
                    return true;
                } else if (z2) {
                    jVar.onCompleted();
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
        AtomicReference<a> atomicReference;
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (atomicReference = this.terminateOnce) == null || (aVar = atomicReference.get()) == null || !atomicReference.compareAndSet(aVar, null)) {
            return;
        }
        aVar.call();
    }

    @Override // i.k
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.done : invokeV.booleanValue;
    }

    @Override // i.e
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

    @Override // i.e
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

    @Override // i.e
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
        j<? super T> jVar = this.subscriber.get();
        try {
            jVar.onNext(t);
        } catch (Throwable th) {
            i.m.a.g(th, jVar, t);
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
                j<? super T> jVar = this.subscriber.get();
                if (jVar == null) {
                    z = false;
                } else if (checkTerminated(this.done, queue.isEmpty(), jVar)) {
                    return;
                } else {
                    long j2 = get();
                    z = j2 == Long.MAX_VALUE;
                    long j3 = 0;
                    while (j2 != 0) {
                        boolean z2 = this.done;
                        Object poll = queue.poll();
                        boolean z3 = poll == null;
                        if (checkTerminated(z2, z3, jVar)) {
                            return;
                        }
                        if (z3) {
                            break;
                        }
                        Object obj = (Object) NotificationLite.e(poll);
                        try {
                            jVar.onNext(obj);
                            j2--;
                            j3++;
                        } catch (Throwable th) {
                            queue.clear();
                            i.m.a.e(th);
                            jVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
                            return;
                        }
                    }
                    if (!z && j3 != 0) {
                        addAndGet(-j3);
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

    @Override // i.f
    public void request(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
            if (i2 > 0) {
                i.o.a.a.b(this, j2);
                replay();
            } else if (this.done) {
                replay();
            }
        }
    }

    @Override // i.k
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

    public void call(j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            if (this.subscriber.compareAndSet(null, jVar)) {
                jVar.add(this);
                jVar.setProducer(this);
                return;
            }
            jVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }
    }
}
