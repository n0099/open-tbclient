package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.container.BaseNativeBrowserContainer;
import com.baidu.nadcore.webview.container.base.AbsContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.x11;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class z11 implements x11.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public z11() {
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

    @Override // com.repackage.x11.a
    public AbsContainer a(d21 d21Var, e21 e21Var, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, d21Var, e21Var, i)) == null) ? new BaseNativeBrowserContainer(d21Var, e21Var) : (AbsContainer) invokeLLI.objValue;
    }

    @Override // com.repackage.x11.a
    public boolean b(HashMap<String, String> hashMap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap, i)) == null) {
            return true;
        }
        return invokeLI.booleanValue;
    }

    @Override // com.repackage.x11.a
    public void c(Context context, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
        }
    }
}
