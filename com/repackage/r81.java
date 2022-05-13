package com.repackage;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class r81 {
    public static /* synthetic */ Interceptable $ic;
    public static r81 b;
    public transient /* synthetic */ FieldHolder $fh;
    public s81 a;

    public r81(s81 s81Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s81Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = s81Var;
    }

    public static r81 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? b : (r81) invokeV.objValue;
    }

    public static void c(s81 s81Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, s81Var) == null) && b == null) {
            synchronized (r81.class) {
                if (b == null) {
                    b = new r81(s81Var);
                }
            }
        }
    }

    public void a(ImageView imageView, String str) {
        s81 s81Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) || (s81Var = this.a) == null) {
            return;
        }
        s81Var.a(imageView, str);
    }
}
