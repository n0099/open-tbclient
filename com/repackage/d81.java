package com.repackage;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d81 {
    public static /* synthetic */ Interceptable $ic;
    public static d81 b;
    public transient /* synthetic */ FieldHolder $fh;
    public e81 a;

    public d81(e81 e81Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e81Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = e81Var;
    }

    public static d81 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? b : (d81) invokeV.objValue;
    }

    public static void c(e81 e81Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, e81Var) == null) && b == null) {
            synchronized (d81.class) {
                if (b == null) {
                    b = new d81(e81Var);
                }
            }
        }
    }

    public void a(ImageView imageView, String str) {
        e81 e81Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) || (e81Var = this.a) == null) {
            return;
        }
        e81Var.a(imageView, str);
    }
}
