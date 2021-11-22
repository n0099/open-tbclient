package io.reactivex.internal.subscribers;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import org.reactivestreams.Subscriber;
/* loaded from: classes2.dex */
public abstract class QueueDrainSubscriber<T, U, V> extends QueueDrainSubscriberPad4 implements FlowableSubscriber<T>, QueueDrain<U, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Subscriber<? super V> actual;
    public volatile boolean cancelled;
    public volatile boolean done;
    public Throwable error;
    public final SimplePlainQueue<U> queue;

    public QueueDrainSubscriber(Subscriber<? super V> subscriber, SimplePlainQueue<U> simplePlainQueue) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {subscriber, simplePlainQueue};
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
        this.queue = simplePlainQueue;
    }

    public boolean accept(Subscriber<? super V> subscriber, U u) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, subscriber, u)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final boolean cancelled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cancelled : invokeV.booleanValue;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final boolean done() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.done : invokeV.booleanValue;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final boolean enter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.wip.getAndIncrement() == 0 : invokeV.booleanValue;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final Throwable error() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.error : (Throwable) invokeV.objValue;
    }

    public final boolean fastEnter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.wip.get() == 0 && this.wip.compareAndSet(0, 1) : invokeV.booleanValue;
    }

    public final void fastPathEmitMax(U u, boolean z, Disposable disposable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{u, Boolean.valueOf(z), disposable}) == null) {
            Subscriber<? super V> subscriber = this.actual;
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            if (fastEnter()) {
                long j = this.requested.get();
                if (j != 0) {
                    if (accept(subscriber, u) && j != Long.MAX_VALUE) {
                        produced(1L);
                    }
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    disposable.dispose();
                    subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                    return;
                }
            } else {
                simplePlainQueue.offer(u);
                if (!enter()) {
                    return;
                }
            }
            QueueDrainHelper.drainMaxLoop(simplePlainQueue, subscriber, z, disposable, this);
        }
    }

    public final void fastPathOrderedEmitMax(U u, boolean z, Disposable disposable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{u, Boolean.valueOf(z), disposable}) == null) {
            Subscriber<? super V> subscriber = this.actual;
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            if (fastEnter()) {
                long j = this.requested.get();
                if (j != 0) {
                    if (simplePlainQueue.isEmpty()) {
                        if (accept(subscriber, u) && j != Long.MAX_VALUE) {
                            produced(1L);
                        }
                        if (leave(-1) == 0) {
                            return;
                        }
                    } else {
                        simplePlainQueue.offer(u);
                    }
                } else {
                    this.cancelled = true;
                    disposable.dispose();
                    subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                    return;
                }
            } else {
                simplePlainQueue.offer(u);
                if (!enter()) {
                    return;
                }
            }
            QueueDrainHelper.drainMaxLoop(simplePlainQueue, subscriber, z, disposable, this);
        }
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final int leave(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? this.wip.addAndGet(i2) : invokeI.intValue;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final long produced(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) ? this.requested.addAndGet(-j) : invokeJ.longValue;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final long requested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.requested.get() : invokeV.longValue;
    }

    public final void requested(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048587, this, j) == null) && SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.requested, j);
        }
    }
}
