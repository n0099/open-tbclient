package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
@Service
/* loaded from: classes7.dex */
public class vh4 implements pl1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public vh4() {
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

    @Override // com.repackage.pl1
    public fh2 a(ZeusPluginFactory.Invoker invoker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, invoker, str)) == null) ? new xh4() : (fh2) invokeLL.objValue;
    }

    @Override // com.repackage.pl1
    public fj2 b(ZeusPluginFactory.Invoker invoker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, invoker, str)) == null) ? new ai4(invoker, str) : (fj2) invokeLL.objValue;
    }

    @Override // com.repackage.pl1
    public fj2 c(ZeusPluginFactory.Invoker invoker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, invoker, str)) == null) ? new zh4(invoker, str) : (fj2) invokeLL.objValue;
    }

    @Override // com.repackage.pl1
    public eh2 d(ZeusPluginFactory.Invoker invoker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, invoker, str)) == null) ? new wh4() : (eh2) invokeLL.objValue;
    }

    @Override // com.repackage.pl1
    public cf2 e(ZeusPluginFactory.Invoker invoker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, invoker, str)) == null) ? new ki4(invoker, str) : (cf2) invokeLL.objValue;
    }
}
