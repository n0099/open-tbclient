package io.reactivex.internal.queue;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class MpscLinkedQueue<T> implements SimplePlainQueue<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference<LinkedQueueNode<T>> consumerNode;
    public final AtomicReference<LinkedQueueNode<T>> producerNode;

    /* loaded from: classes8.dex */
    public static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2404266111789071508L;
        public transient /* synthetic */ FieldHolder $fh;
        public E value;

        public LinkedQueueNode() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public E getAndNullValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                E lpValue = lpValue();
                spValue(null);
                return lpValue;
            }
            return (E) invokeV.objValue;
        }

        public E lpValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.value;
            }
            return (E) invokeV.objValue;
        }

        public LinkedQueueNode<E> lvNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return get();
            }
            return (LinkedQueueNode) invokeV.objValue;
        }

        public LinkedQueueNode(E e) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            spValue(e);
        }

        public void soNext(LinkedQueueNode<E> linkedQueueNode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, linkedQueueNode) == null) {
                lazySet(linkedQueueNode);
            }
        }

        public void spValue(E e) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, e) == null) {
                this.value = e;
            }
        }
    }

    public MpscLinkedQueue() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.producerNode = new AtomicReference<>();
        this.consumerNode = new AtomicReference<>();
        LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>();
        spConsumerNode(linkedQueueNode);
        xchgProducerNode(linkedQueueNode);
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public T poll() {
        InterceptResult invokeV;
        LinkedQueueNode<T> lvNext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            LinkedQueueNode<T> lpConsumerNode = lpConsumerNode();
            LinkedQueueNode<T> lvNext2 = lpConsumerNode.lvNext();
            if (lvNext2 != null) {
                T andNullValue = lvNext2.getAndNullValue();
                spConsumerNode(lvNext2);
                return andNullValue;
            } else if (lpConsumerNode != lvProducerNode()) {
                do {
                    lvNext = lpConsumerNode.lvNext();
                } while (lvNext == null);
                T andNullValue2 = lvNext.getAndNullValue();
                spConsumerNode(lvNext);
                return andNullValue2;
            } else {
                return null;
            }
        }
        return (T) invokeV.objValue;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            while (poll() != null && !isEmpty()) {
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (lvConsumerNode() == lvProducerNode()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public LinkedQueueNode<T> lpConsumerNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.consumerNode.get();
        }
        return (LinkedQueueNode) invokeV.objValue;
    }

    public LinkedQueueNode<T> lvConsumerNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.consumerNode.get();
        }
        return (LinkedQueueNode) invokeV.objValue;
    }

    public LinkedQueueNode<T> lvProducerNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.producerNode.get();
        }
        return (LinkedQueueNode) invokeV.objValue;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, t)) == null) {
            if (t != null) {
                LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>(t);
                xchgProducerNode(linkedQueueNode).soNext(linkedQueueNode);
                return true;
            }
            throw new NullPointerException("Null is not a valid element");
        }
        return invokeL.booleanValue;
    }

    public void spConsumerNode(LinkedQueueNode<T> linkedQueueNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, linkedQueueNode) == null) {
            this.consumerNode.lazySet(linkedQueueNode);
        }
    }

    public LinkedQueueNode<T> xchgProducerNode(LinkedQueueNode<T> linkedQueueNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, linkedQueueNode)) == null) {
            return this.producerNode.getAndSet(linkedQueueNode);
        }
        return (LinkedQueueNode) invokeL.objValue;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t, T t2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, t, t2)) == null) {
            offer(t);
            offer(t2);
            return true;
        }
        return invokeLL.booleanValue;
    }
}
