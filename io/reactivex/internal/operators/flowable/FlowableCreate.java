package io.reactivex.internal.operators.flowable;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes10.dex */
public final class FlowableCreate<T> extends Flowable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BackpressureStrategy backpressure;
    public final FlowableOnSubscribe<T> source;

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableCreate$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$io$reactivex$BackpressureStrategy;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-708539128, "Lio/reactivex/internal/operators/flowable/FlowableCreate$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-708539128, "Lio/reactivex/internal/operators/flowable/FlowableCreate$1;");
                    return;
                }
            }
            int[] iArr = new int[BackpressureStrategy.values().length];
            $SwitchMap$io$reactivex$BackpressureStrategy = iArr;
            try {
                iArr[BackpressureStrategy.MISSING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class BaseEmitter<T> extends AtomicLong implements FlowableEmitter<T>, Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 7326289992464377023L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super T> actual;
        public final SequentialDisposable serial;

        public BaseEmitter(Subscriber<? super T> subscriber) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
            this.serial = new SequentialDisposable();
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.serial.dispose();
                onUnsubscribed();
            }
        }

        public void complete() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || isCancelled()) {
                return;
            }
            try {
                this.actual.onComplete();
            } finally {
                this.serial.dispose();
            }
        }

        public boolean error(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th)) == null) {
                if (th == null) {
                    th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                }
                if (isCancelled()) {
                    return false;
                }
                try {
                    this.actual.onError(th);
                    this.serial.dispose();
                    return true;
                } catch (Throwable th2) {
                    this.serial.dispose();
                    throw th2;
                }
            }
            return invokeL.booleanValue;
        }

        @Override // io.reactivex.FlowableEmitter
        public final boolean isCancelled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.serial.isDisposed() : invokeV.booleanValue;
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                complete();
            }
        }

        @Override // io.reactivex.Emitter
        public final void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, th) == null) || tryOnError(th)) {
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onRequested() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            }
        }

        public void onUnsubscribed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) && SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this, j2);
                onRequested();
            }
        }

        @Override // io.reactivex.FlowableEmitter
        public final long requested() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? get() : invokeV.longValue;
        }

        @Override // io.reactivex.FlowableEmitter
        public final FlowableEmitter<T> serialize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new SerializedEmitter(this) : (FlowableEmitter) invokeV.objValue;
        }

        @Override // io.reactivex.FlowableEmitter
        public final void setCancellable(Cancellable cancellable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, cancellable) == null) {
                setDisposable(new CancellableDisposable(cancellable));
            }
        }

        @Override // io.reactivex.FlowableEmitter
        public final void setDisposable(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, disposable) == null) {
                this.serial.update(disposable);
            }
        }

        @Override // io.reactivex.FlowableEmitter
        public boolean tryOnError(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, th)) == null) ? error(th) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class BufferAsyncEmitter<T> extends BaseEmitter<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2427151001689639875L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean done;
        public Throwable error;
        public final SpscLinkedArrayQueue<T> queue;
        public final AtomicInteger wip;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BufferAsyncEmitter(Subscriber<? super T> subscriber, int i2) {
            super(subscriber);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((Subscriber) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.queue = new SpscLinkedArrayQueue<>(i2);
            this.wip = new AtomicInteger();
        }

        public void drain() {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.wip.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.actual;
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
                int i3 = 1;
                do {
                    long j2 = get();
                    long j3 = 0;
                    while (true) {
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (isCancelled()) {
                            spscLinkedArrayQueue.clear();
                            return;
                        } else {
                            boolean z = this.done;
                            Object obj = (T) spscLinkedArrayQueue.poll();
                            boolean z2 = obj == null;
                            if (z && z2) {
                                Throwable th = this.error;
                                if (th != null) {
                                    error(th);
                                    return;
                                } else {
                                    complete();
                                    return;
                                }
                            } else if (z2) {
                                break;
                            } else {
                                subscriber.onNext(obj);
                                j3++;
                            }
                        }
                    }
                    if (i2 == 0) {
                        if (isCancelled()) {
                            spscLinkedArrayQueue.clear();
                            return;
                        }
                        boolean z3 = this.done;
                        boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                        if (z3 && isEmpty) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                error(th2);
                                return;
                            } else {
                                complete();
                                return;
                            }
                        }
                    }
                    if (j3 != 0) {
                        BackpressureHelper.produced(this, j3);
                    }
                    i3 = this.wip.addAndGet(-i3);
                } while (i3 != 0);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.Emitter
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.done || isCancelled()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            this.queue.offer(t);
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        public void onRequested() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                drain();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        public void onUnsubscribed() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.FlowableEmitter
        public boolean tryOnError(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, th)) == null) {
                if (this.done || isCancelled()) {
                    return false;
                }
                if (th == null) {
                    th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                }
                this.error = th;
                this.done = true;
                drain();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 8360058422307496563L;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DropAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Subscriber) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        public void onOverflow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 338953216916120960L;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ErrorAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Subscriber) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        public void onOverflow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class LatestAsyncEmitter<T> extends BaseEmitter<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4023437720691792495L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean done;
        public Throwable error;
        public final AtomicReference<T> queue;
        public final AtomicInteger wip;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LatestAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Subscriber) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.queue = new AtomicReference<>();
            this.wip = new AtomicInteger();
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0053, code lost:
            if (r13 != 0) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0059, code lost:
            if (isCancelled() == false) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
            r2.lazySet(null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x005e, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x005f, code lost:
            r5 = r17.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0065, code lost:
            if (r2.get() != null) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0067, code lost:
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0068, code lost:
            if (r5 == false) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x006a, code lost:
            if (r11 == false) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x006c, code lost:
            r1 = r17.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x006e, code lost:
            if (r1 == null) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0070, code lost:
            error(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0074, code lost:
            complete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0077, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x007a, code lost:
            if (r9 == 0) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x007c, code lost:
            io.reactivex.internal.util.BackpressureHelper.produced(r17, r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x007f, code lost:
            r4 = r17.wip.addAndGet(-r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.wip.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.actual;
                AtomicReference<T> atomicReference = this.queue;
                int i2 = 1;
                do {
                    long j2 = get();
                    long j3 = 0;
                    while (true) {
                        boolean z = false;
                        int i3 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i3 == 0) {
                            break;
                        } else if (isCancelled()) {
                            atomicReference.lazySet(null);
                            return;
                        } else {
                            boolean z2 = this.done;
                            Object obj = (T) atomicReference.getAndSet(null);
                            boolean z3 = obj == null;
                            if (z2 && z3) {
                                Throwable th = this.error;
                                if (th != null) {
                                    error(th);
                                    return;
                                } else {
                                    complete();
                                    return;
                                }
                            } else if (z3) {
                                break;
                            } else {
                                subscriber.onNext(obj);
                                j3++;
                            }
                        }
                    }
                } while (i2 != 0);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.Emitter
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.done || isCancelled()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            this.queue.set(t);
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        public void onRequested() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                drain();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        public void onUnsubscribed() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.FlowableEmitter
        public boolean tryOnError(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, th)) == null) {
                if (this.done || isCancelled()) {
                    return false;
                }
                if (th == null) {
                    onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
                }
                this.error = th;
                this.done = true;
                drain();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class MissingEmitter<T> extends BaseEmitter<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3776720187248809713L;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Subscriber) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t) {
            long j2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, t) == null) || isCancelled()) {
                return;
            }
            if (t != null) {
                this.actual.onNext(t);
                do {
                    j2 = get();
                    if (j2 == 0) {
                        return;
                    }
                } while (!compareAndSet(j2, j2 - 1));
                return;
            }
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseEmitter<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4127754106204442833L;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoOverflowBaseAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Subscriber) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // io.reactivex.Emitter
        public final void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, t) == null) || isCancelled()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (get() != 0) {
                this.actual.onNext(t);
                BackpressureHelper.produced(this, 1L);
            } else {
                onOverflow();
            }
        }

        public abstract void onOverflow();
    }

    /* loaded from: classes10.dex */
    public static final class SerializedEmitter<T> extends AtomicInteger implements FlowableEmitter<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4883307006032401862L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean done;
        public final BaseEmitter<T> emitter;
        public final AtomicThrowable error;
        public final SimplePlainQueue<T> queue;

        public SerializedEmitter(BaseEmitter<T> baseEmitter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseEmitter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.emitter = baseEmitter;
            this.error = new AtomicThrowable();
            this.queue = new SpscLinkedArrayQueue(16);
        }

        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && getAndIncrement() == 0) {
                drainLoop();
            }
        }

        public void drainLoop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                BaseEmitter<T> baseEmitter = this.emitter;
                SimplePlainQueue<T> simplePlainQueue = this.queue;
                AtomicThrowable atomicThrowable = this.error;
                int i2 = 1;
                while (!baseEmitter.isCancelled()) {
                    if (atomicThrowable.get() != null) {
                        simplePlainQueue.clear();
                        baseEmitter.onError(atomicThrowable.terminate());
                        return;
                    }
                    boolean z = this.done;
                    T poll = simplePlainQueue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        baseEmitter.onComplete();
                        return;
                    } else if (z2) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        baseEmitter.onNext(poll);
                    }
                }
                simplePlainQueue.clear();
            }
        }

        @Override // io.reactivex.FlowableEmitter
        public boolean isCancelled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.emitter.isCancelled() : invokeV.booleanValue;
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.emitter.isCancelled() || this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, th) == null) || tryOnError(th)) {
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, t) == null) || this.emitter.isCancelled() || this.done) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            if (get() == 0 && compareAndSet(0, 1)) {
                this.emitter.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimplePlainQueue<T> simplePlainQueue = this.queue;
                synchronized (simplePlainQueue) {
                    simplePlainQueue.offer(t);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.FlowableEmitter
        public long requested() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.emitter.requested() : invokeV.longValue;
        }

        @Override // io.reactivex.FlowableEmitter
        public FlowableEmitter<T> serialize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : (FlowableEmitter) invokeV.objValue;
        }

        @Override // io.reactivex.FlowableEmitter
        public void setCancellable(Cancellable cancellable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cancellable) == null) {
                this.emitter.setCancellable(cancellable);
            }
        }

        @Override // io.reactivex.FlowableEmitter
        public void setDisposable(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, disposable) == null) {
                this.emitter.setDisposable(disposable);
            }
        }

        @Override // io.reactivex.FlowableEmitter
        public boolean tryOnError(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, th)) == null) {
                if (!this.emitter.isCancelled() && !this.done) {
                    if (th == null) {
                        th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                    }
                    if (this.error.addThrowable(th)) {
                        this.done = true;
                        drain();
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public FlowableCreate(FlowableOnSubscribe<T> flowableOnSubscribe, BackpressureStrategy backpressureStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowableOnSubscribe, backpressureStrategy};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = flowableOnSubscribe;
        this.backpressure = backpressureStrategy;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        BaseEmitter missingEmitter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            int i2 = AnonymousClass1.$SwitchMap$io$reactivex$BackpressureStrategy[this.backpressure.ordinal()];
            if (i2 == 1) {
                missingEmitter = new MissingEmitter(subscriber);
            } else if (i2 == 2) {
                missingEmitter = new ErrorAsyncEmitter(subscriber);
            } else if (i2 == 3) {
                missingEmitter = new DropAsyncEmitter(subscriber);
            } else if (i2 != 4) {
                missingEmitter = new BufferAsyncEmitter(subscriber, Flowable.bufferSize());
            } else {
                missingEmitter = new LatestAsyncEmitter(subscriber);
            }
            subscriber.onSubscribe(missingEmitter);
            try {
                this.source.subscribe(missingEmitter);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                missingEmitter.onError(th);
            }
        }
    }
}
