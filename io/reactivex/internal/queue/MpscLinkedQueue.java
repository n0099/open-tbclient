package io.reactivex.internal.queue;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class MpscLinkedQueue implements SimplePlainQueue {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference consumerNode;
    public final AtomicReference producerNode;

    /* loaded from: classes8.dex */
    public final class LinkedQueueNode extends AtomicReference {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2404266111789071508L;
        public transient /* synthetic */ FieldHolder $fh;
        public Object value;

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

        public Object getAndNullValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Object lpValue = lpValue();
                spValue(null);
                return lpValue;
            }
            return invokeV.objValue;
        }

        public Object lpValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.value;
            }
            return invokeV.objValue;
        }

        public LinkedQueueNode lvNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return (LinkedQueueNode) get();
            }
            return (LinkedQueueNode) invokeV.objValue;
        }

        public LinkedQueueNode(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            spValue(obj);
        }

        public void soNext(LinkedQueueNode linkedQueueNode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, linkedQueueNode) == null) {
                lazySet(linkedQueueNode);
            }
        }

        public void spValue(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
                this.value = obj;
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
        this.producerNode = new AtomicReference();
        this.consumerNode = new AtomicReference();
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode();
        spConsumerNode(linkedQueueNode);
        xchgProducerNode(linkedQueueNode);
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    public Object poll() {
        InterceptResult invokeV;
        LinkedQueueNode lvNext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            LinkedQueueNode lpConsumerNode = lpConsumerNode();
            LinkedQueueNode lvNext2 = lpConsumerNode.lvNext();
            if (lvNext2 != null) {
                Object andNullValue = lvNext2.getAndNullValue();
                spConsumerNode(lvNext2);
                return andNullValue;
            } else if (lpConsumerNode != lvProducerNode()) {
                do {
                    lvNext = lpConsumerNode.lvNext();
                } while (lvNext == null);
                Object andNullValue2 = lvNext.getAndNullValue();
                spConsumerNode(lvNext);
                return andNullValue2;
            } else {
                return null;
            }
        }
        return invokeV.objValue;
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

    public LinkedQueueNode lpConsumerNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (LinkedQueueNode) this.consumerNode.get();
        }
        return (LinkedQueueNode) invokeV.objValue;
    }

    public LinkedQueueNode lvConsumerNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (LinkedQueueNode) this.consumerNode.get();
        }
        return (LinkedQueueNode) invokeV.objValue;
    }

    public LinkedQueueNode lvProducerNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (LinkedQueueNode) this.producerNode.get();
        }
        return (LinkedQueueNode) invokeV.objValue;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj != null) {
                LinkedQueueNode linkedQueueNode = new LinkedQueueNode(obj);
                xchgProducerNode(linkedQueueNode).soNext(linkedQueueNode);
                return true;
            }
            throw new NullPointerException("Null is not a valid element");
        }
        return invokeL.booleanValue;
    }

    public void spConsumerNode(LinkedQueueNode linkedQueueNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, linkedQueueNode) == null) {
            this.consumerNode.lazySet(linkedQueueNode);
        }
    }

    public LinkedQueueNode xchgProducerNode(LinkedQueueNode linkedQueueNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, linkedQueueNode)) == null) {
            return (LinkedQueueNode) this.producerNode.getAndSet(linkedQueueNode);
        }
        return (LinkedQueueNode) invokeL.objValue;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, obj, obj2)) == null) {
            offer(obj);
            offer(obj2);
            return true;
        }
        return invokeLL.booleanValue;
    }
}
