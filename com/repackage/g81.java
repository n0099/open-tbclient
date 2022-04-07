package com.repackage;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g81 {
    public static /* synthetic */ Interceptable $ic;
    public static g81 b;
    public transient /* synthetic */ FieldHolder $fh;
    public h81 a;

    public g81(h81 h81Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h81Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = h81Var;
    }

    public static g81 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? b : (g81) invokeV.objValue;
    }

    public static void c(h81 h81Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, h81Var) == null) && b == null) {
            synchronized (g81.class) {
                if (b == null) {
                    b = new g81(h81Var);
                }
            }
        }
    }

    public void a(ImageView imageView, String str) {
        h81 h81Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) || (h81Var = this.a) == null) {
            return;
        }
        h81Var.a(imageView, str);
    }
}
