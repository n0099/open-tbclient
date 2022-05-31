package com.repackage;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e71 {
    public static /* synthetic */ Interceptable $ic;
    public static e71 b;
    public transient /* synthetic */ FieldHolder $fh;
    public f71 a;

    public e71(f71 f71Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f71Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = f71Var;
    }

    public static e71 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? b : (e71) invokeV.objValue;
    }

    public static void c(f71 f71Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, f71Var) == null) && b == null) {
            synchronized (e71.class) {
                if (b == null) {
                    b = new e71(f71Var);
                }
            }
        }
    }

    public void a(ImageView imageView, String str) {
        f71 f71Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) || (f71Var = this.a) == null) {
            return;
        }
        f71Var.a(imageView, str);
    }
}
