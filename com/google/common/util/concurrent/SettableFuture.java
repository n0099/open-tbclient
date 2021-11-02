package com.google.common.util.concurrent;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.AbstractFuture;
/* loaded from: classes2.dex */
public final class SettableFuture<V> extends AbstractFuture.TrustedFuture<V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SettableFuture() {
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

    public static <V> SettableFuture<V> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new SettableFuture<>() : (SettableFuture) invokeV.objValue;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean set(V v) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, v)) == null) ? super.set(v) : invokeL.booleanValue;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean setException(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) ? super.setException(th) : invokeL.booleanValue;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, listenableFuture)) == null) ? super.setFuture(listenableFuture) : invokeL.booleanValue;
    }
}
