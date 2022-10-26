package io.reactivex.subjects;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class UnicastSubject extends Subject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference actual;
    public final boolean delayError;
    public volatile boolean disposed;
    public volatile boolean done;
    public boolean enableOperatorFusion;
    public Throwable error;
    public final AtomicReference onTerminate;
    public final AtomicBoolean once;
    public final SpscLinkedArrayQueue queue;
    public final BasicIntQueueDisposable wip;

    /* loaded from: classes8.dex */
    public final class UnicastQueueDisposable extends BasicIntQueueDisposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 7926949470189395511L;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnicastSubject this$0;

        public UnicastQueueDisposable(UnicastSubject unicastSubject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {unicastSubject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = unicastSubject;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                if ((i & 2) != 0) {
                    this.this$0.enableOperatorFusion = true;
                    return 2;
                }
                return 0;
            }
            return invokeI.intValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.this$0.disposed;
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.this$0.queue.isEmpty();
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.this$0.queue.poll();
            }
            return invokeV.objValue;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.this$0.disposed) {
                this.this$0.disposed = true;
                this.this$0.doTerminate();
                this.this$0.actual.lazySet(null);
                if (this.this$0.wip.getAndIncrement() == 0) {
                    this.this$0.actual.lazySet(null);
                    this.this$0.queue.clear();
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnicastSubject(int i, Runnable runnable) {
        this(i, runnable, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), runnable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (Runnable) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public UnicastSubject(int i, Runnable runnable, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), runnable, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.queue = new SpscLinkedArrayQueue(ObjectHelper.verifyPositive(i, "capacityHint"));
        this.onTerminate = new AtomicReference(ObjectHelper.requireNonNull(runnable, "onTerminate"));
        this.delayError = z;
        this.actual = new AtomicReference();
        this.once = new AtomicBoolean();
        this.wip = new UnicastQueueDisposable(this);
    }

    public UnicastSubject(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.queue = new SpscLinkedArrayQueue(ObjectHelper.verifyPositive(i, "capacityHint"));
        this.onTerminate = new AtomicReference();
        this.delayError = z;
        this.actual = new AtomicReference();
        this.once = new AtomicBoolean();
        this.wip = new UnicastQueueDisposable(this);
    }

    @CheckReturnValue
    public static UnicastSubject create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new UnicastSubject(Observable.bufferSize(), true);
        }
        return (UnicastSubject) invokeV.objValue;
    }

    public void doTerminate() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (runnable = (Runnable) this.onTerminate.get()) != null && this.onTerminate.compareAndSet(runnable, null)) {
            runnable.run();
        }
    }

    @Override // io.reactivex.subjects.Subject
    public Throwable getThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.done) {
                return this.error;
            }
            return null;
        }
        return (Throwable) invokeV.objValue;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.done && this.error == null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.actual.get() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.done && this.error != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && !this.done && !this.disposed) {
            this.done = true;
            doTerminate();
            drain();
        }
    }

    @CheckReturnValue
    public static UnicastSubject create(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            return new UnicastSubject(i, true);
        }
        return (UnicastSubject) invokeI.objValue;
    }

    public void errorOrComplete(Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, observer) == null) {
            this.actual.lazySet(null);
            Throwable th = this.error;
            if (th != null) {
                observer.onError(th);
            } else {
                observer.onComplete();
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, th) == null) {
            ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (!this.done && !this.disposed) {
                this.error = th;
                this.done = true;
                doTerminate();
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, obj) == null) {
            ObjectHelper.requireNonNull(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (!this.done && !this.disposed) {
                this.queue.offer(obj);
                drain();
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, disposable) == null) {
            if (this.done || this.disposed) {
                disposable.dispose();
            }
        }
    }

    @CheckReturnValue
    public static UnicastSubject create(int i, Runnable runnable) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65541, null, i, runnable)) == null) {
            return new UnicastSubject(i, runnable, true);
        }
        return (UnicastSubject) invokeIL.objValue;
    }

    public boolean failedFast(SimpleQueue simpleQueue, Observer observer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, simpleQueue, observer)) == null) {
            Throwable th = this.error;
            if (th != null) {
                this.actual.lazySet(null);
                simpleQueue.clear();
                observer.onError(th);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @CheckReturnValue
    public static UnicastSubject create(int i, Runnable runnable, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Integer.valueOf(i), runnable, Boolean.valueOf(z)})) == null) {
            return new UnicastSubject(i, runnable, z);
        }
        return (UnicastSubject) invokeCommon.objValue;
    }

    @CheckReturnValue
    public static UnicastSubject create(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65543, null, z)) == null) {
            return new UnicastSubject(Observable.bufferSize(), z);
        }
        return (UnicastSubject) invokeZ.objValue;
    }

    public void drain() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.wip.getAndIncrement() != 0) {
            return;
        }
        Observer observer = (Observer) this.actual.get();
        int i = 1;
        while (observer == null) {
            i = this.wip.addAndGet(-i);
            if (i == 0) {
                return;
            }
            observer = (Observer) this.actual.get();
        }
        if (this.enableOperatorFusion) {
            drainFused(observer);
        } else {
            drainNormal(observer);
        }
    }

    public void drainFused(Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, observer) == null) {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.queue;
            int i = 1;
            boolean z = !this.delayError;
            while (!this.disposed) {
                boolean z2 = this.done;
                if (z && z2 && failedFast(spscLinkedArrayQueue, observer)) {
                    return;
                }
                observer.onNext(null);
                if (z2) {
                    errorOrComplete(observer);
                    return;
                }
                i = this.wip.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
            this.actual.lazySet(null);
            spscLinkedArrayQueue.clear();
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, observer) == null) {
            if (!this.once.get() && this.once.compareAndSet(false, true)) {
                observer.onSubscribe(this.wip);
                this.actual.lazySet(observer);
                if (this.disposed) {
                    this.actual.lazySet(null);
                    return;
                } else {
                    drain();
                    return;
                }
            }
            EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), observer);
        }
    }

    public void drainNormal(Observer observer) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, observer) == null) {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.queue;
            boolean z2 = !this.delayError;
            boolean z3 = true;
            int i = 1;
            while (!this.disposed) {
                boolean z4 = this.done;
                Object poll = this.queue.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z4) {
                    if (z2 && z3) {
                        if (failedFast(spscLinkedArrayQueue, observer)) {
                            return;
                        }
                        z3 = false;
                    }
                    if (z) {
                        errorOrComplete(observer);
                        return;
                    }
                }
                if (z) {
                    i = this.wip.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    observer.onNext(poll);
                }
            }
            this.actual.lazySet(null);
            spscLinkedArrayQueue.clear();
        }
    }
}
