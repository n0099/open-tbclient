package com.qq.e.comm.constants;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class Sig {
    public static /* synthetic */ Interceptable $ic = null;
    public static String ASSET_PLUGIN_SIG = "sZlDgD0wiCzRqt3EwhcchDsXlbX67LTsofzHmdh8x0IbksK2SgNyVyZBOv//7pUlkADns1qiW7KwH1PC7ASzqEDtWvIPY7MOxUVmG8NyrTiC7BMFkN+pNPrY8yWdb/QZhiZdAdOo6NdQta9Wh0xCTc9LMXpdFWr3yri1oQWXcyg=";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1477611406, "Lcom/qq/e/comm/constants/Sig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1477611406, "Lcom/qq/e/comm/constants/Sig;");
        }
    }

    public Sig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
