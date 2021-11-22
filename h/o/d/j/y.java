package h.o.d.j;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes2.dex */
public final class y<E> extends a<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public y() {
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
        c(new LinkedQueueNode<>());
        e(this.producerNode);
        this.consumerNode.soNext(null);
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e2)) == null) {
            if (e2 != null) {
                LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e2);
                this.producerNode.soNext(linkedQueueNode);
                this.producerNode = linkedQueueNode;
                return true;
            }
            throw new NullPointerException("null elements not allowed");
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Queue
    public E peek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LinkedQueueNode<E> lvNext = this.consumerNode.lvNext();
            if (lvNext != null) {
                return lvNext.lpValue();
            }
            return null;
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.Queue
    public E poll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LinkedQueueNode<E> lvNext = this.consumerNode.lvNext();
            if (lvNext != null) {
                E andNullValue = lvNext.getAndNullValue();
                this.consumerNode = lvNext;
                return andNullValue;
            }
            return null;
        }
        return (E) invokeV.objValue;
    }
}
