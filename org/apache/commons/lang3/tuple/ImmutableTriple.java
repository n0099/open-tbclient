package org.apache.commons.lang3.tuple;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class ImmutableTriple<L, M, R> extends Triple<L, M, R> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final L left;
    public final M middle;
    public final R right;

    public ImmutableTriple(L l, M m, R r) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l, m, r};
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
        this.middle = m;
        this.right = r;
    }

    public static <L, M, R> ImmutableTriple<L, M, R> of(L l, M m, R r) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, l, m, r)) == null) ? new ImmutableTriple<>(l, m, r) : (ImmutableTriple) invokeLLL.objValue;
    }

    @Override // org.apache.commons.lang3.tuple.Triple
    public L getLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.left : (L) invokeV.objValue;
    }

    @Override // org.apache.commons.lang3.tuple.Triple
    public M getMiddle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.middle : (M) invokeV.objValue;
    }

    @Override // org.apache.commons.lang3.tuple.Triple
    public R getRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.right : (R) invokeV.objValue;
    }
}
