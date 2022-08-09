package com.repackage;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class u81 {
    public static /* synthetic */ Interceptable $ic;
    public static u81 b;
    public transient /* synthetic */ FieldHolder $fh;
    public v81 a;

    public u81(v81 v81Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v81Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = v81Var;
    }

    public static u81 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? b : (u81) invokeV.objValue;
    }

    public static void c(v81 v81Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, v81Var) == null) && b == null) {
            synchronized (u81.class) {
                if (b == null) {
                    b = new u81(v81Var);
                }
            }
        }
    }

    public void a(ImageView imageView, String str) {
        v81 v81Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) || (v81Var = this.a) == null) {
            return;
        }
        v81Var.a(imageView, str);
    }
}
