package com.repackage;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class u02 extends r02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap d;

    public u02() {
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

    public static u02 a(String str, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, bitmap)) == null) {
            u02 u02Var = new u02();
            u02Var.a = 1;
            u02Var.b = str;
            u02Var.c = 0L;
            u02Var.d = bitmap;
            return u02Var;
        }
        return (u02) invokeLL.objValue;
    }

    public static u02 b(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, str, j)) == null) {
            u02 u02Var = new u02();
            u02Var.a = 1;
            u02Var.b = str;
            u02Var.c = j;
            return u02Var;
        }
        return (u02) invokeLJ.objValue;
    }
}
