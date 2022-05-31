package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public abstract class t64<T> implements w64<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public t64() {
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

    @Override // com.repackage.w64
    public void a(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
        }
    }

    @Override // com.repackage.w64
    public void c(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
        }
    }

    @Override // com.repackage.w64
    public void e(T t, z74 z74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, t, z74Var) == null) {
        }
    }

    @Override // com.repackage.w64
    public void f(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 100;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.w64
    public z74 h(T t, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{t, file, Long.valueOf(j), readableByteChannel})) == null) ? new z74(2302, "业务层默认不处理下载流") : (z74) invokeCommon.objValue;
    }

    @Override // com.repackage.w64
    public void i(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
        }
    }

    @Override // com.repackage.w64
    public void j(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, t) == null) {
        }
    }

    @Override // com.repackage.w64
    public Map<String, Object> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("queue_priority", Integer.valueOf(g()));
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }
}
