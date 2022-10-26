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
public abstract class QueueDrainObserver extends QueueDrainSubscriberPad2 implements Observer, ObservableQueueDrain {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Observer actual;
    public volatile boolean cancelled;
    public volatile boolean done;
    public Throwable error;
    public final SimplePlainQueue queue;

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public void accept(Observer observer, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, observer, obj) == null) {
        }
    }

    public QueueDrainObserver(Observer observer, SimplePlainQueue simplePlainQueue) {
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
    public final boolean cancelled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.cancelled;
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean done() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.done;
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean enter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.wip.getAndIncrement() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final Throwable error() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.error;
        }
        return (Throwable) invokeV.objValue;
    }

    public final boolean fastEnter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.wip.get() == 0 && this.wip.compareAndSet(0, 1)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void fastPathEmit(Object obj, boolean z, Disposable disposable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{obj, Boolean.valueOf(z), disposable}) == null) {
            Observer observer = this.actual;
            SimplePlainQueue simplePlainQueue = this.queue;
            if (this.wip.get() == 0 && this.wip.compareAndSet(0, 1)) {
                accept(observer, obj);
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                simplePlainQueue.offer(obj);
                if (!enter()) {
                    return;
                }
            }
            QueueDrainHelper.drainLoop(simplePlainQueue, observer, z, disposable, this);
        }
    }

    public final void fastPathOrderedEmit(Object obj, boolean z, Disposable disposable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{obj, Boolean.valueOf(z), disposable}) == null) {
            Observer observer = this.actual;
            SimplePlainQueue simplePlainQueue = this.queue;
            if (this.wip.get() == 0 && this.wip.compareAndSet(0, 1)) {
                if (simplePlainQueue.isEmpty()) {
                    accept(observer, obj);
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    simplePlainQueue.offer(obj);
                }
            } else {
                simplePlainQueue.offer(obj);
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
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return this.wip.addAndGet(i);
        }
        return invokeI.intValue;
    }
}
