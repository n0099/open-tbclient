package com.repackage;

import android.webkit.JsPromptResult;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d46 implements y36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d46() {
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

    @Override // com.repackage.y36
    public void a(String str, String str2, String str3, String str4, JsPromptResult jsPromptResult) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(1048576, this, str, str2, str3, str4, jsPromptResult) == null) && b().equals(str)) {
            try {
                x36.f().h(str2);
            } catch (Throwable unused) {
                x36.f().e();
            }
        }
    }

    @Override // com.repackage.y36
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "showH5Dialog" : (String) invokeV.objValue;
    }
}
