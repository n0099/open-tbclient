package io.reactivex.internal.observers;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.ObservableQueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
/* loaded from: classes8.dex */
public abstract class QueueDrainObserver<T, U, V> extends QueueDrainSubscriberPad2 implements Observer<T>, ObservableQueueDrain<U, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Observer<? super V> actual;
    public volatile boolean cancelled;
    public volatile boolean done;
    public Throwable error;
    public final SimplePlainQueue<U> queue;

    public QueueDrainObserver(Observer<? super V> observer, SimplePlainQueue<U> simplePlainQueue) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observer, simplePlainQueue};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.actual = observer;
        this.queue = simplePlainQueue;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public void accept(Observer<? super V> observer, U u) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, observer, u) == null) {
        }
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean cancelled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cancelled : invokeV.booleanValue;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean done() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.done : invokeV.booleanValue;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean enter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.wip.getAndIncrement() == 0 : invokeV.booleanValue;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
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

    public final void fastPathEmit(U u, boolean z, Disposable disposable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{u, Boolean.valueOf(z), disposable}) == null) {
            Observer<? super V> observer = this.actual;
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            if (this.wip.get() == 0 && this.wip.compareAndSet(0, 1)) {
                accept(observer, u);
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                simplePlainQueue.offer(u);
                if (!enter()) {
                    return;
                }
            }
            QueueDrainHelper.drainLoop(simplePlainQueue, observer, z, disposable, this);
        }
    }

    public final void fastPathOrderedEmit(U u, boolean z, Disposable disposable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{u, Boolean.valueOf(z), disposable}) == null) {
            Observer<? super V> observer = this.actual;
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            if (this.wip.get() == 0 && this.wip.compareAndSet(0, 1)) {
                if (simplePlainQueue.isEmpty()) {
                    accept(observer, u);
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    simplePlainQueue.offer(u);
                }
            } else {
                simplePlainQueue.offer(u);
                if (!enter()) {
                    return;
                }
            }
            QueueDrainHelper.drainLoop(simplePlainQueue, observer, z, disposable, this);
        }
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final int leave(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? this.wip.addAndGet(i) : invokeI.intValue;
    }
}
