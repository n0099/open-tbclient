package io.reactivex.internal.util;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes10.dex */
public final class QueueDrainHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long COMPLETED_MASK = Long.MIN_VALUE;
    public static final long REQUESTED_MASK = Long.MAX_VALUE;
    public transient /* synthetic */ FieldHolder $fh;

    public QueueDrainHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, boolean z3, SimpleQueue<?> simpleQueue, QueueDrain<T, U> queueDrain) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), subscriber, Boolean.valueOf(z3), simpleQueue, queueDrain})) == null) {
            if (queueDrain.cancelled()) {
                simpleQueue.clear();
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        Throwable error = queueDrain.error();
                        if (error != null) {
                            subscriber.onError(error);
                        } else {
                            subscriber.onComplete();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable error2 = queueDrain.error();
                if (error2 != null) {
                    simpleQueue.clear();
                    subscriber.onError(error2);
                    return true;
                } else if (z2) {
                    subscriber.onComplete();
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

    public static <T> SimpleQueue<T> createQueue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (i2 < 0) {
                return new SpscLinkedArrayQueue(-i2);
            }
            return new SpscArrayQueue(i2);
        }
        return (SimpleQueue) invokeI.objValue;
    }

    public static <T, U> void drainLoop(SimplePlainQueue<T> simplePlainQueue, Observer<? super U> observer, boolean z, Disposable disposable, ObservableQueueDrain<T, U> observableQueueDrain) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65540, null, new Object[]{simplePlainQueue, observer, Boolean.valueOf(z), disposable, observableQueueDrain}) == null) {
            int i2 = 1;
            while (!checkTerminated(observableQueueDrain.done(), simplePlainQueue.isEmpty(), observer, z, simplePlainQueue, disposable, observableQueueDrain)) {
                while (true) {
                    boolean done = observableQueueDrain.done();
                    T poll = simplePlainQueue.poll();
                    boolean z2 = poll == null;
                    if (checkTerminated(done, z2, observer, z, simplePlainQueue, disposable, observableQueueDrain)) {
                        return;
                    }
                    if (z2) {
                        i2 = observableQueueDrain.leave(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        observableQueueDrain.accept(observer, poll);
                    }
                }
            }
        }
    }

    public static <T, U> void drainMaxLoop(SimplePlainQueue<T> simplePlainQueue, Subscriber<? super U> subscriber, boolean z, Disposable disposable, QueueDrain<T, U> queueDrain) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{simplePlainQueue, subscriber, Boolean.valueOf(z), disposable, queueDrain}) != null) {
            return;
        }
        int i2 = 1;
        while (true) {
            boolean done = queueDrain.done();
            T poll = simplePlainQueue.poll();
            boolean z2 = poll == null;
            if (checkTerminated(done, z2, subscriber, z, simplePlainQueue, queueDrain)) {
                if (disposable != null) {
                    disposable.dispose();
                    return;
                }
                return;
            } else if (z2) {
                i2 = queueDrain.leave(-i2);
                if (i2 == 0) {
                    return;
                }
            } else {
                long requested = queueDrain.requested();
                if (requested != 0) {
                    if (queueDrain.accept(subscriber, poll) && requested != Long.MAX_VALUE) {
                        queueDrain.produced(1L);
                    }
                } else {
                    simplePlainQueue.clear();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    subscriber.onError(new MissingBackpressureException("Could not emit value due to lack of requests."));
                    return;
                }
            }
        }
    }

    public static boolean isCancelled(BooleanSupplier booleanSupplier) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, booleanSupplier)) == null) {
            try {
                return booleanSupplier.getAsBoolean();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static <T> void postComplete(Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, null, subscriber, queue, atomicLong, booleanSupplier) == null) {
            if (queue.isEmpty()) {
                subscriber.onComplete();
            } else if (postCompleteDrain(atomicLong.get(), subscriber, queue, atomicLong, booleanSupplier)) {
            } else {
                do {
                    j = atomicLong.get();
                    if ((j & Long.MIN_VALUE) != 0) {
                        return;
                    }
                    j2 = j | Long.MIN_VALUE;
                } while (!atomicLong.compareAndSet(j, j2));
                if (j != 0) {
                    postCompleteDrain(j2, subscriber, queue, atomicLong, booleanSupplier);
                }
            }
        }
    }

    public static <T> boolean postCompleteDrain(long j, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Long.valueOf(j), subscriber, queue, atomicLong, booleanSupplier})) != null) {
            return invokeCommon.booleanValue;
        }
        long j2 = j & Long.MIN_VALUE;
        while (true) {
            if (j2 != j) {
                if (isCancelled(booleanSupplier)) {
                    return true;
                }
                Object obj = (T) queue.poll();
                if (obj == null) {
                    subscriber.onComplete();
                    return true;
                }
                subscriber.onNext(obj);
                j2++;
            } else if (isCancelled(booleanSupplier)) {
                return true;
            } else {
                if (queue.isEmpty()) {
                    subscriber.onComplete();
                    return true;
                }
                j = atomicLong.get();
                if (j == j2) {
                    long addAndGet = atomicLong.addAndGet(-(j2 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & addAndGet) == 0) {
                        return false;
                    }
                    j = addAndGet;
                    j2 = addAndGet & Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }

    public static <T> boolean postCompleteRequest(long j, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Long.valueOf(j), subscriber, queue, atomicLong, booleanSupplier})) == null) {
            do {
                j2 = atomicLong.get();
            } while (!atomicLong.compareAndSet(j2, BackpressureHelper.addCap(Long.MAX_VALUE & j2, j) | (j2 & Long.MIN_VALUE)));
            if (j2 == Long.MIN_VALUE) {
                postCompleteDrain(j | Long.MIN_VALUE, subscriber, queue, atomicLong, booleanSupplier);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static void request(Subscription subscription, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, null, subscription, i2) == null) {
            subscription.request(i2 < 0 ? Long.MAX_VALUE : i2);
        }
    }

    public static <T, U> boolean checkTerminated(boolean z, boolean z2, Observer<?> observer, boolean z3, SimpleQueue<?> simpleQueue, Disposable disposable, ObservableQueueDrain<T, U> observableQueueDrain) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), observer, Boolean.valueOf(z3), simpleQueue, disposable, observableQueueDrain})) == null) {
            if (observableQueueDrain.cancelled()) {
                simpleQueue.clear();
                disposable.dispose();
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        if (disposable != null) {
                            disposable.dispose();
                        }
                        Throwable error = observableQueueDrain.error();
                        if (error != null) {
                            observer.onError(error);
                        } else {
                            observer.onComplete();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable error2 = observableQueueDrain.error();
                if (error2 != null) {
                    simpleQueue.clear();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    observer.onError(error2);
                    return true;
                } else if (z2) {
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    observer.onComplete();
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
}
