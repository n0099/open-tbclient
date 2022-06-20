package com.repackage;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class p71 {
    public static /* synthetic */ Interceptable $ic;
    public static p71 b;
    public transient /* synthetic */ FieldHolder $fh;
    public q71 a;

    public p71(q71 q71Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q71Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = q71Var;
    }

    public static p71 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? b : (p71) invokeV.objValue;
    }

    public static void c(q71 q71Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, q71Var) == null) && b == null) {
            synchronized (p71.class) {
                if (b == null) {
                    b = new p71(q71Var);
                }
            }
        }
    }

    public void a(ImageView imageView, String str) {
        q71 q71Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) || (q71Var = this.a) == null) {
            return;
        }
        q71Var.a(imageView, str);
    }
}
