package org.apache.commons.lang3.tuple;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class ImmutablePair<L, R> extends Pair<L, R> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 4954918890077093841L;
    public transient /* synthetic */ FieldHolder $fh;
    public final L left;
    public final R right;

    public ImmutablePair(L l, R r) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l, r};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.left = l;
        this.right = r;
    }

    public static <L, R> ImmutablePair<L, R> of(L l, R r) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, l, r)) == null) ? new ImmutablePair<>(l, r) : (ImmutablePair) invokeLL.objValue;
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    public L getLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.left : (L) invokeV.objValue;
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    public R getRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.right : (R) invokeV.objValue;
    }

    @Override // java.util.Map.Entry
    public R setValue(R r) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, r)) == null) {
            throw new UnsupportedOperationException();
        }
        return (R) invokeL.objValue;
    }
}
