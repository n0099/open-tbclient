package org.apache.commons.lang3.tuple;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class MutablePair<L, R> extends Pair<L, R> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 4954918890077093841L;
    public transient /* synthetic */ FieldHolder $fh;
    public L left;
    public R right;

    public MutablePair() {
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

    public static <L, R> MutablePair<L, R> of(L l, R r) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, l, r)) == null) ? new MutablePair<>(l, r) : (MutablePair) invokeLL.objValue;
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

    public void setLeft(L l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l) == null) {
            this.left = l;
        }
    }

    public void setRight(R r) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, r) == null) {
            this.right = r;
        }
    }

    @Override // java.util.Map.Entry
    public R setValue(R r) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, r)) == null) {
            R right = getRight();
            setRight(r);
            return right;
        }
        return (R) invokeL.objValue;
    }

    public MutablePair(L l, R r) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l, r};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.left = l;
        this.right = r;
    }
}
