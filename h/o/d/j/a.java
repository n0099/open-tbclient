package h.o.d.j;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes10.dex */
public abstract class a<E> extends b<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d() == b() : invokeV.booleanValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (Iterator) invokeV.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        InterceptResult invokeV;
        LinkedQueueNode<E> lvNext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LinkedQueueNode<E> d2 = d();
            LinkedQueueNode<E> b2 = b();
            int i2 = 0;
            while (d2 != b2 && i2 < Integer.MAX_VALUE) {
                do {
                    lvNext = d2.lvNext();
                } while (lvNext == null);
                i2++;
                d2 = lvNext;
            }
            return i2;
        }
        return invokeV.intValue;
    }
}
